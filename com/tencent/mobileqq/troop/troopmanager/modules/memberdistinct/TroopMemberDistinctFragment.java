package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J)\u0010\u001b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u0010j\u0002`\u001aH\u0002J<\u0010\"\u001a6\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00040\u001cj\u0002`!H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J \u0010(\u001a\u00020\u00042\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u001f0%j\b\u0012\u0004\u0012\u00020\u001f`&H\u0002J\b\u0010)\u001a\u00020\u0004H\u0016J$\u00100\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\"\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00109R\u0016\u0010P\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR&\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u001f0%j\b\u0012\u0004\u0012\u00020\u001f`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR*\u0010X\u001a\u0016\u0012\u0004\u0012\u00020V\u0018\u00010%j\n\u0012\u0004\u0012\u00020V\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010T\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", OcrConfig.CHINESE, "yh", "Ch", "Ah", "Bh", "Oh", "Nh", "Landroid/content/Intent;", "data", "Ih", "Hh", "Lkotlin/Function1;", "", "resultBlock", "Lh", "Ph", "Rh", "", "Lkotlin/ParameterName;", "name", "rspData", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/DuplicateMembersSuccessBlock;", "Jh", "Lkotlin/Function2;", "", "errorCode", "", "errorMsg", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/TroopQueryErrorBlock;", "Gh", "Qh", "Kh", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "chooseGroup", "Fh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mContext", "D", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "E", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "navBar", UserInfo.SEX_FEMALE, "distinctBtn", "G", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "groupTextView", "I", "checkDesc", "Landroid/widget/RelativeLayout;", "J", "Landroid/widget/RelativeLayout;", "loadAnimationContent", "K", "loadAnimation", "L", "Ljava/lang/String;", "troopUin", "M", "userFrom", "N", "Ljava/util/ArrayList;", "chooseArray", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "P", "chooseResultRecordList", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberDistinctFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private NavBarCommon navBar;

    /* renamed from: F, reason: from kotlin metadata */
    private View distinctBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private View chooseGroup;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView groupTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView checkDesc;

    /* renamed from: J, reason: from kotlin metadata */
    private RelativeLayout loadAnimationContent;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View loadAnimation;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String userFrom;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ArrayList<String> chooseArray;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ArrayList<ResultRecord> chooseResultRecordList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctFragment$a;", "", "", "LOAD_ANIMATION_PAG_PATH", "Ljava/lang/String;", "", "PAG_MAX_HS_RATIO", "D", "PAG_WH_RATIO", "", "REQUEST_RESULT_FRAGMENT_CODE", "I", "REQUEST_SELECT_TROOP_CODE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctFragment$b", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberDistinctFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(@Nullable View v3, int item) {
            FragmentActivity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, item);
            } else if (item == 1 && (activity = TroopMemberDistinctFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberDistinctFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "0";
        this.userFrom = "1";
        this.chooseArray = new ArrayList<>();
    }

    private final void Ah(View rootView) {
        View findViewById = rootView.findViewById(R.id.rlCommenTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rlCommenTitle)");
        NavBarCommon navBarCommon = (NavBarCommon) findViewById;
        this.navBar = navBarCommon;
        NavBarCommon navBarCommon2 = null;
        if (navBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            navBarCommon = null;
        }
        navBarCommon.setTitle(getString(R.string.f180863c8));
        NavBarCommon navBarCommon3 = this.navBar;
        if (navBarCommon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            navBarCommon3 = null;
        }
        navBarCommon3.setLeftBackVisible(0);
        NavBarCommon navBarCommon4 = this.navBar;
        if (navBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            navBarCommon4 = null;
        }
        navBarCommon4.changeBg(!QQTheme.isNowThemeIsNight());
        int g16 = ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000);
        NavBarCommon navBarCommon5 = this.navBar;
        if (navBarCommon5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            navBarCommon5 = null;
        }
        navBarCommon5.setTitleColor(g16);
        NavBarCommon navBarCommon6 = this.navBar;
        if (navBarCommon6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
        } else {
            navBarCommon2 = navBarCommon6;
        }
        navBarCommon2.setOnItemSelectListener(new b());
    }

    private final void Bh(View rootView) {
        float f16 = x.f(getContext()).f185861b;
        final float f17 = x.f(getContext()).f185860a;
        final double min = Math.min(f17 * 0.48d, f16 * 0.5d);
        View findViewById = rootView.findViewById(R.id.f220402n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.page_load_animation)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.loadAnimationContent = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadAnimationContent");
            relativeLayout = null;
        }
        relativeLayout.setMinimumHeight((int) min);
        Lh(new Function1<Boolean, Unit>(f17, min) { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctFragment$doInitPagAnimation$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ double $animationViewHeight;
            final /* synthetic */ float $animationViewWidth;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$animationViewWidth = f17;
                this.$animationViewHeight = min;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopMemberDistinctFragment.this, Float.valueOf(f17), Double.valueOf(min));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                RelativeLayout relativeLayout2;
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (z16 && TroopMemberDistinctFragment.this.getContext() != null) {
                    TroopMemberDistinctFragment troopMemberDistinctFragment = TroopMemberDistinctFragment.this;
                    PAGView pAGView = new PAGView(TroopMemberDistinctFragment.this.getContext());
                    pAGView.setPath("assets://pag/troop_member_distinct_animation.pag");
                    pAGView.setRepeatCount(-1);
                    troopMemberDistinctFragment.loadAnimation = pAGView;
                    relativeLayout2 = TroopMemberDistinctFragment.this.loadAnimationContent;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadAnimationContent");
                        relativeLayout2 = null;
                    }
                    view = TroopMemberDistinctFragment.this.loadAnimation;
                    relativeLayout2.addView(view, (int) this.$animationViewWidth, (int) this.$animationViewHeight);
                    return;
                }
                QLog.i(QPublicBaseFragment.TAG, 1, "[doInitPagAnimation] isInitPagSo = " + z16 + " context = " + TroopMemberDistinctFragment.this.getContext());
            }
        });
    }

    private final void Ch(View rootView) {
        View view;
        Ah(rootView);
        Bh(rootView);
        View findViewById = rootView.findViewById(R.id.te4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_distinct)");
        this.distinctBtn = findViewById;
        View view2 = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            findViewById = null;
        }
        findViewById.setEnabled(false);
        View view3 = this.distinctBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                TroopMemberDistinctFragment.Dh(TroopMemberDistinctFragment.this, view4);
            }
        });
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.f300570a;
        View view4 = this.distinctBtn;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        } else {
            view = view4;
        }
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.b(aVar, "dt_imp", view, "em_group_start_deduplication_btn", null, 8, null);
        View findViewById2 = rootView.findViewById(R.id.tw9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.choose_group)");
        this.chooseGroup = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chooseGroup");
        } else {
            view2 = findViewById2;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                TroopMemberDistinctFragment.Eh(TroopMemberDistinctFragment.this, view5);
            }
        });
        View findViewById3 = rootView.findViewById(R.id.vtl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.group_count_textview)");
        this.groupTextView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.tvb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.check_desc)");
        this.checkDesc = (TextView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(TroopMemberDistinctFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(TroopMemberDistinctFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Nh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Fh(ArrayList<String> chooseGroup) {
        String joinToString$default;
        HashMap hashMap = new HashMap();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(chooseGroup, ";", null, null, 0, null, null, 62, null);
        hashMap.put("choose_group_id", joinToString$default);
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.f300570a;
        View view = this.distinctBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        aVar.a("dt_clck", view, "em_group_start_deduplication_btn", hashMap);
    }

    private final Function2<Integer, String, Unit> Gh() {
        return new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctFragment$handleErrorBlock$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberDistinctFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                TroopMemberDistinctFragment.this.Qh();
                QQToastUtil.showQQToast(1, R.string.f180873c9);
            }
        };
    }

    private final void Hh() {
        View view = this.distinctBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        VideoReport.reportEvent("dt_imp", view, null);
    }

    private final void Ih(Intent data) {
        ArrayList<ResultRecord> arrayList;
        String string;
        Integer num;
        this.chooseArray.clear();
        Integer num2 = null;
        if (data != null) {
            arrayList = data.getParcelableArrayListExtra("selected_target_list");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                this.chooseArray.add(((ResultRecord) it.next()).uin);
            }
        }
        this.chooseResultRecordList = arrayList;
        View view = this.distinctBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        view.setEnabled(!this.chooseArray.isEmpty());
        TextView textView = this.groupTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupTextView");
            textView = null;
        }
        if (!this.chooseArray.isEmpty()) {
            String string2 = getString(R.string.f180763by);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.qb_tr\u2026er_distinct_choose_count)");
            Object[] objArr = new Object[1];
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            objArr[0] = num;
            string = String.format(string2, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(this, *args)");
        } else {
            string = getString(R.string.f180773bz);
        }
        textView.setText(string);
        if (arrayList != null) {
            num2 = Integer.valueOf(arrayList.size());
        }
        QLog.i("TroopMemberDistinct", 1, "choose group finish, [count:" + num2 + "]");
    }

    private final Function1<byte[], Unit> Jh() {
        return new TroopMemberDistinctFragment$handleSuccessBlock$1(this);
    }

    private final boolean Kh() {
        View view = this.distinctBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        if (!view.isEnabled() && !this.chooseArray.isEmpty()) {
            return false;
        }
        return true;
    }

    private final void Lh(final Function1<? super Boolean, Unit> resultBlock) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberDistinctFragment.Mh(Function1.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 resultBlock) {
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new TroopMemberDistinctFragment$loadPagSoAsync$1$1(resultBlock));
    }

    private final void Nh() {
        if (!Kh()) {
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106129", true)) {
            ITroopSelectorApi iTroopSelectorApi = (ITroopSelectorApi) QRoute.api(ITroopSelectorApi.class);
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            iTroopSelectorApi.openNewTroopSelector(context, new Intent(), new TroopSelectorConfig(true, 10, false, false, false, this.chooseResultRecordList, 0, 28, null), 1000);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_MANAGE_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_JOIN_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_UN_NAME_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_SHOW_SET_TOP_TROOP, false);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, 10);
        ArrayList<ResultRecord> arrayList = this.chooseResultRecordList;
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectTroopListForResult(this, intent, 1000);
    }

    private final void Oh() {
        View view = this.distinctBtn;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        view.setEnabled(false);
        TextView textView2 = this.checkDesc;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkDesc");
        } else {
            textView = textView2;
        }
        textView.setText(getString(R.string.f180743bw));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.chooseArray);
        Ph();
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.a.f300571a;
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.a((String[]) array, Jh(), Gh());
        Fh(this.chooseArray);
    }

    private final void Ph() {
        PAGView pAGView;
        View view = this.loadAnimation;
        if (view instanceof PAGView) {
            pAGView = (PAGView) view;
        } else {
            pAGView = null;
        }
        if (pAGView != null) {
            pAGView.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        View view = this.distinctBtn;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distinctBtn");
            view = null;
        }
        view.setEnabled(true);
        TextView textView2 = this.checkDesc;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkDesc");
        } else {
            textView = textView2;
        }
        textView.setText(getString(R.string.f180793c1));
        Rh();
    }

    private final void Rh() {
        PAGView pAGView;
        View view = this.loadAnimation;
        if (view instanceof PAGView) {
            pAGView = (PAGView) view;
        } else {
            pAGView = null;
        }
        if (pAGView != null) {
            pAGView.stop();
        }
        if (pAGView != null) {
            pAGView.setProgress(0.0d);
        }
    }

    private final void yh() {
        String string = requireArguments().getString("troop_uin", "0");
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getSt\u2026EY_INTENT_TROOP_UIN, \"0\")");
        this.troopUin = string;
        String string2 = requireArguments().getString(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "1");
        Intrinsics.checkNotNullExpressionValue(string2, "requireArguments().getSt\u2026EY_INTENT_USER_FROM, \"1\")");
        this.userFrom = string2;
    }

    private final void zh(View rootView) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0M2003OIIM08YV9M");
        hashMap.put("group_id", this.troopUin);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.userFrom);
        VideoReport.setPageId(rootView, "pg_group_members_deduplication");
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_ALL);
        VideoReport.reportPgIn(rootView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (requestCode != 1000) {
            if (requestCode == 1001) {
                Hh();
            }
        } else if (resultCode == -1) {
            Ih(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.mContext = requireActivity;
            View inflate = inflater.inflate(R.layout.f168610g14, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026stinct, container, false)");
            this.mRootView = inflate;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                View view2 = this.mRootView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view2 = null;
                }
                view2.setFitsSystemWindows(true);
                View view3 = this.mRootView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view3 = null;
                }
                view3.setPadding(0, ImmersiveUtils.getStatusBarHeight(inflater.getContext()), 0, 0);
            }
            yh();
            View view4 = this.mRootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view4 = null;
            }
            zh(view4);
            View view5 = this.mRootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view5 = null;
            }
            Ch(view5);
            view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.reportPgOut(view);
        super.onDestroy();
    }
}
