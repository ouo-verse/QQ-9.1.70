package com.tencent.luggage.wxa.be;

import android.content.DialogInterface;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.hn.t;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.xweb.internal.ConstValue;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.be.h f122472a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122473a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122474b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f122475c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122476d;

        public a(v vVar, int i3, t tVar, String str) {
            this.f122473a = vVar;
            this.f122474b = i3;
            this.f122475c = tVar;
            this.f122476d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.f122473a, this.f122474b, this.f122475c, this.f122476d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122478a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122479b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f122480c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f122481d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f122482e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LinkedList f122483f;

        public b(v vVar, int i3, t tVar, int i16, String str, LinkedList linkedList) {
            this.f122478a = vVar;
            this.f122479b = i3;
            this.f122480c = tVar;
            this.f122481d = i16;
            this.f122482e = str;
            this.f122483f = linkedList;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.f122478a, this.f122479b, this.f122480c, this.f122481d, this.f122482e, this.f122483f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.be.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122485a;

        public c(v vVar) {
            this.f122485a = vVar;
        }

        @Override // com.tencent.luggage.wxa.be.i
        public void a(String str) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, onLinkClick url:%s", str);
            new com.tencent.luggage.wxa.be.b().b(str).b(this.f122485a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122487a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122488b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122489c;

        public d(t tVar, v vVar, int i3) {
            this.f122487a = tVar;
            this.f122488b = vVar;
            this.f122489c = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, acceptButton");
            this.f122487a.f128707g = true;
            this.f122488b.a(this.f122489c, e.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            e.this.a(this.f122488b, this.f122487a);
            e.this.e();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.be.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6050e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122491a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122492b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122493c;

        public ViewOnClickListenerC6050e(t tVar, v vVar, int i3) {
            this.f122491a = tVar;
            this.f122492b = vVar;
            this.f122493c = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, rejectButton");
            this.f122491a.f128707g = false;
            this.f122492b.a(this.f122493c, e.this.makeReturnJson("cancel"));
            e.this.a(this.f122492b, this.f122491a);
            e.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122495a;

        public f(v vVar) {
            this.f122495a = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
            String str = this.f122495a.getContext().getString(R.string.ywz) + "" + u.a();
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + str);
            ((d0) this.f122495a.b(d0.class)).a(this.f122495a.getContext(), str, "", null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122497a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122498b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122499c;

        public g(t tVar, v vVar, int i3) {
            this.f122497a = tVar;
            this.f122498b = vVar;
            this.f122499c = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
            this.f122497a.f128707g = false;
            this.f122498b.a(this.f122499c, e.this.makeReturnJson("cancel"));
            e.this.a(this.f122498b, this.f122497a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122501a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122502b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122503c;

        public h(t tVar, v vVar, int i3) {
            this.f122501a = tVar;
            this.f122502b = vVar;
            this.f122503c = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
            this.f122501a.f128707g = true;
            this.f122502b.a(this.f122503c, e.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            e.this.a(this.f122502b, this.f122501a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements com.tencent.luggage.wxa.uo.b {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(com.tencent.luggage.wxa.hn.u uVar) {
            if (uVar == null) {
                w.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, null response");
                return null;
            }
            int i3 = uVar.f128743d.f127731d;
            if (i3 != 0) {
                w.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(i3), uVar.f128743d.f127732e);
                return null;
            }
            w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
            return null;
        }
    }

    public final void e() {
        com.tencent.luggage.wxa.be.h hVar = this.f122472a;
        if (hVar != null) {
            hVar.dismiss();
            this.f122472a = null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            vVar.a(i3, makeReturnJson("fail:data is invalid"));
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                linkedList.add(optJSONArray.optString(i16));
            }
        }
        String optString = jSONObject.optString("wording");
        int optInt = jSONObject.optInt("authStatus", 2);
        int optInt2 = jSONObject.optInt(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
        String appId = vVar.getAppId();
        w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s, clientVersion:%s", appId, Integer.valueOf(optInt2));
        w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording:%s, authStatus:%d, fieldIds:%s", optString, Integer.valueOf(optInt), optJSONArray);
        t tVar = new t();
        tVar.f128706f = linkedList;
        tVar.f128705e = appId;
        tVar.f128708h = optInt;
        tVar.f128710j = optInt2;
        if (optInt2 == 1) {
            c0.a(new a(vVar, i3, tVar, optString));
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                linkedList2.add("  " + optJSONArray2.optString(i17));
            }
        }
        if (linkedList.size() == 0) {
            w.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            vVar.a(i3, makeReturnJson("fail:fields is empty"));
        } else if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            vVar.a(i3, makeReturnJson("fail:wording is empty"));
        } else {
            if (jSONObject.optJSONArray("authGroupList") != null) {
                w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", jSONObject.optJSONArray("authGroupList").toString());
            }
            c0.a(new b(vVar, i3, tVar, optInt, optString, linkedList2));
        }
    }

    public final void a(v vVar, int i3, t tVar, String str) {
        View inflate = ((LayoutInflater) vVar.getContext().getSystemService("layout_inflater")).inflate(R.layout.dxm, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.szw);
        Button button = (Button) inflate.findViewById(R.id.szv);
        Button button2 = (Button) inflate.findViewById(R.id.szx);
        textView.setText(Html.fromHtml(str));
        a(textView);
        textView.setMovementMethod(new c(vVar));
        button.setOnClickListener(new d(tVar, vVar, i3));
        button2.setOnClickListener(new ViewOnClickListenerC6050e(tVar, vVar, i3));
        w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
        com.tencent.luggage.wxa.be.h hVar = new com.tencent.luggage.wxa.be.h(vVar.getContext());
        this.f122472a = hVar;
        hVar.setContentView(inflate);
        this.f122472a.setCancelable(false);
        this.f122472a.setCanceledOnTouchOutside(false);
        r H = vVar.getRuntime().H();
        if (H != null) {
            H.a(this.f122472a);
        }
    }

    public final void a(TextView textView) {
        SpannableString spannableString = new SpannableString(textView.getText());
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            spannableString.removeSpan(uRLSpan);
            spannableString.setSpan(new j(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        textView.setText(spannableString);
    }

    public final void a(v vVar, int i3, t tVar, int i16, String str, LinkedList linkedList) {
        String string;
        if (i16 == 2) {
            string = vVar.getContext().getString(R.string.yww);
        } else {
            string = vVar.getContext().getString(R.string.ywx);
        }
        String string2 = vVar.getContext().getString(R.string.ywy);
        String string3 = vVar.getContext().getString(R.string.ywv);
        String string4 = vVar.getContext().getString(R.string.ywu);
        LayoutInflater layoutInflater = (LayoutInflater) vVar.getContext().getSystemService("layout_inflater");
        ViewGroup viewGroup = null;
        View inflate = layoutInflater.inflate(R.layout.dxp, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.sqp);
        TextView textView2 = (TextView) inflate.findViewById(R.id.sqq);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sqr);
        textView.setText(str);
        textView2.setText(string4);
        textView2.setOnClickListener(new f(vVar));
        linearLayout.removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            linearLayout.setVisibility(0);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                TextView textView3 = (TextView) layoutInflater.inflate(R.layout.dxj, viewGroup);
                textView3.setText(str2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = vVar.getContentView().getResources().getDimensionPixelOffset(R.dimen.c1q);
                textView3.setLayoutParams(layoutParams);
                linearLayout.addView(textView3);
                viewGroup = null;
            }
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams2.leftMargin = 0;
            textView2.setLayoutParams(layoutParams2);
            linearLayout.setVisibility(8);
        }
        w.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
        new MMAlertDialog.Builder(vVar.getContext()).setTitle(string).setView(inflate).setCanBack(false).setCancelable(false).setPositiveBtnText(string2).setPositiveBtnListener(new h(tVar, vVar, i3)).setNegativeBtnText(string3).setNegativeBtnListener(new g(tVar, vVar, i3)).create().show();
    }

    public final void a(v vVar, t tVar) {
        ((com.tencent.luggage.wxa.bj.c) vVar.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", vVar.getAppId(), tVar, com.tencent.luggage.wxa.hn.u.class).b(new i());
    }
}
