package com.tencent.mobileqq.guild.channel.manage.feedsquare;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.profile.me.aa;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bf;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bc;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bg;
import wh2.br;
import xf1.a;
import xf1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001|B\u0007\u00a2\u0006\u0004\by\u0010zJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J(\u0010\u0015\u001a\u00020\n2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J&\u0010 \u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010!\u001a\u00020\nH\u0016J\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\b\u0010'\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(H\u0016J\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\nJ\b\u0010-\u001a\u00020\u0005H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010ER\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\"\u0010\u0007\u001a\u00020W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010a\u001a\u00020W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001a\u0010e\u001a\u00020\u00038\u0006X\u0086D\u00a2\u0006\f\n\u0004\bb\u0010:\u001a\u0004\bc\u0010dR&\u0010i\u001a\u0012\u0012\u0004\u0012\u00020f0\u0011j\b\u0012\u0004\u0012\u00020f`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR$\u0010l\u001a\u0012\u0012\u0004\u0012\u00020j0\u0011j\b\u0012\u0004\u0012\u00020j`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010hR\"\u0010t\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010w\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/manage/feedsquare/GuildChannelManageFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "guildId", "", "Vh", "categoryId", "Wh", "Xh", "", "hi", "Mh", "Ph", "bi", "source", "Yh", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "Lkotlin/collections/ArrayList;", "infoList", "ci", "Rh", "Oh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onDestroyView", "initData", "Uh", "Th", "gi", "initView", "rh", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Nh", "di", "onBackEvent", "Landroidx/recyclerview/widget/ItemTouchHelper;", "T", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Lxf1/a;", "U", "Lxf1/a;", "dragTouchCallBack", "V", "Z", "sorting", "W", "Ljava/lang/String;", "X", "I", "categoryType", "Y", "chatTitle", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "mListView", "Landroid/widget/LinearLayout;", "a0", "Landroid/widget/LinearLayout;", "channelLly", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "b0", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "emptyView", "c0", "bottomLly", "Landroid/widget/TextView;", "d0", "Landroid/widget/TextView;", "channelSort", "e0", "addChannel", "Lxf1/h;", "f0", "Lxf1/h;", "listAdapter", "", "g0", "J", "getCategoryId", "()J", "setCategoryId", "(J)V", "h0", "getNoCategoryId", "setNoCategoryId", "noCategoryId", "i0", "Qh", "()Ljava/lang/String;", "onChannelCreate", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "j0", "Ljava/util/ArrayList;", "channelInfoList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "k0", "noCategoryList", "Loo1/a;", "l0", "Loo1/a;", "getGuildObserver", "()Loo1/a;", "setGuildObserver", "(Loo1/a;)V", "guildObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "m0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gPServiceObserver", "<init>", "()V", "n0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelManageFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener {

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ItemTouchHelper itemTouchHelper;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private a dragTouchCallBack;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean sorting;

    /* renamed from: X, reason: from kotlin metadata */
    private int categoryType;

    /* renamed from: Z, reason: from kotlin metadata */
    private OverScrollRecyclerView mListView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout channelLly;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState emptyView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout bottomLly;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView channelSort;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private TextView addChannel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h listAdapter;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long categoryId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private long noCategoryId;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String chatTitle = "";

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String onChannelCreate = "onChannelCreate";

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.guild.channel.manage.b> channelInfoList = new ArrayList<>();

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<IGProChannel> noCategoryList = new ArrayList<>();

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private oo1.a guildObserver = new c();

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gPServiceObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/manage/feedsquare/GuildChannelManageFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "categoryType", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.manage.feedsquare.GuildChannelManageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String guildId, int categoryType) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (TextUtils.isEmpty(guildId)) {
                QQGuildUIUtil.Q(context, R.string.f143560me);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("key_channel_type", categoryType);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildChannelManageFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0014J(\u0010\u0010\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/channel/manage/feedsquare/GuildChannelManageFragment$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "mGuildId", "", "onChannelListUpdated", "channelUin", "onChannelInfoUpdated", "guildId", "", "channelIds", "onPushChannelDestroy", "", "ops", "Lcom/tencent/mobileqq/qqguildsdk/data/fk;", "list", "onQQMsgListChannelUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            IGProChannelInfo channelInfo;
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            super.onChannelInfoUpdated(channelUin);
            if (!GuildChannelManageFragment.this.sorting && (channelInfo = ((IGPSService) ch.S0(IGPSService.class, "")).getChannelInfo(channelUin)) != null && TextUtils.equals(GuildChannelManageFragment.this.guildId, channelInfo.getGuildId())) {
                GuildChannelManageFragment.this.Yh("onChannelInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String mGuildId) {
            super.onChannelListUpdated(mGuildId);
            if (!GuildChannelManageFragment.this.sorting && TextUtils.equals(mGuildId, GuildChannelManageFragment.this.guildId)) {
                GuildChannelManageFragment.this.Yh("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@Nullable String guildId, @Nullable List<String> channelIds) {
            super.onPushChannelDestroy(guildId, channelIds);
            if (!GuildChannelManageFragment.this.sorting) {
                GuildChannelManageFragment.this.Yh("onPushChannelDestroy");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onQQMsgListChannelUpdated(@Nullable List<Integer> ops, @Nullable List<fk> list) {
            super.onQQMsgListChannelUpdated(ops, list);
            if (!GuildChannelManageFragment.this.sorting) {
                GuildChannelManageFragment.this.Yh("onQQMsgListChannelUpdated");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channel/manage/feedsquare/GuildChannelManageFragment$c", "Loo1/a;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "from", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends oo1.a {
        c() {
        }

        @Override // oo1.a
        public void a(boolean isSuccess, @NotNull IGProChannelInfo channelInfo, @NotNull String from) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            Intrinsics.checkNotNullParameter(from, "from");
            if (Intrinsics.areEqual("list_setting", from)) {
                GuildChannelManageFragment guildChannelManageFragment = GuildChannelManageFragment.this;
                guildChannelManageFragment.Yh(guildChannelManageFragment.getOnChannelCreate());
            }
        }
    }

    private final void Mh() {
        bi();
        Yh("cancelSorting");
    }

    private final void Oh() {
        int i3;
        int i16;
        Map<String, Object> mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_tab_zone_second_manage");
        if (ch.n0(this.guildId)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int i17 = this.categoryType;
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3 && i17 != 9) {
                    i16 = 0;
                } else {
                    i16 = 2;
                }
            } else {
                i16 = 3;
            }
        } else {
            i16 = 1;
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        RelativeLayout relativeLayout = this.N;
        String str = this.guildId;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", str), TuplesKt.to("sgrp_user_type", Integer.valueOf(i3)), TuplesKt.to("sgrp_page_type", Integer.valueOf(i16)));
        iGuildDTReportApi.setGuildPageParams(relativeLayout, str, mapOf);
    }

    private final void Ph() {
        if (!this.sorting) {
            return;
        }
        bi();
    }

    private final void Rh() {
        if (NetworkUtil.isNetworkAvailable() && this.listAdapter != null) {
            ArrayList<com.tencent.mobileqq.qqguildsdk.data.b> arrayList = new ArrayList<>();
            h hVar = this.listAdapter;
            Intrinsics.checkNotNull(hVar);
            com.tencent.mobileqq.qqguildsdk.data.b bVar = null;
            for (com.tencent.mobileqq.guild.channel.manage.b bVar2 : hVar.j0()) {
                if (bVar2.f215081a == 1) {
                    bVar = new com.tencent.mobileqq.qqguildsdk.data.b(bVar2.f215082b, bVar2.f215086f);
                    arrayList.add(bVar);
                }
                IGProChannel iGProChannel = bVar2.f215084d;
                if (iGProChannel != null && bVar != null) {
                    bVar.a(String.valueOf(iGProChannel.getChannelId()));
                }
            }
            ((IGPSService) ch.S0(IGPSService.class, "")).setChannelCategoryInfo(this.guildId, new com.tencent.mobileqq.qqguildsdk.data.b("", 0L, new ArrayList()), arrayList, new bg() { // from class: xf1.d
                @Override // vh2.bg
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    GuildChannelManageFragment.Sh(GuildChannelManageFragment.this, i3, str, iGProSecurityResult);
                }
            });
            return;
        }
        ch.f1(BaseApplication.getContext().getString(R.string.f141910hy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(GuildChannelManageFragment this$0, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            this$0.Ph();
            return;
        }
        Context context = this$0.P.getContext();
        if (str == null) {
            str = this$0.P.getResources().getString(R.string.f141910hy);
            Intrinsics.checkNotNullExpressionValue(str, "mContentView.resources.g\u2026ild_channel_submit_error)");
        }
        QQToast.makeText(context, 1, str, 1).show();
    }

    private final boolean Vh(String guildId) {
        return r.p().getGuildPermission(guildId).a(20001);
    }

    private final boolean Wh(String guildId, String categoryId) {
        if (!r.p().getGuildPermission(guildId).a(20001) && !r.p().getCategoryPermission(guildId, categoryId).a(20001)) {
            return false;
        }
        return true;
    }

    private final boolean Xh() {
        if (this.categoryType == 2 && ch.g0(this.guildId) && !ch.m0(this.guildId)) {
            return false;
        }
        if (!ch.m0(this.guildId) && !ch.A0(this.guildId, Long.valueOf(this.categoryId))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(final String source) {
        QLog.w("GuildChannelManageFragment", 1, source + this.categoryType);
        if (this.categoryType == 1) {
            bd bdVar = new bd();
            bdVar.k(Long.parseLong(this.guildId));
            bdVar.h(false);
            bdVar.j(true);
            bdVar.i(true);
            ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, new br() { // from class: xf1.b
                @Override // wh2.br
                public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                    GuildChannelManageFragment.Zh(GuildChannelManageFragment.this, source, arrayList);
                }
            });
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        ArrayList<IGProCategoryChannelIdList> categoryChannelIdList = ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelIdList(Long.parseLong(this.guildId));
        if (categoryChannelIdList != null) {
            for (IGProCategoryChannelIdList iGProCategoryChannelIdList : categoryChannelIdList) {
                if (iGProCategoryChannelIdList.getCategoryType() == this.categoryType) {
                    arrayList.add(Long.valueOf(iGProCategoryChannelIdList.getCategoryId()));
                }
            }
        }
        bc bcVar = new bc();
        bcVar.e(Long.parseLong(this.guildId));
        bcVar.d(arrayList);
        ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelInfoListByFilter(bcVar, new br() { // from class: xf1.c
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList2) {
                GuildChannelManageFragment.ai(GuildChannelManageFragment.this, source, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildChannelManageFragment this$0, String source, ArrayList infoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        this$0.ci(infoList, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(GuildChannelManageFragment this$0, String source, ArrayList infoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        this$0.ci(infoList, source);
    }

    private final void bi() {
        this.sorting = false;
        Uh();
        this.F.setVisibility(8);
        LinearLayout linearLayout = this.bottomLly;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLly");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        resetLeftButton();
        a aVar = this.dragTouchCallBack;
        if (aVar != null) {
            aVar.b(true);
        }
        h hVar = this.listAdapter;
        Intrinsics.checkNotNull(hVar);
        hVar.o0(this.sorting);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.widget.TextView] */
    private final void ci(ArrayList<IGProCategoryChannelInfoList> infoList, String source) {
        OverScrollRecyclerView overScrollRecyclerView;
        boolean z16;
        if (getContext() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IGProCategoryChannelInfoList> it = infoList.iterator();
        int i3 = 0;
        while (true) {
            float f16 = 1.0f;
            overScrollRecyclerView = null;
            if (!it.hasNext()) {
                break;
            }
            IGProCategoryChannelInfoList next = it.next();
            if (next.getCategoryType() == 1) {
                this.categoryId = next.getCategoryId();
            }
            if (next.getCategoryType() == 2) {
                String categoryName = next.getCategoryName();
                Intrinsics.checkNotNullExpressionValue(categoryName, "category.name");
                this.chatTitle = categoryName;
                Uh();
                if (!Wh(this.guildId, String.valueOf(this.categoryId))) {
                    f16 = 0.5f;
                }
                ?? r95 = this.addChannel;
                if (r95 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                } else {
                    overScrollRecyclerView = r95;
                }
                overScrollRecyclerView.setAlpha(f16);
            }
            Iterator<IGProChannel> it5 = next.getChannelInfoList().iterator();
            while (it5.hasNext()) {
                IGProChannel next2 = it5.next();
                if (this.categoryType != 3 || next2.getChannelType() != 2) {
                    com.tencent.mobileqq.guild.channel.manage.b bVar = new com.tencent.mobileqq.guild.channel.manage.b();
                    if (next.getCategoryType() == 0) {
                        this.noCategoryId = next.getCategoryId();
                        this.noCategoryList.add(next2);
                    }
                    if (next2.getHiddenPostChannel() != 1) {
                        i3++;
                        bVar.f215081a = 0;
                    }
                    bVar.f215084d = next2;
                    bVar.f215082b = next.getCategoryName();
                    bVar.f215086f = next.getCategoryId();
                    bVar.f215087g = next2.getIsCategoryAdmin();
                    bVar.f215088h = r.p().getChannelPermission(this.guildId, String.valueOf(next2.getChannelId())).h();
                    if (!ch.m0(this.guildId) && !ch.A0(this.guildId, Long.valueOf(next.getCategoryId()))) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    bVar.f215090j = z16;
                    arrayList.add(bVar);
                }
            }
        }
        if (this.categoryId == 0 && infoList.size() > 0) {
            this.categoryId = infoList.get(0).getCategoryId();
        }
        if (i3 == 0) {
            LinearLayout linearLayout = this.channelLly;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelLly");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            ?? r16 = this.bottomLly;
            if (r16 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomLly");
            } else {
                overScrollRecyclerView = r16;
            }
            overScrollRecyclerView.setVisibility(8);
            di();
            return;
        }
        GuildQUIEmptyState guildQUIEmptyState = this.emptyView;
        if (guildQUIEmptyState != null) {
            aa.a(guildQUIEmptyState);
        }
        LinearLayout linearLayout2 = this.channelLly;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelLly");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.bottomLly;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLly");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        if (i3 <= 1) {
            TextView textView = this.channelSort;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelSort");
                textView = null;
            }
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.channelSort;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelSort");
                textView2 = null;
            }
            textView2.setVisibility(0);
        }
        if (!Xh()) {
            TextView textView3 = this.channelSort;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelSort");
                textView3 = null;
            }
            textView3.setAlpha(0.5f);
        } else {
            TextView textView4 = this.channelSort;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelSort");
                textView4 = null;
            }
            textView4.setAlpha(1.0f);
        }
        if (!Wh(this.guildId, String.valueOf(this.categoryId))) {
            TextView textView5 = this.addChannel;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                textView5 = null;
            }
            textView5.setAlpha(0.5f);
        } else {
            TextView textView6 = this.addChannel;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                textView6 = null;
            }
            textView6.setAlpha(1.0f);
        }
        com.tencent.mobileqq.guild.channel.manage.b bVar2 = new com.tencent.mobileqq.guild.channel.manage.b();
        bVar2.f215081a = 1;
        int i16 = this.categoryType;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 9) {
                        LinearLayout linearLayout4 = this.channelLly;
                        if (linearLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelLly");
                            linearLayout4 = null;
                        }
                        bVar2.f215082b = linearLayout4.getContext().getResources().getString(R.string.f142180io);
                    }
                } else {
                    LinearLayout linearLayout5 = this.channelLly;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelLly");
                        linearLayout5 = null;
                    }
                    bVar2.f215082b = linearLayout5.getContext().getResources().getString(R.string.f141570h1);
                }
            } else {
                bVar2.f215082b = this.chatTitle;
            }
        } else {
            LinearLayout linearLayout6 = this.channelLly;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelLly");
                linearLayout6 = null;
            }
            bVar2.f215082b = linearLayout6.getContext().getResources().getString(R.string.f141120ft);
        }
        bVar2.f215086f = this.categoryId;
        arrayList.add(0, bVar2);
        this.channelInfoList.clear();
        this.channelInfoList.addAll(arrayList);
        h hVar = this.listAdapter;
        Intrinsics.checkNotNull(hVar);
        hVar.setData(this.channelInfoList);
        if (Intrinsics.areEqual(source, this.onChannelCreate)) {
            OverScrollRecyclerView overScrollRecyclerView2 = this.mListView;
            if (overScrollRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
            } else {
                overScrollRecyclerView = overScrollRecyclerView2;
            }
            overScrollRecyclerView.smoothScrollToPosition(this.channelInfoList.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(GuildChannelManageFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ChannelSettingUtils.j(it, "em_sgrp_empty_create", null, 4, null);
        this$0.Nh();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(GuildChannelManageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildQUIEmptyState guildQUIEmptyState = this$0.emptyView;
        if (guildQUIEmptyState != null) {
            aa.a(guildQUIEmptyState);
        }
        View view = this$0.P;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view).addView(this$0.emptyView, -1, -1);
    }

    private final void hi() {
        if (this.sorting) {
            return;
        }
        this.sorting = true;
        gi();
        LinearLayout linearLayout = this.bottomLly;
        OverScrollRecyclerView overScrollRecyclerView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLly");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        this.F.setVisibility(0);
        this.F.setText(getResources().getString(R.string.f143340lt));
        this.F.setOnClickListener(this);
        setLeftButton(getResources().getString(R.string.f140850f3), new View.OnClickListener() { // from class: xf1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildChannelManageFragment.ii(GuildChannelManageFragment.this, view);
            }
        });
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(null);
        }
        OverScrollRecyclerView overScrollRecyclerView2 = this.mListView;
        if (overScrollRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView2 = null;
        }
        h hVar = this.listAdapter;
        Intrinsics.checkNotNull(hVar);
        a aVar = new a(overScrollRecyclerView2, hVar.i0());
        this.dragTouchCallBack = aVar;
        Intrinsics.checkNotNull(aVar);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(aVar);
        this.itemTouchHelper = itemTouchHelper2;
        Intrinsics.checkNotNull(itemTouchHelper2);
        OverScrollRecyclerView overScrollRecyclerView3 = this.mListView;
        if (overScrollRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            overScrollRecyclerView = overScrollRecyclerView3;
        }
        itemTouchHelper2.attachToRecyclerView(overScrollRecyclerView);
        h hVar2 = this.listAdapter;
        Intrinsics.checkNotNull(hVar2);
        hVar2.o0(this.sorting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(GuildChannelManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void Nh() {
        int i3 = this.categoryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 9) {
                        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).createVoiceChannel(getChildFragmentManager(), this.guildId, "list_setting", this.categoryId);
                        return;
                    }
                    return;
                }
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).createLiveChannel(getChildFragmentManager(), this.guildId, "list_setting", this.categoryId);
                return;
            }
            if (Wh(this.guildId, String.valueOf(this.categoryId))) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).createTextChannel(getChildFragmentManager(), this.guildId, this.chatTitle, "list_setting", this.categoryId);
                return;
            } else {
                QQGuildUIUtil.Q(getContext(), R.string.f141840hr);
                return;
            }
        }
        if (Wh(this.guildId, String.valueOf(this.categoryId))) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).createBoardChannel(getChildFragmentManager(), this.guildId, "list_setting", this.categoryId);
        } else {
            QQGuildUIUtil.Q(getContext(), R.string.f141840hr);
        }
    }

    @NotNull
    /* renamed from: Qh, reason: from getter */
    public final String getOnChannelCreate() {
        return this.onChannelCreate;
    }

    public final void Th() {
        TextView textView = this.addChannel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addChannel");
            textView = null;
        }
        textView.setVisibility(0);
        int i3 = this.categoryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 9) {
                        TextView textView3 = this.addChannel;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                        } else {
                            textView2 = textView3;
                        }
                        textView2.setText(getResources().getString(R.string.f141340ge));
                        return;
                    }
                    return;
                }
                TextView textView4 = this.addChannel;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                } else {
                    textView2 = textView4;
                }
                textView2.setText(getResources().getString(R.string.f141300ga));
                return;
            }
            if (!bf.f235464a.a()) {
                TextView textView5 = this.addChannel;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                } else {
                    textView2 = textView5;
                }
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView6 = this.addChannel;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addChannel");
        } else {
            textView2 = textView6;
        }
        textView2.setText(getResources().getString(R.string.f140970fe));
    }

    public final void Uh() {
        int i3 = this.categoryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 9) {
                        setTitle(getResources().getString(R.string.f158431pl));
                        return;
                    }
                    return;
                }
                setTitle(getResources().getString(R.string.f147940y9));
                return;
            }
            setTitle(getResources().getString(R.string.f142340j4));
            TextView textView = this.addChannel;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addChannel");
                textView = null;
            }
            textView.setText("\u521b\u5efa" + this.chatTitle);
            return;
        }
        setTitle(getResources().getString(R.string.f14896110));
    }

    public final void di() {
        if (this.emptyView != null) {
            View view = this.P;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            if (((ViewGroup) view).indexOfChild(this.emptyView) != -1) {
                return;
            }
        }
        GuildQUIEmptyState.a r16 = new GuildQUIEmptyState.a(getContext()).s(3).o(2).r(false);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: xf1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildChannelManageFragment.ei(GuildChannelManageFragment.this, view2);
            }
        };
        int i3 = this.categoryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 9) {
                        String string = getString(R.string.f1511716z);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_no_channel_voice)");
                        GuildQUIEmptyState.a u16 = r16.u(string);
                        String string2 = getResources().getString(R.string.f141340ge);
                        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026ild_channel_create_voice)");
                        u16.p(string2, onClickListener);
                    }
                } else {
                    String string3 = getString(R.string.f1511616y);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild_no_channel_live)");
                    GuildQUIEmptyState.a u17 = r16.u(string3);
                    String string4 = getResources().getString(R.string.f141300ga);
                    Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026uild_channel_create_live)");
                    u17.p(string4, onClickListener);
                }
            } else {
                r16.u("\u6682\u65e0" + this.chatTitle);
                if (bf.f235464a.a()) {
                    r16.p("\u521b\u5efa" + this.chatTitle, onClickListener);
                }
            }
        } else {
            String string5 = getString(R.string.f141760hj);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.guild_channel_no_board)");
            GuildQUIEmptyState.a u18 = r16.u(string5);
            String string6 = getString(R.string.f141770hk);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.guild_channel_no_board_tip)");
            GuildQUIEmptyState.a q16 = u18.q(string6);
            String string7 = getResources().getString(R.string.f140970fe);
            Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.st\u2026.guild_channel_add_board)");
            q16.p(string7, onClickListener);
        }
        this.emptyView = r16.a();
        this.P.post(new Runnable() { // from class: xf1.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildChannelManageFragment.fi(GuildChannelManageFragment.this);
            }
        });
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        ChannelSettingUtils.h(mContentView, "em_sgrp_empty_create", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        initView();
        initData();
        Oh();
        ch.l().addObserver(this.guildObserver);
        ((IGPSService) ch.S0(IGPSService.class, "")).addObserver(this.gPServiceObserver);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eib;
    }

    public final void gi() {
        int i3 = this.categoryType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 9) {
                        setTitle(getResources().getString(R.string.f158441pm));
                        return;
                    }
                    return;
                }
                setTitle(getResources().getString(R.string.f147950y_));
                return;
            }
            setTitle(getResources().getString(R.string.f142350j5));
            return;
        }
        setTitle(getResources().getString(R.string.f141220g3));
    }

    public final void initData() {
        String str;
        int i3;
        TextView textView = null;
        if (getActivity() != null && GuildSplitViewUtils.f235370a.n(requireActivity())) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString("extra_guild_id", "");
            } else {
                str = null;
            }
            this.guildId = String.valueOf(str);
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                i3 = arguments2.getInt("key_channel_type", 0);
            } else {
                i3 = 0;
            }
            this.categoryType = i3;
        } else {
            Intent intent = requireActivity().getIntent();
            this.guildId = String.valueOf(intent.getStringExtra("extra_guild_id"));
            this.categoryType = intent.getIntExtra("key_channel_type", 0);
        }
        Uh();
        Th();
        h hVar = new h();
        this.listAdapter = hVar;
        Intrinsics.checkNotNull(hVar);
        hVar.p0(this);
        OverScrollRecyclerView overScrollRecyclerView = this.mListView;
        if (overScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView = null;
        }
        overScrollRecyclerView.setAdapter(this.listAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        OverScrollRecyclerView overScrollRecyclerView2 = this.mListView;
        if (overScrollRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView2 = null;
        }
        overScrollRecyclerView2.setLayoutManager(linearLayoutManager);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        OverScrollRecyclerView overScrollRecyclerView3 = this.mListView;
        if (overScrollRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView3 = null;
        }
        overScrollRecyclerView3.setItemAnimator(defaultItemAnimator);
        OverScrollRecyclerView overScrollRecyclerView4 = this.mListView;
        if (overScrollRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView4 = null;
        }
        overScrollRecyclerView4.setNestedScrollingEnabled(false);
        if (!Vh(this.guildId)) {
            TextView textView2 = this.addChannel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addChannel");
            } else {
                textView = textView2;
            }
            textView.setAlpha(0.5f);
        }
        Yh("init");
    }

    public final void initView() {
        View findViewById = this.P.findViewById(R.id.w2_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026guild_channel_setting_xl)");
        this.mListView = (OverScrollRecyclerView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.trt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.channel_Lly)");
        this.channelLly = (LinearLayout) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.tsc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.channel_sort)");
        this.channelSort = (TextView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.f164011sd2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.add_channel)");
        this.addChannel = (TextView) findViewById4;
        View findViewById5 = this.P.findViewById(R.id.t_y);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewById(R.id.bottom_lly)");
        this.bottomLly = (LinearLayout) findViewById5;
        com.tencent.mobileqq.guild.channel.manage.c cVar = new com.tencent.mobileqq.guild.channel.manage.c(getContext(), 0, 1, getResources().getColor(R.color.qui_common_border_standard));
        cVar.b(QQGuildUIUtil.f(16.0f), QQGuildUIUtil.f(16.0f));
        cVar.c(false);
        OverScrollRecyclerView overScrollRecyclerView = this.mListView;
        if (overScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            overScrollRecyclerView = null;
        }
        overScrollRecyclerView.addItemDecoration(cVar);
        TextView textView = this.channelSort;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelSort");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.addChannel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addChannel");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.channelSort;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelSort");
            textView3 = null;
        }
        TextView textView4 = this.channelSort;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelSort");
            textView4 = null;
        }
        Context context = textView4.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "channelSort.context");
        textView3.setCompoundDrawablesWithIntrinsicBounds(GuildUIUtils.w(context, R.drawable.guild_channel_manage_sort, Integer.valueOf(R.color.qui_common_text_primary)), (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView5 = this.addChannel;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addChannel");
            textView5 = null;
        }
        TextView textView6 = this.channelSort;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelSort");
            textView6 = null;
        }
        Context context2 = textView6.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "channelSort.context");
        textView5.setCompoundDrawablesWithIntrinsicBounds(GuildUIUtils.w(context2, R.drawable.guild_channel_manage_add, Integer.valueOf(R.color.qui_common_text_primary)), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!QQGuildUIUtil.v()) {
            if (this.sorting) {
                if (v3 == this.F) {
                    Rh();
                }
            } else {
                int id5 = v3.getId();
                if (id5 == R.id.f164011sd2) {
                    ChannelSettingUtils.j(v3, "em_sgrp_creat_new_section", null, 4, null);
                    Nh();
                } else if (id5 == R.id.tsc) {
                    ChannelSettingUtils.j(v3, "em_sgrp_sort", null, 4, null);
                    if (Xh()) {
                        hi();
                    } else {
                        QQGuildUIUtil.Q(getContext(), R.string.f141860ht);
                    }
                } else if (id5 == R.id.wly) {
                    Object tag = v3.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.channel.manage.GuildChannelInfoUIData");
                    com.tencent.mobileqq.guild.channel.manage.b bVar = (com.tencent.mobileqq.guild.channel.manage.b) tag;
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sub_channel_id", Long.valueOf(bVar.f215084d.getChannelId())));
                    ChannelSettingUtils.i(v3, "em_sgrp_section", mapOf);
                    if (bVar.f215088h) {
                        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(getAppInterface(), BaseApplication.getContext(), this.guildId, String.valueOf(bVar.f215084d.getChannelId()), 1);
                    } else {
                        QQGuildUIUtil.Q(getContext(), R.string.f141850hs);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ch.l().removeObserver(this.guildObserver);
        ((IGPSService) ch.S0(IGPSService.class, "")).deleteObserver(this.gPServiceObserver);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
