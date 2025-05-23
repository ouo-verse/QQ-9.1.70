package com.tencent.mobileqq.sharepanel.config;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/a;", "", "", "actionId", "Lcom/tencent/mobileqq/sharepanel/action/a;", "a", "", "b", "Ljava/util/Map;", "appendActionMap", "", "c", "Ljava/util/List;", "appendActionList", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f287209a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, com.tencent.mobileqq.sharepanel.action.a> appendActionMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<com.tencent.mobileqq.sharepanel.action.a> appendActionList;

    static {
        List<com.tencent.mobileqq.sharepanel.action.a> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f287209a = new a();
        appendActionMap = new LinkedHashMap();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.sharepanel.action.a("remove_favorite", R.drawable.qui_collection_off_oversized, "\u53d6\u6d88\u6536\u85cf"), new com.tencent.mobileqq.sharepanel.action.a("report_abuse", R.drawable.qui_complaint_oversized, "\u4e3e\u62a5"), new com.tencent.mobileqq.sharepanel.action.a("generate_link", R.drawable.qui_link_oversized, "\u751f\u6210\u94fe\u63a5"), new com.tencent.mobileqq.sharepanel.action.a("restart_mini_program", R.drawable.qui_refresh_oversized, "\u91cd\u542f\u5c0f\u7a0b\u5e8f"), new com.tencent.mobileqq.sharepanel.action.a("view_decorations", R.drawable.qui_skin_oversized, "\u67e5\u770b\u88c5\u626e"), new com.tencent.mobileqq.sharepanel.action.a("set_decorations", R.drawable.qui_skin_setting_oversized, "\u8bbe\u7f6e\u88c5\u626e"), new com.tencent.mobileqq.sharepanel.action.a("remove_collection", R.drawable.qui_collection_remove_oversized, "\u79fb\u9664\u5408\u96c6"), new com.tencent.mobileqq.sharepanel.action.a("edit", R.drawable.qui_edit_oversized, "\u7f16\u8f91"), new com.tencent.mobileqq.sharepanel.action.a("not_interested", R.drawable.qui_heart_off_oversized, "\u4e0d\u611f\u5174\u8da3"), new com.tencent.mobileqq.sharepanel.action.a("edit_collection", R.drawable.qui_collection_edit_oversized, "\u7f16\u8f91\u5408\u96c6"), new com.tencent.mobileqq.sharepanel.action.a("pin_to_top", R.drawable.qui_set_top_oversized, "\u7f6e\u9876"), new com.tencent.mobileqq.sharepanel.action.a("move_post", R.drawable.qui_move_oversized, "\u79fb\u8d34"), new com.tencent.mobileqq.sharepanel.action.a("unpin", R.drawable.qui_set_top_off_oversized, "\u53d6\u6d88\u7f6e\u9876"), new com.tencent.mobileqq.sharepanel.action.a("promote_review", R.drawable.qui_firelike_oversized, "\u63a8\u71c3\u8bc4"), new com.tencent.mobileqq.sharepanel.action.a("batch_manage", R.drawable.qui_batch_oversized, "\u6279\u91cf\u7ba1\u7406"), new com.tencent.mobileqq.sharepanel.action.a("recognize_qr_code", R.drawable.qui_qrcode_identify_oversized, "\u8bc6\u522b\u4e8c\u7ef4\u7801"), new com.tencent.mobileqq.sharepanel.action.a("delete", R.drawable.qui_delete_oversized, "\u5220\u9664"), new com.tencent.mobileqq.sharepanel.action.a("floating_window_playback", R.drawable.qui_picture_in_picture_oversized, "\u6d6e\u7a97\u64ad\u653e"), new com.tencent.mobileqq.sharepanel.action.a("set_as_qq_profile_cover", R.drawable.qui_qqcover_oversized, "\u8bbe\u4e3aQQ\n\u8d44\u6599\u5c01\u9762"), new com.tencent.mobileqq.sharepanel.action.a("save_to_phone", R.drawable.qui_save_oversized, "\u4fdd\u5b58\u5230\u624b\u673a"), new com.tencent.mobileqq.sharepanel.action.a(CanvasView.ACTION_TRANSLATE, R.drawable.qui_translate_oversized, "\u7ffb\u8bd1"), new com.tencent.mobileqq.sharepanel.action.a("generate_share_image", R.drawable.qui_image_aio_oversized, "\u751f\u6210\u5206\u4eab\u56fe"), new com.tencent.mobileqq.sharepanel.action.a("floating_window", R.drawable.qui_picture_in_picture_oversized, "\u6d6e\u7a97"), new com.tencent.mobileqq.sharepanel.action.a("cancel_promote", R.drawable.qui_firelike_off_oversized, "\u53d6\u6d88\u63a8"), new com.tencent.mobileqq.sharepanel.action.a("locate_chat", R.drawable.qui_target_to_chat_oversized, "\u5b9a\u4f4d\u804a\u5929"), new com.tencent.mobileqq.sharepanel.action.a(QCircleDaTongConstant.ElementParamValue.BACKGROUND_MUSIC, R.drawable.qui_music_oversized, "\u80cc\u666f\u97f3\u4e50"), new com.tencent.mobileqq.sharepanel.action.a("long_screenshot", R.drawable.qui_long_screenshot_oversized, "\u622a\u957f\u56fe"), new com.tencent.mobileqq.sharepanel.action.a("extract_text", R.drawable.qui_textextract_oversized, "\u63d0\u53d6\u6587\u5b57"), new com.tencent.mobileqq.sharepanel.action.a("generate_qr_code", R.drawable.qui_qrcode_oversized, "\u751f\u6210\u4e8c\u7ef4\u7801"), new com.tencent.mobileqq.sharepanel.action.a("close_danmu", R.drawable.qui_subtitle_off_oversized, "\u5173\u95ed\u5f39\u5e55"), new com.tencent.mobileqq.sharepanel.action.a("remove_announcement", R.drawable.qui_annoucement_off_oversized, "\u79fb\u9664\u516c\u544a"), new com.tencent.mobileqq.sharepanel.action.a("favorite", R.drawable.qui_collection_oversized, "\u6536\u85cf"), new com.tencent.mobileqq.sharepanel.action.a("ai_repair", R.drawable.qui_retouch_oversized, "AI\u4fee\u590d"), new com.tencent.mobileqq.sharepanel.action.a(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, R.drawable.qui_link_oversized, "\u590d\u5236\u94fe\u63a5"), new com.tencent.mobileqq.sharepanel.action.a("open_danmu", R.drawable.qui_subtitle_on_oversized, "\u6253\u5f00\u5f39\u5e55"), new com.tencent.mobileqq.sharepanel.action.a("copy_channel_number", R.drawable.qui_copy_oversized, "\u590d\u5236\u9891\u9053\u53f7"), new com.tencent.mobileqq.sharepanel.action.a("print", R.drawable.qui_printer_oversized, "\u6253\u5370"), new com.tencent.mobileqq.sharepanel.action.a("set_background", R.drawable.qui_set_background_oversized, "\u8bbe\u7f6e\u80cc\u666f"), new com.tencent.mobileqq.sharepanel.action.a("copy", R.drawable.qui_copy_oversized, "\u590d\u5236"), new com.tencent.mobileqq.sharepanel.action.a("watch_later", R.drawable.qui_watch_later_oversized, "\u7a0d\u540e\u518d\u770b"), new com.tencent.mobileqq.sharepanel.action.a("cancel_watch_later", R.drawable.qui_cancel_watch_later_oversized, "\u53d6\u6d88\u7a0d\u540e\u770b"), new com.tencent.mobileqq.sharepanel.action.a("refresh", R.drawable.qui_refresh_oversized, "\u5237\u65b0"), new com.tencent.mobileqq.sharepanel.action.a("set_private", R.drawable.qui_lock_oversized, "\u8bbe\u7f6e\u4e3a\u79c1\u5bc6"), new com.tencent.mobileqq.sharepanel.action.a("add_emote", R.drawable.qui_emoticon_add_oversized, "\u6dfb\u52a0\u5230\u8868\u60c5"), new com.tencent.mobileqq.sharepanel.action.a("block_feed", R.drawable.qui_eye_off_oversized, "\u4e0d\u770b\u4ed6\u7684\n\u52a8\u6001"), new com.tencent.mobileqq.sharepanel.action.a("miniprogram_scan", R.drawable.qui_miniapp_oversized, "\u8bc6\u522b\u5c0f\u7a0b\n\u5e8f\u7801"), new com.tencent.mobileqq.sharepanel.action.a("avatar_switch_on", R.drawable.qui_super_qq_show_on_oversized, "\u6253\u5f00\u8d85\u7ea7\nQQ\u79c0"), new com.tencent.mobileqq.sharepanel.action.a("avatar_switch_off", R.drawable.qui_super_qq_show_off_oversized, "\u5173\u95ed\u8d85\u7ea7\nQQ\u79c0"), new com.tencent.mobileqq.sharepanel.action.a("pin_to_homepage", R.drawable.qui_set_top_oversized, "\u7f6e\u9876\u5230\u4e3b\u9875"), new com.tencent.mobileqq.sharepanel.action.a("pin_to_section", R.drawable.qui_pin_to_top_oversized, "\u7f6e\u9876\u5230\u7248\u5757"), new com.tencent.mobileqq.sharepanel.action.a("uppin_homepage", R.drawable.qui_set_top_off_oversized, "\u53d6\u6d88\u4e3b\u9875\n\u7f6e\u9876"), new com.tencent.mobileqq.sharepanel.action.a("uppin_section", R.drawable.qui_cancel_to_top_oversized, "\u53d6\u6d88\u7248\u5757\n\u7f6e\u9876"), new com.tencent.mobileqq.sharepanel.action.a("debug_admin_delete_feed", R.drawable.qui_delete_oversized, "\u767d\u540d\u5355\u6253\u51fb"), new com.tencent.mobileqq.sharepanel.action.a("debug_admin_block_user", R.drawable.qui_delete_oversized, "\u53d6\u6d88\u8d44\u683c"));
        appendActionList = mutableListOf;
        for (com.tencent.mobileqq.sharepanel.action.a aVar : mutableListOf) {
            appendActionMap.put(aVar.a(), aVar);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.action.a a(@NotNull String actionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.sharepanel.action.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionId);
        }
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        com.tencent.mobileqq.sharepanel.action.a aVar = appendActionMap.get(actionId);
        if (aVar == null) {
            return null;
        }
        return new com.tencent.mobileqq.sharepanel.action.a(aVar.a(), aVar.c(), aVar.d());
    }
}
