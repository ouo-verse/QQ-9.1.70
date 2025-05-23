package com.tencent.qqnt.base.lifecycle;

import android.util.SparseArray;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00042\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/c;", "Lyv3/a;", "Landroid/util/SparseArray;", "Lcom/tencent/qqnt/base/lifecycle/b;", "b", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface c extends yv3.a<SparseArray<b>> {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/c$a;", "", "Lcom/tencent/qqnt/base/lifecycle/c;", "b", "Lcom/tencent/qqnt/base/lifecycle/c;", "a", "()Lcom/tencent/qqnt/base/lifecycle/c;", PatternUtils.NO_MATCH, "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.lifecycle.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f353021a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final c EMPTY;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/base/lifecycle/c$a$a", "Lcom/tencent/qqnt/base/lifecycle/c;", "Landroid/util/SparseArray;", "Lcom/tencent/qqnt/base/lifecycle/b;", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.base.lifecycle.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9514a implements c {
            static IPatchRedirector $redirector_;

            C9514a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // yv3.a
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SparseArray<b> get() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SparseArray) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return new SparseArray<>();
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40493);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f353021a = new Companion();
                EMPTY = new C9514a();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return EMPTY;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40497), (Class<?>) c.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f353021a;
        }
    }
}
