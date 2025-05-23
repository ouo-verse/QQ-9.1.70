package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureManagerForTool extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static SignatureManagerForTool f282246g;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, SignatureTemplateInfo> f282247a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, String> f282248b;

    /* renamed from: c, reason: collision with root package name */
    public RichStatus f282249c;

    /* renamed from: d, reason: collision with root package name */
    public RichStatus f282250d;

    /* renamed from: e, reason: collision with root package name */
    private EIPCResultCallback f282251e;

    /* renamed from: f, reason: collision with root package name */
    public EIPCResultCallback f282252f;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureManagerForTool.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                return;
            }
            int i3 = bundle.getInt("notify_type");
            if (i3 != 6) {
                if (i3 == 7 && eIPCResult.code == 0) {
                    SignatureManagerForTool.this.m(eIPCResult.data.getInt("id"), true);
                    return;
                }
                return;
            }
            if (eIPCResult.code == 0) {
                int i16 = eIPCResult.data.getInt("id");
                String string = eIPCResult.data.getString("url");
                if (QLog.isColorLevel()) {
                    QLog.d("Signature.TOOL", 2, "mSignatureManagerIPCCallback get action id = " + i16 + " url = " + string);
                }
                if (!TextUtils.isEmpty(string)) {
                    SignatureManagerForTool.this.f282248b.put(Integer.valueOf(i16), string);
                    SignatureManagerForTool.this.setChanged();
                    SignatureManagerForTool.this.notifyObservers(4);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureManagerForTool.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                return;
            }
            int i3 = bundle.getInt("notify_type");
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 8) {
                        if (i3 == 9) {
                            int i16 = bundle.getInt("key_history_signature_num");
                            SignatureManagerForTool.this.setChanged();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(8);
                            arrayList.add(Integer.valueOf(i16));
                            SignatureManagerForTool.this.notifyObservers(arrayList);
                            return;
                        }
                        return;
                    }
                    bundle.getLong("bid");
                    String string = bundle.getString("scid");
                    if (!TextUtils.isEmpty(string)) {
                        int i17 = bundle.getInt(WadlProxyConsts.PARAM_DOWNLOAD_RESULT);
                        if (string.startsWith(VasUpdateConstants.SCID_SIGNATURE_STICKER_PREFIX) && i17 == 0) {
                            String substring = string.substring(18, string.length() - 4);
                            if (TextUtils.isDigitsOnly(substring)) {
                                int parseInt = Integer.parseInt(substring);
                                SignatureManagerForTool.this.setChanged();
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(7);
                                arrayList2.add(Integer.valueOf(parseInt));
                                SignatureManagerForTool.this.notifyObservers(arrayList2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(SignJsPlugin.CHANGE_STATUS_CALLBACK_DATA, eIPCResult.data);
                int i18 = eIPCResult.data.getInt("result");
                int i19 = eIPCResult.data.getInt("type");
                SignatureManagerForTool.this.setChanged();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(6);
                arrayList3.add(Integer.valueOf(i18));
                arrayList3.add(hashMap);
                arrayList3.add(Integer.valueOf(i19));
                SignatureManagerForTool.this.notifyObservers(arrayList3);
                return;
            }
            Serializable serializable = bundle.getSerializable("my_signature");
            if (serializable instanceof RichStatus) {
                SignatureManagerForTool.this.setChanged();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(5);
                arrayList4.add(serializable);
                SignatureManagerForTool.this.notifyObservers(arrayList4);
            }
        }
    }

    SignatureManagerForTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282247a = new ConcurrentHashMap<>();
        this.f282248b = new ConcurrentHashMap<>();
        this.f282251e = new a();
        this.f282252f = new b();
    }

    public static synchronized SignatureManagerForTool j() {
        SignatureManagerForTool signatureManagerForTool;
        synchronized (SignatureManagerForTool.class) {
            if (f282246g == null) {
                f282246g = new SignatureManagerForTool();
            }
            signatureManagerForTool = f282246g;
        }
        return signatureManagerForTool;
    }

    public static String k(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return IEPRecommendTask.PROMOTION_IMAGE_URL_PREFIX + str;
    }

    public SignatureTemplateInfo l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SignatureTemplateInfo) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return m(i3, false);
    }

    public SignatureTemplateInfo m(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SignatureTemplateInfo) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        SignatureTemplateInfo signatureTemplateInfo = this.f282247a.get(Integer.valueOf(i3));
        if (signatureTemplateInfo == null || signatureTemplateInfo.isParsing.get() || z16) {
            if (signatureTemplateInfo == null) {
                SignatureTemplateInfo signatureTemplateInfo2 = new SignatureTemplateInfo(Integer.toString(i3));
                this.f282247a.put(Integer.valueOf(i3), signatureTemplateInfo2);
                signatureTemplateInfo = signatureTemplateInfo2;
            }
            if (i3 != 0) {
                signatureTemplateInfo.isParsing.set(true);
                if (QLog.isColorLevel()) {
                    QLog.e("Signature.TOOL", 2, "before getTemplateInfo info");
                }
                ThreadManagerV2.excute(new Runnable(i3) { // from class: com.tencent.mobileqq.richstatus.SignatureManagerForTool.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f282253d;

                    {
                        this.f282253d = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SignatureManagerForTool.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("Signature.TOOL", 2, "in getTemplateInfo info" + this.f282253d);
                        }
                        SignatureTemplateInfo signatureTemplateInfo3 = (SignatureTemplateInfo) SignatureManagerForTool.this.f282247a.get(Integer.valueOf(this.f282253d));
                        boolean z17 = false;
                        if (signatureTemplateInfo3 != null && signatureTemplateInfo3.isParsing.get()) {
                            File file = new File(VasConstant.SIGNATURE_TEMPLATE_DIR + this.f282253d + File.separator + "config.json");
                            if (file.exists()) {
                                String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
                                if (!TextUtils.isEmpty(readFileToStringEx)) {
                                    SignatureTemplateConfig.parseConfig(readFileToStringEx, signatureTemplateInfo3);
                                    signatureTemplateInfo3.isParsing.set(false);
                                    SignatureManagerForTool.this.setChanged();
                                    SignatureManagerForTool.this.notifyObservers(3);
                                    return;
                                }
                                return;
                            }
                            SignatureManagerForTool.this.notifyObservers(9);
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", this.f282253d);
                            QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.K, bundle, SignatureManagerForTool.this.f282251e);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("getTemplateInfo info == null: ");
                            if (signatureTemplateInfo3 == null) {
                                z17 = true;
                            }
                            sb5.append(z17);
                            QLog.e("Signature.TOOL", 2, sb5.toString());
                        }
                    }
                }, 128, null, true);
            }
        }
        return signatureTemplateInfo;
    }

    public void n(RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) richStatus);
            return;
        }
        if (richStatus == null) {
            return;
        }
        if (this.f282249c == null) {
            this.f282249c = new RichStatus(null);
        }
        this.f282249c.copyFrom(richStatus);
        QLog.d("Signature.TOOL", 2, "updateHandleStatus: tpdId=" + this.f282249c.tplId + " fontId=" + this.f282249c.fontId);
    }

    public void o(RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) richStatus);
            return;
        }
        if (richStatus == null) {
            return;
        }
        if (this.f282250d == null) {
            this.f282250d = new RichStatus(null);
        }
        this.f282250d.copyFrom(richStatus);
        QLog.d("Signature.TOOL", 2, "updateSaveStatus: tpdId=" + this.f282250d.tplId + " fontId=" + this.f282250d.fontId);
        n(richStatus);
    }
}
