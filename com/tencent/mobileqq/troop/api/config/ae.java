package com.tencent.mobileqq.troop.api.config;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293957a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293958b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<m> f293959c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45320);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293957a = new AtomicBoolean(false);
        f293958b = new Object();
        f293959c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293958b) {
            if (f293957a.get()) {
                return;
            }
            ArrayList<Class<? extends m>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238012e;
            if (arrayList != null) {
                Iterator<Class<? extends m>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293959c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.e("TroopMemberInfoHandlerProcessorConfig", 1, "Init Fail,", th5);
                    }
                }
            }
            f293957a.set(true);
        }
    }

    public static void b(@NonNull AppInterface appInterface, @NonNull Bundle bundle, @NonNull Map<String, String> map, List<MemberExtInfo> list) {
        Iterator<m> it = f293959c.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, bundle, map, list);
        }
    }
}
