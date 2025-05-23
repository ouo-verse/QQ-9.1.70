package com.tencent.android.gldrawable.api;

import android.graphics.drawable.Drawable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\bH&J(\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/android/gldrawable/api/IGLDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "getResID", "", "isRecyclyed", "", "onTouch", "", HippyTKDListViewAdapter.X, "", "y", "recycle", "setDrawArea", "x0", "y0", "x1", "y1", "setLockWH", "b", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class IGLDrawable extends Drawable {
    @NotNull
    public abstract String getResID();

    public abstract boolean isRecyclyed();

    public abstract void onTouch(float x16, float y16);

    public abstract void recycle();

    public abstract void setDrawArea(float x06, float y06, float x16, float y16);

    public abstract void setLockWH(boolean b16);
}
