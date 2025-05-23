package com.qzone.reborn.albumx.qzonex.bean.initbean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0010R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxEditTextInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "titleBarText", "text", "maxInputLen", "", "hint", "canOutputBlankString", "", "isMultiLineInput", "daTongPageId", "isNeedCheckEmpty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;Z)V", "getCanOutputBlankString", "()Z", "getDaTongPageId", "()Ljava/lang/String;", "getHint", "getMaxInputLen", "()I", "getText", "getTitleBarText", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxEditTextInitBean extends QZAlbumxInitBean {
    private final boolean canOutputBlankString;
    private final String daTongPageId;
    private final String hint;
    private final boolean isMultiLineInput;
    private final boolean isNeedCheckEmpty;
    private final int maxInputLen;
    private final String text;
    private final String titleBarText;

    public /* synthetic */ QZAlbumxEditTextInitBean(String str, String str2, String str3, int i3, String str4, boolean z16, boolean z17, String str5, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i16 & 8) != 0 ? 10 : i3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? false : z17, (i16 & 128) != 0 ? "" : str5, (i16 & 256) != 0 ? false : z18);
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

    /* renamed from: isNeedCheckEmpty, reason: from getter */
    public final boolean getIsNeedCheckEmpty() {
        return this.isNeedCheckEmpty;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxEditTextInitBean(String uin, String titleBarText, String text, int i3, String hint, boolean z16, boolean z17, String daTongPageId, boolean z18) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
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
        this.isNeedCheckEmpty = z18;
    }
}
