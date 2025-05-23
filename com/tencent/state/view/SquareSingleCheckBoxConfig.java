package com.tencent.state.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/view/SquareSingleCheckBoxConfig;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "iconDefaultSelected", "", "getIconDefaultSelected", "()Z", "setIconDefaultSelected", "(Z)V", "iconNormalRes", "", "getIconNormalRes", "()I", "setIconNormalRes", "(I)V", "iconSelectedRes", "getIconSelectedRes", "setIconSelectedRes", "iconSize", "Landroid/util/Size;", "getIconSize", "()Landroid/util/Size;", "setIconSize", "(Landroid/util/Size;)V", "text", "", "getText", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "textMargin", "Landroid/graphics/Rect;", "getTextMargin", "()Landroid/graphics/Rect;", "setTextMargin", "(Landroid/graphics/Rect;)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSingleCheckBoxConfig {
    private boolean iconDefaultSelected;
    private int iconNormalRes;
    private int iconSelectedRes;
    private Size iconSize;
    private String text;
    private int textColor;
    private Rect textMargin;
    private float textSize;

    public SquareSingleCheckBoxConfig(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconNormalRes = R.drawable.i_e;
        this.iconSelectedRes = R.drawable.i_f;
        this.iconSize = new Size(ViewExtensionsKt.dip(context, 24), ViewExtensionsKt.dip(context, 24));
        this.iconDefaultSelected = true;
        this.textMargin = new Rect(ViewExtensionsKt.dip(context, 6), 0, 0, 0);
        this.textSize = ViewExtensionsKt.dip(context, 14);
        this.textColor = (int) 4287137928L;
        this.text = "\u4e0b\u6b21\u4e0d\u518d\u63d0\u9192";
    }

    public final boolean getIconDefaultSelected() {
        return this.iconDefaultSelected;
    }

    public final int getIconNormalRes() {
        return this.iconNormalRes;
    }

    public final int getIconSelectedRes() {
        return this.iconSelectedRes;
    }

    public final Size getIconSize() {
        return this.iconSize;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final Rect getTextMargin() {
        return this.textMargin;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setIconDefaultSelected(boolean z16) {
        this.iconDefaultSelected = z16;
    }

    public final void setIconNormalRes(int i3) {
        this.iconNormalRes = i3;
    }

    public final void setIconSelectedRes(int i3) {
        this.iconSelectedRes = i3;
    }

    public final void setIconSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.iconSize = size;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void setTextColor(int i3) {
        this.textColor = i3;
    }

    public final void setTextMargin(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.textMargin = rect;
    }

    public final void setTextSize(float f16) {
        this.textSize = f16;
    }
}
