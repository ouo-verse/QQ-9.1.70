package com.tencent.mobileqq.album.media;

import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\"\u0010#J$\u0010\b\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\r\u001a\u00020\u0005J\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0007J \u0010\u0018\u001a\u001c\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u00020\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bRp\u0010!\u001a^\u0012\u0004\u0012\u00020\u0005\u0012$\u0012\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0004\u0012\u00020\u00070\u001e0\u001dj.\u0012\u0004\u0012\u00020\u0005\u0012$\u0012\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0004\u0012\u00020\u00070\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/album/media/AIOMediaRepository;", "", "Lkotlin/Pair;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "", "pair", "", "i", "g", "", "Lcom/tencent/mobileqq/album/media/c;", "e", h.F, "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "localMediaInfo", "", "b", "j", "k", "c", "Lkotlinx/coroutines/flow/Flow;", "d", "Lcom/tencent/mobileqq/album/ext/c;", "a", "Ljava/util/List;", "selectedMediaInfos", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "listeners", "<init>", "()V", "album_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMediaRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.album.ext.c> selectedMediaInfos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Function1<Pair<? extends List<LocalMediaInfo>, Integer>, Unit>> listeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/album/media/AIOMediaRepository$a;", "", "", "REFRESH_DEFAULT", "I", "REFRESH_SEQ", "REFRESH_THUMB", "<init>", "()V", "album_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.album.media.AIOMediaRepository$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMediaRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.selectedMediaInfos = new ArrayList();
            this.listeners = new HashMap<>();
        }
    }

    private final void i(Pair<? extends List<LocalMediaInfo>, Integer> pair) {
        Collection<Function1<Pair<? extends List<LocalMediaInfo>, Integer>, Unit>> values = this.listeners.values();
        Intrinsics.checkNotNullExpressionValue(values, "listeners.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(pair);
        }
    }

    public final boolean b(@NotNull LocalMediaInfo localMediaInfo) {
        List mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        boolean add = this.selectedMediaInfos.add(WrapLocalMediaInfoKt.j(localMediaInfo));
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(localMediaInfo);
        i(new Pair<>(mutableListOf, 1));
        return add;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList(WrapLocalMediaInfoKt.c(this.selectedMediaInfos));
        this.selectedMediaInfos.clear();
        Unit unit = Unit.INSTANCE;
        if (!arrayList.isEmpty()) {
            i(new Pair<>(arrayList, 1));
        }
    }

    @NotNull
    public final Flow<Pair<List<LocalMediaInfo>, Integer>> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Flow) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return FlowKt.callbackFlow(new AIOMediaRepository$getDataChangeFlow$1(this, null));
    }

    @NotNull
    public final List<c> e() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<LocalMediaInfo> g16 = g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(b.c((LocalMediaInfo) it.next(), null, null, 3, null));
        }
        return arrayList;
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super List<c>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) continuation);
        }
        return BuildersKt.withContext(Dispatchers.getDefault(), new AIOMediaRepository$getPickPhotoWithMd5Result$2(this, null), continuation);
    }

    @NotNull
    public final List<LocalMediaInfo> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WrapLocalMediaInfoKt.c(this.selectedMediaInfos);
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.selectedMediaInfos.size();
    }

    public final void j(@NotNull LocalMediaInfo localMediaInfo) {
        List mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) localMediaInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(localMediaInfo);
        i(new Pair<>(mutableListOf, 2));
    }

    public final boolean k(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        ArrayList arrayList = new ArrayList(WrapLocalMediaInfoKt.c(this.selectedMediaInfos));
        boolean remove = this.selectedMediaInfos.remove(WrapLocalMediaInfoKt.j(localMediaInfo));
        i(new Pair<>(arrayList, 1));
        return remove;
    }

    @NotNull
    public final List<c> l() {
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.selectedMediaInfos);
            return WrapLocalMediaInfoKt.i(mutableList);
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }
}
