package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.util.ad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/ad;", "", "Lcom/tencent/mobileqq/guild/feed/util/ad$a;", "args", "", "f", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ad f223828a = new ad();

    ad() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final FeedDeleteArgs args, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(args, "$args");
        com.tencent.qqnt.kernel.api.o c16 = l.c();
        if (c16 != null) {
            GProStDelFeedReq gProStDelFeedReq = new GProStDelFeedReq();
            GProStFeed gProStFeed = new GProStFeed();
            gProStFeed.idd = args.getFeedId();
            gProStFeed.poster.idd = args.getPosterId();
            gProStFeed.createTime = args.getCreateTime();
            gProStFeed.channelInfo.sign.guildId = args.getGuildId();
            gProStFeed.channelInfo.sign.channelId = args.getChannelId();
            gProStDelFeedReq.feed = gProStFeed;
            gProStDelFeedReq.src = 0;
            c16.delFeed(gProStDelFeedReq, new IGProDelFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.util.ab
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDelFeedCallback
                public final void onResult(int i16, String str, GProStDelFeedRsp gProStDelFeedRsp) {
                    ad.h(ad.FeedDeleteArgs.this, i16, str, gProStDelFeedRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final FeedDeleteArgs args, final int i3, final String str, GProStDelFeedRsp gProStDelFeedRsp) {
        Intrinsics.checkNotNullParameter(args, "$args");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.i(i3, str, args);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String str, FeedDeleteArgs args) {
        Function0<Unit> d16;
        boolean z16;
        Intrinsics.checkNotNullParameter(args, "$args");
        boolean z17 = true;
        if (i3 != 0) {
            if (i3 != 700100) {
                z16 = false;
            } else {
                str = args.getContext().getString(R.string.f143940nf);
                z16 = true;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, str, 0).show();
            z17 = z16;
        } else {
            com.tencent.mobileqq.guild.util.qqui.g.f(2, "\u5220\u9664\u6210\u529f");
        }
        if (z17 && (d16 = args.d()) != null) {
            d16.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FeedDeleteArgs args, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(args, "$args");
        Function0<Unit> e16 = args.e();
        if (e16 != null) {
            e16.invoke();
        }
    }

    public final void f(@NotNull final FeedDeleteArgs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (yl1.n.d(false, 0, 3, null)) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(args.getContext(), 230, (String) null, args.getContext().getString(R.string.f145550rs), args.getContext().getString(R.string.cancel), args.getContext().getString(R.string.ajx), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ad.g(ad.FeedDeleteArgs.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ad.j(dialogInterface, i3);
            }
        });
        createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.feed.util.aa
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ad.k(ad.FeedDeleteArgs.this, dialogInterface);
            }
        });
        createCustomDialog.show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\u0016\u0010\"R\u001f\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010!\u001a\u0004\b\u001b\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/ad$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "", "J", "g", "()J", "guildId", "c", "channelId", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "feedId", "e", tl.h.F, "posterId", WadlProxyConsts.CREATE_TIME, "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "delFinishListener", "dismissListener", "<init>", "(Landroid/content/Context;JJLjava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.ad$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedDeleteArgs {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long guildId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long channelId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String posterId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long createTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Function0<Unit> delFinishListener;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Function0<Unit> dismissListener;

        public FeedDeleteArgs(@NotNull Context context, long j3, long j16, @NotNull String feedId, @NotNull String posterId, long j17, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(posterId, "posterId");
            this.context = context;
            this.guildId = j3;
            this.channelId = j16;
            this.feedId = feedId;
            this.posterId = posterId;
            this.createTime = j17;
            this.delFinishListener = function0;
            this.dismissListener = function02;
        }

        /* renamed from: a, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: c, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        @Nullable
        public final Function0<Unit> d() {
            return this.delFinishListener;
        }

        @Nullable
        public final Function0<Unit> e() {
            return this.dismissListener;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedDeleteArgs)) {
                return false;
            }
            FeedDeleteArgs feedDeleteArgs = (FeedDeleteArgs) other;
            if (Intrinsics.areEqual(this.context, feedDeleteArgs.context) && this.guildId == feedDeleteArgs.guildId && this.channelId == feedDeleteArgs.channelId && Intrinsics.areEqual(this.feedId, feedDeleteArgs.feedId) && Intrinsics.areEqual(this.posterId, feedDeleteArgs.posterId) && this.createTime == feedDeleteArgs.createTime && Intrinsics.areEqual(this.delFinishListener, feedDeleteArgs.delFinishListener) && Intrinsics.areEqual(this.dismissListener, feedDeleteArgs.dismissListener)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: g, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getPosterId() {
            return this.posterId;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((((this.context.hashCode() * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.feedId.hashCode()) * 31) + this.posterId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31;
            Function0<Unit> function0 = this.delFinishListener;
            int i3 = 0;
            if (function0 == null) {
                hashCode = 0;
            } else {
                hashCode = function0.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            Function0<Unit> function02 = this.dismissListener;
            if (function02 != null) {
                i3 = function02.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "FeedDeleteArgs(context=" + this.context + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", posterId=" + this.posterId + ", createTime=" + this.createTime + ", delFinishListener=" + this.delFinishListener + ", dismissListener=" + this.dismissListener + ")";
        }

        public /* synthetic */ FeedDeleteArgs(Context context, long j3, long j16, String str, String str2, long j17, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16, str, str2, j17, (i3 & 64) != 0 ? null : function0, (i3 & 128) != 0 ? null : function02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface, int i3) {
    }
}
