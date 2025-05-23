package com.tencent.mobileqq.app;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IFavEmoticonUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso$EmojiItem;
import tencent.im.cs.faceroam_sso.faceroam_sso$PlatInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso$ReqBody;
import tencent.im.cs.faceroam_sso.faceroam_sso$ReqDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso$ReqUserInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso$RspBody;
import tencent.im.cs.faceroam_sso.faceroam_sso$RspDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso$RspUserInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$ModifyReq;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$ModifyRsp;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$OcrInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$PicInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$ReqBody;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr$RspBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove$PlatInfo;
import tencent.im.oidb.cmd0xdcf.EmotionMove$ReqBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FavEmoRoamingHandler extends CustomEmoRoamingBaseHandler<CustomEmotionData> implements com.tencent.mobileqq.emosm.r {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f194632e;

    /* renamed from: f, reason: collision with root package name */
    private static int f194633f;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f194634d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f194632e = FavEmoRoamingHandler.class.getName();
        }
    }

    protected FavEmoRoamingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f194634d = com.tencent.mobileqq.config.business.l.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<faceroam_sso$EmojiItem> K2(faceroam_sso$RspUserInfo faceroam_sso_rspuserinfo) {
        if (faceroam_sso_rspuserinfo.emoji_items.get() != null && !faceroam_sso_rspuserinfo.emoji_items.get().isEmpty()) {
            return faceroam_sso_rspuserinfo.emoji_items.get();
        }
        if (faceroam_sso_rspuserinfo.filename.get() != null && !faceroam_sso_rspuserinfo.filename.get().isEmpty()) {
            return Q2(faceroam_sso_rspuserinfo);
        }
        return faceroam_sso_rspuserinfo.emoji_items.get();
    }

    private void L2(Object obj) {
        if (obj != null) {
            EmotionMove$RspBody emotionMove$RspBody = new EmotionMove$RspBody();
            try {
                emotionMove$RspBody.mergeFrom((byte[]) obj);
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE fail ret = " + emotionMove$RspBody.ret + " ,errorMsg = " + emotionMove$RspBody.errmsg);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove ends, errInfo:" + e16.getMessage());
            } catch (Exception e17) {
                QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove exception : " + e17.getMessage());
            } catch (OutOfMemoryError unused) {
                QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove oom");
            }
        }
    }

    private List<faceroam_sso$EmojiItem> Q2(faceroam_sso$RspUserInfo faceroam_sso_rspuserinfo) {
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return new ArrayList();
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        ArrayList arrayList = new ArrayList();
        List<String> list = faceroam_sso_rspuserinfo.filename.get();
        List<Integer> list2 = faceroam_sso_rspuserinfo.uint32_emoji_type.get();
        String str = faceroam_sso_rspuserinfo.bid.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3);
            if (!TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.emosm.favroaming.m mVar = new com.tencent.mobileqq.emosm.favroaming.m(str2);
                if (mVar.a() && !TextUtils.isEmpty(mVar.f204355c) && !TextUtils.isEmpty(mVar.f204356d)) {
                    faceroam_sso$EmojiItem faceroam_sso_emojiitem = new faceroam_sso$EmojiItem();
                    faceroam_sso_emojiitem.file_id.set(str2);
                    faceroam_sso_emojiitem.md5.set(mVar.f204356d);
                    faceroam_sso_emojiitem.download_url.set(FavEmoConstant.getFavRoamingUrl(str2, str, currentAccountUin));
                    if (list2 != null && i3 < list2.size()) {
                        faceroam_sso_emojiitem.file_type.set(list2.get(i3).intValue());
                    }
                    if (TextUtils.isDigitsOnly(mVar.f204355c)) {
                        faceroam_sso_emojiitem.flag.set(Integer.parseInt(mVar.f204355c));
                    }
                    if (TextUtils.isDigitsOnly(mVar.f204357e)) {
                        faceroam_sso_emojiitem.pkg_id.set(Integer.parseInt(mVar.f204357e));
                    }
                    faceroam_sso_emojiitem.pic_id.set(mVar.f204358f);
                    arrayList.add(faceroam_sso_emojiitem);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(List<String> list, List<faceroam_sso$EmojiItem> list2) {
        if (list2 != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list2.size(); i3++) {
                String str = list2.get(i3).file_id.get();
                if (!TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.emosm.favroaming.m mVar = new com.tencent.mobileqq.emosm.favroaming.m(str);
                    if (mVar.a() && !TextUtils.isEmpty(mVar.f204355c) && !TextUtils.isEmpty(mVar.f204356d)) {
                        arrayList.add(mVar);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + str);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < list.size(); i16++) {
                String str2 = list.get(i16);
                if (!TextUtils.isEmpty(str2)) {
                    com.tencent.mobileqq.emosm.favroaming.m mVar2 = new com.tencent.mobileqq.emosm.favroaming.m(str2);
                    if (mVar2.a() && !TextUtils.isEmpty(mVar2.f204355c) && !TextUtils.isEmpty(mVar2.f204356d)) {
                        arrayList2.add(mVar2);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + str2);
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder("");
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                com.tencent.mobileqq.emosm.favroaming.m mVar3 = (com.tencent.mobileqq.emosm.favroaming.m) arrayList.get(i17);
                for (int i18 = 0; i18 < arrayList2.size(); i18++) {
                    com.tencent.mobileqq.emosm.favroaming.m mVar4 = (com.tencent.mobileqq.emosm.favroaming.m) arrayList2.get(i18);
                    if (mVar3.f204355c.equals(mVar4.f204355c) && mVar4.f204355c.equals("0") && mVar4.f204356d.equals(mVar3.f204356d)) {
                        list.remove(mVar4.f204353a);
                        sb5.append(mVar4.f204353a);
                        sb5.append(", ");
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavEmoRoamingHandler", 2, "delList=" + list.size() + ", roamingList=" + list2.size() + ", del resIds:" + ((Object) sb5));
            }
        }
    }

    private void S2(int i3, List<FavEmotionOcr$OcrInfo> list, IFavroamingDBManagerService iFavroamingDBManagerService, List<CustomEmotionData> list2) {
        boolean z16;
        String str;
        String str2;
        if (list != null && list.size() > 0) {
            boolean z17 = false;
            for (int i16 = 0; i16 < list.size(); i16++) {
                FavEmotionOcr$OcrInfo favEmotionOcr$OcrInfo = list.get(i16);
                FavEmotionOcr$PicInfo favEmotionOcr$PicInfo = favEmotionOcr$OcrInfo.pic_info;
                String str3 = favEmotionOcr$PicInfo.string_pic_fileid.get();
                if (i3 == 3 && QLog.isDevelopLevel()) {
                    QLog.d("FavEmoRoamingHandler", 4, "handleOcrUpload words=", favEmotionOcr$OcrInfo.string_pic_ocr.get(), " md5=", favEmotionOcr$PicInfo.string_pic_md5.get(), " self_decs=", favEmotionOcr$OcrInfo.string_self_desc.get(), " resid=" + str3);
                }
                CustomEmotionData customEmotionDataBYResId = iFavroamingDBManagerService.getCustomEmotionDataBYResId(list2, str3);
                if (customEmotionDataBYResId != null) {
                    if (favEmotionOcr$OcrInfo.string_pic_ocr.get() != null && ((str2 = customEmotionDataBYResId.ocrWord) == null || !str2.equals(favEmotionOcr$OcrInfo.string_pic_ocr.get()))) {
                        customEmotionDataBYResId.ocrWord = favEmotionOcr$OcrInfo.string_pic_ocr.get();
                        if (QLog.isDevelopLevel()) {
                            QLog.d("FavEmoRoamingHandler", 4, "handleOcrUpload old ocrWord=" + customEmotionDataBYResId.ocrWord + " new ocrWord=" + favEmotionOcr$OcrInfo.string_pic_ocr.get());
                        }
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (favEmotionOcr$OcrInfo.string_self_desc.get() != null && ((str = customEmotionDataBYResId.modifyWord) == null || !str.equals(favEmotionOcr$OcrInfo.string_self_desc.get()))) {
                        customEmotionDataBYResId.modifyWord = favEmotionOcr$OcrInfo.string_self_desc.get();
                        if (QLog.isDevelopLevel()) {
                            QLog.d("FavEmoRoamingHandler", 4, "handleOcrUpload old modifyWord=" + customEmotionDataBYResId.modifyWord + " new modifyWord=" + favEmotionOcr$OcrInfo.string_self_desc.get());
                        }
                        z16 = true;
                    }
                    if (z16) {
                        iFavroamingDBManagerService.updateCustomEmotion(customEmotionDataBYResId);
                        QLog.i("FavEmoRoamingHandler", 1, "updateOcrEmo  updateEmo:" + customEmotionDataBYResId);
                        z17 = true;
                    }
                }
            }
            if (z17) {
                StickerRecManagerImpl.get(this.app).updateKeywordForFavEmotion();
            }
        }
    }

    public void H2(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.emosm.favroaming.m mVar = new com.tencent.mobileqq.emosm.favroaming.m(it.next());
                if (!TextUtils.isEmpty(mVar.f204356d)) {
                    arrayList.add(mVar.f204356d);
                }
            }
            if (arrayList.size() > 0) {
                ((IVipComicMqqManagerService) this.app.getRuntimeService(IVipComicMqqManagerService.class, "")).delComicEmoticonList(arrayList);
            }
        }
    }

    public void I2(List<CustomEmotionData> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list, i3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        FavEmotionOcr$ReqBody favEmotionOcr$ReqBody = new FavEmotionOcr$ReqBody();
        for (int i16 = 0; i16 < list.size(); i16++) {
            CustomEmotionData customEmotionData = list.get(i16);
            if (!customEmotionData.isMarkFace) {
                FavEmotionOcr$PicInfo favEmotionOcr$PicInfo = new FavEmotionOcr$PicInfo();
                favEmotionOcr$PicInfo.string_pic_md5.set(customEmotionData.md5);
                favEmotionOcr$PicInfo.string_pic_fileid.set(customEmotionData.resid);
                arrayList.add(favEmotionOcr$PicInfo);
            }
        }
        if (arrayList.size() == 0) {
            QLog.d("FavEmoRoamingHandler", 1, "favEmoGetOcrs size=0");
            return;
        }
        try {
            favEmotionOcr$ReqBody.uint32_src_term.set(3);
            favEmotionOcr$ReqBody.list_pic_info.set(arrayList);
            favEmotionOcr$ReqBody.uint32_cmd_type.set(i3);
            favEmotionOcr$ReqBody.string_version.set(AppSetting.f99551k);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(FavEmoConstant.CMD_FAV_OCR, 36910, 1, favEmotionOcr$ReqBody.toByteArray());
            if (i3 == 1) {
                makeOIDBPkg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 3);
            } else if (i3 == 2) {
                makeOIDBPkg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 4);
            }
            super.sendPbReq(makeOIDBPkg);
            QLog.i("FavEmoRoamingHandler", 1, "send request CMD_FAV_OCR, cmdType:" + i3);
        } catch (Exception e16) {
            QLog.e("FavEmoRoamingHandler", 2, "favEmoGetOcrs error =" + e16.toString() + " cmdtype=" + i3 + " size=" + list.size());
            if (QLog.isColorLevel()) {
                for (int i17 = 0; i17 < list.size(); i17++) {
                    QLog.d("FavEmoRoamingHandler", 2, "favEmoGetOcrs data i=" + i17 + " :=" + list.get(i17));
                }
            }
        }
    }

    public void J2(CustomEmotionData customEmotionData, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) customEmotionData, (Object) str);
            return;
        }
        if (customEmotionData == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FavEmoRoamingHandler", 2, "favEmoModifyOcr data = null");
                return;
            }
            return;
        }
        AppInterface appInterface = this.app;
        if (appInterface != null && appInterface.getApp() != null) {
            if (!NetworkUtil.isNetworkAvailable()) {
                notifyUI(3, false, this.app.getApp().getString(R.string.f209215et));
                return;
            }
            try {
                FavEmotionOcr$ReqBody favEmotionOcr$ReqBody = new FavEmotionOcr$ReqBody();
                favEmotionOcr$ReqBody.uint32_src_term.set(3);
                favEmotionOcr$ReqBody.uint32_cmd_type.set(3);
                favEmotionOcr$ReqBody.string_version.set(AppSetting.f99551k);
                FavEmotionOcr$ModifyReq favEmotionOcr$ModifyReq = new FavEmotionOcr$ModifyReq();
                FavEmotionOcr$PicInfo favEmotionOcr$PicInfo = new FavEmotionOcr$PicInfo();
                favEmotionOcr$PicInfo.string_pic_md5.set(customEmotionData.md5);
                favEmotionOcr$PicInfo.string_pic_fileid.set(customEmotionData.resid);
                favEmotionOcr$ModifyReq.pic_info.set(favEmotionOcr$PicInfo);
                favEmotionOcr$ModifyReq.string_self_desc_new.set(str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(favEmotionOcr$ModifyReq);
                favEmotionOcr$ReqBody.list_modify_req.set(arrayList);
                ToServiceMsg makeOIDBPkg = makeOIDBPkg(FavEmoConstant.CMD_FAV_OCR, 36910, 1, favEmotionOcr$ReqBody.toByteArray());
                makeOIDBPkg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 5);
                makeOIDBPkg.extraData.putString("fav_modify_word", str);
                makeOIDBPkg.extraData.putInt("fav_modify_emoid", customEmotionData.emoId);
                super.sendPbReq(makeOIDBPkg);
                return;
            } catch (Exception e16) {
                QLog.e("FavEmoRoamingHandler", 1, "favEmoModifyOcr e=" + e16 + " modifyWord=" + str + " CustomEmotionData=" + customEmotionData.toString());
                return;
            }
        }
        QLog.e("FavEmoRoamingHandler", 1, "favEmoModifyOcr ocr fail, app is null");
        notifyUI(3, false, BaseApplication.getContext().getString(R.string.f209005e9));
    }

    public void M2(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, fromServiceMsg, toServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                int i3 = toServiceMsg.extraData.getInt("fav_modify_emoid", -1);
                String string = toServiceMsg.extraData.getString("fav_modify_word");
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify pkg.uint32_result=" + mergeFrom.uint32_result.get());
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (z17) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("param_succ_flag", str);
                hashMap.put("param_version", Build.VERSION.SDK_INT + "");
                hashMap.put("param_resultCode", mergeFrom.uint32_result.get() + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "favEmoModifyOcrsSuc", false, 0L, 0L, hashMap, null);
                if (z17 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    FavEmotionOcr$RspBody favEmotionOcr$RspBody = new FavEmotionOcr$RspBody();
                    favEmotionOcr$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (favEmotionOcr$RspBody.int32_result.get() == 0) {
                        List<FavEmotionOcr$ModifyRsp> list = favEmotionOcr$RspBody.list_modify_rsp.get();
                        for (int i16 = 0; i16 < list.size(); i16++) {
                            if (QLog.isColorLevel()) {
                                QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify resModify.get(i).uint32_result=" + list.get(i16).int32_result.get());
                            }
                            if (list.get(i16).int32_result.get() == 0) {
                                List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.app.getRuntimeService(IFavroamingDBManagerService.class, "")).getEmoticonDataList();
                                if (emoticonDataList != null) {
                                    Iterator<CustomEmotionData> it = emoticonDataList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            CustomEmotionData next = it.next();
                                            if (i3 == next.emoId) {
                                                next.modifyWord = string;
                                                notifyUI(3, true, next);
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                notifyUI(3, false, this.app.getApplication().getString(R.string.f209015e_));
                                if (QLog.isColorLevel()) {
                                    QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify ret = " + list.get(i16).int32_result.get());
                                }
                            }
                        }
                        return;
                    }
                    notifyUI(3, false, this.app.getApplication().getString(R.string.f209005e9));
                    if (QLog.isColorLevel()) {
                        QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify ret = " + favEmotionOcr$RspBody.int32_result.get());
                        return;
                    }
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                notifyUI(3, false, this.app.getApplication().getString(R.string.f209005e9));
                QLog.e("FavEmoRoamingHandler", 1, "func handleOcrModify ends, errInfo:" + e16.getMessage());
                return;
            } catch (OutOfMemoryError unused) {
                notifyUI(3, false, this.app.getApplication().getString(R.string.f209005e9));
                QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify oom");
                return;
            }
        }
        notifyUI(3, false, this.app.getApplication().getString(R.string.f209005e9));
        QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify error");
    }

    public void N2(FromServiceMsg fromServiceMsg, Object obj, int i3) {
        boolean z16;
        String str;
        List<FavEmotionOcr$OcrInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, fromServiceMsg, obj, Integer.valueOf(i3));
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("FavEmoRoamingHandler", 1, "handleOcrUpload  isSuccess:" + z16);
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom.uint32_result.get() == 0) {
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 1, "handleOcrUpload pkg.uint32_result=" + mergeFrom.uint32_result.get());
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (z17) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("param_succ_flag", str);
                hashMap.put("param_cmd_type", i3 + "");
                hashMap.put("param_version", Build.VERSION.SDK_INT + "");
                hashMap.put("param_resultCode", mergeFrom.uint32_result.get() + "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "favEmoGetOcrSuc", false, 0L, 0L, hashMap, null);
                if (z17 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    FavEmotionOcr$RspBody favEmotionOcr$RspBody = new FavEmotionOcr$RspBody();
                    favEmotionOcr$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (favEmotionOcr$RspBody.list_ocr_info.has()) {
                        list = favEmotionOcr$RspBody.list_ocr_info.get();
                    } else {
                        list = null;
                    }
                    IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.app.getRuntimeService(IFavroamingDBManagerService.class, "");
                    S2(i3, list, iFavroamingDBManagerService, iFavroamingDBManagerService.getEmoticonDataList());
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("FavEmoRoamingHandler", 1, "func handleOcrUpload ends, errInfo:" + e16.getMessage());
                return;
            } catch (OutOfMemoryError unused) {
                QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload oom");
                return;
            }
        }
        QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload ");
    }

    public void O2(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj);
            return;
        }
        QLog.i("FavEmoRoamingHandler", 1, "handleUserInfoGet");
        faceroam_sso$RspBody faceroam_sso_rspbody = new faceroam_sso$RspBody();
        try {
            faceroam_sso_rspbody.mergeFrom((byte[]) obj);
            faceroam_sso$RspUserInfo faceroam_sso_rspuserinfo = faceroam_sso_rspbody.rspcmd_0x01.get();
            long j3 = faceroam_sso_rspbody.ret.get();
            if (j3 != 0) {
                QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet ret = " + j3);
                return;
            }
            ThreadManagerV2.excute(new Runnable(faceroam_sso_rspuserinfo, j3) { // from class: com.tencent.mobileqq.app.FavEmoRoamingHandler.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ faceroam_sso$RspUserInfo f194635d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f194636e;

                {
                    this.f194635d = faceroam_sso_rspuserinfo;
                    this.f194636e = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FavEmoRoamingHandler.this, faceroam_sso_rspuserinfo, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int size;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        FileUtils.createFileIfNotExits(AppConstants.SDCARD_IMG_FAVORITE + ".nomedia");
                        List<faceroam_sso$EmojiItem> K2 = FavEmoRoamingHandler.this.K2(this.f194635d);
                        List<String> list = this.f194635d.delete_file.get();
                        int i3 = this.f194635d.max_roam_size.get();
                        FavEmoConstant.FAV_LOCAL_MAX_COUNT = i3;
                        String currentAccountUin = FavEmoRoamingHandler.this.app.getCurrentAccountUin();
                        if (!TextUtils.isEmpty(currentAccountUin)) {
                            BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt(FavEmoConstant.SP_MAX_FROM_SERVER + currentAccountUin, i3).apply();
                        }
                        if (K2 != null) {
                            int size2 = K2.size();
                            QLog.i("FavEmoRoamingHandler", 1, "handleUserInfoGet serverSize:" + size2);
                            int i16 = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                            if (size2 > i16) {
                                i16 = size2;
                            }
                            FavEmoConstant.FAV_ROAMING_MAX_COUNT = i16;
                            if (FavEmoRoamingHandler.f194633f <= 0) {
                                ReportController.o(FavEmoRoamingHandler.this.app, "dc00898", "", "", "0X800C503", "0X800C503", 0, 0, String.valueOf(size2), "", "", "");
                                FavEmoRoamingHandler.f194633f = size2;
                            }
                        } else {
                            FavEmoConstant.FAV_ROAMING_MAX_COUNT = FavEmoConstant.FAV_LOCAL_MAX_COUNT;
                        }
                        if (QLog.isColorLevel()) {
                            int i17 = -1;
                            if (K2 == null) {
                                size = -1;
                            } else {
                                size = K2.size();
                            }
                            if (list != null) {
                                i17 = list.size();
                            }
                            QLog.d("FavEmoRoamingHandler", 2, "local max size:" + FavEmoConstant.FAV_LOCAL_MAX_COUNT + ",server max size:" + FavEmoConstant.FAV_ROAMING_MAX_COUNT + ",delListSize=" + i17 + ",fileListSize=" + size);
                        }
                        if (QLog.isColorLevel() && K2 != null && list != null) {
                            QLog.d("FavEmoRoamingHandler", 2, "ret = " + this.f194636e + " userlist= " + K2 + " delList=" + list + " local_max =" + i3);
                        }
                        FavEmoRoamingHandler.this.R2(list, K2);
                        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) FavEmoRoamingHandler.this.app.getRuntimeService(IFavroamingDBManagerService.class, "");
                        iFavroamingDBManagerService.notifyFavRoamingUpdate();
                        List<CustomEmotionData> updateFavEmotionsInLocalEx = iFavroamingDBManagerService.updateFavEmotionsInLocalEx(list, K2);
                        if (updateFavEmotionsInLocalEx == null) {
                            updateFavEmotionsInLocalEx = new ArrayList<>();
                        }
                        FavEmoRoamingHandler.this.notifyUI(1, true, updateFavEmotionsInLocalEx);
                        EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", 1);
                    } catch (Exception e16) {
                        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet error", e16);
                    } catch (OutOfMemoryError unused) {
                        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom2");
                    }
                }
            }, 32, null, true);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("FavEmoRoamingHandler", 1, "func handleUserInfoGet ends, errInfo:" + e16.getMessage());
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
        } catch (OutOfMemoryError unused) {
            QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom");
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
        }
    }

    public void P2(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            try {
                EmotionMove$PlatInfo emotionMove$PlatInfo = new EmotionMove$PlatInfo();
                emotionMove$PlatInfo.implat.set(109);
                emotionMove$PlatInfo.mqqver.set(AppSetting.f99551k);
                emotionMove$PlatInfo.osver.set(Build.VERSION.RELEASE);
                EmotionMove$ReqBody emotionMove$ReqBody = new EmotionMove$ReqBody();
                emotionMove$ReqBody.msg_comm_info.set(emotionMove$PlatInfo);
                emotionMove$ReqBody.str_req_filename.set(list);
                emotionMove$ReqBody.uint32_capacity_incr.set(1);
                ToServiceMsg makeOIDBPkg = makeOIDBPkg(FavEmoConstant.CMD_FAV_MOVE, 36911, 1, emotionMove$ReqBody.toByteArray());
                makeOIDBPkg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 6);
                super.sendPbReq(makeOIDBPkg);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 2, "moveEmotion exception = " + e16.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    public void delUserEmoRoamingReq(List<String> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != null && list.size() > 0) {
            faceroam_sso$ReqDeleteItem faceroam_sso_reqdeleteitem = new faceroam_sso$ReqDeleteItem();
            faceroam_sso_reqdeleteitem.filename.set(list);
            faceroam_sso$PlatInfo faceroam_sso_platinfo = new faceroam_sso$PlatInfo();
            faceroam_sso_platinfo.implat.set(109L);
            faceroam_sso_platinfo.mqqver.set(AppSetting.f99551k);
            faceroam_sso_platinfo.osver.set(Build.VERSION.RELEASE);
            faceroam_sso$ReqBody faceroam_sso_reqbody = new faceroam_sso$ReqBody();
            faceroam_sso_reqbody.uint32_sub_cmd.set(2);
            faceroam_sso_reqbody.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
            faceroam_sso_reqbody.reqcmd_0x02.set(faceroam_sso_reqdeleteitem);
            faceroam_sso_reqbody.uint32_capacity_incr.set(1);
            faceroam_sso_reqbody.comm.set(faceroam_sso_platinfo);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), FavEmoConstant.CMD_FAV_ROAMING);
            toServiceMsg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 2);
            toServiceMsg.extraData.putBoolean("needSync", z16);
            toServiceMsg.putWupBuffer(faceroam_sso_reqbody.toByteArray());
            super.sendPbReq(toServiceMsg);
            QLog.i("FavEmoRoamingHandler", 1, "delUserEmoRoamingReq");
        }
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    public void handleDelMessage(Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, obj, Boolean.valueOf(z16));
            return;
        }
        faceroam_sso$RspBody faceroam_sso_rspbody = new faceroam_sso$RspBody();
        try {
            faceroam_sso_rspbody.mergeFrom((byte[]) obj);
            faceroam_sso$RspDeleteItem faceroam_sso_rspdeleteitem = faceroam_sso_rspbody.rspcmd_0x02.get();
            List<Long> list = faceroam_sso_rspdeleteitem.ret.get();
            List<String> list2 = faceroam_sso_rspdeleteitem.filename.get();
            ArrayList arrayList = new ArrayList();
            QLog.d("FavEmoRoamingHandler", 1, " handle ResId=" + list2 + "errMsg=" + faceroam_sso_rspbody.errmsg.get() + " ret=" + faceroam_sso_rspbody.ret.get() + "subCmd=" + faceroam_sso_rspbody.sub_cmd.get());
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list.get(i3).longValue() == 0) {
                    arrayList.add(list2.get(i3));
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 2, " delSuccess ResId=" + list2.get(i3));
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 2, " delFail ResId=" + list2.get(i3) + "error code = " + list.get(i3));
                }
            }
            ((IFavroamingDBManagerService) this.app.getRuntimeService(IFavroamingDBManagerService.class, "")).deleteDB(arrayList);
            super.notifyUI(0, true, Boolean.valueOf(z16));
            EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", 1);
            H2(arrayList);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("FavEmoRoamingHandler", 1, "func handleDelMessage ends, errInfo:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return FavEmoRoamingObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY);
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            switch (i3) {
                case 1:
                    O2(obj);
                    return;
                case 2:
                    handleDelMessage(obj, toServiceMsg.extraData.getBoolean("needSync"));
                    return;
                case 3:
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_DO_OCR_WHEN_UPLOAD");
                    }
                    N2(fromServiceMsg, obj, 3);
                    return;
                case 4:
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_GET_OCR");
                    }
                    N2(fromServiceMsg, obj, 4);
                    return;
                case 5:
                    M2(fromServiceMsg, toServiceMsg, obj);
                    return;
                case 6:
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE success\uff01");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        QLog.e("FavEmoRoamingHandler", 1, "fail to  not send command: " + i3 + " to server");
        if (i3 == 1) {
            IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) this.app.getRuntimeService(IFavroamingManagerService.class, "");
            if (iFavroamingManagerService != null) {
                iFavroamingManagerService.resetSyncState();
            } else {
                QLog.e("FavEmoRoamingHandler", 1, "getRoamingManager return null");
            }
            ((IFavEmoticonUtils) QRoute.api(IFavEmoticonUtils.class)).notifySyncFail();
        }
        if (fromServiceMsg != null && !fromServiceMsg.isSuccess()) {
            if (i3 == 2) {
                EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("2006", 1);
                return;
            }
            if (i3 == 1) {
                EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("2005", 1);
                return;
            }
            if (i3 == 5) {
                notifyUI(3, false, this.app.getApplication().getString(R.string.f209005e9));
                QLog.e("FavEmoRoamingHandler", 1, "modify ocr fail, errInfo:" + fromServiceMsg.getBusinessFailMsg());
                return;
            }
            if (i3 == 6) {
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE fail\uff01");
                }
                L2(obj);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
    public void queryUserEmoRoamingReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        faceroam_sso$ReqUserInfo faceroam_sso_requserinfo = new faceroam_sso$ReqUserInfo();
        if (this.f194634d) {
            faceroam_sso_requserinfo.use_emoji_item.set(true);
        }
        faceroam_sso$PlatInfo faceroam_sso_platinfo = new faceroam_sso$PlatInfo();
        faceroam_sso_platinfo.implat.set(109L);
        faceroam_sso_platinfo.mqqver.set(AppSetting.f99551k);
        faceroam_sso_platinfo.osver.set(Build.VERSION.RELEASE);
        faceroam_sso$ReqBody faceroam_sso_reqbody = new faceroam_sso$ReqBody();
        faceroam_sso_reqbody.uint32_sub_cmd.set(1);
        faceroam_sso_reqbody.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
        faceroam_sso_reqbody.reqcmd_0x01.set(faceroam_sso_requserinfo);
        faceroam_sso_reqbody.uint32_capacity_incr.set(1);
        faceroam_sso_reqbody.comm.set(faceroam_sso_platinfo);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), FavEmoConstant.CMD_FAV_ROAMING);
        toServiceMsg.extraData.putInt(FavEmoConstant.CMD_FAV_SUBCMD_KEY, 1);
        toServiceMsg.putWupBuffer(faceroam_sso_reqbody.toByteArray());
        super.sendPbReq(toServiceMsg);
        QLog.i("FavEmoRoamingHandler", 1, "queryUserEmoRoamingReq");
    }
}
