package nk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.bean.init.QZIntimateHistoryCalendarCardInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateCheckInProcessEvent;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetail;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetailEntity;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$HistoryReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$HistoryRsp;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$MemberSigninDetail;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$MemberSigninDetailEntity;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Setting;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninData;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninDataEntity;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninRsp;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$TodayReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$TodayRsp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile.OperationProfile$ShareParam;
import com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile.OperationProfile$ShareReq;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.ArrayUtils;
import com.tencent.util.QQToastUtil;
import ij.QZIntimateCheckInInfoBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nk.b;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!J\u0010\u0010$\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010%\u001a\u00020\u0003H\u0016J\u0006\u0010&\u001a\u00020\bJ\u0016\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003J\u0016\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003J&\u00101\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u001cR\"\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010+\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R.\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0<0;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010J\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010N\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010I\u00a8\u0006S"}, d2 = {"Lnk/b;", "Lcom/qzone/reborn/base/n;", "", "", "d2", "spaceId", "", "data", "", "f2", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$SigninRsp;", "i2", "signInRsp", "Lij/b;", "S1", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$TodayRsp;", "todayRsp", "U1", "m2", "g2", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$HistoryRsp;", "j2", "historyRsp", "T1", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$BusSigninDetail;", "signInDetail", "R1", "", "isArkShareSuccess", "", "errorCode", "t2", "Landroid/content/Intent;", "intent", "l2", "k2", "getLogTag", ICustomDataEditor.NUMBER_PARAM_2, "Lmqq/app/AppRuntime;", "app", "X1", "q2", "checkDate", "p2", "", "toUin", "fileId", "isFriendCheckInAlready", "W1", "i", "Ljava/lang/String;", "e2", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ICustomDataEditor.STRING_ARRAY_PARAM_2, "setCheckDate", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "setCheckInInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "checkInInfo", "D", "Z", "c2", "()Z", ICustomDataEditor.STRING_PARAM_2, "(Z)V", "inCheckInProcess", "E", "Z1", "r2", "autoShareQZoneSwitchOpen", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.qzone.reborn.base.n {

    /* renamed from: D, reason: from kotlin metadata */
    private boolean inCheckInProcess;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean autoShareQZoneSwitchOpen;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String spaceId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String checkDate = "";

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> checkInInfo = new MutableLiveData<>();

    private final QZIntimateCheckInInfoBean S1(String spaceId, GeneralSigninPB$SigninRsp signInRsp) {
        GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail = signInRsp.bus_detail.get();
        Intrinsics.checkNotNullExpressionValue(generalSigninPB$BusSigninDetail, "signInRsp.bus_detail.get()");
        return R1(spaceId, generalSigninPB$BusSigninDetail);
    }

    private final QZIntimateCheckInInfoBean T1(String spaceId, GeneralSigninPB$HistoryRsp historyRsp) {
        Object obj;
        if (ArrayUtils.isOutOfArrayIndex(0, historyRsp.bus_history.get())) {
            return null;
        }
        List<GeneralSigninPB$BusSigninDetailEntity> list = historyRsp.bus_history.get();
        Intrinsics.checkNotNullExpressionValue(list, "historyRsp.bus_history.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (TextUtils.equals(((GeneralSigninPB$BusSigninDetailEntity) obj).key.get(), "2")) {
                break;
            }
        }
        GeneralSigninPB$BusSigninDetailEntity generalSigninPB$BusSigninDetailEntity = (GeneralSigninPB$BusSigninDetailEntity) obj;
        GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail = generalSigninPB$BusSigninDetailEntity != null ? generalSigninPB$BusSigninDetailEntity.value : null;
        if (generalSigninPB$BusSigninDetail == null) {
            return null;
        }
        return R1(spaceId, generalSigninPB$BusSigninDetail);
    }

    private final QZIntimateCheckInInfoBean U1(String spaceId, GeneralSigninPB$TodayRsp todayRsp) {
        Object obj;
        if (ArrayUtils.isOutOfArrayIndex(0, todayRsp.bus_detail.get())) {
            return null;
        }
        List<GeneralSigninPB$BusSigninDetailEntity> list = todayRsp.bus_detail.get();
        Intrinsics.checkNotNullExpressionValue(list, "todayRsp.bus_detail.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (TextUtils.equals(((GeneralSigninPB$BusSigninDetailEntity) obj).key.get(), "2")) {
                break;
            }
        }
        GeneralSigninPB$BusSigninDetailEntity generalSigninPB$BusSigninDetailEntity = (GeneralSigninPB$BusSigninDetailEntity) obj;
        GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail = generalSigninPB$BusSigninDetailEntity != null ? generalSigninPB$BusSigninDetailEntity.value : null;
        if (generalSigninPB$BusSigninDetail == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "busTodayDetail is null");
            return null;
        }
        return R1(spaceId, generalSigninPB$BusSigninDetail);
    }

    private final List<String> d2() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("signin_notice_switch", "sync_qzone_switch", "sync_friend_switch");
        return mutableListOf;
    }

    private final GeneralSigninPB$SigninRsp i2(byte[] data) {
        try {
            return new GeneralSigninPB$SigninRsp().mergeFrom(data);
        } catch (Exception e16) {
            QLog.e("QZIntimateCheckInViewModel", 1, "parseTodayCheckInRspData exp is " + e16);
            return null;
        }
    }

    private final GeneralSigninPB$HistoryRsp j2(byte[] data) {
        try {
            return new GeneralSigninPB$HistoryRsp().mergeFrom(data);
        } catch (Exception e16) {
            QLog.e("QZIntimateCheckInViewModel", 1, "parseHistoryCheckInRspData exp is " + e16);
            return null;
        }
    }

    private final GeneralSigninPB$TodayRsp m2(byte[] data) {
        try {
            return new GeneralSigninPB$TodayRsp().mergeFrom(data);
        } catch (Exception e16) {
            QLog.e("QZIntimateCheckInViewModel", 1, "parseTodayCheckInRspData exp is " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZIntimateCheckInViewModel", 1, "inCheckInProcess become false");
        this$0.inCheckInProcess = false;
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateCheckInProcessEvent(true));
    }

    public final void W1(AppRuntime app, long toUin, String fileId, boolean isFriendCheckInAlready) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        OperationProfile$ShareReq operationProfile$ShareReq = new OperationProfile$ShareReq();
        operationProfile$ShareReq.activity_id.set(19);
        operationProfile$ShareReq.to_uin.set(toUin);
        operationProfile$ShareReq.to_group_code.set(0L);
        if (isFriendCheckInAlready) {
            operationProfile$ShareReq.select_tag.set("after");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ShortVideoConstants.FILE_UUID, fileId);
        jSONObject.put("store_id", 1);
        ArrayList arrayList = new ArrayList();
        OperationProfile$ShareParam operationProfile$ShareParam = new OperationProfile$ShareParam();
        operationProfile$ShareParam.key.set("signpic");
        operationProfile$ShareParam.value.set(jSONObject.toString());
        arrayList.add(operationProfile$ShareParam);
        OperationProfile$ShareParam operationProfile$ShareParam2 = new OperationProfile$ShareParam();
        operationProfile$ShareParam2.key.set("spaceid");
        operationProfile$ShareParam2.value.set(this.spaceId);
        arrayList.add(operationProfile$ShareParam2);
        operationProfile$ShareReq.share_params.set(arrayList);
        ProtoUtils.a(app, new C10850b(), operationProfile$ShareReq.toByteArray(), "OidbSvcTrpcTcp.0x911a", 37146, 19);
    }

    public final void X1(AppRuntime app, String spaceId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        QLog.i("QZIntimateCheckInViewModel", 1, "[doCheckInRequest] space id is " + spaceId);
        n2();
        GeneralSigninPB$SigninReq generalSigninPB$SigninReq = new GeneralSigninPB$SigninReq();
        generalSigninPB$SigninReq.bus_id.set("partner");
        generalSigninPB$SigninReq.target.set(spaceId);
        generalSigninPB$SigninReq.sub_bus_id.set("2");
        generalSigninPB$SigninReq.source.set("intimate");
        ProtoUtils.a(app, new c(spaceId), generalSigninPB$SigninReq.toByteArray(), "OidbSvcTrpcTcp.0x9144", 37188, 1);
    }

    /* renamed from: Z1, reason: from getter */
    public final boolean getAutoShareQZoneSwitchOpen() {
        return this.autoShareQZoneSwitchOpen;
    }

    /* renamed from: a2, reason: from getter */
    public final String getCheckDate() {
        return this.checkDate;
    }

    public final MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> b2() {
        return this.checkInInfo;
    }

    /* renamed from: c2, reason: from getter */
    public final boolean getInCheckInProcess() {
        return this.inCheckInProcess;
    }

    /* renamed from: e2, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZIntimateCheckInViewModel";
    }

    public final void n2() {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateCheckInProcessEvent(false));
        this.inCheckInProcess = true;
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: nk.a
            @Override // java.lang.Runnable
            public final void run() {
                b.o2(b.this);
            }
        }, 1500L);
    }

    public final void p2(String spaceId, String checkDate) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(checkDate, "checkDate");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QLog.i("QZIntimateCheckInViewModel", 1, "[HistoryCheckInRequest] space id is " + spaceId + ", checkDate is " + checkDate);
        GeneralSigninPB$HistoryReq generalSigninPB$HistoryReq = new GeneralSigninPB$HistoryReq();
        generalSigninPB$HistoryReq.bus_id.set("partner");
        generalSigninPB$HistoryReq.target.set(spaceId);
        ArrayList arrayList = new ArrayList();
        arrayList.add("2");
        generalSigninPB$HistoryReq.sub_bus_id.set(arrayList);
        generalSigninPB$HistoryReq.start_date.set(checkDate);
        generalSigninPB$HistoryReq.end_date.set(checkDate);
        generalSigninPB$HistoryReq.source.set("intimate");
        generalSigninPB$HistoryReq.need_detail.set(true);
        ProtoUtils.a(peekAppRuntime, new d(spaceId), generalSigninPB$HistoryReq.toByteArray(), "OidbSvcTrpcTcp.0x9147", 37191, 1);
    }

    public final void q2(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QLog.i("QZIntimateCheckInViewModel", 1, "[TodayCheckInRequest] space id is " + spaceId);
        GeneralSigninPB$TodayReq generalSigninPB$TodayReq = new GeneralSigninPB$TodayReq();
        generalSigninPB$TodayReq.bus_id.set("partner");
        generalSigninPB$TodayReq.target.set(spaceId);
        ArrayList arrayList = new ArrayList();
        arrayList.add("2");
        generalSigninPB$TodayReq.sub_bus_id.set(arrayList);
        generalSigninPB$TodayReq.source.set("intimate");
        generalSigninPB$TodayReq.need_settings.set(d2());
        ProtoUtils.a(peekAppRuntime, new e(spaceId), generalSigninPB$TodayReq.toByteArray(), "OidbSvcTrpcTcp.0x9146", 37190, 1);
    }

    public final void r2(boolean z16) {
        this.autoShareQZoneSwitchOpen = z16;
    }

    public final void s2(boolean z16) {
        this.inCheckInProcess = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String spaceId, byte[] data) {
        if (data == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleTodayCheckInRsp error, data is null");
            return;
        }
        GeneralSigninPB$SigninRsp i26 = i2(data);
        if (i26 == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleTodayCheckInRsp error, data parse error");
            return;
        }
        this.checkInInfo.postValue(UIStateData.obtainSuccess(false).setData(false, S1(spaceId, i26)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String spaceId, byte[] data) {
        if (data == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleHistoryCheckInRspData error, data is null");
            return;
        }
        GeneralSigninPB$HistoryRsp j26 = j2(data);
        if (j26 == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleHistoryCheckInRsp error, data parse error");
            return;
        }
        this.checkInInfo.postValue(UIStateData.obtainSuccess(false).setData(false, T1(spaceId, j26)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(String spaceId, byte[] data) {
        if (data == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleTodayCheckInRsp error, data is null");
            return;
        }
        GeneralSigninPB$TodayRsp m26 = m2(data);
        if (m26 == null) {
            QLog.e("QZIntimateCheckInViewModel", 1, "handleTodayCheckInRsp error, data parse error");
            return;
        }
        this.checkInInfo.postValue(UIStateData.obtainSuccess(false).setData(false, U1(spaceId, m26)));
    }

    public final void k2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof QZIntimateHistoryCalendarCardInitBean) {
            QZIntimateHistoryCalendarCardInitBean qZIntimateHistoryCalendarCardInitBean = (QZIntimateHistoryCalendarCardInitBean) serializable;
            this.spaceId = qZIntimateHistoryCalendarCardInitBean.getSpaceId();
            this.checkDate = qZIntimateHistoryCalendarCardInitBean.getCheckDate();
        }
    }

    public final void l2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof QZoneIntimateMainPageInitBean) {
            this.spaceId = ((QZoneIntimateMainPageInitBean) serializable).getSpaceId();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/b$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f420334e;

        c(String str) {
            this.f420334e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, String spaceId, byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
            this$0.f2(spaceId, bArr);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateCheckInViewModel", 1, "doCheckInRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            b.this.s2(false);
            b.this.b2().postValue(UIStateData.obtainError("DO_CHECK_IN_FAIL").setRetCode((long) errorCode));
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, final byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final b bVar = b.this;
                final String str = this.f420334e;
                rFWThreadManager.execOnSubThread(new Runnable() { // from class: nk.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c.c(b.this, str, data);
                    }
                });
                return;
            }
            QLog.e("QZIntimateCheckInViewModel", 1, "doCheckInRequest fail, fail code is " + errorCode);
            b.this.s2(false);
            b.this.b2().postValue(UIStateData.obtainError("DO_CHECK_IN_FAIL").setRetCode((long) errorCode));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/b$d", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f420336e;

        d(String str) {
            this.f420336e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, String spaceId, byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
            this$0.g2(spaceId, bArr);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateCheckInViewModel", 1, "requestTodayCheckInRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            b.this.b2().postValue(UIStateData.obtainError(errorMsg).setRetCode((long) errorCode));
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, final byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final b bVar = b.this;
                final String str = this.f420336e;
                rFWThreadManager.execOnSubThread(new Runnable() { // from class: nk.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d.c(b.this, str, data);
                    }
                });
                return;
            }
            QLog.e("QZIntimateCheckInViewModel", 1, "requestHistoryCheckInRequest fail, fail code is " + errorCode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/b$e", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f420338e;

        e(String str) {
            this.f420338e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, String spaceId, byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
            this$0.h2(spaceId, bArr);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateCheckInViewModel", 1, "requestTodayCheckInRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            b.this.b2().postValue(UIStateData.obtainError(errorMsg).setRetCode((long) errorCode));
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, final byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final b bVar = b.this;
                final String str = this.f420338e;
                rFWThreadManager.execOnSubThread(new Runnable() { // from class: nk.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.e.c(b.this, str, data);
                    }
                });
                return;
            }
            QLog.e("QZIntimateCheckInViewModel", 1, "requestTodayCheckInRequest fail, fail code is " + errorCode);
        }
    }

    private final QZIntimateCheckInInfoBean R1(String spaceId, GeneralSigninPB$BusSigninDetail signInDetail) {
        Object obj;
        GeneralSigninPB$MemberSigninDetail generalSigninPB$MemberSigninDetail;
        Object obj2;
        GeneralSigninPB$SigninData generalSigninPB$SigninData;
        Object obj3;
        String format;
        try {
            QZIntimateCheckInInfoBean qZIntimateCheckInInfoBean = new QZIntimateCheckInInfoBean(null, 0, null, null, null, null, null, false, 0L, false, 0L, null, null, null, null, null, null, false, false, null, 1048575, null);
            qZIntimateCheckInInfoBean.G(spaceId);
            qZIntimateCheckInInfoBean.B(true);
            String str = signInDetail.material.background_image_url.get();
            Intrinsics.checkNotNullExpressionValue(str, "signInDetail.material.background_image_url.get()");
            qZIntimateCheckInInfoBean.s(str);
            String str2 = signInDetail.material.theme_color.get();
            Intrinsics.checkNotNullExpressionValue(str2, "signInDetail.material.theme_color.get()");
            qZIntimateCheckInInfoBean.J(str2);
            String str3 = signInDetail.material.calendar_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "signInDetail.material.calendar_url.get()");
            qZIntimateCheckInInfoBean.x(str3);
            qZIntimateCheckInInfoBean.I(signInDetail.bus_info.type.get());
            String str4 = signInDetail.bus_info.name.get();
            Intrinsics.checkNotNullExpressionValue(str4, "signInDetail.bus_info.name.get()");
            qZIntimateCheckInInfoBean.H(str4);
            qZIntimateCheckInInfoBean.E(signInDetail.material.share_button.get());
            qZIntimateCheckInInfoBean.F(signInDetail.material.signin_button.get());
            qZIntimateCheckInInfoBean.y(signInDetail.all_count.continuous_signin_days.get());
            List<GeneralSigninPB$Setting> list = signInDetail.settings.get();
            Intrinsics.checkNotNullExpressionValue(list, "signInDetail.settings.get()");
            qZIntimateCheckInInfoBean.D(list);
            if (!ArrayUtils.isOutOfArrayIndex(0, signInDetail.member_detail.get())) {
                Iterator<GeneralSigninPB$MemberSigninDetailEntity> it = signInDetail.member_detail.get().iterator();
                while (it.hasNext()) {
                    String str5 = it.next().key.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "memberInfo.key.get()");
                    long parseLong = Long.parseLong(str5);
                    if (LoginData.getInstance().getUin() != parseLong) {
                        qZIntimateCheckInInfoBean.A(parseLong);
                    }
                    QLog.i("QZIntimateCheckInViewModel", 1, "member uin is " + parseLong);
                    qZIntimateCheckInInfoBean.i().add(Long.valueOf(parseLong));
                }
            }
            if (ArrayUtils.isOutOfArrayIndex(0, signInDetail.member_detail.get())) {
                QLog.e("QZIntimateCheckInViewModel", 1, "member detail is empty");
                return qZIntimateCheckInInfoBean;
            }
            List<GeneralSigninPB$MemberSigninDetailEntity> list2 = signInDetail.member_detail.get();
            Intrinsics.checkNotNullExpressionValue(list2, "signInDetail.member_detail.get()");
            Iterator<T> it5 = list2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it5.next();
                if (TextUtils.equals(String.valueOf(LoginData.getInstance().getUin()), ((GeneralSigninPB$MemberSigninDetailEntity) obj).key.get())) {
                    break;
                }
            }
            GeneralSigninPB$MemberSigninDetailEntity generalSigninPB$MemberSigninDetailEntity = (GeneralSigninPB$MemberSigninDetailEntity) obj;
            if (generalSigninPB$MemberSigninDetailEntity != null && (generalSigninPB$MemberSigninDetail = generalSigninPB$MemberSigninDetailEntity.value) != null) {
                if (ArrayUtils.isOutOfArrayIndex(0, generalSigninPB$MemberSigninDetail.list.get())) {
                    QLog.e("QZIntimateCheckInViewModel", 1, "selfSignInDetail is empty");
                    return qZIntimateCheckInInfoBean;
                }
                List<GeneralSigninPB$SigninDataEntity> list3 = generalSigninPB$MemberSigninDetail.list.get();
                Intrinsics.checkNotNullExpressionValue(list3, "selfSignInDetail.list.get()");
                Iterator<T> it6 = list3.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it6.next();
                    GeneralSigninPB$SigninDataEntity generalSigninPB$SigninDataEntity = (GeneralSigninPB$SigninDataEntity) obj2;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
                    if (!TextUtils.isEmpty(this.checkDate)) {
                        format = this.checkDate;
                    } else {
                        format = simpleDateFormat.format(date);
                    }
                    if (TextUtils.equals(format, generalSigninPB$SigninDataEntity.key.get())) {
                        break;
                    }
                }
                GeneralSigninPB$SigninDataEntity generalSigninPB$SigninDataEntity2 = (GeneralSigninPB$SigninDataEntity) obj2;
                if (generalSigninPB$SigninDataEntity2 != null && (generalSigninPB$SigninData = generalSigninPB$SigninDataEntity2.value) != null) {
                    String str6 = generalSigninPB$SigninData.card.backgroup_image_url.get();
                    Intrinsics.checkNotNullExpressionValue(str6, "selfSignInData.card.backgroup_image_url.get()");
                    qZIntimateCheckInInfoBean.t(str6);
                    String str7 = generalSigninPB$SigninData.card.content.get();
                    Intrinsics.checkNotNullExpressionValue(str7, "selfSignInData.card.content.get()");
                    qZIntimateCheckInInfoBean.u(str7);
                    String str8 = generalSigninPB$SigninData.card.content_source.get();
                    Intrinsics.checkNotNullExpressionValue(str8, "selfSignInData.card.content_source.get()");
                    qZIntimateCheckInInfoBean.v(str8);
                    String str9 = generalSigninPB$SigninData.card.daily_tips.get();
                    Intrinsics.checkNotNullExpressionValue(str9, "selfSignInData.card.daily_tips.get()");
                    qZIntimateCheckInInfoBean.w(str9);
                    qZIntimateCheckInInfoBean.C(generalSigninPB$SigninData.status.get() == 1);
                    QLog.i("QZIntimateCheckInViewModel", 1, "isSelfCheckInAlready is " + qZIntimateCheckInInfoBean.getIsSelfCheckInAlready());
                    List<GeneralSigninPB$MemberSigninDetailEntity> list4 = signInDetail.member_detail.get();
                    Intrinsics.checkNotNullExpressionValue(list4, "signInDetail.member_detail.get()");
                    Iterator<T> it7 = list4.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it7.next();
                        if (!TextUtils.equals(String.valueOf(LoginData.getInstance().getUin()), ((GeneralSigninPB$MemberSigninDetailEntity) obj3).key.get())) {
                            break;
                        }
                    }
                    GeneralSigninPB$MemberSigninDetailEntity generalSigninPB$MemberSigninDetailEntity2 = (GeneralSigninPB$MemberSigninDetailEntity) obj3;
                    GeneralSigninPB$MemberSigninDetail generalSigninPB$MemberSigninDetail2 = generalSigninPB$MemberSigninDetailEntity2 != null ? generalSigninPB$MemberSigninDetailEntity2.value : null;
                    if (generalSigninPB$MemberSigninDetail2 == null || ArrayUtils.isOutOfArrayIndex(0, generalSigninPB$MemberSigninDetail2.list.get())) {
                        return qZIntimateCheckInInfoBean;
                    }
                    qZIntimateCheckInInfoBean.z(generalSigninPB$MemberSigninDetail2.list.get(0).value.status.get() == 1);
                }
            }
            return qZIntimateCheckInInfoBean;
        } catch (Exception e16) {
            QLog.e("QZIntimateCheckInViewModel", 1, "convertSignInDetailIntoCheckInBean exp is " + e16);
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/b$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nk.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10850b extends ProtoUtils.TroopProtocolObserver {
        C10850b() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateCheckInViewModel", 1, "doArkShareRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            b.this.t2(false, errorCode);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                b.this.t2(true, 0);
                return;
            }
            QLog.e("QZIntimateCheckInViewModel", 1, "doArkShareRequest fail, fail code is " + errorCode);
            b.this.t2(false, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2(boolean isArkShareSuccess, int errorCode) {
        int i3;
        String str;
        switch (errorCode) {
            case 901505:
            case 901506:
                i3 = 4;
                break;
            default:
                i3 = 5;
                break;
        }
        if (isArkShareSuccess && mk.d.f416875a.K() && this.autoShareQZoneSwitchOpen) {
            str = "\u5df2\u6253\u5361\u5e76\u5206\u4eab\u5230\u5bf9\u65b9\u548cQQ\u7a7a\u95f4";
        } else if (isArkShareSuccess && (!mk.d.f416875a.K() || !this.autoShareQZoneSwitchOpen)) {
            str = "\u6253\u5361\u6210\u529f\uff0c\u5df2\u540c\u6b65\u5206\u4eab\u5bf9\u65b9";
        } else if (!isArkShareSuccess && mk.d.f416875a.K() && this.autoShareQZoneSwitchOpen) {
            str = "\u6253\u5361\u6210\u529f\uff0c\u5df2\u540c\u6b65\u5230QQ\u7a7a\u95f4";
        } else if (!isArkShareSuccess && (errorCode == 901505 || errorCode == 901506)) {
            str = "\u6253\u5361\u6210\u529f, \u53d1\u9001\u5206\u4eab\u5931\u8d25";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QZIntimateCheckInViewModel", 1, "toast msg is empty");
        } else {
            QQToastUtil.showQQToastInUiThread(i3, str);
        }
    }
}
