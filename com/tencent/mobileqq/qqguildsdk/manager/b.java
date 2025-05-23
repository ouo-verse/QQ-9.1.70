package com.tencent.mobileqq.qqguildsdk.manager;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ck;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.util.h;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f268449a;

    public b(GPSManagerEngine gPSManagerEngine) {
        this.f268449a = gPSManagerEngine;
    }

    public void a(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }

    public void b(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }

    public void c(@NonNull GProChannelInfo gProChannelInfo) {
        String str;
        if (gProChannelInfo != null) {
            str = "guildId \uff1a" + gProChannelInfo.getGuildId() + ", channelId:" + gProChannelInfo.getChannelUin();
        } else {
            str = "";
        }
        h.e("ChannelListMgr", false, "cache", "fetchChannelInfoWithSort", "new id", str);
        k(gProChannelInfo.getGuildId());
    }

    public void d(String str, ck ckVar) {
        GProChannelInfo gProChannelInfo;
        if (ckVar == null) {
            return;
        }
        HashMap<String, GProChannelInfo> b16 = ckVar.b();
        if (b16.containsKey(str) && (gProChannelInfo = b16.get(str)) != null) {
            c(gProChannelInfo);
            this.f268449a.ej(6, "fetchChannelInfoWithSort", gProChannelInfo);
        }
    }

    public List<cy> e(String str) {
        return com.tencent.mobileqq.qqguildsdk.util.g.c(this.f268449a.Pe(com.tencent.mobileqq.qqguildsdk.util.g.O0(str)));
    }

    public IGProChannelInfo f(String str) {
        IGProChannelInfo We = this.f268449a.We(com.tencent.mobileqq.qqguildsdk.util.g.O0(str));
        if (We != null && !"0".equals(We.getChannelUin())) {
            return We;
        }
        h.u("ChannelListMgr", false, "sdk interface", "getChannelInfo with error channelId\uff1a" + str);
        return null;
    }

    @NotNull
    public List<IGProChannelInfo> g(String str) {
        ArrayList arrayList = new ArrayList();
        List<cy> e16 = e(str);
        if (e16 != null) {
            Iterator<cy> it = e16.iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getChannelList());
            }
        }
        return arrayList;
    }

    public String h(String str) {
        IGProChannelInfo f16 = f(str);
        if (f16 == null) {
            h.u("ChannelListMgr", true, "sdk interface", "getGuildIdOf with error channelUin\uff1a" + str);
            return "";
        }
        return f16.getGuildId();
    }

    public List<IGProChannelInfo> i(String str, int i3) {
        ArrayList arrayList = new ArrayList();
        Iterator<GProChannel> it = this.f268449a.Sf(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), i3).iterator();
        while (it.hasNext()) {
            arrayList.add(new GProChannelInfo(it.next()));
        }
        return arrayList;
    }

    public void j(String str) {
        h.i("ChannelListMgr", true, "cache", "removeChannel " + str);
    }

    public void k(String str) {
        this.f268449a.ej(2, "refreshCategoryMap", str);
    }

    public void l(String str, ck ckVar) {
        if (ckVar == null) {
            return;
        }
        k(str);
    }

    public void m(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }

    public void n(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }

    public void o(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }

    public void p(String str, com.tencent.mobileqq.qqguildsdk.data.b bVar, List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        k(str);
    }
}
