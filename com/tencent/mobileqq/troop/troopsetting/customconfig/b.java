package com.tencent.mobileqq.troop.troopsetting.customconfig;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010 \u001a\u00028\u0000\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u000eR\u0014\u0010 \u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "(Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "(Landroid/view/View;ILjava/util/List;)V", "K", "()Landroid/view/View;", "O", "nBgType", "", "title", "", "bShowArrow", "L", "itemView", ViewStickEventHelper.IS_SHOW, "N", "J", "k", "Landroid/view/View;", "customView", "l", "Z", "getCleanBg", "()Z", "M", "(Z)V", "cleanBg", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b<V extends View> extends w<V> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V customView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean cleanBg;

    public b(@NotNull V customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) customView);
        } else {
            this.customView = customView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NotNull V view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        if (this.cleanBg) {
            view.setBackground(null);
        }
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    protected V H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.customView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return this.customView;
    }

    public final void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        TextView textView = (TextView) this.customView.findViewById(R.id.title);
        TextView textView2 = (TextView) this.customView.findViewById(R.id.i_f);
        if (textView != null && textView2 != null && !TextUtils.isEmpty(textView.getText())) {
            int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = measureText + x.c(this.customView.getContext(), 30.0f);
        }
    }

    @NotNull
    public final V K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (V) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.customView;
    }

    public final void L(int nBgType, @Nullable String title, boolean bShowArrow) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(nBgType), title, Boolean.valueOf(bShowArrow));
            return;
        }
        this.customView.getBackground().setAlpha(255);
        View findViewById = this.customView.findViewById(R.id.title);
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        if (textView != null) {
            if (TextUtils.isEmpty(title)) {
                textView.setText("");
                textView.setVisibility(8);
            } else {
                textView.setText(title);
                textView.setVisibility(0);
            }
        }
        N(this.customView, bShowArrow);
    }

    public final void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.cleanBg = z16;
        }
    }

    public final void N(@Nullable View itemView, boolean isShow) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, itemView, Boolean.valueOf(isShow));
            return;
        }
        if (itemView != null && (imageView = (ImageView) itemView.findViewById(R.id.f164472yw)) != null) {
            imageView.setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
            if (!isShow) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public final void O() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        View findViewById = this.customView.findViewById(R.id.i_f);
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setTextColor(this.customView.getResources().getColor(R.color.qui_common_text_secondary));
        }
    }
}
