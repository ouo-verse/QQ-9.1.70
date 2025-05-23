package com.tencent.videocut.utils;

import android.util.Size;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/utils/n;", "", "Landroid/util/Size;", "res", "", "preferMaxLength", "a", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f384256a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9505);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f384256a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @NotNull
    public final Size a(@NotNull Size res, int preferMaxLength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Size) iPatchRedirector.redirect((short) 3, (Object) this, (Object) res, preferMaxLength);
        }
        Intrinsics.checkNotNullParameter(res, "res");
        int width = res.getWidth();
        int height = res.getHeight();
        com.tencent.videocut.utils.log.b.d("ResolutionUtils", "getFixedResolution(), input resolution\uff0c" + width + HippyTKDListViewAdapter.X + height);
        int max = Math.max(width, height);
        if (max <= preferMaxLength) {
            preferMaxLength = max;
        }
        if (height >= width && height != preferMaxLength) {
            width = (int) ((width * preferMaxLength) / height);
            height = preferMaxLength;
        } else if (width > height && width != preferMaxLength) {
            height = (int) ((height * preferMaxLength) / width);
            width = preferMaxLength;
        }
        Size a16 = l.f384250a.a(width, height, "video/avc");
        return new Size(a16.getWidth(), a16.getHeight());
    }
}
