package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.VideoProgressView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u000f\u0010\u0012\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001e\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0013J\u000f\u0010 \u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b \u0010\u0013J\u000f\u0010!\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b!\u0010\u0013J\u000f\u0010\"\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\"\u0010\u0013J!\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b)\u0010\u0013J\u000f\u0010*\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b*\u0010\u0013J\u000f\u0010+\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b+\u0010\u0013R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\n 1*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0014\u00106\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010>R$\u0010F\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/n;", "", "Landroid/widget/FrameLayout;", "g", HippyNestedScrollComponent.PRIORITY_PARENT, "", "e", "d", "b", "y", "j", "", "key", "f", "l", "w", "E", UserInfo.SEX_FEMALE, "t", "()V", "", "percent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "p", "progress", "v", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "u", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "k", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorStatus;", "videoErrorStatus", "text", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorStatus;Ljava/lang/String;)V", "D", "i", DomainData.DOMAIN_NAME, tl.h.F, "Landroid/widget/RelativeLayout;", "a", "Landroid/widget/RelativeLayout;", "parentView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", "c", "Landroid/widget/FrameLayout;", "statusView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoStateIconView;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoStateIconView;", "stateIconView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "msgSendStateIconView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/f;", "progressController", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getOnClickMsgStatusIcon", "()Landroid/view/View$OnClickListener;", HippyTKDListViewAdapter.X, "(Landroid/view/View$OnClickListener;)V", "onClickMsgStatusIcon", "", "Z", "allowClickStatusIcon", "<init>", "(Landroid/widget/RelativeLayout;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout parentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout statusView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOVideoStateIconView stateIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView msgSendStateIconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f progressController;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onClickMsgStatusIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean allowClickStatusIcon;

    public n(@NotNull RelativeLayout parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentView);
            return;
        }
        this.parentView = parentView;
        this.context = parentView.getContext();
        FrameLayout g16 = g();
        this.statusView = g16;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(5, R.id.kso);
        layoutParams.addRule(6, R.id.kso);
        layoutParams.addRule(7, R.id.kso);
        layoutParams.addRule(8, R.id.kso);
        Unit unit = Unit.INSTANCE;
        parentView.addView(g16, layoutParams);
    }

    public static /* synthetic */ void B(n nVar, VideoErrorStatus videoErrorStatus, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        nVar.A(videoErrorStatus, str);
    }

    private final void b() {
        final ImageView imageView = new ImageView(this.context);
        imageView.setVisibility(8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.c(n.this, imageView, view);
            }
        });
        this.msgSendStateIconView = imageView;
        this.parentView.setLayoutDirection(1);
        RelativeLayout relativeLayout = this.parentView;
        ImageView imageView2 = this.msgSendStateIconView;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.f fVar = com.tencent.mobileqq.aio.msglist.holder.skin.padding.f.f192441a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fVar.a(), fVar.a());
        layoutParams.addRule(0, R.id.kso);
        layoutParams.addRule(12);
        layoutParams.rightMargin = com.tencent.mobileqq.aio.utils.p.c(8);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(imageView2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(n this$0, ImageView this_apply, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this$0.allowClickStatusIcon && (onClickListener = this$0.onClickMsgStatusIcon) != null) {
            onClickListener.onClick(this_apply);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d(FrameLayout parent) {
        VideoProgressView videoProgressView = new VideoProgressView(this.context);
        videoProgressView.setShowCorner(false);
        videoProgressView.setRadius(8.0f, true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        parent.addView(videoProgressView, layoutParams);
        this.progressController = new f(videoProgressView);
    }

    private final void e(FrameLayout parent) {
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AIOVideoStateIconView aIOVideoStateIconView = new AIOVideoStateIconView(context);
        aIOVideoStateIconView.setId(R.id.sk_);
        aIOVideoStateIconView.setVisibility(8);
        this.stateIconView = aIOVideoStateIconView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        parent.addView(aIOVideoStateIconView, layoutParams);
    }

    private final FrameLayout g() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setId(R.id.sk8);
        e(frameLayout);
        return frameLayout;
    }

    private final void j() {
        ImageView imageView = this.msgSendStateIconView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void y() {
        this.allowClickStatusIcon = true;
        ImageView imageView = this.msgSendStateIconView;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.gxn);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f207495a6));
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            com.tencent.mobileqq.aio.msglist.holder.skin.padding.f fVar = com.tencent.mobileqq.aio.msglist.holder.skin.padding.f.f192441a;
            layoutParams.width = fVar.a();
            layoutParams.height = fVar.a();
            imageView.setLayoutParams(layoutParams);
        }
    }

    public final void A(@NotNull VideoErrorStatus videoErrorStatus, @NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) videoErrorStatus, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(videoErrorStatus, "videoErrorStatus");
        Intrinsics.checkNotNullParameter(text, "text");
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.e(videoErrorStatus, text);
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        j();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        VideoErrorStatus videoErrorStatus = VideoErrorStatus.Expired;
        String string = this.context.getString(R.string.yux);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.aio_video_expired)");
        aIOVideoStateIconView.e(videoErrorStatus, string);
    }

    public final void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.f();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.allowClickStatusIcon = true;
        ImageView imageView = this.msgSendStateIconView;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.f160226dl);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f201274ud));
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            com.tencent.mobileqq.aio.msglist.holder.skin.padding.f fVar = com.tencent.mobileqq.aio.msglist.holder.skin.padding.f.f192441a;
            layoutParams.width = fVar.a();
            layoutParams.height = fVar.a();
            imageView.setLayoutParams(layoutParams);
        }
    }

    public final void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.allowClickStatusIcon = false;
        ImageView imageView = this.msgSendStateIconView;
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.common_loading6);
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.f201324ui));
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            com.tencent.mobileqq.aio.msglist.holder.skin.padding.f fVar = com.tencent.mobileqq.aio.msglist.holder.skin.padding.f.f192441a;
            layoutParams.width = fVar.b();
            layoutParams.height = fVar.b();
            imageView.setLayoutParams(layoutParams);
        }
    }

    public final void f(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.progressController == null) {
            d(this.statusView);
        }
        l();
        f fVar = this.progressController;
        Intrinsics.checkNotNull(fVar);
        fVar.b(key);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        j();
        i();
        k();
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        j();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.msgSendStateIconView == null) {
            b();
        }
    }

    public final void m(int percent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, percent);
            return;
        }
        y();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.k(percent);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            k();
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        E();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.f();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        y();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        ImageView imageView = this.msgSendStateIconView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.g();
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        E();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        F();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        F();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.l(100);
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        y();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.h();
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        j();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.i();
        }
    }

    public final void v(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, progress);
            return;
        }
        y();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.l(progress);
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        j();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        aIOVideoStateIconView.d();
        k();
    }

    public final void x(@Nullable View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener);
        } else {
            this.onClickMsgStatusIcon = onClickListener;
        }
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        j();
        AIOVideoStateIconView aIOVideoStateIconView = this.stateIconView;
        if (aIOVideoStateIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateIconView");
            aIOVideoStateIconView = null;
        }
        VideoErrorStatus videoErrorStatus = VideoErrorStatus.Failed;
        String string = this.context.getString(R.string.yuv);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026aio_video_download_error)");
        aIOVideoStateIconView.e(videoErrorStatus, string);
        f fVar = this.progressController;
        if (fVar != null) {
            fVar.f();
        }
    }
}
