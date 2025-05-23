package com.tencent.mobileqq.structmsg;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.widget.u;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.am;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public int R0;
    protected int S0;
    protected int T0;
    public ArrayList<AbsStructMsgElement> U0;
    public int V0;
    private boolean W0;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.W0 = false;
        this.f290322e = PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME;
        this.U0 = new ArrayList<>();
        this.V0 = w();
    }

    private boolean A() {
        int i3 = this.S0;
        if (i3 >= 0 && i3 <= 3) {
            return true;
        }
        return false;
    }

    public void B(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            return;
        }
        if (!TextUtils.isEmpty(this.f290327h)) {
            int g16 = g();
            if (g16 != 0) {
                if (g16 != 1) {
                    if (g16 != 2) {
                        if (g16 == 3) {
                            view.setBackgroundResource(R.drawable.f160240dy);
                            return;
                        }
                        return;
                    }
                    view.setBackgroundResource(R.drawable.f160241dz);
                    return;
                }
                view.setBackgroundResource(R.drawable.f160244e1);
                return;
            }
            view.setBackgroundResource(R.drawable.f160243e0);
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.R0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(16)
    public void D(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        if (A() && z()) {
            int i3 = this.S0;
            if (i3 != 1) {
                if (i3 == 2) {
                    if (!TextUtils.isEmpty(this.f290327h)) {
                        this.T0 = R.drawable.f160244e1;
                    } else {
                        this.T0 = R.drawable.c3y;
                    }
                }
            } else if (!TextUtils.isEmpty(this.f290327h)) {
                this.T0 = R.drawable.f160244e1;
            } else {
                this.T0 = R.drawable.c3x;
            }
            if (view != null && g() == 1) {
                int i16 = this.T0;
                if (i16 != 0) {
                    view.setBackgroundResource(i16);
                    return;
                } else {
                    view.setBackgroundResource(R.drawable.f160244e1);
                    return;
                }
            }
            return;
        }
        if (z() && this.S0 != 0) {
            float f16 = BaseAIOUtils.f(4.0f, view.getResources());
            StateListDrawable c16 = k.c(view.getResources(), this.S0, new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f});
            if (c16 != null) {
                view.setBackground(c16);
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, this, context, view, bundle);
        }
        boolean z16 = false;
        if (bundle != null && bundle.getBoolean("key_support_night_mode", false)) {
            z16 = true;
        }
        this.W0 = z16;
        return y(context, view, bundle);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(j jVar) {
        AbsStructMsgElement a16;
        int i3;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.f290329i = jVar.a("action");
        this.f290334m = jVar.a(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        this.C = jVar.a(PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA);
        this.D = jVar.a(PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA);
        this.f290327h = jVar.a("url");
        this.E = jVar.a("brief");
        this.P = jVar.a("apurl");
        String a17 = jVar.a("flag");
        if (!TextUtils.isEmpty(a17)) {
            try {
                this.I0 = Integer.parseInt(a17);
            } catch (NumberFormatException unused) {
                this.I0 = 0;
            }
        }
        String a18 = jVar.a("mode");
        if (!TextUtils.isEmpty(a18)) {
            try {
                this.R0 = Integer.parseInt(a18);
            } catch (NumberFormatException unused2) {
                this.R0 = 0;
            }
        }
        String a19 = jVar.a(VasProfileTemplatePreloadHelper.BACKGROUND);
        try {
            if (!TextUtils.isEmpty(a19)) {
                if (a19.startsWith("#")) {
                    this.S0 = Color.parseColor(a19);
                } else {
                    this.S0 = Integer.parseInt(a19);
                }
            }
        } catch (IllegalArgumentException unused3) {
            if (QLog.isColorLevel()) {
                QLog.i("AbsStructMsgItem", 2, "Item bg value is " + this.S0);
            }
        }
        this.F = jVar.a(OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA);
        this.G = jVar.a("commonData");
        this.H = jVar.a("index");
        this.I = jVar.a("index_name");
        this.J = jVar.a("index_type");
        this.M = jVar.a(PM.CANVAS);
        this.K = jVar.a("rurl");
        this.N = jVar.a("disType");
        this.L = jVar.a("tid");
        if (this.f290320d > 10 && (jVar5 = jVar.f290431e) != null) {
            String a26 = jVar5.a("action_type");
            if (!TextUtils.isEmpty(a26)) {
                try {
                    this.Q = Integer.parseInt(a26);
                } catch (NumberFormatException unused4) {
                    this.Q = 0;
                }
            }
            String a27 = jVar5.a("dest_type");
            if (!TextUtils.isEmpty(a27)) {
                try {
                    this.W = Integer.parseInt(a27);
                } catch (NumberFormatException unused5) {
                    this.W = 0;
                }
            }
            String a28 = jVar5.a("product_type");
            if (!TextUtils.isEmpty(a28)) {
                try {
                    this.f290319c0 = Integer.parseInt(a28);
                } catch (NumberFormatException unused6) {
                    this.f290319c0 = 0;
                }
            }
            this.R = jVar5.a("advertiser_id");
            this.S = jVar5.a("aid");
            this.T = jVar5.a("app_download_schema");
            this.U = jVar5.a("canvas_json");
            this.V = jVar5.a("customized_invoke_url");
            this.X = jVar5.a("effect_url");
            this.Y = jVar5.a("landing_page");
            this.Z = jVar5.a("landing_page_report_url");
            this.f290317a0 = jVar5.a("noco_id");
            this.f290318b0 = jVar5.a(ReportDataBuilder.KEY_PRODUCT_ID);
            this.f290321d0 = jVar5.a("rl");
            this.f290323e0 = jVar5.a("subordinate_product_id");
            this.f290325f0 = jVar5.a("traceid");
            this.f290326g0 = jVar5.a("via");
            this.f290328h0 = jVar5.a("video_url");
            this.f290330i0 = jVar5.a("appname");
            this.f290331j0 = jVar5.a("customized_invoke_url");
            this.f290332k0 = jVar5.a("pkg_name");
            this.f290333l0 = jVar5.a("pkgurl");
            this.P = jVar5.a("apurl");
        }
        if (this.f290320d > 11 && (jVar4 = jVar.f290431e) != null) {
            this.f290336n0 = jVar4.a("api_click_monitor_url");
            this.f290337o0 = jVar4.a("api_exposure_monitor_url");
            this.f290338p0 = jVar4.a("trace_info_aid");
        }
        if (this.f290320d > 12 && (jVar3 = jVar.f290431e) != null) {
            this.f290339q0 = jVar3.a("corporate_image_name");
            this.f290340r0 = jVar3.a("corporate_logo");
        }
        if (this.f290320d > 13) {
            String a29 = jVar.f290431e.a(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE);
            if (!TextUtils.isEmpty(a29)) {
                try {
                    this.f290335m0 = Integer.parseInt(a29);
                } catch (NumberFormatException unused7) {
                    this.f290335m0 = 0;
                }
            }
        }
        if (this.f290320d > 14 && (jVar2 = jVar.f290431e) != null) {
            String a36 = jVar2.a(u.COLUMN_TAB_ID);
            if (!StringUtil.isEmpty(a36)) {
                try {
                    this.f290341s0 = Integer.parseInt(a36);
                } catch (NumberFormatException unused8) {
                    this.f290341s0 = 0;
                }
            }
            String a37 = jVar2.a("is_hidden");
            if (!StringUtil.isEmpty(a37)) {
                try {
                    this.f290342t0 = Integer.parseInt(a37);
                } catch (NumberFormatException unused9) {
                    this.f290342t0 = 0;
                }
            }
        }
        if (this.f290320d > 15) {
            j jVar6 = jVar.f290431e;
            this.f290343u0 = jVar6.a(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO);
            this.f290344v0 = jVar6.a("sdk_exposure_monitor_url");
            this.f290345w0 = jVar6.a("sdk_click_monitor_url");
            String a38 = jVar6.a("media_duration");
            if (!StringUtil.isEmpty(a38)) {
                try {
                    this.f290346x0 = Integer.parseInt(a38);
                } catch (NumberFormatException unused10) {
                    this.f290346x0 = 0;
                }
            }
            String a39 = jVar6.a("video_file_size");
            if (!StringUtil.isEmpty(a39)) {
                try {
                    this.f290347y0 = Integer.parseInt(a39);
                } catch (NumberFormatException unused11) {
                    this.f290347y0 = 0;
                }
            }
            String a46 = jVar6.a("app_score_num");
            if (!StringUtil.isEmpty(a46)) {
                try {
                    this.f290348z0 = Integer.parseInt(a46);
                } catch (NumberFormatException unused12) {
                    this.f290348z0 = 0;
                }
            }
            String a47 = jVar6.a("download_num");
            if (!StringUtil.isEmpty(a47)) {
                try {
                    this.A0 = Integer.parseInt(a47);
                } catch (NumberFormatException unused13) {
                    this.A0 = 0;
                }
            }
            this.B0 = jVar6.a("universal_link");
            this.C0 = jVar6.a("sdk_data");
            this.D0 = jVar6.a("tencent_video_id");
            this.E0 = jVar6.a("view_id");
        }
        if (this.f290320d > 16) {
            this.F0 = jVar.f290431e.a("qgg_ext");
        }
        if (this.f290320d > 17) {
            j jVar7 = jVar.f290431e;
            this.G0 = jVar7.a("adInfo");
            this.H0 = jVar7.a("is_report_click");
        }
        int b16 = jVar.b();
        for (int i16 = 0; i16 < b16; i16++) {
            j c16 = jVar.c(i16);
            if (c16 != null) {
                if (PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(c16.f290428b)) {
                    String a48 = c16.a(TtmlNode.TAG_LAYOUT);
                    try {
                        if (!TextUtils.isEmpty(a48)) {
                            i3 = Integer.parseInt(a48);
                        } else {
                            i3 = 0;
                        }
                        a16 = h.c(i3);
                    } catch (NumberFormatException unused14) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AbsStructMsgItem", 2, "Item layout value is 0");
                        }
                        return false;
                    }
                } else {
                    a16 = h.a(c16.f290428b);
                }
                if (a16 == null || !a16.d(c16)) {
                    return false;
                }
                m(a16);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(x());
        stringBuffer.append(this.R0);
        ArrayList<AbsStructMsgElement> arrayList = this.U0;
        if (arrayList != null) {
            Iterator<AbsStructMsgElement> it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().f());
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        AbsStructMsgElement absStructMsgElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
            return;
        }
        int readInt = objectInput.readInt();
        this.f290320d = readInt;
        if (readInt > 0 && readInt <= 18) {
            this.f290327h = objectInput.readUTF();
            this.f290329i = objectInput.readUTF();
            this.f290334m = objectInput.readUTF();
            this.C = objectInput.readUTF();
            this.D = objectInput.readUTF();
            this.E = objectInput.readUTF();
            this.I0 = objectInput.readInt();
            this.R0 = objectInput.readInt();
            int i3 = this.f290320d;
            if (2 <= i3 && i3 <= 18) {
                this.S0 = objectInput.readInt();
            }
            int readInt2 = objectInput.readInt();
            int i16 = 1;
            for (int i17 = 0; i17 < readInt2; i17++) {
                String readUTF = objectInput.readUTF();
                if (PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(readUTF)) {
                    absStructMsgElement = h.c(objectInput.readInt());
                } else {
                    AbsStructMsgElement a16 = h.a(readUTF);
                    if ("button".equals(readUTF) && a16 != null) {
                        a16.K0 = String.valueOf(i16);
                        a16.M0 = this.M0;
                        i16++;
                    }
                    if (a16 != null && a.class.isInstance(a16)) {
                        objectInput.readInt();
                    }
                    absStructMsgElement = a16;
                }
                String x16 = x();
                if (x16 != null && absStructMsgElement != null && (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.c)) {
                    if (!x16.endsWith("Layout4") && !x16.endsWith("Layout2") && !x16.endsWith("Layout9")) {
                        if (x16.endsWith("Layout3")) {
                            ((com.tencent.mobileqq.structmsg.view.c) absStructMsgElement).W0 = com.tencent.mobileqq.structmsg.view.c.Z0;
                        }
                    } else {
                        ((com.tencent.mobileqq.structmsg.view.c) absStructMsgElement).W0 = com.tencent.mobileqq.structmsg.view.c.Y0;
                    }
                }
                if (absStructMsgElement != null) {
                    absStructMsgElement.P0 = this.P0;
                    absStructMsgElement.i(objectInput);
                    m(absStructMsgElement);
                }
            }
            int i18 = this.f290320d;
            if (i18 >= 3 && i18 <= 18) {
                this.F = objectInput.readUTF();
                if (this.f290320d > 5) {
                    this.H = objectInput.readUTF();
                    this.I = objectInput.readUTF();
                    this.J = objectInput.readUTF();
                }
                if (this.f290320d > 8) {
                    this.G = objectInput.readUTF();
                }
                if (this.f290320d > 9) {
                    this.L = objectInput.readUTF();
                    this.M = objectInput.readUTF();
                    this.N = objectInput.readUTF();
                    this.K = objectInput.readUTF();
                    this.P = objectInput.readUTF();
                }
                if (this.f290320d > 10) {
                    this.Q = objectInput.readInt();
                    this.R = objectInput.readUTF();
                    this.S = objectInput.readUTF();
                    this.T = objectInput.readUTF();
                    this.U = objectInput.readUTF();
                    this.V = objectInput.readUTF();
                    this.W = objectInput.readInt();
                    this.X = objectInput.readUTF();
                    this.Y = objectInput.readUTF();
                    this.Z = objectInput.readUTF();
                    this.f290317a0 = objectInput.readUTF();
                    this.f290318b0 = objectInput.readUTF();
                    this.f290319c0 = objectInput.readInt();
                    this.f290321d0 = objectInput.readUTF();
                    this.f290323e0 = objectInput.readUTF();
                    this.f290325f0 = objectInput.readUTF();
                    this.f290326g0 = objectInput.readUTF();
                    this.f290328h0 = objectInput.readUTF();
                    this.f290330i0 = objectInput.readUTF();
                    this.f290331j0 = objectInput.readUTF();
                    this.f290332k0 = objectInput.readUTF();
                    this.f290333l0 = objectInput.readUTF();
                }
                if (this.f290320d > 11) {
                    this.f290336n0 = objectInput.readUTF();
                    this.f290337o0 = objectInput.readUTF();
                    this.f290338p0 = objectInput.readUTF();
                }
                if (this.f290320d > 12) {
                    this.f290339q0 = objectInput.readUTF();
                    this.f290340r0 = objectInput.readUTF();
                }
                if (this.f290320d > 13) {
                    this.f290335m0 = objectInput.readInt();
                }
                if (this.f290320d > 14) {
                    this.f290341s0 = objectInput.readInt();
                    this.f290342t0 = objectInput.readInt();
                }
                if (this.f290320d > 15) {
                    this.f290343u0 = objectInput.readUTF();
                    this.f290344v0 = objectInput.readUTF();
                    this.f290345w0 = objectInput.readUTF();
                    this.f290346x0 = objectInput.readInt();
                    this.f290347y0 = objectInput.readInt();
                    this.f290348z0 = objectInput.readInt();
                    this.A0 = objectInput.readInt();
                    this.B0 = objectInput.readUTF();
                    this.C0 = objectInput.readUTF();
                    this.D0 = objectInput.readUTF();
                    this.E0 = objectInput.readUTF();
                }
                if (this.f290320d > 16) {
                    this.F0 = objectInput.readUTF();
                }
                if (this.f290320d > 17) {
                    this.G0 = objectInput.readUTF();
                    this.H0 = objectInput.readUTF();
                    return;
                }
                return;
            }
            return;
        }
        throw new IOException("structmsg_version_error");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void j(AbsShareMsg absShareMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) absShareMsg);
            return;
        }
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        while (it.hasNext()) {
            it.next().j(absShareMsg);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, this.f290322e);
        int i3 = this.V0;
        if (i3 < 0) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(i3);
        }
        xmlSerializer.attribute(null, TtmlNode.TAG_LAYOUT, valueOf);
        if (!TextUtils.isEmpty(this.f290329i)) {
            xmlSerializer.attribute(null, "action", this.f290329i);
        }
        if (!TextUtils.isEmpty(this.f290334m)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, this.f290334m);
        }
        if (!TextUtils.isEmpty(this.C)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA, this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA, this.D);
        }
        if (!TextUtils.isEmpty(this.f290327h)) {
            xmlSerializer.attribute(null, "url", this.f290327h);
        }
        if (!TextUtils.isEmpty(this.E)) {
            xmlSerializer.attribute(null, "brief", this.E);
        }
        int i16 = this.I0;
        if (i16 != 0) {
            xmlSerializer.attribute(null, "flag", String.valueOf(i16));
        }
        int i17 = this.R0;
        if (i17 != 0) {
            xmlSerializer.attribute(null, "mode", String.valueOf(i17));
        }
        int i18 = this.S0;
        if (i18 != 0) {
            xmlSerializer.attribute(null, VasProfileTemplatePreloadHelper.BACKGROUND, String.valueOf(i18));
        }
        if (!TextUtils.isEmpty(this.F)) {
            xmlSerializer.attribute(null, OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, this.F);
        }
        if (!TextUtils.isEmpty(this.G)) {
            xmlSerializer.attribute(null, "commonData", this.G);
        }
        if (!TextUtils.isEmpty(this.H)) {
            xmlSerializer.attribute(null, "index", this.H);
        }
        if (!TextUtils.isEmpty(this.I)) {
            xmlSerializer.attribute(null, "index_name", this.I);
        }
        if (!TextUtils.isEmpty(this.J)) {
            xmlSerializer.attribute(null, "index_type", this.J);
        }
        if (!TextUtils.isEmpty(this.M)) {
            xmlSerializer.attribute(null, PM.CANVAS, this.M);
        }
        if (!TextUtils.isEmpty(this.K)) {
            xmlSerializer.attribute(null, "rurl", this.K);
        }
        if (!TextUtils.isEmpty(this.N)) {
            xmlSerializer.attribute(null, "disType", this.N);
        }
        if (!TextUtils.isEmpty(this.L)) {
            xmlSerializer.attribute(null, "tid", this.L);
        }
        if (!TextUtils.isEmpty(this.P)) {
            xmlSerializer.attribute(null, "apurl", this.P);
        }
        int i19 = this.Q;
        if (i19 != 0) {
            xmlSerializer.attribute(null, "action_type", String.valueOf(i19));
        }
        if (!TextUtils.isEmpty(this.R)) {
            xmlSerializer.attribute(null, "advertiser_id", this.R);
        }
        if (!TextUtils.isEmpty(this.S)) {
            xmlSerializer.attribute(null, "aid", this.S);
        }
        if (!TextUtils.isEmpty(this.T)) {
            xmlSerializer.attribute(null, "app_download_schema", this.T);
        }
        if (!TextUtils.isEmpty(this.U)) {
            xmlSerializer.attribute(null, "canvas_json", this.U);
        }
        if (!TextUtils.isEmpty(this.V)) {
            xmlSerializer.attribute(null, "customized_invoke_url", this.V);
        }
        int i26 = this.W;
        if (i26 != 0) {
            xmlSerializer.attribute(null, "dest_type", String.valueOf(i26));
        }
        if (!TextUtils.isEmpty(this.X)) {
            xmlSerializer.attribute(null, "effect_url", this.X);
        }
        if (!TextUtils.isEmpty(this.Y)) {
            xmlSerializer.attribute(null, "landing_page", this.Y);
        }
        if (!TextUtils.isEmpty(this.Z)) {
            xmlSerializer.attribute(null, "landing_page_report_url", this.Z);
        }
        if (!TextUtils.isEmpty(this.f290317a0)) {
            xmlSerializer.attribute(null, "noco_id", this.f290317a0);
        }
        if (!TextUtils.isEmpty(this.f290318b0)) {
            xmlSerializer.attribute(null, ReportDataBuilder.KEY_PRODUCT_ID, this.f290318b0);
        }
        int i27 = this.f290319c0;
        if (i27 != 0) {
            xmlSerializer.attribute(null, "product_type", String.valueOf(i27));
        }
        int i28 = this.f290335m0;
        if (i28 != 0) {
            xmlSerializer.attribute(null, MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE, String.valueOf(i28));
        }
        if (!TextUtils.isEmpty(this.f290321d0)) {
            xmlSerializer.attribute(null, "rl", this.f290321d0);
        }
        if (!TextUtils.isEmpty(this.f290323e0)) {
            xmlSerializer.attribute(null, "subordinate_product_id", this.f290323e0);
        }
        if (!TextUtils.isEmpty(this.f290325f0)) {
            xmlSerializer.attribute(null, "traceid", this.f290325f0);
        }
        if (!TextUtils.isEmpty(this.f290326g0)) {
            xmlSerializer.attribute(null, "via", this.f290326g0);
        }
        if (!TextUtils.isEmpty(this.f290328h0)) {
            xmlSerializer.attribute(null, "video_url", this.f290328h0);
        }
        if (!TextUtils.isEmpty(this.f290330i0)) {
            xmlSerializer.attribute(null, "appname", this.f290330i0);
        }
        if (!TextUtils.isEmpty(this.f290331j0)) {
            xmlSerializer.attribute(null, "customized_invoke_url", this.f290331j0);
        }
        if (!TextUtils.isEmpty(this.f290332k0)) {
            xmlSerializer.attribute(null, "pkg_name", this.f290332k0);
        }
        if (!TextUtils.isEmpty(this.f290333l0)) {
            xmlSerializer.attribute(null, "pkgurl", this.f290333l0);
        }
        if (!TextUtils.isEmpty(this.f290337o0)) {
            xmlSerializer.attribute(null, "api_exposure_monitor_url", this.f290337o0);
        }
        if (!TextUtils.isEmpty(this.f290336n0)) {
            xmlSerializer.attribute(null, "api_click_monitor_url", this.f290336n0);
        }
        if (!TextUtils.isEmpty(this.f290338p0)) {
            xmlSerializer.attribute(null, "trace_info_aid", this.f290338p0);
        }
        if (!TextUtils.isEmpty(this.f290339q0)) {
            xmlSerializer.attribute(null, "corporate_image_name", this.f290339q0);
        }
        if (!TextUtils.isEmpty(this.f290340r0)) {
            xmlSerializer.attribute(null, "corporate_logo", this.f290340r0);
        }
        int i29 = this.f290341s0;
        if (i29 != 0) {
            xmlSerializer.attribute(null, u.COLUMN_TAB_ID, String.valueOf(i29));
        }
        int i36 = this.f290342t0;
        if (i36 != 0) {
            xmlSerializer.attribute(null, "is_hidden", String.valueOf(i36));
        }
        if (!TextUtils.isEmpty(this.f290343u0)) {
            xmlSerializer.attribute(null, Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, this.f290343u0);
        }
        if (!TextUtils.isEmpty(this.f290344v0)) {
            xmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.f290344v0);
        }
        if (!TextUtils.isEmpty(this.f290345w0)) {
            xmlSerializer.attribute(null, "sdk_click_monitor_url", this.f290345w0);
        }
        int i37 = this.f290346x0;
        if (i37 != 0) {
            xmlSerializer.attribute(null, "media_duration", String.valueOf(i37));
        }
        int i38 = this.f290347y0;
        if (i38 != 0) {
            xmlSerializer.attribute(null, "video_file_size", String.valueOf(i38));
        }
        int i39 = this.f290348z0;
        if (i39 != 0) {
            xmlSerializer.attribute(null, "app_score_num", String.valueOf(i39));
        }
        int i46 = this.A0;
        if (i46 != 0) {
            xmlSerializer.attribute(null, "download_num", String.valueOf(i46));
        }
        if (!TextUtils.isEmpty(this.B0)) {
            xmlSerializer.attribute(null, "universal_link", this.B0);
        }
        if (!TextUtils.isEmpty(this.C0)) {
            xmlSerializer.attribute(null, "sdk_data", this.C0);
        }
        if (!TextUtils.isEmpty(this.D0)) {
            xmlSerializer.attribute(null, "tencent_video_id", this.D0);
        }
        if (!TextUtils.isEmpty(this.E0)) {
            xmlSerializer.attribute(null, "view_id", this.E0);
        }
        if (!TextUtils.isEmpty(this.F0)) {
            xmlSerializer.attribute(null, "qgg_ext", this.F0);
        }
        if (!TextUtils.isEmpty(this.G0)) {
            xmlSerializer.attribute(null, "adInfo", this.G0);
        }
        if (!TextUtils.isEmpty(this.H0)) {
            xmlSerializer.attribute(null, "is_report_click", this.H0);
        }
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        while (it.hasNext()) {
            it.next().k(xmlSerializer);
        }
        xmlSerializer.endTag(null, this.f290322e);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectOutput);
            return;
        }
        objectOutput.writeUTF(this.f290322e);
        objectOutput.writeInt(this.V0);
        objectOutput.writeInt(this.f290320d);
        String str = this.f290327h;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.f290329i;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.f290334m;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        String str5 = this.C;
        if (str5 == null) {
            str5 = "";
        }
        objectOutput.writeUTF(str5);
        String str6 = this.D;
        if (str6 == null) {
            str6 = "";
        }
        objectOutput.writeUTF(str6);
        String str7 = this.E;
        if (str7 == null) {
            str7 = "";
        }
        objectOutput.writeUTF(str7);
        objectOutput.writeInt(this.I0);
        objectOutput.writeInt(this.R0);
        objectOutput.writeInt(this.S0);
        objectOutput.writeInt(this.U0.size());
        QLog.i("getStructMsgFromXmlBuff", 2, "mVersion: " + this.f290320d);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        while (it.hasNext()) {
            it.next().l(objectOutput);
        }
        int i3 = this.f290320d;
        if (i3 >= 3 && i3 <= 18) {
            String str8 = this.F;
            if (str8 == null) {
                str8 = "";
            }
            objectOutput.writeUTF(str8);
            if (this.f290320d > 5) {
                String str9 = this.H;
                if (str9 == null) {
                    str9 = "";
                }
                objectOutput.writeUTF(str9);
                String str10 = this.I;
                if (str10 == null) {
                    str10 = "";
                }
                objectOutput.writeUTF(str10);
                String str11 = this.J;
                if (str11 == null) {
                    str11 = "";
                }
                objectOutput.writeUTF(str11);
            }
            if (this.f290320d > 8) {
                String str12 = this.G;
                if (str12 == null) {
                    str12 = "";
                }
                objectOutput.writeUTF(str12);
            }
            if (this.f290320d > 9) {
                String str13 = this.L;
                if (str13 == null) {
                    str13 = "";
                }
                objectOutput.writeUTF(str13);
                String str14 = this.M;
                if (str14 == null) {
                    str14 = "";
                }
                objectOutput.writeUTF(str14);
                String str15 = this.N;
                if (str15 == null) {
                    str15 = "";
                }
                objectOutput.writeUTF(str15);
                String str16 = this.K;
                if (str16 == null) {
                    str16 = "";
                }
                objectOutput.writeUTF(str16);
                String str17 = this.P;
                if (str17 == null) {
                    str17 = "";
                }
                objectOutput.writeUTF(str17);
            }
            if (this.f290320d > 10) {
                objectOutput.writeInt(this.Q);
                String str18 = this.R;
                String str19 = "0";
                if (str18 == null) {
                    str18 = "0";
                }
                objectOutput.writeUTF(str18);
                String str20 = this.S;
                if (str20 != null) {
                    str19 = str20;
                }
                objectOutput.writeUTF(str19);
                String str21 = this.T;
                if (str21 == null) {
                    str21 = "";
                }
                objectOutput.writeUTF(str21);
                String str22 = this.U;
                if (str22 == null) {
                    str22 = "";
                }
                objectOutput.writeUTF(str22);
                String str23 = this.V;
                if (str23 == null) {
                    str23 = "";
                }
                objectOutput.writeUTF(str23);
                objectOutput.writeInt(this.W);
                String str24 = this.X;
                if (str24 == null) {
                    str24 = "";
                }
                objectOutput.writeUTF(str24);
                String str25 = this.Y;
                if (str25 == null) {
                    str25 = "";
                }
                objectOutput.writeUTF(str25);
                String str26 = this.Z;
                if (str26 == null) {
                    str26 = "";
                }
                objectOutput.writeUTF(str26);
                String str27 = this.f290317a0;
                if (str27 == null) {
                    str27 = "";
                }
                objectOutput.writeUTF(str27);
                String str28 = this.f290318b0;
                if (str28 == null) {
                    str28 = "";
                }
                objectOutput.writeUTF(str28);
                objectOutput.writeInt(this.f290319c0);
                String str29 = this.f290321d0;
                if (str29 == null) {
                    str29 = "";
                }
                objectOutput.writeUTF(str29);
                String str30 = this.f290323e0;
                if (str30 == null) {
                    str30 = "";
                }
                objectOutput.writeUTF(str30);
                String str31 = this.f290325f0;
                if (str31 == null) {
                    str31 = "";
                }
                objectOutput.writeUTF(str31);
                String str32 = this.f290326g0;
                if (str32 == null) {
                    str32 = "";
                }
                objectOutput.writeUTF(str32);
                String str33 = this.f290328h0;
                if (str33 == null) {
                    str33 = "";
                }
                objectOutput.writeUTF(str33);
                String str34 = this.f290330i0;
                if (str34 == null) {
                    str34 = "";
                }
                objectOutput.writeUTF(str34);
                String str35 = this.f290331j0;
                if (str35 == null) {
                    str35 = "";
                }
                objectOutput.writeUTF(str35);
                String str36 = this.f290332k0;
                if (str36 == null) {
                    str36 = "";
                }
                objectOutput.writeUTF(str36);
                String str37 = this.f290333l0;
                if (str37 == null) {
                    str37 = "";
                }
                objectOutput.writeUTF(str37);
            }
            if (this.f290320d > 11) {
                String str38 = this.f290336n0;
                if (str38 == null) {
                    str38 = "";
                }
                objectOutput.writeUTF(str38);
                String str39 = this.f290337o0;
                if (str39 == null) {
                    str39 = "";
                }
                objectOutput.writeUTF(str39);
                String str40 = this.f290338p0;
                if (str40 == null) {
                    str40 = "";
                }
                objectOutput.writeUTF(str40);
            }
            if (this.f290320d > 12) {
                String str41 = this.f290339q0;
                if (str41 == null) {
                    str41 = "";
                }
                objectOutput.writeUTF(str41);
                String str42 = this.f290340r0;
                if (str42 == null) {
                    str42 = "";
                }
                objectOutput.writeUTF(str42);
            }
            if (this.f290320d > 13) {
                objectOutput.writeInt(this.f290335m0);
            }
            if (this.f290320d > 14) {
                objectOutput.writeInt(this.f290341s0);
                objectOutput.writeInt(this.f290342t0);
            }
            if (this.f290320d > 15) {
                String str43 = this.f290343u0;
                if (str43 == null) {
                    str43 = "";
                }
                objectOutput.writeUTF(str43);
                String str44 = this.f290344v0;
                if (str44 == null) {
                    str44 = "";
                }
                objectOutput.writeUTF(str44);
                String str45 = this.f290345w0;
                if (str45 == null) {
                    str45 = "";
                }
                objectOutput.writeUTF(str45);
                objectOutput.writeInt(this.f290346x0);
                objectOutput.writeInt(this.f290347y0);
                objectOutput.writeInt(this.f290348z0);
                objectOutput.writeInt(this.A0);
                String str46 = this.B0;
                if (str46 == null) {
                    str46 = "";
                }
                objectOutput.writeUTF(str46);
                String str47 = this.C0;
                if (str47 == null) {
                    str47 = "";
                }
                objectOutput.writeUTF(str47);
                String str48 = this.D0;
                if (str48 == null) {
                    str48 = "";
                }
                objectOutput.writeUTF(str48);
                String str49 = this.E0;
                if (str49 == null) {
                    str49 = "";
                }
                objectOutput.writeUTF(str49);
            }
            if (this.f290320d > 16) {
                String str50 = this.F0;
                if (str50 == null) {
                    str50 = "";
                }
                objectOutput.writeUTF(str50);
            }
            if (this.f290320d > 17) {
                String str51 = this.G0;
                if (str51 == null) {
                    str51 = "";
                }
                objectOutput.writeUTF(str51);
                String str52 = this.H0;
                if (str52 != null) {
                    str2 = str52;
                }
                objectOutput.writeUTF(str2);
            }
        }
    }

    public void m(AbsStructMsgElement absStructMsgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) absStructMsgElement);
            return;
        }
        if ((absStructMsgElement instanceof b) && !A()) {
            ((b) absStructMsgElement).R0 = null;
        }
        this.U0.add(absStructMsgElement);
    }

    public void n(String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, str2, Integer.valueOf(i3), str3);
            return;
        }
        this.R0 = i3;
        m(new com.tencent.mobileqq.structmsg.view.c(str, str3));
        m(new StructMsgItemTitle(""));
    }

    public void o(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, str2, str3);
        } else {
            q(str, str2, str3, 0, "0");
        }
    }

    public void p(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, str2, str3, Integer.valueOf(i3));
        } else {
            q(str, str2, str3, i3, "0");
        }
    }

    public void q(String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, str3, Integer.valueOf(i3), str4);
            return;
        }
        this.R0 = i3;
        m(new com.tencent.mobileqq.structmsg.view.c(str, str4));
        m(new StructMsgItemTitle(str2));
        m(new ap(str3));
    }

    public void r(String str, String str2, String str3, String str4, String str5, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, str3, str4, str5, Integer.valueOf(i3));
            return;
        }
        this.R0 = i3;
        if (str2 != null && !str2.equals("")) {
            m(new StructMsgItemTitle(str2));
        }
        if (str != null && !str.equals("")) {
            m(new com.tencent.mobileqq.structmsg.view.c(str));
        }
        if (str3 != null && !str3.equals("")) {
            m(new ap(str3));
        }
        if (str4 != null && !str4.equals("")) {
            m(new am(str4, str5));
        }
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            m(new ap(str));
            m(new com.tencent.mobileqq.structmsg.view.d());
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.V0 = 0;
            m(new com.tencent.mobileqq.structmsg.view.e(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.W0 && QQTheme.isNowThemeIsNight()) {
            return true;
        }
        return false;
    }

    public int v(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context, i3)).intValue();
        }
        return (int) (TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    protected abstract int w();

    public abstract String x();

    public abstract View y(Context context, View view, Bundle bundle);

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (g() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Collection<AbsStructMsgElement> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) collection);
            return;
        }
        this.W0 = false;
        this.f290322e = PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME;
        this.U0 = new ArrayList<>(collection);
        this.V0 = w();
    }
}
