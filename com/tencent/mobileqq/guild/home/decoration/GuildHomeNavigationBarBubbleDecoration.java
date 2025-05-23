package com.tencent.mobileqq.guild.home.decoration;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 <2\u00020\u0001:\u0001=B+\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u001a\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010#0\"\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R(\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u001b\u0010-\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b%\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/home/decoration/GuildHomeNavigationBarBubbleDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "guildId", "", "j", "Landroid/graphics/Canvas;", "c", "Landroid/view/View;", "barNextView", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "tip", "", c.G, "totalCount", "", "width", "height", "Landroid/graphics/LinearGradient;", "d", "left", "top", "Landroid/graphics/Path;", "f", "centerBottom", h.F, "b", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "e", "Lkotlin/jvm/functions/Function0;", "getNavigationBar", "Ljava/lang/String;", "curGuildId", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "()Landroid/graphics/Paint;", "paint", "Landroid/graphics/Bitmap;", "i", "g", "()Landroid/graphics/Bitmap;", "startBitmap", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isDelayRemoveBubbleRunning", BdhLogUtil.LogTag.Tag_Conn, "I", NodeProps.MARGIN_HORIZONTAL, "<init>", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;Lkotlin/jvm/functions/Function0;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeNavigationBarBubbleDecoration extends RecyclerView.ItemDecoration {
    private static final int E = QQGuildUIUtil.f(2.0f);
    private static final int F = QQGuildUIUtil.f(4.0f);
    private static final int G = QQGuildUIUtil.f(6.0f);
    private static final int H = QQGuildUIUtil.f(8.0f);
    private static final int I = QQGuildUIUtil.f(10.0f);
    private static final int J = QQGuildUIUtil.f(12.0f);
    private static final int K = QQGuildUIUtil.f(20.0f);
    private static final int L = QQGuildUIUtil.f(31.0f);
    private static final int M = QQGuildUIUtil.f(14.0f);
    private static final int N = QQGuildUIUtil.f(18.0f);
    private static final int P = QQGuildUIUtil.f(40.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final int marginHorizontal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType facadeType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Pair<Integer, GuildHomeHeaderNavigationBar>> getNavigationBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curGuildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy startBitmap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isDelayRemoveBubbleRunning;

    public GuildHomeNavigationBarBubbleDecoration(@NotNull GuildFacadeType facadeType, @NotNull Function0<Pair<Integer, GuildHomeHeaderNavigationBar>> getNavigationBar) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        Intrinsics.checkNotNullParameter(getNavigationBar, "getNavigationBar");
        this.facadeType = facadeType;
        this.getNavigationBar = getNavigationBar;
        this.curGuildId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.mobileqq.guild.home.decoration.GuildHomeNavigationBarBubbleDecoration$paint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                return paint;
            }
        });
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Bitmap>() { // from class: com.tencent.mobileqq.guild.home.decoration.GuildHomeNavigationBarBubbleDecoration$startBitmap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bitmap invoke() {
                Drawable drawable = BaseApplication.context.getResources().getDrawable(R.drawable.guild_navigation_bubble_right, null);
                Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026ation_bubble_right, null)");
                return DrawableKt.toBitmap$default(drawable, QQGuildUIUtil.f(21.0f), QQGuildUIUtil.f(18.0f), null, 4, null);
            }
        });
        this.startBitmap = lazy2;
        this.marginHorizontal = QQGuildUIUtil.f(16.0f);
    }

    private final void c(Canvas c16, View barNextView, RecyclerView parent, String tip, int pos, int totalCount) {
        Logger.f235387a.d().d("Guild.NewHome.NoticeNavigationBarBubbleDecoration", 1, "[drawBubble] totalCount:" + totalCount);
        if (totalCount == 0) {
            return;
        }
        double d16 = pos + 0.5d;
        int measuredWidth = parent.getMeasuredWidth();
        int i3 = this.marginHorizontal;
        float x16 = (float) (parent.getX() + this.marginHorizontal + ((d16 * ((measuredWidth - i3) - i3)) / totalCount));
        float top = barNextView.getTop() + E + barNextView.getTranslationY();
        int i16 = L;
        float f16 = top - i16;
        e().setTextSize(M);
        float measureText = e().measureText(tip);
        float f17 = P + measureText;
        e().setShader(d(f17, i16));
        int i17 = G;
        c16.drawPath(h(x16, i16 + f16 + i17), e());
        float x17 = parent.getX();
        int i18 = I;
        float f18 = x17 + i18;
        float x18 = (parent.getX() + parent.getMeasuredWidth()) - i18;
        float f19 = f17 / 2;
        float f26 = x16 - f19;
        if (f26 >= f18) {
            if (x16 + f19 > x18) {
                f18 = x18 - f17;
            } else {
                f18 = f26;
            }
        }
        float f27 = f16 + i17;
        c16.drawPath(f(f18, f27, f17, i16), e());
        e().setShader(null);
        e().setColor(-1);
        c16.drawText(tip, H + f18, K + f27, e());
        c16.drawBitmap(g(), f18 + measureText + J, f27 + i17, e());
    }

    private final LinearGradient d(float width, float height) {
        return new LinearGradient(0.0f, 0.0f, width, height, Color.parseColor("#37AFFF"), Color.parseColor("#049AFF"), Shader.TileMode.CLAMP);
    }

    private final Paint e() {
        return (Paint) this.paint.getValue();
    }

    private final Path f(float left, float top, float width, float height) {
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        int i3 = F;
        path.addRoundRect(left, top, left + width, top + height, i3, i3, Path.Direction.CW);
        return path;
    }

    private final Bitmap g() {
        return (Bitmap) this.startBitmap.getValue();
    }

    private final Path h(float centerBottom, float top) {
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        int i3 = G;
        path.moveTo(centerBottom - i3, top);
        path.lineTo(i3 + centerBottom, top);
        path.lineTo(centerBottom, top + i3);
        path.close();
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String guildId, GuildHomeNavigationBarBubbleDecoration this$0, RecyclerView parent) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        if (Intrinsics.areEqual(guildId, this$0.curGuildId)) {
            this$0.j(guildId);
            parent.invalidate();
        }
    }

    private final void j(String guildId) {
        List<IGProNavigationInfo> k3;
        this.isDelayRemoveBubbleRunning = false;
        Pair<Integer, GuildHomeHeaderNavigationBar> invoke = this.getNavigationBar.invoke();
        if (invoke != null && (k3 = invoke.component2().k()) != null) {
            for (IGProNavigationInfo iGProNavigationInfo : k3) {
                if (iGProNavigationInfo.getShowBubble()) {
                    String f16 = ch.f();
                    Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
                    String title = iGProNavigationInfo.getTitle();
                    Intrinsics.checkNotNullExpressionValue(title, "gProNavigationInfo.title");
                    String getBubbleDesc = iGProNavigationInfo.getGetBubbleDesc();
                    Intrinsics.checkNotNullExpressionValue(getBubbleDesc, "gProNavigationInfo.bubbleDesc");
                    bw.Z1(f16, guildId, title, getBubbleDesc);
                }
            }
        }
    }

    public final void b(@NotNull String guildId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (this.curGuildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(this.curGuildId, guildId)) {
            j(this.curGuildId);
        }
        this.curGuildId = guildId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas c16, @NotNull final RecyclerView parent, @NotNull RecyclerView.State state) {
        View view;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(c16, parent, state);
        Pair<Integer, GuildHomeHeaderNavigationBar> invoke = this.getNavigationBar.invoke();
        if (invoke != null) {
            int intValue = invoke.component1().intValue();
            GuildHomeHeaderNavigationBar component2 = invoke.component2();
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = parent.findViewHolderForAdapterPosition(intValue);
            if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
                Intrinsics.checkNotNullExpressionValue(view, "parent.findViewHolderFor\u2026pter)?.itemView ?: return");
                String guildId = component2.getGuildId();
                if (guildId == null) {
                    guildId = "";
                }
                final String str = guildId;
                List<IGProNavigationInfo> k3 = component2.k();
                if (k3 != null) {
                    int i3 = 0;
                    for (Object obj : k3) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        IGProNavigationInfo iGProNavigationInfo = (IGProNavigationInfo) obj;
                        int i17 = 5;
                        if (i3 >= 5) {
                            return;
                        }
                        String f16 = ch.f();
                        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
                        String title = iGProNavigationInfo.getTitle();
                        Intrinsics.checkNotNullExpressionValue(title, "gProNavigationInfo.title");
                        String getBubbleDesc = iGProNavigationInfo.getGetBubbleDesc();
                        Intrinsics.checkNotNullExpressionValue(getBubbleDesc, "gProNavigationInfo.bubbleDesc");
                        boolean l06 = bw.l0(f16, str, title, getBubbleDesc);
                        if (iGProNavigationInfo.getShowBubble() && !l06) {
                            if (component2.k().size() <= 5) {
                                i17 = component2.k().size();
                            }
                            String getBubbleDesc2 = iGProNavigationInfo.getGetBubbleDesc();
                            Intrinsics.checkNotNullExpressionValue(getBubbleDesc2, "gProNavigationInfo.bubbleDesc");
                            c(c16, view, parent, getBubbleDesc2, i3, i17);
                            if (!this.isDelayRemoveBubbleRunning) {
                                this.isDelayRemoveBubbleRunning = true;
                                kotlin.Function0.b(2500, new Runnable() { // from class: com.tencent.mobileqq.guild.home.decoration.b
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        GuildHomeNavigationBarBubbleDecoration.i(str, this, parent);
                                    }
                                });
                            }
                        }
                        i3 = i16;
                    }
                }
            }
        }
    }
}
