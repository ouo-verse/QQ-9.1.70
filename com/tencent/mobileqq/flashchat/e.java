package com.tencent.mobileqq.flashchat;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.aio.RichTextChatConfParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements Manager {
    static IPatchRedirector $redirector_;
    private String C;
    private boolean D;
    private int E;
    private String F;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    private String f209840d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f209841e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Integer> f209842f;

    /* renamed from: h, reason: collision with root package name */
    private int f209843h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f209844i;

    /* renamed from: m, reason: collision with root package name */
    private String f209845m;

    public e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f209840d = "";
        this.f209841e = false;
        this.f209842f = new ArrayList<>();
        this.f209843h = 0;
        this.f209845m = HardCodeUtil.qqStr(R.string.t1u);
        this.C = HardCodeUtil.qqStr(R.string.t1v);
        this.E = 0;
        this.F = "";
        this.G = "";
        this.f209842f.clear();
        this.f209844i = ea.p1(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
    }

    public static e d(QQAppInterface qQAppInterface) {
        return (e) qQAppInterface.getManager(QQManagerFactory.RICH_TEXT_CHAT_MANAGER);
    }

    private boolean o(String str) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("first_insatll_entry", 0);
            this.f209843h = optInt;
            if (optInt < 0 || optInt >= 6) {
                this.f209843h = 0;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("enrty_orders");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    int i16 = optJSONArray.getInt(i3);
                    if (i16 >= 0 && i16 < 6) {
                        arrayList.add(Integer.valueOf(i16));
                    }
                }
            }
            synchronized (this.f209842f) {
                this.f209842f.clear();
                this.f209842f.addAll(arrayList);
                p(this.f209842f);
            }
            String optString = jSONObject.optString("zhitu_title");
            String optString2 = jSONObject.optString("zhitu_legal_wording");
            if (jSONObject.has("aio_input_shan_icon_url1")) {
                this.F = jSONObject.optString("aio_input_shan_icon_url1");
            }
            if (jSONObject.has("aio_input_shan_icon_url2")) {
                this.G = jSONObject.optString("aio_input_shan_icon_url2");
            }
            if (jSONObject.optInt("zhitu_legal_switch") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.D = z16;
            this.E = jSONObject.optInt("zhitu_style", 0);
            if (!TextUtils.isEmpty(optString)) {
                this.f209845m = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.C = optString2;
            }
            this.f209841e = true;
            return true;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("RichTextChatManager", 2, e16, new Object[0]);
            }
            this.f209841e = true;
            return false;
        }
    }

    private static ArrayList p(ArrayList<Integer> arrayList) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(Integer.valueOf(it.next().intValue()));
        }
        arrayList.clear();
        Iterator it5 = linkedHashSet.iterator();
        while (it5.hasNext()) {
            arrayList.add((Integer) it5.next());
        }
        return arrayList;
    }

    public void a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        String account = appRuntime.getAccount();
        if (!this.f209841e || !this.f209840d.equals(account)) {
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(RichTextChatConfParser.f202275f);
            this.f209840d = account;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("RichTextChatManager", 4, "first install entry:" + this.f209843h + " mOder:" + this.f209842f);
        }
    }

    public ArrayList<Integer> b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        }
        a(appRuntime);
        return this.f209842f;
    }

    public int c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime)).intValue();
        }
        a(appRuntime);
        return this.f209843h;
    }

    public int e(QQAppInterface qQAppInterface, ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQAppInterface, (Object) arrayList)).intValue();
        }
        int c16 = com.tencent.mobileqq.core.util.b.c(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
            QLog.d("RichTextChatManager", 2, "last Memoried Tab:" + c16);
        }
        if (c16 == -1) {
            if (!ea.o1(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin())) {
                int indexOf = arrayList.indexOf(Integer.valueOf(c(qQAppInterface)));
                ea.M4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), true);
                if (QLog.isColorLevel()) {
                    QLog.d("RichTextChatManager", 2, "Accourding to : selectedTab:" + c16);
                }
                if (indexOf != -1) {
                    return indexOf;
                }
            }
            return 0;
        }
        int indexOf2 = arrayList.indexOf(Integer.valueOf(c16));
        if (QLog.isColorLevel()) {
            QLog.d("RichTextChatManager", 2, "Accourding to orderlist, currentTabPosition:" + indexOf2);
        }
        if (-1 == indexOf2) {
            return 0;
        }
        return indexOf2;
    }

    public boolean f(AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime)).booleanValue();
        }
        synchronized (this.f209842f) {
            ArrayList<Integer> b16 = b(appRuntime);
            z16 = false;
            if (b16 != null) {
                Iterator<Integer> it = b16.iterator();
                while (it.hasNext()) {
                    if (it.next().intValue() == 0) {
                        z16 = true;
                    }
                }
            }
        }
        return z16;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.C;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f209845m;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.E;
    }

    public void j(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("RichTextChatManager", 1, "config content is null , do nothing");
            }
        } else if (o(str)) {
            ea.L4(qQAppInterface.getApp(), qQAppInterface.getAccount(), str);
        } else if (QLog.isColorLevel()) {
            QLog.d("RichTextChatManager", 1, "config content parse error , do nothing");
        }
    }

    public boolean k(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        if (n(qQAppInterface) && this.f209844i) {
            return true;
        }
        return false;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f209844i;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public boolean n(QQAppInterface qQAppInterface) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106065", false);
        if (isSwitchOn) {
            QLog.i("RichTextChatManager", 1, "remoteZhituEntrySwitch:" + isSwitchOn);
            return false;
        }
        ArrayList<Integer> b16 = d(qQAppInterface).b(qQAppInterface);
        if (b16.size() <= 0) {
            return false;
        }
        FlashChatManager flashChatManager = (FlashChatManager) qQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        synchronized (this.f209842f) {
            Iterator<Integer> it = b16.iterator();
            z16 = false;
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue == 1) {
                    if (flashChatManager.l().size() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z16 |= z17;
                } else if (intValue == 0) {
                    z16 |= true;
                } else {
                    if (intValue != 3 && intValue != 4 && intValue != 5) {
                    }
                    z16 = true;
                }
            }
        }
        return z16;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void q(boolean z16, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), qQAppInterface);
        } else {
            this.f209844i = z16;
            ea.N4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), z16);
        }
    }
}
