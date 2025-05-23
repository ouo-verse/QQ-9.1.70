package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.operator.DownloadPicOperator;
import com.tencent.mobileqq.pic.operator.ForwardPicOperator;
import com.tencent.mobileqq.pic.operator.UploadPicOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<UploadPicOperator> f258716a;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<UploadPicOperator> f258717b;

    /* renamed from: c, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<ForwardPicOperator> f258718c;

    /* renamed from: d, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<DownloadPicOperator> f258719d;

    /* renamed from: e, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<com.tencent.mobileqq.pic.operator.multipic.c> f258720e;

    /* renamed from: f, reason: collision with root package name */
    private static com.tencent.mobileqq.pic.operator.h<com.tencent.mobileqq.pic.operator.e> f258721f;

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<Integer, com.tencent.mobileqq.pic.operator.h> f258722g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258716a = new com.tencent.mobileqq.pic.operator.h<>(UploadPicOperator.class);
        f258717b = new com.tencent.mobileqq.pic.operator.h<>(com.tencent.mobileqq.pic.operator.i.class);
        f258718c = new com.tencent.mobileqq.pic.operator.h<>(ForwardPicOperator.class);
        f258719d = new com.tencent.mobileqq.pic.operator.h<>(DownloadPicOperator.class);
        f258720e = new com.tencent.mobileqq.pic.operator.h<>(com.tencent.mobileqq.pic.operator.multipic.c.class);
        f258721f = new com.tencent.mobileqq.pic.operator.h<>(com.tencent.mobileqq.pic.operator.e.class);
        f258722g = new HashMap<>();
        f258716a.b(1039, com.tencent.mobileqq.pic.operator.k.class);
        f258716a.b(1040, com.tencent.mobileqq.pic.operator.k.class);
        f258716a.b(1045, com.tencent.mobileqq.pic.operator.c.class);
        f258716a.b(1042, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1047, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1054, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1044, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1049, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1060, com.tencent.mobileqq.pic.operator.b.class);
        f258716a.b(1056, com.tencent.mobileqq.pic.operator.j.class);
        f258716a.b(1057, com.tencent.mobileqq.pic.operator.f.class);
        f258722g.put(2, f258716a);
        f258722g.put(4, f258717b);
        f258722g.put(3, f258718c);
        f258722g.put(5, f258719d);
        f258722g.put(6, f258719d);
        f258722g.put(7, f258719d);
        f258722g.put(8, f258720e);
        f258722g.put(1, f258721f);
    }

    public static CompressInfo a(int i3, Intent intent) {
        com.tencent.mobileqq.pic.operator.e eVar = (com.tencent.mobileqq.pic.operator.e) j(f258721f, i3);
        if (eVar != null) {
            return eVar.l(intent);
        }
        return null;
    }

    public static l b(int i3, Intent intent) {
        ForwardPicOperator forwardPicOperator = (ForwardPicOperator) j(f258718c, i3);
        if (forwardPicOperator != null) {
            return forwardPicOperator.y(intent);
        }
        return null;
    }

    public static l c(int i3, MessageForPic messageForPic, int i16, String str, String str2, String str3) {
        com.tencent.mobileqq.pic.operator.multipic.c cVar = (com.tencent.mobileqq.pic.operator.multipic.c) j(f258720e, i3);
        if (cVar != null) {
            return cVar.x(messageForPic, i16, str, str2, str3);
        }
        return null;
    }

    public static ArrayList<l> d(int i3, MessageRecord messageRecord, int i16, String str, String str2, String str3) {
        com.tencent.mobileqq.pic.operator.multipic.c cVar;
        if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord) && (cVar = (com.tencent.mobileqq.pic.operator.multipic.c) j(f258720e, i3)) != null) {
            return cVar.y(messageRecord, i16, str, str2, str3);
        }
        return null;
    }

    public static p e(int i3, int i16) {
        return f(i3, 0, i16);
    }

    public static p f(int i3, int i16, int i17) {
        p pVar = new p();
        pVar.f258783d = i3;
        pVar.J = i16;
        pVar.f258784e = i17;
        return pVar;
    }

    public static v g(int i3, Intent intent) {
        UploadPicOperator uploadPicOperator = (UploadPicOperator) j(f258716a, i3);
        if (uploadPicOperator != null) {
            return uploadPicOperator.B(intent);
        }
        return null;
    }

    public static AppInterface h() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static com.tencent.mobileqq.pic.operator.a i(int i3, int i16) {
        com.tencent.mobileqq.pic.operator.h hVar = f258722g.get(Integer.valueOf(i3));
        if (hVar != null) {
            return j(hVar, i16);
        }
        return null;
    }

    private static <T extends com.tencent.mobileqq.pic.operator.a> T j(com.tencent.mobileqq.pic.operator.h<T> hVar, int i3) {
        Class<? extends T> a16 = hVar.a(i3);
        if (a16 != null) {
            try {
                return a16.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th5) {
                QLog.e("PicBusiManager", 1, th5.toString());
                com.tencent.mobileqq.statistics.r.a("PIC_BUS_GET_OPERATOR", String.valueOf(i3));
                th5.printStackTrace();
            }
        }
        return null;
    }

    public static com.tencent.mobileqq.pic.operator.a k(p pVar) {
        if (pVar == null) {
            f.d("PicBusiManager", "launch", "error,req == null");
            return null;
        }
        com.tencent.mobileqq.pic.operator.a i3 = i(pVar.f258783d, pVar.f258784e);
        if (i3 == null) {
            f.d("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + pVar.f258784e);
            return null;
        }
        i3.f258751f = pVar;
        i3.f258749d = pVar.f258785f;
        i3.f258750e = pVar.f258786h;
        i3.j(pVar.G);
        f.b("PicBusiManager", "launch", "cmd:" + pVar.f258783d + ",busiType:" + pVar.f258784e + "localUUID:" + pVar.f258785f);
        i3.i();
        return i3;
    }
}
