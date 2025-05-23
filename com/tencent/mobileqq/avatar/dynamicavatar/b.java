package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$HeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$OneUinHeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$VideoHeadInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<a> f200065a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f200066a;

        /* renamed from: b, reason: collision with root package name */
        public int f200067b;

        /* renamed from: c, reason: collision with root package name */
        public long f200068c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<C7433b> f200069d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static a a(oidb_0x74b$OneUinHeadInfo oidb_0x74b_oneuinheadinfo) {
            if (oidb_0x74b_oneuinheadinfo == null) {
                return null;
            }
            a aVar = new a();
            if (oidb_0x74b_oneuinheadinfo.uint64_uin.has()) {
                aVar.f200066a = oidb_0x74b_oneuinheadinfo.uint64_uin.get();
            }
            if (oidb_0x74b_oneuinheadinfo.uint64_tinyid.has()) {
                aVar.f200068c = oidb_0x74b_oneuinheadinfo.uint64_tinyid.get();
            }
            aVar.f200067b = (int) (System.currentTimeMillis() / 1000);
            if (oidb_0x74b_oneuinheadinfo.rpt_msg_head_list.has()) {
                aVar.f200069d = C7433b.b(oidb_0x74b_oneuinheadinfo.rpt_msg_head_list.get());
            }
            return aVar;
        }

        public static ArrayList<a> b(List<oidb_0x74b$OneUinHeadInfo> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList<a> arrayList = new ArrayList<>();
                Iterator<oidb_0x74b$OneUinHeadInfo> it = list.iterator();
                while (it.hasNext()) {
                    a a16 = a(it.next());
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.avatar.dynamicavatar.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7433b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f200070a;

        /* renamed from: b, reason: collision with root package name */
        public int f200071b;

        /* renamed from: c, reason: collision with root package name */
        public String f200072c;

        /* renamed from: d, reason: collision with root package name */
        public int f200073d;

        /* renamed from: e, reason: collision with root package name */
        public int f200074e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<c> f200075f;

        public C7433b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static C7433b a(oidb_0x74b$HeadInfo oidb_0x74b_headinfo) {
            if (oidb_0x74b_headinfo == null) {
                return null;
            }
            C7433b c7433b = new C7433b();
            if (oidb_0x74b_headinfo.uint32_id.has()) {
                c7433b.f200070a = oidb_0x74b_headinfo.uint32_id.get();
            }
            if (oidb_0x74b_headinfo.str_photohead.has()) {
                c7433b.f200072c = oidb_0x74b_headinfo.str_photohead.get();
            }
            if (oidb_0x74b_headinfo.uint32_invalid.has()) {
                c7433b.f200071b = oidb_0x74b_headinfo.uint32_invalid.get();
            }
            if (oidb_0x74b_headinfo.uint32_timestamp.has()) {
                c7433b.f200073d = oidb_0x74b_headinfo.uint32_timestamp.get();
            }
            if (oidb_0x74b_headinfo.uint32_type.has()) {
                c7433b.f200074e = oidb_0x74b_headinfo.uint32_type.get();
            }
            if (oidb_0x74b_headinfo.rpt_videoheadlist.has()) {
                c7433b.f200075f = c.b(oidb_0x74b_headinfo.rpt_videoheadlist.get());
            }
            return c7433b;
        }

        public static ArrayList<C7433b> b(List<oidb_0x74b$HeadInfo> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList<C7433b> arrayList = new ArrayList<>();
                Iterator<oidb_0x74b$HeadInfo> it = list.iterator();
                while (it.hasNext()) {
                    C7433b a16 = a(it.next());
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f200076a;

        /* renamed from: b, reason: collision with root package name */
        public int f200077b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static c a(oidb_0x74b$VideoHeadInfo oidb_0x74b_videoheadinfo) {
            if (oidb_0x74b_videoheadinfo == null) {
                return null;
            }
            c cVar = new c();
            if (oidb_0x74b_videoheadinfo.str_url.has()) {
                cVar.f200076a = oidb_0x74b_videoheadinfo.str_url.get();
            }
            if (oidb_0x74b_videoheadinfo.uint32_video_size.has()) {
                cVar.f200077b = oidb_0x74b_videoheadinfo.uint32_video_size.get();
            }
            return cVar;
        }

        public static ArrayList<c> b(List<oidb_0x74b$VideoHeadInfo> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList<c> arrayList = new ArrayList<>();
                Iterator<oidb_0x74b$VideoHeadInfo> it = list.iterator();
                while (it.hasNext()) {
                    c a16 = a(it.next());
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
                return arrayList;
            }
            return null;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(oidb_0x74b$RspBody oidb_0x74b_rspbody) {
        if (oidb_0x74b_rspbody == null) {
            return null;
        }
        b bVar = new b();
        if (oidb_0x74b_rspbody.rpt_msg_uin_head_list.has()) {
            bVar.f200065a = a.b(oidb_0x74b_rspbody.rpt_msg_uin_head_list.get());
        }
        return bVar;
    }
}
