package nk;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$GetSettingReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$GetSettingRsp;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SetSettingReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Setting;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SettingEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nk.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bR.\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lnk/p;", "Lcom/qzone/reborn/base/n;", "", "data", "", "R1", "Lcom/tencent/mobileqq/partner/signin/pb/GeneralSigninPB$GetSettingRsp;", "X1", "", "settingKey", "settingValue", "W1", "getLogTag", "settingName", "spaceId", "T1", "", "isInit", "U1", "Lmqq/app/AppRuntime;", "app", "Q1", "S1", "O1", "Z1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setSettingList", "(Landroidx/lifecycle/MutableLiveData;)V", "settingList", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class p extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<List<QZIntimateSettingItemBean>> settingList = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/p$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f420373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f420374f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f420375h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f420376i;

        c(String str, String str2, boolean z16, String str3) {
            this.f420373e = str;
            this.f420374f = str2;
            this.f420375h = z16;
            this.f420376i = str3;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateSettingViewModel", 1, "modifySettingRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            p pVar = p.this;
            String str = this.f420373e;
            String str2 = "true";
            if (TextUtils.equals(this.f420374f, "true")) {
                str2 = "false";
            }
            pVar.W1(str, str2);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            if (errorCode != 0) {
                QLog.e("QZIntimateSettingViewModel", 1, "modifySettingRequest fail, fail code is " + errorCode);
                p pVar = p.this;
                String str = this.f420373e;
                String str2 = "true";
                if (TextUtils.equals(this.f420374f, "true")) {
                    str2 = "false";
                }
                pVar.W1(str, str2);
                return;
            }
            if (this.f420375h) {
                QLog.i("QZIntimateSettingViewModel", 1, "init modify, clear old MMKV key");
                com.qzone.reborn.util.i.b().t(mk.d.f416875a.e(this.f420376i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(String settingKey, String settingValue) {
        Object obj;
        List<QZIntimateSettingItemBean> value = this.settingList.getValue();
        List<QZIntimateSettingItemBean> list = value;
        if (list == null || list.isEmpty()) {
            QLog.e("QZIntimateSettingViewModel", 1, "[modifySettingValue] setting list is empty");
            return;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (TextUtils.equals(settingKey, ((QZIntimateSettingItemBean) obj).getKey())) {
                    break;
                }
            }
        }
        QZIntimateSettingItemBean qZIntimateSettingItemBean = (QZIntimateSettingItemBean) obj;
        if (qZIntimateSettingItemBean != null) {
            qZIntimateSettingItemBean.setValue(settingValue);
        }
        this.settingList.postValue(value);
    }

    private final GeneralSigninPB$GetSettingRsp X1(byte[] data) {
        try {
            return new GeneralSigninPB$GetSettingRsp().mergeFrom(data);
        } catch (Exception e16) {
            QLog.e("QZIntimateSettingViewModel", 1, "parseGetSettingRspData exp is " + e16);
            return null;
        }
    }

    public final boolean O1(String settingKey) {
        Object obj;
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        List<QZIntimateSettingItemBean> value = this.settingList.getValue();
        List<QZIntimateSettingItemBean> list = value;
        if (list == null || list.isEmpty()) {
            QLog.e("QZIntimateSettingViewModel", 1, "[containsSetting] setting list is empty");
            return false;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (TextUtils.equals(settingKey, ((QZIntimateSettingItemBean) obj).getKey())) {
                break;
            }
        }
        return ((QZIntimateSettingItemBean) obj) != null;
    }

    public final MutableLiveData<List<QZIntimateSettingItemBean>> P1() {
        return this.settingList;
    }

    public final void Q1(AppRuntime app, String spaceId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        if (TextUtils.isEmpty(spaceId)) {
            QLog.e("QZIntimateSettingViewModel", 1, "space id is empty");
            return;
        }
        GeneralSigninPB$GetSettingReq generalSigninPB$GetSettingReq = new GeneralSigninPB$GetSettingReq();
        generalSigninPB$GetSettingReq.bus_id.set("partner");
        generalSigninPB$GetSettingReq.target.set(spaceId);
        generalSigninPB$GetSettingReq.sub_bus_id.set("2");
        generalSigninPB$GetSettingReq.source.set("intimate");
        ProtoUtils.a(app, new b(), generalSigninPB$GetSettingReq.toByteArray(), "OidbSvcTrpcTcp.0x92ed", 37613, 1);
    }

    public final boolean S1() {
        List<QZIntimateSettingItemBean> value = this.settingList.getValue();
        return !(value == null || value.isEmpty());
    }

    public final void T1(String settingName, String spaceId, String settingValue) {
        Intrinsics.checkNotNullParameter(settingName, "settingName");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(settingValue, "settingValue");
        U1(settingName, spaceId, settingValue, false);
    }

    public final void U1(String settingName, String spaceId, String settingValue, boolean isInit) {
        Intrinsics.checkNotNullParameter(settingName, "settingName");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(settingValue, "settingValue");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QLog.i("QZIntimateSettingViewModel", 1, "[modifySettingRequest] setting name is " + settingName + ", setting value is " + settingValue);
        W1(settingName, settingValue);
        GeneralSigninPB$SetSettingReq generalSigninPB$SetSettingReq = new GeneralSigninPB$SetSettingReq();
        generalSigninPB$SetSettingReq.bus_id.set("partner");
        generalSigninPB$SetSettingReq.target.set(spaceId);
        generalSigninPB$SetSettingReq.sub_bus_id.set("2");
        generalSigninPB$SetSettingReq.source.set("intimate");
        ArrayList arrayList = new ArrayList();
        GeneralSigninPB$SettingEntity generalSigninPB$SettingEntity = new GeneralSigninPB$SettingEntity();
        generalSigninPB$SettingEntity.key.set(settingName);
        generalSigninPB$SettingEntity.value.set(settingValue);
        arrayList.add(generalSigninPB$SettingEntity);
        generalSigninPB$SetSettingReq.settings.set(arrayList);
        ProtoUtils.a(peekAppRuntime, new c(settingName, settingValue, isInit, spaceId), generalSigninPB$SetSettingReq.toByteArray(), "OidbSvcTrpcTcp.0x92ee", 37614, 1);
    }

    public final boolean Z1(String settingKey) {
        Object obj;
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        List<QZIntimateSettingItemBean> value = this.settingList.getValue();
        List<QZIntimateSettingItemBean> list = value;
        if (list == null || list.isEmpty()) {
            QLog.e("QZIntimateSettingViewModel", 1, "[querySettingValue] setting list is empty");
            return false;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (TextUtils.equals(settingKey, ((QZIntimateSettingItemBean) obj).getKey())) {
                break;
            }
        }
        QZIntimateSettingItemBean qZIntimateSettingItemBean = (QZIntimateSettingItemBean) obj;
        QLog.i("QZIntimateSettingViewModel", 1, "[querySettingValue], setting name is " + settingKey + ", value is " + (qZIntimateSettingItemBean != null ? qZIntimateSettingItemBean.getValue() : null));
        if (qZIntimateSettingItemBean != null) {
            return TextUtils.equals(qZIntimateSettingItemBean.getValue(), "true");
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZIntimateSettingViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(byte[] data) {
        if (data == null) {
            QLog.e("QZIntimateSettingViewModel", 1, "handleGetSettingRsp error, data is null");
            return;
        }
        GeneralSigninPB$GetSettingRsp X1 = X1(data);
        if (X1 == null) {
            QLog.e("QZIntimateSettingViewModel", 1, "handleGetSettingRsp error, data parse error");
            return;
        }
        for (GeneralSigninPB$Setting generalSigninPB$Setting : X1.settings.get()) {
            QLog.i("QZIntimateSettingViewModel", 2, "setting key name is " + generalSigninPB$Setting.name + ", desc is " + generalSigninPB$Setting.desc + ", value is " + generalSigninPB$Setting.value);
        }
        MutableLiveData<List<QZIntimateSettingItemBean>> mutableLiveData = this.settingList;
        List<GeneralSigninPB$Setting> list = X1.settings.get();
        Intrinsics.checkNotNullExpressionValue(list, "resultData.settings.get()");
        mutableLiveData.postValue(ef.d.p(list));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/p$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(p this$0, byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.R1(bArr);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e("QZIntimateSettingViewModel", 1, "getSettingRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, final byte[] data, Bundle bundle) {
            if (errorCode == 0 && data != null) {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final p pVar = p.this;
                rFWThreadManager.execOnSubThread(new Runnable() { // from class: nk.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        p.b.c(p.this, data);
                    }
                });
            } else {
                QLog.e("QZIntimateSettingViewModel", 1, "getSettingRequest fail, fail code is " + errorCode);
            }
        }
    }
}
