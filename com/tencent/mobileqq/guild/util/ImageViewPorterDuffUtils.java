package com.tencent.mobileqq.guild.util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\u000b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ImageViewPorterDuffUtils;", "", "", "b", "Landroid/widget/ImageView;", "targetView", "", "c", "Lkotlin/Lazy;", "a", "()Z", "enableSetFilter", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ImageViewPorterDuffUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ImageViewPorterDuffUtils f235385a = new ImageViewPorterDuffUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableSetFilter;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils$enableSetFilter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_imageView_enable_add_white_filter_20240715", true));
            }
        });
        enableSetFilter = lazy;
    }

    ImageViewPorterDuffUtils() {
    }

    private final boolean a() {
        return ((Boolean) enableSetFilter.getValue()).booleanValue();
    }

    private final boolean b() {
        QLog.i("ImageViewPorterDuffUtils", 4, "needAddFilter=" + a());
        return a();
    }

    public final void c(@Nullable ImageView targetView) {
        if (b()) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.DST_ATOP);
            if (targetView != null) {
                targetView.setColorFilter(porterDuffColorFilter);
            }
        }
    }
}
