package com.tencent.rdelivery.reshub.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rdelivery.RDelivery;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J$\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u0004H&J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u001e\u0010\u001b\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u001aH&J\u001a\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010#\u001a\u00020\nH&J\u001a\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0002H&J\n\u0010(\u001a\u0004\u0018\u00010'H&J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0002H&J\b\u0010*\u001a\u00020\u0010H&\u00a8\u0006+"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/i;", "", "", "resId", "", "validateResFile", "Lcom/tencent/rdelivery/reshub/api/g;", "b", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "forceRequestRemoteConfig", "j", "p", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "d", "a", "l", "Liz3/e;", "listener", "g", "", "keys", "Liz3/l;", "f", WadlProxyConsts.SCENE_ID, "Lcom/tencent/rdelivery/reshub/api/b;", "batchCallback", "c", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "deleteAll", "key", "value", DomainData.DOMAIN_NAME, "Lcom/tencent/rdelivery/RDelivery;", "i", "getLastRequestServerTime", "k", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface i {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ g a(i iVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return iVar.b(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ g b(i iVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return iVar.q(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLatest");
        }

        public static /* synthetic */ g c(i iVar, String str, long j3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                return iVar.d(str, j3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSpecific");
        }

        public static void d(i iVar, @NotNull String resId, @Nullable h hVar) {
            Intrinsics.checkParameterIsNotNull(resId, "resId");
            iVar.j(resId, hVar, false);
        }
    }

    void a(@NotNull String resId, long taskId, @Nullable h callback);

    @Nullable
    g b(@NotNull String resId, boolean validateResFile);

    void c(long sceneId, @Nullable b batchCallback);

    @Nullable
    g d(@NotNull String resId, long taskId, boolean validateResFile);

    void deleteAll();

    void e(@NotNull String resId, @Nullable h callback);

    void f(@NotNull List<String> keys, @NotNull iz3.l listener);

    void g(@Nullable iz3.e listener);

    long getLastRequestServerTime(@NotNull String key);

    void h(@NotNull String resId, long taskId);

    @Nullable
    RDelivery i();

    void j(@NotNull String resId, @Nullable h callback, boolean forceRequestRemoteConfig);

    long k();

    @Nullable
    g l(@NotNull String resId);

    void m(@NotNull String resId);

    void n(@NotNull String key, @Nullable String value);

    boolean o(@NotNull String resId);

    void p(@NotNull String resId, @Nullable h callback);

    @Nullable
    g q(@NotNull String resId, boolean validateResFile);
}
