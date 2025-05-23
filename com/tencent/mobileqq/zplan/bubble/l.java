package com.tencent.mobileqq.zplan.bubble;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001d\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0011\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/R\u0011\u0010\u0006\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00109\u001a\u0002068F\u00a2\u0006\u0006\u001a\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/l;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Lyi3/e;", "bubbleInfo", "", "u", "t", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "delayMillis", "o", tl.h.F, "other", "", "i", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, HippyTKDListViewAdapter.X, "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/bubble/c;", "e", "Lcom/tencent/mobileqq/zplan/bubble/c;", "impl", "Lcom/tencent/mobileqq/zplan/bubble/BubbleStatus;", "f", "Lcom/tencent/mobileqq/zplan/bubble/BubbleStatus;", "status", "I", "canceledMark", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnHideForeverDelayFinishedListener", "()Lkotlin/jvm/functions/Function1;", "v", "(Lkotlin/jvm/functions/Function1;)V", "onHideForeverDelayFinishedListener", "Lmf3/a;", "Lmf3/a;", "report", "k", "()Lyi3/e;", ReportConstant.COSTREPORT_PREFIX, "()Z", "isClickable", "Landroid/graphics/Rect;", "l", "()Landroid/graphics/Rect;", "globalVisibleRect", "", "externalEntrance", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/bubble/c;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class l implements Comparable<l> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c<?> impl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BubbleStatus status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int canceledMark;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super l, Unit> onHideForeverDelayFinishedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final mf3.a report;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f332021a;

        static {
            int[] iArr = new int[BubbleStatus.values().length];
            try {
                iArr[BubbleStatus.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BubbleStatus.HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f332021a = iArr;
        }
    }

    public l(Context context, c<?> impl, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.context = context;
        this.impl = impl;
        this.status = BubbleStatus.UNINITIALIZED;
        this.report = mf3.a.INSTANCE.b(k(), str);
    }

    private final void j() {
        this.impl.setOnClickListener(null);
        this.impl.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(WeakReference thisRef, int i3) {
        Intrinsics.checkNotNullParameter(thisRef, "$thisRef");
        l lVar = (l) thisRef.get();
        if (lVar != null && i3 == lVar.canceledMark) {
            lVar.n();
            Function1<? super l, Unit> function1 = lVar.onHideForeverDelayFinishedListener;
            if (function1 != null) {
                function1.invoke(lVar);
            }
        }
    }

    private final void q() {
        this.impl.onCreate();
        if (this.impl.isClickable()) {
            this.impl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.bubble.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.r(l.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(l this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
    }

    public final void h() {
        this.canceledMark++;
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(l other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return k().getType() - other.k().getType();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [yi3.e] */
    public final yi3.e k() {
        return this.impl.c();
    }

    public final Rect l() {
        return this.impl.d();
    }

    public final void m() {
        if (this.status != BubbleStatus.SHOWING) {
            return;
        }
        this.impl.onHide();
        this.status = BubbleStatus.HIDDEN;
    }

    public final void n() {
        BubbleStatus bubbleStatus = this.status;
        BubbleStatus bubbleStatus2 = BubbleStatus.UNINITIALIZED;
        if (bubbleStatus == bubbleStatus2) {
            return;
        }
        h();
        m();
        j();
        this.status = bubbleStatus2;
    }

    public final boolean s() {
        return this.impl.isClickable();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [yi3.e] */
    public void t() {
        Uri jumpUrl;
        if (this.status == BubbleStatus.SHOWING && (jumpUrl = this.impl.c().getJumpUrl()) != null) {
            this.context.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, jumpUrl));
            mf3.a aVar = this.report;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final boolean u(yi3.e bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        return this.impl.b(bubbleInfo);
    }

    public final void v(Function1<? super l, Unit> function1) {
        this.onHideForeverDelayFinishedListener = function1;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [yi3.e] */
    public final void w() {
        int i3 = a.f332021a[this.status.ordinal()];
        if (i3 == 1) {
            q();
            this.impl.onShow();
            this.status = BubbleStatus.SHOWING;
            int showExpire = this.impl.c().getShowExpire();
            h();
            o(showExpire * 1000);
        } else {
            if (i3 != 2) {
                return;
            }
            this.impl.onShow();
            this.status = BubbleStatus.SHOWING;
        }
        mf3.a aVar = this.report;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void x(FrameLayout parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.impl.a(parent);
    }

    public final void o(long delayMillis) {
        if (delayMillis <= 0 || this.status == BubbleStatus.UNINITIALIZED) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        final int i3 = this.canceledMark;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.bubble.k
            @Override // java.lang.Runnable
            public final void run() {
                l.p(weakReference, i3);
            }
        }, delayMillis);
    }
}
