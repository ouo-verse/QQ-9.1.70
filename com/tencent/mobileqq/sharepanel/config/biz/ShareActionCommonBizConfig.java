package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionCommonBizConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionCommonBizConfig implements a {
    static IPatchRedirector $redirector_;

    public ShareActionCommonBizConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.config.biz.a
    @NotNull
    public List<c> a() {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        List listOf5;
        List listOf6;
        List listOf7;
        List listOf8;
        List<c> listOf9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "transfertoqzone", "weixin", "weixincircle", "qqchannel", "intimatezone", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "groupalbum", "weiyun", "redbook", "mypc", "qqbrowser", "browser", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"remove_favorite", "report_abuse", "generate_link", "restart_mini_program", "view_decorations", "set_decorations", "remove_collection", "edit", "not_interested", "edit_collection", "pin_to_top", "move_post", "promote_review", "batch_manage", "recognize_qr_code", "unpin", "delete", "floating_window_playback", "set_as_qq_profile_cover", "save_to_phone", CanvasView.ACTION_TRANSLATE, "generate_share_image", "floating_window", "cancel_promote", "locate_chat", QCircleDaTongConstant.ElementParamValue.BACKGROUND_MUSIC, "long_screenshot", "extract_text", "generate_qr_code", "close_danmu", "remove_announcement", "favorite", "ai_repair", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "open_danmu", "copy_channel_number", "print", "set_background", "copy", "watch_later", "cancel_watch_later", "refresh", "set_private", "add_emote", "block_feed", "miniprogram_scan", "avatar_switch_on", "avatar_switch_off", "pin_to_homepage", "pin_to_section", "uppin_homepage", "uppin_section"});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qzoneshuoshuo", "weixin"});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"favorite", "recognize_qr_code"});
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "transfertoqzone", "weixin", "weixincircle", "qqchannel", "intimatezone", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "groupalbum", "weiyun", "redbook", "mypc", "qqbrowser", "browser", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "transfertoqzone", "weixin", "weixincircle", "qqchannel", "intimatezone", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "groupalbum", "weiyun", "redbook", "mypc", "qqbrowser", "browser", "otherapp"});
            listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"remove_favorite", "report_abuse", "generate_link", "restart_mini_program", "view_decorations", "set_decorations", "remove_collection", "edit", "not_interested", "edit_collection", "pin_to_top", "move_post", "promote_review", "batch_manage", "recognize_qr_code", "unpin", "delete", "floating_window_playback", "set_as_qq_profile_cover", "save_to_phone", CanvasView.ACTION_TRANSLATE, "generate_share_image", "floating_window", "cancel_promote", "locate_chat", QCircleDaTongConstant.ElementParamValue.BACKGROUND_MUSIC, "long_screenshot", "extract_text", "generate_qr_code", "close_danmu", "remove_announcement", "favorite", "ai_repair", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "open_danmu", "copy_channel_number", "print", "set_background", "copy", "watch_later", "cancel_watch_later", "refresh", "set_private", "add_emote", "block_feed", "miniprogram_scan", "avatar_switch_on", "avatar_switch_off", "pin_to_homepage", "pin_to_section", "uppin_homepage", "uppin_section"});
            listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"remove_favorite", "report_abuse", "generate_link"});
            listOf9 = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new c("debug1", listOf, listOf2, listOf3, listOf4), new c("debug2", listOf5, null, listOf6, null, 20, null), new c("debug3", null, listOf7, null, listOf8, 10, null)});
            return listOf9;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
