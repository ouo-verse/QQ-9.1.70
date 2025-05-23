package g94;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import i94.CollectInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import uv4.ai;
import uv4.aj;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J*\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0002`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0002`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001d\u00a8\u0006\""}, d2 = {"Lg94/b;", "", "Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "isCollected", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aj;", "callback", "", h.F, "Luv4/ai;", "req", "j", "f", "i", "d", "b", "e", "c", "Landroidx/lifecycle/MutableLiveData;", "Li94/a;", "Landroidx/lifecycle/MutableLiveData;", "g", "()Landroidx/lifecycle/MutableLiveData;", "collectLiveData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "dynamicCollectedItem", "dynamicCancelCollectedItem", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f401562a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<CollectInfo> collectLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, az> dynamicCollectedItem = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, az> dynamicCancelCollectedItem = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g94/b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aj;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<aj> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aj result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToast.makeText(BaseApplication.context, 1, "\u53d6\u6d88\u6536\u85cf\u5931\u8d25", 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g94/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aj;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g94.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10366b implements com.tencent.mobileqq.zootopia.api.e<aj> {
        C10366b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aj result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToast.makeText(BaseApplication.context, 1, "\u6536\u85cf\u5931\u8d25", 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g94/b$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aj;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<aj> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ai f401566d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<aj> f401567e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ az f401568f;

        c(ai aiVar, com.tencent.mobileqq.zootopia.api.e<aj> eVar, az azVar) {
            this.f401566d = aiVar;
            this.f401567e = eVar;
            this.f401568f = azVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(aj result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("CollectHelper", 1, "onResultSuccess, req:" + this.f401566d + ", result:" + result);
            com.tencent.mobileqq.zootopia.api.e<aj> eVar = this.f401567e;
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
            b.f401562a.f(this.f401568f, this.f401566d);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e<aj> eVar = this.f401567e;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            QLog.d("CollectHelper", 1, "onResultFailure, error:" + error + ", message:" + message);
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(az item, ai req) {
        CollectInfo collectInfo = new CollectInfo(req.f440143d ? 1 : 2, item);
        if (req.f440143d) {
            HashMap<String, az> hashMap = dynamicCollectedItem;
            String str = item.B;
            Intrinsics.checkNotNullExpressionValue(str, "item.uniqueId");
            hashMap.put(str, item);
            dynamicCancelCollectedItem.remove(item.B);
            item.f440294u = true;
        } else {
            dynamicCollectedItem.remove(item.B);
            HashMap<String, az> hashMap2 = dynamicCancelCollectedItem;
            String str2 = item.B;
            Intrinsics.checkNotNullExpressionValue(str2, "item.uniqueId");
            hashMap2.put(str2, item);
            item.f440294u = false;
        }
        collectLiveData.postValue(collectInfo);
    }

    private final void h(az item, boolean isCollected, com.tencent.mobileqq.zootopia.api.e<aj> callback) {
        ai aiVar = new ai();
        aiVar.f440140a = item.f440274a;
        aiVar.f440141b = item.f440275b;
        aiVar.f440142c = item.f440276c;
        aiVar.f440143d = isCollected;
        aiVar.f440144e = item.B;
        j(item, aiVar, callback);
    }

    private final void j(az item, ai req, com.tencent.mobileqq.zootopia.api.e<aj> callback) {
        QLog.d("CollectHelper", 1, "requestNetWork, req:" + req);
        t94.a.b(t94.a.f435617a, req, new c(req, callback, item), 0, 4, null);
    }

    public final void b(az item) {
        Intrinsics.checkNotNullParameter(item, "item");
        c(item, new a());
    }

    public final void c(az item, com.tencent.mobileqq.zootopia.api.e<aj> callback) {
        Intrinsics.checkNotNullParameter(item, "item");
        h(item, false, callback);
    }

    public final void d(az item) {
        Intrinsics.checkNotNullParameter(item, "item");
        e(item, new C10366b());
    }

    public final void e(az item, com.tencent.mobileqq.zootopia.api.e<aj> callback) {
        Intrinsics.checkNotNullParameter(item, "item");
        h(item, true, callback);
    }

    public final MutableLiveData<CollectInfo> g() {
        return collectLiveData;
    }

    public final boolean i(az item) {
        if (item == null) {
            return false;
        }
        String str = item.B;
        if (dynamicCollectedItem.containsKey(str)) {
            return true;
        }
        if (dynamicCancelCollectedItem.containsKey(str)) {
            return false;
        }
        return item.f440294u;
    }
}
