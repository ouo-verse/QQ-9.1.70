package com.tencent.mobileqq.activity.contacts.base.tabs;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String[] f181543a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f181544b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<f> f181545c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f181546d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f181547e;

    public b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.f181545c = new ArrayList<>();
        this.f181547e = false;
        this.f181546d = z16;
        a();
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f181545c.clear();
        this.f181545c.add(new f(6, R.id.b8k, HardCodeUtil.qqStr(R.string.l3b)));
        this.f181545c.add(new f(1, R.id.b8j, HardCodeUtil.qqStr(R.string.l2j)));
        this.f181545c.add(new f(2, R.id.b8o, HardCodeUtil.qqStr(R.string.l3o)));
        boolean t16 = StudyModeManager.t();
        boolean j3 = ElderModeManager.j();
        if (!t16 && !j3) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_contact_switch", true);
            if (QLog.isColorLevel()) {
                QLog.i("ContactsTabs", 1, "guildContactSwitch:" + isSwitchOn);
            }
            if (isSwitchOn) {
                this.f181545c.add(new f(8, R.id.f164895u63, HardCodeUtil.qqStr(R.string.f212135mp)));
            }
        }
        if (this.f181547e && !t16) {
            this.f181545c.add(new f(7, R.id.f164896u64, HardCodeUtil.qqStr(R.string.f212145mq)));
        }
        this.f181545c.add(new f(3, R.id.b8h, HardCodeUtil.qqStr(R.string.l39)));
        this.f181545c.add(new f(4, R.id.b8l, HardCodeUtil.qqStr(R.string.f171806l35)));
        boolean isSwitchOn2 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101896", true);
        if (!t16 && !isSwitchOn2) {
            this.f181545c.add(new f(5, R.id.b8m, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle()));
        }
        int size = this.f181545c.size();
        this.f181543a = new String[size];
        this.f181544b = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            this.f181544b[i3] = this.f181545c.get(i3).f181555b;
            this.f181543a[i3] = this.f181545c.get(i3).f181556c;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactsTabs", 2, "buildData tabSize:" + size + " isDisablePubAccount:" + isSwitchOn2 + ", showRobot: " + this.f181547e + ", isStudyMode:" + t16);
        }
    }

    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        if (i3 >= 0 && i3 < this.f181545c.size()) {
            return this.f181545c.get(i3).f181554a;
        }
        return 1;
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        for (int i16 = 0; i16 < this.f181545c.size(); i16++) {
            if (this.f181545c.get(i16).f181554a == i3) {
                return i16;
            }
        }
        return -1;
    }

    public boolean d(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (z16 == this.f181546d && z17 == this.f181547e) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactsTabs", 2, "update  tabSize:" + this.f181545c.size());
            }
            return false;
        }
        this.f181546d = z16;
        this.f181547e = z17;
        a();
        return true;
    }
}
