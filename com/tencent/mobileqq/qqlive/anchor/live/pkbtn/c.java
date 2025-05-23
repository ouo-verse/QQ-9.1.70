package com.tencent.mobileqq.qqlive.anchor.live.pkbtn;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.now.linkpkanchorplay.entrance.BottomOperatorButton;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lk4.e;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@ComponentEvent(eventList = {a.class})
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkbtn/c;", "Lcom/tencent/mobileqq/qqlive/framework/component/SingleUIComponent;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "Landroid/view/ViewGroup$MarginLayoutParams;", HippyTKDListViewAdapter.X, "", "k", "i", "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", h.F, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "qqLiveRoomService", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "Lfi2/a;", "cc", "<init>", "(Lfi2/a;)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends SingleUIComponent<FrameLayout> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    @InjectService(key = com.tencent.mobileqq.qqlive.base.room.service.a.class)
    private com.tencent.mobileqq.qqlive.base.room.service.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkbtn/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkbtn.c$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19253);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull fi2.a cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc5);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aegisLogger.i("PKBtnComponent", "pk\u6309\u94ae\u70b9\u51fb!");
        if (this$0.z()) {
            this$0.e().C0(new a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean z() {
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.id.f164636ta4;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FrameLayout p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FrameLayout frameLayout = new FrameLayout(e().getContext());
        BottomOperatorButton bottomOperatorButton = new BottomOperatorButton(e().getContext());
        int dimensionPixelSize = e().getContext().getResources().getDimensionPixelSize(R.dimen.f159089ck0);
        int dimensionPixelSize2 = e().getContext().getResources().getDimensionPixelSize(R.dimen.c5h);
        bottomOperatorButton.setSizeParams(new Size(dimensionPixelSize, dimensionPixelSize), new Size(dimensionPixelSize2, dimensionPixelSize2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        bottomOperatorButton.setLayoutParams(layoutParams);
        frameLayout.addView(bottomOperatorButton);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkbtn.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.w(c.this, view);
            }
        });
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent, com.tencent.mobileqq.qqlive.framework.component.i
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewGroup.MarginLayoutParams) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(e.b(e().getContext(), 50.0f), e.b(e().getContext(), 50.0f));
        marginLayoutParams.rightMargin = ViewUtils.dip2px(8.0f);
        marginLayoutParams.leftMargin = ViewUtils.dip2px(7.0f);
        return marginLayoutParams;
    }

    @NotNull
    public final int[] y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int[] iArr = new int[2];
        r().getLocationInWindow(iArr);
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 0) {
            iArr[0] = 0;
            iArr[1] = q.a(e().getContext(), 64.0f);
        } else {
            iArr[0] = iArr[0] - q.a(e().getContext(), 12.0f);
            iArr[1] = q.a(e().getContext(), 71.0f);
        }
        return iArr;
    }
}
