package com.tencent.timi.game.emo.ui.panel.fav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import th4.s;
import xg4.k;
import xg4.m;
import xg4.n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001\nBA\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/timi/game/emo/ui/panel/fav/FavoritePanelItemView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/timi/game/emo/ui/panel/fav/h;", "", "g", "", "position", "", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "totalDataList", "a", "d", "I", "getColumnNum", "()I", "columnNum", "Lxg4/m;", "e", "Lxg4/m;", "getParam", "()Lxg4/m;", "param", "Lxg4/a;", "f", "Lxg4/a;", "getPanelItemData", "()Lxg4/a;", "panelItemData", tl.h.F, "mImgHeight", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "viewList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILxg4/m;Lxg4/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FavoritePanelItemView extends LinearLayout implements h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int columnNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m param;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final xg4.a panelItemData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mImgHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<View> viewList;

    public /* synthetic */ FavoritePanelItemView(Context context, AttributeSet attributeSet, int i3, int i16, m mVar, xg4.a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 1 : i16, mVar, aVar);
    }

    private final void g() {
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        int i3 = this.columnNum;
        int i16 = appScreenWidth / i3;
        for (int i17 = 0; i17 < i3; i17++) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            addView(relativeLayout, new LinearLayout.LayoutParams(i16, this.mImgHeight));
            URLImageView uRLImageView = new URLImageView(getContext());
            uRLImageView.setId(R.id.f915355f);
            int i18 = this.mImgHeight;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i18, i18);
            layoutParams.addRule(13, -1);
            layoutParams.addRule(12, -1);
            uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            uRLImageView.setAdjustViewBounds(false);
            relativeLayout.addView(uRLImageView, layoutParams);
            this.viewList.add(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FavoritePanelItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QRoute.createNavigator(this$0.getContext(), RouterConstants.UI_ROUTE_FAV_EMOSM_ACTVITY).subscribeFailed(new Function2<Navigator, QRouteException, Unit>() { // from class: com.tencent.timi.game.emo.ui.panel.fav.FavoritePanelItemView$refresh$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Navigator navigator, QRouteException qRouteException) {
                invoke2(navigator, qRouteException);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Navigator navigator, @NotNull QRouteException exception) {
                Intrinsics.checkNotNullParameter(navigator, "navigator");
                Intrinsics.checkNotNullParameter(exception, "exception");
                l.f("FavoritePanelItemView_", "start UI_ROUTE_FAV_EMOSM_ACTVITY failed", exception);
            }
        }).subscribeSuccess(new com.tencent.mobileqq.qroute.route.m() { // from class: com.tencent.timi.game.emo.ui.panel.fav.f
            @Override // com.tencent.mobileqq.qroute.route.m
            public final void a(Object obj) {
                FavoritePanelItemView.i(obj);
            }
        }).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Object obj) {
        l.i("FavoritePanelItemView_", "start UI_ROUTE_FAV_EMOSM_ACTVITY success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(FavoritePanelItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IEmosmService) QRoute.api(IEmosmService.class)).startEmoticonGroupStoreFragment(this$0.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FavoritePanelItemView this$0, EmoticonInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        n callback = this$0.param.getCallback();
        if (callback != null) {
            callback.o2(new k(this$0.panelItemData, data));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FavoritePanelItemView this$0, EmoticonInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        n callback = this$0.param.getCallback();
        if (callback != null) {
            callback.o2(new k(this$0.panelItemData, data));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.timi.game.emo.ui.panel.fav.h
    public void a(int position, @NotNull List<? extends EmoticonInfo> totalDataList) {
        int a16;
        boolean z16;
        Intrinsics.checkNotNullParameter(totalDataList, "totalDataList");
        if (position == 0) {
            a16 = com.tencent.timi.game.utils.b.a(16);
        } else {
            a16 = com.tencent.timi.game.utils.b.a(14);
        }
        setPadding(0, a16, 0, 0);
        int i3 = this.columnNum;
        int i16 = position * i3;
        int i17 = (i3 + i16) - 1;
        if (i16 > i17) {
            return;
        }
        while (true) {
            int i18 = i16 % this.columnNum;
            URLImageView igv = (URLImageView) this.viewList.get(i18).findViewById(R.id.f915355f);
            if (i16 >= totalDataList.size()) {
                this.viewList.get(i18).setVisibility(8);
            } else {
                this.viewList.get(i18).setVisibility(0);
                final EmoticonInfo emoticonInfo = totalDataList.get(i16);
                igv.setOnClickListener(null);
                String str = emoticonInfo.action;
                if (Intrinsics.areEqual(str, EmoticonInfo.FAV_EDIT_ACTION)) {
                    igv.setImageDrawable(null);
                    igv.setImageResource(R.drawable.o76);
                    igv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.emo.ui.panel.fav.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FavoritePanelItemView.h(FavoritePanelItemView.this, view);
                        }
                    });
                } else if (Intrinsics.areEqual(str, "funny_pic")) {
                    igv.setImageDrawable(null);
                    igv.setImageResource(R.drawable.o78);
                    igv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.emo.ui.panel.fav.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FavoritePanelItemView.j(FavoritePanelItemView.this, view);
                        }
                    });
                } else if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
                    String url = ((IFavoriteEmoticonInfo) emoticonInfo).getUrl();
                    if (url == null) {
                        url = "";
                    }
                    if (url.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.viewList.get(i18).setVisibility(8);
                        l.e("FavoritePanelItemView_", "pos:" + position + " data:" + emoticonInfo + " url is empty, can not show");
                    } else {
                        Intrinsics.checkNotNullExpressionValue(igv, "igv");
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = getContext().getResources().getDrawable(R.drawable.o77);
                        obtain.mFailedDrawable = getContext().getResources().getDrawable(R.drawable.o77);
                        obtain.mPlayGifImage = true;
                        Unit unit = Unit.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026                        }");
                        URLDrawable g16 = com.tencent.timi.game.utils.b.g(igv, url, obtain);
                        if (g16 != null) {
                            g16.setIgnorePause(false);
                            g16.setIndividualPause(false);
                        }
                        igv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.emo.ui.panel.fav.d
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FavoritePanelItemView.k(FavoritePanelItemView.this, emoticonInfo, view);
                            }
                        });
                    }
                } else if (emoticonInfo instanceof IPicEmoticonInfo) {
                    IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) emoticonInfo;
                    if (iPicEmoticonInfo.getEmoticon() != null) {
                        Intrinsics.checkNotNullExpressionValue(igv, "igv");
                        Emoticon emoticon = iPicEmoticonInfo.getEmoticon();
                        Intrinsics.checkNotNullExpressionValue(emoticon, "data.emoticon");
                        s.b(igv, EmotionConstants.FROM_PANEL, xg4.l.e(emoticon, iPicEmoticonInfo));
                        igv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.emo.ui.panel.fav.e
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FavoritePanelItemView.l(FavoritePanelItemView.this, emoticonInfo, view);
                            }
                        });
                    }
                }
            }
            if (i16 != i17) {
                i16++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FavoritePanelItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull m param, @NotNull xg4.a panelItemData) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(panelItemData, "panelItemData");
        this.columnNum = i16;
        this.param = param;
        this.panelItemData = panelItemData;
        this.mImgHeight = com.tencent.timi.game.utils.b.a(56);
        this.viewList = new ArrayList<>();
        setOrientation(0);
        g();
    }
}
