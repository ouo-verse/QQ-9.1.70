package com.tencent.mobileqq.leba.controller.list;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.controller.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C7962a extends LebaRedTouchBase {
        static IPatchRedirector $redirector_;

        public C7962a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
        public BusinessInfoCheckUpdate.AppInfo c(AppRuntime appRuntime, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) str);
            }
            if (!TextUtils.isEmpty(str) && String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_KANDIAN).equals(str)) {
                return null;
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, str);
            if (RedTouch.hasRedTouch(appInfo) && appInfo.type.get() != 5 && appInfo.red_display_info.has() && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.has() && appInfo.red_display_info.red_type_info.get() != null) {
                int i3 = appInfo.type.get();
                StringBuilder sb5 = new StringBuilder("getAppInfoByResId resId=");
                sb5.append(str);
                sb5.append(",type=");
                sb5.append(i3);
                if (i3 == 11 || i3 == 16 || i3 == 17) {
                    appInfo.type.set(0);
                }
                for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
                    sb5.append(",info.red_type=");
                    sb5.append(redTypeInfo.red_type.get());
                    sb5.append(",info.red_content=");
                    sb5.append(redTypeInfo.red_content.get());
                    m(redTypeInfo);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.lebatab.LebaRedTouchBase", 1, sb5.toString());
                }
            }
            return appInfo;
        }

        @Override // com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
        public void d(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) redTouch, (Object) appInfo);
            } else {
                redTouch.parseRedTouch(appInfo);
                redTouch.handleLebaListRedTouch(appInfo);
            }
        }

        public void m(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
            String n3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) redTypeInfo);
                return;
            }
            int i3 = redTypeInfo.red_type.get();
            int i16 = 0;
            if (i3 != 11 && i3 != 17) {
                if (i3 == 16) {
                    redTypeInfo.red_type.set(4);
                    String str = redTypeInfo.red_content.get();
                    if (!TextUtils.isEmpty(str)) {
                        if (str.indexOf(RedTouch.NEWLINE_CHAR) == 7) {
                            n3 = str.substring(0, 7) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                        } else {
                            n3 = n(str.replace(RedTouch.NEWLINE_CHAR, "\uff0c"));
                        }
                        redTypeInfo.red_content.set(n3);
                        return;
                    }
                    return;
                }
                if (i3 == 4) {
                    String str2 = redTypeInfo.red_content.get();
                    if (!TextUtils.isEmpty(str2)) {
                        redTypeInfo.red_content.set(n(str2));
                        return;
                    }
                    return;
                }
                if (i3 == 9) {
                    try {
                        i16 = Integer.parseInt(redTypeInfo.red_content.get());
                    } catch (Exception e16) {
                        QLog.e("Q.lebatab.LebaRedTouchBase", 1, e16, new Object[0]);
                    }
                    if (i16 <= 0) {
                        redTypeInfo.red_content.set("8");
                        return;
                    }
                    return;
                }
                return;
            }
            redTypeInfo.red_type.set(0);
        }

        public String n(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            if (str.length() <= 8) {
                return str;
            }
            return str.substring(0, 8) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
    }

    public static void a(View view) {
        View findViewById = view.findViewById(R.id.e6t);
        findViewById.setBackgroundResource(R.drawable.skin_searchbar_bg_theme_version2);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById.findViewById(R.id.ibm);
        roundRelativeLayout.f316195e = ViewUtils.dpToPx(16.0f);
        roundRelativeLayout.setVisibility(8);
        findViewById.findViewById(R.id.et_search_keyword).setBackgroundResource(R.drawable.skin_searchbar_input_theme_version2);
    }
}
