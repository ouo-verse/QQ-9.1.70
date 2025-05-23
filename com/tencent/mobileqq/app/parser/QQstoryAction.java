package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQstoryAction extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private QQAppInterface Q;

    public QQstoryAction(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        } else {
            this.Q = qQAppInterface;
        }
    }

    private boolean F() {
        boolean booleanValue = ((Boolean) ((com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10)).j("key_share_encrypt_flag", Boolean.FALSE)).booleanValue();
        if (TextUtils.isEmpty(this.f307441f.get("token")) && !TextUtils.equals(this.f307440e, "publish") && booleanValue && !TextUtils.equals(this.f307440e, "publish")) {
            this.f307440e = "open";
            od0.a.a(this.f307441f);
        }
        I();
        return true;
    }

    private String G(String str, String str2) {
        if (this.f307441f.containsKey(str)) {
            return this.f307441f.get(str);
        }
        return str2;
    }

    private boolean I() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_STORY_VIDEO_SETTING, QzoneConfig.SECONDARY_JUMP_HYWS_SCHEME_ENABLE, 0) == 0 && BaseApplication.getContext() != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.parser.QQstoryAction.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQstoryAction.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), 1, R.string.fuq, 0).show();
                    }
                }
            });
            return false;
        }
        QLog.e("QQstoryAction", 1, "qqstory is deleted!!");
        return false;
    }

    public boolean H() {
        String str;
        String str2;
        String str3;
        boolean z16;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Context context = this.f307437b;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            str = intent.getStringExtra("big_brother_source_key");
            str2 = intent.getDataString();
        } else {
            str = null;
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f307438c;
        }
        String G = G("roomid", "0");
        String G2 = G("fromid", "");
        String G3 = G("roomtype", "");
        String G4 = G("list_name", "");
        String G5 = G("first_jump_mode", "h5");
        String str4 = str;
        String G6 = G("need_record", "1");
        String G7 = G("is_record", "0");
        String str5 = str2;
        String G8 = G("enter_record_if_finish", "1");
        String G9 = G("nowapp_ext", "");
        String G10 = G("nowplugin_ext", "");
        String G11 = G("h5_ext", "");
        String G12 = G("shakespearetime", "");
        String G13 = G("hostloading_percent", "0");
        if (!this.f307441f.containsKey("msgurl")) {
            str3 = "";
        } else {
            str3 = com.tencent.mobileqq.utils.ax.E(this.f307441f.get("msgurl"));
        }
        String str6 = str3;
        String str7 = this.f307441f.get("coverurl");
        String str8 = this.f307441f.get("extras");
        this.f307441f.get("bid");
        this.f307441f.get(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
        Bundle bundle = new Bundle();
        bundle.putString("coverurl", str7);
        bundle.putString("roomid", G);
        bundle.putString("roomtype", G3);
        bundle.putString("extras_from_js", str8);
        bundle.putBoolean("can_use_h5_first", true);
        bundle.putString("first_jump_mode", G5);
        bundle.putString("is_record", G7);
        bundle.putString("enter_record_if_finish", G8);
        bundle.putString("nowapp_ext", G9);
        bundle.putString("nowplugin_ext", G10);
        bundle.putString("h5_ext", G11);
        bundle.putString("shakespearetime", G12);
        bundle.putString("fromid", G2);
        bundle.putString("url", str6);
        bundle.putString("listname", G4);
        bundle.putString("mqqScheme", str5);
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString("big_brother_source_key", str4);
        }
        if (!TextUtils.isEmpty(G6) && "0".equals(G6)) {
            z16 = false;
        } else {
            z16 = true;
        }
        bundle.putBoolean("need_record", z16);
        if (this.f307441f.containsKey("topic")) {
            bundle.putString("topic", this.f307441f.get("topic"));
        }
        if (this.f307441f.containsKey("story_ext")) {
            bundle.putString("story_ext", this.f307441f.get("story_ext"));
        }
        if (this.f307441f.containsKey("startsrc")) {
            bundle.putString("startsrc", this.f307441f.get("startsrc"));
        }
        if (this.f307441f.containsKey("hostloading_percent")) {
            bundle.putInt("hostloading_percent", Integer.valueOf(G13).intValue());
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, "\u65e0\u7f51\u7edc\u8fde\u63a5\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
            return false;
        }
        try {
            ((com.tencent.mobileqq.intervideo.now.dynamic.b) this.Q.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c(bundle);
            QLog.i("QQstoryAction", 1, "enter now plugin use shadow");
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQstoryAction", 2, e16.toString());
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            if ("openNow".equals(this.f307440e)) {
                return H();
            }
            return F();
        } catch (Exception e16) {
            QLog.e("QQstoryAction", 1, "doAction error: " + e16.getMessage());
            i("QQstoryAction");
            return false;
        }
    }
}
