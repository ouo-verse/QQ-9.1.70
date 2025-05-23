package com.tencent.mobileqq.troopmanage.multigroup;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0017R\u0017\u0010\u0003\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/j;", "Lcom/tencent/mobileqq/troopmanage/multigroup/m;", "Landroid/widget/TextView;", "view", "", "change", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "model", "position", "itemCount", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "getView", "()Landroid/view/View;", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dataHeader", "G", "dataContent", "H", "Landroid/widget/TextView;", "dataTotalTroop", "I", "dataTroopNumber", "J", "dataMemberNumber", "K", "dataManagerNumber", "<init>", "(Landroid/view/View;)V", "L", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View dataHeader;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View dataContent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView dataTotalTroop;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView dataTroopNumber;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView dataMemberNumber;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView dataManagerNumber;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/j$a;", "", "", "DECREASE_CHANGE", "I", "INCREASE_CHANGE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.multigroup.j$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.view = view;
        View findViewById = view.findViewById(R.id.f102715yn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.t\u2026multi_manage_data_header)");
        this.dataHeader = findViewById;
        View findViewById2 = view.findViewById(R.id.f102705ym);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.t\u2026ulti_manage_data_content)");
        this.dataContent = findViewById2;
        View findViewById3 = view.findViewById(R.id.f102745yq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.t\u2026data_header_troop_number)");
        this.dataTotalTroop = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f102775yt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.t\u2026ti_manage_data_troop_num)");
        this.dataTroopNumber = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f102755yr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.t\u2026i_manage_data_member_num)");
        this.dataMemberNumber = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f102765ys);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.t\u2026ge_data_troop_manage_num)");
        this.dataManagerNumber = (TextView) findViewById6;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void n(TextView view, int change) {
        Drawable drawable = view.getContext().getResources().getDrawable(R.drawable.f161449n83);
        Intrinsics.checkNotNullExpressionValue(drawable, "view.context.resources.g\u2026ulti_troop_data_increase)");
        Drawable drawable2 = view.getContext().getResources().getDrawable(R.drawable.f161448n82);
        Intrinsics.checkNotNullExpressionValue(drawable2, "view.context.resources.g\u2026ulti_troop_data_decrease)");
        if (change == 1) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(null, null, drawable, null);
        }
        if (change == -1) {
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            view.setCompoundDrawables(null, null, drawable2, null);
        }
    }

    @Override // com.tencent.mobileqq.troopmanage.multigroup.m
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void l(@NotNull com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f model, int position, int itemCount) {
        String str;
        String str2;
        String str3;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b16;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a d16;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a d17;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b17;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a a16;
        Integer num;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a a17;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b18;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a e16;
        Integer num2;
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a e17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, model, Integer.valueOf(position), Integer.valueOf(itemCount));
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        o.m(this.dataHeader, 1, true);
        o.m(this.dataContent, 3, true);
        TextView textView = this.dataTotalTroop;
        Integer num3 = null;
        String str4 = "-";
        if (model.b() == null) {
            str = "-";
        } else {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b19 = model.b();
            if (b19 != null) {
                str = b19.b();
            } else {
                str = null;
            }
        }
        textView.setText(str);
        TextView textView2 = this.dataTroopNumber;
        if (model.b() == null) {
            str2 = "-";
        } else {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b26 = model.b();
            if (b26 != null && (e17 = b26.e()) != null) {
                num2 = Integer.valueOf(e17.b());
            } else {
                num2 = null;
            }
            str2 = String.valueOf(num2);
        }
        textView2.setText(str2);
        if (model.b() != null && (b18 = model.b()) != null && (e16 = b18.e()) != null) {
            n(this.dataTroopNumber, e16.a());
        }
        TextView textView3 = this.dataMemberNumber;
        if (model.b() == null) {
            str3 = "-";
        } else {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b27 = model.b();
            if (b27 != null && (a17 = b27.a()) != null) {
                num = Integer.valueOf(a17.b());
            } else {
                num = null;
            }
            str3 = String.valueOf(num);
        }
        textView3.setText(str3);
        if (model.b() != null && (b17 = model.b()) != null && (a16 = b17.a()) != null) {
            n(this.dataMemberNumber, a16.a());
        }
        TextView textView4 = this.dataManagerNumber;
        if (model.b() != null) {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b b28 = model.b();
            if (b28 != null && (d17 = b28.d()) != null) {
                num3 = Integer.valueOf(d17.b());
            }
            str4 = String.valueOf(num3);
        }
        textView4.setText(str4);
        if (model.b() != null && (b16 = model.b()) != null && (d16 = b16.d()) != null) {
            n(this.dataManagerNumber, d16.a());
        }
    }

    @NotNull
    public final View m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dataHeader;
    }
}
