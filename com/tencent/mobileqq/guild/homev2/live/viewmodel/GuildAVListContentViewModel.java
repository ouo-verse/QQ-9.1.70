package com.tencent.mobileqq.guild.homev2.live.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ai;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetLiveAudioPollingCtxRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannels;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pp1.GuildAVLiveActiveData;
import pp1.GuildLiveAudioSpaceUIData;
import pp1.g;
import pp1.h;
import vh2.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0014R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150&8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "P1", "", "from", "", "S1", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mGuildId", "", "D", "I", "mCategoryType", "E", "mSceneType", "Landroidx/lifecycle/MutableLiveData;", "", "Lpp1/g;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_liveList", "", "G", "Lkotlin/Lazy;", "R1", "()Ljava/util/Set;", "livedChannelSet", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "H", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "liveList", "<init>", "(Ljava/lang/String;II)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVListContentViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String mGuildId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int mCategoryType;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mSceneType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<g>> _liveList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy livedChannelSet;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J \u0010\t\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onChannelListUpdated", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "changedGuildIdSet", "onPollingLiveAudioChannelPresence", "Lcom/tencent/mobileqq/qqguildsdk/data/g;", "channelInfo", "onChannelUpdatedWithSimpleInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, GuildAVListContentViewModel.this.mGuildId)) {
                GuildAVListContentViewModel.this.S1("onChannelListUpdated");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelUpdatedWithSimpleInfo(@NotNull com.tencent.mobileqq.qqguildsdk.data.g channelInfo) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            List<g> value = GuildAVListContentViewModel.this.Q1().getValue();
            boolean z16 = false;
            if (value != null) {
                List<g> list = value;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((g) it.next()).getChannelId());
                }
                if (arrayList.contains(channelInfo.b())) {
                    z16 = true;
                }
            }
            if (z16) {
                GuildAVListContentViewModel.this.S1("onChannelUpdate");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingLiveAudioChannelPresence(@NotNull HashSet<String> changedGuildIdSet) {
            Intrinsics.checkNotNullParameter(changedGuildIdSet, "changedGuildIdSet");
            if (changedGuildIdSet.contains(GuildAVListContentViewModel.this.mGuildId)) {
                GuildAVListContentViewModel.this.S1("onPollingLiveAudioChannel");
            }
        }
    }

    public GuildAVListContentViewModel(@NotNull String mGuildId, int i3, int i16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
        this.mGuildId = mGuildId;
        this.mCategoryType = i3;
        this.mSceneType = i16;
        this._liveList = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Set<String>>() { // from class: com.tencent.mobileqq.guild.homev2.live.viewmodel.GuildAVListContentViewModel$livedChannelSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<String> invoke() {
                return new LinkedHashSet();
            }
        });
        this.livedChannelSet = lazy;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        GPServiceObserver P1 = P1();
        this.gProObserver = P1;
        this.gProService.addObserver(P1);
    }

    private final GPServiceObserver P1() {
        return new b();
    }

    private final Set<String> R1() {
        return (Set) this.livedChannelSet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(GuildAVListContentViewModel this$0, GProGetLiveAudioPollingCtxRsp gProGetLiveAudioPollingCtxRsp) {
        Collection emptyList;
        int collectionSizeOrDefault;
        List<g> mutableList;
        ArrayList<GProRealTimeChannel> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GProRealTimeChannels gProRealTimeChannels = gProGetLiveAudioPollingCtxRsp.stateMap.get(Integer.valueOf(this$0.mCategoryType));
        if (gProRealTimeChannels == null || (arrayList = gProRealTimeChannels.channels) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (GProRealTimeChannel it : arrayList) {
                h hVar = h.f426934a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                g c16 = hVar.c(it, this$0.mGuildId);
                if (c16 != null) {
                    emptyList.add(c16);
                }
            }
        }
        Set<String> R1 = this$0.R1();
        Collection collection = emptyList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collection) {
            if (obj instanceof GuildAVLiveActiveData) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(((GuildAVLiveActiveData) it5.next()).getChannelId());
        }
        R1.addAll(arrayList3);
        if (this$0.mSceneType != 1) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList(emptyList);
        } else {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : collection) {
                if (this$0.R1().contains(((g) obj2).getChannelId())) {
                    arrayList4.add(obj2);
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        }
        if (!mutableList.isEmpty()) {
            mutableList.add(0, new GuildLiveAudioSpaceUIData("", bi.a(12.0f)));
            mutableList.add(new GuildLiveAudioSpaceUIData("", bi.a(150.0f)));
        }
        this$0._liveList.setValue(mutableList);
    }

    @NotNull
    public final LiveData<List<g>> Q1() {
        return this._liveList;
    }

    public final void S1(@NotNull String from) {
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLiveListViewModel", 1, "updateData from:" + from);
        }
        ai.a e16 = new ai.a().e(this.mGuildId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(this.mCategoryType));
        this.gProService.getLiveAudioPollingCtxV2(e16.d(arrayListOf).c(), new bc() { // from class: com.tencent.mobileqq.guild.homev2.live.viewmodel.c
            @Override // vh2.bc
            public final void onResult(GProGetLiveAudioPollingCtxRsp gProGetLiveAudioPollingCtxRsp) {
                GuildAVListContentViewModel.T1(GuildAVListContentViewModel.this, gProGetLiveAudioPollingCtxRsp);
            }
        });
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.gProService.deleteObserver(this.gProObserver);
        super.onAccountChanged(account);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        this.gProService = iGPSService;
        iGPSService.addObserver(this.gProObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(this.gProObserver);
    }
}
