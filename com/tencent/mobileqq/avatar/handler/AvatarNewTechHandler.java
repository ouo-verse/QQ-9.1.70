package com.tencent.mobileqq.avatar.handler;

import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.bean.QQHeadDetails;
import com.tencent.mobileqq.avatar.utils.c;
import com.tencent.mobileqq.proavatar.info.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oidb.oidb_0xfe1$ReqBody;
import com.tencent.oidb.oidb_0xfe1$ReqData;
import com.tencent.oidb.oidb_0xfe1$ReqUserInfo;
import com.tencent.oidb.oidb_0xfe1$RspBody;
import com.tencent.oidb.oidb_0xfe1$UserData;
import com.tencent.oidb.oidb_0xfe1$UserDataInfo;
import com.tencent.oidb.oidb_0xfe1$UserDataInfoBytesItem;
import com.tencent.oidb.oidb_0xfe1$UserDataInfoIntItem;
import com.tencent.oidb.oidb_headinfo$RspHeadInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&JH\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0011H\u0002J,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001J:\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00052\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/avatar/handler/AvatarNewTechHandler;", "", "", "Lcom/tencent/oidb/oidb_0xfe1$UserData;", "userDataList", "", "dstUserType", "Lcom/tencent/mobileqq/app/face/bean/QQHeadDetails;", "requestQQHeadDetailsList", "", "LAvatarInfo/QQHeadInfo;", "sortedChangedHeadInfoList", "unchangedQQHeadDetailsList", "", "e", "", "selfUin", "Ljava/util/ArrayList;", "qqHeadList", "Lcom/tencent/oidb/oidb_0xfe1$ReqBody;", "a", "Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;", "avatarHandler", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "data", "d", "headType", "Lkotlin/collections/ArrayList;", "b", "", "Lkotlin/Lazy;", "c", "()Z", "timeStampFilterSwitch", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarNewTechHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarNewTechHandler f200124a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy timeStampFilterSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17367);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f200124a = new AvatarNewTechHandler();
        lazy = LazyKt__LazyJVMKt.lazy(AvatarNewTechHandler$timeStampFilterSwitch$2.INSTANCE);
        timeStampFilterSwitch = lazy;
    }

    AvatarNewTechHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final oidb_0xfe1$ReqBody a(long selfUin, ArrayList<QQHeadDetails> qqHeadList) {
        Object obj;
        List<Integer> listOf;
        if (qqHeadList != null && !qqHeadList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<QQHeadDetails> it = qqHeadList.iterator();
            while (it.hasNext()) {
                QQHeadDetails next = it.next();
                if (next != null) {
                    try {
                        oidb_0xfe1$ReqUserInfo oidb_0xfe1_requserinfo = new oidb_0xfe1$ReqUserInfo();
                        String str = next.uinOrMobile;
                        Intrinsics.checkNotNullExpressionValue(str, "it.uinOrMobile");
                        long parseLong = Long.parseLong(str);
                        arrayList.add(Long.valueOf(parseLong));
                        oidb_0xfe1_requserinfo.uint64_req_uin.set(parseLong);
                        oidb_0xfe1_requserinfo.timestamp.set(next.headImgTimestamp);
                        QLog.i("Q.qqhead.AvatarHandler.NewTech", 2, "generateReqBody " + next.uinOrMobile + " headImgTimestamp: " + oidb_0xfe1_requserinfo.timestamp.get());
                        arrayList2.add(oidb_0xfe1_requserinfo);
                    } catch (Exception e16) {
                        QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "generateReqBody exception uin=[" + next.uinOrMobile + "]", e16);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "generateReqBody reqUserInfoList isEmpty");
                return null;
            }
            oidb_0xfe1$ReqBody oidb_0xfe1_reqbody = new oidb_0xfe1$ReqBody();
            QLog.i("Q.qqhead.AvatarHandler.NewTech", 4, "generateReqBody uinList: " + arrayList);
            oidb_0xfe1_reqbody.rpt_uint64_req_uins.set(arrayList);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{101, 45166, 45167});
            oidb_0xfe1$ReqData oidb_0xfe1_reqdata = new oidb_0xfe1$ReqData();
            oidb_0xfe1_reqdata.rpt_basic_fieldids.set(listOf);
            oidb_0xfe1_reqbody.msg_req_param.set(oidb_0xfe1_reqdata);
            oidb_0xfe1_reqbody.rpt_user_infos.set(arrayList2);
            return oidb_0xfe1_reqbody;
        }
        if (qqHeadList != null) {
            obj = Boolean.valueOf(qqHeadList.isEmpty());
        } else {
            obj = "null";
        }
        QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "generateReqBody headList error. " + obj);
        return null;
    }

    private final boolean c() {
        return ((Boolean) timeStampFilterSwitch.getValue()).booleanValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:38|39|(11:40|41|(1:43)(1:84)|44|45|46|47|(1:49)(1:80)|50|(1:52)|53)|(6:65|66|67|68|69|(3:73|59|60))(1:55)|56|57|58|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b7, code lost:
    
        r0 = e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(List<oidb_0xfe1$UserData> userDataList, int dstUserType, List<? extends QQHeadDetails> requestQQHeadDetailsList, List<QQHeadInfo> sortedChangedHeadInfoList, List<QQHeadDetails> unchangedQQHeadDetailsList) {
        Iterator<oidb_0xfe1$UserDataInfoBytesItem> it;
        boolean z16;
        String str;
        long j3;
        long j16;
        for (QQHeadDetails qQHeadDetails : requestQQHeadDetailsList) {
            if (qQHeadDetails != null) {
                for (oidb_0xfe1$UserData oidb_0xfe1_userdata : userDataList) {
                    oidb_0xfe1$UserDataInfo oidb_0xfe1_userdatainfo = oidb_0xfe1_userdata.msg_data.get();
                    if (oidb_0xfe1_userdatainfo != null) {
                        long j17 = oidb_0xfe1_userdata.uint64_fuin.get();
                        if (j17 > 0) {
                            String str2 = qQHeadDetails.uinOrMobile;
                            if (str2 != null && str2.equals(String.valueOf(j17))) {
                                QLog.i("Q.qqhead.AvatarHandler.NewTech", 2, "parseGetQQHeadNtResponse uin: " + j17);
                                QQHeadInfo qQHeadInfo = new QQHeadInfo();
                                qQHeadInfo.uin = j17;
                                qQHeadInfo.headLevel = qQHeadDetails.level;
                                List<oidb_0xfe1$UserDataInfoBytesItem> list = oidb_0xfe1_userdatainfo.map_bytes_values.get();
                                unchangedQQHeadDetailsList.add(qQHeadDetails);
                                if (list != null && !list.isEmpty()) {
                                    Iterator<oidb_0xfe1$UserDataInfoBytesItem> it5 = list.iterator();
                                    while (it5.hasNext()) {
                                        oidb_0xfe1$UserDataInfoBytesItem next = it5.next();
                                        int i3 = next.uint32_key.get();
                                        if (i3 != 101) {
                                            if (i3 == 45166) {
                                                byte[] byteArray = next.bytes_value.get().toByteArray();
                                                Intrinsics.checkNotNullExpressionValue(byteArray, "userDataInfoBytesItem.by\u2026value.get().toByteArray()");
                                                qQHeadInfo.zplanFaceBgUrl = new String(byteArray, Charsets.UTF_8);
                                            }
                                        } else {
                                            oidb_headinfo$RspHeadInfo oidb_headinfo_rspheadinfo = new oidb_headinfo$RspHeadInfo();
                                            try {
                                                oidb_headinfo_rspheadinfo.mergeFrom(next.bytes_value.get().toByteArray());
                                                qQHeadInfo.downLoadUrl = oidb_headinfo_rspheadinfo.url.get();
                                                qQHeadInfo.staticZplanFaceFlag = (byte) oidb_headinfo_rspheadinfo.staticZplanFaceFlag.get();
                                                qQHeadInfo.dynamicZplanFaceFlag = (byte) oidb_headinfo_rspheadinfo.dynamicZplanFaceFlag.get();
                                                FaceInfo faceInfo = qQHeadDetails.faceInfo;
                                                byte b16 = 0;
                                                if (faceInfo != null) {
                                                    z16 = faceInfo.isEnableZplanOutbound();
                                                } else {
                                                    z16 = false;
                                                }
                                                qQHeadInfo.enableZplanOutbound = z16;
                                                qQHeadInfo.dwTimestamp = oidb_headinfo_rspheadinfo.timestamp.get();
                                                qQHeadInfo.cHeadType = (byte) oidb_headinfo_rspheadinfo.faceType.get();
                                                try {
                                                    qQHeadInfo.dstUsrType = (byte) dstUserType;
                                                    qQHeadInfo.dwFaceFlgas = (byte) oidb_headinfo_rspheadinfo.faceFlag.get();
                                                    qQHeadInfo.downLoadUrl = oidb_headinfo_rspheadinfo.url.get();
                                                    qQHeadInfo.systemHeadID = (short) oidb_headinfo_rspheadinfo.sysid.get();
                                                    if (oidb_headinfo_rspheadinfo.headVerify.has()) {
                                                        str = oidb_headinfo_rspheadinfo.headVerify.get();
                                                    } else {
                                                        str = "";
                                                    }
                                                    qQHeadInfo.headVerify = str;
                                                    if (oidb_headinfo_rspheadinfo.apngFaceFlag.has()) {
                                                        b16 = (byte) oidb_headinfo_rspheadinfo.apngFaceFlag.get();
                                                    }
                                                    qQHeadInfo.apngFaceFlag = b16;
                                                    qQHeadInfo.sizeType = qQHeadDetails.sizeType;
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    it = it5;
                                                    QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "parseGetQQHeadNtResponse ", e);
                                                    it5 = it;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                            }
                                            if (c()) {
                                                try {
                                                    j3 = qQHeadInfo.dwTimestamp;
                                                    it = it5;
                                                    try {
                                                        j16 = qQHeadDetails.headImgTimestamp;
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "parseGetQQHeadNtResponse ", e);
                                                        it5 = it;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    it = it5;
                                                }
                                                if (j3 == j16 && j3 > 0) {
                                                    QLog.i("Q.qqhead.AvatarHandler.NewTech", 1, "parseGetQQHeadNtResponse same timeStamp. req:" + j16 + ", qqHeadInfo: " + qQHeadInfo);
                                                    it5 = it;
                                                }
                                            } else {
                                                it = it5;
                                            }
                                            sortedChangedHeadInfoList.add(qQHeadInfo);
                                            unchangedQQHeadDetailsList.remove(qQHeadDetails);
                                            QLog.i("Q.qqhead.AvatarHandler.NewTech", 1, "parseGetQQHeadNtResponse qqHeadInfo: " + qQHeadInfo);
                                            c.s(String.valueOf(qQHeadInfo.uin), qQHeadInfo.downLoadUrl);
                                            it5 = it;
                                        }
                                    }
                                    for (oidb_0xfe1$UserDataInfoIntItem oidb_0xfe1_userdatainfointitem : oidb_0xfe1_userdatainfo.map_uint64_values.get()) {
                                        if (oidb_0xfe1_userdatainfointitem.uint32_key.get() == 45167) {
                                            qQHeadInfo.zplanFaceClipPercent = (int) oidb_0xfe1_userdatainfointitem.uint64_value.get();
                                        }
                                    }
                                } else {
                                    QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "parseGetQQHeadNtResponse bytesList is null or empty");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b(@NotNull AvatarHandler avatarHandler, long selfUin, int headType, @NotNull ArrayList<QQHeadDetails> qqHeadList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, avatarHandler, Long.valueOf(selfUin), Integer.valueOf(headType), qqHeadList);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarHandler, "avatarHandler");
        Intrinsics.checkNotNullParameter(qqHeadList, "qqHeadList");
        oidb_0xfe1$ReqBody a16 = a(selfUin, qqHeadList);
        if (a16 != null) {
            ToServiceMsg makeOIDBPkg = avatarHandler.makeOIDBPkg(FaceConstant.AvatarHandlerCmd.CMD_GET_QQ_HEAD_NT, 4065, 3, a16.toByteArray());
            Intrinsics.checkNotNullExpressionValue(makeOIDBPkg, "avatarHandler.makeOIDBPk\u2026ByteArray()\n            )");
            makeOIDBPkg.extraData.putParcelableArrayList("key_request_list", qqHeadList);
            makeOIDBPkg.extraData.putInt("key_dstUserType", headType);
            avatarHandler.sendPbReq(makeOIDBPkg);
            return;
        }
        QLog.i("Q.qqhead.AvatarHandler.NewTech", 1, "getQQHeadNT reqBody is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull AvatarHandler avatarHandler, @Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        ArrayList arrayList;
        int i3;
        Bundle bundle;
        Bundle bundle2;
        ArrayList parcelableArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, avatarHandler, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarHandler, "avatarHandler");
        oidb_0xfe1$RspBody oidb_0xfe1_rspbody = null;
        if (req != null && (bundle2 = req.extraData) != null && (parcelableArrayList = bundle2.getParcelableArrayList("key_request_list")) != null) {
            arrayList = parcelableArrayList;
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (req != null && (bundle = req.extraData) != null) {
                i3 = bundle.getInt("key_dstUserType");
            } else {
                i3 = 0;
            }
            if (i3 <= 0) {
                QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "handleGetQQHeadNT dstUserType error: " + i3);
                return;
            }
            if (res != null && res.isSuccess()) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                    if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                        oidb_0xfe1$RspBody oidb_0xfe1_rspbody2 = new oidb_0xfe1$RspBody();
                        try {
                            oidb_0xfe1_rspbody2.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                            oidb_0xfe1_rspbody = oidb_0xfe1_rspbody2;
                        } catch (Exception e16) {
                            e = e16;
                            oidb_0xfe1_rspbody = oidb_0xfe1_rspbody2;
                            QLog.e("Q.qqhead.AvatarHandler", 1, "handleGetApolloHead fail.", e);
                            if (oidb_0xfe1_rspbody != null) {
                            }
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
            if (oidb_0xfe1_rspbody != null) {
                QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "handleGetQQHeadNT rspBody is null");
                return;
            }
            oidb_0xfe1_rspbody.rpt_uint64_unfinished_uin.get();
            List<oidb_0xfe1$UserData> list = oidb_0xfe1_rspbody.rpt_msg_userdata.get();
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                e(list, i3, arrayList, arrayList2, arrayList3);
                if (arrayList2.size() > 0) {
                    avatarHandler.z3(arrayList2, false);
                } else {
                    QLog.e("Q.qqhead.AvatarHandler.NewTech", 4, "handleGetQQHeadNT count: " + arrayList2.size());
                }
                avatarHandler.l3(1, 0, arrayList3);
                if (arrayList3.size() > 0) {
                    ArrayList arrayList4 = new ArrayList(arrayList3.size());
                    Iterator<QQHeadDetails> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        arrayList4.add(it.next().uinOrMobile);
                    }
                    avatarHandler.notifyUI(6, true, new Object[]{0, arrayList4});
                }
                a.o(arrayList2);
                return;
            }
            QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "handleGetQQHeadNT userDataList is null or empty");
            return;
        }
        QLog.e("Q.qqhead.AvatarHandler.NewTech", 1, "handleGetQQHeadNT reqQQHeadDetailsList is null or empty");
    }
}
