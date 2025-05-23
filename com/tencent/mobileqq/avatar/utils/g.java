package com.tencent.mobileqq.avatar.utils;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/g;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Path;", "path", "", "canvasWidth", "canvasHeight", "clipHeightPercent", "", "a", "Landroid/view/View;", "view", "b", "d", "scalePercent", "c", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f200158a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29895);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f200158a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull Canvas canvas, @Nullable Path path, float canvasWidth, float canvasHeight, float clipHeightPercent) {
        Path path2;
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvasWidth > 0.0f && canvasHeight > 0.0f) {
            if (path == null) {
                path2 = new Path();
            } else {
                path2 = path;
            }
            path2.reset();
            if (clipHeightPercent > 0.0f && clipHeightPercent < 1.0f) {
                f16 = clipHeightPercent;
            } else {
                f16 = 0.25f;
            }
            float f17 = 1;
            float f18 = f17 + (2 * 0.15f);
            float f19 = f17 + 0.15f;
            canvas.scale(f18, f19, 0.5f * canvasWidth, canvasHeight);
            float f26 = canvasWidth / f18;
            float f27 = canvasHeight / f19;
            float min = canvasHeight - (Math.min(f16, 1.0f) * f27);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                path2.addRect(0.0f, 0.0f, canvasWidth, min, Path.Direction.CW);
            } else {
                canvas.clipRect(0.0f, 0.0f, canvasWidth, min);
            }
            float f28 = (canvasWidth * 0.15f) / f18;
            float f29 = (canvasHeight * 0.15f) / f19;
            path2.addArc(f28, f29, f28 + f26, f29 + f27, 0.0f, 360.0f);
            if (i3 >= 28) {
                canvas.clipPath(path2);
                return;
            } else {
                canvas.clipPath(path2, Region.Op.UNION);
                return;
            }
        }
        QLog.e("Q.qqhead..ZplanOutsideAvatarClipUtils", 1, "clipCanvas canvas size error! [" + canvasWidth + ", " + canvasHeight + "]");
    }

    @JvmStatic
    public static final void b(@Nullable View view) {
        f200158a.c(view, 0.15f);
    }

    @JvmStatic
    public static final void d(@Nullable View view) {
        if (view == null) {
            return;
        }
        ArrayList<ViewGroup> arrayList = new ArrayList();
        while (true) {
            Object parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                break;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.getTag(R.id.f165126uz4) == null || viewGroup.getTag(R.id.uz5) == null) {
                break;
            }
            arrayList.add(parent);
            view = (View) parent;
        }
        for (ViewGroup viewGroup2 : arrayList) {
            Object tag = viewGroup2.getTag(R.id.f165126uz4);
            if (tag instanceof Boolean) {
                viewGroup2.setClipChildren(((Boolean) tag).booleanValue());
            }
            Object tag2 = viewGroup2.getTag(R.id.uz5);
            if (tag2 instanceof Boolean) {
                viewGroup2.setClipToPadding(((Boolean) tag2).booleanValue());
            }
        }
    }

    public final void c(@Nullable View view, float scalePercent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Float.valueOf(scalePercent));
            return;
        }
        if (view != null && scalePercent > 0.0f) {
            float width = view.getWidth() * scalePercent;
            float height = view.getHeight() * scalePercent;
            ArrayList<ViewGroup> arrayList = new ArrayList();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                Object parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    arrayList.add(parent);
                    i3 += view.getLeft();
                    i16 += ((ViewGroup) parent).getWidth() - view.getRight();
                    i17 += view.getTop();
                    if (i3 >= width && i16 >= width && i17 >= height) {
                        for (ViewGroup viewGroup : arrayList) {
                            viewGroup.setTag(R.id.f165126uz4, Boolean.valueOf(viewGroup.getClipChildren()));
                            viewGroup.setTag(R.id.uz5, Boolean.valueOf(viewGroup.getClipToPadding()));
                            viewGroup.setClipChildren(false);
                            viewGroup.setClipToPadding(false);
                        }
                        return;
                    }
                    view = (View) parent;
                } else {
                    return;
                }
            }
        }
    }
}
