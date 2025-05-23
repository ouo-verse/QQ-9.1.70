package com.tencent.mobileqq.config;

import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$TabRule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QConfigServlet extends MSFServlet {
    protected static boolean C;
    protected static int D;
    protected static boolean E;
    protected static int F;
    protected static boolean G;
    protected static boolean H;
    private static ArrayList I;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f202245e;

    /* renamed from: f, reason: collision with root package name */
    public static String f202246f;

    /* renamed from: h, reason: collision with root package name */
    protected static boolean f202247h;

    /* renamed from: i, reason: collision with root package name */
    protected static boolean f202248i;

    /* renamed from: m, reason: collision with root package name */
    protected static int f202249m;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQManage/Inject_config_old_servlet.yml", version = 1)
    k f202250d = new b();

    static {
        ArrayList arrayList = new ArrayList();
        I = arrayList;
        arrayList.add(za1.a.class);
        f202245e = QConfigServlet.class.getSimpleName() + ".CORE";
        f202246f = "";
        f202249m = 0;
        D = 0;
        F = 0;
    }

    private boolean b(Intent intent, ConfigurationService$RespGetConfig configurationService$RespGetConfig, int[] iArr, boolean z16) {
        l e16;
        int i3;
        if (z16 && configurationService$RespGetConfig.result.get() == 0) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f202245e, 2, "onReceive fail: success=", Boolean.valueOf(z16), ", resultCode=", Integer.valueOf(configurationService$RespGetConfig.result.get()), ", config_list_size=", Integer.valueOf(configurationService$RespGetConfig.config_list.size()));
        }
        for (int i16 : iArr) {
            if (am.s().Q(i16) && (e16 = am.s().e(i16)) != null) {
                if (configurationService$RespGetConfig.result.get() != 0) {
                    i3 = -2;
                } else {
                    i3 = -1;
                }
                e16.onReqFailed(i3);
                f202249m++;
            }
        }
        this.f202250d.d(getAppRuntime(), configurationService$RespGetConfig, intent, iArr, z16);
        C = true;
        return true;
    }

    private void c(ArrayList<QConReqExtraInfo> arrayList, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, List<Integer> list3) {
        String str;
        Iterator<QConReqExtraInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            QConReqExtraInfo next = it.next();
            if (!am.s().Q(next.f202243d)) {
                list2.add(Integer.valueOf(next.f202243d));
            } else {
                ConfigurationService$ConfigSeq configurationService$ConfigSeq = new ConfigurationService$ConfigSeq();
                configurationService$ConfigSeq.type.set(next.f202243d);
                try {
                    l e16 = am.s().e(next.f202243d);
                    if (e16 != null) {
                        int onSend = e16.onSend(am.s().g(next.f202243d, f202246f));
                        boolean D2 = am.s().D(getAppRuntime(), next.f202243d);
                        if (D2 || next.f202244e) {
                            am.s().P(next.f202243d, 0);
                            onSend = 0;
                        }
                        if (QLog.isColorLevel()) {
                            String str2 = f202245e;
                            Object[] objArr = new Object[5];
                            objArr[0] = "new config send, type=";
                            objArr[1] = Integer.valueOf(next.f202243d);
                            objArr[2] = ", version=";
                            objArr[3] = Integer.valueOf(onSend);
                            if (D2) {
                                str = ", ResetVersion!";
                            } else {
                                str = "";
                            }
                            objArr[4] = str;
                            QLog.d(str2, 2, objArr);
                        }
                        configurationService$ConfigSeq.version.set(onSend);
                        if (e16.isNeedCompressed()) {
                            configurationService$ConfigSeq.compress.set(1);
                        }
                        ConfigurationService$TabRule configurationService$TabRule = new ConfigurationService$TabRule();
                        configurationService$TabRule.experiment_id.set(e16.tabExperimentId());
                        configurationService$TabRule.group_id.set(e16.tabGroupId());
                        configurationService$ConfigSeq.tab_rule.set(configurationService$TabRule);
                        list.add(configurationService$ConfigSeq);
                        list3.add(Integer.valueOf(next.f202243d));
                    }
                } catch (Exception e17) {
                    QLog.d("QConfigManager", 1, "exception " + next.f202243d, e17);
                }
            }
        }
    }

    private void d(ConfigurationService$RespGetConfig configurationService$RespGetConfig, List<Integer> list, int i3) {
        byte[] bArr;
        List<Integer> list2 = configurationService$RespGetConfig.next_req_types.get();
        if (list2 != null && list2.size() != 0) {
            int size = list2.size();
            int[] iArr = new int[size];
            int size2 = list2.size();
            for (int i16 = 0; i16 < size2; i16++) {
                int intValue = list2.get(i16).intValue();
                iArr[i16] = intValue;
                if (list.size() > 0) {
                    list.remove(Integer.valueOf(intValue));
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive page req, next config type: ");
            for (int i17 = 0; i17 < size; i17++) {
                sb5.append(iArr[i17]);
                sb5.append(",");
            }
            QLog.d(f202245e, 1, sb5.toString());
            if (configurationService$RespGetConfig.cookies.has()) {
                bArr = configurationService$RespGetConfig.cookies.get().toByteArray();
            } else {
                bArr = null;
            }
            am.n(iArr, f202246f, bArr, i3 + 1);
            H = true;
            return;
        }
        QLog.d(f202245e, 2, "onReceive page req, no data for next req");
    }

    private void e(List<Integer> list) {
        StringBuilder sb5 = new StringBuilder("QConfigServlet no receive, len=" + list.size() + ", type: ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (QLog.isColorLevel()) {
                sb5.append(intValue);
                sb5.append(",");
            }
            if (am.s().Q(intValue)) {
                am.s().E(intValue, f202246f);
                F++;
            }
        }
        if (QLog.isColorLevel() && list.size() > 0) {
            QLog.w(f202245e, 2, sb5.toString());
        }
        this.f202250d.e(getAppRuntime(), list);
        G = true;
    }

    private void f(Intent intent, ConfigurationService$ReqGetConfig configurationService$ReqGetConfig, List<ConfigurationService$ConfigSeq> list, List<Integer> list2, List<Integer> list3) {
        int[] iArr = new int[list2.size()];
        for (int i3 = 0; i3 < list2.size(); i3++) {
            iArr[i3] = list2.get(i3).intValue();
        }
        this.f202250d.f(getAppRuntime(), intent, configurationService$ReqGetConfig, iArr, list, list3, f202246f);
        if (QLog.isColorLevel() && list2.size() > 0) {
            StringBuilder sb5 = new StringBuilder("old config send, len=" + list2.size() + ", type:");
            Iterator<Integer> it = list2.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(",");
            }
            QLog.d(f202245e, 2, sb5.toString());
        }
    }

    private void g(Intent intent, ConfigurationService$RespGetConfig configurationService$RespGetConfig, int[] iArr, List<Integer> list) {
        l e16;
        int size;
        int size2 = configurationService$RespGetConfig.config_list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ConfigurationService$Config configurationService$Config = configurationService$RespGetConfig.config_list.get(i3);
            if (configurationService$Config != null && configurationService$Config.type.has()) {
                int i16 = configurationService$Config.type.get();
                if (am.s().Q(i16)) {
                    list.remove(Integer.valueOf(i16));
                    int i17 = configurationService$Config.version.get();
                    if (QLog.isColorLevel() && (e16 = am.s().e(i16)) != null) {
                        String str = f202245e;
                        Object[] objArr = new Object[8];
                        objArr[0] = "onReceive, type=";
                        objArr[1] = Integer.valueOf(i16);
                        objArr[2] = ", oldVersion=";
                        objArr[3] = Integer.valueOf(am.s().g(i16, f202246f));
                        objArr[4] = ", newVersion=";
                        objArr[5] = Integer.valueOf(i17);
                        objArr[6] = ", contentSize=";
                        if (e16.isNeedCompressed()) {
                            size = configurationService$Config.msg_content_list.size();
                        } else {
                            size = configurationService$Config.content_list.size();
                        }
                        objArr[7] = Integer.valueOf(size);
                        QLog.d(str, 2, objArr);
                    }
                    am.s().N(i16, i17, configurationService$Config, f202246f);
                    D++;
                }
            }
        }
        this.f202250d.g(getAppRuntime(), configurationService$RespGetConfig, list, intent, iArr, true);
        E = true;
    }

    private void j(HandlerThread handlerThread) {
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
    }

    public ConfigurationService$RespGetConfig a() {
        return new ConfigurationService$RespGetConfig();
    }

    @QAutoInitMethod
    void h() {
        this.f202250d = (k) com.tencent.mobileqq.qroute.utils.b.a(I);
    }

    protected synchronized void i(Intent intent, int[] iArr, FromServiceMsg fromServiceMsg, HandlerThread handlerThread) {
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.d(f202245e, 2, "realOnReceive, request: ", intent);
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length >= 4) {
            fromServiceMsg.putWupBuffer(aj.h(wupBuffer));
            ConfigurationService$RespGetConfig a16 = a();
            try {
                a16.mergeFrom(fromServiceMsg.getWupBuffer());
                if (QLog.isColorLevel()) {
                    QLog.d(f202245e, 2, "onReceive config list size: ", Integer.valueOf(a16.config_list.size()));
                }
                if (a16.cookies_new.has()) {
                    bArr = a16.cookies_new.get().toByteArray();
                } else {
                    bArr = null;
                }
                if (bArr != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f202245e, 2, "write cookie_new, cookie_new != null");
                    }
                    am.s().U(f202246f, bArr);
                }
                this.f202250d.h(a16);
                f202248i = true;
                try {
                    try {
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(f202245e, 2, e16.toString());
                        }
                    }
                    if (b(intent, a16, iArr, fromServiceMsg.isSuccess())) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList(iArr.length);
                    for (int i3 : iArr) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                    g(intent, a16, iArr, arrayList);
                    if (QLog.isColorLevel()) {
                        QLog.w(f202245e, 2, "onReceive execute spend time: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    if (intent.getBooleanExtra("key_is_all_config", false)) {
                        int intExtra = intent.getIntExtra("key_page_req_count", 0);
                        QLog.d(f202245e, 2, "onReceive check for all config page req, pageReqCount=", Integer.valueOf(intExtra));
                        if (intExtra < 3) {
                            d(a16, arrayList, intExtra);
                        }
                    }
                    e(arrayList);
                    return;
                } finally {
                    j(handlerThread);
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f202245e, 2, "error: " + e17);
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f202245e, 2, "wup buf is null!!!");
        }
        this.f202250d.b(iArr, fromServiceMsg);
        f202247h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        super.onCreate();
        h();
        QLog.d(f202245e, 1, "initQAutoInject, ", this.f202250d.getClass().getSimpleName());
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(final Intent intent, final FromServiceMsg fromServiceMsg) {
        ArrayList parcelableArrayListExtra;
        if (intent == null) {
            parcelableArrayListExtra = null;
        } else {
            parcelableArrayListExtra = intent.getParcelableArrayListExtra("k_cmd_type");
        }
        final int[] j3 = aj.j(parcelableArrayListExtra);
        if (j3 != null && j3.length > 0) {
            if (j3.length < 5) {
                i(intent, j3, fromServiceMsg, null);
            } else {
                ThreadManagerV2.newHandlerRecycleThread("QConfigServlet", -2).b().post(new Runnable() { // from class: com.tencent.mobileqq.config.QConfigServlet.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QConfigServlet.this.i(intent, j3, fromServiceMsg, null);
                    }
                });
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ArrayList<QConReqExtraInfo> parcelableArrayListExtra = intent.getParcelableArrayListExtra("k_cmd_type");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            ConfigurationService$ReqGetConfig configurationService$ReqGetConfig = new ConfigurationService$ReqGetConfig();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            c(parcelableArrayListExtra, arrayList, arrayList2, arrayList3);
            f(intent, configurationService$ReqGetConfig, arrayList, arrayList2, arrayList3);
            if (QLog.isColorLevel()) {
                QLog.d(f202245e, 2, "request send len:", Integer.valueOf(parcelableArrayListExtra.size()), ", real send len:", Integer.valueOf(arrayList3.size()));
                if (arrayList3.size() != parcelableArrayListExtra.size()) {
                    StringBuilder sb5 = new StringBuilder("request but not send: ");
                    Iterator<QConReqExtraInfo> it = parcelableArrayListExtra.iterator();
                    while (it.hasNext()) {
                        QConReqExtraInfo next = it.next();
                        if (!arrayList3.contains(Integer.valueOf(next.f202243d))) {
                            sb5.append(next.f202243d);
                            sb5.append(" ");
                        }
                    }
                    QLog.d(f202245e, 2, sb5.toString());
                }
            }
            configurationService$ReqGetConfig.setHasFlag(true);
            configurationService$ReqGetConfig.seq_list.addAll(arrayList);
            configurationService$ReqGetConfig.is_page_req.set(intent.getBooleanExtra("key_is_page_req", false) ? 1 : 0);
            byte[] byteArrayExtra = intent.getByteArrayExtra("key_cookies");
            if (byteArrayExtra != null) {
                configurationService$ReqGetConfig.cookies.set(ByteStringMicro.copyFrom(byteArrayExtra));
            }
            configurationService$ReqGetConfig.version.set(1);
            byte[] L = am.s().L(f202246f);
            if (L != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f202245e, 2, "read cookie_new, cookie_new != null");
                }
                configurationService$ReqGetConfig.cookies_new.set(ByteStringMicro.copyFrom(L));
            }
            byte[] g16 = aj.g(configurationService$ReqGetConfig);
            if (g16.length > 0) {
                packet.putSendData(g16);
            }
            if (this.f202250d.a(getAppRuntime(), aj.j(parcelableArrayListExtra))) {
                packet.setSSOCommand("ConfigurationService.ReqGetConfigNoLogin");
                intent.putExtra("k_cmd_name", "ConfigurationService.ReqGetConfigNoLogin");
            } else {
                packet.setSSOCommand(BaseConstants.CMD_REQUEST_CONFIG);
            }
        }
    }
}
