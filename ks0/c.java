package ks0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fo0.e;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import tl.h;
import z12.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u00170\u0016H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lks0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "isSelectMode", "", "f1", "show", "k1", "h1", "", "count", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "d1", "state", "g1", "", "Ljava/lang/Class;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "getObserverStates", "Lz12/f;", "d", "Lz12/f;", "mBinding", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mAioSelectToBottomTv", "f", "Landroid/view/View;", "mMultiLayout", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<e, InputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private f mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mAioSelectToBottomTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mMultiLayout;

    private final void e1(int count) {
        String string = getMContext().getString(R.string.f139520bh);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026ild_aio_select_msg_count)");
        TextView textView = this.mAioSelectToBottomTv;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioSelectToBottomTv");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    private final void f1(boolean isSelectMode) {
        GuildLiveLogUtil.INSTANCE.e("GLAioInputMSVB", "[handleMultiSelectModeChanged] isSelectMode = " + isSelectMode);
        k1(isSelectMode);
        e1(1);
    }

    private final void h1() {
        f fVar = this.mBinding;
        View view = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fVar = null;
        }
        View inflate = fVar.f451761b.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "mBinding.vsMultiLayout.inflate()");
        this.mMultiLayout = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.l9j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mMultiLayout.findViewByI\u2026.aio_select_to_buttom_tv)");
        this.mAioSelectToBottomTv = (TextView) findViewById;
        View view2 = this.mMultiLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            view2 = null;
        }
        view2.findViewById(R.id.vyd).setOnClickListener(new View.OnClickListener() { // from class: ks0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                c.i1(c.this, view3);
            }
        });
        View view3 = this.mMultiLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
        } else {
            view = view3;
        }
        view.findViewById(R.id.vye).setOnClickListener(new View.OnClickListener() { // from class: ks0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                c.j1(c.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.h.f400143d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.j.f400145d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k1(boolean show) {
        if (this.mMultiLayout == null) {
            h1();
        }
        View view = this.mMultiLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            view = null;
        }
        yr0.a.s(view, show);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, InputUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildLiveAioInputUIState.GuildMultiSelectState) {
            f1(((GuildLiveAioInputUIState.GuildMultiSelectState) state).getShow());
        } else if (state instanceof GuildLiveAioInputUIState.MultiSelectCountChanged) {
            e1(((GuildLiveAioInputUIState.MultiSelectCountChanged) state).getCount());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildLiveAioInputUIState>> getObserverStates() {
        List<Class<? extends GuildLiveAioInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildLiveAioInputUIState.GuildMultiSelectState.class, GuildLiveAioInputUIState.MultiSelectCountChanged.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        f g16 = f.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            inf\u2026          false\n        )");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        ViewStub root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }
}
