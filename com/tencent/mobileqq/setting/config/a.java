package com.tencent.mobileqq.setting.config;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010+\u001a\u00020!\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010*\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001f\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/setting/config/a;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/setting/config/SingleLineLoadingView;", "view", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "", "J", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "", "position", "", "", "payloads", "K", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "k", "Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "", "l", "Z", "getShowLoading", "()Z", "N", "(Z)V", UIJsPlugin.EVENT_SHOW_LOADING, "", "value", "getRightText", "()Ljava/lang/CharSequence;", "M", "(Ljava/lang/CharSequence;)V", "rightText", "getShowRedDot", "O", "showRedDot", "leftText", "leftIcon", "<init>", "(Ljava/lang/CharSequence;I)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends w<SingleLineLoadingView> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x<x.b.d, x.c.g> singleLineConfig;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean showLoading;

    public a(@NotNull CharSequence leftText, int i3) {
        x.b dVar;
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) leftText, i3);
            return;
        }
        if (i3 != 0) {
            dVar = new x.b.C8996b(leftText, i3);
        } else {
            dVar = new x.b.d(leftText);
        }
        this.singleLineConfig = new x<>(dVar, new x.c.g("", true, false));
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.singleLineConfig.K().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(@NotNull SingleLineLoadingView view, @NotNull Group.c outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        if (this.singleLineConfig.K() instanceof x.b.C8996b) {
            outMargin.c(outMargin.getLeft() + view.getResources().getDimensionPixelSize(R.dimen.dac) + Utils.n(12.0f, view.getResources()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull SingleLineLoadingView view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        view.a(this.singleLineConfig.K(), this.singleLineConfig.O());
        view.b(this.showLoading);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public SingleLineLoadingView H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SingleLineLoadingView) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        SingleLineLoadingView singleLineLoadingView = new SingleLineLoadingView(context, null, 0, 6, null);
        singleLineLoadingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return singleLineLoadingView;
    }

    public final void M(@NotNull CharSequence value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(value, "value");
            this.singleLineConfig.O().h(value);
        }
    }

    public final void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.showLoading = z16;
        }
    }

    public final void O(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.singleLineConfig.O().g(z16);
        }
    }
}
