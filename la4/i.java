package la4;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lla4/i;", "Lla4/d;", "Landroid/os/Message;", "msg", "", "g", tl.h.F, "Lcom/tencent/sqshow/zootopia/player/f;", "options", "isQUIC", "isMultiLevel", "", "f", "e", "message", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"la4/i$b", "Lna4/d$b;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "continueNextProcess", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements d.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f414265b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f414266c;

        b(boolean z16, boolean z17) {
            this.f414265b = z16;
            this.f414266c = z17;
        }

        @Override // na4.d.b
        public void a(com.tencent.sqshow.zootopia.player.f options, boolean continueNextProcess) {
            Intrinsics.checkNotNullParameter(options, "options");
            QLog.d("QFSVideoPreloadExchangeUrlMsgProcess", 1, "preloadDownLoadExchangeUrl finish result:" + options);
            i.this.e(options, this.f414265b, this.f414266c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(com.tencent.sqshow.zootopia.player.f options, boolean isQUIC, boolean isMultiLevel) {
        com.tencent.sqshow.zootopia.player.preload.e m3 = com.tencent.sqshow.zootopia.player.preload.e.INSTANCE.a().m(options);
        com.tencent.sqshow.zootopia.player.preload.e s16 = m3.q(System.currentTimeMillis()).n(options.f()).s(options.a());
        Integer X0 = uq3.c.X0("qqcircle", "qqcircle_video_preload_duration", 5000);
        Intrinsics.checkNotNullExpressionValue(X0, "getConfigValue(\n        \u2026PRELOAD_DURATION_DEFAULT)");
        com.tencent.sqshow.zootopia.player.preload.e k3 = s16.l(X0.intValue()).k(isMultiLevel);
        pu4.g stVideoMaterial = options.getStVideoMaterial();
        com.tencent.sqshow.zootopia.player.preload.e t16 = k3.t(stVideoMaterial != null ? stVideoMaterial.f427441h : 0);
        pu4.g stVideoMaterial2 = options.getStVideoMaterial();
        t16.l(stVideoMaterial2 != null ? stVideoMaterial2.f427441h : 0);
        com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().r(1, m3);
        QLog.d("QFSVideoPreloadExchangeUrlMsgProcess", 1, "createRecordToCheckPreloadNum success");
    }

    private final void f(com.tencent.sqshow.zootopia.player.f options, boolean isQUIC, boolean isMultiLevel) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (isMultiLevel) {
            linkedList.add(Integer.valueOf(na4.d.INSTANCE.b()));
            QLog.d("QFSVideoPreloadExchangeUrlMsgProcess", 1, "exchangeVideoUrl use selected isMultiLevel:" + isMultiLevel);
        }
        na4.d.INSTANCE.a().j(linkedList, options, new b(isQUIC, isMultiLevel));
    }

    private final boolean g(Message msg2) {
        if (!h(msg2)) {
            return false;
        }
        Intrinsics.checkNotNull(msg2);
        Object obj = msg2.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) obj;
        Object obj2 = objArr[0];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.ZPlanPlayerOptions");
        com.tencent.sqshow.zootopia.player.f fVar = (com.tencent.sqshow.zootopia.player.f) obj2;
        if (com.tencent.sqshow.zootopia.player.preload.d.INSTANCE.a().o(fVar.a(), false) != null) {
            QLog.d("QFSVideoPreloadExchangeUrlMsgProcess", 1, "handlerExchangeURL return has preload");
            return false;
        }
        Object obj3 = objArr[1];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
        f(fVar, false, ((Boolean) obj3).booleanValue());
        return true;
    }

    private final boolean h(Message msg2) {
        Intrinsics.checkNotNull(msg2);
        Object obj = msg2.obj;
        if (!(obj instanceof Object[])) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) obj;
        return objArr.length >= 2 && (objArr[0] instanceof com.tencent.sqshow.zootopia.player.f) && (objArr[1] instanceof Boolean);
    }

    @Override // la4.d
    public boolean c(Message message) {
        return g(message);
    }
}
