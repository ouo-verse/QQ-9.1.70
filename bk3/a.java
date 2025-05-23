package bk3;

import ck3.ZPlanModReqInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.zplan.resource.api.ZPlanUserAvatarInfoReq;
import hv4.k;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J(\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J<\u0010\u0014\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J^\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J:\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0018H&\u00a8\u0006\u001e"}, d2 = {"Lbk3/a;", "Lvb3/b;", "Lcom/tencent/zplan/resource/api/a;", "resourceCallback", "Lvj3/b;", "mobileDownloadHandler", "", "throwError", "", "B", "Lck3/b;", "modInfo", "T0", "", "Lcom/tencent/zplan/resource/api/b;", "userReqInfo", "l", "", "stickerIdList", "onlyRequestInfo", "x0", "", "businessScene", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "Lhv4/k;", "extReqInfo", "p0", "w0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface a extends vb3.b {
    void B(com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler, boolean throwError);

    void T0(ZPlanModReqInfo modInfo, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler);

    void l(List<ZPlanUserAvatarInfoReq> userReqInfo, com.tencent.zplan.resource.api.a resourceCallback);

    void p0(int businessScene, HashMap<String, String> extraParams, k extReqInfo, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler);

    boolean w0(int businessScene, HashMap<String, String> extraParams);

    void x0(List<ZPlanUserAvatarInfoReq> userReqInfo, List<String> stickerIdList, boolean onlyRequestInfo, com.tencent.zplan.resource.api.a resourceCallback);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: bk3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0132a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(a aVar, int i3, HashMap hashMap, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    hashMap = new HashMap();
                }
                return aVar.w0(i3, hashMap);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelResHubDownloadByScene");
        }

        public static /* synthetic */ void d(a aVar, int i3, HashMap hashMap, k kVar, com.tencent.zplan.resource.api.a aVar2, vj3.b bVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    hashMap = new HashMap();
                }
                aVar.p0(i3, hashMap, (i16 & 4) != 0 ? null : kVar, (i16 & 8) != 0 ? null : aVar2, (i16 & 16) != 0 ? null : bVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadResourceByScene");
        }

        public static /* synthetic */ void c(a aVar, List list, List list2, boolean z16, com.tencent.zplan.resource.api.a aVar2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                if ((i3 & 8) != 0) {
                    aVar2 = null;
                }
                aVar.x0(list, list2, z16, aVar2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadRecordResources");
        }

        public static /* synthetic */ void b(a aVar, com.tencent.zplan.resource.api.a aVar2, vj3.b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    aVar2 = null;
                }
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                aVar.B(aVar2, bVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadHotPatchResource");
        }
    }
}
