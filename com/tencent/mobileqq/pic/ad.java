package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface ad {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f258597a;

        /* renamed from: b, reason: collision with root package name */
        public int f258598b;

        /* renamed from: c, reason: collision with root package name */
        public String f258599c;

        /* renamed from: d, reason: collision with root package name */
        public String f258600d;

        /* renamed from: e, reason: collision with root package name */
        public long f258601e;

        /* renamed from: f, reason: collision with root package name */
        public String f258602f;

        /* renamed from: g, reason: collision with root package name */
        public String f258603g;

        /* renamed from: h, reason: collision with root package name */
        public long f258604h;

        /* renamed from: i, reason: collision with root package name */
        public long f258605i;

        /* renamed from: j, reason: collision with root package name */
        public int f258606j;

        /* renamed from: k, reason: collision with root package name */
        public int f258607k;

        /* renamed from: l, reason: collision with root package name */
        public Object f258608l;

        /* renamed from: m, reason: collision with root package name */
        public String f258609m;

        /* renamed from: n, reason: collision with root package name */
        public byte[] f258610n;

        /* renamed from: o, reason: collision with root package name */
        public byte[] f258611o;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "SendResult{result=" + this.f258597a + ", errCode=" + this.f258598b + ", errStr='" + this.f258599c + "', path='" + this.f258600d + "', size=" + this.f258601e + ", uuid='" + this.f258602f + "', md5='" + this.f258603g + "', groupFileID=" + this.f258604h + ", thumbFileSize=" + this.f258605i + ", videoAttr=" + this.f258606j + ", videoKandianType=" + this.f258607k + '}';
        }
    }

    MessageRecord g(im_msg_body$RichText im_msg_body_richtext);

    void q(a aVar);

    void r(a aVar);
}
