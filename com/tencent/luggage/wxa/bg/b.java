package com.tencent.luggage.wxa.bg;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.il.n;
import com.tencent.luggage.wxa.kj.n0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122604a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122605b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122606c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122607d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f122608e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f122609f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f122610g;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6057a implements p {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MMBottomSheet f122612a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f122613b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f122614c;

            public C6057a(MMBottomSheet mMBottomSheet, Map map, int i3) {
                this.f122612a = mMBottomSheet;
                this.f122613b = map;
                this.f122614c = i3;
            }

            @Override // com.tencent.luggage.wxa.mo.p
            public void a(h hVar) {
                this.f122612a.setFooterView(null);
                hVar.clear();
                for (int i3 = 0; i3 < a.this.f122609f.size(); i3++) {
                    if (this.f122613b.containsKey(Integer.valueOf(i3))) {
                        hVar.add(i3, (CharSequence) a.this.f122609f.get(i3), true, false);
                    } else {
                        hVar.add(i3, this.f122614c, (CharSequence) a.this.f122609f.get(i3));
                    }
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6058b implements u {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f122616a;

            public C6058b(Map map) {
                this.f122616a = map;
            }

            @Override // com.tencent.luggage.wxa.mo.u
            public void a(MenuItem menuItem, int i3) {
                HashMap hashMap = new HashMap();
                hashMap.put("tapIndex", Integer.valueOf(menuItem.getItemId()));
                if (this.f122616a.containsKey(Integer.valueOf(i3))) {
                    b.e();
                }
                a aVar = a.this;
                aVar.f122604a.a(aVar.f122610g, b.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements MMBottomSheet.IDismissCallBack {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122618a;

            public c(n nVar) {
                this.f122618a = nVar;
            }

            @Override // com.tencent.mm.ui.widget.dialog.MMBottomSheet.IDismissCallBack
            public void onDismiss() {
                this.f122618a.c(a.this.f122606c);
                a aVar = a.this;
                aVar.f122604a.a(aVar.f122610g, b.this.makeReturnJson("fail cancel"));
            }
        }

        public a(l lVar, v vVar, int i3, String str, JSONObject jSONObject, ArrayList arrayList, int i16) {
            this.f122604a = lVar;
            this.f122605b = vVar;
            this.f122606c = i3;
            this.f122607d = str;
            this.f122608e = jSONObject;
            this.f122609f = arrayList;
            this.f122610g = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a16;
            if (!this.f122604a.isRunning()) {
                return;
            }
            this.f122605b.m0().a(n0.ACTION_SHEET);
            Activity L = this.f122604a.L();
            n X = this.f122604a.getRuntime().X();
            MMBottomSheet a17 = X.a(this.f122606c, L);
            if (!w0.c(this.f122607d)) {
                b.a(L, a17, this.f122607d);
            }
            JSONArray optJSONArray = this.f122608e.optJSONArray("newTipsList");
            HashMap hashMap = new HashMap();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        hashMap.put(Integer.valueOf(optJSONObject.optInt("index", -1)), Integer.valueOf(optJSONObject.optInt("type", -1)));
                    }
                }
            }
            if (com.tencent.luggage.wxa.h6.l.f126905a.a(this.f122604a.getAppId())) {
                a16 = com.tencent.luggage.wxa.tk.g.a(this.f122608e.optString("itemColorDark", ""), L.getResources().getColor(R.color.c7u));
            } else {
                a16 = com.tencent.luggage.wxa.tk.g.a(this.f122608e.optString("itemColor", ""), L.getResources().getColor(R.color.c7u));
            }
            a17.setOnCreateMenuListener(new C6057a(a17, hashMap, a16));
            a17.setOnMenuSelectedListener(new C6058b(hashMap));
            a17.setOnBottomSheetDismissListener(new c(X));
            a17.tryShow();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6059b {
    }

    public static /* synthetic */ InterfaceC6059b e() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        v J = lVar.J();
        if (J == null) {
            w.f("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        int optInt = jSONObject.optInt("id", -1);
        String a16 = com.tencent.luggage.wxa.h6.d.a(jSONObject, "alertText");
        w.d("MicroMsg.JsApiShowActionSheet", "invoke, alertText: " + a16);
        String optString = jSONObject.optString(VideoTemplateParser.ITEM_LIST);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                arrayList.add((String) jSONArray.get(i16));
            }
            lVar.a(new a(lVar, J, optInt, a16, jSONObject, arrayList, i3));
        } catch (Exception e16) {
            w.b("MicroMsg.JsApiShowActionSheet", e16.getMessage());
            lVar.a(i3, makeReturnJson("fail"));
        }
    }

    public static void a(Context context, MMBottomSheet mMBottomSheet, String str) {
        w.a("MicroMsg.JsApiShowActionSheet", "addAlertHeaderView");
        TextView textView = new TextView(context);
        textView.setHeight(com.tencent.luggage.wxa.kn.a.c(context, R.dimen.biw));
        textView.setGravity(17);
        textView.setTextColor(context.getResources().getColor(R.color.bgr));
        textView.setTextSize(0, com.tencent.luggage.wxa.kn.a.d(context, R.dimen.bfo));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        int a16 = com.tencent.luggage.wxa.kn.a.a(context, 18);
        textView.setPadding(a16, 0, a16, 0);
        textView.setText(str);
        mMBottomSheet.setTitleView(textView);
    }
}
