package com.qzone.reborn.message.section;

import android.view.View;
import bl.CommonNoticeBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0004J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/message/section/y;", "Lcom/qzone/reborn/base/l;", "Lbl/a;", "Landroid/view/View;", "view", "", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "elementView", "", "elementId", "w", "Ldl/e;", "e", "Ldl/e;", "operateIoc", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", "y", "()Landroid/view/View$OnClickListener;", "spaceClickListener", "Landroid/view/View$OnLongClickListener;", tl.h.F, "Landroid/view/View$OnLongClickListener;", HippyTKDListViewAdapter.X, "()Landroid/view/View$OnLongClickListener;", "longClickListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class y extends com.qzone.reborn.base.l<CommonNoticeBean> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private dl.e operateIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener spaceClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.w
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            y.C(y.this, view);
        }
    };

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View.OnLongClickListener longClickListener = new View.OnLongClickListener() { // from class: com.qzone.reborn.message.section.x
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            boolean A;
            A = y.A(y.this, view);
            return A;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(y this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return this$0.B(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B(View view) {
        if (this.operateIoc == null) {
            this.operateIoc = (dl.e) q(dl.e.class);
        }
        dl.e eVar = this.operateIoc;
        if (eVar == null) {
            return true;
        }
        eVar.K4((CommonNoticeBean) this.mData, this.mPosition);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(y this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.z(view);
        CommonNoticeBean commonNoticeBean = (CommonNoticeBean) this$0.mData;
        if (commonNoticeBean != null) {
            gl.b.f402374a.c(view, commonNoticeBean);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(View elementView, String elementId) {
        Intrinsics.checkNotNullParameter(elementView, "elementView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        CommonNoticeBean commonNoticeBean = (CommonNoticeBean) this.mData;
        if (commonNoticeBean != null) {
            gl.b.f402374a.d(elementView, elementId, commonNoticeBean);
        }
    }

    /* renamed from: x, reason: from getter */
    public final View.OnLongClickListener getLongClickListener() {
        return this.longClickListener;
    }

    /* renamed from: y, reason: from getter */
    public final View.OnClickListener getSpaceClickListener() {
        return this.spaceClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void z(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.operateIoc == null) {
            this.operateIoc = (dl.e) q(dl.e.class);
        }
        dl.e eVar = this.operateIoc;
        if (eVar != null) {
            eVar.E8((CommonNoticeBean) this.mData);
        }
    }
}
