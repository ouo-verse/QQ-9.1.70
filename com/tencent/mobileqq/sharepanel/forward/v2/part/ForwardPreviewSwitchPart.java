package com.tencent.mobileqq.sharepanel.forward.v2.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart;
import com.tencent.mobileqq.sharepanel.forward.v2.ForwardPreviewPanelFragmentV2;
import com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart$viewDelegate$2;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.FloatingRoundCorneredLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.forward.ForwardMiniAIODelegate;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00011\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart;", "Lcom/tencent/mobileqq/sharepanel/forward/part/ForwardPreviewBasePart;", "Landroid/view/View;", "contentView", "", "S9", "U9", "V9", "ea", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contactItem", "Z9", "Lcom/tencent/nt/adapter/session/e;", "sessionWithUid", "aa", "da", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "f", "I", "aioHeight", h.F, "panelWidth", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView;", "i", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView;", "switchView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "leftView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "switchContentContainer", "Lcom/tencent/qqnt/aio/forward/ForwardMiniAIODelegate;", "D", "Lcom/tencent/qqnt/aio/forward/ForwardMiniAIODelegate;", "aioPreview", "", "E", "Z", "isInRightView", "com/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart$viewDelegate$2$a", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "T9", "()Lcom/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart$viewDelegate$2$a;", "viewDelegate", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "G", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewSwitchPart extends ForwardPreviewBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout switchContentContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ForwardMiniAIODelegate aioPreview;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isInRightView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int aioHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int panelWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimateHorizontalSwitchView switchView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View leftView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart$b", "Lav3/a;", "Landroid/view/View;", "view", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements av3.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewSwitchPart.this);
            }
        }

        @Override // av3.a
        public boolean a(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(view, "view");
            AnimateHorizontalSwitchView animateHorizontalSwitchView = ForwardPreviewSwitchPart.this.switchView;
            if (animateHorizontalSwitchView != null) {
                animateHorizontalSwitchView.g(false);
                return true;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35707);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardPreviewSwitchPart(@NotNull com.tencent.mobileqq.sharepanel.forward.d param) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
            return;
        }
        this.aioHeight = (int) (ScreenUtil.SCREEN_HIGHT * 0.86f);
        this.panelWidth = ScreenUtil.SCREEN_WIDTH;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ForwardPreviewSwitchPart$viewDelegate$2.a>() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart$viewDelegate$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/sharepanel/forward/v2/part/ForwardPreviewSwitchPart$viewDelegate$2$a", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", "", "a", "d", "c", "", "isInSecondView", "", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes18.dex */
            public static final class a implements AnimateHorizontalSwitchView.b {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ForwardPreviewSwitchPart f287306a;

                a(ForwardPreviewSwitchPart forwardPreviewSwitchPart) {
                    this.f287306a = forwardPreviewSwitchPart;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) forwardPreviewSwitchPart);
                    }
                }

                @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
                public int a() {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        i3 = this.f287306a.panelWidth;
                        return i3;
                    }
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }

                /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
                
                    r4 = r3.f287306a.switchContentContainer;
                 */
                @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void b(boolean isInSecondView) {
                    LinearLayout linearLayout;
                    ForwardMiniAIODelegate forwardMiniAIODelegate;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                        this.f287306a.isInRightView = isInSecondView;
                        if (!isInSecondView && linearLayout != null) {
                            forwardMiniAIODelegate = this.f287306a.aioPreview;
                            linearLayout.removeView(forwardMiniAIODelegate);
                        }
                        AnimateHorizontalSwitchView animateHorizontalSwitchView = this.f287306a.switchView;
                        if (animateHorizontalSwitchView != null) {
                            ViewGroup.LayoutParams layoutParams = animateHorizontalSwitchView.getLayoutParams();
                            layoutParams.height = -2;
                            animateHorizontalSwitchView.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 5, (Object) this, isInSecondView);
                }

                @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
                public int c() {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        i3 = this.f287306a.aioHeight;
                        return i3;
                    }
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }

                @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
                public int d() {
                    View view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        view = this.f287306a.leftView;
                        if (view != null) {
                            return view.getHeight();
                        }
                        return 0;
                    }
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewSwitchPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(ForwardPreviewSwitchPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewDelegate = lazy;
    }

    private final void S9(View contentView) {
        int coerceAtMost;
        if (contentView == null) {
            return;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(ViewUtils.dip2px(500.0f), contentView.getContext().getResources().getDisplayMetrics().widthPixels);
        this.panelWidth = coerceAtMost;
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.panelWidth;
            contentView.setLayoutParams(layoutParams);
        }
    }

    private final ForwardPreviewSwitchPart$viewDelegate$2.a T9() {
        return (ForwardPreviewSwitchPart$viewDelegate$2.a) this.viewDelegate.getValue();
    }

    private final void U9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ForwardMiniAIODelegate forwardMiniAIODelegate = new ForwardMiniAIODelegate(context, null, 0, 6, null);
        forwardMiniAIODelegate.setLayoutParams(new ViewGroup.MarginLayoutParams(T9().a(), this.aioHeight));
        this.aioPreview = forwardMiniAIODelegate;
        forwardMiniAIODelegate.setOnBackListener(new b());
    }

    private final void V9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        LiveData<SharePanelContactItem> M1 = C9().M1();
        final Function1<SharePanelContactItem, Unit> function1 = new Function1<SharePanelContactItem, Unit>() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart$observeData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewSwitchPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SharePanelContactItem sharePanelContactItem) {
                invoke2(sharePanelContactItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable SharePanelContactItem sharePanelContactItem) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) sharePanelContactItem);
                } else {
                    if (sharePanelContactItem == null) {
                        return;
                    }
                    ForwardPreviewSwitchPart.this.Z9(sharePanelContactItem);
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ForwardPreviewSwitchPart.W9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(ForwardPreviewSwitchPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ForwardPreviewSwitchPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimateHorizontalSwitchView animateHorizontalSwitchView = this$0.switchView;
        if (animateHorizontalSwitchView != null) {
            animateHorizontalSwitchView.setToView(this$0.isInRightView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(final SharePanelContactItem contactItem) {
        ea();
        AnimateHorizontalSwitchView animateHorizontalSwitchView = this.switchView;
        if (animateHorizontalSwitchView != null) {
            ViewGroup.LayoutParams layoutParams = animateHorizontalSwitchView.getLayoutParams();
            layoutParams.height = T9().d();
            animateHorizontalSwitchView.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout = this.switchContentContainer;
        if (linearLayout != null && linearLayout.indexOfChild(this.aioPreview) < 0) {
            linearLayout.addView(this.aioPreview);
        }
        String e16 = contactItem.e();
        if (Intrinsics.areEqual(e16, AppConstants.DATALINE_PHONE_UIN)) {
            aa(new com.tencent.nt.adapter.session.e(PeerUid.DATALINE_PHONE_UID, 8), contactItem);
            return;
        }
        if (Intrinsics.areEqual(e16, AppConstants.DATALINE_PC_UIN)) {
            aa(new com.tencent.nt.adapter.session.e(PeerUid.DATALINE_PC_UID, 8), contactItem);
        } else if (Intrinsics.areEqual(e16, AppConstants.DATALINE_IPAD_UIN)) {
            aa(new com.tencent.nt.adapter.session.e(PeerUid.DATALINE_PAD_UID, 8), contactItem);
        } else {
            com.tencent.nt.adapter.session.c.j(contactItem.e(), contactItem.f(), new Function2<Boolean, com.tencent.nt.adapter.session.e, Unit>(contactItem) { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart$openAIO$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ SharePanelContactItem $contactItem;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$contactItem = contactItem;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardPreviewSwitchPart.this, (Object) contactItem);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.e eVar) {
                    invoke(bool.booleanValue(), eVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable com.tencent.nt.adapter.session.e eVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), eVar);
                    } else if (z16 && eVar != null) {
                        ForwardPreviewSwitchPart.this.aa(eVar, this.$contactItem);
                    } else {
                        QLog.e("ForwardPreviewSwitchPart", 1, "uid get failed !!!");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(final com.tencent.nt.adapter.session.e sessionWithUid, final SharePanelContactItem contactItem) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.f
            @Override // java.lang.Runnable
            public final void run() {
                ForwardPreviewSwitchPart.ba(ForwardPreviewSwitchPart.this, sessionWithUid, contactItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(final ForwardPreviewSwitchPart this$0, com.tencent.nt.adapter.session.e sessionWithUid, final SharePanelContactItem contactItem) {
        ForwardPreviewPanelFragmentV2 forwardPreviewPanelFragmentV2;
        FragmentManager childFragmentManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sessionWithUid, "$sessionWithUid");
        Intrinsics.checkNotNullParameter(contactItem, "$contactItem");
        IPartHost partHost = this$0.getPartHost();
        if (partHost instanceof ForwardPreviewPanelFragmentV2) {
            forwardPreviewPanelFragmentV2 = (ForwardPreviewPanelFragmentV2) partHost;
        } else {
            forwardPreviewPanelFragmentV2 = null;
        }
        if (forwardPreviewPanelFragmentV2 != null && (childFragmentManager = forwardPreviewPanelFragmentV2.getChildFragmentManager()) != null) {
            ForwardMiniAIODelegate forwardMiniAIODelegate = this$0.aioPreview;
            if (forwardMiniAIODelegate != null) {
                ForwardMiniAIODelegate.e(forwardMiniAIODelegate, childFragmentManager, sessionWithUid.a(), sessionWithUid.b(), contactItem.b(), null, 16, null);
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.g
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewSwitchPart.ca(ForwardPreviewSwitchPart.this, contactItem);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(ForwardPreviewSwitchPart this$0, SharePanelContactItem contactItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contactItem, "$contactItem");
        AnimateHorizontalSwitchView animateHorizontalSwitchView = this$0.switchView;
        if (animateHorizontalSwitchView != null) {
            animateHorizontalSwitchView.g(true);
        }
        this$0.da(contactItem);
    }

    private final void da(SharePanelContactItem contactItem) {
        Map<String, Object> a16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_pgid", "pg_share_mini_chat_box");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int f16 = contactItem.f();
        if (f16 != 0) {
            if (f16 == 1) {
                linkedHashMap2.put("aio_type", "2");
                linkedHashMap2.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, contactItem.e());
            }
        } else {
            linkedHashMap2.put("aio_type", "1");
            linkedHashMap2.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, contactItem.e());
        }
        com.tencent.mobileqq.sharepanel.forward.e b16 = B9().b();
        if (b16 != null && (a16 = b16.a()) != null) {
            linkedHashMap2.putAll(a16);
        }
        linkedHashMap.put("cur_pg", linkedHashMap2);
        VideoReport.reportEvent("ev_share_pgin", linkedHashMap);
    }

    private final void ea() {
        int i3;
        ForwardMiniAIODelegate forwardMiniAIODelegate = this.aioPreview;
        if (forwardMiniAIODelegate != null) {
            if (!AnimateHorizontalSwitchView.INSTANCE.a()) {
                i3 = T9().d();
            } else {
                i3 = (int) (forwardMiniAIODelegate.getContext().getResources().getDisplayMetrics().heightPixels * 0.86f);
            }
            this.aioHeight = i3;
            ViewGroup.LayoutParams layoutParams = forwardMiniAIODelegate.getLayoutParams();
            if (layoutParams != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                layoutParams.height = this.aioHeight;
                forwardMiniAIODelegate.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        View[] viewArr = {this.leftView, this.aioPreview};
        for (int i3 = 0; i3 < 2; i3++) {
            S9(viewArr[i3]);
        }
        View view = this.leftView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewSwitchPart.X9(ForwardPreviewSwitchPart.this);
                }
            });
        }
        AnimateHorizontalSwitchView animateHorizontalSwitchView = this.switchView;
        if (animateHorizontalSwitchView != null) {
            animateHorizontalSwitchView.post(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardPreviewSwitchPart.Y9(ForwardPreviewSwitchPart.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        FloatingRoundCorneredLayout floatingRoundCorneredLayout = (FloatingRoundCorneredLayout) rootView.findViewById(R.id.yey);
        if (floatingRoundCorneredLayout != null) {
            floatingRoundCorneredLayout.setCornerRadius(ViewUtils.dpToPx(20.0f));
        }
        AnimateHorizontalSwitchView animateHorizontalSwitchView = (AnimateHorizontalSwitchView) rootView.findViewById(R.id.f912054j);
        this.switchView = animateHorizontalSwitchView;
        if (animateHorizontalSwitchView != null) {
            animateHorizontalSwitchView.setDelegate(T9());
        }
        this.switchContentContainer = (LinearLayout) rootView.findViewById(R.id.f912754q);
        View findViewById = rootView.findViewById(R.id.yhe);
        this.leftView = findViewById;
        S9(findViewById);
        U9();
        V9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ForwardMiniAIODelegate forwardMiniAIODelegate = this.aioPreview;
        if (forwardMiniAIODelegate != null) {
            forwardMiniAIODelegate.c();
        }
    }
}
