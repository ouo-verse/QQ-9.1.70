package com.tencent.mobileqq.vas.api.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/EmoticonSpanApiImpl;", "Lcom/tencent/mobileqq/vas/api/IEmoticonSpanApi;", "()V", "draw", "", "obj", "", "var1", "Landroid/graphics/Canvas;", "var2", "", "var3", "", "var4", "var5", "", "var6", "var7", "var8", "var9", "Landroid/graphics/Paint;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getRect", "Landroid/graphics/Rect;", "isEmoticonSpan", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class EmoticonSpanApiImpl implements IEmoticonSpanApi {
    @Override // com.tencent.mobileqq.vas.api.IEmoticonSpanApi
    public void draw(@Nullable Object obj, @NotNull Canvas var1, @Nullable CharSequence var2, int var3, int var4, float var5, int var6, int var7, int var8, @NotNull Paint var9) {
        EmoticonSpan emoticonSpan;
        Intrinsics.checkNotNullParameter(var1, "var1");
        Intrinsics.checkNotNullParameter(var9, "var9");
        if (obj instanceof EmoticonSpan) {
            emoticonSpan = (EmoticonSpan) obj;
        } else {
            emoticonSpan = null;
        }
        EmoticonSpan emoticonSpan2 = emoticonSpan;
        if (emoticonSpan2 != null) {
            emoticonSpan2.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IEmoticonSpanApi
    @Nullable
    public Drawable getDrawable(@Nullable Object obj) {
        EmoticonSpan emoticonSpan;
        if (obj instanceof EmoticonSpan) {
            emoticonSpan = (EmoticonSpan) obj;
        } else {
            emoticonSpan = null;
        }
        if (emoticonSpan == null) {
            return null;
        }
        return emoticonSpan.getDrawable();
    }

    @Override // com.tencent.mobileqq.vas.api.IEmoticonSpanApi
    @Nullable
    public Rect getRect(@Nullable Object obj) {
        EmoticonSpan emoticonSpan;
        if (obj instanceof EmoticonSpan) {
            emoticonSpan = (EmoticonSpan) obj;
        } else {
            emoticonSpan = null;
        }
        if (emoticonSpan == null) {
            return null;
        }
        return emoticonSpan.getRect();
    }

    @Override // com.tencent.mobileqq.vas.api.IEmoticonSpanApi
    public boolean isEmoticonSpan(@Nullable Object obj) {
        return obj instanceof EmoticonSpan;
    }
}
