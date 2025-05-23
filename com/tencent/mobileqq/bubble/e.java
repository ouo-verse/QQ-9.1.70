package com.tencent.mobileqq.bubble;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f200738a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f200739b;

    /* renamed from: c, reason: collision with root package name */
    private final LruCache<String, Bitmap> f200740c;

    /* renamed from: d, reason: collision with root package name */
    private final BubbleManager f200741d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BubbleManager bubbleManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bubbleManager);
            return;
        }
        this.f200738a = 0;
        this.f200739b = null;
        this.f200741d = bubbleManager;
        this.f200740c = new LruCache<>(10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] a(int i3) {
        String str = this.f200741d.B(i3).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread1.png";
        String str2 = this.f200741d.B(i3).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread2.png";
        String str3 = this.f200741d.B(i3).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread3.png";
        if (new File(str).exists() && new File(str2).exists() && new File(str3).exists()) {
            return new String[]{str, str2, str3};
        }
        return null;
    }

    public void b(boolean z16) {
        AppInterface appInterface;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        boolean z17 = true;
        if (VasNormalToggle.VAS_BUG_UNREAD_BUBBLE.isEnable(true) || (appInterface = this.f200741d.f200578e) == null) {
            return;
        }
        if (!d()) {
            z16 = true;
        }
        if (z16 != c()) {
            if (z16) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.f200738a = i3;
            SharedPreferences.Editor edit = appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0).edit();
            if (i3 != 1) {
                z17 = false;
            }
            edit.putBoolean(AppConstants.Preferences.SVIP_BUBBLE_UNREAD_SWITCH, z17).apply();
            VipInfoHandler vipInfoHandler = (VipInfoHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
            if (vipInfoHandler != null) {
                vipInfoHandler.Y2(z16);
            }
        }
        QLog.d("BubbleManager", 2, "setBubbleUnreadShow " + z16);
    }

    public boolean c() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (VasNormalToggle.VAS_BUG_UNREAD_BUBBLE.isEnable(true)) {
            return true;
        }
        AppInterface appInterface = this.f200741d.f200578e;
        if (appInterface == null) {
            return false;
        }
        if (this.f200738a == 0) {
            if (appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin(), 0).getBoolean(AppConstants.Preferences.SVIP_BUBBLE_UNREAD_SWITCH, true)) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            this.f200738a = i3;
        }
        QLog.d("BubbleManager", 2, "showBubbleUnread " + this.f200738a);
        if (this.f200738a == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!VasNormalToggle.VAS_BUG_UNREAD_BUBBLE.isEnable(true) && QzoneConfig.getInstance().getConfig("K_QQ_VAS", QzoneConfig.SECONDARY_BUBBLE_UNREAD_SWITCH, 0) == 1) {
            return true;
        }
        return false;
    }
}
