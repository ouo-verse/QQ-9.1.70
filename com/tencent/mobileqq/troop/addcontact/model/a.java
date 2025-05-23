package com.tencent.mobileqq.troop.addcontact.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "", "a", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.addcontact.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public /* synthetic */ class C8667a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f293813a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23190);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f293813a = iArr;
        }
    }

    public static final int a(@NotNull AddContactDataType addContactDataType) {
        Intrinsics.checkNotNullParameter(addContactDataType, "<this>");
        int i3 = C8667a.f293813a[addContactDataType.ordinal()];
        if (i3 != 1) {
            int i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 == 3) {
                    return 1;
                }
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return i16;
        }
        return 0;
    }
}
