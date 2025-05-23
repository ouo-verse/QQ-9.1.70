package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.group.group_member_info$MemberInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293954a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293955b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<l> f293956c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293954a = new AtomicBoolean(false);
        f293955b = new Object();
        f293956c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293955b) {
            if (f293954a.get()) {
                return;
            }
            ArrayList<Class<? extends l>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238014g;
            if (arrayList != null) {
                Iterator<Class<? extends l>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293956c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.e("TroopMemberCardHandlerProcessorConfig", 1, "Init Fail,", th5);
                    }
                }
            }
            f293954a.set(true);
        }
    }

    public static void b(String str, String str2, String str3, byte b16) {
        Iterator<l> it = f293956c.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3, b16);
        }
    }

    public static void c(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        Iterator<l> it = f293956c.iterator();
        while (it.hasNext()) {
            it.next().b(troopInfo, troopMemberInfo);
        }
    }

    public static void d(@NonNull TroopMemberCard troopMemberCard, long j3, group_member_info$MemberInfo group_member_info_memberinfo) {
        Iterator<l> it = f293956c.iterator();
        while (it.hasNext()) {
            it.next().c(troopMemberCard, j3, group_member_info_memberinfo);
        }
    }

    public static void e(@NonNull TroopMemberInfo troopMemberInfo, TroopMemberCard troopMemberCard) {
        Iterator<l> it = f293956c.iterator();
        while (it.hasNext()) {
            it.next().d(troopMemberInfo, troopMemberCard);
        }
    }
}
