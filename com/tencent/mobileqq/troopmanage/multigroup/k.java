package com.tencent.mobileqq.troopmanage.multigroup;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/k;", "Lcom/tencent/mobileqq/troopmanage/multigroup/m;", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "model", "", "position", "itemCount", "", "l", "Landroid/view/View;", "E", "Landroid/view/View;", "operationHeader", UserInfo.SEX_FEMALE, "operationContent", "G", "p", "()Landroid/view/View;", "operationMemberManage", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "operationAddManage", "I", "o", "operationBatchManage", "view", "<init>", "(Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends m {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View operationHeader;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View operationContent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View operationMemberManage;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View operationAddManage;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View operationBatchManage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.f102805yw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.t\u2026_manage_operation_header)");
        this.operationHeader = findViewById;
        View findViewById2 = view.findViewById(R.id.f102795yv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.t\u2026manage_operation_content)");
        this.operationContent = findViewById2;
        View findViewById3 = view.findViewById(R.id.f102825yy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.t\u2026_operation_member_manage)");
        this.operationMemberManage = findViewById3;
        View findViewById4 = view.findViewById(R.id.f102785yu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.t\u2026age_operation_add_manage)");
        this.operationAddManage = findViewById4;
        View findViewById5 = view.findViewById(R.id.f102685yk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.t\u2026i_manage_batch_operation)");
        this.operationBatchManage = findViewById5;
    }

    @Override // com.tencent.mobileqq.troopmanage.multigroup.m
    public void l(@NotNull com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f model, int position, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, model, Integer.valueOf(position), Integer.valueOf(itemCount));
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        o.m(this.operationHeader, 1, true);
        o.m(this.operationContent, 3, true);
    }

    @NotNull
    public final View m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.operationAddManage;
    }

    @NotNull
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.operationBatchManage;
    }

    @NotNull
    public final View p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.operationMemberManage;
    }
}
