package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xc13.oidb_0xc13$EncryptUinResult;
import tencent.im.oidb.cmd0xc13.oidb_0xc13$EncryptUinRspBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13$ReqBody;
import tencent.im.oidb.cmd0xc13.oidb_0xc13$RspBody;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EncryptUinHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private b f78802d;

    /* renamed from: e, reason: collision with root package name */
    private String f78803e;

    /* renamed from: f, reason: collision with root package name */
    private c f78804f;

    /* renamed from: h, reason: collision with root package name */
    private AppInterface f78805h;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.EncryptUinHandler$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f78806d;
        final /* synthetic */ EncryptUinHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.K2(this.f78806d, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.EncryptUinHandler.b
        protected void a(boolean z16, List<EncryptUinInfo> list, Bundle bundle) {
            if (z16 && list != null && !list.isEmpty()) {
                EncryptUinInfo encryptUinInfo = list.get(0);
                if (encryptUinInfo.f78809e == 0 && encryptUinInfo.f78808d == EncryptUinHandler.this.f78805h.getLongAccountUin() && !TextUtils.isEmpty(encryptUinInfo.f78810f)) {
                    EncryptUinHandler.this.f78803e = encryptUinInfo.f78810f;
                    if (QLog.isColorLevel()) {
                        QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: " + EncryptUinHandler.this.f78803e);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: failed\uff0ccode=" + encryptUinInfo.f78809e);
                }
                if (EncryptUinHandler.this.f78804f != null) {
                    EncryptUinHandler.this.f78804f.callback(EncryptUinHandler.this.f78803e);
                }
            }
        }

        @Override // com.tencent.biz.pubaccount.EncryptUinHandler.b, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 == 1) {
                super.onUpdate(i3, z16, obj);
                EncryptUinHandler.this.f78805h.removeObserver(EncryptUinHandler.this.f78802d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static abstract class b implements BusinessObserver {
        protected abstract void a(boolean z16, List<EncryptUinInfo> list, Bundle bundle);

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (obj != null) {
                try {
                    Bundle bundle = (Bundle) obj;
                    a(z16, bundle.getParcelableArrayList("KEY_ENCRYPT_RESULT_LIST"), bundle);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            a(false, null, new Bundle());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void callback(String str);
    }

    public EncryptUinHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f78805h = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(List<Long> list, int i3) {
        oidb_0xc13$ReqBody oidb_0xc13_reqbody = new oidb_0xc13$ReqBody();
        oidb_0xc13_reqbody.msg_encrypt_uin_req_body.rpt_uint64_uin.set(list);
        oidb_0xc13_reqbody.msg_encrypt_uin_req_body.setHasFlag(true);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xc13", 3091, 1, oidb_0xc13_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("ARGS_TYPE", Integer.valueOf(i3));
        sendPbReq(makeOIDBPkg);
    }

    public String J2() {
        if (TextUtils.isEmpty(this.f78803e)) {
            L2();
        }
        return this.f78803e;
    }

    public void L2() {
        if (TextUtils.isEmpty(this.f78803e) && this.f78802d == null) {
            a aVar = new a();
            this.f78802d = aVar;
            this.f78805h.addObserver(aVar);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.EncryptUinHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(EncryptUinHandler.this.f78805h.getLongAccountUin()));
                    EncryptUinHandler.this.K2(arrayList, 1);
                }
            }, 128, null, true);
        }
    }

    public void M2(c cVar) {
        this.f78804f = cVar;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        this.f78805h.removeObserver(this.f78802d);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ArrayList<? extends Parcelable> arrayList;
        List<oidb_0xc13$EncryptUinResult> list;
        oidb_0xc13$RspBody oidb_0xc13_rspbody = new oidb_0xc13$RspBody();
        Bundle bundle = new Bundle();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xc13_rspbody);
        int i3 = 0;
        if (parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EncryptUinHandler", 2, "onReceive: isSuccess=" + z16 + ", code=" + parseOIDBPkg);
        }
        if (z16) {
            oidb_0xc13$EncryptUinRspBody oidb_0xc13_encryptuinrspbody = oidb_0xc13_rspbody.msg_encrypt_uin_rsp_body.get();
            if (oidb_0xc13_encryptuinrspbody != null && (list = oidb_0xc13_encryptuinrspbody.rpt_msg_encrypt_result.get()) != null && !list.isEmpty()) {
                arrayList = new ArrayList<>();
                for (oidb_0xc13$EncryptUinResult oidb_0xc13_encryptuinresult : list) {
                    EncryptUinInfo encryptUinInfo = new EncryptUinInfo();
                    encryptUinInfo.f78808d = oidb_0xc13_encryptuinresult.uint64_original_uin.get();
                    encryptUinInfo.f78809e = oidb_0xc13_encryptuinresult.int32_result.get();
                    if (oidb_0xc13_encryptuinresult.bytes_encrypt_uin.get() != null) {
                        encryptUinInfo.f78810f = oidb_0xc13_encryptuinresult.bytes_encrypt_uin.get().toStringUtf8();
                    }
                    arrayList.add(encryptUinInfo);
                }
            } else {
                arrayList = null;
            }
            bundle.putParcelableArrayList("KEY_ENCRYPT_RESULT_LIST", arrayList);
        }
        Object attribute = toServiceMsg.getAttribute("ARGS_TYPE");
        if (attribute != null) {
            i3 = ((Integer) attribute).intValue();
        }
        notifyUI(i3, z16, bundle);
    }

    public EncryptUinHandler(AppInterface appInterface) {
        super(appInterface);
        this.f78805h = appInterface;
    }
}
