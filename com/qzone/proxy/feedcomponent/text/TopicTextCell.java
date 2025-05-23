package com.qzone.proxy.feedcomponent.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/proxy/feedcomponent/text/TopicTextCell;", "Lcom/qzone/proxy/feedcomponent/text/ColorTextCell;", "", "a", "<init>", "()V", "", "type", "(I)V", "", "text", "(ILjava/lang/String;)V", "textColor", "(ILjava/lang/String;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class TopicTextCell extends ColorTextCell {
    public TopicTextCell() {
        super(1);
    }

    private final void a() {
        setTextColor(ef.a.f396213a.a("#465A90", -16776961));
    }

    public Object clone() {
        return super.clone();
    }

    public TopicTextCell(int i3) {
        super(i3, null);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTextCell(int i3, String text) {
        super(i3, text);
        Intrinsics.checkNotNullParameter(text, "text");
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTextCell(int i3, String text, int i16) {
        super(i3, text, i16);
        Intrinsics.checkNotNullParameter(text, "text");
        a();
    }
}
