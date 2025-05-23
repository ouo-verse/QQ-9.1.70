package mn0;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.guild.aio.article.title.action.GuildArticleTitleActionUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mn0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lmn0/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "", "l1", "h1", "g1", "f1", "", "isMultiMode", "j1", ViewStickEventHelper.IS_SHOW, "i1", "p1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "k1", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mActionMoreView", "e", "mActionCloseView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mActionCancelView", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, TitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mActionMoreView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mActionCloseView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mActionCancelView;

    private final void f1() {
        sendIntent(new a.C10796a());
    }

    private final void g1() {
        sendIntent(new a.b());
    }

    private final void h1() {
        IGuildFastClickUtilApi iGuildFastClickUtilApi = (IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class);
        ImageView imageView = this.mActionMoreView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            imageView = null;
        }
        if (iGuildFastClickUtilApi.isFastClick(imageView)) {
            return;
        }
        sendIntent(new a.c());
    }

    private final void i1(boolean isShow) {
        ImageView imageView = null;
        if (isShow) {
            ImageView imageView2 = this.mActionMoreView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.mActionMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void j1(boolean isMultiMode) {
        TextView textView = null;
        if (isMultiMode) {
            ImageView imageView = this.mActionMoreView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
                imageView = null;
            }
            imageView.setVisibility(8);
            ImageView imageView2 = this.mActionCloseView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionCloseView");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            TextView textView2 = this.mActionCancelView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActionCancelView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.mActionMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mActionCloseView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCloseView");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        TextView textView3 = this.mActionCancelView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCancelView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    private final void l1() {
        ImageView imageView = this.mActionMoreView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: mn0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.m1(e.this, view);
            }
        });
        ImageView imageView2 = this.mActionCloseView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCloseView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: mn0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.n1(e.this, view);
            }
        });
        TextView textView2 = this.mActionCancelView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCancelView");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: mn0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.o1(e.this, view);
            }
        });
        ImageView imageView3 = this.mActionMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.mActionCloseView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCloseView");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        TextView textView3 = this.mActionCancelView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCancelView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p1() {
        ImageView imageView = this.mActionMoreView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionMoreView");
            imageView = null;
        }
        Context mContext = getMContext();
        sq0.a aVar = sq0.a.f434200a;
        imageView.setImageDrawable(GuildUIUtils.w(mContext, R.drawable.guild_articlemsg_more_icon, Integer.valueOf(aVar.a())));
        ImageView imageView3 = this.mActionCloseView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActionCloseView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.guild_articlemsg_close_icon, Integer.valueOf(aVar.a())));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        l1();
        p1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, TitleUIState> getViewModel() {
        return new g();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends TitleUIState>> getObserverStates() {
        List<Class<? extends TitleUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildArticleTitleActionUIState.GuildAIOTitleMultiUIState.class, GuildArticleTitleActionUIState.GuildArticleMoreUIState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TitleUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildArticleTitleActionUIState.GuildAIOTitleMultiUIState) {
            j1(((GuildArticleTitleActionUIState.GuildAIOTitleMultiUIState) state).getIsMultiMode());
        } else if (state instanceof GuildArticleTitleActionUIState.GuildArticleMoreUIState) {
            i1(((GuildArticleTitleActionUIState.GuildArticleMoreUIState) state).getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout actionLayout = (FrameLayout) createViewParams.b().findViewById(R.id.f163922cf);
        View findViewById = actionLayout.findViewById(R.id.s9l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "actionLayout.findViewById(R.id.action_more)");
        this.mActionMoreView = (ImageView) findViewById;
        View findViewById2 = actionLayout.findViewById(R.id.s99);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "actionLayout.findViewById(R.id.action_close)");
        this.mActionCloseView = (ImageView) findViewById2;
        View findViewById3 = actionLayout.findViewById(R.id.s98);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "actionLayout.findViewById(R.id.action_cancel)");
        this.mActionCancelView = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(actionLayout, "actionLayout");
        return actionLayout;
    }
}
