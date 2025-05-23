package nk;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R.\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lnk/aq;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Q1", "", "retCode", "", "U1", "", "msg", "S1", "getLogTag", "Landroid/content/Intent;", "intent", "T1", "O1", "businessDetailData", "W1", "P1", "i", "Ljava/lang/String;", "mFeedId", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "setMFeedDetailData", "(Landroidx/lifecycle/MutableLiveData;)V", "mFeedDetailData", "Lbk/h;", BdhLogUtil.LogTag.Tag_Conn, "Lbk/h;", "getMFeedDetailRepo", "()Lbk/h;", "setMFeedDetailRepo", "(Lbk/h;)V", "mFeedDetailRepo", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class aq extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mFeedId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<UIStateData<BusinessFeedData>> mFeedDetailData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private bk.h mFeedDetailRepo = new bk.h();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/aq$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<BusinessFeedData> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BusinessFeedData feedData, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            aq.this.W1(feedData);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            RFWLog.d("QZoneIntimateFeedDetailViewModel", RFWLog.USR, "request feed detail error, " + errorMsg);
            aq.this.S1(errorMsg);
            aq.this.U1(errorCode);
        }
    }

    private final BusinessFeedData Q1() {
        return (BusinessFeedData) com.qzone.reborn.feedx.util.m.a("extra_key_parcelable_feed_for_detail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(String msg2) {
        this.mFeedDetailData.setValue(UIStateData.obtainError(msg2));
    }

    public final void O1() {
        String str = this.mFeedId;
        if (str == null || str.length() == 0) {
            RFWLog.d("QZoneIntimateFeedDetailViewModel", RFWLog.USR, "request feed detail error, feed id is null");
            S1("request feed detail error, feed id is null");
            return;
        }
        bk.h hVar = this.mFeedDetailRepo;
        int i3 = this.contextHashCode;
        String str2 = this.mFeedId;
        Intrinsics.checkNotNull(str2);
        hVar.d(i3, str2, new b());
    }

    public final BusinessFeedData P1() {
        UIStateData<BusinessFeedData> value = this.mFeedDetailData.getValue();
        if (value != null) {
            return value.getData();
        }
        return null;
    }

    public final MutableLiveData<UIStateData<BusinessFeedData>> R1() {
        return this.mFeedDetailData;
    }

    public final void T1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mFeedId = intent.getStringExtra("feed_id");
        W1(Q1());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateFeedDetailViewModel";
    }

    public final void W1(BusinessFeedData businessDetailData) {
        if (businessDetailData == null) {
            QLog.e(getTAG(), 1, "updateDetailData: businessDetailData is null");
            return;
        }
        UIStateData<BusinessFeedData> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setDataList(businessDetailData);
        obtainSuccess.setFinish(true);
        this.mFeedDetailData.setValue(obtainSuccess);
        if (TextUtils.isEmpty(ef.b.a(businessDetailData))) {
            return;
        }
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.c(ef.b.a(businessDetailData), businessDetailData.cellLikeInfo), true);
        ze.a.a().initOrUpdateGlobalState((ze.a) new af.b(ef.b.a(businessDetailData), businessDetailData.getCommentInfoV2()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(long retCode) {
        if (retCode == 10013 || retCode == 10021 || retCode == 10004) {
            ToastUtil.o(R.string.f169553v94, 1);
        }
    }
}
