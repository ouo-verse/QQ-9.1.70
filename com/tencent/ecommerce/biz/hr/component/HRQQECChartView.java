package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.ecommerce.biz.transactiondata.trendchart.ECNewChartView;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import java.util.ArrayList;
import java.util.List;
import kj0.ECChartViewExtData;
import kj0.ECChartViewPointAttr;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002JI\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\u0016\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\u0004\u0018\u0001`\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRQQECChartView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/c;", "", "params", "", "K", "Lorg/json/JSONArray;", "labelArr", "valueArr", "", "Lkj0/b;", "M", "Lkj0/c;", "L", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "H", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECNewChartView;", "chartView", "Landroid/widget/FrameLayout$LayoutParams;", "I", "Landroid/widget/FrameLayout$LayoutParams;", "chartLayoutParams", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRQQECChartView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private ECNewChartView chartView;

    /* renamed from: I, reason: from kotlin metadata */
    private final FrameLayout.LayoutParams chartLayoutParams;

    public HRQQECChartView(Context context) {
        super(context);
        this.chartView = new ECNewChartView(context, null, 0, true, 6, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.chartLayoutParams = layoutParams;
        addView(this.chartView, layoutParams);
    }

    private final void K(String params) {
        try {
            JSONObject jSONObject = new JSONObject(params != null ? params : "{}");
            JSONArray optJSONArray = jSONObject.optJSONArray("xlabels");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("values");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.opt(i3).toString());
                }
            }
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList2.add(Long.valueOf(b.H(optJSONArray2.opt(i16))));
                }
            }
            removeView(this.chartView);
            ECNewChartView eCNewChartView = new ECNewChartView(getContext(), null, 0, true, 6, null);
            this.chartView = eCNewChartView;
            eCNewChartView.g(arrayList, arrayList2, false, M(optJSONArray, optJSONArray2), L());
            addView(this.chartView, this.chartLayoutParams);
        } catch (Exception unused) {
            cg0.a.a("HRQQECChartView", "drawChartWithConfig", "params = " + params + ", exception = exception");
        }
    }

    private final ECChartViewPointAttr L() {
        return new ECChartViewPointAttr(true, 4.0f, 6.0f);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        if (method.hashCode() == -1294678974 && method.equals("drawChartWithConfig")) {
            K(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final List<ECChartViewExtData> M(JSONArray labelArr, JSONArray valueArr) {
        ArrayList arrayList = new ArrayList();
        if (labelArr != null) {
            arrayList.add(new ECChartViewExtData("\u65f6\u95f4", labelArr, false, 4, null));
        }
        if (valueArr != null) {
            JSONArray jSONArray = new JSONArray();
            int length = valueArr.length();
            for (int i3 = 0; i3 < length; i3++) {
                jSONArray.mo162put(valueArr.optString(i3) + '%');
            }
            arrayList.add(new ECChartViewExtData("\u6570\u503c", jSONArray, false, 4, null));
        }
        return arrayList;
    }
}
