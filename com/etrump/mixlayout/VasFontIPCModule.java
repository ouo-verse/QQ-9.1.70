package com.etrump.mixlayout;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.photoplus.sticker.Sticker;
import eipc.EIPCResult;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class VasFontIPCModule extends QIPCModule {
    private static VasFontIPCModule G = null;
    public static String H = "action_download_hy_so";
    public static String I = "action_download_fz_so";
    public static String J = "action_download_font";
    public static String K = "action_download_signature_config";
    public static String L = "action_get_my_signature";
    public static String M = "action_change_status";
    public static String N = "action_get_action";
    public static String P = "action_download_use_quickupdate";
    public static String Q = "action_get_shield_font";
    public static String R = "action_get_history_signature_num";
    public static String S = "action_update_qqvalue";
    private AtomicInteger C;
    private ConcurrentHashMap<Integer, Integer> D;
    private ConcurrentHashMap<String, Integer> E;
    private CallBacker F;

    /* renamed from: d, reason: collision with root package name */
    private Vector<Integer> f32658d;

    /* renamed from: e, reason: collision with root package name */
    private Vector<Integer> f32659e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f32660f;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f32661h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f32662i;

    /* renamed from: m, reason: collision with root package name */
    private AtomicInteger f32663m;

    /* loaded from: classes2.dex */
    class a extends CallBacker {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            int i17;
            EIPCResult createResult;
            if (j3 == 1000 && str.startsWith(VasUpdateConstants.SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX)) {
                String substring = str.substring(15, str.length() - 5);
                if (TextUtils.isDigitsOnly(substring)) {
                    int parseInt = Integer.parseInt(substring);
                    if (VasFontIPCModule.this.D.containsKey(Integer.valueOf(parseInt))) {
                        int intValue = ((Integer) VasFontIPCModule.this.D.get(Integer.valueOf(parseInt))).intValue();
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", parseInt);
                        bundle.putInt("notify_type", 7);
                        if (i3 == 0) {
                            createResult = EIPCResult.createResult(0, bundle);
                        } else {
                            createResult = EIPCResult.createResult(-102, bundle);
                        }
                        VasFontIPCModule.this.callbackResult(intValue, createResult);
                        VasFontIPCModule.this.D.remove(Integer.valueOf(parseInt));
                    }
                }
            }
            if (VasFontIPCModule.this.E.containsKey(str)) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("notify_type", 8);
                bundle2.putLong("bid", j3);
                bundle2.putString("scid", str);
                if (i3 == 0) {
                    i17 = 0;
                } else {
                    i17 = -1;
                }
                bundle2.putInt(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, i17);
                VasFontIPCModule.this.callbackResult(((Integer) VasFontIPCModule.this.E.get(str)).intValue(), EIPCResult.createResult(0, bundle2));
                VasFontIPCModule.this.E.remove(str);
            }
        }
    }

    VasFontIPCModule(String str) {
        super(str);
        this.f32658d = new Vector<>();
        this.f32659e = new Vector<>();
        this.f32660f = new AtomicBoolean(false);
        this.f32661h = new AtomicBoolean(false);
        this.f32662i = new AtomicInteger(0);
        this.f32663m = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = new ConcurrentHashMap<>();
        this.E = new ConcurrentHashMap<>();
        this.F = new a();
    }

    public static synchronized VasFontIPCModule f() {
        VasFontIPCModule vasFontIPCModule;
        synchronized (VasFontIPCModule.class) {
            if (G == null) {
                G = new VasFontIPCModule("VasFontIPCModule");
            }
            vasFontIPCModule = G;
        }
        return vasFontIPCModule;
    }

    public void g(int i3, RichStatus richStatus, TipsInfo tipsInfo, int i16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "onChangeStatus result = " + i3);
        }
        if (this.f32662i.get() > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("notify_type", 5);
            bundle.putInt("result", i3);
            bundle.putInt("type", i16);
            if (tipsInfo != null && (str = tipsInfo.errorDesc) != null) {
                bundle.putString("errorDesc", str);
            }
            if (i16 == 0 && tipsInfo != null) {
                bundle.putBoolean("hasTipsInfo", false);
                if (tipsInfo.type > 0) {
                    bundle.putInt("result", tipsInfo.ret);
                    bundle.putBoolean("hasTipsInfo", true);
                    bundle.putInt("tips_type", tipsInfo.type);
                    bundle.putString("tips_titleWording", tipsInfo.titleWording);
                    bundle.putString("tips_wording", tipsInfo.wording);
                    bundle.putString("tips_rightBtnWording", tipsInfo.rightBtnWording);
                    bundle.putString("tips_leftBtnWording", tipsInfo.leftBtnWording);
                    bundle.putString("tips_vipType", tipsInfo.vipType);
                    bundle.putInt("tips_vipMonth", tipsInfo.vipMonth);
                    bundle.putString("tips_url", tipsInfo.url);
                    bundle.putInt("authAppid", tipsInfo.authAppid);
                }
            }
            callbackResult(this.f32662i.get(), EIPCResult.createResult(0, bundle));
            this.f32662i.set(0);
        }
    }

    public void h(int i3, int i16) {
        if (i3 != 1) {
            if (i3 == 4) {
                this.f32661h.set(false);
                Vector vector = new Vector(this.f32659e);
                Iterator it = vector.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Bundle bundle = new Bundle();
                    bundle.putInt("font_type", i3);
                    callbackResult(num.intValue(), EIPCResult.createResult(i16, bundle));
                }
                this.f32659e.removeAll(vector);
                return;
            }
            return;
        }
        this.f32660f.set(false);
        Vector vector2 = new Vector(this.f32658d);
        Iterator it5 = vector2.iterator();
        while (it5.hasNext()) {
            Integer num2 = (Integer) it5.next();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("font_type", i3);
            callbackResult(num2.intValue(), EIPCResult.createResult(i16, bundle2));
        }
        this.f32658d.removeAll(vector2);
    }

    public void i(int i3, int i16) {
        com.tencent.mobileqq.richstatus.a J2;
        if (this.C.get() > 0 && this.f32663m.get() > 0 && i3 == 102 && i16 == 300 && BaseApplicationImpl.getApplication() != null && (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) && (J2 = ((StatusManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.STATUS_MANAGER)).J(this.C.get())) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("notify_type", 6);
            bundle.putString("url", J2.f282297d);
            bundle.putInt("id", this.C.get());
            callbackResult(this.f32663m.get(), EIPCResult.createResult(0, bundle));
            this.f32663m.set(0);
            this.C.set(0);
            if (QLog.isColorLevel()) {
                QLog.d("Signature", 2, "IPC get action callback id = " + this.C.get() + " url = " + J2.f282297d);
            }
        }
    }

    public void j(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("Signature", 2, "onGetHistorySigNum result = " + i3);
        }
        if (this.f32662i.get() > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("notify_type", 9);
            bundle.putInt("result", i3);
            bundle.putInt("key_history_signature_num", i16);
            callbackResult(this.f32662i.get(), EIPCResult.createResult(0, bundle));
            this.f32662i.set(0);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("VasFontIPCModule", 2, "onCall action = " + str);
        }
        if (BaseApplicationImpl.getApplication() != null && (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            final QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (H.equals(str)) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.etrump.mixlayout.VasFontIPCModule.1

                    /* renamed from: com.etrump.mixlayout.VasFontIPCModule$1$a */
                    /* loaded from: classes2.dex */
                    class a implements IDownLoadListener {
                        a() {
                        }

                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
                            ((IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(1, updateListenerParams.mErrorCode);
                        }

                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
                            ((IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(1, 0);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (new File(VasSoUtils.getSoDir(1) + File.separator + FontSoBusiness.HY_FONT_SO_NAME).exists()) {
                            VasFontIPCModule.this.callbackResult(i3, EIPCResult.createResult(0, null));
                        } else {
                            VasFontIPCModule.this.f32658d.add(Integer.valueOf(i3));
                            if (VasFontIPCModule.this.f32660f.compareAndSet(false, true)) {
                                FontSoBusiness.instance.startDownloadSo(VasUpdateConstants.SCID_HYFONT_SO, new a());
                            }
                        }
                    }
                }, true);
                return null;
            }
            if (J.equals(str)) {
                ((IFontManagerService) qQAppInterface.getRuntimeService(IFontManagerService.class, "")).startDownload(bundle.getInt("id"), Integer.toString(i3), bundle.getInt("font_type"));
                return null;
            }
            if (!I.equals(str)) {
                if (K.equals(str)) {
                    int i16 = bundle.getInt("id");
                    if (i16 > 0 && !this.D.containsKey(Integer.valueOf(i16))) {
                        this.D.put(Integer.valueOf(i16), Integer.valueOf(i3));
                        String str2 = VasUpdateConstants.SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX + i16 + Sticker.JSON_SUFFIX;
                        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
                        iVasQuickUpdateService.addCallBacker(this.F);
                        iVasQuickUpdateService.downloadItem(1000L, str2, "VasFontIPCModule");
                        return null;
                    }
                    return null;
                }
                if (L.equals(str)) {
                    RichStatus R2 = ((StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).R(true);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("notify_type", 4);
                    bundle2.putSerializable("my_signature", R2);
                    callbackResult(i3, EIPCResult.createResult(0, bundle2));
                    return null;
                }
                if (M.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Signature", 2, "ACTION_CHANGE_STATUS");
                    }
                    this.f32662i.set(i3);
                    Serializable serializable = bundle.getSerializable("my_signature");
                    if (serializable instanceof RichStatus) {
                        ((StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).E((RichStatus) serializable, 0);
                        return null;
                    }
                    QLog.e("VasFontIPCModule", 1, "change status error, status is null");
                    new Bundle().putInt("notify_type", 5);
                    callbackResult(i3, EIPCResult.createResult(-102, null));
                    return null;
                }
                if (N.equals(str)) {
                    int i17 = bundle.getInt("id");
                    com.tencent.mobileqq.richstatus.a J2 = ((StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).J(i17);
                    if (J2 == null) {
                        this.f32663m.set(i3);
                        this.C.set(i17);
                        if (QLog.isColorLevel()) {
                            QLog.d("Signature", 2, "IPC get action fail, wait for callback id = " + i17);
                            return null;
                        }
                        return null;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("notify_type", 6);
                    bundle3.putString("url", J2.f282297d);
                    bundle3.putInt("id", i17);
                    callbackResult(i3, EIPCResult.createResult(0, bundle3));
                    if (QLog.isColorLevel()) {
                        QLog.d("Signature", 2, "IPC get action success id = " + i17 + " url = " + J2.f282297d);
                        return null;
                    }
                    return null;
                }
                if (P.equals(str)) {
                    long j3 = bundle.getLong("bid");
                    String string = bundle.getString("scid");
                    if (TextUtils.isEmpty(string)) {
                        callbackResult(i3, EIPCResult.createResult(-102, null));
                        return null;
                    }
                    if (this.E.containsKey(string)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putInt("notify_type", 8);
                        bundle4.putLong("bid", j3);
                        bundle4.putString("scid", string);
                        bundle4.putInt(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, 1);
                        callbackResult(i3, EIPCResult.createResult(0, bundle4));
                        return null;
                    }
                    this.E.put(string, Integer.valueOf(i3));
                    IVasQuickUpdateService iVasQuickUpdateService2 = (IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
                    iVasQuickUpdateService2.addCallBacker(this.F);
                    iVasQuickUpdateService2.downloadItem(j3, string, "VasFontIPCModule");
                    return null;
                }
                if (Q.equals(str)) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putInt("key_shield_font", VasShieldFont.f32669b);
                    callbackResult(i3, EIPCResult.createResult(0, bundle5));
                    return null;
                }
                if (R.equals(str)) {
                    long j16 = bundle.getLong("key_current_uin");
                    this.f32662i.set(i3);
                    ((StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).N(j16);
                    return null;
                }
                if (S.equals(str)) {
                    m23.c.c();
                    return null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("VasFontIPCModule", 2, "onCall action = " + str);
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
