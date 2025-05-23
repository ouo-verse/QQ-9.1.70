package com.tencent.mobileqq.icgame.framework.page.manager;

import com.tencent.mobileqq.icgame.framework.page.Page;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\bR+\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/manager/PageManager;", "", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "page", "", "a", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Lkotlin/Lazy;", "c", "()Ljava/util/ArrayList;", "pageList", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PageManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PageManager f237343a = new PageManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy pageList;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ArrayList<Page>>() { // from class: com.tencent.mobileqq.icgame.framework.page.manager.PageManager$pageList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<Page> invoke() {
                return new ArrayList<>();
            }
        });
        pageList = lazy;
    }

    PageManager() {
    }

    private final ArrayList<Page> c() {
        return (ArrayList) pageList.getValue();
    }

    public final void a(@NotNull Page page) {
        Intrinsics.checkNotNullParameter(page, "page");
        c().add(page);
    }

    @NotNull
    public final ArrayList<Page> b() {
        return new ArrayList<>(c());
    }

    public final void d(@NotNull Page page) {
        Intrinsics.checkNotNullParameter(page, "page");
        c().remove(page);
    }
}
