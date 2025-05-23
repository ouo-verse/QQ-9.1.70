package hs0;

import android.view.View;
import android.widget.ImageView;
import com.tencent.guildlive.aio.input.component.playtogether.GuildLiveAioPlayTogetherUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lhs0/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/guildlive/aio/input/component/playtogether/GuildLiveAioPlayTogetherUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "", "bindViewAndData", "state", "d1", "Lts0/a;", "d", "Lts0/a;", "liveAIOListener", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPlayTogetherView", "<init>", "(Lts0/a;)V", "f", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<ol3.b, GuildLiveAioPlayTogetherUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mPlayTogetherView;

    public b(@Nullable ts0.a aVar) {
        this.liveAIOListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioPlayTogether", "on click mPlayTogetherView");
        ts0.a aVar = this$0.liveAIOListener;
        if (aVar != null) {
            aVar.w3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        yr0.a.q(this.mPlayTogetherView, "em_sgrp_stream_icon", null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, GuildLiveAioPlayTogetherUIState> createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildLiveAioPlayTogetherUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioPlayTogether", "[handleUIState] " + state);
        if (state instanceof GuildLiveAioPlayTogetherUIState.PlayTogetherUpdate) {
            ImageView imageView = this.mPlayTogetherView;
            if (imageView != null) {
                imageView.setVisibility(((GuildLiveAioPlayTogetherUIState.PlayTogetherUpdate) state).getVisibility());
            }
            ImageView imageView2 = this.mPlayTogetherView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(((GuildLiveAioPlayTogetherUIState.PlayTogetherUpdate) state).getSrcDrawable());
            }
            yr0.a.o("imp", this.mPlayTogetherView, null, 4, null);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ImageView imageView = (ImageView) createViewParams.b().findViewById(R.id.vxz);
        this.mPlayTogetherView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: hs0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.e1(b.this, view);
                }
            });
        }
        ImageView imageView2 = this.mPlayTogetherView;
        Intrinsics.checkNotNull(imageView2);
        return imageView2;
    }
}
