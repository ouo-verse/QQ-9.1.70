package com.tencent.ecommerce.biz.hr.prop;

import android.app.Activity;
import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.report.service.e;
import com.tencent.ecommerce.base.report.service.f;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import i01.c;
import i01.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J'\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ1\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\t2\u0010\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\u000f\u0012\u0002\b\u00030\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/prop/ECHRDtViewPropHandler;", "Li01/d;", "Li01/c;", "renderViewExport", "", "propValue", "", DomainData.DOMAIN_NAME, "T", "Lcom/tencent/ecommerce/base/report/service/e;", "Lorg/json/JSONObject;", "params", "l", "(Lcom/tencent/ecommerce/base/report/service/e;Lorg/json/JSONObject;)Ljava/lang/Object;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/ecommerce/base/report/service/e;Ljava/util/Map;)Ljava/lang/Object;", "propKey", "", "e", "c", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECHRDtViewPropHandler implements d {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/ecommerce/biz/hr/prop/ECHRDtViewPropHandler$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnLayoutChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f102645e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f102646f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f102647h;

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/hr/prop/ECHRDtViewPropHandler$b$a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements Function1<Object, Unit> {
            a() {
            }

            public void a(Object result) {
                Map<String, ?> elementParams = com.tencent.ecommerce.base.report.service.b.f100913b.getElementParams(b.this.f102645e);
                b bVar = b.this;
                f fVar = (f) ECHRDtViewPropHandler.this.m(e.INSTANCE.d(bVar.f102646f.f()), elementParams);
                if (!elementParams.containsKey(DTParamKey.REPORT_KEY_APPKEY)) {
                    fVar.g();
                }
                fVar.f("dt_clck");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                a(obj);
                return Unit.INSTANCE;
            }
        }

        b(View view, c cVar, Object obj) {
            this.f102645e = view;
            this.f102646f = cVar;
            this.f102647h = obj;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            KRCSSViewExtensionKt.D(this.f102645e, "vr_layout_change_had_call", Boolean.TRUE);
            this.f102645e.removeOnLayoutChangeListener(this);
            KRCSSViewExtensionKt.D(this.f102645e, "preClick", new a());
            ECHRDtViewPropHandler.this.n(this.f102646f, this.f102647h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T l(e<T> eVar, JSONObject jSONObject) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            eVar.a(str, jSONObject.get(str).toString());
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T m(e<T> eVar, Map<String, ?> map) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            eVar.a(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(c renderViewExport, Object propValue) {
        Activity activity;
        if (propValue != null) {
            JSONObject jSONObject = new JSONObject((String) propValue);
            String optString = jSONObject.optString("pageId");
            String optString2 = jSONObject.optString("elementId");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            String optString3 = jSONObject.optString(IECDtReport.ACTION_IDENTIFIER);
            boolean optBoolean = jSONObject.optBoolean("needAsync", false);
            boolean optBoolean2 = jSONObject.optBoolean(IECDtReport.ACTION_NEED_TRAVERSE_EXPOSURE, true);
            if ((optString.length() > 0) && (activity = renderViewExport.getActivity()) != null) {
                com.tencent.ecommerce.base.report.service.d dVar = (com.tencent.ecommerce.base.report.service.d) l(e.INSTANCE.b(activity).h(optString).j(true), optJSONObject2);
                if (!optJSONObject2.has(DTParamKey.REPORT_KEY_APPKEY)) {
                    dVar.g();
                }
                dVar.i();
            }
            if (optString2.length() > 0) {
                com.tencent.ecommerce.base.report.service.b.f100913b.resetDtReportInfo(renderViewExport.f());
                final f fVar = (f) l(e.INSTANCE.d(renderViewExport.f()).h(optString2), optJSONObject);
                fVar.k(optBoolean2);
                if (optString3.length() > 0) {
                    fVar.j(optString3);
                }
                if (!optJSONObject.has(DTParamKey.REPORT_KEY_APPKEY)) {
                    fVar.g();
                }
                if (optBoolean) {
                    ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.prop.ECHRDtViewPropHandler$bindVr$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            f.this.i();
                        }
                    });
                    return;
                } else {
                    fVar.i();
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // i01.d
    public boolean c(c renderViewExport, String propKey) {
        if (propKey.hashCode() != 3772 || !propKey.equals("vr")) {
            return false;
        }
        KRCSSViewExtensionKt.H(renderViewExport.f(), "preClick");
        KRCSSViewExtensionKt.H(renderViewExport.f(), "vr_layout_change_had_call");
        com.tencent.ecommerce.base.report.service.b.f100913b.resetDtReportInfo(renderViewExport.f());
        return true;
    }

    @Override // i01.d
    public boolean e(c renderViewExport, String propKey, Object propValue) {
        if (propKey.hashCode() != 3772 || !propKey.equals("vr")) {
            return false;
        }
        View f16 = renderViewExport.f();
        Boolean bool = (Boolean) KRCSSViewExtensionKt.w(f16, "vr_layout_change_had_call");
        if (bool != null ? bool.booleanValue() : false) {
            n(renderViewExport, propValue);
        } else {
            f16.addOnLayoutChangeListener(new b(f16, renderViewExport, propValue));
        }
        return true;
    }
}
