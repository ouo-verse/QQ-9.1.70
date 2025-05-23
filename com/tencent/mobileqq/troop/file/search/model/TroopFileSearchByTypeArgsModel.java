package com.tencent.mobileqq.troop.file.search.model;

import android.os.Bundle;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u0005\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "", "", "toString", "", "a", "Lkotlin/Lazy;", "c", "()J", "troopUinL", "", "b", "()I", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "source", "Landroid/os/Bundle;", "args", "<init>", "(Landroid/os/Bundle;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileSearchByTypeArgsModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopUinL;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy searchType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy source;

    public TroopFileSearchByTypeArgsModel(final Bundle args) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(args, "args");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.file.search.model.TroopFileSearchByTypeArgsModel$troopUinL$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(args.getLong("troop_uin"));
            }
        });
        this.troopUinL = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.file.search.model.TroopFileSearchByTypeArgsModel$searchType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(args.getInt("title_type"));
            }
        });
        this.searchType = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.file.search.model.TroopFileSearchByTypeArgsModel$source$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(args.getInt("key_source", 0));
            }
        });
        this.source = lazy3;
    }

    public final int a() {
        return ((Number) this.searchType.getValue()).intValue();
    }

    public final int b() {
        return ((Number) this.source.getValue()).intValue();
    }

    public final long c() {
        return ((Number) this.troopUinL.getValue()).longValue();
    }

    public String toString() {
        return "TroopFileSearchByTypeArgsModel, troopUinL:" + c() + ", searchType:" + a() + ", source:" + b();
    }
}
