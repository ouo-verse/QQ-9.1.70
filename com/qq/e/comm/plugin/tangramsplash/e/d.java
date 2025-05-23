package com.qq.e.comm.plugin.tangramsplash.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.e;
import com.qq.e.comm.plugin.base.ad.model.ExtraCreativeElement;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.adapter.TGSplashInterPage;
import com.tencent.ams.fusion.widget.olympic2024.RoundCornerFrameLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private a f39903a;

    /* renamed from: b, reason: collision with root package name */
    private r f39904b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f39905c;

    /* renamed from: d, reason: collision with root package name */
    private int f39906d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r rVar = d.this.f39904b;
            GDTLogger.i("OlympicInterPageView,[onClick]");
            if (rVar == null) {
                GDTLogger.i("OlympicInterPageView,[onClick]");
            } else {
                e eVar = new e(new WeakReference(d.this));
                ClickInfo.c cVar = new ClickInfo.c(rVar.u(), rVar.t(), rVar.s());
                ClickInfo.a aVar = new ClickInfo.a();
                aVar.d();
                com.qq.e.comm.plugin.base.ad.clickcomponent.c.a(new ClickInfo.b().a(rVar).a(cVar).a(eVar).a(new ClickInfo.d(10)).a(aVar).a());
                d.this.a(1, 0, 0L);
                TGSplashInterPage.getInstance().callBackClose(1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(@NonNull Context context, r rVar) {
        super(context);
        this.f39906d = 295;
        this.f39904b = rVar;
        this.f39903a = new a();
    }

    private boolean c() {
        Bitmap bitmap = this.f39905c;
        if (bitmap == null) {
            GDTLogger.e("OlympicInterPageView,[initBackGround] backGroundBitMap is null");
            return false;
        }
        com.qq.e.comm.plugin.base.media.a.b bVar = new com.qq.e.comm.plugin.base.media.a.b(getContext());
        bVar.setImageBitmap(bitmap);
        bVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(bVar, new FrameLayout.LayoutParams(-1, -1));
        return true;
    }

    private void d() {
        Typeface create;
        Button button = new Button(getContext());
        button.setText("\u5173\u95ed");
        button.setTextSize(14.0f);
        int a16 = ak.a(getContext(), 9);
        int a17 = ak.a(getContext(), 7);
        button.setPadding(a16, a17, a16, a17);
        button.setTextColor(Color.parseColor("#F0F0F0"));
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(button.getTypeface(), 400, false);
            button.setTypeface(create);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#40000000"));
        gradientDrawable.setStroke(ak.a(getContext(), 1), Color.parseColor("#40FFFFFF"));
        gradientDrawable.setCornerRadius(ak.a(getContext(), 6));
        button.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 49), ak.a(getContext(), 32));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.tangramsplash.e.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                GDTLogger.i("OlympicInterPageView,[onClick] close");
                d.this.a(2, 0, 0L);
                TGSplashInterPage.getInstance().callBackClose(2);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = ak.a(getContext(), 54);
        layoutParams.rightMargin = ak.a(getContext(), 22);
        addView(button, layoutParams);
    }

    private void e() {
        String str;
        Typeface create;
        Typeface create2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        textView.setText("\u70b9\u51fb\u4e86\u89e3\u8be6\u60c5");
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setGravity(1);
        textView.setShadowLayer(0.5f, 0.0f, 0.5f, Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
        r rVar = this.f39904b;
        String str2 = "\u8df3\u8f6c\u5fae\u4fe1\u67e5\u770b\u66f4\u591a";
        if (rVar == null || rVar.bJ() == null) {
            str = "\u8df3\u8f6c\u5fae\u4fe1\u67e5\u770b\u66f4\u591a";
        } else {
            str = this.f39904b.bJ().k();
        }
        TextView textView2 = new TextView(getContext());
        GDTLogger.i("OlympicInterPageView,[initTextView] txt:" + str);
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        textView2.setText(str2);
        textView2.setTextSize(16.0f);
        textView2.setTextColor(Color.parseColor("#99FFFFFF"));
        textView2.setGravity(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ak.a(getContext(), 6);
        int i3 = Build.VERSION.SDK_INT;
        textView.setLetterSpacing(0.05f);
        textView2.setLetterSpacing(0.01f);
        if (i3 >= 28) {
            create = Typeface.create(textView.getTypeface(), 600, false);
            textView.setTypeface(create);
            create2 = Typeface.create(textView2.getTypeface(), 500, false);
            textView2.setTypeface(create2);
        }
        linearLayout.addView(textView);
        linearLayout.addView(textView2, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 49;
        layoutParams2.topMargin = (this.f39906d / 2) + ak.a(getContext(), 65) + ak.a(getContext(), 394);
        linearLayout.setLayoutParams(layoutParams2);
        addView(linearLayout);
    }

    public void b() {
        ExtraCreativeElement extraCreativeElement;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            GDTLogger.e("OlympicInterPageView,[initBackGroundBitmap] thread error");
            return;
        }
        r rVar = this.f39904b;
        if (rVar != null) {
            extraCreativeElement = rVar.bL();
        } else {
            extraCreativeElement = null;
        }
        if (extraCreativeElement == null) {
            GDTLogger.e("OlympicInterPageView,[initBackGroundBitmap] creativeElement is null");
        } else {
            this.f39905c = h.a(extraCreativeElement.a(this.f39904b.s()), (ImageView) null);
        }
    }

    public boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            GDTLogger.e("OlympicInterPageView,[initViews] thread error");
            return false;
        }
        GDTLogger.i("OlympicInterPageView,[initViews]");
        setOnClickListener(this.f39903a);
        r rVar = this.f39904b;
        if (rVar == null) {
            GDTLogger.e("OlympicInterPageView,[initViews] adInfo is null");
            return false;
        }
        ExtraCreativeElement bL = rVar.bL();
        if (bL == null) {
            GDTLogger.e("OlympicInterPageView,[initViews] creativeElement is null");
            return false;
        }
        boolean a16 = a(bL) & c() & true;
        d();
        e();
        GDTLogger.i("OlympicInterPageView,[initViews] result:" + a16);
        return a16;
    }

    private int a(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && bitmap.getHeight() != 0 && bitmap.getWidth() != 0) {
            return (i3 * bitmap.getHeight()) / bitmap.getWidth();
        }
        GDTLogger.e("OlympicInterPageView[getBitmapHeight] wrong bitmap");
        return i16;
    }

    private boolean a(ExtraCreativeElement extraCreativeElement) {
        Bitmap bitmap = null;
        List<ExtraCreativeElement.b> b16 = extraCreativeElement != null ? extraCreativeElement.b() : null;
        if (!g.b(b16) && b16.size() >= 3) {
            int b17 = ak.b(getContext());
            if (b17 <= 0) {
                GDTLogger.e("OlympicInterPageView,[initViews] deviceWidth error");
                return false;
            }
            int a16 = (b17 / 2) - ak.a(getContext(), 170);
            ExtraCreativeElement.b bVar = b16.get(1);
            ExtraCreativeElement.b bVar2 = b16.get(0);
            ExtraCreativeElement.b bVar3 = b16.get(2);
            Bitmap a17 = (bVar == null || bVar.a() == null) ? null : bVar.a().a();
            Bitmap a18 = (bVar2 == null || bVar2.a() == null) ? null : bVar2.a().a();
            if (bVar3 != null && bVar3.a() != null) {
                bitmap = bVar3.a().a();
            }
            int a19 = ak.a(getContext(), 394);
            if (a17 != null && a18 != null && bitmap != null) {
                RoundCornerFrameLayout roundCornerFrameLayout = new RoundCornerFrameLayout(getContext());
                roundCornerFrameLayout.setRadius(ak.a(getContext(), 4));
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageBitmap(a17);
                int a26 = ak.a(getContext(), 140);
                int a27 = a(a17, a26, ak.a(getContext(), 206));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a26, a27);
                layoutParams.topMargin = a19 - (a27 / 2);
                layoutParams.gravity = 48;
                layoutParams.leftMargin = a16;
                roundCornerFrameLayout.setRotation(-15.0f);
                roundCornerFrameLayout.addView(imageView);
                addView(roundCornerFrameLayout, layoutParams);
                RoundCornerFrameLayout roundCornerFrameLayout2 = new RoundCornerFrameLayout(getContext());
                roundCornerFrameLayout2.setRadius(ak.a(getContext(), 4));
                ImageView imageView2 = new ImageView(getContext());
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView2.setImageBitmap(bitmap);
                int a28 = ak.a(getContext(), 140);
                int a29 = a(bitmap, a28, ak.a(getContext(), 206));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a28, a29);
                layoutParams2.topMargin = a19 - (a29 / 2);
                layoutParams2.gravity = 8388661;
                layoutParams2.rightMargin = a16;
                roundCornerFrameLayout2.setRotation(15.0f);
                roundCornerFrameLayout2.addView(imageView2);
                addView(roundCornerFrameLayout2, layoutParams2);
                RoundCornerFrameLayout roundCornerFrameLayout3 = new RoundCornerFrameLayout(getContext());
                roundCornerFrameLayout3.setRadius(ak.a(getContext(), 6));
                ImageView imageView3 = new ImageView(getContext());
                imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView3.setImageBitmap(a18);
                int a36 = ak.a(getContext(), 200);
                this.f39906d = a(a18, a36, ak.a(getContext(), 295));
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a36, this.f39906d);
                layoutParams3.topMargin = a19 - (this.f39906d / 2);
                layoutParams3.gravity = 49;
                roundCornerFrameLayout3.addView(imageView3);
                roundCornerFrameLayout3.setElevation(ak.a(getContext(), 2));
                roundCornerFrameLayout3.setTranslationY(ak.a(getContext(), 1));
                roundCornerFrameLayout3.setTranslationX(0.0f);
                roundCornerFrameLayout2.setElevation(ak.a(getContext(), 2));
                roundCornerFrameLayout2.setTranslationY(ak.a(getContext(), 1));
                roundCornerFrameLayout2.setTranslationX(0.0f);
                roundCornerFrameLayout.setElevation(ak.a(getContext(), 2));
                roundCornerFrameLayout.setTranslationY(ak.a(getContext(), 1));
                roundCornerFrameLayout.setTranslationX(0.0f);
                addView(roundCornerFrameLayout3, layoutParams3);
                return true;
            }
            GDTLogger.e("OlympicInterPageView,[initCarouselImageView] bitmap is null");
            return false;
        }
        GDTLogger.e("OlympicInterPageView,[initCarouselImageView] GroupList is null");
        return false;
    }

    public void a(int i3, int i16, long j3) {
        r rVar = this.f39904b;
        if (rVar == null) {
            GDTLogger.i("OlympicInterPageView,[reportCost] adInfo is null ");
            return;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(rVar.f());
        bVar.c(rVar.y());
        bVar.a(rVar.s());
        bVar.a(j3);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", Integer.valueOf(i3));
        bVar.a("act_code", i16);
        StatTracer.trackEvent(rVar.isWeChatCanvasAd() ? 1316019 : 1316018, 0, bVar, cVar);
    }
}
