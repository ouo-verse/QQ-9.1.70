package com.qzone.reborn.configx;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import common.config.service.QzoneConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\t\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/configx/o;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "u", "t", "w", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", HippyTKDListViewAdapter.X, "v", "r", "j", "k", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final boolean j() {
        return f("qzone_disable_new_feeds", false);
    }

    public final boolean k() {
        return f("qzone_enable_preload_feed_pro", true);
    }

    public final String l() {
        return e("detail_page_authorization_denied_desc", QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT_CONTENT);
    }

    public final String m() {
        return e("detail_page_authorization_denied_title", QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT);
    }

    public final String n() {
        return e("detail_page_delete_desc", "\u4e0d\u5728\u610f\u8fc7\u5f80\uff0c\u624d\u80fd\u62e5\u6709\u5f7c\u6b64\u7684\u672a\u6765");
    }

    public final String o() {
        return e("detail_page_delete_title", "\u8be5\u6761\u52a8\u6001\u5df2\u88ab\u5220\u9664");
    }

    public final String p() {
        return e("detail_page_no_net_desc", "\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e");
    }

    public final String q() {
        return e("detail_page_no_net_title", "\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51");
    }

    public final String r() {
        return e("qzone_feed_pro_visitor_anonymous_avatar_url", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qzone/guest/qecommerce_qzone_guest_lncognito.png");
    }

    public final String s() {
        return e("friend_feed_empty_title", "\u5206\u4eab\u751f\u6d3b\uff0c\u7559\u4f4f\u611f\u52a8");
    }

    public final String t() {
        return e("home_page_guest_empty_title", "\u8fd9\u7247\u661f\u7a7a\uff0c\u53ea\u6709\u6d41\u661f\u5212\u8fc7");
    }

    public final String u() {
        return e("mood_list_empty_title", "\u5f00\u59cb\u8fde\u8f7d\u4f60\u7684\u751f\u6d3b");
    }

    public final String v() {
        return e("qzone_leba_entrance_text", "\u7a7a\u95f4\u52a8\u6001");
    }

    public final String w() {
        return e("home_page_host_empty_title", "\u8fd9\u7247\u661f\u7a7a\uff0c\u53ea\u6709\u6d41\u661f\u5212\u8fc7");
    }

    public final String x() {
        return e("ocr_error_toast_msg", "\u6587\u5b57\u8bc6\u522b\u5931\u8d25");
    }

    public final boolean y() {
        return f("qzone_hide_visit_num_in_feed_list", true);
    }
}
