package af3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Laf3/a;", "Lte3/a;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/a;", "handle", "", "d", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "M0", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "mHippyUeApi", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements te3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.mobileqq.zplan.avatar.api.hippy.a> mHippyUeApi = new WeakReference<>(null);

    @Override // te3.a
    public void F(com.tencent.mobileqq.zplan.avatar.api.hippy.a handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        if (Intrinsics.areEqual(handle, this.mHippyUeApi.get())) {
            this.mHippyUeApi = new WeakReference<>(null);
        }
    }

    @Override // te3.a
    public BaseHippyUeActionHandler M0(JSONObject params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        return ef3.a.f396227a.a(params, promise);
    }

    @Override // te3.a
    public void d(com.tencent.mobileqq.zplan.avatar.api.hippy.a handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.mHippyUeApi = new WeakReference<>(handle);
    }

    @Override // te3.a
    public AvatarEngineType g0() {
        if (FilamentApiImpl.f369933a.d()) {
            return AvatarEngineType.FILAMENT;
        }
        return AvatarEngineType.UE;
    }

    @Override // te3.a
    public com.tencent.mobileqq.zplan.avatar.api.hippy.a m() {
        return this.mHippyUeApi.get();
    }
}
