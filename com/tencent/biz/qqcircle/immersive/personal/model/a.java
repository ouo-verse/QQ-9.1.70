package com.tencent.biz.qqcircle.immersive.personal.model;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/model/a;", "", "", "c", "", h.F, "d", "i", "e", "a", "f", "b", "g", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f88731a = new a();

    a() {
    }

    private final boolean c() {
        return k.a().c("private_prods_tab_red_point_key", false);
    }

    private final boolean d() {
        return k.a().c("private_prods_tab_tips_bubble_key", false);
    }

    private final boolean e() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, 11, 31, 23, 59, 59);
        boolean before = calendar.before(calendar2);
        QLog.d("QFSPersonalPrivateTabGuideManager", 4, "result:" + before + ", curCalendar:" + calendar);
        return before;
    }

    private final void h() {
        k.a().j("private_prods_tab_red_point_key", true);
    }

    private final void i() {
        k.a().j("private_prods_tab_tips_bubble_key", true);
    }

    public final boolean a() {
        if (!c() && e()) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (!d() && e()) {
            return true;
        }
        return false;
    }

    public final void f() {
        h();
    }

    public final void g() {
        i();
    }
}
