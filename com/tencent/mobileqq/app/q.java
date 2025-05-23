package com.tencent.mobileqq.app;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.IPSiteModel$Book;
import com.tencent.mobileqq.data.IPSiteModel$Comic;
import com.tencent.mobileqq.data.IPSiteModel$ComicRich;
import com.tencent.mobileqq.data.IPSiteModel$Game;
import com.tencent.mobileqq.data.IPSiteModel$GameRich;
import com.tencent.mobileqq.data.IPSiteModel$Goods;
import com.tencent.mobileqq.data.IPSiteModel$Gxzb;
import com.tencent.mobileqq.data.IPSiteModel$Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.emosm.ComicIPSite$Book;
import com.tencent.pb.emosm.ComicIPSite$Comic;
import com.tencent.pb.emosm.ComicIPSite$ComicRich;
import com.tencent.pb.emosm.ComicIPSite$Game;
import com.tencent.pb.emosm.ComicIPSite$GameRich;
import com.tencent.pb.emosm.ComicIPSite$Goods;
import com.tencent.pb.emosm.ComicIPSite$Gxzb;
import com.tencent.pb.emosm.ComicIPSite$ModuleInfo;
import com.tencent.pb.emosm.ComicIPSite$ModuleReq;
import com.tencent.pb.emosm.ComicIPSite$ModuleRsp;
import com.tencent.pb.emosm.ComicIPSite$Video;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q {
    static IPatchRedirector $redirector_;

    public static void a(String str, boolean z16, @NonNull EmoticonHandler emoticonHandler) {
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonIPSiteSubHandler", 2, "fetchEmoticonIPSiteInformationEx, tabId:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("EmoticonIPSiteSubHandler", 1, "fetchEmoticonIPSiteInformationEx error, id = " + str);
            return;
        }
        ComicIPSite$ModuleInfo comicIPSite$ModuleInfo = new ComicIPSite$ModuleInfo();
        comicIPSite$ModuleInfo.appId.set(204);
        comicIPSite$ModuleInfo.itemId.set("1_" + str);
        comicIPSite$ModuleInfo.isRetSummary.set(z16);
        ComicIPSite$ModuleReq comicIPSite$ModuleReq = new ComicIPSite$ModuleReq();
        comicIPSite$ModuleReq.platform.set(109L);
        comicIPSite$ModuleReq.mqqver.set(AppSetting.f99551k);
        comicIPSite$ModuleReq.uin.set(Long.valueOf(emoticonHandler.getCurrentAccountUin()).longValue());
        comicIPSite$ModuleReq.sub_cmd.set(1);
        comicIPSite$ModuleReq.moduleInfo.set(comicIPSite$ModuleInfo);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", emoticonHandler.getCurrentAccountUin(), "gxzbIpsit.ipsite");
        toServiceMsg.extraData.putString(EmojiManagerServiceProxy.EPID, str);
        toServiceMsg.putWupBuffer(comicIPSite$ModuleReq.toByteArray());
        emoticonHandler.sendPbReq(toServiceMsg);
    }

    public static void b(ToServiceMsg toServiceMsg, Object obj, AppInterface appInterface) {
        long j3;
        long j16;
        String str;
        String str2;
        String str3;
        ComicIPSite$ModuleRsp comicIPSite$ModuleRsp;
        IEmoticonManagerService iEmoticonManagerService;
        boolean z16;
        String str4 = "EmoticonIPSiteSubHandler";
        try {
            ComicIPSite$ModuleRsp mergeFrom = new ComicIPSite$ModuleRsp().mergeFrom((byte[]) obj);
            int i3 = mergeFrom.result.get();
            if (mergeFrom.sub_cmd.get() == 1) {
                if (i3 == 0) {
                    String string = toServiceMsg.extraData.getString(EmojiManagerServiceProxy.EPID);
                    int i16 = mergeFrom.ipId.get();
                    String str5 = mergeFrom.ipName.get();
                    String str6 = mergeFrom.ipDesc.get();
                    String str7 = mergeFrom.ipUrl.get();
                    int i17 = mergeFrom.itemSize.get();
                    String str8 = mergeFrom.strType.get();
                    int i18 = mergeFrom.extId.get();
                    String str9 = mergeFrom.extStr.get();
                    String str10 = mergeFrom.ipLogo.get();
                    String str11 = mergeFrom.ipContent.get();
                    if (mergeFrom.requestInterval.get() == 0) {
                        j3 = 86400;
                    } else {
                        j3 = mergeFrom.requestInterval.get();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EmoticonIPSiteSubHandler", 2, "onReceive richIPReqTime = " + j3);
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        if ("gxzb".equals(str8)) {
                            List<ComicIPSite$Gxzb> list = mergeFrom.gxzbList.get();
                            j16 = j3;
                            int i19 = 0;
                            while (i19 < list.size()) {
                                ComicIPSite$Gxzb comicIPSite$Gxzb = list.get(i19);
                                arrayList.add(new IPSiteModel$Gxzb(comicIPSite$Gxzb.appId.get(), comicIPSite$Gxzb.appName.get(), comicIPSite$Gxzb.cover.get(), comicIPSite$Gxzb.feeType.get(), comicIPSite$Gxzb.f342123id.get(), comicIPSite$Gxzb.name.get()));
                                i19++;
                                list = list;
                                str10 = str10;
                            }
                            str = str10;
                            str2 = "EmoticonIPSiteSubHandler";
                            comicIPSite$ModuleRsp = mergeFrom;
                            str3 = string;
                        } else {
                            j16 = j3;
                            str = str10;
                            if (!"game".equals(str8)) {
                                str2 = "EmoticonIPSiteSubHandler";
                                str3 = string;
                                if ("goods".equals(str8)) {
                                    List<ComicIPSite$Goods> list2 = mergeFrom.goodsList.get();
                                    for (int i26 = 0; i26 < list2.size(); i26++) {
                                        ComicIPSite$Goods comicIPSite$Goods = list2.get(i26);
                                        arrayList.add(new IPSiteModel$Goods(comicIPSite$Goods.cover.get(), comicIPSite$Goods.goodsTags.get(), comicIPSite$Goods.f342122id.get(), comicIPSite$Goods.name.get(), comicIPSite$Goods.price.get(), comicIPSite$Goods.saleTags.get(), comicIPSite$Goods.svipPrice.get(), comicIPSite$Goods.url.get(), comicIPSite$Goods.moreUrl.get(), comicIPSite$Goods.saleNum.get()));
                                    }
                                } else if ("video".equals(str8)) {
                                    List<ComicIPSite$Video> list3 = mergeFrom.videoList.get();
                                    for (int i27 = 0; i27 < list3.size(); i27++) {
                                        ComicIPSite$Video comicIPSite$Video = list3.get(i27);
                                        arrayList.add(new IPSiteModel$Video(comicIPSite$Video.f342124id.get(), comicIPSite$Video.buttonDesc.get(), comicIPSite$Video.content.get(), comicIPSite$Video.cover.get(), comicIPSite$Video.desc.get(), comicIPSite$Video.name.get(), comicIPSite$Video.endTime.get(), comicIPSite$Video.isShow.get(), comicIPSite$Video.newStartTime.get(), comicIPSite$Video.newEndTime.get(), comicIPSite$Video.redirectUrl.get(), comicIPSite$Video.videoSource.get(), comicIPSite$Video.showDate.get()));
                                    }
                                } else if ("book".equals(str8)) {
                                    List<ComicIPSite$Book> list4 = mergeFrom.bookList.get();
                                    for (int i28 = 0; i28 < list4.size(); i28++) {
                                        ComicIPSite$Book comicIPSite$Book = list4.get(i28);
                                        arrayList.add(new IPSiteModel$Book(comicIPSite$Book.cover.get(), comicIPSite$Book.desc.get(), comicIPSite$Book.f342119id.get(), comicIPSite$Book.jumpUrl.get(), comicIPSite$Book.name.get(), comicIPSite$Book.recommDesc.get(), comicIPSite$Book.authorName.get()));
                                    }
                                } else if ("comic".equals(str8)) {
                                    List<ComicIPSite$Comic> list5 = mergeFrom.comicList.get();
                                    int i29 = 0;
                                    while (i29 < list5.size()) {
                                        ComicIPSite$Comic comicIPSite$Comic = list5.get(i29);
                                        List<ComicIPSite$ComicRich> list6 = comicIPSite$Comic.rich.get();
                                        ArrayList arrayList2 = new ArrayList();
                                        int i36 = 0;
                                        while (i36 < list6.size()) {
                                            ComicIPSite$ComicRich comicIPSite$ComicRich = list6.get(i36);
                                            arrayList2.add(new IPSiteModel$ComicRich(comicIPSite$ComicRich.extCover.get(), comicIPSite$ComicRich.extName.get(), comicIPSite$ComicRich.extTitle.get(), comicIPSite$ComicRich.extUrl.get()));
                                            i36++;
                                            list5 = list5;
                                            list6 = list6;
                                            mergeFrom = mergeFrom;
                                            i18 = i18;
                                        }
                                        arrayList.add(new IPSiteModel$Comic(comicIPSite$Comic.comicType.get(), comicIPSite$Comic.cover.get(), comicIPSite$Comic.desc.get(), comicIPSite$Comic.f342120id.get(), comicIPSite$Comic.jumpUrl.get(), comicIPSite$Comic.name.get(), comicIPSite$Comic.recommDesc.get(), comicIPSite$Comic.typeName.get(), arrayList2));
                                        i29++;
                                        list5 = list5;
                                        mergeFrom = mergeFrom;
                                        i18 = i18;
                                    }
                                }
                            } else {
                                List<ComicIPSite$Game> list7 = mergeFrom.gameList.get();
                                int i37 = 0;
                                while (i37 < list7.size()) {
                                    ComicIPSite$Game comicIPSite$Game = list7.get(i37);
                                    List<ComicIPSite$Game> list8 = list7;
                                    ArrayList arrayList3 = new ArrayList();
                                    String str12 = str4;
                                    String str13 = string;
                                    int i38 = 0;
                                    for (List<ComicIPSite$GameRich> list9 = comicIPSite$Game.rich.get(); i38 < list9.size(); list9 = list9) {
                                        ComicIPSite$GameRich comicIPSite$GameRich = list9.get(i38);
                                        arrayList3.add(new IPSiteModel$GameRich(comicIPSite$GameRich.anchorFaceUrl.get(), comicIPSite$GameRich.anchorId.get(), comicIPSite$GameRich.anchorName.get(), comicIPSite$GameRich.coverUrl.get(), comicIPSite$GameRich.online.get(), comicIPSite$GameRich.title.get(), comicIPSite$GameRich.richJumpUrl.get()));
                                        i38++;
                                    }
                                    arrayList.add(new IPSiteModel$Game(comicIPSite$Game.cover.get(), comicIPSite$Game.desc.get(), comicIPSite$Game.f342121id.get(), comicIPSite$Game.jumpUrl.get(), comicIPSite$Game.name.get(), comicIPSite$Game.recommDesc.get(), arrayList3));
                                    i37++;
                                    list7 = list8;
                                    str4 = str12;
                                    string = str13;
                                }
                                str2 = str4;
                                str3 = string;
                            }
                            comicIPSite$ModuleRsp = mergeFrom;
                        }
                        long j17 = j16;
                        String str14 = str;
                        VipIPSiteInfo vipIPSiteInfo = new VipIPSiteInfo(i16, str5, str6, str7, i17, str8, i18, str9, str14, str11, arrayList);
                        if (appInterface != null && (iEmoticonManagerService = (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "")) != null) {
                            EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(str3);
                            syncFindEmoticonPackageById.ipSiteInfo = vipIPSiteInfo;
                            syncFindEmoticonPackageById.ipSiteInfoBytes = iEmoticonManagerService.parseIPSiteInfoToBytes(vipIPSiteInfo);
                            syncFindEmoticonPackageById.richIPReqTime = j17;
                            if (comicIPSite$ModuleRsp.goodsList.size() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            syncFindEmoticonPackageById.hasIpProduct = z16;
                            syncFindEmoticonPackageById.ipUrl = str14;
                            syncFindEmoticonPackageById.ipName = str5;
                            syncFindEmoticonPackageById.ipDetail = str6;
                            syncFindEmoticonPackageById.ipJumpUrl = str7;
                            iEmoticonManagerService.saveEmoticonPackage(syncFindEmoticonPackageById);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, 2, "onReceive vipIPSiteInfo = " + vipIPSiteInfo);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        e = e16;
                        str4 = str2;
                        QLog.e(str4, 1, "onReceive error = ", e);
                        return;
                    }
                }
                QLog.e("EmoticonIPSiteSubHandler", 1, "onReceive error result = " + i3);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
