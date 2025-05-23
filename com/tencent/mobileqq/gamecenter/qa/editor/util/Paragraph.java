package com.tencent.mobileqq.gamecenter.qa.editor.util;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001R\u0017\u0010\u0005\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0006\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Paragraph;", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "sel", "", "isSelected", "isFirst", "Z", "()Z", "isLast", "", "start", "end", "<init>", "(IIZZ)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class Paragraph extends Selection {
    private static final long serialVersionUID = 2475227150049924994L;
    private final boolean isFirst;
    private final boolean isLast;

    public Paragraph(int i3, int i16, boolean z16, boolean z17) {
        super(i3, i16);
        this.isFirst = z16;
        this.isLast = z17;
    }

    /* renamed from: isFirst, reason: from getter */
    public final boolean getIsFirst() {
        return this.isFirst;
    }

    /* renamed from: isLast, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    public final boolean isSelected(@Nullable Selection sel) {
        boolean z16;
        boolean z17;
        if (sel == null) {
            return false;
        }
        if (sel.isEmpty()) {
            if (sel.getMStart() >= getMStart() && sel.getMEnd() < getMEnd()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (sel.getMStart() >= getMStart() && sel.getMEnd() <= getMEnd()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z16 && (!z17 || !this.isLast)) {
                return false;
            }
        } else if (Math.max(getMStart(), sel.getMStart()) >= Math.min(getMEnd(), sel.getMEnd())) {
            return false;
        }
        return true;
    }
}
