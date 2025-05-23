package com.tencent.mobileqq.vas.font.manager;

import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/h;", "", "a", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f309245a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/h$a;", "", "Lcom/tencent/mobileqq/vas/font/manager/i;", "b", "Lcom/tencent/mobileqq/vas/font/manager/i;", "()Lcom/tencent/mobileqq/vas/font/manager/i;", "HY_LOAD_MANAGER", "c", "a", "FZ_LOAD_MANAGER", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.font.manager.h$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f309245a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final i HY_LOAD_MANAGER;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final i FZ_LOAD_MANAGER;

        static {
            String SCID_HYFONT_SO = FontSoBusiness.SCID_HYFONT_SO;
            Intrinsics.checkNotNullExpressionValue(SCID_HYFONT_SO, "SCID_HYFONT_SO");
            HY_LOAD_MANAGER = new i(SCID_HYFONT_SO);
            String SCID_COLORFONT_SO = FontSoBusiness.SCID_COLORFONT_SO;
            Intrinsics.checkNotNullExpressionValue(SCID_COLORFONT_SO, "SCID_COLORFONT_SO");
            FZ_LOAD_MANAGER = new i(SCID_COLORFONT_SO);
        }

        Companion() {
        }

        @NotNull
        public final i a() {
            return FZ_LOAD_MANAGER;
        }

        @NotNull
        public final i b() {
            return HY_LOAD_MANAGER;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/h$b;", "", "", "isSuccess", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(boolean isSuccess);
    }
}
