package h9;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.c;
import com.qzone.reborn.feedx.util.y;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tc.b;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lh9/a;", "Ltc/b;", "Lcom/qzone/common/event/IObserver$main;", "Landroid/os/Bundle;", "bundle", "", "q2", "Lcom/qzone/feed/business/service/a;", "R1", "", "getLogTag", "r2", "P1", "refer", ICustomDataEditor.STRING_PARAM_2, "f2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/qzone/feed/business/service/QZoneFeedService;", UserInfo.SEX_FEMALE, "Lcom/qzone/feed/business/service/QZoneFeedService;", "mCurService", "", "G", "J", "p2", "()J", "setMUin", "(J)V", "mUin", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneFeedService mCurService;

    /* renamed from: G, reason: from kotlin metadata */
    private long mUin;

    @Override // tc.b
    public void P1() {
        super.P1();
        s2("");
    }

    @Override // tc.b
    /* renamed from: R1 */
    public com.qzone.feed.business.service.a getMCurService() {
        return this.mCurService;
    }

    @Override // tc.b
    public void f2() {
        QZoneFeedService qZoneFeedService = this.mCurService;
        if (qZoneFeedService != null) {
            qZoneFeedService.J(getMHandler());
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAIOUserHomeViewModel";
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

    /* renamed from: p2, reason: from getter */
    public final long getMUin() {
        return this.mUin;
    }

    public final void r2() {
        P1();
    }

    public final void s2(String refer) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        c.f55739a.a("data", "requestFeeds");
        com.qzone.feed.business.service.a mCurService = getMCurService();
        if (mCurService != null) {
            mCurService.L(U1(), refer);
        }
    }

    public final void q2(Bundle bundle) {
        if (bundle != null) {
            long j3 = bundle.getLong("uin", 0L);
            this.mUin = j3;
            this.mCurService = QZoneFeedService.V(j3);
        }
    }
}
