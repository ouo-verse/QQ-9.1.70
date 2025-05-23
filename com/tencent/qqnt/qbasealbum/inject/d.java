package com.tencent.qqnt.qbasealbum.inject;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.IPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/d;", "", "", "isNowThemeIsNight", "o", "Landroid/content/Context;", "context", "", "getStatusBarHeight", "isCameraResReady", "", "getServerTimeMillis", "k", "Landroid/view/View;", "view", "", "f", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "Lcom/tencent/biz/richframework/part/Part;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSupportMagnifyLongPic", "e", "r", "a", "g", "Landroid/graphics/drawable/Drawable;", "j", "", "comment", "", "p", "Landroid/content/ComponentName;", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static boolean a(@NotNull d dVar) {
            return false;
        }

        @Nullable
        public static Drawable b(@NotNull d dVar) {
            return null;
        }

        @Nullable
        public static ComponentName c(@NotNull d dVar) {
            return null;
        }

        @Nullable
        public static IPicLoader d(@NotNull d dVar) {
            return null;
        }

        @Nullable
        public static CharSequence e(@NotNull d dVar, @NotNull String comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            return null;
        }

        public static long f(@NotNull d dVar) {
            return System.currentTimeMillis();
        }

        public static int g(@NotNull d dVar, @NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @Nullable
        public static Part h(@NotNull d dVar) {
            return null;
        }

        public static boolean i(@NotNull d dVar) {
            return false;
        }

        public static boolean j(@NotNull d dVar) {
            return false;
        }

        public static boolean k(@NotNull d dVar) {
            return false;
        }

        public static boolean l(@NotNull d dVar) {
            return true;
        }

        public static boolean m(@NotNull d dVar) {
            return false;
        }

        public static boolean n(@NotNull d dVar) {
            return false;
        }

        public static void o(@NotNull d dVar, @NotNull Context context, @NotNull View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static int p(@NotNull d dVar) {
            return 1500;
        }

        public static int q(@NotNull d dVar) {
            return 50;
        }
    }

    boolean a();

    @Nullable
    ComponentName b();

    boolean e();

    void f(@NotNull Context context, @NotNull View view);

    int g();

    @Nullable
    IPicLoader getPicLoader();

    long getServerTimeMillis();

    int getStatusBarHeight(@NotNull Context context);

    boolean isCameraResReady();

    boolean isNowThemeIsNight();

    boolean isSupportMagnifyLongPic();

    @Nullable
    Drawable j();

    boolean k();

    boolean o();

    @Nullable
    CharSequence p(@NotNull String comment);

    @Nullable
    Part q();

    int r();
}
