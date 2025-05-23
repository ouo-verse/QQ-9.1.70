package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.TroopInfoCardGameViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troop.troopgame.data.GradeDistributedInfo;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u00109\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010.R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardHOKGameDataPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "P9", "N9", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/i;", "list", "S9", "Landroid/widget/ImageView;", "progressBar", "Landroid/widget/TextView;", "percentView", "", "percent", "L9", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopGameInfo;", "gameInfo", "V9", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "e", "Landroid/view/View;", "titleContainer", "f", "gameInfoContainer", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "percentContainer", "i", "troopRankContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "troopFightingPowerTitle", BdhLogUtil.LogTag.Tag_Conn, "troopFightingPower", "D", "troopFightingPowerUnit", "E", "gameCountTitle", UserInfo.SEX_FEMALE, "gameCount", "G", "gamePersonNumTitle", "H", "gamePersonNum", "Landroid/graphics/Typeface;", "I", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/TroopInfoCardGameViewModel;", "J", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/TroopInfoCardGameViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "K", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopBasicInfoViewModel", "", "L", "Z", "hasInitView", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardHOKGameDataPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView troopFightingPower;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView troopFightingPowerUnit;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView gameCountTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView gameCount;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView gamePersonNumTitle;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView gamePersonNum;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Typeface typeface;

    /* renamed from: J, reason: from kotlin metadata */
    private TroopInfoCardGameViewModel viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private TroopBasicInfoViewModel troopBasicInfoViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hasInitView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View titleContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View gameInfoContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout percentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View troopRankContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView troopFightingPowerTitle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardHOKGameDataPart$a;", "", "", "ONE_BILLION", "I", "", "TAG", "Ljava/lang/String;", "TEN_THOUSAND", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardHOKGameDataPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardHOKGameDataPart(@NotNull AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.appInterface = appInterface;
        }
    }

    private final void L9(final ImageView progressBar, final TextView percentView, int percent) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, percent);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ax
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopInfoCardHOKGameDataPart.M9(percentView, progressBar, valueAnimator);
            }
        });
        ofInt.setDuration(800L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(TextView percentView, ImageView progressBar, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(percentView, "$percentView");
        Intrinsics.checkNotNullParameter(progressBar, "$progressBar");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (!Intrinsics.areEqual(percentView.getText().toString(), String.valueOf(intValue))) {
            ViewGroup.LayoutParams layoutParams = progressBar.getLayoutParams();
            layoutParams.height = (com.tencent.mobileqq.utils.am.a(64.0f) * intValue) / 100;
            progressBar.setLayoutParams(layoutParams);
            percentView.setText(String.valueOf(intValue));
        }
    }

    private final void N9() {
        TroopInfoCardGameViewModel troopInfoCardGameViewModel = this.viewModel;
        TroopInfoCardGameViewModel troopInfoCardGameViewModel2 = null;
        if (troopInfoCardGameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopInfoCardGameViewModel = null;
        }
        LiveData<TroopGameInfo> O1 = troopInfoCardGameViewModel.O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TroopGameInfo, Unit> function1 = new Function1<TroopGameInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardHOKGameDataPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardHOKGameDataPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopGameInfo troopGameInfo) {
                invoke2(troopGameInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopGameInfo troopGameInfo) {
                View view;
                LinearLayout linearLayout;
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopGameInfo);
                    return;
                }
                view = TroopInfoCardHOKGameDataPart.this.gameInfoContainer;
                LinearLayout linearLayout2 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gameInfoContainer");
                    view = null;
                }
                view.setVisibility(troopGameInfo != null ? 0 : 8);
                if (troopGameInfo != null) {
                    TroopInfoCardHOKGameDataPart troopInfoCardHOKGameDataPart = TroopInfoCardHOKGameDataPart.this;
                    linearLayout = troopInfoCardHOKGameDataPart.percentContainer;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("percentContainer");
                    } else {
                        linearLayout2 = linearLayout;
                    }
                    List<GradeDistributedInfo> list = troopGameInfo.gradeDistributedList;
                    Intrinsics.checkNotNullExpressionValue(list, "it.gradeDistributedList");
                    linearLayout2.setVisibility(true ^ list.isEmpty() ? 0 : 8);
                    List<GradeDistributedInfo> list2 = troopGameInfo.gradeDistributedList;
                    Intrinsics.checkNotNullExpressionValue(list2, "it.gradeDistributedList");
                    Iterator<T> it = list2.iterator();
                    long j3 = 0;
                    while (it.hasNext()) {
                        j3 += ((GradeDistributedInfo) it.next()).userCount;
                    }
                    List<GradeDistributedInfo> list3 = troopGameInfo.gradeDistributedList;
                    Intrinsics.checkNotNullExpressionValue(list3, "it.gradeDistributedList");
                    List<GradeDistributedInfo> list4 = list3;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (GradeDistributedInfo gradeDistributedInfo : list4) {
                        arrayList.add(new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.i(gradeDistributedInfo.grade, gradeDistributedInfo.userCount, j3));
                    }
                    troopInfoCardHOKGameDataPart.S9(arrayList);
                    troopInfoCardHOKGameDataPart.V9(troopGameInfo);
                }
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardHOKGameDataPart.O9(Function1.this, obj);
            }
        });
        TroopInfoCardGameViewModel troopInfoCardGameViewModel3 = this.viewModel;
        if (troopInfoCardGameViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopInfoCardGameViewModel2 = troopInfoCardGameViewModel3;
        }
        troopInfoCardGameViewModel2.S1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(View rootView) {
        View findViewById = rootView.findViewById(R.id.xa_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.hok_title_bar)");
        this.titleContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.vj9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.game_info_container)");
        this.gameInfoContainer = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.xa7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026e_distribution_container)");
        this.percentContainer = (LinearLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.xsq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.item_card_1)");
        this.troopRankContainer = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.vhi);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.gameFightPowerTitle)");
        this.troopFightingPowerTitle = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.vhh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.gameFightPower)");
        this.troopFightingPower = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.vhj);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.gameFightPowerUnit)");
        this.troopFightingPowerUnit = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.xss);
        findViewById8.setBackgroundResource(R.drawable.kym);
        View findViewById9 = findViewById8.findViewById(R.id.dr7);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.item_title)");
        this.gameCountTitle = (TextView) findViewById9;
        View findViewById10 = findViewById8.findViewById(R.id.dq6);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.item_info)");
        this.gameCount = (TextView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.xst);
        findViewById11.setBackgroundResource(R.drawable.kyn);
        View findViewById12 = findViewById11.findViewById(R.id.dr7);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.item_title)");
        this.gamePersonNumTitle = (TextView) findViewById12;
        View findViewById13 = findViewById11.findViewById(R.id.dq6);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.item_info)");
        this.gamePersonNum = (TextView) findViewById13;
        this.typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
        TextView textView = this.troopFightingPower;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFightingPower");
            textView = null;
        }
        textView.setTypeface(this.typeface);
        TextView textView2 = this.gameCount;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameCount");
            textView2 = null;
        }
        textView2.setTypeface(this.typeface);
        TextView textView3 = this.gamePersonNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePersonNum");
            textView3 = null;
        }
        textView3.setTypeface(this.typeface);
        View view2 = this.titleContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TroopInfoCardHOKGameDataPart.Q9(TroopInfoCardHOKGameDataPart.this, view3);
            }
        });
        N9();
        View view3 = this.titleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view3 = null;
        }
        TroopCardDtHelper.m(view3, 1);
        View view4 = this.troopRankContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankContainer");
        } else {
            view = view4;
        }
        TroopCardDtHelper.m(view, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopInfoCardHOKGameDataPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.i> list) {
        LinearLayout linearLayout;
        int lastIndex;
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (true) {
            linearLayout = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.troop.troopcard.reborn.uimodel.i iVar = (com.tencent.mobileqq.troop.troopcard.reborn.uimodel.i) next;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168891h62, (ViewGroup) null);
            ImageView progressBar = (ImageView) inflate.findViewById(R.id.f2370075);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.xa8);
            TextView textView = (TextView) inflate.findViewById(R.id.xa9);
            TextView gradePercent = (TextView) inflate.findViewById(R.id.f2369074);
            gradePercent.setTextColor(iVar.b());
            TextView textView2 = (TextView) inflate.findViewById(R.id.f2371076);
            textView2.setTextColor(iVar.b());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(com.tencent.mobileqq.utils.am.a(2.0f));
            gradientDrawable.setColor(iVar.b());
            progressBar.setImageDrawable(gradientDrawable);
            imageView.setImageBitmap(iVar.d(i3));
            textView.setText(iVar.a());
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            Intrinsics.checkNotNullExpressionValue(gradePercent, "gradePercent");
            L9(progressBar, gradePercent, iVar.c());
            Typeface typeface = this.typeface;
            if (typeface != null) {
                gradePercent.setTypeface(typeface);
                textView2.setTypeface(Typeface.create(typeface, 1));
            }
            LinearLayout linearLayout2 = this.percentContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("percentContainer");
                linearLayout2 = null;
            }
            linearLayout2.addView(inflate, new LinearLayout.LayoutParams(0, com.tencent.mobileqq.utils.am.a(68.0f), 1.0f));
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (i3 != lastIndex) {
                LinearLayout linearLayout3 = this.percentContainer;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("percentContainer");
                } else {
                    linearLayout = linearLayout3;
                }
                linearLayout.addView(new View(getContext()), new LinearLayout.LayoutParams(com.tencent.mobileqq.utils.am.a(8.0f), com.tencent.mobileqq.utils.am.a(68.0f)));
            }
            i3 = i16;
        }
        LinearLayout linearLayout4 = this.percentContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("percentContainer");
        } else {
            linearLayout = linearLayout4;
        }
        com.tencent.mobileqq.utils.am.b(linearLayout);
    }

    private final void T9() {
        DialogUtil.createCustomDialog(getContext(), 230, getContext().getString(R.string.f23335771), ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopCardTipsContent(getContext()), (String) null, getContext().getString(R.string.f2333376z), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.aw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopInfoCardHOKGameDataPart.U9(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(TroopGameInfo gameInfo) {
        TextView textView = this.troopFightingPowerTitle;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFightingPowerTitle");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.f2335177g);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.troop_game_overcome)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf((int) (gameInfo.fightScoreRank * 100))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        View view = this.troopRankContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankContainer");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ay
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopInfoCardHOKGameDataPart.W9(TroopInfoCardHOKGameDataPart.this, view2);
            }
        });
        long j3 = gameInfo.fightScore;
        if (j3 < 10000) {
            TextView textView3 = this.troopFightingPower;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPower");
                textView3 = null;
            }
            textView3.setText(String.valueOf(gameInfo.fightScore));
            TextView textView4 = this.troopFightingPowerUnit;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPowerUnit");
                textView4 = null;
            }
            textView4.setVisibility(8);
        } else if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            TextView textView5 = this.troopFightingPower;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPower");
                textView5 = null;
            }
            String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(gameInfo.fightScore / 10000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView5.setText(format2);
            TextView textView6 = this.troopFightingPowerUnit;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPowerUnit");
                textView6 = null;
            }
            textView6.setText(getContext().getText(R.string.f2333276y));
        } else {
            TextView textView7 = this.troopFightingPower;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPower");
                textView7 = null;
            }
            String format3 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(gameInfo.fightScore / 100000000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            textView7.setText(format3);
            TextView textView8 = this.troopFightingPowerUnit;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopFightingPowerUnit");
                textView8 = null;
            }
            textView8.setText(getContext().getText(R.string.f2333076w));
        }
        TextView textView9 = this.gameCountTitle;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameCountTitle");
            textView9 = null;
        }
        textView9.setText(getContext().getText(R.string.f2334977e));
        TextView textView10 = this.gameCount;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameCount");
            textView10 = null;
        }
        textView10.setText(String.valueOf(gameInfo.weekGPlayGameCount));
        TextView textView11 = this.gamePersonNumTitle;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePersonNumTitle");
            textView11 = null;
        }
        textView11.setText(getContext().getText(R.string.f2335277h));
        TextView textView12 = this.gamePersonNum;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePersonNum");
        } else {
            textView2 = textView12;
        }
        textView2.setText(String.valueOf(gameInfo.weekPlayUserCount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TroopInfoCardHOKGameDataPart this$0, View view) {
        Map<String, String> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[2];
        TroopInfoCardGameViewModel troopInfoCardGameViewModel = this$0.viewModel;
        if (troopInfoCardGameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopInfoCardGameViewModel = null;
        }
        pairArr[0] = TuplesKt.to("group-code", troopInfoCardGameViewModel.Q1());
        pairArr[1] = TuplesKt.to("from", "groupCard");
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).openGameRankPage(this$0.getContext(), mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull final View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        LiveData<Boolean> w26 = troopBasicInfoViewModel.w2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(rootView) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardHOKGameDataPart$onInitView$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $rootView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$rootView = rootView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardHOKGameDataPart.this, (Object) rootView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    z16 = TroopInfoCardHOKGameDataPart.this.hasInitView;
                    if (!z16) {
                        TroopInfoCardHOKGameDataPart.this.hasInitView = true;
                        TroopInfoCardHOKGameDataPart.this.P9(this.$rootView);
                    }
                    View findViewById = this.$rootView.findViewById(R.id.vib);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<View>(R.id.game_card)");
                    findViewById.setVisibility(0);
                    return;
                }
                View findViewById2 = this.$rootView.findViewById(R.id.vib);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<View>(R.id.game_card)");
                findViewById2.setVisibility(8);
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardHOKGameDataPart.R9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopInfoCardGameViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopInfoCa\u2026ameViewModel::class.java)");
        this.viewModel = (TroopInfoCardGameViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.troopBasicInfoViewModel = (TroopBasicInfoViewModel) viewModel2;
        TroopInfoCardGameViewModel troopInfoCardGameViewModel = this.viewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (troopInfoCardGameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopInfoCardGameViewModel = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel2;
        }
        troopInfoCardGameViewModel.R1(troopBasicInfoViewModel.K2());
    }
}
