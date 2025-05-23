package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001c\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "", "", "g", "", "", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "eventHandlers", "i", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/ui/b;", "ptsBasePtsViewData", tl.h.F, "Lcom/tencent/pts/core/PTSComposer;", "a", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "b", "Lcom/tencent/ecommerce/base/ui/b;", "Ljava/util/HashMap;", "c", "Ljava/util/HashMap;", "eventHandlerMap", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "d", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "ptsUpdateDataListener", "com/tencent/ecommerce/base/ui/ECBaseViewController$b", "e", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController$b;", "ptsLiteEventListener", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "basePtsView", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/ui/ECBasePtsView;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public class ECBaseViewController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECBasePtsViewData ptsBasePtsViewData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, IPTSLiteEventListener> eventHandlerMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final PTSComposer.IPTSUpdateDataListener ptsUpdateDataListener = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b ptsLiteEventListener = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ECBasePtsView basePtsView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J<\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/base/ui/ECBaseViewController$b", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataSet", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "onScrollViewItemExposureTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b extends DefaultPTSLiteEventListener {
        b() {
        }

        @Override // com.tencent.pts.core.lite.DefaultPTSLiteEventListener, com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onScrollViewItemExposureTriggered(String identifier, HashMap<String, String> dataSet, View view, PTSComposer ptsComposer) {
            super.onScrollViewItemExposureTriggered(identifier, dataSet, view, ptsComposer);
            Iterator it = ECBaseViewController.this.eventHandlerMap.values().iterator();
            while (it.hasNext()) {
                ((IPTSLiteEventListener) it.next()).onScrollViewItemExposureTriggered(identifier, dataSet, view, ptsComposer);
            }
        }

        @Override // com.tencent.pts.core.lite.DefaultPTSLiteEventListener, com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataSet, View view, PTSComposer ptsComposer) {
            String str;
            cg0.a.b("ECBaseViewController", "[onTapEventTriggered], " + getLogString(identifier, dataSet));
            if (dataSet == null || (str = dataSet.get("eventType")) == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                cg0.a.b("ECBaseViewController", "[handleEventType], eventTypeString is empty.");
                return;
            }
            cg0.a.b("ECBaseViewController", "[handleEventType] eventTypeString = " + str);
            Object[] array = new Regex("\\|").split(str, 0).toArray(new String[0]);
            if (array != null) {
                for (String str2 : (String[]) array) {
                    cg0.a.b("ECBaseViewController", "[handleEventType], eventType = " + str2);
                    IPTSLiteEventListener iPTSLiteEventListener = (IPTSLiteEventListener) ECBaseViewController.this.eventHandlerMap.get(str2);
                    if (iPTSLiteEventListener != null) {
                        iPTSLiteEventListener.onTapEventTriggered(identifier, dataSet, view, ptsComposer);
                    }
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class c implements PTSComposer.IPTSUpdateDataListener {
        c() {
        }

        @Override // com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener
        public final void onDataUpdated(String str) {
            cg0.a.b("ECBaseViewController", "[onDataUpdated] jsonData = " + str);
            ECBasePtsViewData eCBasePtsViewData = ECBaseViewController.this.ptsBasePtsViewData;
            if (eCBasePtsViewData != null) {
                eCBasePtsViewData.d(str);
            }
        }
    }

    public ECBaseViewController(Context context, ECBasePtsView eCBasePtsView) {
        this.context = context;
        this.basePtsView = eCBasePtsView;
    }

    public final void g() {
        cg0.a.b("ECBaseViewController", "[ECBaseViewController] destroy");
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.destroy();
        }
    }

    public final void i(Map<String, ? extends IPTSLiteEventListener> eventHandlers) {
        this.eventHandlerMap.putAll(eventHandlers);
    }

    public final void h(Context context, ECBasePtsViewData ptsBasePtsViewData) {
        String pageName = ptsBasePtsViewData != null ? ptsBasePtsViewData.getPageName() : null;
        String e16 = ECPTSStyleManager.e(pageName, context);
        if (!TextUtils.isEmpty(pageName) && !TextUtils.isEmpty(e16)) {
            this.ptsBasePtsViewData = ptsBasePtsViewData;
            PTSComposer pTSComposer = this.ptsComposer;
            if (pTSComposer != null) {
                pTSComposer.destroy();
            }
            final PTSComposer c16 = gh0.d.f402041a.c(pageName, e16, ptsBasePtsViewData != null ? ptsBasePtsViewData.getProteusData() : null, this.ptsLiteEventListener, this.ptsUpdateDataListener);
            this.basePtsView.post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.ECBaseViewController$refreshBaseView$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECBasePtsView eCBasePtsView;
                    ECBaseViewController.b bVar;
                    eCBasePtsView = ECBaseViewController.this.basePtsView;
                    PTSComposer pTSComposer2 = c16;
                    bVar = ECBaseViewController.this.ptsLiteEventListener;
                    eCBasePtsView.b(pTSComposer2, bVar);
                    ECBaseViewController.this.ptsComposer = c16;
                }
            });
            return;
        }
        cg0.a.a("ECBaseViewController", "refreshBaseView", "[ECBaseViewController] pageName or frameTreeJson is empty.");
    }
}
