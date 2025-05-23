package com.tencent.mobileqq.troop.avatar;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static String f294527k;

    /* renamed from: l, reason: collision with root package name */
    public static int f294528l;

    /* renamed from: a, reason: collision with root package name */
    public String f294529a;

    /* renamed from: b, reason: collision with root package name */
    public String f294530b;

    /* renamed from: c, reason: collision with root package name */
    public int f294531c;

    /* renamed from: d, reason: collision with root package name */
    public int f294532d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f294533e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f294534f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f294535g;

    /* renamed from: h, reason: collision with root package name */
    public String f294536h;

    /* renamed from: i, reason: collision with root package name */
    public int f294537i;

    /* renamed from: j, reason: collision with root package name */
    public long f294538j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f294527k = "-5";
            f294528l = -5;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f294537i = 0;
        }
    }

    public static final boolean a(List<a> list, List<a> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!list.get(i3).equals(list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final a b(TroopClipPic troopClipPic, Set<String> set) {
        a aVar = new a();
        String str = troopClipPic.f203184id;
        aVar.f294530b = str;
        aVar.f294536h = troopClipPic.clipInfo;
        aVar.f294537i = troopClipPic.type;
        aVar.f294531c = 1;
        if (set != null) {
            aVar.f294534f = set.contains(str);
        }
        return aVar;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!Utils.p(this.f294530b, aVar.f294530b) || !Utils.p(this.f294529a, aVar.f294529a) || this.f294531c != aVar.f294531c || this.f294533e != aVar.f294533e || this.f294534f != aVar.f294534f || this.f294535g != aVar.f294535g || !Utils.p(this.f294536h, aVar.f294536h) || this.f294537i != aVar.f294537i || this.f294538j != aVar.f294538j) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AvatarInfo=[seq" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294530b + " " + IProfileCardConst.KEY_FROM_TYPE + ContainerUtils.KEY_VALUE_DELIMITER + this.f294531c + " type" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294537i + " isUploading" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294533e + " isVerifying" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294534f + " clipInfo" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294536h + " ts" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294538j + " localFile" + ContainerUtils.KEY_VALUE_DELIMITER + this.f294529a + "]";
    }
}
