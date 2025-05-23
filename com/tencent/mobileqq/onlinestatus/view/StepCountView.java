package com.tencent.mobileqq.onlinestatus.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.onlinestatus.view.u;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0087\u0001\u0088\u0001B%\u0012\u0006\u0010A\u001a\u00020:\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J>\u0010\u0019\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0014J\b\u0010\u001d\u001a\u00020\tH\u0007J\"\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\tH\u0014J\b\u0010%\u001a\u00020\tH\u0016J\u001c\u0010)\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0014J\b\u0010*\u001a\u00020\u0013H\u0014J\"\u0010/\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u001e\u00104\u001a\u00020\t2\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001302H\u0016J\b\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\u000fH\u0014J\u0012\u00109\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u000107H\u0016R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010KR\u0018\u0010U\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010KR\u0014\u0010W\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010PR\u0014\u0010Y\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010PR\u0018\u0010[\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010KR\u0018\u0010]\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010KR(\u0010d\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010^8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010XR\u0016\u0010n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010XR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010tR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/StepCountView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$b;", "Lcom/tencent/mobileqq/onlinestatus/manager/OnlineStatusPermissionManager$b;", "Lcom/tencent/mobileqq/onlinestatus/StatusVisibleFragment$b;", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "change", "", "fi", "ai", "refreshUI", "hasPartPermission", "Uh", "", "url", "Landroid/widget/ImageView;", "imageView", "", "corner", "outWidth", "outHeight", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "ci", "Th", "ei", "rh", "Wh", "isSuccess", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "color", "v3", "show", "qh", DKHippyEvent.EVENT_STOP, "targetView", "", "cardRect", "Ah", "xh", "requestCode", AdMetricTag.RESPONSE_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusFriendsPermissionItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "smartSelectedList", Constants.SIM_INFO, "Eh", "yh", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "permissionItem", "Zb", "Lcom/tencent/mobileqq/app/QBaseActivity;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "mViewStepBg", "Landroid/widget/Button;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/Button;", "mViewSelectStatus", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "mTvStepCount", "U", "mTvStep", "V", "Landroid/view/View;", "mNightThemeBg", "W", "mViewSelectFriends", "X", "mViewChangeFriends", "Y", "mContentView", "Z", "mRootView", "a0", "mViewMainTitle", "b0", "mViewSubTitle", "Lh43/f;", "value", "c0", "Lh43/f;", "di", "(Lh43/f;)V", "mStepStatusInfo", "d0", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPermissionChecker$OnlineStatusPermissionItem;", "mPermissionItem", "e0", "Landroid/graphics/drawable/Drawable;", "mDefaultStepCountDrawable", "f0", "mNeedSwitchOnlineStatus", "g0", "mNeedCallbackOnStop", "Lcom/tencent/qphone/base/util/BaseApplication;", "h0", "Lcom/tencent/qphone/base/util/BaseApplication;", "mAppContext", "i0", "I", "mWidthBg", "j0", "mHeightBg", "", "k0", UserInfo.SEX_FEMALE, "mCornerBg", "Lh43/a;", "l0", "Lh43/a;", "mGetStepInfoCallback", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;", "dismissCallback", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;)V", "m0", "a", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class StepCountView extends BaseStatusCardViewFragment implements OnlineStatusPermissionManager.b, StatusVisibleFragment.b {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private QBaseActivity activity;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView mViewStepBg;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Button mViewSelectStatus;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private TextView mTvStepCount;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private TextView mTvStep;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View mNightThemeBg;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView mViewSelectFriends;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView mViewChangeFriends;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final View mContentView;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mViewMainTitle;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mViewSubTitle;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h43.f mStepStatusInfo;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnlineStatusPermissionChecker.OnlineStatusPermissionItem mPermissionItem;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mDefaultStepCountDrawable;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedSwitchOnlineStatus;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedCallbackOnStop;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BaseApplication mAppContext;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int mWidthBg;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int mHeightBg;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private float mCornerBg;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h43.a mGetStepInfoCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/StepCountView$b;", "Lh43/e;", "", "b", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/StepCountView;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "mViewRef", "stepCountView", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/StepCountView;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class b implements h43.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<StepCountView> mViewRef;

        public b(@NotNull StepCountView stepCountView) {
            Intrinsics.checkNotNullParameter(stepCountView, "stepCountView");
            this.mViewRef = new WeakReference<>(stepCountView);
        }

        @Override // h43.e
        public void a() {
            QLog.d("StepCountView", 1, "onPermissionDenied");
        }

        @Override // h43.e
        public void b() {
            QLog.d("StepCountView", 1, "onPermissionAllowed");
            StepCountView stepCountView = this.mViewRef.get();
            if (stepCountView != null) {
                stepCountView.ai();
                stepCountView.show();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepCountView(@NotNull QBaseActivity activity, @NotNull OnLineStatusBlurBg onLineStatusBlurBg, @NotNull BaseStatusCardViewFragment.a dismissCallback) {
        super(activity, dismissCallback);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onLineStatusBlurBg, "onLineStatusBlurBg");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.activity = activity;
        this.mNeedSwitchOnlineStatus = true;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mAppContext = context;
        this.mGetStepInfoCallback = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.view.bc
            @Override // h43.a
            public final void a(h43.f fVar) {
                StepCountView.Yh(StepCountView.this, fVar);
            }
        };
        this.I = 1;
        this.N = onLineStatusBlurBg;
        View createView = createView();
        this.mContentView = createView;
        createView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepCountView.Qh(StepCountView.this, view);
            }
        });
        View findViewById = createView.findViewById(R.id.f88384wx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.step_count_root)");
        this.mRootView = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepCountView.Rh(view);
            }
        });
        this.C = createView;
        this.D = findViewById;
        this.mWidthBg = this.mAppContext.getResources().getDisplayMetrics().widthPixels - Utils.n(80.0f, this.mAppContext.getResources());
        this.mHeightBg = Utils.n(207.0f, this.mAppContext.getResources());
        this.mCornerBg = 12 * com.tencent.mobileqq.utils.ah.q();
        Bitmap j3 = com.tencent.mobileqq.util.j.j(this.mAppContext.getResources(), R.drawable.f161170k63, this.mWidthBg, this.mHeightBg);
        if (j3 != null) {
            this.mDefaultStepCountDrawable = new BitmapDrawable(this.mAppContext.getResources(), BaseImageUtil.getHalfRoundedBitmap(j3, this.mCornerBg, this.mWidthBg, this.mHeightBg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(StepCountView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sh();
        this$0.J.L0(AppRuntime.Status.online, 2017);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Th() {
        if (QQTheme.isNowThemeIsNight()) {
            TextView textView = this.mTvStepCount;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mTvStep;
            if (textView2 != null) {
                textView2.setTextColor(-1);
                return;
            }
            return;
        }
        TextView textView3 = this.mTvStepCount;
        if (textView3 != null) {
            textView3.setTextColor(-16777216);
        }
        TextView textView4 = this.mTvStep;
        if (textView4 != null) {
            textView4.setTextColor(-16777216);
        }
    }

    private final void Uh(boolean hasPartPermission) {
        Resources resources = this.mAppContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "mAppContext.resources");
        String string = resources.getString(R.string.zpl);
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.c\u2026atus_all_friends_visible)");
        if (hasPartPermission) {
            string = resources.getString(R.string.zpr);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.c\u2026tus_part_friends_visible)");
        }
        String string2 = resources.getString(R.string.zpq);
        Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.c\u2026iends_visible_modify_tip)");
        TextView textView = this.mViewSelectFriends;
        if (textView != null) {
            textView.setText(string);
            textView.setContentDescription(string);
        }
        TextView textView2 = this.mViewChangeFriends;
        if (textView2 != null) {
            textView2.setText(string2);
            textView2.setClickable(true);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepCountView.Vh(StepCountView.this, view);
                }
            });
            textView2.setOnTouchListener(new u.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(StepCountView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StatusVisibleFragment.sh(this$0.activity, this$0.mPermissionItem, 4, 2017, this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(StepCountView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(this$0.activity, 1, R.string.hpk, 0).show();
            this$0.J.L0(AppRuntime.Status.online, 2017);
        } else {
            AppRuntime appRuntime = this$0.getAppRuntime();
            if (appRuntime != null) {
                IRuntimeService runtimeService = appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IOn\u2026va, ProcessConstant.MAIN)");
                com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.f.class);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
                OnlineStatusDataManager onlineStatusDataManager = (OnlineStatusDataManager) manager;
                Intent intent = new Intent();
                OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this$0.mPermissionItem;
                if (onlineStatusPermissionItem != null) {
                    intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
                }
                intent.putExtra("from_modify", !this$0.mNeedSwitchOnlineStatus);
                if (QLog.isColorLevel()) {
                    QLog.d("StepCountView", 2, "bindView: called. ", "needSwitchOnlineStatus: " + this$0.mNeedSwitchOnlineStatus);
                }
                onlineStatusDataManager.I(intent);
            }
        }
        this$0.J.G0(AppRuntime.Status.online, 2017L);
        this$0.sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(final StepCountView this$0, final h43.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bh
            @Override // java.lang.Runnable
            public final void run() {
                StepCountView.Zh(StepCountView.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(StepCountView this$0, h43.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.di(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai() {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null) {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(appRuntime.getCurrentUin(), Boolean.TRUE, this.mGetStepInfoCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(StepCountView this$0) {
        String str;
        int measuredWidth;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable drawable = this$0.mDefaultStepCountDrawable;
        if (drawable == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        Drawable drawable2 = drawable;
        h43.f fVar = this$0.mStepStatusInfo;
        if (fVar != null) {
            str = fVar.f404303b;
        } else {
            str = null;
        }
        String str2 = str;
        ImageView imageView = this$0.mViewStepBg;
        int i3 = (int) this$0.mCornerBg;
        if (imageView == null) {
            measuredWidth = this$0.mWidthBg;
        } else {
            Intrinsics.checkNotNull(imageView);
            measuredWidth = imageView.getMeasuredWidth();
        }
        this$0.ci(str2, imageView, i3, measuredWidth, this$0.mHeightBg, drawable2);
    }

    private final void ci(String url, ImageView imageView, int corner, int outWidth, int outHeight, Drawable defaultDrawable) {
        boolean z16;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = defaultDrawable;
        obtain.mFailedDrawable = defaultDrawable;
        obtain.mRequestWidth = outWidth;
        obtain.mRequestHeight = outHeight;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (imageView != null) {
                imageView.setImageDrawable(obtain.mFailedDrawable);
                return;
            }
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        if (corner > 0) {
            drawable.setTag(com.tencent.mobileqq.onlinestatus.utils.ah.a(obtain.mRequestWidth, obtain.mRequestHeight, corner));
            drawable.setDecodeHandler(com.tencent.mobileqq.onlinestatus.utils.ah.f256342b);
        }
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private final View createView() {
        View view = View.inflate(BaseApplication.context, R.layout.f168884h54, null);
        this.mViewStepBg = (ImageView) view.findViewById(R.id.yw7);
        this.mTvStepCount = (TextView) view.findViewById(R.id.f111546li);
        this.mTvStep = (TextView) view.findViewById(R.id.f111536lh);
        this.mViewSelectStatus = (Button) view.findViewById(R.id.f82444gw);
        this.mViewSelectFriends = (TextView) view.findViewById(R.id.f82144g3);
        this.mViewChangeFriends = (TextView) view.findViewById(R.id.f82034fs);
        this.mNightThemeBg = view.findViewById(R.id.zrj);
        this.mViewMainTitle = (TextView) view.findViewById(R.id.ywk);
        this.mViewSubTitle = (TextView) view.findViewById(R.id.f166931j64);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    private final void di(h43.f fVar) {
        this.mStepStatusInfo = fVar;
        refreshUI();
    }

    private final void ei() {
        boolean z16;
        boolean z17;
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null) {
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this.mPermissionItem;
            if (onlineStatusPermissionItem != null) {
                z16 = !onlineStatusPermissionItem.isAllHasPermission();
                IRuntimeService runtimeService = appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IOn\u2026va, ProcessConstant.MAIN)");
                com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
                z17 = ((OnlineStatusPermissionManager) manager).E(this.mPermissionItem, this);
            } else {
                z16 = false;
                z17 = false;
            }
            Uh(z16);
            fi(z17);
        }
    }

    private final void fi(boolean change) {
        AppRuntime appRuntime;
        int i3;
        Button button = this.mViewSelectStatus;
        if (button != null && (appRuntime = getAppRuntime()) != null) {
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IOnlineStatusService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IOn\u2026va, ProcessConstant.MAIN)");
            if (((IOnlineStatusService) runtimeService).getExtOnlineStatus() == 2017) {
                if (change) {
                    i3 = R.string.zpn;
                } else {
                    i3 = R.string.cne;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StepCountView", 2, "updateButtonText: called. ", "change: " + change);
                }
                this.mNeedSwitchOnlineStatus = !change;
                button.setText(HardCodeUtil.qqStr(i3));
                button.setEnabled(change);
                return;
            }
            button.setText(HardCodeUtil.qqStr(R.string.f171175cx0));
            button.setEnabled(true);
        }
    }

    private final void refreshUI() {
        boolean z16;
        String str;
        TextView textView = this.mTvStepCount;
        if (textView != null) {
            h43.f fVar = this.mStepStatusInfo;
            if (fVar == null || (str = Integer.valueOf(fVar.f404302a).toString()) == null) {
                str = "0";
            }
            textView.setText(str);
        }
        ImageView imageView = this.mViewStepBg;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bi
                @Override // java.lang.Runnable
                public final void run() {
                    StepCountView.bi(StepCountView.this);
                }
            });
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IOn\u2026va, ProcessConstant.MAIN)");
            com.tencent.mobileqq.onlinestatus.manager.j manager = ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager");
            OnlineStatusPermissionManager onlineStatusPermissionManager = (OnlineStatusPermissionManager) manager;
            OnlineStatusFriendsPermissionItem D = onlineStatusPermissionManager.D(40001L, false, this);
            if (D != null && !D.allHasPermission) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (OnlineStatusToggleUtils.w()) {
                onlineStatusPermissionManager.I(40001L, false);
            }
            Uh(z16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void Ah(@Nullable View targetView, @Nullable int[] cardRect) {
        if (cardRect != null) {
            if (targetView != null && targetView.getWidth() != 0 && targetView.getHeight() != 0) {
                cardRect[0] = targetView.getWidth();
                cardRect[1] = targetView.getHeight();
            } else {
                cardRect[0] = this.mWidthBg;
                cardRect[1] = Utils.n(392.0f, this.D.getResources());
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void Eh() {
        if (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            ai();
            show();
        } else {
            ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new b(this), null);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.b
    public void G6(@NotNull OnlineStatusFriendsPermissionItem item, @NotNull List<Integer> smartSelectedList) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(smartSelectedList, "smartSelectedList");
        if (this.mPermissionItem == null) {
            this.mPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, item.allHasPermission, item.permissionUins);
            ei();
        }
        if (OnlineStatusToggleUtils.w()) {
            ei();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void Wh() {
        Button button = this.mViewSelectStatus;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.bf
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StepCountView.Xh(StepCountView.this, view);
                }
            });
        }
        this.mNeedSwitchOnlineStatus = true;
        fi(false);
        refreshUI();
    }

    @Override // com.tencent.mobileqq.onlinestatus.StatusVisibleFragment.b
    public void Zb(@Nullable OnlineStatusPermissionChecker.OnlineStatusPermissionItem permissionItem) {
        this.mPermissionItem = permissionItem;
        ei();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int responseCode, @Nullable Intent data) {
        if (requestCode == 2017 && responseCode == -1 && data != null && data.getSerializableExtra("online_status_permission_item") != null) {
            Serializable serializableExtra = data.getSerializableExtra("online_status_permission_item");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem");
            this.mPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) serializableExtra;
            ei();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNeedCallbackOnStop) {
            this.J.L0(AppRuntime.Status.online, 2017);
        }
        this.mNeedCallbackOnStop = false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void qh() {
        this.mNeedCallbackOnStop = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void rh() {
        if (QQTheme.isNowThemeIsNight()) {
            this.mRootView.setBackgroundResource(R.drawable.kxv);
            v3(false, null, Color.parseColor("#FF010101"));
            View view = this.mNightThemeBg;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        this.mRootView.setBackgroundResource(R.drawable.qq_status_card_background);
        View view2 = this.mNightThemeBg;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        super.rh();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.onlinestatus.y
    public void show() {
        this.mPermissionItem = null;
        this.mNeedCallbackOnStop = true;
        Wh();
        rh();
        Th();
        try {
            Hh(this.mViewMainTitle);
            Hh(this.mViewSubTitle);
            super.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StepCountView", 2, "show: called. ", "", e16);
            }
        }
        Gh(true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.b
    public void v3(boolean isSuccess, @Nullable Bitmap bitmap, int color) {
        View view;
        if (isSuccess && bitmap != null && (view = this.mContentView) != null) {
            view.setBackgroundDrawable(new BitmapDrawable(bitmap));
            return;
        }
        View view2 = this.mContentView;
        if (view2 != null) {
            view2.setBackgroundColor(color);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected int xh() {
        return Utils.n(392.0f, this.D.getResources());
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    @NotNull
    protected String yh() {
        String name = StepCountView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "StepCountView::class.java.name");
        return name;
    }
}
