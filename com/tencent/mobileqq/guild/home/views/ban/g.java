package com.tencent.mobileqq.guild.home.views.ban;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aY\u0010\u000f\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b\u00a8\u0006\u0010"}, d2 = {"Lvp1/bv;", "", "mainIcon", "", "banContentTitle", "banContent", "mainBtn", "subBtn", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/views/ban/BtnType;", "Lkotlin/ParameterName;", "name", "btnType", "", "clickCb", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225549d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f225550e;

        public a(View view, Function1 function1) {
            this.f225549d = view;
            this.f225550e = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard") && (function1 = this.f225550e) != null) {
                function1.invoke(BtnType.MAIN);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225551d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f225552e;

        public b(View view, Function1 function1) {
            this.f225551d = view;
            this.f225552e = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard") && (function1 = this.f225552e) != null) {
                function1.invoke(BtnType.SUB);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final void a(@NotNull bv bvVar, int i3, @NotNull String banContentTitle, @NotNull String banContent, @NotNull String mainBtn, @NotNull String subBtn, @Nullable Function1<? super BtnType, Unit> function1) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        Intrinsics.checkNotNullParameter(bvVar, "<this>");
        Intrinsics.checkNotNullParameter(banContentTitle, "banContentTitle");
        Intrinsics.checkNotNullParameter(banContent, "banContent");
        Intrinsics.checkNotNullParameter(mainBtn, "mainBtn");
        Intrinsics.checkNotNullParameter(subBtn, "subBtn");
        bvVar.f442603f.setImageResource(i3);
        if (QQTheme.isNowThemeIsNight()) {
            bvVar.f442603f.setImageAlpha(242);
        } else {
            bvVar.f442603f.setImageAlpha(255);
        }
        boolean z29 = true;
        if (banContentTitle.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bvVar.f442602e.setText(banContentTitle);
        } else {
            TextView textView = bvVar.f442602e;
            Intrinsics.checkNotNullExpressionValue(textView, "this.guildBanContentTitle");
            textView.setVisibility(8);
        }
        if (banContent.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            bvVar.f442599b.setText(banContent);
        } else {
            TextView textView2 = bvVar.f442599b;
            Intrinsics.checkNotNullExpressionValue(textView2, "this.banContentTv");
            textView2.setVisibility(8);
        }
        if (mainBtn.length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            if (subBtn.length() == 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (z28) {
                QUIButton qUIButton = bvVar.f442601d;
                Intrinsics.checkNotNullExpressionValue(qUIButton, "this.guildBanContentSubBtn");
                qUIButton.setVisibility(8);
                QUIButton qUIButton2 = bvVar.f442600c;
                Intrinsics.checkNotNullExpressionValue(qUIButton2, "this.guildBanContentMainBtn");
                qUIButton2.setVisibility(8);
                return;
            }
        }
        QUIButton qUIButton3 = bvVar.f442600c;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "this.guildBanContentMainBtn");
        qUIButton3.setOnClickListener(new a(qUIButton3, function1));
        QUIButton qUIButton4 = bvVar.f442601d;
        Intrinsics.checkNotNullExpressionValue(qUIButton4, "this.guildBanContentSubBtn");
        qUIButton4.setOnClickListener(new b(qUIButton4, function1));
        if (mainBtn.length() > 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            if (subBtn.length() > 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (z27) {
                QUIButton qUIButton5 = bvVar.f442600c;
                Intrinsics.checkNotNullExpressionValue(qUIButton5, "this.guildBanContentMainBtn");
                qUIButton5.setVisibility(0);
                QUIButton qUIButton6 = bvVar.f442601d;
                Intrinsics.checkNotNullExpressionValue(qUIButton6, "this.guildBanContentSubBtn");
                qUIButton6.setVisibility(0);
                return;
            }
        }
        if (mainBtn.length() > 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            QUIButton qUIButton7 = bvVar.f442601d;
            Intrinsics.checkNotNullExpressionValue(qUIButton7, "this.guildBanContentSubBtn");
            qUIButton7.setVisibility(8);
            bvVar.f442600c.setText(mainBtn);
            QUIButton guildBanContentMainBtn = bvVar.f442600c;
            Intrinsics.checkNotNullExpressionValue(guildBanContentMainBtn, "guildBanContentMainBtn");
            ViewGroup.LayoutParams layoutParams = guildBanContentMainBtn.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ViewUtils.dpToPx(168.0f);
                guildBanContentMainBtn.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        if (subBtn.length() <= 0) {
            z29 = false;
        }
        if (z29) {
            QUIButton qUIButton8 = bvVar.f442600c;
            Intrinsics.checkNotNullExpressionValue(qUIButton8, "this.guildBanContentMainBtn");
            qUIButton8.setVisibility(8);
            bvVar.f442601d.setText(subBtn);
            QUIButton guildBanContentSubBtn = bvVar.f442601d;
            Intrinsics.checkNotNullExpressionValue(guildBanContentSubBtn, "guildBanContentSubBtn");
            ViewGroup.LayoutParams layoutParams2 = guildBanContentSubBtn.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = ViewUtils.dpToPx(168.0f);
                guildBanContentSubBtn.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        QUIButton qUIButton9 = bvVar.f442600c;
        Intrinsics.checkNotNullExpressionValue(qUIButton9, "this.guildBanContentMainBtn");
        qUIButton9.setVisibility(8);
        QUIButton qUIButton10 = bvVar.f442601d;
        Intrinsics.checkNotNullExpressionValue(qUIButton10, "this.guildBanContentSubBtn");
        qUIButton10.setVisibility(8);
    }
}
