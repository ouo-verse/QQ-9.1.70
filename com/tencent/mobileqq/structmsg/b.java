package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;

    /* renamed from: f1, reason: collision with root package name */
    private static int f290385f1;
    protected String R0;
    protected String S0;
    protected String T0;
    protected String U0;
    protected String V0;
    protected String W0;
    public String X0;
    protected String Y0;
    protected String Z0;

    /* renamed from: a1, reason: collision with root package name */
    protected String f290386a1;

    /* renamed from: b1, reason: collision with root package name */
    protected String f290387b1;

    /* renamed from: c1, reason: collision with root package name */
    protected boolean f290388c1;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f290389d1;

    /* renamed from: e1, reason: collision with root package name */
    public String f290390e1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f290391a;

        /* renamed from: b, reason: collision with root package name */
        public int f290392b;

        /* renamed from: c, reason: collision with root package name */
        public int f290393c;

        /* renamed from: d, reason: collision with root package name */
        public int f290394d;

        /* renamed from: e, reason: collision with root package name */
        public String f290395e;

        /* renamed from: f, reason: collision with root package name */
        public int f290396f;

        /* renamed from: g, reason: collision with root package name */
        public int f290397g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f290398h;

        /* renamed from: i, reason: collision with root package name */
        public String f290399i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f290400j;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f290400j = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = new a();
            aVar.f290391a = this.f290391a;
            aVar.f290392b = this.f290392b;
            aVar.f290395e = this.f290395e;
            aVar.f290394d = this.f290394d;
            aVar.f290396f = this.f290396f;
            aVar.f290397g = this.f290397g;
            aVar.f290398h = this.f290398h;
            aVar.f290400j = this.f290400j;
            return aVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f290385f1 = 12;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290388c1 = false;
        this.f290389d1 = false;
        this.f290320d = f290385f1;
    }

    public TextView A(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(B())) {
            return new StructMsgItemTitle.TitleTextView(context);
        }
        return new EllipsizingTextView(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<? extends TextView> B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TextView.class;
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        } else {
            this.f290390e1 = str;
        }
    }

    public void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.f290389d1 = z16;
        }
    }

    public void E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else if (str != null && !str.equals("")) {
            this.X0 = StringUtil.toDBC(str);
        } else {
            this.X0 = str;
        }
    }

    public void F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.S0 = str;
        }
    }

    public void G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.R0 = str;
        }
    }

    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            this.f290386a1 = str;
        }
    }

    public void I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        } else {
            this.Z0 = str;
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.f290388c1 = true;
        }
    }

    public void K(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.V0 = str;
        }
    }

    public void L(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            this.U0 = str;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        TextView A;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        if (view != null && B().isInstance(view)) {
            A = (TextView) view;
        } else {
            A = A(context);
            A.setId(v());
        }
        A.setTag(this);
        A.setSingleLine(this.f290389d1);
        if (!this.f290388c1) {
            A.setMaxLines(r());
        }
        if (this.f290389d1 || !this.f290388c1) {
            A.setEllipsize(q());
        }
        a s16 = s(context.getResources());
        if (s16 != null) {
            A.setTextColor(s16.f290391a);
            A.requestLayout();
            A.setTypeface(Typeface.DEFAULT, s16.f290392b);
            A.setTextSize(s16.f290393c);
            A.setLineSpacing(BaseAIOUtils.f((w() * 1.0f) / 2.0f, A.getResources()), 1.0f);
            if (s16.f290398h) {
                A.getPaint().setFlags(8);
            }
            if (s16.f290400j) {
                A.getPaint().setFlags(16);
            }
            boolean z16 = false;
            if (bundle != null) {
                z16 = bundle.getBoolean("pre_dialog", false);
            }
            if (z16 && !TextUtils.isEmpty(this.f290390e1)) {
                s16.f290395e = this.f290390e1;
            }
            String str = s16.f290399i;
            if (str != null && !str.equals("") && s16.f290399i.trim().equals("1")) {
                A.setText(Html.fromHtml(s16.f290395e));
            } else {
                A.setText(s16.f290395e);
            }
        } else {
            A.setText("");
        }
        return A;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.R0 = jVar.a("color");
        this.T0 = jVar.a("style");
        this.U0 = jVar.a("size");
        this.X0 = s.c(i.h(jVar), false);
        this.W0 = jVar.a(TextComponent.SpanType.HTML);
        this.Y0 = jVar.a("type");
        this.Z0 = jVar.a("maxLines");
        this.f290386a1 = jVar.a("lineSpace");
        this.f290387b1 = jVar.a(NodeProps.NUMBER_OF_LINES);
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        int i3 = this.f290320d;
        if (i3 == 1) {
            this.X0 = s.c(objectInput.readUTF(), false);
            return;
        }
        if (i3 == 2) {
            this.R0 = s.c(objectInput.readUTF(), false);
            this.T0 = s.c(objectInput.readUTF(), false);
            this.U0 = s.c(objectInput.readUTF(), false);
            this.X0 = s.c(objectInput.readUTF(), false);
            return;
        }
        if (i3 == 3) {
            this.R0 = s.c(objectInput.readUTF(), false);
            this.T0 = s.c(objectInput.readUTF(), false);
            this.U0 = s.c(objectInput.readUTF(), false);
            this.X0 = s.c(objectInput.readUTF(), false);
            this.W0 = s.c(objectInput.readUTF(), false);
            return;
        }
        if (i3 >= 4) {
            this.R0 = s.c(objectInput.readUTF(), false);
            this.T0 = s.c(objectInput.readUTF(), false);
            this.U0 = s.c(objectInput.readUTF(), false);
            this.X0 = s.c(objectInput.readUTF(), false);
            this.W0 = s.c(objectInput.readUTF(), false);
            this.Y0 = s.c(objectInput.readUTF(), false);
            if (this.f290320d >= 11) {
                this.Z0 = s.c(objectInput.readUTF(), false);
                this.f290386a1 = s.c(objectInput.readUTF(), false);
            }
            if (this.f290320d >= 12) {
                this.f290387b1 = s.c(objectInput.readUTF(), false);
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, this.f290322e);
        if (this.X0 != null) {
            if (!TextUtils.isEmpty(this.U0)) {
                xmlSerializer.attribute(null, "size", this.U0);
            }
            if (!TextUtils.isEmpty(this.R0)) {
                xmlSerializer.attribute(null, "color", this.R0);
            }
            if (!TextUtils.isEmpty(this.T0)) {
                xmlSerializer.attribute(null, "style", this.T0);
            }
            if (!TextUtils.isEmpty(this.W0)) {
                xmlSerializer.attribute(null, TextComponent.SpanType.HTML, this.W0);
            }
            if (!TextUtils.isEmpty(this.Y0)) {
                xmlSerializer.attribute(null, "type", this.Y0);
            }
            if (!TextUtils.isEmpty(this.Z0)) {
                xmlSerializer.attribute(null, "maxLines", this.Z0);
            }
            if (!TextUtils.isEmpty(this.f290386a1)) {
                xmlSerializer.attribute(null, "lineSpace", this.f290386a1);
            }
            if (!TextUtils.isEmpty(this.f290387b1)) {
                xmlSerializer.attribute(null, NodeProps.NUMBER_OF_LINES, this.f290387b1);
            }
            xmlSerializer.text(this.X0);
        }
        xmlSerializer.endTag(null, this.f290322e);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String c16;
        String c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        int i3 = this.f290320d;
        String str = "";
        if (i3 == 1) {
            String str2 = this.X0;
            if (str2 != null) {
                str = s.c(str2, false);
            }
            objectOutput.writeUTF(str);
            return;
        }
        if (i3 == 2) {
            String str3 = this.R0;
            if (str3 == null) {
                str3 = "";
            }
            objectOutput.writeUTF(str3);
            String str4 = this.T0;
            if (str4 == null) {
                str4 = "";
            }
            objectOutput.writeUTF(str4);
            String str5 = this.U0;
            if (str5 == null) {
                str5 = "";
            }
            objectOutput.writeUTF(str5);
            String str6 = this.X0;
            if (str6 != null) {
                str = s.c(str6, false);
            }
            objectOutput.writeUTF(str);
            return;
        }
        if (i3 == 3) {
            String str7 = this.R0;
            if (str7 == null) {
                str7 = "";
            }
            objectOutput.writeUTF(str7);
            String str8 = this.T0;
            if (str8 == null) {
                str8 = "";
            }
            objectOutput.writeUTF(str8);
            String str9 = this.U0;
            if (str9 == null) {
                str9 = "";
            }
            objectOutput.writeUTF(str9);
            String str10 = this.X0;
            if (str10 == null) {
                c17 = "";
            } else {
                c17 = s.c(str10, false);
            }
            objectOutput.writeUTF(c17);
            String str11 = this.W0;
            if (str11 != null) {
                str = str11;
            }
            objectOutput.writeUTF(str);
            return;
        }
        if (i3 >= 4) {
            String str12 = this.R0;
            if (str12 == null) {
                str12 = "";
            }
            objectOutput.writeUTF(str12);
            String str13 = this.T0;
            if (str13 == null) {
                str13 = "";
            }
            objectOutput.writeUTF(str13);
            String str14 = this.U0;
            if (str14 == null) {
                str14 = "";
            }
            objectOutput.writeUTF(str14);
            String str15 = this.X0;
            if (str15 == null) {
                c16 = "";
            } else {
                c16 = s.c(str15, false);
            }
            objectOutput.writeUTF(c16);
            String str16 = this.W0;
            if (str16 == null) {
                str16 = "";
            }
            objectOutput.writeUTF(str16);
            String str17 = this.Y0;
            if (str17 == null) {
                str17 = "";
            }
            objectOutput.writeUTF(str17);
            if (this.f290320d >= 11) {
                String str18 = this.Z0;
                if (str18 == null) {
                    str18 = "";
                }
                objectOutput.writeUTF(str18);
                String str19 = this.f290386a1;
                if (str19 == null) {
                    str19 = "";
                }
                objectOutput.writeUTF(str19);
            }
            if (this.f290320d >= 12) {
                String str20 = this.f290387b1;
                if (str20 != null) {
                    str = str20;
                }
                objectOutput.writeUTF(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return -1;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return -16777216;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 26;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextUtils.TruncateAt q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TextUtils.TruncateAt) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return TextUtils.TruncateAt.END;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (!TextUtils.isEmpty(this.Z0)) {
            try {
                return Integer.parseInt(this.Z0);
            } catch (Exception unused) {
                return 2;
            }
        }
        return 2;
    }

    public a s(Resources resources) {
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseColor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources);
        }
        a aVar = new a();
        try {
            if (!TextUtils.isEmpty(this.S0)) {
                aVar.f290391a = Color.parseColor(this.S0);
            } else {
                if (TextUtils.isEmpty(this.R0)) {
                    parseColor = n();
                } else {
                    parseColor = Color.parseColor(this.R0);
                }
                aVar.f290391a = parseColor;
            }
        } catch (Exception unused) {
            aVar.f290391a = n();
        }
        try {
            if (TextUtils.isEmpty(this.T0)) {
                parseInt3 = p();
            } else {
                parseInt3 = Integer.parseInt(this.T0);
            }
            aVar.f290392b = parseInt3;
        } catch (Exception unused2) {
        }
        try {
            if (TextUtils.isEmpty(this.Y0)) {
                parseInt2 = 0;
            } else {
                parseInt2 = Integer.parseInt(this.Y0);
            }
            aVar.f290394d = parseInt2;
        } catch (Exception unused3) {
            aVar.f290394d = 0;
        }
        aVar.f290398h = false;
        int i3 = aVar.f290392b;
        if (i3 < 0 || i3 >= 4) {
            if (i3 == 4) {
                aVar.f290398h = true;
            } else if (i3 == 5) {
                aVar.f290400j = true;
            }
            aVar.f290392b = p();
        }
        try {
            if (!TextUtils.isEmpty(this.V0)) {
                aVar.f290393c = Integer.parseInt(this.V0);
            } else {
                if (TextUtils.isEmpty(this.U0)) {
                    parseInt = o();
                } else {
                    parseInt = Integer.parseInt(this.U0);
                }
                aVar.f290393c = parseInt;
            }
        } catch (Exception unused4) {
        }
        if (aVar.f290393c < 1) {
            aVar.f290393c = o();
        }
        aVar.f290393c /= 2;
        if (TextUtils.isEmpty(t())) {
            return null;
        }
        aVar.f290395e = t();
        aVar.f290399i = this.W0;
        return aVar;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        String str = this.X0;
        if (str == null) {
            str = "";
        }
        this.X0 = str;
        return str;
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.R0;
    }

    protected abstract int v();

    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        if (!TextUtils.isEmpty(this.f290386a1)) {
            try {
                return Integer.parseInt(this.f290386a1);
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.U0;
    }

    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.T0;
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.Y0;
    }

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f290388c1 = false;
        this.f290389d1 = false;
        this.f290320d = f290385f1;
        this.f290322e = str2;
        this.X0 = str;
    }
}
