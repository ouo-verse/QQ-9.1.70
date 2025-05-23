package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import bk1.a;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareHeaderAdapterWorker;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareInviteAdapterWorker;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListAdapterWorker;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedListPartMorePanelCooperateHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR0\u0010(\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020!0 0\u001f8\u0016X\u0096\u0004\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/l;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareListAdapterWorker;", "J", "Lcom/tencent/biz/richframework/part/Part;", "part", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "", "q7", "Lak1/a;", "partApi", "M2", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate$a;", "args", HippyTKDListViewAdapter.X, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper;", "L", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper;", "morePanelLauncherIoc", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareHeaderAdapterWorker;", "M", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareHeaderAdapterWorker;", "headerWorker", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareInviteAdapterWorker;", "N", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareInviteAdapterWorker;", "inviteAdapterWorker", "", "Lbk1/a$a;", "", "P", "[Lbk1/a$a;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()[Lbk1/a$a;", "getWorkers$annotations", "()V", "workers", "Landroidx/lifecycle/LiveData;", "", "sortMode", "<init>", "(Landroidx/lifecycle/LiveData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends FeedSectionListPartDelegate {

    /* renamed from: L, reason: from kotlin metadata */
    private FeedListPartMorePanelCooperateHelper morePanelLauncherIoc;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final FeedSquareHeaderAdapterWorker headerWorker;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final FeedSquareInviteAdapterWorker inviteAdapterWorker;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final a.AbstractC0131a<?, Object>[] workers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull LiveData<Integer> sortMode) {
        super("FeedSquareListPartDelegate", sortMode);
        Intrinsics.checkNotNullParameter(sortMode, "sortMode");
        FeedSquareHeaderAdapterWorker feedSquareHeaderAdapterWorker = new FeedSquareHeaderAdapterWorker();
        this.headerWorker = feedSquareHeaderAdapterWorker;
        FeedSquareInviteAdapterWorker feedSquareInviteAdapterWorker = new FeedSquareInviteAdapterWorker();
        this.inviteAdapterWorker = feedSquareInviteAdapterWorker;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(feedSquareHeaderAdapterWorker);
        spreadBuilder.add(feedSquareInviteAdapterWorker);
        spreadBuilder.addSpread(super.a2());
        this.workers = (a.AbstractC0131a[]) spreadBuilder.toArray(new a.AbstractC0131a[spreadBuilder.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String K(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b sectionContext) {
        Intrinsics.checkNotNullParameter(sectionContext, "$sectionContext");
        String a16 = co1.e.a(sectionContext.getVmApi());
        if (a16 == null) {
            return "";
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate
    @NotNull
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public FeedSquareListAdapterWorker o() {
        return new FeedSquareListAdapterWorker(getTag());
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    public void M2(@NotNull Part part, @NotNull ak1.a partApi) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(partApi, "partApi");
        super.M2(part, partApi);
        this.headerWorker.h(partApi);
        this.inviteAdapterWorker.h(partApi);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    @NotNull
    public a.AbstractC0131a<?, Object>[] a2() {
        return this.workers;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(r(), zp1.a.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    public void q7(@NotNull Part part, @NotNull final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> sectionContext) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(sectionContext, "sectionContext");
        super.q7(part, sectionContext);
        C(part);
        FeedListPartMorePanelCooperateHelper feedListPartMorePanelCooperateHelper = new FeedListPartMorePanelCooperateHelper(part, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.k
            @Override // androidx.core.util.Supplier
            public final Object get() {
                String K;
                K = l.K(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b.this);
                return K;
            }
        });
        PartIOCKt.registerIoc(part, feedListPartMorePanelCooperateHelper, zp1.a.class);
        com.tencent.mobileqq.guild.feed.part.a.c(part).getLifecycle().addObserver(feedListPartMorePanelCooperateHelper);
        this.morePanelLauncherIoc = feedListPartMorePanelCooperateHelper;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate
    @NotNull
    protected FeedSectionListPartDelegate.a x(@NotNull FeedSectionListPartDelegate.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(r());
        if (b16 != null) {
            String string = b16.getString("guild_feed_list_top_feed_id");
            String str = "";
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(GUILD_FEED_LIST_TOP_FEED_ID) ?: \"\"");
            }
            args.j(string);
            String string2 = b16.getString("guild_feed_list_top_channel_id");
            if (string2 == null) {
                string2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(GUILD_FEED_LIST_TOP_CHANNEL_ID) ?: \"\"");
            }
            args.i(string2);
            args.k(b16.getInt("guild_feed_list_top_type"));
            String string3 = b16.getString("guild_feed_list_top_business");
            if (string3 != null) {
                Intrinsics.checkNotNullExpressionValue(string3, "it.getString(GUILD_FEED_LIST_TOP_BUSINESS) ?: \"\"");
                str = string3;
            }
            args.h(str);
            b16.remove("guild_feed_list_top_type");
            b16.remove("guild_feed_list_top_business");
            b16.remove("guild_feed_list_top_feed_id");
        }
        return args;
    }
}
