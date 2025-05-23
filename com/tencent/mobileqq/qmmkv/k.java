package com.tencent.mobileqq.qmmkv;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/k;", "", "", "b", "Lcom/tencent/mobileqq/qmmkv/e;", "Lcom/tencent/mobileqq/qmmkv/e;", "a", "()Lcom/tencent/mobileqq/qmmkv/e;", "report", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f262017a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_MMKV.yml", version = 1)
    @Nullable
    private static final e report = null;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f262019c;

    static {
        ArrayList arrayList = new ArrayList();
        f262019c = arrayList;
        arrayList.add(l.class);
        f262017a = new k();
        b();
    }

    k() {
    }

    @JvmStatic
    @QAutoInitMethod
    public static final void b() {
        report = (e) com.tencent.mobileqq.qroute.utils.b.a(f262019c);
    }

    @Nullable
    public final e a() {
        return report;
    }
}
