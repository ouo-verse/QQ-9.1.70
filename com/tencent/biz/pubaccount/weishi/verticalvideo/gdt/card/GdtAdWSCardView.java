package com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.card;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake.VasAdvShakeButton;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GdtAdWSCardView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private b f82064d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f82059e = ViewCompat.generateViewId();

    /* renamed from: f, reason: collision with root package name */
    public static final int f82060f = ViewCompat.generateViewId();

    /* renamed from: h, reason: collision with root package name */
    public static final int f82061h = ViewCompat.generateViewId();

    /* renamed from: i, reason: collision with root package name */
    public static final int f82062i = ViewCompat.generateViewId();

    /* renamed from: m, reason: collision with root package name */
    public static final int f82063m = ViewCompat.generateViewId();
    public static final int C = ViewCompat.generateViewId();
    public static final int D = ViewCompat.generateViewId();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Html.ImageGetter {
        a() {
        }

        @Override // android.text.Html.ImageGetter
        public Drawable getDrawable(String str) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(GdtAdWSCardView.this.getResources(), AdUIUtils.getBitmapFromString("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"));
            bitmapDrawable.setBounds(0, 0, AdUIUtils.dp2px(28.0f, GdtAdWSCardView.this.getResources()), AdUIUtils.dp2px(15.0f, GdtAdWSCardView.this.getResources()));
            return bitmapDrawable;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f82066a;

        /* renamed from: b, reason: collision with root package name */
        public String f82067b;

        /* renamed from: c, reason: collision with root package name */
        public String f82068c;

        /* renamed from: d, reason: collision with root package name */
        public String f82069d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f82070e;

        /* renamed from: f, reason: collision with root package name */
        public String f82071f;

        /* renamed from: g, reason: collision with root package name */
        public List<String> f82072g = null;

        /* renamed from: h, reason: collision with root package name */
        public WeakReference<View.OnClickListener> f82073h = null;
    }

    GdtAdWSCardView(Context context) {
        super(context);
    }

    private void a() {
        WeakReference<View.OnClickListener> weakReference;
        WSRoundedImageView wSRoundedImageView = new WSRoundedImageView(getContext());
        WSPicLoader g16 = WSPicLoader.g();
        Context context = getContext();
        b bVar = this.f82064d;
        g16.j(context, wSRoundedImageView, bVar != null ? bVar.f82066a : null);
        int dp2px = AdUIUtils.dp2px(41.0f, getResources());
        int dp2px2 = AdUIUtils.dp2px(2.5f, getResources());
        wSRoundedImageView.setPadding(dp2px2, dp2px2, dp2px2, dp2px2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        wSRoundedImageView.setLayoutParams(layoutParams);
        wSRoundedImageView.setId(f82060f);
        b bVar2 = this.f82064d;
        if (bVar2 != null && (weakReference = bVar2.f82073h) != null) {
            wSRoundedImageView.setOnClickListener(weakReference.get());
        }
        addView(wSRoundedImageView);
    }

    private void b() {
        WeakReference<View.OnClickListener> weakReference;
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        b bVar = this.f82064d;
        if (bVar != null && !TextUtils.isEmpty(bVar.f82067b)) {
            textView.setText(this.f82064d.f82067b);
        }
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 14.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setMaxWidth(AdUIUtils.dp2px(140.5f, getResources()));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, AdUIUtils.dp2px(18.0f, getResources()));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.topMargin = AdUIUtils.dp2px(11.5f, getResources());
        layoutParams.leftMargin = AdUIUtils.dp2px(49.0f, getResources());
        textView.setLayoutParams(layoutParams);
        textView.setId(D);
        b bVar2 = this.f82064d;
        if (bVar2 != null && (weakReference = bVar2.f82073h) != null) {
            textView.setOnClickListener(weakReference.get());
        }
        addView(textView);
    }

    private void c() {
        String str;
        WeakReference<View.OnClickListener> weakReference;
        final VasAdvShakeButton vasAdvShakeButton = new VasAdvShakeButton(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(32.0f));
        layoutParams.topMargin = ViewUtils.dip2px(10.0f);
        layoutParams.addRule(14);
        layoutParams.addRule(3, f82063m);
        vasAdvShakeButton.setLayoutParams(layoutParams);
        vasAdvShakeButton.setGravity(17);
        b bVar = this.f82064d;
        if (bVar != null) {
            str = bVar.f82069d;
        } else {
            str = "";
        }
        vasAdvShakeButton.setText(str);
        b bVar2 = this.f82064d;
        if (bVar2 != null && bVar2.f82070e) {
            vasAdvShakeButton.setIconResUrl(bVar2.f82071f);
            vasAdvShakeButton.setIconVisibility(0);
            vasAdvShakeButton.postDelayed(new Runnable() { // from class: n10.a
                @Override // java.lang.Runnable
                public final void run() {
                    VasAdvShakeButton.this.b();
                }
            }, 300L);
        }
        int dip2px = ViewUtils.dip2px(50.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-8437761);
        gradientDrawable.setCornerRadius(dip2px);
        vasAdvShakeButton.setBackground(gradientDrawable);
        vasAdvShakeButton.setId(C);
        b bVar3 = this.f82064d;
        if (bVar3 != null && (weakReference = bVar3.f82073h) != null) {
            vasAdvShakeButton.setOnClickListener(weakReference.get());
        }
        addView(vasAdvShakeButton);
    }

    private void d() {
        WeakReference<View.OnClickListener> weakReference;
        ImageView imageView = new ImageView(getContext());
        int dp2px = AdUIUtils.dp2px(20.0f, getResources());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px, dp2px);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(new BitmapDrawable(getResources(), AdUIUtils.getBitmapFromString("iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAYAAABw4pVUAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAZKADAAQAAAABAAAAZAAAAAAvu95BAAAD+UlEQVR4Ae2c33HaQBCHJcF7nApCOnAegFHyAk4DmVSQpIE4riCkAXeQ2GkgFcS8hX8PuIPQgXlkPMBll+E8hJEsgaW9W83vZpiTD6Hb/T7Q+U6CIEABARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAARAAgQoTCKVym06nJ4v7+8+BMR3qc0Z1L47jmVT/efoZjUYv18Z8p3079JgFYXgVt9u9PK8tah8xIYPhsE9Bd2zg1PE8iqJuq9W6tW0u662MG4qhsROHISkfScr1Tlupm1GpR98efDAYdGiTHw/FBMHJer3uj8fj04dGRxspMjia0KxW7yTDEhGSlpAPUh6RsQk7jKJnafGX0S4iZLFY3BL8eVICLqVkyaB4TRSGYqcr5iMipNvtzkNjviQJ4TYXUnLICGiA/9YWHD+YBY2tcoXGkg80SP5I65GCERnoc8rovYnjr2mxltUuKoSTcC3FZxnMR1yISym+y3AmxIUUDTKcCpGUokWGcyESUjTJ8EJImVK0yfBGSBlSNMrwSkiRUrTK8E5IEVI0y/BSyFOk0KSzQSsBfTpGg4+TVGg5xMkMPCmWpDYnE8OkQPbbDp3RV0EGM/BWCAeXV8pqtZpr/2Rwvly8FsIB5pFCq8W8tN/g/ZOK76ep3Zi9F8LBZknZTWh/W5MMjl2FEA70GCnaZKgScqgUjTLUCeGA/wyH5/SxvuTttGKMuXwdxxdpz/vcruaUxRDptJU5z9jANuauVqud+XKL0SFvADVCcsuw2SuVInKTg2V0bH2wDO4oDJ/T/ORmMpm8OrZfF6/zXgivTWVN+ggcTUUSCklZLpe/NUnxWkjehUK6T/hTVaR4O4bklWFv1dnOU/hG6eScaEyp1+tvm83mNOGz5E1TcvCOwztUhg23ClK8E3KsjKpI8UrIU2VUQYo3QoqSoV2KF0KKlqFZinMhZcnQKsWpkLJlaJTiTIiUDG1SnAiRlqFJirgQVzK0SBEV4lqGBiliQnyR4bsUsdVeusa9/6V8y2ZTS18Dp1+RuMqzSry5FvNfpOX+ISKEkupQGo20VKRl2DjySDFheG73l6hFhND17cTvqHOCrmRYuJlS1usXdl+JWkTI9maDv3sJGdcybDyPSDH0Zvpl95OoRYRsEjHmjOo+PeguHXNH11wv7MUliUSz+mApdHp6T/vxG4fCC/gNc00/HPAz67VFPi/2X1aRQZd5rM3PSC0Wp9THjCTNyuwLxwYBEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEAABEACBHQL/AMD5+Phxa5yWAAAAAElFTkSuQmCC")));
        imageView.setId(f82061h);
        b bVar = this.f82064d;
        if (bVar != null && (weakReference = bVar.f82073h) != null) {
            imageView.setOnClickListener(weakReference.get());
        }
        addView(imageView);
    }

    private void e() {
        WeakReference<View.OnClickListener> weakReference;
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = AdUIUtils.dp2px(8.0f, getResources());
        layoutParams.addRule(9);
        layoutParams.addRule(3, f82062i);
        textView.setLayoutParams(layoutParams);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        b bVar = this.f82064d;
        if (bVar != null && !TextUtils.isEmpty(bVar.f82068c)) {
            textView.setText(HtmlCompat.fromHtml(this.f82064d.f82068c + " <img src=\"ad_icon\">", 63, new a(), null));
        }
        textView.setMaxHeight(AdUIUtils.dp2px(44.0f, getResources()));
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 14.0f);
        textView.setIncludeFontPadding(false);
        textView.setId(f82063m);
        b bVar2 = this.f82064d;
        if (bVar2 != null && (weakReference = bVar2.f82073h) != null) {
            textView.setOnClickListener(weakReference.get());
        }
        addView(textView);
    }

    private void f() {
        List<String> list;
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, f82060f);
        layoutParams.topMargin = AdUIUtils.dp2px(6.0f, getResources());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setId(f82062i);
        int dp2px = AdUIUtils.dp2px(8.0f, getResources());
        b bVar = this.f82064d;
        if (bVar != null && (list = bVar.f82072g) != null && !list.isEmpty()) {
            Iterator<String> it = this.f82064d.f82072g.iterator();
            while (it.hasNext()) {
                View g16 = g(it.next(), linearLayout.getChildCount() == 0 ? 0 : dp2px);
                if (g16 != null) {
                    linearLayout.addView(g16);
                    if (linearLayout.getChildCount() == 3) {
                        break;
                    }
                }
            }
            WeakReference<View.OnClickListener> weakReference = this.f82064d.f82073h;
            if (weakReference != null) {
                linearLayout.setOnClickListener(weakReference.get());
            }
        } else {
            linearLayout.setVisibility(8);
        }
        addView(linearLayout);
    }

    private View g(String str, int i3) {
        if (TextUtils.isEmpty(str) || i3 < 0) {
            return null;
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int dp2px = AdUIUtils.dp2px(4.0f, getResources());
        textView.setPadding(dp2px, dp2px, dp2px, dp2px);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-16777216);
        int dp2px2 = AdUIUtils.dp2px(6.0f, getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(218103808);
        gradientDrawable.setCornerRadius(dp2px2);
        textView.setBackground(gradientDrawable);
        return textView;
    }

    private void h() {
        a();
        b();
        d();
        f();
        e();
        c();
    }

    private void i() {
        if (this.f82064d == null) {
            GdtLog.e("GdtAdWSCardView", "[initView]mParams are null or invalid");
            return;
        }
        int dp2px = AdUIUtils.dp2px(8.0f, getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp2px);
        setBackground(gradientDrawable);
        int dp2px2 = AdUIUtils.dp2px(10.0f, getResources());
        setPadding(dp2px2, dp2px2, dp2px2, dp2px2);
        setId(f82059e);
        WeakReference<View.OnClickListener> weakReference = this.f82064d.f82073h;
        if (weakReference != null) {
            setOnClickListener(weakReference.get());
        }
    }

    public GdtAdWSCardView(Context context, b bVar) {
        this(context);
        j(bVar);
    }

    private void j(b bVar) {
        if (bVar == null) {
            GdtLog.e("GdtAdWSCardView", "[init]params are null or invalid");
            return;
        }
        this.f82064d = bVar;
        i();
        h();
    }
}
