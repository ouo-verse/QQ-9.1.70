package com.qzone.reborn.configx;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0002J\u0016\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/configx/h;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "B", "", "w", HippyTKDListViewAdapter.X, "", "E", UserInfo.SEX_FEMALE, "", "H", "u", "spaceIds", "G", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", ReportConstant.COSTREPORT_PREFIX, "r", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "spaceType", "v", "k", "o", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", BdhLogUtil.LogTag.Tag_Conn, "D", "", "heightRatio", "url", "j", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends d {
    public final String A() {
        return e("qzone_intimate_message_list_empty_text", "\u6682\u65f6\u8fd8\u6ca1\u6709\u6d88\u606f\uff0c\u671f\u5f85\u4f60\u4eec\u7684\u65e5\u5e38");
    }

    public final String B() {
        return e("qzone_intimate_space_privacy_status_change_jumpurl", "https://h5.qzone.qq.com/intimate-space/h5/auth?_wv=1&_wwv=8193&_bid=5588");
    }

    public final String C() {
        String e16 = e("qzone_intimate_guide_page_url", "https://h5.qzone.qq.com/intimate-space/h5/hello?_wv=1&_wwv=8193");
        return w() ? j(0.85f, e16) : e16;
    }

    public final String D() {
        String e16 = e("qzone_intimate_launch_create_page_url", "https://ti.qq.com/hybrid-h5/intimate/launch_v3?_wv=67108867&_nav_txtclr=000000&_wvSb=0&origin=intimate");
        return w() ? j(0.7f, e16) : e16;
    }

    public final int E() {
        return b("qzone_intimate_space_upload_album_select_media_max_count", 100);
    }

    public final boolean F() {
        return QZoneIntimateEntranceManager.m();
    }

    public final void G(String spaceIds) {
        Intrinsics.checkNotNullParameter(spaceIds, "spaceIds");
        com.qzone.reborn.util.i.b().r("qzone_intimate_expose_syn_bar", spaceIds);
    }

    public final void H() {
        com.qzone.reborn.util.i.b().l("qzone_intimate_space_show_message_tab", true);
    }

    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return QzoneConfig.MAIN_KEY_INTIMATE_SPACE;
    }

    public final String j(float heightRatio, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String e16 = e(QzoneConfig.SECONDARY_KEY_HALF_SCREEN_WEB_FILTER_DEVICE, "");
        if (TextUtils.isEmpty(e16)) {
            return com.tencent.mobileqq.webview.util.f.f314875a.b(heightRatio, url);
        }
        return com.tencent.mobileqq.webview.util.f.f314875a.d(heightRatio, url, e16);
    }

    public final boolean k() {
        return b("qzone_intimate_enable_feed_out_entrance", 0) == 1;
    }

    public final boolean l() {
        return b("qzone_intimate_enable_qzone_album_tab", 0) == 1;
    }

    public final String m() {
        return e("qzone_intimate_space_album_list_guest_empty_text", "\u671f\u5f85\u4ed6\u4eec\u7559\u4e0b\u7f8e\u597d\u56de\u5fc6");
    }

    public final String n() {
        return e("qzone_intimate_space_album_list_owner_empty_text", "\u6253\u9020\u4e13\u5c5e\u76f8\u518c\uff0c\u7559\u4f4f\u96be\u5fd8\u65f6\u523b");
    }

    public final boolean o() {
        return f("qzone_intimate_del_media_file_default_check_state", true);
    }

    public final int p() {
        return b("qzone_intimate_space_album_sync_get_max_album_count", 10);
    }

    public final int q() {
        return b("qzone_intimate_space_album_sync_get_max_medias_count", 1000);
    }

    public final int r() {
        return b("qzone_intimate_album_sync_refresh_times", 3);
    }

    public final long s() {
        return c("qzone_intimate_album_sync_success_refresh_time", 3000L);
    }

    public final String t() {
        return e("qzone_intimate_space_album_sync_tip_text", "\u53ea\u80fd\u540c\u6b65\u5f20\u6570\u5c11\u4e8e1000\u5f20\u7684\u76f8\u518c\uff0c\u6700\u591a\u540c\u6b6510\u4e2a\u76f8\u518c\u3002");
    }

    public final String u() {
        String j3 = com.qzone.reborn.util.i.b().j("qzone_intimate_expose_syn_bar", "");
        Intrinsics.checkNotNullExpressionValue(j3, "g().getString(QZONE_INTIMATE_EXPOSE_SYNC_BAR, \"\")");
        return j3;
    }

    public final String v(int spaceType) {
        mk.d dVar = mk.d.f416875a;
        if (dVar.y(Integer.valueOf(spaceType))) {
            return e("QZONE_INTIMATE_SPACE_PUBLISH_MOOD_EDIT_TEXT_HINT_LOVER", "\u8bb0\u5f55\u4e0b\u4f60\u4eec\u7684\u604b\u7231\u65e5\u5e38");
        }
        if (dVar.w(Integer.valueOf(spaceType))) {
            return e("QZONE_INTIMATE_SPACE_PUBLISH_MOOD_EDIT_TEXT_HINT_FRATER", "\u8bb0\u5f55\u4e0b\u4f60\u4eec\u7684\u57fa\u53cb\u65e5\u5e38");
        }
        if (dVar.H(Integer.valueOf(spaceType))) {
            return e("QZONE_INTIMATE_SPACE_PUBLISH_MOOD_EDIT_TEXT_HINT_SOROR", "\u8bb0\u5f55\u4e0b\u4f60\u4eec\u7684\u95fa\u871c\u65e5\u5e38");
        }
        if (dVar.t(Integer.valueOf(spaceType))) {
            return e("QZONE_INTIMATE_SPACE_PUBLISH_MOOD_EDIT_TEXT_HINT_BESTFRIEND", "\u8bb0\u5f55\u4e0b\u4f60\u4eec\u7684\u6b7b\u515a\u65e5\u5e38");
        }
        return e("QZONE_INTIMATE_SPACE_PUBLISH_MOOD_EDIT_TEXT_HINT", "\u8bb0\u5f55\u4e0b\u4f60\u4eec\u7684\u5bc6\u53cb\u65f6\u523b...");
    }

    public final boolean w() {
        return f("qzone_intimate_enable_half_screen_web", true);
    }

    public final String x() {
        return e("qzone_intimate_feed_like_list_url", "https://h5.qzone.qq.com/intimate-space/h5/feed-like-list?_wv=2&_bid=5588");
    }

    public final String y() {
        return e("qzone_intimate_guidepop_background_url", "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/publicity/lover-space-publicity.png");
    }

    public final String z() {
        return e("qzone_intimate_guidepop_text", "\u5168\u65b0\u604b\u4eba\u7a7a\u95f4\u4e0a\u7ebf\u5566");
    }
}
