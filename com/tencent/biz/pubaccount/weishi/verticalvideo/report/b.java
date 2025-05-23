package com.tencent.biz.pubaccount.weishi.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J6\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/report/b;", "", "", "from", "playScene", "LUserGrowth/stSimpleMetaFeed;", "feed", "", "extMap", "", "a", "Lj10/a;", "param", "c", "d", "speed", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f82285a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(String from, String playScene, stSimpleMetaFeed feed, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(feed, "feed");
        c.E(from, playScene, "presslong_speed_guide", feed, "", extMap);
    }

    @JvmStatic
    public static final void b(j10.a param, String speed) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(speed, "speed");
        Map<String, String> map = param.f409071i;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("float_type", String.valueOf(param.f409074l));
        map.put("speed", speed);
        if (!TextUtils.isEmpty(param.f409068f)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, param.f409068f);
        }
        WSPublicAccReport.getInstance().reportSpeedItemClick(param.f409067e, param.f409063a, map);
    }

    @JvmStatic
    public static final void c(j10.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, String> map = param.f409071i;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("float_type", String.valueOf(param.f409074l));
        if (!TextUtils.isEmpty(param.f409068f)) {
            map.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, param.f409068f);
        }
        WSPublicAccReport.getInstance().reportSpeedExposure(param.f409067e, param.f409063a, map);
    }

    @JvmStatic
    public static final void d(String from, String playScene, stSimpleMetaFeed feed, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        c.E(from, playScene, "video_speed_duration", feed, "", extMap);
    }
}
