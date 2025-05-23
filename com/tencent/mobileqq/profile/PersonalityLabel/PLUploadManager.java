package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* loaded from: classes16.dex */
public class PLUploadManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f259788d;

    /* renamed from: e, reason: collision with root package name */
    b f259789e;

    /* renamed from: f, reason: collision with root package name */
    MqqHandler f259790f;

    /* renamed from: h, reason: collision with root package name */
    Vector<a> f259791h;

    /* renamed from: i, reason: collision with root package name */
    private TransProcessorHandler f259792i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f259795a;

        /* renamed from: b, reason: collision with root package name */
        long f259796b;

        /* renamed from: c, reason: collision with root package name */
        PersonalityLabelPhoto f259797c;

        /* renamed from: d, reason: collision with root package name */
        TransferRequest f259798d;

        /* renamed from: e, reason: collision with root package name */
        int f259799e;

        /* renamed from: f, reason: collision with root package name */
        int f259800f;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PLUploadManager.this);
            } else {
                this.f259799e = 0;
                this.f259800f = 0;
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b {
        void l2(List<PersonalityLabelPhoto> list, long j3);

        void w0(long j3, a aVar);
    }

    public PLUploadManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f259791h = new Vector<>();
        com.tencent.mobileqq.profile.PersonalityLabel.b bVar = new com.tencent.mobileqq.profile.PersonalityLabel.b(this, Looper.getMainLooper());
        this.f259792i = bVar;
        this.f259788d = qQAppInterface;
        bVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.f259792i);
        this.f259790f = new MqqHandler(Looper.getMainLooper());
        if (QLog.isColorLevel()) {
            QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + qQAppInterface + " handler:" + this.f259792i);
        }
    }

    private a c(CompressInfo compressInfo, long j3, int i3, int i16, int i17) {
        long currentTimeMillis = ((System.currentTimeMillis() / 1000) << 4) | i17;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = compressInfo.D;
        transferRequest.mUniseq = currentTimeMillis;
        transferRequest.mFileType = 56;
        pu.a aVar = new pu.a();
        for (int i18 = 56; i18 >= 0; i18 -= 8) {
            aVar.c((byte) ((j3 >>> i18) & 255));
        }
        aVar.b(i16);
        aVar.b(i17);
        aVar.b(0);
        aVar.b(0);
        aVar.b(i3);
        transferRequest.mExtentionInfo = aVar.a();
        ((ITransFileController) this.f259788d.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        PersonalityLabelPhoto personalityLabelPhoto = new PersonalityLabelPhoto();
        personalityLabelPhoto.localThumbPath = compressInfo.H;
        personalityLabelPhoto.uniseq = currentTimeMillis;
        personalityLabelPhoto.local = true;
        a aVar2 = new a();
        aVar2.f259796b = j3;
        aVar2.f259798d = transferRequest;
        aVar2.f259797c = personalityLabelPhoto;
        if (QLog.isColorLevel()) {
            QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + compressInfo.D + " uniseq:" + currentTimeMillis);
        }
        return aVar2;
    }

    public void a(long j3, PersonalityLabelPhoto personalityLabelPhoto) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), personalityLabelPhoto);
            return;
        }
        while (true) {
            if (i3 < this.f259791h.size()) {
                if (this.f259791h.get(i3).f259796b == j3 && this.f259791h.get(i3).f259797c.uniseq == personalityLabelPhoto.uniseq) {
                    aVar = this.f259791h.remove(i3);
                    break;
                }
                i3++;
            } else {
                aVar = null;
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            while (i3 < this.f259791h.size()) {
                if (this.f259791h.get(i3).f259796b == j3) {
                    this.f259791h.get(i3).f259795a--;
                }
                i3++;
            }
        }
        if (aVar != null) {
            ((ITransFileController) this.f259788d.getRuntimeService(ITransFileController.class)).stop(aVar.f259798d);
            if (QLog.isColorLevel()) {
                QLog.i("PLUploadManager", 2, "delete " + aVar.f259798d.mLocalPath);
            }
        }
    }

    public a b(long j3, PersonalityLabelPhoto personalityLabelPhoto) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), personalityLabelPhoto);
        }
        for (int i3 = 0; i3 < this.f259791h.size(); i3++) {
            if (this.f259791h.get(i3).f259796b == j3 && this.f259791h.get(i3).f259797c.uniseq == personalityLabelPhoto.uniseq) {
                return this.f259791h.get(i3);
            }
        }
        return null;
    }

    public int d(long j3, PersonalityLabelInfo personalityLabelInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), personalityLabelInfo, Boolean.valueOf(z16))).intValue();
        }
        List<PersonalityLabelPhoto> list = personalityLabelInfo.personalityLabelPhotos;
        if (!z16 && list.size() > 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size).fileId == -1) {
                    list.remove(size);
                    personalityLabelInfo.photoCount--;
                }
            }
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f259791h.size(); i16++) {
            a aVar = this.f259791h.get(i16);
            if (aVar.f259796b == j3) {
                int i17 = aVar.f259795a;
                if (i17 < list.size()) {
                    list.add(i17, aVar.f259797c);
                } else {
                    list.add(aVar.f259797c);
                }
                personalityLabelInfo.photoCount++;
                i3++;
            }
        }
        return i3;
    }

    public void e(long j3, PersonalityLabelPhoto personalityLabelPhoto) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), personalityLabelPhoto);
            return;
        }
        while (true) {
            if (i3 < this.f259791h.size()) {
                if (this.f259791h.get(i3).f259796b == j3 && this.f259791h.get(i3).f259797c.uniseq == personalityLabelPhoto.uniseq) {
                    aVar = this.f259791h.get(i3);
                    break;
                }
                i3++;
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar != null) {
            ((ITransFileController) this.f259788d.getRuntimeService(ITransFileController.class)).transferAsync(aVar.f259798d);
            if (QLog.isColorLevel()) {
                QLog.i("PLUploadManager", 2, "retry " + aVar.f259798d.mLocalPath);
            }
        }
    }

    public void f(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f259789e = bVar;
        }
    }

    public boolean g(List<CompressInfo> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, list, Long.valueOf(j3))).booleanValue();
        }
        ArrayList arrayList = new ArrayList();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            int i17 = i3;
            a c16 = c(list.get(i16), j3, currentTimeMillis, list.size(), i16);
            if (c16 != null) {
                i3 = i17 + 1;
                this.f259791h.add(0, c16);
                arrayList.add(0, c16.f259797c);
            } else {
                i3 = i17;
            }
        }
        int i18 = i3;
        if (i18 > 0) {
            for (int i19 = 0; i19 < this.f259791h.size(); i19++) {
                if (i19 < i18) {
                    this.f259791h.get(i19).f259795a = i19;
                } else if (this.f259791h.get(i19).f259796b == j3) {
                    this.f259791h.get(i19).f259795a += i18;
                }
            }
            this.f259790f.post(new Runnable(arrayList, j3) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f259793d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f259794e;

                {
                    this.f259793d = arrayList;
                    this.f259794e = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PLUploadManager.this, arrayList, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    b bVar = PLUploadManager.this.f259789e;
                    if (bVar != null) {
                        bVar.l2(this.f259793d, this.f259794e);
                    }
                }
            });
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f259790f.removeCallbacksAndMessages(null);
        ((ITransFileController) this.f259788d.getRuntimeService(ITransFileController.class)).removeHandle(this.f259792i);
        if (QLog.isColorLevel()) {
            QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.f259788d + " handler:" + this.f259792i);
        }
    }
}
