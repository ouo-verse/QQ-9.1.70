package com.tencent.qqnt.pluspanel.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.utils.ae;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b.\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/pluspanel/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "setParentView", "(Landroid/view/View;)V", "parentView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setPanelIcon", "(Landroid/widget/ImageView;)V", "panelIcon", "G", "getFlagNew", "setFlagNew", "flagNew", "H", "p", "setRtPanelIcon", "rtPanelIcon", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setPanelName", "(Landroid/widget/TextView;)V", "panelName", "<init>", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class f extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View parentView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ImageView panelIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView flagNew;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View rtPanelIcon;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView panelName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View parentView) {
        super(parentView);
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentView);
            return;
        }
        this.parentView = parentView;
        View findViewById = this.itemView.findViewById(R.id.dcf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.imageView1)");
        this.panelIcon = (ImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.flag_new);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.flag_new)");
        this.flagNew = (ImageView) findViewById2;
        ae aeVar = ae.f352281b;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        this.rtPanelIcon = aeVar.i(context, this.panelIcon);
        View findViewById3 = this.itemView.findViewById(R.id.textView1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.textView1)");
        this.panelName = (TextView) findViewById3;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof f) && Intrinsics.areEqual(this.parentView, ((f) other).parentView)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.parentView.hashCode();
    }

    @NotNull
    public final ImageView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.panelIcon;
    }

    @NotNull
    public final TextView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.panelName;
    }

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.parentView;
    }

    @Nullable
    public final View p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.rtPanelIcon;
    }

    public final void q(@NotNull com.tencent.qqnt.pluspanel.data.a data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.rtPanelIcon;
        if (view == null) {
            return;
        }
        int i3 = 0;
        if (view != null) {
            view.setVisibility(0);
        }
        ae aeVar = ae.f352281b;
        View view2 = this.rtPanelIcon;
        Intrinsics.checkNotNull(view2);
        aeVar.h(view2);
        String g16 = data.g();
        if (g16 != null && g16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.flagNew.setVisibility(8);
            String valueOf = String.valueOf(data.i());
            int j3 = data.j();
            String valueOf2 = String.valueOf(data.g());
            View view3 = this.rtPanelIcon;
            Intrinsics.checkNotNull(view3);
            aeVar.c(valueOf, j3, valueOf2, view3);
            return;
        }
        ImageView imageView = this.flagNew;
        if (!data.l()) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "ViewHolder(parentView=" + this.parentView + ")";
    }
}
