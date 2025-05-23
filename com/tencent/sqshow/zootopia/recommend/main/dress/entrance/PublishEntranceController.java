package com.tencent.sqshow.zootopia.recommend.main.dress.entrance;

import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u000f\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0002\f B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController;", "", "", "dy", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/a;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", h.F, "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "g", "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout$c;", "f", "a", "I", "verticalOffset", "com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$b", "b", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$b;", "mScrollListener", "c", "Lcom/tencent/sqshow/zootopia/portal/detail/scrollingheader/ScrollingHeaderLayout$c;", "mAppLayoutScrollListener", "com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$mCheckRunnable$1", "d", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$mCheckRunnable$1;", "mCheckRunnable", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "mAutoShowTask", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/a;)V", "MyRunnable", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PublishEntranceController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int verticalOffset;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b mScrollListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ScrollingHeaderLayout.c mAppLayoutScrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final PublishEntranceController$mCheckRunnable$1 mCheckRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Runnable mAutoShowTask;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$MyRunnable;", "Ljava/lang/Runnable;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface MyRunnable extends Runnable {
    }

    public PublishEntranceController(final a entrance) {
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        this.mScrollListener = new b(entrance);
        this.mAppLayoutScrollListener = new ScrollingHeaderLayout.c() { // from class: com.tencent.sqshow.zootopia.recommend.main.dress.entrance.b
            @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout.b
            public final void a(ScrollingHeaderLayout scrollingHeaderLayout, int i3) {
                PublishEntranceController.i(PublishEntranceController.this, entrance, scrollingHeaderLayout, i3);
            }
        };
        this.mCheckRunnable = new PublishEntranceController$mCheckRunnable$1(this);
        this.mAutoShowTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.dress.entrance.c
            @Override // java.lang.Runnable
            public final void run() {
                PublishEntranceController.j(a.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PublishEntranceController this$0, a entrance, ScrollingHeaderLayout scrollingHeaderLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entrance, "$entrance");
        QLog.i("PublishEntranceController_", 4, "onOffsetChanged :: verticalOffset == " + i3);
        this$0.h(this$0.verticalOffset - i3, entrance);
        this$0.verticalOffset = i3;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this$0.mCheckRunnable);
        this$0.mCheckRunnable.a(i3);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this$0.mCheckRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(a entrance) {
        Intrinsics.checkNotNullParameter(entrance, "$entrance");
        entrance.show();
    }

    /* renamed from: f, reason: from getter */
    public final ScrollingHeaderLayout.c getMAppLayoutScrollListener() {
        return this.mAppLayoutScrollListener;
    }

    public final RecyclerView.OnScrollListener g() {
        return this.mScrollListener;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$b", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f372560e;

        b(a aVar) {
            this.f372560e = aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            QLog.d("PublishEntranceController_", 4, "dy:" + dy5);
            PublishEntranceController.this.h(dy5, this.f372560e);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == 0) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(PublishEntranceController.this.mAutoShowTask, 1500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int dy5, a entrance) {
        if (dy5 > 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAutoShowTask);
            entrance.hide();
        } else if (dy5 < 0) {
            entrance.show();
        }
    }
}
