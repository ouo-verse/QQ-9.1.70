package com.tencent.mobileqq.richstatus;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends DefaultHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<a> f282370a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<l> f282371b;

    /* renamed from: c, reason: collision with root package name */
    private l f282372c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f282373d;

    /* renamed from: e, reason: collision with root package name */
    private Stack<a> f282374e;

    /* renamed from: f, reason: collision with root package name */
    private a f282375f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<a> f282376g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, Integer> f282377h;

    /* renamed from: i, reason: collision with root package name */
    private StringBuilder f282378i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f282379j;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282378i = new StringBuilder();
        this.f282379j = false;
        HashMap<String, Integer> hashMap = new HashMap<>();
        this.f282377h = hashMap;
        hashMap.put("StateList", 1);
        this.f282377h.put("SubStateList", 2);
        this.f282377h.put("RichState", 3);
        this.f282377h.put("ActionId", 4);
        this.f282377h.put("Display", 5);
        this.f282377h.put("ActionName", 6);
        this.f282377h.put("Describe", 7);
        this.f282377h.put("IconURL", 8);
        this.f282377h.put("TinyIcon", 9);
        this.f282377h.put("Type", 10);
        this.f282377h.put("Parameter", 11);
        this.f282377h.put("DataURL", 12);
        this.f282377h.put("CoverURL", 13);
        this.f282377h.put("NativeList", 14);
        this.f282377h.put("ListParam", 15);
        this.f282377h.put("NativeDetail", 16);
        this.f282377h.put("DetailParam", 17);
        this.f282377h.put("Tags", 18);
        this.f282377h.put("StateTag", 19);
        this.f282377h.put("TagName", 20);
        this.f282377h.put("IdList", 21);
        this.f282377h.put("Action_id", 22);
    }

    public SparseArray<a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SparseArray) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f282370a;
    }

    public ArrayList<l> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f282371b;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i16) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.f282379j) {
            this.f282378i.append(cArr, i3, i16);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.endDocument();
        for (int i3 = 0; i3 < this.f282371b.size(); i3++) {
            ArrayList<Integer> arrayList = this.f282371b.get(i3).f282369b;
            if (arrayList != null) {
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    a aVar = this.f282370a.get(it.next().intValue());
                    if (aVar != null && aVar.f282300g == 2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("RichStatus", 2, "filter xml name = " + aVar.f282298e);
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3);
            return;
        }
        this.f282379j = false;
        String sb5 = this.f282378i.toString();
        Integer num = this.f282377h.get(str2);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue != 20) {
            if (intValue != 22) {
                switch (intValue) {
                    case 1:
                    case 2:
                        this.f282375f = this.f282374e.pop();
                        if (this.f282376g.size() == 0) {
                            this.f282375f.f282304k = null;
                        }
                        if (this.f282374e.size() > 0) {
                            this.f282376g = this.f282374e.lastElement().f282304k;
                            return;
                        }
                        return;
                    case 3:
                        a aVar = this.f282375f;
                        int i3 = aVar.f282295b;
                        if (i3 != 0) {
                            this.f282370a.put(i3, aVar);
                            a aVar2 = this.f282375f;
                            if (aVar2.f282294a) {
                                this.f282376g.add(aVar2);
                            }
                            this.f282375f = null;
                            return;
                        }
                        return;
                    case 4:
                        try {
                            this.f282375f.f282295b = Integer.parseInt(sb5);
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.richstatus.xml", 2, e16.toString() + ", " + e16.getStackTrace().toString());
                                return;
                            }
                            return;
                        }
                    case 5:
                        this.f282375f.f282294a = Boolean.parseBoolean(sb5);
                        return;
                    case 6:
                        this.f282375f.f282299f = sb5;
                        return;
                    case 7:
                        this.f282375f.f282298e = sb5;
                        return;
                    case 8:
                        this.f282375f.f282296c = sb5;
                        return;
                    case 9:
                        this.f282375f.f282297d = sb5;
                        return;
                    case 10:
                        if ("0".equals(sb5)) {
                            this.f282375f.f282300g = 4;
                            return;
                        }
                        if ("1".equals(sb5)) {
                            this.f282375f.f282300g = 3;
                            return;
                        } else if ("2".equals(sb5)) {
                            this.f282375f.f282300g = 2;
                            return;
                        } else {
                            if ("4".equals(sb5)) {
                                this.f282375f.f282300g = 5;
                                return;
                            }
                            return;
                        }
                    case 11:
                        this.f282375f.f282301h = sb5;
                        return;
                    case 12:
                        this.f282375f.f282302i = sb5;
                        return;
                    case 13:
                        this.f282375f.f282303j = sb5;
                        return;
                    case 14:
                        this.f282375f.f282305l = sb5;
                        return;
                    case 15:
                        this.f282375f.f282306m = sb5;
                        return;
                    case 16:
                        this.f282375f.f282307n = sb5;
                        return;
                    case 17:
                        this.f282375f.f282308o = sb5;
                        return;
                    default:
                        return;
                }
            }
            this.f282373d.add(Integer.valueOf(Integer.parseInt(sb5)));
            return;
        }
        this.f282372c.f282368a = sb5;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f282370a = new SparseArray<>();
        this.f282371b = new ArrayList<>();
        this.f282372c = new l();
        this.f282374e = new Stack<>();
        a aVar = new a(-1);
        this.f282375f = aVar;
        this.f282370a.put(-1, aVar);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3, attributes);
            return;
        }
        this.f282379j = true;
        StringBuilder sb5 = this.f282378i;
        sb5.replace(0, sb5.length(), "");
        if (!"StateList".equals(str2) && !"SubStateList".equals(str2)) {
            if ("RichState".equals(str2)) {
                this.f282375f = new a(-1);
                return;
            }
            if ("StateTag".equals(str2)) {
                l lVar = new l();
                this.f282372c = lVar;
                this.f282371b.add(lVar);
                return;
            } else {
                if ("IdList".equals(str2)) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    this.f282373d = arrayList;
                    this.f282372c.f282369b = arrayList;
                    return;
                }
                return;
            }
        }
        ArrayList<a> arrayList2 = new ArrayList<>();
        this.f282376g = arrayList2;
        a aVar = this.f282375f;
        aVar.f282304k = arrayList2;
        this.f282374e.push(aVar);
    }
}
