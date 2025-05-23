package com.tencent.qqnt.msg.graytip.ntactionhandler.troop;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/msg/graytip/ntactionhandler/troop/c;", "", "", "jumpType", "Lcom/tencent/qqnt/msg/graytip/ntactionhandler/troop/a;", "a", "b", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "Landroid/util/SparseArray;", "mProcessorClassMap", "c", "mProcessorMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359640a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<Class<? extends a>> mProcessorClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<a> mProcessorMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f359640a = new c();
        SparseArray<Class<? extends a>> sparseArray = new SparseArray<>();
        sparseArray.put(5, d.class);
        sparseArray.put(3, e.class);
        mProcessorClassMap = sparseArray;
        mProcessorMap = new SparseArray<>();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final a a(int jumpType) {
        Class<? extends a> cls = mProcessorClassMap.get(jumpType);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }

    @Nullable
    public final synchronized a b(int jumpType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, jumpType);
        }
        SparseArray<a> sparseArray = mProcessorMap;
        a aVar = sparseArray.get(jumpType);
        if (aVar != null) {
            return aVar;
        }
        a a16 = a(jumpType);
        if (a16 != null) {
            sparseArray.put(jumpType, a16);
            return a16;
        }
        return null;
    }
}
