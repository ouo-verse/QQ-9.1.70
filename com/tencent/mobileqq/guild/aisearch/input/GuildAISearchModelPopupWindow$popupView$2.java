package com.tencent.mobileqq.guild.aisearch.input;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchModelPopupWindow;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildAISearchModelPopupWindow$popupView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ GuildAISearchModelPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAISearchModelPopupWindow$popupView$2(GuildAISearchModelPopupWindow guildAISearchModelPopupWindow) {
        super(0);
        this.this$0 = guildAISearchModelPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildAISearchModelPopupWindow this$0, View view) {
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
        GuildAISearchModelPopupWindow.b k3;
        context = this.this$0.context;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.f168027ee4, (ViewGroup) null);
        final GuildAISearchModelPopupWindow guildAISearchModelPopupWindow = this.this$0;
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) inflate.findViewById(R.id.f213100o);
        roundFrameLayout.setCorners(15);
        i3 = GuildAISearchModelPopupWindow.f214037j;
        roundFrameLayout.setRadius(i3);
        if (Build.VERSION.SDK_INT < 28) {
            roundFrameLayout.setElevation(com.tencent.guild.aio.util.c.b(10));
        }
        View findViewById = inflate.findViewById(R.id.ebs);
        ListView listView = (ListView) findViewById;
        k3 = guildAISearchModelPopupWindow.k();
        listView.setAdapter((ListAdapter) k3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ListView>(R\u2026rrayAdapter\n            }");
        guildAISearchModelPopupWindow.listView = listView;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAISearchModelPopupWindow$popupView$2.b(GuildAISearchModelPopupWindow.this, view);
            }
        });
        return inflate;
    }
}
