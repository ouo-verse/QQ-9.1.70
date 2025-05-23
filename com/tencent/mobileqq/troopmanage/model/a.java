package com.tencent.mobileqq.troopmanage.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$Entrance;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x934.cmd0x934$Item;
import tencent.im.oidb.cmd0x934.cmd0x934$ItemInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f303147a;

    /* renamed from: b, reason: collision with root package name */
    public String f303148b;

    /* renamed from: c, reason: collision with root package name */
    public String f303149c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f303150d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f303151e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f303152f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f303153g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a(IntelligentManageSvrPB$Entrance intelligentManageSvrPB$Entrance) {
        String str;
        boolean z16;
        a aVar = null;
        if (intelligentManageSvrPB$Entrance == null) {
            return null;
        }
        String str2 = "";
        if (!intelligentManageSvrPB$Entrance.title.has()) {
            str = "";
        } else {
            str = intelligentManageSvrPB$Entrance.title.get();
        }
        if (intelligentManageSvrPB$Entrance.url.has()) {
            str2 = intelligentManageSvrPB$Entrance.url.get();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            aVar = new a();
            aVar.f303147a = intelligentManageSvrPB$Entrance.hashCode();
            aVar.f303148b = str;
            aVar.f303149c = str2;
            boolean z17 = false;
            aVar.f303150d = false;
            if (intelligentManageSvrPB$Entrance.need_guanjia_admin.has() && intelligentManageSvrPB$Entrance.need_guanjia_admin.get()) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.f303152f = z16;
            if (intelligentManageSvrPB$Entrance.privilege.has() && intelligentManageSvrPB$Entrance.privilege.get() == 1) {
                z17 = true;
            }
            aVar.f303153g = z17;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSmartManager", 2, "buildFromEntrance: " + aVar);
        }
        return aVar;
    }

    public static a b(cmd0x934$Item cmd0x934_item, String str) {
        cmd0x934$ItemInfo cmd0x934_iteminfo;
        String str2;
        int i3;
        boolean z16;
        a aVar = null;
        if (cmd0x934_item == null) {
            return null;
        }
        if (cmd0x934_item.off_info.has()) {
            cmd0x934_iteminfo = cmd0x934_item.off_info.get();
        } else {
            cmd0x934_iteminfo = null;
        }
        String str3 = "";
        if (cmd0x934_iteminfo == null || !cmd0x934_iteminfo.title.has()) {
            str2 = "";
        } else {
            str2 = cmd0x934_iteminfo.title.get();
        }
        if (cmd0x934_item.f435981id.has()) {
            i3 = cmd0x934_item.f435981id.get();
        } else {
            i3 = 0;
        }
        if (cmd0x934_item.setting_url.has()) {
            str3 = cmd0x934_item.setting_url.get();
        }
        String str4 = str3;
        if (cmd0x934_item.is_set.has() && cmd0x934_item.is_set.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
            aVar = new a();
            aVar.f303147a = i3;
            aVar.f303148b = str2;
            aVar.f303149c = ((ITroopLinkApi) QRoute.api(ITroopLinkApi.class)).getSmartManagerUrl(str4, str, ITroopIntelligentManageApi.SMART_MANAGER_REBOOT_UIN, i3);
            aVar.f303151e = z16;
            aVar.f303150d = true;
            aVar.f303153g = false;
        } else {
            QLog.e("TroopSmartManager", 1, "buildFrom error id: " + i3 + ", url: " + str4 + ", title: " + str2 + ", isSet: " + z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSmartManager", 2, "buildFrom: " + aVar);
        }
        return aVar;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SmartManagerItem{id=" + this.f303147a + ", title='" + this.f303148b + "', url='" + this.f303149c + "', needSetStatus='" + this.f303150d + "', isSet=" + this.f303151e + ", needAdminRole=" + this.f303152f + ", onlyOwnerCanShow=" + this.f303153g + '}';
    }
}
