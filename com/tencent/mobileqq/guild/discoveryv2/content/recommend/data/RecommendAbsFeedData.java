package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEntry;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExtra;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPBusinessCard;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichText;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00104\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\r\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\n \b*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J-\u0010\u0013\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00120\u0012H\u0096\u0001J\u0011\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00140\u0014H\u0096\u0001J\u0011\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\u0011\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u001c\u001a\n \b*\u0004\u0018\u00010\u001b0\u001bH\u0096\u0001J\u0011\u0010\u001e\u001a\n \b*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J-\u0010 \u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001f0\u001f \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u001f0\u001f\u0018\u00010\u00120\u0012H\u0096\u0001J\u0011\u0010!\u001a\n \b*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J-\u0010$\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010#0# \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010#0#\u0018\u00010\u00120\u0012H\u0096\u0001J\u000e\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020&2\u0006\u0010(\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020&J\u0006\u0010-\u001a\u00020\u0003J\u0010\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0016J\u0012\u00103\u001a\u0004\u0018\u0001022\u0006\u0010/\u001a\u00020.H\u0016R\u0017\u00104\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010B\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "", "a", "", "getAuditStatus", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPBusinessCard;", "kotlin.jvm.PlatformType", "getBusinessCard", "", "getCreateTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProImage;", "getCustomCover", "getFeedContentType", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedStat;", "getFeedStat", "getFeedType", "Ljava/util/ArrayList;", "getFunctionList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "getGuildInfo", "", "getIdd", "getImage", "getLastModifiedTime", "getNeedWebview", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPoster;", "getPoster", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichText;", "getRichText", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "getTags", "getTitle", "getTotalImageCount", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVideo;", "getVideos", "stat", "", "setUpVoteStatus", "count", "setUpVoteCount", "getUpVoteStatus", "getUpVoteCount", "notifyChanged", "isInsertSign", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "mUpVoteStatus", "I", "mUpVoteCount", "J", "mNeedNotify", "Z", "mInsertSign$delegate", "Lkotlin/Lazy;", "b", "()Z", "mInsertSign", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class RecommendAbsFeedData implements l<IGProContentRecommendFeed>, IGProContentRecommendFeed {

    /* renamed from: mInsertSign$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInsertSign;
    private boolean mNeedNotify;
    private long mUpVoteCount;
    private int mUpVoteStatus;

    @NotNull
    private final IGProContentRecommendFeed recommendItem;

    public RecommendAbsFeedData(@NotNull IGProContentRecommendFeed recommendItem) {
        Lazy lazy;
        int i3;
        long j3;
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        this.recommendItem = recommendItem;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData$mInsertSign$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean a16;
                a16 = RecommendAbsFeedData.this.a();
                return Boolean.valueOf(a16);
            }
        });
        this.mInsertSign = lazy;
        IGProFeedStat feedStat = getFeedStat();
        if (feedStat != null) {
            i3 = feedStat.getPreferStatus();
        } else {
            i3 = 0;
        }
        this.mUpVoteStatus = i3;
        IGProFeedStat feedStat2 = getFeedStat();
        if (feedStat2 != null) {
            j3 = feedStat2.getPreferCount();
        } else {
            j3 = 0;
        }
        this.mUpVoteCount = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[LOOP:0: B:8:0x001c->B:21:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        ArrayList<IGProEntry> reports;
        boolean z16;
        IGProExtra gProExtra = getRecommendExtData().getGProExtra();
        if (gProExtra == null || (reports = gProExtra.getReports()) == null || reports.isEmpty()) {
            return false;
        }
        for (IGProEntry iGProEntry : reports) {
            if (Intrinsics.areEqual("forceSetTop", iGProEntry.getKey())) {
                byte[] value = iGProEntry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                if (Intrinsics.areEqual("true", new String(value, Charsets.UTF_8))) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return false;
    }

    private final boolean b() {
        return ((Boolean) this.mInsertSign.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof RecommendAbsFeedData)) {
            return true;
        }
        if (!this.mNeedNotify) {
            RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) newItem;
            if (getMUpVoteStatus() == recommendAbsFeedData.getMUpVoteStatus() && getMUpVoteCount() == recommendAbsFeedData.getMUpVoteCount()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof RecommendAbsFeedData)) {
            return false;
        }
        RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) newItem;
        if (!Intrinsics.areEqual(getIdd() + getRecommendExtData().getIndex(), recommendAbsFeedData.getIdd() + recommendAbsFeedData.getRecommendExtData().getIndex()) || getLastModifiedTime() != recommendAbsFeedData.getLastModifiedTime()) {
            return false;
        }
        if (getRecommendExtData().getIndex() >= 1 && getItemId() != newItem.getItemId()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getAuditStatus() {
        return this.recommendItem.getAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProMVPBusinessCard getBusinessCard() {
        return this.recommendItem.getBusinessCard();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof RecommendAbsFeedData) {
            if (!this.mNeedNotify) {
                RecommendAbsFeedData recommendAbsFeedData = (RecommendAbsFeedData) newItem;
                if (getMUpVoteStatus() == recommendAbsFeedData.getMUpVoteStatus() && getMUpVoteCount() == recommendAbsFeedData.getMUpVoteCount()) {
                    return null;
                }
            }
            this.mNeedNotify = false;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boolean.TRUE);
            return arrayListOf;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public long getCreateTime() {
        return this.recommendItem.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProImage getCustomCover() {
        return this.recommendItem.getCustomCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getFeedContentType() {
        return this.recommendItem.getFeedContentType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProFeedStat getFeedStat() {
        return this.recommendItem.getFeedStat();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getFeedType() {
        return this.recommendItem.getFeedType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<Integer> getFunctionList() {
        return this.recommendItem.getFunctionList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProFeedGuildInfo getGuildInfo() {
        return this.recommendItem.getGuildInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public String getIdd() {
        return this.recommendItem.getIdd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProImage getImage() {
        return this.recommendItem.getImage();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public abstract /* synthetic */ int getItemType();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public long getLastModifiedTime() {
        return this.recommendItem.getLastModifiedTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public boolean getNeedWebview() {
        return this.recommendItem.getNeedWebview();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProPoster getPoster() {
        return this.recommendItem.getPoster();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public abstract /* synthetic */ RecommendExtData getRecommendExtData();

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    public /* bridge */ /* synthetic */ IGProContentRecommendFeed getRecommendItem() {
        return this.recommendItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public IGProMVPRichText getRichText() {
        return this.recommendItem.getRichText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<IGProGuildLabel> getTags() {
        return this.recommendItem.getTags();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public String getTitle() {
        return this.recommendItem.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public int getTotalImageCount() {
        return this.recommendItem.getTotalImageCount();
    }

    /* renamed from: getUpVoteCount, reason: from getter */
    public final long getMUpVoteCount() {
        return this.mUpVoteCount;
    }

    /* renamed from: getUpVoteStatus, reason: from getter */
    public final int getMUpVoteStatus() {
        return this.mUpVoteStatus;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed
    public ArrayList<IGProVideo> getVideos() {
        return this.recommendItem.getVideos();
    }

    public final boolean isInsertSign() {
        return b();
    }

    public final void notifyChanged() {
        this.mNeedNotify = true;
    }

    public final void setUpVoteCount(long count) {
        this.mUpVoteCount = count;
    }

    public final void setUpVoteStatus(int stat) {
        this.mUpVoteStatus = stat;
        if (stat == 1) {
            this.mUpVoteCount++;
            return;
        }
        long j3 = this.mUpVoteCount;
        if (j3 > 0) {
            this.mUpVoteCount = j3 - 1;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public final IGProContentRecommendFeed getRecommendItem() {
        return this.recommendItem;
    }
}
