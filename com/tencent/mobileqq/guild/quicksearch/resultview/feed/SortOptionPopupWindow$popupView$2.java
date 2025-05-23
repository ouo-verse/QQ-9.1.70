package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

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
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SortOptionPopupWindow$popupView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ SortOptionPopupWindow this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SortOptionPopupWindow$popupView$2(SortOptionPopupWindow sortOptionPopupWindow) {
        super(0);
        this.this$0 = sortOptionPopupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SortOptionPopupWindow this$0, View view) {
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
        b j3;
        context = this.this$0.context;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.f168185f92, (ViewGroup) null);
        final SortOptionPopupWindow sortOptionPopupWindow = this.this$0;
        inflate.setPadding(inflate.getPaddingLeft(), inflate.getPaddingTop(), com.tencent.guild.aio.util.c.b(16), inflate.getPaddingBottom());
        View findViewById = inflate.findViewById(R.id.f167009jw1);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        Drawable background = findViewById.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "background");
        findViewById.setBackground(guildUIUtils.F(background, ContextCompat.getColor(findViewById.getContext(), R.color.qui_common_bg_top_light)));
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMarginEnd(com.tencent.guild.aio.util.c.b(20));
            findViewById.setLayoutParams(marginLayoutParams);
        }
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) inflate.findViewById(R.id.f213100o);
        roundFrameLayout.setCorners(15);
        i3 = SortOptionPopupWindow.f231776j;
        roundFrameLayout.setRadius(i3);
        if (Build.VERSION.SDK_INT < 28) {
            roundFrameLayout.setElevation(com.tencent.guild.aio.util.c.b(10));
        }
        View findViewById2 = inflate.findViewById(R.id.f213000n);
        ListView listView = (ListView) findViewById2;
        j3 = sortOptionPopupWindow.j();
        listView.setAdapter((ListAdapter) j3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ListView>(R\u2026rrayAdapter\n            }");
        sortOptionPopupWindow.listView = listView;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SortOptionPopupWindow$popupView$2.b(SortOptionPopupWindow.this, view);
            }
        });
        return inflate;
    }
}
