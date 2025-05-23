package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rdelivery.dependency.AbsLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes27.dex */
public final /* synthetic */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f383823a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f383824b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        int[] iArr = new int[AbsLog.Level.values().length];
        f383823a = iArr;
        AbsLog.Level level = AbsLog.Level.VERBOSE;
        iArr[level.ordinal()] = 1;
        AbsLog.Level level2 = AbsLog.Level.DEBUG;
        iArr[level2.ordinal()] = 2;
        AbsLog.Level level3 = AbsLog.Level.INFO;
        iArr[level3.ordinal()] = 3;
        AbsLog.Level level4 = AbsLog.Level.WARN;
        iArr[level4.ordinal()] = 4;
        AbsLog.Level level5 = AbsLog.Level.ERROR;
        iArr[level5.ordinal()] = 5;
        int[] iArr2 = new int[AbsLog.Level.values().length];
        f383824b = iArr2;
        iArr2[level.ordinal()] = 1;
        iArr2[level2.ordinal()] = 2;
        iArr2[level3.ordinal()] = 3;
        iArr2[level4.ordinal()] = 4;
        iArr2[level5.ordinal()] = 5;
    }
}
