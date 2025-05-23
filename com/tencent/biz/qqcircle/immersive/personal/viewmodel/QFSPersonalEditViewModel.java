package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.content.Intent;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetProfileRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleProfile$SetProfileRsp;
import qqcircle.QQCircleProfile$StModifyLimitItem;
import qqcircle.QQCircleProfile$StProfileBizData;

/* loaded from: classes4.dex */
public class QFSPersonalEditViewModel extends BaseViewModel {
    public static final String[] M = {"\u8bf7\u9009\u62e9", "\u7537", "\u5973"};
    public static final String[] N = {"\u8bf7\u9009\u62e9", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7"};
    private QCircleEditProfileBean K;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<FrequencyItem> f89114i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<FrequencyItem> f89115m = new MutableLiveData<>();
    public MutableLiveData<Integer> C = new MutableLiveData<>();
    public MutableLiveData<Integer> D = new MutableLiveData<>();
    public MutableLiveData<School> E = new MutableLiveData<>();
    public MutableLiveData<e> F = new MutableLiveData<>();
    public MutableLiveData<FrequencyItem> G = new MutableLiveData<>();
    public MutableLiveData<d> H = new MutableLiveData<>();
    public MutableLiveData<Group> I = new MutableLiveData<>();
    public MutableLiveData<Integer> J = new MutableLiveData<>();
    private ITaskListener.Stub L = new b();

    /* loaded from: classes4.dex */
    public static class FrequencyControl implements Serializable {
        public int allowNum;
        public int limitType;
        public int totalNum;

        public void decreaseNum() {
            int i3 = this.allowNum;
            if (i3 > 0) {
                this.allowNum = i3 - 1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class FrequencyItem extends FrequencyControl implements Cloneable {
        public String showText;

        public FrequencyItem(String str) {
            this.showText = str;
        }

        @NonNull
        protected Object clone() {
            FrequencyItem frequencyItem;
            CloneNotSupportedException e16;
            try {
                frequencyItem = (FrequencyItem) super.clone();
                try {
                    frequencyItem.showText = this.showText;
                    frequencyItem.allowNum = this.allowNum;
                    frequencyItem.totalNum = this.totalNum;
                    frequencyItem.limitType = this.limitType;
                } catch (CloneNotSupportedException e17) {
                    e16 = e17;
                    QLog.e("QFSPersonalEditViewModel", 1, "clone... exception:", e16);
                    return frequencyItem;
                }
            } catch (CloneNotSupportedException e18) {
                frequencyItem = null;
                e16 = e18;
            }
            return frequencyItem;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("FrequencyItem{\n");
            stringBuffer.append("totalNum=");
            stringBuffer.append(this.totalNum);
            stringBuffer.append('\n');
            stringBuffer.append(", allowNum=");
            stringBuffer.append(this.allowNum);
            stringBuffer.append('\n');
            stringBuffer.append(", limitType=");
            stringBuffer.append(this.limitType);
            stringBuffer.append('\n');
            stringBuffer.append(", showText='");
            stringBuffer.append(this.showText);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Group implements Serializable {
        public final ArrayList<Long> idList;
        public boolean needShow;
        public String showText;

        public Group(boolean z16, String str, ArrayList<Long> arrayList) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            this.idList = arrayList2;
            this.needShow = z16;
            this.showText = str;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
        }

        public void setIdList(ArrayList<Long> arrayList) {
            this.idList.clear();
            this.idList.addAll(arrayList);
        }

        public void setShowText(String str) {
            this.showText = str;
        }

        public String toString() {
            return "Group{needShow=" + this.needShow + ", showText='" + this.showText + "', idList=" + this.idList + '}';
        }
    }

    /* loaded from: classes4.dex */
    public static final class School extends FrequencyControl {
        public String schoolName;
        public boolean showSchool;

        public School() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("School{\n");
            stringBuffer.append("totalNum=");
            stringBuffer.append(this.totalNum);
            stringBuffer.append('\n');
            stringBuffer.append(", allowNum=");
            stringBuffer.append(this.allowNum);
            stringBuffer.append('\n');
            stringBuffer.append(", limitType=");
            stringBuffer.append(this.limitType);
            stringBuffer.append('\n');
            stringBuffer.append(", showSchool=");
            stringBuffer.append(this.showSchool);
            stringBuffer.append('\n');
            stringBuffer.append(", schoolName='");
            stringBuffer.append(this.schoolName);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        public School(boolean z16, String str, int i3) {
            this.showSchool = z16;
            this.schoolName = str;
            this.allowNum = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f89116a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f89117b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VSDispatchObserver.OnVSRspCallBack f89118c;

        a(int i3, Object obj, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
            this.f89116a = i3;
            this.f89117b = obj;
            this.f89118c = onVSRspCallBack;
        }

        private void d(int i3, Object obj) {
            boolean z16;
            QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent = new QCirclePersonEditUpdateEvent();
            QLog.d("QFSPersonalEditViewModel", 1, "sendProfileChangeEvent... type:" + i3 + " value:" + obj.toString());
            if (i3 != 10008) {
                if (i3 != 10021) {
                    if (i3 != 10023) {
                        if (i3 != 10025) {
                            switch (i3) {
                                case 10001:
                                    FrequencyItem frequencyItem = (FrequencyItem) obj;
                                    frequencyItem.decreaseNum();
                                    qCirclePersonEditUpdateEvent.setNick(frequencyItem);
                                    uq3.c.g7(frequencyItem.showText);
                                    break;
                                case 10002:
                                    qCirclePersonEditUpdateEvent.setGender(((Integer) obj).intValue());
                                    break;
                                case 10003:
                                    qCirclePersonEditUpdateEvent.setLocation((e) obj);
                                    break;
                                default:
                                    switch (i3) {
                                        case 10015:
                                            if (obj instanceof Group) {
                                                qCirclePersonEditUpdateEvent.setGroupInfoList((Group) obj);
                                                break;
                                            }
                                            break;
                                        case 10016:
                                            qCirclePersonEditUpdateEvent.setCompany((String) obj);
                                            break;
                                        case 10017:
                                            qCirclePersonEditUpdateEvent.setConstellation(((Integer) obj).intValue());
                                            break;
                                        case 10018:
                                            qCirclePersonEditUpdateEvent.setSchool((String) obj);
                                            break;
                                    }
                            }
                        } else {
                            FrequencyItem frequencyItem2 = (FrequencyItem) obj;
                            frequencyItem2.decreaseNum();
                            uq3.c.d7(frequencyItem2.showText);
                            qCirclePersonEditUpdateEvent.setAvatar(frequencyItem2);
                        }
                    } else {
                        if (((Integer) obj).intValue() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        qCirclePersonEditUpdateEvent.setShowSchool(z16);
                    }
                } else {
                    com.tencent.biz.qqcircle.immersive.personal.bean.s sVar = (com.tencent.biz.qqcircle.immersive.personal.bean.s) obj;
                    qCirclePersonEditUpdateEvent.setGuild(new d(sVar.g(), sVar.a(), sVar.b()));
                }
            } else {
                FrequencyItem frequencyItem3 = (FrequencyItem) obj;
                frequencyItem3.decreaseNum();
                qCirclePersonEditUpdateEvent.setDesc(frequencyItem3);
            }
            SimpleEventBus.getInstance().dispatchEvent(qCirclePersonEditUpdateEvent, !ProcessUtil.isMainProcess(QCircleApplication.getAPP()));
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onReceive(final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
            QLog.d("QFSPersonalEditViewModel", 1, "setProfile... onReceive... isSuccess:" + z16 + " retCode:" + j3);
            if (z16 && j3 == 0 && qQCircleProfile$SetProfileRsp != null) {
                d(this.f89116a, this.f89117b);
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final VSDispatchObserver.OnVSRspCallBack onVSRspCallBack = this.f89118c;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.k
                @Override // java.lang.Runnable
                public final void run() {
                    VSDispatchObserver.OnVSRspCallBack.this.onReceive(baseRequest, z16, j3, str, qQCircleProfile$SetProfileRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends ITaskListener.Stub {

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> {
            a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetProfileRsp qQCircleProfile$SetProfileRsp) {
                if (z16 && j3 == 0 && qQCircleProfile$SetProfileRsp != null) {
                    QFSPersonalEditViewModel.this.J.postValue(2);
                    return;
                }
                if (uq3.l.b().a(j3)) {
                    QCircleToast.p(str, 0, true);
                    QFSPersonalEditViewModel.this.J.postValue(2);
                } else {
                    QFSPersonalEditViewModel.this.J.postValue(1);
                }
                QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CHANGE_FAIL, "ev_xsj_abnormal_imp");
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) throws RemoteException {
            QLog.d("QFSPersonalEditViewModel", 1, "onTaskChange...");
            if (taskInfo.isFinish() && taskInfo.getMediaInfos().size() > 0 && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
                QFSPersonalEditViewModel.this.b2(taskInfo, new a());
                QFSPersonalEditViewModel.this.d2();
            } else if (taskInfo.isCancelled()) {
                QFSPersonalEditViewModel.this.J.postValue(1);
                QFSPersonalEditInfoPart.va(QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_CHANGE_FAIL, "ev_xsj_abnormal_imp");
                QFSPersonalEditViewModel.this.d2();
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f89121a;

        c(String str) {
            this.f89121a = str;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            QLog.d("QFSPersonalEditViewModel", 1, "publishAvatar... path\uff1a" + this.f89121a);
            winkPublishServiceProxy2.addTaskListener2(QFSPersonalEditViewModel.this.L);
            ja0.a.f409680a.f(this.f89121a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f89123a;

        /* renamed from: b, reason: collision with root package name */
        public String f89124b;

        /* renamed from: c, reason: collision with root package name */
        public long f89125c;

        public d() {
        }

        public d(boolean z16, long j3, String str) {
            this.f89123a = z16;
            this.f89124b = str;
            this.f89125c = j3;
        }
    }

    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public String f89126a;

        /* renamed from: b, reason: collision with root package name */
        public String f89127b;

        public e(String str, String str2) {
            this.f89126a = str;
            this.f89127b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (!this.f89126a.equals(eVar.f89126a)) {
                return false;
            }
            return this.f89127b.equals(eVar.f89127b);
        }

        public int hashCode() {
            return (this.f89126a.hashCode() * 31) + this.f89127b.hashCode();
        }
    }

    private void e2(int i3, List<QQCircleProfile$StModifyLimitItem> list, FrequencyControl frequencyControl) {
        QQCircleProfile$StModifyLimitItem U1 = U1(i3, list);
        if (U1 != null) {
            frequencyControl.allowNum = U1.allowNum.get();
            frequencyControl.totalNum = U1.totalNum.get();
            frequencyControl.limitType = U1.limitType.get();
        }
    }

    public static void f2(int i3, Object obj, VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> onVSRspCallBack) {
        QCircleSetProfileRequest qCircleSetProfileRequest = new QCircleSetProfileRequest(i3, obj);
        QLog.d("QFSPersonalEditViewModel", 1, "setProfile... type:" + i3 + " value:" + obj.toString());
        VSNetworkHelper.getInstance().sendRequest(qCircleSetProfileRequest, new a(i3, obj, onVSRspCallBack));
    }

    public static void h2(int i3, QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData, FrequencyItem frequencyItem) {
        if (qQCircleProfile$StProfileBizData != null) {
            ArrayList arrayList = (ArrayList) qQCircleProfile$StProfileBizData.modifyLimitFields.get();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                if (((QQCircleProfile$StModifyLimitItem) arrayList.get(i16)).type.get() == i3) {
                    ((QQCircleProfile$StModifyLimitItem) arrayList.get(i16)).allowNum.set(frequencyItem.allowNum);
                }
            }
        }
    }

    public MutableLiveData<FrequencyItem> M1() {
        return this.f89114i;
    }

    public MutableLiveData<Integer> N1() {
        return this.J;
    }

    public MutableLiveData<d> O1() {
        return this.H;
    }

    public MutableLiveData<Integer> P1() {
        return this.D;
    }

    public MutableLiveData<FrequencyItem> Q1() {
        return this.G;
    }

    public QCircleEditProfileBean R1() {
        return this.K;
    }

    public MutableLiveData<Integer> S1() {
        return this.C;
    }

    public MutableLiveData<e> T1() {
        return this.F;
    }

    public QQCircleProfile$StModifyLimitItem U1(int i3, List<QQCircleProfile$StModifyLimitItem> list) {
        if (list == null) {
            return null;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (list.get(i16).type.get() == i3) {
                return list.get(i16);
            }
        }
        return null;
    }

    public MutableLiveData<FrequencyItem> W1() {
        return this.f89115m;
    }

    public MutableLiveData<Group> X1() {
        return this.I;
    }

    public MutableLiveData<School> Z1() {
        return this.E;
    }

    public void a2(Intent intent) {
        List<QQCircleProfile$StModifyLimitItem> list;
        String desc;
        this.K = (QCircleEditProfileBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = new QQCircleProfile$StProfileBizData();
        boolean z16 = true;
        try {
            qQCircleProfile$StProfileBizData.mergeFrom(this.K.getStProfileBizData());
            list = qQCircleProfile$StProfileBizData.modifyLimitFields.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSPersonalEditViewModel", 1, "initData... exception:", e16);
            list = null;
        }
        FrequencyItem frequencyItem = new FrequencyItem(this.K.getAvatarUrl());
        e2(10025, list, frequencyItem);
        this.f89114i.postValue(frequencyItem);
        if (!TextUtils.isEmpty(this.K.getNick())) {
            FrequencyItem frequencyItem2 = new FrequencyItem(this.K.getNick());
            e2(10001, list, frequencyItem2);
            this.f89115m.postValue(frequencyItem2);
        }
        this.C.postValue(Integer.valueOf(this.K.getGender()));
        this.D.postValue(Integer.valueOf(this.K.getConstellation()));
        this.E.postValue(new School(this.K.getShowSchool(), this.K.getSchool(), this.K.getUpdateSchoolNum()));
        if (!TextUtils.isEmpty(this.K.getLocation())) {
            this.F.postValue(new e(this.K.getLocation(), this.K.getLocationCode()));
        }
        if (this.K.getDesc() == null) {
            desc = "";
        } else {
            desc = this.K.getDesc();
        }
        FrequencyItem frequencyItem3 = new FrequencyItem(desc);
        e2(10008, list, frequencyItem3);
        this.G.postValue(frequencyItem3);
        MutableLiveData<d> mutableLiveData = this.H;
        if (this.K.getBindChannelStatus() != 1) {
            z16 = false;
        }
        mutableLiveData.postValue(new d(z16, Long.parseLong(this.K.getBindChannelID()), this.K.getBindChannel()));
        this.I.postValue(this.K.getGroup());
    }

    public void b2(TaskInfo taskInfo, VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetProfileRsp> onVSRspCallBack) {
        String originUrl = ((ImageResult) taskInfo.getMediaInfos().get(0).getUploadResult()).getOriginUrl();
        FrequencyItem frequencyItem = (FrequencyItem) this.f89114i.getValue().clone();
        if (frequencyItem == null) {
            QLog.e("QFSPersonalEditViewModel", 1, "onTaskChange... clone fail item == null");
            return;
        }
        QLog.d("QFSPersonalEditViewModel", 1, "onTaskChangeSuccessOnAvatar... avatarUrl:" + originUrl + " item:" + frequencyItem.toString());
        frequencyItem.showText = originUrl;
        f2(10025, frequencyItem, onVSRspCallBack);
    }

    public void c2(String str) {
        WinkPublishHelper2.INSTANCE.bindService(3, new c(str));
    }

    public void d2() {
        WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(3);
        if (this.L != null && service != null) {
            QLog.d("QFSPersonalEditViewModel", 1, "release... mUploadCallback");
            service.removeTaskListener(this.L);
        }
    }

    public void g2(w wVar) {
        List<QQCircleProfile$StModifyLimitItem> list;
        if (wVar != null && wVar.c() != null) {
            QLog.d("QFSPersonalEditViewModel", 1, "updateAvatar... url:" + wVar.c().icon.iconUrl.get());
            QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = new QQCircleProfile$StProfileBizData();
            try {
                qQCircleProfile$StProfileBizData.mergeFrom(wVar.g().toByteArray());
                list = qQCircleProfile$StProfileBizData.modifyLimitFields.get();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSPersonalEditViewModel", 1, "updateAvatar... exception:", e16);
                list = null;
            }
            FrequencyItem frequencyItem = new FrequencyItem(wVar.c().icon.iconUrl.get());
            e2(10025, list, frequencyItem);
            this.f89114i.postValue(frequencyItem);
            return;
        }
        QLog.e("QFSPersonalEditViewModel", 1, "[updateAvatar] userInfoData == null || userInfoData.stUser() == null.");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSPersonalEditViewModel";
    }

    public void i2(QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent) {
        School school;
        if (qCirclePersonEditUpdateEvent.getAvatar() != null) {
            this.f89114i.postValue(qCirclePersonEditUpdateEvent.getAvatar());
        }
        if (qCirclePersonEditUpdateEvent.getNick() != null) {
            this.f89115m.postValue(qCirclePersonEditUpdateEvent.getNick());
        }
        if (qCirclePersonEditUpdateEvent.getGender() != 0) {
            this.C.postValue(Integer.valueOf(qCirclePersonEditUpdateEvent.getGender()));
        }
        if (qCirclePersonEditUpdateEvent.getConstellation() != 0) {
            this.D.postValue(Integer.valueOf(qCirclePersonEditUpdateEvent.getConstellation()));
        }
        if (qCirclePersonEditUpdateEvent.getSchool() != null) {
            if (this.E.getValue() != null) {
                school = this.E.getValue();
            } else {
                school = new School();
            }
            school.schoolName = qCirclePersonEditUpdateEvent.getSchool();
            school.decreaseNum();
            if (qCirclePersonEditUpdateEvent.isUpdateShowSchool()) {
                school.showSchool = qCirclePersonEditUpdateEvent.getShowSchool();
            }
            this.E.postValue(school);
        }
        if (qCirclePersonEditUpdateEvent.getLocation() != null) {
            this.F.postValue(qCirclePersonEditUpdateEvent.getLocation());
        }
        if (qCirclePersonEditUpdateEvent.getDesc() != null) {
            this.G.postValue(qCirclePersonEditUpdateEvent.getDesc());
        }
        if (qCirclePersonEditUpdateEvent.getGuild() != null) {
            this.H.setValue(qCirclePersonEditUpdateEvent.getGuild());
        }
        if (qCirclePersonEditUpdateEvent.getGroupInfoList() != null) {
            this.I.setValue(qCirclePersonEditUpdateEvent.getGroupInfoList());
        }
    }
}
