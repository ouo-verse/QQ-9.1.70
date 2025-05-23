package common.config.service;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f390045a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f390046b;

    c() {
    }

    public static c a() {
        if (f390046b == null) {
            synchronized (f390045a) {
                if (f390046b == null) {
                    f390046b = new c();
                }
            }
        }
        return f390046b;
    }

    public int b() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_POI_CACHE_DISTANCE, 1000);
    }
}
