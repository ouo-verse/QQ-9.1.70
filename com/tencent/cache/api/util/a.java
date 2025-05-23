package com.tencent.cache.api.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f98637a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f98638b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[Priority.values().length];
        f98637a = iArr;
        Priority priority = Priority.Low;
        iArr[priority.ordinal()] = 1;
        Priority priority2 = Priority.Normal;
        iArr[priority2.ordinal()] = 2;
        Priority priority3 = Priority.High;
        iArr[priority3.ordinal()] = 3;
        int[] iArr2 = new int[Priority.values().length];
        f98638b = iArr2;
        iArr2[priority.ordinal()] = 1;
        iArr2[priority2.ordinal()] = 2;
        iArr2[priority3.ordinal()] = 3;
    }
}
