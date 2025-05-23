package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014H&J\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001c\u0010!\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0016J\u001e\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016R\u0014\u0010'\u001a\u00020$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/v;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/u;", "", "eventHandler", "L", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/w;", "loadDataArgs", "y1", "e1", ReportConstant.COSTREPORT_PREFIX, "t0", "", "E", "", "Lhl1/g;", "i", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/x;", "observer", "F1", "N", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/c;", "d", "I", "A1", "", "action", "args", "c", "a0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getIdentifier", "()I", IECDtReport.ACTION_IDENTIFIER, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface v {
    void A1(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer);

    boolean E();

    void F1(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer);

    void I(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer);

    void L(@NotNull Function1<? super u, Unit> eventHandler);

    void N(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer);

    @Nullable
    Object a0(@Nullable String action, @Nullable Object args);

    void b(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer);

    boolean c(@Nullable String action, @Nullable Object args);

    void d(@NotNull LifecycleOwner owner, @NotNull Observer<DataChangedState> observer);

    void e1(@NotNull LoadDataArgs loadDataArgs);

    int getIdentifier();

    @NotNull
    List<hl1.g> i();

    void onDestroy();

    void s(@NotNull LoadDataArgs loadDataArgs);

    void t0(@NotNull LoadDataArgs loadDataArgs);

    void y1(@NotNull LoadDataArgs loadDataArgs);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static Object a(@NotNull v vVar, @Nullable String str, @Nullable Object obj) {
            return null;
        }

        public static boolean b(@NotNull v vVar, @Nullable String str, @Nullable Object obj) {
            return false;
        }

        public static void d(@NotNull v vVar, @NotNull LoadDataArgs loadDataArgs) {
            Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        }

        public static void e(@NotNull v vVar, @NotNull LoadDataArgs loadDataArgs) {
            Intrinsics.checkNotNullParameter(loadDataArgs, "loadDataArgs");
        }

        public static void c(@NotNull v vVar) {
        }
    }
}
