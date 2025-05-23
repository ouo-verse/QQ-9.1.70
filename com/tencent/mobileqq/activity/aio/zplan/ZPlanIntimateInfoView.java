package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderView;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateElegantCardView;
import com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$requestSceneConfigListener$2;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayoutEvent;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.mobileqq.zplan.show.MsgData;
import com.tencent.mobileqq.zplan.show.MsgType;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.state.report.SquareReportConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import le3.ApiPanelEventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x165.Submsgtype0x165$MsgBody;
import wk3.CoupleAvatarDestroyConfig;

@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0006\u0091\u0001\u0095\u0001\u009e\u0001\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0002\u00ab\u0001B3\u0012\b\u0010O\u001a\u0004\u0018\u00010L\u0012\u0006\u0010R\u001a\u00020P\u0012\u0006\u0010U\u001a\u00020\u0015\u0012\u0006\u0010X\u001a\u00020V\u0012\u0006\u0010Z\u001a\u00020\u0006\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0013\u0010\u0010\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0013\u0010\u0019\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0011J\b\u0010\u001a\u001a\u00020\bH\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001dH\u0002J\u0012\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002J\u0012\u0010)\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0002J\u0018\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015052\u0006\u0010#\u001a\u000202H\u0002J\u0010\u00109\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u000107J\b\u0010;\u001a\u0004\u0018\u00010:J\u000e\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<J\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\bJ\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020\bJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\b\u0010E\u001a\u00020\bH\u0016J\u001a\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020F2\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010K\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010\u00152\u0006\u0010J\u001a\u00020\nR\u0016\u0010O\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010QR\u0014\u0010U\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010WR\u0014\u0010Z\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010\u0013R\u0017\u0010`\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010hR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010jR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010nR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR$\u0010y\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010]\u001a\u0004\bv\u0010_\"\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010{R!\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0015\u0010\u0081\u0001\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010{R\u0017\u0010\u0082\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010pR\u0018\u0010\u0084\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010pR\u001b\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b(\u0010\u0086\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u008a\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010pR\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b \u0010\u008b\u0001R\u001f\u0010\u0090\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b'\u0010\u008e\u0001\u001a\u0005\bs\u0010\u008f\u0001R \u0010\u0094\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u0092\u0001\u0010\u008e\u0001\u001a\u0005\b~\u0010\u0093\u0001R\u0017\u0010\u0097\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b$\u0010\u0096\u0001R\u0017\u0010\u009a\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u000e\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0013\u0010\u009c\u0001R\u0018\u0010\u00a1\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u0015\u0010\u00a2\u0001\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010pR\u001d\u0010\u00a5\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0018\u0010\u00a4\u0001R\u0019\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a6\u00018BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\bp\u0010\u00a7\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00ac\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView;", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "Landroid/graphics/Rect;", "K", "Landroid/view/MotionEvent;", "e", "", "e0", "", ExifInterface.LATITUDE_SOUTH, "", "y", "o0", "G", "Y", "d0", "E", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetSceneId", "Z", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "p0", "c0", "b0", "s0", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lle3/b;", "sceneConfig", "Lkotlinx/coroutines/Deferred;", "U", "actionConfig", "O", "data", "X", "Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$AvatarTarget;", "avatarTarget", "V", BdhLogUtil.LogTag.Tag_Req, "P", "Landroid/graphics/Point;", "headPoint", "Lorg/json/JSONObject;", "dataJSONObject", "t0", "input", "charsPerLine", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/show/b;", AppConstants.Key.COLUMN_MSG_DATA, "v0", "Lkotlin/Pair;", "H", "Lcom/tencent/mobileqq/activity/aio/zplan/c;", "callback", "q0", "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateView;", "L", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "r0", "i0", "k0", "j0", "l0", "m0", "h0", "g0", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayoutEvent;", "event", tl.h.F, "eventId", "bubbleId", "n0", "Lcom/tencent/mobileqq/app/BaseActivity;", "d", "Lcom/tencent/mobileqq/app/BaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "Landroid/content/Context;", "context", "f", "Ljava/lang/String;", "friendUin", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "messageService", "i", "fromScroll", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "N", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanCoupleScrollView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanCoupleScrollView;", "scrollView", "D", "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateView;", "intimateView", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "avatarLayout", "sceneControlLayout", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "actionBtnClicker", "I", "windowDismissClicker", "Lug3/a;", "J", "Lug3/a;", "sceneControlAdapter", "getTextureView", "setTextureView", "(Landroid/view/View;)V", "textureView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "firstFrameImageView", "Ljava/util/concurrent/ConcurrentHashMap;", "M", "Ljava/util/concurrent/ConcurrentHashMap;", "eventIdDataMap", "bgImageView", "bgViewWidth", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bgViewHeight", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "bgBitmap", "hasNotReportScroll", "T", "maxScrollDistanceByAlpha", "Lcom/tencent/mobileqq/activity/aio/zplan/c;", "zPlanIntimateCallback", "Lwk3/a;", "Lkotlin/Lazy;", "()Lwk3/a;", "destroyWhenPauseConfig", "com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$requestSceneConfigListener$2$1", "W", "()Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$requestSceneConfigListener$2$1;", "requestSceneConfigListener", "com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$e", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$e;", "messageReceiveListener", "Lcom/tencent/mobileqq/zplan/push/a;", "Lcom/tencent/mobileqq/zplan/push/a;", "zplanIntimateSceneSyncPushObserver", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "Lcom/tencent/mobileqq/activity/aio/zplan/g;", "inputtingPopupWindow", "com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$bgImageViewLayoutListener$1", "a0", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$bgImageViewLayoutListener$1;", "bgImageViewLayoutListener", "INPUTTING_BUBBLE_ID", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "drawerIsOpened", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "()Lcom/tencent/mobileqq/zplan/aio/couple/i;", "coupleAvatarViewController", "<init>", "(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;Z)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class ZPlanIntimateInfoView implements com.tencent.mobileqq.zplan.aio.couple.g {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ZPlanCoupleScrollView scrollView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MainIntimateView intimateView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout avatarLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout sceneControlLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener actionBtnClicker;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener windowDismissClicker;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ug3.a sceneControlAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View textureView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView firstFrameImageView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, String> eventIdDataMap;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ImageView bgImageView;

    /* renamed from: P, reason: from kotlin metadata */
    private int bgViewWidth;

    /* renamed from: Q, reason: from kotlin metadata */
    private int bgViewHeight;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Bitmap bgBitmap;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasNotReportScroll;

    /* renamed from: T, reason: from kotlin metadata */
    private int maxScrollDistanceByAlpha;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.aio.zplan.c zPlanIntimateCallback;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy destroyWhenPauseConfig;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy requestSceneConfigListener;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final e messageReceiveListener;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.zplan.push.a zplanIntimateSceneSyncPushObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private g inputtingPopupWindow;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanIntimateInfoView$bgImageViewLayoutListener$1 bgImageViewLayoutListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int INPUTTING_BUBBLE_ID;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<Boolean> drawerIsOpened;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final BaseActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String friendUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IZPlanMsgService messageService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean fromScroll;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180432a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f180433b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f180434c;

        static {
            int[] iArr = new int[CoupleAvatarLayoutEvent.values().length];
            try {
                iArr[CoupleAvatarLayoutEvent.FIRST_RENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.TOUCH_EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.GET_NODE_POINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.RENDER_FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180432a = iArr;
            int[] iArr2 = new int[CoupleAvatarScene.AvatarTarget.values().length];
            try {
                iArr2[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f180433b = iArr2;
            int[] iArr3 = new int[MsgType.values().length];
            try {
                iArr3[MsgType.MSG_COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[MsgType.MSG_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[MsgType.MSG_VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[MsgType.MSG_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[MsgType.MSG_INPUTTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[MsgType.MSG_INPUTCANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[MsgType.MSG_GIFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[MsgType.MSG_RED_ENVELOPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[MsgType.MSG_TRANSFER.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            f180434c = iArr3;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$d", "Lcom/tencent/mobileqq/activity/aio/zplan/b;", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "a", "Z", "getDownloadInRect", "()Z", "setDownloadInRect", "(Z)V", "downloadInRect", "b", "isScrolling", "setScrolling", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean downloadInRect;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isScrolling;

        d() {
        }

        @Override // com.tencent.mobileqq.activity.aio.zplan.b
        public boolean onTouchEvent(@Nullable MotionEvent ev5) {
            if (ev5 == null || ZPlanIntimateInfoView.this.avatarLayout.getAlpha() <= 0.3f) {
                return false;
            }
            if (ev5.getAction() == 0) {
                this.isScrolling = false;
                boolean e06 = ZPlanIntimateInfoView.this.e0(ev5);
                this.downloadInRect = e06;
                if (!e06) {
                    return false;
                }
                return true;
            }
            if (2 == ev5.getAction()) {
                this.isScrolling = true;
                return false;
            }
            if (1 == ev5.getAction()) {
                if (this.isScrolling) {
                    this.isScrolling = false;
                    return false;
                }
                this.isScrolling = false;
                if (this.downloadInRect) {
                    return ZPlanIntimateInfoView.this.e0(ev5);
                }
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$e", "Lcom/tencent/mobileqq/zplan/show/a;", "Lcom/tencent/mobileqq/zplan/show/b;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements com.tencent.mobileqq.zplan.show.a {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.show.a
        public void a(@NotNull MsgData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("ZPlanIntimateInfoView", 1, "onMsgReceive, data:" + data);
            ZPlanIntimateInfoView.this.v0(data);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View$OnLayoutChangeListener, com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$bgImageViewLayoutListener$1] */
    public ZPlanIntimateInfoView(@Nullable BaseActivity baseActivity, @NotNull Context context, @NotNull String friendUin, @NotNull IZPlanMsgService messageService, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(messageService, "messageService");
        this.activity = baseActivity;
        this.context = context;
        this.friendUin = friendUin;
        this.messageService = messageService;
        this.fromScroll = z16;
        this.eventIdDataMap = new ConcurrentHashMap<>();
        this.hasNotReportScroll = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoupleAvatarDestroyConfig>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$destroyWhenPauseConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoupleAvatarDestroyConfig invoke() {
                return ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarDestroyConfig();
            }
        });
        this.destroyWhenPauseConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanIntimateInfoView$requestSceneConfigListener$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$requestSceneConfigListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$requestSceneConfigListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final ZPlanIntimateInfoView zPlanIntimateInfoView = ZPlanIntimateInfoView.this;
                return new com.tencent.mobileqq.zplan.aio.couple.h() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$requestSceneConfigListener$2.1
                    @Override // com.tencent.mobileqq.zplan.aio.couple.h
                    public void a(boolean isSuccess) {
                        CoroutineScope f16;
                        if (isSuccess && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e)) != null) {
                            CorountineFunKt.e(f16, "zplan_ZPlanIntimateInfoView_initBackground", null, null, null, new ZPlanIntimateInfoView$requestSceneConfigListener$2$1$onUpdate$1(ZPlanIntimateInfoView.this, null), 14, null);
                        }
                    }
                };
            }
        });
        this.requestSceneConfigListener = lazy2;
        this.messageReceiveListener = new e();
        com.tencent.mobileqq.zplan.push.a aVar = new com.tencent.mobileqq.zplan.push.a() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1
            @Override // com.tencent.mobileqq.zplan.push.a
            public void a(long fromUin, long toUin, @NotNull byte[] body) {
                String str;
                CoroutineScope f16;
                Intrinsics.checkNotNullParameter(body, "body");
                QLog.i("ZPlanIntimateInfoView", 1, "zplanIntimateSceneSyncPushObserver onReceivePush");
                String valueOf = String.valueOf(fromUin);
                str = ZPlanIntimateInfoView.this.friendUin;
                if (!Intrinsics.areEqual(valueOf, str)) {
                    QLog.i("ZPlanIntimateInfoView", 1, "zplanIntimateSceneSyncPushObserver not from current friend");
                    return;
                }
                Submsgtype0x165$MsgBody submsgtype0x165$MsgBody = new Submsgtype0x165$MsgBody();
                try {
                    submsgtype0x165$MsgBody.mergeFrom(body);
                    int i3 = submsgtype0x165$MsgBody.scene_id.get();
                    if (i3 > 0 && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e)) != null) {
                        CorountineFunKt.e(f16, "zplan_ZPlanIntimateInfoView_initBackground", null, null, null, new ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1(ZPlanIntimateInfoView.this, i3, null), 14, null);
                    }
                } catch (Exception e16) {
                    QLog.e("ZPlanIntimateInfoView", 1, "zplanIntimateSceneSyncPushObserver error:" + e16);
                }
            }
        };
        this.zplanIntimateSceneSyncPushObserver = aVar;
        ?? r06 = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$bgImageViewLayoutListener$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                int i3;
                QLog.e("ZPlanIntimateInfoView", 1, "onLayoutChange");
                ZPlanIntimateInfoView zPlanIntimateInfoView = ZPlanIntimateInfoView.this;
                int i16 = 0;
                if (v3 != null) {
                    i3 = v3.getWidth();
                } else {
                    i3 = 0;
                }
                zPlanIntimateInfoView.bgViewWidth = i3;
                ZPlanIntimateInfoView zPlanIntimateInfoView2 = ZPlanIntimateInfoView.this;
                if (v3 != null) {
                    i16 = v3.getHeight();
                }
                zPlanIntimateInfoView2.bgViewHeight = i16;
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "zplan_ZPlanIntimateInfoView_initBackground", null, null, null, new ZPlanIntimateInfoView$bgImageViewLayoutListener$1$onLayoutChange$1(ZPlanIntimateInfoView.this, null), 14, null);
                }
            }
        };
        this.bgImageViewLayoutListener = r06;
        this.INPUTTING_BUBBLE_ID = 12;
        Channel<Boolean> Channel$default = ChannelKt.Channel$default(16, null, null, 6, null);
        Channel$default.mo2003trySendJP2dKIU(Boolean.FALSE);
        this.drawerIsOpened = Channel$default;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169208i90, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ionship_aio_drawer, null)");
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.iig);
        ZPlanCoupleScrollView zPlanCoupleScrollView = (ZPlanCoupleScrollView) findViewById;
        zPlanCoupleScrollView.setOnScrollChangedListener(new a());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<ZP\u2026\n            })\n        }");
        this.scrollView = zPlanCoupleScrollView;
        S();
        View findViewById2 = inflate.findViewById(R.id.a39);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.avatar_layout)");
        this.avatarLayout = (RelativeLayout) findViewById2;
        Y();
        d0();
        View findViewById3 = inflate.findViewById(R.id.f79814_s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.scene_control_layout)");
        this.sceneControlLayout = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.a87);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.bg_view)");
        ImageView imageView = (ImageView) findViewById4;
        this.bgImageView = imageView;
        MainIntimateView mainIntimateView = new MainIntimateView(baseActivity, context, friendUin) { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView.2
            @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
            @NotNull
            protected View A() {
                return ZPlanIntimateInfoView.this.getRootView();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
            public void V(@NotNull IntimateInfo intimateInfo) {
                Intrinsics.checkNotNullParameter(intimateInfo, "intimateInfo");
                super.V(intimateInfo);
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "zplan_ZPlanIntimateInfoView_updateIntimateInfo", null, null, null, new ZPlanIntimateInfoView$2$updateIntimateInfo$1(ZPlanIntimateInfoView.this, null), 14, null);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
            @NotNull
            protected View l() {
                return ZPlanIntimateInfoView.this.getRootView();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateView
            @NotNull
            public HashMap<String, Object> q() {
                String str;
                HashMap<String, Object> q16 = super.q();
                Intrinsics.checkNotNullExpressionValue(q16, "super.getPageParam()");
                q16.put("aio_swipleft_version", "3");
                if (ZPlanIntimateInfoView.this.fromScroll) {
                    str = "1";
                } else {
                    str = "2";
                }
                q16.put("zplan_close_space_entrance", str);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restorePgSwipLeftData(q16);
                return q16;
            }
        };
        IntimateHeaderView intimateHeaderView = mainIntimateView.L;
        if (intimateHeaderView != null) {
            intimateHeaderView.setVisibility(8);
        }
        mainIntimateView.R(true);
        mainIntimateView.P(true, new MainIntimateTitlePart.g() { // from class: com.tencent.mobileqq.activity.aio.zplan.j
            @Override // com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart.g
            public final void a() {
                ZPlanIntimateInfoView.f0(ZPlanIntimateInfoView.this);
            }
        });
        this.intimateView = mainIntimateView;
        View findViewById5 = inflate.findViewById(R.id.xrd);
        if (findViewById5 != null) {
            findViewById5.setVisibility(8);
        }
        imageView.addOnLayoutChangeListener(r06);
        c0();
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null) {
            I.u(true, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object E(Continuation<? super Boolean> continuation) {
        ZPlanIntimateInfoView$checkNeedInitIntimateBg$1 zPlanIntimateInfoView$checkNeedInitIntimateBg$1;
        Object coroutine_suspended;
        int i3;
        Integer num;
        Integer num2;
        ZPlanIntimateInfoView zPlanIntimateInfoView;
        com.tencent.mobileqq.zplan.aio.couple.i I;
        if (continuation instanceof ZPlanIntimateInfoView$checkNeedInitIntimateBg$1) {
            zPlanIntimateInfoView$checkNeedInitIntimateBg$1 = (ZPlanIntimateInfoView$checkNeedInitIntimateBg$1) continuation;
            int i16 = zPlanIntimateInfoView$checkNeedInitIntimateBg$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanIntimateInfoView$checkNeedInitIntimateBg$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanIntimateInfoView$checkNeedInitIntimateBg$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanIntimateInfoView$checkNeedInitIntimateBg$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        num2 = (Integer) zPlanIntimateInfoView$checkNeedInitIntimateBg$1.L$1;
                        zPlanIntimateInfoView = (ZPlanIntimateInfoView) zPlanIntimateInfoView$checkNeedInitIntimateBg$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.aio.couple.i I2 = I();
                    if (I2 != null) {
                        num = Boxing.boxInt(I2.getIntimateSceneId());
                    } else {
                        num = null;
                    }
                    com.tencent.mobileqq.zplan.aio.couple.i I3 = I();
                    if (I3 != null) {
                        zPlanIntimateInfoView$checkNeedInitIntimateBg$1.L$0 = this;
                        zPlanIntimateInfoView$checkNeedInitIntimateBg$1.L$1 = num;
                        zPlanIntimateInfoView$checkNeedInitIntimateBg$1.label = 1;
                        Object e16 = I3.e(zPlanIntimateInfoView$checkNeedInitIntimateBg$1);
                        if (e16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        num2 = num;
                        obj = e16;
                        zPlanIntimateInfoView = this;
                    } else {
                        return Boxing.boxBoolean(false);
                    }
                }
                int intValue = ((Number) obj).intValue();
                if (num2 != null && num2.intValue() == intValue) {
                    return Boxing.boxBoolean(false);
                }
                I = zPlanIntimateInfoView.I();
                if (I != null) {
                    I.q(intValue);
                }
                return Boxing.boxBoolean(true);
            }
        }
        zPlanIntimateInfoView$checkNeedInitIntimateBg$1 = new ZPlanIntimateInfoView$checkNeedInitIntimateBg$1(this, continuation);
        Object obj2 = zPlanIntimateInfoView$checkNeedInitIntimateBg$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanIntimateInfoView$checkNeedInitIntimateBg$1.label;
        if (i3 == 0) {
        }
        int intValue2 = ((Number) obj2).intValue();
        if (num2 != null) {
            return Boxing.boxBoolean(false);
        }
        I = zPlanIntimateInfoView.I();
        if (I != null) {
        }
        return Boxing.boxBoolean(true);
    }

    private final String F(String input, int charsPerLine) {
        IntRange until;
        IntProgression step;
        int coerceAtMost;
        int length = input.length();
        if (length <= charsPerLine) {
            return input;
        }
        StringBuilder sb5 = new StringBuilder();
        until = RangesKt___RangesKt.until(0, length);
        step = RangesKt___RangesKt.step(until, charsPerLine);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(first + charsPerLine, length);
                String substring = input.substring(first, coerceAtMost);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                if (coerceAtMost < length) {
                    sb5.append("\n");
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        IntimateElegantCardView intimateElegantCardView;
        int i3;
        int i16;
        try {
            MainIntimateView mainIntimateView = this.intimateView;
            if (mainIntimateView != null && this.maxScrollDistanceByAlpha == 0 && (intimateElegantCardView = mainIntimateView.N) != null && this.avatarLayout != null) {
                int[] a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.a(intimateElegantCardView);
                if (a16.length > 1) {
                    this.maxScrollDistanceByAlpha = a16[1];
                    int[] a17 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.a(this.avatarLayout);
                    if (a17.length > 1 && (i3 = a17[1]) < (i16 = this.maxScrollDistanceByAlpha)) {
                        this.maxScrollDistanceByAlpha = i16 - i3;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("ZPlanIntimateInfoView", 1, "avatarLayout.getLocationOnScreen error " + e16);
        }
    }

    private final Pair<String, String> H(MsgData data) {
        switch (c.f180434c[data.getType().ordinal()]) {
            case 1:
                return new Pair<>("\u7ed9\u4f60\u53d1\u4e86\u6761\u6d88\u606f\uff0c\n\u5feb\u6765\u770b\u4e0b\uff01", "");
            case 2:
                return new Pair<>(data.getText(), "");
            case 3:
                return new Pair<>("", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/yuyin.png");
            case 4:
                return new Pair<>("\u7ed9\u4f60\u53d1\u4e86\u4e2a\u6587\u4ef6\uff0c\n\u5feb\u6765\u770b\u770b\uff01", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/wenjian.png");
            case 5:
                return new Pair<>("", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/shuruzhong.png");
            case 6:
                return new Pair<>("", "");
            case 7:
                return new Pair<>("\u7ed9\u4f60\u9001\u4e86\u4e2a\u793c\u7269\uff0c\n\u5feb\u6765\u6536\u4e0b\uff01", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/liwu.png");
            case 8:
                return new Pair<>("\u7ed9\u4f60\u53d1\u4e86\u4e2a\u7ea2\u5305\uff0c\n\u5feb\u6765\u6536\u4e0b\uff01", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/hongbao.png");
            case 9:
                return new Pair<>("\u7ed9\u4f60\u53d1\u4e86\u7b14\u8f6c\u8d26\uff0c\n\u5feb\u6765\u6536\u4e0b\uff01", "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/zhuanzhang.png");
            default:
                return new Pair<>("", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.zplan.aio.couple.i I() {
        QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
        return IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, this.friendUin, null, 2, null);
    }

    private final CoupleAvatarDestroyConfig J() {
        return (CoupleAvatarDestroyConfig) this.destroyWhenPauseConfig.getValue();
    }

    private final Rect K() {
        ZPlanIntimateContentItemFriendInfoView zPlanIntimateContentItemFriendInfoView;
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            zPlanIntimateContentItemFriendInfoView = mainIntimateView.M;
        } else {
            zPlanIntimateContentItemFriendInfoView = null;
        }
        if (zPlanIntimateContentItemFriendInfoView == null) {
            return new Rect();
        }
        int[] a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.a(zPlanIntimateContentItemFriendInfoView);
        int i3 = a16[0];
        return new Rect(i3, a16[1], zPlanIntimateContentItemFriendInfoView.getWidth() + i3, a16[1] + zPlanIntimateContentItemFriendInfoView.getHeight());
    }

    private final ZPlanIntimateInfoView$requestSceneConfigListener$2.AnonymousClass1 M() {
        return (ZPlanIntimateInfoView$requestSceneConfigListener$2.AnonymousClass1) this.requestSceneConfigListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Boolean> O(CoroutineScope scope, le3.b actionConfig) {
        Deferred<Boolean> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new ZPlanIntimateInfoView$handleAnimationTabItemClick$1(actionConfig, this, null), 3, null);
        return async$default;
    }

    private final void P(String data) {
        final JSONObject b16;
        QLog.i("ZPlanIntimateInfoView", 1, "handleGetNodePoint eventData: " + data);
        com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
        JSONObject b17 = hVar.b(data);
        if (b17 == null) {
            return;
        }
        if (!b17.optBoolean("isSuccess", false)) {
            QLog.i("ZPlanIntimateInfoView", 1, "handleGetNodePoint failed, errMsg: " + b17.optString("errMsg", ""));
            return;
        }
        if (b17.has("requestNodePointDataId")) {
            int optInt = b17.optInt("requestNodePointDataId", -1);
            if (b17.has("requestNodePointDataId")) {
                int optInt2 = b17.optInt("headPointX", -1);
                if (b17.has("headPointY")) {
                    int optInt3 = b17.optInt("headPointY", -1);
                    QLog.i("ZPlanIntimateInfoView", 1, "handleGetNodePoint, requestId: " + optInt + ", nodeX: " + optInt2 + ", nodeY: " + optInt3);
                    final Point point = new Point(optInt2, optInt3);
                    String str = this.eventIdDataMap.get(Integer.valueOf(optInt));
                    if (str != null && (b16 = hVar.b(str)) != null && Intrinsics.areEqual(b16.optString("requestDataPurpose"), "showBubble")) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zplan.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                ZPlanIntimateInfoView.Q(ZPlanIntimateInfoView.this, point, b16);
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.e("ZPlanIntimateInfoView", 1, "handleGetNodePoint failed, HEAD_POINT_Y in data invalid.");
                return;
            }
            QLog.e("ZPlanIntimateInfoView", 1, "handleGetNodePoint failed, HEAD_POINT_X in data invalid.");
            return;
        }
        QLog.e("ZPlanIntimateInfoView", 1, "handleGetNodePoint failed, requestId in data invalid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ZPlanIntimateInfoView this$0, Point headPoint, JSONObject eventExtData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(headPoint, "$headPoint");
        Intrinsics.checkNotNullParameter(eventExtData, "$eventExtData");
        this$0.t0(headPoint, eventExtData);
    }

    private final void R(CoupleAvatarScene.AvatarTarget avatarTarget) {
        Long longOrNull;
        int i3 = c.f180433b[avatarTarget.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.friendUin);
                if (longOrNull != null) {
                    com.tencent.mobileqq.zplan.aio.couple.i.INSTANCE.a(this.context, longOrNull.longValue(), 2);
                    return;
                }
                return;
            }
            QLog.i("ZPlanIntimateInfoView", 1, "handleLongPressEvent avatarTarget:" + avatarTarget + " do nothing");
            return;
        }
        com.tencent.mobileqq.zplan.aio.couple.i.INSTANCE.b(this.context, "em_zplan_portal_entrance_longpress_friend_time");
    }

    private final void S() {
        View findViewById = this.rootView.findViewById(R.id.f99895r1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.top_holder)");
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.activity.aio.zplan.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean T;
                T = ZPlanIntimateInfoView.T(view, motionEvent);
                return T;
            }
        });
        ZPlanCoupleScrollView zPlanCoupleScrollView = this.scrollView;
        if (zPlanCoupleScrollView != null) {
            zPlanCoupleScrollView.setCallback(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T(View view, MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Deferred<Boolean> U(CoroutineScope scope, le3.b sceneConfig) {
        Deferred<Boolean> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new ZPlanIntimateInfoView$handleSceneTabItemClick$1(sceneConfig, this, null), 3, null);
        return async$default;
    }

    private final void V(CoupleAvatarScene.AvatarTarget avatarTarget) {
        if (avatarTarget == CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT || avatarTarget == CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zplan.l
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanIntimateInfoView.W(ZPlanIntimateInfoView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ZPlanIntimateInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.actionBtnClicker;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
    }

    private final void X(String data) {
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
        if (b16 == null) {
            return;
        }
        String optString = b16.optString("touchEventType");
        CoupleAvatarScene.AvatarTarget q16 = CoupleAvatarScene.INSTANCE.q(b16.optString("touchEventTarget"));
        if (Intrinsics.areEqual(optString, TouchEventType.TapUp.toString())) {
            V(q16);
        } else if (Intrinsics.areEqual(optString, TouchEventType.LongPress.toString())) {
            R(q16);
        }
    }

    private final void Y() {
        float e16 = ViewUtils.f352270a.e();
        ViewGroup.LayoutParams layoutParams = this.avatarLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = (int) (1.184f * e16);
        layoutParams2.height = (int) (0.693f * e16);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = (int) (0.45f * e16);
        layoutParams2.addRule(9);
        int i3 = -((int) (e16 * 0.092f));
        layoutParams2.leftMargin = i3;
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = i3;
        this.avatarLayout.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z(Integer num, Continuation<? super Unit> continuation) {
        ZPlanIntimateInfoView$initBackground$1 zPlanIntimateInfoView$initBackground$1;
        Object coroutine_suspended;
        int i3;
        Integer num2;
        ZPlanIntimateInfoView zPlanIntimateInfoView;
        int intValue;
        ZPlanIntimateInfoView zPlanIntimateInfoView2;
        com.tencent.mobileqq.zplan.aio.couple.i I;
        String w3;
        if (continuation instanceof ZPlanIntimateInfoView$initBackground$1) {
            zPlanIntimateInfoView$initBackground$1 = (ZPlanIntimateInfoView$initBackground$1) continuation;
            int i16 = zPlanIntimateInfoView$initBackground$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanIntimateInfoView$initBackground$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanIntimateInfoView$initBackground$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanIntimateInfoView$initBackground$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        zPlanIntimateInfoView = (ZPlanIntimateInfoView) zPlanIntimateInfoView$initBackground$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.e("ZPlanIntimateInfoView", 1, "initBackground targetSceneId:" + num);
                    if (num != null) {
                        intValue = num.intValue();
                        zPlanIntimateInfoView2 = this;
                        I = zPlanIntimateInfoView2.I();
                        if (I == null && (w3 = I.w(intValue, zPlanIntimateInfoView2.M())) != null) {
                            zPlanIntimateInfoView2.p0(w3);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    com.tencent.mobileqq.zplan.aio.couple.i I2 = I();
                    if (I2 != null) {
                        zPlanIntimateInfoView$initBackground$1.L$0 = this;
                        zPlanIntimateInfoView$initBackground$1.label = 1;
                        obj = I2.e(zPlanIntimateInfoView$initBackground$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanIntimateInfoView = this;
                    } else {
                        num2 = null;
                        zPlanIntimateInfoView = this;
                        if (num2 != null) {
                            int intValue2 = num2.intValue();
                            zPlanIntimateInfoView2 = zPlanIntimateInfoView;
                            intValue = intValue2;
                            I = zPlanIntimateInfoView2.I();
                            if (I == null) {
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                }
                num2 = (Integer) obj;
                if (num2 != null) {
                }
            }
        }
        zPlanIntimateInfoView$initBackground$1 = new ZPlanIntimateInfoView$initBackground$1(this, continuation);
        Object obj2 = zPlanIntimateInfoView$initBackground$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanIntimateInfoView$initBackground$1.label;
        if (i3 == 0) {
        }
        num2 = (Integer) obj2;
        if (num2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object a0(ZPlanIntimateInfoView zPlanIntimateInfoView, Integer num, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                num = null;
            }
            return zPlanIntimateInfoView.Z(num, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initBackground");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b0(Continuation<? super Unit> continuation) {
        ZPlanIntimateInfoView$initCoupleAvatarView$1 zPlanIntimateInfoView$initCoupleAvatarView$1;
        Object coroutine_suspended;
        int i3;
        ZPlanIntimateInfoView zPlanIntimateInfoView;
        View view;
        if (continuation instanceof ZPlanIntimateInfoView$initCoupleAvatarView$1) {
            zPlanIntimateInfoView$initCoupleAvatarView$1 = (ZPlanIntimateInfoView$initCoupleAvatarView$1) continuation;
            int i16 = zPlanIntimateInfoView$initCoupleAvatarView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanIntimateInfoView$initCoupleAvatarView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanIntimateInfoView$initCoupleAvatarView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanIntimateInfoView$initCoupleAvatarView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        zPlanIntimateInfoView = (ZPlanIntimateInfoView) zPlanIntimateInfoView$initCoupleAvatarView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("ZPlanIntimateInfoView", 1, "initCoupleAvatarView");
                    com.tencent.mobileqq.zplan.aio.couple.i I = I();
                    if (I != null) {
                        zPlanIntimateInfoView$initCoupleAvatarView$1.L$0 = this;
                        zPlanIntimateInfoView$initCoupleAvatarView$1.label = 1;
                        obj = I.o(zPlanIntimateInfoView$initCoupleAvatarView$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanIntimateInfoView = this;
                    }
                    return Unit.INSTANCE;
                }
                view = (View) obj;
                if (view != null) {
                    View view2 = zPlanIntimateInfoView.textureView;
                    if (view2 != null && !Intrinsics.areEqual(view, view2)) {
                        View view3 = zPlanIntimateInfoView.textureView;
                        Intrinsics.checkNotNull(view3);
                        if (view3.getParent() != null) {
                            ViewParent parent = view3.getParent();
                            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                            ((ViewGroup) parent).removeView(view3);
                        }
                        QLog.i("ZPlanIntimateInfoView", 1, "removeOldTextureView oldView:" + zPlanIntimateInfoView.textureView + " newView:" + view);
                        zPlanIntimateInfoView.textureView = null;
                    }
                    com.tencent.mobileqq.zplan.aio.couple.i I2 = zPlanIntimateInfoView.I();
                    if (I2 != null) {
                        I2.t();
                    }
                    ImageView imageView = zPlanIntimateInfoView.firstFrameImageView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    if (view.getParent() != null) {
                        ViewParent parent2 = view.getParent();
                        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent2).removeView(view);
                    }
                    float e16 = ViewUtils.f352270a.e();
                    int i17 = (int) (1.184f * e16);
                    int i18 = (int) (e16 * 0.693f);
                    com.tencent.mobileqq.zplan.aio.couple.i I3 = zPlanIntimateInfoView.I();
                    if (I3 != null) {
                        I3.c(i17, i18);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    zPlanIntimateInfoView.textureView = view;
                    zPlanIntimateInfoView.avatarLayout.addView(view, layoutParams);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        zPlanIntimateInfoView$initCoupleAvatarView$1 = new ZPlanIntimateInfoView$initCoupleAvatarView$1(this, continuation);
        Object obj2 = zPlanIntimateInfoView$initCoupleAvatarView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanIntimateInfoView$initCoupleAvatarView$1.label;
        if (i3 == 0) {
        }
        view = (View) obj2;
        if (view != null) {
        }
        return Unit.INSTANCE;
    }

    private final void c0() {
        ImageView p16;
        float e16 = ViewUtils.f352270a.e();
        int i3 = (int) (1.3f * e16);
        int i16 = (int) (e16 * 0.76f);
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null && (p16 = I.p(this.friendUin, i3, i16, this.context)) != null) {
            this.firstFrameImageView = p16;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
            ImageView imageView = this.firstFrameImageView;
            Intrinsics.checkNotNull(imageView);
            imageView.setMaxHeight(i16);
            ImageView imageView2 = this.firstFrameImageView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(0);
            layoutParams.addRule(14);
            RelativeLayout relativeLayout = this.avatarLayout;
            ImageView imageView3 = this.firstFrameImageView;
            Intrinsics.checkNotNull(imageView3);
            relativeLayout.addView(imageView3, layoutParams);
        }
    }

    private final void d0() {
        View findViewById = this.rootView.findViewById(R.id.f99895r1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.top_holder)");
        ViewUtils viewUtils = ViewUtils.f352270a;
        int e16 = viewUtils.e();
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = ((int) (e16 * 1.143f)) + viewUtils.b(102);
        findViewById.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e0(MotionEvent e16) {
        try {
            int e17 = ViewUtils.f352270a.e();
            int i3 = (int) (e17 * 0.2d);
            int[] a16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.a(this.avatarLayout);
            int[] a17 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.a(this.sceneControlLayout);
            int i16 = a16[1];
            int i17 = e17 - i3;
            Rect rect = new Rect(i3, i16, i17, this.avatarLayout.getHeight() + i16);
            int i18 = a17[1];
            Rect rect2 = new Rect(i3, i18, i17, this.sceneControlLayout.getHeight() + i18);
            if (!rect.contains((int) e16.getX(), (int) e16.getY()) && !rect2.contains((int) e16.getX(), (int) e16.getY())) {
                if (!K().contains((int) e16.getX(), (int) e16.getY())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e18) {
            QLog.e("ZPlanIntimateInfoView", 1, "isInAvatarArea error " + e18);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ZPlanIntimateInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.activity.aio.zplan.c cVar = this$0.zPlanIntimateCallback;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(int y16) {
        boolean z16;
        int i3 = this.maxScrollDistanceByAlpha;
        if (i3 == 0) {
            return;
        }
        float f16 = 1.0f;
        if (y16 > 0) {
            if (y16 >= i3) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f - ((y16 / i3) * 1.0f);
            }
        }
        if (f16 == this.avatarLayout.getAlpha()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.avatarLayout.setAlpha(f16);
        this.sceneControlLayout.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(String url) {
        boolean z16 = true;
        QLog.e("ZPlanIntimateInfoView", 1, "setBackgroundImage bgViewWidth:" + this.bgViewWidth + " bgViewHeight:" + this.bgViewHeight + " url:" + url + " coupleAvatarViewController:" + I() + " thread=" + Thread.currentThread());
        if (this.bgViewWidth != 0 && this.bgViewHeight != 0) {
            if (url.length() != 0) {
                z16 = false;
            }
            if (!z16 && I() != null) {
                this.bgImageView.removeOnLayoutChangeListener(this.bgImageViewLayoutListener);
                Drawable backgroundDrawable = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getBackgroundDrawable(CoupleAvatarSubScene.IntimateInfo, this.bgViewWidth, this.bgViewHeight, url, this.bgImageView.getDrawable());
                if (backgroundDrawable == null) {
                    return;
                }
                this.bgImageView.setImageDrawable(backgroundDrawable);
            }
        }
    }

    private final void s0() {
        this.avatarLayout.removeView(this.textureView);
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null) {
            I.j();
        }
        this.avatarLayout.removeView(this.firstFrameImageView);
        c0();
    }

    private final void t0(Point headPoint, JSONObject dataJSONObject) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        boolean z19;
        TextView b16;
        ImageView a16;
        boolean z26;
        String it = dataJSONObject.optString("bubbleContent", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            it = null;
        }
        if (it == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(it);
        String picUrl = jSONObject.optString("picUrl", "");
        String formatedBubbleText = jSONObject.optString("text", "");
        String optString = jSONObject.optString(QQBrowserActivity.KEY_MSG_TYPE, "");
        Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
        if (picUrl.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(formatedBubbleText, "bubbleText");
            if (formatedBubbleText.length() == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26 && !Intrinsics.areEqual(optString, MsgType.MSG_INPUTCANCEL.toString())) {
                return;
            }
        }
        if (Intrinsics.areEqual(optString, MsgType.MSG_TEXT.toString())) {
            Intrinsics.checkNotNullExpressionValue(formatedBubbleText, "bubbleText");
            formatedBubbleText = F(formatedBubbleText, 10);
        }
        View view = this.textureView;
        if (view != null) {
            int width = view.getWidth();
            View view2 = this.textureView;
            if (view2 != null) {
                int height = view2.getHeight();
                int i16 = headPoint.x;
                if (i16 > 0 && (i3 = headPoint.y) > 0 && i16 <= width && i3 <= height) {
                    final g gVar = new g(this.context);
                    gVar.setFocusable(true);
                    gVar.setOutsideTouchable(true);
                    if (picUrl.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18 && (a16 = gVar.a()) != null) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                        obtain.mLoadingDrawable = drawable;
                        obtain.mFailedDrawable = drawable;
                        obtain.mUseApngImage = true;
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_double_bitmap", true);
                        obtain.mExtraInfo = bundle;
                        URLDrawable drawable2 = URLDrawable.getDrawable(picUrl, obtain);
                        if (Intrinsics.areEqual(picUrl, "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/yuyin.png") || Intrinsics.areEqual(picUrl, "https://image.superqqshow.qq.com/qq/aio_love_space/bubble/shuruzhong.png")) {
                            ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
                            ViewUtils viewUtils = ViewUtils.f352270a;
                            layoutParams.height = viewUtils.b(20);
                            a16.getLayoutParams().width = viewUtils.b(20);
                        }
                        a16.setImageDrawable(drawable2);
                        a16.setAdjustViewBounds(true);
                        a16.setVisibility(0);
                    }
                    Intrinsics.checkNotNullExpressionValue(formatedBubbleText, "formatedBubbleText");
                    if (formatedBubbleText.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19 && (b16 = gVar.b()) != null) {
                        b16.setText(formatedBubbleText);
                        b16.setTextSize(10.0f);
                        b16.setVisibility(0);
                    }
                    gVar.getContentView().measure(-2, -2);
                    int measuredWidth = gVar.getContentView().getMeasuredWidth();
                    int measuredHeight = gVar.getContentView().getMeasuredHeight();
                    int i17 = headPoint.x - (measuredWidth / 2);
                    int b17 = headPoint.y + measuredHeight + ViewUtils.f352270a.b(16);
                    QLog.i("ZPlanIntimateInfoView", 1, "textureView: width: " + width + ", height: " + height + ", \ncontentView: width: " + measuredWidth + ", height: " + measuredHeight + ", \noffset: x: " + i17 + ", y: " + b17);
                    g gVar2 = this.inputtingPopupWindow;
                    if (gVar2 != null) {
                        gVar2.dismiss();
                        n0("dt_imp_end", this.INPUTTING_BUBBLE_ID);
                    }
                    if (Intrinsics.areEqual(optString, MsgType.MSG_INPUTTING.toString())) {
                        gVar.showAsDropDown(this.textureView, i17, -b17);
                        this.inputtingPopupWindow = gVar;
                        n0("dt_imp", this.INPUTTING_BUBBLE_ID);
                    } else if (Intrinsics.areEqual(optString, MsgType.MSG_INPUTCANCEL.toString())) {
                        this.inputtingPopupWindow = null;
                    }
                    gVar.getContentView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.zplan.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            ZPlanIntimateInfoView.u0(ZPlanIntimateInfoView.this, gVar, view3);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ZPlanIntimateInfoView this$0, g bubblePopupWindow, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bubblePopupWindow, "$bubblePopupWindow");
        this$0.n0("dt_clck", this$0.INPUTTING_BUBBLE_ID);
        bubblePopupWindow.dismiss();
        this$0.n0("dt_imp_end", this$0.INPUTTING_BUBBLE_ID);
        View.OnClickListener onClickListener = this$0.windowDismissClicker;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
        this$0.g0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(MsgData msgData) {
        Pair<String, String> H = H(msgData);
        String first = H.getFirst();
        String second = H.getSecond();
        Pair<String, String> H2 = H(msgData);
        H2.component1();
        H2.component2();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", first);
        jSONObject.put("picUrl", second);
        jSONObject.put(QQBrowserActivity.KEY_MSG_TYPE, msgData.getType().toString());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026())\n         }.toString()");
        QLog.i("ZPlanIntimateInfoView", 1, "tryShowBubble, msgType: " + msgData.getType());
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("requestDataPurpose", "showBubble");
        jSONObject3.put("bubbleContent", jSONObject2);
        this.eventIdDataMap.put(1, jSONObject3.toString());
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("renderObjectType", "renderObjectLeftAvatar");
        jSONObject4.put("renderObjectNodeName", "parietal");
        jSONObject4.put("requestNodePointDataId", 1);
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null) {
            String jSONObject5 = jSONObject4.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject5, "data.toString()");
            I.i(jSONObject5);
        }
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final MainIntimateView getIntimateView() {
        return this.intimateView;
    }

    @NotNull
    /* renamed from: N, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    public void g0() {
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.y();
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.g
    public void h(@NotNull CoupleAvatarLayoutEvent event, @Nullable String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = c.f180432a[event.ordinal()];
        if (i3 != 2) {
            if (i3 == 3) {
                P(data);
                return;
            }
            return;
        }
        X(data);
    }

    public final void h0() {
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null) {
            I.u(false, this.zplanIntimateSceneSyncPushObserver);
        }
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.P(false, null);
        }
        MainIntimateView mainIntimateView2 = this.intimateView;
        if (mainIntimateView2 != null) {
            mainIntimateView2.B();
        }
        MainIntimateView mainIntimateView3 = this.intimateView;
        if (mainIntimateView3 != null) {
            mainIntimateView3.J();
        }
        this.intimateView = null;
        g gVar = this.inputtingPopupWindow;
        if (gVar != null) {
            gVar.dismiss();
        }
        Bitmap bitmap = this.bgBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.bgBitmap = null;
        ZPlanCoupleScrollView zPlanCoupleScrollView = this.scrollView;
        if (zPlanCoupleScrollView != null) {
            zPlanCoupleScrollView.setCallback(null);
        }
    }

    public final void i0() {
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.C();
        }
        ug3.a aVar = this.sceneControlAdapter;
        if (aVar != null) {
            aVar.k();
        }
        s0();
        this.messageService.clearListener(this.messageReceiveListener);
        this.drawerIsOpened.mo2003trySendJP2dKIU(Boolean.FALSE);
    }

    public final void j0() {
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.D();
        }
        com.tencent.mobileqq.zplan.aio.couple.i I = I();
        if (I != null) {
            I.d(CoupleAvatarSubScene.IntimateInfo);
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_ZPlanIntimateInfoView_onDrawerOpened", null, null, null, new ZPlanIntimateInfoView$onDrawerOpened$1(this, null), 14, null);
        }
    }

    public final void k0() {
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.E();
        }
    }

    public final void l0() {
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.F();
        }
    }

    public final void m0() {
        if (J().getEnableDestroyWhenPause()) {
            j0();
        }
        MainIntimateView mainIntimateView = this.intimateView;
        if (mainIntimateView != null) {
            mainIntimateView.G();
        }
    }

    public final void n0(@Nullable String eventId, int bubbleId) {
        HashMap<String, Object> hashMapOf;
        try {
            QRouteApi api = QRoute.api(IMutualMarkHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMutualMarkHelperApi::class.java)");
            IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) api;
            HashMap<String, Object> pgSwipLeftData = iMutualMarkHelperApi.getPgSwipLeftData();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_message_type", Integer.valueOf(bubbleId)));
            iMutualMarkHelperApi.reportItemEvent(eventId, "pg_aio_swipleft", "em_zplan_message", pgSwipLeftData, hashMapOf);
        } catch (Exception e16) {
            QLog.e("ZPlanIntimateInfoView", 1, "reportMsgBubble error:" + e16);
        }
    }

    public final void q0(@Nullable com.tencent.mobileqq.activity.aio.zplan.c callback) {
        this.zPlanIntimateCallback = callback;
    }

    public final void r0(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (this.lifecycleOwner != null) {
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.scrollView);
        WeakReference weakReference = new WeakReference(I());
        final WeakReference weakReference2 = new WeakReference(this);
        IZPlanAIOHelper iZPlanAIOHelper = (IZPlanAIOHelper) QRoute.api(IZPlanAIOHelper.class);
        Context context = this.sceneControlLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "sceneControlLayout.context");
        Pair<View, ug3.a> generatePanelViewAndAdapter = iZPlanAIOHelper.generatePanelViewAndAdapter(context, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), arrayList, this.rootView, new ApiPanelEventHandler(new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
            
                r2 = r0.O(r2, r3);
             */
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Deferred<Boolean> invoke(@NotNull CoroutineScope scope, @NotNull le3.b config) {
                Deferred<Boolean> O;
                Intrinsics.checkNotNullParameter(scope, "scope");
                Intrinsics.checkNotNullParameter(config, "config");
                ZPlanIntimateInfoView zPlanIntimateInfoView = weakReference2.get();
                return (zPlanIntimateInfoView == null || O == null) ? CompletableDeferredKt.CompletableDeferred(Boolean.FALSE) : O;
            }
        }, new Function2<CoroutineScope, le3.b, Deferred<? extends Boolean>>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
            
                r2 = r0.U(r2, r3);
             */
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Deferred<Boolean> invoke(@NotNull CoroutineScope scope, @NotNull le3.b config) {
                Deferred<Boolean> U;
                Intrinsics.checkNotNullParameter(scope, "scope");
                Intrinsics.checkNotNullParameter(config, "config");
                ZPlanIntimateInfoView zPlanIntimateInfoView = weakReference2.get();
                return (zPlanIntimateInfoView == null || U == null) ? CompletableDeferredKt.CompletableDeferred(Boolean.FALSE) : U;
            }
        }, new ZPlanIntimateInfoView$setLifecycleOwner$4(weakReference, null), new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$5
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
                Context context2;
                i.Companion companion = com.tencent.mobileqq.zplan.aio.couple.i.INSTANCE;
                context2 = ZPlanIntimateInfoView.this.context;
                companion.b(context2, "em_zplan_portal_entrance_friend_time");
            }
        }, new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                invoke2(onClickListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View.OnClickListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ZPlanIntimateInfoView.this.actionBtnClicker = it;
            }
        }, this.friendUin, new Function1<View.OnClickListener, Unit>() { // from class: com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View.OnClickListener onClickListener) {
                invoke2(onClickListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View.OnClickListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ZPlanIntimateInfoView.this.windowDismissClicker = it;
            }
        }), this.drawerIsOpened);
        View component1 = generatePanelViewAndAdapter.component1();
        ug3.a component2 = generatePanelViewAndAdapter.component2();
        arrayList.add(component1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        component1.setLayoutParams(layoutParams);
        this.sceneControlLayout.addView(component1);
        this.sceneControlAdapter = component2;
        int applyDimension = (int) TypedValue.applyDimension(1, 17.0f, this.sceneControlLayout.getContext().getResources().getDisplayMetrics());
        this.sceneControlLayout.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView$a", "Lcom/tencent/mobileqq/widget/BounceScrollView$d;", "", "l", "t", "oldl", "oldt", "", "onScrollChanged", "", HippyTKDListViewAdapter.X, "y", "ae", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements BounceScrollView.d {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void onScrollChanged(int l3, int t16, int oldl, int oldt) {
            Map mapOf;
            try {
                ZPlanIntimateInfoView.this.o0(t16);
            } catch (Exception e16) {
                QLog.e("ZPlanIntimateInfoView", 1, "setAvatarAlpha " + e16);
            }
            if (ZPlanIntimateInfoView.this.hasNotReportScroll) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
                VideoReport.reportEvent("ev_zplan_slide_down", mapOf);
                ZPlanIntimateInfoView.this.hasNotReportScroll = false;
            }
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void ae(float x16, float y16) {
        }
    }
}
