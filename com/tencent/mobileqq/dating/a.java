package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BorderTextView;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final String[] D;
    float C;

    /* renamed from: d, reason: collision with root package name */
    private int f203398d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f203399e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f203400f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f203401h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f203402i;

    /* renamed from: m, reason: collision with root package name */
    int f203403m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            D = new String[]{HardCodeUtil.qqStr(R.string.k_j), HardCodeUtil.qqStr(R.string.k_m), HardCodeUtil.qqStr(R.string.k_p), HardCodeUtil.qqStr(R.string.k_n), HardCodeUtil.qqStr(R.string.k_k), HardCodeUtil.qqStr(R.string.k_j), HardCodeUtil.qqStr(R.string.k_o)};
        }
    }

    public void e(View view, AdData adData) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) adData);
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f163977f5);
        BorderTextView borderTextView = (BorderTextView) view.findViewById(R.id.f163981fi);
        SingleLineTextView singleLineTextView = (SingleLineTextView) view.findViewById(R.id.f163993fz);
        SingleLineTextView singleLineTextView2 = (SingleLineTextView) view.findViewById(R.id.f163980fh);
        TextView textView = (TextView) view.findViewById(R.id.f163969e6);
        TextView textView2 = (TextView) view.findViewById(R.id.f163970e8);
        View findViewById = view.findViewById(R.id.ari);
        borderTextView.setTextSize(1, 11.0f);
        borderTextView.setBorderWidth(Math.round(borderTextView.getResources().getDisplayMetrics().density * 1.0f));
        imageView.setImageDrawable(URLDrawableHelper.getDrawable(adData.img_url));
        String str2 = adData.wording;
        if (str2 != null && str2.length() > 0) {
            borderTextView.setText(adData.wording);
            borderTextView.setTextColor(adData.bgColor);
            borderTextView.setBorderColor(adData.bgColor);
            borderTextView.setVisibility(0);
        } else {
            borderTextView.setVisibility(4);
        }
        int i3 = 89;
        if (!TextUtils.isEmpty(adData.distance)) {
            singleLineTextView2.setText(adData.distance);
            singleLineTextView2.setVisibility(0);
            i3 = 89 + Math.round(borderTextView.getPaint().measureText(adData.distance)) + 5;
        } else {
            singleLineTextView2.setVisibility(8);
        }
        singleLineTextView.setMaxWidth((int) (this.f203403m - (i3 * this.C)));
        singleLineTextView.setText(adData.title);
        textView.setText(adData.content);
        textView2.setText(adData.content2);
        int i16 = adData.ad_source;
        if (i16 >= 0) {
            String[] strArr = D;
            if (i16 < strArr.length) {
                str = strArr[i16];
                view.setContentDescription(str);
                findViewById.setContentDescription(str);
                findViewById.setTag(adData.jump_url);
                findViewById.setTag(R.id.gqg, Integer.valueOf(adData.ad_source));
                findViewById.setOnClickListener(this.f203400f);
            }
        }
        str = D[0];
        view.setContentDescription(str);
        findViewById.setContentDescription(str);
        findViewById.setTag(adData.jump_url);
        findViewById.setTag(R.id.gqg, Integer.valueOf(adData.ad_source));
        findViewById.setOnClickListener(this.f203400f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            Integer num = (Integer) view.getTag(R.id.gqg);
            String str = (String) view.getTag();
            if (num != null && str != null) {
                int i3 = this.f203398d;
                if (i3 == 2 || i3 == 1) {
                    ReportController.o(this.f203399e, "CliOper", "", "", "0X80050D1", "0X80050D1", i3, 0, String.valueOf(num), "", "", "");
                }
                if (num.intValue() == 5) {
                    ReportController.o(this.f203399e, "CliOper", "", "", "0X80052A3", "0X80052A3", this.f203398d, 0, "", "", "", "");
                }
                Context context = this.f203401h;
                if (context == null) {
                    context = BaseApplication.getContext();
                }
                ax c16 = bi.c(this.f203399e, context, str);
                if (c16 != null) {
                    c16.b();
                } else {
                    Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", URLUtil.guessUrl(str));
                    context.startActivity(intent);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
