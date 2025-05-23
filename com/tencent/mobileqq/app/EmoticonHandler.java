package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmoticonQBoxAuthListener;
import com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.pb.emosm.EmosmPb$ReqBody;
import com.tencent.pb.emosm.EmosmPb$RspBody;
import com.tencent.pb.emosm.EmosmPb$STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x13Req;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x18Req;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x19Rsp;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x3ReqFetchBq;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x5ReqBQRecommend;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x6Req;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x7Req;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x8ReqAddTab;
import com.tencent.pb.emosm.QBoxEmoticonAuth$GetExpressAuthReq;
import com.tencent.pb.emosm.QBoxEmoticonAuth$GetExpressAuthRsp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class EmoticonHandler extends BusinessHandler implements com.tencent.mobileqq.emosm.o {
    static IPatchRedirector $redirector_;
    public static final String F;
    IEmoticonQBoxAuthListener C;
    Runnable D;
    Runnable E;

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<EmojiManagerServiceImpl.g> f194621d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f194622e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final r f194623f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final az f194624h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f194625i;

    /* renamed from: m, reason: collision with root package name */
    boolean f194626m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            F = EmoticonHandler.class.getName();
        }
    }

    public EmoticonHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f194621d = new CopyOnWriteArrayList<>();
        this.f194626m = false;
        this.C = null;
        this.D = null;
        this.E = null;
        this.f194622e = appInterface;
        r rVar = new r(this);
        this.f194623f = rVar;
        if (com.tencent.mobileqq.emosm.h.a()) {
            this.f194624h = new x(this);
        } else {
            this.f194624h = rVar;
        }
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        EmosmPb$RspBody emosmPb$RspBody;
        boolean isSuccess = fromServiceMsg.isSuccess();
        int i3 = toServiceMsg.extraData.getInt("EmosmPackageId");
        int i16 = toServiceMsg.extraData.getInt("EmosmSubCmd");
        String valueOf = String.valueOf(toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR));
        ArrayList arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("EmosmEmos");
        EmoticonResp emoticonResp = new EmoticonResp();
        emoticonResp.resultcode = fromServiceMsg.getResultCode();
        emoticonResp.data = arrayList;
        emoticonResp.epId = i3;
        emoticonResp.keySeq = valueOf;
        emoticonResp.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "key_seq=" + valueOf + " isSuccess=" + isSuccess + " resultCode=" + fromServiceMsg.getResultCode() + " timeout:" + emoticonResp.timeoutReason + ",subcmd = " + i16);
        }
        int i17 = 0;
        boolean z16 = false;
        i17 = 0;
        if (isSuccess) {
            try {
                emosmPb$RspBody = new EmosmPb$RspBody().mergeFrom(bArr);
            } catch (Exception unused) {
                emoticonResp.resultcode = -1;
                emosmPb$RspBody = null;
            }
            if (emosmPb$RspBody != null) {
                int i18 = emosmPb$RspBody.int32_result.get();
                int i19 = emosmPb$RspBody.uint32_business_id.get();
                emoticonResp.resultcode = i18;
                if (i18 != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EmoticonHandler", 2, "emosm...fetch key \u56de\u5305 sso \u6210\u529f \uff0cserver \u5931\u8d25\uff0cresult = " + i18);
                    }
                    isSuccess = false;
                } else {
                    IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f194622e.getRuntimeService(IEmoticonManagerService.class, "");
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 5) {
                                    if (i16 != 6) {
                                        if (i16 != 7) {
                                            if (i16 != 9) {
                                                if (i16 != 17) {
                                                    if (i16 != 20) {
                                                        if (i16 != 24) {
                                                            if (i16 == 25) {
                                                                P2(i19, emosmPb$RspBody);
                                                            }
                                                        } else {
                                                            int i26 = toServiceMsg.extraData.getInt("tabId");
                                                            EmoticonRecDressup emoticonRecDressup = new EmoticonRecDressup();
                                                            emoticonRecDressup.hasRecommendDressup = emosmPb$RspBody.msg_subcmd0x18_rsp.bool_jump_flag.get();
                                                            emoticonRecDressup.authorId = emosmPb$RspBody.msg_subcmd0x18_rsp.uint32_author_id.get();
                                                            emoticonRecDressup.saveEmotionRecommend(i26);
                                                            if (QLog.isColorLevel()) {
                                                                QLog.i("EmoticonHandler", 2, "fetchEmoticonRecommend return " + emoticonRecDressup.toString());
                                                            }
                                                        }
                                                    } else {
                                                        O2(emosmPb$RspBody);
                                                    }
                                                } else {
                                                    this.f194623f.h(toServiceMsg, i19, emoticonResp, iEmoticonManagerService);
                                                }
                                            } else {
                                                emoticonResp.data = emosmPb$RspBody.msg_subcmd0x9_rsp.get().rpt_assoc_bqs.get();
                                                if (emosmPb$RspBody.msg_subcmd0x9_rsp.get().i32_reset_exposure_flag.get() == 1) {
                                                    z16 = true;
                                                }
                                                emoticonResp.resetKeywordExpose = z16;
                                            }
                                        } else {
                                            emoticonResp.emoticonId = toServiceMsg.extraData.getString("EmoticonId");
                                            emoticonResp.delEpId = emosmPb$RspBody.msg_subcmd0x7_rsp.get().int32_auth_detail.get();
                                            emoticonResp.keySeq = emosmPb$RspBody.msg_subcmd0x7_rsp.get().str_auth_msg.get();
                                            if (toServiceMsg.extraData.getBoolean("EmosmSubCmdFllow")) {
                                                i16 = 107;
                                            }
                                        }
                                    } else {
                                        emoticonResp.emoticonId = toServiceMsg.extraData.getString("EmoticonId");
                                        emoticonResp.delEpId = emosmPb$RspBody.msg_subcmd0x6_collect_auth.get().int32_auth_detail.get();
                                        emoticonResp.keySeq = emosmPb$RspBody.msg_subcmd0x6_collect_auth.get().str_auth_msg.get();
                                    }
                                } else {
                                    S2(i19, emosmPb$RspBody, iEmoticonManagerService);
                                }
                            } else {
                                Q2(i3, emoticonResp, emosmPb$RspBody);
                            }
                        } else if (this.f194623f.i(toServiceMsg, i19, emoticonResp, emosmPb$RspBody)) {
                            return;
                        }
                    } else {
                        this.f194623f.b(emosmPb$RspBody, i19, emoticonResp, iEmoticonManagerService);
                    }
                }
                i17 = i19;
            } else {
                emoticonResp.resultcode = -1;
                if (QLog.isColorLevel()) {
                    QLog.d("EmoticonHandler", 2, "emosm...fetch key \u56de\u5305 \u5f02\u5e38 subcmd = " + i16);
                }
                isSuccess = false;
            }
        } else if (N2(toServiceMsg, fromServiceMsg, i16)) {
            return;
        }
        R2(fromServiceMsg.getResultCode(), isSuccess, i16, i17, emoticonResp);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ByteBuffer wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    wrap.getInt();
                    if (wrap.get() == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    this.f194622e.getApplication().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emosm_has_download_emosmpackage_tag_" + this.f194622e.getCurrentAccountUin(), z18).commit();
                } else {
                    z18 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, needToFetchEmosmList = " + z18);
                }
                if (z18) {
                    if (QLog.isColorLevel()) {
                        QLog.w("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB, initEmoticon");
                    }
                    g(0, 0);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("EmoticonHandler", 1, e16.getMessage());
                return;
            }
        }
        int i3 = toServiceMsg.extraData.getInt("EmoticonRetry");
        QLog.e("EmoticonHandler", 1, "CMD_EMOSM_CHECK_OIDB, error:" + fromServiceMsg.getResultCode());
        if (fromServiceMsg.getResultCode() == 1002 && i3 < 2) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "CMD_EMOSM_CHECK_OIDB try index: " + i3);
            }
            toServiceMsg.extraData.putInt("EmoticonRetry", i3 + 1);
            super.sendPbReq(toServiceMsg);
        }
    }

    private boolean N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3) {
        int i16 = toServiceMsg.extraData.getInt("EmoticonRetry");
        QLog.e("EmoticonHandler", 1, "error can not send cmd: " + i3);
        if (fromServiceMsg.getResultCode() != 1000 && i16 < 2 && i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "try index: " + i16);
            }
            toServiceMsg.extraData.putInt("EmoticonRetry", i16 + 1);
            super.sendPbReq(toServiceMsg);
            return true;
        }
        return false;
    }

    private void O2(EmosmPb$RspBody emosmPb$RspBody) {
        List<EmosmPb$SmallYellowItem> list = emosmPb$RspBody.msg_subcmd0x13_rsp.get().itemlist.get();
        if (list != null && list.size() > 1) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = list.get(i3);
                    if (QLog.isColorLevel() && emosmPb$SmallYellowItem != null) {
                        sb5.append("type = " + emosmPb$SmallYellowItem.type.get() + ";id = " + emosmPb$SmallYellowItem.f342125id.get() + ";ts =" + emosmPb$SmallYellowItem.f342126ts.get());
                    }
                }
                QLog.d("EmoticonHandler", 2, "commonused systememoji item : " + sb5.toString());
            }
            QLog.d("EmoticonHandler", 1, "commonused back");
            ((ICommonUsedSystemEmojiManagerService) this.f194622e.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "")).updateItemInfo(list);
            return;
        }
        QLog.e("EmoticonHandler", 1, "handleCommonUseInfo ItemInfo = null");
    }

    private void P2(int i3, EmosmPb$RspBody emosmPb$RspBody) {
        long j3;
        if (emosmPb$RspBody.msg_subcmd0x19_rsp.has()) {
            EmosmPb$SubCmd0x19Rsp emosmPb$SubCmd0x19Rsp = emosmPb$RspBody.msg_subcmd0x19_rsp.get();
            int i16 = emosmPb$SubCmd0x19Rsp.uint32_package_id.get();
            if (QLog.isColorLevel()) {
                QLog.i("EmoticonHandler", 2, "TYPE_EMOSM_IP_SITE_INFORMATION id = " + i16);
            }
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f194622e.getRuntimeService(IEmoticonManagerService.class, "");
            EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(String.valueOf(i16), i3);
            if (syncFindEmoticonPackageById != null) {
                syncFindEmoticonPackageById.ipUrl = emosmPb$SubCmd0x19Rsp.str_ip_url.get();
                syncFindEmoticonPackageById.ipName = emosmPb$SubCmd0x19Rsp.str_ip_name.get();
                syncFindEmoticonPackageById.ipDetail = emosmPb$SubCmd0x19Rsp.str_ip_detail.get();
                String str = emosmPb$SubCmd0x19Rsp.str_op_name.get();
                if (TextUtils.isEmpty(str)) {
                    str = HardCodeUtil.qqStr(R.string.f209345f6);
                }
                syncFindEmoticonPackageById.ipOpName = str;
                syncFindEmoticonPackageById.ipJumpUrl = emosmPb$SubCmd0x19Rsp.str_jump_url.get();
                if (emosmPb$SubCmd0x19Rsp.fixed32_time.get() == 0) {
                    j3 = 86400;
                } else {
                    j3 = emosmPb$SubCmd0x19Rsp.fixed32_time.get();
                }
                syncFindEmoticonPackageById.ipReqTime = j3;
                iEmoticonManagerService.saveEmoticonPackage(syncFindEmoticonPackageById);
            }
        }
    }

    private void Q2(int i3, EmoticonResp emoticonResp, EmosmPb$RspBody emosmPb$RspBody) {
        ArrayList arrayList = (ArrayList) emoticonResp.data;
        emoticonResp.epId = i3;
        List<ByteStringMicro> list = emosmPb$RspBody.msg_subcmd0x3_rsp_fetchbq.get().rpt_bytes_key.get();
        for (int i16 = 0; i16 < list.size(); i16++) {
            ByteStringMicro byteStringMicro = list.get(i16);
            ((Emoticon) arrayList.get(i16)).encryptKey = byteStringMicro.toStringUtf8();
        }
        emoticonResp.data = arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "emosm...fetch key \u56de\u5305 sso \u6210\u529f \uff0cserver \u6210\u529f");
        }
    }

    private void S2(int i3, EmosmPb$RspBody emosmPb$RspBody, IEmoticonManagerService iEmoticonManagerService) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend = emosmPb$RspBody.msg_subcmd0x5_recommend.get();
        boolean z16 = emosmPb$SubCmd0x5RspBQRecommend.bool_update_flag.get();
        if (z16) {
            int i16 = emosmPb$SubCmd0x5RspBQRecommend.int32_last_recommend_version.get();
            SharedPreferences.Editor edit = this.f194622e.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit();
            edit.putInt("recommendEmotion_sp_lastversion" + this.f194622e.getCurrentAccountUin(), i16);
            edit.putBoolean("isClickRecommendRedpoint", false);
            edit.putLong("recommendRedpointStartTime", System.currentTimeMillis());
            edit.putInt("recommendSeqinterval", emosmPb$SubCmd0x5RspBQRecommend.int32_req_frequency.get());
            edit.putInt("recommendRuleId", emosmPb$SubCmd0x5RspBQRecommend.int32_ruleid.get());
            edit.apply();
            boolean z17 = emosmPb$SubCmd0x5RspBQRecommend.bool_recommend_show_flag.get();
            QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeBool(IEmoticonMainPanel.FORCE_TO_RECOMMEND_PANEL_SP, z17);
            iEmoticonManagerService.clearAllRecommendExposeNum();
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "recommend info : lastVersion = " + i16 + ";seqFrequncy = " + emosmPb$SubCmd0x5RspBQRecommend.int32_req_frequency.get() + ";isForceToRecommend = " + z17);
            }
            iEmoticonManagerService.saveAndUpdateRecommendEmosInfo(emosmPb$SubCmd0x5RspBQRecommend, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "recommend update flag = " + z16);
        }
    }

    public void D2(EmojiManagerServiceImpl.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) gVar);
        } else if (gVar != null) {
            this.f194621d.addIfAbsent(gVar);
        }
    }

    public void E2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            F2(i3, 0);
        }
    }

    public void F2(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f194624h.f(i3, i16);
        }
    }

    public void G2(@NonNull ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) arrayList);
        } else {
            this.f194624h.g(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void H1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        if (i3 == 0) {
            oidb_sso_oidbssopkg.uint32_command.set(1168);
            oidb_sso_oidbssopkg.uint32_service_type.set(92);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt((int) Long.parseLong(this.f194622e.getCurrentAccountUin()));
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x490_92");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            super.sendPbReq(createToServiceMsg);
        }
    }

    public void H2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Boolean.valueOf(z16));
        } else {
            q.a(str, z16, this);
        }
    }

    public void I2(int i3, ArrayList<Emoticon> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), arrayList, str);
            return;
        }
        if (arrayList == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "emosm...fetch key count  = " + arrayList.size() + " epid = " + arrayList.get(0).epId + "  eid.0 = " + arrayList.get(0).eId);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Emoticon> it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                arrayList2.add(ByteStringMicro.copyFrom(com.tencent.mobileqq.core.util.a.p(it.next().eId)));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        EmosmPb$SubCmd0x3ReqFetchBq emosmPb$SubCmd0x3ReqFetchBq = new EmosmPb$SubCmd0x3ReqFetchBq();
        emosmPb$SubCmd0x3ReqFetchBq.uint32_tab_id.set(i3);
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            emosmPb$SubCmd0x3ReqFetchBq.rpt_bytes_bqid.get().add((ByteStringMicro) arrayList2.get(i16));
        }
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(3);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.msg_subcmd0x3_req_fetchbq.set(emosmPb$SubCmd0x3ReqFetchBq);
        emosmPb$ReqBody.int32_plat_id.set(109);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194622e.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmPackageId", i3);
        toServiceMsg.extraData.putSerializable("EmosmEmos", arrayList);
        toServiceMsg.extraData.putInt("EmosmSubCmd", 3);
        toServiceMsg.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, str);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "getKeySeq reqlocalseq:" + str);
        }
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    public void J2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "fetchEmoticonRecommend, tabId:" + i3);
        }
        EmosmPb$SubCmd0x18Req emosmPb$SubCmd0x18Req = new EmosmPb$SubCmd0x18Req();
        emosmPb$SubCmd0x18Req.uint32_tab_id.set(i3);
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(24);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.msg_subcmd0x18_req.set(emosmPb$SubCmd0x18Req);
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194622e.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmSubCmd", 24);
        toServiceMsg.extraData.putInt("tabId", i3);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    public void K2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.uint32_sub_cmd.set(5);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        emosmPb$ReqBody.uint32_business_id.set(i3);
        EmosmPb$SubCmd0x5ReqBQRecommend emosmPb$SubCmd0x5ReqBQRecommend = new EmosmPb$SubCmd0x5ReqBQRecommend();
        int i16 = -1;
        int i17 = this.f194622e.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendEmotion_sp_lastversion" + this.f194622e.getCurrentAccountUin(), -1);
        if (new File(this.f194622e.getApplication().getFilesDir(), "recommemd_emotion_file__" + i3 + this.f194622e.getCurrentAccountUin()).exists()) {
            i16 = i17;
        }
        emosmPb$SubCmd0x5ReqBQRecommend.int32_last_recommend_version.set(i16);
        emosmPb$ReqBody.msg_subcmd0x5_req.set(emosmPb$SubCmd0x5ReqBQRecommend);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194622e.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmSubCmd", 5);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "handle request to recommendEmotionInfo");
        }
    }

    public void R2(int i3, boolean z16, int i16, int i17, EmoticonResp emoticonResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), emoticonResp);
            return;
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f194622e.getRuntimeService(IEmoticonManagerService.class, "");
        if (i16 == 2) {
            if (z16) {
                ThreadManagerV2.excute(new Runnable(iEmoticonManagerService, emoticonResp, i17) { // from class: com.tencent.mobileqq.app.EmoticonHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ IEmoticonManagerService f194627d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ EmoticonResp f194628e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f194629f;

                    {
                        this.f194627d = iEmoticonManagerService;
                        this.f194628e = emoticonResp;
                        this.f194629f = i17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, EmoticonHandler.this, iEmoticonManagerService, emoticonResp, Integer.valueOf(i17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f194627d.handleFetchEmoticonPackagesResp(true, 2, this.f194628e, this.f194629f);
                            EmoticonHandler.this.notifyUI(2, true, this.f194628e);
                        }
                    }
                }, 32, null, true);
                return;
            }
            QLog.e("EmoticonHandler", 1, "fetchEmoticonPackages failed: " + i3);
            notifyUI(i16, z16, emoticonResp);
            return;
        }
        if (i16 == 3) {
            ArrayList arrayList = (ArrayList) emoticonResp.data;
            if (arrayList != null && arrayList.size() > 0 && z16) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Emoticon emoticon = (Emoticon) it.next();
                    iEmoticonManagerService.saveEmoticon(emoticon);
                    if (QLog.isColorLevel()) {
                        QLog.d("EmoticonHandler", 2, "epId:" + emoticon.epId + ",eId:" + emoticon.eId + ",key:" + emoticon.encryptKey);
                    }
                }
            } else {
                QLog.i("EmoticonHandler", 1, "fetch key error:" + emoticonResp.resultcode);
            }
            Iterator<EmojiManagerServiceImpl.g> it5 = this.f194621d.iterator();
            while (it5.hasNext()) {
                it5.next().a(z16, i16, emoticonResp);
            }
        }
        notifyUI(i16, z16, emoticonResp);
    }

    public void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "handleQBoxEmoticonAuthResp isSuccess: " + z16);
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && QLog.isColorLevel()) {
                    QLog.d("EmoticonHandler", 2, "handleQBoxEmoticonAuthResp uint32_result = " + oidb_sso_oidbssopkg.uint32_result.get());
                }
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    QBoxEmoticonAuth$GetExpressAuthRsp qBoxEmoticonAuth$GetExpressAuthRsp = new QBoxEmoticonAuth$GetExpressAuthRsp();
                    try {
                        qBoxEmoticonAuth$GetExpressAuthRsp.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        i3 = qBoxEmoticonAuth$GetExpressAuthRsp.result_code.get();
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        i3 = 2;
                    }
                    try {
                        str = qBoxEmoticonAuth$GetExpressAuthRsp.schema.get();
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e = e17;
                        QLog.e("EmoticonHandler", 1, "handleQBoxEmoticonAuthResp, error", e);
                        U2(2, "");
                        str = "";
                        U2(i3, str);
                        return;
                    }
                    U2(i3, str);
                    return;
                }
                U2(2, "");
                return;
            } catch (InvalidProtocolBufferMicroException e18) {
                QLog.e("EmoticonHandler", 1, "handleQBoxEmoticonAuthResp, error", e18);
                U2(2, "");
                return;
            }
        }
        U2(2, "");
    }

    public void U2(int i3, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) str);
            return;
        }
        if (!this.f194626m) {
            QLog.i("EmoticonHandler", 1, "onGetQBoxEmoticonAuthHandle intercept");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onGetQBoxEmoticonAuthHandle resultCode: ");
        sb5.append(i3);
        sb5.append(" schema : ");
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str;
        }
        sb5.append(str2);
        QLog.i("EmoticonHandler", 1, sb5.toString());
        Runnable runnable = this.E;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.E = null;
            this.D = null;
        }
        this.f194626m = false;
        IEmoticonQBoxAuthListener iEmoticonQBoxAuthListener = this.C;
        if (iEmoticonQBoxAuthListener != null) {
            iEmoticonQBoxAuthListener.onGetAuthResult(i3, str);
        }
    }

    public void V2(EmojiManagerServiceImpl.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) gVar);
        } else if (gVar != null) {
            this.f194621d.remove(gVar);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void W0(int i3, String str, IEmoticonQBoxAuthListener iEmoticonQBoxAuthListener, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, iEmoticonQBoxAuthListener, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonHandler", 2, "getQBoxEmoticonAuth, packageId: " + i3 + " expressionId : " + str);
        }
        if (this.f194626m) {
            QLog.i("EmoticonHandler", 2, "getQBoxEmoticonAuth repeat get auth");
            return;
        }
        this.f194626m = true;
        this.C = iEmoticonQBoxAuthListener;
        if (i16 > 0) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.EmoticonHandler.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!EmoticonHandler.this.f194626m) {
                        return;
                    }
                    QLog.i("EmoticonHandler", 1, "getQBoxEmoticonAuth failed. timeout");
                    EmoticonHandler emoticonHandler = EmoticonHandler.this;
                    emoticonHandler.f194626m = false;
                    IEmoticonQBoxAuthListener iEmoticonQBoxAuthListener2 = emoticonHandler.C;
                    if (iEmoticonQBoxAuthListener2 != null) {
                        iEmoticonQBoxAuthListener2.onGetAuthResult(2, "");
                        EmoticonHandler.this.C = null;
                    }
                }
            };
            this.D = runnable;
            this.E = ThreadManagerV2.executeDelay(runnable, 16, null, true, i16);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("EmoticonHandler", 2, "getQBoxEmoticonAuth invalid param");
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4732);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        QBoxEmoticonAuth$GetExpressAuthReq qBoxEmoticonAuth$GetExpressAuthReq = new QBoxEmoticonAuth$GetExpressAuthReq();
        qBoxEmoticonAuth$GetExpressAuthReq.package_id.set(i3);
        qBoxEmoticonAuth$GetExpressAuthReq.expression_id.set(str);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(qBoxEmoticonAuth$GetExpressAuthReq.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0x127c_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        super.sendPbReq(createToServiceMsg);
    }

    public void W2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "ReportAddEmoticonPkg, pkgId=" + str + " businessType = " + i3);
        }
        EmosmPb$SubCmd0x8ReqAddTab emosmPb$SubCmd0x8ReqAddTab = new EmosmPb$SubCmd0x8ReqAddTab();
        emosmPb$SubCmd0x8ReqAddTab.uint32_tab_id.set(Integer.parseInt(str));
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint32_sub_cmd.set(8);
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        emosmPb$ReqBody.msg_subcmd0x8_req_addtab.set(emosmPb$SubCmd0x8ReqAddTab);
        emosmPb$ReqBody.uint32_business_id.set(i3);
        emosmPb$ReqBody.setHasFlag(true);
        ToServiceMsg createToServiceMsg = createToServiceMsg("BQMallSvc.TabOpReq");
        createToServiceMsg.extraData.putInt("EmosmSubCmd", 8);
        createToServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(createToServiceMsg);
    }

    public void X2(@NonNull List<CommonTabEmojiInfo> list, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, list, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f194624h.e(list, z16, i3);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void Y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.uint32_sub_cmd.set(19);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        List<EmosmPb$SmallYellowItem> localSystemEmojiInfoFromFile = ((ICommonUsedSystemEmojiManagerService) this.f194622e.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "")).getLocalSystemEmojiInfoFromFile();
        if (localSystemEmojiInfoFromFile == null) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest list is null");
            }
            localSystemEmojiInfoFromFile = new ArrayList<>();
        }
        if (QLog.isColorLevel()) {
            if (localSystemEmojiInfoFromFile.size() > 1) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < localSystemEmojiInfoFromFile.size(); i3++) {
                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = localSystemEmojiInfoFromFile.get(i3);
                    if (emosmPb$SmallYellowItem != null) {
                        sb5.append("type = " + emosmPb$SmallYellowItem.type.get());
                        sb5.append(";id = " + emosmPb$SmallYellowItem.f342125id.get());
                        sb5.append(";ts = " + emosmPb$SmallYellowItem.f342126ts.get());
                    }
                }
                QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest item " + sb5.toString());
            } else {
                QLog.d("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest infos = null");
            }
        }
        EmosmPb$SubCmd0x13Req emosmPb$SubCmd0x13Req = new EmosmPb$SubCmd0x13Req();
        emosmPb$SubCmd0x13Req.itemlist.set(localSystemEmojiInfoFromFile);
        emosmPb$ReqBody.msg_subcmd0x13_req.set(emosmPb$SubCmd0x13Req);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194622e.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmSubCmd", 20);
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i("EmoticonHandler", 2, "getCommonUsedSmallYellowEmoitonRequest called.");
        }
    }

    public void Y2(@NonNull CommonTabEmojiInfo commonTabEmojiInfo, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, commonTabEmojiInfo, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f194624h.d(commonTabEmojiInfo, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void c(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "func fetchEmoticonsPackages, timestamp:" + i3 + ",dividemask:" + i16 + " businessType = " + i17 + " fetchSeq:" + i18);
        }
        this.f194624h.c(i3, i16, i17, i18);
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            c(i3, i16, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            K2(0);
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void k() {
        JSONArray optJSONArray;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(this.f194622e, VasUpdateConstants.SCID_KANDIAN_RECOMMENT_EMOTICON, true, null);
        if (jSONFromLocal != null && (optJSONArray = jSONFromLocal.optJSONArray("watchingFocusRecommendList")) != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                int optInt = optJSONObject.optInt("itemId");
                String optString = optJSONObject.optString("name");
                int optInt2 = optJSONObject.optInt("itemType");
                int optInt3 = optJSONObject.optInt(VipFunCallConstants.KEY_FEET_TYPE);
                if (optInt2 == 3) {
                    str = EmotionPanelConstans.emoticonRecommendUrl.replace("[epId]", String.valueOf(optInt)).replace("[mod]", String.valueOf(optInt % 10));
                } else if (optInt2 != 6) {
                    str = "";
                } else {
                    str = EmotionPanelConstans.smallRecommendUrl.replace("[epId]", String.valueOf(optInt));
                }
                String str2 = IndividuationUrlHelper.getMarketDetailUrl(BaseApplication.getContext(), IndividuationUrlHelper.UrlId.EMOJI_DETAIL, String.valueOf(optInt), "") + "&sceneType=1";
                EmosmPb$STRecommendTabInfo emosmPb$STRecommendTabInfo = new EmosmPb$STRecommendTabInfo();
                emosmPb$STRecommendTabInfo.u32_tab_id.set(optInt);
                emosmPb$STRecommendTabInfo.str_tab_name.set(optString);
                emosmPb$STRecommendTabInfo.i32_tab_type.set(optInt2);
                emosmPb$STRecommendTabInfo.i32_feetype.set(optInt3);
                emosmPb$STRecommendTabInfo.str_thumb_nail_url.set(str);
                emosmPb$STRecommendTabInfo.str_button_url.set(str2);
                arrayList.add(emosmPb$STRecommendTabInfo);
            }
            EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend = new EmosmPb$SubCmd0x5RspBQRecommend();
            emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.set(arrayList);
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f194622e.getRuntimeService(IEmoticonManagerService.class, "");
            if (iEmoticonManagerService != null) {
                iEmoticonManagerService.saveAndUpdateRecommendEmosInfo(emosmPb$SubCmd0x5RspBQRecommend, 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return EmoticonObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            this.f194621d.clear();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("BQMallSvc.TabOpReq")) {
            L2(toServiceMsg, fromServiceMsg, (byte[]) obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("OidbSvc.0x490_92")) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("gxzbIpsit.ipsite")) {
            q.b(toServiceMsg, obj, this.f194622e);
            return;
        }
        if (fromServiceMsg.getServiceCmd().equals("OidbSvcTrpcTcp.0x127c_0")) {
            T2(toServiceMsg, fromServiceMsg, obj);
        } else if (QLog.isColorLevel()) {
            QLog.d("EmoticonHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
        }
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void t2(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        EmosmPb$ReqBody emosmPb$ReqBody = new EmosmPb$ReqBody();
        emosmPb$ReqBody.uint64_uin.set(Long.valueOf(this.f194622e.getCurrentAccountUin()).longValue());
        emosmPb$ReqBody.int32_plat_id.set(109);
        emosmPb$ReqBody.str_app_version.set(AppSetting.f99551k);
        if (6 == i3) {
            emosmPb$ReqBody.uint32_sub_cmd.set(i3);
            EmosmPb$SubCmd0x6Req emosmPb$SubCmd0x6Req = new EmosmPb$SubCmd0x6Req();
            emosmPb$SubCmd0x6Req.u32_tab_id.set(i16);
            emosmPb$SubCmd0x6Req.str_item_id.set(str);
            emosmPb$ReqBody.msg_subcmd0x6_req.set(emosmPb$SubCmd0x6Req);
        } else if (7 == i3 || 107 == i3) {
            emosmPb$ReqBody.uint32_sub_cmd.set(7);
            EmosmPb$SubCmd0x7Req emosmPb$SubCmd0x7Req = new EmosmPb$SubCmd0x7Req();
            emosmPb$SubCmd0x7Req.u32_tab_id.set(i16);
            emosmPb$SubCmd0x7Req.str_item_id.set(str);
            emosmPb$ReqBody.msg_subcmd0x7_req.set(emosmPb$SubCmd0x7Req);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f194622e.getCurrentAccountUin(), "BQMallSvc.TabOpReq");
        toServiceMsg.extraData.putInt("EmosmPackageId", i16);
        toServiceMsg.extraData.putInt("EmosmSubCmd", i3);
        toServiceMsg.extraData.putString("EmoticonId", str);
        toServiceMsg.extraData.putBoolean("EmosmSubCmdFllow", false);
        if (107 == i3) {
            toServiceMsg.extraData.putInt("EmosmSubCmd", 7);
            toServiceMsg.extraData.putBoolean("EmosmSubCmdFllow", true);
        }
        toServiceMsg.putWupBuffer(emosmPb$ReqBody.toByteArray());
        super.sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.emosm.o
    public void y1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (!this.f194625i) {
            this.f194625i = true;
            this.f194622e.getRuntimeService(IEmoticonManagerService.class, "");
            g(i3, i16);
        }
    }
}
