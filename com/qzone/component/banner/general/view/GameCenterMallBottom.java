package com.qzone.component.banner.general.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.util.l;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import l6.d;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GameCenterMallBottom extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f46598d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f46599e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f46600f;

    /* renamed from: h, reason: collision with root package name */
    private Button f46601h;

    /* renamed from: i, reason: collision with root package name */
    private i6.a f46602i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(619, 18, 3, "", "1");
            String b16 = d.b(GameCenterMallBottom.this.f46602i);
            if (TextUtils.isEmpty(b16)) {
                b16 = d.d(GameCenterMallBottom.this.f46602i).optString("product_detail_url");
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterMallBottom", 2, "go mall detail\uff1a " + b16);
                }
            }
            if (!TextUtils.isEmpty(b16)) {
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterMallBottom", 2, "go mall detail\uff1a " + b16);
                }
                GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, b16);
                if (GameCenterMallBottom.this.f46602i != null) {
                    int f16 = d.f(GameCenterMallBottom.this.f46602i, "app_type");
                    d.j(GameCenterMallBottom.this.f46602i.g(), "914336", "", GameCenterMallBottom.this.f46602i.s(), "20", String.valueOf(f16), GameCenterMallBottom.this.f46602i.e(), String.valueOf(GameCenterMallBottom.this.f46602i.c()), d.a(f16));
                    d.k(GameCenterMallBottom.this.f46602i.d(), 102, "tianshu.289");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GameCenterMallBottom(Context context) {
        super(context);
        c(context);
    }

    private double b(double d16) {
        return Double.valueOf(new DecimalFormat("#0.00").format(d16 / 100.0d)).doubleValue();
    }

    private void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f127701d, (ViewGroup) null, false);
        this.f46598d = (TextView) inflate.findViewById(R.id.nj6);
        this.f46599e = (TextView) inflate.findViewById(R.id.nj7);
        this.f46600f = (TextView) inflate.findViewById(R.id.nj8);
        Button button = (Button) inflate.findViewById(R.id.f195964);
        this.f46601h = button;
        button.setOnClickListener(new a());
        addView(inflate);
    }

    public GameCenterMallBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void d(i6.a aVar) {
        if (aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterMallBottom", 2, aVar.toString());
        }
        this.f46602i = aVar;
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterMallBottom", 2, "onBindData: " + this.f46602i);
        }
        JSONObject d16 = d.d(this.f46602i);
        this.f46598d.setText(aVar.t());
        this.f46601h.setText(l.a(R.string.f132894n));
        double optDouble = d16.optDouble("final_price", 0.0d);
        double optDouble2 = d16.optDouble("origin_price", 0.0d);
        if (new BigDecimal(optDouble).compareTo(new BigDecimal(optDouble2)) == 0) {
            this.f46599e.setVisibility(0);
            this.f46599e.setText("\u00a5" + b(optDouble));
            this.f46600f.setVisibility(8);
            return;
        }
        if (optDouble2 == 0.0d && optDouble > 0.0d) {
            this.f46599e.setVisibility(0);
            this.f46599e.setText("\u00a5" + b(optDouble));
            this.f46600f.setVisibility(8);
            return;
        }
        if (optDouble != 0.0d && optDouble <= optDouble2) {
            this.f46599e.setVisibility(optDouble < 0.0d ? 8 : 0);
            this.f46599e.setText("\u00a5" + b(optDouble));
            TextView textView = this.f46600f;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.f46600f.setVisibility(optDouble2 < 0.0d ? 8 : 0);
            this.f46600f.setText("\u00a5" + b(optDouble2));
            return;
        }
        this.f46599e.setVisibility(8);
        this.f46600f.setVisibility(8);
    }
}
