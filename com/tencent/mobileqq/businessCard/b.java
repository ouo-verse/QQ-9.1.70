package com.tencent.mobileqq.businessCard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$CardInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$MobileInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$OCRInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$RequestAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$RequestCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$RequestCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$RequestDel;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$RequestModify;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$ResponseAdd;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$ResponseCardDetail;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$ResponseCardList;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$UinInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends MSFServlet {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(QQAppInterface qQAppInterface, BusinessCard businessCard, boolean z16) {
        if (businessCard == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), b.class);
        newIntent.putExtra("key_cmd_type", 1);
        newIntent.putExtra("key_card_info", businessCard);
        newIntent.putExtra("key_is_mine", z16);
        qQAppInterface.startServlet(newIntent);
    }

    public static void b(BusinessCard businessCard, Oidb_0x43c$CardInfo oidb_0x43c$CardInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z16;
        String str6;
        String str7;
        boolean z17;
        boolean z18;
        if (oidb_0x43c$CardInfo == null) {
            return;
        }
        businessCard.cardId = oidb_0x43c$CardInfo.card_id.get().toStringUtf8();
        String str8 = null;
        if (oidb_0x43c$CardInfo.name.has()) {
            str = oidb_0x43c$CardInfo.name.get();
        } else {
            str = null;
        }
        businessCard.cardName = str;
        if (oidb_0x43c$CardInfo.company.has()) {
            str2 = oidb_0x43c$CardInfo.company.get();
        } else {
            str2 = null;
        }
        businessCard.company = str2;
        if (oidb_0x43c$CardInfo.pic_url.has()) {
            str3 = oidb_0x43c$CardInfo.pic_url.get();
        } else {
            str3 = null;
        }
        businessCard.picUrl = str3;
        if (oidb_0x43c$CardInfo.bind_uin.has()) {
            str4 = String.valueOf(oidb_0x43c$CardInfo.bind_uin.get());
        } else {
            str4 = null;
        }
        businessCard.bindUin = str4;
        businessCard.lastUpdateTime = oidb_0x43c$CardInfo.last_update_time.get();
        businessCard.cardSrc = oidb_0x43c$CardInfo.card_src.get();
        if (oidb_0x43c$CardInfo.uins.has() && oidb_0x43c$CardInfo.uins.get() != null) {
            Iterator<Long> it = oidb_0x43c$CardInfo.uins.get().iterator();
            while (it.hasNext()) {
                businessCard.qqNum.add(String.valueOf(it.next().longValue()));
            }
        }
        if (oidb_0x43c$CardInfo.uin_info.has() && oidb_0x43c$CardInfo.uin_info.get() != null) {
            for (Oidb_0x43c$UinInfo oidb_0x43c$UinInfo : oidb_0x43c$CardInfo.uin_info.get()) {
                CardUinInfo cardUinInfo = new CardUinInfo();
                cardUinInfo.f200898d = String.valueOf(oidb_0x43c$UinInfo.uin.get());
                if (oidb_0x43c$UinInfo.isFriend.has() && oidb_0x43c$UinInfo.isFriend.get()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                cardUinInfo.f200899e = z17;
                if (oidb_0x43c$UinInfo.isSearchable.has() && oidb_0x43c$UinInfo.isSearchable.get()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                cardUinInfo.f200900f = z18;
                businessCard.uinInfos.add(cardUinInfo);
            }
        }
        if (oidb_0x43c$CardInfo.mobiles.has() && oidb_0x43c$CardInfo.mobiles.get() != null) {
            Iterator<String> it5 = oidb_0x43c$CardInfo.mobiles.get().iterator();
            while (it5.hasNext()) {
                businessCard.mobilesNum.add(it5.next());
            }
        }
        if (oidb_0x43c$CardInfo.descs.has() && oidb_0x43c$CardInfo.descs.get() != null) {
            Iterator<String> it6 = oidb_0x43c$CardInfo.descs.get().iterator();
            while (it6.hasNext()) {
                businessCard.descs.add(it6.next());
            }
        }
        String str9 = "";
        if (oidb_0x43c$CardInfo.mobile_info.has() && oidb_0x43c$CardInfo.mobile_info.get() != null) {
            for (Oidb_0x43c$MobileInfo oidb_0x43c$MobileInfo : oidb_0x43c$CardInfo.mobile_info.get()) {
                CardMobileInfo cardMobileInfo = new CardMobileInfo();
                if (!oidb_0x43c$MobileInfo.mobile.has()) {
                    str5 = "";
                } else {
                    str5 = oidb_0x43c$MobileInfo.mobile.get();
                }
                cardMobileInfo.f200887d = str5;
                if (oidb_0x43c$MobileInfo.isFriend.has() && oidb_0x43c$MobileInfo.isFriend.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cardMobileInfo.f200889f = z16;
                if (z16) {
                    cardMobileInfo.f200888e = String.valueOf(oidb_0x43c$MobileInfo.bind_uin.get());
                } else {
                    cardMobileInfo.f200888e = "";
                }
                if (!oidb_0x43c$MobileInfo.nick_name.has()) {
                    str6 = "";
                } else {
                    str6 = oidb_0x43c$MobileInfo.nick_name.get();
                }
                cardMobileInfo.f200890h = str6;
                if (!oidb_0x43c$MobileInfo.format_mobile.has()) {
                    str7 = "";
                } else {
                    str7 = oidb_0x43c$MobileInfo.format_mobile.get();
                }
                cardMobileInfo.f200891i = str7;
                businessCard.mobileInfos.add(cardMobileInfo);
            }
        }
        if (oidb_0x43c$CardInfo.ocr_info.has()) {
            Oidb_0x43c$OCRInfo oidb_0x43c$OCRInfo = oidb_0x43c$CardInfo.ocr_info.get();
            CardOCRInfo cardOCRInfo = new CardOCRInfo();
            if (oidb_0x43c$OCRInfo.name.has()) {
                str9 = oidb_0x43c$OCRInfo.name.get();
            }
            cardOCRInfo.f200892d = str9;
            if (oidb_0x43c$CardInfo.pic_url.has()) {
                str8 = oidb_0x43c$CardInfo.pic_url.get();
            }
            cardOCRInfo.f200893e = str8;
            Iterator<Long> it7 = oidb_0x43c$OCRInfo.uins.get().iterator();
            while (it7.hasNext()) {
                cardOCRInfo.f200894f.add(String.valueOf(it7.next().longValue()));
            }
            Iterator<String> it8 = oidb_0x43c$OCRInfo.mobiles.get().iterator();
            while (it8.hasNext()) {
                cardOCRInfo.f200895h.add(it8.next());
            }
            cardOCRInfo.f200896i = oidb_0x43c$OCRInfo.name_dependLevel.get();
            cardOCRInfo.f200897m = oidb_0x43c$OCRInfo.uins_dependLevel.get();
            cardOCRInfo.C = oidb_0x43c$OCRInfo.mobiles_dependLevel.get();
            businessCard.OCRInfo = cardOCRInfo;
        } else {
            businessCard.OCRInfo = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "decodeBuinessCard card=" + businessCard);
        }
    }

    private void c(BusinessCardManager businessCardManager, ArrayList<BusinessCard> arrayList, Oidb_0x43c$ResponseCardList oidb_0x43c$ResponseCardList) {
        for (Oidb_0x43c$CardInfo oidb_0x43c$CardInfo : oidb_0x43c$ResponseCardList.others.get()) {
            BusinessCard businessCard = new BusinessCard();
            b(businessCard, oidb_0x43c$CardInfo);
            if (businessCard.cardId != null) {
                arrayList.add(businessCard);
                businessCardManager.b(businessCard);
            }
        }
    }

    public static void d(QQAppInterface qQAppInterface, int i3, int i16, boolean z16) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), b.class);
        newIntent.putExtra("key_cmd_type", 4);
        newIntent.putExtra("req_get_list_seq", i3);
        newIntent.putExtra("req_get_list_nextFlag", i16);
        newIntent.putExtra("req_get_list_first", z16);
        qQAppInterface.startServlet(newIntent);
    }

    public static void e(QQAppInterface qQAppInterface, String str, boolean z16, int i3) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), b.class);
        newIntent.putExtra("key_cmd_type", 5);
        newIntent.putExtra("key_card_id", str);
        newIntent.putExtra("key_is_mine", z16);
        newIntent.putExtra("key_get_detail_type", i3);
        qQAppInterface.startServlet(newIntent);
    }

    public static void f(QQAppInterface qQAppInterface, BusinessCard businessCard, boolean z16) {
        if (businessCard == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), b.class);
        newIntent.putExtra("key_cmd_type", 3);
        newIntent.putExtra("key_card_info", businessCard);
        newIntent.putExtra("key_is_mine", z16);
        qQAppInterface.startServlet(newIntent);
    }

    private void g(byte[] bArr, int i3, String str, Packet packet) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1084);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        packet.setSSOCommand(str);
        packet.putSendData(allocate.array());
        packet.setTimeout(30000L);
    }

    private void h(Intent intent, Packet packet) {
        BusinessCard businessCard = (BusinessCard) intent.getExtras().getParcelable("key_card_info");
        Oidb_0x43c$CardInfo oidb_0x43c$CardInfo = new Oidb_0x43c$CardInfo();
        if (!TextUtils.isEmpty(businessCard.picUrl)) {
            oidb_0x43c$CardInfo.pic_url.set(businessCard.picUrl);
        }
        if (!TextUtils.isEmpty(businessCard.cardName)) {
            oidb_0x43c$CardInfo.name.set(businessCard.cardName);
        }
        if (!TextUtils.isEmpty(businessCard.company)) {
            oidb_0x43c$CardInfo.company.set(businessCard.company);
        }
        Iterator<String> it = businessCard.qqNum.iterator();
        while (it.hasNext()) {
            oidb_0x43c$CardInfo.uins.add(Long.valueOf(Long.parseLong(it.next())));
        }
        Iterator<String> it5 = businessCard.mobilesNum.iterator();
        while (it5.hasNext()) {
            oidb_0x43c$CardInfo.mobiles.add(it5.next());
        }
        Iterator<String> it6 = businessCard.descs.iterator();
        while (it6.hasNext()) {
            oidb_0x43c$CardInfo.descs.add(it6.next());
        }
        if (!TextUtils.isEmpty(businessCard.bindUin)) {
            try {
                oidb_0x43c$CardInfo.bind_uin.set(Long.parseLong(businessCard.bindUin));
            } catch (NumberFormatException unused) {
            }
        }
        if (!TextUtils.isEmpty(businessCard.bindMobile)) {
            oidb_0x43c$CardInfo.bind_mbl.set(businessCard.bindMobile);
        }
        oidb_0x43c$CardInfo.card_src.set(businessCard.cardSrc);
        if (businessCard.OCRInfo != null) {
            Oidb_0x43c$OCRInfo oidb_0x43c$OCRInfo = new Oidb_0x43c$OCRInfo();
            oidb_0x43c$OCRInfo.name.set(businessCard.OCRInfo.f200892d);
            for (String str : businessCard.OCRInfo.f200894f) {
                if (str != null && str.length() > 0) {
                    oidb_0x43c$OCRInfo.uins.add(Long.valueOf(Long.parseLong(str)));
                }
            }
            for (String str2 : businessCard.OCRInfo.f200895h) {
                if (str2.length() > 0) {
                    oidb_0x43c$OCRInfo.mobiles.add(str2);
                }
            }
            oidb_0x43c$OCRInfo.name_dependLevel.set(businessCard.OCRInfo.f200896i);
            oidb_0x43c$OCRInfo.uins_dependLevel.set(businessCard.OCRInfo.f200897m);
            oidb_0x43c$OCRInfo.mobiles_dependLevel.set(businessCard.OCRInfo.C);
            oidb_0x43c$CardInfo.ocr_info.set(oidb_0x43c$OCRInfo);
        }
        Oidb_0x43c$RequestAdd oidb_0x43c$RequestAdd = new Oidb_0x43c$RequestAdd();
        oidb_0x43c$RequestAdd.card_info.set(oidb_0x43c$CardInfo);
        boolean booleanExtra = intent.getBooleanExtra("key_is_mine", false);
        if (booleanExtra) {
            oidb_0x43c$RequestAdd.isMine.set(booleanExtra);
            businessCard.cardType = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "reqAddCard: card=" + businessCard);
        }
        g(oidb_0x43c$RequestAdd.toByteArray(), 1, "OidbSvc.0x43c_1", packet);
    }

    private void i(Intent intent, Packet packet) {
        Oidb_0x43c$RequestDel oidb_0x43c$RequestDel = new Oidb_0x43c$RequestDel();
        String stringExtra = intent.getStringExtra("key_card_id");
        oidb_0x43c$RequestDel.card_id.set(ByteStringMicro.copyFromUtf8(stringExtra));
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "reqDelCard: id=" + stringExtra);
        }
        g(oidb_0x43c$RequestDel.toByteArray(), 2, "OidbSvc.0x43c_2", packet);
    }

    private void j(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra("req_get_list_seq", -1);
        int intExtra2 = intent.getIntExtra("req_get_list_nextFlag", 0);
        Oidb_0x43c$RequestCardList oidb_0x43c$RequestCardList = new Oidb_0x43c$RequestCardList();
        oidb_0x43c$RequestCardList.req_num.set(intExtra);
        oidb_0x43c$RequestCardList.next_flag.set(intExtra2);
        oidb_0x43c$RequestCardList.req_num.set(10);
        g(oidb_0x43c$RequestCardList.toByteArray(), 4, "OidbSvc.0x43c_4", packet);
    }

    private void k(Intent intent, Packet packet) {
        Oidb_0x43c$RequestCardDetail oidb_0x43c$RequestCardDetail = new Oidb_0x43c$RequestCardDetail();
        String stringExtra = intent.getStringExtra("key_card_id");
        oidb_0x43c$RequestCardDetail.card_id.set(ByteStringMicro.copyFromUtf8(stringExtra));
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "reqGetDetailCardInfo|cardId=" + stringExtra);
        }
        g(oidb_0x43c$RequestCardDetail.toByteArray(), 5, "OidbSvc.0x43c_5", packet);
    }

    private void l(Intent intent, Packet packet) {
        BusinessCard businessCard = (BusinessCard) intent.getExtras().getParcelable("key_card_info");
        Oidb_0x43c$CardInfo oidb_0x43c$CardInfo = new Oidb_0x43c$CardInfo();
        oidb_0x43c$CardInfo.card_id.set(ByteStringMicro.copyFromUtf8(businessCard.cardId));
        if (!TextUtils.isEmpty(businessCard.picUrl)) {
            oidb_0x43c$CardInfo.pic_url.set(businessCard.picUrl);
        }
        if (!TextUtils.isEmpty(businessCard.cardName)) {
            oidb_0x43c$CardInfo.name.set(businessCard.cardName);
        }
        if (!TextUtils.isEmpty(businessCard.company)) {
            oidb_0x43c$CardInfo.company.set(businessCard.company);
        }
        Iterator<String> it = businessCard.qqNum.iterator();
        while (it.hasNext()) {
            oidb_0x43c$CardInfo.uins.add(Long.valueOf(Long.parseLong(it.next())));
        }
        Iterator<String> it5 = businessCard.mobilesNum.iterator();
        while (it5.hasNext()) {
            oidb_0x43c$CardInfo.mobiles.add(it5.next());
        }
        Iterator<String> it6 = businessCard.descs.iterator();
        while (it6.hasNext()) {
            oidb_0x43c$CardInfo.descs.add(it6.next());
        }
        if (!TextUtils.isEmpty(businessCard.bindUin)) {
            try {
                oidb_0x43c$CardInfo.bind_uin.set(Long.parseLong(businessCard.bindUin));
            } catch (NumberFormatException unused) {
            }
        }
        if (!TextUtils.isEmpty(businessCard.bindMobile)) {
            oidb_0x43c$CardInfo.bind_mbl.set(businessCard.bindMobile);
        }
        if (businessCard.OCRInfo != null) {
            Oidb_0x43c$OCRInfo oidb_0x43c$OCRInfo = new Oidb_0x43c$OCRInfo();
            oidb_0x43c$OCRInfo.name.set(businessCard.OCRInfo.f200892d);
            for (String str : businessCard.OCRInfo.f200894f) {
                if (str.length() > 0) {
                    oidb_0x43c$OCRInfo.uins.add(Long.valueOf(Long.parseLong(str)));
                }
            }
            for (String str2 : businessCard.OCRInfo.f200895h) {
                if (str2.length() > 0) {
                    oidb_0x43c$OCRInfo.mobiles.add(str2);
                }
            }
            oidb_0x43c$OCRInfo.name_dependLevel.set(businessCard.OCRInfo.f200896i);
            oidb_0x43c$OCRInfo.uins_dependLevel.set(businessCard.OCRInfo.f200897m);
            oidb_0x43c$OCRInfo.mobiles_dependLevel.set(businessCard.OCRInfo.C);
            oidb_0x43c$CardInfo.ocr_info.set(oidb_0x43c$OCRInfo);
        }
        Oidb_0x43c$RequestModify oidb_0x43c$RequestModify = new Oidb_0x43c$RequestModify();
        oidb_0x43c$RequestModify.card_info.set(oidb_0x43c$CardInfo);
        if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "reqModifyCard:" + businessCard);
        }
        g(oidb_0x43c$RequestModify.toByteArray(), 3, "OidbSvc.0x43c_3", packet);
    }

    private void m(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r11.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                bundle.putInt("resp_result", i3);
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_Servlet", 2, "respAddCard | is success, and result=" + i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    Oidb_0x43c$ResponseAdd oidb_0x43c$ResponseAdd = new Oidb_0x43c$ResponseAdd();
                    oidb_0x43c$ResponseAdd.mergeFrom(byteArray);
                    if (oidb_0x43c$ResponseAdd.card_id.has()) {
                        String stringUtf8 = oidb_0x43c$ResponseAdd.card_id.get().toStringUtf8();
                        BusinessCard businessCard = (BusinessCard) intent.getExtras().getParcelable("key_card_info");
                        boolean booleanExtra = intent.getBooleanExtra("key_is_mine", false);
                        if (businessCard != null) {
                            businessCard.cardId = stringUtf8;
                            bundle.putString("key_card_id", stringUtf8);
                            if (QLog.isColorLevel()) {
                                QLog.d("BusinessCard_Servlet", 2, "respAddCard | is success cardId=" + stringUtf8);
                            }
                            e(qQAppInterface, stringUtf8, booleanExtra, 1);
                        }
                    }
                } else {
                    isSuccess = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("BusinessCard_Servlet", 2, e16.getMessage());
                z16 = false;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "$$respAddCard | is not success");
        }
        z16 = isSuccess;
        notifyObserver(intent, 1, z16, bundle, a.class);
    }

    private void n(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("key_card_id");
        bundle.putString("key_card_id", stringExtra);
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r11.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_Servlet", 2, "respDelCard | del cardId = " + stringExtra + ",result=" + i3);
                }
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    BusinessCardManager businessCardManager = (BusinessCardManager) ((QQAppInterface) getAppRuntime()).getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
                    BusinessCard i16 = businessCardManager.i(stringExtra);
                    if (i16 != null && !TextUtils.isEmpty(i16.bindUin)) {
                        businessCardManager.q(i16.bindUin);
                    }
                    businessCardManager.p(stringExtra);
                } else {
                    isSuccess = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("BusinessCard_Servlet", 2, e16.getMessage());
                z16 = false;
            }
        }
        z16 = isSuccess;
        notifyObserver(intent, 2, z16, bundle, a.class);
    }

    private void o(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        int intExtra = intent.getIntExtra("req_get_list_seq", -1);
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r13.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_Servlet", 2, "respGetCardList | is success, and result=" + i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                    BusinessCardManager businessCardManager = (BusinessCardManager) qQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    Oidb_0x43c$ResponseCardList oidb_0x43c$ResponseCardList = new Oidb_0x43c$ResponseCardList();
                    oidb_0x43c$ResponseCardList.mergeFrom(byteArray);
                    int i16 = oidb_0x43c$ResponseCardList.seq.get();
                    if (i16 == intExtra) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BusinessCard_Servlet", 2, "respGetCardList | seq equal " + i16);
                        }
                        notifyObserver(intent, 4, false, null, a.class);
                        return;
                    }
                    boolean booleanExtra = intent.getBooleanExtra("req_get_list_first", false);
                    ArrayList<BusinessCard> arrayList = new ArrayList<>();
                    if (booleanExtra) {
                        businessCardManager.f();
                        if (oidb_0x43c$ResponseCardList.mine.has()) {
                            BusinessCard businessCard = new BusinessCard();
                            b(businessCard, oidb_0x43c$ResponseCardList.mine.get());
                            businessCard.cardType = 1;
                            businessCardManager.b(businessCard);
                            arrayList.add(businessCard);
                        }
                    }
                    c(businessCardManager, arrayList, oidb_0x43c$ResponseCardList);
                    businessCardManager.r(arrayList, false);
                    int i17 = oidb_0x43c$ResponseCardList.next_flag.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("BusinessCard_Servlet", 2, "respGetCardList | nextFlag=" + i17);
                    }
                    if (i17 == -1) {
                        businessCardManager.s(i16);
                        notifyObserver(intent, 4, true, null, a.class);
                        return;
                    } else {
                        d(qQAppInterface, intExtra, i17, false);
                        return;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("BusinessCard_Servlet", 2, e16.getMessage());
            }
        }
        notifyObserver(intent, 4, false, null, a.class);
    }

    private void p(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("key_card_id");
        bundle.putString("key_card_id", stringExtra);
        bundle.putInt("key_get_detail_type", intent.getIntExtra("key_get_detail_type", 3));
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r14.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is success, and result=" + i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    BusinessCardManager businessCardManager = (BusinessCardManager) ((QQAppInterface) getAppRuntime()).getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    Oidb_0x43c$ResponseCardDetail oidb_0x43c$ResponseCardDetail = new Oidb_0x43c$ResponseCardDetail();
                    oidb_0x43c$ResponseCardDetail.mergeFrom(byteArray);
                    if (oidb_0x43c$ResponseCardDetail.card_id.has() && oidb_0x43c$ResponseCardDetail.card_id.get().toStringUtf8().equals(stringExtra)) {
                        BusinessCard businessCard = new BusinessCard();
                        Oidb_0x43c$CardInfo oidb_0x43c$CardInfo = oidb_0x43c$ResponseCardDetail.card_info.get();
                        b(businessCard, oidb_0x43c$CardInfo);
                        if (intent.getBooleanExtra("key_is_mine", false)) {
                            businessCard.cardType = 1;
                        } else {
                            businessCard.cardType = 0;
                        }
                        if (oidb_0x43c$CardInfo.ocr_info.has()) {
                            businessCardManager.c(businessCard);
                        }
                        if (!TextUtils.isEmpty(businessCard.bindUin)) {
                            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(businessCard.bindUin), "BusinessCard_Servlet")) {
                                businessCardManager.d(businessCard.bindUin, businessCard);
                            } else {
                                businessCardManager.q(businessCard.bindUin);
                            }
                            if (intent.getIntExtra("key_get_detail_type", 3) == 1) {
                                businessCardManager.t(1, true);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is success, and cardId=" + stringExtra);
                        }
                    }
                } else {
                    isSuccess = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("BusinessCard_Servlet", 2, e16.getMessage());
                z16 = false;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("BusinessCard_Servlet", 2, "respGetDetailCardInfo | is not success");
        }
        z16 = isSuccess;
        notifyObserver(intent, 5, z16, bundle, a.class);
    }

    private void q(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        BusinessCard businessCard = (BusinessCard) intent.getParcelableExtra("key_card_info");
        bundle.putString("key_card_id", businessCard.cardId);
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r10.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard_Servlet", 2, "RespModifyCard | is success and result = " + i3);
                }
                if (i3 == 0) {
                    e((QQAppInterface) getAppRuntime(), businessCard.cardId, intent.getBooleanExtra("key_is_mine", false), 2);
                } else {
                    isSuccess = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.w("BusinessCard_Servlet", 2, e16.getMessage());
                z16 = false;
            }
        }
        z16 = isSuccess;
        notifyObserver(intent, 3, z16, bundle, a.class);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resp:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("BusinessCard_Servlet", 2, sb5.toString());
        }
        if (serviceCmd.equals("OidbSvc.0x43c_1")) {
            m(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("OidbSvc.0x43c_2")) {
            n(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("OidbSvc.0x43c_3")) {
            q(intent, fromServiceMsg);
        } else if (serviceCmd.equals("OidbSvc.0x43c_4")) {
            o(intent, fromServiceMsg);
        } else if (serviceCmd.equals("OidbSvc.0x43c_5")) {
            p(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int i3 = intent.getExtras().getInt("key_cmd_type");
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            k(intent, packet);
                            return;
                        }
                        return;
                    }
                    j(intent, packet);
                    return;
                }
                l(intent, packet);
                return;
            }
            i(intent, packet);
            return;
        }
        h(intent, packet);
    }
}
