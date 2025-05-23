package com.tencent.mobileqq.guild.feed.feedsquare.fragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "invoke", "()Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2 extends Lambda implements Function0<LiveData<l>> {
    final /* synthetic */ GuildFeedSquareSectionFragmentHome this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<I, O> implements Function {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInitBean f218865a;

        public a(GuildFeedSquareInitBean guildFeedSquareInitBean) {
            this.f218865a = guildFeedSquareInitBean;
        }

        @Override // androidx.arch.core.util.Function
        public final l apply(Integer num) {
            int intValue = num.intValue();
            String guildId = this.f218865a.getGuildId();
            String channelId = this.f218865a.getChannelId();
            String str = GuildHomeSubFeedFragment.INSTANCE.b().get(Integer.valueOf(intValue));
            if (str == null) {
                str = "";
            }
            av avVar = av.f223852a;
            int g16 = avVar.g(avVar.b(intValue));
            Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            return new l(new SectionInfo(channelId, guildId, str, g16));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2(GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome) {
        super(0);
        this.this$0 = guildFeedSquareSectionFragmentHome;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final LiveData<l> invoke() {
        GuildFeedSquareInitBean guildFeedSquareInitBean;
        mp1.b Dh;
        LiveData<l> liveData;
        com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel;
        LiveData<Integer> O1;
        guildFeedSquareInitBean = this.this$0.mInitBean;
        if (guildFeedSquareInitBean != null) {
            Dh = this.this$0.Dh();
            if (Dh == null || (guildSubTabPageViewModel = Dh.getGuildSubTabPageViewModel()) == null || (O1 = guildSubTabPageViewModel.O1()) == null) {
                liveData = null;
            } else {
                liveData = Transformations.map(O1, new a(guildFeedSquareInitBean));
                Intrinsics.checkNotNullExpressionValue(liveData, "crossinline f: (X) -> Y)\u2026ap(this) { f.invoke(it) }");
            }
            if (liveData == null) {
                QLog.e("GuildFeedSquareSectionFragmentHome", 1, "[initSectionInfo]: sourceLiveData is null");
            }
            if (liveData == null) {
                return null;
            }
            LifecycleOwner lifecycleOwner = this.this$0.getLifecycleOwner();
            final GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2$3$1 guildFeedSquareSectionFragmentHome$sectionInfoLiveData$2$3$1 = new Function1<l, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2$3$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(l lVar) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(l lVar) {
                    invoke2(lVar);
                    return Unit.INSTANCE;
                }
            };
            liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2.b(Function1.this, obj);
                }
            });
            return liveData;
        }
        QLog.e("GuildFeedSquareSectionFragmentHome", 1, "[initSectionInfo]: initBean is null");
        return null;
    }
}
