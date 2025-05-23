package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0003345B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "", "()V", "autoScale", "", "getAutoScale", "()Z", "setAutoScale", "(Z)V", "extraInfo", "Landroid/os/Bundle;", "getExtraInfo", "()Landroid/os/Bundle;", "setExtraInfo", "(Landroid/os/Bundle;)V", "loadListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getLoadListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "setLoadListener", "(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loop", "", "getLoop", "()I", "setLoop", "(I)V", "requestHeight", "getRequestHeight", "setRequestHeight", "requestWidth", "getRequestWidth", "setRequestWidth", "tagId", "", "getTagId", "()[I", "setTagId", "([I)V", "useCache", "getUseCache", "setUseCache", "useUnFinishedCache", "getUseUnFinishedCache", "setUseUnFinishedCache", "Companion", "EmptyDrawable", "URLDrawableListenerAdapter", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ApngOptions {

    @NotNull
    public static final String PROTOCOL = "vasapngdownloader";
    private int loop;
    private int requestHeight;
    private int requestWidth;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ColorDrawable TRANSPARENT = new ColorDrawable(0);

    @NotNull
    private static final URLDrawableListenerAdapter DEFAULT_LISTENER = new URLDrawableListenerAdapter();

    @JvmField
    @NotNull
    public static final EmptyDrawable EMPTY_DRAWABLE = new EmptyDrawable(1, 1);

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
    private URLDrawable.URLDrawableListener loadListener = DEFAULT_LISTENER;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$Companion;", "", "()V", "DEFAULT_LISTENER", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$URLDrawableListenerAdapter;", "getDEFAULT_LISTENER", "()Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$URLDrawableListenerAdapter;", "EMPTY_DRAWABLE", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$EmptyDrawable;", "PROTOCOL", "", "TRANSPARENT", "Landroid/graphics/drawable/ColorDrawable;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final URLDrawableListenerAdapter getDEFAULT_LISTENER() {
            return ApngOptions.DEFAULT_LISTENER;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$EmptyDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "w", "", h.F, "(II)V", "getH", "()I", "getW", "getIntrinsicHeight", "getIntrinsicWidth", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class EmptyDrawable extends ColorDrawable {
        private final int h;
        private final int w;

        public EmptyDrawable(int i3, int i16) {
            super(0);
            this.w = i3;
            this.h = i16;
        }

        public final int getH() {
            return this.h;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.h;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.w;
        }

        public final int getW() {
            return this.w;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$URLDrawableListenerAdapter;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "()V", "onLoadCanceled", "", "arg0", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "arg1", "", "onLoadProgressed", "", "onLoadSuccessed", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static class URLDrawableListenerAdapter implements URLDrawable.URLDrawableListener {
        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable arg0, @NotNull Throwable arg1) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            Intrinsics.checkNotNullParameter(arg1, "arg1");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable arg0, int arg1) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
        }
    }

    public final boolean getAutoScale() {
        return this.autoScale;
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
