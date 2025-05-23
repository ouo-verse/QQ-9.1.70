package com.tencent.mobileqq.qqsec.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.setting.config.SingleLineRedTouchView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012%\b\u0002\u0010#\u001a\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/t;", "Lcom/tencent/mobileqq/setting/config/b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/setting/config/SingleLineRedTouchView;", "L", "view", "", "position", "", "", "payloads", "", "K", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "loadingView", "", "p", "Z", "getShowLoading", "()Z", "setShowLoading", "(Z)V", UIJsPlugin.EVENT_SHOW_LOADING, "", "leftText", "leftIcon", "", "redTouchPath", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", NodeProps.ON_CLICK, "<init>", "(Ljava/lang/CharSequence;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class t extends com.tencent.mobileqq.setting.config.b {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean showLoading;

    public /* synthetic */ t(CharSequence charSequence, int i3, String str, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : str, (i16 & 8) == 0 ? function1 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), str, function1, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.setting.config.b, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K */
    public void F(@NotNull SingleLineRedTouchView view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        ImageView imageView = null;
        if (this.showLoading) {
            ImageView imageView2 = this.loadingView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.loadingView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                imageView3 = null;
            }
            ImageView imageView4 = this.loadingView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                imageView = imageView4;
            }
            imageView3.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView.getContext(), 2));
            return;
        }
        ImageView imageView5 = this.loadingView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView5 = null;
        }
        imageView5.setVisibility(8);
        ImageView imageView6 = this.loadingView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            imageView6 = null;
        }
        imageView6.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.setting.config.b, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L */
    public SingleLineRedTouchView H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SingleLineRedTouchView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        SingleLineRedTouchView H = super.H(parent);
        ImageView imageView = new ImageView(parent.getContext());
        int n3 = Utils.n(16.0f, parent.getContext().getResources());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n3, n3);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginEnd(Utils.n(32.0f, parent.getContext().getResources()));
        imageView.setLayoutParams(layoutParams);
        this.loadingView = imageView;
        H.addView(imageView);
        return H;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull CharSequence leftText, int i3, @Nullable String str, @Nullable Function1<? super View, Unit> function1) {
        super(leftText, i3, str, function1);
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, leftText, Integer.valueOf(i3), str, function1);
    }
}
