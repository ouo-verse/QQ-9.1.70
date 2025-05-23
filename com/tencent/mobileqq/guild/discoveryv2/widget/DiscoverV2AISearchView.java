package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0017\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoverV2AISearchView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "", "d", "c", h.F, "g", "e", "onThemeChanged", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "f", "descriptionView", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "aiSearchConfig", "", "i", "I", "aiIconSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoverV2AISearchView extends LinearLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView descriptionView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiSearchConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int aiIconSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverV2AISearchView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GuildAISearchConfBean b() {
        return (GuildAISearchConfBean) this.aiSearchConfig.getValue();
    }

    private final void c() {
        com.tencent.mobileqq.guild.picload.e.a().e(Option.obtain().setTargetView(this.iconView).setNeedFilterUrl(false).setUrl(b().getIconUrl()).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(getContext().getDrawable(R.drawable.guild_discover_ai_search_icon)).setRequestWidth(this.aiIconSize).setRequestHeight(this.aiIconSize));
    }

    private final void d() {
        this.titleView.setText(b().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String());
        this.descriptionView.setText(b().getEntranceDesc());
        c();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DiscoverV2AISearchView this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.descriptionView;
        if (this$0.titleView.getLineCount() > 1) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
    }

    private final void h() {
        int[] intArray;
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), R.color.qui_common_icon_primary);
        float b16 = bi.b(16);
        int a16 = bi.a(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppCompatResources.getColorStateList(getContext(), R.color.qui_button_bg_ghost_pressed));
        gradientDrawable.setCornerRadius(b16);
        gradientDrawable.setStroke(a16, colorStateList);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(b16);
        gradientDrawable2.setStroke(a16, colorStateList);
        StateListDrawable stateListDrawable = new StateListDrawable();
        intArray = ArraysKt___ArraysKt.toIntArray(new Integer[]{Integer.valueOf(android.R.attr.state_pressed)});
        stateListDrawable.addState(intArray, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        setBackground(stateListDrawable);
    }

    public final void e() {
        this.titleView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                DiscoverV2AISearchView.f(DiscoverV2AISearchView.this);
            }
        });
    }

    public final void g() {
        TextView[] textViewArr = {this.titleView, this.descriptionView};
        float fontLevel = FontSettingManager.getFontLevel();
        if (fontLevel > 18.0f) {
            for (int i3 = 0; i3 < 2; i3++) {
                TextView textView = textViewArr[i3];
                if (textView.getLayoutParams() == null) {
                    return;
                }
                textView.setTextSize(0, textView.getTextSize() * (18.0f / fontLevel));
            }
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoverV2AISearchView", "[onThemeChanged] ");
        }
        h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverV2AISearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoverV2AISearchView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoverV2AISearchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildAISearchConfBean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.DiscoverV2AISearchView$aiSearchConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAISearchConfBean invoke() {
                GuildAISearchConfBean a16 = GuildAISearchConfBean.INSTANCE.a();
                Logger.f235387a.d().i("DiscoverV2AISearchView", 1, "aiSearch: " + a16.r());
                return a16;
            }
        });
        this.aiSearchConfig = lazy;
        this.aiIconSize = bi.a(22.0f);
        View inflate = LayoutInflater.from(context).inflate(R.layout.eld, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.f165724xd3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.iconFrequentQuestions)");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f1053165o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tvFrequentQuestions)");
        this.titleView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f10515659);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tvDescription)");
        this.descriptionView = (TextView) findViewById3;
        d();
    }
}
