package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionRichMediaBizConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionRichMediaBizConfig implements a {
    static IPatchRedirector $redirector_;

    public ShareActionRichMediaBizConfig() {
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
        List listOf9;
        List listOf10;
        List listOf11;
        List listOf12;
        List listOf13;
        List listOf14;
        List listOf15;
        List listOf16;
        List<c> listOf17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "qqchannel", "groupalbum", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "edit", "locate_chat", CanvasView.ACTION_TRANSLATE, "extract_text", "miniprogram_scan"});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "qqchannel", "groupalbum", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "edit", "locate_chat", CanvasView.ACTION_TRANSLATE, "extract_text", "miniprogram_scan"});
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "qqchannel", "groupalbum", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "floating_window", "edit", "locate_chat", "miniprogram_scan"});
            listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "qqchannel", "groupalbum", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "floating_window", "edit", "locate_chat", "miniprogram_scan"});
            listOf9 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf10 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "edit", "locate_chat", CanvasView.ACTION_TRANSLATE, "extract_text", "miniprogram_scan"});
            listOf11 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf12 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "edit", "locate_chat", CanvasView.ACTION_TRANSLATE, "extract_text", "miniprogram_scan"});
            listOf13 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf14 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "floating_window", "edit", "locate_chat", "miniprogram_scan"});
            listOf15 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weiyun", MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, "otherapp"});
            listOf16 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"recognize_qr_code", "save_to_phone", "favorite", "floating_window", "edit", "locate_chat", "miniprogram_scan"});
            listOf17 = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new c("mediamessage_picture", listOf, listOf2, listOf3, listOf4), new c("mediamessage_video", listOf5, listOf6, listOf7, listOf8), new c("mediamessage_filepicture", listOf9, listOf10, listOf11, listOf12), new c("mediamessage_filevideo", listOf13, listOf14, listOf15, listOf16)});
            return listOf17;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
