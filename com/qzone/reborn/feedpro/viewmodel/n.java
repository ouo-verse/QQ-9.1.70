package com.qzone.reborn.feedpro.viewmodel;

import com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView;
import com.qzone.reborn.feedx.viewmodel.r;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/n;", "Lcom/qzone/reborn/feedx/viewmodel/r;", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "listener", "", "Z1", "U1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "refreshProgressProvider", "", "D", "Z", "W1", "()Z", "X1", "(Z)V", "isPublishBarCeilingEnd", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends r {

    /* renamed from: C, reason: from kotlin metadata */
    private QzoneFeedProRefreshHeaderView.b refreshProgressProvider;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPublishBarCeilingEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/n$a", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProRefreshHeaderView$b;", "", "d", "offsetY", "", "e", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements QzoneFeedProRefreshHeaderView.b {
        a() {
        }

        @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
        public void a() {
            QzoneFeedProRefreshHeaderView.b bVar = n.this.refreshProgressProvider;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
        public int d() {
            QzoneFeedProRefreshHeaderView.b bVar = n.this.refreshProgressProvider;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
        public void e(int offsetY) {
            QzoneFeedProRefreshHeaderView.b bVar = n.this.refreshProgressProvider;
            if (bVar != null) {
                bVar.e(offsetY);
            }
        }

        @Override // com.qzone.reborn.feedpro.widget.header.QzoneFeedProRefreshHeaderView.b
        public void f() {
            QzoneFeedProRefreshHeaderView.b bVar = n.this.refreshProgressProvider;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    public final QzoneFeedProRefreshHeaderView.b U1() {
        return new a();
    }

    /* renamed from: W1, reason: from getter */
    public final boolean getIsPublishBarCeilingEnd() {
        return this.isPublishBarCeilingEnd;
    }

    public final void X1(boolean z16) {
        this.isPublishBarCeilingEnd = z16;
    }

    public final void Z1(QzoneFeedProRefreshHeaderView.b listener) {
        this.refreshProgressProvider = listener;
    }
}
