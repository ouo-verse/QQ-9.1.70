package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.profile.o;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.w("VipWZRYTemplateHelper", 1, "ProfileCardManager download failed code:" + updateListenerParams.mErrorCode + " msg:" + updateListenerParams.mErrorMessage);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            String str = p.c() + "xydata.json";
            o.b(str);
            if (QLog.isColorLevel()) {
                QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete, parseConfig " + str);
            }
        }
    }

    public static void a(CallBacker callBacker) {
        if (e()) {
            b().addDownLoadListener(VasUpdateConstants.SCID_WZRY_TEMPLATE, new a());
            b().startDownload(VasUpdateConstants.SCID_WZRY_TEMPLATE);
        } else {
            IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "");
            iVasQuickUpdateService.addCallBacker(callBacker);
            iVasQuickUpdateService.downloadItem(15L, VasUpdateConstants.SCID_WZRY_TEMPLATE, "ProfileCard");
        }
    }

    private static QQVasUpdateBusiness b() {
        try {
            return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 15L);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        if (e()) {
            return b().getSavePath(VasUpdateConstants.SCID_WZRY_TEMPLATE) + File.separator;
        }
        return ProfileCardTemplateUtil.d() + "wzryTemplate/";
    }

    public static boolean d(String str) {
        boolean z16;
        if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
            String c16 = c();
            File file = new File(c16, "xydata.json");
            if (o.f260268b == null) {
                o.b(file.getAbsolutePath());
            }
            if (o.f260268b != null) {
                File file2 = new File(c16, "logo.png");
                File file3 = new File(c16, "bgImage.jpg");
                File file4 = new File(c16, "shimmer_mask.png");
                File file5 = new File(c16, "logo_bg.png");
                File file6 = new File(c16, "font_chs.tff");
                File file7 = new File(c16, "font_num.tff");
                File file8 = new File(c16, "addIcon.png");
                if (file2.exists() && file3.exists() && file4.exists() && file5.exists() && file6.exists() && file7.exists() && file8.exists()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                o oVar = o.f260268b;
                if (oVar.f260269a != null) {
                    for (int i3 = 0; i3 < oVar.f260269a.size(); i3++) {
                        o.a valueAt = oVar.f260269a.valueAt(i3);
                        o.b bVar = valueAt.f260274e;
                        if (bVar != null && !TextUtils.isEmpty(bVar.f260275a)) {
                            String str2 = valueAt.f260274e.f260275a;
                            if (str2.contains("/")) {
                                str2 = str2.substring(str2.lastIndexOf("/"));
                            }
                            File file9 = new File(c16, str2);
                            if (z16 && file9.exists()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                        }
                    }
                    return z16;
                }
            }
        }
        return false;
    }

    private static boolean e() {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(15L).booleanValue() && b() != null) {
            return true;
        }
        return false;
    }

    public static boolean f(long j3) {
        if (j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC && j3 != ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
            return false;
        }
        return true;
    }

    public static void g(String str, String str2, int i3) {
        if (i3 == 0) {
            if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                String str3 = c() + "xydata.json";
                o.b(str3);
                if (QLog.isColorLevel()) {
                    QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete, parseConfig " + str3);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete failed, errorCode = " + i3);
        }
    }
}
