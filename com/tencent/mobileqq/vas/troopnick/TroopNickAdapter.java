package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC;
import com.tencent.mobileqq.vas.ipc.remote.IEmoticonManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNickAdapter implements VasResAdapter, VasResDrawable.VasResDrawableAdapter {

    /* renamed from: a, reason: collision with root package name */
    private VasResController f311039a;

    /* renamed from: b, reason: collision with root package name */
    private String f311040b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f311041c;

    /* renamed from: d, reason: collision with root package name */
    public int f311042d;

    /* renamed from: e, reason: collision with root package name */
    public int f311043e;

    public TroopNickAdapter(VasResDrawable vasResDrawable) {
        this(vasResDrawable, null, R.drawable.hv8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i3, int i16) {
        VasResController vasResController;
        VasResController vasResController2 = this.f311039a;
        if (vasResController2 == null) {
            return;
        }
        synchronized (vasResController2) {
            String[] f16 = f(str);
            if (f16 != null && f16.length != 0 && (vasResController = this.f311039a) != null) {
                Message obtainMessage = vasResController.getUIHanlder().obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                bundle.putStringArray("pngs", f16);
                bundle.putInt(WidgetCacheConstellationData.INTERVAL, i3);
                bundle.putInt("repeatTimes", i16);
                obtainMessage.setData(bundle);
                obtainMessage.what = 10001;
                this.f311039a.getUIHanlder().sendMessage(obtainMessage);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void destroy() {
        VasResController vasResController = this.f311039a;
        if (vasResController != null) {
            synchronized (vasResController) {
                this.f311039a = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void downloadDone(int i3, final Bundle bundle) {
        boolean z16;
        int i16 = 0;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadDone isMainThread:");
            if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("TroopNickAdapter", 2, sb5.toString());
        }
        if (bundle != null) {
            i16 = bundle.getInt("resType");
        }
        if (i16 == 2) {
            if (3 == i3 || i3 == 0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String signatureFilePath;
                        int i17 = bundle.getInt("dynamicType");
                        String string = bundle.getString("tplId");
                        String string2 = bundle.getString(WadlProxyConsts.PARAM_FILENAME);
                        if (i17 != 16) {
                            signatureFilePath = null;
                        } else {
                            signatureFilePath = SignatureTemplateConfig.getSignatureFilePath(string, "dynamic_aio");
                        }
                        if (signatureFilePath != null) {
                            boolean X = DownloaderFactory.X(new File(SignatureTemplateConfig.getSignatureFilePath(string, string2)), new File(signatureFilePath), true);
                            if (TroopNickAdapter.this.f311039a != null) {
                                synchronized (TroopNickAdapter.this.f311039a) {
                                    if (TroopNickAdapter.this.f311039a == null) {
                                        return;
                                    }
                                    if (X) {
                                        TroopNickAdapter.this.f311039a.getUIHanlder().sendEmptyMessage(10003);
                                    }
                                }
                            }
                        }
                    }
                }, 128, null, true);
            }
        }
    }

    public String[] f(String str) {
        String str2;
        StringBuilder sb5;
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            try {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(File.separator);
                if (new File(str, "01.9.png").exists()) {
                    str2 = "%s.9.png";
                } else {
                    str2 = "%s.png";
                }
                sb6.append(str2);
                String sb7 = sb6.toString();
                for (int i3 = 1; i3 < listFiles.length; i3++) {
                    Object[] objArr = new Object[1];
                    if (i3 < 10) {
                        sb5 = new StringBuilder();
                        sb5.append("0");
                        sb5.append(i3);
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(i3);
                        sb5.append("");
                    }
                    objArr[0] = sb5.toString();
                    String format = String.format(sb7, objArr);
                    if (new File(format).exists()) {
                        arrayList.add(format);
                    } else {
                        return (String[]) arrayList.toArray(new String[arrayList.size()]);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNickAdapter", 2, "SignatureView DynamicItem png file path error.");
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter
    public String getDrawableUrl() {
        File file = new File(this.f311040b, "bg.png");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return new File(this.f311040b, "bg.9.png").getAbsolutePath();
    }

    public void h(boolean z16) {
        this.f311041c = z16;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter
    public boolean isDynamic() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void load() {
        VasResController vasResController = this.f311039a;
        if (vasResController == null) {
            return;
        }
        synchronized (vasResController) {
            VasResController vasResController2 = this.f311039a;
            if (vasResController2 == null) {
                return;
            }
            final int id5 = vasResController2.getId();
            final TroopNickNameBusiness troopNickNameBusiness = (TroopNickNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(TroopNickNameBusiness.class);
            if (troopNickNameBusiness.isFileExists(id5)) {
                this.f311040b = troopNickNameBusiness.getSavePath(id5);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        TroopNickNameBusiness.Config config = troopNickNameBusiness.getConfig(id5);
                        if (config != null) {
                            TroopNickAdapter troopNickAdapter = TroopNickAdapter.this;
                            troopNickAdapter.f311042d = config.fontId;
                            troopNickAdapter.f311043e = config.fontType;
                            String str = troopNickAdapter.f311040b;
                            int i16 = config.delay;
                            if (TroopNickAdapter.this.f311041c) {
                                i3 = -1;
                            } else {
                                i3 = config.repeatCount;
                            }
                            troopNickAdapter.g(str, i16, i3);
                        }
                    }
                }, 16, null, true);
            } else {
                ((IEmoticonManager) RemoteProxy.getProxy(EmoticonManagerIPC.class)).startTroopNickDownload(id5, null, -1, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.2
                    @Override // eipc.EIPCResultCallback
                    public void onCallback(EIPCResult eIPCResult) {
                        Bundle bundle;
                        if (eIPCResult != null && (bundle = eIPCResult.data) != null && bundle.getBoolean("status")) {
                            TroopNickAdapter.this.f311040b = eIPCResult.data.getString("filepath");
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.TroopNickAdapter.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    TroopNickNameBusiness.Config config = troopNickNameBusiness.getConfig(id5);
                                    if (config != null) {
                                        TroopNickAdapter troopNickAdapter = TroopNickAdapter.this;
                                        troopNickAdapter.f311042d = config.fontId;
                                        troopNickAdapter.f311043e = config.fontType;
                                        troopNickAdapter.g(troopNickAdapter.f311040b, config.delay, config.repeatCount);
                                    }
                                }
                            }, 16, null, true);
                        }
                    }
                });
            }
        }
    }

    public TroopNickAdapter(VasResDrawable vasResDrawable, AppRuntime appRuntime, int i3) {
        this.f311040b = "";
        this.f311041c = false;
        this.f311039a = vasResDrawable.getVasResController();
        vasResDrawable.getOptions().loadDrawableId = R.drawable.ft6;
        vasResDrawable.getOptions().defaultDrawableId = i3;
        vasResDrawable.getOptions().animatinType = 104;
        if (appRuntime != null) {
            vasResDrawable.addHeader("my_uin", appRuntime.getAccount());
        }
    }
}
