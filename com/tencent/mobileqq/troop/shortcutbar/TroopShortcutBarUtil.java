package com.tencent.mobileqq.troop.shortcutbar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xece.oidb_0xece$App;
import tencent.im.oidb.cmd0xece.oidb_0xece$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShortcutBarUtil {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f298609a;

        /* renamed from: b, reason: collision with root package name */
        public long f298610b;

        /* renamed from: c, reason: collision with root package name */
        public String f298611c;

        /* renamed from: d, reason: collision with root package name */
        public String f298612d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f298609a = 0L;
            this.f298610b = 0L;
            this.f298611c = "";
            this.f298612d = "";
        }

        String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.f298609a);
                jSONObject.put("appType", this.f298610b);
                String str = this.f298611c;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                jSONObject.put("appName", str);
                String str3 = this.f298612d;
                if (str3 != null) {
                    str2 = str3;
                }
                jSONObject.put("appJumpUrl", str2);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "appId:" + this.f298609a + " appType:" + this.f298610b + " appName:" + this.f298611c + " appJumpUrl:" + this.f298612d + " ";
        }
    }

    public static void a(QQAppInterface qQAppInterface, String str, a aVar) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.f298611c) && !TextUtils.isEmpty(aVar.f298612d)) {
            TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) qQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            long i3 = troopShortcutBarManager.i(str);
            if (i3 != 0) {
                c(qQAppInterface, str, i3);
            }
            String string = BaseApplication.getContext().getResources().getString(R.string.f236727f5);
            String string2 = BaseApplication.getContext().getResources().getString(R.string.f236737f6);
            String string3 = BaseApplication.getContext().getResources().getString(R.string.f236757f8);
            String string4 = BaseApplication.getContext().getResources().getString(R.string.f236747f7);
            String str2 = string + aVar.f298611c + string2 + string3 + string4;
            g gVar = new g(str, str, str2, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 131091, com.tencent.mobileqq.service.message.e.K0());
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 62);
            bundle.putString("textColor", "#40A0FF");
            bundle.putString("key_action_DATA", aVar.a());
            gVar.b(string.length(), string.length() + aVar.f298611c.length(), bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_action", 63);
            bundle2.putString("textColor", "#40A0FF");
            bundle2.putString("key_action_DATA", aVar.a());
            gVar.b(string.length() + aVar.f298611c.length() + string2.length(), str2.length() - string4.length(), bundle2);
            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
            messageForUniteGrayTip.createMessageUniseq();
            messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
            com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
            troopShortcutBarManager.u(str, messageForUniteGrayTip.uniseq);
        }
    }

    public static a b(oidb_0xece$RspBody oidb_0xece_rspbody) {
        List<oidb_0xece$App> list;
        if (oidb_0xece_rspbody == null || !oidb_0xece_rspbody.active_app_tips.has() || !oidb_0xece_rspbody.active_app_tips.get().apps.has() || (list = oidb_0xece_rspbody.active_app_tips.get().apps.get()) == null || list.size() <= 0) {
            return null;
        }
        oidb_0xece$App oidb_0xece_app = list.get(0);
        a aVar = new a();
        aVar.f298609a = oidb_0xece_app.appid.get();
        aVar.f298611c = oidb_0xece_app.app_name.get();
        aVar.f298610b = oidb_0xece_app.source.get();
        aVar.f298612d = oidb_0xece_app.url.get();
        return aVar;
    }

    private static void c(QQAppInterface qQAppInterface, String str, long j3) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable(str, j3) { // from class: com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil.1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f298607e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f298608f;

                {
                    this.f298607e = str;
                    this.f298608f = j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QQAppInterface.this, str, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQAppInterface.this.getMessageFacade().T1(this.f298607e, 1, this.f298608f);
                    }
                }
            }, 32, null, true);
        }
    }
}
