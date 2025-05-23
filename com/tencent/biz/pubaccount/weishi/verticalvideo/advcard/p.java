package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J4\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0007J<\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0007J$\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007JD\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0003J<\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nH\u0003\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/p;", "", "", "from", "playScene", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "g", "f", "", "ext", "i", "", "actionId", tl.h.F, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "feed", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "status", "a", "d", "c", "position", "b", "e", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f81908a = new p();

    p() {
    }

    @JvmStatic
    public static final void a(WSVerticalPageFragment fragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j feed, WSDownloadStatus status) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(status, "status");
        if (fragment == null) {
            return;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_status", String.valueOf(status.getType())), TuplesKt.to("clk_loc", "3"));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.T(fragment.getFrom(), fragment.getPlayScene(), "videotag_rich", 1000001, feed, "", true, mutableMapOf);
    }

    @JvmStatic
    private static final void b(String from, String playScene, String position, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data, int actionId, Map<String, String> ext) {
        ext.put("type", String.valueOf(data.e().video_type));
        ez.a f16 = data.f();
        Integer valueOf = f16 != null ? Integer.valueOf(f16.d()) : null;
        if (valueOf != null) {
            ext.put("rich_type", valueOf.toString());
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.t(from, playScene, position, data.e(), actionId, "", ext);
    }

    @JvmStatic
    public static final void c(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        b(from, playScene, QAdVrReport.ElementID.AD_FLOAT, data, 1000001, new LinkedHashMap());
    }

    @JvmStatic
    public static final void d(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        e(from, playScene, QAdVrReport.ElementID.AD_FLOAT, data, new LinkedHashMap());
    }

    @JvmStatic
    private static final void e(String from, String playScene, String position, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data, Map<String, String> ext) {
        ext.put("type", String.valueOf(data.e().video_type));
        ez.a f16 = data.f();
        Integer valueOf = f16 != null ? Integer.valueOf(f16.d()) : null;
        if (valueOf != null) {
            ext.put("rich_type", valueOf.toString());
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.E(from, playScene, position, data.e(), "", ext);
    }

    @JvmStatic
    public static final void f(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        b(from, playScene, "ad_video_info", data, 1000001, new LinkedHashMap());
    }

    @JvmStatic
    public static final void g(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        e(from, playScene, "ad_video_info", data, new LinkedHashMap());
    }

    @JvmStatic
    public static final void h(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data, int actionId, Map<String, String> ext) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        b(from, playScene, "download_float_btn", data, actionId, ext);
    }

    @JvmStatic
    public static final void i(String from, String playScene, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data, Map<String, String> ext) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        e(from, playScene, "download_float", data, ext);
    }
}
