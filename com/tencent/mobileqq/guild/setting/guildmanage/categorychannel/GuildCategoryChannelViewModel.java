package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetCategoryOrderRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.de;
import com.tencent.mobileqq.qqguildsdk.data.genc.ej;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ef1.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import wh2.dv;
import wh2.ef;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010$\u001a\u00020\u000f\u00a2\u0006\u0004\b;\u0010<J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\rJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\nJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rR\u0014\u0010$\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R*\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\n0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R&\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010.R'\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004058F\u00a2\u0006\u0006\u001a\u0004\b6\u00107R#\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r02058F\u00a2\u0006\u0006\u001a\u0004\b9\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelViewModel;", "Lef1/b;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "Lkotlin/collections/ArrayList;", "categoryIdList", "", "Q1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "channelOpenList", "", GameCenterAPIJavaScript.CLOSE_SWITCH, "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/l;", "R1", "", "W1", "g2", "edit", "f2", "c2", "guildId", "S1", "X1", "d2", "", "U1", "itemData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "isNeedSwitchToMainPage", "i2", "data", "targetData", "b2", BdhLogUtil.LogTag.Tag_Conn, "J", "bindGuildId", "D", "Ljava/util/ArrayList;", "E", "channelCloseList", UserInfo.SEX_FEMALE, "Z", "isEditing", "Landroidx/lifecycle/MutableLiveData;", "G", "Landroidx/lifecycle/MutableLiveData;", "_categoryChannelIdList", "H", "isSaveSuccess", "Lkotlin/Pair;", "I", "_showConfirmRemoveDialog", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "categoryChannelIdList", "Z1", "showConfirmRemoveDialog", "<init>", "(J)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCategoryChannelViewModel extends ef1.b {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final long bindGuildId;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isEditing;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProCategoryChannelIdList> channelOpenList = new ArrayList<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<IGProCategoryChannelIdList> channelCloseList = new ArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<b>> _categoryChannelIdList = new MutableLiveData<>(new ArrayList());

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSaveSuccess = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, GuildCategoryChannelItemData>> _showConfirmRemoveDialog = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7895a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f233739a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f233740b;

            public C7895a(ViewModelStoreOwner viewModelStoreOwner, long j3) {
                this.f233739a = viewModelStoreOwner;
                this.f233740b = j3;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildCategoryChannelViewModel(this.f233740b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
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
        public final GuildCategoryChannelViewModel a(@NotNull ViewModelStoreOwner owner, long guildId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7895a(owner, guildId)).get(GuildCategoryChannelViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildCategoryChannelViewModel) viewModel;
        }

        Companion() {
        }
    }

    public GuildCategoryChannelViewModel(long j3) {
        this.bindGuildId = j3;
    }

    private final void Q1(ArrayList<b> categoryIdList) {
        Object obj;
        boolean z16;
        long W1 = W1();
        Logger.f235387a.d().d("GuildModuleManageViewModel", 1, "[addDefaultJumpSettings] defaultSettingCategoryId:" + W1 + ", guildId:" + this.bindGuildId);
        Iterator<T> it = this.channelOpenList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProCategoryChannelIdList) obj).getCategoryId() == W1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProCategoryChannelIdList iGProCategoryChannelIdList = (IGProCategoryChannelIdList) obj;
        if (iGProCategoryChannelIdList == null) {
            Logger.f235387a.d().d("GuildModuleManageViewModel", 1, "[addDefaultJumpSettings] defaultItem is null");
            return;
        }
        categoryIdList.add(new GuildCategoryChannelTitleHideInEditHolderData(3, 0L, 2, null));
        long categoryId = iGProCategoryChannelIdList.getCategoryId();
        String r16 = QQGuildUIUtil.r(R.string.f1502214e);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild\u2026_visitor_default_jump_to)");
        categoryIdList.add(new GuildCategoryChannelDefaultSettingItemData(categoryId, 0, r16, this.bindGuildId, iGProCategoryChannelIdList, null, 34, null));
    }

    private final List<GuildCategoryChannelItemData> R1(ArrayList<IGProCategoryChannelIdList> channelOpenList, boolean closeSwitch) {
        int collectionSizeOrDefault;
        int lastIndex;
        ItemPositionType itemPositionType;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(channelOpenList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
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
            arrayList.add(new GuildCategoryChannelItemData(iGProCategoryChannelIdList.getCategoryId(), 0, this.bindGuildId, iGProCategoryChannelIdList, closeSwitch, this.isEditing, itemPositionType, false, 130, null));
            i3 = i16;
        }
        return arrayList;
    }

    private final long W1() {
        IGProJumpToCategoryInfo jumpToCategory = ((IGPSService) ch.S0(IGPSService.class, "")).getJumpToCategory(String.valueOf(this.bindGuildId));
        if (jumpToCategory != null) {
            return jumpToCategory.getCategoryId();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(GuildCategoryChannelViewModel this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProSetCategoryOrderRsp iGProSetCategoryOrderRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && iGProSetCategoryOrderRsp != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildModuleManageViewModel", 2, "saveChannelCategoryOrder success, " + iGProSetCategoryOrderRsp.getCategoryList());
            }
            this$0.isSaveSuccess.setValue(Boolean.TRUE);
            this$0.c2();
            return;
        }
        SecurityTipHelperKt.F(ch.i(), i3, str, null, null, null, 56, null);
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "saveChannelCategoryOrder error, result:" + i3 + " errMsg:" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildModuleManageViewModel", 1, (String) it.next(), null);
        }
        this$0.isSaveSuccess.setValue(Boolean.FALSE);
    }

    private final void g2() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.channelOpenList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IGProCategoryChannelIdList) obj).getCategoryType() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProCategoryChannelIdList iGProCategoryChannelIdList = (IGProCategoryChannelIdList) obj;
        if (iGProCategoryChannelIdList == null) {
            Logger.f235387a.d().d("GuildModuleManageViewModel", 1, "[switchDefaultToMainPage] main page is null");
            return;
        }
        de deVar = new de();
        deVar.f(deVar.c());
        deVar.d(iGProCategoryChannelIdList.getCategoryId());
        Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[switchDefaultToMainPage] req:" + deVar);
        ((IGPSService) ch.S0(IGPSService.class, "")).setJumpToCategory(deVar, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.r
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildCategoryChannelViewModel.h2(i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Logger.f235387a.d().d("GuildCategoryChannelChoiceViewModel", 1, "[switchDefaultToMainPage] result:" + i3 + ", errMsg:" + str + ", secResult:" + iGProSecurityResult);
    }

    public final void S1(long guildId) {
        ArrayList<Integer> arrayListOf;
        this.channelOpenList.clear();
        this.channelCloseList.clear();
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        ArrayList<IGProCategoryChannelIdList> categoryChannelIdListExcludeCategoryType = iGPSService.getCategoryChannelIdListExcludeCategoryType(guildId, arrayListOf);
        if (categoryChannelIdListExcludeCategoryType != null) {
            for (IGProCategoryChannelIdList iGProCategoryChannelIdList : categoryChannelIdListExcludeCategoryType) {
                if (iGProCategoryChannelIdList.getCategoryType() != 0) {
                    if (iGProCategoryChannelIdList.getCloseSwitch()) {
                        this.channelCloseList.add(iGProCategoryChannelIdList);
                    } else {
                        this.channelOpenList.add(iGProCategoryChannelIdList);
                    }
                }
            }
        }
        this._categoryChannelIdList.setValue(X1());
    }

    @NotNull
    public final LiveData<ArrayList<b>> T1() {
        return this._categoryChannelIdList;
    }

    @NotNull
    public final String U1() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = this.channelOpenList.iterator();
        while (it.hasNext()) {
            sb5.append(((IGProCategoryChannelIdList) it.next()).getCategoryType());
            sb5.append(",");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    @NotNull
    public final ArrayList<b> X1() {
        ArrayList<b> arrayList = new ArrayList<>();
        boolean z16 = !this.isEditing;
        String r16 = QQGuildUIUtil.r(R.string.f141950i2);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild_channel_title_edit)");
        arrayList.add(new GuildCategoryChannelTitleHolderData(1, 0L, z16, r16, 2, null));
        arrayList.addAll(R1(this.channelOpenList, false));
        if (!this.channelCloseList.isEmpty()) {
            arrayList.add(new GuildCategoryChannelSecondHolderData(2, 0L, 2, null));
        }
        if (!this.channelCloseList.isEmpty()) {
            arrayList.addAll(R1(this.channelCloseList, true));
        }
        if (!this.isEditing) {
            Q1(arrayList);
        }
        return arrayList;
    }

    @NotNull
    public final LiveData<Pair<Boolean, GuildCategoryChannelItemData>> Z1() {
        return this._showConfirmRemoveDialog;
    }

    public final void a2(@NotNull GuildCategoryChannelItemData itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        long W1 = W1();
        if (!itemData.getIsCloseSwitch() && itemData.getCategoryChannel().getCategoryId() == W1) {
            this._showConfirmRemoveDialog.setValue(new Pair<>(Boolean.TRUE, itemData));
        } else {
            i2(itemData, false);
        }
    }

    public final void b2(@NotNull GuildCategoryChannelItemData data, @NotNull GuildCategoryChannelItemData targetData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(targetData, "targetData");
        Collections.swap(this.channelOpenList, this.channelOpenList.indexOf(data.getCategoryChannel()), this.channelOpenList.indexOf(targetData.getCategoryChannel()));
    }

    public final void c2() {
        this._categoryChannelIdList.setValue(X1());
    }

    public final void d2() {
        ej ejVar = new ej();
        ejVar.f(this.bindGuildId);
        if (!this.channelOpenList.isEmpty()) {
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<T> it = this.channelOpenList.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((IGProCategoryChannelIdList) it.next()).getCategoryId()));
            }
            ejVar.e(arrayList);
        }
        if (!this.channelCloseList.isEmpty()) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            Iterator<T> it5 = this.channelCloseList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(Long.valueOf(((IGProCategoryChannelIdList) it5.next()).getCategoryId()));
            }
            ejVar.d(arrayList2);
        }
        ((IGPSService) ch.S0(IGPSService.class, "")).setChannelCategoryOrder(ejVar, new ef() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.s
            @Override // wh2.ef
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProSetCategoryOrderRsp iGProSetCategoryOrderRsp) {
                GuildCategoryChannelViewModel.e2(GuildCategoryChannelViewModel.this, i3, str, iGProSecurityResult, iGProSetCategoryOrderRsp);
            }
        });
    }

    public final void f2(boolean edit) {
        this.isEditing = edit;
        this._categoryChannelIdList.setValue(X1());
    }

    public final void i2(@NotNull final GuildCategoryChannelItemData itemData, boolean isNeedSwitchToMainPage) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        GuildCategoryChannelItemData d16 = GuildCategoryChannelItemData.d(itemData, 0L, 0, 0L, null, !itemData.getIsCloseSwitch(), false, null, false, 239, null);
        if (itemData.getIsCloseSwitch()) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.channelCloseList, (Function1) new Function1<IGProCategoryChannelIdList, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelViewModel$updateShowState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull IGProCategoryChannelIdList it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getCategoryId() == GuildCategoryChannelItemData.this.getId());
                }
            });
            this.channelOpenList.add(d16.getCategoryChannel());
        } else {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.channelOpenList, (Function1) new Function1<IGProCategoryChannelIdList, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelViewModel$updateShowState$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull IGProCategoryChannelIdList it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getCategoryId() == GuildCategoryChannelItemData.this.getId());
                }
            });
            this.channelCloseList.add(d16.getCategoryChannel());
        }
        this._categoryChannelIdList.setValue(X1());
        if (isNeedSwitchToMainPage) {
            g2();
        }
    }
}
