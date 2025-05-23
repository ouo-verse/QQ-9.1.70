package com.qwallet.authorize.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/qwallet/authorize/dialog/l;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "phoneData", "", "isSelect", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "phoneNumTextView", UserInfo.SEX_FEMALE, "sourceTagTextView", "Landroid/view/View;", "G", "Landroid/view/View;", "phoneSelect", "view", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class l extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView phoneNumTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView sourceTagTextView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View phoneSelect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.sz_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorize_phone_num)");
        this.phoneNumTextView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.szh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.authorize_source_tag)");
        this.sourceTagTextView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.szd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.authorize_phone_select)");
        this.phoneSelect = findViewById3;
    }

    public final void l(@NotNull AuthorizePhoneData phoneData, boolean isSelect) {
        boolean z16;
        Intrinsics.checkNotNullParameter(phoneData, "phoneData");
        this.phoneNumTextView.setText(phoneData.getPhoneMask());
        int i3 = 0;
        if (phoneData.getSourceTag().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.sourceTagTextView.setText(phoneData.getSourceTag());
            this.sourceTagTextView.setVisibility(0);
        } else {
            this.sourceTagTextView.setVisibility(8);
        }
        View view = this.phoneSelect;
        if (!isSelect) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }
}
