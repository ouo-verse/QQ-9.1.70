package com.tencent.sqshow.zootopia.nativeui.view.experience;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.au;
import uv4.bu;
import uv4.bv;
import uv4.x;
import uv4.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/m;", "", "", "b", "", "storeItemId", "useCount", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bv;", "callback", "c", "Landroidx/lifecycle/MutableLiveData;", "Luv4/au;", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "colorConfig", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f371882a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<au> colorConfig = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/m$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/y;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<y> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(y result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ExperienceCardHelper", 1, "refreshColorConfig success ");
            m.f371882a.a().postValue(result.f440472a);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ExperienceCardHelper", 1, "refreshColorConfig fail error=" + error + " message=" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/m$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bv;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<bv> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bv> f371884d;

        b(com.tencent.mobileqq.zootopia.api.e<bv> eVar) {
            this.f371884d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bv result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ExperienceCardHelper", 1, "useExperienceCard success ");
            m.f371882a.a().postValue(result.f440397a);
            this.f371884d.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ExperienceCardHelper", 1, "useExperienceCard fail error=" + error + " message=" + message);
            this.f371884d.onResultFailure(error, message);
        }
    }

    m() {
    }

    public final MutableLiveData<au> a() {
        return colorConfig;
    }

    public final void c(int storeItemId, int useCount, com.tencent.mobileqq.zootopia.api.e<bv> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("ExperienceCardHelper", 1, "useExperienceCard storeItemId=" + storeItemId + " useCount=" + useCount);
        bu buVar = new bu();
        buVar.f440396b = useCount;
        buVar.f440395a = storeItemId;
        va4.a.n(va4.a.f441274a, buVar, new b(callback), 0, 4, null);
    }

    public final void b() {
        QLog.d("ExperienceCardHelper", 1, "refreshColorConfig");
        va4.a.j(va4.a.f441274a, new x(), new a(), 0, 4, null);
    }
}
