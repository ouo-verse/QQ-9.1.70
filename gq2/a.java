package gq2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.setting.main.config.AccountManageView;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tenpay.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lgq2/a;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/setting/main/config/AccountManageView;", "view", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "", "J", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "", "position", "", "", "payloads", "K", "", BdhLogUtil.LogTag.Tag_Conn, "", "k", "Z", "isNewType", "()Z", "Landroid/view/View$OnClickListener;", "l", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/x;", "singleLineConfig", "<init>", "(ZLandroid/view/View$OnClickListener;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends w<AccountManageView> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean isNewType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener onClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final x<x.b.C8996b, x.c.g> singleLineConfig;

    public a(boolean z16, View.OnClickListener onClickListener) {
        this.isNewType = z16;
        this.onClickListener = onClickListener;
        String string = BaseApplication.getContext().getString(R.string.f196784i9);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026.qq_account_and_security)");
        x<x.b.C8996b, x.c.g> xVar = new x<>(new x.b.C8996b(string, R.drawable.qui_user), new x.c.g("", true, false, 4, null));
        if (z16) {
            x.b.C8996b K = xVar.K();
            String string2 = BaseApplication.getContext().getString(R.string.f196784i9);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026.qq_account_and_security)");
            K.b(string2);
        }
        this.singleLineConfig = xVar;
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    public String C() {
        return this.singleLineConfig.K().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void D(AccountManageView view, Group.c outMargin) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        outMargin.c(outMargin.getLeft() + view.getResources().getDimensionPixelSize(R.dimen.dac) + Utils.dp2Px(view.getContext(), 12.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(AccountManageView view, int position, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        view.d(this.singleLineConfig.K(), this.singleLineConfig.O());
        view.c();
        view.e(this.onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public AccountManageView H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AccountManageView accountManageView = new AccountManageView(context, null, 0, 6, null);
        accountManageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return accountManageView;
    }
}
