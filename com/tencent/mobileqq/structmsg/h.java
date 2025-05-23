package com.tencent.mobileqq.structmsg;

import android.util.SparseArray;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout30;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.aa;
import com.tencent.mobileqq.structmsg.view.ac;
import com.tencent.mobileqq.structmsg.view.ad;
import com.tencent.mobileqq.structmsg.view.ae;
import com.tencent.mobileqq.structmsg.view.af;
import com.tencent.mobileqq.structmsg.view.ag;
import com.tencent.mobileqq.structmsg.view.ai;
import com.tencent.mobileqq.structmsg.view.ak;
import com.tencent.mobileqq.structmsg.view.al;
import com.tencent.mobileqq.structmsg.view.am;
import com.tencent.mobileqq.structmsg.view.an;
import com.tencent.mobileqq.structmsg.view.ao;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.structmsg.view.aq;
import com.tencent.mobileqq.structmsg.view.ar;
import com.tencent.mobileqq.structmsg.view.as;
import com.tencent.mobileqq.structmsg.view.at;
import com.tencent.mobileqq.structmsg.view.au;
import com.tencent.mobileqq.structmsg.view.av;
import com.tencent.mobileqq.structmsg.view.aw;
import com.tencent.mobileqq.structmsg.view.l;
import com.tencent.mobileqq.structmsg.view.m;
import com.tencent.mobileqq.structmsg.view.n;
import com.tencent.mobileqq.structmsg.view.o;
import com.tencent.mobileqq.structmsg.view.p;
import com.tencent.mobileqq.structmsg.view.q;
import com.tencent.mobileqq.structmsg.view.r;
import com.tencent.mobileqq.structmsg.view.s;
import com.tencent.mobileqq.structmsg.view.t;
import com.tencent.mobileqq.structmsg.view.u;
import com.tencent.mobileqq.structmsg.view.v;
import com.tencent.mobileqq.structmsg.view.w;
import com.tencent.mobileqq.structmsg.view.x;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Class<? extends AbsStructMsgElement>> f290424a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<Class<? extends a>> f290425b;

    /* renamed from: c, reason: collision with root package name */
    public static HashSet<String> f290426c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends AbsStructMsgElement>> hashMap = new HashMap<>();
        f290424a = hashMap;
        hashMap.put("pavideo", al.class);
        f290424a.put("video", StructMsgItemVideo.class);
        f290424a.put("picture", com.tencent.mobileqq.structmsg.view.c.class);
        f290424a.put("title", StructMsgItemTitle.class);
        f290424a.put("summary", ap.class);
        f290424a.put(SemanticAttributes.FaasTriggerValues.TIMER, as.class);
        f290424a.put("hr", com.tencent.mobileqq.structmsg.view.d.class);
        f290424a.put("image", com.tencent.mobileqq.structmsg.view.e.class);
        f290424a.put("more", ak.class);
        f290424a.put("progress", an.class);
        f290424a.put("checklist", av.class);
        f290424a.put("vote", aw.class);
        f290424a.put("price", am.class);
        f290424a.put("button", StructMsgItemButton.class);
        f290424a.put("remark", ao.class);
        f290424a.put("paaudio", StructMsgItemPAAudio.class);
        f290424a.put("textButton", ar.class);
        f290424a.put("content", com.tencent.mobileqq.structmsg.view.b.class);
        f290424a.put(ReportConstant.COSTREPORT_TRANS, at.class);
        f290424a.put("td", aq.class);
        f290424a.put("head", com.tencent.mobileqq.structmsg.view.a.class);
        f290424a.put("type", au.class);
        SparseArray<Class<? extends a>> sparseArray = new SparseArray<>();
        f290425b = sparseArray;
        sparseArray.append(0, ag.class);
        sparseArray.append(1, com.tencent.mobileqq.structmsg.view.k.class);
        sparseArray.append(2, u.class);
        sparseArray.append(3, w.class);
        sparseArray.append(4, x.class);
        sparseArray.append(5, y.class);
        sparseArray.append(6, aa.class);
        sparseArray.append(7, ac.class);
        sparseArray.append(8, ad.class);
        sparseArray.append(9, ae.class);
        sparseArray.append(10, com.tencent.mobileqq.structmsg.view.f.class);
        sparseArray.append(11, com.tencent.mobileqq.structmsg.view.g.class);
        sparseArray.append(12, com.tencent.mobileqq.structmsg.view.h.class);
        sparseArray.append(18, com.tencent.mobileqq.structmsg.view.i.class);
        sparseArray.append(19, com.tencent.mobileqq.structmsg.view.j.class);
        sparseArray.append(20, StructMsgItemLayout20.class);
        sparseArray.append(21, l.class);
        sparseArray.append(22, m.class);
        sparseArray.append(23, n.class);
        sparseArray.append(24, o.class);
        sparseArray.append(25, p.class);
        sparseArray.append(26, q.class);
        sparseArray.append(27, r.class);
        sparseArray.append(28, s.class);
        sparseArray.append(29, t.class);
        sparseArray.append(30, StructMsgItemLayout30.class);
        sparseArray.append(31, v.class);
        HashSet<String> hashSet = new HashSet<>();
        f290426c = hashSet;
        hashSet.add(ag.class.getName());
        f290426c.add(com.tencent.mobileqq.structmsg.view.k.class.getName());
        f290426c.add(u.class.getName());
        f290426c.add(w.class.getName());
        f290426c.add(x.class.getName());
        f290426c.add(y.class.getName());
        f290426c.add(aa.class.getName());
        f290426c.add(StructMsgItemLayout20.class.getName());
        f290426c.add(l.class.getName());
        f290426c.add(StructMsgItemLayout30.class.getName());
        f290426c.add(v.class.getName());
        f290426c.add(af.class.getName());
        f290426c.add(ai.class.getName());
    }

    public static AbsStructMsgElement a(String str) {
        return b(str, 0);
    }

    public static AbsStructMsgElement b(String str, int i3) {
        Class<? extends AbsStructMsgElement> cls;
        StringBuilder sb5;
        StringBuilder sb6;
        Class<? extends AbsStructMsgElement> cls2;
        Class<? extends AbsStructMsgElement> cls3 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        AbsStructMsgElement absStructMsgElement = null;
        try {
            if (!PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME.equals(str)) {
                cls2 = f290424a.get(str);
            } else {
                cls2 = f290425b.get(i3);
            }
            cls = cls2;
            if (cls != null) {
                try {
                    absStructMsgElement = (AbsStructMsgElement) cls.newInstance();
                } catch (IllegalAccessException unused) {
                    if (cls == null) {
                        if (QLog.isColorLevel()) {
                            sb6 = new StringBuilder();
                            sb6.append("Not supported element, type = ");
                            sb6.append(str);
                            sb6.append(", layout = ");
                            sb6.append(i3);
                            QLog.e("StructMsgElementFactory", 2, sb6.toString());
                        }
                    } else if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("New instance ");
                        sb5.append(cls.getSimpleName());
                        sb5.append(" failure.");
                        QLog.e("StructMsgElementFactory", 2, sb5.toString());
                    }
                    return absStructMsgElement;
                } catch (InstantiationException unused2) {
                    if (cls == null) {
                        if (QLog.isColorLevel()) {
                            sb6 = new StringBuilder();
                            sb6.append("Not supported element, type = ");
                            sb6.append(str);
                            sb6.append(", layout = ");
                            sb6.append(i3);
                            QLog.e("StructMsgElementFactory", 2, sb6.toString());
                        }
                    } else if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("New instance ");
                        sb5.append(cls.getSimpleName());
                        sb5.append(" failure.");
                        QLog.e("StructMsgElementFactory", 2, sb5.toString());
                    }
                    return absStructMsgElement;
                } catch (Throwable th5) {
                    th = th5;
                    cls3 = cls;
                    if (cls3 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("StructMsgElementFactory", 2, "Not supported element, type = " + str + ", layout = " + i3);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.e("StructMsgElementFactory", 2, "New instance " + cls3.getSimpleName() + " failure.");
                    }
                    throw th;
                }
            }
        } catch (IllegalAccessException unused3) {
            cls = null;
        } catch (InstantiationException unused4) {
            cls = null;
        } catch (Throwable th6) {
            th = th6;
        }
        if (cls == null) {
            if (QLog.isColorLevel()) {
                sb6 = new StringBuilder();
                sb6.append("Not supported element, type = ");
                sb6.append(str);
                sb6.append(", layout = ");
                sb6.append(i3);
                QLog.e("StructMsgElementFactory", 2, sb6.toString());
            }
        } else if (absStructMsgElement == null && QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("New instance ");
            sb5.append(cls.getSimpleName());
            sb5.append(" failure.");
            QLog.e("StructMsgElementFactory", 2, sb5.toString());
        }
        return absStructMsgElement;
    }

    public static a c(int i3) {
        StringBuilder sb5;
        Class<? extends a> cls = f290425b.get(i3);
        a aVar = null;
        if (cls != null) {
            try {
                aVar = cls.newInstance();
            } catch (IllegalAccessException unused) {
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                }
            } catch (InstantiationException unused2) {
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsgElementFactory", 2, "New instance " + cls.getSimpleName() + " failure.");
                }
                throw th5;
            }
        }
        if (cls == null) {
            if (QLog.isColorLevel()) {
                QLog.e("StructMsgElementFactory", 2, "Not supported element, layout = " + i3);
            }
        } else if (aVar == null && QLog.isColorLevel()) {
            sb5 = new StringBuilder();
            sb5.append("New instance ");
            sb5.append(cls.getSimpleName());
            sb5.append(" failure.");
            QLog.e("StructMsgElementFactory", 2, sb5.toString());
        }
        return aVar;
    }
}
