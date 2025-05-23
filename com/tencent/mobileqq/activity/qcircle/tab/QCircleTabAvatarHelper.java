package com.tencent.mobileqq.activity.qcircle.tab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.bubble.QCircleTabRedPointBubbleShowController;
import com.tencent.mobileqq.activity.qcircle.utils.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qcircle.api.utils.RedPointInfoExtKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$StyleRed;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u001b\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0013\u0010\u0017\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\f\u0010!\u001a\u00020\u0002*\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\f\u0010%\u001a\u00020\b*\u00020\u0011H\u0002J\u001f\u0010&\u001a\u00020\u0002*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u001dJ!\u0010(\u001a\u00020\b*\u00020\u00112\b\b\u0002\u0010'\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J3\u0010+\u001a\u00020\b*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J\u0014\u0010-\u001a\u00020\u001e*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u00100J\u001b\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010D\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010C\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/tab/QCircleTabAvatarHelper;", "", "", BdhLogUtil.LogTag.Tag_Conn, "Lqqcircle/QQCircleCounter$RedPointInfo;", "redPointInfo", "Lcom/tencent/mobileqq/activity/qcircle/tab/UpdateTabAvatarSource;", "source", "", "N", "O", "J", "D", "I", "(Lqqcircle/QQCircleCounter$RedPointInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lqqcircle/QQCircleCounterStyle$StyleRed;", "redCornerInfo", "Landroid/widget/RelativeLayout;", "qCircleTab", "isAllowBubbleDemotion", "M", "(Lqqcircle/QQCircleCounterStyle$StyleRed;Landroid/widget/RelativeLayout;ZLqqcircle/QQCircleCounter$RedPointInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;", "redDisplayInfo", "Landroid/widget/FrameLayout;", "w", "(Landroid/widget/RelativeLayout;Lqqcircle/QQCircleCounterMsg$RedDisplayInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/View;", "y", "(Landroid/widget/RelativeLayout;Lqqcircle/QQCircleCounterStyle$StyleRed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "", "v", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "withAnimation", "G", "(Landroid/widget/RelativeLayout;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useDemotionCorner", "t", "(Landroid/widget/RelativeLayout;Lqqcircle/QQCircleCounter$RedPointInfo;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "cornerView", "L", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "K", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/Job;", "showTabAvatarJob", "c", "upgradeCornerJob", "d", "Lcom/tencent/mobileqq/activity/qcircle/tab/UpdateTabAvatarSource;", "avatarSourceForPrint", "e", "Z", "hasAvatarForPrint", "f", "hasRedCornerForPrint", "g", "withAnimationForPrint", h.F, "Ljava/lang/String;", "mOldCornerTagPrint", "i", "mCornerTagPrint", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job showTabAvatarJob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job upgradeCornerJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasAvatarForPrint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean hasRedCornerForPrint;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean withAnimationForPrint;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleTabAvatarHelper f184573a = new QCircleTabAvatarHelper();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static UpdateTabAvatarSource avatarSourceForPrint = UpdateTabAvatarSource.UPDATE_RED_POINT;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mOldCornerTagPrint = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCornerTagPrint = "";

    QCircleTabAvatarHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(Continuation<? super Unit> continuation) {
        QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1 qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1) {
            qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1 = (QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1) continuation;
            int i16 = qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Job job = upgradeCornerJob;
                    if (job != null) {
                        qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.label = 1;
                        if (JobKt.cancelAndJoin(job, qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                upgradeCornerJob = null;
                QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "cancelAndJoinUpgradeCornerJob success");
                return Unit.INSTANCE;
            }
        }
        qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1 = new QCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1(this, continuation);
        Object obj2 = qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabAvatarHelper$cancelAndJoinUpgradeCornerJob$1.label;
        if (i3 == 0) {
        }
        upgradeCornerJob = null;
        QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "cancelAndJoinUpgradeCornerJob success");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        Job job = showTabAvatarJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            showTabAvatarJob = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new QCircleTabAvatarHelper$hideTabAvatar$1(null), 3, null);
    }

    private final boolean E(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (!RedPointInfoExtKt.isMatchBubbleDemotion(qQCircleCounter$RedPointInfo)) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "isAllowBubbleDemotion, not matchBubbleDemotion");
            return false;
        }
        if (QCircleTabRedPointBubbleShowController.v()) {
            return true;
        }
        if (!QCircleRedDotDataHelper.isShowBubbleRedDot(qQCircleCounter$RedPointInfo)) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "isAllowBubbleDemotion, isShowBubbleRedDot false");
            return false;
        }
        if (RedPointInfoExtKt.isBubbleContentEmpty(qQCircleCounter$RedPointInfo)) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 4, "isAllowBubbleDemotion, bubble content empty");
            return false;
        }
        if (RedPointInfoExtKt.isBubbleExpired(qQCircleCounter$RedPointInfo)) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "isAllowBubbleDemotion, bubble expired");
            return false;
        }
        QQCircleCounter$RedPointInfo lastExposedBubble = QCircleFrame.getRedInfoBean().getLastExposedBubble();
        if (lastExposedBubble == null || !RedPointInfoExtKt.isSameBubble(qQCircleCounter$RedPointInfo, lastExposedBubble)) {
            return true;
        }
        QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "isAllowBubbleDemotion, bubble has showed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(RelativeLayout relativeLayout) {
        boolean z16;
        View findViewById = relativeLayout.findViewById(R.id.f32260t_);
        if (findViewById != null) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "removeAvatarView success, id=" + findViewById.getTag());
            relativeLayout.removeView(findViewById);
        }
        View f16 = QCircleTabRedPointBuildAvatarViewHelper.f184586a.f();
        if (f16 == null) {
            return;
        }
        if (f16.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "show qQCircle icon");
            f16.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object G(RelativeLayout relativeLayout, boolean z16, Continuation<? super Unit> continuation) {
        QCircleTabAvatarHelper$removeCornerView$1 qCircleTabAvatarHelper$removeCornerView$1;
        Object coroutine_suspended;
        int i3;
        View a16;
        if (continuation instanceof QCircleTabAvatarHelper$removeCornerView$1) {
            qCircleTabAvatarHelper$removeCornerView$1 = (QCircleTabAvatarHelper$removeCornerView$1) continuation;
            int i16 = qCircleTabAvatarHelper$removeCornerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$removeCornerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabAvatarHelper$removeCornerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabAvatarHelper$removeCornerView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        View view = (View) qCircleTabAvatarHelper$removeCornerView$1.L$1;
                        RelativeLayout relativeLayout2 = (RelativeLayout) qCircleTabAvatarHelper$removeCornerView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        a16 = view;
                        relativeLayout = relativeLayout2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    relativeLayout.removeOnLayoutChangeListener(QCircleTabRedPointBuildAvatarViewHelper.f184586a.h());
                    a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(relativeLayout);
                    if (a16 != null) {
                        if (withAnimationForPrint != z16) {
                            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "removeCorner success, withAnimation=" + z16);
                            withAnimationForPrint = z16;
                        }
                        if (z16) {
                            qCircleTabAvatarHelper$removeCornerView$1.L$0 = relativeLayout;
                            qCircleTabAvatarHelper$removeCornerView$1.L$1 = a16;
                            qCircleTabAvatarHelper$removeCornerView$1.label = 1;
                            if (K(a16, qCircleTabAvatarHelper$removeCornerView$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                relativeLayout.removeView(a16);
                return Unit.INSTANCE;
            }
        }
        qCircleTabAvatarHelper$removeCornerView$1 = new QCircleTabAvatarHelper$removeCornerView$1(this, continuation);
        Object obj2 = qCircleTabAvatarHelper$removeCornerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabAvatarHelper$removeCornerView$1.label;
        if (i3 == 0) {
        }
        relativeLayout.removeView(a16);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object H(QCircleTabAvatarHelper qCircleTabAvatarHelper, RelativeLayout relativeLayout, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return qCircleTabAvatarHelper.G(relativeLayout, z16, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0227 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object I(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, Continuation<? super Unit> continuation) {
        QCircleTabAvatarHelper$showAvatarRedPoint$1 qCircleTabAvatarHelper$showAvatarRedPoint$1;
        QCircleTabAvatarHelper$showAvatarRedPoint$1 qCircleTabAvatarHelper$showAvatarRedPoint$12;
        Object coroutine_suspended;
        Object firstOrNull;
        QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo;
        Object obj;
        QCircleTabAvatarHelper qCircleTabAvatarHelper;
        RelativeLayout relativeLayout;
        boolean z16;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2;
        RelativeLayout relativeLayout2;
        QCircleTabAvatarHelper qCircleTabAvatarHelper2;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo3;
        RelativeLayout relativeLayout3;
        QCircleTabAvatarHelper qCircleTabAvatarHelper3;
        QCircleTabAvatarHelper qCircleTabAvatarHelper4;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo4;
        RelativeLayout relativeLayout4;
        View a16;
        boolean z17;
        QCircleTabAvatarHelper qCircleTabAvatarHelper5;
        RelativeLayout relativeLayout5;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo5;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo6 = qQCircleCounter$RedPointInfo;
        if (continuation instanceof QCircleTabAvatarHelper$showAvatarRedPoint$1) {
            qCircleTabAvatarHelper$showAvatarRedPoint$1 = (QCircleTabAvatarHelper$showAvatarRedPoint$1) continuation;
            int i3 = qCircleTabAvatarHelper$showAvatarRedPoint$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$showAvatarRedPoint$1.label = i3 - Integer.MIN_VALUE;
                qCircleTabAvatarHelper$showAvatarRedPoint$12 = qCircleTabAvatarHelper$showAvatarRedPoint$1;
                Object obj2 = qCircleTabAvatarHelper$showAvatarRedPoint$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (qCircleTabAvatarHelper$showAvatarRedPoint$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        RelativeLayout g16 = QCircleTabRedPointBuildAvatarViewHelper.f184586a.g();
                        if (g16 == null) {
                            return Unit.INSTANCE;
                        }
                        QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed = qQCircleCounter$RedPointInfo6.allPushInfo.styleBottomTab.red.get();
                        Intrinsics.checkNotNullExpressionValue(qQCircleCounterStyle$StyleRed, "redPointInfo.allPushInfo.styleBottomTab.red.get()");
                        QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed2 = qQCircleCounterStyle$StyleRed;
                        boolean E = E(qQCircleCounter$RedPointInfo);
                        List<QQCircleCounterMsg$RedDisplayInfo> list = qQCircleCounter$RedPointInfo6.allPushInfo.styleBottomTab.button.icons.get();
                        Intrinsics.checkNotNullExpressionValue(list, "redPointInfo.allPushInfo\u2026tomTab.button.icons.get()");
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        qQCircleCounterMsg$RedDisplayInfo = (QQCircleCounterMsg$RedDisplayInfo) firstOrNull;
                        if (qQCircleCounterMsg$RedDisplayInfo == null) {
                            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "showAvatarRedPoint, but avatar list is empty");
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 1;
                            if (M(qQCircleCounterStyle$StyleRed2, g16, E, qQCircleCounter$RedPointInfo, qCircleTabAvatarHelper$showAvatarRedPoint$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        String v3 = v(qQCircleCounterMsg$RedDisplayInfo);
                        View findViewById = g16.findViewById(R.id.f32260t_);
                        if (findViewById != null) {
                            obj = findViewById.getTag();
                        } else {
                            obj = null;
                        }
                        QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "showAvatarRedPoint, isAllowBubbleDemotion=" + E + ", oldAvatarTag=" + obj + ", avatarTag=" + v3);
                        if (!Intrinsics.areEqual(obj, v3)) {
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = this;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo6;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = g16;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = qQCircleCounterMsg$RedDisplayInfo;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.Z$0 = E;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 2;
                            if (A(qCircleTabAvatarHelper$showAvatarRedPoint$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            qCircleTabAvatarHelper = this;
                            relativeLayout = g16;
                            z16 = E;
                            qCircleTabAvatarHelper.F(relativeLayout);
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo6;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = qQCircleCounterMsg$RedDisplayInfo;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.Z$0 = z16;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 3;
                            if (H(qCircleTabAvatarHelper, relativeLayout, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 1, null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            QCircleTabAvatarHelper qCircleTabAvatarHelper6 = qCircleTabAvatarHelper;
                            qQCircleCounter$RedPointInfo2 = qQCircleCounter$RedPointInfo6;
                            relativeLayout2 = relativeLayout;
                            qCircleTabAvatarHelper2 = qCircleTabAvatarHelper6;
                            if (!z16) {
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper2;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo2;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout2;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = qQCircleCounterMsg$RedDisplayInfo;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 4;
                                QCircleTabAvatarHelper qCircleTabAvatarHelper7 = qCircleTabAvatarHelper2;
                                QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo7 = qQCircleCounter$RedPointInfo2;
                                if (u(qCircleTabAvatarHelper2, relativeLayout2, qQCircleCounter$RedPointInfo2, true, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 4, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                qCircleTabAvatarHelper4 = qCircleTabAvatarHelper7;
                                RelativeLayout relativeLayout6 = relativeLayout2;
                                qQCircleCounter$RedPointInfo4 = qQCircleCounter$RedPointInfo7;
                                relativeLayout4 = relativeLayout6;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper4;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo4;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout4;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = null;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 5;
                                if (qCircleTabAvatarHelper4.s(relativeLayout4, qQCircleCounterMsg$RedDisplayInfo, qCircleTabAvatarHelper$showAvatarRedPoint$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                QCircleTabAvatarHelper qCircleTabAvatarHelper8 = qCircleTabAvatarHelper4;
                                a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(relativeLayout4);
                                if (a16 != null) {
                                    z17 = Intrinsics.areEqual(a16.getTag(R.id.f32270ta), Boxing.boxBoolean(true));
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper8;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo4;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout4;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 6;
                                    if (H(qCircleTabAvatarHelper8, relativeLayout4, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 1, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    qCircleTabAvatarHelper5 = qCircleTabAvatarHelper8;
                                    relativeLayout5 = relativeLayout4;
                                    qQCircleCounter$RedPointInfo5 = qQCircleCounter$RedPointInfo4;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = null;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = null;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = null;
                                    qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 7;
                                    if (u(qCircleTabAvatarHelper5, relativeLayout5, qQCircleCounter$RedPointInfo5, false, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 4, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            }
                            QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo8 = qQCircleCounter$RedPointInfo2;
                            QCircleTabAvatarHelper qCircleTabAvatarHelper9 = qCircleTabAvatarHelper2;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper9;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo8;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout2;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = null;
                            qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 8;
                            obj2 = qCircleTabAvatarHelper9.s(relativeLayout2, qQCircleCounterMsg$RedDisplayInfo, qCircleTabAvatarHelper$showAvatarRedPoint$12);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            qQCircleCounter$RedPointInfo3 = qQCircleCounter$RedPointInfo8;
                            relativeLayout3 = relativeLayout2;
                            qCircleTabAvatarHelper3 = qCircleTabAvatarHelper9;
                            if (((Boolean) obj2).booleanValue()) {
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = null;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = null;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = null;
                                qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 9;
                                if (u(qCircleTabAvatarHelper3, relativeLayout3, qQCircleCounter$RedPointInfo3, false, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 4, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 10;
                        if (M(qQCircleCounterStyle$StyleRed2, g16, E, qQCircleCounter$RedPointInfo, qCircleTabAvatarHelper$showAvatarRedPoint$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    case 2:
                        z16 = qCircleTabAvatarHelper$showAvatarRedPoint$12.Z$0;
                        QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo2 = (QQCircleCounterMsg$RedDisplayInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3;
                        RelativeLayout relativeLayout7 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo9 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper10 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        qQCircleCounterMsg$RedDisplayInfo = qQCircleCounterMsg$RedDisplayInfo2;
                        relativeLayout = relativeLayout7;
                        qQCircleCounter$RedPointInfo6 = qQCircleCounter$RedPointInfo9;
                        qCircleTabAvatarHelper = qCircleTabAvatarHelper10;
                        qCircleTabAvatarHelper.F(relativeLayout);
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo6;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = qQCircleCounterMsg$RedDisplayInfo;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.Z$0 = z16;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 3;
                        if (H(qCircleTabAvatarHelper, relativeLayout, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 1, null) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        z16 = qCircleTabAvatarHelper$showAvatarRedPoint$12.Z$0;
                        QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo3 = (QQCircleCounterMsg$RedDisplayInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3;
                        RelativeLayout relativeLayout8 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo10 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper11 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        qQCircleCounterMsg$RedDisplayInfo = qQCircleCounterMsg$RedDisplayInfo3;
                        relativeLayout2 = relativeLayout8;
                        qQCircleCounter$RedPointInfo2 = qQCircleCounter$RedPointInfo10;
                        qCircleTabAvatarHelper2 = qCircleTabAvatarHelper11;
                        if (!z16) {
                        }
                        break;
                    case 4:
                        QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo4 = (QQCircleCounterMsg$RedDisplayInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3;
                        RelativeLayout relativeLayout9 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo11 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper12 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        qQCircleCounterMsg$RedDisplayInfo = qQCircleCounterMsg$RedDisplayInfo4;
                        relativeLayout4 = relativeLayout9;
                        qQCircleCounter$RedPointInfo4 = qQCircleCounter$RedPointInfo11;
                        qCircleTabAvatarHelper4 = qCircleTabAvatarHelper12;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = qCircleTabAvatarHelper4;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = qQCircleCounter$RedPointInfo4;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = relativeLayout4;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$3 = null;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 5;
                        if (qCircleTabAvatarHelper4.s(relativeLayout4, qQCircleCounterMsg$RedDisplayInfo, qCircleTabAvatarHelper$showAvatarRedPoint$12) == coroutine_suspended) {
                        }
                        QCircleTabAvatarHelper qCircleTabAvatarHelper82 = qCircleTabAvatarHelper4;
                        a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(relativeLayout4);
                        if (a16 != null) {
                        }
                        if (!z17) {
                        }
                        return Unit.INSTANCE;
                    case 5:
                        relativeLayout4 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        qQCircleCounter$RedPointInfo4 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        qCircleTabAvatarHelper4 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        QCircleTabAvatarHelper qCircleTabAvatarHelper822 = qCircleTabAvatarHelper4;
                        a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(relativeLayout4);
                        if (a16 != null) {
                        }
                        if (!z17) {
                        }
                        return Unit.INSTANCE;
                    case 6:
                        RelativeLayout relativeLayout10 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo12 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper13 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        relativeLayout5 = relativeLayout10;
                        qQCircleCounter$RedPointInfo5 = qQCircleCounter$RedPointInfo12;
                        qCircleTabAvatarHelper5 = qCircleTabAvatarHelper13;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0 = null;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1 = null;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2 = null;
                        qCircleTabAvatarHelper$showAvatarRedPoint$12.label = 7;
                        if (u(qCircleTabAvatarHelper5, relativeLayout5, qQCircleCounter$RedPointInfo5, false, false, qCircleTabAvatarHelper$showAvatarRedPoint$12, 4, null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 7:
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    case 8:
                        RelativeLayout relativeLayout11 = (RelativeLayout) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$2;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo13 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper14 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$showAvatarRedPoint$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        relativeLayout3 = relativeLayout11;
                        qQCircleCounter$RedPointInfo3 = qQCircleCounter$RedPointInfo13;
                        qCircleTabAvatarHelper3 = qCircleTabAvatarHelper14;
                        if (((Boolean) obj2).booleanValue()) {
                        }
                        return Unit.INSTANCE;
                    case 9:
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    case 10:
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        qCircleTabAvatarHelper$showAvatarRedPoint$1 = new QCircleTabAvatarHelper$showAvatarRedPoint$1(this, continuation);
        qCircleTabAvatarHelper$showAvatarRedPoint$12 = qCircleTabAvatarHelper$showAvatarRedPoint$1;
        Object obj22 = qCircleTabAvatarHelper$showAvatarRedPoint$12.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (qCircleTabAvatarHelper$showAvatarRedPoint$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(QQCircleCounter$RedPointInfo redPointInfo) {
        Job launch$default;
        B();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new QCircleTabAvatarHelper$showTabAvatar$1(redPointInfo, null), 3, null);
        showTabAvatarJob = launch$default;
    }

    private final Object K(View view, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(250L);
        ofFloat.addListener(new a(ofFloat, safeContinuation));
        ofFloat.start();
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    private final Object L(View view, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        view.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(250L);
        ofFloat.addListener(new b(ofFloat, safeContinuation));
        ofFloat.start();
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object M(QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed, RelativeLayout relativeLayout, boolean z16, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, Continuation<? super Unit> continuation) {
        QCircleTabAvatarHelper$updateCornerView$1 qCircleTabAvatarHelper$updateCornerView$1;
        Object coroutine_suspended;
        int i3;
        Object obj;
        String str;
        QCircleTabAvatarHelper qCircleTabAvatarHelper;
        String obj2;
        QCircleTabAvatarHelper qCircleTabAvatarHelper2;
        RelativeLayout relativeLayout2;
        boolean z17;
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2;
        if (continuation instanceof QCircleTabAvatarHelper$updateCornerView$1) {
            qCircleTabAvatarHelper$updateCornerView$1 = (QCircleTabAvatarHelper$updateCornerView$1) continuation;
            int i16 = qCircleTabAvatarHelper$updateCornerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$updateCornerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj3 = qCircleTabAvatarHelper$updateCornerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabAvatarHelper$updateCornerView$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj3);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z18 = qCircleTabAvatarHelper$updateCornerView$1.Z$0;
                        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo3 = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$updateCornerView$1.L$2;
                        RelativeLayout relativeLayout3 = (RelativeLayout) qCircleTabAvatarHelper$updateCornerView$1.L$1;
                        QCircleTabAvatarHelper qCircleTabAvatarHelper3 = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$updateCornerView$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        z17 = z18;
                        qQCircleCounter$RedPointInfo2 = qQCircleCounter$RedPointInfo3;
                        relativeLayout2 = relativeLayout3;
                        qCircleTabAvatarHelper2 = qCircleTabAvatarHelper3;
                        qCircleTabAvatarHelper$updateCornerView$1.L$0 = null;
                        qCircleTabAvatarHelper$updateCornerView$1.L$1 = null;
                        qCircleTabAvatarHelper$updateCornerView$1.L$2 = null;
                        qCircleTabAvatarHelper$updateCornerView$1.label = 3;
                        if (u(qCircleTabAvatarHelper2, relativeLayout2, qQCircleCounter$RedPointInfo2, z17, false, qCircleTabAvatarHelper$updateCornerView$1, 4, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    z16 = qCircleTabAvatarHelper$updateCornerView$1.Z$0;
                    qQCircleCounter$RedPointInfo = (QQCircleCounter$RedPointInfo) qCircleTabAvatarHelper$updateCornerView$1.L$2;
                    relativeLayout = (RelativeLayout) qCircleTabAvatarHelper$updateCornerView$1.L$1;
                    qCircleTabAvatarHelper = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$updateCornerView$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                } else {
                    ResultKt.throwOnFailure(obj3);
                    String x16 = x(qQCircleCounterStyle$StyleRed);
                    View a16 = com.tencent.mobileqq.activity.qcircle.utils.a.a(relativeLayout);
                    if (a16 != null) {
                        obj = a16.getTag();
                    } else {
                        obj = null;
                    }
                    String str2 = "";
                    if (x16 == null) {
                        str = "";
                    } else {
                        str = x16;
                    }
                    if (obj != null && (obj2 = obj.toString()) != null) {
                        str2 = obj2;
                    }
                    if (!TextUtils.equals(str, mCornerTagPrint) || !TextUtils.equals(str2, mOldCornerTagPrint)) {
                        QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "showAvatarRedPoint, oldCornerTag=" + str2 + ", cornerTag=" + str);
                        mCornerTagPrint = str;
                        mOldCornerTagPrint = str2;
                    }
                    if (Intrinsics.areEqual(obj, x16) && !z16) {
                        return Unit.INSTANCE;
                    }
                    qCircleTabAvatarHelper$updateCornerView$1.L$0 = this;
                    qCircleTabAvatarHelper$updateCornerView$1.L$1 = relativeLayout;
                    qCircleTabAvatarHelper$updateCornerView$1.L$2 = qQCircleCounter$RedPointInfo;
                    qCircleTabAvatarHelper$updateCornerView$1.Z$0 = z16;
                    qCircleTabAvatarHelper$updateCornerView$1.label = 1;
                    if (A(qCircleTabAvatarHelper$updateCornerView$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qCircleTabAvatarHelper = this;
                }
                qCircleTabAvatarHelper$updateCornerView$1.L$0 = qCircleTabAvatarHelper;
                qCircleTabAvatarHelper$updateCornerView$1.L$1 = relativeLayout;
                qCircleTabAvatarHelper$updateCornerView$1.L$2 = qQCircleCounter$RedPointInfo;
                qCircleTabAvatarHelper$updateCornerView$1.Z$0 = z16;
                qCircleTabAvatarHelper$updateCornerView$1.label = 2;
                if (H(qCircleTabAvatarHelper, relativeLayout, false, qCircleTabAvatarHelper$updateCornerView$1, 1, null) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                qCircleTabAvatarHelper2 = qCircleTabAvatarHelper;
                relativeLayout2 = relativeLayout;
                z17 = z16;
                qQCircleCounter$RedPointInfo2 = qQCircleCounter$RedPointInfo;
                qCircleTabAvatarHelper$updateCornerView$1.L$0 = null;
                qCircleTabAvatarHelper$updateCornerView$1.L$1 = null;
                qCircleTabAvatarHelper$updateCornerView$1.L$2 = null;
                qCircleTabAvatarHelper$updateCornerView$1.label = 3;
                if (u(qCircleTabAvatarHelper2, relativeLayout2, qQCircleCounter$RedPointInfo2, z17, false, qCircleTabAvatarHelper$updateCornerView$1, 4, null) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        }
        qCircleTabAvatarHelper$updateCornerView$1 = new QCircleTabAvatarHelper$updateCornerView$1(this, continuation);
        Object obj32 = qCircleTabAvatarHelper$updateCornerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabAvatarHelper$updateCornerView$1.label;
        if (i3 == 0) {
        }
        qCircleTabAvatarHelper$updateCornerView$1.L$0 = qCircleTabAvatarHelper;
        qCircleTabAvatarHelper$updateCornerView$1.L$1 = relativeLayout;
        qCircleTabAvatarHelper$updateCornerView$1.L$2 = qQCircleCounter$RedPointInfo;
        qCircleTabAvatarHelper$updateCornerView$1.Z$0 = z16;
        qCircleTabAvatarHelper$updateCornerView$1.label = 2;
        if (H(qCircleTabAvatarHelper, relativeLayout, false, qCircleTabAvatarHelper$updateCornerView$1, 1, null) != coroutine_suspended) {
        }
    }

    @JvmStatic
    public static final void N(@NotNull final QQCircleCounter$RedPointInfo redPointInfo, @NotNull final UpdateTabAvatarSource source) {
        Intrinsics.checkNotNullParameter(redPointInfo, "redPointInfo");
        Intrinsics.checkNotNullParameter(source, "source");
        g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$updateTabAvatarStatus$1
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

            /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
            
                if (r2 != r1) goto L8;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                UpdateTabAvatarSource updateTabAvatarSource;
                boolean z16;
                boolean z17;
                boolean hasAvatar = RedPointInfoExtKt.hasAvatar(QQCircleCounter$RedPointInfo.this);
                boolean hasRedCorner = RedPointInfoExtKt.hasRedCorner(QQCircleCounter$RedPointInfo.this);
                updateTabAvatarSource = QCircleTabAvatarHelper.avatarSourceForPrint;
                if (updateTabAvatarSource == source) {
                    z16 = QCircleTabAvatarHelper.hasAvatarForPrint;
                    if (z16 == hasAvatar) {
                        z17 = QCircleTabAvatarHelper.hasRedCornerForPrint;
                    }
                }
                QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "updateTabAvatarStatus, source=" + source + ", hasAvatar=" + hasAvatar + ", hasRedCorner=" + hasRedCorner);
                QCircleTabAvatarHelper.avatarSourceForPrint = source;
                QCircleTabAvatarHelper.hasAvatarForPrint = hasAvatar;
                QCircleTabAvatarHelper.hasRedCornerForPrint = hasRedCorner;
                if (hasAvatar || hasRedCorner) {
                    QCircleTabAvatarHelper.f184573a.J(QQCircleCounter$RedPointInfo.this);
                } else {
                    QCircleTabAvatarHelper.f184573a.D();
                }
            }
        });
    }

    @JvmStatic
    public static final void O() {
        g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$upgradeCornerIfNeed$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$upgradeCornerIfNeed$1$1", f = "QCircleTabAvatarHelper.kt", i = {}, l = {118, 119, 120}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$upgradeCornerIfNeed$1$1, reason: invalid class name */
            /* loaded from: classes10.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Job $job;
                final /* synthetic */ RelativeLayout $qCircleTab;
                final /* synthetic */ QQCircleCounter$RedPointInfo $redPointInfo;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Job job, RelativeLayout relativeLayout, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$job = job;
                    this.$qCircleTab = relativeLayout;
                    this.$redPointInfo = qQCircleCounter$RedPointInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$job, this.$qCircleTab, this.$redPointInfo, continuation);
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    Object G;
                    Object t16;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            QCircleTabAvatarHelper qCircleTabAvatarHelper = QCircleTabAvatarHelper.f184573a;
                            RelativeLayout relativeLayout = this.$qCircleTab;
                            QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.$redPointInfo;
                            this.label = 3;
                            t16 = qCircleTabAvatarHelper.t(relativeLayout, qQCircleCounter$RedPointInfo, false, true, this);
                            if (t16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Job job = this.$job;
                        if (job != null) {
                            this.label = 1;
                            if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    QCircleTabAvatarHelper qCircleTabAvatarHelper2 = QCircleTabAvatarHelper.f184573a;
                    RelativeLayout relativeLayout2 = this.$qCircleTab;
                    this.label = 2;
                    G = qCircleTabAvatarHelper2.G(relativeLayout2, true, this);
                    if (G == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    QCircleTabAvatarHelper qCircleTabAvatarHelper3 = QCircleTabAvatarHelper.f184573a;
                    RelativeLayout relativeLayout3 = this.$qCircleTab;
                    QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2 = this.$redPointInfo;
                    this.label = 3;
                    t16 = qCircleTabAvatarHelper3.t(relativeLayout3, qQCircleCounter$RedPointInfo2, false, true, this);
                    if (t16 == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RelativeLayout g16;
                Job job;
                Job launch$default;
                QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
                RelativeLayout g17 = qCircleTabRedPointBuildAvatarViewHelper.g();
                View a16 = g17 != null ? com.tencent.mobileqq.activity.qcircle.utils.a.a(g17) : null;
                if (a16 != null ? Intrinsics.areEqual(a16.getTag(R.id.f32270ta), Boolean.TRUE) : false) {
                    Object tag = a16.getTag(R.id.f32310te);
                    QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = tag instanceof QQCircleCounter$RedPointInfo ? (QQCircleCounter$RedPointInfo) tag : null;
                    if (qQCircleCounter$RedPointInfo == null || (g16 = qCircleTabRedPointBuildAvatarViewHelper.g()) == null) {
                        return;
                    }
                    if (g16.findViewById(R.id.f32260t_) != null) {
                        job = QCircleTabAvatarHelper.upgradeCornerJob;
                        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(job, g16, qQCircleCounter$RedPointInfo, null), 3, null);
                        QCircleTabAvatarHelper.upgradeCornerJob = launch$default;
                    } else {
                        a16.setTag(R.id.f32270ta, Boolean.FALSE);
                        QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "upgradeCornerIfNeed\uff0c but avatarView is null");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(RelativeLayout relativeLayout, QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo, Continuation<? super Boolean> continuation) {
        QCircleTabAvatarHelper$addAvatarView$1 qCircleTabAvatarHelper$addAvatarView$1;
        Object coroutine_suspended;
        int i3;
        QCircleTabAvatarHelper qCircleTabAvatarHelper;
        FrameLayout frameLayout;
        if (continuation instanceof QCircleTabAvatarHelper$addAvatarView$1) {
            qCircleTabAvatarHelper$addAvatarView$1 = (QCircleTabAvatarHelper$addAvatarView$1) continuation;
            int i16 = qCircleTabAvatarHelper$addAvatarView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$addAvatarView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabAvatarHelper$addAvatarView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabAvatarHelper$addAvatarView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        qQCircleCounterMsg$RedDisplayInfo = (QQCircleCounterMsg$RedDisplayInfo) qCircleTabAvatarHelper$addAvatarView$1.L$2;
                        relativeLayout = (RelativeLayout) qCircleTabAvatarHelper$addAvatarView$1.L$1;
                        qCircleTabAvatarHelper = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$addAvatarView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    qCircleTabAvatarHelper$addAvatarView$1.L$0 = this;
                    qCircleTabAvatarHelper$addAvatarView$1.L$1 = relativeLayout;
                    qCircleTabAvatarHelper$addAvatarView$1.L$2 = qQCircleCounterMsg$RedDisplayInfo;
                    qCircleTabAvatarHelper$addAvatarView$1.label = 1;
                    obj = w(relativeLayout, qQCircleCounterMsg$RedDisplayInfo, qCircleTabAvatarHelper$addAvatarView$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qCircleTabAvatarHelper = this;
                }
                frameLayout = (FrameLayout) obj;
                if (frameLayout != null) {
                    return Boxing.boxBoolean(false);
                }
                frameLayout.setTag(qCircleTabAvatarHelper.v(qQCircleCounterMsg$RedDisplayInfo));
                View f16 = QCircleTabRedPointBuildAvatarViewHelper.f184586a.f();
                if (f16 == null) {
                    return Boxing.boxBoolean(false);
                }
                QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "hide qQCircle icon");
                f16.setVisibility(8);
                QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "addAvatarView success, tag=" + frameLayout.getTag() + ", obj=" + frameLayout.hashCode());
                relativeLayout.addView(frameLayout);
                return Boxing.boxBoolean(true);
            }
        }
        qCircleTabAvatarHelper$addAvatarView$1 = new QCircleTabAvatarHelper$addAvatarView$1(this, continuation);
        Object obj2 = qCircleTabAvatarHelper$addAvatarView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabAvatarHelper$addAvatarView$1.label;
        if (i3 == 0) {
        }
        frameLayout = (FrameLayout) obj2;
        if (frameLayout != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(RelativeLayout relativeLayout, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, boolean z16, boolean z17, Continuation<? super Unit> continuation) {
        QCircleTabAvatarHelper$addCornerView$1 qCircleTabAvatarHelper$addCornerView$1;
        Object coroutine_suspended;
        int i3;
        QQCircleCounterStyle$StyleRed redCornerInfo;
        QCircleTabAvatarHelper qCircleTabAvatarHelper;
        RelativeLayout relativeLayout2;
        QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed;
        View z18;
        if (continuation instanceof QCircleTabAvatarHelper$addCornerView$1) {
            qCircleTabAvatarHelper$addCornerView$1 = (QCircleTabAvatarHelper$addCornerView$1) continuation;
            int i16 = qCircleTabAvatarHelper$addCornerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qCircleTabAvatarHelper$addCornerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qCircleTabAvatarHelper$addCornerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qCircleTabAvatarHelper$addCornerView$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z17 = qCircleTabAvatarHelper$addCornerView$1.Z$0;
                    qQCircleCounterStyle$StyleRed = (QQCircleCounterStyle$StyleRed) qCircleTabAvatarHelper$addCornerView$1.L$2;
                    relativeLayout2 = (RelativeLayout) qCircleTabAvatarHelper$addCornerView$1.L$1;
                    qCircleTabAvatarHelper = (QCircleTabAvatarHelper) qCircleTabAvatarHelper$addCornerView$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    redCornerInfo = qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.red.get();
                    if (z16) {
                        z18 = z(relativeLayout, qQCircleCounter$RedPointInfo);
                        qCircleTabAvatarHelper = this;
                        if (z18 != null) {
                            Intrinsics.checkNotNullExpressionValue(redCornerInfo, "redCornerInfo");
                            z18.setTag(qCircleTabAvatarHelper.x(redCornerInfo));
                        }
                        if (z18 != null) {
                            QLog.i("QCircleTabRedPoint.TabAvatarHelper", 1, "addCornerView success, tag=" + z18.getTag() + ", obj=" + z18.hashCode() + ", withAnimation=" + z17);
                            relativeLayout.addView(z18);
                            relativeLayout.addOnLayoutChangeListener(QCircleTabRedPointBuildAvatarViewHelper.f184586a.h());
                            if (z17) {
                                qCircleTabAvatarHelper$addCornerView$1.L$0 = null;
                                qCircleTabAvatarHelper$addCornerView$1.L$1 = null;
                                qCircleTabAvatarHelper$addCornerView$1.L$2 = null;
                                qCircleTabAvatarHelper$addCornerView$1.label = 2;
                                if (qCircleTabAvatarHelper.L(z18, qCircleTabAvatarHelper$addCornerView$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    Intrinsics.checkNotNullExpressionValue(redCornerInfo, "redCornerInfo");
                    qCircleTabAvatarHelper$addCornerView$1.L$0 = this;
                    qCircleTabAvatarHelper$addCornerView$1.L$1 = relativeLayout;
                    qCircleTabAvatarHelper$addCornerView$1.L$2 = redCornerInfo;
                    qCircleTabAvatarHelper$addCornerView$1.Z$0 = z17;
                    qCircleTabAvatarHelper$addCornerView$1.label = 1;
                    Object y16 = y(relativeLayout, redCornerInfo, qCircleTabAvatarHelper$addCornerView$1);
                    if (y16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qCircleTabAvatarHelper = this;
                    relativeLayout2 = relativeLayout;
                    qQCircleCounterStyle$StyleRed = redCornerInfo;
                    obj = y16;
                }
                View view = (View) obj;
                redCornerInfo = qQCircleCounterStyle$StyleRed;
                relativeLayout = relativeLayout2;
                z18 = view;
                if (z18 != null) {
                }
                if (z18 != null) {
                }
                return Unit.INSTANCE;
            }
        }
        qCircleTabAvatarHelper$addCornerView$1 = new QCircleTabAvatarHelper$addCornerView$1(this, continuation);
        Object obj2 = qCircleTabAvatarHelper$addCornerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qCircleTabAvatarHelper$addCornerView$1.label;
        if (i3 == 0) {
        }
        View view2 = (View) obj2;
        redCornerInfo = qQCircleCounterStyle$StyleRed;
        relativeLayout = relativeLayout2;
        z18 = view2;
        if (z18 != null) {
        }
        if (z18 != null) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object u(QCircleTabAvatarHelper qCircleTabAvatarHelper, RelativeLayout relativeLayout, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, boolean z16, boolean z17, Continuation continuation, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if ((i3 & 2) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i3 & 4) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        return qCircleTabAvatarHelper.t(relativeLayout, qQCircleCounter$RedPointInfo, z18, z19, continuation);
    }

    private final String v(QQCircleCounterMsg$RedDisplayInfo redDisplayInfo) {
        return redDisplayInfo.avatarURL.get() + "_" + redDisplayInfo.headImg.get();
    }

    private final Object w(RelativeLayout relativeLayout, QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo, Continuation<? super FrameLayout> continuation) {
        QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
        String str = qQCircleCounterMsg$RedDisplayInfo.avatarURL.get();
        Intrinsics.checkNotNullExpressionValue(str, "redDisplayInfo.avatarURL.get()");
        String str2 = qQCircleCounterMsg$RedDisplayInfo.headImg.get();
        Intrinsics.checkNotNullExpressionValue(str2, "redDisplayInfo.headImg.get()");
        return qCircleTabRedPointBuildAvatarViewHelper.b(relativeLayout, str, str2, continuation);
    }

    private final String x(QQCircleCounterStyle$StyleRed redCornerInfo) {
        return redCornerInfo.typ.get() + "_" + redCornerInfo.wording.get() + "_" + redCornerInfo.url.get();
    }

    private final Object y(RelativeLayout relativeLayout, QQCircleCounterStyle$StyleRed qQCircleCounterStyle$StyleRed, Continuation<? super View> continuation) {
        if (qQCircleCounterStyle$StyleRed.typ.get() == 2) {
            QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
            String str = qQCircleCounterStyle$StyleRed.url.get();
            Intrinsics.checkNotNullExpressionValue(str, "redCornerInfo.url.get()");
            return qCircleTabRedPointBuildAvatarViewHelper.c(relativeLayout, str, continuation);
        }
        if (qQCircleCounterStyle$StyleRed.typ.get() == 1) {
            QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper2 = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
            String str2 = qQCircleCounterStyle$StyleRed.wording.get();
            Intrinsics.checkNotNullExpressionValue(str2, "redCornerInfo.wording.get()");
            return qCircleTabRedPointBuildAvatarViewHelper2.e(relativeLayout, str2);
        }
        return null;
    }

    private final View z(RelativeLayout relativeLayout, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        QCircleTabRedPointBuildAvatarViewHelper qCircleTabRedPointBuildAvatarViewHelper = QCircleTabRedPointBuildAvatarViewHelper.f184586a;
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View d16 = qCircleTabRedPointBuildAvatarViewHelper.d(context);
        d16.setTag(R.id.f32270ta, Boolean.TRUE);
        d16.setTag(R.id.f32310te, qQCircleCounter$RedPointInfo);
        return d16;
    }

    public final boolean C() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_tab_avatar_memory_leak_check", true);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/qcircle/tab/QCircleTabAvatarHelper$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f184582d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f184583e;

        /* JADX WARN: Multi-variable type inference failed */
        a(ObjectAnimator objectAnimator, Continuation<? super Unit> continuation) {
            this.f184582d = objectAnimator;
            this.f184583e = continuation;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            if (QCircleTabAvatarHelper.f184573a.C()) {
                this.f184582d.removeListener(this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (QCircleTabAvatarHelper.f184573a.C()) {
                this.f184582d.removeListener(this);
            }
            Continuation<Unit> continuation = this.f184583e;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/qcircle/tab/QCircleTabAvatarHelper$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f184584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f184585e;

        /* JADX WARN: Multi-variable type inference failed */
        b(ObjectAnimator objectAnimator, Continuation<? super Unit> continuation) {
            this.f184584d = objectAnimator;
            this.f184585e = continuation;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            if (QCircleTabAvatarHelper.f184573a.C()) {
                this.f184584d.removeListener(this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (QCircleTabAvatarHelper.f184573a.C()) {
                this.f184584d.removeListener(this);
            }
            Continuation<Unit> continuation = this.f184585e;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
