package com.tencent.mobileqq.guild.feed.feedsection.fragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
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
public final class FeedSectionSecondaryListFragment$sectionInfoLiveData$2 extends Lambda implements Function0<LiveData<l>> {
    final /* synthetic */ FeedSectionSecondaryListFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<I, O> implements Function {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareInitBean f218637a;

        public a(GuildFeedSquareInitBean guildFeedSquareInitBean) {
            this.f218637a = guildFeedSquareInitBean;
        }

        @Override // androidx.arch.core.util.Function
        public final l apply(Integer num) {
            String str;
            String str2;
            int i3;
            GuildFeedSquareInitBean guildFeedSquareInitBean = this.f218637a;
            String str3 = null;
            if (guildFeedSquareInitBean != null) {
                str = guildFeedSquareInitBean.getGuildId();
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "bean?.guildId ?: \"\"");
            }
            GuildFeedSquareInitBean guildFeedSquareInitBean2 = this.f218637a;
            if (guildFeedSquareInitBean2 != null) {
                str2 = guildFeedSquareInitBean2.getChannelId();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "bean?.channelId ?: \"\"");
            }
            GuildFeedSquareInitBean guildFeedSquareInitBean3 = this.f218637a;
            if (guildFeedSquareInitBean3 != null) {
                str3 = guildFeedSquareInitBean3.getChannelName();
            }
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "bean?.channelName ?: \"\"");
                str4 = str3;
            }
            av avVar = av.f223852a;
            GuildFeedSquareInitBean guildFeedSquareInitBean4 = this.f218637a;
            if (guildFeedSquareInitBean4 != null) {
                i3 = guildFeedSquareInitBean4.getBusinessType();
            } else {
                i3 = 15;
            }
            return new l(new SectionInfo(str2, str, str4, avVar.g(i3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSectionSecondaryListFragment$sectionInfoLiveData$2(FeedSectionSecondaryListFragment feedSectionSecondaryListFragment) {
        super(0);
        this.this$0 = feedSectionSecondaryListFragment;
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
        GuildFeedSquareInitBean Ah;
        com.tencent.mobileqq.guild.home.subhome.a Ch;
        LiveData<l> liveData;
        MutableLiveData<Integer> N1;
        Ah = this.this$0.Ah();
        Ch = this.this$0.Ch();
        if (Ch == null || (N1 = Ch.N1()) == null) {
            liveData = null;
        } else {
            liveData = Transformations.map(N1, new a(Ah));
            Intrinsics.checkNotNullExpressionValue(liveData, "crossinline f: (X) -> Y)\u2026ap(this) { f.invoke(it) }");
        }
        if (liveData == null) {
            QLog.e("FeedSection.SecondaryListFragment", 1, "[initSectionInfo]: sourceLiveData is null");
        }
        if (liveData == null) {
            return null;
        }
        LifecycleOwner lifecycleOwner = this.this$0.getLifecycleOwner();
        final FeedSectionSecondaryListFragment$sectionInfoLiveData$2$3$1 feedSectionSecondaryListFragment$sectionInfoLiveData$2$3$1 = new Function1<l, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment$sectionInfoLiveData$2$3$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(l lVar) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }
        };
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionSecondaryListFragment$sectionInfoLiveData$2.b(Function1.this, obj);
            }
        });
        return liveData;
    }
}
