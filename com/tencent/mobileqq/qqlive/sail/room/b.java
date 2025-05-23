package com.tencent.mobileqq.qqlive.sail.room;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/b;", "", "", "expect", "", "a", "b", "", "toString", "", "", "Ljava/util/Map;", "stateMap", "I", "currentState", "c", "()I", "current", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final SparseArray<String> f272424d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, List<Integer>> stateMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/b$a;", "", "", "STATE_DESTROYED", "I", "STATE_IDLE", "STATE_PAUSED", "STATE_RESUMED", "STATE_STARTED", "STATE_STARTING", "STATE_STOPPED", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(0, "STATE_IDLE");
        sparseArray.put(30, "STATE_STARTING");
        sparseArray.put(40, "STATE_STARTED");
        sparseArray.put(50, "STATE_PAUSED");
        sparseArray.put(60, "STATE_RESUMED");
        sparseArray.put(70, "STATE_STOPPED");
        sparseArray.put(80, "STATE_DESTROYED");
        f272424d = sparseArray;
    }

    public b() {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        List listOf5;
        List listOf6;
        List emptyList;
        Map<Integer, List<Integer>> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{30, 80});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 40, 70, 80});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{60, 50, 70, 80});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{60, 70, 80});
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{50, 70, 80});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{30, 80});
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, listOf), TuplesKt.to(30, listOf2), TuplesKt.to(40, listOf3), TuplesKt.to(50, listOf4), TuplesKt.to(60, listOf5), TuplesKt.to(70, listOf6), TuplesKt.to(80, emptyList));
            this.stateMap = mapOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public final boolean a(int expect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, expect)).booleanValue();
        }
        if (b(expect)) {
            this.currentState = expect;
            return true;
        }
        AegisLogger.INSTANCE.w("Open_Live|AudienceRoomState", "changeState", "cannot change state, current=" + this.currentState + ", expect=" + expect);
        return false;
    }

    public final boolean b(int expect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, expect)).booleanValue();
        }
        List<Integer> list = this.stateMap.get(Integer.valueOf(c()));
        if (list == null || !list.contains(Integer.valueOf(expect))) {
            return false;
        }
        return true;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.currentState;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "currentState=" + ((Object) f272424d.get(this.currentState));
    }
}
