package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.RightTextRecyclerLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.ioc.operate.api.IParentViewAttacher;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final int f91235a = ViewUtils.dip2px(32.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final int f91236b = ViewUtils.dip2px(248.0f);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static final class a implements RightTextRecyclerLayout.a {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f91237a;

        /* renamed from: b, reason: collision with root package name */
        private int f91238b = -1;

        a(Runnable runnable) {
            this.f91237a = runnable;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.RightTextRecyclerLayout.a
        public void a() {
            Runnable runnable;
            if (this.f91238b == 1 && (runnable = this.f91237a) != null) {
                runnable.run();
            }
            this.f91238b = -1;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.RightTextRecyclerLayout.a
        public void b(int i3) {
            if (this.f91238b == i3) {
                return;
            }
            this.f91238b = i3;
            if (i3 == 1) {
                ad.u(50L);
            }
        }
    }

    private static Size b(View view, int i3, int i16, float f16) {
        int i17 = i(view);
        if (i17 > 0 && i16 > i17) {
            i3 = (int) (i17 / f16);
            i16 = i17;
        }
        return new Size(i3, i16);
    }

    public static void c(final ImageView imageView, final Option option) {
        imageView.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.p(imageView, option);
            }
        }).start();
    }

    private static float d(Size size, float f16) {
        int width = size.getWidth();
        int height = size.getHeight();
        if (width > 0 && height > 0) {
            return size.getHeight() / size.getWidth();
        }
        return f16;
    }

    private static float e(Size size, float f16) {
        int width = size.getWidth();
        int height = size.getHeight();
        if (width > 0 && height > 0 && height / width <= 1.3333334f) {
            return size.getHeight() / size.getWidth();
        }
        return f16;
    }

    public static Drawable f(@ColorInt int i3, int i16, int i17, int i18) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, ViewUtils.dip2px(i16));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.setBounds(0, 0, ViewUtils.dip2px(i17), ViewUtils.dip2px(i18));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i3);
        paint.setStyle(Paint.Style.FILL);
        return shapeDrawable;
    }

    public static Size g(View view) {
        int min = (int) (Math.min(k(), j()) * 0.55f);
        return b(view, min, (int) (min * 1.3333334f), 1.3333334f);
    }

    private static Size h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        int i16;
        int i17 = feedCloudMeta$StFeed.type.get();
        if (i17 == 3) {
            i3 = feedCloudMeta$StFeed.video.height.get();
            i16 = feedCloudMeta$StFeed.video.width.get();
        } else if (i17 == 2) {
            i3 = feedCloudMeta$StFeed.cover.height.get();
            i16 = feedCloudMeta$StFeed.cover.width.get();
        } else {
            if (QCircleHostConstants._AppSetting.isPublicVersion()) {
                return new Size(0, 0);
            }
            throw new UnsupportedOperationException("unsupported type: " + i17);
        }
        return new Size(i16, i3);
    }

    private static int i(View view) {
        if (view != null) {
            Object m3 = m(view);
            while (m3 instanceof View) {
                View view2 = (View) m3;
                if (view2.getId() == R.id.f52532a2) {
                    return (int) (view2.getHeight() * 0.9f);
                }
                m3 = m(view2);
            }
            return 0;
        }
        return 0;
    }

    private static int j() {
        return DisplayUtil.getInstantScreenHeight(RFWApplication.getApplication());
    }

    private static int k() {
        return DisplayUtil.getInstantScreenWidth(RFWApplication.getApplication());
    }

    public static Size l(View view) {
        int i3 = f91236b;
        return b(view, i3, (int) (i3 * 1.3333334f), 1.3333334f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ViewParent m(@NonNull View view) {
        if (view instanceof IParentViewAttacher) {
            return ((IParentViewAttacher) view).getParentView();
        }
        return view.getParent();
    }

    private static void n(RightTextRecyclerLayout rightTextRecyclerLayout, String str, Runnable runnable) {
        rightTextRecyclerLayout.setText(str);
        rightTextRecyclerLayout.setTextColor(rightTextRecyclerLayout.getContext().getResources().getColor(R.color.qvideo_skin_color_text_secondary));
        int dip2px = ViewUtils.dip2px(14.0f);
        int dip2px2 = ViewUtils.dip2px(16.0f);
        int dip2px3 = ViewUtils.dip2px(14.0f);
        rightTextRecyclerLayout.setTextSize(dip2px);
        rightTextRecyclerLayout.setMarginEnd(dip2px2 + dip2px3);
        rightTextRecyclerLayout.setTextMargin(ViewUtils.dip2px(7.0f));
        rightTextRecyclerLayout.d();
        rightTextRecyclerLayout.c(new RightTextRecyclerLayout.b(dip2px + (dip2px3 << 1), 1.0f));
        rightTextRecyclerLayout.c(new RightTextRecyclerLayout.b(ViewUtils.dip2px(10.0f), 3.0f));
        rightTextRecyclerLayout.setListener(new a(runnable));
    }

    private static void o(RightTextRecyclerLayout rightTextRecyclerLayout) {
        rightTextRecyclerLayout.setText(null);
        rightTextRecyclerLayout.d();
        rightTextRecyclerLayout.c(new RightTextRecyclerLayout.b(Integer.MAX_VALUE, 2.0f));
        rightTextRecyclerLayout.setListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(ImageView imageView, Option option) {
        imageView.setVisibility(4);
        q50.b.e().b(option);
        imageView.setAlpha(1.0f);
    }

    public static Size q(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16, View view) {
        boolean z16;
        Size h16 = h(feedCloudMeta$StFeed);
        if (h16.getWidth() > h16.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new Size(i3, i16);
        }
        float d16 = d(h16, 1.7777778f);
        return b(view, (int) (i16 / d16), i16, d16);
    }

    public static Size r(FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view, boolean z16) {
        boolean z17;
        float d16;
        int i3;
        Size h16 = h(feedCloudMeta$StFeed);
        if (h16.getWidth() > h16.getHeight()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            d16 = d(h16, 0.5625f);
            i3 = k() - f91235a;
        } else if (z16) {
            d16 = e(h16, 1.3333334f);
            i3 = f91236b;
        } else {
            d16 = d(h16, 1.7777778f);
            i3 = f91236b;
        }
        return b(view, i3, (int) (i3 * d16), d16);
    }

    public static void s(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(str).setLoadingDrawableColor(0));
        }
    }

    public static void t(RightTextRecyclerLayout rightTextRecyclerLayout, Collection<FeedCloudMeta$StFeed> collection, String str, Runnable runnable) {
        if (collection.size() == 1) {
            o(rightTextRecyclerLayout);
        } else {
            n(rightTextRecyclerLayout, str, runnable);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void u(long j3) {
        try {
            Vibrator vibrator = (Vibrator) QCircleApplication.getAPP().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(j3);
            }
        } catch (Exception e16) {
            QLog.e("QFSSearchWidgetUtil", 1, e16, new Object[0]);
        }
    }
}
