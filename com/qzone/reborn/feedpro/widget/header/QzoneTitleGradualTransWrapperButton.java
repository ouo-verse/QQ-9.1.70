package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\nH\u0014R*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneTitleGradualTransWrapperButton;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/reborn/feedpro/widget/header/ae;", "transItem", "", "n0", "o0", "Landroid/view/View;", "view", "p0", "", "getLayoutId", com.tencent.luggage.wxa.c8.c.G, "m0", "", "value", "e", UserInfo.SEX_FEMALE, HippyQQPagView.FunctionName.GET_PROGRESS, "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", "progress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneTitleGradualTransWrapperButton extends QZoneBaseWidgetView<ae> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneTitleGradualTransWrapperButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void n0(ae transItem) {
        transItem.getEndItem().setAlpha(this.progress);
        transItem.getStartItem().setAlpha(1.0f - this.progress);
        o0(transItem);
        p0(transItem.getEndItem());
        p0(transItem.getStartItem());
    }

    private final void o0(ae transItem) {
        if (this.progress < 0.95f) {
            transItem.getStartItem().setClickable(true);
            transItem.getEndItem().setClickable(false);
            transItem.getStartItem().bringToFront();
        } else {
            transItem.getStartItem().setClickable(false);
            transItem.getEndItem().setClickable(true);
            transItem.getEndItem().bringToFront();
        }
    }

    private final void p0(View view) {
        if (view.getAlpha() <= 0.01f) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneTitleGradualTransWrapperButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzoneTitleGradualTransWrapperButton(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(ae transItem, int pos) {
        if (transItem != null) {
            addView(transItem.getEndItem());
            addView(transItem.getStartItem());
            transItem.getEndItem().setAlpha(0.0f);
            transItem.getStartItem().setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneTitleGradualTransWrapperButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setProgress(float f16) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0.0f, 1.0f);
        this.progress = coerceIn;
        ae data = getData();
        if (data != null) {
            n0(data);
        }
    }
}
