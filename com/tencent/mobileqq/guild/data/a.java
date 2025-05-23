package com.tencent.mobileqq.guild.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b \u0010\u001c\"\u0004\b#\u0010\u001eR\"\u0010&\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b\u0012\u0010\u001c\"\u0004\b%\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/data/a;", "", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "setApp", "(Lmqq/app/AppRuntime;)V", "app", "Landroid/content/Context;", "b", "Landroid/content/Context;", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Landroid/graphics/drawable/Drawable$Callback;", "c", "Landroid/graphics/drawable/Drawable$Callback;", "getDrawableCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "setDrawableCallback", "(Landroid/graphics/drawable/Drawable$Callback;)V", "drawableCallback", "", "d", "I", "()I", "f", "(I)V", "defaultIconSize", "e", "setIconPaddingLeft", "iconPaddingLeft", "setIconPaddingRight", "iconPaddingRight", "g", "iconFirstPaddingRight", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public AppRuntime app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Drawable.Callback drawableCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int iconPaddingLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int iconPaddingRight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int defaultIconSize = ViewUtils.dpToPx(19.0f);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int iconFirstPaddingRight = ViewUtils.dpToPx(19.0f);

    @NotNull
    public final Context a() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final int getDefaultIconSize() {
        return this.defaultIconSize;
    }

    /* renamed from: c, reason: from getter */
    public final int getIconFirstPaddingRight() {
        return this.iconFirstPaddingRight;
    }

    /* renamed from: d, reason: from getter */
    public final int getIconPaddingLeft() {
        return this.iconPaddingLeft;
    }

    /* renamed from: e, reason: from getter */
    public final int getIconPaddingRight() {
        return this.iconPaddingRight;
    }

    public final void f(int i3) {
        this.defaultIconSize = i3;
    }

    public final void g(int i3) {
        this.iconFirstPaddingRight = i3;
    }
}
