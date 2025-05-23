package com.tencent.sqshow.zootopia.portal.home.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0001\nB\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+B\u001b\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b*\u0010.B#\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0006\u00a2\u0006\u0004\b*\u00100J\b\u0010\u0003\u001a\u00020\u0001H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/BaseIndicator;", "Landroid/view/View;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/a;", "b", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/b;", "d", "", "count", "currentPosition", "", "a", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "", "isFakeEdgeItem", "c", "state", "onPageScrollStateChanged", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/b;", "e", "()Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/b;", "setHelper", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/b;)V", "helper", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "f", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mPaint", UserInfo.SEX_FEMALE, "g", "()F", "setOffset", "(F)V", "offset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class BaseIndicator extends View implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.portal.home.banner.indicator.b helper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float offset;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372372a;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.BELOW_BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f372372a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.a
    public void a(int count, int currentPosition) {
        QLog.i("BaseIndicator", 1, "onPageChanged count:" + count + ", currentPosition:" + currentPosition);
        this.helper.t(count);
        this.helper.q(currentPosition);
        requestLayout();
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.a
    public View b() {
        if (this.helper.getAttachToBanner()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            int i3 = b.f372372a[this.helper.getCom.tencent.ditto.shell.LayoutAttrDefine.Gravity.Gravity java.lang.String().ordinal()];
            if (i3 == 1) {
                layoutParams.addRule(9);
            } else if (i3 == 2) {
                layoutParams.addRule(14);
            } else if (i3 == 3) {
                layoutParams.addRule(11);
            } else if (i3 == 4) {
                layoutParams.addRule(14);
                layoutParams.addRule(12);
            }
            layoutParams.leftMargin = this.helper.getMargins().getLeftMargin();
            layoutParams.rightMargin = this.helper.getMargins().getRightMargin();
            layoutParams.topMargin = this.helper.getMargins().getTopMargin();
            layoutParams.bottomMargin = this.helper.getMargins().getBottomMargin();
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
    public void c(int position, boolean isFakeEdgeItem) {
        QLog.i("BaseIndicator", 1, "onPageSelected position:" + position);
        this.helper.q(position);
        invalidate();
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.indicator.a
    /* renamed from: d, reason: from getter */
    public com.tencent.sqshow.zootopia.portal.home.banner.indicator.b getHelper() {
        return this.helper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tencent.sqshow.zootopia.portal.home.banner.indicator.b e() {
        return this.helper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f, reason: from getter */
    public final Paint getMPaint() {
        return this.mPaint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g, reason: from getter */
    public final float getOffset() {
        return this.offset;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        QLog.i("BaseIndicator", 1, "onPageScrolled position:" + position + ", positionOffset:" + positionOffset + ", positionOffsetPixels:" + positionOffsetPixels);
        this.offset = positionOffset;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new com.tencent.sqshow.zootopia.portal.home.banner.indicator.b();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(0);
        this.mPaint.setColor(this.helper.getNormalColor());
    }

    @Override // com.tencent.sqshow.zootopia.portal.home.banner.c
    public void onPageScrollStateChanged(int state) {
    }
}
