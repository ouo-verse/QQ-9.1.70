package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.repo.aftersale.apply.item.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u0010\u001a\u00020\u000b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", DomainData.DOMAIN_NAME, "", "show", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "divider", "G", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "l", "()Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "o", "(Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;)V", "applyItem", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "nextApplyItem", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class b<T extends com.tencent.ecommerce.repo.aftersale.apply.item.d> extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private final View divider;

    /* renamed from: G, reason: from kotlin metadata */
    private T applyItem;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.ecommerce.repo.aftersale.apply.item.d nextApplyItem;

    public b(View view) {
        super(view);
        this.context = wg0.a.a();
        this.divider = view.findViewById(R.id.f162992nq2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    public final T l() {
        return this.applyItem;
    }

    /* renamed from: m, reason: from getter */
    public final com.tencent.ecommerce.repo.aftersale.apply.item.d getNextApplyItem() {
        return this.nextApplyItem;
    }

    public abstract void n(int position);

    public final void o(T t16) {
        this.applyItem = t16;
    }

    public final void p(com.tencent.ecommerce.repo.aftersale.apply.item.d dVar) {
        this.nextApplyItem = dVar;
    }

    public final void q(boolean show) {
        View view = this.divider;
        if (view != null) {
            view.setVisibility(show ? 0 : 8);
        }
    }
}
