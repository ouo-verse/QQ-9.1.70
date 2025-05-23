package com.tencent.mobileqq.vipav;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.k;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Manager, IVipFunCallManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private k f313101d;

    /* renamed from: e, reason: collision with root package name */
    VasIpcTempData f313102e;

    /* renamed from: f, reason: collision with root package name */
    f f313103f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends f {
        static IPatchRedirector $redirector_;

        a(String str, String str2) {
            super(str, str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "onDone, status=" + gVar.i() + ", task.errCode:" + gVar.f313006d + ", key=" + gVar.f313004c);
            }
            Bundle h16 = gVar.h();
            if (h16 != null) {
                boolean g16 = b.this.g(gVar);
                if (h16.getInt(VipFunCallConstants.KEY_DEAL_TYPE) == 0) {
                    return;
                }
                int i3 = h16.getInt("callId");
                Bundle bundle = new Bundle();
                bundle.putInt("status", 3);
                b.this.f313102e.set(String.valueOf(i3), bundle);
                int i16 = h16.getInt("resourceType");
                String string = h16.getString("path");
                if (!h16.getBoolean(VipFunCallConstants.KEY_EXISTS, false)) {
                    g16 = FileUtils.rename(string + ".tmp", string);
                }
                if (!g16) {
                    QLog.e("VipFunCallManager", 1, "mDownloadListener onDone rename failure. path:" + string);
                }
                if (h16.getBoolean(VipFunCallConstants.KEY_IS_IPC) && b.this.f313101d != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(VipFunCallConstants.KEY_STATUSE, 3);
                    bundle2.putInt("callId", i3);
                    bundle2.putInt("srcType", h16.getInt("srcType"));
                    bundle2.putBoolean(VipFunCallConstants.KEY_BOO_RESULT, g16);
                    bundle2.putInt("resourceType", i16);
                    b.this.f313101d.a(i3, gVar.i(), bundle2);
                }
                if (9 == VipFunCallUtil.getResourceType()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
                    }
                    Intent intent = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
                    intent.putExtra(VipFunCallConstants.FUN_CALL_ID, i3);
                    intent.setPackage(VasUtil.getApp().getApp().getPackageName());
                    VasUtil.getApp().getApp().sendBroadcast(intent);
                    return;
                }
                return;
            }
            QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + gVar.f313004c);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + gVar.f313014l + "percent=" + gVar.f313015m + ", key=" + gVar.f313004c);
            }
            Bundle h16 = gVar.h();
            if (h16 == null) {
                QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + gVar.f313004c);
                return;
            }
            if (h16.getInt(VipFunCallConstants.KEY_DEAL_TYPE) != 0 && gVar.h().getBoolean(VipFunCallConstants.KEY_IS_IPC) && b.this.f313101d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(VipFunCallConstants.KEY_STATUSE, 2);
                bundle.putInt("callId", h16.getInt("callId"));
                bundle.putInt("srcType", h16.getInt("srcType"));
                bundle.putInt("progress", (int) gVar.f313015m);
                bundle.putInt("resourceType", h16.getInt("resourceType"));
                b.this.f313101d.b(bundle);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            Bundle h16 = gVar.h();
            if (h16 == null) {
                QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + gVar.f313004c);
                return true;
            }
            if (h16.getInt(VipFunCallConstants.KEY_DEAL_TYPE) == 0) {
                return true;
            }
            int i3 = h16.getInt("resourceType");
            boolean z16 = h16.getBoolean(VipFunCallConstants.KEY_IS_IPC);
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "onStart, loaded=" + gVar.f313014l + ", percent=" + gVar.f313015m + ", resType=" + i3 + ", isIPC=" + z16);
            }
            if (z16 && b.this.f313101d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(VipFunCallConstants.KEY_STATUSE, 1);
                bundle.putInt("callId", h16.getInt("callId"));
                bundle.putInt("srcType", h16.getInt("srcType"));
                bundle.putInt("resourceType", i3);
                b.this.f313101d.b(bundle);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vipav.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8959b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f313105a;

        /* renamed from: b, reason: collision with root package name */
        private int f313106b;

        /* renamed from: c, reason: collision with root package name */
        private int f313107c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f313108d;

        /* renamed from: e, reason: collision with root package name */
        private int f313109e;

        /* renamed from: f, reason: collision with root package name */
        private String f313110f;

        /* renamed from: g, reason: collision with root package name */
        private String f313111g;

        /* renamed from: h, reason: collision with root package name */
        private File f313112h;

        /* renamed from: i, reason: collision with root package name */
        private int f313113i;

        /* renamed from: j, reason: collision with root package name */
        private Bundle f313114j;

        public C8959b(int i3, int i16, boolean z16, int i17, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), str, str2);
                return;
            }
            this.f313106b = i3;
            this.f313107c = i16;
            this.f313108d = z16;
            this.f313109e = i17;
            this.f313110f = str;
            this.f313111g = str2;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f313113i;
        }

        public File b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f313112h;
        }

        public Bundle c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f313114j;
        }

        public C8959b d() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C8959b) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            File file = new File(this.f313111g);
            this.f313112h = file;
            if (file.exists() && this.f313112h.isFile()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "startDownload exists(), id=" + this.f313106b + ", resType=" + this.f313107c + ", isIPC=" + this.f313108d + ", srcType=" + this.f313109e + ", fileExist=" + z16);
            }
            if (z16 && !this.f313108d) {
                this.f313105a = true;
                return this;
            }
            this.f313113i = this.f313107c;
            this.f313114j = new Bundle();
            if (7 != VipFunCallUtil.getResourceType() && 7 == this.f313113i) {
                this.f313113i = 0;
            }
            this.f313114j.putInt("callId", this.f313106b);
            this.f313114j.putString("path", this.f313111g);
            this.f313114j.putBoolean(VipFunCallConstants.KEY_IS_IPC, this.f313108d);
            this.f313114j.putInt("resourceType", this.f313107c);
            this.f313114j.putInt("srcType", this.f313109e);
            this.f313114j.putInt(VipFunCallConstants.KEY_DEAL_TYPE, this.f313113i);
            if (z16) {
                this.f313114j.putBoolean(VipFunCallConstants.KEY_EXISTS, true);
                g gVar = new g(this.f313110f, this.f313112h);
                gVar.y(3);
                gVar.f313006d = 0;
                gVar.w(this.f313114j);
                b.this.f313103f.onDone(gVar);
                this.f313105a = true;
                return this;
            }
            this.f313105a = false;
            return this;
        }

        boolean e() {
            return this.f313105a;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0089 -> B:20:0x0098). Please report as a decompilation issue!!! */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        InputStream inputStream = null;
        this.f313101d = null;
        this.f313102e = new VasIpcTempData("fun_call");
        this.f313103f = new a(AppConstants.FlowStatPram.PARAM_WIFICOLOR_RING_DOWNLOAD_FLOW, AppConstants.FlowStatPram.PARAM_XGCOLOR_RING_DOWNLOAD_FLOW);
        File file = new File(VipFunCallUtil.getFunCallPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!f()) {
            if (QLog.isColorLevel()) {
                QLog.d("VipFunCallManager", 2, "<<need to copy a default config file.");
            }
            try {
                try {
                    try {
                        inputStream = VasUtil.getApp().getApp().getAssets().open("funcall/vipfuncall_config.json");
                        FileUtils.writeFile(VipFunCallUtil.getFunCallPath(), new StringBuffer("config.json"), inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
    }

    private void c(int i3, int i16, boolean z16, int i17) {
        boolean z17 = false;
        if (VasUtil.getApp() != null) {
            z17 = VipFunCallUtil.isExternalStorageReady(VasUtil.getApp().getApp(), "VipFunCallManager", false);
        }
        if (QLog.isColorLevel() || !z17) {
            QLog.d("VipFunCallManager", 2, "startDownload, id=" + i3 + ", resType=" + i16 + ", isIPC=" + z16 + ", srcType=" + i17 + ", haveSDCard=" + z17);
        }
    }

    private int d(List<Long> list, SharedPreferences sharedPreferences, String str, String str2, SharedPreferences.Editor editor, int i3) {
        String[] split = str2.split(",");
        for (int i16 = 0; i16 < split.length; i16++) {
            if (str.equals(split[i16])) {
                i3 = i16;
            } else if (!TextUtils.isEmpty(split[i16])) {
                String string = sharedPreferences.getString(VipFunCallConstants.KEY_GROUP_ONE + split[i16], "");
                Iterator<Long> it = list.iterator();
                String str3 = string;
                while (it.hasNext()) {
                    String valueOf = String.valueOf(it.next());
                    if (!TextUtils.isEmpty(valueOf)) {
                        str3 = str3.replace(valueOf + "-", "");
                    }
                }
                if (!string.equals(str3)) {
                    editor.putString(VipFunCallConstants.KEY_GROUP_ONE + split[i16], str3);
                }
            }
        }
        return i3;
    }

    @Nullable
    private SharedPreferences e(AppRuntime appRuntime, int i3, int i16) {
        if (appRuntime == null) {
            appRuntime = VasUtil.getApp();
        }
        if (appRuntime == null) {
            QLog.e("VipFunCallManager", 1, "setFunCallData null == app opType=" + i3 + ", callId=" + i16);
            return null;
        }
        SharedPreferences funCallSP = VipFunCallUtil.getFunCallSP(appRuntime, 1, null);
        if (funCallSP == null) {
            QLog.e("VipFunCallManager", 1, "setFunCallData null == sp");
            return null;
        }
        return funCallSP;
    }

    private boolean f() {
        return new File(VipFunCallConstants.FUNCALL_CONFIG_FILE).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(g gVar) {
        boolean z16;
        if (gVar.i() == 3 && gVar.f313006d == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + gVar.i() + ", task.errCode:" + gVar.f313006d);
        }
        return z16;
    }

    private void h(int i3, SharedPreferences sharedPreferences) {
        String str;
        if (i3 == 0) {
            QLog.e("VipFunCallManager", 1, "setGroup callId == 0, opType=SET_DATA_DELET_GROUP");
            return;
        }
        String valueOf = String.valueOf(i3);
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        String string = sharedPreferences.getString(VipFunCallConstants.KEY_GROUP, null);
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            String str2 = "";
            for (int i16 = 0; i16 < split.length; i16++) {
                if (!valueOf.equals(split[i16])) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    if (str2.length() > 0) {
                        str = "," + split[i16];
                    } else {
                        str = split[i16];
                    }
                    sb5.append(str);
                    str2 = sb5.toString();
                }
            }
            if (!string.equals(str2)) {
                sharedPreferences.edit().putString(VipFunCallConstants.KEY_GROUP, str2).commit();
            }
        }
    }

    private void i(int i3, int i16, int i17, List<Long> list, long j3, SharedPreferences sharedPreferences) {
        if (i16 != 0 && list != null && list.size() >= 1) {
            String valueOf = String.valueOf(i16);
            if (TextUtils.isEmpty(valueOf)) {
                return;
            }
            String string = sharedPreferences.getString(VipFunCallConstants.KEY_GROUP, null);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            int i18 = -1;
            if (!TextUtils.isEmpty(string)) {
                i18 = d(list, sharedPreferences, valueOf, string, edit, -1);
            }
            if (i18 < 0) {
                if (!TextUtils.isEmpty(string)) {
                    valueOf = string + "," + valueOf;
                }
                edit.putString(VipFunCallConstants.KEY_GROUP, valueOf);
            }
            Iterator<Long> it = list.iterator();
            String str = "-";
            while (it.hasNext()) {
                str = str + it.next() + "-";
            }
            edit.putString(VipFunCallConstants.KEY_GROUP_ONE + i16, i16 + "," + i17 + "," + str + "," + j3);
            edit.commit();
            return;
        }
        QLog.e("VipFunCallManager", 1, "setGroup uins.size() < 1 opType=" + i3 + ", callId=" + i16);
    }

    @Override // com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager
    public boolean downloadFCSuit(int i3, int i16, boolean z16, int i17, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), kVar)).booleanValue();
        }
        this.f313101d = kVar;
        int resourceType = VipFunCallUtil.getResourceType();
        startDownload(i3, 9, z16, i17);
        startDownload(i3, resourceType, z16, i17);
        if (i16 != 0) {
            ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).colorRingDownload(VasUtil.getApp(), i16, z16, i17, kVar);
        }
        if (resourceType == 6) {
            startDownload(i3, 7, false, 0);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getClass().getName();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f313101d = null;
        }
    }

    @Override // com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager
    public void setFunCallData(AppRuntime appRuntime, int i3, String str, int i16, int i17, List<Long> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), list, Long.valueOf(j3));
            return;
        }
        SharedPreferences e16 = e(appRuntime, i3, i16);
        if (e16 == null) {
            return;
        }
        if (2 == i3) {
            h(i16, e16);
            return;
        }
        if (1 == i3) {
            i(i3, i16, i17, list, j3, e16);
            return;
        }
        if (i3 == 0) {
            SharedPreferences.Editor edit = e16.edit();
            edit.putInt(str + "callId6", i16);
            edit.putInt(str + "callId9", i16);
            edit.putInt(str + "callId7", i16);
            edit.putInt(str + "callId3", i17);
            edit.commit();
            return;
        }
        QLog.e("VipFunCallManager", 1, "setFunCallData opType == unknow " + i3);
    }

    @Override // com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager
    public void startDownload(int i3, int i16, boolean z16, int i17) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        c(i3, i16, z16, i17);
        if (i3 == 0) {
            return;
        }
        String resourceUrlOrValue = VipFunCallUtil.getResourceUrlOrValue(VasUtil.getApp(), i3, i16, null);
        if (TextUtils.isEmpty(resourceUrlOrValue)) {
            QLog.e("VipFunCallManager", 1, "startDownload error0 url=null, id=" + i3 + ", resType=" + i16 + ", isIPC=" + z16 + ", srcType=" + i17);
            return;
        }
        String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(VasUtil.getApp(), i3, i16, null);
        if (TextUtils.isEmpty(resourcePathByUrl)) {
            QLog.e("VipFunCallManager", 1, "startDownload error resPath=null, id=" + i3 + ", resType=" + i16 + ", isIPC=" + z16 + ", srcType=" + i17);
            return;
        }
        C8959b d16 = new C8959b(i3, i16, z16, i17, resourceUrlOrValue, resourcePathByUrl).d();
        if (d16.e()) {
            return;
        }
        File b16 = d16.b();
        int a16 = d16.a();
        Bundle c16 = d16.c();
        if (a16 != 0) {
            b16 = new File(resourcePathByUrl + ".tmp");
        }
        g gVar = new g(resourceUrlOrValue, b16);
        gVar.V = (byte) 1;
        gVar.E = 5242880L;
        gVar.R = VipFunCallConstants.FLOW_TYPE;
        if (9 == i16 || 7 == i16) {
            if (WebpSoLoader.b() != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            gVar.M = z17;
        }
        if (7 != i16) {
            gVar.f313019q = true;
        }
        ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).startDownload(VasUtil.getApp(), c16, gVar, this.f313103f);
        if (QLog.isColorLevel()) {
            QLog.d("VipFunCallManager", 2, "startDownload, id=" + i3 + ", resType=" + i16 + ", url=" + resourceUrlOrValue);
        }
    }
}
