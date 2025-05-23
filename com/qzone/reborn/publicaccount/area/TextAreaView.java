package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.util.AttributeSet;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.publicaccount.i;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/TextAreaView;", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class TextAreaView extends QZoneRichTextView {

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/TextAreaView$a;", "", "Landroid/content/Context;", "context", "", "template", "Lcom/qzone/reborn/publicaccount/area/TextAreaView;", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.publicaccount.area.TextAreaView$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextAreaView a(Context context, int template) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextAreaView textAreaView = new TextAreaView(context);
            textAreaView.setTextSize(ViewUtils.getSpValue(14.0f));
            textAreaView.setMaxLine(1);
            textAreaView.setEllipsisStr("");
            i iVar = i.f58780a;
            if (iVar.c(template)) {
                textAreaView.setTextColor(context.getResources().getColor(R.color.qui_common_text_allwhite_primary));
            } else if (iVar.d(template)) {
                textAreaView.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
            }
            textAreaView.setClickable(false);
            textAreaView.setLongclickable(false);
            textAreaView.setCellClickable(false);
            return textAreaView;
        }

        public final TextAreaView b(Context context, int template) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextAreaView textAreaView = new TextAreaView(context);
            textAreaView.setTextSize(ViewUtils.getSpValue(17.0f));
            textAreaView.setMaxLine(1);
            textAreaView.setEllipsisStr("");
            i iVar = i.f58780a;
            if (iVar.c(template)) {
                textAreaView.setTextColor(context.getResources().getColor(R.color.qui_common_text_allwhite_primary));
            } else if (iVar.d(template)) {
                textAreaView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
            }
            textAreaView.setClickable(false);
            textAreaView.setLongclickable(false);
            textAreaView.setCellClickable(false);
            return textAreaView;
        }

        Companion() {
        }
    }

    public TextAreaView(Context context) {
        super(context);
    }

    public TextAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextAreaView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
