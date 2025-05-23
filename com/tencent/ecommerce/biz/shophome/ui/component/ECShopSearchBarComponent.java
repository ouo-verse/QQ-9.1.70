package com.tencent.ecommerce.biz.shophome.ui.component;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0002(\u0010B)\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0017\u0010$\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b\u0013\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "c", "Landroid/view/View;", "e", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "d", "getComponentView", "", "abnormalType", "f", "", "show", "g", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", HippyQQConstants.URL_COMPONENT_NAME, "b", "I", "Lcom/tencent/pts/core/PTSComposer;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Landroid/app/Activity;", "Landroid/app/Activity;", "context", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "arguments", "", "Ljava/lang/String;", "shopId", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;", "()Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;", "clickListener", "<init>", "(Landroid/app/Activity;Landroid/os/Bundle;Ljava/lang/String;Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;)V", h.F, "ClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopSearchBarComponent implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout component;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int abnormalType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Activity context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Bundle arguments;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String shopId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ClickListener clickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;", "", "onShareBtnClick", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ClickListener {
        void onShareBtnClick();
    }

    public ECShopSearchBarComponent(Activity activity, Bundle bundle, String str, ClickListener clickListener) {
        this.context = activity;
        this.arguments = bundle;
        this.shopId = str;
        this.clickListener = clickListener;
        this.component = new LinearLayout(activity);
        c();
    }

    private final void c() {
        this.component.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.component.setGravity(17);
        this.component.addView(e());
    }

    private final IPTSLiteEventListener d() {
        return new b();
    }

    private final View e() {
        PTSItemView pTSItemView = new PTSItemView(this.context);
        gh0.d dVar = gh0.d.f402041a;
        String e16 = ECPTSStyleManager.e("shop_home_search_bar", this.context);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("show_share", false);
        Unit unit = Unit.INSTANCE;
        PTSComposer b16 = dVar.b("shop_home_search_bar", e16, jSONObject.toString(), d());
        this.ptsComposer = b16;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ptsComposer");
        }
        b16.layoutToView(pTSItemView);
        return pTSItemView;
    }

    /* renamed from: b, reason: from getter */
    public final ClickListener getClickListener() {
        return this.clickListener;
    }

    public final void f(int abnormalType) {
        this.abnormalType = abnormalType;
    }

    public final void g(boolean show) {
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ptsComposer");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("show_share", show);
        Unit unit = Unit.INSTANCE;
        pTSComposer.updateData(jSONObject.toString());
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.component;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                str = "";
            }
            if (Intrinsics.areEqual(str, "clickBackButton")) {
                ECShopSearchBarComponent.this.context.finish();
                return;
            }
            if (Intrinsics.areEqual(str, "clickSearchBar")) {
                if (ECShopSearchBarComponent.this.abnormalType == 1) {
                    i.f101155b.c(R.string.wt6, ECToastIcon.ICON_NONE, 0);
                    return;
                }
                com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar.c(ECShopSearchBarComponent.this.arguments);
                aVar.k(c16.role, c16.shopId, c16.source);
                com.tencent.ecommerce.biz.shophome.util.b bVar = com.tencent.ecommerce.biz.shophome.util.b.f104380a;
                ECShopSearchBarComponent eCShopSearchBarComponent = ECShopSearchBarComponent.this;
                bVar.d(eCShopSearchBarComponent.context, eCShopSearchBarComponent.arguments);
                return;
            }
            if (Intrinsics.areEqual(str, "clickShareButton")) {
                ECShopSearchBarComponent.this.getClickListener().onShareBtnClick();
            }
        }
    }
}
