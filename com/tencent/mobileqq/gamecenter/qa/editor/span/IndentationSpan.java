package com.tencent.mobileqq.gamecenter.qa.editor.span;

import android.text.style.LeadingMarginSpan;
import com.tencent.mobileqq.mini.api.MiniConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.d;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004B)\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016R\u001a\u0010\r\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/span/IndentationSpan;", "Landroid/text/style/LeadingMarginSpan$Standard;", "Lzd1/e;", "", "Lzd1/d;", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "getLeadingMargin", "b", "d", "I", "c", "()Ljava/lang/Integer;", "value", "e", "Z", "mIgnoreSpan", "indentation", "isEmpty", "isFirst", "isLast", "<init>", "(IZZZ)V", "ignoreSpan", "(IZ)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class IndentationSpan extends LeadingMarginSpan.Standard implements e<Integer>, d<Integer> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int value;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIgnoreSpan;

    public IndentationSpan(int i3, boolean z16, boolean z17, boolean z18) {
        super(i3);
        this.value = i3;
        this.mIgnoreSpan = z16 && z18 && !z17;
    }

    @Override // zd1.d
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IndentationSpan a() {
        return new IndentationSpan(getValue().intValue(), this.mIgnoreSpan);
    }

    @Override // zd1.e
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    @Override // android.text.style.LeadingMarginSpan.Standard, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        if (this.mIgnoreSpan) {
            return 0;
        }
        return getValue().intValue();
    }

    IndentationSpan(int i3, boolean z16) {
        super(i3);
        this.value = i3;
        this.mIgnoreSpan = z16;
    }
}
