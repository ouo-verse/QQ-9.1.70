package com.tencent.sqshow.zootopia.nativeui.data.repo;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/i;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/h;", "", "param", "", "a", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/e;", "Landroidx/lifecycle/MutableLiveData;", "b", "()Landroidx/lifecycle/MutableLiveData;", "mPanelAllData", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<AvatarPanelAllData> mPanelAllData = new MutableLiveData<>();

    @Override // com.tencent.sqshow.zootopia.nativeui.data.repo.h
    public void a(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        yb4.e.g(yb4.e.f450058a, param, 0, 2, null);
    }

    public final MutableLiveData<AvatarPanelAllData> b() {
        return this.mPanelAllData;
    }
}
