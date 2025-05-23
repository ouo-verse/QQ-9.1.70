package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import f61.c;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.common.GenericCardPB$GenericCardItem;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\bF\u0010GB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bF\u0010JB!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bF\u0010MJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010 \u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010+\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010(R\u0016\u00107\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010(R\u0016\u00109\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010(R\u0016\u0010;\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010(R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010@\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/view/HorizontalGenericCardView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "b", "Landroid/view/View;", "view", "", "url", "Landroid/graphics/drawable/Drawable;", "mDefaultDrawable", "f", "Landroid/content/Context;", "context", "c", "e", "d", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "uin", "setFriendUin", "Lf61/c;", "cardInfo", "setCardInfo", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "onTouch", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "bgView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", h.F, "subTitleView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "i", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "startGameButton", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "contentView", BdhLogUtil.LogTag.Tag_Conn, "leftTitleView", "D", "leftValueView", "E", "rightTitleView", UserInfo.SEX_FEMALE, "rightValueView", "G", "Lf61/c;", "cardModel", "H", "Ljava/lang/String;", "bgUrl", "I", WadlProxyConsts.KEY_JUMP_URL, "J", "friendUin", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class HorizontalGenericCardView extends RelativeLayout implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView leftTitleView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TextView leftValueView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView rightTitleView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private TextView rightValueView;

    /* renamed from: G, reason: from kotlin metadata */
    private c cardModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String bgUrl;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String jumpUrl;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String friendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RoundRelativeLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView bgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView titleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView subTitleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QUIButton startGameButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalGenericCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.bgUrl = "";
        this.jumpUrl = "";
        this.friendUin = "";
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fcp, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.xqr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.i\u2026zontal_generic_card_root)");
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById;
        this.rootView = roundRelativeLayout;
        roundRelativeLayout.f316195e = getResources().getDimensionPixelSize(R.dimen.f158728ni);
        View findViewById2 = inflate.findViewById(R.id.xqh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.i\u2026_generic_card_content_bg)");
        this.bgView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.xqu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.i\u2026ontal_generic_card_title)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.xqt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.i\u2026al_generic_card_subtitle)");
        this.subTitleView = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tem);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.btn_go_start_game)");
        this.startGameButton = (QUIButton) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.xqg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.i\u2026tal_generic_card_content)");
        this.contentView = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.xql);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.i\u2026_generic_card_left_title)");
        this.leftTitleView = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.xqm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.i\u2026_generic_card_left_value)");
        this.leftValueView = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.xqp);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.i\u2026generic_card_right_title)");
        this.rightTitleView = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.xqq);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.i\u2026generic_card_right_value)");
        this.rightValueView = (TextView) findViewById10;
        if (QQTheme.isVasTheme()) {
            inflate.findViewById(R.id.xqs).setBackgroundResource(R.drawable.juh);
        }
        b();
        setOnClickListener(this);
        setOnTouchListener(this);
        this.startGameButton.setOnClickListener(this);
        setVisibility(8);
    }

    private final HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String str = this.friendUin;
        if (str != null) {
            hashMap.put("touin", str);
        }
        return hashMap;
    }

    private final void b() {
        int i3;
        View findViewById = findViewById(R.id.xqi);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        int[] iArr = new int[2];
        Resources resources = getResources();
        boolean isVasTheme = QQTheme.isVasTheme();
        int i16 = R.color.qui_common_bg_bottom_light;
        if (isVasTheme) {
            i3 = R.color.qui_common_bg_bottom_light;
        } else {
            i3 = R.color.qui_common_fill_light_secondary;
        }
        iArr[0] = resources.getColor(i3);
        iArr[1] = 0;
        findViewById.setBackgroundDrawable(new GradientDrawable(orientation, iArr));
        View findViewById2 = findViewById(R.id.xqj);
        Resources resources2 = getResources();
        if (!QQTheme.isVasTheme()) {
            i16 = R.color.qui_common_fill_light_secondary;
        }
        findViewById2.setBackgroundColor(resources2.getColor(i16));
    }

    private final void c(Context context, String url) {
        boolean startsWith$default;
        if (context != null && !TextUtils.isEmpty(url)) {
            if (NetworkUtil.isNetworkAvailable()) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
                if (startsWith$default) {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", url);
                    context.startActivity(intent);
                    return;
                }
                context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(url)));
                return;
            }
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f170722lt));
            return;
        }
        QLog.e("HorizontalGenericCardView", 1, "invokeScheme fail, invalid params");
    }

    private final void d() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_card_wangzhe_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), a());
    }

    private final void e() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_bas_card_wangzhe_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), a());
    }

    private final void f(View view, String url, Drawable mDefaultDrawable) {
        boolean z16;
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = new Bundle();
        obtain.mLoadingDrawable = mDefaultDrawable;
        obtain.mFailedDrawable = mDefaultDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!u.a().b()) {
            c(getContext(), this.jumpUrl);
            d();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        Integer num;
        if (event != null) {
            num = Integer.valueOf(event.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (v3 != null) {
                v3.setAlpha(0.5f);
            }
        } else if (num != null && num.intValue() == 1) {
            if (v3 != null) {
                v3.performClick();
            }
            if (v3 != null) {
                v3.setAlpha(1.0f);
            }
        } else if (num != null && num.intValue() == 3 && v3 != null) {
            v3.setAlpha(1.0f);
        }
        return true;
    }

    public final void setCardInfo(@NotNull c cardInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.cardModel = cardInfo;
        c cVar = null;
        if (cardInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            cardInfo = null;
        }
        if (cardInfo.getIsEmpty()) {
            setVisibility(8);
            return;
        }
        boolean z17 = false;
        setVisibility(0);
        e();
        c cVar2 = this.cardModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            cVar2 = null;
        }
        String backgroundUrl = cVar2.getBackgroundUrl();
        this.bgUrl = backgroundUrl;
        f(this.bgView, backgroundUrl, new ColorDrawable(0));
        c cVar3 = this.cardModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            cVar3 = null;
        }
        this.jumpUrl = cVar3.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        c cVar4 = this.cardModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            cVar4 = null;
        }
        boolean z18 = true;
        if (cVar4.d().isEmpty()) {
            TextView textView = this.titleView;
            c cVar5 = this.cardModel;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardModel");
                cVar5 = null;
            }
            String title = cVar5.getTitle();
            if (title.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                title = HardCodeUtil.qqStr(R.string.f161291xb);
            }
            textView.setText(title);
            TextView textView2 = this.subTitleView;
            c cVar6 = this.cardModel;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            } else {
                cVar = cVar6;
            }
            String intro = cVar.getIntro();
            if (intro.length() != 0) {
                z18 = false;
            }
            if (z18) {
                intro = HardCodeUtil.qqStr(R.string.f161001wj);
            }
            textView2.setText(intro);
            this.contentView.setVisibility(8);
            this.subTitleView.setVisibility(0);
            this.startGameButton.setVisibility(0);
            return;
        }
        this.contentView.setVisibility(0);
        this.subTitleView.setVisibility(8);
        this.startGameButton.setVisibility(8);
        TextView textView3 = this.titleView;
        c cVar7 = this.cardModel;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
            cVar7 = null;
        }
        textView3.setText(cVar7.getTitle());
        c cVar8 = this.cardModel;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardModel");
        } else {
            cVar = cVar8;
        }
        Iterator<GenericCardPB$GenericCardItem> it = cVar.d().iterator();
        boolean z19 = false;
        while (it.hasNext()) {
            GenericCardPB$GenericCardItem next = it.next();
            if (!z17) {
                this.leftTitleView.setText(next.key.get());
                this.leftValueView.setText(next.value.get());
                z17 = true;
            } else if (!z19) {
                this.rightTitleView.setText(next.key.get());
                this.rightValueView.setText(next.value.get());
                z19 = true;
            }
        }
    }

    public final void setFriendUin(@Nullable String uin) {
        this.friendUin = uin;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalGenericCardView(@NotNull Context context, @NotNull AttributeSet attr) {
        super(context, attr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.bgUrl = "";
        this.jumpUrl = "";
        this.friendUin = "";
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fcp, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.xqr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.i\u2026zontal_generic_card_root)");
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById;
        this.rootView = roundRelativeLayout;
        roundRelativeLayout.f316195e = getResources().getDimensionPixelSize(R.dimen.f158728ni);
        View findViewById2 = inflate.findViewById(R.id.xqh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.i\u2026_generic_card_content_bg)");
        this.bgView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.xqu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.i\u2026ontal_generic_card_title)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.xqt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.i\u2026al_generic_card_subtitle)");
        this.subTitleView = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tem);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.btn_go_start_game)");
        this.startGameButton = (QUIButton) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.xqg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.i\u2026tal_generic_card_content)");
        this.contentView = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.xql);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.i\u2026_generic_card_left_title)");
        this.leftTitleView = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.xqm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.i\u2026_generic_card_left_value)");
        this.leftValueView = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.xqp);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.i\u2026generic_card_right_title)");
        this.rightTitleView = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.xqq);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.i\u2026generic_card_right_value)");
        this.rightValueView = (TextView) findViewById10;
        if (QQTheme.isVasTheme()) {
            inflate.findViewById(R.id.xqs).setBackgroundResource(R.drawable.juh);
        }
        b();
        setOnClickListener(this);
        setOnTouchListener(this);
        this.startGameButton.setOnClickListener(this);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalGenericCardView(@NotNull Context context, @NotNull AttributeSet attr, int i3) {
        super(context, attr, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.bgUrl = "";
        this.jumpUrl = "";
        this.friendUin = "";
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fcp, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.xqr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.i\u2026zontal_generic_card_root)");
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById;
        this.rootView = roundRelativeLayout;
        roundRelativeLayout.f316195e = getResources().getDimensionPixelSize(R.dimen.f158728ni);
        View findViewById2 = inflate.findViewById(R.id.xqh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.i\u2026_generic_card_content_bg)");
        this.bgView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.xqu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.i\u2026ontal_generic_card_title)");
        this.titleView = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.xqt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.i\u2026al_generic_card_subtitle)");
        this.subTitleView = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tem);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.btn_go_start_game)");
        this.startGameButton = (QUIButton) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.xqg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.i\u2026tal_generic_card_content)");
        this.contentView = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.xql);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.i\u2026_generic_card_left_title)");
        this.leftTitleView = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.xqm);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.i\u2026_generic_card_left_value)");
        this.leftValueView = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.xqp);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.i\u2026generic_card_right_title)");
        this.rightTitleView = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.xqq);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.i\u2026generic_card_right_value)");
        this.rightValueView = (TextView) findViewById10;
        if (QQTheme.isVasTheme()) {
            inflate.findViewById(R.id.xqs).setBackgroundResource(R.drawable.juh);
        }
        b();
        setOnClickListener(this);
        setOnTouchListener(this);
        this.startGameButton.setOnClickListener(this);
        setVisibility(8);
    }
}
