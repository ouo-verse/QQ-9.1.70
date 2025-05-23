package com.tencent.mobileqq.comment;

import android.os.Bundle;
import com.tencent.mobileqq.comment.b;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends QIPCModule implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static volatile c f201760e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f201761f;

    /* renamed from: d, reason: collision with root package name */
    private List<b> f201762d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
            } else {
                QLog.d("DanmuDataIPCClient", 1, "get barrage list, IPC success, msgSeq:", Long.valueOf(eIPCResult.data.getLong("key_barrage_msg_seq")));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void d(long j3, String str, DanmuItemBean danmuItemBean);

        void f(long j3, String str, int i3, List<DanmuItemBean> list);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.comment.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC7462c {
        void onDanmuPullResult(com.tencent.mobileqq.comment.a aVar, boolean z16, boolean z17, int i3, ArrayList<DanmuItemBean> arrayList, List<Long> list);
    }

    c() {
        super("DanmuDataIPCClient");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f201762d = new ArrayList();
        }
    }

    public static c c() {
        if (f201760e == null) {
            synchronized (c.class) {
                if (f201760e == null) {
                    f201760e = new c();
                }
            }
        }
        return f201760e;
    }

    public static void registerModule() {
        c c16 = c();
        if (!f201761f) {
            QIPCClientHelper.getInstance().register(c16);
            f201761f = true;
            QLog.d("DanmuDataIPCClient", 1, "registerModule");
        }
    }

    @Override // com.tencent.mobileqq.comment.f
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.mobileqq.comment.b.f().a();
            callServer("qipc_action_clear_cache", new Bundle());
        }
    }

    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else if (bVar != null && !this.f201762d.contains(bVar)) {
            this.f201762d.add(bVar);
        }
    }

    public Bundle callServer(String str, Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bundle) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bundle);
        }
        if ("qipc_action_get_barrage".equals(str)) {
            long j3 = bundle.getLong("key_barrage_msg_seq");
            long j16 = bundle.getLong("key_barrage_grp_uin");
            int i3 = bundle.getInt("key_barrage_topic_type");
            b.a c16 = com.tencent.mobileqq.comment.b.f().c(com.tencent.mobileqq.comment.b.f().d(j16, j3));
            if (c16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("DanmuDataIPCClient", 2, "get barrage list, msgSeq:", Long.valueOf(j3), " groupUin:", Long.valueOf(j16), " topicType:", Integer.valueOf(i3), " peakCached:", Boolean.valueOf(z16));
            if (z16) {
                QLog.d("DanmuDataIPCClient", 2, "peak listSize:", Integer.valueOf(c16.f201754i.size()), ", fullList:", c16.f201754i.toString());
            }
            bundle.putBoolean("key_barrage_is_update", z16);
            bundle.putLong("key_barrage_req_time", System.currentTimeMillis());
            QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_get_barrage", bundle, new a());
        }
        if ("qipc_action_clear_cache".equals(str)) {
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "DanmuDataIPCServer", "qipc_action_clear_cache", null);
        }
        return null;
    }

    public void d(Bundle bundle) {
        boolean z16;
        boolean z17;
        String str;
        b.a aVar;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        bundle.setClassLoader(DanmuItemBean.class.getClassLoader());
        long j3 = bundle.getLong("key_barrage_msg_seq");
        long j16 = bundle.getLong("key_barrage_grp_uin");
        int i17 = bundle.getInt("key_barrage_topic_type");
        boolean z18 = bundle.getBoolean("key_barrage_is_success");
        int i18 = bundle.getInt("key_barrage_interval_time");
        if (QLog.isColorLevel()) {
            QLog.d("DanmuDataIPCClient", 2, "handleGetBarrageEIPCResult, topicSeq:", Long.valueOf(j3), " groupUin:", Long.valueOf(j16), " topicType:", Integer.valueOf(i17), " isSuccess:", Boolean.valueOf(z18));
        }
        if (bundle.containsKey("key_barrage_req_time")) {
            long j17 = bundle.getLong("key_barrage_req_time");
            long j18 = bundle.getLong("key_barrage_net_req_time");
            long j19 = bundle.getLong("key_barrage_net_response_time");
            long j26 = j18 - j17;
            long j27 = j19 - j18;
            long currentTimeMillis = System.currentTimeMillis() - j19;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ipcReqCost", String.valueOf(j26));
            hashMap.put("netReqCost", String.valueOf(j27));
            hashMap.put("ipcRspCost", String.valueOf(currentTimeMillis));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "DanmuPullCost", false, 0L, 0L, hashMap, null);
            if (QLog.isColorLevel()) {
                QLog.d("DanmuDataIPCClient", 2, "handleGetBarrageEIPCResult, ipcReqCost:", Long.valueOf(j26), " netReqCost:", Long.valueOf(j27), " ipcRspCost:", Long.valueOf(currentTimeMillis));
            }
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("key_barrage_danmu_list");
        long[] longArray = bundle.getLongArray("key_barrage_del_seq_list");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (longArray != null && longArray.length > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        String d16 = com.tencent.mobileqq.comment.b.f().d(j16, j3);
        b.a c16 = com.tencent.mobileqq.comment.b.f().c(d16);
        if (c16 == null) {
            c16 = com.tencent.mobileqq.comment.b.f().b(d16);
        }
        if (!z18 || (!z16 && !z17)) {
            str = "DanmuDataIPCClient";
            aVar = c16;
        } else {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "handleGetBarrageEIPCResult, danmuItemList size:";
                if (parcelableArrayList != null) {
                    i3 = parcelableArrayList.size();
                } else {
                    i3 = 0;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = " delSeqArr size:";
                if (longArray != null) {
                    i16 = longArray.length;
                } else {
                    i16 = 0;
                }
                objArr[3] = Integer.valueOf(i16);
                QLog.d("DanmuDataIPCClient", 2, objArr);
            }
            ArrayList arrayList = new ArrayList(longArray.length);
            for (long j28 : longArray) {
                arrayList.add(Long.valueOf(j28));
            }
            str = "DanmuDataIPCClient";
            aVar = c16;
            aVar.d(parcelableArrayList).j(arrayList).c(new com.tencent.mobileqq.comment.a(j16, j3, i17, true)).e(null).n();
        }
        if (z18 && aVar != null && !aVar.f201754i.isEmpty()) {
            Iterator<b> it = this.f201762d.iterator();
            while (it.hasNext()) {
                it.next().f(j3, String.valueOf(j16), i18, aVar.f201754i);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "handleGetBarrageEIPCResult end");
        }
    }

    public void e(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else if (bVar != null && this.f201762d.contains(bVar)) {
            this.f201762d.remove(bVar);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 6, this, str, bundle, Integer.valueOf(i3));
        }
        if ("qipc_action_get_barrage_result".equals(str)) {
            d(bundle);
            return null;
        }
        if ("qipc_action_send_barrage".equals(str)) {
            bundle.setClassLoader(DanmuItemBean.class.getClassLoader());
            DanmuItemBean danmuItemBean = (DanmuItemBean) bundle.getParcelable("key_barrage_danmu_msg");
            long j3 = bundle.getLong("key_barrage_msg_seq");
            String string = bundle.getString("key_barrage_grp_uin");
            Iterator<b> it = this.f201762d.iterator();
            while (it.hasNext()) {
                it.next().d(j3, string, danmuItemBean);
            }
            return null;
        }
        return null;
    }
}
