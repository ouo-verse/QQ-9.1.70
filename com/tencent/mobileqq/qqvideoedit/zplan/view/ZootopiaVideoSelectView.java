package com.tencent.mobileqq.qqvideoedit.zplan.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ik2.GifClipData;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0002FGB'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0006\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\b\u0010 \u0012\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010 R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010 R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010 R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010 R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010 R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010 R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010 R\u0018\u00109\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView;", "Landroid/widget/RelativeLayout;", "", "c", "Landroid/view/View;", "T", "", "viewId", "d", "(I)Landroid/view/View;", "i", "topMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "leftMargin", "l", "Landroid/view/MotionEvent;", "event", "f", "view", "ev", "", "k", "videoWidth", "videoHeight", "g", "Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView$a;", "listener", "setOnClipChangedListener", "Lik2/d;", "e", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "I", "getMMoveType$annotations", "()V", "mMoveType", "Z", "mStartMoving", "", UserInfo.SEX_FEMALE, "mDownRawX", h.F, "mDownRawY", "mDownTopMargin", "mDownLeftMargin", BdhLogUtil.LogTag.Tag_Conn, "mMaxTopMargin", "D", "mMaxLeftMargin", "E", "mMidViewWidth", "mMidViewHeight", "G", "mVideoWidth", "H", "mVideoHeight", "Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView$a;", "mOnClipChangedListener", "Landroid/util/SparseArray;", "J", "Landroid/util/SparseArray;", "cacheViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "Companion", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ZootopiaVideoSelectView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mMaxTopMargin;

    /* renamed from: D, reason: from kotlin metadata */
    private int mMaxLeftMargin;

    /* renamed from: E, reason: from kotlin metadata */
    private int mMidViewWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int mMidViewHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private int mVideoWidth;

    /* renamed from: H, reason: from kotlin metadata */
    private int mVideoHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private a mOnClipChangedListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<View> cacheViews;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mMoveType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mStartMoving;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mDownRawX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mDownRawY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mDownTopMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mDownLeftMargin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView$a;", "", "Lik2/d;", "data", "", "z6", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void z6(@NotNull GifClipData data);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZootopiaVideoSelectView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        float width;
        int i3 = this.mVideoHeight;
        int i16 = this.mVideoWidth;
        if (i3 > i16) {
            this.mMoveType = 2;
            width = (i16 / i3) * getHeight();
        } else {
            this.mMoveType = 1;
            width = getWidth() * (i3 / i16);
        }
        QLog.i("ZootopiaVideoSelectView_", 4, "mVideoWidth:" + this.mVideoWidth + ", mVideoHeight:" + this.mVideoHeight + ", size:" + width);
        int i17 = (int) width;
        this.mMidViewWidth = i17;
        this.mMidViewHeight = i17;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mMidViewWidth, this.mMidViewHeight);
        if (this.mMoveType == 2) {
            layoutParams.addRule(14);
            layoutParams.topMargin = (int) ((getHeight() / 2) - (width / 2));
            this.mMaxTopMargin = getHeight() - i17;
            ((RelativeLayout) d(R.id.z6c)).setLayoutParams(layoutParams);
            m(layoutParams.topMargin);
            return;
        }
        layoutParams.addRule(15);
        layoutParams.leftMargin = (int) ((getWidth() / 2) - (width / 2));
        this.mMaxLeftMargin = getWidth() - i17;
        ((RelativeLayout) d(R.id.z6c)).setLayoutParams(layoutParams);
        l(layoutParams.leftMargin);
    }

    private final <T extends View> T d(int viewId) {
        T t16 = (T) this.cacheViews.get(viewId);
        if (t16 == null) {
            t16 = (T) findViewById(viewId);
            Intrinsics.checkNotNull(t16);
            this.cacheViews.put(viewId, t16);
        }
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.mobileqq.qqvideoedit.zplan.view.ZootopiaVideoSelectView.findView");
        return t16;
    }

    private final void f(MotionEvent event) {
        int coerceAtLeast;
        int coerceAtMost;
        int coerceAtLeast2;
        int coerceAtMost2;
        int i3 = this.mMoveType;
        if (i3 != 1) {
            if (i3 == 2) {
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((int) (this.mDownTopMargin + (event.getRawY() - this.mDownRawY)), 0);
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast2, this.mMaxTopMargin);
                m(coerceAtMost2);
                return;
            }
            return;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (this.mDownLeftMargin + (event.getRawX() - this.mDownRawX)), 0);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, this.mMaxLeftMargin);
        l(coerceAtMost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaVideoSelectView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(0);
        a aVar = this$0.mOnClipChangedListener;
        if (aVar != null) {
            aVar.z6(this$0.e());
        }
    }

    private final void i() {
        ((RelativeLayout) d(R.id.z6c)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaVideoSelectView.j(ZootopiaVideoSelectView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZootopiaVideoSelectView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), "clicked", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean k(View view, MotionEvent ev5) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight()).contains((int) ev5.getRawX(), (int) ev5.getRawY());
    }

    private final void l(int leftMargin) {
        ViewGroup.LayoutParams layoutParams = ((RelativeLayout) d(R.id.z6c)).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = leftMargin;
        ((RelativeLayout) d(R.id.z6c)).setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = d(R.id.ygr).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.rightMargin = leftMargin * (-1);
        d(R.id.ygr).setLayoutParams(layoutParams4);
        requestLayout();
    }

    private final void m(int topMargin) {
        ViewGroup.LayoutParams layoutParams = ((RelativeLayout) d(R.id.z6c)).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = topMargin;
        ((RelativeLayout) d(R.id.z6c)).setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = d(R.id.f99575q6).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.bottomMargin = topMargin * (-1);
        d(R.id.f99575q6).setLayoutParams(layoutParams4);
        requestLayout();
    }

    @NotNull
    public final GifClipData e() {
        if (this.mMoveType == 2) {
            Intrinsics.checkNotNull(((RelativeLayout) d(R.id.z6c)).getLayoutParams(), "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            float f16 = ((RelativeLayout.LayoutParams) r0).topMargin * 1.0f;
            return new GifClipData(0.0f, f16 / getHeight(), 1.0f, (f16 + this.mMidViewHeight) / getHeight());
        }
        Intrinsics.checkNotNull(((RelativeLayout) d(R.id.z6c)).getLayoutParams(), "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        float f17 = ((RelativeLayout.LayoutParams) r0).leftMargin * 1.0f;
        return new GifClipData(f17 / getWidth(), 0.0f, (f17 + this.mMidViewWidth) / getWidth(), 1.0f);
    }

    public final void g(int videoWidth, int videoHeight) {
        if (videoWidth > 0 && videoHeight > 0) {
            if (this.mVideoWidth == videoWidth && this.mVideoHeight == videoHeight) {
                if (QLog.isColorLevel()) {
                    QLog.i("ZootopiaVideoSelectView_", 2, "width and height is not changed.");
                    return;
                }
                return;
            } else {
                this.mVideoWidth = videoWidth;
                this.mVideoHeight = videoHeight;
                c();
                post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaVideoSelectView.h(ZootopiaVideoSelectView.this);
                    }
                });
                return;
            }
        }
        QLog.e("ZootopiaVideoSelectView_", 1, "bad video info!");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        if (ev5 == null || ev5.getAction() != 0) {
            return false;
        }
        if (k(d(R.id.z6c), ev5)) {
            QLog.i("ZootopiaVideoSelectView_", 4, "onInterceptTouchEvent return true");
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (event == null) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(event);
                    }
                } else {
                    if (this.mStartMoving) {
                        f(event);
                    }
                    return true;
                }
            }
            this.mStartMoving = false;
            f(event);
            a aVar = this.mOnClipChangedListener;
            if (aVar != null) {
                aVar.z6(e());
            }
            return true;
        }
        if (k(d(R.id.z6c), event)) {
            this.mStartMoving = true;
            this.mDownRawX = event.getRawX();
            this.mDownRawY = event.getRawY();
            ViewGroup.LayoutParams layoutParams = ((RelativeLayout) d(R.id.z6c)).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            this.mDownTopMargin = ((RelativeLayout.LayoutParams) layoutParams).topMargin;
            ViewGroup.LayoutParams layoutParams2 = ((RelativeLayout) d(R.id.z6c)).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            this.mDownLeftMargin = ((RelativeLayout.LayoutParams) layoutParams2).leftMargin;
            return true;
        }
        this.mStartMoving = false;
        this.mDownRawX = 0.0f;
        this.mDownRawY = 0.0f;
        this.mDownTopMargin = 0;
        this.mDownLeftMargin = 0;
        return false;
    }

    public final void setOnClipChangedListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnClipChangedListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZootopiaVideoSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaVideoSelectView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZootopiaVideoSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMoveType = 2;
        this.cacheViews = new SparseArray<>();
        View.inflate(context, R.layout.i8x, this);
        i();
    }
}
