package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.model.TroopPersonalSettingData;
import com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R4\u0010\u0019\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00150\u0014j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingPersonalAndOtherPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "M9", "N9", "O9", "", "troopUin", "", "L9", "Q9", "T9", "P9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/f;", "f", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/f;", "gameInfoItem", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "personalSettingConfig", "i", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingPersonalAndOtherPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.x<?, ?>> configList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.f gameInfoItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<?, ?> personalSettingConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group[] groups;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingPersonalAndOtherPart$a;", "", "", "LUCKY_CHARACTER_FLAG", "I", "", "SP_KEY_PERSONAL_SETTING_FOR_NEW_SHORTCUT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingPersonalAndOtherPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingPersonalAndOtherPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configList = new ArrayList<>();
            this.groups = new Group[0];
        }
    }

    private final boolean L9(String troopUin) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        if (!((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).useNewShortcut(troopUin)) {
            QLog.d("TroopSettingPersonalAndOtherPart", 2, "no red point for no new shortcut, troopUin: " + troopUin);
            return false;
        }
        TroopShortcutSettingCache.Companion companion = TroopShortcutSettingCache.INSTANCE;
        TroopShortcutSettingCache a16 = companion.a();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (a16.f(j3)) {
            return false;
        }
        TroopShortcutSettingCache a17 = companion.a();
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        if (a17.d(j16)) {
            QLog.d("TroopSettingPersonalAndOtherPart", 2, "no red point for disableCapsule");
            return false;
        }
        boolean isEmptyRedPointSP = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("troop_new_shortcut" + z9().getCurrentAccountUin());
        QLog.d("TroopSettingPersonalAndOtherPart", 2, "canShowRedDot:" + isEmptyRedPointSP + " for app.currentAccountUin");
        return isEmptyRedPointSP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        boolean z16;
        com.tencent.mobileqq.troop.troopsetting.bizconfig.f fVar;
        String stringExtra = getActivity().getIntent().getStringExtra("focusItem");
        if (stringExtra == null) {
            Bundle arguments = getPartHost().getArguments();
            if (arguments != null) {
                stringExtra = arguments.getString("focusItem", "");
            } else {
                stringExtra = null;
            }
        }
        boolean z17 = false;
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.bizconfig.f fVar2 = this.gameInfoItem;
        if (fVar2 != null && fVar2.getIsVisible()) {
            z17 = true;
        }
        if (z17 && (fVar = this.gameInfoItem) != null) {
            fVar.Y();
        }
    }

    private final void N9() {
        Q9();
        O9();
        CharSequence d16 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.d(getContext().getResources().getString(R.string.f2068059a));
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.x[] xVarArr = (com.tencent.mobileqq.widget.listitem.x[]) array;
        this.groups = new Group[]{new Group(d16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length))};
    }

    private final void O9() {
        if (B9().T3()) {
            com.tencent.mobileqq.troop.troopsetting.bizconfig.f fVar = new com.tencent.mobileqq.troop.troopsetting.bizconfig.f(getContext(), x9(), B9());
            this.gameInfoItem = fVar;
            this.configList.add(fVar);
        }
    }

    private final void P9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingPersonalAndOtherPart$initObserve$1(this, null), 3, null);
    }

    private final void Q9() {
        String string = getContext().getResources().getString(R.string.f235317bb);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026g.troop_personal_setting)");
        x.b.d dVar = new x.b.d(string);
        x.c.g gVar = new x.c.g("", false, false, 6, null);
        String str = B9().T2().troopUin;
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "viewModel.troopInfoData.troopUin ?: \"\"");
        }
        gVar.g(L9(str));
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, gVar);
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingPersonalAndOtherPart.R9(TroopSettingPersonalAndOtherPart.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bv
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingPersonalAndOtherPart.S9(view);
            }
        });
        this.personalSettingConfig = xVar;
        this.configList.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(TroopSettingPersonalAndOtherPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.activity.c.c(it);
    }

    private final void T9() {
        QBaseActivity qBaseActivity;
        boolean z16;
        x.c.g gVar;
        Activity activity = getActivity();
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        TroopInfo S2 = B9().S2();
        TroopInfoData T2 = B9().T2();
        if (S2.troopuin != null && T2.troopUin != null && getContext() != null) {
            String str = S2.troopuin;
            Intrinsics.checkNotNullExpressionValue(str, "info.troopuin");
            boolean isHomeworkTroop = S2.isHomeworkTroop();
            boolean isQidianPrivateTroop = S2.isQidianPrivateTroop();
            if ((S2.groupFlagExt4 & 32768) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str2 = T2.troopColorNick;
            int i3 = T2.troopColorNickId;
            String c16 = eu.c(T2);
            Intrinsics.checkNotNullExpressionValue(c16, "getIDReport(infoData)");
            TroopPersonalSettingData troopPersonalSettingData = new TroopPersonalSettingData(str, isHomeworkTroop, isQidianPrivateTroop, z16, str2, i3, c16);
            com.tencent.mobileqq.widget.listitem.x<?, ?> xVar2 = this.personalSettingConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personalSettingConfig");
                xVar2 = null;
            }
            Object O = xVar2.O();
            if (O instanceof x.c.g) {
                gVar = (x.c.g) O;
            } else {
                gVar = null;
            }
            if (gVar != null && gVar.getShowRedPoint()) {
                ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setRedPointSP("troop_new_shortcut" + z9().getCurrentAccountUin());
                gVar.g(false);
                com.tencent.mobileqq.widget.listitem.x<?, ?> xVar3 = this.personalSettingConfig;
                if (xVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personalSettingConfig");
                } else {
                    xVar = xVar3;
                }
                D9(xVar);
            }
            TroopPersonalSettingFragment.Companion companion = TroopPersonalSettingFragment.INSTANCE;
            Activity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            companion.a((QBaseActivity) activity2, troopPersonalSettingData, 23);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.groups;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        N9();
        P9();
        M9();
    }
}
