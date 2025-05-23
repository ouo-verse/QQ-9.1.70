package fj;

import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.qqnt.kernel.api.IKernelService;
import cooperation.qzone.QUA;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\n"}, d2 = {"Lfj/r;", "", "Lcom/tencent/qqnt/kernel/api/g;", "b", "", "c", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f399469a = new r();

    r() {
    }

    @JvmStatic
    public static final com.tencent.qqnt.kernel.api.g b() {
        IKernelService iKernelService;
        f399469a.c();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) == null) {
            return null;
        }
        return iKernelService.getAlbumService();
    }

    private final void c() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.qqnt.kernel.api.g albumService = (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) == null) ? null : iKernelService.getAlbumService();
        if (albumService != null) {
            albumService.setAlbumServiceInfo(peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null, QUA.getQUA3(), a());
        }
    }

    private final String a() {
        return QZoneRequest.getDeiviceInfoDetailInner(false);
    }
}
