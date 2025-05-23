package com.qzone.reborn.feedx.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.utils.b;
import com.qzone.reborn.feedx.util.y;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ]2\u00020\u0001:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\u001e\u0010&\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u0002R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010?\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR*\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O0N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010Z\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010D\u001a\u0004\bX\u0010F\"\u0004\bY\u0010H\u00a8\u0006_"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxMoodListViewModel;", "Ltc/b;", "", ICustomDataEditor.STRING_PARAM_2, "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataList", "J2", "data", "", "E2", "C2", "", "getLogTag", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "savedInstance", "H2", "F2", "Lcom/qzone/feed/business/service/a;", "R1", "B2", Constants.BASE_IN_PLUGIN_VERSION, "refer", "K2", "I2", Constants.MMCCID, "P1", "f2", "j2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/qzone/common/business/result/QZoneResult;", "result", SemanticAttributes.DbSystemValues.H2, "feedsData", "", "loadType", "g2", NowProxyConstants.AccountInfoKey.A2, "x2", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "u2", "()Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "setInitBean", "(Lcom/qzone/reborn/route/QZoneMoodListInitBean;)V", "initBean", "", "G", "J", "w2", "()J", "setMUin", "(J)V", "mUin", "H", "Ljava/lang/String;", "getMNickName", "()Ljava/lang/String;", "setMNickName", "(Ljava/lang/String;)V", "mNickName", "I", "getMRefer", "setMRefer", "mRefer", "Z", "getMNeedRefresh", "()Z", "setMNeedRefresh", "(Z)V", "mNeedRefresh", "Ly6/e;", "K", "Ly6/e;", "mCurService", "Landroidx/lifecycle/MutableLiveData;", "Lx6/e;", "L", "Landroidx/lifecycle/MutableLiveData;", "v2", "()Landroidx/lifecycle/MutableLiveData;", "setMQbossShortcutInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "mQbossShortcutInfo", "M", "t2", "L2", "hasShowPraiseBubble", "<init>", "()V", "N", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxMoodListViewModel extends tc.b {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneMoodListInitBean initBean;

    /* renamed from: G, reason: from kotlin metadata */
    private long mUin;

    /* renamed from: H, reason: from kotlin metadata */
    private String mNickName;

    /* renamed from: K, reason: from kotlin metadata */
    private y6.e mCurService;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasShowPraiseBubble;

    /* renamed from: I, reason: from kotlin metadata */
    private String mRefer = "";

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mNeedRefresh = true;

    /* renamed from: L, reason: from kotlin metadata */
    private MutableLiveData<x6.e> mQbossShortcutInfo = new MutableLiveData<>();

    private final boolean C2(BusinessFeedData data) {
        return B2() && y.d(data);
    }

    private final boolean E2(BusinessFeedData data) {
        return C2(data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BusinessFeedData> J2(List<? extends BusinessFeedData> dataList) {
        ArrayList arrayList = new ArrayList();
        if (dataList.isEmpty()) {
            return dataList;
        }
        arrayList.addAll(dataList);
        int size = arrayList.size();
        int i3 = -1;
        for (int i16 = 0; i16 < size; i16++) {
            if (E2((BusinessFeedData) arrayList.get(i16))) {
                i3 = i16;
            }
        }
        if (i3 == -1) {
            return arrayList;
        }
        arrayList.remove(i3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s2() {
        boolean z16;
        y6.e eVar = this.mCurService;
        if (eVar == null) {
            return;
        }
        Intrinsics.checkNotNull(eVar);
        eVar.r0();
        if (!this.mNeedRefresh) {
            y6.e eVar2 = this.mCurService;
            Intrinsics.checkNotNull(eVar2);
            if (eVar2.f0()) {
                z16 = false;
                this.mNeedRefresh = z16;
                G2();
                if (this.mNeedRefresh) {
                    return;
                }
                P1();
                return;
            }
        }
        z16 = true;
        this.mNeedRefresh = z16;
        G2();
        if (this.mNeedRefresh) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(final QZoneFeedxMoodListViewModel this$0, final x6.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.l
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxMoodListViewModel.z2(QZoneFeedxMoodListViewModel.this, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(QZoneFeedxMoodListViewModel this$0, x6.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mQbossShortcutInfo.setValue(eVar);
    }

    public final boolean A2() {
        y6.e eVar = this.mCurService;
        if (eVar != null) {
            return eVar.f0();
        }
        return false;
    }

    public final boolean B2() {
        return !D2();
    }

    public final boolean D2() {
        return this.mUin == LoginData.getInstance().getUin();
    }

    public final boolean F2() {
        return !TextUtils.isEmpty(this.initBean != null ? r0.getPraiseBubbleText() : null);
    }

    public final void G2() {
        if (D2()) {
            x2();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r2 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H2(Intent intent, Bundle savedInstance) {
        if (savedInstance != null && savedInstance.containsKey("key_uin")) {
            this.mUin = savedInstance.getLong("key_uin");
            this.mNickName = savedInstance.getString("key_nickname");
            this.initBean = (QZoneMoodListInitBean) savedInstance.getParcelable("qzone_route_bean");
            if (this.mUin <= 0) {
                this.mUin = LoginData.getInstance().getUin();
            }
        }
        if (intent == null) {
            return;
        }
        if (this.mUin == 0) {
            this.mUin = intent.getLongExtra("key_uin", LoginData.getInstance().getUin());
        }
        if (this.mUin <= 0) {
            this.mUin = LoginData.getInstance().getUin();
        }
        String str = this.mNickName;
        if (str != null) {
            boolean z16 = false;
            if (str != null && str.length() == 0) {
                z16 = true;
            }
        }
        this.mNickName = intent.getStringExtra("key_nickname");
        this.initBean = (QZoneMoodListInitBean) intent.getParcelableExtra("qzone_route_bean");
        this.mCurService = y6.e.b0(this.mUin);
    }

    public final void K2(String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        com.qzone.reborn.feedx.util.c.f55739a.a("data", "requestFeeds");
        com.qzone.feed.business.service.a mCurService = getMCurService();
        if (mCurService != null) {
            mCurService.L(U1(), refer);
        }
    }

    public final void L2(boolean z16) {
        this.hasShowPraiseBubble = z16;
    }

    @Override // tc.b
    public void P1() {
        super.P1();
        QLog.d("QZoneFeedxMoodListViewModel", 1, "doRefresh");
        K2(this.mRefer);
    }

    @Override // tc.b
    /* renamed from: R1 */
    public com.qzone.feed.business.service.a getMCurService() {
        return this.mCurService;
    }

    @Override // tc.b
    public void f2() {
        y6.e eVar = this.mCurService;
        if (eVar != null) {
            eVar.J(getMHandler());
        }
    }

    @Override // tc.b
    public void g2(List<? extends BusinessFeedData> feedsData, int loadType) {
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        if (!feedsData.isEmpty()) {
            Iterator<? extends BusinessFeedData> it = feedsData.iterator();
            while (it.hasNext()) {
                it.next().feedType = 4099;
            }
        }
        super.g2(feedsData, loadType);
        if (QZoneConfigHelper.r()) {
            this.mNeedRefresh = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxMoodListViewModel";
    }

    @Override // tc.b
    public void h2(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    @Override // tc.b
    public List<BusinessFeedData> j2(List<? extends BusinessFeedData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        return J2(dataList);
    }

    @Override // tc.b
    public void n2() {
        UIStateData<List<BusinessFeedData>> value = T1().getValue();
        List<BusinessFeedData> data = value != null ? value.getData() : null;
        if (data == null || data.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(data);
        if (y.e() && !b2()) {
            BusinessFeedData a16 = y.a();
            Intrinsics.checkNotNullExpressionValue(a16, "buildFakeGuestMemorySealFeed()");
            arrayList.add(a16);
        }
        UIStateData<List<BusinessFeedData>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setUpTurning(true);
        obtainSuccess.setData(c2(), arrayList);
        obtainSuccess.setFinish(!b2());
        T1().postValue(obtainSuccess);
    }

    /* renamed from: t2, reason: from getter */
    public final boolean getHasShowPraiseBubble() {
        return this.hasShowPraiseBubble;
    }

    /* renamed from: u2, reason: from getter */
    public final QZoneMoodListInitBean getInitBean() {
        return this.initBean;
    }

    public final MutableLiveData<x6.e> v2() {
        return this.mQbossShortcutInfo;
    }

    /* renamed from: w2, reason: from getter */
    public final long getMUin() {
        return this.mUin;
    }

    public final void x2() {
        com.qzone.publish.utils.b.j(new b.e() { // from class: com.qzone.reborn.feedx.viewmodel.k
            @Override // com.qzone.publish.utils.b.e
            public final void a(x6.e eVar) {
                QZoneFeedxMoodListViewModel.y2(QZoneFeedxMoodListViewModel.this, eVar);
            }
        });
    }

    public final void I2() {
        QLog.d("QZoneFeedxMoodListViewModel", 1, "refreshData");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new QZoneFeedxMoodListViewModel$refreshData$1(this, null), 2, null);
    }
}
