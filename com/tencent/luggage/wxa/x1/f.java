package com.tencent.luggage.wxa.x1;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.a1;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.s;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.luggage.wxa.xd.a {
    static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.x1.d f144492a = new com.tencent.luggage.wxa.x1.d();

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.x1.b f144493b = new com.tencent.luggage.wxa.x1.b();

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.x1.c f144494c = new com.tencent.luggage.wxa.x1.c();

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.x1.h f144495d = new com.tencent.luggage.wxa.x1.h();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements TextView.OnEditorActionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144496a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f144497b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f144498c;

        public a(WAGamePanelInputEditText wAGamePanelInputEditText, l lVar, boolean z16) {
            this.f144496a = wAGamePanelInputEditText;
            this.f144497b = lVar;
            this.f144498c = z16;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            f.this.f144494c.a(this.f144496a.getEditableText().toString(), this.f144497b);
            if (this.f144498c) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f144500a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144501b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144502c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f144503d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f144504e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vl.c f144505f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.x1.a f144506g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f144507h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f144508i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f144509j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f144510k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f144511l;

        public b(l lVar, String str, int i3, boolean z16, boolean z17, com.tencent.luggage.wxa.vl.c cVar, com.tencent.luggage.wxa.x1.a aVar, boolean z18, boolean z19, boolean z26, boolean z27, int i16) {
            this.f144500a = lVar;
            this.f144501b = str;
            this.f144502c = i3;
            this.f144503d = z16;
            this.f144504e = z17;
            this.f144505f = cVar;
            this.f144506g = aVar;
            this.f144507h = z18;
            this.f144508i = z19;
            this.f144509j = z26;
            this.f144510k = z27;
            this.f144511l = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(this.f144500a, this.f144501b, this.f144502c, this.f144503d, this.f144504e, this.f144505f, this.f144506g, this.f144507h, this.f144508i, this.f144509j, this.f144510k, this.f144511l);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f2.a f144513a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144514b;

        public c(com.tencent.luggage.wxa.f2.a aVar, WAGamePanelInputEditText wAGamePanelInputEditText) {
            this.f144513a = aVar;
            this.f144514b = wAGamePanelInputEditText;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (com.tencent.luggage.wxa.qc.b.DESTROYED == bVar && this.f144513a.getAttachedEditText() == this.f144514b) {
                this.f144513a.j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends s.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144516a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f144517b;

        public d(WAGamePanelInputEditText wAGamePanelInputEditText, l lVar) {
            this.f144516a = wAGamePanelInputEditText;
            this.f144517b = lVar;
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void a(String str) {
            f.this.f144492a.a(this.f144516a.getEditableText().toString(), this.f144517b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e extends MMTextWatcherAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f144519a;

        public e(l lVar) {
            this.f144519a = lVar;
        }

        @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a1.b(editable)) {
                return;
            }
            f.this.f144492a.a(editable.toString(), this.f144519a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x1.f$f, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6897f implements com.tencent.luggage.wxa.sl.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144521a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f144522b;

        public C6897f(WAGamePanelInputEditText wAGamePanelInputEditText, l lVar) {
            this.f144521a = wAGamePanelInputEditText;
            this.f144522b = lVar;
        }

        @Override // com.tencent.luggage.wxa.sl.b
        public void a() {
            f.this.f144492a.a(this.f144521a.getEditableText().toString(), this.f144522b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144524a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f144525b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f144526c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f2.a f144527d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c.InterfaceC6640c f144528e;

        public g(WAGamePanelInputEditText wAGamePanelInputEditText, l lVar, boolean z16, com.tencent.luggage.wxa.f2.a aVar, c.InterfaceC6640c interfaceC6640c) {
            this.f144524a = wAGamePanelInputEditText;
            this.f144525b = lVar;
            this.f144526c = z16;
            this.f144527d = aVar;
            this.f144528e = interfaceC6640c;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.f144494c.a(this.f144524a.getEditableText().toString(), this.f144525b);
            f.this.f144492a.a(this.f144524a.getEditableText().toString(), this.f144525b);
            if (!this.f144526c) {
                try {
                    this.f144527d.j();
                    this.f144525b.getRuntime().c0().b(this.f144528e);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements f0.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144530a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f144531b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f2.a f144532c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f144533d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f144534e;

        public h(WAGamePanelInputEditText wAGamePanelInputEditText, l lVar, com.tencent.luggage.wxa.f2.a aVar, float f16, int i3) {
            this.f144530a = wAGamePanelInputEditText;
            this.f144531b = lVar;
            this.f144532c = aVar;
            this.f144533d = f16;
            this.f144534e = i3;
        }

        @Override // com.tencent.luggage.wxa.ol.f0.m
        public void a(int i3) {
            if (2 == i3) {
                f.this.f144493b.a(this.f144530a.getEditableText().toString(), this.f144531b);
                c0 c0Var = new c0();
                l lVar = this.f144531b;
                c0Var.a(0, lVar, lVar.J());
                return;
            }
            int height = this.f144532c.getHeight();
            w.d("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged state(%d),inputPanelHeight(%d),density(%f).", Integer.valueOf(i3), Integer.valueOf(height), Float.valueOf(this.f144533d));
            HashMap hashMap = new HashMap(1);
            hashMap.put("height", Float.valueOf(height / this.f144533d));
            this.f144531b.a(this.f144534e, f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            c0 c0Var2 = new c0();
            l lVar2 = this.f144531b;
            c0Var2.a(height, lVar2, lVar2.J());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements f0.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WAGamePanelInputEditText f144536a;

        public i(WAGamePanelInputEditText wAGamePanelInputEditText) {
            this.f144536a = wAGamePanelInputEditText;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements com.tencent.luggage.wxa.ul.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f144538a;

        public j(l lVar) {
            this.f144538a = lVar;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString(RemoteHandleConst.PARAM_DEFAULT_VALUE);
        int optInt = jSONObject.optInt("maxLength", 140);
        if (optInt <= 0) {
            optInt = Integer.MAX_VALUE;
        }
        int i16 = optInt;
        boolean optBoolean = jSONObject.optBoolean("multiple", false);
        boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
        com.tencent.luggage.wxa.vl.c a16 = com.tencent.luggage.wxa.vl.c.a(jSONObject.optString("confirmType"));
        com.tencent.luggage.wxa.x1.a a17 = com.tencent.luggage.wxa.x1.a.a(jSONObject.optString("keyboardType"));
        boolean optBoolean3 = jSONObject.optBoolean("showStoreEmoticon", false);
        boolean optBoolean4 = jSONObject.optBoolean("showStoreEmoticonPlus", false);
        boolean optBoolean5 = jSONObject.optBoolean("showEmoticonFirst", false);
        String optString2 = jSONObject.optString("keyboardAppearance", "default");
        w.d("MicroMsg.WAGameJsApiShowKeyboard", "defaultValue :%s,finalMaxLength(%d),multiple(%b),confirmHold(%b),showStoreEmoticon(%b),showEmoticonFirst(%b),keyboardAppearance(%s),showStoreEmoticonPlus(%b).", optString, Integer.valueOf(i16), Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Boolean.valueOf(optBoolean3), Boolean.valueOf(optBoolean5), optString2, Boolean.valueOf(optBoolean4));
        lVar.a(new b(lVar, optString, i16, optBoolean, optBoolean2, a16, a17, optBoolean3, optBoolean4, optBoolean5, optString2.equalsIgnoreCase(MiniAppConst.MENU_STYLE_DARK), i3));
    }

    public final void a(l lVar, String str, int i3, boolean z16, boolean z17, com.tencent.luggage.wxa.vl.c cVar, com.tencent.luggage.wxa.x1.a aVar, boolean z18, boolean z19, boolean z26, boolean z27, int i16) {
        v J;
        if (!lVar.isRunning() || (J = lVar.J()) == null) {
            return;
        }
        float a16 = com.tencent.luggage.wxa.kn.a.a(J.getContext());
        View contentView = J.getContentView();
        Objects.requireNonNull(contentView);
        com.tencent.luggage.wxa.f2.a a17 = com.tencent.luggage.wxa.f2.a.a(contentView, z27);
        a17.setCanSmileyInput(com.tencent.luggage.wxa.x1.a.EMOJI == aVar);
        a17.d(z18);
        a17.b(z19);
        WAGamePanelInputEditText attachedEditText = a17.getAttachedEditText();
        c cVar2 = new c(a17, attachedEditText);
        lVar.getRuntime().c0().a(cVar2);
        attachedEditText.setSingleLine(!z16);
        attachedEditText.setMaxLength(i3);
        s.a(attachedEditText).b(i3).a(false).a(a.EnumC6654a.MODE_CHINESE_AS_1).a(new d(attachedEditText, lVar));
        if (!w0.c(str)) {
            attachedEditText.setText(str.length() > i3 ? str.substring(0, i3) : str);
            attachedEditText.setSelection(attachedEditText.getText().length());
        } else {
            attachedEditText.setText("");
        }
        attachedEditText.addTextChangedListener(new e(lVar));
        attachedEditText.setComposingDismissedListener(new C6897f(attachedEditText, lVar));
        a17.setOnConfirmClickListener(new g(attachedEditText, lVar, z17, a17, cVar2));
        a17.setOnVisibilityChangedListener(new h(attachedEditText, lVar, a17, a16, i16));
        a17.setOnSmileyChosenListener(new i(attachedEditText));
        a17.setOnEmoticonOperationListener(new j(lVar));
        if (!z16) {
            attachedEditText.setOnEditorActionListener(new a(attachedEditText, lVar, z17));
        } else {
            attachedEditText.setOnEditorActionListener(null);
        }
        a17.a(cVar, aVar, lVar.getRuntime().L(), lVar.D().getOrientationHandler().a(), z16);
        if (z26) {
            a17.r();
        }
    }
}
