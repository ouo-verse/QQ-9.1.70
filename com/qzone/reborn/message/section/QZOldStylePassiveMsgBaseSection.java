package com.qzone.reborn.message.section;

import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/view/View;", "view", "", "y", "Ldl/g;", "e", "Lkotlin/Lazy;", "w", "()Ldl/g;", "operateIoc", "Landroid/view/View$OnClickListener;", "f", "Landroid/view/View$OnClickListener;", HippyTKDListViewAdapter.X, "()Landroid/view/View$OnClickListener;", "spaceClickListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZOldStylePassiveMsgBaseSection extends com.qzone.reborn.base.l<BusinessFeedData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy operateIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener spaceClickListener;

    public QZOldStylePassiveMsgBaseSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<dl.g>() { // from class: com.qzone.reborn.message.section.QZOldStylePassiveMsgBaseSection$operateIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final dl.g invoke() {
                Object q16;
                q16 = QZOldStylePassiveMsgBaseSection.this.q(dl.g.class);
                return (dl.g) q16;
            }
        });
        this.operateIoc = lazy;
        this.spaceClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZOldStylePassiveMsgBaseSection.z(QZOldStylePassiveMsgBaseSection.this, view);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean y(View view) {
        dl.g w3 = w();
        if (w3 == null) {
            return true;
        }
        w3.E6((BusinessFeedData) this.mData, this.mPosition);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QZOldStylePassiveMsgBaseSection this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.y(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    public final dl.g w() {
        return (dl.g) this.operateIoc.getValue();
    }

    /* renamed from: x, reason: from getter */
    public final View.OnClickListener getSpaceClickListener() {
        return this.spaceClickListener;
    }
}
