package jw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends d {

    /* renamed from: o, reason: collision with root package name */
    private String f411045o;

    /* renamed from: p, reason: collision with root package name */
    private HashMap<String, String> f411046p;

    public a(String str, HashMap<String, String> hashMap, int i3) {
        super(null, "", "", "", "");
        this.f411045o = str;
        this.f411046p = hashMap;
        this.f304058k = false;
        u(i3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public HashMap<String, String> b() {
        return this.f411046p;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public String q() {
        return this.f411045o;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        ReportManager.INSTANCE.report(this, this.f304054g, 11, gVar);
    }
}
