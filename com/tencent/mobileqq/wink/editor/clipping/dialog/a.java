package com.tencent.mobileqq.wink.editor.clipping.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.videocut.utils.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends ReportDialog {
    public static int T = e.f384236a.a(65.0f);
    private final int C;
    private final int D;
    HashMap<Float, TextView> E;
    float F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    b N;
    private int P;
    private int Q;
    private int R;
    private View S;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.editor.clipping.dialog.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class ViewOnClickListenerC9019a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        float f319159d;

        public ViewOnClickListenerC9019a(float f16) {
            this.f319159d = f16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            for (Map.Entry<Float, TextView> entry : a.this.E.entrySet()) {
                entry.getValue().setSelected(false);
                entry.getValue().setTextColor(a.this.C);
            }
            view.setSelected(true);
            ((TextView) view).setTextColor(a.this.D);
            b bVar = a.this.N;
            if (bVar != null) {
                bVar.a(this.f319159d, view);
                a.this.dismiss();
            }
            VideoReport.reportEvent("dt_clck", a.this.G, WinkDTParamBuilder.buildElementParams());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(float f16, View view);
    }

    public a(Context context, int i3) {
        super(context, R.style.f173460a10);
        this.C = getContext().getResources().getColor(R.color.f158017al3);
        this.D = getContext().getResources().getColor(R.color.b9n);
        this.E = new HashMap<>();
        this.F = 1.0f;
        this.P = x.c(getContext(), 212.0f);
        this.Q = x.c(getContext(), 12.0f);
        this.R = 85;
        init();
    }

    private void Q(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void R() {
        int i3;
        HashMap<Float, TextView> hashMap = this.E;
        if (hashMap != null) {
            for (Map.Entry<Float, TextView> entry : hashMap.entrySet()) {
                boolean a16 = l63.b.a(entry.getKey().floatValue(), this.F);
                entry.getValue().setSelected(a16);
                TextView value = entry.getValue();
                if (a16) {
                    i3 = this.D;
                } else {
                    i3 = this.C;
                }
                value.setTextColor(i3);
            }
        }
    }

    private void S() {
        if (this.S == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getOwnerActivity());
        VideoReport.setPageId(this.S, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        VideoReport.setPageParams(this.S, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        VideoReport.ignorePageInOutEvent(this.S, true);
    }

    private void init() {
        this.S = LayoutInflater.from(getContext()).inflate(R.layout.f168940hf1, (ViewGroup) null);
        S();
        this.G = (TextView) this.S.findViewById(R.id.f112466o0);
        this.H = (TextView) this.S.findViewById(R.id.f111406l5);
        this.I = (TextView) this.S.findViewById(R.id.f111456l_);
        this.J = (TextView) this.S.findViewById(R.id.f1063168d);
        this.K = (TextView) this.S.findViewById(R.id.f110376ic);
        this.L = (TextView) this.S.findViewById(R.id.f112456nz);
        this.M = (TextView) this.S.findViewById(R.id.f112446ny);
        this.G.setOnClickListener(new ViewOnClickListenerC9019a(0.5f));
        this.H.setOnClickListener(new ViewOnClickListenerC9019a(0.75f));
        this.I.setOnClickListener(new ViewOnClickListenerC9019a(1.0f));
        this.J.setOnClickListener(new ViewOnClickListenerC9019a(1.25f));
        this.K.setOnClickListener(new ViewOnClickListenerC9019a(1.5f));
        this.L.setOnClickListener(new ViewOnClickListenerC9019a(2.0f));
        this.M.setOnClickListener(new ViewOnClickListenerC9019a(3.0f));
        this.E.put(Float.valueOf(0.5f), this.G);
        this.E.put(Float.valueOf(0.75f), this.H);
        this.E.put(Float.valueOf(1.0f), this.I);
        this.E.put(Float.valueOf(1.25f), this.J);
        this.E.put(Float.valueOf(1.5f), this.K);
        this.E.put(Float.valueOf(2.0f), this.L);
        this.E.put(Float.valueOf(3.0f), this.M);
        Q(this.G, WinkDaTongReportConstant.ElementId.EM_XSJ_SPEED_BUTTON);
    }

    public void U(float f16) {
        this.F = f16;
        R();
    }

    public void W(b bVar) {
        this.N = bVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setGravity(int i3) {
        this.R = i3;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        super.show();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(this.R);
        attributes.y = this.P;
        attributes.x = this.Q;
        attributes.dimAmount = 0.1f;
        window.setAttributes(attributes);
        window.setLayout(T, -2);
        window.setContentView(this.S);
    }
}
