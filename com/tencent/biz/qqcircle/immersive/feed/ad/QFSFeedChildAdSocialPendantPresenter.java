package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class QFSFeedChildAdSocialPendantPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private GdtAd I;
    private View J;
    private View K;
    private TextView L;
    private LinearLayout M;
    private int N;

    private void h1(QFSFeedAdCardAnimEvent qFSFeedAdCardAnimEvent) {
        String str;
        if (qFSFeedAdCardAnimEvent == null) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[handleCardAnimEvent] error, event is null");
            return;
        }
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, qFSFeedAdCardAnimEvent.getTraceId())) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[handleCardAnimEvent] error, not the same ad");
            return;
        }
        QLog.i("QFSFeedChildAdSocialPendantPresenter", 2, "[handleCardAnimEvent] state:" + qFSFeedAdCardAnimEvent.getState() + " status:" + qFSFeedAdCardAnimEvent.getStatus());
        if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "1")) {
            p1();
        } else if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "2") && qFSFeedAdCardAnimEvent.getStatus() == 1) {
            i1();
        }
    }

    private void i1() {
        if (!eq.f85700a.b(this.I, this.N)) {
            QLog.i("QFSFeedChildAdSocialPendantPresenter", 2, "[hidePendantView] canShowSocialPendant false");
        } else {
            s1(8);
        }
    }

    private void j1() {
        if (!eq.f85700a.b(this.I, this.N)) {
            QLog.i("QFSFeedChildAdSocialPendantPresenter", 2, "[initAndUpdateView] canShowSocialPendant false");
            return;
        }
        k1();
        l1();
        t1();
    }

    private void k1() {
        if (this.J != null) {
            return;
        }
        View view = this.C;
        if (view == null) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[initCardView] error, mRootView is null");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.v9u);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[initCardView]", th5);
            }
        }
        this.J = this.C.findViewById(R.id.v9q);
    }

    private void l1() {
        View view = this.J;
        if (view == null) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[initSocialPendantView] mCardView is null");
            return;
        }
        if (this.K != null) {
            QLog.i("QFSFeedChildAdSocialPendantPresenter", 1, "[initSocialPendantView] mPendantView is ready");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f38791_x);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, th5, new Object[0]);
            }
        }
        View findViewById = this.J.findViewById(R.id.f38781_w);
        this.K = findViewById;
        if (findViewById == null) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[initSocialPendantView] mPendantView is ready");
        } else {
            this.L = (TextView) findViewById.findViewById(R.id.f38771_v);
            this.M = (LinearLayout) this.K.findViewById(R.id.f38761_u);
        }
    }

    private static List<Integer> n1(int i3, int i16) {
        int i17 = (i16 - i3) + 1;
        if (i16 < i3) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i18 = i3; i18 < i3 + i17; i18++) {
            arrayList.add(Integer.valueOf(i18));
        }
        try {
            Collections.shuffle(arrayList);
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[randomArray] error", th5);
        }
        return arrayList;
    }

    private void o1() {
        View view = this.K;
        if (view != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = this.M;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        TextView textView = this.L;
        if (textView != null) {
            textView.setText("");
        }
    }

    private void p1() {
        if (!eq.f85700a.b(this.I, this.N)) {
            QLog.i("QFSFeedChildAdSocialPendantPresenter", 2, "[showPendantView] canShowSocialPendant false");
        } else {
            s1(0);
        }
    }

    private void q1() {
        Drawable drawable;
        int i3;
        Context m06 = m0();
        if (this.M != null && m06 != null) {
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{872415231});
            List<Integer> n16 = n1(0, b.SOCIAL_PENDANT_URL_LIST.length - 1);
            if (n16 == null) {
                QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantImageLayout] error, imageIndexes is null");
                return;
            }
            try {
                drawable = m06.getResources().getDrawable(R.drawable.nc_);
            } catch (Throwable unused) {
                QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantImageLayout] error, can't get defaultDrawable");
                drawable = null;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < 3; i17++) {
                if (i17 >= n16.size()) {
                    QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantImageLayout] error, count index out of bound");
                } else {
                    if (n16.get(i17) != null) {
                        i3 = n16.get(i17).intValue();
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                    String[] strArr = b.SOCIAL_PENDANT_URL_LIST;
                    if (i3 < strArr.length && i3 >= 0) {
                        ShapeableImageView shapeableImageView = new ShapeableImageView(m06);
                        shapeableImageView.setStrokeWidth(GdtUIUtils.dp2px(0.84f, m06.getResources()));
                        shapeableImageView.setStrokeColor(colorStateList);
                        shapeableImageView.setClipToOutline(true);
                        shapeableImageView.setShapeAppearanceModel(com.google.android.material.shape.g.a().p(com.google.android.material.shape.g.f34052m).m());
                        int dp2px = GdtUIUtils.dp2px(20.0f, m06.getResources());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px, dp2px);
                        layoutParams.setMargins(i16 * (-1), 0, 0, 0);
                        shapeableImageView.setLayoutParams(layoutParams);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = drawable;
                        obtain.mFailedDrawable = drawable;
                        shapeableImageView.setImageDrawable(URLDrawable.getDrawable(strArr[i3], obtain));
                        this.M.addView(shapeableImageView);
                        i16 = GdtUIUtils.dp2px(10.0f, m06.getResources());
                    } else {
                        QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantImageLayout] error, imageIndex out of bound");
                    }
                }
            }
            return;
        }
        QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantImageLayout] error, View is null");
    }

    private void r1() {
        String L = af.L(this.I);
        if (TextUtils.isEmpty(L)) {
            QLog.i("QFSFeedChildAdSocialPendantPresenter", 2, "[updatePendantText] text is null");
            return;
        }
        TextView textView = this.L;
        if (textView == null) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 1, "[updatePendantText] error, View is null");
        } else {
            textView.setText(L);
        }
    }

    private void s1(final int i3) {
        if (x0() != null) {
            x0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdSocialPendantPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSFeedChildAdSocialPendantPresenter.this.K != null) {
                        QFSFeedChildAdSocialPendantPresenter.this.K.setVisibility(i3);
                    }
                }
            });
        }
    }

    private void t1() {
        q1();
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSFeedAdCardAnimEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        int i16;
        super.L0(feedCloudMeta$StFeed, i3);
        GdtAd gdtAd = new GdtAd(u.e(this.E));
        String traceId = gdtAd.getTraceId();
        GdtAd gdtAd2 = this.I;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
            QLog.e("QFSFeedChildAdSocialPendantPresenter", 2, "[onBindData] ignore, is the same ad");
            return;
        }
        o1();
        this.I = gdtAd;
        FeedCloudMeta$StFeed c16 = u.c(this.E);
        if (c16 != null) {
            i16 = c16.status.get();
        } else {
            i16 = Integer.MIN_VALUE;
        }
        this.N = i16;
        j1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedAdCardAnimEvent) {
            h1((QFSFeedAdCardAnimEvent) QFSFeedAdCardAnimEvent.class.cast(simpleBaseEvent));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdSocialPendantPresenter";
    }
}
