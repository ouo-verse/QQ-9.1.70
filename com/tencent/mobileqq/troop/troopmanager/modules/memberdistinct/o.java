package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.protofile.TroopMemberDetectSvr$DuplicateMember;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/o;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/m;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "model", "", "position", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "setUserCell", "(Landroid/view/View;)V", "userCell", UserInfo.SEX_FEMALE, "userSpec", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "userNick", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "userHeader", "view", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class o extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View userCell;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private View userSpec;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private TextView userNick;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ImageView userHeader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.f115216vf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.user_cell)");
        this.userCell = findViewById;
        View findViewById2 = view.findViewById(R.id.f115786wz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.user_spec)");
        this.userSpec = findViewById2;
        View findViewById3 = view.findViewById(R.id.f115636wk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.user_nick)");
        this.userNick = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f115276vl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.user_header)");
        this.userHeader = (ImageView) findViewById4;
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.m
    public void l(@NotNull com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a model, int position) {
        String str;
        String str2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) model, position);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        View view = this.userSpec;
        if (position != 0) {
            i3 = 0;
        }
        view.setVisibility(i3);
        TextView textView = this.userNick;
        TroopMemberDetectSvr$DuplicateMember b16 = model.b();
        String str3 = "";
        if (b16 == null || (pBStringField2 = b16.nick_name) == null || (str = pBStringField2.get()) == null) {
            str = "";
        }
        textView.setText(str);
        ImageView imageView = this.userHeader;
        TroopMemberDetectSvr$DuplicateMember b17 = model.b();
        if (b17 != null && (pBStringField = b17.avatar) != null) {
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
        return this.userCell;
    }
}
