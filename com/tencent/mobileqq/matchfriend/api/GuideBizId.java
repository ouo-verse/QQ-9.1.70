package com.tencent.mobileqq.matchfriend.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "", "(Ljava/lang/String;I)V", "toString", "", "ID_UNKNOWN", "ID_INTERACTIVE_MARK", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class GuideBizId {
    private static final /* synthetic */ GuideBizId[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final GuideBizId ID_INTERACTIVE_MARK;
    public static final GuideBizId ID_UNKNOWN;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243988a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22896);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GuideBizId.values().length];
            try {
                iArr[GuideBizId.ID_INTERACTIVE_MARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f243988a = iArr;
        }
    }

    private static final /* synthetic */ GuideBizId[] $values() {
        return new GuideBizId[]{ID_UNKNOWN, ID_INTERACTIVE_MARK};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ID_UNKNOWN = new GuideBizId("ID_UNKNOWN", 0);
        ID_INTERACTIVE_MARK = new GuideBizId("ID_INTERACTIVE_MARK", 1);
        $VALUES = $values();
    }

    GuideBizId(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static GuideBizId valueOf(String str) {
        return (GuideBizId) Enum.valueOf(GuideBizId.class, str);
    }

    public static GuideBizId[] values() {
        return (GuideBizId[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (a.f243988a[ordinal()] == 1) {
            return "1";
        }
        return "0";
    }
}
