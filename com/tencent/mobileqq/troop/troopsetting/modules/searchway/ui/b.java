package com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJD\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tH\u0007J&\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0016\u001a\u00020\u0013*\u00020\u0004R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/b;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "curOption", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "Lkotlin/Function1;", "", "newOptionSelected", "Lcom/tencent/widget/ActionSheet;", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "b", "actionSheet", "d", "", "position", "c", "g", "", "Ljava/util/List;", "emIds", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f301224a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> emIds;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f301226a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25283);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopSearchWay.values().length];
            try {
                iArr[TroopSearchWay.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopSearchWay.PUBLIC_UIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TroopSearchWay.PUBLIC_UIN_AND_KEYWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f301226a = iArr;
        }
    }

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f301224a = new b();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"em_group_search_unsearchable", "em_group_search_groupid", "em_group_search_groupid_keyword"});
        emIds = listOf;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(View rootView, Map<String, ? extends Object> pageParams) {
        VideoReport.setPageId(rootView, "pg_group_set");
        VideoReport.setPageParams(rootView, new PageParams(pageParams));
    }

    private final void c(ActionSheet actionSheet, int position) {
        LinearLayout linearLayout = actionSheet.mContentContainer;
        if (linearLayout.getChildCount() < 3 || position >= 3) {
            return;
        }
        View childAt = linearLayout.getChildAt(position);
        VideoReport.setElementId(childAt, emIds.get(position));
        VideoReport.reportEvent("clck", childAt, null);
    }

    private final void d(ActionSheet actionSheet) {
        LinearLayout linearLayout = actionSheet.mContentContainer;
        if (linearLayout.getChildCount() < 3) {
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            VideoReport.setElementId(childAt, emIds.get(i3));
            VideoReport.reportEvent("imp", childAt, null);
        }
    }

    @JvmStatic
    @NotNull
    public static final ActionSheet e(@NotNull Context context, @NotNull TroopSearchWay curOption, @Nullable Map<String, ? extends Object> pageParams, @NotNull final Function1<? super TroopSearchWay, Unit> newOptionSelected) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(curOption, "curOption");
        Intrinsics.checkNotNullParameter(newOptionSelected, "newOptionSelected");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        for (TroopSearchWay troopSearchWay : TroopSearchWay.values()) {
            String string = context.getString(f301224a.g(troopSearchWay));
            if (troopSearchWay == curOption) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(string, z16);
        }
        actionSheet.setMainTitle(R.string.f235397bj);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                b.f(Function1.this, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
        b bVar = f301224a;
        ViewGroup rootView = actionSheet.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "actionSheet.rootView");
        bVar.b(rootView, pageParams);
        bVar.d(actionSheet);
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 newOptionSelected, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(newOptionSelected, "$newOptionSelected");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        newOptionSelected.invoke(TroopSearchWay.values()[i3]);
        actionSheet.dismiss();
        f301224a.c(actionSheet, i3);
    }

    public final int g(@NotNull TroopSearchWay troopSearchWay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopSearchWay)).intValue();
        }
        Intrinsics.checkNotNullParameter(troopSearchWay, "<this>");
        int i3 = a.f301226a[troopSearchWay.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return R.string.f235487bs;
                }
                throw new NoWhenBranchMatchedException();
            }
            return R.string.f235477br;
        }
        return R.string.f235457bp;
    }
}
