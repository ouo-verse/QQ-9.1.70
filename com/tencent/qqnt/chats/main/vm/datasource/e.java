package com.tencent.qqnt.chats.main.vm.datasource;

import androidx.core.app.NotificationCompat;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J.\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\bH\u0016J\u0016\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "", "isGuildUpdate", "", "f", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "b", "", NotificationCompat.CATEGORY_ERROR, "", "msg", "e", "uidList", "d", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "result", "errMsg", "curSpecifyInfo", "a", "onLitterEarChange", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface e {
    void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo);

    void b(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> changedList, boolean isGuildUpdate);

    void c(@NotNull List<Long> uinList);

    void d(@NotNull List<String> uidList);

    void e(int err, @NotNull String msg2);

    void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate);

    void onLitterEarChange();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static void a(@NotNull e eVar, @NotNull List<String> uidList) {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
        }

        public static void b(@NotNull e eVar, @NotNull List<Long> uinList) {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
        }

        public static void c(@NotNull e eVar, int i3, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        public static /* synthetic */ void f(e eVar, RecentContactListChangedInfo recentContactListChangedInfo, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                eVar.f(recentContactListChangedInfo, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRecentContactListChanged");
        }

        public static /* synthetic */ void g(e eVar, List list, List list2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                eVar.b(list, list2, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRecentContactPartChanged");
        }

        public static void e(@NotNull e eVar) {
        }

        public static void d(@NotNull e eVar, int i3, @Nullable String str, @Nullable RecentContactInfo recentContactInfo) {
        }
    }
}
