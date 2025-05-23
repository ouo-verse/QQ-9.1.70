package nh1;

import android.content.Context;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lnh1/c;", "", "Landroid/content/Context;", "context", "", "searchKey", "", "searchEntryPageType", "", IECSearchBar.METHOD_DO_SEARCH, "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f420140a = new c();

    c() {
    }

    public final void a(@NotNull Context context, @NotNull String searchKey, int searchEntryPageType, boolean doSearch, @Nullable GuildAppReportSourceInfo reportSourceInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchKey, "searchKey");
        ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).jump2SearchFromGuild(context);
        Logger.f235387a.d().i("GuildSearchTempUtil", 1, "start searchKey=" + searchKey + " searchEntryPageType=" + searchEntryPageType + " doSearch=" + doSearch);
    }
}
