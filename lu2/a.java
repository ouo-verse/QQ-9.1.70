package lu2;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, b> f415566a = new HashMap<>();

    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        b bVar;
        if (aVar != null && (bVar = this.f415566a.get(Integer.valueOf(aVar.a()))) != null) {
            bVar.a(aVar);
        }
    }

    public void b(int i3, b bVar) {
        this.f415566a.put(Integer.valueOf(i3), bVar);
    }
}
