package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uo0.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ2\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J%\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\f*\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/PostPermissionCheckFuns;", "", "Lan1/b;", "partSearch", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/PostPermissionCheckFuns$a;", "continuation", "", "channelId", "guildId", "Luo0/k$a;", "g", "", "isHiddenChannelPassed", "search", "i", "e", "isAllowPostToHiddenChannel", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", WadlProxyConsts.CHANNEL, "d", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;)Z", "isVisible", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PostPermissionCheckFuns {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PostPermissionCheckFuns f222320a = new PostPermissionCheckFuns();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/PostPermissionCheckFuns$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "canPost", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "hiddenChannelId", "c", "isRequiredToSelectNotHiddenChannel", "d", "isThereAnySpeakableNotHiddenChannel", "e", "f", "isVisibleChannel", "isTroopGuild", "<init>", "(ZLjava/lang/String;ZZZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.utils.PostPermissionCheckFuns$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CheckSpeakablePermissionResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean canPost;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String hiddenChannelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isRequiredToSelectNotHiddenChannel;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isThereAnySpeakableNotHiddenChannel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isVisibleChannel;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isTroopGuild;

        public CheckSpeakablePermissionResult(boolean z16, @NotNull String hiddenChannelId, boolean z17, boolean z18, boolean z19, boolean z26) {
            Intrinsics.checkNotNullParameter(hiddenChannelId, "hiddenChannelId");
            this.canPost = z16;
            this.hiddenChannelId = hiddenChannelId;
            this.isRequiredToSelectNotHiddenChannel = z17;
            this.isThereAnySpeakableNotHiddenChannel = z18;
            this.isVisibleChannel = z19;
            this.isTroopGuild = z26;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanPost() {
            return this.canPost;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getHiddenChannelId() {
            return this.hiddenChannelId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsRequiredToSelectNotHiddenChannel() {
            return this.isRequiredToSelectNotHiddenChannel;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsThereAnySpeakableNotHiddenChannel() {
            return this.isThereAnySpeakableNotHiddenChannel;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsTroopGuild() {
            return this.isTroopGuild;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckSpeakablePermissionResult)) {
                return false;
            }
            CheckSpeakablePermissionResult checkSpeakablePermissionResult = (CheckSpeakablePermissionResult) other;
            if (this.canPost == checkSpeakablePermissionResult.canPost && Intrinsics.areEqual(this.hiddenChannelId, checkSpeakablePermissionResult.hiddenChannelId) && this.isRequiredToSelectNotHiddenChannel == checkSpeakablePermissionResult.isRequiredToSelectNotHiddenChannel && this.isThereAnySpeakableNotHiddenChannel == checkSpeakablePermissionResult.isThereAnySpeakableNotHiddenChannel && this.isVisibleChannel == checkSpeakablePermissionResult.isVisibleChannel && this.isTroopGuild == checkSpeakablePermissionResult.isTroopGuild) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsVisibleChannel() {
            return this.isVisibleChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        public int hashCode() {
            boolean z16 = this.canPost;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode = ((r06 * 31) + this.hiddenChannelId.hashCode()) * 31;
            ?? r26 = this.isRequiredToSelectNotHiddenChannel;
            int i16 = r26;
            if (r26 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            ?? r27 = this.isThereAnySpeakableNotHiddenChannel;
            int i18 = r27;
            if (r27 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            ?? r28 = this.isVisibleChannel;
            int i26 = r28;
            if (r28 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z17 = this.isTroopGuild;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            return "CheckSpeakablePermissionResult(canPost=" + this.canPost + ", hiddenChannelId=" + this.hiddenChannelId + ", isRequiredToSelectNotHiddenChannel=" + this.isRequiredToSelectNotHiddenChannel + ", isThereAnySpeakableNotHiddenChannel=" + this.isThereAnySpeakableNotHiddenChannel + ", isVisibleChannel=" + this.isVisibleChannel + ", isTroopGuild=" + this.isTroopGuild + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Luo0/k;", "kotlin.jvm.PlatformType", "search", "Lcom/tencent/guild/aio/input/at/quickAt/search/SearchException;", "error", "", "a", "(Luo0/k;Lcom/tencent/guild/aio/input/at/quickAt/search/SearchException;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements k.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k.a f222327a;

        b(k.a aVar) {
            this.f222327a = aVar;
        }

        @Override // uo0.k.a
        public final void a(uo0.k kVar, SearchException searchException) {
            k.a aVar = this.f222327a;
            if (aVar != null) {
                aVar.a(kVar, searchException);
            }
        }
    }

    PostPermissionCheckFuns() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r7.getSpeakPermission() == 1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if (r7.getMySpeakPermissionType() == 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r6 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean d(String guildId, boolean isHiddenChannelPassed, boolean isAllowPostToHiddenChannel, IGProChannel channel) {
        if (ch.j0(guildId)) {
            if (GuildFeedPublishUtils.f222315a.w(guildId)) {
                if (isHiddenChannelPassed) {
                }
                if (channel.getVisibleType() == 1) {
                }
            }
            return false;
        }
        if (isHiddenChannelPassed) {
            return isAllowPostToHiddenChannel;
        }
    }

    private final boolean e(an1.b search) {
        boolean z16;
        List<IGProChannel> i3 = search.i();
        Intrinsics.checkNotNullExpressionValue(i3, "search.result");
        List<IGProChannel> list = i3;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (IGProChannel iGProChannel : list) {
            if (yl1.i.f450608a.j(iGProChannel.getHiddenPostChannel()) && iGProChannel.getMySpeakPermissionType() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(IGProChannel iGProChannel) {
        if (iGProChannel.getVisibleType() == 1 || iGProChannel.getVisibleType() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.tencent.mobileqq.guild.feed.nativepublish.utils.q] */
    public final k.a g(final an1.b partSearch, final CancellableContinuation<? super CheckSpeakablePermissionResult> continuation, final String channelId, final String guildId) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new k.a() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.q
            @Override // uo0.k.a
            public final void a(uo0.k kVar, SearchException searchException) {
                PostPermissionCheckFuns.h(Ref.ObjectRef.this, partSearch, continuation, channelId, guildId, kVar, searchException);
            }
        };
        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.PostPermissionCheckFuns$prepareSearchResultHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                objectRef.element = null;
            }
        });
        return (k.a) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.ObjectRef handler, an1.b partSearch, CancellableContinuation continuation, String channelId, String guildId, uo0.k search, SearchException searchException) {
        Long longOrNull;
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(handler, "$handler");
        Intrinsics.checkNotNullParameter(partSearch, "$partSearch");
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        IGProChannel iGProChannel = null;
        handler.element = null;
        if (search == partSearch) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(channelId);
            an1.b bVar = (an1.b) search;
            List<IGProChannel> i3 = bVar.i();
            Intrinsics.checkNotNullExpressionValue(i3, "search.result");
            Iterator<T> it = i3.iterator();
            while (true) {
                z16 = false;
                if (it.hasNext()) {
                    obj = it.next();
                    long channelId2 = ((IGProChannel) obj).getChannelId();
                    if (longOrNull != null && channelId2 == longOrNull.longValue()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProChannel iGProChannel2 = (IGProChannel) obj;
            if (iGProChannel2 != null) {
                z16 = yl1.i.f450608a.k(iGProChannel2.getHiddenPostChannel());
                iGProChannel = iGProChannel2;
            }
            PostPermissionCheckFuns postPermissionCheckFuns = f222320a;
            Intrinsics.checkNotNullExpressionValue(search, "search");
            String i16 = postPermissionCheckFuns.i(z16, channelId, bVar);
            if (iGProChannel == null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new CheckSpeakablePermissionResult(false, i16, false, postPermissionCheckFuns.e(bVar), false, false)));
                return;
            } else {
                boolean d16 = postPermissionCheckFuns.d(guildId, z16, true, iGProChannel);
                Result.Companion companion2 = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new CheckSpeakablePermissionResult(d16, i16, false, postPermissionCheckFuns.e(bVar), postPermissionCheckFuns.f(iGProChannel), false)));
                return;
            }
        }
        continuation.resumeWith(Result.m476constructorimpl(null));
    }

    private final String i(boolean isHiddenChannelPassed, String channelId, an1.b search) {
        Object obj;
        String l3;
        if (!isHiddenChannelPassed) {
            List<IGProChannel> i3 = search.i();
            Intrinsics.checkNotNullExpressionValue(i3, "search.result");
            Iterator<T> it = i3.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (yl1.i.f450608a.k(((IGProChannel) obj).getHiddenPostChannel())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProChannel iGProChannel = (IGProChannel) obj;
            if (iGProChannel == null || (l3 = Long.valueOf(iGProChannel.getChannelId()).toString()) == null) {
                return "";
            }
            return l3;
        }
        return channelId;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super CheckSpeakablePermissionResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!GuildInfoManager.q().P(str2)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            AppRuntime Q0 = ch.Q0();
            if (Q0 == null) {
                QLog.e("PostPermissionCheckFuns", 1, "peekAppRuntime is null");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            } else {
                an1.b bVar = new an1.b(Q0, str);
                bVar.n(new b(f222320a.g(bVar, cancellableContinuationImpl, str2, str)));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return new CheckSpeakablePermissionResult(true, "", false, false, true, true);
    }
}
