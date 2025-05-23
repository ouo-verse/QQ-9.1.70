package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/DynamicDrawableOptions;", "", "()V", "autoScale", "", "getAutoScale", "()Z", "setAutoScale", "(Z)V", "cacheKeySuffix", "", "getCacheKeySuffix", "()Ljava/lang/String;", "setCacheKeySuffix", "(Ljava/lang/String;)V", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loop", "", "getLoop", "()I", "setLoop", "(I)V", "requestHeight", "getRequestHeight", "setRequestHeight", "requestWidth", "getRequestWidth", "setRequestWidth", "useCache", "getUseCache", "setUseCache", "toCacheKey", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class DynamicDrawableOptions {

    @NotNull
    private static final ApngOptions.EmptyDrawable EMPTY_DRAWABLE = new ApngOptions.EmptyDrawable(1, 1);

    @Nullable
    private String cacheKeySuffix;
    private int loop;
    private int requestHeight;
    private int requestWidth;
    private boolean useCache = true;

    @Nullable
    private Drawable loadingDrawable = EMPTY_DRAWABLE;
    private boolean autoScale = true;

    public final boolean getAutoScale() {
        return this.autoScale;
    }

    @Nullable
    public final String getCacheKeySuffix() {
        return this.cacheKeySuffix;
    }

    @Nullable
    public final Drawable getLoadingDrawable() {
        return this.loadingDrawable;
    }

    public final int getLoop() {
        return this.loop;
    }

    public final int getRequestHeight() {
        return this.requestHeight;
    }

    public final int getRequestWidth() {
        return this.requestWidth;
    }

    public final boolean getUseCache() {
        return this.useCache;
    }

    public final void setAutoScale(boolean z16) {
        this.autoScale = z16;
    }

    public final void setCacheKeySuffix(@Nullable String str) {
        this.cacheKeySuffix = str;
    }

    public final void setLoadingDrawable(@Nullable Drawable drawable) {
        this.loadingDrawable = drawable;
    }

    public final void setLoop(int i3) {
        this.loop = i3;
    }

    public final void setRequestHeight(int i3) {
        this.requestHeight = i3;
    }

    public final void setRequestWidth(int i3) {
        this.requestWidth = i3;
    }

    public final void setUseCache(boolean z16) {
        this.useCache = z16;
    }

    @NotNull
    public final String toCacheKey() {
        return "{" + this.cacheKeySuffix + "_" + this.loop + "_" + this.requestWidth + "_" + this.requestHeight + "}";
    }
}
