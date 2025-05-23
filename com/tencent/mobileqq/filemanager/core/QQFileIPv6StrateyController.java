package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes12.dex */
public class QQFileIPv6StrateyController implements INetInfoHandler {

    /* renamed from: e, reason: collision with root package name */
    private String f207570e = "";

    /* renamed from: f, reason: collision with root package name */
    private boolean f207571f = false;

    /* renamed from: h, reason: collision with root package name */
    private long f207572h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f207573i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f207574m = true;
    private boolean C = true;
    private boolean D = true;
    private boolean E = true;
    private int F = 1;

    /* renamed from: d, reason: collision with root package name */
    private FileIPv6Detecter f207569d = new FileIPv6Detecter();

    /* renamed from: com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ QQFileIPv6StrateyController this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.this$0.f207571f) {
                return;
            }
            AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
            this.this$0.f207571f = false;
        }
    }

    private d.b A(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.contains("[") && str.contains("]")) {
                int indexOf = str.indexOf("[");
                int indexOf2 = str.indexOf("]");
                if (indexOf2 > indexOf) {
                    return new d.b(str.substring(indexOf, indexOf2 + 1), i3);
                }
                QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo err. ipPortStr:" + str);
                return null;
            }
            int lastIndexOf = str.lastIndexOf(":");
            if (lastIndexOf >= 0) {
                return new d.b(str.substring(0, lastIndexOf), i3);
            }
            return new d.b(str, i3);
        } catch (Exception unused) {
            QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo exp. ipPortStr:" + str);
            return null;
        }
    }

    private void D(BaseQQAppInterface baseQQAppInterface, boolean z16, String str, int i3) {
        int i16;
        int i17;
        int i18 = 2;
        if (C()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 7) {
                        i17 = 0;
                    } else {
                        i17 = 3;
                    }
                } else {
                    i17 = 4;
                }
            } else {
                i17 = 2;
            }
        } else {
            i17 = 1;
        }
        int i19 = QQFileUtilsImpl.i();
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 != 3) {
                    i18 = 0;
                }
            } else {
                i18 = 3;
            }
        } else {
            i18 = 1;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_domain", String.valueOf(str));
        hashMap.put("param_result", String.valueOf(!z16 ? 1 : 0));
        hashMap.put("param_stackType", String.valueOf(i18));
        hashMap.put("param_loginType", String.valueOf(i16));
        hashMap.put("param_bizType", String.valueOf(i17));
        String str2 = this.f207570e;
        if (baseQQAppInterface != null) {
            str2 = baseQQAppInterface.getCurrentAccountUin();
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "actFAIPDerect", true, 0L, 0L, hashMap, null);
        QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] >> reportInnerDnsResult:" + hashMap.toString());
    }

    private void c(List<d.b> list, List<String> list2, int i3, int i16) {
        d.b A;
        if (list2 != null && list2.size() != 0 && list != null && i16 != 0) {
            int i17 = 0;
            for (String str : list2) {
                if (!TextUtils.isEmpty(str) && (A = A(str, i3)) != null) {
                    if (i17 < i16) {
                        list.add(A);
                        i17++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private BaseQQAppInterface d(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface == null) {
            return QQFileManagerUtilImpl.A0();
        }
        return baseQQAppInterface;
    }

    private int r(BaseQQAppInterface baseQQAppInterface) {
        IQFileConfigManager iQFileConfigManager;
        if (baseQQAppInterface == null || (iQFileConfigManager = (IQFileConfigManager) baseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")) == null) {
            return 0;
        }
        return iQFileConfigManager.getFileIPv6Strategy();
    }

    private List<d.b> v(BaseQQAppInterface baseQQAppInterface, String str, int i3, int i16, boolean z16) {
        boolean z17;
        String str2;
        int i17;
        List<d.b> list = null;
        if (str != null && !TextUtils.isEmpty(str)) {
            ArrayList<String> reqDnsForIpList = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).reqDnsForIpList(str, true, 28);
            if (reqDnsForIpList != null && reqDnsForIpList.size() > 0) {
                list = new ArrayList<>();
                if (z16) {
                    i17 = reqDnsForIpList.size();
                } else {
                    i17 = 1;
                }
                c(list, reqDnsForIpList, i3, i17);
                str2 = list.toString();
                z17 = true;
            } else {
                z17 = false;
                str2 = "";
            }
            QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns[" + str + "] result:" + z17 + " IPv6List[" + str2 + "]");
            D(baseQQAppInterface, z17, str, i16);
        } else {
            QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. domain=null");
        }
        return list;
    }

    private d.c w(BaseQQAppInterface baseQQAppInterface, d.a aVar, int i3) {
        int r16 = r(baseQQAppInterface);
        if (r16 == 0) {
            return null;
        }
        if (r16 == 1) {
            return x(baseQQAppInterface, aVar, i3, false);
        }
        if (r16 != 2 || !C()) {
            return null;
        }
        return x(baseQQAppInterface, aVar, i3, false);
    }

    private d.c x(BaseQQAppInterface baseQQAppInterface, d.a aVar, int i3, boolean z16) {
        List<d.b> v3 = v(baseQQAppInterface, aVar.f207639a, aVar.f207640b, i3, z16);
        d.c cVar = new d.c();
        if (v3 != null && v3.size() != 0) {
            if (!z16 && !this.f207569d.g(aVar)) {
                this.f207569d.e(baseQQAppInterface, aVar, v3.get(0));
                return null;
            }
            cVar.f207643a = 2;
            cVar.f207644b = v3;
            return cVar;
        }
        q();
        cVar.f207643a = 1;
        cVar.f207644b.add(new d.b(aVar.f207639a, aVar.f207640b));
        return cVar;
    }

    private boolean[] y(BaseQQAppInterface baseQQAppInterface) {
        boolean z16;
        boolean z17;
        if (1 != QQFileUtilsImpl.i()) {
            if (3 == QQFileUtilsImpl.i()) {
                z17 = true;
                z16 = z17;
                return new boolean[]{z17, z16};
            }
            if (2 == QQFileUtilsImpl.i() && r(baseQQAppInterface) != 0 && (r(baseQQAppInterface) == 1 || (r(baseQQAppInterface) == 2 && C()))) {
                z16 = false;
                z17 = true;
                return new boolean[]{z17, z16};
            }
        }
        z17 = false;
        z16 = z17;
        return new boolean[]{z17, z16};
    }

    public boolean B(BaseQQAppInterface baseQQAppInterface, int i3) {
        IQFileConfigManager iQFileConfigManager;
        if (d(baseQQAppInterface) == null || (iQFileConfigManager = (IQFileConfigManager) baseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")) == null) {
            return false;
        }
        if (i3 == 1) {
            return iQFileConfigManager.getC2CFileIPv6Switch();
        }
        if (i3 == 3) {
            return iQFileConfigManager.getGroupFileIPv6Switch();
        }
        if (i3 == 5 || i3 != 7) {
            return false;
        }
        return iQFileConfigManager.getDatalineFileIPv6Switch();
    }

    public boolean C() {
        if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
            return true;
        }
        return false;
    }

    public int e() {
        return this.F;
    }

    public boolean f() {
        return this.f207574m;
    }

    public boolean g() {
        return this.E;
    }

    public boolean h() {
        return this.D;
    }

    public boolean i() {
        return this.C;
    }

    public boolean j() {
        return this.f207573i;
    }

    public void k(boolean z16) {
        this.f207574m = z16;
    }

    public void l(boolean z16) {
        this.E = z16;
    }

    public void m(boolean z16) {
        this.D = z16;
    }

    public void n(boolean z16) {
        this.C = z16;
    }

    public void o(int i3) {
        this.F = i3;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        this.f207569d.h();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        this.f207569d.h();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        this.f207569d.h();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        this.f207569d.h();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        this.f207569d.h();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        this.f207569d.h();
    }

    public void p(boolean z16) {
        this.f207573i = z16;
    }

    public List<ExcitingTransferHostInfo> s(BaseQQAppInterface baseQQAppInterface, int i3) {
        List<ExcitingTransferHostInfo> bigDataHostList;
        BaseQQAppInterface d16 = d(baseQQAppInterface);
        if (!B(d16, i3)) {
            return null;
        }
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPV6listForExcitingUpload on enable IPV6. busType:" + i3 + " stacktype:" + QQFileUtilsImpl.i() + " isV6Login:" + C() + " stratey:" + r(d16));
        boolean[] y16 = y(d16);
        boolean z16 = y16[0];
        boolean z17 = y16[1];
        if (!z16 || (bigDataHostList = ((IExcitingTransferAdapter) baseQQAppInterface.getRuntimeService(IExcitingTransferAdapter.class, "")).getBigDataHostList(true)) == null || bigDataHostList.size() == 0) {
            return null;
        }
        if (z17) {
            return bigDataHostList;
        }
        ArrayList arrayList = new ArrayList();
        for (ExcitingTransferHostInfo excitingTransferHostInfo : bigDataHostList) {
            if (arrayList.size() >= 1) {
                break;
            }
            arrayList.add(excitingTransferHostInfo);
        }
        return arrayList;
    }

    public List<String> t(BaseQQAppInterface baseQQAppInterface, int i3, List<String> list) {
        if (list != null && list.size() != 0) {
            BaseQQAppInterface d16 = d(baseQQAppInterface);
            if (!B(d16, i3)) {
                return null;
            }
            QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPV6listForMediaPlatfrom on enable IPV6. busType:" + i3 + " stacktype:" + QQFileUtilsImpl.i() + " isV6Login:" + C() + " stratey:" + r(d16));
            boolean[] y16 = y(d16);
            boolean z16 = y16[0];
            boolean z17 = y16[1];
            if (z16) {
                ArrayList arrayList = new ArrayList();
                if (z17) {
                    arrayList.addAll(list);
                    return arrayList;
                }
                for (String str : list) {
                    if (arrayList.size() >= 1) {
                        break;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    public d.c u(BaseQQAppInterface baseQQAppInterface, d.a aVar, int i3) {
        if (aVar == null) {
            return null;
        }
        BaseQQAppInterface d16 = d(baseQQAppInterface);
        if (!B(d16, i3)) {
            return null;
        }
        if (d16 != null) {
            this.f207570e = d16.getCurrentUin();
        } else {
            QLog.w("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. app=null");
        }
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPlistForV6Domain on enable IPV6. busType:" + i3 + " ipv6Domain:" + aVar.f207639a + " port:" + aVar.f207640b + " stacktype:" + QQFileUtilsImpl.i() + " isV6Login:" + C() + " stratey:" + r(d16));
        if (1 == QQFileUtilsImpl.i()) {
            return null;
        }
        if (3 == QQFileUtilsImpl.i()) {
            return x(d16, aVar, i3, true);
        }
        if (2 != QQFileUtilsImpl.i()) {
            return null;
        }
        return w(d16, aVar, i3);
    }

    public void z() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController.1
            @Override // java.lang.Runnable
            public void run() {
                if (QQFileIPv6StrateyController.this.f207571f) {
                    return;
                }
                AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), QQFileIPv6StrateyController.this);
                QQFileIPv6StrateyController.this.f207571f = true;
            }
        });
    }

    private void q() {
    }
}
