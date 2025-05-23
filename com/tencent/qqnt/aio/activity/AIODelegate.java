package com.tencent.qqnt.aio.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.frame.engine.AIOStartEnginektKt;
import com.tencent.aio.frame.engine.a;
import com.tencent.aio.monitor.PerfFrameCollector;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOHideEvent;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.event.ScaleAIOEvent;
import com.tencent.mobileqq.aio.utils.ba;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.qqnt.aio.activity.delegatevb.FullForegroundVB;
import com.tencent.qqnt.aio.activity.j;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.aio.api.IAIOFactoryClassApi;
import com.tencent.qqnt.aio.utils.AIOExpandFullScreenSwitch;
import com.tencent.qqnt.aio.utils.AIOOptConfigKt;
import com.tencent.qqnt.aio.utils.NTMsgUtil;
import com.tencent.qqnt.aio.widget.AIOGestureLayout;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.mainframe.api.IMainFrameApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u0002:\u00028HB\u0019\u0012\u0006\u0010\u0018\u001a\u00020N\u0012\u0006\u0010W\u001a\u00020\t\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u0003H\u0002J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020,H\u0016J\u000e\u0010/\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0005J\b\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\fH\u0016J\u0010\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0016J\u0018\u0010<\u001a\u00020\u00032\u0006\u00109\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\u00032\u0006\u00104\u001a\u00020\fH\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\u0016\u0010?\u001a\u00020\u00032\u0006\u00109\u001a\u00020\t2\u0006\u0010;\u001a\u00020:J\u0016\u0010@\u001a\u00020\u00032\u0006\u00109\u001a\u00020\t2\u0006\u0010;\u001a\u00020:J\u000e\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0001J\u0006\u0010C\u001a\u00020\u0003J\u0006\u0010D\u001a\u00020\u0003J\b\u0010F\u001a\u00020EH\u0016J\u0010\u0010H\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020\u0003H\u0016J\u0006\u0010K\u001a\u00020\u0003J\u0006\u0010L\u001a\u00020\u0003J\b\u0010M\u001a\u00020\u0003H\u0016R\"\u0010\u0018\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0017\u0010W\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b2\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010`\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010Y\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010Y\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010Y\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u0010Y\u001a\u0004\bm\u0010nR\u0018\u0010q\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010TR\u0016\u0010r\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010^R\u0016\u0010s\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010TR\u0016\u0010t\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010mR\u0016\u0010v\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010DR\u0016\u0010w\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010DR\u0016\u0010x\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010DR\"\u0010}\u001a\u00020E8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010y\u001a\u0004\bl\u0010z\"\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0082\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010DR)\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0005\b\u0019\u0010\u0083\u0001\u001a\u0005\bp\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b+\u0010\u0088\u0001R\u001e\u0010\u008c\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b#\u0010Y\u001a\u0005\bu\u0010\u008b\u0001R \u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\"\u0010\u008d\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bK\u0010\u008f\u0001RB\u0010\u0095\u0001\u001a.\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:0\u0092\u00010\u0091\u0001j\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:0\u0092\u0001`\u0093\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bL\u0010\u0094\u0001R\u001b\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0004\u0010\u0097\u0001\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/activity/AIODelegate;", "Lts/e$a;", "Lcom/tencent/qqnt/aio/activity/j;", "", "U", "", "o0", "updateData", "h0", "", "peerId", "nick", "", "chatType", "k0", HippyTKDListViewAdapter.X, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lus/a;", "j0", "Landroid/content/Intent;", "B", "M", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", ParseCommon.CONTAINER, "N", "y", "v", "", "uin", "a0", "p0", "O", "m0", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d0", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "chatFragmentProvider", "", "Lcom/tencent/qqnt/aio/activity/delegatevb/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "P", "Landroid/view/View;", "getAIORootView", "isScale", "K", "show", "hide", "e", "X", "state", "d", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "a", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", tl.h.F, "g", "c", "c0", "n0", "chatPieAttachListener", "e0", "Y", "Z", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "isEnable", "b", "f", "clearAIOCache", ExifInterface.LATITUDE_SOUTH, "T", "attachViewTree", "Lcom/tencent/qqnt/aio/e;", "Lcom/tencent/qqnt/aio/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/aio/e;", "setContainer", "(Lcom/tencent/qqnt/aio/e;)V", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Landroid/content/Context;", "Lkotlin/Lazy;", "E", "()Landroid/content/Context;", "mContext", "Landroid/view/Window;", "J", "()Landroid/view/Window;", "mWindow", "Landroidx/fragment/app/FragmentManager;", "i", "G", "()Landroidx/fragment/app/FragmentManager;", "mFragmentManager", "Lcom/tencent/qqnt/aio/api/IAIOFactoryClassApi;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "()Lcom/tencent/qqnt/aio/api/IAIOFactoryClassApi;", "mFactoryApi", "Lcom/tencent/qqnt/aio/interceptor/e;", BdhLogUtil.LogTag.Tag_Conn, "I", "()Lcom/tencent/qqnt/aio/interceptor/e;", "mSub", "D", "mPeerId", "mPeerUin", "mNick", "mChatType", "H", "mIsScale", "mIsMinAio", "isPerfEnable", "Lcom/tencent/aio/data/AIOContact;", "()Lcom/tencent/aio/data/AIOContact;", "f0", "(Lcom/tencent/aio/data/AIOContact;)V", "mAIOContact", "Lts/b;", "L", "Lts/b;", "aioAssistanceService", "mIsAIOShowed", "Lus/a;", "()Lus/a;", "g0", "(Lus/a;)V", "mChatFragmentProvider", "Lts/e$a;", "mChatPieAttachListener", "Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;", "()Lcom/tencent/qqnt/aio/widget/AIOGestureLayout;", "mRoot", "Ljava/util/List;", "mDelegateVBList", "Lcom/tencent/aio/data/AIOParam;", "mAIOParam", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mMsgActionList", "Lcom/tencent/aio/frame/api/c;", "Lcom/tencent/aio/frame/api/c;", "mDrawerFrameProvider", "<init>", "(Lcom/tencent/qqnt/aio/e;Ljava/lang/String;)V", "V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class AIODelegate implements e.a, j {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> W;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mSub;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mPeerId;

    /* renamed from: E, reason: from kotlin metadata */
    private long mPeerUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String mNick;

    /* renamed from: G, reason: from kotlin metadata */
    private int mChatType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsScale;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsMinAio;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isPerfEnable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private AIOContact mAIOContact;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ts.b aioAssistanceService;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsAIOShowed;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private us.a mChatFragmentProvider;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private e.a mChatPieAttachListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoot;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.qqnt.aio.activity.delegatevb.b> mDelegateVBList;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private AIOParam mAIOParam;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Pair<String, com.tencent.aio.runtime.message.b>> mMsgActionList;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.frame.api.c mDrawerFrameProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.aio.e container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mWindow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFragmentManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFactoryApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R4\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/activity/AIODelegate$a;", "", "Landroidx/fragment/app/Fragment;", "f", "", "a", "b", "Ljava/lang/ref/WeakReference;", "<set-?>", "Ljava/lang/ref/WeakReference;", "getBottomAIOFragment", "()Ljava/lang/ref/WeakReference;", "bottomAIOFragment", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f348427a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static WeakReference<Fragment> bottomAIOFragment;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39336);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                f348427a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(@NotNull Fragment f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) f16);
                return;
            }
            Intrinsics.checkNotNullParameter(f16, "f");
            if (bottomAIOFragment == null) {
                bottomAIOFragment = new WeakReference<>(f16);
            }
        }

        public final void b(@Nullable Fragment f16) {
            Fragment fragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) f16);
                return;
            }
            WeakReference<Fragment> weakReference = bottomAIOFragment;
            if (weakReference != null) {
                fragment = weakReference.get();
            } else {
                fragment = null;
            }
            if (f16 == fragment) {
                bottomAIOFragment = null;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/activity/AIODelegate$b;", "", "", "externalMsgUnRegisterSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "externalMsgUnRegisterSwitch", "", "ANIM_TOTAL_DURATION", "J", "FORCE_ENABLE_PERF_MONITOR", "Z", "", "SCALE_CORNERS", UserInfo.SEX_FEMALE, "SCALE_TOP_MARGIN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.activity.AIODelegate$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIODelegate.W.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/activity/AIODelegate$c", "Lcom/tencent/qqnt/aio/widget/h;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.qqnt.aio.widget.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.h
        public void dispatchTouchEvent(@NotNull MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5);
                return;
            }
            Intrinsics.checkNotNullParameter(ev5, "ev");
            us.a D = AIODelegate.this.D();
            if (D != null) {
                D.a(new GestureEvent.DispatchTouchEvent(ev5));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/activity/AIODelegate$d", "Lcom/tencent/qqnt/aio/widget/g;", "", "b", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements com.tencent.qqnt.aio.widget.g {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.g
        public void a() {
            us.a D;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            GestureEvent.RightSwipeEvent rightSwipeEvent = new GestureEvent.RightSwipeEvent(false, 1, null);
            us.a D2 = AIODelegate.this.D();
            if (D2 != null) {
                D2.a(rightSwipeEvent);
            }
            if (!rightSwipeEvent.a() && (D = AIODelegate.this.D()) != null) {
                Bundle bundle = new Bundle();
                bundle.putString("aio_disappear_type", "2");
                Unit unit = Unit.INSTANCE;
                D.a(new ExternalCommIntent("close_aio", new Bundle(bundle)));
            }
        }

        @Override // com.tencent.qqnt.aio.widget.g
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            us.a D = AIODelegate.this.D();
            if (D != null) {
                D.a(new GestureEvent.LeftSwipeEvent(false, 1, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Activity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            AIODelegate.this.a(ScaleAIOEvent.SwitchToFullScreen.f188709d);
            ((IMainFrameApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMainFrameApi.class)).backToConversation();
            Context E = AIODelegate.this.E();
            if (E instanceof Activity) {
                activity = (Activity) E;
            } else {
                activity = null;
            }
            if (activity != null) {
                ba.f194128a.a(activity);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIODelegate$Companion$externalMsgUnRegisterSwitch$2.INSTANCE);
        W = lazy;
    }

    public AIODelegate(@NotNull com.tencent.qqnt.aio.e container, @NotNull String tag) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container, (Object) tag);
            return;
        }
        this.container = container;
        this.tag = tag;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Context>() { // from class: com.tencent.qqnt.aio.activity.AIODelegate$mContext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Context invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AIODelegate.this.A().getContext() : (Context) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mContext = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Window>() { // from class: com.tencent.qqnt.aio.activity.AIODelegate$mWindow$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Window invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AIODelegate.this.A().getWindow() : (Window) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mWindow = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FragmentManager>() { // from class: com.tencent.qqnt.aio.activity.AIODelegate$mFragmentManager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FragmentManager invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AIODelegate.this.A().getSupportFragmentManager() : (FragmentManager) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mFragmentManager = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIODelegate$mFactoryApi$2.INSTANCE);
        this.mFactoryApi = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AIODelegate$mSub$2.INSTANCE);
        this.mSub = lazy5;
        this.mNick = "";
        this.mAIOContact = new AIOContact(0, "", "", null, 8, null);
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<AIOGestureLayout>() { // from class: com.tencent.qqnt.aio.activity.AIODelegate$mRoot$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIODelegate.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOGestureLayout invoke() {
                boolean P;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOGestureLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOGestureLayout aIOGestureLayout = new AIOGestureLayout(AIODelegate.this.E());
                AIODelegate aIODelegate = AIODelegate.this;
                P = aIODelegate.P();
                if (P) {
                    FrameLayout frameLayout = new FrameLayout(aIODelegate.E());
                    frameLayout.setId(R.id.tua);
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    aIOGestureLayout.addView(frameLayout);
                } else {
                    aIOGestureLayout.setId(R.id.tua);
                }
                return aIOGestureLayout;
            }
        });
        this.mRoot = lazy6;
        this.mMsgActionList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent B() {
        return this.container.getIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context E() {
        return (Context) this.mContext.getValue();
    }

    private final IAIOFactoryClassApi F() {
        return (IAIOFactoryClassApi) this.mFactoryApi.getValue();
    }

    private final FragmentManager G() {
        return (FragmentManager) this.mFragmentManager.getValue();
    }

    private final AIOGestureLayout H() {
        return (AIOGestureLayout) this.mRoot.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.aio.interceptor.e I() {
        return (com.tencent.qqnt.aio.interceptor.e) this.mSub.getValue();
    }

    private final Window J() {
        return (Window) this.mWindow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AIODelegate this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        us.a aVar = this$0.mChatFragmentProvider;
        if (aVar != null) {
            aVar.a(new ExternalCommIntent("close_aio", new Bundle()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int M() {
        if (this.mIsScale) {
            return ViewUtils.dip2px(88.0f);
        }
        return 0;
    }

    private final void N(RoundFrameLayout container) {
        if (!this.mIsScale) {
            return;
        }
        container.setRadius(ViewUtils.dip2px(16.0f));
        container.setCorners(3);
    }

    private final boolean O() {
        Integer num;
        AIOSession r16;
        AIOContact c16;
        AIOParam aIOParam = this.mAIOParam;
        if (aIOParam != null && (r16 = aIOParam.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        if (this.mIsScale && AIOExpandFullScreenSwitch.f352242a.a()) {
            if (num != null && num.intValue() == 1) {
                return true;
            }
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P() {
        return ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotAIO(String.valueOf(this.mPeerUin), Integer.valueOf(this.mChatType));
    }

    private final boolean Q() {
        if (this.mChatType == 103 && Intrinsics.areEqual(this.mPeerId, "u_2ZRcriDgt2a46svnxKPPMw")) {
            return true;
        }
        return false;
    }

    private final boolean R() {
        return !Q();
    }

    private final void U() {
        com.tencent.aio.frame.api.e g16;
        if (!this.mIsScale) {
            return;
        }
        QLog.d("AIODelegate", 1, "[onAIOAnimZoomIn] zoom in .");
        B().putExtra("key_is_scale_chat", false);
        int M = M();
        int dip2px = ViewUtils.dip2px(16.0f);
        this.mIsScale = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(M, 0);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.activity.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIODelegate.V(AIODelegate.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(dip2px, 0);
        ofInt2.setDuration(300L);
        ofInt2.setInterpolator(new LinearInterpolator());
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.activity.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIODelegate.W(AIODelegate.this, valueAnimator);
            }
        });
        com.tencent.aio.frame.api.c cVar = this.mDrawerFrameProvider;
        if (cVar != null && (g16 = cVar.g()) != null) {
            g16.h(true);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofInt, ofInt2);
        animatorSet.setDuration(300L);
        animatorSet.addListener(new e());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AIODelegate this$0, ValueAnimator valueAnimator) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        AIOGestureLayout H = this$0.H();
        ViewGroup.LayoutParams layoutParams = H.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMargins(0, intValue, 0, 0);
            H.setLayoutParams(marginLayoutParams);
            H.requestLayout();
            H.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(AIODelegate this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOGestureLayout H = this$0.H();
        Intrinsics.checkNotNull(valueAnimator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        H.setRadius(ViewUtils.dip2px(((Integer) r2).intValue()));
        H.setCorners(3);
        H.requestLayout();
        H.invalidate();
    }

    private final void a0(final long uin, final AIOParam aioParam) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.activity.g
                @Override // java.lang.Runnable
                public final void run() {
                    AIODelegate.b0(AIOParam.this, uin);
                }
            });
        } else {
            aioParam.l().putLong("key_peerUin", uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AIOParam aioParam, long j3) {
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        aioParam.l().putLong("key_peerUin", j3);
    }

    private final void d0() {
        try {
            us.a aVar = this.mChatFragmentProvider;
            if (aVar != null) {
                aVar.e(new Rect());
            }
        } catch (Exception e16) {
            QLog.e("AIODelegate", 1, "saveResetFitsSystemWindow error", e16);
        }
    }

    private final void h0(final boolean updateData) {
        String str = this.mPeerId;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            k0(str, this.mNick, this.mChatType, updateData);
        } else if (this.mPeerUin != 0) {
            HashSet<Long> hashSet = new HashSet<>();
            hashSet.add(Long.valueOf(this.mPeerUin));
            QLog.i("AIODelegate", 1, "needToConvertUin2Uid");
            ag j3 = com.tencent.qqnt.msg.f.j();
            if (j3 != null) {
                j3.getUid(hashSet, new IKernelGetUidInfoCallback() { // from class: com.tencent.qqnt.aio.activity.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                    public final void onResult(HashMap hashMap) {
                        AIODelegate.i0(AIODelegate.this, updateData, hashMap);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(AIODelegate this$0, boolean z16, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIODelegate", 1, "convertUin2Uid onResult uid is " + hashMap.get(Long.valueOf(this$0.mPeerUin)));
        String str = (String) hashMap.get(Long.valueOf(this$0.mPeerUin));
        if (str != null) {
            this$0.k0(str, this$0.mNick, this$0.mChatType, z16);
        }
    }

    private final us.a j0(AIOParam aioParam) {
        us.a d16;
        if (m0()) {
            this.mDrawerFrameProvider = com.tencent.qqnt.aio.frame.a.f349984a.a(aioParam);
            com.tencent.aio.main.engine.b bVar = com.tencent.aio.main.engine.b.f69377a;
            a.Companion companion = com.tencent.aio.frame.engine.a.INSTANCE;
            a.C0630a c0630a = new a.C0630a();
            c0630a.b(aioParam);
            c0630a.e(G());
            c0630a.c(R.id.tua);
            c0630a.d(this.mDrawerFrameProvider);
            d16 = AIOStartEnginektKt.b(bVar, c0630a.a(), null, 2, null);
        } else {
            d16 = com.tencent.aio.main.engine.b.d(com.tencent.aio.main.engine.b.f69377a, aioParam, G(), R.id.tua, null, 8, null);
        }
        a.f348427a.a(d16.h());
        return d16;
    }

    private final void k0(String peerId, String nick, int chatType, boolean updateData) {
        final AIODelegate$startAIOWithInterceptor$startFunc$1 aIODelegate$startAIOWithInterceptor$startFunc$1 = new AIODelegate$startAIOWithInterceptor$startFunc$1(chatType, this, peerId, nick, updateData);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.activity.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIODelegate.l0(AIODelegate$startAIOWithInterceptor$startFunc$1.this);
                }
            });
        } else {
            aIODelegate$startAIOWithInterceptor$startFunc$1.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(AIODelegate$startAIOWithInterceptor$startFunc$1 startFunc) {
        Intrinsics.checkNotNullParameter(startFunc, "$startFunc");
        startFunc.a();
    }

    private final boolean m0() {
        if (O()) {
            return com.tencent.qqnt.aio.utils.g.f352296a.a(this.mChatType, this.mPeerId, this.mPeerUin);
        }
        if (!this.mIsScale && com.tencent.qqnt.aio.utils.g.f352296a.a(this.mChatType, this.mPeerId, this.mPeerUin)) {
            return true;
        }
        return false;
    }

    private final boolean o0() {
        boolean z16;
        long j3;
        int i3;
        boolean z17;
        boolean equals$default;
        int i16;
        boolean z18;
        Intent B = B();
        String stringExtra = B.getStringExtra("key_peerId");
        int intExtra = B.getIntExtra("key_chat_type", 0);
        boolean booleanExtra = B.getBooleanExtra("key_is_scale_chat", false);
        boolean booleanExtra2 = B.getBooleanExtra("key_is_miniaio", false);
        long longExtra = B.getLongExtra("key_peerUin", 0L);
        boolean booleanExtra3 = B.getBooleanExtra("key_force_restart", false);
        if (booleanExtra3) {
            QLog.i("AIODelegate", 1, "[updateData]: peerId " + stringExtra + ", peerUin: " + longExtra + ", forceRestart: " + booleanExtra3);
            B.putExtra("key_force_restart", false);
        }
        String stringExtra2 = B.getStringExtra("key_chat_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.mNick = stringExtra2;
        if (!TextUtils.isEmpty(stringExtra)) {
            z16 = booleanExtra2;
            j3 = longExtra;
            equals$default = StringsKt__StringsJVMKt.equals$default(stringExtra, this.mPeerId, false, 2, null);
            if (equals$default && intExtra == (i16 = this.mChatType) && (z18 = this.mIsScale) == booleanExtra && !booleanExtra3) {
                QLog.i("AIODelegate", 1, "[updateData]: peerId " + this.mPeerId + ", chatType " + i16 + ", isScale " + z18 + ", forceRestart: " + booleanExtra3 + ", noChange");
                return false;
            }
        } else {
            z16 = booleanExtra2;
            j3 = longExtra;
            if (j3 > 0) {
                long j16 = this.mPeerUin;
                if (j3 == j16 && intExtra == (i3 = this.mChatType) && (z17 = this.mIsScale) == booleanExtra && !booleanExtra3) {
                    QLog.i("AIODelegate", 1, "[updateData]: peerUin " + j16 + ", chatType " + i3 + ", isScale " + z17 + ", forceRestart: " + booleanExtra3 + ", noChange");
                    return false;
                }
            }
        }
        this.mPeerId = stringExtra;
        this.mPeerUin = j3;
        this.mChatType = intExtra;
        this.mIsScale = booleanExtra;
        this.mIsMinAio = z16;
        return true;
    }

    private final void p0() {
        Bundle l3;
        AIOParam aIOParam = this.mAIOParam;
        if (aIOParam != null && (l3 = aIOParam.l()) != null) {
            l3.putAll(B().getExtras());
            long j3 = this.mPeerUin;
            if (j3 > 0) {
                l3.putLong("key_peerUin", j3);
            }
        }
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.a(AIOLifeCycleEvent.OnNewIntent.f348412d);
        }
    }

    private final void v(final String peerId, final AIOParam aioParam) {
        Long longOrNull;
        this.mPeerId = peerId;
        long j3 = this.mPeerUin;
        long j16 = 0;
        if (j3 == 0) {
            if (aioParam.r().c().e() == 2) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(peerId);
                if (longOrNull != null) {
                    j16 = longOrNull.longValue();
                }
                this.mPeerUin = j16;
                a0(j16, aioParam);
                Y();
                return;
            }
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(peerId);
            ag j17 = com.tencent.qqnt.msg.f.j();
            if (j17 != null) {
                j17.getUin(hashSet, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.aio.activity.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                    public final void onResult(HashMap hashMap) {
                        AIODelegate.w(peerId, this, aioParam, hashMap);
                    }
                });
                return;
            }
            return;
        }
        a0(j3, aioParam);
        QLog.i("AIODelegate", 1, "[addUinToBundle]: uin is " + this.mPeerUin);
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(String peerId, AIODelegate this$0, AIOParam aioParam, HashMap hashMap) {
        long longValue;
        Intrinsics.checkNotNullParameter(peerId, "$peerId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        QLog.i("AIODelegate", 1, "[addUinToBundle]: convertUin result is " + hashMap.get(peerId));
        Long l3 = (Long) hashMap.get(peerId);
        if (l3 != null) {
            this$0.a0(l3.longValue(), aioParam);
        }
        Long l16 = (Long) hashMap.get(peerId);
        if (l16 == null) {
            longValue = 0;
        } else {
            longValue = l16.longValue();
        }
        this$0.mPeerUin = longValue;
        this$0.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String peerId, String nick, int chatType, boolean updateData) {
        boolean z16;
        QLog.i("AIODelegate", 1, "[doStartAIO]: peerId is " + peerId + ", nick is " + com.tencent.qqnt.aio.utils.b.c(nick) + ", chatType is " + chatType);
        if (!this.container.isAttach()) {
            QLog.i("AIODelegate", 1, "[doStartAIO]: container is not add");
            return;
        }
        String str = "";
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        w msgService = ((IKernelService) runtimeService).getMsgService();
        if (msgService != null) {
            msgService.setFocusOnBase(new Contact(chatType, peerId, ""));
        }
        this.mIsAIOShowed = true;
        this.mAIOContact = new AIOContact(chatType, peerId, "", nick);
        AIOSession aIOSession = new AIOSession(this.mAIOContact);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_scale_chat", this.mIsScale);
        bundle.putAll(B().getExtras());
        bundle.putInt("key_msg_head_padding", F().getMsgHeadPadding(this.container.getContext(), this.mIsScale, false));
        bundle.putBoolean("key_update_msg_data", updateData);
        bundle.putBoolean("Key_toggle_opt_live_data", AIOOptConfigKt.h());
        bundle.putBoolean("key_toggle_opt_messenger", AIOOptConfigKt.i());
        bundle.putBoolean("Key_toggle_opt_dispatcher", AIOOptConfigKt.j());
        bundle.putBoolean("key_toggle_opt_concurrent_initialization", AIOOptConfigKt.l());
        bundle.putBoolean("key_toggle_opt_iterative_build_vm", AIOOptConfigKt.m());
        bundle.putBoolean("Key_tootle_opt_recycle_helper", AIOOptConfigKt.k());
        QLog.i("AIODelegate", 1, "KEY_TOGGLE_OPT_LIVE_DATA " + AIOOptConfigKt.h() + "  KEY_TOGGLE_OPT_MESSENGER " + AIOOptConfigKt.i() + " USE_CONCURRENT_INITIALIZATION " + AIOOptConfigKt.l() + " USE_AIOCORE_NEW_POSTER " + AIOOptConfigKt.j() + " KEY_TOGGLE_OPT_ITERATIVE_BUILD_VM " + AIOOptConfigKt.m() + " USE_AIOCORE_RECYCLE_HELPER  " + AIOOptConfigKt.k());
        long j3 = bundle.getLong(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME, 0L);
        if (j3 > 0) {
            com.tencent.qqnt.trace.d dVar = com.tencent.qqnt.trace.d.f362331a;
            dVar.d(j3);
            dVar.h(System.currentTimeMillis());
        }
        String y16 = y(chatType);
        if (!TextUtils.equals(y16, F().getC2CAIOFactory()) && !TextUtils.equals(y16, F().getGroupAIOFactory()) && !com.tencent.qqnt.aio.factory.b.f349915a.b(new com.tencent.qqnt.aio.factory.a(chatType, this.mIsScale, false, B().getExtras(), 4, null))) {
            z16 = false;
        } else {
            z16 = true;
        }
        AIOParam.a h16 = new AIOParam.a().i(z16).e(y16).a(bundle).h(aIOSession);
        ts.b createAIOAssistanceService = F().createAIOAssistanceService(this.container.getContext(), h16.c());
        this.aioAssistanceService = createAIOAssistanceService;
        this.mAIOParam = h16.b(createAIOAssistanceService).c();
        AIOGestureLayout H = H();
        if (H.getLayoutParams() == null) {
            H.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        }
        ViewGroup.LayoutParams layoutParams = H.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, M(), 0, 0);
        N(H);
        H.setTouchListener(new c());
        AIOParam aIOParam = this.mAIOParam;
        Intrinsics.checkNotNull(aIOParam);
        us.a j06 = j0(aIOParam);
        j06.g().b(this);
        this.mChatFragmentProvider = j06;
        AIOGestureLayout H2 = H();
        us.a aVar = this.mChatFragmentProvider;
        Intrinsics.checkNotNull(aVar);
        List<com.tencent.qqnt.aio.activity.delegatevb.b> z17 = z(H2, aVar);
        this.mDelegateVBList = z17;
        if (z17 != null) {
            Iterator<T> it = z17.iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.aio.activity.delegatevb.b) it.next()).d();
            }
        }
        if (R()) {
            H().setGestureDetector(new d());
            H().setInterceptScrollLRFlag(true);
            H().setInterceptScrollRLFlag(true);
            H().setIsInterceptChildEventWhenScroll(true);
        } else {
            H().m();
            H().setInterceptScrollLRFlag(false);
            H().setInterceptScrollRLFlag(false);
            H().setIsInterceptChildEventWhenScroll(false);
        }
        com.tencent.mobileqq.aio.utils.e.f194142a.g(H());
        AIOParam aIOParam2 = this.mAIOParam;
        Intrinsics.checkNotNull(aIOParam2);
        v(peerId, aIOParam2);
        h.f348481a.b(this);
        NTMsgUtil nTMsgUtil = NTMsgUtil.f352264a;
        int i3 = this.mChatType;
        String str2 = this.mPeerId;
        if (str2 != null) {
            str = str2;
        }
        nTMsgUtil.i(i3, str);
    }

    private final String y(int chatType) {
        return com.tencent.qqnt.aio.factory.b.f349915a.a(new com.tencent.qqnt.aio.factory.a(chatType, this.mIsScale, false, B().getExtras(), 4, null));
    }

    private final List<com.tencent.qqnt.aio.activity.delegatevb.b> z(ViewGroup rootView, us.a chatFragmentProvider) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new FullForegroundVB(rootView, chatFragmentProvider), new com.tencent.qqnt.aio.activity.delegatevb.a(rootView, chatFragmentProvider, this), new com.tencent.qqnt.aio.activity.delegatevb.d(rootView, chatFragmentProvider));
        return arrayListOf;
    }

    @NotNull
    public final com.tencent.qqnt.aio.e A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.container;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AIOContact C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOContact) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mAIOContact;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final us.a D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (us.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mChatFragmentProvider;
    }

    @NotNull
    public final View K(boolean isScale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, isScale);
        }
        if (isScale) {
            View aIORootView = getAIORootView();
            FrameLayout frameLayout = new FrameLayout(E());
            frameLayout.addView(aIORootView);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.activity.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIODelegate.L(AIODelegate.this, view);
                }
            });
            return frameLayout;
        }
        return getAIORootView();
    }

    public final void S() {
        boolean isEnabled;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion() && Build.VERSION.SDK_INT >= 29) {
            isEnabled = Trace.isEnabled();
            if (isEnabled) {
                Trace.endAsyncSection("onAIOAnim", 0);
            }
        }
        if (!this.isPerfEnable) {
            return;
        }
        PerfFrameCollector perfFrameCollector = PerfFrameCollector.H;
        if (perfFrameCollector.f()) {
            perfFrameCollector.e();
        }
    }

    public final void T() {
        boolean isEnabled;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion() && Build.VERSION.SDK_INT >= 29) {
            isEnabled = Trace.isEnabled();
            if (isEnabled) {
                Trace.beginAsyncSection("onAIOAnim", 0);
            }
        }
        if (!this.isPerfEnable) {
            return;
        }
        com.tencent.qqnt.trace.perf.b.f362361a.e();
        PerfFrameCollector.H.i();
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.i("AIODelegate", 1, "[onDestroy]: clearAIOCache");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        w msgService = ((IKernelService) runtimeService).getMsgService();
        if (msgService != null) {
            msgService.setFocusOnBase(new Contact(this.mChatType, "0", ""));
        }
        hide();
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.clearAIOCache();
        }
        this.mChatFragmentProvider = null;
    }

    public final void Y() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (!this.mIsAIOShowed) {
            QLog.d("AIODelegate", 1, "onEnterAioReport mIsAIOShowed false " + H().hashCode());
            return;
        }
        Intent B = B();
        if (B.getBooleanExtra("update_aio_by_msg_box", false)) {
            B.removeExtra("update_aio_by_msg_box");
            Z();
        }
        String stringExtra = B.getStringExtra("key_from");
        if (TextUtils.isEmpty(stringExtra)) {
            int intExtra = B.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
            if (6 == intExtra) {
                stringExtra = "10";
            } else if (7 == intExtra) {
                stringExtra = "1";
            }
        }
        String stringExtra2 = B.getStringExtra("key_page_id");
        String stringExtra3 = B.getStringExtra(WSStatisticsBaseCollector.KEY_REF_PAGE_ID);
        int intExtra2 = B.getIntExtra("key_page_stp", 0) + 1;
        HashMap hashMap = new HashMap();
        hashMap.put("aio_type", Integer.valueOf(this.mChatType));
        hashMap.put("subtype_aio_pg", Integer.valueOf(this.mChatType));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_UIN_TO, Long.valueOf(this.mPeerUin));
        if (stringExtra == null) {
            stringExtra = "14";
        }
        hashMap.put("source_aio_appear", stringExtra);
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        hashMap.put("current_mode", ((IAIOReport) companion.a(IAIOReport.class)).currentMode());
        com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
        hashMap.put("aio_morphology", bVar.b(this.mIsScale, this.mIsMinAio));
        String str = "";
        if (this.mChatType != 2) {
            obj = "";
        } else {
            obj = Long.valueOf(this.mPeerUin);
        }
        hashMap.put("group_id", obj);
        hashMap.put("slide_num", "");
        if (this.mChatType == 2) {
            hashMap.put("flame_type", Boolean.valueOf(((ITroopApi) companion.a(ITroopApi.class)).hasTroopFlame(String.valueOf(this.mPeerUin))));
            String stringExtra4 = B.getStringExtra(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE);
            if (stringExtra4 != null) {
                str = stringExtra4;
            }
            hashMap.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, str);
        }
        com.tencent.mobileqq.aio.utils.a d16 = new com.tencent.mobileqq.aio.utils.a().b(stringExtra2).d(intExtra2);
        if (stringExtra3 == null) {
            stringExtra3 = PageUtils.VR_PAGE_NONE;
        }
        bVar.h(H(), d16.e(stringExtra3).c(hashMap));
    }

    public final void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (!this.mIsAIOShowed) {
            QLog.i("AIODelegate", 1, "onExitAioReport mIsAIOShowed false " + H().hashCode());
            return;
        }
        com.tencent.mobileqq.aio.utils.b.f194119a.i(H());
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void a(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) msgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.a(msgIntent);
        }
    }

    @Override // ts.e.a
    public void attachViewTree() {
        com.tencent.aio.frame.api.c cVar;
        com.tencent.aio.frame.api.e g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        e.a aVar = this.mChatPieAttachListener;
        if (aVar != null) {
            aVar.attachViewTree();
        }
        List<? extends com.tencent.qqnt.aio.activity.delegatevb.b> list = this.mDelegateVBList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.aio.activity.delegatevb.b) it.next()).e();
            }
        }
        RFWNavigationBarImmersiveHelper.INSTANCE.tryRequestFitSystemWindows(H());
        Iterator<T> it5 = this.mMsgActionList.iterator();
        while (it5.hasNext()) {
            Pair pair = (Pair) it5.next();
            QLog.i("AIODelegate", 1, "[attachViewTree]: register " + pair.getFirst());
            us.a aVar2 = this.mChatFragmentProvider;
            if (aVar2 != null) {
                aVar2.i((String) pair.getFirst(), (com.tencent.aio.runtime.message.b) pair.getSecond());
            }
        }
        if (m0() && O() && (cVar = this.mDrawerFrameProvider) != null && (g16 = cVar.g()) != null) {
            g16.h(false);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void b(boolean isEnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, isEnable);
        } else {
            this.isPerfEnable = isEnable;
            PerfFrameCollector.H.h(isEnable);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return false;
    }

    public final void c0(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.i(actionCode, action);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void clearAIOCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        QLog.i("AIODelegate", 1, "clear aio msg cache");
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.clearAIOCache();
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void d(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, state);
            return;
        }
        if (state != 1) {
            if (state != 2) {
                if (state != 4) {
                    if (state == 5) {
                        X();
                        return;
                    }
                    return;
                }
                Z();
                return;
            }
            com.tencent.mobileqq.aio.utils.e.f194142a.g(H());
            return;
        }
        Y();
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mIsAIOShowed;
    }

    public final void e0(@NotNull e.a chatPieAttachListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) chatPieAttachListener);
        } else {
            Intrinsics.checkNotNullParameter(chatPieAttachListener, "chatPieAttachListener");
            this.mChatPieAttachListener = chatPieAttachListener;
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public boolean f() {
        k kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        ts.b bVar = this.aioAssistanceService;
        if (bVar instanceof k) {
            kVar = (k) bVar;
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0(@NotNull AIOContact aIOContact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aIOContact);
        } else {
            Intrinsics.checkNotNullParameter(aIOContact, "<set-?>");
            this.mAIOContact = aIOContact;
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void g(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, state);
            return;
        }
        switch (state) {
            case 101:
                T();
                return;
            case 102:
                S();
                return;
            case 103:
                U();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g0(@Nullable us.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.mChatFragmentProvider = aVar;
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public AIOContact getAIOContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (AIOContact) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mAIOContact;
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public View getAIORootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return H();
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void h(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        this.mMsgActionList.add(new Pair<>(actionCode, action));
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.i("AIODelegate", 1, "[hide]: nick is " + com.tencent.qqnt.aio.utils.b.c(this.mNick) + ", isAIOShow " + this.mIsAIOShowed + ", hashCode= " + hashCode());
        if (this.mIsAIOShowed) {
            us.a aVar = this.mChatFragmentProvider;
            if (aVar != null) {
                if (INSTANCE.b()) {
                    Iterator<T> it = this.mMsgActionList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        aVar.l((String) pair.getFirst(), (com.tencent.aio.runtime.message.b) pair.getSecond());
                    }
                    this.mMsgActionList.clear();
                }
                aVar.j(G());
                aVar.g().a(this);
                a.f348427a.b(aVar.h());
                d0();
            }
            List<? extends com.tencent.qqnt.aio.activity.delegatevb.b> list = this.mDelegateVBList;
            if (list != null) {
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.qqnt.aio.activity.delegatevb.b) it5.next()).c();
                }
            }
            this.mDelegateVBList = null;
            Z();
            this.mIsAIOShowed = false;
            h.f348481a.a(this);
            NTMsgUtil nTMsgUtil = NTMsgUtil.f352264a;
            int i3 = this.mChatType;
            String str = this.mPeerId;
            if (str == null) {
                str = "";
            }
            nTMsgUtil.l(i3, str);
            this.mAIOContact = new AIOContact(0, "", "", null, 8, null);
            SimpleEventBus.getInstance().dispatchEvent(new AIOHideEvent(String.valueOf(this.mPeerUin), this.mChatType, this.mNick));
        }
    }

    public final void n0(@NotNull String actionCode, @NotNull com.tencent.aio.runtime.message.b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) actionCode, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        us.a aVar = this.mChatFragmentProvider;
        if (aVar != null) {
            aVar.l(actionCode, action);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            j.b.a(this, i3, i16, intent);
        }
    }

    @Override // com.tencent.qqnt.aio.activity.j
    @NotNull
    public View show() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        QLog.i("AIODelegate", 1, "[show]: isAIOShow " + this.mIsAIOShowed + ", hashCode= " + hashCode());
        Intent B = B();
        com.tencent.qqnt.aio.utils.f fVar = com.tencent.qqnt.aio.utils.f.f352295a;
        if (fVar.f(fVar.b(B))) {
            boolean o06 = o0();
            if (o06 && this.mIsAIOShowed) {
                d0();
                z16 = true;
            } else {
                z16 = false;
            }
            if (!o06 && this.mIsAIOShowed) {
                p0();
            } else {
                ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).setWindowStyle(J());
                h0(o06);
            }
            if (z16) {
                QLog.i("AIODelegate", 1, "[show]: send ResetAIO");
                us.a aVar = this.mChatFragmentProvider;
                if (aVar != null) {
                    aVar.a(AIOLifeCycleEvent.ResetAIO.f348413d);
                }
            }
        } else {
            FragmentManager G = G();
            IAIOFactoryClassApi mFactoryApi = F();
            Intrinsics.checkNotNullExpressionValue(mFactoryApi, "mFactoryApi");
            fVar.c(R.id.tua, G, mFactoryApi);
        }
        return K(this.mIsScale);
    }
}
