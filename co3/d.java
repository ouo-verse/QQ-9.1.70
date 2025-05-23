package co3;

import com.tencent.component.core.event.EventCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.PKEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lco3/d;", "", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "callback", "", "f", "e", "d", "Lhn3/d;", "pkEventInfo", "g", h.F, "a", "", "c", "b", "Lhn3/d;", "curPKEvent", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PKEvent curPKEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.linkandpkobserver.a callback;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final PKEvent getCurPKEvent() {
        return this.curPKEvent;
    }

    public final boolean b() {
        PKEvent pKEvent = this.curPKEvent;
        if (pKEvent == null || pKEvent.getPkId() == 0 || pKEvent.getPkStatus() == 4 || pKEvent.getPkStatus() == 6) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        PKEvent pKEvent = this.curPKEvent;
        if (pKEvent == null || pKEvent.getPkId() == 0) {
            return false;
        }
        if ((pKEvent.getPkType() != 1 && pKEvent.getPkType() != 2) || pKEvent.getPkStatus() == 4 || pKEvent.getPkStatus() == 6) {
            return false;
        }
        return true;
    }

    public final void d() {
        com.tencent.now.pkgame.linkandpkobserver.a aVar = this.callback;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void e() {
        com.tencent.now.pkgame.linkandpkobserver.a aVar = this.callback;
        if (aVar != null) {
            aVar.b(null);
        }
    }

    public final void f(@NotNull com.tencent.now.pkgame.linkandpkobserver.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public final void g(@NotNull PKEvent pkEventInfo) {
        com.tencent.now.pkgame.linkandpkobserver.a aVar;
        Intrinsics.checkNotNullParameter(pkEventInfo, "pkEventInfo");
        if (pkEventInfo.getEventType() == 3 && (aVar = this.callback) != null) {
            aVar.d();
        }
        this.curPKEvent = pkEventInfo;
        EventCenter.post(pkEventInfo);
        com.tencent.now.pkgame.linkandpkobserver.a aVar2 = this.callback;
        if (aVar2 != null) {
            aVar2.e(pkEventInfo.getPkStatus(), pkEventInfo.getAnchorInfo(), pkEventInfo.getPkId(), pkEventInfo.getPkType());
        }
    }

    public final void h(@NotNull PKEvent pkEventInfo) {
        Intrinsics.checkNotNullParameter(pkEventInfo, "pkEventInfo");
        PKEvent pKEvent = this.curPKEvent;
        if (pKEvent == null) {
            AegisLogger.INSTANCE.e("PK_Biz|CurrentPKInfoMode", "stopPKGame is invalid!", "because there is no pkgame now!");
            return;
        }
        boolean z16 = false;
        if (pKEvent != null && pkEventInfo.getPkId() == pKEvent.getPkId()) {
            z16 = true;
        }
        if (!z16) {
            AegisLogger.INSTANCE.e("PK_Biz|CurrentPKInfoMode", "stopPKGame is invalid!", "because the pk need to stop is not current pk game!");
            return;
        }
        EventCenter.post(pkEventInfo);
        com.tencent.now.pkgame.linkandpkobserver.a aVar = this.callback;
        if (aVar != null) {
            aVar.d();
        }
        this.curPKEvent = null;
    }
}
