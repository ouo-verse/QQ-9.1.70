package com.tencent.mobileqq.gamecenter.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.ui.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J6\u0010\u0012\u001a\u00020\u000b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002JJ\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0015\u001a\u00020\u000bR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/utils/i;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/RelativeLayout;", "gamePriorityContentView", "Lgd1/a;", "friendGameInfo", "", "gamePackageName", "tick", "", "f", "e", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/data/g;", "Lkotlin/collections/ArrayList;", "gamePriorityList", "d", "c", "j", "i", "Landroid/app/Dialog;", "b", "Landroid/app/Dialog;", "mGamePriorityDialog", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "mCloseListener", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Dialog mGamePriorityDialog;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f213440a = new i();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final View.OnClickListener mCloseListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.utils.g
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            i.h(view);
        }
    };

    i() {
    }

    private final void c() {
        Dialog dialog = mGamePriorityDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private final void d(ArrayList<com.tencent.mobileqq.gamecenter.data.g> gamePriorityList, Activity activity, RelativeLayout gamePriorityContentView) {
        if (gamePriorityList != null) {
            for (int i3 = 0; i3 < gamePriorityList.size() && i3 < 4; i3++) {
                com.tencent.mobileqq.gamecenter.data.g gVar = gamePriorityList.get(i3);
                Intrinsics.checkNotNullExpressionValue(gVar, "gamePriorityList.get(i)");
                com.tencent.mobileqq.gamecenter.data.g gVar2 = gVar;
                ImageView imageView = new ImageView(activity);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(40.0f), ViewUtils.dip2px(40.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                layoutParams.topMargin = ViewUtils.dip2px(158.0f);
                float M = (float) ((ah.M() - (ViewUtils.dip2px(40.0f) * gamePriorityList.size())) / (gamePriorityList.size() + 1));
                float f16 = i3;
                layoutParams.leftMargin = (int) (M + ((ViewUtils.dip2px(40.0f) + M) * f16));
                if (!TextUtils.isEmpty(gVar2.getMIconUrl())) {
                    URLDrawable drawable = URLDrawable.getDrawable(gVar2.getMIconUrl());
                    Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(gamePriorityInfo.mIconUrl)");
                    imageView.setImageDrawable(drawable);
                }
                gamePriorityContentView.addView(imageView, layoutParams);
                TextView textView = new TextView(activity);
                textView.setText(gVar2.getMDetailInfo());
                textView.setTextColor(-2144128205);
                textView.setTextSize(12.0f);
                textView.setLines(3);
                textView.setGravity(3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(63.0f), -2);
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
                float M2 = (float) ((ah.M() - (ViewUtils.dip2px(63.0f) * gamePriorityList.size())) / (gamePriorityList.size() + 1));
                layoutParams2.leftMargin = (int) (M2 + ((ViewUtils.dip2px(63.0f) + M2) * f16));
                layoutParams2.topMargin = ViewUtils.dip2px(208.0f);
                gamePriorityContentView.addView(textView, layoutParams2);
            }
        }
    }

    private final RelativeLayout e(Activity activity, gd1.a friendGameInfo) {
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        RoundRectLinearLayout roundRectLinearLayout = new RoundRectLinearLayout(activity);
        roundRectLinearLayout.setRoundRect(ViewUtils.dip2px(15.0f), -1, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(30.0f));
        layoutParams.addRule(10);
        relativeLayout.addView(roundRectLinearLayout, layoutParams);
        View view = new View(activity);
        view.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(450.0f));
        layoutParams2.addRule(10);
        layoutParams2.topMargin = ViewUtils.dip2px(10.0f);
        relativeLayout.addView(view, layoutParams2);
        TextView textView = new TextView(activity);
        textView.setText("\u6e38\u620f\u4e2d\u5fc3\u542f\u52a8\u4e13\u5c5e\u7279\u6743");
        textView.setTextColor(DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
        textView.setTextSize(20.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(9);
        layoutParams3.topMargin = ViewUtils.dip2px(20.0f);
        layoutParams3.leftMargin = ViewUtils.dip2px(20.0f);
        relativeLayout.addView(textView, layoutParams3);
        ImageView imageView = new ImageView(activity);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView.setImageResource(R.drawable.mug);
        imageView.setOnClickListener(mCloseListener);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = ViewUtils.dip2px(5.0f);
        layoutParams4.rightMargin = ViewUtils.dip2px(10.0f);
        relativeLayout.addView(imageView, layoutParams4);
        ImageView imageView2 = new ImageView(activity);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(60.0f), ViewUtils.dip2px(60.0f));
        layoutParams5.addRule(10);
        layoutParams5.addRule(9);
        layoutParams5.topMargin = ViewUtils.dip2px(66.0f);
        layoutParams5.leftMargin = ViewUtils.dip2px(20.0f);
        if (!TextUtils.isEmpty(friendGameInfo.f401948l)) {
            String str = friendGameInfo.f401948l;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = ViewUtils.dip2px(60.0f);
            obtain.mRequestWidth = ViewUtils.dip2px(60.0f);
            imageView2.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        }
        relativeLayout.addView(imageView2, layoutParams5);
        TextView textView2 = new TextView(activity);
        textView2.setText(friendGameInfo.f401947k);
        textView2.setTextColor(DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
        textView2.setTextSize(15.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(10);
        layoutParams6.addRule(9);
        layoutParams6.topMargin = ViewUtils.dip2px(75.0f);
        layoutParams6.leftMargin = ViewUtils.dip2px(88.0f);
        relativeLayout.addView(textView2, layoutParams6);
        TextView textView3 = new TextView(activity);
        textView3.setText("\u542f\u52a8\u7279\u6743\u751f\u6548\u4e2d");
        textView3.setClickable(false);
        textView3.setTextColor(-32768);
        textView3.setDuplicateParentStateEnabled(false);
        textView3.setBackgroundDrawable(new ad(385843200, ViewUtils.dip2px(4.0f), ViewUtils.dip2px(80.0f), ViewUtils.dip2px(18.0f)));
        textView3.setTextSize(10.0f);
        textView3.setGravity(17);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(10);
        layoutParams7.addRule(9);
        layoutParams7.topMargin = ViewUtils.dip2px(101.0f);
        layoutParams7.leftMargin = ViewUtils.dip2px(88.0f);
        relativeLayout.addView(textView3, layoutParams7);
        View view2 = new View(activity);
        view2.setBackgroundColor(369098752);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(335.0f), 1);
        layoutParams8.addRule(14);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = ViewUtils.dip2px(142.0f);
        relativeLayout.addView(view2, layoutParams8);
        return relativeLayout;
    }

    private final void f(final Activity activity, RelativeLayout gamePriorityContentView, final gd1.a friendGameInfo, final String gamePackageName, final String tick) {
        RoundRectLinearLayout roundRectLinearLayout = new RoundRectLinearLayout(activity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(335.0f), ViewUtils.dip2px(40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = ViewUtils.dip2px(32.0f);
        roundRectLinearLayout.setGravity(17);
        float dip2px = ViewUtils.dip2px(20.0f);
        Window window = null;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px}, null, null));
        shapeDrawable.getPaint().setShader(new LinearGradient(0.0f, 0.0f, ViewUtils.dip2px(335.0f), 0.0f, -16733441, -16751361, Shader.TileMode.CLAMP));
        roundRectLinearLayout.setBackgroundDrawable(shapeDrawable);
        gamePriorityContentView.addView(roundRectLinearLayout, layoutParams);
        TextView textView = new TextView(activity);
        textView.setText("\u7acb\u5373\u542f\u52a8");
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(17);
        roundRectLinearLayout.addView(textView);
        roundRectLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.utils.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.g(gd1.a.this, gamePackageName, tick, activity, view);
            }
        });
        ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
        mGamePriorityDialog = reportDialog;
        reportDialog.setContentView(gamePriorityContentView);
        Dialog dialog = mGamePriorityDialog;
        if (dialog != null) {
            window = dialog.getWindow();
        }
        if (window != null) {
            window.setGravity(80);
        }
        if (window != null) {
            window.setDimAmount(0.5f);
        }
        if (window != null) {
            window.setWindowAnimations(R.style.f173923av4);
        }
        if (window != null) {
            window.setLayout(-1, ViewUtils.dip2px(460.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(gd1.a friendGameInfo, String str, String str2, Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(friendGameInfo, "$friendGameInfo");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        f213440a.c();
        ((ITempApi) QRoute.api(ITempApi.class)).startGame(friendGameInfo.f401939c, str, str2, activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        f213440a.c();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void i() {
        c();
        mGamePriorityDialog = null;
    }

    public final void j(@Nullable gd1.a friendGameInfo, @Nullable Activity activity, @Nullable ArrayList<com.tencent.mobileqq.gamecenter.data.g> gamePriorityList, @Nullable String gamePackageName, @Nullable String tick) {
        if (friendGameInfo != null && activity != null && !activity.isFinishing() && !TextUtils.isEmpty(gamePackageName) && !TextUtils.isEmpty(tick)) {
            if (mGamePriorityDialog == null) {
                RelativeLayout e16 = e(activity, friendGameInfo);
                d(gamePriorityList, activity, e16);
                f(activity, e16, friendGameInfo, gamePackageName, tick);
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(friendGameInfo.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207564", "", "", "8", "0");
            Dialog dialog = mGamePriorityDialog;
            if (dialog != null) {
                dialog.show();
                return;
            }
            return;
        }
        QLog.i("GamePriorityDialogUtil", 1, "[showGamePriorityView] params error,gamePackageName:" + gamePackageName + ",tick:" + tick);
    }
}
