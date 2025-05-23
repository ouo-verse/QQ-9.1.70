package com.qzone.reborn.groupalbum.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumEditTextInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "groupId", "", "titleBarText", "text", "maxInputLen", "", "hint", "canOutputBlankString", "", "isMultiLineInput", "daTongPageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "getCanOutputBlankString", "()Z", "getDaTongPageId", "()Ljava/lang/String;", "getHint", "getMaxInputLen", "()I", "getText", "getTitleBarText", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumEditTextInitBean extends GroupAlbumInitBean {
    private final boolean canOutputBlankString;
    private final String daTongPageId;
    private final String hint;
    private final boolean isMultiLineInput;
    private final int maxInputLen;
    private final String text;
    private final String titleBarText;

    public /* synthetic */ GroupAlbumEditTextInitBean(String str, String str2, String str3, int i3, String str4, boolean z16, boolean z17, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i16 & 8) != 0 ? 10 : i3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? false : z16, (i16 & 64) != 0 ? false : z17, (i16 & 128) != 0 ? "" : str5);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumEditTextInitBean(String groupId, String titleBarText, String text, int i3, String hint, boolean z16, boolean z17, String daTongPageId) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
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
