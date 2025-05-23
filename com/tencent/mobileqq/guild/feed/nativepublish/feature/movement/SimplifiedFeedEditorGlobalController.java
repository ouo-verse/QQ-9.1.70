package com.tencent.mobileqq.guild.feed.nativepublish.feature.movement;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.InputAnimationControllerImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.guild.feed.util.be;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0002\b\u000b\u0018\u0000 L2\u00020\u0001:\u0002\u0016\u0013B\u001b\u0012\u0006\u0010(\u001a\u00020&\u0012\b\b\u0002\u0010,\u001a\u00020\u0018\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000f\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0004J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\u0018\u0010!\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u0017\u0010,\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R?\u0010G\u001a\u001f\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0000@BX\u0080.\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010#R\u0018\u0010d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010\\R,\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010f\u0018\u00010e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010_R\u0016\u0010o\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010_R\u0016\u0010p\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010_R\u0016\u0010q\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010_R\"\u0010v\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010_\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010)R*\u0010\u001a\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010)\u001a\u0004\bw\u0010+\"\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b|\u0010sR\u0014\u0010\u007f\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b~\u0010s\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "Lam1/a;", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "", "B", "U", "J", "com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$d", "r", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$d;", "com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "delayMillis", "b", "Landroid/view/View;", "input", "a", "T", "", "source", "closeIntent", "", "flag", HippyTKDListViewAdapter.X, "intent", "", "shouldStash", "H", "K", "I", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "binding", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "defaultCloseIntentOnCollapsed", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;", "c", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;", "getCallback", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;", "M", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;)V", "callback", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "w", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "P", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;)V", "panelStateUpdateListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isHalf", "e", "Lkotlin/jvm/functions/Function1;", "getDisplayModeChangeListener", "()Lkotlin/jvm/functions/Function1;", "O", "(Lkotlin/jvm/functions/Function1;)V", "displayModeChangeListener", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "<set-?>", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "v", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "inputAnimController", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorMovementEffect;", "g", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorMovementEffect;", "followPanelMovementEffect", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorFullScreenModeEffect;", "fullScreenModeEffect", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/c;", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/c;", "imeHelper", "j", "Ljava/lang/Runnable;", "pendingForceCheckImeActiveRunnable", "k", "Z", "isImeActivatedEver", "l", "forceCheckTimes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "checkEditorClosedRunnable", "Landroidx/core/util/Supplier;", "Landroid/app/Activity;", DomainData.DOMAIN_NAME, "Landroidx/core/util/Supplier;", "getActivityProvider", "()Landroidx/core/util/Supplier;", "L", "(Landroidx/core/util/Supplier;)V", "activityProvider", "isInitialized", "isSwitchingMode", "isCalledFinished", "isDisableFollowPanelEffect", "D", "()Z", "setHalfScreen", "(Z)V", "isHalfScreen", "t", "closeIntentStashed", "value", "N", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "isActivityFinishing", "E", "isInExpandingOrFoldingState", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SimplifiedFeedEditorGlobalController implements am1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimplifiedFeedEditorViewBinding binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultCloseIntentOnCollapsed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e.a panelStateUpdateListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> displayModeChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e inputAnimController;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private SimplifiedFeedEditorMovementEffect followPanelMovementEffect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SimplifiedFeedEditorFullScreenModeEffect fullScreenModeEffect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.c imeHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable pendingForceCheckImeActiveRunnable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isImeActivatedEver;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int forceCheckTimes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable checkEditorClosedRunnable;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Supplier<Activity> activityProvider;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isInitialized;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isSwitchingMode;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isCalledFinished;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isDisableFollowPanelEffect;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isHalfScreen;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String closeIntentStashed;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String closeIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$b;", "", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$a;", "", "foldState", "keyboardHeight", "", "c", "state", "onStateChanged", "d", "", "a", "Z", "isFirstExpanded", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isFirstExpanded;

        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void c(int foldState, int keyboardHeight) {
            if (SimplifiedFeedEditorGlobalController.this.pendingForceCheckImeActiveRunnable != null && foldState == 1) {
                SimplifiedFeedEditorGlobalController.this.isImeActivatedEver = true;
            }
            e.a panelStateUpdateListener = SimplifiedFeedEditorGlobalController.this.getPanelStateUpdateListener();
            if (panelStateUpdateListener != null) {
                panelStateUpdateListener.c(foldState, keyboardHeight);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void d() {
            boolean z16 = true;
            QLog.d("FeedEditor.GlobalController", 1, "[onCollapsed]: isHalf=" + SimplifiedFeedEditorGlobalController.this.getIsHalfScreen() + ", isCalledFinished=" + SimplifiedFeedEditorGlobalController.this.isCalledFinished + ", closeIntent=" + SimplifiedFeedEditorGlobalController.this.getCloseIntent());
            if (SimplifiedFeedEditorGlobalController.this.getIsHalfScreen() && !SimplifiedFeedEditorGlobalController.this.isCalledFinished) {
                if (SimplifiedFeedEditorGlobalController.this.getCloseIntent().length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    SimplifiedFeedEditorGlobalController.this.p();
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.a
        public void onStateChanged(int state) {
            e.a panelStateUpdateListener = SimplifiedFeedEditorGlobalController.this.getPanelStateUpdateListener();
            if (panelStateUpdateListener != null) {
                panelStateUpdateListener.onStateChanged(state);
            }
            if ((state & 7) == 1 && !this.isFirstExpanded) {
                this.isFirstExpanded = true;
                SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = SimplifiedFeedEditorGlobalController.this.followPanelMovementEffect;
                if (simplifiedFeedEditorMovementEffect == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
                    simplifiedFeedEditorMovementEffect = null;
                }
                simplifiedFeedEditorMovementEffect.l();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$c;", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "b", "()Landroid/view/ViewGroup;", "inputPanelContainer", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements e.c {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.c
        @NotNull
        public ViewGroup b() {
            return SimplifiedFeedEditorGlobalController.this.binding.getConstraintFixFrame();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.c
        @NotNull
        public View getRoot() {
            return SimplifiedFeedEditorGlobalController.this.binding.getRoot();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$f", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SimplifiedFeedEditorGlobalController.this.binding.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
            SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = SimplifiedFeedEditorGlobalController.this.followPanelMovementEffect;
            if (simplifiedFeedEditorMovementEffect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
                simplifiedFeedEditorMovementEffect = null;
            }
            simplifiedFeedEditorMovementEffect.m();
            return false;
        }
    }

    public SimplifiedFeedEditorGlobalController(@NotNull SimplifiedFeedEditorViewBinding binding, @NotNull String defaultCloseIntentOnCollapsed) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(defaultCloseIntentOnCollapsed, "defaultCloseIntentOnCollapsed");
        this.binding = binding;
        this.defaultCloseIntentOnCollapsed = defaultCloseIntentOnCollapsed;
        this.imeHelper = new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.c("FeedEditor.GlobalController");
        this.isHalfScreen = true;
        this.closeIntent = defaultCloseIntentOnCollapsed;
    }

    private final void B() {
        this.followPanelMovementEffect = new SimplifiedFeedEditorMovementEffect("FeedEditor.GlobalController", this.binding, v());
        this.fullScreenModeEffect = new SimplifiedFeedEditorFullScreenModeEffect(this.binding, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController$initializeEffect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = SimplifiedFeedEditorGlobalController.this.followPanelMovementEffect;
                if (simplifiedFeedEditorMovementEffect == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
                    simplifiedFeedEditorMovementEffect = null;
                }
                simplifiedFeedEditorMovementEffect.n(SimplifiedFeedEditorGlobalController.this.getIsHalfScreen());
                SimplifiedFeedEditorGlobalController.this.isSwitchingMode = false;
            }
        });
    }

    private final boolean C() {
        Activity activity;
        Supplier<Activity> supplier = this.activityProvider;
        boolean z16 = false;
        if (supplier != null && (activity = supplier.get()) != null && !activity.isFinishing()) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean E() {
        int a16 = com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.g.a(v());
        if (a16 != 3 && a16 != 2) {
            return false;
        }
        return true;
    }

    private final Runnable F() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.i
            @Override // java.lang.Runnable
            public final void run() {
                SimplifiedFeedEditorGlobalController.G(SimplifiedFeedEditorGlobalController.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(SimplifiedFeedEditorGlobalController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.C() && !this$0.isImeActivatedEver) {
            if (!com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.g.c(this$0.v()) || com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.g.b(this$0.v()) != 8) {
                QLog.i("FeedEditor.GlobalController", 1, "[showInputMethodAndDelayCheck]: keyboard isn't active once, try again, forceCheckTime=" + this$0.forceCheckTimes);
                int i3 = this$0.forceCheckTimes;
                if (i3 >= 3) {
                    SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = null;
                    this$0.pendingForceCheckImeActiveRunnable = null;
                    SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect2 = this$0.followPanelMovementEffect;
                    if (simplifiedFeedEditorMovementEffect2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
                    } else {
                        simplifiedFeedEditorMovementEffect = simplifiedFeedEditorMovementEffect2;
                    }
                    simplifiedFeedEditorMovementEffect.q();
                    return;
                }
                this$0.forceCheckTimes = i3 + 1;
                this$0.imeHelper.f();
                Runnable runnable = this$0.pendingForceCheckImeActiveRunnable;
                if (runnable != null) {
                    be.a(220L, runnable);
                }
            }
        }
    }

    private final void J() {
        InputAnimationControllerImpl inputAnimationControllerImpl = new InputAnimationControllerImpl("FeedEditor", new e());
        inputAnimationControllerImpl.i(r());
        inputAnimationControllerImpl.d(q());
        this.inputAnimController = inputAnimationControllerImpl;
    }

    private final void N(String str) {
        boolean z16;
        this.closeIntent = str;
        if (this.isHalfScreen) {
            U();
        }
        SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = this.followPanelMovementEffect;
        if (simplifiedFeedEditorMovementEffect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
            simplifiedFeedEditorMovementEffect = null;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        simplifiedFeedEditorMovementEffect.o(z16);
    }

    private final void Q() {
        this.binding.getRoot().getViewTreeObserver().addOnPreDrawListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(SimplifiedFeedEditorGlobalController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.imeHelper.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(SimplifiedFeedEditorGlobalController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.imeHelper.f();
    }

    private final void U() {
        boolean z16;
        SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = this.followPanelMovementEffect;
        if (simplifiedFeedEditorMovementEffect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
            simplifiedFeedEditorMovementEffect = null;
        }
        int i3 = 0;
        if (this.closeIntent.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = -1;
        }
        simplifiedFeedEditorMovementEffect.p(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        b bVar = this.callback;
        if (bVar != null) {
            bVar.a();
        }
        this.isCalledFinished = true;
    }

    private final c q() {
        return new c();
    }

    private final d r() {
        return new d();
    }

    public static /* synthetic */ void y(SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        simplifiedFeedEditorGlobalController.x(str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SimplifiedFeedEditorGlobalController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isCalledFinished) {
            QLog.d("FeedEditor.GlobalController", 1, "[checkEditorClosedRunnable]: editor is not closed yet, close it manually");
            this$0.p();
        }
    }

    public final void A() {
        Q();
        J();
        B();
        this.isInitialized = true;
    }

    /* renamed from: D, reason: from getter */
    public final boolean getIsHalfScreen() {
        return this.isHalfScreen;
    }

    public final void H(@Nullable String intent, boolean shouldStash) {
        if (shouldStash) {
            this.closeIntentStashed = this.closeIntent;
        }
        if (intent == null) {
            intent = this.defaultCloseIntentOnCollapsed;
        }
        N(intent);
    }

    public final void I() {
        this.isDisableFollowPanelEffect = true;
        SimplifiedFeedEditorFullScreenModeEffect simplifiedFeedEditorFullScreenModeEffect = this.fullScreenModeEffect;
        if (simplifiedFeedEditorFullScreenModeEffect == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fullScreenModeEffect");
            simplifiedFeedEditorFullScreenModeEffect = null;
        }
        simplifiedFeedEditorFullScreenModeEffect.r(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController$performDismissAnimation$1
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
                SimplifiedFeedEditorGlobalController.this.p();
            }
        });
    }

    public final void K() {
        String str = this.closeIntentStashed;
        if (str != null) {
            N(str);
        }
    }

    public final void L(@Nullable Supplier<Activity> supplier) {
        this.activityProvider = supplier;
    }

    public final void M(@Nullable b bVar) {
        this.callback = bVar;
    }

    public final void O(@Nullable Function1<? super Boolean, Unit> function1) {
        this.displayModeChangeListener = function1;
    }

    public final void P(@Nullable e.a aVar) {
        this.panelStateUpdateListener = aVar;
    }

    public final void T() {
        if (C()) {
            return;
        }
        this.imeHelper.f();
        this.isImeActivatedEver = false;
        if (this.pendingForceCheckImeActiveRunnable == null) {
            this.pendingForceCheckImeActiveRunnable = F();
        }
        View root = this.binding.getRoot();
        Runnable runnable = this.pendingForceCheckImeActiveRunnable;
        Intrinsics.checkNotNull(runnable);
        root.postDelayed(runnable, 220L);
    }

    @Override // am1.a
    public void a(@NotNull View input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.imeHelper.i(input);
    }

    @Override // am1.a
    public void b(long delayMillis) {
        if (!C()) {
            if (delayMillis > 0) {
                this.binding.getRoot().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimplifiedFeedEditorGlobalController.R(SimplifiedFeedEditorGlobalController.this);
                    }
                }, delayMillis);
            } else {
                this.binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimplifiedFeedEditorGlobalController.S(SimplifiedFeedEditorGlobalController.this);
                    }
                });
            }
        }
    }

    public final void o() {
        boolean z16 = this.isHalfScreen;
        if (!z16 && !this.isSwitchingMode) {
            if (E()) {
                return;
            }
            this.isHalfScreen = true;
            this.isSwitchingMode = true;
            Function1<? super Boolean, Unit> function1 = this.displayModeChangeListener;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            SimplifiedFeedEditorFullScreenModeEffect simplifiedFeedEditorFullScreenModeEffect = this.fullScreenModeEffect;
            if (simplifiedFeedEditorFullScreenModeEffect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenModeEffect");
                simplifiedFeedEditorFullScreenModeEffect = null;
            }
            simplifiedFeedEditorFullScreenModeEffect.A();
            return;
        }
        QLog.w("FeedEditor.GlobalController", 1, "[backToHalfScreenMode]: called in illegal state, " + z16 + ", " + this.isSwitchingMode);
    }

    public final void s() {
        boolean z16 = this.isHalfScreen;
        if (z16 && !this.isSwitchingMode) {
            if (E()) {
                return;
            }
            this.isSwitchingMode = true;
            this.isHalfScreen = false;
            Function1<? super Boolean, Unit> function1 = this.displayModeChangeListener;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            SimplifiedFeedEditorFullScreenModeEffect simplifiedFeedEditorFullScreenModeEffect = this.fullScreenModeEffect;
            if (simplifiedFeedEditorFullScreenModeEffect == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullScreenModeEffect");
                simplifiedFeedEditorFullScreenModeEffect = null;
            }
            simplifiedFeedEditorFullScreenModeEffect.z();
            return;
        }
        QLog.w("FeedEditor.GlobalController", 1, "[enterFullScreenMode]: called in illegal state, " + z16 + ", " + this.isSwitchingMode);
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getCloseIntent() {
        return this.closeIntent;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getDefaultCloseIntentOnCollapsed() {
        return this.defaultCloseIntentOnCollapsed;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e v() {
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e eVar = this.inputAnimController;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputAnimController");
        return null;
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public final e.a getPanelStateUpdateListener() {
        return this.panelStateUpdateListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r4 == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(@NotNull String source, @Nullable String closeIntent, int flag) {
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        boolean z17 = true;
        H(closeIntent, true);
        v().c(source, flag);
        if (closeIntent != null) {
            if (closeIntent.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        if (z17 && this.checkEditorClosedRunnable == null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.h
                @Override // java.lang.Runnable
                public final void run() {
                    SimplifiedFeedEditorGlobalController.z(SimplifiedFeedEditorGlobalController.this);
                }
            };
            be.a(400L, runnable);
            this.checkEditorClosedRunnable = runnable;
        }
    }

    public /* synthetic */ SimplifiedFeedEditorGlobalController(SimplifiedFeedEditorViewBinding simplifiedFeedEditorViewBinding, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(simplifiedFeedEditorViewBinding, (i3 & 2) != 0 ? "" : str);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e$b;", "", "height", "targetHeightHint", "", "a", "panelId", "targetHeight", "e", "f", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements e.b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void a(int height, int targetHeightHint) {
            if (!SimplifiedFeedEditorGlobalController.this.isDisableFollowPanelEffect) {
                SimplifiedFeedEditorMovementEffect simplifiedFeedEditorMovementEffect = SimplifiedFeedEditorGlobalController.this.followPanelMovementEffect;
                if (simplifiedFeedEditorMovementEffect == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followPanelMovementEffect");
                    simplifiedFeedEditorMovementEffect = null;
                }
                simplifiedFeedEditorMovementEffect.t(height, targetHeightHint);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void f() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e.b
        public void e(int panelId, int targetHeight) {
        }
    }
}
