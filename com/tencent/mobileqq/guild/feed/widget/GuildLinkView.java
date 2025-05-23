package com.tencent.mobileqq.guild.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\f\u00a2\u0006\u0004\b9\u0010:J.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J:\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002Jz\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014R?\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildLinkView;", "Landroid/widget/FrameLayout;", "", "", "", WadlProxyConsts.KEY_JUMP_URL, "b", "extraDtParams", "", "f", "imgUrl", "Lkotlin/Pair;", "", "coverSize", "imageGroupKey", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "picLoadListener", "g", "title", "abstract", "Landroid/view/View$OnClickListener;", "onViewCloseCb", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "d", "Lkotlin/jvm/functions/Function1;", "getOnClickContainerListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickContainerListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickContainerListener", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivLinkIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvLinkTitle", tl.h.F, "tvLinkAbstract", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "i", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", ParseCommon.CONTAINER, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mImageUrl", BdhLogUtil.LogTag.Tag_Conn, "ivCloseBtn", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLinkView extends FrameLayout {

    /* renamed from: C */
    @NotNull
    private ImageView ivCloseBtn;

    /* renamed from: d, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> onClickContainerListener;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private ImageView ivLinkIcon;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private TextView tvLinkTitle;

    /* renamed from: h */
    @NotNull
    private TextView tvLinkAbstract;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private RoundCorneredRelativeLayout com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String;

    /* renamed from: m */
    @Nullable
    private String mImageUrl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLinkView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Map<String, Object> b(Map<String, ? extends Object> map, String str) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("sgrp_url", str);
        hashMap.put("sgrp_url_type", 1);
        return hashMap;
    }

    public static /* synthetic */ void d(GuildLinkView guildLinkView, String str, String str2, String str3, String str4, Map map, IPicLoadStateListener iPicLoadStateListener, String str5, Pair pair, View.OnClickListener onClickListener, int i3, Object obj) {
        String str6;
        Map map2;
        IPicLoadStateListener iPicLoadStateListener2;
        String str7;
        Pair pair2;
        View.OnClickListener onClickListener2;
        if ((i3 & 8) != 0) {
            str6 = "";
        } else {
            str6 = str4;
        }
        if ((i3 & 16) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i3 & 32) != 0) {
            iPicLoadStateListener2 = null;
        } else {
            iPicLoadStateListener2 = iPicLoadStateListener;
        }
        if ((i3 & 64) != 0) {
            str7 = null;
        } else {
            str7 = str5;
        }
        if ((i3 & 128) != 0) {
            pair2 = new Pair(0, 0);
        } else {
            pair2 = pair;
        }
        if ((i3 & 256) != 0) {
            onClickListener2 = null;
        } else {
            onClickListener2 = onClickListener;
        }
        guildLinkView.c(str, str2, str3, str6, map2, iPicLoadStateListener2, str7, pair2, onClickListener2);
    }

    public static final void e(GuildLinkView this$0, String jumpUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpUrl, "$jumpUrl");
        Function1<? super String, Unit> function1 = this$0.onClickContainerListener;
        if (function1 != null) {
            function1.invoke(jumpUrl);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f(String r122, Map<String, ? extends Object> extraDtParams) {
        if1.a.b(this, "em_sgrp_insert_card_url", r122.hashCode() + "#" + hashCode(), b(extraDtParams, r122), null, null, null, null, null, 248, null);
    }

    private final void g(String imgUrl, Pair<Integer, Integer> coverSize, String imageGroupKey, IPicLoadStateListener picLoadListener) {
        ImageView imageView = this.ivLinkIcon;
        GuildFeedListImageExKt.g(imageView, imgUrl, coverSize, imageGroupKey, GuildFeedListImageExKt.c(imageView), null, false, false, false, picLoadListener, 224, null);
    }

    public final void c(@NotNull String title, @NotNull String r65, @NotNull String imgUrl, @NotNull final String r85, @Nullable Map<String, ? extends Object> extraDtParams, @Nullable IPicLoadStateListener picLoadListener, @Nullable String imageGroupKey, @NotNull Pair<Integer, Integer> coverSize, @Nullable View.OnClickListener onViewCloseCb) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(r65, "abstract");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(r85, "jumpUrl");
        Intrinsics.checkNotNullParameter(coverSize, "coverSize");
        QLog.i("GuildLinkView", 4, "onBind--title:" + title + ",abstract:" + r65 + ",imgUrl:" + imgUrl + ",jumpUrl:" + r85);
        this.tvLinkTitle.setText(title);
        if (r65.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.tvLinkAbstract.setVisibility(8);
            this.tvLinkTitle.setMaxLines(2);
            if (title.length() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (z27) {
                this.tvLinkTitle.setText(r85);
            }
        } else {
            if (title.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.tvLinkTitle.setText(r65);
            } else {
                this.tvLinkAbstract.setVisibility(0);
                this.tvLinkAbstract.setText(r65);
                this.tvLinkTitle.setMaxLines(1);
            }
        }
        if (imgUrl.length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18 && !Intrinsics.areEqual(imgUrl, this.mImageUrl)) {
            this.mImageUrl = imgUrl;
            g(imgUrl, coverSize, imageGroupKey, picLoadListener);
        } else {
            String str = this.mImageUrl;
            if (str != null && str.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                this.ivLinkIcon.setImageDrawable(getContext().getDrawable(R.drawable.guild_link_view_default_thumb));
            }
        }
        if (r85.length() > 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildLinkView.e(GuildLinkView.this, r85, view);
                }
            });
        } else {
            QLog.e("GuildLinkView", 1, "onClick--jumpUrl is empty!");
        }
        if (onViewCloseCb != null) {
            this.ivCloseBtn.setVisibility(0);
            this.ivCloseBtn.setOnClickListener(onViewCloseCb);
        }
        f(r85, extraDtParams);
    }

    public final void setOnClickContainerListener(@Nullable Function1<? super String, Unit> function1) {
        this.onClickContainerListener = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLinkView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLinkView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLinkView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onClickContainerListener = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildLinkView$onClickContainerListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Context context2 = context;
                if (!(context2 instanceof Activity)) {
                    context2 = null;
                }
                GuildJumpUtil.w((Activity) context2, it);
            }
        };
        View inflate = LayoutInflater.from(context).inflate(R.layout.evx, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.y5b);
        ImageView imageView = (ImageView) findViewById;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Im\u2026ype.CENTER_CROP\n        }");
        this.ivLinkIcon = imageView;
        View findViewById2 = inflate.findViewById(R.id.f109066et);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_link_title)");
        this.tvLinkTitle = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f109056es);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_link_abstract)");
        this.tvLinkAbstract = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f166798ic2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.rl_container)");
        this.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String = (RoundCorneredRelativeLayout) findViewById4;
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158720na);
        this.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String.setRadius(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        View findViewById5 = inflate.findViewById(R.id.az7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.close_btn)");
        this.ivCloseBtn = (ImageView) findViewById5;
    }
}
