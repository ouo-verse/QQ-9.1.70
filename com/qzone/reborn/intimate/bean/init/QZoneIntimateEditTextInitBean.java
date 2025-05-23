package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateEditTextInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "titleBarText", "", "text", "maxInputLen", "", "hint", "canOutputBlankString", "", "isMultiLineInput", "daTongPageId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "getCanOutputBlankString", "()Z", "getDaTongPageId", "()Ljava/lang/String;", "getHint", "getMaxInputLen", "()I", "getText", "getTitleBarText", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateEditTextInitBean extends QZoneIntimateInitBean {
    private final boolean canOutputBlankString;
    private final String daTongPageId;
    private final String hint;
    private final boolean isMultiLineInput;
    private final int maxInputLen;
    private final String text;
    private final String titleBarText;

    public /* synthetic */ QZoneIntimateEditTextInitBean(String str, String str2, int i3, String str3, boolean z16, boolean z17, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? 15 : i3, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? false : z17, (i16 & 64) != 0 ? "" : str4);
    }

    public final boolean getCanOutputBlankString() {
        return this.canOutputBlankString;
    }

    public final String getDaTongPageId() {
        return this.daTongPageId;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getMaxInputLen() {
        return this.maxInputLen;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitleBarText() {
        return this.titleBarText;
    }

    /* renamed from: isMultiLineInput, reason: from getter */
    public final boolean getIsMultiLineInput() {
        return this.isMultiLineInput;
    }

    public QZoneIntimateEditTextInitBean(String titleBarText, String text, int i3, String hint, boolean z16, boolean z17, String daTongPageId) {
        Intrinsics.checkNotNullParameter(titleBarText, "titleBarText");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(daTongPageId, "daTongPageId");
        this.titleBarText = titleBarText;
        this.text = text;
        this.maxInputLen = i3;
        this.hint = hint;
        this.canOutputBlankString = z16;
        this.isMultiLineInput = z17;
        this.daTongPageId = daTongPageId;
    }
}
