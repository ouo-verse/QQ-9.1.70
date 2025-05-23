package com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed;

import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0002\u000f\u0016BH\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\b0\u0012\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R/\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureAsyncWorkManager;", "", "Ljava/lang/Runnable;", h.F, "", "forceEnd", "", "from", "", "g", "f", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureAsyncWorkManager$b;", "data", "k", "", "a", "Ljava/util/List;", "remoteResImageDataList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "b", "Lkotlin/jvm/functions/Function1;", "onWorksOk", "c", "Z", "hasReturn", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/h;", "d", "Ljava/util/Set;", "remoteImageAdapters", "e", "Lkotlin/Lazy;", "j", "()Ljava/lang/Runnable;", "forceReturnRunnable", "", "maxWaitTime", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "textViewContainer", "<init>", "(JLcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLongFeedPictureAsyncWorkManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ImageRemoteResData> remoteResImageDataList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> onWorksOk;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasReturn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h> remoteImageAdapters;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy forceReturnRunnable;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureAsyncWorkManager$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageRemoteResData f220339e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ GuildLongFeedPictureAsyncWorkManager f220340f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ImageRemoteResData imageRemoteResData, GuildLongFeedPictureAsyncWorkManager guildLongFeedPictureAsyncWorkManager) {
            super(false);
            this.f220339e = imageRemoteResData;
            this.f220340f = guildLongFeedPictureAsyncWorkManager;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            if (state == LoadState.STATE_SUCCESS) {
                this.f220339e.d(true);
                this.f220340f.g(false, "loadImageRemoteRes data" + this.f220339e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildLongFeedPictureAsyncWorkManager(long j3, @NotNull TextViewContainer textViewContainer, @NotNull List<ImageRemoteResData> remoteResImageDataList, @NotNull Function1<? super Boolean, Unit> onWorksOk) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(textViewContainer, "textViewContainer");
        Intrinsics.checkNotNullParameter(remoteResImageDataList, "remoteResImageDataList");
        Intrinsics.checkNotNullParameter(onWorksOk, "onWorksOk");
        this.remoteResImageDataList = remoteResImageDataList;
        this.onWorksOk = onWorksOk;
        this.remoteImageAdapters = new LinkedHashSet();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Runnable>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureAsyncWorkManager$forceReturnRunnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Runnable invoke() {
                Runnable h16;
                h16 = GuildLongFeedPictureAsyncWorkManager.this.h();
                return h16;
            }
        });
        this.forceReturnRunnable = lazy;
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> r16 = textViewContainer.r();
        Intrinsics.checkNotNullExpressionValue(r16, "textViewContainer.richTextSpans");
        Iterator<T> it = r16.iterator();
        while (it.hasNext()) {
            final g i3 = ((com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c) it.next()).i();
            if (i3 instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h) {
                this.remoteImageAdapters.add(i3);
                ((com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h) i3).a(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureAsyncWorkManager$1$1
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
                        GuildLongFeedPictureAsyncWorkManager.this.g(false, "viewAdapter:" + i3);
                    }
                });
            }
        }
        Iterator<T> it5 = this.remoteResImageDataList.iterator();
        while (it5.hasNext()) {
            k((ImageRemoteResData) it5.next());
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildLongFeedPictureAsyncWorkManager", 1, "start remoteImageAdapters:" + this.remoteImageAdapters.size() + " remoteResImageDataList:" + this.remoteResImageDataList.size());
        }
        kotlin.Function0.b((int) j3, j());
    }

    private final boolean f() {
        for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.h hVar : this.remoteImageAdapters) {
            if (!hVar.getHadImageLoaded()) {
                Logger logger = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger.d().d("GuildLongFeedPictureAsyncWorkManager", 1, "remoteImageAdapter not ok id:" + lr1.a.a(hVar) + " " + hVar);
                }
                return false;
            }
        }
        for (ImageRemoteResData imageRemoteResData : this.remoteResImageDataList) {
            if (!imageRemoteResData.getBindResOK()) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger2.d().d("GuildLongFeedPictureAsyncWorkManager", 1, "remoteResImageData not ok:" + imageRemoteResData);
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean forceEnd, String from) {
        if (this.hasReturn) {
            return;
        }
        boolean f16 = f();
        if (forceEnd) {
            Logger.f235387a.d().a("GuildLongFeedPictureAsyncWorkManager", 1, "checkAsyncWorksOk forceEnd allIsOK:" + f16 + " from:" + from);
            this.hasReturn = true;
            this.onWorksOk.invoke(Boolean.valueOf(f16));
            return;
        }
        if (!f16) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("GuildLongFeedPictureAsyncWorkManager", 1, "checkAsyncWorksOk notOK from:" + from);
                return;
            }
            return;
        }
        Logger.f235387a.d().a("GuildLongFeedPictureAsyncWorkManager", 1, "checkAsyncWorksOk OK from:" + from);
        this.hasReturn = true;
        kotlin.Function0.c(j());
        this.onWorksOk.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable h() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildLongFeedPictureAsyncWorkManager.i(GuildLongFeedPictureAsyncWorkManager.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildLongFeedPictureAsyncWorkManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(true, "createForceDelayRunnable");
    }

    private final Runnable j() {
        return (Runnable) this.forceReturnRunnable.getValue();
    }

    private final void k(ImageRemoteResData data) {
        e.a().f(v.d(data.getRemotePicUrl(), data.getImageView(), null, null, 12, null).setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a), new c(data, this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureAsyncWorkManager$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", "imageView", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "remotePicUrl", "getTag", "tag", "d", "Z", "()Z", "(Z)V", "bindResOK", "<init>", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureAsyncWorkManager$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ImageRemoteResData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ImageView imageView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String remotePicUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tag;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean bindResOK;

        public ImageRemoteResData(@NotNull ImageView imageView, @NotNull String remotePicUrl, @NotNull String tag, boolean z16) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(remotePicUrl, "remotePicUrl");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.imageView = imageView;
            this.remotePicUrl = remotePicUrl;
            this.tag = tag;
            this.bindResOK = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getBindResOK() {
            return this.bindResOK;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getRemotePicUrl() {
            return this.remotePicUrl;
        }

        public final void d(boolean z16) {
            this.bindResOK = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageRemoteResData)) {
                return false;
            }
            ImageRemoteResData imageRemoteResData = (ImageRemoteResData) other;
            if (Intrinsics.areEqual(this.imageView, imageRemoteResData.imageView) && Intrinsics.areEqual(this.remotePicUrl, imageRemoteResData.remotePicUrl) && Intrinsics.areEqual(this.tag, imageRemoteResData.tag) && this.bindResOK == imageRemoteResData.bindResOK) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.imageView.hashCode() * 31) + this.remotePicUrl.hashCode()) * 31) + this.tag.hashCode()) * 31;
            boolean z16 = this.bindResOK;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "ImageRemoteResData(imageView=" + this.imageView + ", remotePicUrl=" + this.remotePicUrl + ", tag=" + this.tag + ", bindResOK=" + this.bindResOK + ")";
        }

        public /* synthetic */ ImageRemoteResData(ImageView imageView, String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageView, str, str2, (i3 & 8) != 0 ? false : z16);
        }
    }
}
