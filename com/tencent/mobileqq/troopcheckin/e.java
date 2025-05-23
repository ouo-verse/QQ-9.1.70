package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo$PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo$PttShortVideoUploadResp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected String f302721h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f302722i;

    /* renamed from: j, reason: collision with root package name */
    protected Transaction f302723j;

    /* renamed from: k, reason: collision with root package name */
    private ITransactionCallback f302724k;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ITransactionCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), bArr, hashMap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(e.this.f302714b, 2, "upload onFailed errn:" + i3);
            }
            e.this.f();
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) hashMap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(e.this.f302714b, 2, "upload onSuccess");
            }
            try {
                PttShortVideo$PttShortVideoUploadResp mergeFrom = new PttShortVideo$PttShortVideoUploadResp().mergeFrom(bArr);
                if (mergeFrom.str_fileid.has()) {
                    e.this.f302721h = mergeFrom.str_fileid.get();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            e eVar = e.this;
            eVar.f302722i = true;
            eVar.b();
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }
    }

    public e(com.tencent.mobileqq.troopcheckin.a aVar, int i3) {
        super(aVar, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
        } else {
            this.f302722i = false;
            this.f302724k = new a();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.troopcheckin.a aVar = this.f302713a;
        String str = aVar.f302709b;
        String str2 = aVar.f302708a;
        boolean g16 = g(str);
        if (g16) {
            z16 = h(str2);
        } else {
            z16 = false;
        }
        if (!g16 || !z16) {
            f();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f302717e && this.f302722i) {
            e();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Transaction transaction = this.f302718f;
        if (transaction != null) {
            transaction.cancelTransaction();
        }
        Transaction transaction2 = this.f302723j;
        if (transaction2 != null) {
            transaction2.cancelTransaction();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        boolean z16 = true;
        bundle.putInt(BaseProfileQZoneComponent.KEY_IS_VIDEO, 1);
        if (this.f302716d != null && this.f302721h != null) {
            bundle.putInt("result", 1);
            bundle.putString("url", this.f302716d);
            bundle.putString("vid", this.f302721h);
        } else {
            z16 = false;
            bundle.putInt("result", 0);
            bundle.putString("error", "");
        }
        b.c().d(z16, this.f302715c, bundle);
    }

    protected boolean h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f302714b, 2, "uploadVideo path= " + str);
        }
        ITransactionCallback iTransactionCallback = this.f302724k;
        QQAppInterface d16 = d();
        if (d16 != null) {
            String currentUin = d16.getCurrentUin();
            byte[] k3 = v81.a.k(str);
            File file = new File(str);
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f302714b, 2, "uploadVideo md5 null ");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f302714b, 1, "uploadVideo,file length " + new File(str).length());
            }
            PttShortVideo$PttShortVideoUploadReq pttShortVideo$PttShortVideoUploadReq = new PttShortVideo$PttShortVideoUploadReq();
            pttShortVideo$PttShortVideoUploadReq.setHasFlag(true);
            pttShortVideo$PttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(currentUin));
            pttShortVideo$PttShortVideoUploadReq.uint64_touin.set(Long.parseLong(currentUin));
            pttShortVideo$PttShortVideoUploadReq.uint32_chat_type.set(1);
            pttShortVideo$PttShortVideoUploadReq.uint32_client_type.set(1);
            pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(currentUin));
            pttShortVideo$PttShortVideoUploadReq.uint32_agent_type.set(0);
            pttShortVideo$PttShortVideoUploadReq.uint32_business_type.set(3001);
            pttShortVideo$PttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
            PttShortVideo$PttShortVideoFileInfo pttShortVideo$PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
            pttShortVideo$PttShortVideoFileInfo.str_file_name.set(file.getName());
            pttShortVideo$PttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(k3));
            pttShortVideo$PttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(k3));
            pttShortVideo$PttShortVideoFileInfo.uint64_file_size.set(file.length());
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_length.set(0);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_res_width.set(0);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_format.set(3);
            pttShortVideo$PttShortVideoFileInfo.uint32_file_time.set((int) this.f302713a.f302710c);
            pttShortVideo$PttShortVideoFileInfo.uint64_thumb_file_size.set(0L);
            pttShortVideo$PttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(pttShortVideo$PttShortVideoFileInfo);
            Transaction transaction = new Transaction(currentUin, 74, str, 0, k3, iTransactionCallback, pttShortVideo$PttShortVideoUploadReq.toByteArray(), false);
            int submitTransactionTask = d16.getHwEngine().submitTransactionTask(transaction);
            if (submitTransactionTask == 0) {
                this.f302723j = transaction;
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f302714b, 2, "uploadVideo submitTransactionTask  retCode= " + submitTransactionTask);
            }
        }
        return false;
    }
}
