package dd;

import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedx.util.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR*\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ldd/a;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "M1", "", "getLogTag", "", "N1", "i", "Ljava/lang/String;", "TAG", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "setFeedData", "(Landroidx/lifecycle/MutableLiveData;)V", "feedData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneInputDataViewModel";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<BusinessFeedData> feedData = new MutableLiveData<>();

    private final BusinessFeedData M1() {
        Object a16 = m.a("extra_key_parcelable_feed_for_detail");
        if (a16 instanceof BusinessFeedData) {
            return (BusinessFeedData) a16;
        }
        return null;
    }

    public final void N1() {
        BusinessFeedData M1 = M1();
        this.feedData.setValue(M1);
        QLog.d(this.TAG, 1, "initData  data=" + M1);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    public final MutableLiveData<BusinessFeedData> j() {
        return this.feedData;
    }
}
