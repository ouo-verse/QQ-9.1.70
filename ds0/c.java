package ds0;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.guild.aio.chosen.title.g;
import com.tencent.guild.aio.title.GuildAioTitleTextUIState;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guildlive.aio.excellentdetail.title.AnnounceDetailMoreIconVisible;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lds0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", "h1", "f1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lds0/d;", "d1", "bindViewAndData", "state", "g1", "Lz12/a;", "d", "Lz12/a;", "mBinding", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private z12.a mBinding;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394744a;

        static {
            int[] iArr = new int[IGuildAioTitleUIState.TYPE.values().length];
            try {
                iArr[IGuildAioTitleUIState.TYPE.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.BACKBTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.EMPTY_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f394744a = iArr;
        }
    }

    private final void e1() {
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) mContext).onBackPressed();
    }

    private final void f1() {
        sendIntent(new g.a());
    }

    private final void h1() {
        sendIntent(new g.b());
        z12.a aVar = this.mBinding;
        z12.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f451728d.setOnClickListener(new View.OnClickListener() { // from class: ds0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i1(c.this, view);
            }
        });
        z12.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f451727c.setOnClickListener(new View.OnClickListener() { // from class: ds0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.j1(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new c.l());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public d createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull IGuildAioTitleUIState state) {
        c cVar;
        Intrinsics.checkNotNullParameter(state, "state");
        z12.a aVar = null;
        if (!state.getResult()) {
            cVar = this;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return;
        }
        int i3 = a.f394744a[state.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    AnnounceDetailMoreIconVisible announceDetailMoreIconVisible = (AnnounceDetailMoreIconVisible) state;
                    z12.a aVar2 = this.mBinding;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        aVar = aVar2;
                    }
                    yr0.a.s(aVar.f451727c, announceDetailMoreIconVisible.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
                    return;
                }
                return;
            }
            e1();
            return;
        }
        GuildAioTitleTextUIState guildAioTitleTextUIState = (GuildAioTitleTextUIState) state;
        z12.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar3;
        }
        aVar.f451729e.setText(guildAioTitleTextUIState.getName());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        z12.a g16 = z12.a.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }
}
