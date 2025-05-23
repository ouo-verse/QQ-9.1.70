package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.plugin.PluginBaseActivity;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends ReportDialog implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private TextView D;
    private Button E;
    private Button F;
    private ImageView G;
    private VasMMKVProxy H;
    private Activity I;
    private CustomWebView J;
    private String K;
    private String L;
    private int M;
    private int N;
    private d.b P;

    public c(Activity activity, d.b bVar, int i3, String str, int i16) {
        super(activity, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, bVar, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        this.H = null;
        this.I = activity;
        this.P = bVar;
        this.L = str;
        this.M = i3;
        this.N = i16;
        initView();
    }

    private void N() {
        d.b bVar = this.P;
        if (bVar != null) {
            bVar.callback(3);
        }
        if (this.J != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 3);
                this.J.callJs(this.K, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e("CUKingCardDialog", 1, "onClick exception e = ", e16);
            }
        }
        int i3 = this.N;
        if (i3 == 2) {
            VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-3", this.L, 1, 0, 0, "", "", "");
        } else if (i3 == 3) {
            VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-3", this.L, 1, 0, 0, "", "", "");
        }
    }

    private void initView() {
        setContentView(R.layout.f167827ir);
        this.C = (ImageView) findViewById(R.id.a59);
        this.D = (TextView) findViewById(R.id.eqq);
        this.E = (Button) findViewById(R.id.bcg);
        this.F = (Button) findViewById(R.id.b_9);
        this.G = (ImageView) findViewById(R.id.cancel);
        VasMMKVProxy kingCard = VasMMKV.getKingCard(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        this.H = kingCard;
        String decodeString = kingCard.decodeString("guidePopupImgUrl_v2", "");
        if (QLog.isColorLevel()) {
            QLog.i("CUKingCardDialog", 2, "SP_KEY_GUIDE_POPUP_IMG_URL: " + decodeString);
        }
        ColorDrawable colorDrawable = new ColorDrawable(this.I.getResources().getColor(R.color.akv));
        if (!TextUtils.isEmpty(decodeString)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            this.C.setImageDrawable(URLDrawable.getDrawable(decodeString, obtain));
        } else {
            this.C.setImageDrawable(colorDrawable);
        }
        String decodeString2 = this.H.decodeString("guidePopupText_v2", "");
        String decodeString3 = this.H.decodeString("guideJumpText_v2", "");
        String decodeString4 = this.H.decodeString("guideContinueText_v2", "");
        if (QLog.isColorLevel()) {
            QLog.i("CUKingCardDialog", 2, String.format("popUpType: %d, mSceneId: %d, popUpStr: %s, guideBtnStr: %s, continueBtnStr: %s", Integer.valueOf(this.N), Integer.valueOf(this.M), decodeString2, decodeString3, decodeString4));
        }
        this.D.setText(decodeString2);
        this.E.setText(decodeString3);
        this.E.setOnClickListener(this);
        this.F.setText(decodeString4);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onBackPressed();
            N();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.bcg) {
                String c16 = d.c(this.L);
                if (!TextUtils.isEmpty(c16)) {
                    Activity activity = this.I;
                    if (activity instanceof PluginBaseActivity) {
                        PluginBaseActivity pluginBaseActivity = (PluginBaseActivity) activity;
                        Intent intent = new Intent(pluginBaseActivity.getOutActivity(), (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", c16);
                        intent.setFlags(268435456);
                        pluginBaseActivity.getOutActivity().startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(this.I, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("url", c16);
                        this.I.startActivity(intent2);
                    }
                } else {
                    QLog.e("CUKingCardDialog", 1, "onClick cuGuideBtn url = null");
                }
                int i3 = this.N;
                if (i3 == 2) {
                    VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-1", this.L, 1, 0, 0, "", "", "");
                } else if (i3 == 3) {
                    VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-1", this.L, 1, 0, 0, "", "", "");
                }
                d.b bVar = this.P;
                if (bVar != null) {
                    bVar.callback(4);
                }
                dismiss();
                if (this.J != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 4);
                        this.J.callJs(this.K, jSONObject.toString());
                    } catch (Exception e16) {
                        QLog.e("CUKingCardDialog", 1, "onClick exception e = ", e16);
                    }
                }
            } else if (id5 == R.id.b_9) {
                d.b bVar2 = this.P;
                if (bVar2 != null) {
                    bVar2.callback(1);
                }
                dismiss();
                if (this.J != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        this.J.callJs(this.K, jSONObject2.toString());
                    } catch (Exception e17) {
                        QLog.e("CUKingCardDialog", 1, "onClick exception e = ", e17);
                    }
                }
                int i16 = this.N;
                if (i16 == 2) {
                    VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-2", this.L, 1, 0, 0, "", "", "");
                } else if (i16 == 3) {
                    VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-2", this.L, 1, 0, 0, "", "", "");
                }
            } else if (id5 == R.id.cancel) {
                dismiss();
                N();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public c(Activity activity, CustomWebView customWebView, String str, int i3, String str2, int i16) {
        super(activity, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, customWebView, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            return;
        }
        this.H = null;
        this.I = activity;
        this.J = customWebView;
        this.K = str;
        this.L = str2;
        this.M = i3;
        this.N = i16;
        initView();
    }
}
