package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECFloatCommonDetailBulletinFragment;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/b;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "e", "Landroid/view/View;", "g", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "f", "", "d", "getComponentView", "", "visibility", "setComponentViewVisibility", "data", h.F, "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", HippyQQConstants.URL_COMPONENT_NAME, "Lcom/tencent/pts/core/PTSComposer;", "b", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout component;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final int f104334d = com.tencent.ecommerce.biz.util.e.c(32.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/b$a;", "", "", "PAGE_HEIGHT", "I", "a", "()I", "", "SHOP_HOME_ANNOUNCEMENT_PAGE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.component.b$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return b.f104334d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/component/b$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.component.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1093b extends com.tencent.ecommerce.base.ui.e {
        C1093b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            String optString;
            String str3 = "";
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                str = "";
            }
            if (Intrinsics.areEqual(str, "showBulletinTipsView")) {
                if (ptsComposer == null || (str2 = ptsComposer.getJsonData()) == null) {
                    str2 = "";
                }
                JSONObject optJSONObject = com.tencent.ecommerce.base.ktx.e.b(new JSONObject(), str2).optJSONObject("bulletin");
                if (optJSONObject != null && (optString = optJSONObject.optString(FileReaderHelper.TXT_EXT)) != null) {
                    str3 = optString;
                }
                ECFloatCommonDetailBulletinFragment.INSTANCE.a(b.this.context, str3, "\u516c\u544a");
                com.tencent.ecommerce.biz.bulletin.b.c(com.tencent.ecommerce.biz.bulletin.b.f101349a, b.this.d(), "", BulletinScene.SHOP_MAIN_PAGE, null, 8, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
        this.component = new LinearLayout(context);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        String str;
        String optString;
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer == null || (str = pTSComposer.getJsonData()) == null) {
            str = "";
        }
        JSONObject optJSONObject = com.tencent.ecommerce.base.ktx.e.b(new JSONObject(), str).optJSONObject("shop_info");
        return (optJSONObject == null || (optString = optJSONObject.optString("id", "")) == null) ? "" : optString;
    }

    private final void e() {
        this.component.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.component.setGravity(17);
        this.component.addView(g());
    }

    private final IPTSLiteEventListener f() {
        return new C1093b();
    }

    private final View g() {
        PTSItemView pTSItemView = new PTSItemView(this.context);
        PTSComposer b16 = gh0.d.f402041a.b("qshop_detail_bulletin", ECPTSStyleManager.e("qshop_detail_bulletin", this.context), new JSONObject().toString(), f());
        this.ptsComposer = b16;
        if (b16 != null) {
            b16.layoutToView(pTSItemView);
        }
        return pTSItemView;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.component;
    }

    public final void h(String data) {
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.setData(data);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int visibility) {
        this.component.setVisibility(visibility);
        com.tencent.ecommerce.biz.bulletin.b.e(com.tencent.ecommerce.biz.bulletin.b.f101349a, d(), "", BulletinScene.SHOP_MAIN_PAGE, null, 8, null);
    }
}
