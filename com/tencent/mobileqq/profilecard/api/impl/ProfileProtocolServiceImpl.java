package com.tencent.mobileqq.profilecard.api.impl;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import SummaryCard.TCoverInfo;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.handler.ProfileCardHandler;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.profilecard.processor.ProfileBusinessProcessorFactory;
import com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes16.dex */
public class ProfileProtocolServiceImpl implements IProfileProtocolService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardProtocolServiceImpl";
    private AppRuntime appRuntime;
    private ProfileBusinessProcessorFactory processorFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public interface RequestParamAsyncCallback {
        void onResult(boolean z16);
    }

    public ProfileProtocolServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void asyncPutParams(TicketManager ticketManager, long j3, Bundle bundle, RequestParamAsyncCallback requestParamAsyncCallback) {
        if (ticketManager != null && bundle != null && requestParamAsyncCallback != null) {
            ticketManager.getA2(j3, 16, new MainTicketCallback(bundle, requestParamAsyncCallback) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ RequestParamAsyncCallback val$callback;
                final /* synthetic */ Bundle val$params;

                {
                    this.val$params = bundle;
                    this.val$callback = requestParamAsyncCallback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ProfileProtocolServiceImpl.this, bundle, requestParamAsyncCallback);
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onFail(int i3, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    } else {
                        QLog.d(ProfileProtocolServiceImpl.TAG, 1, "initSdk async get login ticket fail errorCode:", Integer.valueOf(i3), ", errorMsg:", str);
                        this.val$callback.onResult(false);
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onSuccess(MainTicketInfo mainTicketInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
                        return;
                    }
                    QLog.i(ProfileProtocolServiceImpl.TAG, 1, "initSdk async get login ticket success");
                    this.val$params.putString(IProfileProtocolConst.PARAM_LOGIN_SIG, mainTicketInfo.getA2());
                    this.val$callback.onResult(true);
                }
            });
        }
    }

    private ProfileCardHandler getProfileCardHandler() {
        return (ProfileCardHandler) ((AppInterface) this.appRuntime).getBusinessHandler(((IProfileHandlerApi) QRoute.api(IProfileHandlerApi.class)).getProfileCardHandler());
    }

    public static ProfileProtocolServiceImpl getProfileProtocolService(AppRuntime appRuntime) {
        return (ProfileProtocolServiceImpl) appRuntime.getRuntimeService(IProfileProtocolService.class, "all");
    }

    private boolean isContactCardResponse(long j3, int i3) {
        if (j3 <= 0 && i3 != 41 && i3 != 6 && i3 != 45) {
            return true;
        }
        return false;
    }

    private void notifyUI(int i3, boolean z16, Object obj) {
        getProfileCardHandler().notifyUI(i3, z16, obj);
    }

    private ContactCard processContactCard(Bundle bundle, RespSummaryCard respSummaryCard) {
        byte[] bArr;
        String string = bundle.getString(IProfileProtocolConst.PARAM_SEARCH_NAME);
        IProfileDataService iProfileDataService = (IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
        boolean z16 = true;
        ContactCard contactCardByMobileNo = iProfileDataService.getContactCardByMobileNo(string, true);
        contactCardByMobileNo.bAge = respSummaryCard.bAge;
        contactCardByMobileNo.bSex = respSummaryCard.bSex;
        contactCardByMobileNo.nickName = respSummaryCard.strNick;
        contactCardByMobileNo.strProvince = respSummaryCard.strProvince;
        contactCardByMobileNo.strCountry = respSummaryCard.strCountry;
        contactCardByMobileNo.strCity = respSummaryCard.strCity;
        contactCardByMobileNo.strContactName = respSummaryCard.strContactName;
        if (respSummaryCard.iContactNotBindQQ == 1) {
            z16 = false;
        }
        contactCardByMobileNo.bindQQ = z16;
        contactCardByMobileNo.vRichSign = respSummaryCard.vRichSign;
        TCoverInfo tCoverInfo = respSummaryCard.stCoverInfo;
        if (tCoverInfo != null) {
            bArr = tCoverInfo.vTagInfo;
        } else {
            bArr = null;
        }
        contactCardByMobileNo.vCoverInfo = bArr;
        long j3 = respSummaryCard.lUIN;
        if (j3 > 0) {
            contactCardByMobileNo.uin = String.valueOf(j3);
        } else {
            contactCardByMobileNo.uin = "";
        }
        iProfileDataService.saveContactCard(contactCardByMobileNo);
        return contactCardByMobileNo;
    }

    private Card processProfileCard(Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard) {
        long j3 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        IProfileDataService iProfileDataService = (IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
        Card profileCard = iProfileDataService.getProfileCard(String.valueOf(j3), true);
        List<AbsProfileBusinessProcessor> businessProcessors = this.processorFactory.getBusinessProcessors(this.appRuntime);
        Iterator<AbsProfileBusinessProcessor> it = businessProcessors.iterator();
        while (it.hasNext()) {
            it.next().onProcessProfileCard(bundle, profileCard, respHead, respSummaryCard);
        }
        ArrayList<byte[]> arrayList = respSummaryCard.vvRespServices;
        if (arrayList != null) {
            try {
                SparseArray<BusinessRespBuffer> parseBusinessRespBuffer = BusinessRespBuffer.parseBusinessRespBuffer(arrayList);
                Iterator<AbsProfileBusinessProcessor> it5 = businessProcessors.iterator();
                while (it5.hasNext()) {
                    it5.next().onProcessProfileService(bundle, profileCard, respHead, respSummaryCard, parseBusinessRespBuffer);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "processProfileCard process service fail.", e16);
            }
        }
        if (respSummaryCard.vResp0x5ebInfo != null) {
            try {
                oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = new oidb_0x5eb$UdcUinData();
                oidb_0x5eb_udcuindata.mergeFrom(respSummaryCard.vResp0x5ebInfo);
                Iterator<AbsProfileBusinessProcessor> it6 = businessProcessors.iterator();
                while (it6.hasNext()) {
                    it6.next().onProcessProfile0x5eb(bundle, profileCard, respHead, respSummaryCard, oidb_0x5eb_udcuindata);
                }
            } catch (Exception e17) {
                QLog.e(TAG, 1, "processProfileCard process 0x5eb fail.", e17);
            }
        }
        iProfileDataService.saveProfileCard(profileCard);
        return profileCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequest(Bundle bundle) {
        if (this.appRuntime != null) {
            NewIntent newIntent = new NewIntent(this.appRuntime.getApplicationContext(), ProfileCardServlet.class);
            newIntent.putExtra(ProfileCardServlet.PARAM_CMD_ID, 1);
            newIntent.putExtras(bundle);
            this.appRuntime.startServlet(newIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor] */
    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public <T extends AbsProfileBusinessProcessor> T getBusinessProcessor(Class<? extends AbsProfileBusinessProcessor> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        T t16 = null;
        for (AbsProfileBusinessProcessor absProfileBusinessProcessor : this.processorFactory.getBusinessProcessors(this.appRuntime)) {
            if (absProfileBusinessProcessor.getClass().equals(cls)) {
                t16 = absProfileBusinessProcessor;
            }
        }
        return t16;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void getProfileDetail(String str, List<Short> list, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, list, Integer.valueOf(i3), bundle);
            return;
        }
        QLog.d(TAG, 2, String.format("getProfileDetail targetUin=%s reqFields=%s serviceType=%s params=%s ", str, Arrays.toString(list.toArray()), Integer.valueOf(i3), bundle));
        try {
            long parseLong = Long.parseLong(str);
            short size = (short) list.size();
            if (bundle == null) {
                bundle = new Bundle();
            }
            ByteBuffer allocate = ByteBuffer.allocate((size * 2) + 7);
            allocate.putInt((int) parseLong);
            allocate.put((byte) 0);
            allocate.putShort(size);
            Iterator<Short> it = list.iterator();
            while (it.hasNext()) {
                allocate.putShort(it.next().shortValue());
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION);
            oidb_sso_oidbssopkg.uint32_service_type.set(i3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ProfileCardHandler profileCardHandler = getProfileCardHandler();
            ToServiceMsg createToServiceMsg = profileCardHandler.createToServiceMsg(IProfileProtocolConst.CMD_GET_PROFILE_DETAIL);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putAll(bundle);
            profileCardHandler.sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getProfileDetail fail.", e16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void getProfileDetailForEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(TAG, 2, "getProfileDetailForEdit");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Short.valueOf(ProfileContants.FIELD_SEX));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_PROFESSION));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_GET_BIRTHDAY));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_COMPANY));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_QZONE_HOMETOWN));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_QZONE_HOMETOWN_DISTRICT));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_QZONE_LOCATION));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_QZONE_LOCATION_DISTRICT));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_EMAIL));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_PERSONAL_NOTE));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_COLLEGE));
        arrayList.add(Short.valueOf(ProfileContants.FIELD_AGE));
        arrayList.add((short) -23408);
        arrayList.add((short) -23213);
        arrayList.add((short) -23196);
        arrayList.add((short) -23180);
        arrayList.add((short) -20368);
        arrayList.add((short) -23175);
        arrayList.add((short) -23169);
        arrayList.add((short) -23159);
        arrayList.add((short) -23364);
        arrayList.add((short) -18352);
        arrayList.add((short) -18349);
        arrayList.add((short) -25222);
        arrayList.add((short) -18335);
        getProfileDetail(this.appRuntime.getCurrentUin(), arrayList, 9, null);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void getProfileDetailForLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d(TAG, 2, "getProfileDetailForLogin");
        ArrayList arrayList = new ArrayList();
        Iterator<AbsProfileBusinessProcessor> it = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
        while (it.hasNext()) {
            it.next().onGetProfileDetailRequestForLogin(arrayList);
        }
        getProfileDetail(this.appRuntime.getCurrentUin(), arrayList, 9, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
            this.processorFactory = new ProfileBusinessProcessorFactory();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void requestProfileCard(String str, String str2, int i3, long j3, byte b16, long j16, long j17, byte[] bArr, String str3, long j18, int i16, byte[] bArr2, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Byte.valueOf(b16), Long.valueOf(j16), Long.valueOf(j17), bArr, str3, Long.valueOf(j18), Integer.valueOf(i16), bArr2, Byte.valueOf(b17));
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            long parseLong2 = Long.parseLong(str2);
            Bundle bundle = new Bundle();
            bundle.putLong("selfUin", parseLong);
            bundle.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, parseLong2);
            bundle.putInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE, i3);
            bundle.putLong(IProfileProtocolConst.PARAM_QZONE_FEED_TIMESTAMP, j3);
            bundle.putByte(IProfileProtocolConst.PARAM_IS_FRIEND, b16);
            bundle.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j16);
            bundle.putLong("troopUin", j17);
            bundle.putByteArray(IProfileProtocolConst.PARAM_QZONE_SEED, bArr);
            bundle.putString(IProfileProtocolConst.PARAM_SEARCH_NAME, str3);
            bundle.putLong(IProfileProtocolConst.PARAM_GET_CONTROL, j18);
            bundle.putInt("addFriendSource", i16);
            bundle.putByteArray(IProfileProtocolConst.PARAM_SECURE_SIG, bArr2);
            bundle.putByte(IProfileProtocolConst.PARAM_REQ_MEDAL, b17);
            bundle.putByte(IProfileProtocolConst.PARAM_REQ_EXTEND, (byte) 1);
            requestProfileCard(bundle);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "requestProfileCard fail.", e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x020f A[LOOP:1: B:18:0x0209->B:20:0x020f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fa  */
    /* JADX WARN: Type inference failed for: r19v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void responseGetProfileDetail(Bundle bundle, boolean z16, int i3, Object obj) {
        String str;
        int i16;
        boolean z17;
        boolean z18;
        boolean z19;
        Card card;
        Card card2;
        Iterator<AbsProfileBusinessProcessor> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        char c16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, bundle, Boolean.valueOf(z16), Integer.valueOf(i3), obj);
            return;
        }
        List<AbsProfileBusinessProcessor> businessProcessors = this.processorFactory.getBusinessProcessors(this.appRuntime);
        Iterator<AbsProfileBusinessProcessor> it5 = businessProcessors.iterator();
        while (it5.hasNext()) {
            it5.next().onGetProfileDetailResponseBegin(bundle);
        }
        String str2 = TAG;
        Card card3 = null;
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.has()) {
                        try {
                            int i18 = mergeFrom.uint32_result.get();
                            if (i18 == 0) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            i16 = i18;
                            z19 = z18;
                        } catch (Exception e16) {
                            e = e16;
                            i16 = i3;
                            str = str2;
                            QLog.e(str, 1, "responseGetProfileCard fail.", e);
                            if (card3 == null) {
                                card3 = new Card();
                            }
                            z17 = false;
                            it = businessProcessors.iterator();
                            while (it.hasNext()) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            notifyUI(1002, z17, card3);
                        }
                    } else {
                        i16 = i3;
                        z19 = false;
                    }
                    if (z19) {
                        try {
                            ByteBuffer wrap = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                            Long valueOf = Long.valueOf(Utils.P(wrap.getInt()));
                            wrap.get();
                            short s16 = wrap.getShort();
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, String.format("responseGetProfileCard uin=%s tlvCount=%s", valueOf, Short.valueOf(s16)));
                            }
                            IProfileDataService iProfileDataService = (IProfileDataService) this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
                            Card profileCard = iProfileDataService.getProfileCard(String.valueOf(valueOf), true);
                            try {
                                Iterator<AbsProfileBusinessProcessor> it6 = businessProcessors.iterator();
                                while (it6.hasNext()) {
                                    try {
                                        it6.next().onGetProfileDetailTLVBegin(bundle, valueOf.longValue(), profileCard);
                                    } catch (Exception e17) {
                                        e = e17;
                                        card3 = profileCard;
                                        str = str2;
                                        QLog.e(str, 1, "responseGetProfileCard fail.", e);
                                        if (card3 == null) {
                                        }
                                        z17 = false;
                                        it = businessProcessors.iterator();
                                        while (it.hasNext()) {
                                        }
                                        if (QLog.isColorLevel()) {
                                        }
                                        notifyUI(1002, z17, card3);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        card3 = profileCard;
                                        if (card3 == null) {
                                        }
                                        throw th;
                                    }
                                }
                                int position = wrap.position();
                                short s17 = 0;
                                while (wrap.hasRemaining()) {
                                    ?? r19 = s17 + 1;
                                    if (s17 >= s16) {
                                        break;
                                    }
                                    try {
                                        wrap.position(position);
                                        short s18 = wrap.getShort();
                                        short s19 = wrap.getShort();
                                        int position2 = wrap.position() + s19;
                                        if (QLog.isColorLevel()) {
                                            Object[] objArr = new Object[i17];
                                            objArr[c16] = Short.valueOf(s18);
                                            objArr[1] = Short.valueOf(s19);
                                            objArr[2] = Integer.valueOf(position2);
                                            QLog.d(str2, 2, String.format("responseGetProfileCard K=%s, L=%s, nextTLVPosition=%s", objArr));
                                        }
                                        Iterator<AbsProfileBusinessProcessor> it7 = businessProcessors.iterator();
                                        while (it7.hasNext()) {
                                            card2 = profileCard;
                                            IProfileDataService iProfileDataService2 = iProfileDataService;
                                            short s26 = s16;
                                            str = str2;
                                            try {
                                                it7.next().onGetProfileDetailTLV(bundle, valueOf.longValue(), profileCard, s18, s19, wrap);
                                                profileCard = card2;
                                                iProfileDataService = iProfileDataService2;
                                                str2 = str;
                                                s16 = s26;
                                                i17 = 3;
                                                c16 = 0;
                                            } catch (Exception e18) {
                                                e = e18;
                                                card3 = card2;
                                                QLog.e(str, 1, "responseGetProfileCard fail.", e);
                                                if (card3 == null) {
                                                }
                                                z17 = false;
                                                it = businessProcessors.iterator();
                                                while (it.hasNext()) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                notifyUI(1002, z17, card3);
                                            } catch (Throwable th6) {
                                                th = th6;
                                                card3 = card2;
                                                if (card3 == null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        s17 = r19;
                                        position = position2;
                                    } catch (Exception e19) {
                                        e = e19;
                                        card2 = profileCard;
                                        str = str2;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        card2 = profileCard;
                                    }
                                }
                                Card card4 = profileCard;
                                IProfileDataService iProfileDataService3 = iProfileDataService;
                                str = str2;
                                try {
                                    Iterator<AbsProfileBusinessProcessor> it8 = businessProcessors.iterator();
                                    while (it8.hasNext()) {
                                        card = card4;
                                        try {
                                            it8.next().onGetProfileDetailTLVEnd(bundle, valueOf.longValue(), card);
                                            card4 = card;
                                        } catch (Exception e26) {
                                            e = e26;
                                            card3 = card;
                                            QLog.e(str, 1, "responseGetProfileCard fail.", e);
                                            if (card3 == null) {
                                            }
                                            z17 = false;
                                            it = businessProcessors.iterator();
                                            while (it.hasNext()) {
                                            }
                                            if (QLog.isColorLevel()) {
                                            }
                                            notifyUI(1002, z17, card3);
                                        } catch (Throwable th8) {
                                            th = th8;
                                            card3 = card;
                                            if (card3 == null) {
                                                new Card();
                                            }
                                            throw th;
                                        }
                                    }
                                    card = card4;
                                    if (bundle.getBoolean(IProfileProtocolConst.KEY_PARSE_PROFILE_LOCATION)) {
                                        Iterator<AbsProfileBusinessProcessor> it9 = businessProcessors.iterator();
                                        while (it9.hasNext()) {
                                            it9.next().requestParseProfileLocation(card);
                                        }
                                    }
                                    iProfileDataService3.saveProfileCard(card);
                                    card3 = card;
                                } catch (Exception e27) {
                                    e = e27;
                                    card = card4;
                                } catch (Throwable th9) {
                                    th = th9;
                                    card = card4;
                                }
                            } catch (Exception e28) {
                                e = e28;
                                card = profileCard;
                                str = str2;
                            } catch (Throwable th10) {
                                th = th10;
                                card = profileCard;
                            }
                        } catch (Exception e29) {
                            e = e29;
                        }
                    } else {
                        str = TAG;
                    }
                    if (card3 == null) {
                        card3 = new Card();
                    }
                    z17 = z19;
                } catch (Exception e36) {
                    e = e36;
                    str = TAG;
                    i16 = i3;
                }
            } else {
                str = TAG;
                z17 = z16;
                i16 = i3;
            }
            it = businessProcessors.iterator();
            while (it.hasNext()) {
                it.next().onGetProfileDetailResponseEnd(bundle, z17, card3);
            }
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, String.format("responseGetProfileCard success=%s resultCode=%s", Boolean.valueOf(z17), Integer.valueOf(i16)));
            }
            notifyUI(1002, z17, card3);
        } catch (Throwable th11) {
            th = th11;
        }
    }

    public void responseProfileCard(Bundle bundle, RespHead respHead, RespSummaryCard respSummaryCard) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, bundle, respHead, respSummaryCard);
            return;
        }
        if (respHead != null && respSummaryCard != null && respHead.iResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = bundle.getLong("selfUin");
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        int i3 = bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE);
        String string = bundle.getString(IProfileProtocolConst.PARAM_SEARCH_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("responseProfileCard selfUin=%s targetUin=%s comeFromType=%s success=%s", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        Iterator<AbsProfileBusinessProcessor> it = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
        while (it.hasNext()) {
            it.next().onResponseProfileCard(z16, bundle, respHead, respSummaryCard);
        }
        if (z16) {
            if (isContactCardResponse(j16, i3)) {
                notifyUI(1001, true, processContactCard(bundle, respSummaryCard));
                return;
            } else {
                notifyUI(1001, true, processProfileCard(bundle, respHead, respSummaryCard));
                return;
            }
        }
        if (j16 > 0) {
            string = String.valueOf(j16);
        }
        if (respHead != null) {
            QLog.e(TAG, 1, "getCardInfo error , code: " + respHead.iResult);
        }
        notifyUI(1001, false, string);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void setProfileDetail(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else {
            getProfileCardHandler().setProfileDetail(bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileProtocolService
    public void requestProfileCard(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        long j3 = bundle.getLong("selfUin");
        long j16 = bundle.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        int i3 = bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("requestProfileCard selfUin=%s targetUin=%s comeFromType=%s", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3)));
        }
        ArrayList<BusinessReqBuffer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Iterator<AbsProfileBusinessProcessor> it = this.processorFactory.getBusinessProcessors(this.appRuntime).iterator();
        while (it.hasNext()) {
            it.next().onRequestProfileCard(bundle, arrayList, arrayList2);
        }
        bundle.putParcelableArrayList(IProfileProtocolConst.PARAM_REQ_SERVICES, arrayList);
        bundle.putIntegerArrayList(IProfileProtocolConst.PARAM_REQ_0X5EB, arrayList2);
        TicketManager ticketManager = (TicketManager) this.appRuntime.getManager(2);
        if (ticketManager != null) {
            if (!ticketManager.useAsyncTicketInterface()) {
                bundle.putString(IProfileProtocolConst.PARAM_LOGIN_SIG, ticketManager.getA2(String.valueOf(j3)));
                QLog.d(TAG, 1, "requestProfileCard send request");
                sendRequest(bundle);
                return;
            }
            asyncPutParams(ticketManager, j3, bundle, new RequestParamAsyncCallback(bundle) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bundle val$params;

                {
                    this.val$params = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileProtocolServiceImpl.this, (Object) bundle);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.api.impl.ProfileProtocolServiceImpl.RequestParamAsyncCallback
                public void onResult(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    } else {
                        QLog.d(ProfileProtocolServiceImpl.TAG, 1, "requestProfileCard async param result:", Boolean.valueOf(z16));
                        ProfileProtocolServiceImpl.this.sendRequest(this.val$params);
                    }
                }
            });
            return;
        }
        QLog.w(TAG, 1, "requestProfileCard ticketManager null");
        sendRequest(bundle);
    }
}
