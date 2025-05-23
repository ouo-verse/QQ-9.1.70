package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.util.Supplier;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$dataReportManage$2;
import com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$inputMessageDelegate$2;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;

@Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$generateInputContextProvider$1", "Lwk1/h;", "Lwk1/a;", "a", "Lwk1/a;", "b", "()Lwk1/a;", "guildBarDependency", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getFeedId", "()Ljava/lang/String;", "feedId", "getGuildId", "guildId", "getChannelId", "channelId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "()Ljava/util/concurrent/ConcurrentHashMap;", "extDataMap", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "Lwk1/m;", "d", "()Lwk1/m;", "inputStyleConfig", "Lwk1/f;", "f", "()Lwk1/f;", "feedLikeManage", "Lwk1/e;", "c", "()Lwk1/e;", "dataReportManage", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBottomPresenter$generateInputContextProvider$1 implements wk1.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.a guildBarDependency;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GuildFeedGalleryBottomPresenter f219718b;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryBottomPresenter$generateInputContextProvider$1$a", "Lcom/tencent/mobileqq/guild/data/s;", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements s {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildFeedGalleryBottomPresenter f219719d;

        a(GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter) {
            this.f219719d = guildFeedGalleryBottomPresenter;
        }

        @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
        @NotNull
        public String getChannelId() {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean;
            String str;
            guildFeedGalleryInitBean = this.f219719d.initBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getChannelId();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }

        @Override // com.tencent.mobileqq.guild.data.s, com.tencent.mobileqq.guild.data.r
        @NotNull
        public String getGuildId() {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean;
            String str;
            guildFeedGalleryInitBean = this.f219719d.initBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getGuildId();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildFeedGalleryBottomPresenter$generateInputContextProvider$1(final GuildFeedGalleryBottomPresenter guildFeedGalleryBottomPresenter) {
        final MutableLiveData mutableLiveData;
        this.f219718b = guildFeedGalleryBottomPresenter;
        final Context context = getContext();
        final a aVar = new a(guildFeedGalleryBottomPresenter);
        final Supplier supplier = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.h
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Integer i3;
                i3 = GuildFeedGalleryBottomPresenter$generateInputContextProvider$1.i(GuildFeedGalleryBottomPresenter.this);
                return i3;
            }
        };
        final Supplier supplier2 = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.i
            @Override // androidx.core.util.Supplier
            public final Object get() {
                JumpGuildParam.JoinInfoParam j3;
                j3 = GuildFeedGalleryBottomPresenter$generateInputContextProvider$1.j(GuildFeedGalleryBottomPresenter.this);
                return j3;
            }
        };
        final Supplier supplier3 = new Supplier() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.j
            @Override // androidx.core.util.Supplier
            public final Object get() {
                String k3;
                k3 = GuildFeedGalleryBottomPresenter$generateInputContextProvider$1.k(GuildFeedGalleryBottomPresenter.this);
                return k3;
            }
        };
        mutableLiveData = guildFeedGalleryBottomPresenter.simpleLifecycleOwner;
        BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl = new BottomGuideBarDelegateDefaultImpl(guildFeedGalleryBottomPresenter, context, aVar, supplier, supplier2, supplier3, mutableLiveData) { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$generateInputContextProvider$1$guildBarDependency$1

            /* renamed from: N, reason: from kotlin metadata */
            @NotNull
            private final Lazy colorConfig;

            /* renamed from: P, reason: from kotlin metadata */
            @NotNull
            private final Lazy reportDelegate;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(context, aVar, supplier, supplier2, supplier3, mutableLiveData, false);
                Lazy lazy;
                Lazy lazy2;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<int[]>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$generateInputContextProvider$1$guildBarDependency$1$colorConfig$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final int[] invoke() {
                        ViewGroup viewGroup;
                        viewGroup = GuildFeedGalleryBottomPresenter.this.inputRootView;
                        if (viewGroup == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("inputRootView");
                            viewGroup = null;
                        }
                        int color = ContextCompat.getColor(viewGroup.getContext(), R.color.qui_common_text_allwhite_secondary);
                        return new int[]{color, color};
                    }
                });
                this.colorConfig = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<co1.k>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryBottomPresenter$generateInputContextProvider$1$guildBarDependency$1$reportDelegate$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final co1.k invoke() {
                        co1.k X;
                        X = GuildFeedGalleryBottomPresenter.this.X();
                        return X;
                    }
                });
                this.reportDelegate = lazy2;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl, wk1.a
            @NotNull
            public int[] b() {
                return (int[]) this.colorConfig.getValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl, wk1.a
            @NotNull
            public co1.k e() {
                return (co1.k) this.reportDelegate.getValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl, wk1.a
            public boolean h() {
                return tl1.e.f436522a.a(true)[2];
            }
        };
        guildFeedGalleryBottomPresenter.guideBarDependencyRef = bottomGuideBarDelegateDefaultImpl;
        this.guildBarDependency = bottomGuideBarDelegateDefaultImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer i(GuildFeedGalleryBottomPresenter this$0) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        guildFeedGalleryInitBean = this$0.initBean;
        if (guildFeedGalleryInitBean != null) {
            i3 = guildFeedGalleryInitBean.getBusinessType();
        } else {
            i3 = 0;
        }
        return Integer.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JumpGuildParam.JoinInfoParam j(GuildFeedGalleryBottomPresenter this$0) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        guildFeedGalleryInitBean = this$0.initBean;
        JumpGuildParam.JoinInfoParam joinInfoParam = null;
        if (guildFeedGalleryInitBean == null) {
            return null;
        }
        JumpGuildParam.JoinInfoParam joinInfoParam2 = guildFeedGalleryInitBean.getJoinInfoParam();
        if (joinInfoParam2 != null) {
            Intrinsics.checkNotNullExpressionValue(joinInfoParam2, "joinInfoParam");
            if (joinInfoParam2.isValid()) {
                joinInfoParam = joinInfoParam2;
            }
            if (joinInfoParam != null) {
                return joinInfoParam;
            }
        }
        return new JumpGuildParam.JoinInfoParam(String.valueOf(guildFeedGalleryInitBean.getFeed().channelInfo.sign.channelId), guildFeedGalleryInitBean.getFeed().channelInfo.sign.joinGuildSig, "immersive_feed", "others");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(GuildFeedGalleryBottomPresenter this$0) {
        String e06;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e06 = this$0.e0();
        return e06;
    }

    @Override // wk1.h
    @NotNull
    public ConcurrentHashMap<String, Object> a() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        guildFeedGalleryInitBean = this.f219718b.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        GuildFeedPublishInfo guildFeedPublishInfo = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
        if (guildFeedPublishInfo != null) {
            concurrentHashMap.put("Feed_Publish_Info", guildFeedPublishInfo);
        }
        return concurrentHashMap;
    }

    @Override // wk1.h
    @NotNull
    /* renamed from: b, reason: from getter */
    public wk1.a getGuildBarDependency() {
        return this.guildBarDependency;
    }

    @Override // wk1.h
    @NotNull
    public wk1.e c() {
        GuildFeedGalleryBottomPresenter$dataReportManage$2.a d06;
        d06 = this.f219718b.d0();
        return d06;
    }

    @Override // wk1.h
    @NotNull
    public InputStyleConfig d() {
        InputStyleConfig g06;
        g06 = this.f219718b.g0();
        return g06;
    }

    @Override // wk1.h
    @Nullable
    public wk1.f f() {
        com.tencent.mobileqq.guild.feed.gallery.part.s sVar = (com.tencent.mobileqq.guild.feed.gallery.part.s) this.f219718b.e(com.tencent.mobileqq.guild.feed.gallery.part.s.class);
        if (sVar != null) {
            return sVar.f();
        }
        return null;
    }

    @Override // wk1.h
    @NotNull
    public String getChannelId() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        guildFeedGalleryInitBean = this.f219718b.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        String channelId = guildFeedGalleryInitBean.getChannelId();
        if (channelId == null) {
            return "";
        }
        return channelId;
    }

    @Override // wk1.h
    @NotNull
    public Context getContext() {
        Context context = this.f219718b.f219734i.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        return context;
    }

    @Override // wk1.h
    @NotNull
    public wk1.i getDelegate() {
        GuildFeedGalleryBottomPresenter$inputMessageDelegate$2.a f06;
        f06 = this.f219718b.f0();
        return f06;
    }

    @Override // wk1.h
    @NotNull
    public String getFeedId() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        guildFeedGalleryInitBean = this.f219718b.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        String feedId = guildFeedGalleryInitBean.getFeedId();
        if (feedId == null) {
            return "";
        }
        return feedId;
    }

    @Override // wk1.h
    @NotNull
    public String getGuildId() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        guildFeedGalleryInitBean = this.f219718b.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        String guildId = guildFeedGalleryInitBean.getGuildId();
        if (guildId == null) {
            return "";
        }
        return guildId;
    }
}
