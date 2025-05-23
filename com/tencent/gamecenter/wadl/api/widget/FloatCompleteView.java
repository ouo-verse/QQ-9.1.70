package com.tencent.gamecenter.wadl.api.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.List;
import ll0.a;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatCompleteView extends FrameLayout implements View.OnClickListener {
    private ImageView C;
    private Button D;
    private TextView E;
    private a F;
    private int G;
    private WadlResult H;
    private int I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private View f106687d;

    /* renamed from: e, reason: collision with root package name */
    private RFWRoundImageView f106688e;

    /* renamed from: f, reason: collision with root package name */
    private RFWRoundImageView f106689f;

    /* renamed from: h, reason: collision with root package name */
    private RFWRoundImageView f106690h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f106691i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f106692m;

    public FloatCompleteView(@NonNull Context context) {
        super(context);
        this.G = 0;
        a(context);
    }

    private void a(Context context) {
        float f16 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
        this.G = (int) ((50.0f * f16) + 0.5f);
        this.J = (int) ((227.0f * f16) + 0.5f);
        this.I = (int) ((f16 * 278.0f) + 0.5f);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167985eb2, (ViewGroup) null, true);
        this.f106687d = inflate;
        this.f106688e = (RFWRoundImageView) inflate.findViewById(R.id.xcs);
        this.f106689f = (RFWRoundImageView) this.f106687d.findViewById(R.id.xct);
        this.f106690h = (RFWRoundImageView) this.f106687d.findViewById(R.id.xcu);
        this.D = (Button) this.f106687d.findViewById(R.id.tdg);
        ImageView imageView = (ImageView) this.f106687d.findViewById(R.id.xcq);
        this.f106691i = imageView;
        imageView.setOnClickListener(this);
        this.E = (TextView) this.f106687d.findViewById(R.id.f111586lm);
        this.f106692m = (ImageView) this.f106687d.findViewById(R.id.svm);
        this.C = (ImageView) this.f106687d.findViewById(R.id.svn);
        this.D.setOnClickListener(this);
        addView(this.f106687d, new FrameLayout.LayoutParams(this.J, this.I));
    }

    public boolean b() {
        List<WadlResult> list;
        String str;
        a aVar = this.F;
        WadlResult wadlResult = null;
        if (aVar != null) {
            list = aVar.e();
        } else {
            list = null;
        }
        QLog.i("WadlFloat_FloatCompleteView", 2, "notifyDataChanged wadlResults=" + list);
        if (list == null || list.size() < 1) {
            return false;
        }
        this.f106689f.setVisibility(8);
        this.f106690h.setVisibility(8);
        int i3 = 0;
        for (WadlResult wadlResult2 : list) {
            if (wadlResult2.isDownloadComplete() && GameCenterUtil.fileExists(wadlResult2.downloadFilePath)) {
                if (wadlResult == null) {
                    wadlResult = wadlResult2;
                }
                i3++;
                if (i3 <= 3 && !StringUtil.isEmpty(wadlResult2.wadlParams.iconUrl)) {
                    try {
                        URLDrawable drawable = URLDrawable.getDrawable(new URL(wadlResult2.wadlParams.iconUrl), URLDrawable.URLDrawableOptions.obtain());
                        if (i3 == 1) {
                            this.f106688e.setVisibility(0);
                            this.f106688e.setImageDrawable(drawable);
                        } else if (i3 == 2) {
                            this.f106689f.setVisibility(0);
                            this.f106689f.setImageDrawable(drawable);
                        } else if (i3 == 3) {
                            this.f106690h.setVisibility(0);
                            this.f106690h.setImageDrawable(drawable);
                        }
                    } catch (Exception unused) {
                        QLog.e("WadlFloat_FloatCompleteView", 1, "notifyDataChanged iconUrl=" + wadlResult2.wadlParams.iconUrl);
                    }
                }
            }
        }
        if (wadlResult != null) {
            this.H = wadlResult;
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("915275").setExt(1, "817120").setGameAppId(this.H.wadlParams.appId).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "8").report();
        }
        TextView textView = this.E;
        if (i3 > 1) {
            str = "\u591a\u6b3e\u6e38\u620f\u4e0b\u8f7d\u5b8c\u6210";
        } else {
            str = "\u4e0b\u8f7d\u5b8c\u6210";
        }
        textView.setText(str);
        if (i3 <= 0) {
            return false;
        }
        return true;
    }

    public void c(boolean z16, int i3) {
        QLog.i("WadlFloat_FloatCompleteView", 2, "updateArrow isToRight: " + z16 + ", translationY: " + i3);
        if (i3 < 0) {
            i3 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f106687d.getLayoutParams();
        if (z16) {
            this.f106692m.setVisibility(8);
            this.C.setVisibility(0);
            this.C.setTranslationY(i3);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = this.G;
            this.f106687d.setLayoutParams(layoutParams);
            return;
        }
        this.C.setVisibility(8);
        this.f106692m.setVisibility(0);
        this.f106692m.setTranslationY(i3);
        layoutParams.leftMargin = this.G;
        layoutParams.rightMargin = 0;
        this.f106687d.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.xcq) {
            a aVar = this.F;
            if (aVar != null) {
                aVar.b();
            }
            str = "1";
        } else if (id5 == R.id.tdg && this.H != null) {
            a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.b();
            }
            WadlResult wadlResult = this.H;
            WadlParams wadlParams = wadlResult.wadlParams;
            GameCenterUtil.goToInstallWithJump(wadlParams.appId, wadlParams.packageName, wadlResult.downloadFilePath, wadlParams.sourceId, GameCenterUtil.INSTALL_FROM_FLOAT_BALL, false);
            str = "2";
        } else {
            str = "";
        }
        if (this.H != null) {
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("915276").setExt(1, "817120").setGameAppId(this.H.wadlParams.appId).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "20").setExt(2, str).report();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFloatWndListener(a aVar) {
        this.F = aVar;
    }

    public FloatCompleteView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = 0;
        a(context);
    }
}
