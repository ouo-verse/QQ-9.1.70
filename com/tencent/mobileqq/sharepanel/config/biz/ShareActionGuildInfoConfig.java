package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionGuildInfoConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionGuildInfoConfig implements a {
    static IPatchRedirector $redirector_;

    public ShareActionGuildInfoConfig() {
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
        List listOf17;
        List listOf18;
        List listOf19;
        List listOf20;
        List listOf21;
        List listOf22;
        List listOf23;
        List listOf24;
        List listOf25;
        List listOf26;
        List listOf27;
        List emptyList;
        List listOf28;
        List emptyList2;
        List listOf29;
        List listOf30;
        List<c> listOf31;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"mypc", "qqfriend", "qzoneshuoshuo", "weixin", "weixincircle"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"save_to_phone", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "generate_qr_code"});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"generate_qr_code", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "copy_channel_number"});
            listOf9 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf10 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"generate_qr_code", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "copy_channel_number"});
            listOf11 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf12 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"pin_to_homepage", "uppin_homepage", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "delete", "generate_qr_code", "copy_channel_number"});
            listOf13 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf14 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"pin_to_homepage", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf15 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf16 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf17 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf18 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf19 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf20 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf21 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf22 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf23 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo"});
            listOf24 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"uppin_homepage", "pin_to_homepage", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "delete", "generate_qr_code", "copy_channel_number"});
            listOf25 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            listOf26 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "uppin_homepage", "pin_to_homepage", "delete", "generate_qr_code", "copy_channel_number"});
            listOf27 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "weixin", "mypc"});
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            listOf28 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"weixin", "weixincircle"});
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            listOf29 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo", "redbook"});
            listOf30 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"generate_share_image", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK});
            listOf31 = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new c("pindao_qrcode", listOf, listOf2, listOf3, null, 16, null), new c("robot_card", listOf4, listOf5, listOf6, null, 16, null), new c("pindao_homepage", listOf7, listOf8, listOf9, listOf10), new c("pindao_card", listOf11, listOf12, listOf13, listOf14), new c("pindao_vedio", listOf15, listOf16, listOf17, listOf18), new c("pindao_live", listOf19, listOf20, listOf21, listOf22), new c("pindao_schedule", listOf23, listOf24, listOf25, listOf26), new c("pindao_livepush", listOf27, emptyList, listOf28, emptyList2), new c("pindao_aisearchh5", listOf29, listOf30, null, null, 24, null)});
            return listOf31;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
