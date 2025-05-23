package com.tencent.qqnt.inner.compator.troopinfo.processor;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/inner/compator/troopinfo/processor/o;", "Lcom/tencent/qqnt/inner/compator/troopinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "c", "a", "", "Ljava/lang/String;", "oldName", "", "Ljava/util/List;", "changedInfoList", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class o implements com.tencent.qqnt.inner.compator.troopinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String oldName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TroopInfo> changedInfoList;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.changedInfoList = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object LOCK = com.tencent.mobileqq.troop.api.utils.a.f294337a;
        Intrinsics.checkNotNullExpressionValue(LOCK, "LOCK");
        synchronized (LOCK) {
            Iterator<TroopInfo> it = this$0.changedInfoList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.troop.api.utils.a.d(it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.inner.compator.troopinfo.processor.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.e(o.this);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void b(@Nullable TroopInfo troopInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo != null) {
            str = troopInfo.getTroopDisplayName();
        } else {
            str = null;
        }
        this.oldName = str;
    }

    @Override // com.tencent.qqnt.inner.compator.troopinfo.a
    public void c(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopInfo);
        } else if (troopInfo != null && !Intrinsics.areEqual(this.oldName, troopInfo.getTroopDisplayName())) {
            this.changedInfoList.add(troopInfo);
        }
    }
}
