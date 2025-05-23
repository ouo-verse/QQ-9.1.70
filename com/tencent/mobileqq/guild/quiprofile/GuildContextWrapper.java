package com.tencent.mobileqq.guild.quiprofile;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.GuildQUIProfileLayoutInflater;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.app.QBaseActivityWrapper;
import com.tencent.mobileqq.app.utils.DisplayMetricsUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001\u0003B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u000e\u0010\u0011\u001a\b\u0018\u00010\u000fR\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u000fR\u00020\u00100\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildContextWrapper;", "Landroid/content/ContextWrapper;", "Lcom/tencent/mobileqq/guild/quiprofile/c;", "a", "", "c", "b", "", "name", "", "getSystemService", "", "getThemeResId", "resid", "setTheme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getTheme", "Landroid/content/Context;", "Landroid/content/Context;", PM.BASE, "I", "themeId", "themeResId", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "d", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "threadLocalResource", "e", "threadLocalTheme", "<init>", "(Landroid/content/Context;I)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContextWrapper extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context base;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int themeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int themeResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWThreadLocal<c> threadLocalResource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWThreadLocal<Resources.Theme> threadLocalTheme;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextWrapper(@NotNull Context base, int i3) {
        super(base);
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this.themeId = i3;
        this.threadLocalResource = new RFWThreadLocal<>();
        this.threadLocalTheme = new RFWThreadLocal<>();
    }

    private final c a() {
        return new c(this.base, null, this.themeId, false, 10, null);
    }

    private final void c() {
        if (this.threadLocalTheme.get() == null) {
            Resources.Theme newTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            int themeResId = getThemeResId();
            if (themeResId != 0) {
                newTheme.applyStyle(themeResId, true);
                this.threadLocalTheme.set(newTheme);
            } else {
                this.threadLocalTheme.set(theme);
                QLog.e("GuildContextWrapper", 1, "getThemeResId() == 0\uff0c\u4f7f\u7528\u539f\u59cb\u7684theme");
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c getResources() {
        c cVar = this.threadLocalResource.get();
        if (cVar == null) {
            cVar = a();
            this.threadLocalResource.set(cVar);
        }
        DisplayMetricsUtil.checkAndCorrectDensity(cVar.getSuperDisplayMetrics());
        com.tencent.mobileqq.app.displaymetric.a.f195491a.a(cVar);
        return cVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @NotNull
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object service = super.getSystemService(name);
        if (Intrinsics.areEqual("layout_inflater", name) && (service instanceof LayoutInflater)) {
            if (service instanceof GuildQUIProfileLayoutInflater) {
                GuildQUIProfileLayoutInflater guildQUIProfileLayoutInflater = (GuildQUIProfileLayoutInflater) service;
                if (guildQUIProfileLayoutInflater.getContext() == this) {
                    return (LayoutInflater) service;
                }
                return guildQUIProfileLayoutInflater.cloneInContext(this);
            }
            return new GuildQUIProfileLayoutInflater((LayoutInflater) service, this);
        }
        Intrinsics.checkNotNullExpressionValue(service, "service");
        return service;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public Resources.Theme getTheme() {
        getBaseContext().getTheme();
        c();
        return this.threadLocalTheme.get();
    }

    @Keep
    public final int getThemeResId() {
        ComponentName componentName;
        Object obj;
        int i3 = this.themeResId;
        if (i3 != 0) {
            return i3;
        }
        Context baseContext = getBaseContext();
        Activity a16 = ep.a(baseContext);
        Integer num = null;
        if (a16 != null) {
            componentName = a16.getComponentName();
        } else {
            componentName = null;
        }
        int i16 = 0;
        if (componentName != null) {
            try {
                this.themeResId = getPackageManager().getActivityInfo(componentName, 0).theme;
            } catch (Throwable th5) {
                QLog.e("GuildContextWrapper", 1, "getPackageManager().getActivityInfo failed", th5);
            }
        }
        if (this.themeResId == 0) {
            try {
                Method setThemeResIdMethod = QBaseActivityWrapper.getSetThemeResIdMethod();
                if (setThemeResIdMethod != null) {
                    obj = setThemeResIdMethod.invoke(baseContext, new Object[0]);
                } else {
                    obj = null;
                }
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                }
                if (num != null) {
                    i16 = num.intValue();
                }
                this.themeResId = i16;
            } catch (Throwable th6) {
                QLog.e("GuildContextWrapper", 1, "refection getThemeResId failed", th6);
            }
        }
        return this.themeResId;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resid) {
        super.setTheme(resid);
        c();
        Resources.Theme theme = this.threadLocalTheme.get();
        if (theme != null) {
            theme.applyStyle(resid, true);
        }
    }
}
