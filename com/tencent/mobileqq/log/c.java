package com.tencent.mobileqq.log;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.z;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$WebViewConfigReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$WebViewConfigRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static final String f241766m;

    /* renamed from: d, reason: collision with root package name */
    Set<String> f241767d;

    /* renamed from: e, reason: collision with root package name */
    boolean f241768e;

    /* renamed from: f, reason: collision with root package name */
    boolean f241769f;

    /* renamed from: h, reason: collision with root package name */
    QQAppInterface f241770h;

    /* renamed from: i, reason: collision with root package name */
    private int f241771i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72775);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f241766m = c.class.getSimpleName();
        }
    }

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f241767d = new HashSet();
        this.f241768e = false;
        this.f241769f = false;
        this.f241771i = 0;
        this.f241770h = qQAppInterface;
    }

    private void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            File file = new File(this.f241770h.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.f241747l);
            if (!file.exists() && !file.mkdirs()) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebCoreDump", 2, "Can't create dir: " + file);
                    return;
                }
                return;
            }
            jSONObject.put("js_report", this.f241768e);
            jSONObject.put("url_check", this.f241769f);
            if (this.f241767d.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.f241767d.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(it.next());
                }
                jSONObject.put("url_list", jSONArray);
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreDump", 2, "Http capture white list=" + this.f241767d);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 2, "-->url white list is empty!");
            }
            if (this.f241771i > 0) {
                SharedPreferences preferences = this.f241770h.getPreferences();
                long currentTimeMillis = System.currentTimeMillis() + (this.f241771i * 1000);
                preferences.edit().putLong("nextCheckWebviewTime", currentTimeMillis).commit();
                if (QLog.isColorLevel()) {
                    String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis));
                    QLog.d(f241766m, 2, "handleCheckUpdateItemData nextCheckUpdateTime" + format);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f241770h.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.f241747l + this.f241770h.getCurrentAccountUin() + "config.json"));
            fileOutputStream.write(jSONObject.toString().getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("WebCoreDump", 2, "-->save config failed:" + e16.toString());
            }
        } catch (IOException e17) {
            if (QLog.isColorLevel()) {
                QLog.w("WebCoreDump", 2, "-->save config failed:" + e17.toString());
            }
        } catch (JSONException e18) {
            if (QLog.isColorLevel()) {
                QLog.w("WebCoreDump", 2, "-->save config failed:" + e18.toString());
            }
        }
    }

    public boolean b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            long j3 = this.f241770h.getPreferences().getLong("nextCheckWebviewTime", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(j3));
                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis));
                String str = f241766m;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isSendTemplateCheckUpdate nextCheckUpdateTime=");
                sb5.append(format);
                sb5.append(",systemTimestamp=");
                sb5.append(format2);
                sb5.append(",isSend=");
                if (currentTimeMillis > j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(str, 2, sb5.toString());
            }
            File file = new File(this.f241770h.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.f241747l + this.f241770h.getCurrentAccountUin() + "config.json");
            if (currentTimeMillis <= j3) {
                if (file.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(f241766m, 2, "Can't handle JS log and HTTP capture white list config: " + e16);
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (!b()) {
            return null;
        }
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 126;
        PreloadInfoCheckUpdate$WebViewConfigReq preloadInfoCheckUpdate$WebViewConfigReq = new PreloadInfoCheckUpdate$WebViewConfigReq();
        PreloadInfoCheckUpdate$ControlReqHead preloadInfoCheckUpdate$ControlReqHead = new PreloadInfoCheckUpdate$ControlReqHead();
        preloadInfoCheckUpdate$ControlReqHead.protocol_ver.set(1);
        preloadInfoCheckUpdate$ControlReqHead.client_plat_id.set(109);
        preloadInfoCheckUpdate$ControlReqHead.client_ver.set(AppSetting.f99554n);
        preloadInfoCheckUpdate$ControlReqHead.os_ver.set(AppSetting.f99543c);
        preloadInfoCheckUpdate$ControlReqHead.uin.set(Long.parseLong(this.f241770h.getCurrentAccountUin()));
        preloadInfoCheckUpdate$WebViewConfigReq.head.set(preloadInfoCheckUpdate$ControlReqHead);
        byte[] byteArray = preloadInfoCheckUpdate$WebViewConfigReq.toByteArray();
        int length = byteArray.length;
        int i16 = length + 4;
        byte[] bArr = new byte[i16];
        System.arraycopy(z.d(i16), 0, bArr, 0, 4);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        reqItem.vecParam = bArr;
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        if (respItem == null || respItem.eServiceID != 126) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f241766m, 2, "handleCheckUpdateItemData respitem.cResult:" + ((int) respItem.cResult));
        }
        this.f241768e = false;
        this.f241769f = false;
        this.f241767d.clear();
        byte b16 = respItem.cResult;
        byte[] bArr = respItem.vecUpdate;
        if (b16 == 2 && bArr.length > 4) {
            int longData = ((int) PkgTools.getLongData(bArr, 0)) - 4;
            byte[] bArr2 = new byte[longData];
            PkgTools.copyData(bArr2, 0, bArr, 4, longData);
            try {
                PreloadInfoCheckUpdate$WebViewConfigRsp preloadInfoCheckUpdate$WebViewConfigRsp = new PreloadInfoCheckUpdate$WebViewConfigRsp();
                preloadInfoCheckUpdate$WebViewConfigRsp.mergeFrom(bArr2);
                if (preloadInfoCheckUpdate$WebViewConfigRsp.head.code.get() == 0) {
                    this.f241768e = preloadInfoCheckUpdate$WebViewConfigRsp.js_report.get();
                    this.f241769f = preloadInfoCheckUpdate$WebViewConfigRsp.url_check.get();
                    this.f241767d.addAll(preloadInfoCheckUpdate$WebViewConfigRsp.url_list.get());
                    this.f241771i = preloadInfoCheckUpdate$WebViewConfigRsp.interval.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("WebCoreDump", 2, "handleCheckUpdateItemData IsReportLog" + this.f241768e + ", Url_Check=" + this.f241769f + ", interval=" + this.f241771i);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreDump", 2, "-->exception during handle checkup data:" + e16.toString());
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("WebCoreDump", 2, "-->checkup error:result=" + ((int) b16) + ",data length:" + bArr.length);
        }
        a();
        if (VipWebViewReportLog.f241752q.get() != 1) {
            VipWebViewReportLog.f241737b = this.f241767d;
            VipWebViewReportLog.f241738c = this.f241768e;
            VipWebViewReportLog.f241739d = this.f241769f;
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 2, "Update VipWebViewReportLog members");
            }
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 5;
    }
}
