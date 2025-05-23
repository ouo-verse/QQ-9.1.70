package com.tencent.mobileqq.onlinestatus.view;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.aw;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusClickHelper;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusDialogHelper;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.observer.AccountObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001R\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001bB)\u0012\u0006\u0010Z\u001a\u00020Y\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010.\u001a\u00020\r\u00a2\u0006\u0004\b_\u0010`J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u001b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0016J\u001c\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0014J&\u0010'\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010.\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010-R\u0016\u0010M\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR$\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010W\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/StatusFoldView;", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment;", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPanel$a;", "Lcom/tencent/mobileqq/onlinestatus/aw$a;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$b;", "", "needUpdateItem", "Uh", "(Z)Ljava/lang/Boolean;", "", "Th", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "Yh", "Rh", "Xh", "", "width", "Wh", "onStart", DKHippyEvent.EVENT_STOP, "Landroid/view/View;", "targetView", "", "cardRect", "Ah", "show", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/onlinestatus/au;", "Lkotlin/collections/ArrayList;", "getDataList", "Qg", "", "yh", "oldItem", "curItem", "curView", "g2", "v", "l3", "statusItem", "Q9", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "J", "foldId", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/ViewGroup;", "mStatusContainerView", "Lcom/tencent/mobileqq/onlinestatus/bt;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/onlinestatus/bt;", "mOnlineStatusViewCtrl", "Lcom/tencent/mobileqq/onlinestatus/ba;", "T", "Lcom/tencent/mobileqq/onlinestatus/ba;", "mPanelParams", "Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusDialogHelper;", "U", "Lkotlin/Lazy;", "Oh", "()Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusDialogHelper;", "mDialogHelper", "Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusClickHelper;", "V", "Ph", "()Lcom/tencent/mobileqq/onlinestatus/utils/OnlineStatusClickHelper;", "mStatusClickHelper", "W", "Lmqq/app/AppRuntime$Status;", "mStatus", "X", "mExtStatus", "Y", "I", "mMaxColumn", "Z", "mMaxRow", "a0", "mNeedRefreshStatus", "com/tencent/mobileqq/onlinestatus/view/StatusFoldView$b", "b0", "Lcom/tencent/mobileqq/onlinestatus/view/StatusFoldView$b;", "mAccountObserver", "Qh", "()Ljava/util/ArrayList;", "statusList", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "onlineStatusBlurBg", "Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;", "dismissCallback", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/BaseStatusCardViewFragment$a;J)V", "c0", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class StatusFoldView extends BaseStatusCardViewFragment implements OnlineStatusPanel.a, aw.a {

    /* renamed from: Q, reason: from kotlin metadata */
    private final long foldId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ViewGroup mStatusContainerView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.onlinestatus.bt mOnlineStatusViewCtrl;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.ba mPanelParams;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDialogHelper;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy mStatusClickHelper;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private AppRuntime.Status mStatus;

    /* renamed from: X, reason: from kotlin metadata */
    private long mExtStatus;

    /* renamed from: Y, reason: from kotlin metadata */
    private int mMaxColumn;

    /* renamed from: Z, reason: from kotlin metadata */
    private int mMaxRow;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedRefreshStatus;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAccountObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/StatusFoldView$b", "Lmqq/observer/AccountObserver;", "", "isSuccess", "Lmqq/app/AppRuntime$Status;", "currentStatus", "", "extStatus", "isUserSet", "isChanged", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "isLargeChanged", "", "onOnlineStatusChanged", "onlineStatus", "extOnlineStatus", "onOnlineStatusPush", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends AccountObserver {
        b() {
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean isSuccess, @Nullable AppRuntime.Status currentStatus, long extStatus, boolean isUserSet, boolean isChanged, long timeStamp, boolean isLargeChanged) {
            if (isSuccess && currentStatus != null && extStatus != -1) {
                StatusFoldView.this.Yh(currentStatus, extStatus);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // mqq.observer.AccountObserver
        public void onOnlineStatusPush(@Nullable AppRuntime.Status onlineStatus, long extOnlineStatus) {
            if (onlineStatus != null && extOnlineStatus != -1) {
                StatusFoldView.this.Yh(onlineStatus, extOnlineStatus);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusFoldView(@NotNull QBaseActivity activity, @Nullable OnLineStatusBlurBg onLineStatusBlurBg, @NotNull BaseStatusCardViewFragment.a dismissCallback, long j3) {
        super(activity, dismissCallback);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.foldId = j3;
        this.mPanelParams = new com.tencent.mobileqq.onlinestatus.ba();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OnlineStatusDialogHelper>() { // from class: com.tencent.mobileqq.onlinestatus.view.StatusFoldView$mDialogHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OnlineStatusDialogHelper invoke() {
                return new OnlineStatusDialogHelper();
            }
        });
        this.mDialogHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<OnlineStatusClickHelper>() { // from class: com.tencent.mobileqq.onlinestatus.view.StatusFoldView$mStatusClickHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OnlineStatusClickHelper invoke() {
                return new OnlineStatusClickHelper();
            }
        });
        this.mStatusClickHelper = lazy2;
        this.mStatus = AppRuntime.Status.online;
        this.mMaxColumn = 3;
        this.mMaxRow = 4;
        this.mNeedRefreshStatus = true;
        this.mAccountObserver = new b();
        this.I = 1;
        this.N = onLineStatusBlurBg == null ? new OnLineStatusBlurBg() : onLineStatusBlurBg;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.f168881h51, (ViewGroup) null, false);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusFoldView.Mh(StatusFoldView.this, view);
            }
        });
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f88324wr);
        this.mStatusContainerView = viewGroup;
        this.D = viewGroup;
        this.C = inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(StatusFoldView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sh();
        BaseStatusCardViewFragment.a aVar = this$0.J;
        if (aVar != null) {
            aVar.L0(AppRuntime.Status.online, -100);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final OnlineStatusDialogHelper Oh() {
        return (OnlineStatusDialogHelper) this.mDialogHelper.getValue();
    }

    private final OnlineStatusClickHelper Ph() {
        return (OnlineStatusClickHelper) this.mStatusClickHelper.getValue();
    }

    private final ArrayList<com.tencent.mobileqq.onlinestatus.au> Qh() {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> g16 = com.tencent.mobileqq.config.business.ak.f202506a.a().g((int) this.foldId);
        if (g16 == null) {
            return new ArrayList<>();
        }
        return g16;
    }

    private final boolean Rh(final AppRuntime.Status status, final long extStatus) {
        OnlineStatusDialogHelper Oh = Oh();
        QBaseActivity mActivity = this.K;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        return Oh.b(mActivity, status, extStatus, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.az
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                StatusFoldView.Sh(StatusFoldView.this, status, extStatus, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(StatusFoldView this$0, AppRuntime.Status status, long j3, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        if (i3 == 1) {
            this$0.Xh(status, j3);
            this$0.sh();
        } else {
            com.tencent.mobileqq.onlinestatus.bt btVar = this$0.mOnlineStatusViewCtrl;
            if (btVar != null) {
                btVar.h(this$0.mStatus, this$0.mExtStatus);
            }
        }
    }

    private final void Th() {
        IOnlineStatusService iOnlineStatusService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppRuntime.Status status = null;
        if (peekAppRuntime != null) {
            iOnlineStatusService = (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        } else {
            iOnlineStatusService = null;
        }
        if (iOnlineStatusService != null) {
            status = iOnlineStatusService.getOnlineStatus();
        }
        if (status == null) {
            status = this.mStatus;
        }
        this.mStatus = status;
        this.mExtStatus = com.tencent.mobileqq.onlinestatus.af.C().M(peekAppRuntime);
    }

    private final Boolean Uh(final boolean needUpdateItem) {
        final ViewGroup viewGroup = this.mStatusContainerView;
        if (viewGroup != null) {
            return Boolean.valueOf(viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.bb
                @Override // java.lang.Runnable
                public final void run() {
                    StatusFoldView.Vh(viewGroup, this, needUpdateItem);
                }
            }));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(ViewGroup it, StatusFoldView this$0, boolean z16) {
        boolean z17;
        int i3;
        boolean z18;
        int i16;
        int i17;
        OnlineStatusPanel d16;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int dpToPx = ViewUtils.dpToPx(72.0f);
        int measuredWidth = it.getMeasuredWidth();
        if (measuredWidth <= 0) {
            measuredWidth = it.getWidth();
            QLog.d("StatusFoldView", 1, "prepareContentViews containerWidth <= 0, width: " + measuredWidth);
        }
        int i18 = measuredWidth;
        com.tencent.mobileqq.onlinestatus.bt btVar = this$0.mOnlineStatusViewCtrl;
        if (btVar == null) {
            int size = this$0.Qh().size();
            int i19 = this$0.mMaxColumn;
            int i26 = (size / i19) + 1;
            com.tencent.mobileqq.onlinestatus.ba baVar = this$0.mPanelParams;
            baVar.f255565d = i19;
            int i27 = this$0.mMaxRow;
            if (i26 <= i27 && i26 > 0) {
                i27 = i26;
            }
            baVar.f255564c = i27;
            baVar.f255562a = 3;
            baVar.f255568g = 12;
            baVar.f255570i = 16;
            baVar.f255566e = 16;
            baVar.f255567f = 16;
            baVar.f255574m = 16;
            int b16 = com.tencent.mobileqq.onlinestatus.utils.x.INSTANCE.b(baVar, dpToPx);
            if (i18 <= b16 && i18 > 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            com.tencent.mobileqq.onlinestatus.ba baVar2 = this$0.mPanelParams;
            if (z18) {
                i16 = b16;
            } else {
                i16 = i18;
            }
            baVar2.f255571j = i16;
            com.tencent.mobileqq.onlinestatus.bt btVar2 = new com.tencent.mobileqq.onlinestatus.bt(this$0.K, it, this$0, baVar2, this$0);
            this$0.mOnlineStatusViewCtrl = btVar2;
            btVar2.b();
            com.tencent.mobileqq.onlinestatus.bt btVar3 = this$0.mOnlineStatusViewCtrl;
            if (btVar3 != null && (d16 = btVar3.d()) != null) {
                d16.setBackgroundResource(R.drawable.k5k);
            }
            if (z18) {
                i17 = b16;
            } else {
                i17 = -1;
            }
            this$0.Wh(i17);
            QLog.d("StatusFoldView", 1, "prepareContentViews dataSize: " + size + " row: " + i26 + " maxRow: " + this$0.mMaxRow + " widthLess: " + z18 + " containerWidth: " + i18);
            return;
        }
        if (z16 && btVar != null) {
            btVar.l();
        }
        int b17 = com.tencent.mobileqq.onlinestatus.utils.x.INSTANCE.b(this$0.mPanelParams, dpToPx);
        if (i18 <= b17 && i18 > 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            b17 = i18;
        }
        int i28 = this$0.mPanelParams.f255571j;
        if (b17 != i28) {
            QLog.d("StatusFoldView", 1, "prepareContentViews widthLess: " + z17 + " containerWidth: " + i18 + " width: " + b17 + " currentWidth: " + i28);
            this$0.mPanelParams.f255571j = b17;
            if (z17) {
                i3 = b17;
            } else {
                i3 = -1;
            }
            this$0.Wh(i3);
            com.tencent.mobileqq.onlinestatus.bt btVar4 = this$0.mOnlineStatusViewCtrl;
            if (btVar4 != null) {
                btVar4.a(false);
            }
        }
    }

    private final void Wh(int width) {
        ViewGroup.LayoutParams layoutParams;
        OnlineStatusPanel d16;
        com.tencent.mobileqq.onlinestatus.bt btVar = this.mOnlineStatusViewCtrl;
        OnlineStatusPanel onlineStatusPanel = null;
        if (btVar != null && (d16 = btVar.d()) != null) {
            layoutParams = d16.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null && layoutParams.width != width) {
            layoutParams.width = width;
            com.tencent.mobileqq.onlinestatus.bt btVar2 = this.mOnlineStatusViewCtrl;
            if (btVar2 != null) {
                onlineStatusPanel = btVar2.d();
            }
            if (onlineStatusPanel != null) {
                onlineStatusPanel.setLayoutParams(layoutParams);
            }
        }
    }

    private final void Xh(AppRuntime.Status status, long extStatus) {
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(this.K, 1, R.string.hpk, 0).show();
            BaseStatusCardViewFragment.a aVar = this.J;
            if (aVar != null) {
                aVar.L0(AppRuntime.Status.online, -100);
                return;
            }
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        ((IOnlineStatusService) runtimeService).updateOnlineStatus(status, extStatus);
        BaseStatusCardViewFragment.a aVar2 = this.J;
        if (aVar2 != null) {
            aVar2.G0(status, extStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(AppRuntime.Status status, long extStatus) {
        if (this.mStatus != status || this.mExtStatus != extStatus) {
            this.mStatus = status;
            this.mExtStatus = extStatus;
            com.tencent.mobileqq.onlinestatus.bt btVar = this.mOnlineStatusViewCtrl;
            if (btVar != null) {
                btVar.h(status, extStatus);
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void Ah(@Nullable View targetView, @Nullable int[] cardRect) {
        if (cardRect != null) {
            if (targetView != null) {
                cardRect[0] = targetView.getWidth();
                cardRect[1] = targetView.getHeight();
            } else {
                cardRect[0] = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(78.0f);
                cardRect[1] = ViewUtils.dpToPx(300.0f);
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    @Nullable
    public ArrayList<com.tencent.mobileqq.onlinestatus.au> Qg() {
        com.tencent.mobileqq.onlinestatus.au i3 = com.tencent.mobileqq.config.business.ak.f202506a.a().i(this.mStatus, this.mExtStatus);
        Intrinsics.checkNotNullExpressionValue(i3, "bean.getOnlineStatusItem(mStatus, mExtStatus)");
        if (i3.B != this.foldId) {
            return null;
        }
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = new ArrayList<>();
        arrayList.add(i3);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void g2(@Nullable com.tencent.mobileqq.onlinestatus.au oldItem, @Nullable com.tencent.mobileqq.onlinestatus.au curItem, @Nullable View curView) {
        if (curItem == null) {
            sh();
            return;
        }
        if (Intrinsics.areEqual(oldItem, curItem)) {
            OnlineStatusClickHelper Ph = Ph();
            QBaseActivity mActivity = this.K;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            AppRuntime.Status status = curItem.f255494g;
            Intrinsics.checkNotNullExpressionValue(status, "curItem.oldStatus");
            Ph.b(mActivity, status, curItem.f255489b);
            return;
        }
        AppRuntime.Status status2 = curItem.f255494g;
        Intrinsics.checkNotNullExpressionValue(status2, "curItem.oldStatus");
        if (Rh(status2, curItem.f255489b)) {
            return;
        }
        AppRuntime.Status status3 = curItem.f255494g;
        Intrinsics.checkNotNullExpressionValue(status3, "curItem.oldStatus");
        Xh(status3, curItem.f255489b);
        sh();
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    @NotNull
    public ArrayList<com.tencent.mobileqq.onlinestatus.au> getDataList() {
        return Qh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNeedRefreshStatus) {
            Th();
            com.tencent.mobileqq.onlinestatus.bt btVar = this.mOnlineStatusViewCtrl;
            if (btVar != null) {
                btVar.h(this.mStatus, this.mExtStatus);
            }
        }
        Uh(false);
        this.mNeedRefreshStatus = false;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.registObserver(this.mAccountObserver);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mNeedRefreshStatus = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.unRegistObserver(this.mAccountObserver);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.onlinestatus.y
    public void show() {
        Th();
        this.mNeedRefreshStatus = false;
        rh();
        Uh(true);
        super.show();
        Gh(true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    @NotNull
    protected String yh() {
        String name = StatusFoldView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "StatusFoldView::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void l3(@Nullable View v3) {
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void Q9(@Nullable com.tencent.mobileqq.onlinestatus.au statusItem, @Nullable View v3) {
    }
}
