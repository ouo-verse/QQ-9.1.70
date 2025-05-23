package nn0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.guild.aio.article.title.navigate.GuildArticleTitleNavigateUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nn0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00150\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006'"}, d2 = {"Lnn0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lnn0/a;", "Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState;", "", "h1", "e1", "", "summary", "d1", "", "visibility", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "g1", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mNavigateMainMsgLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mNavigateMainMsgView", "f", "mMainMsgSummaryView", "<init>", "()V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildArticleTitleNavigateUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mNavigateMainMsgLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mNavigateMainMsgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMainMsgSummaryView;

    private final void d1(String summary) {
        TextView textView = this.mMainMsgSummaryView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainMsgSummaryView");
            textView = null;
        }
        textView.setText(new QQText(summary, 3, 16));
    }

    private final void e1() {
        sendIntent(new a.C10852a());
    }

    private final void f1(int visibility) {
        RelativeLayout relativeLayout = this.mNavigateMainMsgLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            relativeLayout = null;
        }
        if (relativeLayout.getVisibility() == 4 && visibility == 0) {
            RelativeLayout relativeLayout3 = this.mNavigateMainMsgLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.animate().cancel();
            RelativeLayout relativeLayout4 = this.mNavigateMainMsgLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(visibility);
            RelativeLayout relativeLayout5 = this.mNavigateMainMsgLayout;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
                relativeLayout5 = null;
            }
            relativeLayout5.setAlpha(0.0f);
            RelativeLayout relativeLayout6 = this.mNavigateMainMsgLayout;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            } else {
                relativeLayout2 = relativeLayout6;
            }
            relativeLayout2.animate().alphaBy(1.0f).setDuration(300L).start();
            return;
        }
        RelativeLayout relativeLayout7 = this.mNavigateMainMsgLayout;
        if (relativeLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            relativeLayout7 = null;
        }
        if (relativeLayout7.getVisibility() == 0 && visibility == 4) {
            RelativeLayout relativeLayout8 = this.mNavigateMainMsgLayout;
            if (relativeLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
                relativeLayout8 = null;
            }
            relativeLayout8.animate().cancel();
            RelativeLayout relativeLayout9 = this.mNavigateMainMsgLayout;
            if (relativeLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            } else {
                relativeLayout2 = relativeLayout9;
            }
            relativeLayout2.setVisibility(visibility);
        }
    }

    private final void h1() {
        TextView textView = this.mNavigateMainMsgView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: nn0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i1(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildArticleTitleNavigateUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildArticleTitleNavigateUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildArticleTitleNavigateUIState.MainMsgSummaryUIState) {
            d1(((GuildArticleTitleNavigateUIState.MainMsgSummaryUIState) state).getSummary());
        } else if (state instanceof GuildArticleTitleNavigateUIState.ShowNavigateUIState) {
            f1(((GuildArticleTitleNavigateUIState.ShowNavigateUIState) state).getVisibility());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildArticleTitleNavigateUIState>> getObserverStates() {
        List<Class<? extends GuildArticleTitleNavigateUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildArticleTitleNavigateUIState.MainMsgSummaryUIState.class, GuildArticleTitleNavigateUIState.ShowNavigateUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.zmg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026yId(R.id.navigate_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.mNavigateMainMsgLayout = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            relativeLayout = null;
        }
        View findViewById2 = relativeLayout.findViewById(R.id.zmh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mNavigateMainMsgLayout.f\u2026ewById(R.id.navigate_msg)");
        this.mNavigateMainMsgView = (TextView) findViewById2;
        RelativeLayout relativeLayout2 = this.mNavigateMainMsgLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            relativeLayout2 = null;
        }
        View findViewById3 = relativeLayout2.findViewById(R.id.ywg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mNavigateMainMsgLayout.f\u2026Id(R.id.main_msg_summary)");
        this.mMainMsgSummaryView = (TextView) findViewById3;
        RelativeLayout relativeLayout3 = this.mNavigateMainMsgLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(4);
        RelativeLayout relativeLayout4 = this.mNavigateMainMsgLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNavigateMainMsgLayout");
            return null;
        }
        return relativeLayout4;
    }
}
