package oz4;

import java.util.UUID;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class j implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public static final j f424770i = new j();

    /* renamed from: d, reason: collision with root package name */
    public final String f424771d = UUID.randomUUID().toString();

    /* renamed from: e, reason: collision with root package name */
    public int f424772e;

    /* renamed from: f, reason: collision with root package name */
    public String f424773f;

    /* renamed from: h, reason: collision with root package name */
    public int f424774h;

    public static j a() {
        return f424770i;
    }

    public final String toString() {
        return "TrackerEventApp{appIdBiz=" + this.f424772e + ", appVersionName='" + this.f424773f + "', appVersionCode=" + this.f424774h + ", channel='null', appAbi='null', startId='" + this.f424771d + "'}";
    }
}
