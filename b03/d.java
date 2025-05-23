package b03;

import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f27636a;

    /* renamed from: b, reason: collision with root package name */
    public long f27637b;

    /* renamed from: c, reason: collision with root package name */
    public int f27638c;

    /* renamed from: d, reason: collision with root package name */
    public long f27639d;

    /* renamed from: e, reason: collision with root package name */
    public String f27640e;

    /* renamed from: f, reason: collision with root package name */
    public String f27641f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f27642g;

    public d(qcUserinfoServer.ItemCheckInfo itemCheckInfo) {
        this.f27636a = itemCheckInfo.appid.get();
        this.f27637b = itemCheckInfo.itemid.get();
        this.f27638c = itemCheckInfo.ret.get();
        this.f27639d = itemCheckInfo.validts.get();
        this.f27640e = itemCheckInfo.url.get();
        this.f27641f = itemCheckInfo.text.get();
        this.f27642g = itemCheckInfo.isSetup.get();
    }
}
