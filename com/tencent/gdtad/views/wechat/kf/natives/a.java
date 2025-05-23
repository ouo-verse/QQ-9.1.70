package com.tencent.gdtad.views.wechat.kf.natives;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.image.GdtRoundedURIImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f109748d;

        b(View view) {
            this.f109748d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Integer)) {
                return;
            }
            this.f109748d.setBackgroundColor(((Integer) animatedValue).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f109749d;

        c(View view) {
            this.f109749d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Integer)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.f109749d.getLayoutParams();
            layoutParams.height = ((Integer) animatedValue).intValue();
            this.f109749d.setLayoutParams(layoutParams);
        }
    }

    public static View a(AdWXCustomerService.Params params, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, boolean z16) {
        long j3;
        String str;
        Ad ad5;
        Ad ad6;
        if (params != null && (ad6 = params.f61350ad) != null) {
            j3 = ad6.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (params != null && (ad5 = params.f61350ad) != null) {
            str = ad5.getTraceId();
        } else {
            str = null;
        }
        if (params != null && params.isValid() && (params.f61350ad instanceof GdtAd)) {
            LayoutInflater from = LayoutInflater.from(params.waekActivity.get());
            if (from == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[build] error, inflater is null, aid:" + j3 + " traceId:" + str + " isDarkMode:" + z16);
                return null;
            }
            View inflate = from.inflate(R.layout.f168005ed3, (ViewGroup) null);
            if (k(params, inflate, onClickListener2, z16) && h(params, inflate, z16) && i(params, inflate, onClickListener2, z16) && e(params, inflate, z16) && f(params, inflate, z16) && j(params, inflate, z16) && g(params, inflate, onClickListener, z16) && d(params, inflate, z16)) {
                QLog.i("GdtWXCustomerServiceViewBuilder", 1, "[build] aid:" + j3 + " traceId:" + str + " isDarkMode:" + z16);
                return inflate;
            }
            QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[build] error, initialize failed, aid:" + j3 + " traceId:" + str + " isDarkMode:" + z16);
            return null;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[build] error, not valid, aid:" + j3 + " traceId:" + str + " isDarkMode:" + z16);
        return null;
    }

    public static Animator b(View view, boolean z16) {
        View view2;
        View view3;
        int i3;
        if (view != null) {
            view2 = view.findViewById(R.id.f165349vn3);
        } else {
            view2 = null;
        }
        if (view != null) {
            view3 = view.findViewById(R.id.f165348vn2);
        } else {
            view3 = null;
        }
        if (view != null && view2 != null && view3 != null) {
            QLog.i("GdtWXCustomerServiceViewBuilder", 1, "[buildAnimator] isDarkMode:" + z16);
            int[] iArr = new int[2];
            iArr[0] = 0;
            if (z16) {
                i3 = 178;
            } else {
                i3 = 76;
            }
            iArr[1] = Color.argb(i3, 0, 0, 0);
            ValueAnimator ofArgb = ValueAnimator.ofArgb(iArr);
            ofArgb.setDuration(660L);
            ofArgb.addUpdateListener(new b(view));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(660L);
            ValueAnimator ofInt = ValueAnimator.ofInt(ViewUtils.dpToPx(60.0f), ViewUtils.dpToPx(325.0f));
            ofInt.setDuration(660L);
            ofInt.addUpdateListener(new c(view2));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat2.setStartDelay(500L);
            ofFloat2.setDuration(500L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofArgb, ofFloat, ofInt, ofFloat2);
            return animatorSet;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[buildAnimator] error");
        return null;
    }

    private static GradientDrawable c(float[] fArr, String str, int i3, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (fArr != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                gradientDrawable.setColor(Color.parseColor(str));
            } catch (Throwable th5) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[createBackgroundDrawable]", th5);
            }
        }
        if (i3 > 0 && !TextUtils.isEmpty(str2)) {
            try {
                gradientDrawable.setStroke(i3, Color.parseColor(str2));
            } catch (Throwable th6) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[createBackgroundDrawable]", th6);
            }
        }
        return gradientDrawable;
    }

    private static boolean d(AdWXCustomerService.Params params, View view, boolean z16) {
        TextView textView;
        if (params != null && params.isValid()) {
            String str = null;
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.vmw);
            } else {
                textView = null;
            }
            if (textView == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdditionalText] error, textView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            Ad ad5 = params.f61350ad;
            if (ad5 instanceof GdtAd) {
                str = ((GdtAd) ad5).getWXCustomerServiceAdditionalText();
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdditionalText] error, params is not valid");
        return false;
    }

    private static boolean e(AdWXCustomerService.Params params, View view, boolean z16) {
        GdtRoundedURIImageView gdtRoundedURIImageView;
        if (params != null && params.isValid()) {
            String str = null;
            if (view != null) {
                gdtRoundedURIImageView = (GdtRoundedURIImageView) view.findViewById(R.id.vmx);
            } else {
                gdtRoundedURIImageView = null;
            }
            if (gdtRoundedURIImageView == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdvertiserLogo] error, imageView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            Ad ad5 = params.f61350ad;
            if (ad5 instanceof GdtAd) {
                str = ((GdtAd) ad5).getAdvertiser_corporate_logo();
            }
            if (!TextUtils.isEmpty(str)) {
                gdtRoundedURIImageView.setImageURL(str);
            } else {
                gdtRoundedURIImageView.setImageResource(R.drawable.jrz);
            }
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdvertiserLogo] error, params is not valid");
        return false;
    }

    private static boolean f(AdWXCustomerService.Params params, View view, boolean z16) {
        TextView textView;
        String str;
        if (params != null && params.isValid()) {
            String str2 = null;
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.vmy);
            } else {
                textView = null;
            }
            if (textView == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdvertiserName] error, textView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            if (z16) {
                str = "#FFFFFF";
            } else {
                str = "#333333";
            }
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Throwable th5) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdvertiserName]", th5);
            }
            Ad ad5 = params.f61350ad;
            if (ad5 instanceof GdtAd) {
                str2 = ((GdtAd) ad5).getAdvertiser_corporate_image_name();
            }
            if (!TextUtils.isEmpty(str2)) {
                textView.setText(str2);
            }
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initAdvertiserName] error, params is not valid");
        return false;
    }

    private static boolean g(AdWXCustomerService.Params params, View view, View.OnClickListener onClickListener, boolean z16) {
        String str;
        View view2;
        TextView textView;
        if (params != null && params.isValid()) {
            float dpToPx = ViewUtils.dpToPx(40.0f);
            float[] fArr = {dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx};
            if (z16) {
                str = "#0066CC";
            } else {
                str = "#0099FF";
            }
            String str2 = null;
            GradientDrawable c16 = c(fArr, str, Integer.MIN_VALUE, null);
            if (view != null) {
                view2 = view.findViewById(R.id.vmz);
            } else {
                view2 = null;
            }
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.f165347vn1);
            } else {
                textView = null;
            }
            if (view2 != null && textView != null) {
                view2.setBackground(c16);
                if (TextUtils.isEmpty(params.f61350ad.getUrlForLandingPage())) {
                    QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initButton] error, url is empty, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                    return false;
                }
                Ad ad5 = params.f61350ad;
                if (ad5 instanceof GdtAd) {
                    str2 = ((GdtAd) ad5).getButtonText(false);
                }
                if (!TextUtils.isEmpty(str2)) {
                    textView.setText(str2);
                }
                if (onClickListener == null) {
                    QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initButton] error, onClickListener is empty, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                    return false;
                }
                view2.setOnClickListener(onClickListener);
                return true;
            }
            QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initButton] error, container or textView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
            return false;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initButton] error, params is not valid");
        return false;
    }

    private static boolean h(AdWXCustomerService.Params params, View view, boolean z16) {
        String str;
        if (params != null && params.isValid()) {
            float dpToPx = ViewUtils.dpToPx(12.0f);
            float[] fArr = {dpToPx, dpToPx, dpToPx, dpToPx, 0.0f, 0.0f, 0.0f, 0.0f};
            if (z16) {
                str = "#262626";
            } else {
                str = "#FFFFFF";
            }
            View view2 = null;
            GradientDrawable c16 = c(fArr, str, Integer.MIN_VALUE, null);
            if (view != null) {
                view2 = view.findViewById(R.id.f165349vn3);
            }
            if (view2 == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initCardContainerBackground] error, cardContainer is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            view2.setBackground(c16);
            view2.setOnClickListener(new ViewOnClickListenerC1171a());
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initCardContainerBackground] error, params is not valid");
        return false;
    }

    private static boolean i(AdWXCustomerService.Params params, View view, View.OnClickListener onClickListener, boolean z16) {
        View view2;
        if (params != null && params.isValid()) {
            if (view != null) {
                view2 = view.findViewById(R.id.f165350vn4);
            } else {
                view2 = null;
            }
            if (view2 == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initCloseButton] error, closeView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            if (onClickListener == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initCloseButton] error, onClickListener is empty, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            view2.setOnClickListener(onClickListener);
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initCloseButton] error, params is not valid");
        return false;
    }

    private static boolean j(AdWXCustomerService.Params params, View view, boolean z16) {
        String str;
        TextView textView;
        if (params != null && params.isValid()) {
            float dpToPx = ViewUtils.dpToPx(2.0f);
            float[] fArr = {dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx};
            int dpToPx2 = ViewUtils.dpToPx(0.5f);
            if (z16) {
                str = "#666666";
            } else {
                str = GameCenterVideoViewController.GRAY_MASK;
            }
            String str2 = null;
            GradientDrawable c16 = c(fArr, null, dpToPx2, str);
            if (view != null) {
                textView = (TextView) view.findViewById(R.id.vn5);
            } else {
                textView = null;
            }
            if (textView == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initConsultingText] error, textView is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            textView.setBackground(c16);
            Ad ad5 = params.f61350ad;
            if (ad5 instanceof GdtAd) {
                str2 = ((GdtAd) ad5).getWXCustomerServiceConsultingText();
            }
            if (!TextUtils.isEmpty(str2)) {
                textView.setText(str2);
            }
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initConsultingText] error, params is not valid");
        return false;
    }

    private static boolean k(AdWXCustomerService.Params params, View view, View.OnClickListener onClickListener, boolean z16) {
        if (params != null && params.isValid()) {
            if (view == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initRootView] error, view is null, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            if (onClickListener == null) {
                QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initRootView] error, onClickListener is empty, aid:" + params.f61350ad.getAId() + " traceId:" + params.f61350ad.getTraceId());
                return false;
            }
            view.setOnClickListener(onClickListener);
            return true;
        }
        QLog.e("GdtWXCustomerServiceViewBuilder", 1, "[initRootView] error, params is not valid");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.views.wechat.kf.natives.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class ViewOnClickListenerC1171a implements View.OnClickListener {
        ViewOnClickListenerC1171a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
