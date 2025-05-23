package hg3;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.cloudmod.api.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.c;
import qv4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lhg3/a;", "", "", "toastMsg", "", "c", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "cloudGameInfo", "", "mapId", "modStatus", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "contextRefer", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "listener", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404857a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hg3/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hg3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10434a implements e<d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f404858d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f404859e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f404860f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WeakReference f404861h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ b f404862i;

        public C10434a(long j3, String str, int i3, WeakReference weakReference, b bVar) {
            this.f404858d = j3;
            this.f404859e = str;
            this.f404860f = i3;
            this.f404861h = weakReference;
            this.f404862i = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean z16 = true;
            QLog.d("ZPlanModInfoHelper", 1, "onResultSuccess, result: " + result);
            int i3 = result.f430128a;
            String str = result.f430129b;
            Intrinsics.checkNotNullExpressionValue(str, "result.toast");
            long currentTimeMillis = System.currentTimeMillis() - this.f404858d;
            QLog.d("ZPlanModInfoHelper", 1, "onResult, code: " + i3 + ", toastMsg:" + str + ", scheme: " + this.f404859e + ", cost: " + currentTimeMillis);
            kg3.a.f412316a.m(this.f404860f, this.f404859e, i3, currentTimeMillis);
            if (i3 == 0) {
                a.f404857a.c(str);
                return;
            }
            if (i3 == 1) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = (Context) this.f404861h.get();
                if (context == null) {
                    context = BaseApplicationImpl.sApplication.getApplicationContext();
                }
                Intrinsics.checkNotNullExpressionValue(context, "contextRefer.get() ?: Ba\u2026cation.applicationContext");
                iZPlanApi.launchSchemeWithContext(context, this.f404859e);
                a.f404857a.c(str);
                this.f404862i.a();
                return;
            }
            if (i3 != 2) {
                return;
            }
            a aVar = a.f404857a;
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                str = "\u5f53\u524d\u670d\u52a1\u5668\u4e0d\u8db3\uff0c\u5df2\u4e3a\u4f60\u81ea\u52a8\u4e0b\u8f7d";
            }
            aVar.c(str);
            this.f404862i.b();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZPlanModInfoHelper", 1, "onResultFailure, error: " + error + ", message: " + message);
            long currentTimeMillis = System.currentTimeMillis() - this.f404858d;
            QLog.d("ZPlanModInfoHelper", 1, "onResult, code: -1, toastMsg:\u670d\u52a1\u5668\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5, scheme: " + this.f404859e + ", cost: " + currentTimeMillis);
            kg3.a.f412316a.m(this.f404860f, this.f404859e, -1, currentTimeMillis);
        }
    }

    a() {
    }

    public final void b(ZPlanCloudGameInfo cloudGameInfo, int mapId, int modStatus, WeakReference<Context> contextRefer, b listener) {
        Intrinsics.checkNotNullParameter(cloudGameInfo, "cloudGameInfo");
        Intrinsics.checkNotNullParameter(contextRefer, "contextRefer");
        Intrinsics.checkNotNullParameter(listener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        kg3.a.f412316a.d("e_zplan_cloud_mod_entrance", mapId, cloudGameInfo.getScheme());
        String gameId = cloudGameInfo.getGameId();
        String scheme = cloudGameInfo.getScheme();
        if (!(gameId == null || gameId.length() == 0)) {
            if (!(scheme == null || scheme.length() == 0)) {
                c cVar = new c();
                cVar.f430126a = gameId;
                cVar.f430127b = modStatus;
                QLog.d("ZPlanModInfoHelper", 1, "isCloudModAvailable, req: " + cVar);
                ig3.a.b(ig3.a.f407604a, cVar, new C10434a(currentTimeMillis, scheme, mapId, contextRefer, listener), 0, 4, null);
                return;
            }
        }
        QLog.d("ZPlanModInfoHelper", 1, "data is null, gameId: " + gameId + ", scheme: " + scheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String toastMsg) {
        if (toastMsg == null || toastMsg.length() == 0) {
            return;
        }
        CommonExKt.l(toastMsg);
    }
}
