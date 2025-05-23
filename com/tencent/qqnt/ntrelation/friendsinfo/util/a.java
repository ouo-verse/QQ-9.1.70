package com.tencent.qqnt.ntrelation.friendsinfo.util;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.c;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bJ,\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\bJ,\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\bJ,\u0010\u0012\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\bJ,\u0010\u0014\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\bJ,\u0010\u0016\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\bJ,\u0010\u0018\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\bJ,\u0010\u001a\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\bJ,\u0010\u001c\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/util/a;", "", "", "a", "", "trace", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "infos", "", "d", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "c", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", IVideoFilterTools.CATEGORYS, "b", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "e", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "j", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "f", "Lkx3/a;", "i", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "g", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", h.F, "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360077a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f360077a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        boolean isNTLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNTLogOpen();
        if (QLog.isDebugVersion()) {
            QLog.i("FriendsInfoLogUtil", 2, "isLogOpen:" + isNTLogOpen);
        }
        if (!isNTLogOpen) {
            return true;
        }
        return false;
    }

    public final void b(@Nullable String trace, @Nullable ArrayList<b> categorys) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) trace, (Object) categorys);
            return;
        }
        if (categorys != null && !a()) {
            Iterator<b> it = categorys.iterator();
            while (it.hasNext()) {
                QLog.i("FriendsInfoLogUtil", 1, "FriendsInfoService " + trace + " detailInfo is " + cq.w(it.next().toString(), 2) + " \n");
            }
        }
    }

    public final void c(@Nullable String trace, @Nullable ArrayList<c> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos != null && !a()) {
            Iterator<c> it = infos.iterator();
            while (it.hasNext()) {
                QLog.i("FriendsInfoLogUtil", 1, "FriendsInfoService " + trace + " detailInfo is " + cq.w(it.next().toString(), 2) + " \n");
            }
        }
    }

    public final void d(@Nullable String trace, @Nullable ArrayList<d> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos != null && !a()) {
            Iterator<d> it = infos.iterator();
            while (it.hasNext()) {
                QLog.i("FriendsInfoLogUtil", 1, "FriendsInfoService " + trace + " friendSimpleInfo is " + cq.w(it.next().toString(), 2) + " \n");
            }
        }
    }

    public final void e(@Nullable String trace, @Nullable ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos == null) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("FriendsInfoLogUtil", 1, "IntimateInfoService " + trace + " simpleInfo is " + cq.w(it.next().toString(), 2) + " \n");
        }
    }

    public final void f(@Nullable String trace, @Nullable ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos == null) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("FriendsInfoLogUtil", 1, "OnlineStatusInfoService " + trace + " simpleInfo is " + cq.w(it.next().toString(), 2) + " \n");
        }
    }

    public final void g(@Nullable String trace, @Nullable ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos != null && !a()) {
            Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.a> it = infos.iterator();
            while (it.hasNext()) {
                QLog.i("FriendsInfoLogUtil", 1, "OtherInfoService " + trace + " detailInfo is " + cq.w(it.next().toString(), 2) + " \n");
            }
        }
    }

    public final void h(@Nullable String trace, @Nullable ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos == null) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.c> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("FriendsInfoLogUtil", 1, "OtherInfoService " + trace + " simpleInfo is " + cq.w(it.next().toString(), 2) + " \n");
        }
    }

    public final void i(@Nullable String trace, @Nullable ArrayList<kx3.a> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos != null && !a()) {
            Iterator<kx3.a> it = infos.iterator();
            while (it.hasNext()) {
                QLog.i("FriendsInfoLogUtil", 1, "VasInfoService " + trace + " detailInfo is " + cq.w(it.next().toString(), 2) + " \n");
            }
        }
    }

    public final void j(@Nullable String trace, @Nullable ArrayList<NTVasSimpleInfo> infos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) trace, (Object) infos);
            return;
        }
        if (infos == null) {
            return;
        }
        Iterator<NTVasSimpleInfo> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("FriendsInfoLogUtil", 1, "VasInfoService " + trace + " simpleInfo is " + cq.w(it.next().toString(), 2) + " \n");
        }
    }
}
