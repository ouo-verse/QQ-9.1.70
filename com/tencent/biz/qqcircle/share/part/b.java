package com.tencent.biz.qqcircle.share.part;

import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.widgets.QFSShareBottomPlayRateView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/share/part/b;", "Lcom/tencent/mobileqq/multishare/part/b;", "Landroid/view/View;", "z9", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "e", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "getShareInfo", "()Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class b extends com.tencent.mobileqq.multishare.part.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleShareInfo shareInfo;

    public b(@NotNull QCircleShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        this.shareInfo = shareInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
    }

    @Override // com.tencent.mobileqq.multishare.part.b
    @NotNull
    public View z9() {
        QFSShareBottomPlayRateView qFSShareBottomPlayRateView = new QFSShareBottomPlayRateView(getContext());
        qFSShareBottomPlayRateView.d(this.shareInfo, new QFSShareBottomPlayRateView.b() { // from class: com.tencent.biz.qqcircle.share.part.a
            @Override // com.tencent.biz.qqcircle.widgets.QFSShareBottomPlayRateView.b
            public final void onClick() {
                b.C9(b.this);
            }
        });
        return qFSShareBottomPlayRateView;
    }
}
