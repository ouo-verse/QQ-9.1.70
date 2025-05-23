package com.tencent.mobileqq.guild.quicksearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment;
import com.tencent.mobileqq.guild.quicksearch.calendar.GuildCalendarSearchFragment;
import com.tencent.mobileqq.guild.quicksearch.event.GuildSearchKeyEvent;
import com.tencent.mobileqq.guild.quicksearch.fragment.QuickSearchFeedFragment;
import com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource;
import com.tencent.mobileqq.guild.quicksearch.model.SearchMemberInfo;
import com.tencent.mobileqq.guild.quicksearch.resultview.history.GuildQuickSearchHistoryView;
import com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar;
import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import lw1.j;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u000e\u0011\u0018\u0000 g2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030,0+j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030,`-H\u0016J\"\u00104\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u000102H\u0016R\u0016\u00107\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lh", "initView", "Ih", "Eh", "Fh", "", NodeProps.VISIBLE, "Bh", "initViewModel", "com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$b", "Ch", "()Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$b;", "com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$c", "Dh", "()Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$c;", "Mh", "Nh", "initDtReport", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "needStatusTrans", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar;", "D", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar;", "searchBox", "Landroid/view/ViewStub;", "E", "Landroid/view/ViewStub;", "historyViewViewStub", "Landroidx/fragment/app/FragmentContainerView;", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/FragmentContainerView;", "fragmentContainer", "Lcom/tencent/mobileqq/guild/quicksearch/fragment/QuickSearchFeedFragment;", "G", "Lcom/tencent/mobileqq/guild/quicksearch/fragment/QuickSearchFeedFragment;", "feedFragment", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/history/GuildQuickSearchHistoryView;", "H", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/history/GuildQuickSearchHistoryView;", "historyView", "Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion$ENTRANCE_FROM;", "I", "Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion$ENTRANCE_FROM;", "entranceFrom", "", "J", "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "K", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extData", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "L", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "viewModel", "M", "Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$b;", "searchBarListener", "Llw1/j;", "N", "Lkotlin/Lazy;", "Hh", "()Llw1/j;", "searchHistoryController", "<init>", "()V", "P", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildQuickSearchFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildInnerSearchBar searchBox;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewStub historyViewViewStub;

    /* renamed from: F, reason: from kotlin metadata */
    private FragmentContainerView fragmentContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QuickSearchFeedFragment feedFragment;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildQuickSearchHistoryView historyView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private SearchBarExtData extData;

    /* renamed from: L, reason: from kotlin metadata */
    private QuickSearchViewModel viewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchHistoryController;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Companion.ENTRANCE_FROM entranceFrom = Companion.ENTRANCE_FROM.DEFAULT;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final b searchBarListener = Ch();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion;", "", "Landroid/content/Context;", "context", "", "guildId", "", "a", "Lcom/tencent/mobileqq/guild/quicksearch/model/SearchMemberInfo;", "searchMemberInfo", "", "requestCode", "c", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "b", "KEY_BOARD_DELAY_SHOW_TIME", "J", "REQUEST_CODE_FOR_SEARCH", "I", "RESULT_CODE_CANCELED", "SEARCH_MEMBER_INFO", "Ljava/lang/String;", "TAG", "TIME_STAMP_INFO", "<init>", "()V", "ENTRANCE_FROM", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion$ENTRANCE_FROM;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "DEFAULT", "GUILD_MEMBER_SELECTOR", "DATE_SELECTOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        public enum ENTRANCE_FROM {
            DEFAULT,
            GUILD_MEMBER_SELECTOR,
            DATE_SELECTOR;


            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion$ENTRANCE_FROM$a;", "", "", "ordinal", "Lcom/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$Companion$ENTRANCE_FROM;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment$Companion$ENTRANCE_FROM$a, reason: from kotlin metadata */
            /* loaded from: classes14.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @NotNull
                public final ENTRANCE_FROM a(int ordinal) {
                    Object orNull;
                    orNull = ArraysKt___ArraysKt.getOrNull(ENTRANCE_FROM.values(), ordinal);
                    ENTRANCE_FROM entrance_from = (ENTRANCE_FROM) orNull;
                    if (entrance_from == null) {
                        return ENTRANCE_FROM.DEFAULT;
                    }
                    return entrance_from;
                }

                Companion() {
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildQuickSearchFragment.class);
            QLog.i("QQGuildInSearchTag.GuildQuickSearchFragment", 1, "startFragment guildId:" + guildId);
        }

        public final void b(@NotNull Context context, @NotNull String guildId, long timeStamp, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_entrance_from", ENTRANCE_FROM.DATE_SELECTOR.ordinal());
            intent.putExtra("TIME_STAMP_INFO", timeStamp);
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildQuickSearchFragment.class, requestCode);
            QLog.i("QQGuildInSearchTag.GuildQuickSearchFragment", 1, "startResultFragment guildId:" + guildId + "\uff0ctimeStamp:" + timeStamp);
        }

        public final void c(@NotNull Context context, @NotNull String guildId, @NotNull SearchMemberInfo searchMemberInfo, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(searchMemberInfo, "searchMemberInfo");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_entrance_from", ENTRANCE_FROM.GUILD_MEMBER_SELECTOR.ordinal());
            intent.putExtra("SEARCH_MEMBER_INFO", searchMemberInfo);
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildQuickSearchFragment.class, requestCode);
            QLog.i("QQGuildInSearchTag.GuildQuickSearchFragment", 1, "startResultFragment guildId:" + guildId + "\uff0c tinyId:" + searchMemberInfo.getTinyId());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f231553a;

        static {
            int[] iArr = new int[Companion.ENTRANCE_FROM.values().length];
            try {
                iArr[Companion.ENTRANCE_FROM.GUILD_MEMBER_SELECTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.ENTRANCE_FROM.DATE_SELECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f231553a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$b", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/GuildInnerSearchBar$b;", "", "onCancelClick", "Landroid/view/View;", "backView", "onBackClick", "view", "a", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extData", "", "text", "c", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildInnerSearchBar.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar.b
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            bt btVar = bt.f235484a;
            GuildInnerSearchBar guildInnerSearchBar = GuildQuickSearchFragment.this.searchBox;
            if (guildInnerSearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                guildInnerSearchBar = null;
            }
            bt.h(btVar, guildInnerSearchBar, "em_sgrp_search_box", "clck", null, 8, null);
        }

        @Override // com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar.b
        public void b(@NotNull QUISearchBar searchBar, @NotNull View backView) {
            Intrinsics.checkNotNullParameter(searchBar, "searchBar");
            Intrinsics.checkNotNullParameter(backView, "backView");
            GuildInnerSearchBar.b.a.a(this, searchBar, backView);
            ImageView clearView = searchBar.getClearView();
            Intrinsics.checkNotNullExpressionValue(clearView, "searchBar.clearView");
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            bt.d(clearView, "em_sgrp_search_clear", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
            TextView cancelView = searchBar.getCancelView();
            Intrinsics.checkNotNullExpressionValue(cancelView, "searchBar.cancelView");
            bt.d(cancelView, "em_sgrp_search_cancel", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        }

        @Override // com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar.b
        public void c(@Nullable SearchBarExtData extData, @NotNull String text) {
            CharSequence trim;
            boolean z16;
            Map<String, ? extends Object> mapOf;
            Intrinsics.checkNotNullParameter(text, "text");
            trim = StringsKt__StringsKt.trim((CharSequence) text);
            String obj = trim.toString();
            QuickSearchViewModel quickSearchViewModel = GuildQuickSearchFragment.this.viewModel;
            QuickSearchViewModel quickSearchViewModel2 = null;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            if (quickSearchViewModel.getPageState() == 0) {
                bt btVar = bt.f235484a;
                GuildInnerSearchBar guildInnerSearchBar = GuildQuickSearchFragment.this.searchBox;
                if (guildInnerSearchBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                    guildInnerSearchBar = null;
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, obj));
                btVar.g(guildInnerSearchBar, "em_sgrp_search", "clck", mapOf);
            }
            if (obj.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16 || extData != null) && !QQGuildUIUtil.v()) {
                QuickSearchViewModel quickSearchViewModel3 = GuildQuickSearchFragment.this.viewModel;
                if (quickSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    quickSearchViewModel3 = null;
                }
                quickSearchViewModel3.s2(extData, text, GuildSearchActionSource.SOFT_KEYBOARD);
                QuickSearchViewModel quickSearchViewModel4 = GuildQuickSearchFragment.this.viewModel;
                if (quickSearchViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    quickSearchViewModel2 = quickSearchViewModel4;
                }
                if (quickSearchViewModel2.getPageState() == 0) {
                    GuildQuickSearchFragment.this.Nh();
                    return;
                }
                QuickSearchFeedFragment quickSearchFeedFragment = GuildQuickSearchFragment.this.feedFragment;
                if (quickSearchFeedFragment != null) {
                    quickSearchFeedFragment.qh();
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar.b
        public void onBackClick(@NotNull View backView) {
            Intrinsics.checkNotNullParameter(backView, "backView");
            bt.h(bt.f235484a, backView, "em_sgrp_back_btn", "clck", null, 8, null);
            GuildQuickSearchFragment.this.onBackEvent();
        }

        @Override // com.tencent.mobileqq.guild.quicksearch.searchbox.GuildInnerSearchBar.b
        public void onCancelClick() {
            FragmentActivity activity = GuildQuickSearchFragment.this.getActivity();
            if (activity != null) {
                activity.setResult(10213);
            }
            FragmentActivity activity2 = GuildQuickSearchFragment.this.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$c", "Llw1/j;", "", "searchText", "", "c", "a", "Landroid/view/View;", "view", "d", "b", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements j {
        c() {
        }

        @Override // lw1.j
        public void a() {
            QLog.i("QQGuildInSearchTag.GuildQuickSearchFragment", 1, "onClearHistorySearch ");
            QuickSearchViewModel quickSearchViewModel = GuildQuickSearchFragment.this.viewModel;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.Z1();
        }

        @Override // lw1.j
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildCalendarSearchFragment.Companion companion = GuildCalendarSearchFragment.INSTANCE;
            Context requireContext = GuildQuickSearchFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String str = GuildQuickSearchFragment.this.guildId;
            if (str == null) {
                str = "";
            }
            companion.a(requireContext, str, 10214);
        }

        @Override // lw1.j
        public void c(@NotNull String searchText) {
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            QLog.i("QQGuildInSearchTag.GuildQuickSearchFragment", 1, "onSearchHistoryItemClicked " + searchText);
            GuildInnerSearchBar guildInnerSearchBar = GuildQuickSearchFragment.this.searchBox;
            if (guildInnerSearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                guildInnerSearchBar = null;
            }
            guildInnerSearchBar.setEditText(searchText);
            GuildInnerSearchBar guildInnerSearchBar2 = GuildQuickSearchFragment.this.searchBox;
            if (guildInnerSearchBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                guildInnerSearchBar2 = null;
            }
            guildInnerSearchBar2.setKeyboardVisible(false);
            QuickSearchViewModel quickSearchViewModel = GuildQuickSearchFragment.this.viewModel;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.s2(null, searchText, GuildSearchActionSource.HISTORY_BOARD);
            GuildQuickSearchFragment.this.Nh();
        }

        @Override // lw1.j
        public void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QuickSearchViewModel quickSearchViewModel = GuildQuickSearchFragment.this.viewModel;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.t2();
        }

        @Override // lw1.j
        public void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildMemberSelectorFragment.Companion companion = GuildMemberSelectorFragment.INSTANCE;
            Context requireContext = GuildQuickSearchFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String str = GuildQuickSearchFragment.this.guildId;
            if (str == null) {
                str = "";
            }
            companion.a(requireContext, str, 10214);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f231556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildQuickSearchFragment f231557b;

        public d(ViewModelStoreOwner viewModelStoreOwner, GuildQuickSearchFragment guildQuickSearchFragment) {
            this.f231556a = viewModelStoreOwner;
            this.f231557b = guildQuickSearchFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f231557b.guildId;
            if (str == null) {
                str = "";
            }
            TimedValue timedValue = new TimedValue(new QuickSearchViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$e", "Lsa0/a;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends sa0.a {
        e() {
        }

        @Override // sa0.a, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FragmentContainerView fragmentContainerView = GuildQuickSearchFragment.this.fragmentContainer;
            GuildInnerSearchBar guildInnerSearchBar = null;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.setBackgroundResource(R.drawable.lvj);
            FragmentContainerView fragmentContainerView2 = GuildQuickSearchFragment.this.fragmentContainer;
            if (fragmentContainerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView2 = null;
            }
            fragmentContainerView2.setVisibility(8);
            GuildQuickSearchHistoryView guildQuickSearchHistoryView = GuildQuickSearchFragment.this.historyView;
            if (guildQuickSearchHistoryView != null) {
                GuildInnerSearchBar guildInnerSearchBar2 = GuildQuickSearchFragment.this.searchBox;
                if (guildInnerSearchBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                } else {
                    guildInnerSearchBar = guildInnerSearchBar2;
                }
                guildQuickSearchHistoryView.setLogicParent(guildInnerSearchBar);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            FragmentContainerView fragmentContainerView = GuildQuickSearchFragment.this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/GuildQuickSearchFragment$f", "Lsa0/a;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends sa0.a {
        f() {
        }

        @Override // sa0.a, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FragmentContainerView fragmentContainerView = GuildQuickSearchFragment.this.fragmentContainer;
            GuildInnerSearchBar guildInnerSearchBar = null;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.setBackgroundResource(R.drawable.lvj);
            GuildQuickSearchFragment.this.Bh(false);
            QuickSearchFeedFragment quickSearchFeedFragment = GuildQuickSearchFragment.this.feedFragment;
            if (quickSearchFeedFragment != null) {
                GuildInnerSearchBar guildInnerSearchBar2 = GuildQuickSearchFragment.this.searchBox;
                if (guildInnerSearchBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                } else {
                    guildInnerSearchBar = guildInnerSearchBar2;
                }
                quickSearchFeedFragment.rh(guildInnerSearchBar);
            }
            QuickSearchFeedFragment quickSearchFeedFragment2 = GuildQuickSearchFragment.this.feedFragment;
            if (quickSearchFeedFragment2 != null) {
                quickSearchFeedFragment2.initReport();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            FragmentContainerView fragmentContainerView = GuildQuickSearchFragment.this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }

    public GuildQuickSearchFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment$searchHistoryController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildQuickSearchFragment.c invoke() {
                GuildQuickSearchFragment.c Dh;
                Dh = GuildQuickSearchFragment.this.Dh();
                return Dh;
            }
        });
        this.searchHistoryController = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(boolean visible) {
        int i3;
        if (visible) {
            Fh();
        }
        GuildQuickSearchHistoryView guildQuickSearchHistoryView = this.historyView;
        if (guildQuickSearchHistoryView != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            guildQuickSearchHistoryView.setVisibility(i3);
        }
    }

    private final b Ch() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Dh() {
        return new c();
    }

    private final void Eh() {
        if (this.feedFragment == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            QuickSearchFeedFragment.Companion companion = QuickSearchFeedFragment.INSTANCE;
            String str = this.guildId;
            if (str == null) {
                str = "";
            }
            QuickSearchFeedFragment a16 = companion.a(str);
            FragmentContainerView fragmentContainerView = this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            beginTransaction.replace(fragmentContainerView.getId(), a16);
            this.feedFragment = a16;
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private final void Fh() {
        GuildQuickSearchHistoryView guildQuickSearchHistoryView;
        if (this.historyView == null) {
            ViewStub viewStub = this.historyViewViewStub;
            GuildQuickSearchHistoryView guildQuickSearchHistoryView2 = null;
            QuickSearchViewModel quickSearchViewModel = null;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("historyViewViewStub");
                viewStub = null;
            }
            View inflate = viewStub.inflate();
            if (inflate instanceof GuildQuickSearchHistoryView) {
                guildQuickSearchHistoryView = (GuildQuickSearchHistoryView) inflate;
            } else {
                guildQuickSearchHistoryView = null;
            }
            if (guildQuickSearchHistoryView != null) {
                guildQuickSearchHistoryView.i(Hh(), this.guildId);
                QuickSearchViewModel quickSearchViewModel2 = this.viewModel;
                if (quickSearchViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    quickSearchViewModel = quickSearchViewModel2;
                }
                LiveData<List<String>> e26 = quickSearchViewModel.e2();
                LifecycleOwner lifecycleOwner = getLifecycleOwner();
                final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment$ensureInflateHistoryView$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                        invoke2((List<String>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<String> list) {
                        GuildQuickSearchHistoryView guildQuickSearchHistoryView3 = GuildQuickSearchFragment.this.historyView;
                        if (guildQuickSearchHistoryView3 != null) {
                            guildQuickSearchHistoryView3.r(list);
                        }
                    }
                };
                e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.a
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        GuildQuickSearchFragment.Gh(Function1.this, obj);
                    }
                });
                guildQuickSearchHistoryView2 = guildQuickSearchHistoryView;
            }
            this.historyView = guildQuickSearchHistoryView2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final j Hh() {
        return (j) this.searchHistoryController.getValue();
    }

    private final void Ih() {
        Companion.ENTRANCE_FROM entrance_from = this.entranceFrom;
        GuildInnerSearchBar guildInnerSearchBar = null;
        if (entrance_from != Companion.ENTRANCE_FROM.GUILD_MEMBER_SELECTOR && entrance_from != Companion.ENTRANCE_FROM.DATE_SELECTOR) {
            GuildInnerSearchBar guildInnerSearchBar2 = this.searchBox;
            if (guildInnerSearchBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                guildInnerSearchBar2 = null;
            }
            guildInnerSearchBar2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.quicksearch.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildQuickSearchFragment.Jh(GuildQuickSearchFragment.this);
                }
            }, 200L);
            Bh(true);
            FragmentContainerView fragmentContainerView = this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            fragmentContainerView.setVisibility(8);
            GuildQuickSearchHistoryView guildQuickSearchHistoryView = this.historyView;
            if (guildQuickSearchHistoryView != null) {
                GuildInnerSearchBar guildInnerSearchBar3 = this.searchBox;
                if (guildInnerSearchBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                } else {
                    guildInnerSearchBar = guildInnerSearchBar3;
                }
                guildQuickSearchHistoryView.setLogicParent(guildInnerSearchBar);
                return;
            }
            return;
        }
        SearchBarExtData searchBarExtData = this.extData;
        if (searchBarExtData != null) {
            GuildInnerSearchBar guildInnerSearchBar4 = this.searchBox;
            if (guildInnerSearchBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                guildInnerSearchBar4 = null;
            }
            guildInnerSearchBar4.setExtInfo(searchBarExtData);
        }
        GuildInnerSearchBar guildInnerSearchBar5 = this.searchBox;
        if (guildInnerSearchBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar5 = null;
        }
        guildInnerSearchBar5.setBackVisible(true, false);
        GuildInnerSearchBar guildInnerSearchBar6 = this.searchBox;
        if (guildInnerSearchBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar6 = null;
        }
        guildInnerSearchBar6.setKeyboardVisible(false);
        QuickSearchViewModel quickSearchViewModel = this.viewModel;
        if (quickSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            quickSearchViewModel = null;
        }
        quickSearchViewModel.s2(this.extData, null, GuildSearchActionSource.DEFAULT);
        Bh(false);
        FragmentContainerView fragmentContainerView2 = this.fragmentContainer;
        if (fragmentContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView2 = null;
        }
        fragmentContainerView2.setVisibility(0);
        Eh();
        QuickSearchFeedFragment quickSearchFeedFragment = this.feedFragment;
        if (quickSearchFeedFragment != null) {
            GuildInnerSearchBar guildInnerSearchBar7 = this.searchBox;
            if (guildInnerSearchBar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            } else {
                guildInnerSearchBar = guildInnerSearchBar7;
            }
            quickSearchFeedFragment.rh(guildInnerSearchBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(GuildQuickSearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildInnerSearchBar guildInnerSearchBar = this$0.searchBox;
        if (guildInnerSearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar = null;
        }
        guildInnerSearchBar.setKeyboardVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Lh() {
        SearchMemberInfo searchMemberInfo;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.guildId = arguments.getString("extra_guild_id");
            Companion.ENTRANCE_FROM a16 = Companion.ENTRANCE_FROM.INSTANCE.a(arguments.getInt("extra_entrance_from"));
            this.entranceFrom = a16;
            int i3 = a.f231553a[a16.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    long j3 = arguments.getLong("TIME_STAMP_INFO", -1L);
                    if (j3 > 0) {
                        this.extData = new SearchBarExtData.DateExtData(j3);
                        return;
                    }
                    return;
                }
                return;
            }
            Parcelable parcelable = arguments.getParcelable("SEARCH_MEMBER_INFO");
            if (parcelable instanceof SearchMemberInfo) {
                searchMemberInfo = (SearchMemberInfo) parcelable;
            } else {
                searchMemberInfo = null;
            }
            if (searchMemberInfo != null) {
                String str = this.guildId;
                if (str == null) {
                    str = "";
                }
                this.extData = new SearchBarExtData.GuildMemberExtData(str, searchMemberInfo.getTinyId(), searchMemberInfo.getName(), searchMemberInfo.getUserType());
            }
        }
    }

    private final void Mh() {
        QuickSearchViewModel quickSearchViewModel = this.viewModel;
        QuickSearchViewModel quickSearchViewModel2 = null;
        if (quickSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            quickSearchViewModel = null;
        }
        quickSearchViewModel.v2(0);
        GuildInnerSearchBar guildInnerSearchBar = this.searchBox;
        if (guildInnerSearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar = null;
        }
        guildInnerSearchBar.setKeyboardVisible(false);
        GuildInnerSearchBar guildInnerSearchBar2 = this.searchBox;
        if (guildInnerSearchBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar2 = null;
        }
        guildInnerSearchBar2.setEditText("");
        GuildInnerSearchBar guildInnerSearchBar3 = this.searchBox;
        if (guildInnerSearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar3 = null;
        }
        guildInnerSearchBar3.setBackVisible(false, true);
        Bh(true);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154627oz);
        loadAnimation.setAnimationListener(new e());
        FragmentContainerView fragmentContainerView = this.fragmentContainer;
        if (fragmentContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView = null;
        }
        fragmentContainerView.startAnimation(loadAnimation);
        QuickSearchViewModel quickSearchViewModel3 = this.viewModel;
        if (quickSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            quickSearchViewModel2 = quickSearchViewModel3;
        }
        quickSearchViewModel2.u2("pg_sgrp_search_all");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh() {
        QuickSearchViewModel quickSearchViewModel = this.viewModel;
        FragmentContainerView fragmentContainerView = null;
        if (quickSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            quickSearchViewModel = null;
        }
        quickSearchViewModel.v2(1);
        GuildInnerSearchBar guildInnerSearchBar = this.searchBox;
        if (guildInnerSearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            guildInnerSearchBar = null;
        }
        guildInnerSearchBar.setBackVisible(true, true);
        FragmentContainerView fragmentContainerView2 = this.fragmentContainer;
        if (fragmentContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView2 = null;
        }
        fragmentContainerView2.setVisibility(0);
        Eh();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154632p4);
        loadAnimation.setAnimationListener(new f());
        FragmentContainerView fragmentContainerView3 = this.fragmentContainer;
        if (fragmentContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        } else {
            fragmentContainerView = fragmentContainerView3;
        }
        fragmentContainerView.startAnimation(loadAnimation);
    }

    private final void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
    }

    private final void initView() {
        GuildInnerSearchBar guildInnerSearchBar = null;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            view.setFitsSystemWindows(true);
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            view2.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_light));
            boolean z16 = !GuildThemeManager.f235286a.b();
            Window window = requireActivity().getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
            GuildThemeManager.i(z16, window);
        }
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById = view3.findViewById(R.id.wuw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_quick_search_box)");
        this.searchBox = (GuildInnerSearchBar) findViewById;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById2 = view4.findViewById(R.id.f81024d2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026search_history_view_stub)");
        this.historyViewViewStub = (ViewStub) findViewById2;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById3 = view5.findViewById(R.id.f81174dg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.search_result_view)");
        this.fragmentContainer = (FragmentContainerView) findViewById3;
        GuildInnerSearchBar guildInnerSearchBar2 = this.searchBox;
        if (guildInnerSearchBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        } else {
            guildInnerSearchBar = guildInnerSearchBar2;
        }
        guildInnerSearchBar.setSearchBarListener(this.searchBarListener);
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider(requireActivity, new d(requireActivity, this)).get(QuickSearchViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        QuickSearchViewModel quickSearchViewModel = (QuickSearchViewModel) viewModel;
        this.viewModel = quickSearchViewModel;
        Companion.ENTRANCE_FROM entrance_from = this.entranceFrom;
        QuickSearchViewModel quickSearchViewModel2 = null;
        if (entrance_from != Companion.ENTRANCE_FROM.GUILD_MEMBER_SELECTOR && entrance_from != Companion.ENTRANCE_FROM.DATE_SELECTOR) {
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.v2(0);
        } else {
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.v2(1);
        }
        QuickSearchViewModel quickSearchViewModel3 = this.viewModel;
        if (quickSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            quickSearchViewModel2 = quickSearchViewModel3;
        }
        LiveData<Boolean> i26 = quickSearchViewModel2.i2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GuildQuickSearchFragment.this.Nh();
                GuildInnerSearchBar guildInnerSearchBar = GuildQuickSearchFragment.this.searchBox;
                if (guildInnerSearchBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBox");
                    guildInnerSearchBar = null;
                }
                guildInnerSearchBar.setKeyboardVisible(true);
            }
        };
        i26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQuickSearchFragment.Kh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildSearchKeyEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        activity.getWindow().setSoftInputMode(3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10214 && resultCode == 10213) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(10213);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Companion.ENTRANCE_FROM entrance_from = this.entranceFrom;
        if (entrance_from != Companion.ENTRANCE_FROM.GUILD_MEMBER_SELECTOR && entrance_from != Companion.ENTRANCE_FROM.DATE_SELECTOR) {
            QuickSearchViewModel quickSearchViewModel = this.viewModel;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            if (quickSearchViewModel.getPageState() != 0) {
                Mh();
                return true;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f3a, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        Lh();
        initView();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentContainerView fragmentContainerView = this.fragmentContainer;
        if (fragmentContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            fragmentContainerView = null;
        }
        Animation animation = fragmentContainerView.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.guild.picload.e.a().g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildSearchKeyEvent) {
            QuickSearchViewModel quickSearchViewModel = this.viewModel;
            if (quickSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                quickSearchViewModel = null;
            }
            quickSearchViewModel.X1(((GuildSearchKeyEvent) event).getSearchKey());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initDtReport();
        initViewModel();
        Ih();
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
