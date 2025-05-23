package com.tencent.mobileqq.gamecenter.qa.editor.util;

import android.widget.EditText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000e\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0011\u0010\f\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "Ljava/io/Serializable;", "", "start", "end", "offsetLeft", "offsetRight", "offset", "mStart", "I", "mEnd", "", "isEmpty", "()Z", "<init>", "(II)V", "Landroid/widget/EditText;", "editor", "(Landroid/widget/EditText;)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class Selection implements Serializable {
    private static final long serialVersionUID = 8415527424030047664L;
    private int mEnd;
    private int mStart;

    public Selection(int i3, int i16) {
        this.mStart = i3;
        this.mEnd = i16;
        if (i3 > i16) {
            this.mEnd = i3;
            this.mStart = i16;
        }
    }

    /* renamed from: end, reason: from getter */
    public final int getMEnd() {
        return this.mEnd;
    }

    public final boolean isEmpty() {
        if (this.mStart == this.mEnd) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Selection offset(int offsetLeft, int offsetRight) {
        this.mStart = Math.max(0, this.mStart - offsetLeft);
        this.mEnd += offsetRight;
        return this;
    }

    /* renamed from: start, reason: from getter */
    public final int getMStart() {
        return this.mStart;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Selection(@NotNull EditText editor) {
        this(editor.getSelectionStart(), editor.getSelectionEnd());
        Intrinsics.checkNotNullParameter(editor, "editor");
    }
}
