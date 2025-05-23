package gu2;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import cooperation.qzone.PlatformInfor;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends hv2.c {
    @Override // hv2.c
    public String a() {
        return "";
    }

    @Override // hv2.c
    public String b() {
        return HostStaticInvokeHelper.getAIDTicket();
    }

    @Override // hv2.c
    public String c() {
        return "";
    }

    @Override // hv2.c
    public String d() {
        return PlatformInfor.g().getNetworkType();
    }

    @Override // hv2.c
    public String e() {
        return UUID.randomUUID().toString();
    }

    @Override // hv2.c
    public String f() {
        return "";
    }

    @Override // hv2.c
    public int g() {
        return TVideoConfig.f304492a.l();
    }

    @Override // hv2.c
    public int h() {
        return TVideoConfig.f304492a.m();
    }

    @Override // hv2.c
    public String j() {
        return HostStaticInvokeHelper.getTAIDTicket();
    }
}
