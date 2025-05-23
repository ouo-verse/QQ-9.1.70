package com.tencent.mobileqq.guild.feed.util;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedPublishQualityEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ak {
    public static void a(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        bl.c().b(new GuildFeedPublishQualityEvent(qCirclePublishQualityDataBuilder), true);
    }

    public static void b() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_PICKER_CANCEL").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void c() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_DISCARD_EDIT_SEL_NO_DISCARD").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void d() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_SAVE_DRAFT_SEL_CANCEL").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void e(GuildFeedPublishInitBean guildFeedPublishInitBean) {
        String str;
        if (guildFeedPublishInitBean.isEditPublish()) {
            str = "key_detailedit";
        } else if (guildFeedPublishInitBean.isEditDraft()) {
            str = "sendboxedit";
        } else {
            str = "newpublish";
        }
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_PUBLIC_ENTER").setTraceId(GuildUploadHelper.i().h()).setExt1(str));
    }

    public static void f(Map<String, LocalMediaInfo> map) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, LocalMediaInfo> entry : map.entrySet()) {
            entry.getKey();
            LocalMediaInfo value = entry.getValue();
            if (AlbumUtil.isImage(value)) {
                sb5.append("p");
                sb5.append("-");
            } else if (AlbumUtil.isVideo(value)) {
                sb5.append("v");
                sb5.append("-");
            }
        }
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_PICKER_EXIT_NORMAL").setTraceId(GuildUploadHelper.i().h()).setExt1(sb5.substring(0, sb5.length() - 1)).setExt2(String.valueOf(map.size())).setExt4(sb5.substring(0, sb5.length() - 1)));
    }

    public static void g() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_LOAD_DRAFT_SEL_NO_LOAD").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void h() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_SAVE_DRAFT_SEL_NO_SAVE_EXIT").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void i() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_LOAD_DRAFT_SHOW").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void j() {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_SAVE_DRAFT_SHOW").setTraceId(GuildUploadHelper.i().h()));
    }

    public static void k(String str, String str2) {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_POST_NOTIFY_CHANGE").setTraceId(GuildUploadHelper.i().h()).setExt1(str).setExt2(str2));
    }

    public static void l(String str) {
        a(new QCirclePublishQualityDataBuilder().setKeyEventId("CH_E_MEDIA_DELETE").setTraceId(GuildUploadHelper.i().h()).setExt1(str));
    }

    public static void m(boolean z16) {
        String str;
        if (z16) {
            str = "CH_E_POST_REDO";
        } else {
            str = "CH_E_POST_UNDO";
        }
        a(new QCirclePublishQualityDataBuilder().setKeyEventId(str).setTraceId(GuildUploadHelper.i().h()));
    }
}
