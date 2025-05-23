package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryPreItemView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class QFSGalleryPreListView extends QCircleBaseWidgetView<FeedCloudMeta$StFeed> {
    private static final int H = ViewUtils.dpToPx(33.0f);
    private static final int I = ViewUtils.dpToPx(44.0f);
    private static final int J = ViewUtils.dpToPx(2.0f);
    private static final int K = ViewUtils.dpToPx(9.0f);
    private static final int L = ViewUtils.dpToPx(70.0f);
    private int C;
    private float D;
    private d E;
    private e F;
    private SpannableStringBuilder G;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f93238d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.gallery.adapter.a f93239e;

    /* renamed from: f, reason: collision with root package name */
    private QFSGalleryPreItemView f93240f;

    /* renamed from: h, reason: collision with root package name */
    private QFSGalleryPreItemView f93241h;

    /* renamed from: i, reason: collision with root package name */
    private QFSGalleryPreItemView f93242i;

    /* renamed from: m, reason: collision with root package name */
    private int f93243m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getAdapter() == null || QFSGalleryPreListView.this.f93239e.getItemCount() <= 1) {
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                rect.left = QFSGalleryPreListView.L;
            } else if (childAdapterPosition == recyclerView.getAdapter().getItemCount() - 1) {
                rect.right = QFSGalleryPreListView.L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends CharacterStyle {
        c() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(QFSGalleryPreListView.this.getContext().getColor(R.color.cla));
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onSelected(int i3);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    public QFSGalleryPreListView(@NonNull Context context) {
        this(context, null);
    }

    private void A0(int i3) {
        String valueOf = String.valueOf(i3 + 1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(valueOf + " / " + this.f93243m);
        spannableStringBuilder.setSpan(new c(), 0, valueOf.length(), 33);
        this.G = spannableStringBuilder;
        e eVar = this.F;
        if (eVar != null) {
            eVar.a(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i3) {
        QFSGalleryPreItemView qFSGalleryPreItemView;
        d dVar = this.E;
        if (dVar != null) {
            dVar.onSelected(i3);
        }
        A0(i3);
        for (int i16 = 0; i16 < this.f93238d.getChildCount(); i16++) {
            View childAt = this.f93238d.getChildAt(i16);
            if (this.f93238d.getChildLayoutPosition(childAt) == i3) {
                QLog.d("QFSGalleryPreListView", 1, "updateSelectedViews pos:" + i3);
                QFSGalleryPreItemView qFSGalleryPreItemView2 = this.f93240f;
                if (qFSGalleryPreItemView2 != null && qFSGalleryPreItemView2 != childAt) {
                    qFSGalleryPreItemView2.p0();
                }
                QFSGalleryPreItemView qFSGalleryPreItemView3 = (QFSGalleryPreItemView) childAt;
                this.f93240f = qFSGalleryPreItemView3;
                qFSGalleryPreItemView3.o0();
                QFSGalleryPreItemView qFSGalleryPreItemView4 = null;
                if (i16 > 0) {
                    qFSGalleryPreItemView = (QFSGalleryPreItemView) this.f93238d.getChildAt(i16 - 1);
                } else {
                    qFSGalleryPreItemView = null;
                }
                this.f93241h = qFSGalleryPreItemView;
                if (i16 < this.f93238d.getChildCount() - 1) {
                    qFSGalleryPreItemView4 = (QFSGalleryPreItemView) this.f93238d.getChildAt(i16 + 1);
                }
                this.f93242i = qFSGalleryPreItemView4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(View view, int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.leftMargin = i16;
        layoutParams.rightMargin = i16;
        view.setLayoutParams(layoutParams);
    }

    private void initView() {
        this.f93238d = (RecyclerView) findViewById(R.id.f42861kx);
        this.f93239e = new com.tencent.biz.qqcircle.immersive.gallery.adapter.a();
        this.f93238d.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
        this.f93238d.setAdapter(this.f93239e);
        this.f93238d.addItemDecoration(new a());
        this.f93238d.addOnScrollListener(new b());
    }

    private int u0(float f16) {
        int i3 = L;
        int i16 = (i3 * 2) + (this.f93243m * ((J * 2) + H));
        float f17 = i16 * f16;
        if (f17 < ImmersiveUtils.getScreenWidth() * i3) {
            return 0;
        }
        if (f17 > ImmersiveUtils.getScreenWidth() * (i16 - i3)) {
            return this.f93243m - 1;
        }
        return (((int) (f16 - ((ImmersiveUtils.getScreenWidth() * i3) / i16))) * this.f93243m) / (ImmersiveUtils.getScreenWidth() - (((i3 * 2) * ImmersiveUtils.getScreenWidth()) / i16));
    }

    private void y0() {
        if (this.f93240f != null && this.f93241h != null) {
            QLog.d("QFSGalleryPreListView", 1, "startLeftDragAnimation left" + this.f93241h.getLeft() + "width" + this.f93241h.getWidth());
            C0(this.f93240f.m0(), H, J);
            C0(this.f93241h.m0(), I, K);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.75f, 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 1.0f);
            scaleAnimation.setDuration(200L);
            TranslateAnimation translateAnimation = new TranslateAnimation(r4 - r5, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            this.f93241h.m0().startAnimation(animationSet);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.33f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 1.0f);
            scaleAnimation2.setDuration(200L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(r4 - r5, 0.0f, 0.0f, 0.0f);
            translateAnimation2.setDuration(200L);
            AnimationSet animationSet2 = new AnimationSet(false);
            animationSet2.addAnimation(scaleAnimation2);
            animationSet2.addAnimation(translateAnimation2);
            this.f93240f.m0().startAnimation(animationSet2);
            int i3 = this.C - 1;
            this.C = i3;
            B0(i3);
        }
    }

    private void z0() {
        if (this.f93240f != null && this.f93242i != null) {
            QLog.d("QFSGalleryPreListView", 1, "startRightDragAnimation left" + this.f93242i.getLeft() + "width" + this.f93242i.getWidth());
            C0(this.f93240f.m0(), H, J);
            C0(this.f93242i.m0(), I, K);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.75f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 1.0f);
            scaleAnimation.setDuration(200L);
            TranslateAnimation translateAnimation = new TranslateAnimation(r5 - r4, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            this.f93242i.m0().startAnimation(animationSet);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.33f, 1.0f, 1.0f, 1.0f, 1, 0.0f, 1, 1.0f);
            scaleAnimation2.setDuration(200L);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(r5 - r4, 0.0f, 0.0f, 0.0f);
            translateAnimation2.setDuration(200L);
            AnimationSet animationSet2 = new AnimationSet(false);
            animationSet2.addAnimation(scaleAnimation2);
            animationSet2.addAnimation(translateAnimation2);
            this.f93240f.m0().startAnimation(animationSet2);
            int i3 = this.C + 1;
            this.C = i3;
            B0(i3);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gnc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f93243m = feedCloudMeta$StFeed.images.size();
        this.f93239e.setDatas(feedCloudMeta$StFeed.images.get());
    }

    public void setOnItemSelectedListener(d dVar) {
        this.E = dVar;
    }

    public void setTextChangeListener(e eVar) {
        this.F = eVar;
        SpannableStringBuilder spannableStringBuilder = this.G;
        if (spannableStringBuilder != null) {
            eVar.a(spannableStringBuilder);
        }
    }

    public void v0(float f16) {
        QFSGalleryPreItemView qFSGalleryPreItemView;
        QFSGalleryPreItemView qFSGalleryPreItemView2;
        if (this.f93240f == null) {
            return;
        }
        this.f93238d.scrollBy((int) (((((((H + (J * 2)) * (this.f93243m - 1)) + I) + (K * 2)) + (L * 2)) * (f16 - this.D)) / ImmersiveUtils.getScreenWidth()), 0);
        if (f16 - this.D > 0.0f && (qFSGalleryPreItemView2 = this.f93240f) != null && f16 > qFSGalleryPreItemView2.getLeft() + this.f93240f.getWidth()) {
            z0();
        } else if (f16 - this.D < 0.0f && (qFSGalleryPreItemView = this.f93240f) != null && f16 < qFSGalleryPreItemView.getLeft()) {
            y0();
        }
        this.D = f16;
    }

    public void w0(final float f16) {
        final int u06 = u0(f16);
        this.C = u06;
        this.f93238d.scrollToPosition(u06);
        this.D = f16;
        QLog.d("QFSGalleryPreListView", 1, "setSelection" + u06);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView.1
            @Override // java.lang.Runnable
            public void run() {
                QFSGalleryPreListView.this.B0(u06);
                if (QFSGalleryPreListView.this.f93240f == null) {
                    return;
                }
                QFSGalleryPreListView qFSGalleryPreListView = QFSGalleryPreListView.this;
                qFSGalleryPreListView.C0(qFSGalleryPreListView.f93240f.m0(), QFSGalleryPreListView.I, QFSGalleryPreListView.K);
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = QFSGalleryPreListView.this.f93238d.findViewHolderForLayoutPosition(u06);
                if (findViewHolderForLayoutPosition != null) {
                    QFSGalleryPreListView.this.f93238d.scrollBy(((findViewHolderForLayoutPosition.itemView.getLeft() - QFSGalleryPreListView.this.f93238d.getPaddingLeft()) + (findViewHolderForLayoutPosition.itemView.getWidth() / 2)) - ((int) f16), 0);
                }
            }
        });
    }

    public void x0() {
        this.D = 0.0f;
        this.f93239e.setDatas(new ArrayList());
    }

    public QFSGalleryPreListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSGalleryPreListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }
}
