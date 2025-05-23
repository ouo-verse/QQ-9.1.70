package com.tencent.rdelivery;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.net.BaseProto$BizSystemID;
import com.tencent.rdelivery.net.BaseProto$ConfigType;
import com.tencent.rdelivery.net.BaseProto$DataRefreshMode;
import com.tencent.rdelivery.net.BaseProto$PullTarget;
import com.tencent.rdelivery.net.BaseProto$ServerType;
import com.tencent.rdelivery.net.d;
import com.tencent.rdelivery.util.RDeliveryConstant$DataLoadMode;
import iz3.e;
import iz3.i;
import iz3.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0005\"\u001f\u001e\u00c5\u0001B\u00c9\u0003\b\u0002\u0012\u0006\u0010}\u001a\u00020\u0006\u0012\u0006\u0010~\u001a\u00020\u0006\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0006\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010>\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0082\u0001\u0012\u0010\b\u0002\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0086\u0001\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0006\u0012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010L\u001a\u00020\u0017\u0012\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0006\u0012\f\b\u0002\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u0001\u0012\f\b\u0002\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u0001\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010W\u0012\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010b\u0012\f\b\u0002\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a0\u0001\u0012\n\b\u0002\u0010\u00a7\u0001\u001a\u00030\u00a4\u0001\u0012\u000b\b\u0002\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\f\u0012\u000b\b\u0002\u0010\u00af\u0001\u001a\u0004\u0018\u00010\f\u0012\t\b\u0002\u0010\u00b0\u0001\u001a\u00020\f\u0012\t\b\u0002\u0010\u00b1\u0001\u001a\u00020\f\u0012\t\b\u0002\u0010\u00b3\u0001\u001a\u00020\u0013\u0012\b\u0010a\u001a\u0004\u0018\u00010]\u0012\t\b\u0002\u0010\u00b5\u0001\u001a\u00020\f\u0012\t\b\u0002\u0010\u00b6\u0001\u001a\u00020\f\u0012\u000b\b\u0002\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u0006\u0012\t\b\u0002\u0010\u00b8\u0001\u001a\u00020\f\u0012\t\b\u0002\u0010\u00b9\u0001\u001a\u00020\f\u0012\n\b\u0002\u0010\u00bc\u0001\u001a\u00030\u00ba\u0001\u0012\u000b\b\u0002\u0010\u00be\u0001\u001a\u0004\u0018\u00010\u0006\u0012\t\b\u0002\u0010\u00bf\u0001\u001a\u00020\f\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0006\b\u00c0\u0001\u0010\u00c1\u0001B\u0015\b\u0012\u0012\b\u0010\u00c3\u0001\u001a\u00030\u00c2\u0001\u00a2\u0006\u0006\b\u00c0\u0001\u0010\u00c4\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#J\u0019\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0000\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\fJ\u0019\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-H\u0000\u00a2\u0006\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00101R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u00103\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001f\u00104\u001a\u0004\b5\u00106R(\u0010:\u001a\u0004\u0018\u00010&2\b\u00103\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u00109R$\u0010>\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=R(\u0010A\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010=R(\u0010D\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u00101\u001a\u0004\bC\u0010=R(\u0010G\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bE\u00101\u001a\u0004\bF\u0010=R$\u0010L\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR$\u0010N\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b8\u0010I\u001a\u0004\bM\u0010KR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010\\\u001a\u0004\u0018\u00010W2\b\u00103\u001a\u0004\u0018\u00010W8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R(\u0010a\u001a\u0004\u0018\u00010]2\b\u00103\u001a\u0004\u0018\u00010]8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b@\u0010^\u001a\u0004\b_\u0010`R(\u0010f\u001a\u0004\u0018\u00010b2\b\u00103\u001a\u0004\u0018\u00010b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\bX\u0010eR$\u0010i\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00178\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bg\u0010I\u001a\u0004\bh\u0010KR$\u0010\u001a\u001a\u00020\f2\u0006\u00103\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bj\u0010\u001b\u001a\u0004\bk\u0010lR$\u0010\u001c\u001a\u00020\f2\u0006\u00103\u001a\u00020\f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bm\u0010\u001b\u001a\u0004\bn\u0010lR(\u0010q\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bo\u00101\u001a\u0004\bp\u0010=R\u0018\u0010s\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u00107R4\u0010x\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b`u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020 0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010zR\u0017\u0010}\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b|\u00101\u001a\u0004\b?\u0010=R\u0017\u0010~\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\bn\u00101\u001a\u0004\bB\u0010=R\u0018\u0010\u0080\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u007f\u00101\u001a\u0004\bE\u0010=R\u0018\u0010\u0081\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\bR\u00101\u001a\u0004\bI\u0010=R)\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0082\u00018\u0006\u00a2\u0006\u000e\n\u0005\b5\u0010\u0083\u0001\u001a\u0005\bP\u0010\u0084\u0001R\"\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0086\u00018\u0006\u00a2\u0006\u000f\n\u0005\bF\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001e\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b\u007f\u0010=R\u0019\u0010\u0092\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\r\n\u0005\b\u0091\u0001\u00101\u001a\u0004\bj\u0010=R\u0019\u0010\u0094\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\r\n\u0005\b\u0093\u0001\u00101\u001a\u0004\bg\u0010=R\u0018\u0010\u0095\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\bC\u00101\u001a\u0004\b;\u0010=R\u001e\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0006\u00a2\u0006\u000f\n\u0005\bM\u0010\u0097\u0001\u001a\u0006\b\u0093\u0001\u0010\u0098\u0001R\u001e\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0006\u00a2\u0006\u000f\n\u0005\bZ\u0010\u009b\u0001\u001a\u0006\b\u0091\u0001\u0010\u009c\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\r\n\u0005\b\u009e\u0001\u00101\u001a\u0004\b|\u0010=R\u001e\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a0\u00018\u0006\u00a2\u0006\u000f\n\u0005\bI\u0010\u00a1\u0001\u001a\u0006\b\u009e\u0001\u0010\u00a2\u0001R\u001c\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u008d\u0001\u0010\u00a5\u0001\u001a\u0005\bc\u0010\u00a6\u0001R\u001d\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\u000f\n\u0005\b<\u0010\u00a8\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R*\u0010\u00af\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b_\u0010\u00a8\u0001\u001a\u0006\b\u00ac\u0001\u0010\u00aa\u0001\"\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0015\u0010\u00b0\u0001\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010\u001bR\u0018\u0010\u00b1\u0001\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\bo\u0010lR\u001b\u0010\u00b3\u0001\u001a\u00020\u00138\u0006\u00a2\u0006\u000f\n\u0005\b%\u0010\u008d\u0001\u001a\u0006\b\u008b\u0001\u0010\u00b2\u0001R\u001a\u0010\u00b5\u0001\u001a\u00020\f8\u0006\u00a2\u0006\u000e\n\u0005\b\u00ac\u0001\u0010\u001b\u001a\u0005\b\u00b4\u0001\u0010lR\u0019\u0010\u00b6\u0001\u001a\u00020\f8\u0006\u00a2\u0006\r\n\u0005\b\u00b4\u0001\u0010\u001b\u001a\u0004\br\u0010lR\u001a\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\bk\u00101\u001a\u0004\bH\u0010=R\u0016\u0010\u00b8\u0001\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010\u001bR\u0018\u0010\u00b9\u0001\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\bm\u0010lR\u0017\u0010\u00bc\u0001\u001a\u00030\u00ba\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\r\u0010\u00bb\u0001R\u001b\u0010\u00be\u0001\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\r\n\u0004\b+\u00101\u001a\u0005\b\u00bd\u0001\u0010=R\u0018\u0010\u00bf\u0001\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\bv\u0010l\u00a8\u0006\u00c6\u0001"}, d2 = {"Lcom/tencent/rdelivery/RDeliverySetting;", "", "Lcom/tencent/rdelivery/util/c;", "logger", "", "e0", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "data", "B", "t", "", "U", "X", "value", "f0", "newUserId", "g0", "", "softInterval", "hardInterval", "b0", "", "sampling", "a0", "isCfgChangeReport", "Z", "forbidBuglyConnectReport", "Y", "c", "b", "Lcom/tencent/rdelivery/RDeliverySetting$c;", "listener", "a", "Landroid/content/Context;", "context", "O", "Lcom/tencent/raft/standard/storage/IRStorage;", "irStorage", "N", "(Lcom/tencent/raft/standard/storage/IRStorage;)V", "T", "V", "W", "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "c0", "(Lcom/tencent/raft/standard/net/IRNetwork;)V", "Ljava/lang/String;", "rdInstanceIdentifier", "<set-?>", "Lcom/tencent/rdelivery/util/c;", "y", "()Lcom/tencent/rdelivery/util/c;", "Lcom/tencent/raft/standard/storage/IRStorage;", "i", "()Lcom/tencent/raft/standard/storage/IRStorage;", "commonStorage", "d", "K", "()Ljava/lang/String;", "userId", "e", "l", "customServerUrl", "f", "E", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "logicEnvironment", h.F, "I", "getUpdateInterval", "()I", "updateInterval", UserInfo.SEX_FEMALE, "realUpdateInterval", "Liz3/i;", "j", "Liz3/i;", HippyTKDListViewAdapter.X, "()Liz3/i;", "d0", "(Liz3/i;)V", "localStorageUpdateListener", "Lorg/json/JSONObject;", "k", "Lorg/json/JSONObject;", "G", "()Lorg/json/JSONObject;", "subSystemBizParams", "Liz3/e;", "Liz3/e;", "L", "()Liz3/e;", "usrCustomListener", "Lcom/tencent/rdelivery/net/BaseProto$ServerType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/rdelivery/net/BaseProto$ServerType;", "()Lcom/tencent/rdelivery/net/BaseProto$ServerType;", "customServerType", DomainData.DOMAIN_NAME, "getReportSampling", "reportSampling", "o", BdhLogUtil.LogTag.Tag_Req, "()Z", "p", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "M", "uuid", "r", "reportRecordStorage", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/HashMap;", "fixedAfterHitDataMap", "", "Ljava/util/List;", "listeners", "u", "appId", com.heytap.mcssdk.a.a.f36102l, "w", "bundleId", "systemId", "", "Ljava/util/Map;", "()Ljava/util/Map;", "customProperties", "", "Ljava/util/Set;", "getFixedAfterHitKeys", "()Ljava/util/Set;", "fixedAfterHitKeys", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Integer;", "J", "()Ljava/lang/Integer;", "updateStrategy", "hostAppVersion", BdhLogUtil.LogTag.Tag_Conn, "devModel", "D", "devManufacturer", "androidSystemVersion", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "()Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "pullTarget", "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "()Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "pullDataType", "H", "fixedSceneId", "Liz3/q;", "Liz3/q;", "()Liz3/q;", "subSystemRespListener", "Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "()Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "dataRefreshMode", "Ljava/lang/Boolean;", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Boolean;", "isDebugPackage", "P", "set64Bit", "(Ljava/lang/Boolean;)V", "is64Bit", "enableEncrypt", "enableDetailLog", "()J", "nextFullReqIntervalLimit", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isAPad", "enableMultiProcessDataSync", "businessSetName", "enableBuglyQQCrashReport", "enableClearAllOptimize", "Lcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;", "Lcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;", "dataLoadMode", "getConfigStoreSuffix", "configStoreSuffix", "enableRecordLastRequestTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/rdelivery/net/BaseProto$PullTarget;Lcom/tencent/rdelivery/net/BaseProto$ConfigType;Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/rdelivery/net/BaseProto$ServerType;Liz3/q;Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZJLiz3/e;ZZLjava/lang/String;ZZLcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;Ljava/lang/String;ZLjava/lang/String;)V", "Lcom/tencent/rdelivery/RDeliverySetting$a;", "builder", "(Lcom/tencent/rdelivery/RDeliverySetting$a;)V", "UpdateStrategy", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDeliverySetting {

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private final Integer updateStrategy;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final String hostAppVersion;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String devModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String devManufacturer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String androidSystemVersion;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final BaseProto$PullTarget pullTarget;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final BaseProto$ConfigType pullDataType;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final String fixedSceneId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final q subSystemRespListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final BaseProto$DataRefreshMode dataRefreshMode;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final Boolean isDebugPackage;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Boolean is64Bit;

    /* renamed from: M, reason: from kotlin metadata */
    private final boolean enableEncrypt;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean enableDetailLog;

    /* renamed from: O, reason: from kotlin metadata */
    private final long nextFullReqIntervalLimit;

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean isAPad;

    /* renamed from: Q, reason: from kotlin metadata */
    private final boolean enableMultiProcessDataSync;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private final String businessSetName;

    /* renamed from: S, reason: from kotlin metadata */
    private final boolean enableBuglyQQCrashReport;

    /* renamed from: T, reason: from kotlin metadata */
    private final boolean enableClearAllOptimize;

    /* renamed from: U, reason: from kotlin metadata */
    private final RDeliveryConstant$DataLoadMode dataLoadMode;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final String configStoreSuffix;

    /* renamed from: W, reason: from kotlin metadata */
    private final boolean enableRecordLastRequestTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String rdInstanceIdentifier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.rdelivery.util.c logger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRStorage commonStorage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String userId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String customServerUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qimei;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String logicEnvironment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int updateInterval;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int realUpdateInterval;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i localStorageUpdateListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile JSONObject subSystemBizParams;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile e usrCustomListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseProto$ServerType customServerType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private volatile int reportSampling;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isCfgChangeReport;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean forbidBuglyConnectReport;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uuid;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private IRStorage reportRecordStorage;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, RDeliveryData> fixedAfterHitDataMap;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final List<c> listeners;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appKey;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bundleId;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String systemId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> customProperties;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> fixedAfterHitKeys;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rdelivery/RDeliverySetting$UpdateStrategy;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "START_UP", "PERIODIC", "HOT_RELOAD", "NETWORK_RECONNECT", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum UpdateStrategy {
        START_UP(1),
        PERIODIC(2),
        HOT_RELOAD(4),
        NETWORK_RECONNECT(8);

        private final int value;

        UpdateStrategy(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002J\u001c\u0010\u0015\u001a\u00020\u00002\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u0010\u0010.\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010,J\u0010\u00100\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010/J\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u000201J\u0017\u00106\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\b9\u00107J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u000204J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u000204J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u000204J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010@\u001a\u000204J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010C\u001a\u00020BJ\u0006\u0010F\u001a\u00020ER$\u0010\u0007\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bF\u0010H\u001a\u0004\bI\u0010JR$\u0010\t\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bK\u0010H\u001a\u0004\bL\u0010JR$\u0010\u0011\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bI\u0010H\u001a\u0004\bM\u0010JR$\u0010\u000b\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bL\u0010H\u001a\u0004\bN\u0010JR(\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bO\u0010JR$\u0010\u000f\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bP\u0010H\u001a\u0004\bQ\u0010JR@\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020R2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020R8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR0\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00020W2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020W8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bU\u0010X\u001a\u0004\bY\u0010ZR(\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\\\u0010H\u001a\u0004\b]\u0010JR(\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010G\u001a\u0004\u0018\u00010\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR$\u0010h\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bf\u0010H\u001a\u0004\bg\u0010JR$\u0010 \u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bi\u0010H\u001a\u0004\bj\u0010JR$\u0010\"\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bj\u0010H\u001a\u0004\bi\u0010JR$\u0010$\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bk\u0010H\u001a\u0004\bK\u0010JR(\u0010p\u001a\u0004\u0018\u00010&2\b\u0010G\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR(\u0010v\u001a\u0004\u0018\u00010q2\b\u0010G\u001a\u0004\u0018\u00010q8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR(\u0010|\u001a\u0004\u0018\u00010w2\b\u0010G\u001a\u0004\u0018\u00010w8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R(\u0010\u007f\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b}\u0010H\u001a\u0004\b~\u0010JR,\u0010\u0083\u0001\u001a\u0004\u0018\u00010)2\b\u0010G\u001a\u0004\u0018\u00010)8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0005\b\\\u0010\u0082\u0001R,\u0010\u0087\u0001\u001a\u0004\u0018\u00010,2\b\u0010G\u001a\u0004\u0018\u00010,8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bY\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010\u008a\u0001\u001a\u0002012\u0006\u0010G\u001a\u0002018\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b~\u0010\u0088\u0001\u001a\u0005\bf\u0010\u0089\u0001R,\u0010\u008e\u0001\u001a\u0004\u0018\u0001042\b\u0010G\u001a\u0004\u0018\u0001048\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bg\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u00108\u001a\u0004\u0018\u0001042\b\u0010G\u001a\u0004\u0018\u0001048\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b]\u0010\u008b\u0001\u001a\u0006\b\u008f\u0001\u0010\u008d\u0001R'\u0010\u0092\u0001\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\b\u0090\u0001\u0010=\u001a\u0005\bx\u0010\u0091\u0001R%\u0010:\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0004\bt\u0010=\u001a\u0005\bk\u0010\u0091\u0001R%\u0010<\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0004\bn\u0010=\u001a\u0005\br\u0010\u0091\u0001R*\u0010\u0095\u0001\u001a\u00030\u0093\u00012\u0007\u0010G\u001a\u00030\u0093\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bO\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0094\u0001R+\u0010\u0098\u0001\u001a\u0004\u0018\u00010/2\b\u0010G\u001a\u0004\u0018\u00010/8\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\bz\u0010\u0096\u0001\u001a\u0005\bc\u0010\u0097\u0001R(\u0010\u009a\u0001\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u0085\u0001\u0010=\u001a\u0006\b\u0099\u0001\u0010\u0091\u0001R%\u0010>\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0004\bN\u0010=\u001a\u0005\b}\u0010\u0091\u0001R&\u0010\u009b\u0001\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0004\bd\u0010=\u001a\u0005\bl\u0010\u0091\u0001R&\u0010@\u001a\u0002042\u0006\u0010G\u001a\u0002048\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0004\b`\u0010=\u001a\u0006\b\u0080\u0001\u0010\u0091\u0001R&\u0010C\u001a\u00020B2\u0006\u0010G\u001a\u00020B8\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0005\bQ\u0010\u009c\u0001\u001a\u0005\bb\u0010\u009d\u0001R)\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bc\u0010H\u001a\u0004\bP\u0010JR*\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0005\b\u008f\u0001\u0010H\u001a\u0004\bS\u0010JR*\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\r\n\u0005\b\u0099\u0001\u0010H\u001a\u0004\b^\u0010J\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/tencent/rdelivery/RDeliverySetting$a;", "", "", "name", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "suffix", BdhLogUtil.LogTag.Tag_Req, "appId", "N", com.heytap.mcssdk.a.a.f36102l, "O", "systemId", "k0", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "i0", "userId", "n0", "bundleId", "P", "", "customProperties", ExifInterface.LATITUDE_SOUTH, "logicEnvironment", "g0", "", "updateInterval", "l0", "updateStrategy", "m0", "(Ljava/lang/Integer;)Lcom/tencent/rdelivery/RDeliverySetting$a;", "version", "d0", "devModel", "X", "devManufacturer", "W", "androidSystemVersion", "M", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "target", "h0", "Lcom/tencent/rdelivery/net/BaseProto$ServerType;", "type", "T", "Liz3/q;", "listener", "j0", "Liz3/e;", "c0", "Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "mode", "V", "", "isDebug", "f0", "(Ljava/lang/Boolean;)Lcom/tencent/rdelivery/RDeliverySetting$a;", "is64Bit", "e0", "enableBuglyQQCrashReport", "Y", "enableDetailLog", "Z", "enableMultiProcessDataSync", "a0", "enableRecordLastRequestTime", "b0", "Lcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;", "dataLoadMode", "U", "Lcom/tencent/rdelivery/RDeliverySetting;", "a", "<set-?>", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "d", "e", "E", "B", "f", "H", "", "g", "Ljava/util/Map;", h.F, "()Ljava/util/Map;", "", "Ljava/util/Set;", "u", "()Ljava/util/Set;", "fixedAfterHitKeys", "i", HippyTKDListViewAdapter.X, "j", "Ljava/lang/Integer;", "G", "()Ljava/lang/Integer;", "k", "I", UserInfo.SEX_FEMALE, "()I", "l", "w", "hostAppVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "pullTarget", "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "pullDataType", "Lorg/json/JSONObject;", "r", "Lorg/json/JSONObject;", BdhLogUtil.LogTag.Tag_Conn, "()Lorg/json/JSONObject;", "subSystemBizParams", ReportConstant.COSTREPORT_PREFIX, "v", "fixedSceneId", "t", "Lcom/tencent/rdelivery/net/BaseProto$ServerType;", "()Lcom/tencent/rdelivery/net/BaseProto$ServerType;", "customServerType", "Liz3/q;", "D", "()Liz3/q;", "subSystemRespListener", "Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "()Lcom/tencent/rdelivery/net/BaseProto$DataRefreshMode;", "dataRefreshMode", "Ljava/lang/Boolean;", "L", "()Ljava/lang/Boolean;", "isDebugPackage", "J", "y", "()Z", "enableEncrypt", "", "()J", "nextFullReqIntervalLimit", "Liz3/e;", "()Liz3/e;", "usrCustomListener", "K", "isAPad", "enableClearAllOptimize", "Lcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;", "()Lcom/tencent/rdelivery/util/RDeliveryConstant$DataLoadMode;", "businessSetName", "configStoreSuffix", "customServerUrl", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a {

        /* renamed from: B, reason: from kotlin metadata */
        private long nextFullReqIntervalLimit;

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private e usrCustomListener;

        /* renamed from: D, reason: from kotlin metadata */
        private boolean isAPad;

        /* renamed from: E, reason: from kotlin metadata */
        private boolean enableMultiProcessDataSync;

        /* renamed from: F, reason: from kotlin metadata */
        private boolean enableClearAllOptimize;

        /* renamed from: G, reason: from kotlin metadata */
        private boolean enableRecordLastRequestTime;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private String businessSetName;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private String configStoreSuffix;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private String customServerUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String qimei;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String logicEnvironment;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer updateStrategy;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BaseProto$PullTarget pullTarget;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BaseProto$ConfigType pullDataType;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private JSONObject subSystemBizParams;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String fixedSceneId;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BaseProto$ServerType customServerType;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private q subSystemRespListener;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean isDebugPackage;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean is64Bit;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String appId = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String appKey = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String bundleId = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String systemId = BaseProto$BizSystemID.DEFAULT.getValue();

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String userId = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Map<String, String> customProperties = new LinkedHashMap();

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Set<String> fixedAfterHitKeys = new LinkedHashSet();

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int updateInterval = 14400;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String hostAppVersion = "";

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String devModel = "";

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String devManufacturer = "";

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String androidSystemVersion = "";

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private BaseProto$DataRefreshMode dataRefreshMode = BaseProto$DataRefreshMode.FROM_SERVER;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        private boolean enableEncrypt = true;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        private boolean enableBuglyQQCrashReport = true;

        /* renamed from: A, reason: from kotlin metadata */
        private boolean enableDetailLog = true;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private RDeliveryConstant$DataLoadMode dataLoadMode = RDeliveryConstant$DataLoadMode.INITIAL_LOAD;

        @Nullable
        /* renamed from: A, reason: from getter */
        public final BaseProto$PullTarget getPullTarget() {
            return this.pullTarget;
        }

        @Nullable
        /* renamed from: B, reason: from getter */
        public final String getQimei() {
            return this.qimei;
        }

        @Nullable
        /* renamed from: C, reason: from getter */
        public final JSONObject getSubSystemBizParams() {
            return this.subSystemBizParams;
        }

        @Nullable
        /* renamed from: D, reason: from getter */
        public final q getSubSystemRespListener() {
            return this.subSystemRespListener;
        }

        @NotNull
        /* renamed from: E, reason: from getter */
        public final String getSystemId() {
            return this.systemId;
        }

        /* renamed from: F, reason: from getter */
        public final int getUpdateInterval() {
            return this.updateInterval;
        }

        @Nullable
        /* renamed from: G, reason: from getter */
        public final Integer getUpdateStrategy() {
            return this.updateStrategy;
        }

        @NotNull
        /* renamed from: H, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        @Nullable
        /* renamed from: I, reason: from getter */
        public final e getUsrCustomListener() {
            return this.usrCustomListener;
        }

        @Nullable
        /* renamed from: J, reason: from getter */
        public final Boolean getIs64Bit() {
            return this.is64Bit;
        }

        /* renamed from: K, reason: from getter */
        public final boolean getIsAPad() {
            return this.isAPad;
        }

        @Nullable
        /* renamed from: L, reason: from getter */
        public final Boolean getIsDebugPackage() {
            return this.isDebugPackage;
        }

        @NotNull
        public final a M(@NotNull String androidSystemVersion) {
            Intrinsics.checkParameterIsNotNull(androidSystemVersion, "androidSystemVersion");
            this.androidSystemVersion = androidSystemVersion;
            return this;
        }

        @NotNull
        public final a N(@NotNull String appId) {
            Intrinsics.checkParameterIsNotNull(appId, "appId");
            this.appId = appId;
            return this;
        }

        @NotNull
        public final a O(@NotNull String appKey) {
            Intrinsics.checkParameterIsNotNull(appKey, "appKey");
            this.appKey = appKey;
            return this;
        }

        @NotNull
        public final a P(@NotNull String bundleId) {
            Intrinsics.checkParameterIsNotNull(bundleId, "bundleId");
            this.bundleId = bundleId;
            return this;
        }

        @NotNull
        public final a Q(@NotNull String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            this.businessSetName = name;
            return this;
        }

        @NotNull
        public final a R(@NotNull String suffix) {
            Intrinsics.checkParameterIsNotNull(suffix, "suffix");
            this.configStoreSuffix = suffix;
            return this;
        }

        @NotNull
        public final a S(@Nullable Map<String, String> customProperties) {
            if (customProperties != null) {
                this.customProperties.putAll(customProperties);
            }
            return this;
        }

        @NotNull
        public final a T(@NotNull BaseProto$ServerType type) {
            Intrinsics.checkParameterIsNotNull(type, "type");
            this.customServerType = type;
            return this;
        }

        @NotNull
        public final a U(@NotNull RDeliveryConstant$DataLoadMode dataLoadMode) {
            Intrinsics.checkParameterIsNotNull(dataLoadMode, "dataLoadMode");
            this.dataLoadMode = dataLoadMode;
            return this;
        }

        @NotNull
        public final a V(@NotNull BaseProto$DataRefreshMode mode) {
            Intrinsics.checkParameterIsNotNull(mode, "mode");
            this.dataRefreshMode = mode;
            return this;
        }

        @NotNull
        public final a W(@NotNull String devManufacturer) {
            Intrinsics.checkParameterIsNotNull(devManufacturer, "devManufacturer");
            this.devManufacturer = devManufacturer;
            return this;
        }

        @NotNull
        public final a X(@NotNull String devModel) {
            Intrinsics.checkParameterIsNotNull(devModel, "devModel");
            this.devModel = devModel;
            return this;
        }

        @NotNull
        public final a Y(boolean enableBuglyQQCrashReport) {
            this.enableBuglyQQCrashReport = enableBuglyQQCrashReport;
            return this;
        }

        @NotNull
        public final a Z(boolean enableDetailLog) {
            this.enableDetailLog = enableDetailLog;
            return this;
        }

        @NotNull
        public final RDeliverySetting a() {
            return new RDeliverySetting(this, null);
        }

        @NotNull
        public final a a0(boolean enableMultiProcessDataSync) {
            this.enableMultiProcessDataSync = enableMultiProcessDataSync;
            return this;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getAndroidSystemVersion() {
            return this.androidSystemVersion;
        }

        @NotNull
        public final a b0(boolean enableRecordLastRequestTime) {
            this.enableRecordLastRequestTime = enableRecordLastRequestTime;
            return this;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        public final a c0(@Nullable e listener) {
            this.usrCustomListener = listener;
            return this;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getAppKey() {
            return this.appKey;
        }

        @NotNull
        public final a d0(@NotNull String version) {
            Intrinsics.checkParameterIsNotNull(version, "version");
            this.hostAppVersion = version;
            return this;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getBundleId() {
            return this.bundleId;
        }

        @NotNull
        public final a e0(@Nullable Boolean is64Bit) {
            this.is64Bit = is64Bit;
            return this;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getBusinessSetName() {
            return this.businessSetName;
        }

        @NotNull
        public final a f0(@Nullable Boolean isDebug) {
            this.isDebugPackage = isDebug;
            return this;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getConfigStoreSuffix() {
            return this.configStoreSuffix;
        }

        @NotNull
        public final a g0(@Nullable String logicEnvironment) {
            this.logicEnvironment = logicEnvironment;
            return this;
        }

        @NotNull
        public final Map<String, String> h() {
            return this.customProperties;
        }

        @NotNull
        public final a h0(@NotNull BaseProto$PullTarget target) {
            Intrinsics.checkParameterIsNotNull(target, "target");
            this.pullTarget = target;
            return this;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final BaseProto$ServerType getCustomServerType() {
            return this.customServerType;
        }

        @NotNull
        public final a i0(@Nullable String qimei) {
            this.qimei = qimei;
            return this;
        }

        @Nullable
        /* renamed from: j, reason: from getter */
        public final String getCustomServerUrl() {
            return this.customServerUrl;
        }

        @NotNull
        public final a j0(@Nullable q listener) {
            this.subSystemRespListener = listener;
            return this;
        }

        @NotNull
        /* renamed from: k, reason: from getter */
        public final RDeliveryConstant$DataLoadMode getDataLoadMode() {
            return this.dataLoadMode;
        }

        @NotNull
        public final a k0(@NotNull String systemId) {
            Intrinsics.checkParameterIsNotNull(systemId, "systemId");
            this.systemId = systemId;
            return this;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final BaseProto$DataRefreshMode getDataRefreshMode() {
            return this.dataRefreshMode;
        }

        @NotNull
        public final a l0(int updateInterval) {
            this.updateInterval = updateInterval;
            return this;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final String getDevManufacturer() {
            return this.devManufacturer;
        }

        @NotNull
        public final a m0(@Nullable Integer updateStrategy) {
            this.updateStrategy = updateStrategy;
            return this;
        }

        @NotNull
        /* renamed from: n, reason: from getter */
        public final String getDevModel() {
            return this.devModel;
        }

        @NotNull
        public final a n0(@NotNull String userId) {
            Intrinsics.checkParameterIsNotNull(userId, "userId");
            this.userId = userId;
            return this;
        }

        /* renamed from: o, reason: from getter */
        public final boolean getEnableBuglyQQCrashReport() {
            return this.enableBuglyQQCrashReport;
        }

        /* renamed from: p, reason: from getter */
        public final boolean getEnableClearAllOptimize() {
            return this.enableClearAllOptimize;
        }

        /* renamed from: q, reason: from getter */
        public final boolean getEnableDetailLog() {
            return this.enableDetailLog;
        }

        /* renamed from: r, reason: from getter */
        public final boolean getEnableEncrypt() {
            return this.enableEncrypt;
        }

        /* renamed from: s, reason: from getter */
        public final boolean getEnableMultiProcessDataSync() {
            return this.enableMultiProcessDataSync;
        }

        /* renamed from: t, reason: from getter */
        public final boolean getEnableRecordLastRequestTime() {
            return this.enableRecordLastRequestTime;
        }

        @NotNull
        public final Set<String> u() {
            return this.fixedAfterHitKeys;
        }

        @Nullable
        /* renamed from: v, reason: from getter */
        public final String getFixedSceneId() {
            return this.fixedSceneId;
        }

        @NotNull
        /* renamed from: w, reason: from getter */
        public final String getHostAppVersion() {
            return this.hostAppVersion;
        }

        @Nullable
        /* renamed from: x, reason: from getter */
        public final String getLogicEnvironment() {
            return this.logicEnvironment;
        }

        /* renamed from: y, reason: from getter */
        public final long getNextFullReqIntervalLimit() {
            return this.nextFullReqIntervalLimit;
        }

        @Nullable
        /* renamed from: z, reason: from getter */
        public final BaseProto$ConfigType getPullDataType() {
            return this.pullDataType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rdelivery/RDeliverySetting$c;", "", "", "softInterval", "hardInterval", "", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface c {
        void a(long softInterval, long hardInterval);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/rdelivery/RDeliverySetting$d", "Lcom/tencent/rdelivery/net/d$b;", "", "reason", "", "onFail", "onSuccess", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class d implements d.b {
        d() {
        }

        @Override // com.tencent.rdelivery.net.d.b
        public void onFail(@Nullable String reason) {
            com.tencent.rdelivery.util.c logger = RDeliverySetting.this.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "reportSavedPullEventReportRecord doReportPullEvent onFail,reason = " + reason, false, 4, null);
            }
        }

        @Override // com.tencent.rdelivery.net.d.b
        public void onSuccess() {
            com.tencent.rdelivery.util.c logger = RDeliverySetting.this.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_Reporter", "reportSavedPullEventReportRecord doReportPullEvent onSuccess", false, 4, null);
            }
        }
    }

    public /* synthetic */ RDeliverySetting(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    /* renamed from: A, reason: from getter */
    public final long getNextFullReqIntervalLimit() {
        return this.nextFullReqIntervalLimit;
    }

    @Nullable
    public final RDeliveryData B(@NotNull String key, @Nullable RDeliveryData data) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (!this.fixedAfterHitKeys.contains(key)) {
            return data;
        }
        synchronized (this.fixedAfterHitDataMap) {
            if (this.fixedAfterHitDataMap.containsKey(key)) {
                data = this.fixedAfterHitDataMap.get(key);
                Unit unit = Unit.INSTANCE;
            } else {
                this.fixedAfterHitDataMap.put(key, data);
            }
        }
        return data;
    }

    @Nullable
    /* renamed from: C, reason: from getter */
    public final BaseProto$ConfigType getPullDataType() {
        return this.pullDataType;
    }

    @Nullable
    /* renamed from: D, reason: from getter */
    public final BaseProto$PullTarget getPullTarget() {
        return this.pullTarget;
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final String getQimei() {
        return this.qimei;
    }

    /* renamed from: F, reason: from getter */
    public final int getRealUpdateInterval() {
        return this.realUpdateInterval;
    }

    @Nullable
    /* renamed from: G, reason: from getter */
    public final JSONObject getSubSystemBizParams() {
        return this.subSystemBizParams;
    }

    @Nullable
    /* renamed from: H, reason: from getter */
    public final q getSubSystemRespListener() {
        return this.subSystemRespListener;
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public final String getSystemId() {
        return this.systemId;
    }

    @Nullable
    /* renamed from: J, reason: from getter */
    public final Integer getUpdateStrategy() {
        return this.updateStrategy;
    }

    @NotNull
    /* renamed from: K, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final e getUsrCustomListener() {
        return this.usrCustomListener;
    }

    @Nullable
    /* renamed from: M, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public final void N(@Nullable IRStorage irStorage) {
        this.commonStorage = irStorage;
    }

    public final synchronized void O(@NotNull Context context) {
        String str;
        IRStorage iRStorage;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!TextUtils.isEmpty(this.uuid)) {
            com.tencent.rdelivery.util.c cVar = this.logger;
            if (cVar != null) {
                com.tencent.rdelivery.util.c.b(cVar, "RDeliverySetting", "initUUID return for inited", false, 4, null);
            }
            return;
        }
        IRStorage iRStorage2 = this.commonStorage;
        if (iRStorage2 == null || (str = iRStorage2.getString("RdeliveryUuid", "")) == null) {
            str = "";
        }
        if (Intrinsics.areEqual(str, "")) {
            String string = context.getSharedPreferences("rdelivery_sp_file", 4).getString("rdelivery_uuid", "");
            if (string == null) {
                string = "";
            }
            str = string;
            if (!TextUtils.isEmpty(str) && (iRStorage = this.commonStorage) != null) {
                iRStorage.putString("RdeliveryUuid", str);
            }
            com.tencent.rdelivery.util.c cVar2 = this.logger;
            if (cVar2 != null) {
                com.tencent.rdelivery.util.c.b(cVar2, "RDeliverySetting", "initUUID id from sp: " + str, false, 4, null);
            }
        }
        if (Intrinsics.areEqual(str, "")) {
            com.tencent.rdelivery.util.c cVar3 = this.logger;
            if (cVar3 != null) {
                com.tencent.rdelivery.util.c.b(cVar3, "RDeliverySetting", "initUUID id is empty", false, 4, null);
            }
            str = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
            IRStorage iRStorage3 = this.commonStorage;
            if (iRStorage3 != null) {
                iRStorage3.putString("RdeliveryUuid", str);
            }
        }
        this.uuid = str;
        com.tencent.rdelivery.util.c cVar4 = this.logger;
        if (cVar4 != null) {
            com.tencent.rdelivery.util.c.f(cVar4, "RDeliverySetting", "initUUID uuid = " + this.uuid, false, 4, null);
        }
    }

    @Nullable
    /* renamed from: P, reason: from getter */
    public final Boolean getIs64Bit() {
        return this.is64Bit;
    }

    /* renamed from: Q, reason: from getter */
    public final boolean getIsAPad() {
        return this.isAPad;
    }

    /* renamed from: R, reason: from getter */
    public final boolean getIsCfgChangeReport() {
        return this.isCfgChangeReport;
    }

    @Nullable
    /* renamed from: S, reason: from getter */
    public final Boolean getIsDebugPackage() {
        return this.isDebugPackage;
    }

    /* renamed from: T, reason: from getter */
    public final boolean getEnableBuglyQQCrashReport() {
        return this.enableBuglyQQCrashReport;
    }

    /* renamed from: U, reason: from getter */
    public final boolean getEnableEncrypt() {
        return this.enableEncrypt;
    }

    public final boolean V() {
        if (this.dataLoadMode == RDeliveryConstant$DataLoadMode.LAZY_LOAD) {
            return true;
        }
        return false;
    }

    public final boolean W() {
        if (this.dataRefreshMode == BaseProto$DataRefreshMode.FROM_SERVER) {
            return true;
        }
        return false;
    }

    public final boolean X() {
        if (Intrinsics.areEqual(this.systemId, BaseProto$BizSystemID.TAB.getValue()) && !TextUtils.isEmpty(this.fixedSceneId)) {
            return true;
        }
        return false;
    }

    public final void Y(boolean forbidBuglyConnectReport) {
        this.forbidBuglyConnectReport = forbidBuglyConnectReport;
    }

    public final void Z(boolean isCfgChangeReport) {
        com.tencent.rdelivery.util.c cVar = this.logger;
        if (cVar != null) {
            cVar.a(com.tencent.rdelivery.util.d.a("RDelivery_SendNetRequestTask", getRdInstanceIdentifier()), "onGetIsCfgChangeReportFromServer isCfgChangeReport = " + isCfgChangeReport, this.enableDetailLog);
        }
        this.isCfgChangeReport = isCfgChangeReport;
    }

    public final void a(@NotNull c listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listeners.add(listener);
    }

    public final void a0(int sampling) {
        this.reportSampling = sampling;
    }

    @NotNull
    public final String b() {
        String str = this.appId + "_" + this.systemId + "_" + this.logicEnvironment + "_" + this.userId;
        if (this.pullTarget != null) {
            str = str + "_" + this.pullTarget;
        }
        if (this.pullDataType != null) {
            str = str + "_" + this.pullDataType;
        }
        if (this.fixedSceneId != null) {
            str = str + "_" + this.fixedSceneId;
        }
        if (this.configStoreSuffix != null) {
            str = str + "_" + this.configStoreSuffix;
        }
        com.tencent.rdelivery.util.c cVar = this.logger;
        if (cVar != null) {
            cVar.a(com.tencent.rdelivery.util.d.a("RDeliverySetting", getRdInstanceIdentifier()), "generateDataStorageId " + str, this.enableDetailLog);
        }
        return str;
    }

    public final void b0(long softInterval, long hardInterval) {
        com.tencent.rdelivery.util.c cVar = this.logger;
        if (cVar != null) {
            cVar.a(com.tencent.rdelivery.util.d.a("RDeliverySetting", getRdInstanceIdentifier()), "onGetUpdateIntervalFromServer " + softInterval + ", " + hardInterval, this.enableDetailLog);
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(softInterval, hardInterval);
        }
    }

    @NotNull
    public final String c() {
        String str = this.appId + "_" + this.systemId + "_";
        if (this.pullTarget != null) {
            str = str + "_" + this.pullTarget;
        }
        if (this.pullDataType != null) {
            str = str + "_" + this.pullDataType;
        }
        if (this.fixedSceneId != null) {
            str = str + "_" + this.fixedSceneId;
        }
        if (this.configStoreSuffix != null) {
            return str + "_" + this.configStoreSuffix;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c0(@Nullable IRNetwork netInterface) {
        String[] strArr;
        String str;
        JSONObject jSONObject;
        boolean z16;
        boolean startsWith$default;
        IRStorage iRStorage = this.reportRecordStorage;
        if (iRStorage != null) {
            strArr = iRStorage.allKeys();
        } else {
            strArr = null;
        }
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str2 : strArr) {
                if (str2 != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "rp_record_key_", false, 2, null);
                    if (startsWith$default) {
                        z16 = true;
                        if (!z16) {
                            arrayList.add(str2);
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            for (String str3 : arrayList) {
                com.tencent.rdelivery.util.c cVar = this.logger;
                if (cVar != null) {
                    cVar.a(com.tencent.rdelivery.util.d.a("RDeliverySetting", getRdInstanceIdentifier()), "reportSavedPullEventReportRecord it key = " + str3, this.enableDetailLog);
                }
                IRStorage iRStorage2 = this.reportRecordStorage;
                if (iRStorage2 != null) {
                    str = iRStorage2.getString(str3, null);
                } else {
                    str = null;
                }
                IRStorage iRStorage3 = this.reportRecordStorage;
                if (iRStorage3 != null) {
                    iRStorage3.remove(str3);
                }
                if (str != null) {
                    try {
                        jSONObject = new JSONObject(str);
                        try {
                            Unit unit = Unit.INSTANCE;
                        } catch (Exception e16) {
                            e = e16;
                            com.tencent.rdelivery.util.c cVar2 = this.logger;
                            if (cVar2 != null) {
                                cVar2.d(com.tencent.rdelivery.util.d.a("RDeliverySetting", getRdInstanceIdentifier()), "reportSavedPullEventReportRecord Exception", e);
                                Unit unit2 = Unit.INSTANCE;
                            }
                            if (jSONObject == null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        jSONObject = null;
                    }
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    jSONArray.mo162put(jSONObject);
                }
            }
        }
        com.tencent.rdelivery.util.c cVar3 = this.logger;
        if (cVar3 != null) {
            cVar3.a(com.tencent.rdelivery.util.d.a("RDeliverySetting", getRdInstanceIdentifier()), "reportSavedPullEventReportRecord jsonArray.length() = " + jSONArray.length(), this.enableDetailLog);
        }
        if (jSONArray.length() > 0) {
            d.Companion companion = com.tencent.rdelivery.net.d.INSTANCE;
            companion.b(companion.a(jSONArray, new d()), netInterface, this);
        }
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAndroidSystemVersion() {
        return this.androidSystemVersion;
    }

    public final void d0(@Nullable i iVar) {
        this.localStorageUpdateListener = iVar;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final void e0(@Nullable com.tencent.rdelivery.util.c logger) {
        this.logger = logger;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    public final synchronized void f0(@NotNull String key, @Nullable String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.customProperties.put(key, value);
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getBundleId() {
        return this.bundleId;
    }

    public final void g0(@NotNull String newUserId) {
        Intrinsics.checkParameterIsNotNull(newUserId, "newUserId");
        this.userId = newUserId;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getBusinessSetName() {
        return this.businessSetName;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final IRStorage getCommonStorage() {
        return this.commonStorage;
    }

    @NotNull
    public final Map<String, String> j() {
        return this.customProperties;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final BaseProto$ServerType getCustomServerType() {
        return this.customServerType;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getCustomServerUrl() {
        return this.customServerUrl;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final BaseProto$DataRefreshMode getDataRefreshMode() {
        return this.dataRefreshMode;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getDevManufacturer() {
        return this.devManufacturer;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getDevModel() {
        return this.devModel;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getEnableClearAllOptimize() {
        return this.enableClearAllOptimize;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getEnableDetailLog() {
        return this.enableDetailLog;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getEnableMultiProcessDataSync() {
        return this.enableMultiProcessDataSync;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getEnableRecordLastRequestTime() {
        return this.enableRecordLastRequestTime;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final String getRdInstanceIdentifier() {
        return this.rdInstanceIdentifier;
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final String getFixedSceneId() {
        return this.fixedSceneId;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getForbidBuglyConnectReport() {
        return this.forbidBuglyConnectReport;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final String getHostAppVersion() {
        return this.hostAppVersion;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final i getLocalStorageUpdateListener() {
        return this.localStorageUpdateListener;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final com.tencent.rdelivery.util.c getLogger() {
        return this.logger;
    }

    @Nullable
    /* renamed from: z, reason: from getter */
    public final String getLogicEnvironment() {
        return this.logicEnvironment;
    }

    RDeliverySetting(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Set<String> set, String str7, Integer num, int i3, String str8, String str9, String str10, String str11, BaseProto$PullTarget baseProto$PullTarget, BaseProto$ConfigType baseProto$ConfigType, JSONObject jSONObject, String str12, BaseProto$ServerType baseProto$ServerType, q qVar, BaseProto$DataRefreshMode baseProto$DataRefreshMode, Boolean bool, Boolean bool2, boolean z16, boolean z17, long j3, e eVar, boolean z18, boolean z19, String str13, boolean z26, boolean z27, RDeliveryConstant$DataLoadMode rDeliveryConstant$DataLoadMode, String str14, boolean z28, String str15) {
        int coerceAtLeast;
        this.appId = str;
        this.appKey = str2;
        this.bundleId = str3;
        this.systemId = str4;
        this.customProperties = map;
        this.fixedAfterHitKeys = set;
        this.updateStrategy = num;
        this.hostAppVersion = str8;
        this.devModel = str9;
        this.devManufacturer = str10;
        this.androidSystemVersion = str11;
        this.pullTarget = baseProto$PullTarget;
        this.pullDataType = baseProto$ConfigType;
        this.fixedSceneId = str12;
        this.subSystemRespListener = qVar;
        this.dataRefreshMode = baseProto$DataRefreshMode;
        this.isDebugPackage = bool;
        this.is64Bit = bool2;
        this.enableEncrypt = z16;
        this.enableDetailLog = z17;
        this.nextFullReqIntervalLimit = j3;
        this.isAPad = z18;
        this.enableMultiProcessDataSync = z19;
        this.businessSetName = str13;
        this.enableBuglyQQCrashReport = z26;
        this.enableClearAllOptimize = z27;
        this.dataLoadMode = rDeliveryConstant$DataLoadMode;
        this.configStoreSuffix = str14;
        this.enableRecordLastRequestTime = z28;
        this.userId = "";
        this.updateInterval = 14400;
        this.realUpdateInterval = 14400;
        this.reportSampling = 10;
        this.isCfgChangeReport = true;
        this.fixedAfterHitDataMap = new HashMap<>();
        this.listeners = new CopyOnWriteArrayList();
        this.userId = str6;
        this.logicEnvironment = str7;
        this.updateInterval = i3;
        this.subSystemBizParams = jSONObject;
        this.usrCustomListener = eVar;
        this.customServerType = baseProto$ServerType;
        this.customServerUrl = str15;
        this.qimei = str5;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 600);
        this.realUpdateInterval = coerceAtLeast;
        this.rdInstanceIdentifier = c();
    }

    RDeliverySetting(a aVar) {
        this(aVar.getAppId(), aVar.getAppKey(), aVar.getBundleId(), aVar.getSystemId(), aVar.getQimei(), aVar.getUserId(), aVar.h(), aVar.u(), aVar.getLogicEnvironment(), aVar.getUpdateStrategy(), aVar.getUpdateInterval(), aVar.getHostAppVersion(), aVar.getDevModel(), aVar.getDevManufacturer(), aVar.getAndroidSystemVersion(), aVar.getPullTarget(), aVar.getPullDataType(), aVar.getSubSystemBizParams(), aVar.getFixedSceneId(), aVar.getCustomServerType(), aVar.getSubSystemRespListener(), aVar.getDataRefreshMode(), aVar.getIsDebugPackage(), aVar.getIs64Bit(), aVar.getEnableEncrypt(), aVar.getEnableDetailLog(), aVar.getNextFullReqIntervalLimit(), aVar.getUsrCustomListener(), aVar.getIsAPad(), aVar.getEnableMultiProcessDataSync(), aVar.getBusinessSetName(), aVar.getEnableBuglyQQCrashReport(), aVar.getEnableClearAllOptimize(), aVar.getDataLoadMode(), aVar.getConfigStoreSuffix(), aVar.getEnableRecordLastRequestTime(), aVar.getCustomServerUrl());
    }
}
