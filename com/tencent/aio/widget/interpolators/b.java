package com.tencent.aio.widget.interpolators;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\"\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\"\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t\"\u0016\u0010\u0011\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0012\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"", HippyTKDListViewAdapter.X, "f", "", "a", "I", "e", "()I", "setINTERPOLATOR_VISCOUS_FLUID", "(I)V", "INTERPOLATOR_VISCOUS_FLUID", "b", "d", "setINTERPOLATOR_DECELERATE", "INTERPOLATOR_DECELERATE", "c", UserInfo.SEX_FEMALE, "VISCOUS_FLUID_NORMALIZE", "VISCOUS_FLUID_OFFSET", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f69980a;

    /* renamed from: b, reason: collision with root package name */
    private static int f69981b;

    /* renamed from: c, reason: collision with root package name */
    private static float f69982c;

    /* renamed from: d, reason: collision with root package name */
    private static float f69983d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54733);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f69981b = 1;
        float f16 = 1.0f / f(1.0f);
        f69982c = f16;
        f69983d = 1.0f - (f16 * f(1.0f));
    }

    public static final int d() {
        return f69981b;
    }

    public static final int e() {
        return f69980a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(float f16) {
        float f17 = f16 * 8.0f;
        if (f17 < 1.0f) {
            return f17 - (1.0f - ((float) Math.exp(-f17)));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
    }
}
