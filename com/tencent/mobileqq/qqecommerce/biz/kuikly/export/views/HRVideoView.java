package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.base.video.ECQFSVideoView;
import com.tencent.mobileqq.qqecommerce.base.video.ECVideoInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.RLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u00b0\u0001\u00b1\u0001B\u0013\u0012\b\u0010\u00ad\u0001\u001a\u00030\u00ac\u0001\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J5\u0010\u001e\u001a\u00020\u00072+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0002J5\u0010\u001f\u001a\u00020\u00072+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0002J5\u0010 \u001a\u00020\u00072+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0002J5\u0010!\u001a\u00020\u00072+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002JD\u00106\u001a\u00020\u00072:\u0010\u001d\u001a6\u0012\u0013\u0012\u001102\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000701j\u0002`5H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0018\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050;*\u00020'H\u0002J\u0018\u0010?\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0007H\u0014J\b\u0010A\u001a\u00020\u0007H\u0014JI\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010B\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cH\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\u0006\u0010F\u001a\u00020EJ*\u0010L\u001a\u00020\u00072\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020E2\b\u0010K\u001a\u0004\u0018\u00010\u0018H\u0016J*\u0010Q\u001a\u00020\u00072\u0006\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020G2\b\u0010P\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010R\u001a\u00020\u0007H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J\b\u0010T\u001a\u00020\u0007H\u0016J\u001a\u0010Y\u001a\u00020\u00072\u0006\u0010V\u001a\u00020U2\b\u0010X\u001a\u0004\u0018\u00010WH\u0016J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010V\u001a\u00020U2\u0006\u0010^\u001a\u00020WH\u0016J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016J\b\u0010a\u001a\u00020\u0012H\u0016J\b\u0010b\u001a\u00020\u0012H\u0016R\u0014\u0010e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR(\u0010n\u001a\u0004\u0018\u00010#2\b\u0010i\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010gR\u0016\u0010r\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010gR\u0016\u0010t\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010fR\u0016\u0010v\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010gR\u0016\u0010x\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010gR\u0016\u0010z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010gR\u0016\u0010|\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010jR\u0016\u0010~\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010gR=\u0010\u0081\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R>\u0010\u0083\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R>\u0010\u0085\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0080\u0001R>\u0010\u0087\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0080\u0001R>\u0010\u0089\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0080\u0001R\u001a\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008e\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0097\u0002\u0010\u0094\u0001\u001a\u00ff\u0001\u0012w\u0012u\u0012\u0013\u0012\u001102\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0007 \u0090\u0001*:\u0012\u0013\u0012\u001102\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0007\u0018\u000101j\u0004\u0018\u0001`501j\u0002`5 \u0090\u0001*~\u0012w\u0012u\u0012\u0013\u0012\u001102\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0007 \u0090\u0001*:\u0012\u0013\u0012\u001102\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0007\u0018\u000101j\u0004\u0018\u0001`501j\u0002`5\u0018\u00010\u0091\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001a\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u00a0\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010\u00a2\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010dR\u0018\u0010\u00a4\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010gR\u0018\u0010\u00a6\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010gR\u0018\u0010\u00a8\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u0010gR\u0017\u0010\u00ab\u0001\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/HRVideoView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Lcom/tencent/mobileqq/qqecommerce/base/video/d;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/tencent/mobileqq/qqecommerce/base/video/e;", "", "params", "", "E0", "y0", "x0", "l0", "m0", "F0", "M0", "D0", "C0", "P0", "", "isActivityDestroy", "G0", "I0", "N0", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "v0", "s0", "t0", "u0", "src", "Lcom/tencent/mobileqq/qqecommerce/base/video/c;", "p0", "n0", "url", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "o0", "path", "A0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/HRVideoView$VideoState;", "newState", "B0", "R0", "J0", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/qqecommerce/base/video/f;", "player", "info", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/WithPlayerCallback;", "S0", "L0", "z0", "Landroid/app/Application;", "q0", "Ljava/util/HashMap;", "Q0", "propKey", "value", "b", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "r0", "", "what", "arg1", "arg2", "obj", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extInfo", "onError", "onComplete", "onSeekComplete", "onPrepared", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "g", "d", "H", "Ljava/lang/String;", "tag", "I", "Z", "attached", "<set-?>", "J", "Lcom/tencent/mobileqq/qqecommerce/base/video/c;", "w0", "()Lcom/tencent/mobileqq/qqecommerce/base/video/c;", QCircleScheme.AttrDetail.VIDEO_INFO, "K", "mute", "L", "loop", "M", "resize", "N", "hadPreloadSuccess", "P", "hadTranslatePb", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "needStartWhenPrepared", BdhLogUtil.LogTag.Tag_Req, "lastPlayPos", ExifInterface.LATITUDE_SOUTH, "isOfflineSrc", "T", "Lkotlin/jvm/functions/Function1;", "infoCallback", "U", "errorCallback", "V", "completeCallback", "W", "stateChangeCallback", "a0", "progressUpdateCallback", "b0", "Lcom/tencent/mobileqq/qqecommerce/base/video/f;", "c0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/HRVideoView$VideoState;", "videoState", "", "kotlin.jvm.PlatformType", "", "d0", "Ljava/util/Set;", "callbackQueue", "Landroid/os/Handler;", "e0", "Landroid/os/Handler;", "uiHandler", "Ljava/lang/Runnable;", "f0", "Ljava/lang/Runnable;", "updateProgressTask", "Landroid/widget/ImageView;", "g0", "Landroid/widget/ImageView;", "cover", "h0", "coverUrl", "i0", "isActivityResume", "j0", "hadRelease", "k0", "hadDestroy", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "VideoState", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HRVideoView extends KRView implements com.tencent.mobileqq.qqecommerce.base.video.d, Application.ActivityLifecycleCallbacks, com.tencent.mobileqq.qqecommerce.base.video.e {

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m0, reason: collision with root package name */
    private static final List<Integer> f263084m0;

    /* renamed from: H, reason: from kotlin metadata */
    private final String tag;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean attached;

    /* renamed from: J, reason: from kotlin metadata */
    private ECVideoInfo videoInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mute;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean loop;

    /* renamed from: M, reason: from kotlin metadata */
    private int resize;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hadPreloadSuccess;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hadTranslatePb;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needStartWhenPrepared;

    /* renamed from: R, reason: from kotlin metadata */
    private long lastPlayPos;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isOfflineSrc;

    /* renamed from: T, reason: from kotlin metadata */
    private Function1<Object, Unit> infoCallback;

    /* renamed from: U, reason: from kotlin metadata */
    private Function1<Object, Unit> errorCallback;

    /* renamed from: V, reason: from kotlin metadata */
    private Function1<Object, Unit> completeCallback;

    /* renamed from: W, reason: from kotlin metadata */
    private Function1<Object, Unit> stateChangeCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> progressUpdateCallback;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.base.video.f player;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private VideoState videoState;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Set<Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>> callbackQueue;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private Runnable updateProgressTask;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ImageView cover;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String coverUrl;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isActivityResume;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean hadRelease;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/HRVideoView$VideoState;", "", "state", "", "(Ljava/lang/String;II)V", "IDLE", "PREPARING", "PLAYING", "PAUSED", "COMPLETE", RLog.ERROR, "BUFFERING", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum VideoState {
        IDLE(0),
        PREPARING(6),
        PLAYING(1),
        PAUSED(2),
        COMPLETE(3),
        ERROR(4),
        BUFFERING(5);

        public final int state;

        VideoState(int i3) {
            this.state = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b%\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u000bR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0016R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0016R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0014\u0010,\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u000bR\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0016R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0016R\u0014\u0010/\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u000bR\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0016R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0016R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0016R\u0014\u00104\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b4\u0010\u000b\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/HRVideoView$a;", "", "", "d", "Landroid/widget/ImageView$ScaleType;", "c", "", "DEFAULT_PROGRESS_UPDATE_INTERVAL", "J", "", "EVENT_COMPLETE", "Ljava/lang/String;", "EVENT_ERROR", "EVENT_INFO", "EVENT_PROGRESS_UPDATE", "EVENT_SEEK_COMPLETE", "EVENT_STATE_CHANGED", "FEED_PB_CLASS_NAME", "", "INFO_LIST", "Ljava/util/List;", "INFO_SEEK_COMPLETE", "I", "LOOP", "METHOD_GET_CURRENT_POS", "METHOD_GET_DURATION", "METHOD_GET_FILE_SIZE", "METHOD_GET_STATE", "METHOD_PAUSE", "METHOD_PLAY", "METHOD_PREDOWNLOAD", "METHOD_PREPLAY", "METHOD_RELEASE", "METHOD_SEEK", "METHOD_STOP", "MUTE", "PLAYER_INFO_BUFFERING_END", "PLAYER_INFO_BUFFERING_START", "PLAYER_INFO_CURRENT_LOOP_END", "PLAYER_INFO_CURRENT_LOOP_START", "PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED", "PLAYER_SCALE_BOTH_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_RATIO", "RESIZE", "RESIZE_CONTAIN", "RESIZE_COVER", "SRC", "SUPER_STATE_ERROR", "SUPER_STATE_IDLE", "SUPER_STATE_RELEASED", "SUPER_STATE_UNKNOW", "VIEW_NAME", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i3) {
            if (i3 == 1 || i3 != 2) {
                return 0;
            }
            return 2;
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageView.ScaleType c(int i3) {
            if (i3 == 1) {
                return ImageView.ScaleType.CENTER;
            }
            if (i3 != 2) {
                return ImageView.ScaleType.CENTER;
            }
            return ImageView.ScaleType.CENTER_CROP;
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{105, 107, 108, 112, 113});
        f263084m0 = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HRVideoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "HRVideoView[" + hashCode() + "]";
        this.tag = str;
        this.lastPlayPos = -1L;
        this.videoState = VideoState.IDLE;
        this.callbackQueue = Collections.newSetFromMap(new ConcurrentHashMap());
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.cover = new ImageView(context);
        this.coverUrl = "";
        this.isActivityResume = true;
        QLog.d(str, 1, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        setKeepScreenOn(true);
        addView(this.cover, -1, -1);
        this.updateProgressTask = new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.b
            @Override // java.lang.Runnable
            public final void run() {
                HRVideoView.N(HRVideoView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(VideoState newState) {
        Map mapOf;
        VideoState videoState = this.videoState;
        this.videoState = newState;
        QLog.i(this.tag, 1, "onStateChange oldState=" + videoState + "\uff0cnewState=" + newState);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("state", Integer.valueOf(this.videoState.state)));
        Function1<Object, Unit> function1 = this.stateChangeCallback;
        if (function1 != null) {
            function1.invoke(mapOf);
        }
        if (newState == VideoState.PLAYING) {
            this.uiHandler.removeCallbacks(this.updateProgressTask);
            this.uiHandler.post(this.updateProgressTask);
            if (this.mute) {
                return;
            }
            J0();
            return;
        }
        if (newState == VideoState.ERROR || newState == VideoState.IDLE) {
            this.uiHandler.removeCallbacks(this.updateProgressTask);
        }
    }

    private final void C0() {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$pause$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                HRVideoView.this.B0(HRVideoView.VideoState.PAUSED);
                HRVideoView.this.needStartWhenPrepared = false;
                player.pause();
            }
        });
    }

    private final void D0() {
        QLog.i(this.tag, 1, "play");
        l0();
        m0();
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$play$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                HRVideoView.VideoState videoState;
                String str;
                String str2;
                String str3;
                boolean z16;
                String str4;
                String str5;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                videoState = HRVideoView.this.videoState;
                HRVideoView.VideoState videoState2 = HRVideoView.VideoState.PREPARING;
                if (videoState == videoState2) {
                    if (info.getIsPreload()) {
                        z16 = HRVideoView.this.hadPreloadSuccess;
                        if (z16) {
                            str5 = HRVideoView.this.tag;
                            QLog.i(str5, 1, "play to start preload video");
                            HRVideoView.this.M0();
                            return;
                        } else {
                            str4 = HRVideoView.this.tag;
                            QLog.i(str4, 1, "play to wait preload video");
                            return;
                        }
                    }
                    str3 = HRVideoView.this.tag;
                    QLog.i(str3, 1, "play to wait preparing video");
                    return;
                }
                if (videoState == HRVideoView.VideoState.IDLE) {
                    HRVideoView.this.needStartWhenPrepared = true;
                    str2 = HRVideoView.this.tag;
                    QLog.i(str2, 1, "play to open video");
                    HRVideoView.this.B0(videoState2);
                    final HRVideoView hRVideoView = HRVideoView.this;
                    ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$play$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ImageView imageView;
                            imageView = HRVideoView.this.cover;
                            imageView.setVisibility(0);
                        }
                    });
                    player.b(info);
                    HRVideoView.this.hadRelease = false;
                    return;
                }
                if (videoState == HRVideoView.VideoState.PAUSED || videoState == HRVideoView.VideoState.COMPLETE) {
                    str = HRVideoView.this.tag;
                    QLog.i(str, 1, "play to restart");
                    HRVideoView.this.M0();
                }
            }
        });
    }

    private final void E0(String params) {
        String feedPb;
        final String optString = new JSONObject(params).optString("pageId");
        ECVideoInfo eCVideoInfo = this.videoInfo;
        if (eCVideoInfo == null || (feedPb = eCVideoInfo.getFeedPb()) == null) {
            return;
        }
        pg2.a.f426173a.a(feedPb, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$predownload$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                invoke2(messageMicro);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageMicro<?> pb5) {
                Intrinsics.checkNotNullParameter(pb5, "pb");
                IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                if (qCircleApi != null) {
                    String pageId = optString;
                    Intrinsics.checkNotNullExpressionValue(pageId, "pageId");
                    qCircleApi.preDownloadVideo(pb5, pageId);
                }
            }
        });
    }

    private final void F0() {
        QLog.i(this.tag, 1, "preplay");
        l0();
        m0();
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$preplay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                String str;
                HRVideoView.VideoState videoState;
                String str2;
                HRVideoView.VideoState videoState2;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                str = HRVideoView.this.tag;
                QLog.i(str, 1, "preplay");
                videoState = HRVideoView.this.videoState;
                if (videoState != HRVideoView.VideoState.IDLE) {
                    str2 = HRVideoView.this.tag;
                    videoState2 = HRVideoView.this.videoState;
                    QLog.i(str2, 1, "preplay state error, state=" + videoState2);
                    HRVideoView.this.P0();
                }
                HRVideoView.this.B0(HRVideoView.VideoState.PREPARING);
                HRVideoView.this.hadPreloadSuccess = false;
                HRVideoView.this.needStartWhenPrepared = false;
                info.m(true);
                final HRVideoView hRVideoView = HRVideoView.this;
                ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$preplay$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ImageView imageView;
                        imageView = HRVideoView.this.cover;
                        imageView.setVisibility(0);
                    }
                });
                player.b(info);
            }
        });
    }

    private final void G0(boolean isActivityDestroy) {
        com.tencent.mobileqq.qqecommerce.base.video.f fVar;
        if (this.hadRelease) {
            QLog.i(this.tag, 1, "had release return");
            return;
        }
        QLog.i(this.tag, 1, "release");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$release$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar2, ECVideoInfo eCVideoInfo) {
                invoke2(fVar2, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                Ref.BooleanRef.this.element = true;
                this.B0(HRVideoView.VideoState.IDLE);
                player.release();
            }
        });
        if (!booleanRef.element && isActivityDestroy && (fVar = this.player) != null) {
            try {
                B0(VideoState.IDLE);
                fVar.release();
            } catch (Throwable th5) {
                QLog.i(this.tag, 1, "release error: " + th5);
            }
        }
        I0();
        q0().unregisterActivityLifecycleCallbacks(this);
        this.hadRelease = true;
    }

    private final void I0() {
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        final View view = fVar != null ? fVar.getView() : null;
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$releasePlayerInstance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                imageView = HRVideoView.this.cover;
                imageView.setVisibility(0);
                View view2 = view;
                if (view2 != null) {
                    HRVideoView hRVideoView = HRVideoView.this;
                    if (Intrinsics.areEqual(view2.getParent(), hRVideoView)) {
                        hRVideoView.removeView(view2);
                    }
                }
            }
        });
        this.player = null;
        this.uiHandler.removeCallbacksAndMessages(null);
        q0().unregisterActivityLifecycleCallbacks(this);
    }

    private final void J0() {
        this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.c
            @Override // java.lang.Runnable
            public final void run() {
                HRVideoView.K0(HRVideoView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(HRVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.q0().getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0() {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$runDelayTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                boolean z16;
                String str;
                boolean z17;
                boolean z18;
                boolean z19;
                boolean z06;
                Set set;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                z16 = HRVideoView.this.hadDestroy;
                if (!z16) {
                    z19 = HRVideoView.this.hadRelease;
                    if (!z19) {
                        z06 = HRVideoView.this.z0();
                        if (!z06) {
                            set = HRVideoView.this.callbackQueue;
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                ((Function2) it.next()).invoke(player, info);
                            }
                            return;
                        }
                    }
                }
                str = HRVideoView.this.tag;
                z17 = HRVideoView.this.hadDestroy;
                z18 = HRVideoView.this.hadRelease;
                QLog.i(str, 1, "runDelayTask hadDestroy or release: " + z17 + ", " + z18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        if (this.isActivityResume) {
            B0(VideoState.PLAYING);
            com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
            if (fVar != null) {
                fVar.start();
            }
            this.hadRelease = false;
            return;
        }
        QLog.e(this.tag, 1, "safeStart", "want start but isActivityResume=false");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(HRVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R0();
    }

    private final void N0(final String params) {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$seek$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                if (params.length() > 0) {
                    JSONObject jSONObject = new JSONObject(params);
                    player.seek(jSONObject.optLong("positionMs"), jSONObject.optInt("mode"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(final HRVideoView this$0, Object value, String propKey) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(propKey, "$propKey");
        this$0.videoInfo = this$0.p0((String) value);
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$setProp$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HRVideoView.this.x0();
                HRVideoView.this.y0();
            }
        });
        QLog.i(this$0.tag, 1, "setProp isOffline propKey=" + propKey + ", value=" + value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        QLog.i(this.tag, 1, "stop");
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$stop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                HRVideoView.this.B0(HRVideoView.VideoState.IDLE);
                player.stop();
            }
        });
        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$stop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                imageView = HRVideoView.this.cover;
                imageView.setVisibility(0);
            }
        });
    }

    private final HashMap<String, String> Q0(JSONObject jSONObject) {
        String obj;
        Object opt;
        String obj2;
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next != null && (obj = next.toString()) != null && (opt = jSONObject.opt(obj)) != null && (obj2 = opt.toString()) != null) {
                hashMap.put(obj, obj2);
            }
        }
        return hashMap;
    }

    private final void R0() {
        Map mapOf;
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        long currentPositionMs = fVar != null ? fVar.getCurrentPositionMs() : 0L;
        if (currentPositionMs != this.lastPlayPos) {
            this.lastPlayPos = currentPositionMs;
            mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("progressMs", Long.valueOf(currentPositionMs)));
            Function1<Object, Unit> function1 = this.progressUpdateCallback;
            if (function1 != null) {
                function1.invoke(mapOf);
            }
        }
        this.uiHandler.postDelayed(this.updateProgressTask, 1000L);
    }

    private final void S0(Function2<? super com.tencent.mobileqq.qqecommerce.base.video.f, ? super ECVideoInfo, Unit> callback) {
        l0();
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        if (fVar != null) {
            ECVideoInfo eCVideoInfo = this.videoInfo;
            if (eCVideoInfo != null) {
                if (this.hadTranslatePb) {
                    callback.invoke(fVar, eCVideoInfo);
                    return;
                }
                this.callbackQueue.add(callback);
                QLog.e(this.tag, 1, "withPlayer", "videoInfo wait pb translate, callback=" + callback.getClass().getName());
                return;
            }
            if (!this.hadTranslatePb && this.isOfflineSrc) {
                this.callbackQueue.add(callback);
            }
            QLog.e(this.tag, 1, "withPlayer", "videoInfo null, callback=" + callback.getClass().getName());
        }
    }

    private final void l0() {
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        if (fVar != null) {
            int state = fVar.getState();
            VideoState videoState = this.videoState;
            boolean z16 = (state == -1 || state == 0) && videoState != VideoState.IDLE;
            boolean z17 = state == 10;
            boolean z18 = state == 9;
            if (z16 || z17 || z18) {
                QLog.i(this.tag, 1, "checkPlayer super had bean error or release, just recreate, superState=" + state + ", currentState=" + videoState);
                B0(VideoState.IDLE);
                fVar.stop();
                fVar.release();
                I0();
            }
        }
    }

    private final void m0() {
        if (this.player == null) {
            QLog.i(this.tag, 1, "checkPlayer init ");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ECQFSVideoView eCQFSVideoView = new ECQFSVideoView(context);
            this.player = eCQFSVideoView;
            View view = eCQFSVideoView.getView();
            if (view != null) {
                addView(view, -1, -1);
            }
            com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
            if (fVar != null) {
                fVar.a(this);
            }
            com.tencent.mobileqq.qqecommerce.base.video.f fVar2 = this.player;
            if (fVar2 != null) {
                fVar2.setMute(this.mute);
            }
            com.tencent.mobileqq.qqecommerce.base.video.f fVar3 = this.player;
            if (fVar3 != null) {
                fVar3.setLoop(this.loop);
            }
            com.tencent.mobileqq.qqecommerce.base.video.f fVar4 = this.player;
            if (fVar4 != null) {
                fVar4.setXYaxis(INSTANCE.d(this.resize));
            }
            q0().unregisterActivityLifecycleCallbacks(this);
            q0().registerActivityLifecycleCallbacks(this);
        }
    }

    private final ECVideoInfo n0(String src) {
        JSONObject jSONObject = new JSONObject(src);
        String optString = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"url\")");
        return o0(optString, jSONObject);
    }

    private final ECVideoInfo p0(String src) {
        JSONObject jSONObject = new JSONObject(src);
        String url = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (A0(url)) {
            String offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(url);
            if (!(offlineResPath == null || offlineResPath.length() == 0)) {
                url = offlineResPath;
            }
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return o0(url, jSONObject);
    }

    private final Application q0() {
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "{\n            BaseApplic\u2026etApplication()\n        }");
        return application;
    }

    private final void s0(final Function1<Object, Unit> callback) {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$getCurrentPositionMs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                com.tencent.mobileqq.qqecommerce.base.video.f fVar;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                JSONObject jSONObject = new JSONObject();
                fVar = HRVideoView.this.player;
                jSONObject.put("position", fVar != null ? fVar.getCurrentPositionMs() : 0L);
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(jSONObject.toString());
                }
            }
        });
    }

    private final void t0(final Function1<Object, Unit> callback) {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$getDurationMs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                com.tencent.mobileqq.qqecommerce.base.video.f fVar;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                JSONObject jSONObject = new JSONObject();
                fVar = HRVideoView.this.player;
                jSONObject.put("duration", fVar != null ? fVar.getDurationMs() : 0L);
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(jSONObject.toString());
                }
            }
        });
    }

    private final void u0(final Function1<Object, Unit> callback) {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$getFileSizeBytes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                com.tencent.mobileqq.qqecommerce.base.video.f fVar;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                JSONObject jSONObject = new JSONObject();
                fVar = HRVideoView.this.player;
                jSONObject.put("fileSize", fVar != null ? fVar.getFileSizeBytes() : 0L);
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(jSONObject.toString());
                }
            }
        });
    }

    private final void v0(final Function1<Object, Unit> callback) {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$getState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                HRVideoView.VideoState videoState;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                JSONObject jSONObject = new JSONObject();
                videoState = HRVideoView.this.videoState;
                jSONObject.put("state", videoState.state);
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(jSONObject.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        String coverPicUrl;
        ECVideoInfo eCVideoInfo = this.videoInfo;
        if (eCVideoInfo != null) {
            if (eCVideoInfo.getCoverLayerUrl().length() > 0) {
                coverPicUrl = eCVideoInfo.getCoverLayerUrl();
            } else {
                if (!(eCVideoInfo.getCoverPicUrl().length() > 0)) {
                    return;
                } else {
                    coverPicUrl = eCVideoInfo.getCoverPicUrl();
                }
            }
            if (Intrinsics.areEqual(this.coverUrl, coverPicUrl)) {
                return;
            }
            this.coverUrl = coverPicUrl;
            this.cover.setScaleType(INSTANCE.c(this.resize));
            IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
            if (qCircleApi != null) {
                qCircleApi.loadFeedImage(this.cover, this.coverUrl);
            }
            QLog.i(this.tag, 1, "initCover new, width=" + getWidth() + ", height=" + getHeight() + ", url=" + coverPicUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y0() {
        boolean z16;
        String feedPb;
        ECVideoInfo eCVideoInfo = this.videoInfo;
        if (eCVideoInfo != null && (feedPb = eCVideoInfo.getFeedPb()) != null) {
            if (feedPb.length() == 0) {
                z16 = true;
                if (!z16) {
                    this.hadTranslatePb = true;
                    L0();
                    return;
                }
                final ECVideoInfo eCVideoInfo2 = this.videoInfo;
                if (eCVideoInfo2 != null) {
                    this.hadTranslatePb = false;
                    pg2.a.f426173a.a(eCVideoInfo2.getFeedPb(), new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$initPB$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                            invoke2(messageMicro);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(MessageMicro<?> it) {
                            String str;
                            Intrinsics.checkNotNullParameter(it, "it");
                            str = HRVideoView.this.tag;
                            QLog.i(str, 1, "bytesToPb finished runDelayTask ");
                            HRVideoView.this.hadTranslatePb = true;
                            eCVideoInfo2.n(it);
                            HRVideoView.this.L0();
                        }
                    });
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z0() {
        Activity activity = getActivity();
        boolean z16 = activity != null && activity.isDestroyed();
        if (activity == null || z16) {
            QLog.d(this.tag, 1, "isActivityDestroyed: act=" + activity + ", destroy=" + (activity != null ? Boolean.valueOf(activity.isDestroyed()) : null) + ", finished=" + (activity != null ? Boolean.valueOf(activity.isFinishing()) : null));
        }
        return z16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001d. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(final String propKey, final Object value) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!this.hadDestroy && !z0()) {
            switch (propKey.hashCode()) {
                case -2124458952:
                    if (propKey.equals("onComplete")) {
                        this.completeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1);
                        return true;
                    }
                    return super.b(propKey, value);
                case -1349867671:
                    if (propKey.equals("onError")) {
                        this.errorCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1);
                        return true;
                    }
                    return super.b(propKey, value);
                case -1058637547:
                    if (propKey.equals("onProgressUpdate")) {
                        this.progressUpdateCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1);
                        return true;
                    }
                    return super.b(propKey, value);
                case -1013260499:
                    if (propKey.equals("onInfo")) {
                        this.infoCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1);
                        return true;
                    }
                    return super.b(propKey, value);
                case -934437708:
                    if (propKey.equals("resize")) {
                        this.resize = ((Integer) value).intValue();
                        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$setProp$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ImageView imageView;
                                int i3;
                                imageView = HRVideoView.this.cover;
                                HRVideoView.Companion companion = HRVideoView.INSTANCE;
                                i3 = HRVideoView.this.resize;
                                imageView.setScaleType(companion.c(i3));
                            }
                        });
                        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
                        if (fVar == null) {
                            return true;
                        }
                        fVar.setXYaxis(INSTANCE.d(this.resize));
                        return true;
                    }
                    return super.b(propKey, value);
                case 114148:
                    if (propKey.equals("src")) {
                        String str = (String) value;
                        String url = new JSONObject(str).optString("url");
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        if (A0(url)) {
                            this.isOfflineSrc = true;
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HRVideoView.O0(HRVideoView.this, value, propKey);
                                }
                            }, 16, null, false);
                            return true;
                        }
                        this.isOfflineSrc = false;
                        this.videoInfo = n0(str);
                        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$setProp$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                HRVideoView.this.x0();
                            }
                        });
                        y0();
                        QLog.i(this.tag, 1, "setProp propKey=" + propKey + ", value=" + value);
                        return true;
                    }
                    return super.b(propKey, value);
                case 3327652:
                    if (propKey.equals("loop")) {
                        boolean booleanValue = ((Boolean) value).booleanValue();
                        this.loop = booleanValue;
                        com.tencent.mobileqq.qqecommerce.base.video.f fVar2 = this.player;
                        if (fVar2 == null) {
                            return true;
                        }
                        fVar2.setLoop(booleanValue);
                        return true;
                    }
                    return super.b(propKey, value);
                case 3363353:
                    if (propKey.equals("mute")) {
                        boolean booleanValue2 = ((Boolean) value).booleanValue();
                        this.mute = booleanValue2;
                        com.tencent.mobileqq.qqecommerce.base.video.f fVar3 = this.player;
                        if (fVar3 == null) {
                            return true;
                        }
                        fVar3.setMute(booleanValue2);
                        return true;
                    }
                    return super.b(propKey, value);
                case 1201265730:
                    if (propKey.equals("onStateChange")) {
                        this.stateChangeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1);
                        return true;
                    }
                    return super.b(propKey, value);
                default:
                    return super.b(propKey, value);
            }
        }
        QLog.i(this.tag, 1, "had destroy, filter setProp, " + propKey);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0018. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!this.hadDestroy && !z0()) {
            switch (method.hashCode()) {
                case -1302455528:
                    if (method.equals("getFileSizeBytes")) {
                        u0(callback);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case -1059248085:
                    if (method.equals("predownload")) {
                        if (params == null) {
                            return null;
                        }
                        E0(params);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case -573351342:
                    if (method.equals("getCurrentPositionMs")) {
                        s0(callback);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case -318360489:
                    if (method.equals("preplay")) {
                        F0();
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 3443508:
                    if (method.equals("play")) {
                        D0();
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 3526264:
                    if (method.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                        if (params == null) {
                            return null;
                        }
                        N0(params);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 3540994:
                    if (method.equals("stop")) {
                        P0();
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 106440182:
                    if (method.equals("pause")) {
                        C0();
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 933755472:
                    if (method.equals("getDurationMs")) {
                        t0(callback);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 1090594823:
                    if (method.equals("release")) {
                        H0(this, false, 1, null);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                case 1965583067:
                    if (method.equals("getState")) {
                        v0(callback);
                        return Unit.INSTANCE;
                    }
                    return super.call(method, params, callback);
                default:
                    return super.call(method, params, callback);
            }
        }
        QLog.i(this.tag, 1, "had destroy, filter call, " + method);
        return Boolean.TRUE;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.e
    public boolean d() {
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        return (fVar != null ? fVar.getState() : 0) == 5;
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.e
    public boolean g() {
        com.tencent.mobileqq.qqecommerce.base.video.f fVar = this.player;
        int state = fVar != null ? fVar.getState() : 0;
        return state == 4 || state == 5 || state == 6 || state == 7 || state == 8;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(activity, getActivity())) {
            P0();
            G0(true);
            this.attached = false;
            QLog.i(this.tag, 1, "onActivityDestroyed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(activity, getActivity())) {
            this.isActivityResume = false;
            C0();
            QLog.i(this.tag, 1, "onActivityPaused");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(activity, getActivity())) {
            this.isActivityResume = true;
            QLog.i(this.tag, 1, "onActivityResumed");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i(this.tag, 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        this.attached = true;
        q0().unregisterActivityLifecycleCallbacks(this);
        q0().registerActivityLifecycleCallbacks(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.d
    public void onComplete() {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$onComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Function1 function1;
                Map emptyMap;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                HRVideoView.this.B0(HRVideoView.VideoState.COMPLETE);
                function1 = HRVideoView.this.completeCallback;
                if (function1 != null) {
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    function1.invoke(emptyMap);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public void onDestroy() {
        super.onDestroy();
        QLog.i(this.tag, 1, "onViewDestroy");
        H0(this, false, 1, null);
        this.hadDestroy = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i(this.tag, 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        P0();
        H0(this, false, 1, null);
        this.attached = false;
        q0().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.d
    public void onError(int module, int errorType, int errorCode, String extInfo) {
        Map mapOf;
        QLog.i(this.tag, 1, "onError " + errorCode);
        B0(VideoState.ERROR);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("errorCode", Integer.valueOf(errorCode)));
        Function1<Object, Unit> function1 = this.errorCallback;
        if (function1 != null) {
            function1.invoke(mapOf);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.d
    public void onInfo(final int what, final long arg1, final long arg2, final Object obj) {
        if (f263084m0.contains(Integer.valueOf(what))) {
            S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$onInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                    invoke2(fVar, eCVideoInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                    Map mapOf;
                    Function1 function1;
                    String str;
                    Intrinsics.checkNotNullParameter(player, "player");
                    Intrinsics.checkNotNullParameter(info, "info");
                    if (what == 105) {
                        str = this.tag;
                        QLog.i(str, 1, "first frame rendered hide cover");
                        final HRVideoView hRVideoView = this;
                        ECThreadUtilKt.f(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$onInfo$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                ImageView imageView;
                                imageView = HRVideoView.this.cover;
                                imageView.setVisibility(8);
                            }
                        });
                    }
                    mapOf = MapsKt__MapsKt.mapOf(new Pair("infoType", Integer.valueOf(what)), new Pair("arg1", Long.valueOf(arg1)), new Pair("arg2", Long.valueOf(arg2)), new Pair("obj", obj));
                    function1 = this.infoCallback;
                    if (function1 != null) {
                        function1.invoke(mapOf);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.d
    public void onPrepared() {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$onPrepared$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                String str;
                boolean z16;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                str = HRVideoView.this.tag;
                QLog.i(str, 1, "onPrepared");
                z16 = HRVideoView.this.needStartWhenPrepared;
                if (z16) {
                    HRVideoView.this.M0();
                } else if (info.getIsPreload()) {
                    HRVideoView.this.hadPreloadSuccess = true;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.base.video.d
    public void onSeekComplete() {
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$onSeekComplete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                Map mapOf;
                Function1 function1;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("infoType", 1001));
                function1 = HRVideoView.this.infoCallback;
                if (function1 != null) {
                    function1.invoke(mapOf);
                }
            }
        });
    }

    public final long r0() {
        final Ref.LongRef longRef = new Ref.LongRef();
        S0(new Function2<com.tencent.mobileqq.qqecommerce.base.video.f, ECVideoInfo, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView$getCurrentPositionMs$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqecommerce.base.video.f fVar, ECVideoInfo eCVideoInfo) {
                invoke2(fVar, eCVideoInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqecommerce.base.video.f player, ECVideoInfo info) {
                com.tencent.mobileqq.qqecommerce.base.video.f fVar;
                Intrinsics.checkNotNullParameter(player, "player");
                Intrinsics.checkNotNullParameter(info, "info");
                Ref.LongRef longRef2 = Ref.LongRef.this;
                fVar = this.player;
                longRef2.element = fVar != null ? fVar.getCurrentPositionMs() : 0L;
            }
        });
        return longRef.element;
    }

    /* renamed from: w0, reason: from getter */
    public final ECVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    private final boolean A0(String path) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "http", false, 2, null);
        return startsWith$default && !TextUtils.isEmpty(Uri.parse(path).getQueryParameter("_bid"));
    }

    private final ECVideoInfo o0(String url, JSONObject json) {
        HashMap<String, String> hashMap;
        long optLong = json.optLong("startPosMs", 0L);
        String optString = json.optString("feedPb");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"feedPb\")");
        long optLong2 = json.optLong("durationMs");
        String optString2 = json.optString(QCircleSchemeAttr.Detail.COVER_PIC_URL);
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"cover_pic_url\")");
        String optString3 = json.optString("cover_layer_url");
        Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"cover_layer_url\")");
        int optInt = json.optInt("feedIndex");
        JSONObject optJSONObject = json.optJSONObject("ext_dtreport_params");
        if (optJSONObject == null || (hashMap = Q0(optJSONObject)) == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        boolean optBoolean = json.optBoolean("adaptHeight");
        String optString4 = json.optString("vid");
        Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"vid\")");
        return new ECVideoInfo(url, optLong, optString, optLong2, optString2, optString3, false, null, optInt, hashMap2, optBoolean, optString4, json.optBoolean("useUrlAsId"), 192, null);
    }

    static /* synthetic */ void H0(HRVideoView hRVideoView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        hRVideoView.G0(z16);
    }
}
