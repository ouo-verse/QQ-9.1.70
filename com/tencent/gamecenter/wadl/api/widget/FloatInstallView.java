package com.tencent.gamecenter.wadl.api.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import ll0.a;
import mqq.app.MobileQQ;
import tencent.im.qqgame.QQGameIntercept$GetFloatingWindowResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatInstallView extends FrameLayout implements View.OnClickListener {
    private Button C;
    private TextView D;
    private TextView E;
    private TextView F;
    private String G;
    private a H;
    private int I;
    private int J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private View f106693d;

    /* renamed from: e, reason: collision with root package name */
    private RFWRoundImageView f106694e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f106695f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f106696h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f106697i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f106698m;

    public FloatInstallView(@NonNull Context context) {
        super(context);
        this.I = 0;
        b(context);
    }

    private void b(Context context) {
        float f16 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
        this.I = (int) ((50.0f * f16) + 0.5f);
        this.J = (int) ((354.0f * f16) + 0.5f);
        this.K = (int) ((f16 * 287.0f) + 0.5f);
        View inflate = LayoutInflater.from(context).inflate(R.layout.eb7, (ViewGroup) null, true);
        this.f106693d = inflate;
        this.f106694e = (RFWRoundImageView) inflate.findViewById(R.id.xcr);
        this.f106695f = (ImageView) this.f106693d.findViewById(R.id.y3t);
        this.C = (Button) this.f106693d.findViewById(R.id.tdf);
        ImageView imageView = (ImageView) this.f106693d.findViewById(R.id.xcq);
        this.f106696h = imageView;
        imageView.setOnClickListener(this);
        this.D = (TextView) this.f106693d.findViewById(R.id.kbs);
        this.E = (TextView) this.f106693d.findViewById(R.id.f111586lm);
        this.F = (TextView) this.f106693d.findViewById(R.id.f111596ln);
        this.f106697i = (ImageView) this.f106693d.findViewById(R.id.svm);
        this.f106698m = (ImageView) this.f106693d.findViewById(R.id.svn);
        this.C.setOnClickListener(this);
        addView(this.f106693d, new FrameLayout.LayoutParams(this.K, this.J));
    }

    public void a(String str, QQGameIntercept$GetFloatingWindowResponse qQGameIntercept$GetFloatingWindowResponse) {
        QLog.i("WadlFloat_FloatInstallView", 2, "initData iconUrl: " + qQGameIntercept$GetFloatingWindowResponse.icon.get() + ", guideUrl: " + qQGameIntercept$GetFloatingWindowResponse.url.get() + ", name: " + qQGameIntercept$GetFloatingWindowResponse.name.get());
        if (!TextUtils.isEmpty(str) && !str.equals(this.G)) {
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("915167").setExt(1, "817120").setGameAppId(str).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "8").report();
        }
        this.G = str;
        String str2 = qQGameIntercept$GetFloatingWindowResponse.icon.get();
        if (!StringUtil.isEmpty(str2)) {
            try {
                this.f106694e.setImageDrawable(URLDrawable.getDrawable(new URL(str2), URLDrawable.URLDrawableOptions.obtain()));
            } catch (Exception unused) {
                QLog.e("WadlFloat_FloatInstallView", 1, "initData iconUrl=" + str2);
            }
        }
        String str3 = qQGameIntercept$GetFloatingWindowResponse.url.get();
        if (!StringUtil.isEmpty(str3)) {
            try {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setAutoScale(true);
                apngOptions.setUseCache(false);
                this.f106695f.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str3, apngOptions, ""));
            } catch (Exception unused2) {
                QLog.e("WadlFloat_FloatInstallView", 1, "initData apngUrl=" + str2);
                this.f106695f.setVisibility(4);
            }
        } else {
            this.f106695f.setVisibility(4);
        }
        this.D.setText(qQGameIntercept$GetFloatingWindowResponse.name.get());
        this.E.setText(qQGameIntercept$GetFloatingWindowResponse.title.get());
        this.F.setText(qQGameIntercept$GetFloatingWindowResponse.sub_title.get());
    }

    public void c(boolean z16, int i3) {
        QLog.i("WadlFloat_FloatInstallView", 2, "updateArrow isToRight: " + z16 + ", translationY: " + i3);
        if (i3 < 0) {
            i3 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f106693d.getLayoutParams();
        if (z16) {
            this.f106697i.setVisibility(8);
            this.f106698m.setVisibility(0);
            this.f106698m.setTranslationY(i3);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = this.I;
            this.f106693d.setLayoutParams(layoutParams);
            return;
        }
        this.f106698m.setVisibility(8);
        this.f106697i.setVisibility(0);
        this.f106697i.setTranslationY(i3);
        layoutParams.leftMargin = this.I;
        layoutParams.rightMargin = 0;
        this.f106693d.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.xcq || id5 == R.id.tdf) {
            try {
                WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this);
                }
            } catch (Throwable th5) {
                QLog.e("WadlFloat_FloatInstallView", 1, "[onCloseClick] onCloseClick exception", th5);
            }
            a aVar = this.H;
            if (aVar != null) {
                if (id5 != R.id.tdf) {
                    str = "1";
                } else {
                    str = "2";
                }
                aVar.f(true);
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("915168").setExt(1, "817120").setGameAppId(this.G).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "20").setExt(2, str).report();
            } else {
                QLog.w("WadlFloat_FloatInstallView", 1, "[onCloseClick] onCloseClick wndListener is null");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFloatWndListener(a aVar) {
        this.H = aVar;
    }

    public FloatInstallView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        b(context);
    }
}
