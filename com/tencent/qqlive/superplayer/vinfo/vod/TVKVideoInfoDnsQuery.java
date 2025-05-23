package com.tencent.qqlive.superplayer.vinfo.vod;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.net.InetAddress;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKVideoInfoDnsQuery extends BaseThread {
    String C;
    ArrayList<String> D = new ArrayList<>();
    ArrayList<String> E = new ArrayList<>();

    public TVKVideoInfoDnsQuery(String str) {
        this.C = "";
        this.C = str;
    }

    private synchronized void c(String str) {
        this.D.add(str);
    }

    private synchronized void d(String str) {
        this.E.add(str);
    }

    public synchronized ArrayList<String> o() {
        return this.E;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            System.out.println("dns:" + this.C + " begin");
            InetAddress[] allByName = InetAddress.getAllByName(this.C);
            for (int i3 = 0; i3 < allByName.length; i3++) {
                System.out.println("dns:" + this.C + " result:" + allByName[i3].getHostAddress() + " byte[] length:" + allByName[i3].getAddress().length);
                if (allByName[i3].getAddress().length == 16) {
                    d(allByName[i3].getHostAddress());
                } else {
                    c(allByName[i3].getHostAddress());
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            System.out.println("dns:" + this.C + " elaspe:" + currentTimeMillis2);
        } catch (Exception unused) {
            System.out.println("Could not find getvinfo host");
        }
    }
}
