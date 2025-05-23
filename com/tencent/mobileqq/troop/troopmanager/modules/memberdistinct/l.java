package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.protofile.TroopMemberDetectSvr$GroupInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u00a2\u0006\u0004\b \u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/l;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/m;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "model", "", "position", "", "l", "p", "", "o", "Landroid/view/View;", "E", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "setGroupCell", "(Landroid/view/View;)V", "groupCell", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "groupName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "groupHeader", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "groupCheck", "view", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View groupCell;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView groupName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView groupHeader;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private QUICheckBox groupCheck;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.vtb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.group_cell)");
        this.groupCell = findViewById;
        View findViewById2 = view.findViewById(R.id.group_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.group_name)");
        this.groupName = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.vtr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.group_header)");
        this.groupHeader = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.cxl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.group_check)");
        this.groupCheck = (QUICheckBox) findViewById4;
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.m
    public void l(@NotNull com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a model, int position) {
        String str;
        String str2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) model, position);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        this.groupCheck.setChecked(model.d());
        TextView textView = this.groupName;
        TroopMemberDetectSvr$GroupInfo a16 = model.a();
        String str3 = "";
        if (a16 == null || (pBStringField2 = a16.group_name) == null || (str = pBStringField2.get()) == null) {
            str = "";
        }
        textView.setText(str);
        ImageView imageView = this.groupHeader;
        TroopMemberDetectSvr$GroupInfo a17 = model.a();
        if (a17 != null && (pBStringField = a17.group_face) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        if (str2 != null) {
            str3 = str2;
        }
        n.a(imageView, str3);
    }

    @NotNull
    public final View m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groupCell;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.groupCheck.isChecked();
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.groupCheck.setChecked(!r0.isChecked());
        }
    }
}
