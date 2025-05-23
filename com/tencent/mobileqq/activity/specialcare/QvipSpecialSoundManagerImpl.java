package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QvipSpecialSoundManagerImpl implements IQvipSpecialSoundManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f186443d;

    /* renamed from: e, reason: collision with root package name */
    private b f186444e;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f186445f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f186446h;

    public QvipSpecialSoundManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186444e = new b(4096);
        this.f186446h = new Handler(Looper.getMainLooper());
        this.f186443d = VasUtil.getApp().getApplicationContext();
        this.f186445f = VasUtil.getApp();
        try {
            ThreadManager.getFileThreadHandler().post(new MoveConfig(this.f186443d.getFilesDir().getCanonicalPath() + "/"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            try {
                g a16 = g.a(new JSONObject(str));
                if (a16 != null) {
                    q(a16.f186574a);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(String str) {
        int i3;
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(MsfSdkUtils.insertMtype("lingyin", str), new File(this.f186443d.getFilesDir(), str));
            gVar.V = (byte) 1;
            i3 = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).specialSoundDownload(gVar);
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        if (i3 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(c cVar, boolean z16) {
        if (cVar == null) {
            return;
        }
        this.f186446h.post(new Runnable(cVar, z16) { // from class: com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f186449d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f186450e;

            {
                this.f186449d = cVar;
                this.f186450e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QvipSpecialSoundManagerImpl.this, cVar, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f186449d.onResult(this.f186450e);
                }
            }
        });
    }

    private void m() {
        SharedPreferences sharedPreferences = this.f186445f.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        if (sharedPreferences.contains("defaulut_special_sound_source1")) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("defaulut_special_sound_source1", R.raw.f169448ab);
        edit.commit();
    }

    private boolean n(String str) {
        String currentAccountUin = this.f186445f.getCurrentAccountUin();
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.contains("|")) {
            try {
                for (String str2 : str.split("\\|")) {
                    if (str2.trim().equals(currentAccountUin)) {
                        return true;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return str.equals(currentAccountUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QvipSpecialSoundManager", 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j3) {
        if (j3 <= 0) {
            o("reportFlowData is Empty flowSize = " + j3);
            return;
        }
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            o("reportFlowData int wifi state");
        } else {
            o("reportFlowData int 2G/3G state");
        }
        o("sendAppDataIncerment flowSize = " + j3);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return getClass().getName();
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public String getSoundName(int i3) {
        g.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        HashMap<String, g.a> hashMap = f.f186573b;
        if (hashMap != null && !hashMap.isEmpty() && (aVar = hashMap.get(String.valueOf(i3))) != null) {
            return aVar.f186576b;
        }
        return "";
    }

    public String i(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) file);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] c16 = this.f186444e.c(4096);
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(c16, 0, 4096);
                        if (read != -1) {
                            byteArrayOutputStream.write(c16, 0, read);
                        } else {
                            return new String(byteArrayOutputStream.toByteArray(), "utf-8");
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                        this.f186444e.d(c16);
                        return "";
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                        this.f186444e.d(c16);
                        return "";
                    }
                } finally {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    this.f186444e.d(c16);
                }
            }
        } catch (FileNotFoundException e18) {
            e18.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public boolean isCacheData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return f.f186572a.containsKey("key_special_sound_list" + this.f186445f.getCurrentAccountUin());
    }

    public String j() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        File file = new File(this.f186443d.getFilesDir(), "pddata/vas/special_remind/new_config.json");
        boolean z16 = true;
        if (!file.exists()) {
            try {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.f186445f.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getString("specialcare_config", ""), file);
                gVar.V = (byte) 1;
                gVar.Q = true;
                i3 = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).specialSoundDownload(gVar);
            } catch (Exception e16) {
                e16.printStackTrace();
                i3 = -1;
            }
            if (i3 == 0) {
                p(file.length());
            } else {
                z16 = false;
            }
        }
        if (!z16) {
            o("downLoad Special Sound Config failed.");
            return "";
        }
        try {
            return i(file);
        } catch (IOException e17) {
            o("decodeTextFile is IOException.");
            e17.printStackTrace();
            return "";
        } catch (Exception e18) {
            o("decodeTextFile is exception.");
            e18.printStackTrace();
            return "";
        } catch (OutOfMemoryError e19) {
            o("decodeTextFile is OutOfMemoryError.");
            e19.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public void loadSpecialSoundConfig(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else {
            ThreadManagerV2.post(new Runnable(cVar) { // from class: com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ c f186448d;

                {
                    this.f186448d = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QvipSpecialSoundManagerImpl.this, (Object) cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
                        j3 = QvipSpecialSoundManagerImpl.this.r();
                    } else {
                        j3 = QvipSpecialSoundManagerImpl.this.j();
                    }
                    QvipSpecialSoundManagerImpl.this.h(j3);
                    QvipSpecialSoundManagerImpl.this.l(this.f186448d, f.f186572a.containsKey("key_special_sound_list" + QvipSpecialSoundManagerImpl.this.f186445f.getCurrentAccountUin()));
                }
            }, 5, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public void onSpecialSoundConfigDownloaded(int i3, File file, String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), file, str);
            return;
        }
        if (file == null) {
            QLog.e("QvipSpecialSoundManager", 1, "onSpecialSoundConfigDownloaded specialSoundPath == null");
            return;
        }
        String str2 = null;
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QvipSpecialSoundManager", 2, "download SpecialSound Success");
            }
            try {
                String i16 = i(file);
                if (file.exists()) {
                    j3 = file.length();
                } else {
                    j3 = 0;
                }
                p(j3);
                str2 = i16;
            } catch (Exception e16) {
                o("decodeTextFile is exception.");
                e16.printStackTrace();
            } catch (OutOfMemoryError e17) {
                o("decodeTextFile is OutOfMemoryError.");
                e17.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            o("new Config is Empty");
        } else if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            o("Config is Same");
        } else {
            s(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public void parseSpecialSoundConfigFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
                return;
            }
            m();
            h(j());
        }
    }

    public void q(List<g.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            SharedPreferences.Editor edit = this.f186445f.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
            for (int i3 = 0; i3 < size; i3++) {
                g.a aVar = list.get(i3);
                HashMap<String, g.a> hashMap = f.f186573b;
                if (!hashMap.containsKey(String.valueOf(aVar.f186575a))) {
                    hashMap.put(String.valueOf(aVar.f186575a), aVar);
                }
                edit.putString(AppConstants.Preferences.SPECIAL_SOUND_URL + aVar.f186575a, aVar.f186579e);
                if (!n(aVar.f186580f)) {
                    o("is white list.");
                } else if (aVar.f186581g == 1) {
                    int i16 = aVar.f186577c;
                    if (i16 == 1) {
                        arrayList.add(aVar);
                    } else if (i16 == 2) {
                        arrayList2.add(aVar);
                    } else {
                        arrayList3.add(aVar);
                    }
                }
            }
            edit.commit();
            list.clear();
            list.addAll(arrayList);
            list.addAll(arrayList2);
            list.addAll(arrayList3);
            HashMap<String, List<g.a>> hashMap2 = f.f186572a;
            if (!hashMap2.containsKey("key_special_sound_list" + this.f186445f.getCurrentAccountUin())) {
                hashMap2.put("key_special_sound_list" + this.f186445f.getCurrentAccountUin(), list);
                return;
            }
            return;
        }
        o("SpecialSoundList is empty, donot need sort.");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String r() {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String decodeString = VipMMKV.getCommon().decodeString("specialcare_config_url", "https://imgcache.qq.com/club/mobile/profile/income_call/special_remind_5.3_0_1432878163.json");
        String stringData = VasToggle.FEATURE_SPECIALCARE_CONFIG.getStringData("https://imgcache.qq.com/club/mobile/profile/income_call/special_remind_5.3_0_1432878163.json");
        File file = new File(this.f186443d.getFilesDir(), "pddata/vas/special_remind/new_config.json");
        if (!decodeString.equals(stringData)) {
            if (file.exists()) {
                FileUtils.deleteFile(file);
            }
            VipMMKV.getCommon().encodeString("specialcare_config_url", stringData);
        }
        if (!file.exists()) {
            try {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(stringData, file);
                gVar.V = (byte) 1;
                gVar.Q = true;
                i3 = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).specialSoundDownload(gVar);
            } catch (Exception e16) {
                QLog.e("QvipSpecialSoundManager", 1, e16, new Object[0]);
                i3 = -1;
            }
            if (i3 == 0) {
                p(file.length());
            } else {
                z16 = false;
                if (z16) {
                    o("downLoad Special Sound Config failed.");
                    return "";
                }
                try {
                    return i(file);
                } catch (Exception | OutOfMemoryError e17) {
                    QLog.e("QvipSpecialSoundManager", 1, e17, new Object[0]);
                    return "";
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public void s(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str) && str2 != null && !TextUtils.isEmpty(str2)) {
                    g a16 = g.a(new JSONObject(str2));
                    g a17 = g.a(new JSONObject(str));
                    List<g.a> list = a16.f186574a;
                    List<g.a> list2 = a17.f186574a;
                    if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty() && list.size() >= list2.size()) {
                        int size = list2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            g.a aVar = list.get(i3);
                            g.a aVar2 = list2.get(i3);
                            if (aVar.f186575a == aVar2.f186575a && !aVar.f186578d.equals(aVar2.f186578d)) {
                                ThreadManagerV2.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ g.a f186447d;

                                    {
                                        this.f186447d = aVar;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QvipSpecialSoundManagerImpl.this, (Object) aVar);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        long j3;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (QvipSpecialSoundManagerImpl.this.k(this.f186447d.f186579e)) {
                                            File file = new File(QvipSpecialSoundManagerImpl.this.f186443d.getFilesDir(), this.f186447d.f186579e);
                                            if (file.exists()) {
                                                j3 = file.length();
                                            } else {
                                                j3 = 0;
                                            }
                                            QvipSpecialSoundManagerImpl.this.p(j3);
                                            return;
                                        }
                                        QvipSpecialSoundManagerImpl.this.o("updateSpecialSound down fial, id=" + this.f186447d.f186575a);
                                    }
                                }, 5, null, true);
                            }
                        }
                        return;
                    }
                    o("updateSpecialSound return.");
                }
            } catch (Exception e16) {
                o("updateSpecialSound exception");
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager
    public void updateSpecialSoundConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
            return;
        }
        SharedPreferences sharedPreferences = this.f186445f.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        File file = new File(this.f186443d.getFilesDir(), "pddata/vas/special_remind/new_config.json");
        String str = null;
        try {
            if (file.exists()) {
                str = i(file);
            }
        } catch (Exception e16) {
            o("download error:" + e16.toString());
            e16.printStackTrace();
        }
        try {
            String string = sharedPreferences.getString("specialcare_config", "");
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(string, file);
            gVar.V = (byte) 1;
            gVar.Q = true;
            gVar.B = 20000;
            IVasDepTemp iVasDepTemp = (IVasDepTemp) QRoute.api(IVasDepTemp.class);
            if (iVasDepTemp.isEnable()) {
                iVasDepTemp.requestPreDownload(file, string, 10021, PreDownloadConstants.DEPARTMENT_VAS, 2, 0, new RunnableTask((BaseQQAppInterface) this.f186445f, "vas_special_remind", new SyncDownloadRunnable(gVar, file, str, this), 4000L));
                if (QLog.isColorLevel()) {
                    QLog.d("QvipSpecialSoundManager", 2, "[preDownload] path=" + file.getCanonicalPath() + " url=" + string);
                    return;
                }
                return;
            }
            onSpecialSoundConfigDownloaded(((IVasDepTemp) QRoute.api(IVasDepTemp.class)).specialSoundDownload(gVar), file, str);
        } catch (Exception e17) {
            o("download error:" + e17.toString());
            e17.printStackTrace();
        }
    }
}
