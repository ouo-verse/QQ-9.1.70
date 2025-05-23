package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cg0.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView;", "Landroid/widget/FrameLayout;", "", "pagUrl", "", "g", "l", "j", "f", "filePath", h.F, "picUrl", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "d", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "pagContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "coverView", "Lorg/libpag/PAGView;", "Lorg/libpag/PAGView;", "pagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanPagView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View parentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup pagContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView coverView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PAGView pagView;

    public ECXingHuanPagView(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.pagView == null) {
            a.b("ECXingHuanPagView", "addPagView");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            PAGView pAGView = new PAGView(getContext());
            pAGView.setLayoutParams(layoutParams);
            pAGView.setScaleMode(1);
            Unit unit = Unit.INSTANCE;
            this.pagView = pAGView;
            this.pagContainer.addView(pAGView);
        }
    }

    private final void g(String pagUrl) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new ECXingHuanPagView$configPagContainer$1(this, pagUrl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String filePath) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setPath(filePath);
            pAGView.addListener(new b(filePath));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        this.pagContainer.setVisibility(8);
        this.coverView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        this.pagContainer.setVisibility(0);
        this.coverView.setVisibility(8);
    }

    public final void k() {
        PAGView pAGView = this.pagView;
        if (pAGView == null || pAGView.isPlaying()) {
            return;
        }
        l();
        pAGView.play();
    }

    public final void m() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            j();
            pAGView.stop();
        }
    }

    public ECXingHuanPagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ECXingHuanPagView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ECXingHuanPagView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.parentView = LayoutInflater.from(context).inflate(R.layout.cva, (ViewGroup) this, true);
        this.pagContainer = (ViewGroup) findViewById(R.id.o5z);
        this.coverView = (ImageView) findViewById(R.id.nuw);
    }

    public final void i(String pagUrl, String picUrl) {
        if (!(pagUrl == null || pagUrl.length() == 0)) {
            g(pagUrl);
        }
        if (picUrl == null || picUrl.length() == 0) {
            return;
        }
        ImageViewKt.b(this.coverView, picUrl, 0, 0, 0, 14, null);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView$configPagView$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements PAGView.PAGViewListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f101935e;

        b(String str) {
            this.f101935e = str;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView view) {
            ECXingHuanPagView.this.j();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView view) {
            ECXingHuanPagView.this.j();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView view) {
            ECXingHuanPagView.this.l();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView view) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView view) {
        }
    }
}
