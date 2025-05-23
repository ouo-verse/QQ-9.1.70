package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    private static final int Z0;

    /* renamed from: a1, reason: collision with root package name */
    public static AdExposureChecker.ExposureCallback f290685a1;

    /* renamed from: b1, reason: collision with root package name */
    public static ArrayList<AdExposureChecker> f290686b1;
    private int X0;
    private int Y0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f290687d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f290688e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f290689f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f290690h;

        a(String str, Context context, String str2, String str3) {
            this.f290687d = str;
            this.f290688e = context;
            this.f290689f = str2;
            this.f290690h = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, v.this, str, context, str2, str3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int indexOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(this.f290687d) && (indexOf = this.f290687d.indexOf(58)) != -1) {
                String substring = this.f290687d.substring(0, indexOf);
                if (!TextUtils.isEmpty(substring)) {
                    String lowerCase = substring.toLowerCase();
                    try {
                    } catch (Throwable th5) {
                        if (QLog.isDevelopLevel()) {
                            th5.printStackTrace();
                        }
                    }
                    if (lowerCase.compareTo("http") != 0 && lowerCase.compareTo("https") != 0) {
                        if (lowerCase.compareTo(SchemaUtils.SCHEMA_MQQAPI) == 0) {
                            Intent intent = new Intent(this.f290688e, (Class<?>) JumpActivity.class);
                            intent.setData(Uri.parse(this.f290687d));
                            this.f290688e.startActivity(intent);
                        }
                        ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "public.tailad.click", 0, 0, "", ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(this.f290689f, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE, ""), this.f290690h, "");
                    }
                    Intent intent2 = new Intent(this.f290688e, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("url", this.f290687d);
                    this.f290688e.startActivity(intent2);
                    ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "public.tailad.click", 0, 0, "", ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(this.f290689f, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE, ""), this.f290690h, "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            Z0 = Color.parseColor("#C7C7C7");
            f290686b1 = new ArrayList<>();
        }
    }

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    private TextView E(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setId(R.id.f66803bm);
        textView.setText(context.getResources().getText(R.string.f2177261s));
        textView.setSingleLine(false);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(1, R.id.f66813bn);
        layoutParams.addRule(0, R.id.f66823bo);
        layoutParams.addRule(15);
        layoutParams.setMargins(ViewUtils.dip2px(12.0f), 0, ViewUtils.dip2px(12.0f), 0);
        relativeLayout.addView(textView, layoutParams);
        J(context, textView);
        return textView;
    }

    @NotNull
    private ImageView F(Context context, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.f66813bn);
        int dpToPx = ViewUtils.dpToPx(50.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((dpToPx * 16) / 9, dpToPx);
        layoutParams.addRule(15);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.f162127nv0));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        relativeLayout.addView(imageView, layoutParams);
        return imageView;
    }

    private RelativeLayout G(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(74.0f));
        relativeLayout.setPadding(this.X0, 0, this.Y0, 0);
        relativeLayout.setLayoutParams(layoutParams);
        if (QLog.isColorLevel()) {
            QLog.i("QWalletGdtAdApi_StructMsgItemLayout31", 2, "getItemRootView...left:" + this.X0 + ",right:" + this.Y0 + ",top:0,bottom:0");
        }
        return relativeLayout;
    }

    private void H(RelativeLayout relativeLayout) {
        int paddingTop = relativeLayout.getPaddingTop();
        int paddingBottom = relativeLayout.getPaddingBottom();
        relativeLayout.setBackgroundResource(R.drawable.f160241dz);
        relativeLayout.setPadding(this.X0, paddingTop, this.Y0, paddingBottom);
    }

    private void I(Context context, RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
        String string = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(account, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_TITLE, "");
        String string2 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(account, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_JUMP_URL, "");
        String string3 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getString(account, IQWalletPreferenceApi.KEY_WALLET_PUB_MSG_TAIL_IMG_URL, "");
        Drawable drawable = context.getResources().getDrawable(R.drawable.f162127nv0);
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(string3, drawable, drawable));
        textView.setText(string);
        relativeLayout.setOnClickListener(new a(string2, context, account, string));
    }

    private void J(Context context, TextView textView) {
        if (context instanceof BaseActivity) {
            textView.getPaint().setFakeBoldText(false);
            textView.setTextSize(1, 12);
            try {
                textView.setTextColor(Color.parseColor("#000000"));
            } catch (Throwable th5) {
                QLog.e("QWalletGdtAdApi_StructMsgItemLayout31", 1, th5, new Object[0]);
                textView.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 31;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "Layout31";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        RelativeLayout G;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        if (bundle != null) {
            try {
                if (bundle.getBoolean(IQWalletGdtAdApi.WALLET_PUB_AD_TAG)) {
                    this.X0 = context.getResources().getDimensionPixelSize(R.dimen.axy) - ViewUtils.dip2px(3.0f);
                    this.Y0 = context.getResources().getDimensionPixelSize(R.dimen.axz) - ViewUtils.dip2px(3.0f);
                    if (view instanceof RelativeLayout) {
                        G = (RelativeLayout) view;
                        G.removeAllViews();
                    } else {
                        G = G(context);
                    }
                    H(G);
                    ImageView F = F(context, G);
                    TextView E = E(context, G);
                    I(context, G, F, E);
                    if (u()) {
                        G.setBackgroundColor(Color.parseColor("#0D0D0D"));
                        E.setTextColor(-1);
                    }
                    return G;
                }
            } catch (Throwable th5) {
                QLog.e("QWalletGdtAdApi_StructMsgItemLayout31", 1, th5, new Object[0]);
                return null;
            }
        }
        return new View(context);
    }
}
