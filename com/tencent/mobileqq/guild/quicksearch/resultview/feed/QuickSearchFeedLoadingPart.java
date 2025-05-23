package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.loading.GuildSearchSkeletonLoadingView;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedLoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/quicksearch/loading/GuildSearchSkeletonLoadingView;", "e", "Lcom/tencent/mobileqq/guild/quicksearch/loading/GuildSearchSkeletonLoadingView;", "z9", "()Lcom/tencent/mobileqq/guild/quicksearch/loading/GuildSearchSkeletonLoadingView;", "B9", "(Lcom/tencent/mobileqq/guild/quicksearch/loading/GuildSearchSkeletonLoadingView;)V", "loadingView", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedLoadingPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public GuildSearchSkeletonLoadingView loadingView;

    public QuickSearchFeedLoadingPart(@NotNull QuickSearchViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void B9(@NotNull GuildSearchSkeletonLoadingView guildSearchSkeletonLoadingView) {
        Intrinsics.checkNotNullParameter(guildSearchSkeletonLoadingView, "<set-?>");
        this.loadingView = guildSearchSkeletonLoadingView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.wzl);
        GuildSearchSkeletonLoadingView guildSearchSkeletonLoadingView = (GuildSearchSkeletonLoadingView) findViewById;
        guildSearchSkeletonLoadingView.d(2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Gu\u2026e.FEED)\n                }");
        B9(guildSearchSkeletonLoadingView);
        LiveData<Integer> g26 = this.viewModel.g2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedLoadingPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 1) {
                    QuickSearchFeedLoadingPart.this.z9().e();
                } else {
                    QuickSearchFeedLoadingPart.this.z9().b();
                }
            }
        };
        g26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedLoadingPart.A9(Function1.this, obj);
            }
        });
    }

    @NotNull
    public final GuildSearchSkeletonLoadingView z9() {
        GuildSearchSkeletonLoadingView guildSearchSkeletonLoadingView = this.loadingView;
        if (guildSearchSkeletonLoadingView != null) {
            return guildSearchSkeletonLoadingView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        return null;
    }
}
