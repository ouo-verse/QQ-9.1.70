package com.tencent.creatorad.servlet;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.creatorad.data.DataManager;
import com.tencent.creatorad.pb.CreatorReader$GetShareADReq;
import com.tencent.creatorad.pb.CreatorReader$GetShareADRsp;
import com.tencent.creatorad.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static b f100377d;

    /* renamed from: a, reason: collision with root package name */
    private qq_ad_get.QQAdGet.DeviceInfo f100378a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.tencent.creatorad.data.a> f100379b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<String>> f100380c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f100377d = null;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100379b = new ConcurrentHashMap<>();
            this.f100380c = new ConcurrentHashMap<>();
        }
    }

    private CreatorReader$GetShareADReq a(List<String> list, int i3) {
        CreatorReader$GetShareADReq creatorReader$GetShareADReq = new CreatorReader$GetShareADReq();
        qq_ad_get.QQAdGet.UserInfo userInfo = new qq_ad_get.QQAdGet.UserInfo();
        String c16 = c.c();
        creatorReader$GetShareADReq.busi_type.set(i3);
        creatorReader$GetShareADReq.tickets.set(list);
        creatorReader$GetShareADReq.user_info.set(userInfo);
        if (this.f100378a == null) {
            this.f100378a = c.d();
        }
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = this.f100378a;
        if (deviceInfo != null) {
            creatorReader$GetShareADReq.device_info.set(deviceInfo);
        }
        creatorReader$GetShareADReq.client_mod.set(c16);
        return creatorReader$GetShareADReq;
    }

    public static b b() {
        if (f100377d == null) {
            synchronized (b.class) {
                if (f100377d == null) {
                    f100377d = new b();
                }
            }
        }
        return f100377d;
    }

    private void d(com.tencent.creatorad.data.a aVar, CreatorReader$GetShareADRsp creatorReader$GetShareADRsp, boolean z16) {
        if (aVar == null) {
            return;
        }
        for (int i3 = 0; i3 < creatorReader$GetShareADRsp.ads.size(); i3++) {
            aVar.a(z16, creatorReader$GetShareADRsp.ads.get(i3));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(Intent intent, FromServiceMsg fromServiceMsg) {
        List<String> list;
        com.tencent.creatorad.data.a aVar;
        int resultCode;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("requestKey");
            if (!TextUtils.isEmpty(stringExtra)) {
                aVar = this.f100379b.get(stringExtra);
                this.f100379b.remove(stringExtra);
                list = this.f100380c.get(stringExtra);
                this.f100380c.remove(stringExtra);
                boolean z17 = false;
                if (fromServiceMsg.isSuccess()) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    bArr = bArr2;
                }
                CreatorReader$GetShareADRsp creatorReader$GetShareADRsp = new CreatorReader$GetShareADRsp();
                resultCode = fromServiceMsg.getResultCode();
                if (resultCode != 1000) {
                    try {
                        creatorReader$GetShareADRsp.mergeFrom(bArr);
                        z16 = c.e(creatorReader$GetShareADRsp);
                        try {
                            if (aVar != null && z16) {
                                d(aVar, creatorReader$GetShareADRsp, true);
                            } else {
                                QLog.e("CREATOR_AD.RequestManager", 1, "onGetShareADRsp, callback: " + aVar + " isAdValid: " + z16);
                                d(aVar, creatorReader$GetShareADRsp, false);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            QLog.e("CREATOR_AD.RequestManager", 1, "onReceive exception " + e);
                            d(aVar, creatorReader$GetShareADRsp, false);
                            z17 = z16;
                            DataManager.d().e(z17, creatorReader$GetShareADRsp, list);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        z16 = false;
                    }
                    z17 = z16;
                } else {
                    QLog.e("CREATOR_AD.RequestManager", 1, "onReceive result fail with result " + resultCode);
                    d(aVar, creatorReader$GetShareADRsp, false);
                }
                DataManager.d().e(z17, creatorReader$GetShareADRsp, list);
            }
        }
        list = arrayList;
        aVar = null;
        boolean z172 = false;
        if (fromServiceMsg.isSuccess()) {
        }
        CreatorReader$GetShareADRsp creatorReader$GetShareADRsp2 = new CreatorReader$GetShareADRsp();
        resultCode = fromServiceMsg.getResultCode();
        if (resultCode != 1000) {
        }
        DataManager.d().e(z172, creatorReader$GetShareADRsp2, list);
    }

    public void e(List<String> list, int i3, com.tencent.creatorad.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), aVar);
            return;
        }
        if (list != null && !list.isEmpty()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("CREATOR_AD.RequestManager", 1, "requestShareAD , get null appRuntime , requestShareAD cancel");
                    return;
                }
                return;
            }
            CreatorReader$GetShareADReq a16 = a(list, i3);
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), a.class);
            newIntent.putExtra("data", fh.b(a16.toByteArray()));
            newIntent.putExtra("cmd", "trpc.creator.reader.CreatorReader.SsoGetShareAD");
            String uuid = UUID.randomUUID().toString();
            if (aVar != null) {
                this.f100379b.put(uuid, aVar);
            }
            List<String> list2 = this.f100380c.get(uuid);
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.f100380c.put(uuid, new ArrayList(list));
            }
            newIntent.putExtra("requestKey", uuid);
            peekAppRuntime.startServlet(newIntent);
        }
    }
}
