package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import fh1.MineFeedImageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J(\u0010\u0018\u001a\u00020\u00072 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u001e\u0010$\u001a\u00020\u00072\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050!j\b\u0012\u0004\u0012\u00020\u0005`\"R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00050!j\b\u0012\u0004\u0012\u00020\u0005`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R0\u00105\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewHolder;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/g;", "feedItem", "", "k0", "", "n0", "Landroid/content/Context;", "context", "r0", "Landroid/os/Bundle;", "l0", "Lkotlin/Pair;", "m0", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "o0", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedItemCallback;", "callback", "t0", "getItemCount", "holder", "position", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "feedItemList", "s0", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", "guildBaseProfileData", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "userProfileInfo", "D", "Lkotlin/Pair;", "imagePairSize", "E", "Ljava/util/ArrayList;", "feedList", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFeedItemAdapter extends RecyclerView.Adapter<GuildProfileFeedViewHolder> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private ev userProfileInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> imagePairSize = new Pair<>(0, 0);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ProfileFeedItem> feedList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function2<? super Integer, ? super ProfileFeedItem, Unit> itemClickCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildBaseProfileData guildBaseProfileData;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedItemAdapter$a;", "", "", "a", "", "FEED_ITEM_IMAGE_WIDTH_MAX_DP", UserInfo.SEX_FEMALE, "FEED_ITEM_MARGIN_DP", "FEED_ITEM_OFFSET_DP", "PHONE_MAX_FEED_LIST", "I", "TABLET_MAX_FEED_LIST", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedItemAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            boolean z16;
            BaseApplication context = BaseApplication.getContext();
            if (PadUtil.a(context) == DeviceType.PHONE) {
                return 4;
            }
            int d16 = bi.d();
            if (AppSetting.t(context) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d16 = (int) (d16 * com.tencent.mobileqq.pad.e.g());
            } else if (z16) {
                throw new NoWhenBranchMatchedException();
            }
            int i3 = 8;
            if (d16 == 0) {
                return 8;
            }
            int a16 = ((d16 - (bi.a(20.0f) * 2)) + bi.a(3.0f)) / bi.a(108.0f);
            if (a16 == 0) {
                i3 = 1;
            } else if (a16 < 8) {
                i3 = a16;
            }
            Logger.f235387a.d().d("Guild.profile.GuildProfileFeedItemAdapter", 1, "[maxCount] " + i3);
            return i3;
        }

        Companion() {
        }
    }

    private final void k0(View rootView, ProfileFeedItem feedItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_profile");
        GuildBaseProfileData guildBaseProfileData = this.guildBaseProfileData;
        GuildBaseProfileData guildBaseProfileData2 = null;
        if (guildBaseProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
            guildBaseProfileData = null;
        }
        hashMap.put("sgrp_user_type", Integer.valueOf(v.b(guildBaseProfileData.k())));
        hashMap.put("sgrp_user_master", Integer.valueOf(n0()));
        GuildBaseProfileData guildBaseProfileData3 = this.guildBaseProfileData;
        if (guildBaseProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
            guildBaseProfileData3 = null;
        }
        hashMap.put("sgrp_profile_scene", Integer.valueOf(guildBaseProfileData3.g()));
        GuildBaseProfileData guildBaseProfileData4 = this.guildBaseProfileData;
        if (guildBaseProfileData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
            guildBaseProfileData4 = null;
        }
        String e16 = guildBaseProfileData4.e();
        Intrinsics.checkNotNullExpressionValue(e16, "guildBaseProfileData.guildId");
        hashMap.put("sgrp_channel_id", e16);
        GuildBaseProfileData guildBaseProfileData5 = this.guildBaseProfileData;
        if (guildBaseProfileData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
        } else {
            guildBaseProfileData2 = guildBaseProfileData5;
        }
        String b16 = guildBaseProfileData2.b();
        Intrinsics.checkNotNullExpressionValue(b16, "guildBaseProfileData.dstTinyId");
        hashMap.put("sgrp_profile_userid", b16);
        String valueOf = String.valueOf(feedItem.getFeed().channelInfo.sign.channelId);
        String feedId = feedItem.getFeed().idd;
        hashMap.put("sgrp_sub_channel_id", valueOf);
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        hashMap.put("forum_content_id", feedId);
        ch.T0(rootView, "em_sgrp_forum_feed_publish", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, hashMap);
    }

    private final Bundle l0(ProfileFeedItem feedItem) {
        GuildBaseProfileData guildBaseProfileData = this.guildBaseProfileData;
        if (guildBaseProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
            guildBaseProfileData = null;
        }
        String e16 = guildBaseProfileData.e();
        String valueOf = String.valueOf(feedItem.getFeed().channelInfo.sign.channelId);
        String str = feedItem.getFeed().poster.idd;
        long j3 = feedItem.getFeed().createTime;
        String str2 = feedItem.getFeed().idd;
        String str3 = feedItem.getFeed().channelInfo.sign.joinGuildSig;
        Bundle bundle = new Bundle();
        bundle.putString("guildId", e16);
        bundle.putString("channelId", valueOf);
        bundle.putString("posterTinyId", str);
        bundle.putString("feedId", str2);
        bundle.putInt("shareSource", 14);
        bundle.putLong(WadlProxyConsts.CREATE_TIME, j3);
        bundle.putString("visitorTinyId", ch.g());
        bundle.putInt("businessType", 8);
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam("", str3, "profile_card", "channel_profile_card");
        bundle.putInt("immersive_source", 18);
        bundle.putParcelable("joinInfoParam", joinInfoParam);
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", "channel_profile_card");
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("jumpExtraInfo", guildAppReportSourceInfo);
        return bundle;
    }

    private final Pair<Integer, Integer> m0() {
        int size;
        if (this.imagePairSize.getFirst().intValue() != 0 && this.imagePairSize.getSecond().intValue() != 0) {
            return this.imagePairSize;
        }
        BaseApplication context = BaseApplication.getContext();
        int a16 = (x.f(context).f185860a - (bi.a(20.0f) * 2)) - ((this.feedList.size() - 1) * bi.a(3.0f));
        int a17 = bi.a(105.0f);
        if (PadUtil.a(context) == DeviceType.PHONE) {
            size = 4;
        } else {
            size = this.feedList.size();
        }
        int min = Math.min(a16 / size, a17);
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(min), Integer.valueOf(min));
        this.imagePairSize = pair;
        return pair;
    }

    private final int n0() {
        GuildBaseProfileData guildBaseProfileData = this.guildBaseProfileData;
        GuildBaseProfileData guildBaseProfileData2 = null;
        if (guildBaseProfileData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
            guildBaseProfileData = null;
        }
        String j3 = guildBaseProfileData.j();
        GuildBaseProfileData guildBaseProfileData3 = this.guildBaseProfileData;
        if (guildBaseProfileData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildBaseProfileData");
        } else {
            guildBaseProfileData2 = guildBaseProfileData3;
        }
        return Intrinsics.areEqual(j3, guildBaseProfileData2.b()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(Context context, ProfileFeedItem feedItem) {
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedDetailActivity(context, l0(feedItem), ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(feedItem.getFeed()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.feedList.size();
    }

    public final void o0(@NotNull GuildProfileData profileData) {
        Intrinsics.checkNotNullParameter(profileData, "profileData");
        GuildBaseProfileData guildBaseProfileData = profileData.getGuildBaseProfileData();
        Intrinsics.checkNotNullExpressionValue(guildBaseProfileData, "profileData.guildBaseProfileData");
        this.guildBaseProfileData = guildBaseProfileData;
        ev userProfileInfo = profileData.getUserProfileInfo();
        Intrinsics.checkNotNullExpressionValue(userProfileInfo, "profileData.userProfileInfo");
        this.userProfileInfo = userProfileInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final GuildProfileFeedViewHolder holder, final int position) {
        Object orNull;
        boolean z16;
        String url;
        boolean z17;
        boolean z18;
        String url2;
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.feedList, position);
        final ProfileFeedItem profileFeedItem = (ProfileFeedItem) orNull;
        if (profileFeedItem == null) {
            return;
        }
        List<MineFeedImageInfo> c16 = profileFeedItem.c();
        if (!(c16 instanceof Collection) || !c16.isEmpty()) {
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                if (((MineFeedImageInfo) it.next()).getIsVideo()) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        boolean isEmpty = profileFeedItem.c().isEmpty();
        String str = "";
        Object obj = null;
        if (z16) {
            Iterator<T> it5 = profileFeedItem.c().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                MineFeedImageInfo mineFeedImageInfo = (MineFeedImageInfo) next;
                if (mineFeedImageInfo.getUrl().length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19 && mineFeedImageInfo.getIsVideo()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    obj = next;
                    break;
                }
            }
            MineFeedImageInfo mineFeedImageInfo2 = (MineFeedImageInfo) obj;
            if (mineFeedImageInfo2 != null && (url2 = mineFeedImageInfo2.getUrl()) != null) {
                str = url2;
            }
            holder.u(str);
        } else if (isEmpty) {
            holder.s(profileFeedItem);
        } else {
            Iterator<T> it6 = profileFeedItem.c().iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next2 = it6.next();
                MineFeedImageInfo mineFeedImageInfo3 = (MineFeedImageInfo) next2;
                if (mineFeedImageInfo3.getUrl().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && !mineFeedImageInfo3.getIsVideo()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    obj = next2;
                    break;
                }
            }
            MineFeedImageInfo mineFeedImageInfo4 = (MineFeedImageInfo) obj;
            if (mineFeedImageInfo4 != null && (url = mineFeedImageInfo4.getUrl()) != null) {
                str = url;
            }
            holder.t(str);
        }
        Pair<Integer, Integer> m06 = m0();
        holder.n(m06.getFirst().intValue(), m06.getSecond().intValue());
        holder.r(position, this.feedList.size());
        holder.p(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedItemAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function2 function2;
                function2 = GuildProfileFeedItemAdapter.this.itemClickCallback;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(position), profileFeedItem);
                }
                GuildProfileFeedItemAdapter guildProfileFeedItemAdapter = GuildProfileFeedItemAdapter.this;
                Context context = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                guildProfileFeedItemAdapter.r0(context, profileFeedItem);
            }
        });
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        k0(view, profileFeedItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public GuildProfileFeedViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f2k, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new GuildProfileFeedViewHolder(itemView);
    }

    public final void s0(@NotNull ArrayList<ProfileFeedItem> feedItemList) {
        Intrinsics.checkNotNullParameter(feedItemList, "feedItemList");
        if (feedItemList.isEmpty()) {
            return;
        }
        this.feedList.clear();
        int min = Math.min(feedItemList.size(), INSTANCE.a());
        this.feedList.addAll(feedItemList.subList(0, min));
        notifyItemRangeChanged(0, this.feedList.size());
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedItemAdapter", 1, "[setData] feedItemList count " + min);
    }

    public final void t0(@Nullable Function2<? super Integer, ? super ProfileFeedItem, Unit> callback) {
        this.itemClickCallback = callback;
    }
}
