package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/views/ch;", "", "", "a", "I", "getLineBreakMagicCode", "()I", "lineBreakMagicCode", "", "b", "Ljava/lang/String;", "getTextWithLineBreak", "()Ljava/lang/String;", "textWithLineBreak", "<init>", "(ILjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ch {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int lineBreakMagicCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String textWithLineBreak;

    public ch(int i3, String textWithLineBreak) {
        Intrinsics.checkNotNullParameter(textWithLineBreak, "textWithLineBreak");
        this.lineBreakMagicCode = i3;
        this.textWithLineBreak = textWithLineBreak;
    }
}
