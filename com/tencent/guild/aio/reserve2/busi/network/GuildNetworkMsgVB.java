package com.tencent.guild.aio.reserve2.busi.network;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.guild.aio.reserve2.busi.network.GuildNetworkMsgUIState;
import com.tencent.guild.aio.reserve2.busi.network.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00110\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010 \u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/network/GuildNetworkMsgVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/reserve2/busi/network/a;", "Lcom/tencent/guild/aio/reserve2/busi/network/GuildNetworkMsgUIState;", "", "isConnect", "", "h1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "e1", "", "d", "I", "mItemIconWidth", "e", "mItemIconHeight", "f", "mRightIconWidth", h.F, "mRightIconHeight", "i", "mRightIconLeftMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mArrowRightMargin", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "d1", "()Landroid/widget/RelativeLayout;", "contentView", "<init>", "()V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildNetworkMsgVB extends com.tencent.aio.base.mvvm.a<a, GuildNetworkMsgUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mItemIconWidth = ScreenUtil.dip2px(24.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mItemIconHeight = ScreenUtil.dip2px(24.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mRightIconWidth = ScreenUtil.dip2px(16.0f);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mRightIconHeight = ScreenUtil.dip2px(16.0f);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mRightIconLeftMargin = ScreenUtil.dip2px(12.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mArrowRightMargin = ScreenUtil.dip2px(11.5f);

    public GuildNetworkMsgVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.guild.aio.reserve2.busi.network.GuildNetworkMsgVB$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout relativeLayout = new RelativeLayout(GuildNetworkMsgVB.this.getMContext());
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.tencent.guild.aio.util.c.b(50)));
                return relativeLayout;
            }
        });
        this.contentView = lazy;
    }

    private final RelativeLayout d1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final void f1() {
        int roundToInt;
        int roundToInt2;
        if (d1().getChildCount() > 0) {
            d1().removeAllViews();
        }
        d1().setFocusable(true);
        d1().setClickable(true);
        Resources resources = getMContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "mContext.resources");
        ImageView imageView = new ImageView(getMContext());
        imageView.setId(R.id.jnj);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mItemIconWidth, this.mItemIconHeight);
        roundToInt = MathKt__MathJVMKt.roundToInt(com.tencent.guild.aio.msglist.ark.b.b() * 25.4f);
        layoutParams.leftMargin = roundToInt;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        imageView.setImageResource(R.drawable.common_banner_tips_warning);
        d1().addView(imageView, layoutParams);
        TextView textView = new TextView(getMContext());
        textView.setId(R.id.jnk);
        textView.setSingleLine(true);
        textView.setGravity(8388627);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(resources.getColorStateList(R.color.f157970ah4));
        textView.setDuplicateParentStateEnabled(true);
        textView.setText(resources.getString(R.string.f1512817_));
        textView.setContentDescription(resources.getString(R.string.f1512817_));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(com.tencent.guild.aio.msglist.ark.b.b() * 19.4f);
        layoutParams2.leftMargin = roundToInt2;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, R.id.jnj);
        layoutParams2.addRule(0, R.id.jnl);
        d1().addView(textView, layoutParams2);
        ImageView imageView2 = new ImageView(getMContext());
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawable = resources.getDrawable(R.drawable.mr9);
        Intrinsics.checkNotNullExpressionValue(drawable, "res.getDrawable(com.tenc\u2026banner_tips_arrow_simple)");
        imageView2.setImageDrawable(drawable);
        imageView2.setImportantForAccessibility(2);
        imageView2.setId(R.id.jnl);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.mRightIconWidth, this.mRightIconHeight);
        layoutParams3.rightMargin = this.mArrowRightMargin;
        layoutParams3.leftMargin = this.mRightIconLeftMargin;
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        d1().addView(imageView2, layoutParams3);
        Drawable drawable2 = resources.getDrawable(R.drawable.f160540jm);
        Intrinsics.checkNotNullExpressionValue(drawable2, "res.getDrawable(com.tenc\u2026ackground_theme_version2)");
        d1().setBackgroundDrawable(drawable2);
        d1().setVisibility(8);
        d1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.reserve2.busi.network.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNetworkMsgVB.g1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        MobileQQ.sMobileQQ.startActivity(new Intent("android.settings.SETTINGS"));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h1(boolean isConnect) {
        if (isConnect) {
            d1().setVisibility(8);
        } else {
            d1().setVisibility(0);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        sendIntent(new a.C1212a());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildNetworkMsgUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildNetworkMsgUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildNetworkMsgUIState.NetworkStatusState) {
            h1(((GuildNetworkMsgUIState.NetworkStatusState) state).getConnected());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildNetworkMsgUIState>> getObserverStates() {
        List<Class<? extends GuildNetworkMsgUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildNetworkMsgUIState.NetworkStatusState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        f1();
        return d1();
    }
}
