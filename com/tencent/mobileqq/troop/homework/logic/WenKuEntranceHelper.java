package com.tencent.mobileqq.troop.homework.logic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigParser;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.utils.eu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class WenKuEntranceHelper implements a, View.OnClickListener {
    static IPatchRedirector $redirector_;
    protected TextView C;
    protected View D;
    protected Boolean E;
    protected String F;
    protected int G;
    protected String H;
    protected String I;
    protected JSONObject J;
    protected boolean K;
    protected long L;
    protected boolean M;
    protected boolean N;
    protected boolean P;

    /* renamed from: d, reason: collision with root package name */
    protected String f297154d;

    /* renamed from: e, reason: collision with root package name */
    protected PublishHomeWorkFragment f297155e;

    /* renamed from: f, reason: collision with root package name */
    protected View f297156f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f297157h;

    /* renamed from: i, reason: collision with root package name */
    protected View f297158i;

    /* renamed from: m, reason: collision with root package name */
    protected LinearLayout f297159m;

    public WenKuEntranceHelper(PublishHomeWorkFragment publishHomeWorkFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) publishHomeWorkFragment, (Object) str);
            return;
        }
        this.E = Boolean.FALSE;
        this.F = "";
        this.G = 0;
        this.H = "";
        this.I = "";
        this.J = null;
        this.K = false;
        this.L = 0L;
        this.M = false;
        this.N = true;
        this.P = false;
        this.f297155e = publishHomeWorkFragment;
        this.f297154d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j() {
        AppInterface appInterface;
        if (this.f297155e.getActivity() == null) {
            appInterface = null;
        } else {
            appInterface = (AppInterface) this.f297155e.getQBaseActivity().getAppRuntime();
        }
        if (appInterface == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            }
            if (appInterface == null) {
                return "publish_hw_docs_guide_counts";
            }
        }
        return "publish_hw_docs_guide_counts" + appInterface.getCurrentAccountUin();
    }

    private boolean k() {
        if (this.f297155e.Mh() == 1) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (!k()) {
            return false;
        }
        com.tencent.mobileqq.troop.homework.config.a c16 = PublishHwkThirdPartyEntryConfigParser.c();
        if (c16 != null && !c16.E) {
            return false;
        }
        int i3 = PreferenceManager.getDefaultSharedPreferences(this.f297155e.getActivity()).getInt(j(), 0);
        if (QLog.isColorLevel()) {
            QLog.d("DocsEntranceHelper", 2, String.format("needShow guide count: %s", Integer.valueOf(i3)));
        }
        if (i3 >= 3) {
            return false;
        }
        return true;
    }

    private void m(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("DocsEntranceHelper", 2, "onClickDocsLink");
        }
        Intent intent = new Intent();
        StringBuilder sb5 = new StringBuilder(this.I);
        if (!this.I.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb5.append("client=homeworkt");
        intent.putExtra("url", sb5.toString());
        RouteUtils.startActivity(this.f297155e.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
        if (this.f297155e.Lh() != null) {
            this.f297155e.Lh().B();
        }
    }

    private void n(View view) {
        q(false);
        LinearLayout linearLayout = this.f297159m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f297155e.Ci(2);
    }

    private void o(View view) {
        QLog.d("DocsEntranceHelper", 1, "onJumpToDocs");
        com.tencent.mobileqq.troop.homework.config.a c16 = PublishHwkThirdPartyEntryConfigParser.c();
        if (c16 != null) {
            String str = c16.C;
            if (str.isEmpty()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("url", str + "?id=homework&client=homeworkt&_wv=2");
            RouteUtils.startActivityForResult(this.f297155e.getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER, 265);
            if (this.f297155e.Lh() != null) {
                this.f297155e.Lh().B();
            }
            if (this.f297157h.getVisibility() == 0) {
                p(false, 3);
                s(false);
                r(false);
            }
        }
        Bundle Oh = this.f297155e.Oh();
        String[] strArr = new String[3];
        String str2 = this.f297154d;
        if (str2 == null) {
            str2 = "";
        }
        strArr[0] = str2;
        strArr[1] = Oh.getString("reportIdentity", "");
        strArr[2] = Oh.getString("reportCourse", "");
        eu.g("Grp_edu", "homework", "createHW_doc_clk", 0, 0, strArr);
    }

    private void p(boolean z16, int i3) {
        ThreadManagerV2.postImmediately(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.troop.homework.logic.WenKuEntranceHelper.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f297160d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f297161e;

            {
                this.f297160d = z16;
                this.f297161e = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, WenKuEntranceHelper.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(WenKuEntranceHelper.this.f297155e.getActivity());
                int i16 = defaultSharedPreferences.getInt(WenKuEntranceHelper.this.j(), 0);
                if (QLog.isColorLevel()) {
                    QLog.d("DocsEntranceHelper", 2, String.format("onShow guide count: %s", Integer.valueOf(i16)));
                }
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                if (this.f297160d) {
                    edit.putInt(WenKuEntranceHelper.this.j(), i16 + this.f297161e).commit();
                } else {
                    edit.putInt(WenKuEntranceHelper.this.j(), this.f297161e).commit();
                }
                edit.apply();
            }
        }, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16) {
        View view = this.f297158i;
        if (view != null) {
            if (z16 && !this.K) {
                view.setVisibility(0);
                this.K = true;
            } else {
                view.setVisibility(8);
            }
        }
    }

    private void s(boolean z16) {
        TextView textView = this.f297157h;
        if (textView != null) {
            if (z16) {
                textView.setVisibility(0);
                this.f297157h.setText("");
                this.f297157h.setBackgroundResource(0);
                this.f297157h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f160084mk3, 0, 0, 0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f297156f = this.f297155e.findViewById(R.id.f29100kq);
        this.f297157h = (TextView) this.f297155e.findViewById(R.id.f29120ks);
        this.f297158i = this.f297155e.findViewById(R.id.f242008h);
        com.tencent.mobileqq.troop.homework.config.a c16 = PublishHwkThirdPartyEntryConfigParser.c();
        if (c16 != null) {
            if (c16.E) {
                this.f297156f.setVisibility(0);
                this.f297156f.setOnClickListener(this);
                if (this.f297155e.Mh() == 1) {
                    this.f297156f.setClickable(true);
                } else {
                    this.f297156f.setVisibility(8);
                    this.P = false;
                }
            } else {
                this.f297156f.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f297155e.findViewById(R.id.f102005wq);
        this.f297159m = linearLayout;
        linearLayout.setOnClickListener(this);
        if (!this.E.booleanValue()) {
            this.f297159m.setVisibility(8);
        }
        this.C = (TextView) this.f297159m.findViewById(R.id.f1040862c);
        View findViewById = this.f297159m.findViewById(R.id.f1040562_);
        this.D = findViewById;
        findViewById.setOnClickListener(this);
        boolean l3 = l();
        this.P = l3;
        if (l3) {
            s(true);
            p(true, 1);
        } else {
            s(false);
            r(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void b(JSONArray jSONArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONArray);
            return;
        }
        if (this.E.booleanValue()) {
            Object obj = this.J;
            if (obj != null) {
                jSONArray.mo162put(obj);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "wenku");
                jSONObject.put("url", this.I);
                jSONObject.put("appid", "101458937");
                jSONObject.put(Element.ELEMENT_NAME_COURSE_NAME, this.H);
                jSONObject.put("title", this.F);
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
        return this.E.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void d(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONObject);
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("appid");
        if ("wenku".equals(optString) && optString2.equals("101458937")) {
            this.J = jSONObject;
            String optString3 = jSONObject.optString("title");
            this.I = jSONObject.optString("url");
            this.H = jSONObject.optString(Element.ELEMENT_NAME_COURSE_NAME);
            this.C.setText(optString3);
            this.f297159m.setVisibility(0);
            this.f297159m.setClickable(false);
            this.D.setVisibility(8);
            q(true);
            this.f297155e.Ci(3);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.M = z16;
        if (!z16) {
            r(false);
        } else if (this.N) {
            this.N = false;
            if (this.P) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.logic.WenKuEntranceHelper.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WenKuEntranceHelper.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        WenKuEntranceHelper wenKuEntranceHelper = WenKuEntranceHelper.this;
                        if (wenKuEntranceHelper.M) {
                            wenKuEntranceHelper.r(true);
                        }
                    }
                }, 500L);
            }
        }
        if (!this.E.booleanValue()) {
            return;
        }
        if (z16) {
            this.f297159m.setVisibility(8);
            r(false);
        } else {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.logic.WenKuEntranceHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WenKuEntranceHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        WenKuEntranceHelper.this.f297159m.setVisibility(0);
                    }
                }
            }, 20L);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.logic.a
    public void f(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (i3 != 3) {
            if (z16) {
                this.f297156f.setEnabled(false);
            } else {
                this.f297156f.setEnabled(true);
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
        if (this.E.booleanValue() && i3 == 1) {
            Bundle Oh = this.f297155e.Oh();
            String[] strArr = new String[3];
            String str = this.f297154d;
            if (str == null) {
                str = "";
            }
            strArr[0] = str;
            strArr[1] = Oh.getString("reportIdentity", "");
            strArr[2] = Oh.getString("reportCourse", "");
            eu.g("Grp_edu", "homework", "createHW_doc", 0, 0, strArr);
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
        if (i3 != 265) {
            return;
        }
        if (intent == null) {
            QLog.e("DocsEntranceHelper", 1, "onActivityResult data == null");
            return;
        }
        String stringExtra = intent.getStringExtra("params");
        if (stringExtra.isEmpty()) {
            QLog.e("DocsEntranceHelper", 1, "onActivityResult strData.isEmpty");
            return;
        }
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e16) {
            QLog.e("DocsEntranceHelper", 1, "onActivityResult exception:" + e16 + "," + stringExtra);
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.e("DocsEntranceHelper", 1, "onActivityResult argsJson == null");
            return;
        }
        this.F = jSONObject.optString("title");
        this.H = jSONObject.optString(Element.ELEMENT_NAME_COURSE_NAME);
        this.I = jSONObject.optString("url");
        this.C.setText(this.F);
        this.f297159m.setVisibility(0);
        q(true);
        this.f297155e.Ci(3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f29100kq) {
                o(view);
            } else if (id5 == R.id.f102005wq) {
                m(view);
            } else if (id5 == R.id.f1040562_) {
                n(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.E = Boolean.valueOf(z16);
        }
    }
}
