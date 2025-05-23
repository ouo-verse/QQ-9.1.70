package com.tencent.ecommerce.biz.shophome.ui.component;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/d;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "Landroid/view/View;", "c", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "b", "", "visibility", "", "setComponentViewVisibility", "getComponentView", "", "dataJson", "d", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/pts/core/PTSComposer;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Landroid/app/Activity;", "Landroid/app/Activity;", "context", "<init>", "(Landroid/app/Activity;)V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout component;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Activity context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final int f104344d = com.tencent.ecommerce.biz.util.e.c(114.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/d$a;", "", "", "PAGE_HEIGHT", "I", "a", "()I", "", "SHOP_HOME_DISTRIBUTION_PROMOTE_PAGE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.component.d$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return d.f104344d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(Activity activity) {
        this.context = activity;
        this.component = new LinearLayout(activity);
    }

    private final IPTSLiteEventListener b() {
        return new b();
    }

    private final View c() {
        PTSItemView pTSItemView = new PTSItemView(this.context);
        PTSComposer b16 = gh0.d.f402041a.b("distribution_promote_data", ECPTSStyleManager.e("distribution_promote_data", this.context), "", b());
        this.ptsComposer = b16;
        if (b16 != null) {
            b16.layoutToView(pTSItemView);
        }
        return pTSItemView;
    }

    public final void d(String dataJson) {
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.setData(dataJson);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        this.component.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.component.setGravity(17);
        this.component.addView(c());
        return this.component;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int visibility) {
        this.component.setVisibility(visibility);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/d$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
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
            cg0.a.b("ECShopHomeDistributionPromoteData", "[onTapEventTriggered] eventType=" + str);
        }
    }
}
