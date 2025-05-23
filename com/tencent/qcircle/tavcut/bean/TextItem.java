package com.tencent.qcircle.tavcut.bean;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0000H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qcircle/tavcut/bean/TextItem;", "", "()V", "assetFontPath", "", "getAssetFontPath", "()Ljava/lang/String;", "setAssetFontPath", "(Ljava/lang/String;)V", "fontPath", "getFontPath", "setFontPath", "text", "getText", IECSearchBar.METHOD_SET_TEXT, "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "clone", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class TextItem implements Cloneable {

    @Nullable
    private String assetFontPath;

    @Nullable
    private String fontPath;

    @Nullable
    private String text;
    private int textColor;

    @Nullable
    public final String getAssetFontPath() {
        return this.assetFontPath;
    }

    @Nullable
    public final String getFontPath() {
        return this.fontPath;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setAssetFontPath(@Nullable String str) {
        this.assetFontPath = str;
    }

    public final void setFontPath(@Nullable String str) {
        this.fontPath = str;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setTextColor(int i3) {
        this.textColor = i3;
    }

    @NotNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TextItem m236clone() {
        TextItem textItem = new TextItem();
        textItem.text = this.text;
        textItem.textColor = this.textColor;
        textItem.fontPath = this.fontPath;
        textItem.assetFontPath = this.assetFontPath;
        return textItem;
    }
}
