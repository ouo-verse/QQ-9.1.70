package mb2;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f416518a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f416519b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f416520c;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(26279), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        f416518a = new int[]{R.string.f170822ak3, R.string.zqq};
        f416519b = new int[]{R.drawable.cja, R.drawable.jwg};
        f416520c = new int[]{R.id.epz, R.id.epz};
    }
}
