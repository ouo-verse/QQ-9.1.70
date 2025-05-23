package com.tencent.qqnt.qbasealbum.select.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import ox3.a;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J=\u0010\f\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022'\u0010\u000b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J\u0006\u0010\r\u001a\u00020\nR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/repository/SelectedLocalMediaRepository;", "", "", "", "mediaPaths", "Lkotlin/Function1;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", QAdVrReportParams.ParamKey.MEDIA, "", "onQueryFinish", "b", "c", "", "a", "Ljava/util/List;", "selectedMediaPaths", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SelectedLocalMediaRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> selectedMediaPaths;

    public SelectedLocalMediaRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.selectedMediaPaths = new ArrayList();
        }
    }

    public final void b(@NotNull List<String> mediaPaths, @NotNull Function1<? super List<LocalMediaInfo>, Unit> onQueryFinish) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPaths, (Object) onQueryFinish);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaPaths, "mediaPaths");
        Intrinsics.checkNotNullParameter(onQueryFinish, "onQueryFinish");
        if (mediaPaths.isEmpty()) {
            return;
        }
        this.selectedMediaPaths.clear();
        this.selectedMediaPaths.addAll(mediaPaths);
        a.j(SelectedLocalMediaRepository$querySelectedLocalMedia$1.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SelectedLocalMediaRepository$querySelectedLocalMedia$2(this, onQueryFinish, null), 3, null);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
