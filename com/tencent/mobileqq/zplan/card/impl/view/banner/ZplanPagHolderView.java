package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.RoundFrameLayout;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001eJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanPagHolderView;", "Lcom/tencent/sqshow/widget/RoundFrameLayout;", "Lkotlin/Function0;", "", "runnable", DomainData.DOMAIN_NAME, "", "l", "Ljava/lang/Runnable;", "p", "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView;", "k", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/card/impl/view/banner/ZplanBannerPagView;", "pagView", "D", "Z", "pagViewReady", "E", "Ljava/lang/Runnable;", "postRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanPagHolderView extends RoundFrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private ZplanBannerPagView pagView;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean pagViewReady;

    /* renamed from: E, reason: from kotlin metadata */
    private Runnable postRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagHolderView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        final long currentTimeMillis = System.currentTimeMillis();
        if (PagLoader.c().d()) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ZplanBannerPagView zplanBannerPagView = new ZplanBannerPagView(context2);
            this.pagView = zplanBannerPagView;
            addView(zplanBannerPagView);
            QLog.i("ZplanPagHolderView", 1, "load pag view direct : cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ");
            setVisibility(0);
            this.pagViewReady = true;
            return;
        }
        PagLoader.c().f(getContext(), new PagLoader.b() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.i
            @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
            public final void onComplete(boolean z16) {
                ZplanPagHolderView.j(ZplanPagHolderView.this, currentTimeMillis, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final ZplanPagHolderView this$0, final long j3, final boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.j
            @Override // java.lang.Runnable
            public final void run() {
                ZplanPagHolderView.m(z16, this$0, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z16, ZplanPagHolderView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZplanBannerPagView zplanBannerPagView = new ZplanBannerPagView(context);
            this$0.pagView = zplanBannerPagView;
            this$0.addView(zplanBannerPagView);
            this$0.setVisibility(0);
            this$0.invalidate();
            this$0.pagViewReady = true;
            Runnable runnable = this$0.postRunnable;
            if (runnable != null) {
                runnable.run();
            }
            QLog.i("ZplanPagHolderView", 1, "load pag view after load so : cost: " + (System.currentTimeMillis() - j3) + " ");
            return;
        }
        this$0.setVisibility(8);
        QLog.e("ZplanPagHolderView", 1, "add load pag so failed ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 runnable, ZplanPagHolderView this$0) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        runnable.invoke();
        this$0.postRunnable = null;
    }

    /* renamed from: k, reason: from getter */
    public final ZplanBannerPagView getPagView() {
        return this.pagView;
    }

    public final boolean l() {
        ZplanBannerPagView zplanBannerPagView;
        if (!this.pagViewReady || (zplanBannerPagView = this.pagView) == null) {
            return false;
        }
        Intrinsics.checkNotNull(zplanBannerPagView);
        return zplanBannerPagView.r();
    }

    public final void n(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (this.pagViewReady) {
            runnable.invoke();
        } else {
            this.postRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.k
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanPagHolderView.o(Function0.this, this);
                }
            };
        }
    }

    public final void p(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (l()) {
            runnable.run();
            return;
        }
        ZplanBannerPagView zplanBannerPagView = this.pagView;
        if (zplanBannerPagView != null) {
            zplanBannerPagView.z(new ZplanPagHolderView$runAfterPagViewReady$1(runnable));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagHolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        final long currentTimeMillis = System.currentTimeMillis();
        if (PagLoader.c().d()) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ZplanBannerPagView zplanBannerPagView = new ZplanBannerPagView(context2);
            this.pagView = zplanBannerPagView;
            addView(zplanBannerPagView);
            QLog.i("ZplanPagHolderView", 1, "load pag view direct : cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ");
            setVisibility(0);
            this.pagViewReady = true;
            return;
        }
        PagLoader.c().f(getContext(), new PagLoader.b() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.i
            @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
            public final void onComplete(boolean z16) {
                ZplanPagHolderView.j(ZplanPagHolderView.this, currentTimeMillis, z16);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagHolderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        final long currentTimeMillis = System.currentTimeMillis();
        if (PagLoader.c().d()) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ZplanBannerPagView zplanBannerPagView = new ZplanBannerPagView(context2);
            this.pagView = zplanBannerPagView;
            addView(zplanBannerPagView);
            QLog.i("ZplanPagHolderView", 1, "load pag view direct : cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ");
            setVisibility(0);
            this.pagViewReady = true;
            return;
        }
        PagLoader.c().f(getContext(), new PagLoader.b() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.i
            @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
            public final void onComplete(boolean z16) {
                ZplanPagHolderView.j(ZplanPagHolderView.this, currentTimeMillis, z16);
            }
        });
    }
}
