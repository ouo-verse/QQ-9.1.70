package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCard;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreloadGuildFeedsCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002\r\u0011B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate;", "", "", "r", "p", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsRsp;", "rsp", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "a", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$b;", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$b;", "depends", "", "c", "J", "cdDuration", "", "d", "[B", "token", "e", "lastNewFeedPostTime", "", "f", "Z", "isTaskRunIng", "g", "lastTaskRunTime", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$b;)V", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNewFeedPostDelegate {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long cdDuration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] token;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastNewFeedPostTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTaskRunIng;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastTaskRunTime;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "", "b", "Lij1/g;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull ij1.g data) {
            GProRecommendCard gProRecommendCard;
            Intrinsics.checkNotNullParameter(data, "data");
            GProStFeed b16 = data.b();
            if (b16 == null || (gProRecommendCard = b16.recommendCard) == null || gProRecommendCard.cardType != 5) {
                return false;
            }
            return true;
        }

        public final boolean b(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.mainType == 6) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J+\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$b;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsReq;", "req", "", "c", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsRsp;", "rsp", "b", "(ILjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsRsp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        boolean a(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data);

        @Nullable
        Object b(int i3, @NotNull String str, @NotNull GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp, @NotNull Continuation<? super Unit> continuation);

        void c(@NotNull GProPreloadGuildFeedsReq req);
    }

    public GuildNewFeedPostDelegate(@NotNull LifecycleOwner lifecycleOwner, @NotNull b depends) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.lifecycleOwner = lifecycleOwner;
        this.depends = depends;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(GProPreloadGuildFeedsRsp rsp) {
        this.cdDuration = rsp.cdDuration * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(GProPreloadGuildFeedsRsp rsp) {
        this.token = rsp.token;
    }

    private final void p() {
        GProPreloadGuildFeedsReq gProPreloadGuildFeedsReq = new GProPreloadGuildFeedsReq();
        this.depends.c(gProPreloadGuildFeedsReq);
        byte[] bArr = this.token;
        if (bArr != null) {
            gProPreloadGuildFeedsReq.token = bArr;
        }
        Logger.f235387a.d().i("GuildNewFeedPostDelegate", 1, "preloadGuildFeeds token:" + gProPreloadGuildFeedsReq.token.hashCode() + " req:" + gProPreloadGuildFeedsReq);
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.preloadGuildFeeds(gProPreloadGuildFeedsReq, new IGProPreloadGuildFeedsCallback() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.m
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProPreloadGuildFeedsCallback
                public final void onResult(int i3, String str, GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp) {
                    GuildNewFeedPostDelegate.q(GuildNewFeedPostDelegate.this, currentTimeMillis, i3, str, gProPreloadGuildFeedsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GuildNewFeedPostDelegate this$0, long j3, int i3, String str, GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp) {
        Integer num;
        ArrayList<GProStFeed> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        if (gProPreloadGuildFeedsRsp != null && (arrayList = gProPreloadGuildFeedsRsp.stfeedList) != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        d16.i("GuildNewFeedPostDelegate", 1, "preloadGuildFeeds rsp result:" + i3 + " errMsg:" + str + " size:" + num);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0.lifecycleOwner), null, null, new GuildNewFeedPostDelegate$preloadGuildFeeds$3$2(gProPreloadGuildFeedsRsp, this$0, j3, i3, str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (this.isTaskRunIng) {
            Logger.f235387a.d().i("GuildNewFeedPostDelegate", 1, "runTask isTaskRunIng");
            return;
        }
        this.isTaskRunIng = true;
        long currentTimeMillis = System.currentTimeMillis() - this.lastTaskRunTime;
        long j3 = this.cdDuration;
        if (currentTimeMillis > j3) {
            j3 = 0;
        } else if (currentTimeMillis >= 0) {
            j3 -= currentTimeMillis;
        }
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildNewFeedPostDelegate.s(GuildNewFeedPostDelegate.this);
            }
        }, j3, true);
        Logger.f235387a.d().i("GuildNewFeedPostDelegate", 1, "runTask lastTaskRunTime:" + this.lastTaskRunTime + " delayTime:" + j3 + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GuildNewFeedPostDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    public final void m(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildNewFeedPostDelegate", 1, "handleFeedNewPost data:" + data);
        }
        if (!this.depends.a(data)) {
            if (QLog.isColorLevel()) {
                logger.d().d("GuildNewFeedPostDelegate", 1, "handleFeedNewPost not needHandlerPush");
            }
        } else {
            this.lastNewFeedPostTime = System.currentTimeMillis();
            r();
        }
    }
}
