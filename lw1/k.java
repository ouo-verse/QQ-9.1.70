package lw1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.quicksearch.resultview.history.GuildQuickSearchData;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Llw1/k;", "", "", "c", "", "e", "searchWords", "a", "b", "f", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "key", "", "Z", "hasChanged", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "_searchHistoryLiveData", "", "Ljava/util/List;", "searchHistoryList", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "searchHistoryLiveData", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> _searchHistoryLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> searchHistoryList;

    public k(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.key = c();
        this._searchHistoryLiveData = new MutableLiveData<>();
        this.searchHistoryList = new ArrayList();
        MMKVOptionEntity L = bw.L();
        if (L.containsKey(this.key)) {
            GuildQuickSearchData guildQuickSearchData = (GuildQuickSearchData) L.decodeParcelable(this.key, GuildQuickSearchData.class, new GuildQuickSearchData());
            List<String> list = this.searchHistoryList;
            List<String> a16 = guildQuickSearchData.a();
            Intrinsics.checkNotNullExpressionValue(a16, "guildQuickSearchData.searchList");
            list.addAll(a16);
        }
        e();
    }

    private final String c() {
        return "MMKV_KEY_GUILD_QUICK_SEARCH_HISTORY_" + this.guildId + "_" + ch.g();
    }

    private final void e() {
        this._searchHistoryLiveData.setValue(this.searchHistoryList);
    }

    public final void a(@Nullable String searchWords) {
        boolean z16;
        List take;
        List<String> mutableList;
        if (searchWords != null && searchWords.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        int indexOf = this.searchHistoryList.indexOf(searchWords);
        if (indexOf >= 0) {
            this.searchHistoryList.remove(indexOf);
        }
        this.searchHistoryList.add(0, searchWords);
        if (this.searchHistoryList.size() > 10) {
            take = CollectionsKt___CollectionsKt.take(this.searchHistoryList, 10);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) take);
            this.searchHistoryList = mutableList;
        }
        this.hasChanged = true;
        e();
    }

    public final void b() {
        this.searchHistoryList.clear();
        this.hasChanged = true;
        e();
    }

    @NotNull
    public final LiveData<List<String>> d() {
        return this._searchHistoryLiveData;
    }

    public final void f() {
        if (this.hasChanged) {
            this.hasChanged = false;
            GuildQuickSearchData guildQuickSearchData = new GuildQuickSearchData();
            guildQuickSearchData.b(this.searchHistoryList);
            bw.L().encodeParcelable(this.key, guildQuickSearchData);
        }
    }
}
