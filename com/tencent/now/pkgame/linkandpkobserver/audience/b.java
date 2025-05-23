package com.tencent.now.pkgame.linkandpkobserver.audience;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.now.pkgame.linkandpkobserver.audience.PKLinkMicOffChecker;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import qo3.SeiConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u0016\u001aB\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "", "", "j", "Lqo3/a;", "seiConfig", "e", "f", "Lcom/tencent/mobileqq/qqlive/callback/room/VideoSeiInfo;", "info", "", "roomId", "g", "Lgo3/a;", "c", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b$b;", "seiCallback", "", "seiEndAutoClear", h.F, "d", "i", "a", "Lgo3/a;", "linkMicBean", "", "b", "Ljava/util/Map;", "seiCallbackMap", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker;", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker;", "linkMicOffChecker", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go3.a linkMicBean = new go3.a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<InterfaceC9251b, Boolean> seiCallbackMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PKLinkMicOffChecker linkMicOffChecker = new PKLinkMicOffChecker(new c());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/audience/b$b;", "", "Lqo3/a;", "seiConfig", "", "b", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.pkgame.linkandpkobserver.audience.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9251b {
        void a();

        void b(@NotNull SeiConfig seiConfig);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/b$c", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker$b;", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements PKLinkMicOffChecker.b {
        c() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.audience.PKLinkMicOffChecker.b
        public void a() {
            b.this.f();
            b.this.j();
        }
    }

    private final void e(SeiConfig seiConfig) {
        Iterator<Map.Entry<InterfaceC9251b, Boolean>> it = this.seiCallbackMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().b(seiConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        AegisLogger.INSTANCE.i("PK_Biz|AudienceSeiInfoSubscriber", "notifySeiLinkEnd, hashCode:" + hashCode());
        Iterator<Map.Entry<InterfaceC9251b, Boolean>> it = this.seiCallbackMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        AegisLogger.INSTANCE.i("PK_Biz|AudienceSeiInfoSubscriber", "unRegisterSeiCallback, thread:" + Thread.currentThread().getName());
        Iterator<Map.Entry<InterfaceC9251b, Boolean>> it = this.seiCallbackMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                it.remove();
            }
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final go3.a getLinkMicBean() {
        return this.linkMicBean;
    }

    public final void g(@NotNull VideoSeiInfo info, long roomId) {
        Intrinsics.checkNotNullParameter(info, "info");
        SeiConfig a16 = qo3.b.a(info.seiData);
        if (a16.c() == null) {
            return;
        }
        e(a16);
        if (a16.e() && (!a16.c().isEmpty())) {
            go3.a aVar = new go3.a("on");
            aVar.h(roomId);
            aVar.g(a16.c().get(0));
            aVar.i(new i(a16.getW(), a16.getH()));
            aVar.f(SystemClock.elapsedRealtime());
            this.linkMicBean = aVar;
        } else {
            go3.a aVar2 = new go3.a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            aVar2.f(SystemClock.elapsedRealtime());
            aVar2.h(roomId);
            this.linkMicBean = aVar2;
        }
        this.linkMicOffChecker.k(this.linkMicBean);
        if (!this.linkMicOffChecker.getTimerIsRunning() && this.linkMicBean.e()) {
            this.linkMicOffChecker.g();
        }
    }

    public final void h(@NotNull InterfaceC9251b seiCallback, boolean seiEndAutoClear) {
        Intrinsics.checkNotNullParameter(seiCallback, "seiCallback");
        this.seiCallbackMap.put(seiCallback, Boolean.valueOf(seiEndAutoClear));
        AegisLogger.INSTANCE.i("PK_Biz|AudienceSeiInfoSubscriber", "registerSeiCallback, size:" + this.seiCallbackMap.size());
    }

    public final void i() {
        AegisLogger.INSTANCE.i("PK_Biz|AudienceSeiInfoSubscriber", "unInit, hashCode:" + hashCode());
        this.seiCallbackMap.clear();
        this.linkMicOffChecker.i();
    }

    public final void d() {
    }
}
