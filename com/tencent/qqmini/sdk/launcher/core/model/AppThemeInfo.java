package com.tencent.qqmini.sdk.launcher.core.model;

import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/model/AppThemeInfo;", "", "fontScale", "", "fontSize", "isNightTheme", "", "(FFZ)V", "getFontScale", "()F", "setFontScale", "(F)V", "getFontSize", CanvasView.ACTION_SET_FONT_SIZE, "()Z", "setNightTheme", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class AppThemeInfo {
    private float fontScale;
    private float fontSize;
    private boolean isNightTheme;

    public AppThemeInfo(float f16, float f17, boolean z16) {
        this.fontScale = f16;
        this.fontSize = f17;
        this.isNightTheme = z16;
    }

    public static /* synthetic */ AppThemeInfo copy$default(AppThemeInfo appThemeInfo, float f16, float f17, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = appThemeInfo.fontScale;
        }
        if ((i3 & 2) != 0) {
            f17 = appThemeInfo.fontSize;
        }
        if ((i3 & 4) != 0) {
            z16 = appThemeInfo.isNightTheme;
        }
        return appThemeInfo.copy(f16, f17, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final float getFontScale() {
        return this.fontScale;
    }

    /* renamed from: component2, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsNightTheme() {
        return this.isNightTheme;
    }

    @NotNull
    public final AppThemeInfo copy(float fontScale, float fontSize, boolean isNightTheme) {
        return new AppThemeInfo(fontScale, fontSize, isNightTheme);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AppThemeInfo) {
                AppThemeInfo appThemeInfo = (AppThemeInfo) other;
                if (Float.compare(this.fontScale, appThemeInfo.fontScale) != 0 || Float.compare(this.fontSize, appThemeInfo.fontSize) != 0 || this.isNightTheme != appThemeInfo.isNightTheme) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.fontScale) * 31) + Float.floatToIntBits(this.fontSize)) * 31;
        boolean z16 = this.isNightTheme;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return floatToIntBits + i3;
    }

    public final boolean isNightTheme() {
        return this.isNightTheme;
    }

    public final void setFontScale(float f16) {
        this.fontScale = f16;
    }

    public final void setFontSize(float f16) {
        this.fontSize = f16;
    }

    public final void setNightTheme(boolean z16) {
        this.isNightTheme = z16;
    }

    @NotNull
    public String toString() {
        return "AppThemeInfo(fontScale=" + this.fontScale + ", fontSize=" + this.fontSize + ", isNightTheme=" + this.isNightTheme + ")";
    }
}
