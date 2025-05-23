package com.qzone.reborn.feedpro.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/QzoneFeedProTextContentView;", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setRichText", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "text", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedProTextContentView extends QZoneRichTextView {
    public QzoneFeedProTextContentView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(QzoneFeedProTextContentView this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r rVar = r.f54359a;
        xd.c.f(list, rVar.b(this$0.getContext()), false);
        return xd.c.g(list, rVar.b(this$0.getContext()), false);
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView
    public ArrayList<TextCell> setRichText(CharSequence text) {
        setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedpro.widget.c
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List m3;
                m3 = QzoneFeedProTextContentView.m(QzoneFeedProTextContentView.this, list);
                return m3;
            }
        });
        ArrayList<TextCell> richText = super.setRichText(text);
        Intrinsics.checkNotNullExpressionValue(richText, "super.setRichText(text)");
        return richText;
    }

    public QzoneFeedProTextContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QzoneFeedProTextContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
