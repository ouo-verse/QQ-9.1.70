package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76$Item;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76$ReqBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76$RspBody;
import tencent.im.oidb.cmd0xc76.oidb_cmd0xc76$Setting;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a$GetUinInfoReq;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a$GetUinInfoRsp;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a$ReqBody;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a$RspBody;
import tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a$UinInfo;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$ReqBody;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$UnFollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$UnfollowReq;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AppletsHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Integer> f196695d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f196696e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<Long> f196697f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f196698h;

    public AppletsHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f196695d = new ConcurrentHashMap();
        this.f196696e = new Object();
        this.f196697f = new HashSet();
        this.f196698h = qQAppInterface;
    }

    private <T extends MessageRecord> Map<String, Integer> D2(List<T> list) {
        int i3;
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String F2 = F2(it.next());
                if (!TextUtils.isEmpty(F2)) {
                    Integer num = (Integer) hashMap.get(F2);
                    if (num != null) {
                        i3 = Integer.valueOf(num.intValue() + 1);
                    } else {
                        i3 = 1;
                    }
                    hashMap.put(F2, i3);
                }
            }
            return hashMap;
        }
        return null;
    }

    private String F2(MessageRecord messageRecord) {
        JSONObject jSONObject;
        if (messageRecord != null && (jSONObject = messageRecord.mExJsonObject) != null) {
            return jSONObject.optString("appid");
        }
        return null;
    }

    private List<MessageRecord> H2() {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_APPLETS_UIN, QzoneConfig.DEFAULT_APPLETS_UIN);
        long C = this.f196698h.getConversationFacade().C(config, 1038);
        if (C > System.currentTimeMillis()) {
            C = -1;
        }
        List<ChatMessage> s16 = this.f196698h.getMessageFacade().F(1038).s(config, 1038, C);
        if (s16 != null) {
            ArrayList arrayList = new ArrayList();
            for (ChatMessage chatMessage : s16) {
                if (!chatMessage.isread) {
                    arrayList.add(chatMessage);
                }
            }
            return arrayList;
        }
        return null;
    }

    private oidb_sso$OIDBSSOPkg I2(ArrayList<AppletItem> arrayList, boolean z16) {
        oidb_cmd0xc76$ReqBody oidb_cmd0xc76_reqbody = new oidb_cmd0xc76$ReqBody();
        oidb_cmd0xc76_reqbody.cmd.set(2);
        ArrayList arrayList2 = new ArrayList();
        Iterator<AppletItem> it = arrayList.iterator();
        while (it.hasNext()) {
            AppletItem next = it.next();
            oidb_cmd0xc76$Item oidb_cmd0xc76_item = new oidb_cmd0xc76$Item();
            if (z16) {
                oidb_cmd0xc76_item.puin.set(Long.parseLong(next.f()));
                oidb_cmd0xc76_item.name.set(next.c());
                oidb_cmd0xc76_item.value.set(next.e());
            } else {
                oidb_cmd0xc76_item.f435986id.set(next.b());
                oidb_cmd0xc76_item.type.set(next.getType());
                oidb_cmd0xc76_item.value.set(next.e());
            }
            arrayList2.add(oidb_cmd0xc76_item);
        }
        oidb_cmd0xc76_reqbody.apps.set(arrayList2);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3190);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc76_reqbody.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        int i16;
        oidb_cmd0xc7a$GetUinInfoRsp oidb_cmd0xc7a_getuininforsp;
        List<oidb_cmd0xc7a$UinInfo> list;
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("AppletsHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("AppletsHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc7a|OIDBSSOPke.result=" + i3);
                }
            } else {
                i3 = -1;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                oidb_cmd0xc7a$RspBody oidb_cmd0xc7a_rspbody = new oidb_cmd0xc7a$RspBody();
                try {
                    oidb_cmd0xc7a_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AppletsHandler", 2, "onReceive handleGetAppletDetail: onReceive parse fail");
                    }
                    e18.printStackTrace();
                }
                if (oidb_cmd0xc7a_rspbody.wording.has()) {
                    str = oidb_cmd0xc7a_rspbody.wording.get();
                } else {
                    str = "";
                }
                if (oidb_cmd0xc7a_rspbody.next_req_duration.has()) {
                    i16 = oidb_cmd0xc7a_rspbody.next_req_duration.get();
                } else {
                    i16 = 0;
                }
                ((AppletsFolderManager) this.f196698h.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).x(str, i16);
                if (oidb_cmd0xc7a_rspbody.get_uin_info_rsp.has()) {
                    oidb_cmd0xc7a_getuininforsp = oidb_cmd0xc7a_rspbody.get_uin_info_rsp.get();
                } else {
                    oidb_cmd0xc7a_getuininforsp = null;
                }
                if (oidb_cmd0xc7a_getuininforsp != null && oidb_cmd0xc7a_getuininforsp.uin_infos.has()) {
                    list = oidb_cmd0xc7a_getuininforsp.uin_infos.get();
                } else {
                    list = null;
                }
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (oidb_cmd0xc7a$UinInfo oidb_cmd0xc7a_uininfo : list) {
                        AppletsAccountInfo appletsAccountInfo = new AppletsAccountInfo();
                        if (oidb_cmd0xc7a_uininfo.uin.has()) {
                            appletsAccountInfo.uin = String.valueOf(oidb_cmd0xc7a_uininfo.uin.get());
                        }
                        if (oidb_cmd0xc7a_uininfo.face_url.has()) {
                            appletsAccountInfo.faceUrl = oidb_cmd0xc7a_uininfo.face_url.get();
                        }
                        if (oidb_cmd0xc7a_uininfo.face_url_simple.has()) {
                            appletsAccountInfo.faceUrlSimple = oidb_cmd0xc7a_uininfo.face_url_simple.get();
                        }
                        if (oidb_cmd0xc7a_uininfo.nick.has()) {
                            appletsAccountInfo.nick = oidb_cmd0xc7a_uininfo.nick.get();
                        }
                        if (oidb_cmd0xc7a_uininfo.appinfo.has()) {
                            appletsAccountInfo.appInfo = appletsAccountInfo.convertToAppletInfo(oidb_cmd0xc7a_uininfo.appinfo.get());
                        }
                        arrayList.add(appletsAccountInfo);
                    }
                }
                notifyUI(1, true, arrayList);
            }
            notifyUI(1, false, null);
            return;
        }
        notifyUI(1, false, null);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_cmd0xc96$ReqBody oidb_cmd0xc96_reqbody = new oidb_cmd0xc96$ReqBody();
        int i16 = -1;
        try {
            oidb_sso_oidbssopkg.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
            oidb_cmd0xc96_reqbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            i3 = oidb_cmd0xc96_reqbody.cmd_type.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg2.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.w("AppletsHandler", 4, e17.getMessage(), e17);
            } catch (Exception e18) {
                QLog.w("AppletsHandler", 4, e18.getMessage(), e18);
            }
            if (oidb_sso_oidbssopkg2 != null && oidb_sso_oidbssopkg2.uint32_result.has()) {
                i16 = oidb_sso_oidbssopkg2.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc96|OIDBSSOPke.result=" + i16);
                }
            }
            if (i16 == 0 && oidb_sso_oidbssopkg2 != null && oidb_sso_oidbssopkg2.bytes_bodybuffer.has() && oidb_sso_oidbssopkg2.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray();
                if (i3 != 1) {
                    if (i3 == 2) {
                        notifyUI(5, true, byteArray);
                        return;
                    }
                    return;
                }
                notifyUI(4, true, byteArray);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AppletsHandler", 2, "0xc96 fail");
            }
            notifyUI(i3 + 3, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletsHandler", 2, "handleGetAppletPublicAccount res.isSuccess=false");
        }
        notifyUI(i3, false, null);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("AppletsHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("AppletsHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc76|OIDBSSOPke.result=" + i3);
                }
            } else {
                i3 = -1;
            }
            if (toServiceMsg.extraData.getBoolean("public_account_state_changed_flag", false)) {
                if (i3 == 0 && oidb_sso_oidbssopkg != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AppletsHandler", 2, "handle OidbSvc.0xc76|OIDBSSOPke  pubacc report successfully!");
                    }
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    oidb_cmd0xc76$RspBody oidb_cmd0xc76_rspbody = new oidb_cmd0xc76$RspBody();
                    try {
                        oidb_cmd0xc76_rspbody.mergeFrom(byteArray);
                        if (oidb_cmd0xc76_rspbody.cmd.has()) {
                            if (oidb_cmd0xc76_rspbody.cmd.get() == 2) {
                                notifyUI(7, fromServiceMsg.isSuccess(), toServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list"));
                                return;
                            }
                            return;
                        }
                    } catch (InvalidProtocolBufferMicroException e18) {
                        QLog.w("AppletsHandler", 4, e18.getMessage(), e18);
                    } catch (Exception e19) {
                        QLog.w("AppletsHandler", 4, e19.getMessage(), e19);
                    }
                }
                notifyUI(7, false, toServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list"));
                return;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                oidb_cmd0xc76$RspBody oidb_cmd0xc76_rspbody2 = new oidb_cmd0xc76$RspBody();
                try {
                    oidb_cmd0xc76_rspbody2.mergeFrom(byteArray2);
                    if (oidb_cmd0xc76_rspbody2.cmd.has()) {
                        int i16 = oidb_cmd0xc76_rspbody2.cmd.get();
                        if (i16 == 1) {
                            N2(toServiceMsg, fromServiceMsg, oidb_cmd0xc76_rspbody2);
                        } else if (i16 == 2) {
                            P2(toServiceMsg, fromServiceMsg, oidb_cmd0xc76_rspbody2);
                        }
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e26) {
                    QLog.w("AppletsHandler", 4, e26.getMessage(), e26);
                    return;
                } catch (Exception e27) {
                    QLog.w("AppletsHandler", 4, e27.getMessage(), e27);
                    return;
                }
            }
            ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                notifyUI(3, false, parcelableArrayList);
                return;
            } else {
                notifyUI(2, false, null);
                return;
            }
        }
        ArrayList parcelableArrayList2 = toServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
        if (parcelableArrayList2 != null && parcelableArrayList2.size() > 0) {
            notifyUI(3, false, parcelableArrayList2);
        } else {
            notifyUI(2, false, null);
        }
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, oidb_cmd0xc76$RspBody oidb_cmd0xc76_rspbody) {
        ArrayList arrayList = new ArrayList();
        if (oidb_cmd0xc76_rspbody.main.has()) {
            oidb_cmd0xc76$Setting oidb_cmd0xc76_setting = oidb_cmd0xc76_rspbody.main.get();
            ArrayList arrayList2 = new ArrayList();
            com.tencent.mobileqq.applets.data.a aVar = new com.tencent.mobileqq.applets.data.a();
            if (oidb_cmd0xc76_setting.item.has()) {
                for (oidb_cmd0xc76$Item oidb_cmd0xc76_item : oidb_cmd0xc76_setting.item.get()) {
                    AppletItem.b bVar = new AppletItem.b();
                    if (oidb_cmd0xc76_item.f435986id.has()) {
                        bVar.c(oidb_cmd0xc76_item.f435986id.get());
                    }
                    if (oidb_cmd0xc76_item.icon.has()) {
                        bVar.b(oidb_cmd0xc76_item.icon.get());
                    }
                    if (oidb_cmd0xc76_item.type.has()) {
                        bVar.e(oidb_cmd0xc76_item.type.get());
                    }
                    if (oidb_cmd0xc76_item.name.has()) {
                        bVar.d(oidb_cmd0xc76_item.name.get());
                    }
                    if (oidb_cmd0xc76_item.value.has()) {
                        bVar.f(oidb_cmd0xc76_item.value.get());
                    }
                    arrayList2.add(bVar.a());
                }
            }
            aVar.f196768b = arrayList2;
            if (oidb_cmd0xc76_setting.desc.has()) {
                aVar.f196767a = oidb_cmd0xc76_setting.desc.get();
            }
            arrayList.add(aVar);
        }
        if (oidb_cmd0xc76_rspbody.apps.has()) {
            ArrayList arrayList3 = new ArrayList();
            com.tencent.mobileqq.applets.data.a aVar2 = new com.tencent.mobileqq.applets.data.a();
            oidb_cmd0xc76$Setting oidb_cmd0xc76_setting2 = oidb_cmd0xc76_rspbody.apps.get();
            if (oidb_cmd0xc76_setting2.item.has()) {
                for (oidb_cmd0xc76$Item oidb_cmd0xc76_item2 : oidb_cmd0xc76_setting2.item.get()) {
                    AppletItem.b bVar2 = new AppletItem.b();
                    if (oidb_cmd0xc76_item2.f435986id.has()) {
                        bVar2.c(oidb_cmd0xc76_item2.f435986id.get());
                    }
                    if (oidb_cmd0xc76_item2.icon.has()) {
                        bVar2.b(oidb_cmd0xc76_item2.icon.get());
                    }
                    if (oidb_cmd0xc76_item2.type.has()) {
                        bVar2.e(oidb_cmd0xc76_item2.type.get());
                    }
                    if (oidb_cmd0xc76_item2.name.has()) {
                        bVar2.d(oidb_cmd0xc76_item2.name.get());
                    }
                    if (oidb_cmd0xc76_item2.value.has()) {
                        bVar2.f(oidb_cmd0xc76_item2.value.get());
                    }
                    arrayList3.add(bVar2.a());
                }
            }
            aVar2.f196768b = arrayList3;
            if (oidb_cmd0xc76_setting2.desc.has()) {
                aVar2.f196767a = oidb_cmd0xc76_setting2.desc.get();
            }
            arrayList.add(aVar2);
        }
        if (arrayList.size() > 0) {
            notifyUI(2, true, arrayList);
        } else {
            notifyUI(2, false, null);
        }
    }

    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, oidb_cmd0xc76$RspBody oidb_cmd0xc76_rspbody) {
        ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("unreceived_uin_list");
        if (fromServiceMsg.isSuccess()) {
            notifyUI(3, true, parcelableArrayList);
        } else {
            notifyUI(3, false, parcelableArrayList);
        }
    }

    public void E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        oidb_cmd0xc76$ReqBody oidb_cmd0xc76_reqbody = new oidb_cmd0xc76$ReqBody();
        oidb_cmd0xc76_reqbody.cmd.set(1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3190);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc76_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xc76");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void G2(List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        oidb_cmd0xc7a$ReqBody oidb_cmd0xc7a_reqbody = new oidb_cmd0xc7a$ReqBody();
        oidb_cmd0xc7a_reqbody.cmd.set(1);
        oidb_cmd0xc7a$GetUinInfoReq oidb_cmd0xc7a_getuininforeq = new oidb_cmd0xc7a$GetUinInfoReq();
        oidb_cmd0xc7a_getuininforeq.uins.set(list);
        oidb_cmd0xc7a_reqbody.get_uin_info_req.set(oidb_cmd0xc7a_getuininforeq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3194);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc7a_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xc7a");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        synchronized (this.f196696e) {
            this.f196695d.clear();
            this.f196697f.clear();
        }
        notifyUI(8, true, null);
    }

    public void O2(List<MessageRecord> list) {
        Map<String, Integer> D2;
        Integer value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f196696e) {
            for (MessageRecord messageRecord : list) {
                if (!this.f196697f.contains(Long.valueOf(messageRecord.msgUid))) {
                    linkedList.add(messageRecord);
                    this.f196697f.add(Long.valueOf(messageRecord.msgUid));
                }
            }
        }
        if (linkedList.size() >= 1 && (D2 = D2(linkedList)) != null && D2.size() > 0) {
            synchronized (this.f196696e) {
                for (Map.Entry<String, Integer> entry : D2.entrySet()) {
                    String key = entry.getKey();
                    Integer num = this.f196695d.get(key);
                    if (num != null) {
                        value = Integer.valueOf(num.intValue() + entry.getValue().intValue());
                    } else {
                        value = entry.getValue();
                    }
                    this.f196695d.put(key, value);
                }
            }
            notifyUI(8, true, this.f196695d);
        }
    }

    public void Q2(boolean z16, int i3, long j3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        oidb_cmd0xc96$ReqBody oidb_cmd0xc96_reqbody = new oidb_cmd0xc96$ReqBody();
        if (i3 != -1 && j3 != -1) {
            oidb_cmd0xc96_reqbody.app_type.set(i3);
            oidb_cmd0xc96_reqbody.appid.set(j3);
        } else if (j16 != -1) {
            oidb_cmd0xc96_reqbody.puin.set(j16);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AppletsHandler", 2, "report info error, all is none!");
                return;
            }
            return;
        }
        if (z16) {
            oidb_cmd0xc96$FollowExt oidb_cmd0xc96_followext = new oidb_cmd0xc96$FollowExt();
            oidb_cmd0xc96_followext.source_from.set(i16);
            oidb_cmd0xc96$FollowReq oidb_cmd0xc96_followreq = new oidb_cmd0xc96$FollowReq();
            oidb_cmd0xc96_followreq.ext.set(oidb_cmd0xc96_followext);
            oidb_cmd0xc96_reqbody.follow_req.set(oidb_cmd0xc96_followreq);
            oidb_cmd0xc96_reqbody.cmd_type.set(1);
        } else {
            oidb_cmd0xc96$UnFollowExt oidb_cmd0xc96_unfollowext = new oidb_cmd0xc96$UnFollowExt();
            oidb_cmd0xc96_unfollowext.source_from.set(i16);
            oidb_cmd0xc96$UnfollowReq oidb_cmd0xc96_unfollowreq = new oidb_cmd0xc96$UnfollowReq();
            oidb_cmd0xc96_unfollowreq.ext.set(oidb_cmd0xc96_unfollowext);
            oidb_cmd0xc96_reqbody.unfollow_req.set(oidb_cmd0xc96_unfollowreq);
            oidb_cmd0xc96_reqbody.cmd_type.set(2);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3222);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc96_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xc96");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.d("AppletsHandler", 1, "requestGetAppletsMsgUnreadInfo");
        List<MessageRecord> H2 = H2();
        if (H2 != null && H2.size() > 0) {
            Map<String, Integer> D2 = D2(H2);
            if (D2 != null && D2.size() > 0) {
                synchronized (this.f196696e) {
                    this.f196695d.clear();
                    this.f196695d.putAll(D2);
                }
                notifyUI(8, true, this.f196695d);
                return;
            }
            return;
        }
        synchronized (this.f196696e) {
            this.f196695d.clear();
        }
        notifyUI(8, true, null);
    }

    public void S2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            List<MessageRecord> H2 = H2();
            synchronized (this.f196696e) {
                this.f196695d.remove(str);
            }
            if (H2 != null) {
                String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_APPLETS_UIN, QzoneConfig.DEFAULT_APPLETS_UIN);
                int i3 = 0;
                for (MessageRecord messageRecord : H2) {
                    if (str.equals(F2(messageRecord))) {
                        this.f196698h.getMessageFacade().a1(config, 1038, messageRecord.uniseq, AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
                        i3--;
                    }
                }
                if (i3 != 0) {
                    this.f196698h.getConversationFacade().c0(config, 1038, i3);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + str + "  increaseCount: " + i3 + "  unreadMsgList size:" + H2.size());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + str + "  unreadMsgList == null \uff01");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppletsHandler", 2, "setAppletsMsgReadedByAppid: " + str);
        }
    }

    public void T2(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3));
            return;
        }
        ArrayList<AppletItem> arrayList = new ArrayList<>();
        AppletItem.b bVar = new AppletItem.b();
        bVar.d(str2);
        bVar.g(str);
        bVar.f(i3);
        arrayList.add(bVar.a());
        V2(arrayList, true);
    }

    public void U2(ArrayList<AppletItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            V2(arrayList, false);
        }
    }

    public void V2(ArrayList<AppletItem> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        oidb_sso$OIDBSSOPkg I2 = I2(arrayList, z16);
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xc76");
        createToServiceMsg.putWupBuffer(I2.toByteArray());
        if (z16) {
            createToServiceMsg.extraData.putBoolean("public_account_state_changed_flag", true);
            createToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", arrayList);
        } else {
            createToServiceMsg.extraData.putParcelableArrayList("unreceived_uin_list", arrayList);
        }
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xc76");
            this.allowCmdSet.add("OidbSvc.0xc7a");
            this.allowCmdSet.add("OidbSvc.0xc96");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("AppletsHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        if ("OidbSvc.0xc7a".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            K2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xc76".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xc96".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
