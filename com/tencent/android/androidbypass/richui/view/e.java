package com.tencent.android.androidbypass.richui.view;

import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/e;", "Lcom/tencent/android/androidbypass/richui/view/h;", "Landroid/widget/ImageView;", "", "ratio", "lpWidth", "lpHeight", "", "i", "", "src", "Landroid/widget/ImageView$ScaleType;", "scaleType", "c", "", "radius", "roundMode", "e", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface e extends h<ImageView> {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/android/androidbypass/richui/view/e$a;", "", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.view.e$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f72361a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18763);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f72361a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(18764), (Class<?>) e.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f72361a;
        }
    }

    void c(@NotNull String src, @Nullable ImageView.ScaleType scaleType);

    void e(int radius, int roundMode);

    void i(float ratio, float lpWidth, float lpHeight);
}
