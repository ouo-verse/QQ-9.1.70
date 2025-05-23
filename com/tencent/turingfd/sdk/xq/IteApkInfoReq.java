package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class IteApkInfoReq extends Norma {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f382845a;

        /* renamed from: b, reason: collision with root package name */
        public String f382846b;

        /* renamed from: c, reason: collision with root package name */
        public long f382847c;

        /* renamed from: d, reason: collision with root package name */
        public String f382848d;

        /* renamed from: e, reason: collision with root package name */
        public String f382849e;

        /* renamed from: f, reason: collision with root package name */
        public String f382850f;

        /* renamed from: g, reason: collision with root package name */
        public String f382851g;

        /* renamed from: h, reason: collision with root package name */
        public int f382852h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList<String> f382853i;

        /* renamed from: j, reason: collision with root package name */
        public String f382854j;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<String> f382855k;

        /* renamed from: l, reason: collision with root package name */
        public ArrayList<String> f382856l;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f382845a = "";
            this.f382846b = "";
            this.f382847c = 0L;
            this.f382848d = "";
            this.f382849e = "";
            this.f382850f = "";
            this.f382851g = "";
            this.f382852h = 0;
            this.f382854j = "";
        }

        public final Builder apkFrom(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            this.f382852h = i3;
            return this;
        }

        public IteApkInfoReq build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (IteApkInfoReq) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return new IteApkInfoReq(this);
        }

        public final Builder certMd5(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f382846b = str;
            return this;
        }

        public final Builder chatContent(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) arrayList);
            }
            this.f382853i = arrayList;
            return this;
        }

        public final Builder chattingQQ(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
            }
            this.f382855k = arrayList;
            return this;
        }

        public final Builder chattingRoomQQ(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            }
            this.f382856l = arrayList;
            return this;
        }

        public final Builder fileFieleId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f382848d = str;
            return this;
        }

        public final Builder fileMd5(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.f382850f = str;
            return this;
        }

        public final Builder fileName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.f382851g = str;
            return this;
        }

        public final Builder fileSha1(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            this.f382849e = str;
            return this;
        }

        public final Builder fileSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            this.f382847c = j3;
            return this;
        }

        public final Builder localQQ(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f382854j = str;
            return this;
        }

        public final Builder pkgName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f382845a = str;
            return this;
        }
    }

    public IteApkInfoReq(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.f382930a = builder.f382845a;
        this.f382931b = builder.f382846b;
        this.f382932c = builder.f382847c;
        this.f382933d = builder.f382848d;
        this.f382934e = builder.f382849e;
        this.f382935f = builder.f382850f;
        this.f382936g = builder.f382851g;
        this.f382937h = builder.f382852h;
        this.f382938i = builder.f382853i;
        this.f382939j = builder.f382854j;
        this.f382940k = builder.f382855k;
        this.f382941l = builder.f382856l;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
