package com.tencent.mobileqq.guild.home.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 42\u00020\u0001:\u0003567B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001b0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0(8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010*R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001b0(8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010*R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\b0(8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010*\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "Lef1/b;", "", "guildId", "", "T1", "account", "onAccountChanged", "", "index", "prevIndex", "", "isClick", "U1", "channelId", "S1", "sortMode", "N1", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "currentGuildId", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "D", "Landroidx/lifecycle/MutableLiveData;", "_tabDataListLiveData", "Lef1/a;", "Lcom/tencent/mobileqq/guild/home/viewmodels/e$c;", "E", "_liveEventSelectTab", "Lcom/tencent/mobileqq/guild/home/viewmodels/e$b;", UserInfo.SEX_FEMALE, "_feedSquareSwitchEvent", "G", "_feedSortMode", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "H", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "tabDataListLiveData", "Q1", "liveEventSelectTab", "P1", "feedSwitchEvent", "O1", "feedSortMode", "<init>", "(Ljava/lang/String;)V", "I", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String currentGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<c.GuildHomeSubTabData>> _tabDataListLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<ef1.a<SelectTabEvent>> _liveEventSelectTab;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<ef1.a<FeedSquareSwitchEvent>> _feedSquareSwitchEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _feedSortMode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/e$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "channelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.e$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedSquareSwitchEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        public FeedSquareSwitchEvent(@NotNull String guildId, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.guildId = guildId;
            this.channelId = channelId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedSquareSwitchEvent)) {
                return false;
            }
            FeedSquareSwitchEvent feedSquareSwitchEvent = (FeedSquareSwitchEvent) other;
            if (Intrinsics.areEqual(this.guildId, feedSquareSwitchEvent.guildId) && Intrinsics.areEqual(this.channelId, feedSquareSwitchEvent.channelId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.guildId.hashCode() * 31) + this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "FeedSquareSwitchEvent(guildId=" + this.guildId + ", channelId=" + this.channelId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/e$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getIndex", "()I", "index", "b", "Z", "isClick", "()Z", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "c", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "()Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "tabData", "d", "getPrevTabData", "prevTabData", "<init>", "(IZLcom/tencent/mobileqq/guild/home/subhome/c$b;Lcom/tencent/mobileqq/guild/home/subhome/c$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.e$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class SelectTabEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isClick;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final c.GuildHomeSubTabData tabData;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final c.GuildHomeSubTabData prevTabData;

        public SelectTabEvent(int i3, boolean z16, @Nullable c.GuildHomeSubTabData guildHomeSubTabData, @Nullable c.GuildHomeSubTabData guildHomeSubTabData2) {
            this.index = i3;
            this.isClick = z16;
            this.tabData = guildHomeSubTabData;
            this.prevTabData = guildHomeSubTabData2;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final c.GuildHomeSubTabData getTabData() {
            return this.tabData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectTabEvent)) {
                return false;
            }
            SelectTabEvent selectTabEvent = (SelectTabEvent) other;
            if (this.index == selectTabEvent.index && this.isClick == selectTabEvent.isClick && Intrinsics.areEqual(this.tabData, selectTabEvent.tabData) && Intrinsics.areEqual(this.prevTabData, selectTabEvent.prevTabData)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int i3 = this.index * 31;
            boolean z16 = this.isClick;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (i3 + i16) * 31;
            c.GuildHomeSubTabData guildHomeSubTabData = this.tabData;
            int i18 = 0;
            if (guildHomeSubTabData == null) {
                hashCode = 0;
            } else {
                hashCode = guildHomeSubTabData.hashCode();
            }
            int i19 = (i17 + hashCode) * 31;
            c.GuildHomeSubTabData guildHomeSubTabData2 = this.prevTabData;
            if (guildHomeSubTabData2 != null) {
                i18 = guildHomeSubTabData2.hashCode();
            }
            return i19 + i18;
        }

        @NotNull
        public String toString() {
            return "SelectTabEvent(index=" + this.index + ", isClick=" + this.isClick + ", tabData=" + this.tabData + ", prevTabData=" + this.prevTabData + ")";
        }
    }

    public e(@NotNull String currentGuildId) {
        Intrinsics.checkNotNullParameter(currentGuildId, "currentGuildId");
        this.currentGuildId = currentGuildId;
        this._tabDataListLiveData = new MutableLiveData<>();
        this._liveEventSelectTab = new MutableLiveData<>();
        this._feedSquareSwitchEvent = new MutableLiveData<>();
        this._feedSortMode = new MutableLiveData<>();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeSubTabPageViewModel", 1, "addObserver");
        }
    }

    public final void N1(int sortMode) {
        this._feedSortMode.setValue(Integer.valueOf(sortMode));
    }

    @NotNull
    public final LiveData<Integer> O1() {
        return this._feedSortMode;
    }

    @NotNull
    public final LiveData<ef1.a<FeedSquareSwitchEvent>> P1() {
        return this._feedSquareSwitchEvent;
    }

    @NotNull
    public final LiveData<ef1.a<SelectTabEvent>> Q1() {
        return this._liveEventSelectTab;
    }

    @NotNull
    public final LiveData<List<c.GuildHomeSubTabData>> R1() {
        return this._tabDataListLiveData;
    }

    public final void S1(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this._feedSquareSwitchEvent.setValue(new ef1.a<>(new FeedSquareSwitchEvent(guildId, channelId)));
    }

    public final void T1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.currentGuildId = guildId;
    }

    public final void U1(int index, int prevIndex, boolean isClick) {
        Object m476constructorimpl;
        Object m476constructorimpl2;
        c.GuildHomeSubTabData guildHomeSubTabData;
        c.GuildHomeSubTabData guildHomeSubTabData2;
        MutableLiveData<ef1.a<SelectTabEvent>> mutableLiveData = this._liveEventSelectTab;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            List<c.GuildHomeSubTabData> value = this._tabDataListLiveData.getValue();
            if (value != null) {
                guildHomeSubTabData2 = value.get(index);
            } else {
                guildHomeSubTabData2 = null;
            }
            m476constructorimpl = Result.m476constructorimpl(guildHomeSubTabData2);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        c.GuildHomeSubTabData guildHomeSubTabData3 = (c.GuildHomeSubTabData) m476constructorimpl;
        try {
            List<c.GuildHomeSubTabData> value2 = this._tabDataListLiveData.getValue();
            if (value2 != null) {
                guildHomeSubTabData = value2.get(prevIndex);
            } else {
                guildHomeSubTabData = null;
            }
            m476constructorimpl2 = Result.m476constructorimpl(guildHomeSubTabData);
        } catch (Throwable th6) {
            Result.Companion companion3 = Result.INSTANCE;
            m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl2)) {
            obj = m476constructorimpl2;
        }
        mutableLiveData.setValue(new ef1.a<>(new SelectTabEvent(index, isClick, guildHomeSubTabData3, (c.GuildHomeSubTabData) obj)));
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
    }
}
