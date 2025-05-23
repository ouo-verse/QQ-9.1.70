package com.tencent.mobileqq.friend.contact;

import com.tencent.biz.qui.dragrefresh.QUIDragRefreshView;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/ContactDragRefreshViewWrap;", "Lwc1/a;", "", "a", "b", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "onPostThemeChanged", "c", "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView;", "Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView;", "childView", "<init>", "(Lcom/tencent/biz/qui/dragrefresh/QUIDragRefreshView;)V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ContactDragRefreshViewWrap implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QUIDragRefreshView childView;

    public ContactDragRefreshViewWrap(QUIDragRefreshView childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.childView = childView;
    }

    @Override // wc1.a
    public void a() {
        this.childView.r();
    }

    @Override // wc1.a
    public void b() {
        this.childView.t();
        this.childView.p();
    }

    @Override // wc1.a
    public void onPostThemeChanged() {
        this.childView.p();
        this.childView.r();
    }

    @Override // wc1.a
    public float c(float progress) {
        if (progress < 0.0f) {
            progress = 0.0f;
        }
        this.childView.setVisibility(progress >= 0.0f ? 0 : 4);
        if (progress > 0.5f) {
            return 0.5f;
        }
        return progress;
    }

    @Override // wc1.a
    public void setProgress(float progress) {
        float f16 = ((progress * 6) / 5) + 0.4f;
        this.childView.setDragProgress(f16);
        this.childView.setScaleX(f16);
        this.childView.setScaleY(f16);
    }
}
