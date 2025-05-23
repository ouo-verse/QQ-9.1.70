package com.tencent.qqnt.pluspanel.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/c;", "", "a", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static final int f360677b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f360678c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f360679d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f360680e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f360681f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f360682g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f360683h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f360684i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f360685j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f360686k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f360687l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f360688m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f360689n;

    /* renamed from: o, reason: collision with root package name */
    private static final int f360690o;

    /* renamed from: p, reason: collision with root package name */
    private static final int f360691p;

    /* renamed from: q, reason: collision with root package name */
    private static final int f360692q;

    /* renamed from: r, reason: collision with root package name */
    private static final int f360693r;

    /* renamed from: s, reason: collision with root package name */
    private static final int f360694s;

    /* renamed from: t, reason: collision with root package name */
    private static final int f360695t;

    /* renamed from: u, reason: collision with root package name */
    private static final int f360696u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f360697v;

    /* renamed from: w, reason: collision with root package name */
    private static final int f360698w;

    /* renamed from: x, reason: collision with root package name */
    private static final int f360699x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f360700y;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b1\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010)\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001a\u0010/\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/c$a;", "", "", "UIAPPID_PLUS_ENTRANCE_VOICE_CALL", "I", "v", "()I", "UIAPPID_PLUS_ENTRANCE_VIDEO_CALL", "u", "UIAPPID_PLUS_ENTRANCE_POKE", "l", "UIAPPID_PLUS_ENTRANCE_HOT_PIC", "g", "UIAPPID_PLUS_ENTRANCE_LOCATION", "i", "UIAPPID_PLUS_ENTRANCE_FILE", "e", "UIAPPID_PLUS_ENTRANCE_LISTEN_TOGETHER", h.F, "UIAPPID_PLUS_ENTRANCE_FAVORITE", "d", "UIAPPID_PLUS_ENTRANCE_MINI_APP", "j", "UIAPPID_PLUS_ENTRANCE_DOODLE", "c", "UIAPPID_PLUS_ENTRANCE_TRANSFER", "t", "UIAPPID_PLUS_ENTRANCE_BUSINESS_CARD", "b", "UIAPPID_PLUS_ENTRANCE_GIFT", "f", "UIAPPID_PLUS_ENTRANCE_TENCENT_DOCS", ReportConstant.COSTREPORT_PREFIX, "UIAPPID_PLUS_ENTRANCE_RECEIPT_MSG", DomainData.DOMAIN_NAME, "UIAPPID_PLUS_ENTRANCE_PIC", "k", "UIAPPID_PLUS_ENTRANCE_SHOOT", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "UIAPPID_PLUS_ENTRANCE_RED_PACKET", "o", "UIAPPID_PLUS_ENTRANCE_SING_TOGETHER", "r", "UIAPPID_PLUS_ENTRANCE_SHARE_SCREEN", "p", "UIAPPID_PLUS_ENTRANCE_AV_GAME", "a", "UIAPPID_PLUS_ENTRANCE_QAV_WATCH_TOGETHER", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.utils.c$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                return;
            }
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                return c.f360699x;
            }
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return c.f360688m;
            }
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return c.f360686k;
            }
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return c.f360684i;
            }
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return c.f360682g;
            }
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return c.f360689n;
            }
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return c.f360680e;
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return c.f360683h;
            }
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }

        public final int i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return c.f360681f;
            }
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return c.f360685j;
            }
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                return c.f360693r;
            }
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }

        public final int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return c.f360679d;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        public final int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
                return c.f360700y;
            }
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }

        public final int n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return c.f360692q;
            }
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }

        public final int o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                return c.f360695t;
            }
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }

        public final int p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                return c.f360698w;
            }
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }

        public final int q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                return c.f360694s;
            }
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }

        public final int r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                return c.f360696u;
            }
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }

        public final int s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return c.f360690o;
            }
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }

        public final int t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return c.f360687l;
            }
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }

        public final int u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return c.f360678c;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        public final int v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return c.f360677b;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f360677b = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_VOICE_CALL;
        f360678c = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_VIDEO_CALL;
        f360679d = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_POKE;
        f360680e = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_HOT_PIC;
        f360681f = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_LOCATION;
        f360682g = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_FILE;
        f360683h = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_LISTEN_TOGETHER;
        f360684i = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_FAVORITE;
        f360685j = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_MINI_APP;
        f360686k = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_DOODLE;
        f360687l = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_TRANSFER;
        f360688m = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_BUSINESS_CARD;
        f360689n = 130213;
        f360690o = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_TENCENT_DOCS;
        f360691p = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_CM_SHOW;
        f360692q = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_RECEIPT_MSG;
        f360693r = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_PIC;
        f360694s = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_SHOOT;
        f360695t = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_RED_PACKET;
        f360696u = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_SING_TOGETHER;
        f360697v = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_TOGETHER_HI;
        f360698w = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_SHARE_SCREEN;
        f360699x = BusinessInfoCheckUpdateItem.UIAPPID_PLUS_ENTRANCE_AV_GAME;
        f360700y = 130223;
    }
}
