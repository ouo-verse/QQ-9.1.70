package com.qzone.reborn.feedx.presenter;

import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerFrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CellColorfulTail;
import cooperation.qzone.model.TailColor;
import eo.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010&R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010DR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010DR\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010/\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/i;", "Lvg/a;", "", "L", "T", "P", "", "M", "U", "Lcooperation/qzone/model/CellColorfulTail;", TextNode.MODE_TAIL, "O", "", "url", BdhLogUtil.LogTag.Tag_Req, "title", "content", ExifInterface.LATITUDE_SOUTH, "k", "", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", "onViewHolderDetachedFromWindow", "c", DKHippyEvent.EVENT_STOP, "Lcooperation/qzone/model/TailColor;", "tailColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, UserInfo.SEX_FEMALE, "Landroid/view/View;", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "titleTextView", "I", "contentTextView", "J", "lineView", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "K", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "shimmerLayout", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "parentOnScrollListener", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "parentRecyclerView", "N", "Ljava/lang/String;", "feedCellId", "maxLength", "Z", "isEnableShimmerExperiment", "", "[I", "barrierAnimationStart", "barrierAnimationReset", "animationStartCount", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView contentTextView;

    /* renamed from: J, reason: from kotlin metadata */
    private View lineView;

    /* renamed from: K, reason: from kotlin metadata */
    private QUIShimmerFrameLayout shimmerLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private RecyclerView.OnScrollListener parentOnScrollListener;

    /* renamed from: M, reason: from kotlin metadata */
    private RecyclerView parentRecyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    private String feedCellId;

    /* renamed from: P, reason: from kotlin metadata */
    private final int maxLength = 9;

    /* renamed from: Q, reason: from kotlin metadata */
    private final boolean isEnableShimmerExperiment = com.qzone.reborn.layer.part.u.INSTANCE.a();

    /* renamed from: R, reason: from kotlin metadata */
    private final int[] barrierAnimationStart = new int[2];

    /* renamed from: S, reason: from kotlin metadata */
    private final int[] barrierAnimationReset = new int[2];

    /* renamed from: T, reason: from kotlin metadata */
    private int animationStartCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/i$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                i.this.P();
                i.this.T();
            } else {
                i.this.U();
            }
        }
    }

    private final void L() {
        int k3 = com.qzone.util.ar.k();
        int i3 = (int) (k3 * 0.2d);
        int e16 = com.qzone.util.ar.e(25.0f);
        int[] iArr = this.barrierAnimationStart;
        iArr[0] = i3 - e16;
        iArr[1] = (k3 - i3) + e16;
        int e17 = com.qzone.util.ar.e(83.0f);
        int[] iArr2 = this.barrierAnimationReset;
        iArr2[0] = e17 - e16;
        iArr2[1] = k3;
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerLayout;
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = null;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
            qUIShimmerFrameLayout = null;
        }
        qUIShimmerFrameLayout.updateRepeatCount(0);
        QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.shimmerLayout;
        if (qUIShimmerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
        } else {
            qUIShimmerFrameLayout2 = qUIShimmerFrameLayout3;
        }
        qUIShimmerFrameLayout2.updateXfermode(PorterDuff.Mode.SRC_ATOP);
        this.parentOnScrollListener = new b();
        ViewGroup viewGroup = this.D;
        if (viewGroup instanceof RecyclerView) {
            this.parentRecyclerView = (RecyclerView) viewGroup;
        }
    }

    private final boolean M() {
        if (!this.isEnableShimmerExperiment || this.animationStartCount >= 1 || this.shimmerLayout == null) {
            return false;
        }
        RecyclerView recyclerView = this.parentRecyclerView;
        if (!(recyclerView != null && recyclerView.getScrollState() == 0)) {
            return false;
        }
        int[] iArr = new int[2];
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerLayout;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
            qUIShimmerFrameLayout = null;
        }
        qUIShimmerFrameLayout.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = this.barrierAnimationStart;
        if (i3 >= iArr2[0] && i3 <= iArr2[1]) {
            return true;
        }
        QLog.d(getTAG(), 1, "enablePlayShimmingAnimation shimmerLayout not full visible");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(CellColorfulTail cellColorfulTail, i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        eo.c.f396879a.b();
        yo.d.c(cellColorfulTail.actionUrl, view.getContext());
        this$0.U();
    }

    private final void O(CellColorfulTail tail) {
        String str;
        fo.b l3 = new fo.b().l(tail.reportParam);
        Map<String, Object> f16 = l3.f();
        Intrinsics.checkNotNullExpressionValue(f16, "map.paramMap");
        f16.put("macrotail_type", Integer.valueOf(tail.type));
        Map<String, Object> f17 = l3.f();
        Intrinsics.checkNotNullExpressionValue(f17, "map.paramMap");
        String str2 = tail.name;
        if (TextUtils.isEmpty(tail.desc)) {
            str = "";
        } else {
            str = "|" + tail.desc;
        }
        f17.put("literal_text", str2 + str);
        l3.h(new c.a());
        fo.c.o(this.f441562d, "em_qz_big_tail", l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        if (this.animationStartCount >= 1) {
            int[] iArr = new int[2];
            QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerLayout;
            if (qUIShimmerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
                qUIShimmerFrameLayout = null;
            }
            qUIShimmerFrameLayout.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            int[] iArr2 = this.barrierAnimationReset;
            if (i3 <= iArr2[0] || i3 >= iArr2[1]) {
                QLog.d("QZoneFeedBigTailPresenter", 1, "resetAnimationCountWhenInvisible doReset");
                this.animationStartCount = 0;
            }
        }
    }

    private final void R(String url) {
        Option url2 = Option.obtain().setUrl(url);
        ImageView imageView = this.iconImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
            imageView = null;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(url2.setTargetView(imageView));
    }

    private final void S(String title, String content) {
        int intValue;
        TextView textView = this.titleTextView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setMaxEms(this.maxLength);
        TextView textView3 = this.contentTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
            textView3 = null;
        }
        if (TextUtils.isEmpty(title)) {
            intValue = this.maxLength;
        } else {
            int i3 = this.maxLength;
            Integer valueOf = title != null ? Integer.valueOf(title.length()) : null;
            Intrinsics.checkNotNull(valueOf);
            intValue = i3 - valueOf.intValue();
        }
        textView3.setMaxEms(intValue);
        TextView textView4 = this.titleTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView4 = null;
        }
        textView4.setText(title);
        TextView textView5 = this.contentTextView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
            textView5 = null;
        }
        textView5.setText(content);
        View view = this.lineView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lineView");
            view = null;
        }
        view.setVisibility(TextUtils.isEmpty(content) ? 8 : 0);
        TextView textView6 = this.contentTextView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
        } else {
            textView2 = textView6;
        }
        textView2.setVisibility(TextUtils.isEmpty(content) ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        CellColorfulTail cellColorfulTail;
        if (M()) {
            String str = this.feedCellId;
            BusinessFeedData businessFeedData = this.f441565h;
            QLog.d("QZoneFeedBigTailPresenter", 1, "startShimmerAnimation feedId:" + str + ", " + ((businessFeedData == null || (cellColorfulTail = businessFeedData.cellColorfulTail) == null) ? null : cellColorfulTail.desc));
            this.animationStartCount = this.animationStartCount + 1;
            QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerLayout;
            if (qUIShimmerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
                qUIShimmerFrameLayout = null;
            }
            qUIShimmerFrameLayout.stopShimming(null);
            QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.shimmerLayout;
            if (qUIShimmerFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
                qUIShimmerFrameLayout2 = null;
            }
            qUIShimmerFrameLayout2.startShimming(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerLayout;
        if (qUIShimmerFrameLayout != null) {
            if (qUIShimmerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shimmerLayout");
                qUIShimmerFrameLayout = null;
            }
            qUIShimmerFrameLayout.stopShimming(null);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
        View findViewById = containerView.findViewById(R.id.mym);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026zone_feedx_big_tail_icon)");
        this.iconImageView = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.myq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026one_feedx_big_tail_title)");
        this.titleTextView = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.myl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026e_feedx_big_tail_content)");
        this.contentTextView = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.myn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026zone_feedx_big_tail_line)");
        this.lineView = findViewById4;
        View findViewById5 = containerView.findViewById(R.id.myp);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ail_shimmer_frame_layout)");
        this.shimmerLayout = (QUIShimmerFrameLayout) findViewById5;
        if (this.isEnableShimmerExperiment) {
            L();
        }
        this.f441562d.setVisibility(0);
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        T();
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedBigTailPresenter";
    }

    @Override // vg.a, vg.c
    public void onStop() {
        super.onStop();
        U();
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        RecyclerView recyclerView = this.parentRecyclerView;
        if (recyclerView != null) {
            T();
            RecyclerView.OnScrollListener onScrollListener = this.parentOnScrollListener;
            RecyclerView.OnScrollListener onScrollListener2 = null;
            if (onScrollListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentOnScrollListener");
                onScrollListener = null;
            }
            recyclerView.removeOnScrollListener(onScrollListener);
            RecyclerView.OnScrollListener onScrollListener3 = this.parentOnScrollListener;
            if (onScrollListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentOnScrollListener");
            } else {
                onScrollListener2 = onScrollListener3;
            }
            recyclerView.addOnScrollListener(onScrollListener2);
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderDetachedFromWindow(holder);
        U();
        RecyclerView recyclerView = this.parentRecyclerView;
        if (recyclerView != null) {
            RecyclerView.OnScrollListener onScrollListener = this.parentOnScrollListener;
            if (onScrollListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentOnScrollListener");
                onScrollListener = null;
            }
            recyclerView.removeOnScrollListener(onScrollListener);
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn9;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        CellIdInfo cellIdInfo;
        this.animationStartCount = 0;
        final CellColorfulTail cellColorfulTail = null;
        this.feedCellId = (feedData == null || (cellIdInfo = feedData.cellIdInfo) == null) ? null : cellIdInfo.cellId;
        if (feedData != null) {
            try {
                cellColorfulTail = feedData.cellColorfulTail;
            } catch (Throwable th5) {
                QLog.e("QZoneFeedBigTailPresenter", 1, "onBindData ex: ", th5);
                return;
            }
        }
        if (cellColorfulTail != null && !feedData.isFakeFeed()) {
            com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
            if (!kVar.a()) {
                this.f441562d.setVisibility(0);
                if (kVar.f()) {
                    Q(cellColorfulTail.darkStyle);
                    String str = cellColorfulTail.darkStyle.token;
                    Intrinsics.checkNotNullExpressionValue(str, "tail.darkStyle.token");
                    R(str);
                } else {
                    Q(cellColorfulTail.brightStyle);
                    String str2 = cellColorfulTail.brightStyle.token;
                    Intrinsics.checkNotNullExpressionValue(str2, "tail.brightStyle.token");
                    R(str2);
                }
                S(cellColorfulTail.name, cellColorfulTail.desc);
                this.f441562d.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        i.N(CellColorfulTail.this, this, view);
                    }
                });
                T();
                O(cellColorfulTail);
                return;
            }
        }
        this.f441562d.setVisibility(8);
    }

    public final void Q(TailColor tailColor) {
        if (tailColor == null) {
            return;
        }
        if (!TextUtils.isEmpty(tailColor.backgroundColor)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(com.qzone.widget.util.a.c(tailColor.backgroundColor));
            gradientDrawable.setCornerRadius(com.qzone.util.ar.e(4.0f));
            this.f441562d.setBackground(gradientDrawable);
        }
        if (TextUtils.isEmpty(tailColor.textColor)) {
            return;
        }
        int c16 = com.qzone.widget.util.a.c(tailColor.textColor);
        TextView textView = this.titleTextView;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setTextColor(c16);
        TextView textView2 = this.contentTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTextView");
            textView2 = null;
        }
        textView2.setTextColor(c16);
        View view2 = this.lineView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lineView");
        } else {
            view = view2;
        }
        view.setBackgroundColor(c16);
    }
}
