package com.tencent.mobileqq.gamecenter.qa.editor.span;

import android.text.Layout;
import android.text.style.AlignmentSpan;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.d;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00102\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004:\u0001\u0011B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0000H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/span/AlignmentSpan;", "Landroid/text/style/AlignmentSpan$Standard;", "Lzd1/e;", "Landroid/text/Layout$Alignment;", "Lzd1/d;", "b", "", "d", "Z", "mIsRTL", "c", "()Landroid/text/Layout$Alignment;", "value", "align", "<init>", "(Landroid/text/Layout$Alignment;Z)V", "e", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AlignmentSpan extends AlignmentSpan.Standard implements e<Layout.Alignment>, d<Layout.Alignment> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<Layout.Alignment, Layout.Alignment> f212441f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsRTL;

    static {
        HashMap hashMap = new HashMap();
        f212441f = hashMap;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        hashMap.put(alignment, alignment);
        hashMap.put(Layout.Alignment.ALIGN_NORMAL, Layout.Alignment.ALIGN_OPPOSITE);
        hashMap.put(Layout.Alignment.ALIGN_OPPOSITE, Layout.Alignment.ALIGN_NORMAL);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AlignmentSpan(@Nullable Layout.Alignment alignment, boolean z16) {
        super(alignment);
        alignment = z16 ? f212441f.get(alignment) : alignment;
        Intrinsics.checkNotNull(alignment);
        this.mIsRTL = z16;
    }

    @Override // zd1.d
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AlignmentSpan a() {
        return new AlignmentSpan(getValue(), this.mIsRTL);
    }

    @Override // zd1.e
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Layout.Alignment getValue() {
        Layout.Alignment alignment = getAlignment();
        if (this.mIsRTL) {
            return f212441f.get(alignment);
        }
        return alignment;
    }
}
