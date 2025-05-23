package com.tencent.mobileqq.guild.quiprofile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.QUIResourcesWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001\u000eB-\u0012\u0006\u0010&\u001a\u00020 \u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0018\u00010\u0006R\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0018\u00010\u0006R\u00020\u0007H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0018\u00010\u0006R\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0018\u00010\u0006R\u00020\u0007H\u0016R\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0016\u0010\u001dR\"\u0010$\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/c;", "Landroid/content/res/QUIResourcesWrapper;", "", "id", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "theme", "density", "getDrawableForDensity", "Landroid/content/res/ColorStateList;", "getColorStateList", "getColor", "a", "Landroid/content/res/Resources;", "()Landroid/content/res/Resources;", PM.BASE, "b", "I", "themeId", "", "c", "Z", "d", "()Z", "isVasThemeDisabled", "Lcom/tencent/mobileqq/guild/quiprofile/d;", "Lcom/tencent/mobileqq/guild/quiprofile/d;", "()Lcom/tencent/mobileqq/guild/quiprofile/d;", "helper", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "e", "Lmqq/util/WeakReference;", "contextWeakRef", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/content/res/Resources;IZ)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends QUIResourcesWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Resources base;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int themeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isVasThemeDisabled;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d helper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextWeakRef;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ c(Context context, Resources resources, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, resources, (i16 & 4) != 0 ? 1000 : i3, (i16 & 8) != 0 ? true : z16);
        if ((i16 & 2) != 0) {
            resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        }
    }

    private final Context b() {
        Context context = this.contextWeakRef.get();
        if (context == null) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                return BaseApplication.getContext();
            }
            return qBaseActivity;
        }
        return context;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Resources getBase() {
        return this.base;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final d getHelper() {
        return this.helper;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsVasThemeDisabled() {
        return this.isVasThemeDisabled;
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public int getColor(int id5) throws Resources.NotFoundException {
        return getColor(id5, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @NotNull
    public ColorStateList getColorStateList(int id5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateList colorStateList = super.getColorStateList(id5, theme);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "super.getColorStateList(id, theme)");
        ColorStateList b16 = this.helper.b(colorStateList);
        Intrinsics.checkNotNullExpressionValue(b16, "helper.tintColorStateList(src)");
        return b16;
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @Nullable
    public Drawable getDrawable(int id5) throws Resources.NotFoundException {
        return getDrawable(id5, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int id5, int density) throws Resources.NotFoundException {
        return getDrawableForDensity(id5, density, null);
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    public int getColor(int id5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return getColorStateList(id5, theme).getDefaultColor();
        } catch (Exception e16) {
            QLog.e("QUIProfileSkin_Resources", 1, "getColor error:", e16);
            return super.getColor(id5, theme);
        }
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @Nullable
    public Drawable getDrawable(int id5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(id5, theme);
        return drawable != null ? this.helper.a(b(), drawable) : drawable;
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int id5, int density, @Nullable Resources.Theme theme) {
        Drawable drawableForDensity = super.getDrawableForDensity(id5, density, theme);
        return drawableForDensity != null ? this.helper.a(b(), drawableForDensity) : drawableForDensity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context, @NotNull Resources base, int i3, boolean z16) {
        super(base);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.themeId = i3;
        this.isVasThemeDisabled = z16;
        this.helper = new d(i3, z16);
        this.contextWeakRef = new WeakReference<>(context);
        DisplayMetricsUtil.checkAndCorrectDensity(getSuperDisplayMetrics());
    }

    @Override // android.content.res.QUIResourcesWrapper, android.content.res.Resources
    @NotNull
    public ColorStateList getColorStateList(int id5) throws Resources.NotFoundException {
        return getColorStateList(id5, null);
    }
}
