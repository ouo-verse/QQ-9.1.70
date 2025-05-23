package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.animation.ValueAnimator;
import android.app.Activity;
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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.TroopInfoCardGameViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troop.troopgame.data.TroopMetaDreamGameInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardMDGameDataPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "L9", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/n;", "list", "R9", "Landroid/widget/ImageView;", "progressBar", "Landroid/widget/TextView;", "percentView", "", "percent", "J9", "Lcom/tencent/mobileqq/troop/troopgame/data/TroopMetaDreamGameInfo;", "gameInfo", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "e", "Landroid/view/View;", "titleContainer", "f", "gameInfoContainer", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "percentContainer", "i", "rankContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "gameCount", BdhLogUtil.LogTag.Tag_Conn, "gamePersonNum", "Landroid/graphics/Typeface;", "D", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/TroopInfoCardGameViewModel;", "E", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/TroopInfoCardGameViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopBasicInfoViewModel", "", "G", "Z", "hasInitView", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardMDGameDataPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView gamePersonNum;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Typeface typeface;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopInfoCardGameViewModel viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopBasicInfoViewModel troopBasicInfoViewModel;

    /* renamed from: G, reason: from kotlin metadata */
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
    private View rankContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView gameCount;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardMDGameDataPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMDGameDataPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardMDGameDataPart(@NotNull AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.appInterface = appInterface;
        }
    }

    private final void J9(final ImageView progressBar, final TextView percentView, int percent) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, percent);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopInfoCardMDGameDataPart.K9(percentView, progressBar, valueAnimator);
            }
        });
        ofInt.setDuration(800L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TextView percentView, ImageView progressBar, ValueAnimator valueAnimator) {
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

    private final void L9() {
        TroopInfoCardGameViewModel troopInfoCardGameViewModel = this.viewModel;
        TroopInfoCardGameViewModel troopInfoCardGameViewModel2 = null;
        if (troopInfoCardGameViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopInfoCardGameViewModel = null;
        }
        LiveData<TroopMetaDreamGameInfo> P1 = troopInfoCardGameViewModel.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TroopMetaDreamGameInfo, Unit> function1 = new Function1<TroopMetaDreamGameInfo, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMDGameDataPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardMDGameDataPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMetaDreamGameInfo troopMetaDreamGameInfo) {
                invoke2(troopMetaDreamGameInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopMetaDreamGameInfo troopMetaDreamGameInfo) {
                View view;
                LinearLayout linearLayout;
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMetaDreamGameInfo);
                    return;
                }
                view = TroopInfoCardMDGameDataPart.this.gameInfoContainer;
                LinearLayout linearLayout2 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gameInfoContainer");
                    view = null;
                }
                int i3 = 0;
                view.setVisibility(troopMetaDreamGameInfo != null ? 0 : 8);
                if (troopMetaDreamGameInfo != null) {
                    TroopInfoCardMDGameDataPart troopInfoCardMDGameDataPart = TroopInfoCardMDGameDataPart.this;
                    linearLayout = troopInfoCardMDGameDataPart.percentContainer;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("percentContainer");
                    } else {
                        linearLayout2 = linearLayout;
                    }
                    linearLayout2.setVisibility(true ^ troopMetaDreamGameInfo.getGradeDistributedList().isEmpty() ? 0 : 8);
                    Iterator<T> it = troopMetaDreamGameInfo.getGradeDistributedList().iterator();
                    while (it.hasNext()) {
                        i3 += ((TroopMetaDreamGameInfo.b) it.next()).b();
                    }
                    List<TroopMetaDreamGameInfo.b> gradeDistributedList = troopMetaDreamGameInfo.getGradeDistributedList();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(gradeDistributedList, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (TroopMetaDreamGameInfo.b bVar : gradeDistributedList) {
                        arrayList.add(new com.tencent.mobileqq.troop.troopcard.reborn.uimodel.n(bVar.d(), bVar.a(), bVar.c(), bVar.b(), i3));
                    }
                    troopInfoCardMDGameDataPart.R9(arrayList);
                    troopInfoCardMDGameDataPart.P9(troopMetaDreamGameInfo);
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardMDGameDataPart.M9(Function1.this, obj);
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
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(View rootView) {
        View findViewById = rootView.findViewById(R.id.z5q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026etadream_game_card_title)");
        this.titleContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.z5r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ream_game_info_container)");
        this.gameInfoContainer = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.z5s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026e_distribution_container)");
        this.percentContainer = (LinearLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.z5v);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026metadream_item_card_rank)");
        this.rankContainer = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.z5u).findViewById(R.id.f101875wd);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.troop_game_num_a_week)");
        this.gameCount = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.z5w).findViewById(R.id.f101885we);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.troop_game_person_num_a_week)");
        this.gamePersonNum = (TextView) findViewById6;
        this.typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf");
        TextView textView = this.gameCount;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameCount");
            textView = null;
        }
        textView.setTypeface(this.typeface);
        TextView textView2 = this.gamePersonNum;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePersonNum");
            textView2 = null;
        }
        textView2.setTypeface(this.typeface);
        L9();
        View view = this.titleContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            view = null;
        }
        TroopCardDtHelper.p(view, "em_group_fun_party_card", null, 4, null);
        View view2 = this.rankContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankContainer");
            view2 = null;
        }
        TroopCardDtHelper.p(view2, "em_group_fun_party_rank", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(final TroopMetaDreamGameInfo gameInfo) {
        View view = this.rankContainer;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankContainer");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopInfoCardMDGameDataPart.Q9(TroopInfoCardMDGameDataPart.this, gameInfo, view2);
            }
        });
        TextView textView2 = this.gameCount;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameCount");
            textView2 = null;
        }
        textView2.setText(String.valueOf(gameInfo.getRecentGameNum()));
        TextView textView3 = this.gamePersonNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePersonNum");
        } else {
            textView = textView3;
        }
        textView.setText(String.valueOf(gameInfo.getRecentUserNum()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopInfoCardMDGameDataPart this$0, TroopMetaDreamGameInfo gameInfo, View view) {
        String replace$default;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gameInfo, "$gameInfo");
        TroopBasicInfoViewModel troopBasicInfoViewModel = this$0.troopBasicInfoViewModel;
        BaseQQAppInterface baseQQAppInterface = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        String K2 = troopBasicInfoViewModel.K2();
        replace$default = StringsKt__StringsJVMKt.replace$default(gameInfo.getRankPageUrl(), "{group_code}", K2, false, 4, (Object) null);
        QLog.d("TroopInfoCardMDGameDataPart", 1, "goto rank page(" + replace$default + "), troopUin=" + K2);
        AppInterface appInterface = this$0.appInterface;
        if (appInterface instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appInterface;
        }
        com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c(baseQQAppInterface, this$0.getActivity(), replace$default);
        if (c16 != null) {
            c16.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.n> list) {
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
            com.tencent.mobileqq.troop.troopcard.reborn.uimodel.n nVar = (com.tencent.mobileqq.troop.troopcard.reborn.uimodel.n) next;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168891h62, (ViewGroup) null);
            ImageView progressBar = (ImageView) inflate.findViewById(R.id.f2370075);
            ImageView gradeIcon = (ImageView) inflate.findViewById(R.id.xa8);
            TextView textView = (TextView) inflate.findViewById(R.id.xa9);
            TextView gradePercent = (TextView) inflate.findViewById(R.id.f2369074);
            gradePercent.setTextColor(nVar.b());
            TextView textView2 = (TextView) inflate.findViewById(R.id.f2371076);
            textView2.setTextColor(nVar.b());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(com.tencent.mobileqq.utils.am.a(2.0f));
            gradientDrawable.setColor(nVar.b());
            progressBar.setImageDrawable(gradientDrawable);
            Intrinsics.checkNotNullExpressionValue(gradeIcon, "gradeIcon");
            nVar.d(gradeIcon);
            textView.setText(nVar.a());
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            Intrinsics.checkNotNullExpressionValue(gradePercent, "gradePercent");
            J9(progressBar, gradePercent, nVar.c());
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
            linearLayout2.addView(inflate, new LinearLayout.LayoutParams(com.tencent.mobileqq.utils.am.a(42.0f), com.tencent.mobileqq.utils.am.a(68.0f)));
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
        LiveData<Boolean> x26 = troopBasicInfoViewModel.x2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(rootView) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMDGameDataPart$onInitView$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $rootView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$rootView = rootView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardMDGameDataPart.this, (Object) rootView);
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
                    z16 = TroopInfoCardMDGameDataPart.this.hasInitView;
                    if (!z16) {
                        TroopInfoCardMDGameDataPart.this.hasInitView = true;
                        TroopInfoCardMDGameDataPart.this.N9(this.$rootView);
                    }
                    View findViewById = this.$rootView.findViewById(R.id.z5p);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026.id.meta_dream_game_card)");
                    findViewById.setVisibility(0);
                    return;
                }
                View findViewById2 = this.$rootView.findViewById(R.id.z5p);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Vi\u2026.id.meta_dream_game_card)");
                findViewById2.setVisibility(8);
            }
        };
        x26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.az
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardMDGameDataPart.O9(Function1.this, obj);
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
