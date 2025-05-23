package com.tencent.mobileqq.guild.feed.util;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/ag;", "", "", "size", "", "c", "picUrl", "b", "width", "height", "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f223839a = new ag();

    ag() {
    }

    @JvmStatic
    @NotNull
    public static final String b(@Nullable String picUrl) {
        boolean z16;
        int indexOf$default;
        int indexOf$default2;
        CharSequence replaceRange;
        if (picUrl != null) {
            if (picUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) picUrl, "//", 0, false, 6, (Object) null);
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) picUrl, '.', 0, false, 6, (Object) null);
                replaceRange = StringsKt__StringsKt.replaceRange((CharSequence) picUrl, indexOf$default + 2, indexOf$default2, (CharSequence) "worldr");
                return replaceRange.toString();
            }
            return "";
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final String c(int size) {
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        if (size < 1024) {
            return size + "B";
        }
        if (size < 1048576) {
            return decimalFormat.format((size * 1.0d) / 1024) + "K";
        }
        return decimalFormat.format((size * 1.0d) / 1048576) + "M";
    }

    @Nullable
    public final Bitmap a(int width, int height) {
        if (width <= 0) {
            width = 854;
        }
        if (height <= 0) {
            height = 480;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            createBitmap.eraseColor(-16777216);
            return createBitmap;
        } catch (Exception e16) {
            QLog.e("GuildFeedImageUtil", 1, "[generateBlackBitmap]: w=" + width + " h=" + height + " ex=" + e16);
            return null;
        }
    }
}
