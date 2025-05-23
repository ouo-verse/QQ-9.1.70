package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$dataReportManage$2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;
import wk1.h;
import wk1.l;
import yl1.n;

@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0007\u001a\u00020\u00028VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$inputContextProvider$1", "Lwk1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "a", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/BottomGuideBarDelegateDefaultImpl;", "guildBarDependency", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getFeedId", "()Ljava/lang/String;", "feedId", "getGuildId", "guildId", "getChannelId", "channelId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "()Ljava/util/concurrent/ConcurrentHashMap;", "extDataMap", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "Lwk1/f;", "f", "()Lwk1/f;", "feedLikeManage", "Lwk1/e;", "c", "()Lwk1/e;", "dataReportManage", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BottomInteractivePart$inputContextProvider$1 implements wk1.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildBarDependency;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BottomInteractivePart f220623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BottomInteractivePart$inputContextProvider$1(BottomInteractivePart bottomInteractivePart) {
        Lazy lazy;
        this.f220623b = bottomInteractivePart;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BottomInteractivePart$inputContextProvider$1$guildBarDependency$2(this, bottomInteractivePart));
        this.guildBarDependency = lazy;
    }

    @Override // wk1.h
    @NotNull
    public ConcurrentHashMap<String, Object> a() {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        GuildFeedPublishInfo q16 = n.q(GuildSplitViewUtils.f235370a.h(this.f220623b.getPartHost()));
        if (q16 != null) {
            concurrentHashMap.put("Feed_Publish_Info", q16);
        }
        return concurrentHashMap;
    }

    @Override // wk1.h
    @NotNull
    public wk1.e c() {
        BottomInteractivePart$dataReportManage$2.a E9;
        E9 = this.f220623b.E9();
        return E9;
    }

    @Override // wk1.h
    @Nullable
    public InputStyleConfig d() {
        return h.a.a(this);
    }

    @Override // wk1.h
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BottomGuideBarDelegateDefaultImpl b() {
        return (BottomGuideBarDelegateDefaultImpl) this.guildBarDependency.getValue();
    }

    @Override // wk1.h
    @NotNull
    public wk1.f f() {
        return new com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f();
    }

    @Override // wk1.h
    @NotNull
    public String getChannelId() {
        String str;
        str = this.f220623b.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            return null;
        }
        return str;
    }

    @Override // wk1.h
    @NotNull
    public Context getContext() {
        Context context = this.f220623b.getContext();
        if (context == null) {
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            return context2;
        }
        return context;
    }

    @Override // wk1.h
    @NotNull
    public wk1.i getDelegate() {
        l G9;
        G9 = this.f220623b.G9();
        return G9;
    }

    @Override // wk1.h
    @NotNull
    public String getFeedId() {
        String str;
        str = this.f220623b.feedId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            return null;
        }
        return str;
    }

    @Override // wk1.h
    @NotNull
    public String getGuildId() {
        String str;
        str = this.f220623b.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            return null;
        }
        return str;
    }
}
