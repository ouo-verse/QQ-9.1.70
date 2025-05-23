package com.tencent.mobileqq.cardcontainer.template.imagenobutton;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.cardcontainer.view.BaseCardView;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticon.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/ImageNoButtonCardView;", "Lcom/tencent/mobileqq/cardcontainer/view/BaseCardView;", "", "url", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Landroid/view/View;", "f", "", "i", "Landroid/widget/ImageView;", "close", "j", h.F, "Landroid/widget/ImageView;", "btnClose", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ImageNoButtonCardView extends BaseCardView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView btnClose;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/imagenobutton/ImageNoButtonCardView$a;", "", "", "EMO_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.imagenobutton.ImageNoButtonCardView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageNoButtonCardView(@NotNull Context context) {
        super(context, 0.0f, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e("CardContainer.ImageNoButtonCardView", 1, "loadImage  state:" + loadState + "  option:" + option);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e("CardContainer.ImageNoButtonCardView", 1, "loadImage  state:" + loadState + "  option:" + option);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e("CardContainer.ImageNoButtonCardView", 1, "loadImage  state:" + loadState + "  option:" + option);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(a bizModel, ImageNoButtonCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(bizModel, "$bizModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CardContainer.ImageNoButtonCardView", 1, "card click  schema:" + bizModel.e());
        com.tencent.mobileqq.cardcontainer.e g16 = this$0.g();
        if (g16 != null) {
            e.a.b(g16, null, 1, null);
        }
        this$0.h(bizModel.e());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean s(String url) {
        boolean z16;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        try {
            String queryParameter = Uri.parse(url).getQueryParameter(CustomAnimation.KeyPath.COLOR_FILTER);
            if (queryParameter != null) {
                if (Intrinsics.areEqual(queryParameter, "0")) {
                    return false;
                }
                if (Intrinsics.areEqual(queryParameter, "false")) {
                    return false;
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.i("CardContainer.ImageNoButtonCardView", 1, "[enableColorFilterForIcon] url=" + url + " exc=" + e16);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    @NotNull
    public View f(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        int i3 = 0;
        ca1.b g16 = ca1.b.g(LayoutInflater.from(getContext()), this, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, false)");
        if (!(data instanceof b)) {
            ConstraintLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "rootBinding.root");
            return root;
        }
        final a t16 = ((b) data).t();
        if (t16 == null) {
            ConstraintLayout root2 = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "rootBinding.root");
            return root2;
        }
        Option url = Option.obtain().setTargetView(g16.f30489c).setFailedDrawableId(R.drawable.moy).setUrl(t16.b());
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        qQPicLoader.d().loadImage(url, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.cardcontainer.template.imagenobutton.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ImageNoButtonCardView.o(loadState, option);
            }
        });
        qQPicLoader.d().loadImage(Option.obtain().setTargetView(g16.f30488b).setFailedDrawableId(R.drawable.f160830com).setUrl(t16.a()), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.cardcontainer.template.imagenobutton.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ImageNoButtonCardView.p(loadState, option);
            }
        });
        qQPicLoader.d().loadImage(Option.obtain().setTargetView(g16.f30490d).setFailDrawable(new ColorDrawable(0)).setLoadingDrawable(new ColorDrawable(0)).setUrl(t16.d()), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.cardcontainer.template.imagenobutton.f
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                ImageNoButtonCardView.q(loadState, option);
            }
        });
        g16.f30493g.setText(t16.g());
        if (t16.h() == 1) {
            ImageView imageView = this.btnClose;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.jca);
            }
            g16.f30496j.setVisibility(8);
            g16.f30494h.setVisibility(8);
            g16.f30493g.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
            g16.f30493g.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            g16.f30491e.setVisibility(8);
            String f16 = t16.f();
            if (f16 != null) {
                g16.f30492f.setText(new QQText(q.f204858a.a(f16), 3, 16));
            }
            g16.f30492f.setVisibility(0);
            if (s(t16.d())) {
                g16.f30490d.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.qui_common_icon_secondary), PorterDuff.Mode.SRC_ATOP));
            } else {
                g16.f30490d.setColorFilter((ColorFilter) null);
            }
        } else if (t16.h() == 2 || t16.h() == 3) {
            ImageView imageView2 = this.btnClose;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.m1u);
            }
            g16.f30496j.setVisibility(0);
            g16.f30494h.setVisibility(0);
            g16.f30493g.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
            g16.f30493g.setShadowLayer(1.0f, 0.0f, 0.0f, Integer.MIN_VALUE);
            ImageView imageView3 = g16.f30491e;
            if (t16.h() != 3) {
                i3 = 8;
            }
            imageView3.setVisibility(i3);
            g16.f30492f.setText("");
            g16.f30492f.setVisibility(8);
            if (s(t16.d())) {
                g16.f30490d.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.qui_common_icon_allwhite_primary), PorterDuff.Mode.SRC_ATOP));
            } else {
                g16.f30490d.setColorFilter((ColorFilter) null);
            }
        }
        g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.template.imagenobutton.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageNoButtonCardView.r(a.this, this, view);
            }
        });
        ConstraintLayout root3 = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "rootBinding.root");
        return root3;
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.cardcontainer.e g16 = g();
        if (g16 != null) {
            g16.F8();
        }
        com.tencent.mobileqq.cardcontainer.e g17 = g();
        if (g17 != null) {
            e.a.c(g17, null, 1, null);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.view.BaseCardView
    public void j(@NotNull ImageView close) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) close);
        } else {
            Intrinsics.checkNotNullParameter(close, "close");
            this.btnClose = close;
        }
    }
}
