package com.tencent.mobileqq.zplan.minihome.repository;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfo;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver;
import com.tencent.mobileqq.zplan.minihome.ai;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import q55.d;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/repository/MiniHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "", "uin", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "", "useCache", "", "M1", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleCoroutineScope;Ljava/lang/Boolean;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/zplan/minihome/ag;", "i", "Landroidx/lifecycle/MutableLiveData;", "_miniHomeInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "info", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<MiniHomeInfo> _miniHomeInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<MiniHomeInfo> info;

    public MiniHomeViewModel() {
        MutableLiveData<MiniHomeInfo> mutableLiveData = new MutableLiveData<>();
        this._miniHomeInfo = mutableLiveData;
        this.info = mutableLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v8, types: [T, q55.d] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, q55.d] */
    public final void M1(String uin, LifecycleCoroutineScope scope, Boolean useCache) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        QLog.i("MiniHomeViewModel", 1, "fetchMiniHomeInfo, uin: " + uin + ", useCache: " + useCache);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (Intrinsics.areEqual(useCache, Boolean.TRUE)) {
            MiniHomeInfoObserver miniHomeInfoObserver = MiniHomeInfoObserver.f334284c;
            ?? e16 = miniHomeInfoObserver.e(uin);
            objectRef.element = e16;
            if (e16 == 0) {
                QLog.i("MiniHomeViewModel", 1, "fetchMiniHomeInfo cache empty, try fetch from MMKV, uin: " + uin);
                objectRef.element = miniHomeInfoObserver.f(uin);
            }
            d dVar = (d) objectRef.element;
            if (dVar != null) {
                QLog.i("MiniHomeViewModel", 1, "fetchMiniHomeInfoFromCacheOrMMKV success, uin: " + uin + ", rsp: " + dVar);
                this._miniHomeInfo.setValue(ai.a(dVar));
            }
        } else {
            QLog.i("MiniHomeViewModel", 1, "fetchMiniHomeInfo, netOnly, skip cache and MMKV.");
        }
        CorountineFunKt.e(scope, "MiniHomeViewModel_fetchMiniHomeInfo", null, null, null, new MiniHomeViewModel$fetchMiniHomeInfo$2(uin, objectRef, this, null), 14, null);
    }

    public final LiveData<MiniHomeInfo> O1() {
        return this.info;
    }

    public static /* synthetic */ void N1(MiniHomeViewModel miniHomeViewModel, String str, LifecycleCoroutineScope lifecycleCoroutineScope, Boolean bool, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bool = Boolean.TRUE;
        }
        miniHomeViewModel.M1(str, lifecycleCoroutineScope, bool);
    }
}
