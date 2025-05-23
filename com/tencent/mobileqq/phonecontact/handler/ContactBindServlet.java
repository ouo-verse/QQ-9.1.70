package com.tencent.mobileqq.phonecontact.handler;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.CompressedPackage;
import SecurityAccountServer.LastLoginInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RequestBindMobileV2;
import SecurityAccountServer.RequestCancelBindMobile;
import SecurityAccountServer.RequestDisableMobileBind;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RequestHideContact;
import SecurityAccountServer.RequestQueryLastLoginState;
import SecurityAccountServer.RequestQueryNewUserRecommendedList;
import SecurityAccountServer.RequestQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.RequestQueryQQBindingStat;
import SecurityAccountServer.RequestQueryQQMobileContactsV2;
import SecurityAccountServer.RequestQueryQQMobileContactsV3;
import SecurityAccountServer.RequestReBindMblWTLogin;
import SecurityAccountServer.RequestReBindMobile;
import SecurityAccountServer.RequestResendSmscode;
import SecurityAccountServer.RequestUpdateAddressBook;
import SecurityAccountServer.RequestUpdateAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBook;
import SecurityAccountServer.RequestUploadAddressBookNotBind;
import SecurityAccountServer.RequestUploadAddressBookV2;
import SecurityAccountServer.RequestVerifySmscode;
import SecurityAccountServer.RequestVerifyWTLogin;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponeBindMobileV2;
import SecurityAccountServer.ResponeQueryLastLoginState;
import SecurityAccountServer.ResponeQueryNewUserRecommendedList;
import SecurityAccountServer.ResponeQueryNewUserRecommendedListNotBind;
import SecurityAccountServer.ResponeQueryQQMobileContactsV3;
import SecurityAccountServer.ResponeReBindMobile;
import SecurityAccountServer.ResponeUpdateAddressBook;
import SecurityAccountServer.ResponeUpdateAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBook;
import SecurityAccountServer.ResponeUploadAddressBookNotBind;
import SecurityAccountServer.ResponeUploadAddressBookV2;
import SecurityAccountServer.ResponseReBindMblWTLogin;
import SecurityAccountServer.ResponseVerifyWTLogin;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchGetContactServlet;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.phonecontact.observer.b;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.phonecontact.util.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactBindServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IPhoneContactService f258475d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f258476e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f258477f;

    /* renamed from: h, reason: collision with root package name */
    private int[] f258478h;

    public ContactBindServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258476e = false;
        this.f258477f = false;
        this.f258478h = new int[0];
    }

    private void A(Bundle bundle, NewIntent newIntent) {
        if (bundle != null && newIntent != null) {
            List<AddressBookItem> list = (List) bundle.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
            D(list);
            newIntent.putExtra(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST, new ArrayList(list));
        }
    }

    public static void B(AppInterface appInterface, byte[] bArr, String str) {
        NewIntent newIntent = new NewIntent(appInterface.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 27);
        newIntent.putExtra("cmd_param_phone_bind_sign", bArr);
        newIntent.putExtra("cmd_param_phone_uin", str);
        newIntent.setWithouLogin(true);
        appInterface.startServlet(newIntent);
    }

    private void C(AddressBookItem addressBookItem) {
        if (!e.a() || addressBookItem == null) {
            return;
        }
        addressBookItem.name = "isNull";
    }

    private void E(ResponeQueryQQMobileContactsV3 responeQueryQQMobileContactsV3) {
        RespondQueryQQBindingStat respondQueryQQBindingStat = new RespondQueryQQBindingStat();
        respondQueryQQBindingStat.nationCode = responeQueryQQMobileContactsV3.nationCode;
        respondQueryQQBindingStat.mobileNo = responeQueryQQMobileContactsV3.mobileNo;
        respondQueryQQBindingStat.MobileUniqueNo = responeQueryQQMobileContactsV3.MobileUniqueNo;
        respondQueryQQBindingStat.isRecommend = responeQueryQQMobileContactsV3.isRecommend;
        respondQueryQQBindingStat.originBinder = responeQueryQQMobileContactsV3.originBinder;
        respondQueryQQBindingStat.bindingTime = responeQueryQQMobileContactsV3.bindingTime;
        respondQueryQQBindingStat.lastUsedFlag = responeQueryQQMobileContactsV3.lastUsedFlag;
        respondQueryQQBindingStat.type = responeQueryQQMobileContactsV3.type;
        respondQueryQQBindingStat.isStopFindMatch = responeQueryQQMobileContactsV3.isInactive;
        respondQueryQQBindingStat.isPhoneSwitched = responeQueryQQMobileContactsV3.isChangeDev;
        respondQueryQQBindingStat.noBindUploadContacts = responeQueryQQMobileContactsV3.noBindUploadContacts;
        f().saveBindInfo(respondQueryQQBindingStat, "saveBindStatAndBindStrategy");
        f().saveQueryInterval(responeQueryQQMobileContactsV3.nextQueryTimeInterval * 1000, responeQueryQQMobileContactsV3.nextReLoginTimeInterval * 1000, responeQueryQQMobileContactsV3.nextReconnectionTimeInterval * 1000);
    }

    private UniPacket b(FromServiceMsg fromServiceMsg) {
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.decode(fromServiceMsg.getWupBuffer());
        return uniPacket;
    }

    public static RequestHeader c(int i3, int i16, int i17) {
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.ver = 100;
        requestHeader.cmd = i3;
        requestHeader.requestID = i16;
        requestHeader.svrSeqNo = i17;
        requestHeader.account = "";
        requestHeader.appid = 0;
        requestHeader.sbid = "";
        requestHeader.channel_id = "";
        requestHeader.ksid = "";
        requestHeader.uin = 0L;
        return requestHeader;
    }

    private ResponeQueryQQMobileContactsV3 e(UniPacket uniPacket) {
        byte[] bArr;
        CompressedPackage compressedPackage = (CompressedPackage) uniPacket.getByClass("CompressedPackage", new CompressedPackage());
        if (compressedPackage != null) {
            ResponeQueryQQMobileContactsV3 responeQueryQQMobileContactsV3 = new ResponeQueryQQMobileContactsV3();
            if (compressedPackage.compressed) {
                bArr = z(compressedPackage.buffer);
            } else {
                bArr = compressedPackage.buffer;
            }
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf-8");
            responeQueryQQMobileContactsV3.readFrom(jceInputStream);
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "getRspQueryContacts_v3 | compress != null | read from JceInputStream");
                return responeQueryQQMobileContactsV3;
            }
            return responeQueryQQMobileContactsV3;
        }
        return (ResponeQueryQQMobileContactsV3) uniPacket.getByClass("ResponeQueryQQMobileContactsV3", new ResponeQueryQQMobileContactsV3());
    }

    private IPhoneContactService f() {
        if (this.f258475d == null) {
            this.f258475d = (IPhoneContactService) getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
        }
        return this.f258475d;
    }

    private void g(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeBindMobileV2 responeBindMobileV2 = (ResponeBindMobileV2) b16.getByClass("ResponeBindMobileV2", new ResponeBindMobileV2());
            f().updateSessionId(responeBindMobileV2.sessionSid);
            Bundle bundle = new Bundle();
            bundle.putInt(b.KEY_RESULT, respondHeader.result);
            bundle.putBoolean(b.KEY_AUTO_BIND, responeBindMobileV2.bindSuccess);
            int i3 = respondHeader.result;
            if (i3 == 107) {
                bundle.putString(b.KEY_UIN, responeBindMobileV2.alreadyBindedUin);
            } else if (i3 == 106) {
                bundle.putString(b.KEY_UIN, "");
            }
            notifyObserver(intent, 35, true, bundle, b.class);
            return;
        }
        notifyObserver(intent, 35, false, null, b.class);
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.isSuccess()) {
            int i3 = ((RespondHeader) decodePacket(fromServiceMsg.getWupBuffer(), com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader())).result;
            if (i3 != 0 && i3 != 105) {
                notifyObserver(intent, 20, false, null, b.class);
                return;
            } else {
                f().saveBindInfo(null, "handleCancelBind");
                notifyObserver(intent, 20, true, null, b.class);
                return;
            }
        }
        notifyObserver(intent, 20, false, null, b.class);
    }

    private void i(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.i("IMCore.PhoneContact.ContactBindServlet", 2, "handleDisableMobileBind");
        }
        if (fromServiceMsg.isSuccess()) {
            if (((RespondHeader) decodePacket(fromServiceMsg.getWupBuffer(), com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader())).result == 0) {
                f().OnDisableMobileBindSuc();
                notifyObserver(intent, 33, true, null, b.class);
                return;
            } else {
                notifyObserver(intent, 33, false, null, b.class);
                return;
            }
        }
        notifyObserver(intent, 33, false, null, b.class);
    }

    private void j(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            if (respondHeader == null) {
                notifyObserver(intent, 26, false, bundle, b.class);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleGetBindUinWithPhone respHeader.result =" + respondHeader.result);
            }
            int i3 = respondHeader.result;
            boolean z16 = true;
            boolean z17 = false;
            if (i3 == 107) {
                str = String.valueOf(((ResponseVerifyWTLogin) b16.getByClass("ResponseVerifyWTLogin", new ResponseVerifyWTLogin())).preBindUin);
                z17 = true;
                z16 = false;
            } else {
                str = null;
                if (i3 != 0) {
                    z16 = false;
                }
            }
            bundle.putBoolean("bindOK", z16);
            bundle.putBoolean("hadBind", z17);
            bundle.putString("bindUin", str);
            notifyObserver(intent, 26, true, bundle, b.class);
            return;
        }
        notifyObserver(intent, 26, false, bundle, b.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        ArrayList<? extends Parcelable> arrayList;
        ArrayList<RecommendedContactInfo> arrayList2;
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            if (respondHeader != null && respondHeader.result == 0 && (arrayList2 = ((ResponeQueryNewUserRecommendedList) b16.getByClass("ResponeQueryNewUserRecommendedList", new ResponeQueryNewUserRecommendedList())).RecommendedContacts) != null && arrayList2.size() > 0) {
                arrayList = new ArrayList<>();
                for (RecommendedContactInfo recommendedContactInfo : arrayList2) {
                    RecommendContactInfo recommendContactInfo = new RecommendContactInfo(recommendedContactInfo);
                    if (d(recommendedContactInfo, recommendContactInfo)) {
                        arrayList.add(recommendContactInfo);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleGetNewer origin: " + arrayList2.size() + ", handled: " + arrayList.size());
                }
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleGetNewerGuideRecommended " + z16);
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), arrayList);
                notifyObserver(intent, 36, true, bundle, b.class);
            }
        }
        z16 = false;
        arrayList = null;
        if (QLog.isColorLevel()) {
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), arrayList);
        notifyObserver(intent, 36, true, bundle2, b.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        ArrayList<? extends Parcelable> arrayList;
        ArrayList<RecommendedContactInfo> arrayList2;
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            if (respondHeader != null && respondHeader.result == 0 && (arrayList2 = ((ResponeQueryNewUserRecommendedListNotBind) b16.getByClass("ResponeQueryNewUserRecommendedListNotBind", new ResponeQueryNewUserRecommendedListNotBind())).RecommendedContacts) != null && arrayList2.size() > 0) {
                arrayList = new ArrayList<>();
                for (RecommendedContactInfo recommendedContactInfo : arrayList2) {
                    RecommendContactInfo recommendContactInfo = new RecommendContactInfo(recommendedContactInfo);
                    if (d(recommendedContactInfo, recommendContactInfo)) {
                        arrayList.add(recommendContactInfo);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleGetNewerGuideRecommendedNotBind origin: " + arrayList2.size() + ", handled: " + arrayList.size());
                }
                z16 = true;
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleGetNewerGuideRecommendedNotBind " + z16);
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), arrayList);
                notifyObserver(intent, 40, true, bundle, b.class);
            }
        }
        z16 = false;
        arrayList = null;
        if (QLog.isColorLevel()) {
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(RecommendContactInfo.class.getSimpleName(), arrayList);
        notifyObserver(intent, 40, true, bundle2, b.class);
    }

    private void m(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess()) {
            RespondHeader respondHeader = (RespondHeader) b(fromServiceMsg).getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            if (respondHeader == null) {
                notifyObserver(intent, 34, false, bundle, b.class);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleHideContact respHeader.result =" + respondHeader.result);
            }
            if (respondHeader.result == 0) {
                f().changeHidenStatus(intent.getStringExtra("unique_phone_no"), intent.getBooleanExtra("param_hiden_flag", false));
                notifyObserver(intent, 34, true, bundle, b.class);
                return;
            }
            notifyObserver(intent, 34, false, bundle, b.class);
            return;
        }
        notifyObserver(intent, 34, false, bundle, b.class);
    }

    private void n(Intent intent, FromServiceMsg fromServiceMsg) {
        RespondQueryQQBindingStat respondQueryQQBindingStat;
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            if (((RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader())).result == 105) {
                bundle.putBoolean("bind_state", false);
                respondQueryQQBindingStat = null;
            } else {
                respondQueryQQBindingStat = (RespondQueryQQBindingStat) b16.getByClass("RespondQueryQQBindingStat", new RespondQueryQQBindingStat());
                bundle.putBoolean("bind_state", true);
            }
            f().saveBindInfo(respondQueryQQBindingStat, "handleQueryBindState");
            notifyObserver(intent, 12, true, bundle, b.class);
            return;
        }
        notifyObserver(intent, 12, false, null, b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isDestroyed = f().isDestroyed();
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "Query contact v3 resp, " + fromServiceMsg.isSuccess() + " isMgrDestroyed = " + isDestroyed);
        }
        if (isDestroyed) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeQueryQQMobileContactsV3 e16 = e(b16);
            if (respondHeader != null && e16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "after get respHeader | result = " + respondHeader.result);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleQueryContactV3 isInactive " + e16.isInactive + ", " + e16.isChangeDev);
                }
                int i3 = intent.getExtras().getInt("query_package_no", 0);
                int i16 = intent.getExtras().getInt("param_update_flag", 0);
                long j3 = intent.getExtras().getLong("param_query_from");
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, String.format("handleQueryContactV3 pno:%s, flag:%s, from:%s, state: %s", Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(intent.getExtras().getInt("param_bind_state"))));
                }
                int i17 = respondHeader.result;
                if (i17 == 0) {
                    E(e16);
                    IPhoneContactService f16 = f();
                    long j16 = e16.nextFlag;
                    if (e16.queryFlag == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    int saveContactFromServer = i16 | f16.saveContactFromServer(false, i3, j16, z18, e16.timeStamp, e16.MaxsignTimeStamp, e16.BindFriendContacts, e16.BindNotFriendContacts);
                    if (e16.nextFlag != 4294967295L) {
                        int bindStateForServer = f().getBindStateForServer();
                        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
                        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 30);
                        z17 = true;
                        newIntent.putExtra("query_package_no", i3 + 1);
                        newIntent.putExtra("next_flag", e16.nextFlag);
                        newIntent.putExtra("time_stamp", e16.timeStamp);
                        newIntent.putExtra("richinfo_time_stamp", e16.MaxsignTimeStamp);
                        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, e16.sessionSid);
                        newIntent.putExtra("force_query_list", e16.queryFlag);
                        newIntent.putExtra("param_update_flag", saveContactFromServer);
                        newIntent.putExtra("unique_phone_no", intent.getExtras().getString("unique_phone_no"));
                        newIntent.putExtra("param_query_from", j3);
                        newIntent.putExtra("param_bind_state", bindStateForServer);
                        newIntent.setObserver(((NewIntent) intent).getObserver());
                        getAppRuntime().startServlet(newIntent);
                    } else {
                        z17 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "Query contact finish.");
                        }
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("bind_state", true);
                        bundle.putLong("param_query_from", j3);
                        notifyObserver(intent, 12, true, bundle, b.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("param_update_flag", saveContactFromServer);
                        notifyObserver(intent, 30, true, bundle2, b.class);
                    }
                } else {
                    z17 = true;
                    if (i17 != 105 && i17 != 107) {
                        notifyObserver(intent, 12, false, null, b.class);
                    } else {
                        E(e16);
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean("bind_state", false);
                        bundle3.putLong("param_query_from", j3);
                        notifyObserver(intent, 12, true, bundle3, b.class);
                        f().saveUIBits(e16.UIBits);
                        z16 = z17;
                        if (!z16) {
                            notifyObserver(intent, 12, false, null, b.class);
                            if (f().getSelfBindState() == 9) {
                                notifyObserver(intent, 30, false, null, b.class);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                f().saveUIBits(e16.UIBits);
                z16 = z17;
                if (!z16) {
                }
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    private void p(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        if (f().isDestroyed()) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            Bundle extras = intent.getExtras();
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeQueryLastLoginState responeQueryLastLoginState = (ResponeQueryLastLoginState) b16.getByClass("ResponeQueryLastLoginState", new ResponeQueryLastLoginState());
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder(100);
                sb5.append("handleLastLogin, nextflag = ");
                sb5.append(responeQueryLastLoginState.nextFlag);
                sb5.append(", result = ");
                sb5.append(respondHeader.result);
                sb5.append(", lastUsedFlag = ");
                sb5.append(responeQueryLastLoginState.lastUsedFlag);
                sb5.append(", mobile = ");
                if (!TextUtils.isEmpty(responeQueryLastLoginState.mobileNo) && !TextUtils.isEmpty(responeQueryLastLoginState.nationCode)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, sb5.toString());
            }
            if (respondHeader.result == 0 && !TextUtils.isEmpty(responeQueryLastLoginState.mobileNo) && !TextUtils.isEmpty(responeQueryLastLoginState.nationCode) && responeQueryLastLoginState.lastUsedFlag == 1) {
                ArrayList<String> stringArrayList = extras.getStringArrayList("param_last_login_list");
                if (stringArrayList == null) {
                    stringArrayList = new ArrayList<>();
                }
                ArrayList<String> arrayList = stringArrayList;
                if (responeQueryLastLoginState.lastLoginList.size() > 0) {
                    arrayList.ensureCapacity(arrayList.size() + responeQueryLastLoginState.lastLoginList.size());
                    Iterator<LastLoginInfo> it = responeQueryLastLoginState.lastLoginList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().contactsInfoEncrypt);
                    }
                }
                if (responeQueryLastLoginState.nextFlag != 4294967295L) {
                    NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
                    newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 32);
                    newIntent.putExtra("next_flag", responeQueryLastLoginState.nextFlag);
                    newIntent.putExtra("time_stamp", responeQueryLastLoginState.timeStamp);
                    newIntent.putExtra("unique_phone_no", extras.getString("unique_phone_no"));
                    newIntent.putExtra("param_last_login_list", arrayList);
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                f().saveLastLoginList(arrayList, responeQueryLastLoginState.timeStamp, responeQueryLastLoginState.interval);
                notifyObserver(intent, 32, true, null, b.class);
                return;
            }
            notifyObserver(intent, 32, false, null, b.class);
            return;
        }
        notifyObserver(intent, 32, false, null, b.class);
    }

    private void q(Intent intent, FromServiceMsg fromServiceMsg) {
        if (f().isDestroyed()) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            f().updateSessionId(((ResponeReBindMobile) b16.getByClass("ResponeReBindMobile", new ResponeReBindMobile())).sessionSid);
            Bundle bundle = new Bundle();
            bundle.putInt(b.KEY_RESULT, respondHeader.result);
            int i3 = respondHeader.result;
            if (i3 != 0 && i3 != 104) {
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "BindNumberBusiness  rebind failed ,\u8fd4\u56de\u7801\u4e0d\u6b63\u786e");
                }
                notifyObserver(intent, 19, false, bundle, b.class);
                return;
            }
            notifyObserver(intent, 19, true, bundle, b.class);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "BindNumberBusiness  rebind failed ,response isSuccess = false");
        }
        notifyObserver(intent, 19, false, null, b.class);
    }

    private void r(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.isSuccess()) {
            if (((RespondHeader) decodePacket(fromServiceMsg.getWupBuffer(), com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader())).result == 0) {
                notifyObserver(intent, 17, true, null, b.class);
                return;
            } else {
                notifyObserver(intent, 17, false, null, b.class);
                return;
            }
        }
        notifyObserver(intent, 17, false, null, b.class);
    }

    private void s(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 15);
        newIntent.putExtra("unique_phone_no", extras.getString("unique_phone_no"));
        int i17 = extras.getInt("upload_package_no");
        if (f().isDestroyed()) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeUpdateAddressBook responeUpdateAddressBook = (ResponeUpdateAddressBook) b16.getByClass("ResponeUpdateAddressBook", new ResponeUpdateAddressBook());
            int i18 = respondHeader.result;
            if (i18 == 0) {
                ArrayList arrayList = (ArrayList) extras.getSerializable("add_contact_list");
                int i19 = i17 * 50;
                if (i19 < arrayList.size()) {
                    int i26 = i19 + 50;
                    if (i26 > arrayList.size()) {
                        i26 = arrayList.size();
                    }
                    f().markUploadedContact(arrayList.subList(i19, i26));
                }
                long j3 = responeUpdateAddressBook.nextFlag;
                if (j3 != 4294967295L) {
                    newIntent.putExtra("next_flag", j3);
                    newIntent.putExtra("upload_package_no", i17 + 1);
                    newIntent.putExtra("add_contact_list", (ArrayList) extras.getSerializable("add_contact_list"));
                    newIntent.putExtra("del_contact_list", (ArrayList) extras.getSerializable("del_contact_list"));
                    newIntent.putExtra("rename_contact_list", (ArrayList) extras.getSerializable("rename_contact_list"));
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUpdateAddressBook.sessionSid);
                    newIntent.putExtra("is_resend", false);
                    newIntent.setObserver(((NewIntent) intent).getObserver());
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                notifyObserver(intent, 15, true, null, b.class);
                if (extras.containsKey("add_contact_list")) {
                    ArrayList<PhoneContact> arrayList2 = (ArrayList) extras.getSerializable("rename_contact_list");
                    if (arrayList2.size() == 0) {
                        return;
                    }
                    f().updateRenameList(arrayList2);
                    return;
                }
                return;
            }
            if (i18 == 105) {
                f().saveBindInfo(null, "handleUpdateContact");
                Bundle bundle = new Bundle();
                bundle.putInt("param_fail_reason", 1);
                notifyObserver(intent, 15, false, bundle, b.class);
                return;
            }
            if (extras.getBoolean("is_resend")) {
                Bundle bundle2 = new Bundle();
                if (i17 == 0) {
                    i16 = 2;
                } else {
                    i16 = 3;
                }
                bundle2.putInt("param_fail_reason", i16);
                notifyObserver(intent, 15, false, bundle2, b.class);
                return;
            }
            newIntent.putExtra("next_flag", responeUpdateAddressBook.nextFlag);
            newIntent.putExtra("upload_package_no", i17);
            newIntent.putExtra("add_contact_list", (ArrayList) extras.getSerializable("add_contact_list"));
            newIntent.putExtra("del_contact_list", (ArrayList) extras.getSerializable("del_contact_list"));
            newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUpdateAddressBook.sessionSid);
            newIntent.putExtra("is_resend", true);
            newIntent.setObserver(((NewIntent) intent).getObserver());
            getAppRuntime().startServlet(newIntent);
            return;
        }
        if (extras.getBoolean("is_resend")) {
            Bundle bundle3 = new Bundle();
            if (i17 == 0) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            bundle3.putInt("param_fail_reason", i3);
            notifyObserver(intent, 15, false, bundle3, b.class);
            return;
        }
        newIntent.putExtra("next_flag", extras.getLong("next_flag"));
        newIntent.putExtra("upload_package_no", i17);
        newIntent.putExtra("add_contact_list", (ArrayList) extras.getSerializable("add_contact_list"));
        newIntent.putExtra("del_contact_list", (ArrayList) extras.getSerializable("del_contact_list"));
        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
        newIntent.putExtra("is_resend", true);
        newIntent.setObserver(((NewIntent) intent).getObserver());
        getAppRuntime().startServlet(newIntent);
    }

    private void t(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        int i17;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 38);
        newIntent.putExtra("unique_phone_no", extras.getString("unique_phone_no"));
        int i18 = extras.getInt("upload_package_no");
        if (f().isDestroyed()) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeUpdateAddressBookNotBind responeUpdateAddressBookNotBind = (ResponeUpdateAddressBookNotBind) b16.getByClass("ResponeUpdateAddressBookNotBind", new ResponeUpdateAddressBookNotBind());
            int i19 = respondHeader.result;
            if (i19 == 0) {
                ArrayList arrayList = (ArrayList) extras.getSerializable("add_contact_list");
                int i26 = i18 * 50;
                if (i26 < arrayList.size()) {
                    int i27 = i26 + 50;
                    if (i27 > arrayList.size()) {
                        i27 = arrayList.size();
                    }
                    f().markUploadedContactNotBind(arrayList.subList(i26, i27));
                }
                long j3 = responeUpdateAddressBookNotBind.nextFlag;
                if (j3 != 4294967295L) {
                    newIntent.putExtra("next_flag", j3);
                    newIntent.putExtra("upload_package_no", i18 + 1);
                    newIntent.putExtra("add_contact_list", extras.getSerializable("add_contact_list"));
                    newIntent.putExtra("del_contact_list", extras.getSerializable("del_contact_list"));
                    newIntent.putExtra("rename_contact_list", extras.getSerializable("rename_contact_list"));
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUpdateAddressBookNotBind.sessionSid);
                    newIntent.putExtra("is_resend", false);
                    newIntent.setObserver(((NewIntent) intent).getObserver());
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                notifyObserver(intent, 38, true, null, b.class);
                if (extras.containsKey("add_contact_list")) {
                    ArrayList<PhoneContact> arrayList2 = (ArrayList) extras.getSerializable("rename_contact_list");
                    if (arrayList2.size() == 0) {
                        return;
                    }
                    f().updateRenameList(arrayList2);
                    return;
                }
                return;
            }
            if (i19 != 109 && i19 != 108) {
                if (extras.getBoolean("is_resend")) {
                    Bundle bundle = new Bundle();
                    if (i18 == 0) {
                        i17 = 2;
                    } else {
                        i17 = 3;
                    }
                    bundle.putInt("param_fail_reason", i17);
                    notifyObserver(intent, 38, false, bundle, b.class);
                    return;
                }
                newIntent.putExtra("next_flag", responeUpdateAddressBookNotBind.nextFlag);
                newIntent.putExtra("upload_package_no", i18);
                newIntent.putExtra("add_contact_list", extras.getSerializable("add_contact_list"));
                newIntent.putExtra("del_contact_list", extras.getSerializable("del_contact_list"));
                newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUpdateAddressBookNotBind.sessionSid);
                newIntent.putExtra("is_resend", true);
                newIntent.setObserver(((NewIntent) intent).getObserver());
                getAppRuntime().startServlet(newIntent);
                return;
            }
            f().saveBindInfo(null, "handleUpdateContactNotBind");
            Bundle bundle2 = new Bundle();
            if (respondHeader.result == 109) {
                i16 = 4;
            } else {
                i16 = 5;
            }
            bundle2.putInt("param_fail_reason", i16);
            notifyObserver(intent, 38, false, bundle2, b.class);
            return;
        }
        if (extras.getBoolean("is_resend")) {
            Bundle bundle3 = new Bundle();
            if (i18 == 0) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            bundle3.putInt("param_fail_reason", i3);
            notifyObserver(intent, 38, false, bundle3, b.class);
            return;
        }
        newIntent.putExtra("next_flag", extras.getLong("next_flag"));
        newIntent.putExtra("upload_package_no", i18);
        newIntent.putExtra("add_contact_list", extras.getSerializable("add_contact_list"));
        newIntent.putExtra("del_contact_list", extras.getSerializable("del_contact_list"));
        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
        newIntent.putExtra("is_resend", true);
        newIntent.setObserver(((NewIntent) intent).getObserver());
        getAppRuntime().startServlet(newIntent);
    }

    private void u(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle extras = intent.getExtras();
        int i3 = extras.getInt("upload_package_no");
        String string = extras.getString("unique_phone_no");
        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 14);
        newIntent.putExtra("unique_phone_no", string);
        if (f().isDestroyed()) {
            return;
        }
        int i16 = 2;
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeUploadAddressBook responeUploadAddressBook = (ResponeUploadAddressBook) b16.getByClass("ResponeUploadAddressBook", new ResponeUploadAddressBook());
            int i17 = respondHeader.result;
            if (i17 == 0) {
                ArrayList arrayList = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                int i18 = i3 * 50;
                int i19 = i18 + 50;
                if (i19 > arrayList.size()) {
                    i19 = arrayList.size();
                }
                f().markUploadedContact(arrayList.subList(i18, i19));
                long j3 = responeUploadAddressBook.nextFlag;
                if (j3 != 4294967295L) {
                    newIntent.putExtra("next_flag", j3);
                    newIntent.putExtra("upload_package_no", i3 + 1);
                    A(extras, newIntent);
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUploadAddressBook.sessionSid);
                    newIntent.putExtra("is_resend", false);
                    newIntent.setObserver(((NewIntent) intent).getObserver());
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                notifyObserver(intent, 14, true, null, b.class);
                return;
            }
            if (i17 != 105 && i17 != 107) {
                if (extras.getBoolean("is_resend")) {
                    Bundle bundle = new Bundle();
                    if (i3 != 0) {
                        i16 = 3;
                    }
                    bundle.putInt("param_fail_reason", i16);
                    notifyObserver(intent, 14, false, bundle, b.class);
                    return;
                }
                newIntent.putExtra("is_resend", true);
                newIntent.putExtra("next_flag", extras.getLong("next_flag"));
                newIntent.putExtra("upload_package_no", i3);
                A(extras, newIntent);
                newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
                newIntent.setObserver(((NewIntent) intent).getObserver());
                getAppRuntime().startServlet(newIntent);
                return;
            }
            f().saveBindInfo(null, "handleUploadContact");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("param_fail_reason", 1);
            notifyObserver(intent, 14, false, bundle2, b.class);
            return;
        }
        if (extras.getBoolean("is_resend")) {
            Bundle bundle3 = new Bundle();
            if (i3 != 0) {
                i16 = 3;
            }
            bundle3.putInt("param_fail_reason", i16);
            notifyObserver(intent, 14, false, bundle3, b.class);
            return;
        }
        newIntent.putExtra("is_resend", true);
        newIntent.putExtra("next_flag", extras.getLong("next_flag"));
        newIntent.putExtra("upload_package_no", i3);
        A(extras, newIntent);
        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
        newIntent.setObserver(((NewIntent) intent).getObserver());
        getAppRuntime().startServlet(newIntent);
    }

    private void v(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        int i17;
        Bundle extras = intent.getExtras();
        int i18 = extras.getInt("upload_package_no");
        String string = extras.getString("unique_phone_no");
        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 37);
        newIntent.putExtra("unique_phone_no", string);
        boolean isDestroyed = f().isDestroyed();
        int i19 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleUploadContactNotBind, " + fromServiceMsg.isSuccess() + ", packageNo = " + i18 + " isMgrDestroyed = " + isDestroyed);
        }
        if (isDestroyed) {
            return;
        }
        try {
            if (fromServiceMsg.isSuccess()) {
                UniPacket b16 = b(fromServiceMsg);
                RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
                ResponeUploadAddressBookNotBind responeUploadAddressBookNotBind = (ResponeUploadAddressBookNotBind) b16.getByClass("ResponeUploadAddressBookNotBind", new ResponeUploadAddressBookNotBind());
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleUploadContactNotBind, result = " + respondHeader.result);
                }
                int i26 = respondHeader.result;
                if (i26 == 0) {
                    ArrayList arrayList = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                    int i27 = i18 * 50;
                    int i28 = i27 + 50;
                    if (i28 > arrayList.size()) {
                        i28 = arrayList.size();
                    }
                    f().markUploadedContactNotBind(arrayList.subList(i27, i28));
                    f().saveContactFromServerNotBind(true, i18, responeUploadAddressBookNotBind.nextFlag, responeUploadAddressBookNotBind.timeStamp, responeUploadAddressBookNotBind.BindFriendContacts, responeUploadAddressBookNotBind.BindNotFriendContacts);
                    Bundle bundle = new Bundle();
                    if (arrayList.size() != 0) {
                        i16 = (i27 * 100) / arrayList.size();
                    } else {
                        i16 = 100;
                    }
                    if (arrayList.size() != 0) {
                        i17 = ((i28 + 50) * 100) / arrayList.size();
                    } else {
                        i17 = 100;
                    }
                    int min = Math.min(i17, 100);
                    bundle.putInt("current_percentage", i16);
                    bundle.putInt("expected_percentage", min);
                    notifyObserver(intent, 100, true, bundle, b.class);
                    long j3 = responeUploadAddressBookNotBind.nextFlag;
                    if (j3 != 4294967295L) {
                        newIntent.putExtra("next_flag", j3);
                        newIntent.putExtra("upload_package_no", i18 + 1);
                        A(extras, newIntent);
                        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUploadAddressBookNotBind.sessionSid);
                        newIntent.putExtra("is_resend", false);
                        newIntent.setObserver(((NewIntent) intent).getObserver());
                        getAppRuntime().startServlet(newIntent);
                        return;
                    }
                    notifyObserver(intent, 37, true, null, b.class);
                    return;
                }
                if (i26 != 109 && i26 != 108) {
                    if (extras.getBoolean("is_resend")) {
                        Bundle bundle2 = new Bundle();
                        if (i18 != 0) {
                            i19 = 3;
                        }
                        bundle2.putInt("param_fail_reason", i19);
                        notifyObserver(intent, 37, false, bundle2, b.class);
                        return;
                    }
                    newIntent.putExtra("is_resend", true);
                    newIntent.putExtra("next_flag", extras.getLong("next_flag"));
                    newIntent.putExtra("upload_package_no", i18);
                    A(extras, newIntent);
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
                    newIntent.setObserver(((NewIntent) intent).getObserver());
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                Bundle bundle3 = new Bundle();
                if (respondHeader.result == 109) {
                    i3 = 4;
                } else {
                    i3 = 5;
                }
                bundle3.putInt("param_fail_reason", i3);
                notifyObserver(intent, 37, false, bundle3, b.class);
                return;
            }
            if (extras.getBoolean("is_resend")) {
                Bundle bundle4 = new Bundle();
                if (i18 != 0) {
                    i19 = 3;
                }
                bundle4.putInt("param_fail_reason", i19);
                notifyObserver(intent, 37, false, bundle4, b.class);
                return;
            }
            newIntent.putExtra("is_resend", true);
            newIntent.putExtra("next_flag", extras.getLong("next_flag"));
            newIntent.putExtra("upload_package_no", i18);
            A(extras, newIntent);
            newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
            newIntent.setObserver(((NewIntent) intent).getObserver());
            getAppRuntime().startServlet(newIntent);
        } catch (Exception unused) {
            notifyObserver(intent, 37, false, null, b.class);
        }
    }

    private void w(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        try {
            LockMethodProxy.sleep(1000L);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        Bundle extras = intent.getExtras();
        int i17 = extras.getInt("upload_package_no");
        String string = extras.getString("unique_phone_no");
        NewIntent newIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 31);
        newIntent.putExtra("unique_phone_no", string);
        boolean isDestroyed = f().isDestroyed();
        int i18 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleUploadContactV2, " + fromServiceMsg.isSuccess() + ", packageNo = " + i17 + " isMgrDestroyed = " + isDestroyed);
        }
        if (isDestroyed) {
            return;
        }
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            ResponeUploadAddressBookV2 responeUploadAddressBookV2 = (ResponeUploadAddressBookV2) b16.getByClass("ResponeUploadAddressBookV2", new ResponeUploadAddressBookV2());
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handleUploadContactV2, result = " + respondHeader.result);
            }
            int i19 = respondHeader.result;
            if (i19 == 0) {
                ArrayList arrayList = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                int i26 = i17 * 50;
                int i27 = i26 + 50;
                if (i27 > arrayList.size()) {
                    i27 = arrayList.size();
                }
                f().markUploadedContact(arrayList.subList(i26, i27));
                f().saveContactFromServer(true, i17, responeUploadAddressBookV2.nextFlag, true, responeUploadAddressBookV2.timeStamp, responeUploadAddressBookV2.MaxsignTimeStamp, responeUploadAddressBookV2.BindFriendContacts, responeUploadAddressBookV2.BindNotFriendContacts);
                Bundle bundle = new Bundle();
                if (arrayList.size() != 0) {
                    i3 = (i26 * 100) / arrayList.size();
                } else {
                    i3 = 100;
                }
                if (arrayList.size() != 0) {
                    i16 = ((i27 + 50) * 100) / arrayList.size();
                } else {
                    i16 = 100;
                }
                int min = Math.min(i16, 100);
                bundle.putInt("current_percentage", i3);
                bundle.putInt("expected_percentage", min);
                notifyObserver(intent, 100, true, bundle, b.class);
                long j3 = responeUploadAddressBookV2.nextFlag;
                if (j3 != 4294967295L) {
                    newIntent.putExtra("next_flag", j3);
                    newIntent.putExtra("upload_package_no", i17 + 1);
                    A(extras, newIntent);
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, responeUploadAddressBookV2.sessionSid);
                    newIntent.putExtra("is_resend", false);
                    newIntent.setObserver(((NewIntent) intent).getObserver());
                    getAppRuntime().startServlet(newIntent);
                    return;
                }
                notifyObserver(intent, 31, true, null, b.class);
                return;
            }
            if (i19 != 105 && i19 != 107) {
                if (extras.getBoolean("is_resend")) {
                    Bundle bundle2 = new Bundle();
                    if (i17 != 0) {
                        i18 = 3;
                    }
                    bundle2.putInt("param_fail_reason", i18);
                    notifyObserver(intent, 31, false, bundle2, b.class);
                    return;
                }
                newIntent.putExtra("is_resend", true);
                newIntent.putExtra("next_flag", extras.getLong("next_flag"));
                newIntent.putExtra("upload_package_no", i17);
                A(extras, newIntent);
                newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
                newIntent.setObserver(((NewIntent) intent).getObserver());
                getAppRuntime().startServlet(newIntent);
                return;
            }
            f().saveBindInfo(null, "handleUploadContactV2_temp");
            Bundle bundle3 = new Bundle();
            bundle3.putInt("param_fail_reason", 1);
            notifyObserver(intent, 31, false, bundle3, b.class);
            return;
        }
        if (extras.getBoolean("is_resend")) {
            Bundle bundle4 = new Bundle();
            if (i17 != 0) {
                i18 = 3;
            }
            bundle4.putInt("param_fail_reason", i18);
            notifyObserver(intent, 31, false, bundle4, b.class);
            return;
        }
        newIntent.putExtra("is_resend", true);
        newIntent.putExtra("next_flag", extras.getLong("next_flag"));
        newIntent.putExtra("upload_package_no", i17);
        A(extras, newIntent);
        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, extras.getByteArray(ServiceConst.PARA_SESSION_ID));
        newIntent.setObserver(((NewIntent) intent).getObserver());
        getAppRuntime().startServlet(newIntent);
    }

    private void x(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg.isSuccess()) {
            RespondHeader respondHeader = (RespondHeader) decodePacket(fromServiceMsg.getWupBuffer(), com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            Bundle bundle = new Bundle();
            bundle.putInt(b.KEY_RESULT, respondHeader.result);
            notifyObserver(intent, 16, true, bundle, b.class);
            return;
        }
        notifyObserver(intent, 16, false, null, b.class);
    }

    private void y(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        boolean z16 = false;
        if (fromServiceMsg.isSuccess()) {
            UniPacket b16 = b(fromServiceMsg);
            RespondHeader respondHeader = (RespondHeader) b16.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247452l, new RespondHeader());
            if (respondHeader == null) {
                bundle.putBoolean("bind_state", false);
                notifyObserver(intent, 27, false, bundle, b.class);
                return;
            }
            if (respondHeader.result == 0) {
                ResponseReBindMblWTLogin responseReBindMblWTLogin = (ResponseReBindMblWTLogin) b16.getByClass("ResponseReBindMblWTLogin", new ResponseReBindMblWTLogin());
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindServlet", 2, "handlerReBindMblWTLogin resp = " + responseReBindMblWTLogin.result);
                }
                z16 = true;
            }
            bundle.putBoolean("bind_state", z16);
            notifyObserver(intent, 27, true, bundle, b.class);
            return;
        }
        bundle.putBoolean("bind_state", false);
        notifyObserver(intent, 27, false, bundle, b.class);
    }

    private byte[] z(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inflaterInputStream.read(bArr2);
                        if (-1 != read) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inflaterInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return bArr;
        }
    }

    public void D(List<AddressBookItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (e.a() && list != null && !list.isEmpty()) {
            Iterator<AddressBookItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().name = "isNull";
            }
        }
    }

    public boolean d(RecommendedContactInfo recommendedContactInfo, RecommendContactInfo recommendContactInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recommendedContactInfo, (Object) recommendContactInfo)).booleanValue();
        }
        if (!TextUtils.isEmpty(recommendedContactInfo.contactsInfoEncrypt)) {
            recommendedContactInfo.contactsInfoEncrypt = recommendedContactInfo.contactsInfoEncrypt.toUpperCase();
            PhoneContact phoneContactByMD5 = f().getPhoneContactByMD5(recommendedContactInfo.contactsInfoEncrypt);
            if (phoneContactByMD5 != null) {
                String a16 = PhoneContactUtils.a(recommendedContactInfo.MobileNoMask, phoneContactByMD5.mobileNo);
                recommendContactInfo.C = a16;
                recommendContactInfo.D = phoneContactByMD5.name;
                if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(recommendContactInfo.D)) {
                    return true;
                }
            } else {
                QLog.d("newerguide", 2, "test .. fillNewerGuideInfo no contact " + recommendedContactInfo.contactsInfoEncrypt);
            }
        }
        return false;
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new String[]{"account.ResponseNotifyForRecommendUpdate"};
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd == null) {
            return;
        }
        if (serviceCmd.equals("account.RequestQueryQQBindingStat")) {
            n(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestBindMobileV2")) {
            g(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestReBindMobile")) {
            q(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestCancelBindMobile")) {
            h(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestDisableMobileBind")) {
            i(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestVerifyBindingSmscode")) {
            x(intent, fromServiceMsg);
            return;
        }
        if (serviceCmd.equals("account.RequestResendBindingSmscode")) {
            r(intent, fromServiceMsg);
            return;
        }
        if (!serviceCmd.equals("account.RequestQueryQQMobileContactsV2")) {
            if (serviceCmd.equals("account.RequestQueryQQMobileContactsV3")) {
                ThreadManagerV2.excute(new Runnable(intent, fromServiceMsg) { // from class: com.tencent.mobileqq.phonecontact.handler.ContactBindServlet.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Intent f258479d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ FromServiceMsg f258480e;

                    {
                        this.f258479d = intent;
                        this.f258480e = fromServiceMsg;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ContactBindServlet.this, intent, fromServiceMsg);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("IMCore.PhoneContact.ContactBindServlet", 2, "handleQueryContactV3 run in Threadmanager");
                        }
                        try {
                            ContactBindServlet.this.o(this.f258479d, this.f258480e);
                        } catch (Exception e16) {
                            QLog.e("IMCore.PhoneContact.ContactBindServlet", 1, "handleQueryContactV3 fail.", e16);
                        }
                    }
                }, 16, null, false);
                return;
            }
            if (serviceCmd.equals("account.RequestUploadAddressBook")) {
                u(intent, fromServiceMsg);
                return;
            }
            if (serviceCmd.equals("account.RequestUpdateAddressBook")) {
                s(intent, fromServiceMsg);
                return;
            }
            if (!serviceCmd.equals("account.ResponseNotifyForRecommendUpdate")) {
                if (serviceCmd.equals(BaseConstants.CMD_WT_LOGIN_ADDCONTACTS)) {
                    j(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals(BaseConstants.CMD_WT_LOGIN_REQUESTREBINDMBL)) {
                    y(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals("account.RequestUploadAddressBookV2")) {
                    w(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals("account.RequestQueryLastLoginState")) {
                    p(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals("account.RequestHideContact")) {
                    m(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals("account.RequestQueryNewUserRecommendedList")) {
                    k(intent, fromServiceMsg);
                    return;
                }
                if (serviceCmd.equals("account.RequestQueryNewUserRecommendedListNotBind")) {
                    l(intent, fromServiceMsg);
                } else if (serviceCmd.equals("account.RequestUploadAddressBookNotBind")) {
                    v(intent, fromServiceMsg);
                } else if (serviceCmd.equals("account.RequestUpdateAddressBookNotBind")) {
                    t(intent, fromServiceMsg);
                }
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        packet.setServantName("AccountServer");
        packet.setFuncName("AccountServerFunc");
        RequestHeader c16 = c(0, 0, 0);
        switch (extras.getInt(AppConstants.Key.SHARE_REQ_TYPE, 0)) {
            case 12:
                packet.setSSOCommand("account.RequestQueryQQBindingStat");
                c16.cmd = 12;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                packet.addRequestPacket("RequestQueryQQBindingStat", new RequestQueryQQBindingStat(f().getUNIQUE_NO()));
                return;
            case 13:
            case 18:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 39:
            default:
                return;
            case 14:
                packet.setSSOCommand("account.RequestUploadAddressBook");
                c16.cmd = 14;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                int i3 = extras.getInt("upload_package_no");
                ArrayList arrayList = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                int i16 = i3 * 50;
                int i17 = i16 + 50;
                if (arrayList.size() <= i17 - 1) {
                    i17 = arrayList.size();
                }
                List<AddressBookItem> subList = arrayList.subList(i16, i17);
                D(subList);
                RequestUploadAddressBook requestUploadAddressBook = new RequestUploadAddressBook();
                requestUploadAddressBook.MobileUniqueNo = extras.getString("unique_phone_no");
                requestUploadAddressBook.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                if ((i3 + 1) * 50 >= arrayList.size()) {
                    requestUploadAddressBook.nextFlag = 4294967295L;
                } else {
                    requestUploadAddressBook.nextFlag = extras.getLong("next_flag");
                }
                requestUploadAddressBook.AddressBookList = new ArrayList<>(subList);
                packet.addRequestPacket("RequestUploadAddressBook", requestUploadAddressBook);
                return;
            case 15:
                packet.setSSOCommand("account.RequestUpdateAddressBook");
                c16.cmd = 15;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                ArrayList arrayList2 = (ArrayList) extras.getSerializable("add_contact_list");
                ArrayList arrayList3 = (ArrayList) extras.getSerializable("del_contact_list");
                D(arrayList2);
                D(arrayList3);
                RequestUpdateAddressBook requestUpdateAddressBook = new RequestUpdateAddressBook();
                requestUpdateAddressBook.MobileUniqueNo = extras.getString("unique_phone_no");
                requestUpdateAddressBook.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                int i18 = extras.getInt("upload_package_no") * 50;
                int i19 = i18 + 50;
                if ((arrayList2 != null && i19 < arrayList2.size()) || (arrayList3 != null && i19 < arrayList3.size())) {
                    requestUpdateAddressBook.nextFlag = extras.getLong("next_flag");
                } else {
                    requestUpdateAddressBook.nextFlag = 4294967295L;
                }
                if (arrayList2 != null && i18 < arrayList2.size()) {
                    if (i19 > arrayList2.size()) {
                        i19 = arrayList2.size();
                    }
                    requestUpdateAddressBook.AddressBookAddList = new ArrayList<>(arrayList2.subList(i18, i19));
                } else {
                    requestUpdateAddressBook.AddressBookAddList = null;
                }
                if (arrayList3 != null && i18 < arrayList3.size()) {
                    if (i19 > arrayList3.size()) {
                        i19 = arrayList3.size();
                    }
                    requestUpdateAddressBook.AddressBookDelList = new ArrayList<>(arrayList3.subList(i18, i19));
                } else {
                    requestUpdateAddressBook.AddressBookDelList = null;
                }
                packet.addRequestPacket("RequestUpdateAddressBook", requestUpdateAddressBook);
                return;
            case 16:
                packet.setSSOCommand("account.RequestVerifyBindingSmscode");
                c16.cmd = 16;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestVerifySmscode requestVerifySmscode = new RequestVerifySmscode();
                requestVerifySmscode.smsCode = extras.getString("verify_smscode");
                requestVerifySmscode.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                requestVerifySmscode.type = extras.getInt("cmd_param_bind_type");
                requestVerifySmscode.isFromUni = extras.getBoolean("cmd_param_is_from_uni", false);
                requestVerifySmscode.isFromChangeBind = extras.getBoolean("cmd_param_is_from_change_bind", false);
                packet.addRequestPacket("RequestVerifySmscode", requestVerifySmscode);
                return;
            case 17:
                packet.setSSOCommand("account.RequestResendBindingSmscode");
                c16.cmd = 17;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestResendSmscode requestResendSmscode = new RequestResendSmscode();
                requestResendSmscode.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                packet.addRequestPacket("RequestResendSmscode", requestResendSmscode);
                return;
            case 19:
                packet.setSSOCommand("account.RequestReBindMobile");
                c16.cmd = 19;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestReBindMobile requestReBindMobile = new RequestReBindMobile();
                requestReBindMobile.nationCode = extras.getString("country_code");
                if (extras.getBoolean("cmd_param_is_encrypt", false)) {
                    requestReBindMobile.isSecNewReq = true;
                    requestReBindMobile.encrptBindMobileInfo = extras.getByteArray("cmd_param_encrypt_mobile");
                } else {
                    requestReBindMobile.mobileNo = extras.getString("phone_number");
                }
                requestReBindMobile.type = extras.getInt("cmd_param_bind_type");
                requestReBindMobile.isFromUni = extras.getBoolean("cmd_param_is_from_uni", false);
                requestReBindMobile.isFromChangeBind = extras.getBoolean("cmd_param_is_from_change_bind", false);
                packet.addRequestPacket("RequestReBindMobile", requestReBindMobile);
                return;
            case 20:
                packet.setSSOCommand("account.RequestCancelBindMobile");
                c16.cmd = 20;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestCancelBindMobile requestCancelBindMobile = new RequestCancelBindMobile();
                requestCancelBindMobile.nationCode = extras.getString("country_code");
                if (extras.getBoolean("cmd_param_is_encrypt", false)) {
                    requestCancelBindMobile.isSecNewReq = true;
                    requestCancelBindMobile.encrptCancelMobileInfo = extras.getByteArray("cmd_param_encrypt_mobile");
                } else {
                    requestCancelBindMobile.mobileNo = extras.getString("phone_number");
                }
                requestCancelBindMobile.isFromUni = extras.getBoolean("cmd_param_is_from_uni", false);
                requestCancelBindMobile.isFromChangeBind = extras.getBoolean("cmd_param_is_from_change_bind", false);
                packet.addRequestPacket("RequestCancelBindMobile", requestCancelBindMobile);
                return;
            case 26:
                packet.setAccount("0");
                packet.setSSOCommand(BaseConstants.CMD_WT_LOGIN_ADDCONTACTS);
                c16.cmd = 26;
                try {
                    c16.uin = Long.parseLong(extras.getString("cmd_param_phone_uin"));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestVerifyWTLogin requestVerifyWTLogin = new RequestVerifyWTLogin();
                requestVerifyWTLogin.encryptBuffer = extras.getByteArray("cmd_param_phone_bind_sign");
                packet.addRequestPacket("RequestVerifyWTLogin", requestVerifyWTLogin);
                return;
            case 27:
                packet.setAccount("0");
                packet.setSSOCommand(BaseConstants.CMD_WT_LOGIN_REQUESTREBINDMBL);
                c16.cmd = 27;
                try {
                    c16.uin = Long.parseLong(extras.getString("cmd_param_phone_uin"));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestReBindMblWTLogin requestReBindMblWTLogin = new RequestReBindMblWTLogin();
                requestReBindMblWTLogin.encryptBuffer = extras.getByteArray("cmd_param_phone_bind_sign");
                packet.addRequestPacket("RequestReBindMblWTLogin", requestReBindMblWTLogin);
                return;
            case 28:
                packet.setSSOCommand("account.RequestQueryQQMobileContactsV2");
                c16.cmd = 28;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestQueryQQMobileContactsV2 requestQueryQQMobileContactsV2 = new RequestQueryQQMobileContactsV2();
                requestQueryQQMobileContactsV2.Compressd = true;
                requestQueryQQMobileContactsV2.nextFlag = extras.getLong("next_flag");
                requestQueryQQMobileContactsV2.timeStamp = extras.getLong("time_stamp");
                requestQueryQQMobileContactsV2.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                packet.addRequestPacket("RequestQueryQQMobileContactsV2", requestQueryQQMobileContactsV2);
                return;
            case 30:
                packet.setSSOCommand("account.RequestQueryQQMobileContactsV3");
                c16.cmd = 30;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestQueryQQMobileContactsV3 requestQueryQQMobileContactsV3 = new RequestQueryQQMobileContactsV3();
                requestQueryQQMobileContactsV3.Compressd = true;
                requestQueryQQMobileContactsV3.nextFlag = extras.getLong("next_flag");
                requestQueryQQMobileContactsV3.timeStamp = extras.getLong("time_stamp");
                requestQueryQQMobileContactsV3.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                requestQueryQQMobileContactsV3.MaxsignTimeStamp = extras.getLong("richinfo_time_stamp");
                requestQueryQQMobileContactsV3.MobileUniqueNo = extras.getString("unique_phone_no");
                requestQueryQQMobileContactsV3.queryFlag = extras.getInt("force_query_list");
                requestQueryQQMobileContactsV3.queryFrom = extras.getLong("param_query_from");
                requestQueryQQMobileContactsV3.OmitOffline = true;
                requestQueryQQMobileContactsV3.bindState = extras.getInt("param_bind_state");
                packet.addRequestPacket("RequestQueryQQMobileContactsV3", requestQueryQQMobileContactsV3);
                return;
            case 31:
                packet.setSSOCommand("account.RequestUploadAddressBookV2");
                c16.cmd = 31;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                int i26 = extras.getInt("upload_package_no");
                ArrayList arrayList4 = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                int i27 = i26 * 50;
                int i28 = i27 + 50;
                if (arrayList4.size() <= i28 - 1) {
                    i28 = arrayList4.size();
                }
                List<AddressBookItem> subList2 = arrayList4.subList(i27, i28);
                D(subList2);
                RequestUploadAddressBookV2 requestUploadAddressBookV2 = new RequestUploadAddressBookV2();
                requestUploadAddressBookV2.MobileUniqueNo = extras.getString("unique_phone_no");
                requestUploadAddressBookV2.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                if ((i26 + 1) * 50 >= arrayList4.size()) {
                    requestUploadAddressBookV2.nextFlag = 4294967295L;
                } else {
                    requestUploadAddressBookV2.nextFlag = extras.getLong("next_flag");
                }
                requestUploadAddressBookV2.AddressBookList = new ArrayList<>(subList2);
                packet.addRequestPacket("RequestUploadAddressBookV2", requestUploadAddressBookV2);
                return;
            case 32:
                packet.setSSOCommand("account.RequestQueryLastLoginState");
                c16.cmd = 32;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestQueryLastLoginState requestQueryLastLoginState = new RequestQueryLastLoginState();
                requestQueryLastLoginState.nextFlag = extras.getLong("next_flag");
                requestQueryLastLoginState.timeStamp = extras.getLong("time_stamp");
                requestQueryLastLoginState.MobileUniqueNo = extras.getString("unique_phone_no");
                packet.addRequestPacket("RequestQueryLastLoginState", requestQueryLastLoginState);
                return;
            case 33:
                packet.setSSOCommand("account.RequestDisableMobileBind");
                c16.cmd = 33;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                String stringExtra = intent.getStringExtra("country_code");
                String stringExtra2 = intent.getStringExtra("phone_number");
                RequestDisableMobileBind requestDisableMobileBind = new RequestDisableMobileBind(stringExtra, stringExtra2);
                requestDisableMobileBind.nationCode = stringExtra;
                requestDisableMobileBind.mobileNo = stringExtra2;
                packet.addRequestPacket("RequestDisableMobileBind", requestDisableMobileBind);
                return;
            case 34:
                packet.setSSOCommand("account.RequestHideContact");
                c16.cmd = 34;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestHideContact requestHideContact = new RequestHideContact();
                AddressBookItem addressBookItem = (AddressBookItem) extras.getSerializable("param_hiden_mobile");
                C(addressBookItem);
                requestHideContact.contact = addressBookItem;
                requestHideContact.isHide = extras.getBoolean("param_hiden_flag");
                packet.addRequestPacket("RequestHideContact", requestHideContact);
                return;
            case 35:
                packet.setSSOCommand("account.RequestBindMobileV2");
                c16.cmd = 35;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestBindMobileV2 requestBindMobileV2 = new RequestBindMobileV2();
                requestBindMobileV2.nationCode = extras.getString("country_code");
                if (extras.getBoolean("cmd_param_is_encrypt", false)) {
                    requestBindMobileV2.isSecNewReq = true;
                    requestBindMobileV2.encrptBindMobileInfo = extras.getByteArray("cmd_param_encrypt_mobile");
                } else {
                    requestBindMobileV2.mobileNo = extras.getString("phone_number");
                }
                requestBindMobileV2.type = extras.getInt("cmd_param_bind_type");
                requestBindMobileV2.isFromUni = extras.getBoolean("cmd_param_is_from_uni", false);
                requestBindMobileV2.isFromChangeBind = extras.getBoolean("cmd_param_is_from_change_bind", false);
                packet.addRequestPacket("RequestBindMobileV2", requestBindMobileV2);
                return;
            case 36:
                packet.setSSOCommand("account.RequestQueryNewUserRecommendedList");
                c16.cmd = 36;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestQueryNewUserRecommendedList requestQueryNewUserRecommendedList = new RequestQueryNewUserRecommendedList();
                requestQueryNewUserRecommendedList.MobileUniqueNo = extras.getString("unique_phone_no");
                requestQueryNewUserRecommendedList.WantNum = extras.getInt("wantCount");
                packet.addRequestPacket("RequestQueryNewUserRecommendedList", requestQueryNewUserRecommendedList);
                return;
            case 37:
                packet.setSSOCommand("account.RequestUploadAddressBookNotBind");
                c16.cmd = 37;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                int i29 = extras.getInt("upload_package_no");
                ArrayList arrayList5 = (ArrayList) extras.getSerializable(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST);
                int i36 = i29 * 50;
                int i37 = i36 + 50;
                if (arrayList5.size() <= i37 - 1) {
                    i37 = arrayList5.size();
                }
                List<AddressBookItem> subList3 = arrayList5.subList(i36, i37);
                D(subList3);
                RequestUploadAddressBookNotBind requestUploadAddressBookNotBind = new RequestUploadAddressBookNotBind();
                requestUploadAddressBookNotBind.MobileUniqueNo = extras.getString("unique_phone_no");
                requestUploadAddressBookNotBind.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                if ((i29 + 1) * 50 >= arrayList5.size()) {
                    requestUploadAddressBookNotBind.nextFlag = 4294967295L;
                } else {
                    requestUploadAddressBookNotBind.nextFlag = extras.getLong("next_flag");
                }
                requestUploadAddressBookNotBind.AddressBookList = new ArrayList<>(subList3);
                packet.addRequestPacket("RequestUploadAddressBookNotBind", requestUploadAddressBookNotBind);
                return;
            case 38:
                packet.setSSOCommand("account.RequestUpdateAddressBookNotBind");
                c16.cmd = 38;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                ArrayList arrayList6 = (ArrayList) extras.getSerializable("add_contact_list");
                ArrayList arrayList7 = (ArrayList) extras.getSerializable("del_contact_list");
                D(arrayList6);
                D(arrayList7);
                RequestUpdateAddressBookNotBind requestUpdateAddressBookNotBind = new RequestUpdateAddressBookNotBind();
                requestUpdateAddressBookNotBind.MobileUniqueNo = extras.getString("unique_phone_no");
                requestUpdateAddressBookNotBind.sessionSid = extras.getByteArray(ServiceConst.PARA_SESSION_ID);
                int i38 = extras.getInt("upload_package_no") * 50;
                int i39 = i38 + 50;
                if ((arrayList6 != null && i39 < arrayList6.size()) || (arrayList7 != null && i39 < arrayList7.size())) {
                    requestUpdateAddressBookNotBind.nextFlag = extras.getLong("next_flag");
                } else {
                    requestUpdateAddressBookNotBind.nextFlag = 4294967295L;
                }
                if (arrayList6 != null && i38 < arrayList6.size()) {
                    if (i39 > arrayList6.size()) {
                        i39 = arrayList6.size();
                    }
                    requestUpdateAddressBookNotBind.AddressBookAddList = new ArrayList<>(arrayList6.subList(i38, i39));
                } else {
                    requestUpdateAddressBookNotBind.AddressBookAddList = null;
                }
                if (arrayList7 != null && i38 < arrayList7.size()) {
                    if (i39 > arrayList7.size()) {
                        i39 = arrayList7.size();
                    }
                    requestUpdateAddressBookNotBind.AddressBookDelList = new ArrayList<>(arrayList7.subList(i38, i39));
                } else {
                    requestUpdateAddressBookNotBind.AddressBookDelList = null;
                }
                packet.addRequestPacket("RequestUpdateAddressBookNotBind", requestUpdateAddressBookNotBind);
                return;
            case 40:
                packet.setSSOCommand("account.RequestQueryNewUserRecommendedListNotBind");
                c16.cmd = 40;
                packet.addRequestPacket(com.tencent.mobileqq.msf.core.auth.e.f247446f, c16);
                RequestQueryNewUserRecommendedListNotBind requestQueryNewUserRecommendedListNotBind = new RequestQueryNewUserRecommendedListNotBind();
                requestQueryNewUserRecommendedListNotBind.MobileUniqueNo = extras.getString("unique_phone_no");
                requestQueryNewUserRecommendedListNotBind.WantNum = extras.getInt("wantCount");
                packet.addRequestPacket("RequestQueryNewUserRecommendedListNotBind", requestQueryNewUserRecommendedListNotBind);
                return;
        }
    }
}
