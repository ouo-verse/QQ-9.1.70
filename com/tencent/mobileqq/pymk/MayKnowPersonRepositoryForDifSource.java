package com.tencent.mobileqq.pymk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.data.PYMKTotalData;
import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.oidb_0xc26$MayKnowPerson;
import tencent.im.oidb.oidb_0xc26$QzoneInfo;
import tencent.im.troop.findtroop.TabRecommendPB$GetRecommendExtraInfoReq;
import tencent.im.troop.findtroop.TabRecommendPB$GetRecommendExtraInfoRsp;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendReq;
import tencent.im.troop.findtroop.TabRecommendPB$GetTabRecommendRsp;
import tencent.im.troop.findtroop.TabRecommendPB$PersionParam;
import tencent.im.troop.findtroop.TabRecommendPB$PersonExtraInfo;
import tencent.im.troop.findtroop.TabRecommendPB$Session;
import tencent.im.troop.findtroop.TabRecommendPB$TabRecommendResult;

@Metadata(d1 = {"\u0000\u00f1\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0003]\u009e\u0001\b\u00c6\u0002\u0018\u00002\u00020\u0001B\n\b\u0002\u00a2\u0006\u0005\b\u00a5\u0001\u0010oJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007JB\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u00020\t`\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J(\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0017j\b\u0012\u0004\u0012\u00020\u0005`\u0018H\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001aH\u0002J.\u0010%\u001a\u00020$2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u00020\t`\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J$\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J6\u0010-\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010*2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u00102\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010*2\u0010\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u00104\u001a\u00020\r2\u0010\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u00105\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JD\u0010;\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00042$\u0010:\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020908\u0012\u0004\u0012\u00020\r07H\u0007J\u0010\u0010=\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001aH\u0007J\u0012\u0010>\u001a\u0004\u0018\u00010.2\u0006\u0010'\u001a\u00020&H\u0002J\u000e\u0010@\u001a\u0004\u0018\u00010\u0005*\u00020?H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010'\u001a\u00020&H\u0002J\u0018\u0010D\u001a\u00020\r2\u0006\u0010C\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010E\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010F\u001a\u00020\rH\u0002J\b\u0010G\u001a\u00020\rH\u0002J\b\u0010H\u001a\u00020\rH\u0002J\n\u0010J\u001a\u0004\u0018\u00010IH\u0002J\u0010\u0010K\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010L\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010M\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010N\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001aH\u0002J\u001a\u0010O\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010PH\u0002J\u0012\u0010R\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010S\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010T\u001a\u00020\rH\u0002J\b\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020\rH\u0002J\"\u0010\\\u001a\u00020\r2\u0010\u0010Y\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030X0W2\u0006\u0010[\u001a\u00020ZH\u0002J\u000f\u0010^\u001a\u00020]H\u0002\u00a2\u0006\u0004\b^\u0010_J\u0006\u0010`\u001a\u00020\u001aJ\u0018\u0010a\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0018\u0010c\u001a\u00020\r2\u0006\u0010b\u001a\u00020\u001a2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010d\u001a\u00020\u001a2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010e\u001a\u00020\rRj\u0010p\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010g0fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010g`h2&\u0010i\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010g0fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010g`h8\u0006@BX\u0087\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010k\u0012\u0004\bn\u0010o\u001a\u0004\bl\u0010mR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR&\u0010x\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120u0t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR \u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020y0t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010wR2\u0010}\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010kR\u0016\u0010\u007f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010UR4\u0010\u0081\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010kR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R3\u0010b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010kR4\u0010\u008a\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010kR4\u0010\u008c\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010kR\u001c\u0010[\u001a\u00030\u008d\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R3\u0010\u0095\u0001\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209080t8\u0006\u00a2\u0006\u000f\n\u0005\b\u0092\u0001\u0010w\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\u000f\n\u0005\b\u0096\u0001\u0010r\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u00a1\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R!\u0010\u00a4\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\u000f\n\u0005\b\u00a2\u0001\u0010r\u001a\u0006\b\u00a3\u0001\u0010\u0098\u0001\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource;", "", "", "dataSource", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "O", "Lcom/tencent/mobileqq/data/PYMKBizEntryInfo;", "M", "", "type", "", "needRefresh", "", "x0", "w0", "Lcom/tencent/mobileqq/pymk/api/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/pymk/api/a;", "listener", BdhLogUtil.LogTag.Tag_Conn, "o0", "isForce", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filterUins", "", "eTag", "J", "itemSize", HippyControllerProps.ARRAY, "l0", UserInfo.SEX_FEMALE, "icon", "tips", "A0", "Ltencent/im/troop/findtroop/TabRecommendPB$Session;", "U", "", "data", "lastETag", "Y", "Ltencent/im/troop/findtroop/TabRecommendPB$TabRecommendResult;", "personData", "bizDataList", "E0", "Ltencent/im/troop/findtroop/TabRecommendPB$GetTabRecommendRsp;", "retData", "F0", "recommendPerson", "G0", "isEnd", "i0", "s0", "uins", "Lkotlin/Function2;", "", "Ltencent/im/troop/findtroop/TabRecommendPB$PersonExtraInfo;", "block", "I", "uin", "q0", "k0", "Ltencent/im/oidb/oidb_0xc26$MayKnowPerson;", "C0", "Ltencent/im/troop/findtroop/TabRecommendPB$GetRecommendExtraInfoRsp;", "j0", "requestInterval", "H0", "c0", "m0", "z0", "D0", "Lcom/tencent/common/app/AppInterface;", "L", "d0", "h0", "e0", "f0", "g0", "Lcom/tencent/mobileqq/persistence/EntityManager;", "N", "t0", "r0", "b0", "Z", "a0", "", "Lcom/tencent/mobileqq/persistence/transaction/BaseTransaction;", "list", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "E", "com/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$a", "H", "()Lcom/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$a;", "V", "y0", "traceId", "u0", "W", "n0", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/data/QZoneInfo;", "Lkotlin/collections/HashMap;", "<set-?>", "b", "Ljava/util/HashMap;", "T", "()Ljava/util/HashMap;", "getQZoneExpInfo$annotations", "()V", "qZoneExpInfo", "c", "Ljava/util/List;", "ALL_DATA_SOURCE", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "Lcom/tencent/mobileqq/data/PYMKTotalData;", "e", "recommendData", "f", "isFetching", "g", "isDBLoading", tl.h.F, "nextRequestTime", "i", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "j", "Lcom/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$a;", "friendObserver", "k", "l", "mETag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsEnd", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "o", ExifInterface.LATITUDE_SOUTH, "()Ljava/util/concurrent/ConcurrentHashMap;", "qZoneDetailInfoCache", "p", "getValidDataSource", "()Ljava/util/List;", "validDataSource", "Ljava/util/Comparator;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/Comparator;", "comparatorForCardDispalyTime", "com/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$receiver$1", "r", "Lcom/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$receiver$1;", "receiver", ReportConstant.COSTREPORT_PREFIX, "getTotoalDataSource", "totoalDataSource", "<init>", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MayKnowPersonRepositoryForDifSource {

    /* renamed from: a, reason: collision with root package name */
    public static final MayKnowPersonRepositoryForDifSource f261398a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile HashMap<Integer, QZoneInfo> qZoneExpInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> ALL_DATA_SOURCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, CopyOnWriteArrayList<com.tencent.mobileqq.pymk.api.a>> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, PYMKTotalData> recommendData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, Boolean> isFetching;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isDBLoading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, Long> nextRequestTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static EntityManager entityManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final a friendObserver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, String> traceId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, String> mETag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, Boolean> mIsEnd;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final MMKVOptionEntityV2 entity;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, Map<Long, TabRecommendPB$PersonExtraInfo>> qZoneDetailInfoCache;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> validDataSource;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final Comparator<MayKnowRecommend> comparatorForCardDispalyTime;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static final MayKnowPersonRepositoryForDifSource$receiver$1 receiver;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> totoalDataSource;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$a", "Lcom/tencent/mobileqq/friend/observer/a;", "", "isSucess", "", "reqUin", "", "onAddReqStatesChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.friend.observer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onAddReqStatesChanged(boolean isSucess, String reqUin) {
            Intrinsics.checkNotNullParameter(reqUin, "reqUin");
            if (isSucess) {
                MayKnowPersonRepositoryForDifSource.q0(reqUin);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/pymk/MayKnowPersonRepositoryForDifSource$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> f261441d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f261442e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> function2, int i3) {
            this.f261441d = function2;
            this.f261442e = i3;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            Map<Long, TabRecommendPB$PersonExtraInfo> emptyMap;
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            Map<Long, TabRecommendPB$PersonExtraInfo> emptyMap2;
            if (errorCode == 0 && data != null) {
                TabRecommendPB$GetRecommendExtraInfoRsp j06 = MayKnowPersonRepositoryForDifSource.f261398a.j0(data);
                if (j06 == null) {
                    QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchQZoneExtraInfo error. data is null");
                    Function2<Boolean, Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> function2 = this.f261441d;
                    Boolean bool = Boolean.FALSE;
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                    function2.invoke(bool, emptyMap2);
                    return;
                }
                List<TabRecommendPB$PersonExtraInfo> list = j06.person_extra_info.get();
                Intrinsics.checkNotNullExpressionValue(list, "retData.person_extra_info.get()");
                List<TabRecommendPB$PersonExtraInfo> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj : list2) {
                    linkedHashMap.put(Long.valueOf(((TabRecommendPB$PersonExtraInfo) obj).uin.get()), obj);
                }
                MayKnowPersonRepositoryForDifSource.f261398a.S().put(Integer.valueOf(this.f261442e), linkedHashMap);
                this.f261441d.invoke(Boolean.TRUE, linkedHashMap);
                return;
            }
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchQZoneExtraInfo error. errorCode:" + errorCode);
            Function2<Boolean, Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> function22 = this.f261441d;
            Boolean bool2 = Boolean.FALSE;
            emptyMap = MapsKt__MapsKt.emptyMap();
            function22.invoke(bool2, emptyMap);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((PYMKBizEntryInfo) t16).orderNum), Integer.valueOf(((PYMKBizEntryInfo) t17).orderNum));
            return compareValues;
        }
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$receiver$1] */
    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = new MayKnowPersonRepositoryForDifSource();
        f261398a = mayKnowPersonRepositoryForDifSource;
        qZoneExpInfo = new HashMap<>();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 4});
        ALL_DATA_SOURCE = listOf;
        listeners = new ConcurrentHashMap<>();
        recommendData = new ConcurrentHashMap<>();
        isFetching = new HashMap<>();
        nextRequestTime = new HashMap<>();
        friendObserver = mayKnowPersonRepositoryForDifSource.H();
        traceId = new HashMap<>();
        mETag = new HashMap<>();
        mIsEnd = new HashMap<>();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.getConte\u2026), QMMKVFile.FILE_COMMON)");
        entity = fromV2;
        qZoneDetailInfoCache = new ConcurrentHashMap<>();
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 4});
        validDataSource = listOf2;
        comparatorForCardDispalyTime = new Comparator() { // from class: com.tencent.mobileqq.pymk.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int G;
                G = MayKnowPersonRepositoryForDifSource.G((MayKnowRecommend) obj, (MayKnowRecommend) obj2);
                return G;
            }
        };
        receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                MayKnowPersonRepositoryForDifSource.f261398a.z0();
            }
        };
        mayKnowPersonRepositoryForDifSource.m0();
        mayKnowPersonRepositoryForDifSource.z0();
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 4});
        totoalDataSource = listOf3;
    }

    MayKnowPersonRepositoryForDifSource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(final int icon, final String tips) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            com.tencent.mobileqq.guild.util.qqui.g.f(icon, tips);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.e
                @Override // java.lang.Runnable
                public final void run() {
                    MayKnowPersonRepositoryForDifSource.B0(icon, tips);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(int i3, String tips) {
        Intrinsics.checkNotNullParameter(tips, "$tips");
        com.tencent.mobileqq.guild.util.qqui.g.f(i3, tips);
    }

    @JvmStatic
    public static final void C(com.tencent.mobileqq.pymk.api.a listener, int dataSource) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConcurrentHashMap<Integer, CopyOnWriteArrayList<com.tencent.mobileqq.pymk.api.a>> concurrentHashMap = listeners;
        CopyOnWriteArrayList<com.tencent.mobileqq.pymk.api.a> copyOnWriteArrayList = concurrentHashMap.get(Integer.valueOf(dataSource));
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.addIfAbsent(listener);
            return;
        }
        concurrentHashMap.put(Integer.valueOf(dataSource), new CopyOnWriteArrayList<>());
        CopyOnWriteArrayList<com.tencent.mobileqq.pymk.api.a> copyOnWriteArrayList2 = concurrentHashMap.get(Integer.valueOf(dataSource));
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.addIfAbsent(listener);
        }
    }

    private final MayKnowRecommend C0(oidb_0xc26$MayKnowPerson oidb_0xc26_mayknowperson) {
        return MayKnowRecommend.convertServerDataToLocal((int) (System.currentTimeMillis() / 1000), 23, "", "", oidb_0xc26_mayknowperson);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        Iterator<T> it = validDataSource.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
            mayKnowPersonRepositoryForDifSource.d0(intValue);
            PYMKTotalData pYMKTotalData = recommendData.get(Integer.valueOf(intValue));
            List<? extends MayKnowRecommend> list = pYMKTotalData != null ? pYMKTotalData.mayKnowRecommends : null;
            if (list == null) {
                list = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(list, "recommendData[it]?.mayKn\u2026Recommends ?: ArrayList()");
            }
            String str = mETag.get(Integer.valueOf(intValue));
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "this.mETag[it] ?: \"\"");
            Boolean bool = mIsEnd.get(Integer.valueOf(intValue));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            Intrinsics.checkNotNullExpressionValue(bool, "this.mIsEnd[it] ?: true");
            mayKnowPersonRepositoryForDifSource.e0(list, str, bool.booleanValue(), intValue);
            mayKnowPersonRepositoryForDifSource.h0(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(List<BaseTransaction<?>> list, Entity entity2) {
        list.add(new PersistOrReplaceTransaction(entity2));
    }

    private final boolean F() {
        if (NetworkUtil.isNetworkAvailable()) {
            return false;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f131430p);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.network_error_dialog_message)");
        A0(1, qqStr);
        return true;
    }

    private final void F0(final TabRecommendPB$GetTabRecommendRsp retData, final String lastETag, final int dataSource) {
        Integer num;
        Object obj;
        ArrayList arrayList;
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList;
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2;
        TabRecommendPB$PersionParam tabRecommendPB$PersionParam;
        PBStringField pBStringField;
        PBRepeatMessageField<oidb_0xc26$MayKnowPerson> pBRepeatMessageField;
        List<oidb_0xc26$MayKnowPerson> list;
        int collectionSizeOrDefault;
        List<TabRecommendPB$TabRecommendResult> list2 = retData.tab_recommend_result.get();
        Intrinsics.checkNotNullExpressionValue(list2, "retData.tab_recommend_result.get()");
        Iterator<T> it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((TabRecommendPB$TabRecommendResult) obj).type.get() == 2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        final TabRecommendPB$TabRecommendResult tabRecommendPB$TabRecommendResult = (TabRecommendPB$TabRecommendResult) obj;
        if (tabRecommendPB$TabRecommendResult == null || (pBRepeatMessageField = tabRecommendPB$TabRecommendResult.recommend_person) == null || (list = pBRepeatMessageField.get()) == null) {
            arrayList = null;
        } else {
            List<oidb_0xc26$MayKnowPerson> list3 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (oidb_0xc26$MayKnowPerson it5 : list3) {
                MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList2.add(mayKnowPersonRepositoryForDifSource.C0(it5));
            }
            arrayList = arrayList2;
        }
        QLog.i("MayKnowPersonRepositoryForDifSource", 1, "[handleRecommendDataFetch] recommendPerson size=" + (arrayList != null ? arrayList.size() : 0) + " dataSource " + dataSource);
        TabRecommendPB$Session tabRecommendPB$Session = retData.session_info;
        String str = (tabRecommendPB$Session == null || (tabRecommendPB$PersionParam = tabRecommendPB$Session.persion_param_info) == null || (pBStringField = tabRecommendPB$PersionParam.etag) == null) ? null : pBStringField.get();
        String str2 = str == null ? "" : str;
        boolean z16 = retData.is_end.get() == 1 || TextUtils.isEmpty(str2);
        QLog.i("MayKnowPersonRepositoryForDifSource", 1, "[handleRecommendDataFetch] bizEntry dataSource " + dataSource);
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!TextUtils.isEmpty(lastETag)) {
                f261398a.i0(arrayList, str2, z16, dataSource);
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "parseMayKnowDataAndNotify success. dataSource " + dataSource + " data size:" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
                return;
            }
            MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource2 = f261398a;
            mayKnowPersonRepositoryForDifSource2.s0(str2, z16, dataSource);
            mayKnowPersonRepositoryForDifSource2.G0(tabRecommendPB$TabRecommendResult, arrayList, dataSource);
            mayKnowPersonRepositoryForDifSource2.d0(dataSource);
            PYMKTotalData pYMKTotalData = (PYMKTotalData) recommendData.get(Integer.valueOf(dataSource));
            List list4 = pYMKTotalData != null ? pYMKTotalData.mayKnowRecommends : null;
            if (list4 == null) {
                list4 = new ArrayList();
            } else {
                Intrinsics.checkNotNullExpressionValue(list4, "recommendData[dataSource\u2026Recommends ?: ArrayList()");
            }
            String str3 = (String) mETag.get(Integer.valueOf(dataSource));
            String str4 = str3 != null ? str3 : "";
            Intrinsics.checkNotNullExpressionValue(str4, "mETag[dataSource] ?: \"\"");
            Boolean bool = (Boolean) mIsEnd.get(Integer.valueOf(dataSource));
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            Intrinsics.checkNotNullExpressionValue(bool, "mIsEnd[dataSource] ?: false");
            mayKnowPersonRepositoryForDifSource2.e0(list4, str4, bool.booleanValue(), dataSource);
            mayKnowPersonRepositoryForDifSource2.h0(dataSource);
            mayKnowPersonRepositoryForDifSource2.t0(dataSource);
            mayKnowPersonRepositoryForDifSource2.r0(dataSource);
            long j3 = retData.next_request_delay.get();
            mayKnowPersonRepositoryForDifSource2.H0(j3, dataSource);
            PYMKTotalData pYMKTotalData2 = (PYMKTotalData) recommendData.get(Integer.valueOf(dataSource));
            Integer valueOf = (pYMKTotalData2 == null || (copyOnWriteArrayList2 = pYMKTotalData2.mayKnowRecommends) == null) ? null : Integer.valueOf(copyOnWriteArrayList2.size());
            HashMap<Integer, QZoneInfo> T = T();
            PYMKTotalData pYMKTotalData3 = (PYMKTotalData) recommendData.get(Integer.valueOf(dataSource));
            if (pYMKTotalData3 != null && (copyOnWriteArrayList = pYMKTotalData3.pymkBizEntryInfos) != null) {
                num = Integer.valueOf(copyOnWriteArrayList.size());
            }
            QLog.d("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataFirstPage success. dataSource " + dataSource + " dataSize:" + valueOf + " qzone:" + T + " lastEtag:" + lastETag + " bizEntry: " + num + " requestDelay:" + j3);
            return;
        }
        final String str5 = str2;
        final boolean z17 = z16;
        final ArrayList arrayList3 = arrayList;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$updateMayKnowPerson$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList3;
                CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList4;
                if (!TextUtils.isEmpty(lastETag)) {
                    MayKnowPersonRepositoryForDifSource.f261398a.i0(arrayList3, str5, z17, dataSource);
                    int i3 = dataSource;
                    List list5 = arrayList3;
                    QLog.d("MayKnowPersonRepositoryForDifSource", 1, "parseMayKnowDataAndNotify success. dataSource " + i3 + " data size:" + (list5 != null ? Integer.valueOf(list5.size()) : null));
                    return;
                }
                MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource3 = MayKnowPersonRepositoryForDifSource.f261398a;
                mayKnowPersonRepositoryForDifSource3.s0(str5, z17, dataSource);
                mayKnowPersonRepositoryForDifSource3.G0(tabRecommendPB$TabRecommendResult, arrayList3, dataSource);
                mayKnowPersonRepositoryForDifSource3.d0(dataSource);
                PYMKTotalData pYMKTotalData4 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                List list6 = pYMKTotalData4 != null ? pYMKTotalData4.mayKnowRecommends : null;
                if (list6 == null) {
                    list6 = new ArrayList();
                } else {
                    Intrinsics.checkNotNullExpressionValue(list6, "recommendData[dataSource\u2026Recommends ?: ArrayList()");
                }
                String str6 = (String) MayKnowPersonRepositoryForDifSource.mETag.get(Integer.valueOf(dataSource));
                if (str6 == null) {
                    str6 = "";
                }
                Intrinsics.checkNotNullExpressionValue(str6, "mETag[dataSource] ?: \"\"");
                Boolean bool2 = (Boolean) MayKnowPersonRepositoryForDifSource.mIsEnd.get(Integer.valueOf(dataSource));
                if (bool2 == null) {
                    bool2 = Boolean.FALSE;
                }
                Intrinsics.checkNotNullExpressionValue(bool2, "mIsEnd[dataSource] ?: false");
                mayKnowPersonRepositoryForDifSource3.e0(list6, str6, bool2.booleanValue(), dataSource);
                mayKnowPersonRepositoryForDifSource3.h0(dataSource);
                mayKnowPersonRepositoryForDifSource3.t0(dataSource);
                mayKnowPersonRepositoryForDifSource3.r0(dataSource);
                long j16 = retData.next_request_delay.get();
                mayKnowPersonRepositoryForDifSource3.H0(j16, dataSource);
                int i16 = dataSource;
                PYMKTotalData pYMKTotalData5 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                Integer valueOf2 = (pYMKTotalData5 == null || (copyOnWriteArrayList4 = pYMKTotalData5.mayKnowRecommends) == null) ? null : Integer.valueOf(copyOnWriteArrayList4.size());
                HashMap<Integer, QZoneInfo> T2 = MayKnowPersonRepositoryForDifSource.T();
                String str7 = lastETag;
                PYMKTotalData pYMKTotalData6 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                if (pYMKTotalData6 != null && (copyOnWriteArrayList3 = pYMKTotalData6.pymkBizEntryInfos) != null) {
                    r3 = Integer.valueOf(copyOnWriteArrayList3.size());
                }
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataFirstPage success. dataSource " + i16 + " dataSize:" + valueOf2 + " qzone:" + T2 + " lastEtag:" + str7 + " bizEntry: " + r3 + " requestDelay:" + j16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G(MayKnowRecommend mayKnowRecommend, MayKnowRecommend mayKnowRecommend2) {
        long j3 = mayKnowRecommend.cardDisplayTimestamp;
        long j16 = mayKnowRecommend2.cardDisplayTimestamp;
        if (j3 < j16) {
            return -1;
        }
        return j3 == j16 ? 0 : 1;
    }

    private final a H() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(long requestInterval, int dataSource) {
        nextRequestTime.put(Integer.valueOf(dataSource), Long.valueOf((NetConnInfoCenter.getServerTimeMillis() / 1000) + requestInterval));
        f fVar = f.f261465a;
        Long l3 = nextRequestTime.get(Integer.valueOf(dataSource));
        if (l3 == null) {
            l3 = 0L;
        }
        fVar.o(l3.longValue(), dataSource);
    }

    @JvmStatic
    public static final void I(int dataSource, List<Long> uins, Function2<? super Boolean, ? super Map<Long, TabRecommendPB$PersonExtraInfo>, Unit> block) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(block, "block");
        QLog.i("MayKnowPersonRepositoryForDifSource", 1, "fetchQZoneExtraInfo. size: " + uins.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchQZoneExtraInfo error. app is null");
            return;
        }
        ConcurrentHashMap<Integer, Map<Long, TabRecommendPB$PersonExtraInfo>> concurrentHashMap = qZoneDetailInfoCache;
        if (concurrentHashMap.containsKey(Integer.valueOf(dataSource))) {
            Boolean bool = Boolean.TRUE;
            Map<Long, TabRecommendPB$PersonExtraInfo> map = concurrentHashMap.get(Integer.valueOf(dataSource));
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            block.invoke(bool, map);
        }
        TabRecommendPB$GetRecommendExtraInfoReq tabRecommendPB$GetRecommendExtraInfoReq = new TabRecommendPB$GetRecommendExtraInfoReq();
        tabRecommendPB$GetRecommendExtraInfoReq.uin_list.addAll(uins);
        tabRecommendPB$GetRecommendExtraInfoReq.source.set(1);
        ProtoUtils.a(peekAppRuntime, new b(block, dataSource), tabRecommendPB$GetRecommendExtraInfoReq.toByteArray(), "OidbSvcTrpcTcp.0x90c9", 37065, 0);
    }

    @JvmStatic
    public static final void J(boolean isForce, ArrayList<Long> filterUins, final String eTag, final int dataSource) {
        Intrinsics.checkNotNullParameter(filterUins, "filterUins");
        MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
        if (mayKnowPersonRepositoryForDifSource.F()) {
            return;
        }
        Boolean bool = isFetching.get(Integer.valueOf(dataSource));
        if (bool == null ? false : bool.booleanValue()) {
            return;
        }
        if (!isForce && !mayKnowPersonRepositoryForDifSource.c0(dataSource) && TextUtils.isEmpty(eTag)) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 4, "fetchRecommendDataRemote filter " + nextRequestTime + " dataSource " + dataSource);
            return;
        }
        isFetching.put(Integer.valueOf(dataSource), Boolean.TRUE);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataRemote error. app is null. dataSource " + dataSource);
            return;
        }
        QLog.i("MayKnowPersonRepositoryForDifSource", 4, mayKnowPersonRepositoryForDifSource.V() + " fetchRecommendDataRemote eTag " + eTag + " dataSource " + dataSource);
        TabRecommendPB$GetTabRecommendReq tabRecommendPB$GetTabRecommendReq = new TabRecommendPB$GetTabRecommendReq();
        tabRecommendPB$GetTabRecommendReq.tab.set(3);
        tabRecommendPB$GetTabRecommendReq.session_info.set(mayKnowPersonRepositoryForDifSource.U(filterUins, eTag));
        tabRecommendPB$GetTabRecommendReq.source.set(dataSource);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(3);
        tabRecommendPB$GetTabRecommendReq.filter_type.set(arrayList);
        final boolean pymkTestSwitch = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch();
        if (pymkTestSwitch) {
            mayKnowPersonRepositoryForDifSource.A0(-1, "\u8bf7\u6c420x904d eTag " + eTag + " dataSource " + dataSource);
        }
        ProtoUtils.a(peekAppRuntime, new ProtoUtils.TroopProtocolObserver() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$fetchRecommendDataRemote$1
            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
                HashMap hashMap;
                hashMap = MayKnowPersonRepositoryForDifSource.isFetching;
                hashMap.put(Integer.valueOf(dataSource), Boolean.FALSE);
                MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource2 = MayKnowPersonRepositoryForDifSource.f261398a;
                mayKnowPersonRepositoryForDifSource2.g0(eTag, dataSource);
                if (pymkTestSwitch) {
                    mayKnowPersonRepositoryForDifSource2.A0(1, "\u8bf7\u6c420x904d eTag " + eTag + " \u5931\u8d25 dataSource " + dataSource);
                }
                QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataRemote error. onError:" + errorCode + " dataSource " + dataSource);
                return true;
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public void onResult(int errorCode, final byte[] data, Bundle bundle) {
                HashMap hashMap;
                hashMap = MayKnowPersonRepositoryForDifSource.isFetching;
                hashMap.put(Integer.valueOf(dataSource), Boolean.FALSE);
                if (errorCode == 0 && data != null) {
                    l lVar = l.f261472a;
                    final String str = eTag;
                    final int i3 = dataSource;
                    ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$fetchRecommendDataRemote$1$onResult$$inlined$runOnSubThread$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MayKnowPersonRepositoryForDifSource.f261398a.Y(data, str, i3);
                        }
                    });
                    return;
                }
                QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataRemote error. data is null. code: " + errorCode);
            }
        }, tabRecommendPB$GetTabRecommendReq.toByteArray(), "OidbSvcTrpcTcp.0x904d", 36941, 0);
    }

    private final AppInterface L() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @JvmStatic
    public static final List<PYMKBizEntryInfo> M(int dataSource) {
        ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
        if (!concurrentHashMap.containsKey(Integer.valueOf(dataSource))) {
            return new ArrayList();
        }
        PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(dataSource));
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList = pYMKTotalData != null ? pYMKTotalData.pymkBizEntryInfos : null;
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    private final EntityManager N() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchPageData error. app is null.");
            return null;
        }
        return peekAppRuntime.getEntityManagerFactory().createEntityManager();
    }

    @JvmStatic
    public static final List<MayKnowRecommend> O(int dataSource) {
        List<MayKnowRecommend> mutableList;
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return new ArrayList();
        }
        ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
        if (!concurrentHashMap.containsKey(Integer.valueOf(dataSource))) {
            return new ArrayList();
        }
        PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(dataSource));
        Collection collection = pYMKTotalData != null ? pYMKTotalData.mayKnowRecommends : null;
        if (collection == null) {
            collection = new ArrayList();
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList(collection);
        return mutableList;
    }

    @JvmStatic
    public static final com.tencent.mobileqq.pymk.api.c Q(int dataSource) {
        List<MayKnowRecommend> O = O(dataSource);
        String str = mETag.get(Integer.valueOf(dataSource));
        if (str == null) {
            str = "";
        }
        Boolean bool = mIsEnd.get(Integer.valueOf(dataSource));
        if (bool == null) {
            bool = Boolean.TRUE;
        }
        return new com.tencent.mobileqq.pymk.api.c(O, str, bool.booleanValue(), !f261398a.c0(dataSource));
    }

    public static final HashMap<Integer, QZoneInfo> T() {
        return qZoneExpInfo;
    }

    private final TabRecommendPB$Session U(ArrayList<Long> filterUins, String eTag) {
        TabRecommendPB$Session tabRecommendPB$Session = new TabRecommendPB$Session();
        TabRecommendPB$PersionParam tabRecommendPB$PersionParam = new TabRecommendPB$PersionParam();
        if (!filterUins.isEmpty()) {
            tabRecommendPB$PersionParam.filter_uins.set(filterUins);
        }
        if (eTag != null) {
            tabRecommendPB$PersionParam.etag.set(eTag);
        }
        tabRecommendPB$Session.persion_param_info.set(tabRecommendPB$PersionParam);
        return tabRecommendPB$Session;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(byte[] data, String lastETag, int dataSource) {
        TabRecommendPB$GetTabRecommendRsp k06 = k0(data);
        if (k06 == null) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataRemote error. data parse error. ");
        } else {
            F0(k06, lastETag, dataSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList;
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList2;
        EntityManager entityManager2 = entityManager;
        List<? extends Entity> query = entityManager2 != null ? entityManager2.query(PYMKBizEntryInfo.class, true, null, null, null, null, "", null) : null;
        if (!(query instanceof List)) {
            query = null;
        }
        boolean z16 = false;
        if (query != null && (!query.isEmpty())) {
            z16 = true;
        }
        if (!z16) {
            Integer valueOf = query != null ? Integer.valueOf(query.size()) : null;
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "loadRecommendDataFromDB entryList " + valueOf + " " + recommendData.size());
            return;
        }
        List<? extends Entity> list = query;
        CollectionsKt___CollectionsKt.sortedWith(list, new c());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PYMKBizEntryInfo pYMKBizEntryInfo = (PYMKBizEntryInfo) it.next();
            ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
            PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(pYMKBizEntryInfo.dataSource));
            if (pYMKTotalData != null && (copyOnWriteArrayList2 = pYMKTotalData.pymkBizEntryInfos) != null) {
                copyOnWriteArrayList2.add(pYMKBizEntryInfo);
            } else {
                concurrentHashMap.put(Integer.valueOf(pYMKBizEntryInfo.dataSource), new PYMKTotalData());
                PYMKTotalData pYMKTotalData2 = concurrentHashMap.get(Integer.valueOf(pYMKBizEntryInfo.dataSource));
                if (pYMKTotalData2 != null && (copyOnWriteArrayList = pYMKTotalData2.pymkBizEntryInfos) != null) {
                    copyOnWriteArrayList.add(pYMKBizEntryInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList;
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2;
        EntityManager entityManager2 = entityManager;
        List<? extends Entity> query = entityManager2 != null ? entityManager2.query(MayKnowRecommend.class, true, null, null, null, null, "", null) : null;
        if (!(query instanceof List)) {
            query = null;
        }
        boolean z16 = false;
        if (query != null && (!query.isEmpty())) {
            z16 = true;
        }
        if (!z16) {
            Integer valueOf = query != null ? Integer.valueOf(query.size()) : null;
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "loadRecommendDataFromDB dataList " + valueOf + " " + recommendData.size());
            return;
        }
        Iterator<T> it = query.iterator();
        while (it.hasNext()) {
            MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) it.next();
            ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
            PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(mayKnowRecommend.dataSource));
            if (pYMKTotalData != null && (copyOnWriteArrayList2 = pYMKTotalData.mayKnowRecommends) != null) {
                copyOnWriteArrayList2.add(mayKnowRecommend);
            } else {
                concurrentHashMap.put(Integer.valueOf(mayKnowRecommend.dataSource), new PYMKTotalData());
                PYMKTotalData pYMKTotalData2 = concurrentHashMap.get(Integer.valueOf(mayKnowRecommend.dataSource));
                if (pYMKTotalData2 != null && (copyOnWriteArrayList = pYMKTotalData2.mayKnowRecommends) != null) {
                    copyOnWriteArrayList.add(mayKnowRecommend);
                }
            }
        }
    }

    private final void b0() {
        if (isDBLoading) {
            return;
        }
        EntityManager entityManager2 = entityManager;
        if (!(entityManager2 != null && entityManager2.isOpen())) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "loadRecommendDataFromDB error. db is null.");
            return;
        }
        isDBLoading = true;
        l lVar = l.f261472a;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$loadRecommendDataFromDB$$inlined$runOnDBThread$1
            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList;
                CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2;
                MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = MayKnowPersonRepositoryForDifSource.f261398a;
                mayKnowPersonRepositoryForDifSource.a0();
                mayKnowPersonRepositoryForDifSource.Z();
                Iterator it = MayKnowPersonRepositoryForDifSource.recommendData.entrySet().iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) ((Map.Entry) it.next()).getKey()).intValue();
                    PYMKTotalData pYMKTotalData = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(intValue));
                    Integer num = null;
                    Integer valueOf = (pYMKTotalData == null || (copyOnWriteArrayList2 = pYMKTotalData.mayKnowRecommends) == null) ? null : Integer.valueOf(copyOnWriteArrayList2.size());
                    PYMKTotalData pYMKTotalData2 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(intValue));
                    if (pYMKTotalData2 != null && (copyOnWriteArrayList = pYMKTotalData2.pymkBizEntryInfos) != null) {
                        num = Integer.valueOf(copyOnWriteArrayList.size());
                    }
                    QLog.d("MayKnowPersonRepositoryForDifSource", 1, "loadRecommendDataFromDB dataSource " + intValue + " personList " + valueOf + "entryList " + num);
                }
                MayKnowPersonRepositoryForDifSource.isDBLoading = false;
                MayKnowPersonRepositoryForDifSource.f261398a.D0();
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c0(int dataSource) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        Long l3 = nextRequestTime.get(Integer.valueOf(dataSource));
        if (l3 == null) {
            l3 = 0L;
        }
        return serverTimeMillis > l3.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(final int dataSource) {
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListener " + dataSource);
            for (Map.Entry entry : listeners.entrySet()) {
                if (((Number) entry.getKey()).intValue() == dataSource) {
                    for (com.tencent.mobileqq.pymk.api.a aVar : (Iterable) entry.getValue()) {
                        if (aVar != null) {
                            PYMKTotalData pYMKTotalData = (PYMKTotalData) recommendData.get(Integer.valueOf(dataSource));
                            List<? extends MayKnowRecommend> list = pYMKTotalData != null ? pYMKTotalData.mayKnowRecommends : null;
                            if (list == null) {
                                list = new ArrayList<>();
                            } else {
                                Intrinsics.checkNotNullExpressionValue(list, "recommendData[dataSource\u2026Recommends ?: ArrayList()");
                            }
                            aVar.d(list, true);
                        }
                    }
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$notifyListener$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListener " + dataSource);
                for (Map.Entry entry2 : MayKnowPersonRepositoryForDifSource.listeners.entrySet()) {
                    if (((Number) entry2.getKey()).intValue() == dataSource) {
                        for (com.tencent.mobileqq.pymk.api.a aVar2 : (Iterable) entry2.getValue()) {
                            if (aVar2 != null) {
                                PYMKTotalData pYMKTotalData2 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                                List<? extends MayKnowRecommend> list2 = pYMKTotalData2 != null ? pYMKTotalData2.mayKnowRecommends : null;
                                if (list2 == null) {
                                    list2 = new ArrayList<>();
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(list2, "recommendData[dataSource\u2026Recommends ?: ArrayList()");
                                }
                                aVar2.d(list2, true);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(final List<? extends MayKnowRecommend> data, final String eTag, final boolean isEnd, final int dataSource) {
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListener new " + dataSource);
            for (Map.Entry entry : listeners.entrySet()) {
                if (((Number) entry.getKey()).intValue() == dataSource) {
                    Iterator it = ((Iterable) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mobileqq.pymk.api.a) it.next()).e(new com.tencent.mobileqq.pymk.api.c(data, eTag, isEnd, !f261398a.c0(dataSource)));
                    }
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$notifyListener$$inlined$runOnUiThread$2
            @Override // java.lang.Runnable
            public final void run() {
                QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListener new " + dataSource);
                for (Map.Entry entry2 : MayKnowPersonRepositoryForDifSource.listeners.entrySet()) {
                    if (((Number) entry2.getKey()).intValue() == dataSource) {
                        Iterator it5 = ((Iterable) entry2.getValue()).iterator();
                        while (it5.hasNext()) {
                            ((com.tencent.mobileqq.pymk.api.a) it5.next()).e(new com.tencent.mobileqq.pymk.api.c(data, eTag, isEnd, !MayKnowPersonRepositoryForDifSource.f261398a.c0(dataSource)));
                        }
                    }
                }
            }
        });
    }

    private final void f0(final String uin) {
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            for (Map.Entry entry : listeners.entrySet()) {
                QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListenerForRemove uin " + uin + " dataSource " + entry.getKey());
                Iterator it = ((Iterable) entry.getValue()).iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.pymk.api.a) it.next()).c(uin);
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$notifyListenerForRemove$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                for (Map.Entry entry2 : MayKnowPersonRepositoryForDifSource.listeners.entrySet()) {
                    QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListenerForRemove uin " + uin + " dataSource " + entry2.getKey());
                    Iterator it5 = ((Iterable) entry2.getValue()).iterator();
                    while (it5.hasNext()) {
                        ((com.tencent.mobileqq.pymk.api.a) it5.next()).c(uin);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(final String eTag, final int dataSource) {
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListenerForReqFail dataSource: " + dataSource);
            for (Map.Entry entry : listeners.entrySet()) {
                if (((Number) entry.getKey()).intValue() == dataSource) {
                    Iterator it = ((Iterable) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mobileqq.pymk.api.a) it.next()).b(eTag);
                    }
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$notifyListenerForReqFail$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyListenerForReqFail dataSource: " + dataSource);
                for (Map.Entry entry2 : MayKnowPersonRepositoryForDifSource.listeners.entrySet()) {
                    if (((Number) entry2.getKey()).intValue() == dataSource) {
                        Iterator it5 = ((Iterable) entry2.getValue()).iterator();
                        while (it5.hasNext()) {
                            ((com.tencent.mobileqq.pymk.api.a) it5.next()).b(eTag);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(final int dataSource) {
        l lVar = l.f261472a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyTotalInfoChange " + dataSource);
            for (Map.Entry entry : listeners.entrySet()) {
                if (((Number) entry.getKey()).intValue() == dataSource) {
                    for (com.tencent.mobileqq.pymk.api.a aVar : (Iterable) entry.getValue()) {
                        if (aVar != null) {
                            PYMKTotalData pYMKTotalData = (PYMKTotalData) recommendData.get(Integer.valueOf(dataSource));
                            if (pYMKTotalData == null) {
                                pYMKTotalData = new PYMKTotalData();
                            }
                            Intrinsics.checkNotNullExpressionValue(pYMKTotalData, "recommendData[dataSource]?: PYMKTotalData()");
                            aVar.a(pYMKTotalData);
                        }
                    }
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$notifyTotalInfoChange$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                QLog.i("MayKnowPersonRepositoryForDifSource", 1, "notifyTotalInfoChange " + dataSource);
                for (Map.Entry entry2 : MayKnowPersonRepositoryForDifSource.listeners.entrySet()) {
                    if (((Number) entry2.getKey()).intValue() == dataSource) {
                        for (com.tencent.mobileqq.pymk.api.a aVar2 : (Iterable) entry2.getValue()) {
                            if (aVar2 != null) {
                                PYMKTotalData pYMKTotalData2 = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                                if (pYMKTotalData2 == null) {
                                    pYMKTotalData2 = new PYMKTotalData();
                                }
                                Intrinsics.checkNotNullExpressionValue(pYMKTotalData2, "recommendData[dataSource]?: PYMKTotalData()");
                                aVar2.a(pYMKTotalData2);
                            }
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(List<? extends MayKnowRecommend> recommendPerson, String eTag, boolean isEnd, int dataSource) {
        ArrayList arrayList = new ArrayList();
        if (recommendPerson != null) {
            for (MayKnowRecommend mayKnowRecommend : recommendPerson) {
                if (mayKnowRecommend != null) {
                    arrayList.add(mayKnowRecommend);
                }
            }
        }
        e0(arrayList, eTag, isEnd, dataSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TabRecommendPB$GetRecommendExtraInfoRsp j0(byte[] data) {
        try {
            return new TabRecommendPB$GetRecommendExtraInfoRsp().mergeFrom(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, e16, "parseRecommendExtraInfoRsp error.");
            return null;
        }
    }

    private final TabRecommendPB$GetTabRecommendRsp k0(byte[] data) {
        try {
            return new TabRecommendPB$GetTabRecommendRsp().mergeFrom(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, e16, "parseTabRecommendRsp error.");
            return null;
        }
    }

    private final void l0(int itemSize, ArrayList<MayKnowRecommend> array) {
        int size = array.size();
        for (int i3 = 0; i3 < size && i3 < itemSize; i3++) {
            new QQProAvatarDrawable().q(BaseApplication.getContext(), 1, array.get(i3).uin);
        }
    }

    private final void m0() {
        if (BaseApplication.getContext() == null || BaseApplication.getContext().getContentResolver() == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_LOGIN);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(receiver, intentFilter);
    }

    @JvmStatic
    public static final void o0(com.tencent.mobileqq.pymk.api.a listener, int dataSource) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<com.tencent.mobileqq.pymk.api.a> copyOnWriteArrayList = listeners.get(Integer.valueOf(dataSource));
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(listener);
        }
    }

    @JvmStatic
    public static final void q0(final String uin) {
        Unit unit;
        Object obj;
        Intrinsics.checkNotNullParameter(uin, "uin");
        for (Map.Entry<Integer, PYMKTotalData> entry : recommendData.entrySet()) {
            int intValue = entry.getKey().intValue();
            CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList = entry.getValue().mayKnowRecommends;
            Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "it.value.mayKnowRecommends");
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                unit = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MayKnowRecommend) obj).uin, uin)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            final MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) obj;
            if (mayKnowRecommend != null) {
                entry.getValue().mayKnowRecommends.remove(mayKnowRecommend);
                l lVar = l.f261472a;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$removeRecommendData$lambda$29$lambda$27$$inlined$runOnDBThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        EntityManager entityManager2;
                        entityManager2 = MayKnowPersonRepositoryForDifSource.entityManager;
                        if (entityManager2 != null) {
                            entityManager2.remove(MayKnowRecommend.this);
                        }
                    }
                }, 32, null, false);
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$removeRecommendData$lambda$29$lambda$27$$inlined$runOnSubThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b.f180893a.d(uin, 2);
                    }
                });
                MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
                mayKnowPersonRepositoryForDifSource.d0(intValue);
                mayKnowPersonRepositoryForDifSource.h0(intValue);
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "removeRecommendData success data:" + mayKnowRecommend + " dataSource " + intValue);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "removeRecommendData for cache " + uin);
            }
        }
        f261398a.f0(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(final int dataSource) {
        EntityManager entityManager2 = entityManager;
        if (!(entityManager2 != null && entityManager2.isOpen())) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "saveRecommendDataToDB error. db is null. dataSource: " + dataSource);
            return;
        }
        l lVar = l.f261472a;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$saveBizEntryToDB$$inlined$runOnDBThread$1
            @Override // java.lang.Runnable
            public final void run() {
                EntityManager entityManager3;
                CopyOnWriteArrayList<PYMKBizEntryInfo> pymkBizEntryInfos;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DeleteTransaction(PYMKBizEntryInfo.class.getSimpleName(), "dataSource=?", new String[]{String.valueOf(dataSource)}));
                PYMKTotalData pYMKTotalData = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                if (pYMKTotalData != null && (pymkBizEntryInfos = pYMKTotalData.pymkBizEntryInfos) != null) {
                    Intrinsics.checkNotNullExpressionValue(pymkBizEntryInfos, "pymkBizEntryInfos");
                    for (PYMKBizEntryInfo it : pymkBizEntryInfos) {
                        it.setStatus(1000);
                        it.dataSource = dataSource;
                        MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = MayKnowPersonRepositoryForDifSource.f261398a;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        mayKnowPersonRepositoryForDifSource.E(arrayList, it);
                    }
                }
                entityManager3 = MayKnowPersonRepositoryForDifSource.entityManager;
                Intrinsics.checkNotNull(entityManager3);
                boolean doMultiDBOperateByTransaction = entityManager3.doMultiDBOperateByTransaction(arrayList);
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "saveBizEntryToDB dataSource: " + dataSource + " result " + doMultiDBOperateByTransaction + " size " + arrayList.size());
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(String eTag, boolean isEnd, int dataSource) {
        QLog.i("MayKnowPersonRepositoryForDifSource", 1, "saveFirstPageParam eTag " + eTag + " isEnd " + isEnd + " dataSource " + dataSource);
        mETag.put(Integer.valueOf(dataSource), eTag);
        mIsEnd.put(Integer.valueOf(dataSource), Boolean.valueOf(isEnd));
        f fVar = f.f261465a;
        String str = mETag.get(Integer.valueOf(dataSource));
        if (str == null) {
            str = "";
        }
        fVar.l(str, dataSource);
        Boolean bool = mIsEnd.get(Integer.valueOf(dataSource));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        fVar.n(bool.booleanValue(), dataSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(final int dataSource) {
        EntityManager entityManager2 = entityManager;
        if (!(entityManager2 != null && entityManager2.isOpen())) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "saveRecommendDataToDB error. db is null. dataSource: " + dataSource);
            return;
        }
        l lVar = l.f261472a;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$saveRecommendDataToDB$$inlined$runOnDBThread$1
            @Override // java.lang.Runnable
            public final void run() {
                EntityManager entityManager3;
                CopyOnWriteArrayList<MayKnowRecommend> mayKnowRecommends;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DeleteTransaction(MayKnowRecommend.class.getSimpleName(), "dataSource=?", new String[]{String.valueOf(dataSource)}));
                PYMKTotalData pYMKTotalData = (PYMKTotalData) MayKnowPersonRepositoryForDifSource.recommendData.get(Integer.valueOf(dataSource));
                if (pYMKTotalData != null && (mayKnowRecommends = pYMKTotalData.mayKnowRecommends) != null) {
                    Intrinsics.checkNotNullExpressionValue(mayKnowRecommends, "mayKnowRecommends");
                    for (MayKnowRecommend it : mayKnowRecommends) {
                        it.setStatus(1000);
                        it.dataSource = dataSource;
                        MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = MayKnowPersonRepositoryForDifSource.f261398a;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        mayKnowPersonRepositoryForDifSource.E(arrayList, it);
                    }
                }
                entityManager3 = MayKnowPersonRepositoryForDifSource.entityManager;
                Intrinsics.checkNotNull(entityManager3);
                boolean doMultiDBOperateByTransaction = entityManager3.doMultiDBOperateByTransaction(arrayList);
                f.f261465a.m(MayKnowPersonRepositoryForDifSource.T().get(Integer.valueOf(dataSource)), Integer.valueOf(dataSource));
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "saveRecommendDataToDB dataSource: " + dataSource + " result " + doMultiDBOperateByTransaction + " size " + arrayList.size());
            }
        }, 32, null, false);
    }

    @JvmStatic
    public static final void w0(int dataSource, long type) {
        Object obj;
        PYMKTotalData pYMKTotalData = recommendData.get(Integer.valueOf(dataSource));
        if (pYMKTotalData != null) {
            CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList = pYMKTotalData.pymkBizEntryInfos;
            Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "pymkTotalData.pymkBizEntryInfos");
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((PYMKBizEntryInfo) obj).type == type) {
                        break;
                    }
                }
            }
            final PYMKBizEntryInfo pYMKBizEntryInfo = (PYMKBizEntryInfo) obj;
            if (pYMKBizEntryInfo != null) {
                pYMKBizEntryInfo.lastCartonShowTime = new Date().getTime() / 1000;
                l lVar = l.f261472a;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$setBizEntryCartonShow$lambda$8$lambda$7$$inlined$runOnDBThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        EntityManager entityManager2;
                        entityManager2 = MayKnowPersonRepositoryForDifSource.entityManager;
                        if (entityManager2 != null) {
                            entityManager2.update(PYMKBizEntryInfo.this);
                        }
                    }
                }, 32, null, false);
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "removeRecommendData success data:" + pYMKBizEntryInfo + " dataSource " + dataSource);
            }
        }
    }

    @JvmStatic
    public static final void x0(long type, boolean needRefresh) {
        Object obj;
        for (Map.Entry<Integer, PYMKTotalData> entry : recommendData.entrySet()) {
            int intValue = entry.getKey().intValue();
            CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList = entry.getValue().pymkBizEntryInfos;
            Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "entry.value.pymkBizEntryInfos");
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((PYMKBizEntryInfo) obj).type == type) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            final PYMKBizEntryInfo pYMKBizEntryInfo = (PYMKBizEntryInfo) obj;
            if (pYMKBizEntryInfo != null) {
                pYMKBizEntryInfo.lastCloseTime = new Date().getTime() / 1000;
                l lVar = l.f261472a;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pymk.MayKnowPersonRepositoryForDifSource$setBizEntryClose$lambda$4$lambda$3$$inlined$runOnDBThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        EntityManager entityManager2;
                        entityManager2 = MayKnowPersonRepositoryForDifSource.entityManager;
                        if (entityManager2 != null) {
                            entityManager2.update(PYMKBizEntryInfo.this);
                        }
                    }
                }, 32, null, false);
                if (needRefresh) {
                    f261398a.h0(intValue);
                }
                QLog.d("MayKnowPersonRepositoryForDifSource", 1, "removeRecommendData success data:" + pYMKBizEntryInfo + " dataSource " + intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        AppInterface L = L();
        if (L != null) {
            L.removeObserver(friendObserver);
        }
        AppInterface L2 = L();
        if (L2 != null) {
            L2.addObserver(friendObserver);
        }
        EntityManager entityManager2 = entityManager;
        if (entityManager2 != null) {
            entityManager2.close();
        }
        entityManager = N();
        recommendData.clear();
        isFetching = new HashMap<>();
        isDBLoading = false;
        Iterator<T> it = validDataSource.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            Integer valueOf = Integer.valueOf(intValue);
            HashMap<Integer, QZoneInfo> hashMap = qZoneExpInfo;
            f fVar = f.f261465a;
            hashMap.put(valueOf, fVar.e(Integer.valueOf(intValue)));
            nextRequestTime.put(Integer.valueOf(intValue), Long.valueOf(fVar.g(intValue)));
            mETag.put(Integer.valueOf(intValue), fVar.d(intValue));
            mIsEnd.put(Integer.valueOf(intValue), Boolean.valueOf(fVar.f(intValue)));
        }
        b0();
        QLog.d("MayKnowPersonRepositoryForDifSource", 1, "setUp " + qZoneExpInfo + " nextRequestTime:" + nextRequestTime);
    }

    public final ConcurrentHashMap<Integer, Map<Long, TabRecommendPB$PersonExtraInfo>> S() {
        return qZoneDetailInfoCache;
    }

    public final String V() {
        try {
            if (!TextUtils.isEmpty(SSODebugUtil.loadTestEnvironment()[0])) {
                return "TestEnv";
            }
            if (MsfSdkUtils.isBuildTestEnvValid()) {
                return "TestEnv";
            }
            return "NormalEnv";
        } catch (Exception e16) {
            QLog.e("MayKnowPersonRepositoryForDifSource", 1, "getTestEnvironment error " + e16);
            return "";
        }
    }

    public final String W(int dataSource) {
        String str = traceId.get(Integer.valueOf(dataSource));
        return str == null ? "" : str;
    }

    public final void n0() {
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList;
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2;
        Iterator<T> it = totoalDataSource.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
            mayKnowPersonRepositoryForDifSource.s0("", false, intValue);
            mayKnowPersonRepositoryForDifSource.H0(0L, intValue);
            ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
            PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(intValue));
            Integer num = null;
            CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList3 = pYMKTotalData != null ? pYMKTotalData.mayKnowRecommends : null;
            if (!(copyOnWriteArrayList3 == null || copyOnWriteArrayList3.isEmpty())) {
                mayKnowPersonRepositoryForDifSource.G0(null, null, intValue);
                mayKnowPersonRepositoryForDifSource.t0(intValue);
            }
            PYMKTotalData pYMKTotalData2 = concurrentHashMap.get(Integer.valueOf(intValue));
            CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList4 = pYMKTotalData2 != null ? pYMKTotalData2.pymkBizEntryInfos : null;
            if (!(copyOnWriteArrayList4 == null || copyOnWriteArrayList4.isEmpty())) {
                mayKnowPersonRepositoryForDifSource.E0(null, new ArrayList<>(), intValue);
                mayKnowPersonRepositoryForDifSource.r0(intValue);
            }
            mayKnowPersonRepositoryForDifSource.d0(intValue);
            PYMKTotalData pYMKTotalData3 = concurrentHashMap.get(Integer.valueOf(intValue));
            List<? extends MayKnowRecommend> list = pYMKTotalData3 != null ? pYMKTotalData3.mayKnowRecommends : null;
            if (list == null) {
                list = new ArrayList<>();
            } else {
                Intrinsics.checkNotNullExpressionValue(list, "recommendData[dataSource\u2026Recommends ?: ArrayList()");
            }
            String str = mETag.get(Integer.valueOf(intValue));
            String str2 = str != null ? str : "";
            Intrinsics.checkNotNullExpressionValue(str2, "mETag[dataSource] ?: \"\"");
            Boolean bool = mIsEnd.get(Integer.valueOf(intValue));
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            Intrinsics.checkNotNullExpressionValue(bool, "mIsEnd[dataSource] ?: false");
            mayKnowPersonRepositoryForDifSource.e0(list, str2, bool.booleanValue(), intValue);
            mayKnowPersonRepositoryForDifSource.h0(intValue);
            PYMKTotalData pYMKTotalData4 = concurrentHashMap.get(Integer.valueOf(intValue));
            Integer valueOf = (pYMKTotalData4 == null || (copyOnWriteArrayList2 = pYMKTotalData4.mayKnowRecommends) == null) ? null : Integer.valueOf(copyOnWriteArrayList2.size());
            HashMap<Integer, QZoneInfo> hashMap = qZoneExpInfo;
            PYMKTotalData pYMKTotalData5 = concurrentHashMap.get(Integer.valueOf(intValue));
            if (pYMKTotalData5 != null && (copyOnWriteArrayList = pYMKTotalData5.pymkBizEntryInfos) != null) {
                num = Integer.valueOf(copyOnWriteArrayList.size());
            }
            QLog.d("MayKnowPersonRepositoryForDifSource", 1, "removeAllPymkData success. dataSource " + intValue + " dataSize:" + valueOf + " qzone:" + hashMap + " bizEntry: " + num + " requestDelay:0");
        }
    }

    public final void u0(String traceId2, int dataSource) {
        Intrinsics.checkNotNullParameter(traceId2, "traceId");
        traceId.put(Integer.valueOf(dataSource), traceId2);
    }

    public final void y0(int itemSize, int dataSource) {
        MayKnowRecommend mayKnowRecommend;
        if (((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch()) {
            A0(-1, "\u66f4\u65b0 " + dataSource + " \u9876\u90e8 " + itemSize + " \u4e2a\u65f6\u95f4\u6233\uff0c\u5e76\u4e14\u91cd\u6392\u5e8f");
        }
        QLog.i("MayKnowPersonRepositoryForDifSource", 1, "setTimeStampAndResort dataSource " + dataSource);
        PYMKTotalData pYMKTotalData = recommendData.get(Integer.valueOf(dataSource));
        if (pYMKTotalData != null) {
            ArrayList<MayKnowRecommend> arrayList = new ArrayList<>();
            arrayList.addAll(pYMKTotalData.mayKnowRecommends);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 < itemSize && (mayKnowRecommend = arrayList.get(i3)) != null) {
                    mayKnowRecommend.cardDisplayTimestamp = serverTimeMillis;
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, comparatorForCardDispalyTime);
            pYMKTotalData.mayKnowRecommends.clear();
            pYMKTotalData.mayKnowRecommends.addAll(arrayList);
            MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource = f261398a;
            mayKnowPersonRepositoryForDifSource.l0(itemSize, arrayList);
            mayKnowPersonRepositoryForDifSource.d0(dataSource);
            mayKnowPersonRepositoryForDifSource.h0(dataSource);
            mayKnowPersonRepositoryForDifSource.t0(dataSource);
        }
    }

    private final void E0(TabRecommendPB$TabRecommendResult personData, ArrayList<PYMKBizEntryInfo> bizDataList, int dataSource) {
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList;
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList2;
        CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList3;
        if (personData != null && bizDataList != null) {
            PYMKTotalData pYMKTotalData = recommendData.get(Integer.valueOf(dataSource));
            CopyOnWriteArrayList<PYMKBizEntryInfo> copyOnWriteArrayList4 = pYMKTotalData != null ? pYMKTotalData.pymkBizEntryInfos : null;
            if (copyOnWriteArrayList4 != null) {
                for (PYMKBizEntryInfo pYMKBizEntryInfo : bizDataList) {
                    int indexOf = copyOnWriteArrayList4.indexOf(pYMKBizEntryInfo);
                    if (indexOf >= 0) {
                        pYMKBizEntryInfo.lastCloseTime = copyOnWriteArrayList4.get(indexOf).lastCloseTime;
                        pYMKBizEntryInfo.lastCartonShowTime = copyOnWriteArrayList4.get(indexOf).lastCartonShowTime;
                    }
                    QLog.i("MayKnowPersonRepositoryForDifSource", 1, "updateBizEntryInfo " + pYMKBizEntryInfo);
                }
            }
            ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
            PYMKTotalData pYMKTotalData2 = concurrentHashMap.get(Integer.valueOf(dataSource));
            if (pYMKTotalData2 != null && (copyOnWriteArrayList3 = pYMKTotalData2.pymkBizEntryInfos) != null) {
                copyOnWriteArrayList3.clear();
            }
            PYMKTotalData pYMKTotalData3 = concurrentHashMap.get(Integer.valueOf(dataSource));
            if (pYMKTotalData3 != null && (copyOnWriteArrayList2 = pYMKTotalData3.pymkBizEntryInfos) != null) {
                copyOnWriteArrayList2.addAll(bizDataList);
                return;
            }
            CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList();
            copyOnWriteArrayList5.addAll(bizDataList);
            concurrentHashMap.put(Integer.valueOf(dataSource), new PYMKTotalData(copyOnWriteArrayList5, null));
            return;
        }
        PYMKTotalData pYMKTotalData4 = recommendData.get(Integer.valueOf(dataSource));
        if (pYMKTotalData4 == null || (copyOnWriteArrayList = pYMKTotalData4.pymkBizEntryInfos) == null) {
            return;
        }
        copyOnWriteArrayList.clear();
    }

    public static /* synthetic */ void D(com.tencent.mobileqq.pymk.api.a aVar, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        C(aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(TabRecommendPB$TabRecommendResult personData, List<? extends MayKnowRecommend> recommendPerson, int dataSource) {
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList;
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList2;
        CopyOnWriteArrayList<MayKnowRecommend> copyOnWriteArrayList3;
        if (personData != null && recommendPerson != null) {
            ConcurrentHashMap<Integer, PYMKTotalData> concurrentHashMap = recommendData;
            PYMKTotalData pYMKTotalData = concurrentHashMap.get(Integer.valueOf(dataSource));
            if (pYMKTotalData != null && (copyOnWriteArrayList3 = pYMKTotalData.mayKnowRecommends) != null) {
                copyOnWriteArrayList3.clear();
            }
            PYMKTotalData pYMKTotalData2 = concurrentHashMap.get(Integer.valueOf(dataSource));
            if (pYMKTotalData2 != null && (copyOnWriteArrayList2 = pYMKTotalData2.mayKnowRecommends) != null) {
                copyOnWriteArrayList2.addAll(recommendPerson);
            } else {
                CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList();
                copyOnWriteArrayList4.addAll(recommendPerson);
                concurrentHashMap.put(Integer.valueOf(dataSource), new PYMKTotalData(null, copyOnWriteArrayList4));
            }
            HashMap<Integer, QZoneInfo> hashMap = qZoneExpInfo;
            Integer valueOf = Integer.valueOf(dataSource);
            oidb_0xc26$QzoneInfo oidb_0xc26_qzoneinfo = personData.qzone_info.get();
            Intrinsics.checkNotNullExpressionValue(oidb_0xc26_qzoneinfo, "personData.qzone_info.get()");
            hashMap.put(valueOf, new QZoneInfo(oidb_0xc26_qzoneinfo));
            return;
        }
        PYMKTotalData pYMKTotalData3 = recommendData.get(Integer.valueOf(dataSource));
        if (pYMKTotalData3 != null && (copyOnWriteArrayList = pYMKTotalData3.mayKnowRecommends) != null) {
            copyOnWriteArrayList.clear();
        }
        qZoneExpInfo.put(Integer.valueOf(dataSource), null);
        QLog.w("MayKnowPersonRepositoryForDifSource", 1, "fetchRecommendDataRemote error. data is empty. dataSource " + dataSource);
    }

    public static /* synthetic */ List P(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        return O(i3);
    }

    public static /* synthetic */ com.tencent.mobileqq.pymk.api.c R(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        return Q(i3);
    }

    public static /* synthetic */ String X(MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        return mayKnowPersonRepositoryForDifSource.W(i3);
    }

    public static /* synthetic */ void p0(com.tencent.mobileqq.pymk.api.a aVar, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        o0(aVar, i3);
    }

    public static /* synthetic */ void v0(MayKnowPersonRepositoryForDifSource mayKnowPersonRepositoryForDifSource, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        mayKnowPersonRepositoryForDifSource.u0(str, i3);
    }

    public static /* synthetic */ void K(boolean z16, ArrayList arrayList, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = false;
        }
        if ((i16 & 2) != 0) {
            arrayList = new ArrayList();
        }
        if ((i16 & 4) != 0) {
            str = null;
        }
        if ((i16 & 8) != 0) {
            i3 = 1;
        }
        J(z16, arrayList, str, i3);
    }
}
