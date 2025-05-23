package com.tencent.qqmini.sdk.utils;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StTemplateInfo;

/* loaded from: classes23.dex */
public class MiniProgramShareUtils {
    public static final String MINI_APP_SHARE_APPID = "miniAppShareAppid";
    public static final String MINI_APP_SHARE_APP_TYPE = "miniAppShareAppType";
    public static final String MINI_APP_SHARE_DEST_ID = "miniAppShareDestId";
    public static final String MINI_APP_SHARE_DEST_TYPE = "miniAppShareDestType";
    public static final String MINI_APP_SHARE_FROM = "miniAppShareFrom";
    public static final int MINI_APP_SHARE_FROM_DETAIL = 10;
    public static final int MINI_APP_SHARE_FROM_INNER_BUTTON = 11;
    public static final int MINI_APP_SHARE_FROM_MORE_BUTTON = 12;
    public static final String MINI_APP_SHARE_SCENE = "miniAppShareScene";
    public static final String MINI_APP_SHARE_TYPE = "miniAppShareType";

    public static MiniProgramShare$StAdaptShareInfoReq newShareInfoRequest(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5, String str6, String str7, COMM.StCommonExt stCommonExt, int i19, String str8, int i26, boolean z16, String str9, String str10, String str11, String str12, String str13) {
        MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq = new MiniProgramShare$StAdaptShareInfoReq();
        if (str != null) {
            miniProgramShare$StAdaptShareInfoReq.appid.set(str);
        }
        if (str2 != null) {
            miniProgramShare$StAdaptShareInfoReq.title.set(str2);
        }
        if (str3 != null) {
            miniProgramShare$StAdaptShareInfoReq.desc.set(str3);
        }
        miniProgramShare$StAdaptShareInfoReq.time.set(i3);
        miniProgramShare$StAdaptShareInfoReq.scene.set(i16);
        miniProgramShare$StAdaptShareInfoReq.templetType.set(i17);
        miniProgramShare$StAdaptShareInfoReq.businessType.set(i18);
        setUrl(str4, str5, str6, str7, miniProgramShare$StAdaptShareInfoReq);
        if (stCommonExt != null) {
            miniProgramShare$StAdaptShareInfoReq.extInfo.set(stCommonExt);
        }
        miniProgramShare$StAdaptShareInfoReq.verType.set(i19);
        if (str8 != null) {
            miniProgramShare$StAdaptShareInfoReq.versionId.set(str8);
        }
        miniProgramShare$StAdaptShareInfoReq.shareType.set(i26);
        miniProgramShare$StAdaptShareInfoReq.withShareTicket.set(z16 ? 1 : 0);
        if (str9 != null) {
            miniProgramShare$StAdaptShareInfoReq.webURL.set(str9);
        }
        if (str10 != null) {
            miniProgramShare$StAdaptShareInfoReq.appidRich.set(str10);
        }
        setTemplate(str11, str12, miniProgramShare$StAdaptShareInfoReq);
        if (i26 == 5 && str13 != null) {
            miniProgramShare$StAdaptShareInfoReq.rcvOpenId.set(str13);
        }
        return miniProgramShare$StAdaptShareInfoReq;
    }

    private static void setTemplate(String str, String str2, MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq) {
        if (str != null && str2 != null) {
            MiniProgramShare$StTemplateInfo miniProgramShare$StTemplateInfo = new MiniProgramShare$StTemplateInfo();
            miniProgramShare$StTemplateInfo.templateId.set(str);
            miniProgramShare$StTemplateInfo.templateData.set(str2);
            miniProgramShare$StAdaptShareInfoReq.template.set(miniProgramShare$StTemplateInfo);
        }
    }

    private static void setUrl(String str, String str2, String str3, String str4, MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq) {
        if (str != null) {
            miniProgramShare$StAdaptShareInfoReq.picUrl.set(str);
        }
        if (str2 != null) {
            miniProgramShare$StAdaptShareInfoReq.vidUrl.set(str2);
        }
        if (str3 != null) {
            miniProgramShare$StAdaptShareInfoReq.jumpUrl.set(str3);
        }
        if (str4 != null) {
            miniProgramShare$StAdaptShareInfoReq.iconUrl.set(str4);
        }
    }
}
