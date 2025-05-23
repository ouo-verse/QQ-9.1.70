package g33;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;
import com.tencent.mobileqq.vas.util.VasUtil;
import g33.b;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lg33/b;", "", "Lcom/tencent/mobileqq/vas/pendant/proto/qcUserinfoServer$GetUserOrFriendUsingReq;", Const.BUNDLE_KEY_REQUEST, "Lg33/b$a;", "observer", "", "b", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f401206a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lg33/b$a;", "", "Lcom/tencent/mobileqq/vas/pendant/proto/qcUserinfoServer$GetUserOrFriendUsingRsp;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a(@NotNull qcUserinfoServer.GetUserOrFriendUsingRsp data);
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a observer, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (z16) {
            qcUserinfoServer.GetUserOrFriendUsingRsp getUserOrFriendUsingRsp = new qcUserinfoServer.GetUserOrFriendUsingRsp();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            getUserOrFriendUsingRsp.mergeFrom((byte[]) obj);
            observer.a(getUserOrFriendUsingRsp);
        }
    }

    public final void b(@NotNull qcUserinfoServer.GetUserOrFriendUsingReq request, @NotNull final a observer) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(observer, "observer");
        try {
            IPbProtocol pbRequest = VasUtil.getService().getPbRequest();
            byte[] byteArray = request.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
            Charset forName = Charset.forName("ISO8859_1");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"ISO8859_1\")");
            pbRequest.request("trpc.qqva.qc_userinfo_server.QcUserinfoServer.SsoGetUserOrFriendUsing", new String(byteArray, forName), new BusinessObserver() { // from class: g33.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    b.c(b.a.this, i3, z16, obj);
                }
            });
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
