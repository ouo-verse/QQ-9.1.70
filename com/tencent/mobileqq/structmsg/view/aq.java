package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aq extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    public int f290600g1;

    /* renamed from: h1, reason: collision with root package name */
    public boolean f290601h1;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f290602i1;

    /* renamed from: j1, reason: collision with root package name */
    public int f290603j1;

    /* renamed from: k1, reason: collision with root package name */
    public int f290604k1;

    /* renamed from: l1, reason: collision with root package name */
    public int f290605l1;

    public aq() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public TextView A(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TextView) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        return new TextView(context);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(-1);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) jVar)).booleanValue();
        }
        try {
            String a16 = jVar.a("weight");
            if (a16 != null) {
                i3 = Integer.parseInt(a16);
            } else {
                i3 = 0;
            }
            this.f290605l1 = i3;
            String a17 = jVar.a("align");
            if (!TextUtils.isEmpty(a17)) {
                String[] split = a17.split("\\|");
                HashMap hashMap = new HashMap();
                hashMap.put("left", 3);
                hashMap.put("right", 5);
                hashMap.put("top", 48);
                hashMap.put("bottom", 80);
                hashMap.put("center", 17);
                for (int i16 = 0; i16 < split.length; i16++) {
                    if (!TextUtils.isEmpty(split[i16])) {
                        String lowerCase = split[i16].toLowerCase();
                        if (hashMap.containsKey(lowerCase)) {
                            this.f290603j1 = ((Integer) hashMap.get(lowerCase)).intValue() | this.f290603j1;
                        }
                    }
                }
            }
        } catch (NumberFormatException unused) {
            this.f290605l1 = 1;
        }
        return super.d(jVar);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "td";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.f290605l1 = objectInput.readInt();
        this.f290603j1 = objectInput.readInt();
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, this.f290322e);
        xmlSerializer.attribute(null, "weight", String.valueOf(this.f290605l1));
        xmlSerializer.attribute(null, "align", String.valueOf(this.f290603j1));
        xmlSerializer.endTag(null, this.f290322e);
        super.k(xmlSerializer);
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        objectOutput.writeInt(this.f290605l1);
        objectOutput.writeInt(this.f290603j1);
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.f290601h1 && this.f290600g1 != 0) {
            return -1;
        }
        return -16777216;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 28;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f290604k1;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    protected int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.id.tv_summary;
    }

    public aq(String str) {
        super(str, "td");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f290600g1 = 0;
        this.f290601h1 = false;
        this.f290602i1 = true;
        this.f290603j1 = 48;
        this.f290604k1 = 1;
        this.f290605l1 = 1;
    }
}
