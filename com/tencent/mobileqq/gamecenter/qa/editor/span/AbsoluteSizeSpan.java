package com.tencent.mobileqq.gamecenter.qa.editor.span;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.d;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/span/AbsoluteSizeSpan;", "Landroid/text/style/AbsoluteSizeSpan;", "Lzd1/e;", "", "Lzd1/d;", "a", "b", "()Ljava/lang/Integer;", "value", "size", "<init>", "(I)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AbsoluteSizeSpan extends android.text.style.AbsoluteSizeSpan implements e<Integer>, d<Integer> {
    public AbsoluteSizeSpan(int i3) {
        super(i3);
    }

    @Override // zd1.d
    @Nullable
    public d<Integer> a() {
        return new AbsoluteSizeSpan(getSize());
    }

    @Override // zd1.e
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        return Integer.valueOf(getSize());
    }
}
