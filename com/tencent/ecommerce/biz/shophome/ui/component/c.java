package com.tencent.ecommerce.biz.shophome.ui.component;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/c;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "Landroid/view/View;", "b", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "a", "", "dataJson", "", "c", "", "visibility", "setComponentViewVisibility", "getComponentView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/pts/core/PTSComposer;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Landroid/app/Activity;", "Landroid/app/Activity;", "context", "<init>", "(Landroid/app/Activity;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout component;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Activity context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/c$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            String str3 = "";
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                str = "";
            }
            if (Intrinsics.areEqual(str, "allInOneJump")) {
                if (dataMap != null && (str2 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL)) != null) {
                    str3 = str2;
                }
                cg0.a.b("ECShopDiscountInfoComponent", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str3);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                ECScheme.g(str3, null, 2, null);
            }
        }
    }

    public c(Activity activity) {
        this.context = activity;
        this.component = new LinearLayout(activity);
    }

    private final IPTSLiteEventListener a() {
        return new b();
    }

    private final View b() {
        PTSItemView pTSItemView = new PTSItemView(this.context);
        PTSComposer b16 = gh0.d.f402041a.b("shop_home_discount_info", ECPTSStyleManager.e("shop_home_discount_info", this.context), "", a());
        this.ptsComposer = b16;
        if (b16 != null) {
            b16.layoutToView(pTSItemView);
        }
        return pTSItemView;
    }

    public final void c(String dataJson) {
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.setData(dataJson);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        this.component.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.component.setGravity(17);
        this.component.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
        this.component.addView(b());
        return this.component;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int visibility) {
        this.component.setVisibility(visibility);
    }
}
