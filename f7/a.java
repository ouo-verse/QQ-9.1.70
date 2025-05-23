package f7;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public boolean a(com.qzone.jbox2d.dynamics.e eVar, com.qzone.jbox2d.dynamics.e eVar2) {
        com.qzone.jbox2d.dynamics.d g16 = eVar.g();
        com.qzone.jbox2d.dynamics.d g17 = eVar2.g();
        int i3 = g16.f48207c;
        return (i3 != g17.f48207c || i3 == 0) ? ((g16.f48206b & g17.f48205a) == 0 || (g16.f48205a & g17.f48206b) == 0) ? false : true : i3 > 0;
    }
}
