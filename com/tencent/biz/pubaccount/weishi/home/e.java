package com.tencent.biz.pubaccount.weishi.home;

import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;
import vy.WSNavigationBarInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u000bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/home/e;", "", "", "b", "", "c", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "i", "", h.F, "barId", "defaultName", "d", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "lastBarId", "getCurrentBarId", DomainData.DOMAIN_NAME, "currentBarId", "I", "e", "()I", "o", "(I)V", "currentPosition", "<set-?>", "isSelectedFollow", "Z", "j", "()Z", "isSelectedImmersion", "k", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f80814a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String lastBarId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String currentBarId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int currentPosition;

    e() {
    }

    @JvmStatic
    public static final String b() {
        if (com.tencent.biz.pubaccount.weishi.push.c.b(bb.z())) {
            return "follow_tab";
        }
        if (i()) {
            return "waterfall_tab";
        }
        return c.e();
    }

    @JvmStatic
    public static final int c() {
        String b16 = b();
        if (Intrinsics.areEqual(b16, "follow_tab")) {
            return 0;
        }
        return (!Intrinsics.areEqual(b16, "monofeed_tab") && c.m()) ? 2 : 1;
    }

    @JvmStatic
    public static final int g() {
        return e00.b.b() ? 2 : 1;
    }

    @JvmStatic
    public static final boolean i() {
        WSRedDotPushMsg z16 = bb.z();
        return com.tencent.biz.pubaccount.weishi.push.c.a(z16) || com.tencent.biz.pubaccount.weishi.push.c.c(z16) || Intrinsics.areEqual(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_open_home_then_video");
    }

    @JvmStatic
    public static final boolean l() {
        return Intrinsics.areEqual(b(), "monofeed_tab");
    }

    @JvmStatic
    public static final boolean m() {
        return Intrinsics.areEqual(b(), "waterfall_tab");
    }

    public final void a() {
        c.f80807a.a();
        lastBarId = "";
        currentBarId = "";
        currentPosition = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d(String barId, String defaultName) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(barId, "barId");
        Intrinsics.checkNotNullParameter(defaultName, "defaultName");
        WSNavigationBarInfo b16 = c.f80807a.b(barId);
        String barName = b16 != null ? b16.getBarName() : null;
        if (barName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(barName);
            if (!isBlank) {
                z16 = false;
                return !z16 ? defaultName : barName;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final int e() {
        return currentPosition;
    }

    public final String f() {
        return lastBarId;
    }

    public final void h() {
        c.f80807a.i();
        currentBarId = b();
        currentPosition = c();
    }

    public final boolean j() {
        return Intrinsics.areEqual(currentBarId, "follow_tab");
    }

    public final boolean k() {
        return Intrinsics.areEqual(currentBarId, "monofeed_tab");
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        currentBarId = str;
    }

    public final void o(int i3) {
        currentPosition = i3;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        lastBarId = str;
    }
}
