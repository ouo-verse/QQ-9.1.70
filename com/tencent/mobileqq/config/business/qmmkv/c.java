package com.tencent.mobileqq.config.business.qmmkv;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/config/business/qmmkv/c;", "", "", "a", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f202807a = new c();

    c() {
    }

    public final void a() {
        Set of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new m[]{i.f202813f, h.f202812f, e.f202809f, d.f202808f, g.f202811f, f.f202810f, j.f202814f});
        Iterator it = of5.iterator();
        while (it.hasNext()) {
            ((m) it.next()).update();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QMMKV_ConfigUpdate", 2, "update");
        }
    }
}
