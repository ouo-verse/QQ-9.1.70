package com.tencent.mobileqq.qwallet.publicaccount.controller;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.publicaccount.conf.TabItem;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.AppSetting;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0015\u0010!R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/controller/TabItemController;", "Landroidx/lifecycle/LifecycleObserver;", "", "isSelected", "", "j", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/a;", "tabClickListener", h.F, "i", "g", "Landroid/view/View;", "d", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "e", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "tabItem", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconImg", "iconArrow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/a;", "Lcom/tencent/mobileqq/qwallet/publicaccount/controller/PopMenuController;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qwallet/publicaccount/controller/PopMenuController;", "popupMenuController", "D", "Z", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;)V", "E", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TabItemController implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy popupMenuController;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabItem tabItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a tabClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public TabItemController(@NotNull View itemView, @NotNull TabItem tabItem) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(tabItem, "tabItem");
        this.itemView = itemView;
        this.tabItem = tabItem;
        View findViewById = itemView.findViewById(R.id.md8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_item_title)");
        TextView textView = (TextView) findViewById;
        this.titleView = textView;
        View findViewById2 = itemView.findViewById(R.id.f165781xk3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.img_item_icon)");
        ImageView imageView = (ImageView) findViewById2;
        this.iconImg = imageView;
        View findViewById3 = itemView.findViewById(R.id.f165780xk2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.img_item_arrow)");
        this.iconArrow = (ImageView) findViewById3;
        lazy = LazyKt__LazyJVMKt.lazy(new TabItemController$popupMenuController$2(this));
        this.popupMenuController = lazy;
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(tabItem.getIconUrl(), com.tencent.mobileqq.urldrawable.b.f306350a));
        textView.setText(tabItem.getName());
        j(false);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.publicaccount.controller.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabItemController.b(TabItemController.this, view);
            }
        });
        Context context = itemView.getContext();
        if (context instanceof ComponentActivity) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) context), Dispatchers.getMain().getImmediate(), null, new TabItemController$2$1(context, this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TabItemController this$0, View view) {
        a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isSelected && (aVar = this$0.tabClickListener) != null) {
            aVar.a(this$0.tabItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final PopMenuController f() {
        return (PopMenuController) this.popupMenuController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(boolean isSelected) {
        int i3;
        int i16;
        int i17;
        Drawable mutate;
        if (isSelected) {
            i3 = Color.parseColor("#FF0099FF");
        } else if (QQTheme.isNowThemeIsNight()) {
            i3 = Color.parseColor("#FF999999");
        } else {
            i3 = -16777216;
        }
        Drawable netDrawableForAIO = QWalletPicHelper.getNetDrawableForAIO(this.tabItem.getIconUrl(), com.tencent.mobileqq.urldrawable.b.f306350a);
        if (netDrawableForAIO != null) {
            if (netDrawableForAIO instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) netDrawableForAIO).mutate2();
            } else {
                mutate = netDrawableForAIO.mutate();
            }
            mutate.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            this.iconImg.setImageDrawable(mutate);
        }
        this.titleView.setTextColor(i3);
        ImageView imageView = this.iconArrow;
        if (!this.tabItem.getSheetList().isEmpty()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        if (isSelected) {
            i17 = R.drawable.nwf;
        } else {
            i17 = R.drawable.nwe;
        }
        ImageView imageView2 = this.iconArrow;
        imageView2.setImageDrawable(ResourcesCompat.getDrawable(imageView2.getResources(), i17, null));
        this.isSelected = isSelected;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        f().d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        Context context = this.itemView.getContext();
        if (context instanceof ComponentActivity) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) context), Dispatchers.getMain().getImmediate(), null, new TabItemController$removeObserver$1$1(context, this, null), 2, null);
        }
    }

    public final void h(@NotNull a tabClickListener) {
        Intrinsics.checkNotNullParameter(tabClickListener, "tabClickListener");
        this.tabClickListener = tabClickListener;
        f().i(tabClickListener);
    }

    public final void i() {
        f().j(this.itemView);
        j(true);
        for (TabItem tabItem : this.tabItem.getSheetList()) {
            com.tencent.mobileqq.qwallet.c.e("public.bottom_drawer_sub.show", "", String.valueOf(tabItem.getTabId()), tabItem.getName(), AppSetting.getSubVersion());
        }
    }
}
