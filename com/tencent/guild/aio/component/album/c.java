package com.tencent.guild.aio.component.album;

import android.view.View;
import android.widget.LinearLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.guild.aio.component.album.GuildAioAlbumUIState;
import com.tencent.guild.aio.component.album.a;
import com.tencent.guild.aio.util.d;
import com.tencent.guild.widgets.RedDotImageView;
import com.tencent.mobileqq.R;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001a0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/component/album/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/album/a;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "", WidgetCacheConstellationData.NUM, "", "i1", "", "panelShowing", "h1", "d1", "isFunctionOn", "j1", "Landroid/view/View;", "v", "g1", "Lcom/tencent/mvi/api/help/a;", "params", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "state", "e1", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mAlbumLayout", "Lcom/tencent/guild/widgets/RedDotImageView;", "e", "Lcom/tencent/guild/widgets/RedDotImageView;", "mAlbumIcon", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildAioAlbumUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAlbumLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RedDotImageView mAlbumIcon;

    private final int d1(boolean panelShowing) {
        if (panelShowing) {
            return R.drawable.qui_image_aio_oversized_icon_aio_toolbar_active;
        }
        return R.drawable.qui_image_aio_oversized_icon_aio_toolbar_normal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(c this$0, View view) {
        com.tencent.aio.api.runtime.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        boolean z16 = false;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && d.a(aVar)) {
            z16 = true;
        }
        if (!z16) {
            RedDotImageView redDotImageView = this$0.mAlbumIcon;
            if (redDotImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumIcon");
                redDotImageView = null;
            }
            this$0.g1(redDotImageView);
            this$0.sendIntent(new a.C1179a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_aio_plus_pic");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    private final void h1(boolean panelShowing) {
        RedDotImageView redDotImageView = this.mAlbumIcon;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumIcon");
            redDotImageView = null;
        }
        redDotImageView.setImageResource(d1(panelShowing));
    }

    private final void i1(int num) {
        RedDotImageView redDotImageView = this.mAlbumIcon;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumIcon");
            redDotImageView = null;
        }
        redDotImageView.setUnreadNumber(num);
    }

    private final void j1(boolean isFunctionOn) {
        LinearLayout linearLayout = null;
        if (isFunctionOn) {
            LinearLayout linearLayout2 = this.mAlbumLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumLayout");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setAlpha(1.0f);
            return;
        }
        LinearLayout linearLayout3 = this.mAlbumLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setAlpha(0.5f);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(new a.b());
        h1(false);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioAlbumUIState> getViewModel() {
        return new GuildAioAlbumViewModel();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioAlbumUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioAlbumUIState.AlbumPanelState) {
            h1(((GuildAioAlbumUIState.AlbumPanelState) state).getIsShowing());
        } else if (state instanceof GuildAioAlbumUIState.AlbumNumState) {
            i1(((GuildAioAlbumUIState.AlbumNumState) state).getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.NUM java.lang.String());
        } else if (state instanceof GuildAioAlbumUIState.AlbumSafetySwitch) {
            j1(((GuildAioAlbumUIState.AlbumSafetySwitch) state).getIsFunctionOn());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioAlbumUIState>> getObserverStates() {
        List<Class<? extends GuildAioAlbumUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAioAlbumUIState.AlbumNumState.class, GuildAioAlbumUIState.AlbumPanelState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        View findViewById = params.b().findViewById(R.id.f165423vx3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "params.parent.findViewBy\u2026d.guild_aio_album_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mAlbumLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumLayout");
            linearLayout = null;
        }
        View findViewById2 = linearLayout.findViewById(R.id.f165422vx2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mAlbumLayout.findViewByI\u2026id.guild_aio_album_image)");
        RedDotImageView redDotImageView = (RedDotImageView) findViewById2;
        this.mAlbumIcon = redDotImageView;
        if (redDotImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumIcon");
            redDotImageView = null;
        }
        redDotImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.component.album.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.f1(c.this, view);
            }
        });
        RedDotImageView redDotImageView2 = this.mAlbumIcon;
        if (redDotImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumIcon");
            redDotImageView2 = null;
        }
        redDotImageView2.setReddotXOffsetPx(com.tencent.guild.aio.util.c.b(15));
        LinearLayout linearLayout2 = this.mAlbumLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumLayout");
            return null;
        }
        return linearLayout2;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        i1(0);
    }
}
