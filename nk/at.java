package nk;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSpaceInitRequestBean;
import com.qzone.reborn.intimate.event.QZoneIntimateRefreshAlbumTabEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateUpdateSpaceInfoEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;
import qzone.QZIntimateSpaceReader$ClearReddotRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 q2\u00020\u0001:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u00104\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0016\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R.\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0>0=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010J\u001a\b\u0012\u0004\u0012\u00020F0=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010@\u001a\u0004\bH\u0010B\"\u0004\bI\u0010DR\"\u0010M\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001e\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R\"\u0010S\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010j\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR(\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010@\u001a\u0004\bl\u0010B\"\u0004\bm\u0010D\u00a8\u0006s"}, d2 = {"Lnk/at;", "Lcom/qzone/reborn/base/n;", "", "e2", "", "getLogTag", "N1", "spaceId", "j2", "Landroid/content/Intent;", "intent", "d2", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "X1", "", "timeStampInSecond", "", "isNeedToast", "c2", "M1", "i2", "i", "Ljava/lang/String;", "P1", "()Ljava/lang/String;", "setMFrom", "(Ljava/lang/String;)V", "mFrom", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "W1", "()I", "setMTabIndex", "(I)V", "mTabIndex", "Lqj/n;", BdhLogUtil.LogTag.Tag_Conn, "Lqj/n;", "getMTabRefreshIoc", "()Lqj/n;", SemanticAttributes.DbSystemValues.H2, "(Lqj/n;)V", "mTabRefreshIoc", "", "Lqj/k;", "D", "Ljava/util/List;", "Z1", "()Ljava/util/List;", "setSpaceInfoUpdateIocList", "(Ljava/util/List;)V", "spaceInfoUpdateIocList", "E", "T1", "setMSpaceId", "mSpaceId", "Lbk/q;", UserInfo.SEX_FEMALE, "Lbk/q;", "mSpaceMainRepo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "G", "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setMSpaceInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "mSpaceInfo", "", "H", "S1", "setMSpaceCoverViewAlpha", "mSpaceCoverViewAlpha", "R1", "g2", "mIsIntercept", "J", "Q1", "()J", "f2", "(J)V", "mInterceptionCause", "K", "Z", "b2", "()Z", "setDraft", "(Z)V", "isDraft", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "L", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "O1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "setInitBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;)V", "initBean", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "M", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "getActivateSpaceBean", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "setActivateSpaceBean", "(Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;)V", "activateSpaceBean", "N", ICustomDataEditor.STRING_ARRAY_PARAM_2, "setStatusAfterActivate", "statusAfterActivate", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class at extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private qj.n mTabRefreshIoc;

    /* renamed from: I, reason: from kotlin metadata */
    private int mIsIntercept;

    /* renamed from: J, reason: from kotlin metadata */
    private long mInterceptionCause;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isDraft;

    /* renamed from: L, reason: from kotlin metadata */
    private QZoneIntimateMainPageInitBean initBean;

    /* renamed from: M, reason: from kotlin metadata */
    private QZoneIntimateActivateSpaceBean activateSpaceBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTabIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mFrom = "";

    /* renamed from: D, reason: from kotlin metadata */
    private List<qj.k> spaceInfoUpdateIocList = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private String mSpaceId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private final bk.q mSpaceMainRepo = new bk.q();

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> mSpaceInfo = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Float> mSpaceCoverViewAlpha = new MutableLiveData<>();

    /* renamed from: N, reason: from kotlin metadata */
    private MutableLiveData<Boolean> statusAfterActivate = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/at$c", "Lcom/qzone/reborn/base/n$a;", "", "relationDays", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements n.a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f420313a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ at f420314b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f420315c;

        c(boolean z16, at atVar, long j3) {
            this.f420313a = z16;
            this.f420314b = atVar;
            this.f420315c = j3;
        }

        public void a(int relationDays, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (this.f420313a) {
                com.qzone.reborn.util.o.f59556a.c(R.string.w_c, 2);
            }
            UIStateData<QZoneIntimateSpaceBean> value = this.f420314b.U1().getValue();
            if (value != null) {
                long j3 = this.f420315c;
                at atVar = this.f420314b;
                com.tencent.qqcamerakit.common.e.e("QZoneIntimateMainTabViewModel", 1, "anniversary is " + j3 + ", relationDays is " + relationDays);
                QZoneIntimateSpaceBean data = value.getData();
                if (data != null) {
                    data.setAnniversary(j3);
                }
                QZoneIntimateSpaceBean data2 = value.getData();
                if (data2 != null) {
                    data2.setRelationDays(relationDays);
                }
                value.getData().setFromCheckIn(false);
                atVar.U1().postValue(value);
            }
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }

        @Override // com.qzone.reborn.base.n.a
        public /* bridge */ /* synthetic */ void onSuccess(Integer num, long j3, String str, boolean z16) {
            a(num.intValue(), j3, str, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/at$d", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "spaceBean", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements n.a<QZoneIntimateSpaceBean> {
        d() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZoneIntimateSpaceBean spaceBean, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(spaceBean, "spaceBean");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            at.this.U1().postValue(UIStateData.obtainSuccess(false).setData(false, spaceBean));
            if (!at.this.getIsDraft()) {
                at.this.a2().postValue(Boolean.TRUE);
            }
            RFWLog.i(at.this.getTAG(), RFWLog.USR, "activate space id is " + at.this.getMSpaceId());
            at.this.g2(0);
            at.this.f2(0L);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            at.this.U1().postValue(UIStateData.obtainError(errorMsg).setRetCode(errorCode));
            at.this.g2(1);
            at.this.f2(errorCode);
        }
    }

    private final void e2() {
        if ((this.mSpaceId.length() == 0) && !this.isDraft) {
            RFWLog.e(getTAG(), RFWLog.USR, "refreshSpaceInfo error mSpaceId is empty");
            return;
        }
        if (this.mSpaceId.length() > 0) {
            RFWLog.i("QZoneIntimateMainTabViewModel", RFWLog.USR, "space id is " + this.mSpaceId);
            this.isDraft = false;
        }
        this.mSpaceMainRepo.h(this.contextHashCode, new QZoneIntimateSpaceInitRequestBean(this.mSpaceId, this.isDraft, this.activateSpaceBean), new d());
    }

    public final void M1() {
        this.mSpaceMainRepo.d(this.contextHashCode, 4, new b());
    }

    public final void N1() {
        e2();
        qj.n nVar = this.mTabRefreshIoc;
        if (nVar != null) {
            nVar.c0();
        }
    }

    /* renamed from: O1, reason: from getter */
    public final QZoneIntimateMainPageInitBean getInitBean() {
        return this.initBean;
    }

    /* renamed from: P1, reason: from getter */
    public final String getMFrom() {
        return this.mFrom;
    }

    /* renamed from: Q1, reason: from getter */
    public final long getMInterceptionCause() {
        return this.mInterceptionCause;
    }

    /* renamed from: R1, reason: from getter */
    public final int getMIsIntercept() {
        return this.mIsIntercept;
    }

    public final MutableLiveData<Float> S1() {
        return this.mSpaceCoverViewAlpha;
    }

    /* renamed from: T1, reason: from getter */
    public final String getMSpaceId() {
        return this.mSpaceId;
    }

    public final MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1() {
        return this.mSpaceInfo;
    }

    /* renamed from: W1, reason: from getter */
    public final int getMTabIndex() {
        return this.mTabIndex;
    }

    public final QZoneIntimateSpaceBean X1() {
        UIStateData<QZoneIntimateSpaceBean> value = this.mSpaceInfo.getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    public final List<qj.k> Z1() {
        return this.spaceInfoUpdateIocList;
    }

    public final MutableLiveData<Boolean> a2() {
        return this.statusAfterActivate;
    }

    /* renamed from: b2, reason: from getter */
    public final boolean getIsDraft() {
        return this.isDraft;
    }

    public final void c2(long timeStampInSecond, boolean isNeedToast) {
        if (this.mSpaceId.length() == 0) {
            return;
        }
        this.mSpaceMainRepo.f(this.contextHashCode, this.mSpaceId, timeStampInSecond, new c(isNeedToast, this, timeStampInSecond));
    }

    public final void f2(long j3) {
        this.mInterceptionCause = j3;
    }

    public final void g2(int i3) {
        this.mIsIntercept = i3;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateMainTabViewModel";
    }

    public final void h2(qj.n nVar) {
        this.mTabRefreshIoc = nVar;
    }

    public final void i2() {
        QZoneIntimateSpaceBean data;
        PBBoolField pBBoolField;
        UIStateData<QZoneIntimateSpaceBean> value = this.mSpaceInfo.getValue();
        if (value == null || (data = value.getData()) == null) {
            return;
        }
        QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = data.getMedalInfo();
        if (medalInfo != null && (pBBoolField = medalInfo.has_new_medal) != null) {
            pBBoolField.set(false);
        }
        data.setFromRefreshSpace(false);
        data.setFromCheckIn(false);
        this.mSpaceInfo.postValue(UIStateData.obtainSuccess(false).setData(false, data));
    }

    public final void j2(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.mSpaceId = spaceId;
        this.isDraft = false;
        if (ArrayUtils.isOutOfArrayIndex(0, this.spaceInfoUpdateIocList)) {
            return;
        }
        List<qj.k> list = this.spaceInfoUpdateIocList;
        Intrinsics.checkNotNull(list);
        Iterator<qj.k> it = list.iterator();
        while (it.hasNext()) {
            it.next().gc(spaceId);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateUpdateSpaceInfoEvent(spaceId));
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateRefreshAlbumTabEvent());
    }

    public final void d2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = (QZoneIntimateMainPageInitBean) serializable;
        this.initBean = qZoneIntimateMainPageInitBean;
        if (qZoneIntimateMainPageInitBean == null) {
            return;
        }
        Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean);
        this.mSpaceId = qZoneIntimateMainPageInitBean.getSpaceId();
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean2 = this.initBean;
        Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean2);
        this.mFrom = qZoneIntimateMainPageInitBean2.getFrom();
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean3 = this.initBean;
        Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean3);
        this.mTabIndex = qZoneIntimateMainPageInitBean3.getTabId();
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean4 = this.initBean;
        Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean4);
        this.isDraft = qZoneIntimateMainPageInitBean4.getIsDraft();
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean5 = this.initBean;
        Intrinsics.checkNotNull(qZoneIntimateMainPageInitBean5);
        this.activateSpaceBean = qZoneIntimateMainPageInitBean5.getActivateSpaceBean();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/at$b", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZIntimateSpaceReader$ClearReddotRsp;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<QZIntimateSpaceReader$ClearReddotRsp> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZIntimateSpaceReader$ClearReddotRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
        }
    }
}
