package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001a\u00106\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\b\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions;", "", "()V", "autoScale", "", "getAutoScale", "()Z", "setAutoScale", "(Z)V", "cacheKeySuffix", "", "getCacheKeySuffix", "()Ljava/lang/String;", "setCacheKeySuffix", "(Ljava/lang/String;)V", "extraInfo", "Landroid/os/Bundle;", "getExtraInfo", "()Landroid/os/Bundle;", "setExtraInfo", "(Landroid/os/Bundle;)V", "loadListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getLoadListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "setLoadListener", "(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loop", "", "getLoop", "()I", "setLoop", "(I)V", "requestHeight", "getRequestHeight", "setRequestHeight", "requestWidth", "getRequestWidth", "setRequestWidth", "tagId", "", "getTagId", "()[I", "setTagId", "([I)V", "useCache", "getUseCache", "setUseCache", "useUnFinishedCache", "getUseUnFinishedCache", "setUseUnFinishedCache", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SharpPOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ApngOptions.EmptyDrawable EMPTY_DRAWABLE = new ApngOptions.EmptyDrawable(1, 1);

    @NotNull
    public static final String PROTOCOL = "vasapngdownloader";

    @Nullable
    private String cacheKeySuffix;
    private int loop;
    private int requestHeight;
    private int requestWidth;

    @NotNull
    private int[] tagId = new int[0];

    @NotNull
    private Bundle extraInfo = new Bundle();
    private boolean useCache = true;

    @Nullable
    private Drawable loadingDrawable = EMPTY_DRAWABLE;
    private boolean autoScale = true;
    private boolean useUnFinishedCache = true;

    @NotNull
    private URLDrawable.URLDrawableListener loadListener = ApngOptions.INSTANCE.getDEFAULT_LISTENER();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/SharpPOptions$Companion;", "", "()V", "EMPTY_DRAWABLE", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$EmptyDrawable;", "getEMPTY_DRAWABLE", "()Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$EmptyDrawable;", "PROTOCOL", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ApngOptions.EmptyDrawable getEMPTY_DRAWABLE() {
            return SharpPOptions.EMPTY_DRAWABLE;
        }

        Companion() {
        }
    }

    public final boolean getAutoScale() {
        return this.autoScale;
    }

    @Nullable
    public final String getCacheKeySuffix() {
        return this.cacheKeySuffix;
    }

    @NotNull
    public final Bundle getExtraInfo() {
        return this.extraInfo;
    }

    @NotNull
    public final URLDrawable.URLDrawableListener getLoadListener() {
        return this.loadListener;
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

    @NotNull
    public final int[] getTagId() {
        return this.tagId;
    }

    public final boolean getUseCache() {
        return this.useCache;
    }

    public final boolean getUseUnFinishedCache() {
        return this.useUnFinishedCache;
    }

    public final void setAutoScale(boolean z16) {
        this.autoScale = z16;
    }

    public final void setCacheKeySuffix(@Nullable String str) {
        this.cacheKeySuffix = str;
    }

    public final void setExtraInfo(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.extraInfo = bundle;
    }

    public final void setLoadListener(@NotNull URLDrawable.URLDrawableListener uRLDrawableListener) {
        Intrinsics.checkNotNullParameter(uRLDrawableListener, "<set-?>");
        this.loadListener = uRLDrawableListener;
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

    public final void setTagId(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.tagId = iArr;
    }

    public final void setUseCache(boolean z16) {
        this.useCache = z16;
    }

    public final void setUseUnFinishedCache(boolean z16) {
        this.useUnFinishedCache = z16;
    }
}
