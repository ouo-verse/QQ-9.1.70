package com.tencent.qqnt.qbasealbum.utils;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/h;", "", "Landroid/widget/ImageView;", "view", "", "originW", "originH", "", "b", "a", "", UserInfo.SEX_FEMALE, "sFlowItemHeight", "c", "sFlowItemMaxWidth", "d", "sFlowItemMinWidth", "e", "sRatioMax", "f", "sRatioMin", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f361657a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float sFlowItemHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float sFlowItemMaxWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static float sFlowItemMinWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static float sRatioMax;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static float sRatioMin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f361657a = new h();
        com.tencent.qqnt.qbasealbum.inject.a aVar = com.tencent.qqnt.qbasealbum.inject.a.f361230a;
        sFlowItemHeight = aVar.a().getResources().getDimension(R.dimen.cym);
        sFlowItemMaxWidth = aVar.a().getResources().getDimension(R.dimen.cyk);
        float dimension = aVar.a().getResources().getDimension(R.dimen.cyl);
        sFlowItemMinWidth = dimension;
        float f16 = sFlowItemMaxWidth;
        float f17 = sFlowItemHeight;
        sRatioMax = f16 / f17;
        sRatioMin = dimension / f17;
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(int originW, int originH) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(originW), Integer.valueOf(originH))).intValue();
        }
        if (originW != 0 && originH != 0) {
            float f16 = originW / originH;
            float f17 = sRatioMin;
            if (f16 <= sRatioMax && f17 <= f16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return 0;
            }
            if (f16 >= f17) {
                return 2;
            }
            return 1;
        }
        return -1;
    }

    public final void b(@NotNull ImageView view, int originW, int originH) {
        float f16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(originW), Integer.valueOf(originH));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        int a16 = a(originW, originH);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (a16 != 1) {
            if (a16 != 2) {
                i3 = layoutParams.width;
                layoutParams.width = i3;
                view.setLayoutParams(layoutParams);
            }
            f16 = sFlowItemMaxWidth;
        } else {
            f16 = sFlowItemMinWidth;
        }
        i3 = (int) f16;
        layoutParams.width = i3;
        view.setLayoutParams(layoutParams);
    }
}
