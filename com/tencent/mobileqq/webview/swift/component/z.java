package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class z extends b.C8976b implements com.tencent.mobileqq.webview.swift.g {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected MiniMsgUser f314522e;

    /* renamed from: f, reason: collision with root package name */
    private String f314523f;

    /* renamed from: h, reason: collision with root package name */
    private int f314524h;

    /* renamed from: i, reason: collision with root package name */
    private int f314525i;

    /* renamed from: m, reason: collision with root package name */
    private String f314526m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements MiniMsgUser.IMiniMsgActionCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
            }
        }

        public void a(String str, JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) jSONObject);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("action", str);
                jSONObject2.put("options", jSONObject);
                ((TouchWebView) z.this.f314441d.getWebView()).callJs("javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + jSONObject2.toString() + ");");
            } catch (Exception e16) {
                QLog.d("SwiftMiniAIOHandler", 1, e16, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onFromMiniAIOToAIO() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SwiftMiniAIOHandler", 2, "onFromMiniAIOToAIO ");
            }
            a("fromMiniAIOToAIO", new JSONObject());
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onGoToConversation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftMiniAIOHandler", 2, "onGoToConversation ");
                }
                a("returnMsgList", new JSONObject());
            } catch (Exception e16) {
                QLog.d("SwiftMiniAIOHandler", 1, e16, new Object[0]);
            }
        }

        @Override // com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback
        public void onOpenMiniAIOCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            z zVar = z.this;
            if (zVar.f314522e == null) {
                return;
            }
            String g16 = zVar.g();
            if (TextUtils.isEmpty(g16)) {
                g16 = zVar.f314441d.getWebView().getTitle();
            }
            if (TextUtils.isEmpty(g16) || "\u200e".equals(g16)) {
                g16 = HardCodeUtil.qqStr(R.string.f172921vk2);
            }
            Bundle bundle = new Bundle();
            bundle.putString("banner_wording", g16);
            MiniMsgUserParam param = z.this.f314522e.getParam();
            Intent b16 = com.tencent.mobileqq.webview.swift.utils.s.b(bundle, zVar.f314441d.getWebViewProvider());
            param.backConversationIntent = b16;
            com.tencent.mobileqq.webview.swift.utils.s.a(b16);
            try {
                a("entryClicked", new JSONObject());
            } catch (Exception e16) {
                QLog.d("SwiftMiniAIOHandler", 1, e16, new Object[0]);
            }
        }
    }

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private MiniMsgUser.IMiniMsgActionCallback h() {
        return new a();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.f314522e == null) {
            MiniMsgUser miniMsgUser = new MiniMsgUser(this.f314441d.getActivity(), i());
            this.f314522e = miniMsgUser;
            miniMsgUser.onForeground();
        }
    }

    public void b(boolean z16) {
        int i3;
        MiniMsgUser miniMsgUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        v vVar = (v) this.f314441d.getProvider().a(2);
        if (vVar != null && vVar.C.d() != null) {
            View d16 = vVar.C.d();
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            d16.setVisibility(i3);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d16.getLayoutParams();
            layoutParams.addRule(15, -1);
            d16.setLayoutParams(layoutParams);
            View findViewById = d16.findViewById(R.id.ews);
            String str = this.f314526m;
            if (str != null) {
                if (str.equals("white")) {
                    findViewById.setBackgroundResource(R.drawable.mini_msg_float_view_top_white);
                } else if (this.f314526m.equals("black")) {
                    findViewById.setBackgroundResource(R.drawable.mini_msg_float_view_top_black);
                }
            }
            if (z16 && (miniMsgUser = this.f314522e) != null) {
                miniMsgUser.onForeground();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.g
    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f314524h = i3;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) bundle);
            return;
        }
        if (2 == i3) {
            MiniMsgUser miniMsgUser = this.f314522e;
            if (miniMsgUser != null) {
                miniMsgUser.onForeground();
            }
        } else if (9 == i3) {
            MiniMsgUser miniMsgUser2 = this.f314522e;
            if (miniMsgUser2 != null) {
                miniMsgUser2.onBackground();
            }
            v vVar = (v) this.f314441d.getProvider().a(2);
            if (vVar != null && (swiftIphoneTitleBarUI = vVar.C) != null && swiftIphoneTitleBarUI.d() != null && vVar.C.q()) {
                MiniMsgIPCClient.getInstance().clearBusiness(this.f314524h);
            }
        }
        super.f(i3, bundle);
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f314523f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MiniMsgUserParam i() {
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MiniMsgUserParam) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = this.f314524h;
        miniMsgUserParam.accessType = 1;
        miniMsgUserParam.filterMsgType = 1;
        miniMsgUserParam.requestCode = 200;
        v vVar = (v) this.f314441d.getProvider().a(2);
        if (vVar != null && (swiftIphoneTitleBarUI = vVar.C) != null && swiftIphoneTitleBarUI.d() != null) {
            miniMsgUserParam.entryView = vVar.C.d();
            miniMsgUserParam.unreadView = (TextView) vVar.C.d().findViewById(R.id.ewt);
        }
        miniMsgUserParam.actionCallback = h();
        return miniMsgUserParam;
    }

    public void j(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.f314524h = i3;
        this.f314525i = i16;
        this.f314526m = str;
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f314523f = str;
        }
    }
}
