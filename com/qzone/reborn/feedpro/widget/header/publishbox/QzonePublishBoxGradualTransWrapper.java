package com.qzone.reborn.feedpro.widget.header.publishbox;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import ue.a;
import ue.b;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016R*\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/publishbox/QzonePublishBoxGradualTransWrapper;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lue/b;", "Lue/a;", "transItem", "", "n0", "o0", "", "getLayoutId", c.G, "m0", "d0", "Landroid/content/Intent;", "intent", "G", "", "value", "e", UserInfo.SEX_FEMALE, HippyQQPagView.FunctionName.GET_PROGRESS, "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", "progress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzonePublishBoxGradualTransWrapper extends QZoneBaseWidgetView<b> implements a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzonePublishBoxGradualTransWrapper(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void n0(b transItem) {
        transItem.getEndItem().n().setAlpha(this.progress);
        transItem.getStartItem().n().setAlpha(1.0f - this.progress);
        o0(transItem);
    }

    private final void o0(b transItem) {
        if (this.progress < 0.9f) {
            transItem.getStartItem().n().setClickable(true);
            transItem.getEndItem().n().setClickable(false);
            transItem.getStartItem().n().bringToFront();
        } else {
            transItem.getStartItem().n().setClickable(false);
            transItem.getEndItem().n().setClickable(true);
            transItem.getEndItem().n().bringToFront();
        }
    }

    @Override // ue.a
    public void G(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        b data = getData();
        if (data != null) {
            data.getStartItem().G(intent);
            data.getEndItem().G(intent);
        }
    }

    @Override // ue.a
    public void d0() {
        if (getData() != null) {
            getData().getStartItem().d0();
            getData().getEndItem().d0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzonePublishBoxGradualTransWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzonePublishBoxGradualTransWrapper(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(b transItem, int pos) {
        if (transItem != null) {
            addView(transItem.getEndItem().n());
            addView(transItem.getStartItem().n());
            transItem.getEndItem().n().setAlpha(0.0f);
            transItem.getStartItem().n().setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzonePublishBoxGradualTransWrapper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setProgress(float f16) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0.0f, 1.0f);
        this.progress = coerceIn;
        b data = getData();
        if (data != null) {
            n0(data);
        }
    }
}
