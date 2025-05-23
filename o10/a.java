package o10;

import com.tencent.biz.pubaccount.weishi.config.experiment.b;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0007R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lo10/a;", "", "", "k", "a", "", "i", "", "e", "", "d", "c", "", "key", "g", "", "process", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "j", "l", h.F, "f", "b", "Ljava/lang/String;", "getCurrentUin", "()Ljava/lang/String;", "setCurrentUin", "(Ljava/lang/String;)V", PanoramaConfig.KEY_CURRENT_UIN, "I", "getAtGuideShowedTime", "()I", "setAtGuideShowedTime", "(I)V", "atGuideShowedTime", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f421718a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String currentUin = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int atGuideShowedTime;

    a() {
    }

    private final void a() {
        int e16 = e();
        int d16 = ai.d("key_exp_at_guide_show_time", 0);
        x.f("WSCommentAtHelperLog", "[WSCommentAtHelper.kt][checkExpAtGuideShowTimeChanged] expAtGuideShowTime:" + e16 + ", expAtGuideShowTimeFromSp:" + d16);
        if (e16 != d16) {
            ai.m("key_exp_at_guide_show_time", e16);
            ai.m("key_at_guide_showed_time", 0);
        }
    }

    private final int c() {
        int Y = bb.Y(g("delay_play_process"), 110);
        if (Y == 100) {
            return 99;
        }
        return Y;
    }

    private final long d() {
        return bb.Z(g("delay_play_time"), 0L);
    }

    private final int e() {
        return bb.Y(g("show_time"), 0);
    }

    private final String g(String key) {
        String str;
        Map<String, String> d16 = b.h().d();
        return (d16 == null || (str = d16.get(key)) == null) ? "" : str;
    }

    private final boolean i() {
        int e16 = e();
        return e16 < 0 || atGuideShowedTime < e16;
    }

    private final void k() {
        String uin = b.h().y();
        if (Intrinsics.areEqual(currentUin, uin)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        currentUin = uin;
        a();
        int d16 = ai.d("key_at_guide_showed_time", 0);
        atGuideShowedTime = d16;
        x.f("WSCommentAtHelperLog", "[WSCommentAtHelper.kt][refreshCommentAtGuideData] atGuideShowedTime:" + d16);
    }

    public final int b() {
        return bb.Y(g("auto_dismiss_time"), -1);
    }

    public final String f() {
        return g("image");
    }

    public final boolean h() {
        return Intrinsics.areEqual("1", g(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public final boolean j(float process, long playTime) {
        if (!h()) {
            return false;
        }
        k();
        return i() && process * ((float) 100) >= ((float) c()) && playTime >= d() * ((long) 1000);
    }

    public final void l() {
        int i3 = atGuideShowedTime + 1;
        atGuideShowedTime = i3;
        ai.m("key_at_guide_showed_time", i3);
    }
}
