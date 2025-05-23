package ac2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ScaleXSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f25804a = "b";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseActivity f25805d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f25806e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f25807f;

        a(BaseActivity baseActivity, d dVar, int i3) {
            this.f25805d = baseActivity;
            this.f25806e = dVar;
            this.f25807f = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cc2.a.b(this.f25805d, this.f25806e.f25832g, r0.f25828c, "", "", "");
            bc2.a.h(this.f25806e.f25833h, this.f25807f);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ac2.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class ViewOnClickListenerC0026b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseActivity f25808d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ac2.a f25809e;

        ViewOnClickListenerC0026b(BaseActivity baseActivity, ac2.a aVar) {
            this.f25808d = baseActivity;
            this.f25809e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.d(this.f25808d, this.f25809e);
            SimpleEventBus.getInstance().dispatchEvent(new NoRecommendDataEvent());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static void b(BaseActivity baseActivity, RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof ac2.a) {
            ac2.a aVar = (ac2.a) viewHolder;
            if (aVar.f25801e != null) {
                if (i3 == 3) {
                    d(baseActivity, aVar);
                } else {
                    e(baseActivity, aVar);
                }
            }
        }
    }

    public static void c(BaseActivity baseActivity, RecyclerView.ViewHolder viewHolder, d dVar, int i3) {
        if (baseActivity != null && !baseActivity.isFinishing() && viewHolder != null && dVar != null) {
            qb2.e eVar = (qb2.e) viewHolder;
            eVar.G = i3;
            View view = eVar.f428789e;
            if (view != null) {
                view.setOnClickListener(new a(baseActivity, dVar, i3));
            }
            TextView textView = eVar.f428792i;
            if (textView != null) {
                textView.setText(dVar.f25830e);
            }
            RoundedRectImageView roundedRectImageView = eVar.f428790f;
            if (roundedRectImageView != null) {
                int width = roundedRectImageView.getWidth() / 2;
                int height = eVar.f428790f.getHeight() / 2;
                IImageLoader iImageLoader = (IImageLoader) QRoute.api(IImageLoader.class);
                RoundedRectImageView roundedRectImageView2 = eVar.f428790f;
                String str = dVar.f25829d;
                Drawable drawable = baseActivity.getResources().getDrawable(R.drawable.f161158k54);
                ColorDrawable colorDrawable = new ColorDrawable(13553358);
                if (width == 0) {
                    width = 300;
                }
                int i16 = width;
                if (height == 0) {
                    height = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
                }
                iImageLoader.displayImage(roundedRectImageView2, str, drawable, colorDrawable, i16, height, null, false);
            }
            if (eVar.f428791h != null) {
                ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(eVar.f428791h, dVar.f25845t, baseActivity.getResources().getDrawable(R.drawable.n4_), new ColorDrawable(13553358), 30, 30, null, true);
            }
            TextView textView2 = eVar.E;
            if (textView2 != null) {
                textView2.setText("" + dVar.f25834i);
            }
            if (eVar.F != null) {
                String b16 = dVar.b();
                if (b16 != null && b16.length() > 0) {
                    eVar.F.setText(b16);
                    eVar.F.setVisibility(0);
                } else {
                    eVar.F.setVisibility(8);
                }
            }
            FrameAnimationView frameAnimationView = eVar.D;
            if (frameAnimationView != null) {
                frameAnimationView.setAnimationRes(R.drawable.f161156k52);
                eVar.D.a();
            }
            bc2.a.i(dVar.f25833h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(BaseActivity baseActivity, ac2.a aVar) {
        String str;
        ImageView imageView = aVar.f25803h;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        if (aVar.f25802f != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(baseActivity, R.anim.f154744r1);
            loadAnimation.setInterpolator(new LinearInterpolator());
            aVar.f25802f.startAnimation(loadAnimation);
            aVar.f25802f.setVisibility(0);
        }
        if (baseActivity != null) {
            str = baseActivity.getResources().getString(R.string.f2205769h);
        } else {
            str = "\u52a0\u8f7d\u4e2d";
        }
        aVar.f25801e.setText(str);
        aVar.f25801e.setOnClickListener(null);
        try {
            aVar.f25801e.setTextColor(Color.parseColor("#00CAFC"));
        } catch (IllegalArgumentException e16) {
            QLog.d(f25804a, 2, "parse color error: " + e16.toString());
        }
    }

    private static void e(BaseActivity baseActivity, ac2.a aVar) {
        String str;
        if (baseActivity != null) {
            str = baseActivity.getResources().getString(R.string.f2205869i);
        } else {
            str = "\u6682\u65e0\u6570\u636e\uff0c\u8bf7\u5237\u65b0\u9875\u9762";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new UnderlineSpan(), 6, 8, 33);
        spannableString.setSpan(new ScaleXSpan(1.1f), 6, 8, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), 6, 8, 33);
        try {
            aVar.f25801e.setTextColor(Color.parseColor("#878B99"));
        } catch (IllegalArgumentException e16) {
            QLog.d(f25804a, 2, "parse color error: " + e16.toString());
        }
        ImageView imageView = aVar.f25803h;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = aVar.f25802f;
        if (imageView2 != null) {
            imageView2.clearAnimation();
            aVar.f25802f.setVisibility(8);
        }
        aVar.f25801e.setText(spannableString);
        aVar.f25801e.setOnClickListener(new ViewOnClickListenerC0026b(baseActivity, aVar));
    }
}
