package fm;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.service.qzone.e;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends ql.a {
    private boolean E;
    private boolean F;
    private boolean H;
    private boolean I;
    private Intent J;

    /* renamed from: m, reason: collision with root package name */
    private boolean f399789m = false;
    private boolean C = false;
    private ro.a D = null;
    private boolean G = true;
    private boolean K = false;

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public boolean O1() {
        return this.G;
    }

    public ro.a P1() {
        return this.D;
    }

    public boolean Q1() {
        return this.K;
    }

    public boolean R1() {
        return this.C;
    }

    public boolean S1() {
        if (this.I) {
            return this.H;
        }
        e eVar = e.f286406a;
        eVar.k();
        com.tencent.mobileqq.service.qzone.a aVar = com.tencent.mobileqq.service.qzone.a.f286399a;
        aVar.a();
        Intent intent = this.J;
        boolean z16 = intent != null && TextUtils.equals(intent.getStringExtra(QZoneJsConstants.SOURCE_HOLIDAY), "1") && aVar.c() != null && eVar.e();
        this.H = z16;
        this.I = true;
        return z16;
    }

    public boolean T1() {
        return this.f399789m;
    }

    public void U1(boolean z16) {
        this.G = z16;
    }

    public void W1(boolean z16) {
        this.C = z16;
    }

    public void X1(boolean z16) {
        this.F = z16;
    }

    public void Z1(boolean z16) {
        this.f399789m = z16;
    }

    public void a2(boolean z16) {
        this.K = z16;
    }

    public void b2(boolean z16) {
        this.E = z16;
    }

    public void c2(ro.a aVar) {
        this.D = aVar;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZonePublishMoodPageConfigViewModel";
    }

    public void setIntent(Intent intent) {
        this.J = intent;
    }
}
