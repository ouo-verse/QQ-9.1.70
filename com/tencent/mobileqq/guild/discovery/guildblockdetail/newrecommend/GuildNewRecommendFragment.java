package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.GProSelectedGuildCard;
import com.tencent.mobileqq.guild.discoveryv2.content.util.UpdateRecommendGuildsData;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.cy;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.NumberUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef1.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J&\u0010\u0016\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildNewRecommendFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "", "Jh", "Lh", "Landroid/view/View;", "view", "Mh", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "y7", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "rh", "onPostThemeChanged", DKHippyEvent.EVENT_STOP, "", "onBackEvent", "T", "I", "categoryId", "U", "categoryConfId", "", "V", "Ljava/lang/String;", "categoryName", "W", "pageFrom", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/graphics/Rect;", "X", "Lkotlinx/coroutines/flow/MutableStateFlow;", "flowSystemInsets", "Y", "Lkotlin/Lazy;", "Kh", "()Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "viewModel", "<init>", "()V", "Z", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNewRecommendFragment extends QQGuildTokenTitleBarFragment implements u {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<cy> f216693a0 = new ArrayList<>();

    /* renamed from: T, reason: from kotlin metadata */
    private int categoryId;

    /* renamed from: U, reason: from kotlin metadata */
    private int categoryConfId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String categoryName = "";

    /* renamed from: W, reason: from kotlin metadata */
    private int pageFrom = 4;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private MutableStateFlow<Rect> flowSystemInsets = StateFlowKt.MutableStateFlow(new Rect(0, ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ), 0, 0));

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\"\u0010\t\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006JF\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006JN\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006R\u0014\u0010\u0019\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildNewRecommendFragment$a;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/cy;", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "items", "", "b", "Landroid/content/Context;", "context", "", "categoryId", "", "categoryName", "pageFrom", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", VideoTemplateParser.ITEM_LIST, "d", "categoryConfId", "mainSource", "subSource", "c", "EXTRA_MODULE_CATEGORYID", "Ljava/lang/String;", "EXTRA_MODULE_CATEGORYNAME", "EXTRA_MODULE_CATEGORY_CONF_ID", "EXTRA_MODULE_MAIN_SOURCE", "EXTRA_MODULE_SUB_SOURCE", "EXTRA_PAGE_FROM", "NEW_GUILD_RECOMMEND_TAG", "itemListFromDiscoveryPage", "Ljava/util/ArrayList;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<cy> a() {
            return GuildNewRecommendFragment.f216693a0;
        }

        public final void b(@Nullable ArrayList<cy> items) {
            GuildNewRecommendFragment.f216693a0.clear();
            if (items != null) {
                GuildNewRecommendFragment.f216693a0.addAll(items);
            }
        }

        public final void c(@NotNull Context context, int pageFrom, int categoryConfId, @NotNull String mainSource, @NotNull String subSource, @NotNull ArrayList<cy> itemList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mainSource, "mainSource");
            Intrinsics.checkNotNullParameter(subSource, "subSource");
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            Intent intent = new Intent();
            intent.putExtra(IFileBrowserService.FILE_BROWSER_PAGE_FROM, pageFrom);
            intent.putExtra("module_category_conf_id", categoryConfId);
            intent.putExtra("module_main_source", mainSource);
            intent.putExtra("module_sub_source", subSource);
            qw1.b.r(intent, Reporters.f231995a.b().newReportTask().setEventCode("feature_guild").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            intent.putExtra("GuildAppReportSourceInfo", (Parcelable) new GuildAppReportSourceInfo());
            intent.setFlags(268435456);
            b(itemList);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildNewRecommendFragment.class, null, 8, null);
        }

        public final void d(@NotNull Context context, int categoryId, @NotNull String categoryName, int pageFrom, @NotNull GuildAppReportSourceInfo reportSourceInfo, @NotNull ArrayList<cy> itemList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(categoryName, "categoryName");
            Intrinsics.checkNotNullParameter(reportSourceInfo, "reportSourceInfo");
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            Intent intent = new Intent();
            intent.putExtra(IFileBrowserService.FILE_BROWSER_PAGE_FROM, pageFrom);
            intent.putExtra("module_categoryId", categoryId);
            intent.putExtra("module_categoryName", categoryName);
            intent.putExtra("GuildAppReportSourceInfo", (Parcelable) reportSourceInfo);
            qw1.b.r(intent, Reporters.f231995a.b().newReportTask().setEventCode("feature_guild").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            b(itemList);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildNewRecommendFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    public GuildNewRecommendFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildRecommendDetailViewModel>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildRecommendDetailViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                final GuildNewRecommendFragment guildNewRecommendFragment = GuildNewRecommendFragment.this;
                return (GuildRecommendDetailViewModel) companion.c(guildNewRecommendFragment, GuildRecommendDetailViewModel.class, new Function0<GuildRecommendDetailViewModel>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment$viewModel$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final GuildRecommendDetailViewModel invoke() {
                        int i3;
                        int i16;
                        int i17;
                        String str;
                        i3 = GuildNewRecommendFragment.this.pageFrom;
                        i16 = GuildNewRecommendFragment.this.categoryId;
                        i17 = GuildNewRecommendFragment.this.categoryConfId;
                        str = GuildNewRecommendFragment.this.categoryName;
                        return new GuildRecommendDetailViewModel(i3, i16, i17, str);
                    }
                });
            }
        });
        this.viewModel = lazy;
    }

    private final void Jh() {
        Map mutableMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_module_place", 0));
        VideoReport.setPageId(this.P, "pg_sgrp_discover_recommend_card");
        VideoReport.setPageParams(this.P, new PageParams((Map<String, ?>) mutableMapOf));
    }

    private final GuildRecommendDetailViewModel Kh() {
        return (GuildRecommendDetailViewModel) this.viewModel.getValue();
    }

    private final void Lh() {
        ArrayList<GuildRecommendCardItem> arrayList;
        GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp value = Kh().getDiscoverRecommendDetailRspForNewCard().getValue();
        if (value != null) {
            arrayList = value.d();
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < 3; i3++) {
                if (arrayList.size() > i3) {
                    GuildRecommendCardItem guildRecommendCardItem = arrayList.get(i3);
                    Intrinsics.checkNotNullExpressionValue(guildRecommendCardItem, "items[i]");
                    GuildRecommendCardItem guildRecommendCardItem2 = guildRecommendCardItem;
                    GProSelectedGuildCard gProSelectedGuildCard = new GProSelectedGuildCard();
                    gProSelectedGuildCard.setGuildId(NumberUtil.stringToLong(guildRecommendCardItem2.getGuildId()));
                    gProSelectedGuildCard.setGuildAvatar(guildRecommendCardItem2.getGuildIconUrl());
                    gProSelectedGuildCard.setGuildName(guildRecommendCardItem2.getGuildName());
                    gProSelectedGuildCard.getMedals().addAll(guildRecommendCardItem2.getMedalInfoList());
                    gProSelectedGuildCard.setTagList(guildRecommendCardItem2.getTagList());
                    arrayList2.add(gProSelectedGuildCard);
                }
            }
            SimpleEventBus.getInstance().dispatchEvent(new UpdateRecommendGuildsData(arrayList2));
        }
    }

    private final void Mh(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.a
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat Nh;
                Nh = GuildNewRecommendFragment.Nh(GuildNewRecommendFragment.this, view2, windowInsetsCompat);
                return Nh;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Nh(GuildNewRecommendFragment this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        Intrinsics.checkNotNullExpressionValue(insets, "insets");
        String a16 = MiscKt.a(insets);
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, insets);
        Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "onApplyWindowInsets(v, insets)");
        int[] iArr2 = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        if (!Arrays.equals(iArr, iArr2)) {
            Logger.a d16 = Logger.f235387a.d();
            String arrays = Arrays.toString(iArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            String arrays2 = Arrays.toString(iArr2);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            d16.i("QQGuildCustomTitleBarFragment", 1, "setIgnoreWindowInsetsPaddings: " + arrays + " -> " + arrays2 + ", " + a16);
            view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            this$0.flowSystemInsets.setValue(new Rect(iArr2[0], iArr2[1], iArr2[2], iArr2[3]));
        }
        return onApplyWindowInsets;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        String str;
        String str2;
        String string;
        String string2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        Bundle arguments = getArguments();
        IPerformanceReportTask iPerformanceReportTask = null;
        if (arguments != null) {
            iPerformanceReportTask = qw1.b.g(arguments, null, 1, null);
        }
        arrayList.add(new GuildRecommendListPart(this, iPerformanceReportTask));
        int i3 = this.pageFrom;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("module_main_source")) == null) {
            str = "";
        } else {
            str = string2;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string = arguments3.getString("module_sub_source")) == null) {
            str2 = "";
        } else {
            str2 = string;
        }
        arrayList.add(new GuildRecommendContent(this, R.id.f166765i30, i3, str, str2));
        arrayList.add(new GuildRecommendDetailLoadingPart(this, R.id.f88364wv));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int i3;
        String str;
        int i16;
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        Bundle arguments = getArguments();
        int i17 = 0;
        if (arguments != null) {
            i3 = arguments.getInt("module_categoryId");
        } else {
            i3 = 0;
        }
        this.categoryId = i3;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i17 = arguments2.getInt("module_category_conf_id");
        }
        this.categoryConfId = i17;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str = arguments3.getString("module_categoryName");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.categoryName = str;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i16 = arguments4.getInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM);
        } else {
            i16 = 4;
        }
        this.pageFrom = i16;
        this.E.setText(HardCodeUtil.qqStr(R.string.f155781if));
        Jh();
        GuildSplitViewUtils.f235370a.B(this.N);
        RelativeLayout titleRoot = this.N;
        if (titleRoot != null) {
            Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
            Mh(titleRoot);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168098et0;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        rh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Lh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
        DrawableType drawableType = new DrawableType(R.drawable.guild_audio_top_back_left_btn, Integer.valueOf(R.color.qui_common_icon_primary));
        ImageView mLeftBackIcon = this.I;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon, "mLeftBackIcon");
        drawableType.a(mLeftBackIcon);
    }

    @Override // com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.u
    @NotNull
    public GuildRecommendDetailViewModel y7() {
        return Kh();
    }
}
