package gs0;

import android.view.View;
import com.tencent.guildlive.aio.input.component.gift.GuildLiveAioGiftUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.ScanningView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lgs0/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/guildlive/aio/input/component/gift/GuildLiveAioGiftUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "", "bindViewAndData", "state", "d1", "Lts0/a;", "d", "Lts0/a;", "liveAIOListener", "e", "Landroid/view/View;", "mGiftView", "Lcom/tencent/mobileqq/guild/widget/ScanningView;", "f", "Lcom/tencent/mobileqq/guild/widget/ScanningView;", "mScanningView", "<init>", "(Lts0/a;)V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<ol3.b, GuildLiveAioGiftUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mGiftView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScanningView mScanningView;

    public b(@Nullable ts0.a aVar) {
        this.liveAIOListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioGiftViewBinder", "on click mGiftView");
        ts0.a aVar = this$0.liveAIOListener;
        if (aVar != null) {
            aVar.wf();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        yr0.a.q(this.mGiftView, "em_sgrp_aio_gifts", null, 4, null);
        yr0.a.o("imp", this.mGiftView, null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, GuildLiveAioGiftUIState> createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildLiveAioGiftUIState state) {
        ScanningView scanningView;
        Intrinsics.checkNotNullParameter(state, "state");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioGiftViewBinder", "[handleUIState] " + state);
        if (state instanceof GuildLiveAioGiftUIState.GiftVisibleChange) {
            View view = this.mGiftView;
            if (view != null) {
                view.setVisibility(((GuildLiveAioGiftUIState.GiftVisibleChange) state).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
            }
            if (((GuildLiveAioGiftUIState.GiftVisibleChange) state).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String() == 0 && (scanningView = this.mScanningView) != null) {
                scanningView.e();
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.mGiftView = createViewParams.b().findViewById(R.id.wmi);
        this.mScanningView = (ScanningView) createViewParams.b().findViewById(R.id.f79734_k);
        View view = this.mGiftView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: gs0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.e1(b.this, view2);
                }
            });
        }
        View view2 = this.mGiftView;
        Intrinsics.checkNotNull(view2);
        return view2;
    }
}
