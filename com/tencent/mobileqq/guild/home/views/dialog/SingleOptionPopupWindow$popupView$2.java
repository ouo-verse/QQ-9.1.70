package com.tencent.mobileqq.guild.home.views.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class SingleOptionPopupWindow$popupView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ SingleOptionPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleOptionPopupWindow$popupView$2(SingleOptionPopupWindow singleOptionPopupWindow) {
        super(0);
        this.this$0 = singleOptionPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SingleOptionPopupWindow this$0, View view) {
        PopupWindow popupWindow;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        Context context;
        int i3;
        c l3;
        context = this.this$0.context;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View invoke$lambda$4 = ((LayoutInflater) systemService).inflate(R.layout.f168185f92, (ViewGroup) null);
        final SingleOptionPopupWindow singleOptionPopupWindow = this.this$0;
        View findViewById = invoke$lambda$4.findViewById(R.id.f167009jw1);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Drawable background = findViewById.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "background");
        findViewById.setBackground(guildUIUtils.F(background, ContextCompat.getColor(findViewById.getContext(), R.color.qui_common_bg_top_light)));
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) invoke$lambda$4.findViewById(R.id.f213100o);
        roundFrameLayout.setCorners(15);
        i3 = SingleOptionPopupWindow.f225560m;
        roundFrameLayout.setRadius(i3);
        if (Build.VERSION.SDK_INT < 28) {
            roundFrameLayout.setElevation(com.tencent.guild.aio.util.c.b(10));
        }
        View findViewById2 = invoke$lambda$4.findViewById(R.id.f213000n);
        ListView listView = (ListView) findViewById2;
        l3 = singleOptionPopupWindow.l();
        listView.setAdapter((ListAdapter) l3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ListView>(R\u2026rrayAdapter\n            }");
        singleOptionPopupWindow.listView = listView;
        invoke$lambda$4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleOptionPopupWindow$popupView$2.b(SingleOptionPopupWindow.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(invoke$lambda$4, "invoke$lambda$4");
        if1.a.b(invoke$lambda$4, "em_sgrp_sort_panel", null, null, null, ClickPolicy.REPORT_NONE, null, null, null, 238, null);
        return invoke$lambda$4;
    }
}
