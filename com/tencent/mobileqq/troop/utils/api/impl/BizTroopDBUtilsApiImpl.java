package com.tencent.mobileqq.troop.utils.api.impl;

import GeneralSettings.Setting;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.config.u;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BizTroopDBUtilsApiImpl implements IBizTroopDBUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BizTroopDBUtilsApiImpl";
    a mLimitQueuedRunnablePool;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements ThreadExcutor.IThreadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        ConcurrentLinkedQueue<Runnable> f302054d;

        /* renamed from: e, reason: collision with root package name */
        private int f302055e;

        /* renamed from: f, reason: collision with root package name */
        private int f302056f;

        /* renamed from: h, reason: collision with root package name */
        private int f302057h;

        public a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f302054d = new ConcurrentLinkedQueue<>();
            this.f302055e = i3;
            this.f302057h = i16;
            this.f302056f = 0;
        }

        public void a() {
            Runnable poll;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (this.f302056f < this.f302055e && (poll = this.f302054d.poll()) != null) {
                this.f302056f++;
                ThreadManagerV2.excute(poll, this.f302057h, this, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f302056f--;
                a();
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    public BizTroopDBUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLimitQueuedRunnablePool = new a(10, 32);
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi
    public void saveGeneralSettings(ArrayList<Setting> arrayList, AppInterface appInterface) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList, (Object) appInterface);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                j3 = System.currentTimeMillis();
                QLog.d(TAG, 2, "saveGeneralSettings setting start size = " + arrayList.size());
            } else {
                j3 = 0;
            }
            RoamSettingDataServiceImpl roamSettingDataServiceImpl = (RoamSettingDataServiceImpl) appInterface.getRuntimeService(IRoamSettingDataService.class, "");
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Setting setting = arrayList.get(i3);
                String str = setting.Path;
                String str2 = setting.Value;
                if (str != null) {
                    if (str2 == null || str2.length() == 0 || str2.equalsIgnoreCase("")) {
                        str2 = u.c().d(((RoamSettingServiceImpl) appInterface.getRuntimeService(IRoamSettingService.class, "")).getGeneralSettingType(str));
                    }
                    RoamSetting saveRoamSetting = roamSettingDataServiceImpl.saveRoamSetting(str, str2);
                    if (saveRoamSetting != null) {
                        arrayList2.add(saveRoamSetting);
                    }
                    u.c().f(str, str2);
                }
            }
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                ThreadManagerV2.post(new Runnable(roamSettingDataServiceImpl, arrayList2) { // from class: com.tencent.mobileqq.troop.utils.api.impl.BizTroopDBUtilsApiImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ RoamSettingDataServiceImpl f302052d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f302053e;

                    {
                        this.f302052d = roamSettingDataServiceImpl;
                        this.f302053e = arrayList2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, BizTroopDBUtilsApiImpl.this, roamSettingDataServiceImpl, arrayList2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f302052d.saveRoamSettingToDB(this.f302053e);
                        }
                    }
                }, 5, null, false);
            } else {
                roamSettingDataServiceImpl.saveRoamSettingToDB(arrayList2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - j3));
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi
    public void saveGeneralSettingsRevision(int i3, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) appInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveGeneralSettingRevision=" + i3);
        }
        ((RoamSettingDataServiceImpl) appInterface.getRuntimeService(IRoamSettingDataService.class, "")).setRevision(i3);
    }
}
