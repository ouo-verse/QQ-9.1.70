package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SimpleDateFormat f98728a;

    /* renamed from: b, reason: collision with root package name */
    public static long f98729b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static String f98730c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static ConcurrentHashMap<String, Map<String, Integer>> f98731d;

    /* renamed from: e, reason: collision with root package name */
    public static List<String> f98732e;

    /* renamed from: f, reason: collision with root package name */
    public static long f98733f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final d f98734g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        d dVar = new d();
        f98734g = dVar;
        f98728a = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINA);
        f98730c = "";
        f98731d = new ConcurrentHashMap<>();
        f98732e = new ArrayList();
        dVar.a();
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = f98728a;
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        String tempDay = simpleDateFormat.format(calendar.getTime());
        boolean z16 = !Intrinsics.areEqual(tempDay, f98730c);
        if (!Intrinsics.areEqual(tempDay, f98730c)) {
            Intrinsics.checkNotNullExpressionValue(tempDay, "tempDay");
            f98730c = tempDay;
            List<String> list = f98732e;
            list.clear();
            Calendar calendar2 = Calendar.getInstance();
            for (int i3 = 1; i3 <= 3; i3++) {
                calendar2.add(5, -1);
                SimpleDateFormat simpleDateFormat2 = f98728a;
                Intrinsics.checkNotNullExpressionValue(calendar2, "calendar");
                String format = simpleDateFormat2.format(calendar2.getTime());
                Intrinsics.checkNotNullExpressionValue(format, "formatTime.format(calendar.time)");
                list.add(format);
            }
            Iterator<Map.Entry<String, Map<String, Integer>>> it = f98731d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Map<String, Integer>> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (!f98732e.contains(next.getKey())) {
                    it.remove();
                }
            }
        }
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        StringBuilder a16 = com.tencent.cache.api.h.a(com.tencent.cache.api.collection.c.a("updateCurrentDay, currentDay: "), f98730c, ", ", "historyDayList:");
        a16.append(f98732e);
        a16.append(", cost:");
        a16.append(System.currentTimeMillis() - currentTimeMillis);
        bVar.j("AccessRecorder", 1, a16.toString());
        return z16;
    }
}
