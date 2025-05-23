package com.tencent.mobileqq.tts.data;

import android.text.TextUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class TtsNetStreamParam {
    static IPatchRedirector $redirector_ = null;
    public static final int MODEL_QPILOT = 1;
    public static final int MODEL_YOUTU = 0;
    private static final String TAG = "TtsNetStreamParam";
    public static final int VOICE_TYPE_FEMALE = 0;
    public static final int VOICE_TYPE_MALE = 1;
    private static long sReqSeq;

    @SerializedName("appid")
    public String appId;
    public Integer autoTTS;
    public int businessID;
    public String clientVersion;
    public Integer model;
    public String msgBytes;
    public int net;

    @Expose(serialize = false)
    public String sKey;
    public Long sendUin;
    public Long seq;
    public String text;
    public String textMd5;
    public Long uin;
    public String voiceType;

    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f303352a;

        /* renamed from: b, reason: collision with root package name */
        private Long f303353b;

        /* renamed from: c, reason: collision with root package name */
        private Long f303354c;

        /* renamed from: d, reason: collision with root package name */
        private String f303355d;

        /* renamed from: e, reason: collision with root package name */
        private String f303356e;

        /* renamed from: f, reason: collision with root package name */
        private String f303357f;

        /* renamed from: g, reason: collision with root package name */
        private int f303358g;

        /* renamed from: h, reason: collision with root package name */
        private int f303359h;

        /* renamed from: i, reason: collision with root package name */
        private String f303360i;

        /* renamed from: j, reason: collision with root package name */
        private Integer f303361j;

        /* renamed from: k, reason: collision with root package name */
        private String f303362k;

        /* renamed from: l, reason: collision with root package name */
        public String f303363l;

        /* renamed from: m, reason: collision with root package name */
        public Integer f303364m;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f303364m = 0;
            }
        }

        public TtsNetStreamParam a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (TtsNetStreamParam) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            TtsNetStreamParam ttsNetStreamParam = new TtsNetStreamParam();
            ttsNetStreamParam.appId = this.f303352a;
            ttsNetStreamParam.uin = this.f303353b;
            ttsNetStreamParam.sendUin = this.f303354c;
            ttsNetStreamParam.text = this.f303355d;
            ttsNetStreamParam.textMd5 = this.f303356e;
            long j3 = TtsNetStreamParam.sReqSeq;
            TtsNetStreamParam.sReqSeq = 1 + j3;
            ttsNetStreamParam.seq = Long.valueOf(j3);
            ttsNetStreamParam.clientVersion = this.f303357f;
            ttsNetStreamParam.net = this.f303358g;
            ttsNetStreamParam.businessID = this.f303359h;
            String str = this.f303360i;
            ttsNetStreamParam.sKey = str;
            ttsNetStreamParam.model = this.f303361j;
            ttsNetStreamParam.voiceType = this.f303362k;
            ttsNetStreamParam.msgBytes = this.f303363l;
            ttsNetStreamParam.autoTTS = this.f303364m;
            if (TextUtils.isEmpty(str)) {
                QLog.w(TtsNetStreamParam.TAG, 1, "[create] key is empty.");
            }
            return ttsNetStreamParam;
        }

        public a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f303352a = str;
            return this;
        }

        public a c(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) num);
            }
            this.f303364m = num;
            return this;
        }

        public a d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.f303359h = i3;
            return this;
        }

        public a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f303357f = str;
            return this;
        }

        public a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.f303360i = str;
            return this;
        }

        public a g(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) num);
            }
            this.f303361j = num;
            return this;
        }

        public a h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.f303363l = str;
            return this;
        }

        public a i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.f303358g = i3;
            return this;
        }

        public a j(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            this.f303354c = Long.valueOf(j3);
            return this;
        }

        public a k(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f303355d = str;
            return this;
        }

        public a l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f303356e = str;
            return this;
        }

        public a m(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, j3);
            }
            this.f303353b = Long.valueOf(j3);
            return this;
        }

        public a n(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            }
            this.f303362k = str;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sReqSeq = 0L;
        }
    }

    public TtsNetStreamParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.model = null;
        this.voiceType = null;
        this.autoTTS = 0;
    }
}
