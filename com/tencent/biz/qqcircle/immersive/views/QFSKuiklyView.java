package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.events.QFSKuiklyEvent;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSKuiklyView extends QCircleBaseWidgetView implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, SimpleEventReceiver {
    private String C;
    private int D;
    private Map<String, String> E;
    private String F;
    private String G;
    private String H;
    private long I;
    private b J;
    private boolean K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    protected final QFSFullScreenHintView f90363d;

    /* renamed from: e, reason: collision with root package name */
    protected QCirclePanelLoadingView f90364e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f90365f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g f90366h;

    /* renamed from: i, reason: collision with root package name */
    private String f90367i;

    /* renamed from: m, reason: collision with root package name */
    private String f90368m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSKuiklyView.this.o0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void onPageLoadComplete(boolean z16, @Nullable ErrorReason errorReason, @NonNull KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode);
    }

    public QFSKuiklyView(@NonNull Context context) {
        this(context, null);
    }

    private void l0(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(frameLayout, layoutParams);
        this.f90365f = frameLayout;
        this.f90364e = new QCirclePanelLoadingView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        frameLayout.addView(this.f90364e, layoutParams2);
    }

    private void m0(@NonNull QFSKuiklyEvent qFSKuiklyEvent) {
        String paramsString = qFSKuiklyEvent.getParamsString("qq_cir_kuikly_view_tag");
        if (TextUtils.equals(qFSKuiklyEvent.eventName, "qvideo_reload_kuikly_view") && !TextUtils.isEmpty(this.G) && TextUtils.equals(this.G, paramsString)) {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "handleKuiklyEvent reloadData");
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "realLoadData");
        showLoadingView();
        n0(this.f90367i, this.f90368m, this.C, this.D, true, this.E);
    }

    private void p0() {
        Object obj = this.f90366h;
        if (obj != null && (obj instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) obj;
            if (viewGroup.getChildCount() <= 0) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                if (viewGroup2.getChildCount() <= 0) {
                    return;
                }
                RFWLog.d("QFSKuiklyView", RFWLog.USR, "real do request layout");
                viewGroup2.getChildAt(0).requestLayout();
            }
        }
    }

    private void r0() {
        if (TextUtils.isEmpty(this.H)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendUpdateSchemaEvent :" + this.H);
            jSONObject.put(QZoneDTLoginReporter.SCHEMA, this.H);
            jSONObject.put("schema_jump_time", this.I);
            jSONObject.put("qq_cir_kuikly_view_tag", this.G);
            com.tencent.kuikly.core.render.android.expand.module.l.e(getContext(), "QQCir_Video_To_Kuikly_Send_Enter_Schema", jSONObject);
        } catch (JSONException e16) {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendUpdateSchemaEvent error:" + e16);
        }
    }

    private void s0() {
        JSONObject jSONObject = new JSONObject();
        try {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendViewReloadSucceedEvent " + this.G);
            jSONObject.put("qq_cir_kuikly_view_tag", this.G);
            com.tencent.kuikly.core.render.android.expand.module.l.e(getContext(), "QQCirKuiklyViewReloadSuccess", jSONObject);
        } catch (JSONException e16) {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendViewReloadSucceedEvent error:" + e16);
        }
    }

    private void u0(Map<String, String> map) {
        if (map == null) {
            return;
        }
        try {
            String str = map.get("qfs_page_bg_color");
            if (str == null) {
                return;
            }
            int parseColor = Color.parseColor("#" + ((Object) str));
            FrameLayout frameLayout = this.f90365f;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(parseColor);
            }
            setBackgroundColor(parseColor);
            QFSFullScreenHintView qFSFullScreenHintView = this.f90363d;
            if (qFSFullScreenHintView != null) {
                qFSFullScreenHintView.setBackgroundColor(parseColor);
            }
        } catch (Exception e16) {
            RFWLog.e("QFSKuiklyView", RFWLog.USR, "setLoadingBgColor error:" + e16);
        }
    }

    private boolean v0(String str, String str2, String str3, int i3) {
        int b16;
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.f90366h;
        if (gVar != null) {
            gVar.onPause();
            this.f90366h.onDetach();
            removeView((View) this.f90366h);
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "tryReplaceView remove old");
        }
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "tryReplaceView add new;pageName:" + str + ",resId:" + str2 + ",high:" + i3);
        this.f90366h = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(getContext(), this);
        if (i3 <= 0) {
            b16 = -1;
        } else {
            b16 = com.tencent.qqnt.base.utils.c.f353052a.b(i3);
        }
        addView((View) this.f90366h, 0, new FrameLayout.LayoutParams(-1, b16));
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSKuiklyEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "hideErrorView");
        QFSFullScreenHintView qFSFullScreenHintView = this.f90363d;
        if (qFSFullScreenHintView != null) {
            qFSFullScreenHintView.o0();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "hideLoadingView");
        QCirclePanelLoadingView qCirclePanelLoadingView = this.f90364e;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        FrameLayout frameLayout = this.f90365f;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void n0(String str, String str2, String str3, int i3, boolean z16, Map<String, String> map) {
        this.L++;
        v0(str, str2, str3, i3);
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
            this.F = map.get(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID);
            String str4 = this.F + hashCode();
            this.G = str4;
            hashMap.put("qq_cir_kuikly_view_tag", str4);
        }
        u0(map);
        hashMap.put("bundle_name", str2);
        hashMap.put("server_data", str3);
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.f90366h;
        if (gVar != null) {
            gVar.b(str, hashMap, null);
        }
        this.f90367i = str;
        this.f90368m = str2;
        this.C = str3;
        this.D = i3;
        this.E = map;
    }

    public void onDestroy() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.f90366h;
        if (gVar != null) {
            gVar.onDetach();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, @Nullable ErrorReason errorReason, @NonNull KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar;
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "onPageLoadComplete isSucceed:" + z16);
        if (z16) {
            p0();
        }
        b bVar = this.J;
        if (bVar != null) {
            bVar.onPageLoadComplete(z16, errorReason, kuiklyRenderCoreExecuteMode);
        }
        if (this.K && (gVar = this.f90366h) != null) {
            gVar.onResume();
        }
        if (this.L > 1) {
            s0();
        }
        r0();
    }

    public void onPause() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.f90366h;
        if (gVar != null) {
            gVar.onPause();
        }
        this.K = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSKuiklyEvent) {
            m0((QFSKuiklyEvent) simpleBaseEvent);
        }
    }

    public void onResume() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.f90366h;
        if (gVar != null) {
            gVar.onResume();
        }
        this.K = true;
    }

    public void q0() {
        JSONObject jSONObject = new JSONObject();
        try {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendRefreshMsg:" + this.G);
            jSONObject.put("qq_cir_kuikly_view_tag", this.G);
            com.tencent.kuikly.core.render.android.expand.module.l.e(getContext(), "qvideo_kuikly_refresh_in_kuikly", jSONObject);
        } catch (JSONException e16) {
            RFWLog.d("QFSKuiklyView", RFWLog.USR, "sendRefreshMsg error:" + e16);
        }
    }

    public void setKuiklyCallback(b bVar) {
        this.J = bVar;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "showErrorView");
        QFSFullScreenHintView qFSFullScreenHintView = this.f90363d;
        if (qFSFullScreenHintView != null) {
            qFSFullScreenHintView.x0("\u9875\u9762\u52a0\u8f7d\u5931\u8d25\u8bf7\u91cd\u8bd5");
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "showLoadingView");
        QCirclePanelLoadingView qCirclePanelLoadingView = this.f90364e;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.n0();
        }
        FrameLayout frameLayout = this.f90365f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public void w0(String str, long j3) {
        RFWLog.d("QFSKuiklyView", RFWLog.USR, "updateSchemaInfo:" + str + ",enterTime:" + j3);
        this.H = str;
        this.I = j3;
        r0();
    }

    public QFSKuiklyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSKuiklyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        l0(context);
        QFSFullScreenHintView qFSFullScreenHintView = new QFSFullScreenHintView(context);
        this.f90363d = qFSFullScreenHintView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(qFSFullScreenHintView, layoutParams);
        qFSFullScreenHintView.setTokenByErrorCode(10014L, 16);
        qFSFullScreenHintView.setTokenByErrorCode(10009L, 1);
        qFSFullScreenHintView.setOnRetryClickListener(new a());
        qFSFullScreenHintView.setVisibility(8);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
