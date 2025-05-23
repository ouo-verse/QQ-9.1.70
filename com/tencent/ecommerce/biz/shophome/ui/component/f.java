package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "Landroid/view/View;", "getComponentView", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "pageName", "", "c", "Z", "showHead", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String pageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean showHead;

    public f(Context context, String str, boolean z16) {
        this.context = context;
        this.pageName = str;
        this.showHead = z16;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        ECBasePtsView eCBasePtsView = new ECBasePtsView(this.context);
        ECBaseViewController eCBaseViewController = new ECBaseViewController(this.context, eCBasePtsView);
        Context context = this.context;
        String str = this.pageName;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("show_head", this.showHead);
        Unit unit = Unit.INSTANCE;
        eCBaseViewController.h(context, new ECBasePtsViewData(null, str, jSONObject.toString(), null, 9, null));
        return eCBasePtsView;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }
}
