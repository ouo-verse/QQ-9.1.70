package com.tencent.mobileqq.zplan.servlet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.epicgames.ue4.ZPlanVersion;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.state.data.SquareJSConst;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$ActionInfo;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$ReqBody;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$RspBody;
import com.tencent.trpcprotocol.zplan.data_card.data_card.dataCard$ReqBody;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$Info;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$InfoDes;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$UserInfo;
import com.tencent.trpcprotocol.zplan.user_info.get_pb.getPb$ReqBody;
import com.tencent.trpcprotocol.zplan.user_info.get_pb.getPb$RspBody;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tencent.im.oidb.cmd0x10ae.oidb_0x10ae$GetZPlanFriendListRequest;
import tencent.im.oidb.cmd0x10ae.oidb_0x10ae$GetZPlanFriendListResponse;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J6\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J.\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\f\u0010\u001a\u001a\u00020\u0019*\u00020\u0010H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001e2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030#H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010'\u001a\u00020&H\u0002J\u000e\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0007J\u001c\u0010,\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J$\u0010-\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u00101\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u0003J6\u00104\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u00102\u001a\u0004\u0018\u00010\u00032\b\u00103\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005J \u00105\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J(\u00106\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J.\u00108\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010.2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010:\u001a\u00020\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u0016\u0010?\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/ZPlanRequest;", "", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/zplan/servlet/d;", "listener", "", tl.h.F, "", "serviceType", "f", "g", "", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/model/c;", "infoDesList", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/trpcprotocol/zplan/user_info/get_pb/getPb$RspBody;", "response", "", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "l", "Lcom/tencent/trpcprotocol/zplan/user_info/common_pb/commonPb$InfoDes;", "B", "errMsg", "i", "command", "", "bodyBytes", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "r", "dataBytes", "Lcom/tencent/mobileqq/pb/MessageMicro;", "msg", "t", "Ltencent/im/oidb/cmd0x10ae/oidb_0x10ae$GetZPlanFriendListResponse;", "rsp", ReportConstant.COSTREPORT_PREFIX, "uin", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", "Lcom/tencent/common/app/AppInterface;", "app", "appid", "p", "openId", "appId", DomainData.DOMAIN_NAME, "o", "v", "openIdList", "w", "userInfoDesList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isChecked", "Lnk3/a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanRequest f335367a = new ZPlanRequest();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$a", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f335368d;

        a(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f335368d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            if (isSuccess && data != null) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    int size = oidb_0x5eb_rspbody.rpt_msg_uin_data.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(i16);
                        String valueOf = String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                        String appearanceKey = oidb_0x5eb_udcuindata.zplan_appearanceKey.get().toStringUtf8();
                        int i17 = oidb_0x5eb_udcuindata.zplan_appearanceKey_time.get();
                        int i18 = oidb_0x5eb_udcuindata.zplan_avatar_gender.get();
                        if (!(appearanceKey == null || appearanceKey.length() == 0) || ZPlanQQMC.INSTANCE.enableUpdateZPlanUserInfoWithEmptyAppearanceKey()) {
                            Intrinsics.checkNotNullExpressionValue(appearanceKey, "appearanceKey");
                            linkedHashMap.put(valueOf, new ZPlanUserInfo(valueOf, appearanceKey, i17, i18));
                        }
                    }
                    this.f335368d.a(true, linkedHashMap);
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "getAppearanceKey complete, sso result:" + i3 + ", errMsg:" + str);
                this.f335368d.a(false, null);
                return;
            }
            QLog.e("[zplan]ZPlanRequest", 1, "getAppearanceKey, isSuccess: " + isSuccess + ", data: " + data);
            this.f335368d.a(false, null);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                if (isSuccess && data != null) {
                    GetZPlanAction$RspBody getZPlanAction$RspBody = new GetZPlanAction$RspBody();
                    ZPlanRequest.f335367a.t((byte[]) data, getZPlanAction$RspBody);
                    int i3 = getZPlanAction$RspBody.icon_nums.get();
                    ArrayList arrayList = new ArrayList();
                    List<GetZPlanAction$ActionInfo> list = getZPlanAction$RspBody.actionInfo.get();
                    if (list != null && list.size() > 0) {
                        for (GetZPlanAction$ActionInfo getZPlanAction$ActionInfo : list) {
                            kf3.d dVar = new kf3.d();
                            dVar.n(getZPlanAction$ActionInfo.f381671id.get());
                            dVar.j(getZPlanAction$ActionInfo.is_dynamic.get());
                            dVar.l(getZPlanAction$ActionInfo.icon_url.get());
                            dVar.i(getZPlanAction$ActionInfo.cover_index.get());
                            arrayList.add(dVar);
                        }
                    }
                    ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
                    if (a16 == null) {
                        QLog.e("[zplan]ZPlanRequest", 1, "getRecomAvartar resp success, counts:" + i3 + ", list size:" + arrayList.size() + ", but handler null!");
                        return;
                    }
                    a16.notifyUI(2, true, new Object[]{arrayList, Integer.valueOf(i3)});
                    QLog.i("[zplan]ZPlanRequest", 1, "getRecomAvartar success, counts:" + i3 + ", list size:" + arrayList.size());
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "getRecomAvartar fail");
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "getRecomAvartar onUpdate exception:", e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$c", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f335369d;

        c(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f335369d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            String stringUtf8;
            boolean z16 = false;
            try {
                if (isSuccess && data != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    ZPlanRequest.f335367a.t((byte[]) data, oidb_0x5eb_rspbody);
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                        if (String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get()).length() == 0) {
                            stringUtf8 = String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                        } else {
                            stringUtf8 = oidb_0x5eb_udcuindata.bytes_openid.get().toStringUtf8();
                        }
                        int i3 = oidb_0x5eb_udcuindata.uint32_allow.get();
                        int i16 = oidb_0x5eb_udcuindata.uint32_zplan_add_frd.get();
                        if (i3 != 2 && i16 == SwitchSetting.ADD_FRIEND_SETTING.getOnValue()) {
                            z16 = true;
                        }
                        this.f335369d.a(true, Boolean.valueOf(z16));
                        if (QLog.isColorLevel()) {
                            QLog.i("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] success, uin:" + stringUtf8 + " addSwitch:" + i3 + " zplanAddSwitch:" + i16);
                            return;
                        }
                        return;
                    }
                    QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] error, rsp size 0");
                    this.f335369d.a(false, null);
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] fail, isSuccess:" + isSuccess);
                this.f335369d.a(false, null);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] fail exception:", e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$e", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZPlanRequestHandler f335371d;

        e(ZPlanRequestHandler zPlanRequestHandler) {
            this.f335371d = zPlanRequestHandler;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                if (isSuccess && data != null) {
                    oidb_0x10ae$GetZPlanFriendListResponse oidb_0x10ae_getzplanfriendlistresponse = new oidb_0x10ae$GetZPlanFriendListResponse();
                    ZPlanRequest zPlanRequest = ZPlanRequest.f335367a;
                    zPlanRequest.t((byte[]) data, oidb_0x10ae_getzplanfriendlistresponse);
                    List s16 = zPlanRequest.s(oidb_0x10ae_getzplanfriendlistresponse);
                    this.f335371d.notifyUI(3, true, s16);
                    if (QLog.isColorLevel()) {
                        QLog.i("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] success, uinList size:" + s16.size());
                        return;
                    }
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] fail, isSuccess:" + isSuccess);
                this.f335371d.notifyUI(3, false, null);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] fail exception:", e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$f", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335372d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f335373e;

        public f(String str, String str2) {
            this.f335372d = str;
            this.f335373e = str2;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() < 1) {
                        QLog.e("[zplan]ZPlanRequest", 1, "[queryRegister] no available uin data.");
                        return;
                    }
                    boolean z16 = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0).uint32_zplan_open.get() == 1;
                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("zplan_sp" + this.f335373e, 0).edit();
                    edit.putBoolean("zplan_register", z16);
                    edit.apply();
                    ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
                    if (a16 != null) {
                        a16.notifyUI(1, true, new Boolean[]{Boolean.valueOf(z16)});
                        return;
                    }
                    return;
                }
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                QLog.e("[zplan]ZPlanRequest", 1, "[ZPlanRequestHandler]: cmd: " + this.f335372d + " completed with sso result: " + i3 + ", errMsg: " + str);
            } catch (Exception e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "[ZPlanRequestHandler]: request cmd: " + this.f335372d + " failed with ", e16);
            }
        }
    }

    ZPlanRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(boolean z16, nk3.a callback, boolean z17) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("[zplan]ZPlanRequest", 1, "[setSettingProfileCardSwitch] success=" + z17 + ", isChecked=" + z16);
        if (!z17) {
            callback.onResult(false);
            return;
        }
        if (z16) {
            com.tencent.mobileqq.zplan.setting.c.n(z16);
            y.h(z16);
        }
        com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.PROFILE_CARD_SETTING, z16);
        y.f335851a.k(z16, 1004L);
    }

    private final commonPb$InfoDes B(com.tencent.mobileqq.zplan.model.c cVar) {
        commonPb$InfoDes commonpb_infodes = new commonPb$InfoDes();
        commonpb_infodes.name.set(cVar.f334802a);
        commonpb_infodes.type.set(cVar.f334803b);
        return commonpb_infodes;
    }

    private final List<Long> C(List<String> uinList) {
        Long longOrNull;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = uinList.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(Long.valueOf(longOrNull.longValue()));
            }
        }
        return arrayList;
    }

    private final void f(List<String> uinList, int serviceType, com.tencent.mobileqq.zplan.servlet.d listener) {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        List<Long> C = C(uinList);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(27405, 1), new com.tencent.mobileqq.zplan.model.c(27404, 3), new com.tencent.mobileqq.zplan.model.c(45140, 3));
        if (ZPlanFeatureSwitch.f369852a.F()) {
            mutableListOf.add(new com.tencent.mobileqq.zplan.model.c(13, 1));
        }
        f335367a.y(C, mutableListOf, listener, serviceType);
    }

    private final void g(List<String> uinList, com.tencent.mobileqq.zplan.servlet.d listener) {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        List<Long> C = C(uinList);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(27405, 1), new com.tencent.mobileqq.zplan.model.c(13, 1), new com.tencent.mobileqq.zplan.model.c(27404, 3), new com.tencent.mobileqq.zplan.model.c(45140, 3));
        f335367a.x(C, mutableListOf, listener);
    }

    private final void h(List<String> uinList, com.tencent.mobileqq.zplan.servlet.d listener) {
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.req_zplan_appearanceKey.set(1);
        oidb_0x5eb_reqbody.req_zplan_appearanceKey_time.set(1);
        oidb_0x5eb_reqbody.req_zplan_avatar_gender.set(1);
        for (String str : uinList) {
            try {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "getAppearanceKey add uin:" + str + ", exception:", e16);
            }
        }
        oidb_sso$OIDBSSOPkg r16 = r(1515, 22, oidb_0x5eb_reqbody.toByteArray());
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 == null) {
            listener.a(false, null);
        } else {
            a16.request("OidbSvc.0x5eb_22", r16.toByteArray(), new a(listener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String errMsg, com.tencent.mobileqq.zplan.servlet.d listener) {
        QLog.e("[zplan]ZPlanRequest", 1, errMsg);
        listener.a(false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0051 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, ZPlanUserInfo> l(getPb$RspBody response) {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            List<commonPb$UserInfo> list = response.user_infos.get();
            if (list == null) {
                return null;
            }
            for (commonPb$UserInfo commonpb_userinfo : list) {
                if (commonpb_userinfo == null) {
                    QLog.e("[zplan]ZPlanRequest", 1, "requestOidb_0x1127 resp first pbUserInfo empty");
                } else {
                    String valueOf = String.valueOf(commonpb_userinfo.uint64_uin.get());
                    List<commonPb$Info> currUserInfos = commonpb_userinfo.infos.get();
                    List<commonPb$Info> list2 = currUserInfos;
                    if (list2 != null && !list2.isEmpty()) {
                        z16 = false;
                        if (!z16) {
                            QLog.e("[zplan]ZPlanRequest", 1, "requestOidb_0x1127 resp pbUserInfo.infos empty");
                        } else {
                            Intrinsics.checkNotNullExpressionValue(currUserInfos, "currUserInfos");
                            HashMap hashMap = new HashMap();
                            for (Object obj : currUserInfos) {
                                hashMap.put(Integer.valueOf(((commonPb$Info) obj).des.name.get()), ((commonPb$Info) obj).value.get());
                            }
                            String str = "";
                            if (hashMap.containsKey(27405)) {
                                str = String.valueOf(hashMap.get(27405));
                            }
                            if (hashMap.containsKey(13)) {
                                str = String.valueOf(hashMap.get(13));
                            }
                            String str2 = str;
                            if (!(str2.length() == 0)) {
                                linkedHashMap.put(valueOf, new ZPlanUserInfo(valueOf, str2, Long.parseLong(String.valueOf(hashMap.get(27404))), 0, 8, null));
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th5) {
            QLog.e("[zplan]ZPlanRequest", 1, "requestOidb_0x1127 onUpdate exception:", th5);
            return null;
        }
    }

    private final oidb_sso$OIDBSSOPkg r(int command, int serviceType, byte[] bodyBytes) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(command);
        oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        if (bodyBytes != null) {
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bodyBytes));
        }
        return oidb_sso_oidbssopkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> s(oidb_0x10ae$GetZPlanFriendListResponse rsp) {
        ArrayList arrayList = new ArrayList();
        int size = rsp.uins.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(String.valueOf(rsp.uins.get(i3)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(byte[] dataBytes, MessageMicro<?> msg2) {
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom(dataBytes);
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            String str = oidb_sso_oidbssopkg.str_error_msg.get();
            if (i3 != 0) {
                QLog.e("[zplan]ZPlanRequest", 1, "parseOIDBPkg complete, sso result:" + i3 + ", errMsg:" + str);
            } else {
                msg2.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            }
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanRequest", 1, "parseOIDBPkg error", e16);
        }
    }

    private final void x(List<Long> uinList, List<com.tencent.mobileqq.zplan.model.c> infoDesList, com.tencent.mobileqq.zplan.servlet.d listener) {
        int collectionSizeOrDefault;
        List<commonPb$InfoDes> mutableList;
        getPb$ReqBody getpb_reqbody = new getPb$ReqBody();
        getpb_reqbody.uint64_uins.set(uinList);
        PBRepeatMessageField<commonPb$InfoDes> pBRepeatMessageField = getpb_reqbody.need_infos;
        List<com.tencent.mobileqq.zplan.model.c> list = infoDesList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f335367a.B((com.tencent.mobileqq.zplan.model.c) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        pBRepeatMessageField.set(mutableList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4391);
        oidb_sso_oidbssopkg.uint32_service_type.set(5);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(getpb_reqbody.toByteArray()));
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("OidbSvcTrpcTcp.0x1127_5", oidb_sso_oidbssopkg.toByteArray(), new g(listener));
        }
    }

    private final void y(List<Long> uinList, List<com.tencent.mobileqq.zplan.model.c> infoDesList, com.tencent.mobileqq.zplan.servlet.d listener, int serviceType) {
        int collectionSizeOrDefault;
        List<commonPb$InfoDes> mutableList;
        getPb$ReqBody getpb_reqbody = new getPb$ReqBody();
        getpb_reqbody.uint64_uins.set(uinList);
        PBRepeatMessageField<commonPb$InfoDes> pBRepeatMessageField = getpb_reqbody.need_infos;
        List<com.tencent.mobileqq.zplan.model.c> list = infoDesList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f335367a.B((com.tencent.mobileqq.zplan.model.c) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        pBRepeatMessageField.set(mutableList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4391);
        oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(getpb_reqbody.toByteArray()));
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("OidbSvcTrpcTcp.0x1127_" + serviceType, oidb_sso_oidbssopkg.toByteArray(), new h(listener));
        }
    }

    public final void j(List<String> uinList, int serviceType, com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (uinList.isEmpty()) {
            i("getAppearanceKey failed, uinList empty.", listener);
        } else {
            f(uinList, serviceType, listener);
        }
    }

    public final void k(List<String> uinList, com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (uinList.isEmpty()) {
            i("getLongAppearanceKey failed, uinList empty.", listener);
        } else if (ZPlanFeatureSwitch.f369852a.F()) {
            g(uinList, listener);
        } else {
            h(uinList, listener);
        }
    }

    public final void m() {
        QLog.i("[zplan]ZPlanRequest", 1, "getRecomAvartar start");
        GetZPlanAction$ReqBody getZPlanAction$ReqBody = new GetZPlanAction$ReqBody();
        getZPlanAction$ReqBody.type.set(3);
        getZPlanAction$ReqBody.engine_version.set(ZPlanVersion.ZPlanVersion);
        oidb_sso$OIDBSSOPkg r16 = r(4136, 1, getZPlanAction$ReqBody.toByteArray());
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "getRecomAvartar error, handler null");
        } else {
            a16.request("OidbSvcTrpcTcp.0x1028_1", r16.toByteArray(), new b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:8:0x0014, B:10:0x001b, B:15:0x0027, B:16:0x0059, B:23:0x004c), top: B:7:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:8:0x0014, B:10:0x001b, B:15:0x0027, B:16:0x0059, B:23:0x004c), top: B:7:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(AppInterface app, String uin, String openId, String appId, com.tencent.mobileqq.zplan.servlet.d listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (app == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] app is null.");
            return;
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            if (uin != null && uin.length() != 0) {
                z16 = false;
                if (!z16) {
                    PBRepeatField<ByteStringMicro> pBRepeatField = oidb_0x5eb_reqbody.rpt_bytes_openid;
                    Intrinsics.checkNotNull(openId);
                    byte[] bytes = openId.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    pBRepeatField.add(ByteStringMicro.copyFrom(bytes));
                    PBUInt32Field pBUInt32Field = oidb_0x5eb_reqbody.uint32_appid;
                    Intrinsics.checkNotNull(appId);
                    pBUInt32Field.set(Integer.parseInt(appId));
                } else {
                    oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(uin)));
                }
                oidb_0x5eb_reqbody.uint32_req_allow.set(1);
                oidb_0x5eb_reqbody.uint32_req_zplan_add_frd.set(1);
                oidb_sso$OIDBSSOPkg r16 = r(1515, 22, oidb_0x5eb_reqbody.toByteArray());
                BusinessHandler businessHandler = app.getBusinessHandler(ZPlanRequestHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
                ZPlanRequestHandler zPlanRequestHandler = (ZPlanRequestHandler) businessHandler;
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] start");
                }
                zPlanRequestHandler.request("OidbSvc.0x5eb_22", r16.toByteArray(), new c(listener));
            }
            z16 = true;
            if (!z16) {
            }
            oidb_0x5eb_reqbody.uint32_req_allow.set(1);
            oidb_0x5eb_reqbody.uint32_req_zplan_add_frd.set(1);
            oidb_sso$OIDBSSOPkg r162 = r(1515, 22, oidb_0x5eb_reqbody.toByteArray());
            BusinessHandler businessHandler2 = app.getBusinessHandler(ZPlanRequestHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler2, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
            ZPlanRequestHandler zPlanRequestHandler2 = (ZPlanRequestHandler) businessHandler2;
            if (QLog.isColorLevel()) {
            }
            zPlanRequestHandler2.request("OidbSvc.0x5eb_22", r162.toByteArray(), new c(listener));
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanAddFriendSetting] create request body exception", e16);
            listener.a(false, null);
        }
    }

    public final void o(AppInterface app, String uin, com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (app == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] app is null.");
            return;
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(uin)));
            oidb_0x5eb_reqbody.uint32_flag_zplan_edit_avatar.set(1);
            oidb_sso$OIDBSSOPkg r16 = r(1515, 22, oidb_0x5eb_reqbody.toByteArray());
            BusinessHandler businessHandler = app.getBusinessHandler(ZPlanRequestHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
            ZPlanRequestHandler zPlanRequestHandler = (ZPlanRequestHandler) businessHandler;
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] start");
            }
            zPlanRequestHandler.request("OidbSvc.0x5eb_22", r16.toByteArray(), new d(listener));
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] create request body exception", e16);
            listener.a(false, null);
        }
    }

    public final void p(AppInterface app, String appid) {
        Intrinsics.checkNotNullParameter(appid, "appid");
        if (app == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] app is null.");
            return;
        }
        try {
            oidb_0x10ae$GetZPlanFriendListRequest oidb_0x10ae_getzplanfriendlistrequest = new oidb_0x10ae$GetZPlanFriendListRequest();
            oidb_0x10ae_getzplanfriendlistrequest.appid.set(Long.parseLong(appid));
            oidb_sso$OIDBSSOPkg r16 = r(4270, 1, oidb_0x10ae_getzplanfriendlistrequest.toByteArray());
            BusinessHandler businessHandler = app.getBusinessHandler(ZPlanRequestHandler.class.getName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
            ZPlanRequestHandler zPlanRequestHandler = (ZPlanRequestHandler) businessHandler;
            if (QLog.isColorLevel()) {
                QLog.d("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] start");
            }
            zPlanRequestHandler.request("OidbSvcTrpcTcp.0x10ae_1", r16.toByteArray(), new e(zPlanRequestHandler));
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanRecentFriendList] create request body exception", e16);
        }
    }

    public final byte[] q(List<com.tencent.mobileqq.zplan.model.c> userInfoDesList) {
        Intrinsics.checkNotNullParameter(userInfoDesList, "userInfoDesList");
        dataCard$ReqBody datacard_reqbody = new dataCard$ReqBody();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.zplan.model.c cVar : userInfoDesList) {
            commonPb$InfoDes commonpb_infodes = new commonPb$InfoDes();
            commonpb_infodes.name.set(cVar.f334802a);
            commonpb_infodes.type.set(cVar.f334803b);
            arrayList.add(commonpb_infodes);
        }
        datacard_reqbody.need_infos.set(arrayList);
        byte[] byteArray = datacard_reqbody.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "reqBody.toByteArray()");
        return byteArray;
    }

    public final void u(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("[zplan]ZPlanRequest", 1, "[queryRegister] start");
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.uint32_zplan_open.set(1);
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(uin)));
            oidb_sso$OIDBSSOPkg r16 = r(1515, 22, oidb_0x5eb_reqbody.toByteArray());
            ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
            if (a16 != null) {
                byte[] byteArray = r16.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "ssoReq.toByteArray()");
                a16.request("OidbSvc.0x5eb_22", byteArray, new f("OidbSvc.0x5eb_22", uin));
            }
        } catch (Exception e16) {
            QLog.e("[zplan]ZPlanRequest", 1, "[queryRegister] parse String to Long failed, uin maybe invalid. ", e16);
        }
    }

    public final void v(AppInterface app, final String openId, String appId, final com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (app == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenId] app is null.");
            return;
        }
        final Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        ResultReceiver resultReceiver = new ResultReceiver(uIHandlerV2) { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanRequest$requestGetIsFriendByOpenId$receiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                QLog.d("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenId] resultCode:" + resultCode);
                if (resultCode == 0 && resultData != null) {
                    Serializable serializable = resultData.getSerializable("isFriendMap");
                    Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Boolean>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Boolean> }");
                    Boolean bool = (Boolean) ((HashMap) serializable).get(openId);
                    if (bool != null) {
                        listener.a(true, bool);
                        return;
                    }
                }
                QLog.e("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenId] fail");
                listener.a(false, null);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(openId);
        BusinessHandler businessHandler = app.getBusinessHandler(FriendHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.friend.handler.FriendHandler");
        ((FriendHandler) businessHandler).V2(arrayList, appId, resultReceiver);
    }

    public final void w(AppInterface app, List<String> openIdList, String appId, final com.tencent.mobileqq.zplan.servlet.d listener) {
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (app == null) {
            QLog.e("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenIdList] app is null.");
            return;
        }
        final Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        ResultReceiver resultReceiver = new ResultReceiver(uIHandlerV2) { // from class: com.tencent.mobileqq.zplan.servlet.ZPlanRequest$requestGetIsFriendByOpenIdList$receiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                QLog.d("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenIdList] resultCode:" + resultCode);
                if (resultCode == 0 && resultData != null) {
                    Serializable serializable = resultData.getSerializable("isFriendMap");
                    Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Boolean>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Boolean> }");
                    d.this.a(true, (HashMap) serializable);
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenIdList] fail");
                d.this.a(false, null);
            }
        };
        BusinessHandler businessHandler = app.getBusinessHandler(FriendHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.friend.handler.FriendHandler");
        ((FriendHandler) businessHandler).V2(openIdList, appId, resultReceiver);
    }

    public final void z(final boolean isChecked, final nk3.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(SwitchSetting.PROFILE_CARD_SETTING, Boolean.valueOf(isChecked)));
        if (isChecked) {
            arrayList.add(new Pair(SwitchSetting.MASTER_SETTING, Boolean.valueOf(isChecked)));
        }
        com.tencent.mobileqq.zplan.setting.e.f335451a.g(arrayList, new nk3.a() { // from class: com.tencent.mobileqq.zplan.servlet.l
            @Override // nk3.a
            public final void onResult(boolean z16) {
                ZPlanRequest.A(isChecked, callback, z16);
            }
        });
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$d", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f335370d;

        d(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f335370d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            try {
                if (isSuccess && data != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    ZPlanRequest.f335367a.t((byte[]) data, oidb_0x5eb_rspbody);
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                        String valueOf = String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                        boolean z16 = oidb_0x5eb_udcuindata.uint32_flag_zplan_edit_avatar.get() > 0;
                        this.f335370d.a(true, Boolean.valueOf(z16));
                        if (QLog.isColorLevel()) {
                            QLog.i("[zplan]ZPlanRequest", 2, "[getZPlanEditAvatarSetting] success, uin:" + valueOf + " flag:" + z16);
                            return;
                        }
                        return;
                    }
                    QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] error, rsp size 0");
                    this.f335370d.a(false, null);
                    return;
                }
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] fail, isSuccess:" + isSuccess);
                this.f335370d.a(false, null);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("[zplan]ZPlanRequest", 1, "[getZPlanEditAvatarSetting] fail exception:", e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$h", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f335375d;

        h(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f335375d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            if (isSuccess && data != null) {
                getPb$RspBody getpb_rspbody = new getPb$RspBody();
                ZPlanRequest zPlanRequest = ZPlanRequest.f335367a;
                zPlanRequest.t((byte[]) data, getpb_rspbody);
                Map l3 = zPlanRequest.l(getpb_rspbody);
                boolean z16 = false;
                if (l3 != null && (!l3.isEmpty())) {
                    z16 = true;
                }
                if (z16) {
                    this.f335375d.a(true, l3);
                    return;
                }
            }
            this.f335375d.a(isSuccess, null);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$g", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.servlet.d f335374d;

        g(com.tencent.mobileqq.zplan.servlet.d dVar) {
            this.f335374d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            if (!isSuccess || data == null) {
                ZPlanRequest.f335367a.i("getAppearanceKey failed.", this.f335374d);
                return;
            }
            getPb$RspBody getpb_rspbody = new getPb$RspBody();
            ZPlanRequest zPlanRequest = ZPlanRequest.f335367a;
            zPlanRequest.t((byte[]) data, getpb_rspbody);
            Map l3 = zPlanRequest.l(getpb_rspbody);
            com.tencent.mobileqq.zplan.servlet.d dVar = this.f335374d;
            if (l3 == null || l3.isEmpty()) {
                zPlanRequest.i("getAppearanceKeyMap failed.", dVar);
            } else {
                dVar.a(true, l3);
            }
        }
    }
}
