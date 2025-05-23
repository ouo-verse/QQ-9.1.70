package com.qwallet.authorize.phone;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qwallet/authorize/phone/i;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "phoneData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "phoneNumTextView", UserInfo.SEX_FEMALE, "sourceTagTextView", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "l", "()Landroid/widget/Button;", "deleteBtn", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView phoneNumTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView sourceTagTextView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Button deleteBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.sz_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorize_phone_num)");
        this.phoneNumTextView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.szh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.authorize_source_tag)");
        this.sourceTagTextView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f164527sz4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.authorize_delete_btn)");
        this.deleteBtn = (Button) findViewById3;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final Button getDeleteBtn() {
        return this.deleteBtn;
    }

    public final void m(@NotNull AuthorizePhoneData phoneData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(phoneData, "phoneData");
        this.phoneNumTextView.setText(phoneData.getPhoneMask());
        Button button = this.deleteBtn;
        int source = phoneData.getSource();
        int i3 = 0;
        if (source >= 0 && source < 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        button.setVisibility(i3);
        this.sourceTagTextView.setText(phoneData.getSourceTag());
    }
}
