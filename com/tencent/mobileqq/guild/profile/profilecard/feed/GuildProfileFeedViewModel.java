package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.text.SpannableStringBuilder;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import fh1.MineFeedImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u001c\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\u0019j\b\u0012\u0004\u0012\u00020\n`\u001a0\u0016J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R*\u0010)\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\u0019j\b\u0012\u0004\u0012\u00020\n`\u001a0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lwy1/a;", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "", "T1", "S1", "", "feedPBStream", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/g;", "N1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "", "Lfh1/d;", "M1", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "image", "", "isVideoCover", "Q1", "Lcom/tencent/mobileqq/guild/util/cn;", "", "O1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "P1", "R1", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", "i", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildBaseProfileData;", "guildBaseProfileData", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "userProfileInfo", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/util/cn;", "feedCountLiveData", "D", "feedListLiveData", "repository", "<init>", "(Lwy1/a;)V", "E", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFeedViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final cn<String> feedCountLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final cn<ArrayList<ProfileFeedItem>> feedListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildBaseProfileData guildBaseProfileData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ev userProfileInfo;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewModel$Companion;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewModel;", "a", "", "EMOJI_ALIGN", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildProfileFeedViewModel a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return (GuildProfileFeedViewModel) ef1.c.INSTANCE.c(owner, GuildProfileFeedViewModel.class, new Function0<GuildProfileFeedViewModel>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedViewModel$Companion$of$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GuildProfileFeedViewModel invoke() {
                    return new GuildProfileFeedViewModel(new wy1.a());
                }
            });
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFeedViewModel(@NotNull wy1.a repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.feedCountLiveData = new cn<>();
        this.feedListLiveData = new cn<>();
    }

    private final List<MineFeedImageInfo> M1(GProStFeed feed) {
        String joinToString$default;
        MineFeedImageInfo Q1;
        MineFeedImageInfo Q12;
        ArrayList<GProStImage> arrayList = feed.images;
        ArrayList<GProStVideo> arrayList2 = feed.videos;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            GProStImage gProStImage = arrayList.get(i3);
            if (gProStImage.displayIndex == 0 && (Q12 = Q1(gProStImage, false)) != null) {
                arrayList3.add(Q12);
            }
        }
        if (arrayList3.isEmpty()) {
            int size2 = arrayList2.size();
            for (int i16 = 0; i16 < size2; i16++) {
                GProStVideo gProStVideo = arrayList2.get(i16);
                if (gProStVideo.displayIndex == 0 && (Q1 = Q1(gProStVideo.cover, true)) != null) {
                    arrayList3.add(Q1);
                }
            }
        }
        Logger.a d16 = Logger.f235387a.d();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList3, ";", null, null, 0, null, null, 62, null);
        d16.d("Guild.profile.GuildProfileFeedViewModel", 1, "[convertFeedImageInfoList] result " + joinToString$default);
        return arrayList3;
    }

    private final ProfileFeedItem N1(byte[] feedPBStream) {
        GProStFeed convertToStFeedByNT = ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).convertToStFeedByNT(feedPBStream);
        d dVar = d.f231412a;
        ArrayList<GProStRichTextContent> arrayList = convertToStFeedByNT.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "stFeed.contents.contents");
        SpannableStringBuilder c16 = d.c(dVar, arrayList, 1, 0.0f, 4, null);
        int i3 = convertToStFeedByNT.feedType;
        List<MineFeedImageInfo> M1 = M1(convertToStFeedByNT);
        String feedId = convertToStFeedByNT.idd;
        Logger.f235387a.d().i("Guild.profile.GuildProfileFeedViewModel", 1, "covertToFeedItem itemId=" + feedId + " text=" + ((Object) c16) + ", imageList=" + M1.size());
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        return new ProfileFeedItem(feedId, i3, c16, M1, convertToStFeedByNT);
    }

    private final MineFeedImageInfo Q1(GProStImage image, boolean isVideoCover) {
        if (image == null) {
            return null;
        }
        Iterator<GProStImageUrl> it = image.vecImageUrlList.iterator();
        while (it.hasNext()) {
            GProStImageUrl next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "image.vecImageUrlList");
            GProStImageUrl gProStImageUrl = next;
            if (gProStImageUrl.levelType == 2) {
                String str = gProStImageUrl.url;
                Intrinsics.checkNotNullExpressionValue(str, "imageUrl.url");
                return new MineFeedImageInfo(str, isVideoCover, gProStImageUrl.width, gProStImageUrl.height);
            }
        }
        return null;
    }

    private final void S1(GuildProfileData profileData) {
        String str;
        IGProUserPublishedFeedSummary feedSummary = profileData.getFeedSummary();
        if (feedSummary != null) {
            str = feedSummary.getPublishedCountStr();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedViewModel", 1, "[updateFeedCountData] " + str);
        this.feedCountLiveData.postValue(str);
    }

    private final void T1(final GuildProfileData profileData) {
        boolean z16;
        ArrayList<byte[]> feedList;
        IGProUserPublishedFeedSummary feedSummary = profileData.getFeedSummary();
        if (feedSummary != null && (feedList = feedSummary.getFeedList()) != null && (!feedList.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[updateFeedListData] no data ");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.profile.GuildProfileFeedViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildProfileFeedViewModel.U1(GuildProfileData.this, this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildProfileData profileData, GuildProfileFeedViewModel this$0) {
        Intrinsics.checkNotNullParameter(profileData, "$profileData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<ProfileFeedItem> arrayList = new ArrayList<>();
        ArrayList<byte[]> feedList = profileData.getFeedSummary().getFeedList();
        Intrinsics.checkNotNullExpressionValue(feedList, "profileData.feedSummary.feedList");
        ArrayList arrayList2 = new ArrayList();
        for (byte[] it : feedList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ProfileFeedItem N1 = this$0.N1(it);
            if (N1 != null) {
                arrayList2.add(N1);
            }
        }
        arrayList.addAll(arrayList2);
        this$0.feedListLiveData.postValue(arrayList);
    }

    @NotNull
    public final cn<String> O1() {
        return this.feedCountLiveData;
    }

    @NotNull
    public final cn<ArrayList<ProfileFeedItem>> P1() {
        return this.feedListLiveData;
    }

    public final void R1(@NotNull GuildProfileData profileData) {
        Intrinsics.checkNotNullParameter(profileData, "profileData");
        GuildBaseProfileData guildBaseProfileData = profileData.getGuildBaseProfileData();
        Intrinsics.checkNotNullExpressionValue(guildBaseProfileData, "profileData.guildBaseProfileData");
        this.guildBaseProfileData = guildBaseProfileData;
        ev userProfileInfo = profileData.getUserProfileInfo();
        Intrinsics.checkNotNullExpressionValue(userProfileInfo, "profileData.userProfileInfo");
        this.userProfileInfo = userProfileInfo;
        S1(profileData);
        T1(profileData);
    }
}
