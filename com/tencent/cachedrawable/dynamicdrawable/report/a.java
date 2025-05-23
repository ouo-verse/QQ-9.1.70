package com.tencent.cachedrawable.dynamicdrawable.report;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/report/a;", "", "", "a", "d", "e", "c", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/report/a$a;", "Lcom/tencent/cachedrawable/dynamicdrawable/report/a$a;", "getFrameReportData", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f99050a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static C1007a getFrameReportData;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\"\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001e\u0010\rR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010!\u001a\u0004\b\u000f\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0013\u0010\"\"\u0004\b&\u0010$R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/report/a$a;", "", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "a", "", UserInfo.SEX_FEMALE, "g", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(F)V", "getFrameNum", "b", "d", DomainData.DOMAIN_NAME, "getBusinessCacheDataNum", "c", h.F, "r", "getLruDataNum", "j", ReportConstant.COSTREPORT_PREFIX, "getWeakDataNum", "e", "f", "p", "getFileDataNum", "o", "getDecoderDataNum", "", "I", "()I", "setFrameLruCacheMaxSize", "(I)V", "frameLruCacheMaxSize", "setFrameLruCacheSize", "frameLruCacheSize", "", "i", "J", "()J", "setGetLruDataNumPercent", "(J)V", "getLruDataNumPercent", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1007a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float getFrameNum;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float getBusinessCacheDataNum;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float getLruDataNum;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float getWeakDataNum;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float getFileDataNum;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float getDecoderDataNum;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int frameLruCacheMaxSize;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int frameLruCacheSize;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long getLruDataNumPercent;

        public C1007a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final void l() {
            boolean z16;
            float f16 = this.getFrameNum;
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheDataReporter", Intrinsics.stringPlus("getFrameNum : ", Float.valueOf(f16)));
                return;
            }
            c cVar = c.f98952a;
            this.frameLruCacheMaxSize = cVar.g();
            this.frameLruCacheSize = cVar.h();
            this.getLruDataNumPercent = (this.getLruDataNum / this.getFrameNum) * 10000;
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.a("CacheDataReporter", k());
            com.tencent.cachedrawable.dynamicdrawable.business.report.a.f98865a.a(this);
        }

        private final void m() {
            this.getFrameNum = 0.0f;
            this.getBusinessCacheDataNum = 0.0f;
            this.getLruDataNum = 0.0f;
            this.getWeakDataNum = 0.0f;
            this.getFileDataNum = 0.0f;
            this.getDecoderDataNum = 0.0f;
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this);
            } else if (this.getFrameNum >= 100000.0f) {
                l();
                m();
            }
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.frameLruCacheMaxSize;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return this.frameLruCacheSize;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.getBusinessCacheDataNum;
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.getDecoderDataNum;
        }

        public final float f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
            }
            return this.getFileDataNum;
        }

        public final float g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.getFrameNum;
        }

        public final float h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.getLruDataNum;
        }

        public final long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
            }
            return this.getLruDataNumPercent;
        }

        public final float j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.getWeakDataNum;
        }

        @NotNull
        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            int i3 = this.frameLruCacheSize;
            int i16 = this.frameLruCacheMaxSize;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFrameNum : ");
            sb5.append(this.getFrameNum);
            sb5.append(" getBusinessCacheDataNum : ");
            sb5.append(this.getBusinessCacheDataNum / this.getFrameNum);
            sb5.append(" getLruDataNum : ");
            sb5.append(this.getLruDataNum / this.getFrameNum);
            sb5.append(" getWeakDataNum : ");
            sb5.append(this.getWeakDataNum / this.getFrameNum);
            sb5.append(" getFileDataNum : ");
            sb5.append(this.getFileDataNum / this.getFrameNum);
            sb5.append(" getDecoderDataNum : ");
            sb5.append(this.getDecoderDataNum / this.getFrameNum);
            sb5.append(" LruCache size: ");
            int i17 = i3 / 1024;
            sb5.append(i17 / 1024);
            sb5.append(" M ");
            sb5.append(i17 % 1024);
            sb5.append(" K ");
            sb5.append(i3 % 1024);
            sb5.append("  maxSize : ");
            int i18 = i16 / 1024;
            sb5.append(i18 / 1024);
            sb5.append(" M ");
            sb5.append(i18 % 1024);
            sb5.append(" K ");
            sb5.append(i16 % 1024);
            sb5.append(TokenParser.SP);
            return sb5.toString();
        }

        public final void n(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.getBusinessCacheDataNum = f16;
            }
        }

        public final void o(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.getDecoderDataNum = f16;
            }
        }

        public final void p(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            } else {
                this.getFileDataNum = f16;
            }
        }

        public final void q(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                this.getFrameNum = f16;
            }
        }

        public final void r(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            } else {
                this.getLruDataNum = f16;
            }
        }

        public final void s(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            } else {
                this.getWeakDataNum = f16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f99050a = new a();
            getFrameReportData = new C1007a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (getFrameReportData) {
            C1007a c1007a = getFrameReportData;
            c1007a.q(c1007a.g() + 1.0f);
            C1007a c1007a2 = getFrameReportData;
            c1007a2.n(c1007a2.d() + 1.0f);
            getFrameReportData.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        synchronized (getFrameReportData) {
            C1007a c1007a = getFrameReportData;
            c1007a.q(c1007a.g() + 1.0f);
            C1007a c1007a2 = getFrameReportData;
            c1007a2.o(c1007a2.e() + 1.0f);
            getFrameReportData.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (getFrameReportData) {
            C1007a c1007a = getFrameReportData;
            c1007a.q(c1007a.g() + 1.0f);
            C1007a c1007a2 = getFrameReportData;
            c1007a2.p(c1007a2.f() + 1.0f);
            getFrameReportData.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (getFrameReportData) {
            C1007a c1007a = getFrameReportData;
            c1007a.q(c1007a.g() + 1.0f);
            C1007a c1007a2 = getFrameReportData;
            c1007a2.r(c1007a2.h() + 1.0f);
            getFrameReportData.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (getFrameReportData) {
            C1007a c1007a = getFrameReportData;
            c1007a.q(c1007a.g() + 1.0f);
            C1007a c1007a2 = getFrameReportData;
            c1007a2.s(c1007a2.j() + 1.0f);
            getFrameReportData.a();
            Unit unit = Unit.INSTANCE;
        }
    }
}
