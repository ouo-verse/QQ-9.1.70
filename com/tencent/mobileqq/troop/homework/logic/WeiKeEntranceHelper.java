package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigParser;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.utils.eu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class WeiKeEntranceHelper implements a, View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected Boolean C;
    protected String D;
    protected int E;
    protected String F;
    protected int G;
    protected JSONObject H;

    /* renamed from: d, reason: collision with root package name */
    protected String f297148d;

    /* renamed from: e, reason: collision with root package name */
    protected PublishHomeWorkFragment f297149e;

    /* renamed from: f, reason: collision with root package name */
    protected View f297150f;

    /* renamed from: h, reason: collision with root package name */
    protected LinearLayout f297151h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f297152i;

    /* renamed from: m, reason: collision with root package name */
    protected View f297153m;

    private void h(View view) {
        k(false);
        LinearLayout linearLayout = this.f297151h;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f297149e.Ci(1);
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f297150f = this.f297149e.findViewById(R.id.f29300l_);
        com.tencent.mobileqq.troop.homework.config.a c16 = PublishHwkThirdPartyEntryConfigParser.c();
        if (c16 != null) {
            if (c16.d()) {
                this.f297150f.setVisibility(0);
                this.f297150f.setOnClickListener(this);
                if (this.f297149e.Mh() == 1) {
                    this.f297150f.setClickable(true);
                } else {
                    this.f297150f.setClickable(false);
                }
            } else {
                this.f297150f.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f297149e.findViewById(R.id.f101985wo);
        this.f297151h = linearLayout;
        linearLayout.setOnClickListener(this);
        if (!this.C.booleanValue()) {
            this.f297151h.setVisibility(8);
        }
        this.f297152i = (TextView) this.f297149e.findViewById(R.id.f102105x0);
        View findViewById = this.f297149e.findViewById(R.id.f10403628);
        this.f297153m = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void b(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONArray);
            return;
        }
        if (this.C.booleanValue()) {
            Object obj = this.H;
            if (obj != null) {
                jSONArray.mo162put(obj);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "exam");
                jSONObject.put("exam_type", "1");
                jSONObject.put("appid", "101036803");
                jSONObject.put("exam_id", String.valueOf(this.G));
                jSONObject.put(Element.ELEMENT_NAME_COURSE_NAME, this.F);
                jSONObject.put("exam_count", String.valueOf(this.E));
                jSONObject.put("title", this.D);
                jSONArray.mo162put(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.C.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void d(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONObject);
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("exam_type");
        String optString3 = jSONObject.optString("appid");
        if (optString != null && optString.equals("exam") && optString2 != null && !optString2.equals("0") && optString3 != null && optString3.equals("101036803")) {
            this.H = jSONObject;
            String optString4 = jSONObject.optString("exam_id");
            this.f297152i.setText(jSONObject.optString("title"));
            this.G = Integer.valueOf(optString4).intValue();
            this.f297151h.setVisibility(0);
            this.f297151h.setClickable(false);
            this.f297153m.setVisibility(8);
            k(true);
            this.f297149e.Ci(1);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            if (!this.C.booleanValue()) {
                return;
            }
            if (z16) {
                this.f297151h.setVisibility(8);
            } else {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeiKeEntranceHelper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            WeiKeEntranceHelper.this.f297151h.setVisibility(0);
                        }
                    }
                }, 20L);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void f(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (i3 != 1) {
            if (z16) {
                this.f297150f.setEnabled(false);
            } else {
                this.f297150f.setEnabled(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (this.C.booleanValue() && i3 == 1) {
            Bundle Oh = this.f297149e.Oh();
            String[] strArr = new String[3];
            String str = this.f297148d;
            if (str == null) {
                str = "";
            }
            strArr[0] = str;
            strArr[1] = Oh.getString("reportIdentity", "");
            strArr[2] = Oh.getString("reportCourse", "");
            eu.g("Grp_edu", "homework", "createHW_lele", 0, 0, strArr);
        }
    }

    protected void i(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DocsEntranceHelper", 2, "onClickWeiKeLink");
        }
        String b16 = PublishHwkThirdPartyEntryConfigParser.c().b();
        if (b16.isEmpty()) {
            return;
        }
        String str = b16 + "?gc=" + this.f297148d + "&appid=101036803&examid=" + this.G + "&_wwv=128&_wv=3";
        Intent intent = new Intent();
        intent.putExtra("url", str);
        RouteUtils.startActivity(this.f297149e.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
        if (this.f297149e.Lh() != null) {
            this.f297149e.Lh().B();
        }
    }

    protected void j(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DocsEntranceHelper", 2, "onJumpToWeiKe");
        }
        InputMethodUtil.hide(this.f297149e.getActivity());
        Intent intent = new Intent();
        intent.putExtra("url", PublishHwkThirdPartyEntryConfigParser.c().c() + "?gc=" + this.f297148d + "&appid=101036803&_wwv=128&_wv=3");
        RouteUtils.startActivityForResult(this.f297149e.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER, 264);
        if (this.f297149e.Lh() != null) {
            this.f297149e.Lh().B();
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.C = Boolean.valueOf(z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 264) {
            return;
        }
        if (intent == null) {
            QLog.e("DocsEntranceHelper", 2, "onActivityResult data == null");
            return;
        }
        String stringExtra = intent.getStringExtra("params");
        if (stringExtra.isEmpty()) {
            QLog.e("DocsEntranceHelper", 2, "onActivityResult strData.isEmpty");
            return;
        }
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.e("DocsEntranceHelper", 2, "onActivityResult argsJson == null");
            return;
        }
        this.D = jSONObject.optString("title");
        this.E = jSONObject.optInt(WidgetCacheConstellationData.NUM, 0);
        String str = HardCodeUtil.qqStr(R.string.f180453b4) + " (" + this.E + HardCodeUtil.qqStr(R.string.f180463b5) + ")\n" + HardCodeUtil.qqStr(R.string.f180473b6) + "\n" + this.D;
        this.F = jSONObject.optString(Element.ELEMENT_NAME_COURSE_NAME);
        this.G = jSONObject.optInt("exam_id", -1);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "str");
            jSONObject2.put("text", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            if (this.f297149e.Lh() != null) {
                this.f297149e.Lh().setDataByEdit(jSONArray, this.f297148d);
                this.f297149e.vi();
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        this.f297152i.setText(this.D);
        this.f297151h.setVisibility(0);
        k(true);
        this.f297149e.Ci(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f29300l_) {
                j(view);
            } else if (id5 == R.id.f101975wn) {
                i(view);
            } else if (id5 == R.id.f10403628) {
                h(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
