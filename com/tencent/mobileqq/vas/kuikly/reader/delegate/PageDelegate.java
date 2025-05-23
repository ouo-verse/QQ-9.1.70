package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\bb\u0010cJ0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0004J\b\u0010\n\u001a\u00020\bH\u0004J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0017J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0017J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\bH\u0016R\u001a\u0010&\u001a\u00020\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00102\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\r\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001b\u0010<\u001a\u0002078DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\"\u0010C\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010F\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\"\u0010K\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010G\u001a\u0004\b3\u0010H\"\u0004\bI\u0010JR\"\u0010O\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u0004\bN\u0010BR\"\u0010S\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010>\u001a\u0004\bQ\u0010@\"\u0004\bR\u0010BR\"\u0010U\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010>\u001a\u0004\bU\u0010@\"\u0004\bV\u0010BR\u0014\u0010\u0003\u001a\u00020W8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010XR\u0014\u0010\u0004\u001a\u00020W8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010XR\u0014\u0010Y\u001a\u00020W8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010XR\u0014\u0010Z\u001a\u00020W8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010XR\u0014\u0010\\\u001a\u00020W8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010XR\u0016\u0010_\u001a\u0004\u0018\u00010]8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010^R\u0016\u0010`\u001a\u0004\u0018\u00010]8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010^R\u0016\u0010a\u001a\u0004\u0018\u00010]8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;", "", "", "startX", "startY", "dx", "dy", "animationSpeed", "", "J", "K", "width", "height", "I", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "Landroid/graphics/Canvas;", PM.CANVAS, "y", "v", "t", "B", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "direction", "D", "Landroid/view/MotionEvent;", "event", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "", "p", "o", "w", "Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "g", "()Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "readView", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "c", DomainData.DOMAIN_NAME, "()I", "setViewWidth", "(I)V", "viewWidth", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setViewHeight", "viewHeight", "Landroid/widget/Scroller;", "e", "Lkotlin/Lazy;", tl.h.F, "()Landroid/widget/Scroller;", "scroller", "f", "Z", "r", "()Z", "E", "(Z)V", "isMoved", "getNoNext", UserInfo.SEX_FEMALE, "noNext", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "()Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "setMDirection", "(Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;)V", "mDirection", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Conn, "isCancel", "j", ReportConstant.COSTREPORT_PREFIX, "G", "isRunning", "k", "isStarted", "H", "", "()F", "lastX", "touchX", "l", "touchY", "Landroid/view/View;", "()Landroid/view/View;", "nextPage", "curPage", "prevPage", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class PageDelegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasBookTransitionView readView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int viewWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int viewHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scroller;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isMoved;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean noNext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageDirection mDirection;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isCancel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isStarted;

    public PageDelegate(@NotNull VasBookTransitionView readView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(readView, "readView");
        this.readView = readView;
        Context context = readView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "readView.context");
        this.context = context;
        this.viewWidth = readView.getWidth();
        this.viewHeight = readView.getHeight();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Scroller>() { // from class: com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate$scroller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Scroller invoke() {
                return new Scroller(PageDelegate.this.getReadView().getContext(), new LinearInterpolator());
            }
        });
        this.scroller = lazy;
        this.noNext = true;
        this.mDirection = PageDirection.NONE;
    }

    public abstract void A(@NotNull MotionEvent event);

    public abstract void B(int animationSpeed);

    public final void C(boolean z16) {
        this.isCancel = z16;
    }

    @CallSuper
    public void D(@NotNull PageDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.mDirection = direction;
    }

    public final void E(boolean z16) {
        this.isMoved = z16;
    }

    public final void F(boolean z16) {
        this.noNext = z16;
    }

    public final void G(boolean z16) {
        this.isRunning = z16;
    }

    public final void H(boolean z16) {
        this.isStarted = z16;
    }

    @CallSuper
    public void I(int width, int height) {
        this.viewWidth = width;
        this.viewHeight = height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(int startX, int startY, int dx5, int dy5, int animationSpeed) {
        int abs;
        if (dx5 != 0) {
            abs = (animationSpeed * Math.abs(dx5)) / this.viewWidth;
        } else {
            abs = (animationSpeed * Math.abs(dy5)) / this.viewHeight;
        }
        h().startScroll(startX, startY, dx5, dy5, abs);
        this.isRunning = true;
        this.isStarted = true;
        this.readView.invalidate();
    }

    protected final void K() {
        this.isStarted = false;
        this.isMoved = false;
        this.isRunning = false;
        this.readView.postInvalidate();
    }

    public void a() {
        if (h().computeScrollOffset()) {
            VasBookTransitionView.setTouchPoint$default(this.readView, h().getCurrX(), h().getCurrY(), false, 4, null);
        } else if (this.isStarted) {
            v();
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View b() {
        return this.readView.getCurPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float c() {
        return this.readView.getLastX();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final PageDirection getMDirection() {
        return this.mDirection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View e() {
        return this.readView.getNextPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View f() {
        return this.readView.getPrevPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: g, reason: from getter */
    public final VasBookTransitionView getReadView() {
        return this.readView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Scroller h() {
        return (Scroller) this.scroller.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float i() {
        return this.readView.getStartX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float j() {
        return this.readView.getStartY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float k() {
        return this.readView.getTouchX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float l() {
        return this.readView.getTouchY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m, reason: from getter */
    public final int getViewHeight() {
        return this.viewHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n, reason: from getter */
    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final boolean o() {
        boolean z16 = true;
        if (this.readView.getCurrentIndex() >= this.readView.getPageCount() - 1) {
            z16 = false;
        }
        if (!z16) {
            Toast.makeText(this.readView.getContext(), "\u5df2\u7ecf\u6700\u540e\u4e00\u9875\uff01", 0).show();
        }
        if (!i.f309926a.a("VasBookTransitionView1", this.readView.c())) {
            return false;
        }
        return z16;
    }

    public final boolean p() {
        boolean z16;
        if (this.readView.getCurrentIndex() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!i.f309926a.a("VasBookTransitionView1", this.readView.c())) {
            return false;
        }
        return z16;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsCancel() {
        return this.isCancel;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsMoved() {
        return this.isMoved;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    public abstract void t(int animationSpeed);

    public abstract void u(int animationSpeed);

    public abstract void v();

    public final void x() {
        this.isMoved = false;
        this.noNext = false;
        this.isRunning = false;
        this.isCancel = false;
        D(PageDirection.NONE);
    }

    public abstract void y(@NotNull Canvas canvas);

    public void w() {
    }

    public void z() {
    }
}
