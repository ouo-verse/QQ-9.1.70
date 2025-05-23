package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NumRedMsgHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89$NumRedBusiInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class NumRedMsgManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f280225d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f280226e;

    /* renamed from: f, reason: collision with root package name */
    protected NumRedMsgHandler f280227f;

    /* renamed from: h, reason: collision with root package name */
    protected ConcurrentHashMap<Integer, NumRedGetMsgCallback> f280228h;

    /* renamed from: i, reason: collision with root package name */
    protected NumRedMsg.NumMsgRspBody f280229i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.redtouch.NumRedMsgManager$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f280230d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ NumRedGetMsgCallback f280231e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f280232f;
        final /* synthetic */ NumRedMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            List list;
            NumRedGetMsgCallback numRedGetMsgCallback;
            List<NumRedMsg.NumMsgBusi> list2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!this.this$0.f280225d && (list = this.f280230d) != null) {
                boolean z17 = true;
                if (list.size() >= 1 && (numRedGetMsgCallback = this.f280231e) != null) {
                    ConcurrentHashMap<Integer, NumRedGetMsgCallback> concurrentHashMap = this.this$0.f280228h;
                    if (concurrentHashMap != null && !concurrentHashMap.containsKey(Integer.valueOf(numRedGetMsgCallback.key))) {
                        this.this$0.f280228h.put(Integer.valueOf(this.f280231e.key), this.f280231e);
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    NumRedMsg.NumMsgRspBody b16 = this.this$0.b();
                    if (b16 != null && (list2 = b16.rpt_num_red.get()) != null) {
                        for (int i3 = 0; i3 < this.f280230d.size(); i3++) {
                            int i16 = 0;
                            while (true) {
                                if (i16 < list2.size()) {
                                    if (list2.get(i16).ui64_msgid.get() == ((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i3)).uint32_app_id.get()) {
                                        arrayList.add(list2.get(i16));
                                        z16 = true;
                                        break;
                                    }
                                    i16++;
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (!z16) {
                                NumRedMsg.NumMsgBusi numMsgBusi = new NumRedMsg.NumMsgBusi();
                                numMsgBusi.ui64_msgid.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i3)).uint64_msgid.get());
                                numMsgBusi.ui_appid.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i3)).uint32_android_app_id.get());
                                numMsgBusi.str_path.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i3)).str_android_path.get());
                                arrayList2.add(numMsgBusi);
                            }
                        }
                        z17 = false;
                    }
                    if (z17) {
                        for (int i17 = 0; i17 < this.f280230d.size(); i17++) {
                            NumRedMsg.NumMsgBusi numMsgBusi2 = new NumRedMsg.NumMsgBusi();
                            numMsgBusi2.ui64_msgid.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i17)).uint64_msgid.get());
                            numMsgBusi2.ui_appid.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i17)).uint32_android_app_id.get());
                            numMsgBusi2.str_path.set(((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i17)).str_android_path.get());
                            arrayList2.add(numMsgBusi2);
                        }
                    }
                    if (arrayList.size() == this.f280230d.size()) {
                        this.f280231e.updateNumMsg(this.f280232f, arrayList);
                        return;
                    }
                    long[] jArr = new long[this.f280230d.size()];
                    for (int i18 = 0; i18 < this.f280230d.size(); i18++) {
                        jArr[i18] = ((Submsgtype0x89$NumRedBusiInfo) this.f280230d.get(i18)).uint64_msgid.get();
                    }
                    this.this$0.f280227f.E2(arrayList2, this.f280231e.key, this.f280232f, jArr);
                }
            }
        }
    }

    public NumRedMsgManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f280225d = false;
        this.f280228h = new ConcurrentHashMap<>();
        this.f280226e = qQAppInterface;
        this.f280227f = (NumRedMsgHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NUMREDMSG_HANDLER);
    }

    private void c(long[] jArr, NumRedGetMsgCallback numRedGetMsgCallback, String str, boolean z16) {
        ThreadManagerV2.post(new Runnable(jArr, numRedGetMsgCallback, z16, str) { // from class: com.tencent.mobileqq.redtouch.NumRedMsgManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long[] f280233d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ NumRedGetMsgCallback f280234e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f280235f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f280236h;

            {
                this.f280233d = jArr;
                this.f280234e = numRedGetMsgCallback;
                this.f280235f = z16;
                this.f280236h = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NumRedMsgManager.this, jArr, numRedGetMsgCallback, Boolean.valueOf(z16), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                NumRedGetMsgCallback numRedGetMsgCallback2;
                List<NumRedMsg.NumMsgBusi> list;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!NumRedMsgManager.this.f280225d) {
                    boolean z18 = true;
                    if (this.f280233d.length >= 1 && (numRedGetMsgCallback2 = this.f280234e) != null) {
                        if (!NumRedMsgManager.this.f280228h.containsKey(Integer.valueOf(numRedGetMsgCallback2.key))) {
                            NumRedMsgManager.this.f280228h.put(Integer.valueOf(this.f280234e.key), this.f280234e);
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        NumRedMsg.NumMsgRspBody b16 = NumRedMsgManager.this.b();
                        if (b16 != null && (list = b16.rpt_num_red.get()) != null) {
                            for (int i3 = 0; i3 < this.f280233d.length; i3++) {
                                int i16 = 0;
                                while (true) {
                                    if (i16 < list.size()) {
                                        if (list.get(i16).ui64_msgid.get() == this.f280233d[i3]) {
                                            arrayList.add(list.get(i16));
                                            z17 = true;
                                            break;
                                        }
                                        i16++;
                                    } else {
                                        z17 = false;
                                        break;
                                    }
                                }
                                if (!z17) {
                                    NumRedMsg.NumMsgBusi numMsgBusi = new NumRedMsg.NumMsgBusi();
                                    numMsgBusi.ui64_msgid.set(this.f280233d[i3]);
                                    arrayList2.add(numMsgBusi);
                                }
                            }
                            z18 = false;
                        }
                        if (z18) {
                            for (int i17 = 0; i17 < this.f280233d.length; i17++) {
                                NumRedMsg.NumMsgBusi numMsgBusi2 = new NumRedMsg.NumMsgBusi();
                                numMsgBusi2.ui64_msgid.set(this.f280233d[i17]);
                                arrayList2.add(numMsgBusi2);
                            }
                        }
                        int size = arrayList.size();
                        long[] jArr2 = this.f280233d;
                        if (size != jArr2.length && !this.f280235f) {
                            NumRedMsgManager.this.f280227f.E2(arrayList2, this.f280234e.key, this.f280236h, jArr2);
                        } else {
                            this.f280234e.updateNumMsg(this.f280236h, arrayList);
                        }
                    }
                }
            }
        }, 5, null, false);
    }

    private boolean f() {
        return new File(this.f280226e.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.f280226e.getCurrentAccountUin()).exists();
    }

    private void g(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("NumRedMsgManager", 2, str);
        }
    }

    private boolean h(NumRedMsg.NumMsgRspBody numMsgRspBody) {
        boolean pushData2File = FileUtils.pushData2File(new File(this.f280226e.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.f280226e.getCurrentAccountUin()).getAbsolutePath(), numMsgRspBody.toByteArray(), false);
        if (pushData2File) {
            i(numMsgRspBody);
        }
        return pushData2File;
    }

    private void i(NumRedMsg.NumMsgRspBody numMsgRspBody) {
        this.f280229i = numMsgRspBody;
    }

    private void j(NumRedMsg.NumMsgRspBody numMsgRspBody) {
        if (numMsgRspBody == null) {
            return;
        }
        NumRedMsg.NumMsgRspBody b16 = b();
        if (b16 == null) {
            h(numMsgRspBody);
            return;
        }
        List<NumRedMsg.NumMsgBusi> list = b16.rpt_num_red.get();
        if (list == null) {
            h(numMsgRspBody);
            return;
        }
        List<NumRedMsg.NumMsgBusi> list2 = numMsgRspBody.rpt_num_red.get();
        if (list2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list2.size(); i3++) {
            boolean z16 = false;
            for (int i16 = 0; i16 < list.size(); i16++) {
                if (list.get(i16).ui64_msgid.get() == list2.get(i3).ui64_msgid.get()) {
                    list.get(i16).str_content.set(list2.get(i3).str_content.get());
                    list.get(i16).str_ext.set(list2.get(i3).str_ext.get());
                    list.get(i16).str_missionid.set(list2.get(i3).str_missionid.get());
                    list.get(i16).str_path.set(list2.get(i3).str_path.get());
                    list.get(i16).str_url.set(list2.get(i3).str_url.get());
                    list.get(i16).ui_appid.set(list2.get(i3).ui_appid.get());
                    list.get(i16).ui_expire_time.set(list2.get(i3).ui_expire_time.get());
                    list.get(i16).str_ret.set(list2.get(i3).str_ret.get());
                    z16 = true;
                }
            }
            if (!z16) {
                arrayList.add(list2.get(i3));
            }
        }
        list.addAll(arrayList);
        h(b16);
    }

    public NumRedMsg.NumMsgRspBody b() {
        byte[] fileToBytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NumRedMsg.NumMsgRspBody) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        NumRedMsg.NumMsgRspBody numMsgRspBody = this.f280229i;
        if (numMsgRspBody != null) {
            return numMsgRspBody;
        }
        NumRedMsg.NumMsgRspBody numMsgRspBody2 = new NumRedMsg.NumMsgRspBody();
        File file = new File(this.f280226e.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.f280226e.getCurrentAccountUin());
        if (!file.exists()) {
            g("numredmsg pb file does not exist");
            try {
                file.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        synchronized (this) {
            fileToBytes = FileUtils.fileToBytes(file);
        }
        if (fileToBytes == null) {
            g("Can not translate numredmsg pb file to byte");
            return null;
        }
        try {
            numMsgRspBody2.mergeFrom(fileToBytes);
            i(numMsgRspBody2);
            return numMsgRspBody2;
        } catch (Exception e17) {
            e17.printStackTrace();
            g("merge numredmsg file to rspbody fail");
            return null;
        }
    }

    public void d(long[] jArr, String str, NumRedGetMsgCallback numRedGetMsgCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, jArr, str, numRedGetMsgCallback);
        } else {
            c(jArr, numRedGetMsgCallback, str, false);
        }
    }

    public void e(NumRedMsg.NumMsgRspBody numMsgRspBody, ToServiceMsg toServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, numMsgRspBody, toServiceMsg, Boolean.valueOf(z16));
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("NumMsgListenerKey");
        long[] longArray = toServiceMsg.extraData.getLongArray("NumMsgIDList");
        String string = toServiceMsg.extraData.getString("NumMsgListenerCmd");
        if (z16) {
            if (numMsgRspBody == null) {
                return;
            }
            if (!f()) {
                h(numMsgRspBody);
            } else {
                j(numMsgRspBody);
            }
        }
        NumRedGetMsgCallback numRedGetMsgCallback = this.f280228h.get(Integer.valueOf(i3));
        if (numRedGetMsgCallback != null) {
            c(longArray, numRedGetMsgCallback, string, true);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f280225d = true;
            this.f280228h.clear();
        }
    }
}
