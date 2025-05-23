package com.tencent.luggage.wxa.z1;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends n {

    /* renamed from: h0, reason: collision with root package name */
    public v f146178h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f146179i0;

    public e(Context context, p pVar) {
        super(context, pVar);
        setForceDisableMeasureCache(true);
        w.d("MicroMsg.WAGamePage", "hy: WAGamePage on create");
    }

    public final v F() {
        return getContainer().d(this.f146179i0);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public boolean a(String str) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void g() {
        super.g();
        this.f146178h0.e();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public v getCurrentPageView() {
        return this.f146178h0;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public String getCurrentUrl() {
        return this.f146179i0;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public View h() {
        if (this.f146178h0 == null) {
            v F = F();
            this.f146178h0 = F;
            a(F);
        }
        return this.f146178h0.getContentView();
    }

    public void setCurrentUrl(String str) {
        this.f146179i0 = str;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void setInitialUrl(String str) {
        this.f146179i0 = str;
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void t() {
        super.t();
        this.f146178h0.V0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void u() {
        super.u();
        this.f146178h0.X0();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void v() {
        super.v();
        setEnableGesture(this.f146178h0.O0());
        this.f146178h0.a1();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(long j3, String str, k1 k1Var) {
        this.f146179i0 = str;
        this.f146178h0.a(j3, str, k1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(String str, v vVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public boolean a(long j3, String str, k1 k1Var, JSONObject jSONObject) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public void a(String str, String str2, int[] iArr) {
        this.f146178h0.a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.kj.n
    public v a(int i3, boolean z16) {
        if (this.f146178h0.getComponentId() == i3) {
            return this.f146178h0;
        }
        return null;
    }
}
