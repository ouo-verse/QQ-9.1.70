package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ba;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.de;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.QQToastUtil;
import ef1.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0013\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R'\u0010(\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0%8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/e;", "Lef1/b;", "", "X1", "", "selectedCategoryId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "Lkotlin/collections/ArrayList;", "S1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "channelOpenList", "", "O1", "", "resultList", "data", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/t;", "choiceItemData", "Z1", "guildId", "P1", "categoryChannelId", "", "subCategoryType", "T1", BdhLogUtil.LogTag.Tag_Conn, "J", "D", "Ljava/util/ArrayList;", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_categoryChannelIdList", "", UserInfo.SEX_FEMALE, "_defaultCategorySetResult", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "categoryChannelIdList", "R1", "defaultCategorySetResult", "<init>", "(J)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends ef1.b {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final long guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProCategoryChannelIdList> channelOpenList = new ArrayList<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b>> _categoryChannelIdList = new MutableLiveData<>(new ArrayList());

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _defaultCategorySetResult = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/e$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/e;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.e$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7897a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f233760a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f233761b;

            public C7897a(ViewModelStoreOwner viewModelStoreOwner, long j3) {
                this.f233760a = viewModelStoreOwner;
                this.f233761b = j3;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new e(this.f233761b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final e a(@NotNull ViewModelStoreOwner owner, long guildId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7897a(owner, guildId)).get(e.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (e) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233762a;

        static {
            int[] iArr = new int[ItemPositionType.values().length];
            try {
                iArr[ItemPositionType.Single.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemPositionType.Bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemPositionType.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemPositionType.Middle.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f233762a = iArr;
        }
    }

    public e(long j3) {
        this.guildId = j3;
    }

    private final List<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> O1(ArrayList<IGProCategoryChannelIdList> channelOpenList, long selectedCategoryId) {
        int lastIndex;
        ItemPositionType itemPositionType;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : channelOpenList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            IGProCategoryChannelIdList iGProCategoryChannelIdList = (IGProCategoryChannelIdList) obj;
            if (channelOpenList.size() == 1) {
                itemPositionType = ItemPositionType.Single;
            } else if (i3 != 0) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(channelOpenList);
                if (i3 == lastIndex) {
                    itemPositionType = ItemPositionType.Bottom;
                } else {
                    itemPositionType = ItemPositionType.Middle;
                }
            } else {
                itemPositionType = ItemPositionType.Top;
            }
            ItemPositionType itemPositionType2 = itemPositionType;
            ArrayList arrayList2 = new ArrayList();
            long categoryId = iGProCategoryChannelIdList.getCategoryId();
            long j3 = this.guildId;
            if (iGProCategoryChannelIdList.getCategoryId() == selectedCategoryId) {
                z16 = true;
            } else {
                z16 = false;
            }
            GuildCategoryChoiceItemData guildCategoryChoiceItemData = new GuildCategoryChoiceItemData(categoryId, 0, j3, z16, iGProCategoryChannelIdList, itemPositionType2, 2, null);
            arrayList2.add(guildCategoryChoiceItemData);
            Z1(arrayList2, iGProCategoryChannelIdList, guildCategoryChoiceItemData);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
            i3 = i16;
        }
        return arrayList;
    }

    private final ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> S1(long selectedCategoryId) {
        ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> arrayList = new ArrayList<>();
        arrayList.addAll(O1(this.channelOpenList, selectedCategoryId));
        return arrayList;
    }

    public static /* synthetic */ void U1(e eVar, long j3, long j16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        eVar.T1(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(e this$0, long j3, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[selectDefaultJumpToCategory] result:" + i3 + ", errMsg:" + str + ", secResult:" + iGProSecurityResult);
        if (i3 == 0) {
            this$0._categoryChannelIdList.setValue(this$0.S1(j3));
            this$0._defaultCategorySetResult.setValue(Boolean.TRUE);
            this$0.X1();
            return;
        }
        QQToastUtil.showQQToast(1, R.string.f1501714_);
    }

    private final void X1() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_channel_id", Long.valueOf(this.guildId));
        ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> value = this._categoryChannelIdList.getValue();
        if (value != null) {
            for (com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b bVar : value) {
                if (bVar instanceof GuildCategoryChoiceItemData) {
                    GuildCategoryChoiceItemData guildCategoryChoiceItemData = (GuildCategoryChoiceItemData) bVar;
                    if (guildCategoryChoiceItemData.getIsSelect()) {
                        linkedHashMap.put("sgrp_tab_name", guildCategoryChoiceItemData.getCategoryChannel().getCategoryAlias());
                    }
                } else if (bVar instanceof GuildCategoryChoiceSubItemData) {
                    linkedHashMap.put("sgrp_homepage_default_sort", Integer.valueOf(((GuildCategoryChoiceSubItemData) bVar).getSelectedSubCategoryType()));
                }
            }
        }
        VideoReport.reportEvent("ev_sgrp_user_default_jump_zone", linkedHashMap);
    }

    private final void Z1(List<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b> resultList, IGProCategoryChannelIdList data, GuildCategoryChoiceItemData choiceItemData) {
        Unit unit;
        IGProJumpToCategoryInfo jumpToCategory;
        ItemPositionType itemPositionType;
        ItemPositionType itemPositionType2;
        if (data.getCategoryType() == 1 && choiceItemData.getIsSelect()) {
            iz1.a aVar = (iz1.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102934");
            if (aVar != null) {
                Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[convertModuleItemToUiData] FEED_SQUARE config enable:" + aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String());
                if (aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.ENABLED java.lang.String() && (jumpToCategory = ((IGPSService) ch.S0(IGPSService.class, "")).getJumpToCategory(String.valueOf(this.guildId))) != null && jumpToCategory.getCategoryId() == data.getCategoryId()) {
                    ItemPositionType positionType = choiceItemData.getPositionType();
                    int[] iArr = b.f233762a;
                    int i3 = iArr[positionType.ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3 && i3 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        itemPositionType = ItemPositionType.Middle;
                    } else {
                        itemPositionType = ItemPositionType.Bottom;
                    }
                    ItemPositionType itemPositionType3 = itemPositionType;
                    ba.Companion companion = ba.INSTANCE;
                    int c16 = companion.c(aVar, jumpToCategory);
                    long categoryId = data.getCategoryId();
                    String string = BaseApplication.context.getString(R.string.f140910f9);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ory_feed_sort_choose_tip)");
                    resultList.add(new GuildCategoryChoiceSubItemData(0, categoryId, string, c16, companion.b(c16), itemPositionType3, 1, null));
                    int i16 = iArr[choiceItemData.getPositionType().ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            itemPositionType2 = choiceItemData.getPositionType();
                        } else {
                            itemPositionType2 = ItemPositionType.Middle;
                        }
                    } else {
                        itemPositionType2 = ItemPositionType.Top;
                    }
                    choiceItemData.f(itemPositionType2);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[convertModuleItemToUiData] FEED_SQUARE config is null");
            }
        }
    }

    public final void P1(long guildId, long selectedCategoryId) {
        ArrayList<Integer> arrayListOf;
        this.channelOpenList.clear();
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        ArrayList<IGProCategoryChannelIdList> categoryChannelIdListExcludeCategoryType = iGPSService.getCategoryChannelIdListExcludeCategoryType(guildId, arrayListOf);
        if (categoryChannelIdListExcludeCategoryType != null) {
            for (IGProCategoryChannelIdList iGProCategoryChannelIdList : categoryChannelIdListExcludeCategoryType) {
                if (iGProCategoryChannelIdList.getCategoryType() != 0 && !iGProCategoryChannelIdList.getCloseSwitch()) {
                    this.channelOpenList.add(iGProCategoryChannelIdList);
                }
            }
        }
        this._categoryChannelIdList.setValue(S1(selectedCategoryId));
    }

    @NotNull
    public final LiveData<ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b>> Q1() {
        return this._categoryChannelIdList;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        return this._defaultCategorySetResult;
    }

    public final void T1(long guildId, final long categoryChannelId, int subCategoryType) {
        de deVar = new de();
        deVar.f(guildId);
        deVar.d(categoryChannelId);
        if (subCategoryType != 0) {
            deVar.e(subCategoryType);
        }
        Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[selectDefaultJumpToCategory] req:" + deVar);
        ((IGPSService) ch.S0(IGPSService.class, "")).setJumpToCategory(deVar, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.d
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                e.W1(e.this, categoryChannelId, i3, str, iGProSecurityResult);
            }
        });
    }
}
