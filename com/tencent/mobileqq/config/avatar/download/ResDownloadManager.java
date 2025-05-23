package com.tencent.mobileqq.config.avatar.download;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bRP\u0010\u0012\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e0\fj\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/download/ResDownloadManager;", "", "", "url", "Lcom/tencent/mobileqq/config/avatar/download/a;", "callback", "", "b", "Lcom/tencent/mobileqq/config/avatar/download/d;", "file", "", "c", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "mDownloadingTaskMap", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ResDownloadManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<ResDownloadManager> f202374c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<a>> mDownloadingTaskMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/download/ResDownloadManager$a;", "", "Lcom/tencent/mobileqq/config/avatar/download/ResDownloadManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/config/avatar/download/ResDownloadManager;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.avatar.download.ResDownloadManager$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ResDownloadManager a() {
            return (ResDownloadManager) ResDownloadManager.f202374c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ResDownloadManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ResDownloadManager>() { // from class: com.tencent.mobileqq.config.avatar.download.ResDownloadManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ResDownloadManager invoke() {
                return new ResDownloadManager(null);
            }
        });
        f202374c = lazy;
    }

    public /* synthetic */ ResDownloadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final synchronized boolean b(@NotNull String url, @NotNull a callback) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        containsKey = this.mDownloadingTaskMap.containsKey(url);
        if (containsKey) {
            ArrayList<a> arrayList = this.mDownloadingTaskMap.get(url);
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(callback);
        } else {
            HashMap<String, ArrayList<a>> hashMap = this.mDownloadingTaskMap;
            ArrayList<a> arrayList2 = new ArrayList<>();
            arrayList2.add(callback);
            Unit unit = Unit.INSTANCE;
            hashMap.put(url, arrayList2);
        }
        return containsKey;
    }

    public final synchronized void c(@NotNull String url, @Nullable ResFile file) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.mDownloadingTaskMap.containsKey(url)) {
            ArrayList<a> arrayList = this.mDownloadingTaskMap.get(url);
            Intrinsics.checkNotNull(arrayList);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(file);
            }
            this.mDownloadingTaskMap.remove(url);
        }
    }

    ResDownloadManager() {
        this.mDownloadingTaskMap = new HashMap<>();
    }
}
