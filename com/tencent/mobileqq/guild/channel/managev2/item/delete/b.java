package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "createVM", "state", "", "d1", "", "e", "I", "getTitleRes", "()I", "titleRes", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "itemView", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends com.tencent.mobileqq.guild.channel.managev2.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int titleRes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView itemView;

    public b(int i3) {
        this.titleRes = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            TextView textView = this$0.itemView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemView");
                textView = null;
            }
            this$0.sendIntent(new b.C7685b(textView));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<com.tencent.mobileqq.guild.channel.managev2.b, ChannelSettingUIState, ChannelSettingMviContext> createVM() {
        return new ChannelDeleteViewModel();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ChannelSettingUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ChannelSettingUIState.SettingItemEnableUIState) {
            TextView textView = this.itemView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemView");
                textView = null;
            }
            b1(textView, ((ChannelSettingUIState.SettingItemEnableUIState) state).getEnableModify());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        TextView textView = null;
        View rootView = LayoutInflater.from(createViewParams.a()).inflate(R.layout.eil, (ViewGroup) null);
        View findViewById = rootView.findViewById(R.id.f167041k72);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_delete)");
        TextView textView2 = (TextView) findViewById;
        this.itemView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            textView2 = null;
        }
        textView2.setText(createViewParams.a().getResources().getString(this.titleRes));
        TextView textView3 = this.itemView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.e1(b.this, view);
            }
        });
        com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
        QRouteApi api = QRoute.api(IGuildDTReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) api;
        TextView textView4 = this.itemView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
        } else {
            textView = textView4;
        }
        iGuildDTReportApi.setElementExposureAllAndClickPolicy(textView, "em_sgrp_delete_btn");
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    public /* synthetic */ b(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.string.f141360gg : i3);
    }
}
