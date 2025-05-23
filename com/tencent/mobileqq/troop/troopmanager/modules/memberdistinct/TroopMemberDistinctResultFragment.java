package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.TroopMemberDistinctResultListItemType;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.TroopMemberDetectSvr$DuplicateMember;
import com.tencent.protofile.TroopMemberDetectSvr$GroupInfo;
import com.tencent.protofile.TroopMemberDetectSvr$QueryDuplicateMembersRsp;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\r\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f`\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J<\u0010\u001b\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0013j\u0002`\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0002\u00a2\u0006\u0004\b!\u0010\"J \u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00140%j\b\u0012\u0004\u0012\u00020\u0014`&2\u0006\u0010$\u001a\u00020#H\u0002J\u001e\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0*H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0002H\u0016J$\u00107\u001a\u00020\u00042\u0006\u00102\u001a\u0002012\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u000105H\u0016J*\u0010:\u001a\u00020\u00022\"\u00109\u001a\u001e\u0012\u0004\u0012\u00020(\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020(0%j\b\u0012\u0004\u0012\u00020(`&08R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010@R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010@R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000b0 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R0\u0010b\u001a\u001e\u0012\u0004\u0012\u00020(\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140%j\b\u0012\u0004\u0012\u00020\u0014`&0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR0\u0010d\u001a\u001e\u0012\u0004\u0012\u00020(\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020(0%j\b\u0012\u0004\u0012\u00020(`&0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010g\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctResultFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ch", OcrConfig.CHINESE, "Bh", "Ah", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "uh", "", "data", "Oh", "Nh", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "Lkotlin/ParameterName;", "name", "itemModel", "", "isChecked", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TapItemCallback;", "Hh", "Ih", "Gh", "Kh", "xh", "", "Fh", "()[Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/model/a;", "Lcom/tencent/protofile/TroopMemberDetectSvr$DuplicateMember;", "repeatMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vh", "", "groupCode", "", "qqList", "wh", "Jh", "isConfirm", "Ph", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "troops", "Qh", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "mContext", "D", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "E", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "navBar", UserInfo.SEX_FEMALE, "btnDelete", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "resultList", "H", "resultListContainer", "Landroid/widget/FrameLayout;", "I", "Landroid/widget/FrameLayout;", "resultEmpty", "Lcom/tencent/common/app/AppInterface;", "J", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/k;", "K", "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/k;", "resultListAdapter", "L", "[Ljava/lang/String;", "chooseTroop", "", "M", "Ljava/util/Map;", "chooseRepeatUser", "N", "deleteTroop", "P", "Ljava/lang/String;", "troopUin", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberDistinctResultFragment extends QPublicBaseFragment {
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
    private View btnDelete;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView resultList;

    /* renamed from: H, reason: from kotlin metadata */
    private View resultListContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout resultEmpty;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private AppInterface app;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultListAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String[] chooseTroop;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a>> chooseRepeatUser;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, ArrayList<Long>> deleteTroop;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctResultFragment$a;", "", "", "EC_GROUP_DEL_CONFIRM_POP_CLCK", "Ljava/lang/String;", "EC_GROUP_DEL_CONFIRM_POP_IMP", "EV_GROUP_MEMBERS_DEDUPLICATION", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctResultFragment$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/TroopMemberDistinctResultFragment$b", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberDistinctResultFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(@Nullable View v3, int item) {
            FragmentActivity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, item);
            } else if (item == 1 && (activity = TroopMemberDistinctResultFragment.this.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberDistinctResultFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopMemberDistinctResultFragment$resultListAdapter$2.INSTANCE);
            this.resultListAdapter = lazy;
            this.chooseTroop = new String[0];
            this.chooseRepeatUser = new LinkedHashMap();
            this.deleteTroop = new LinkedHashMap();
            this.troopUin = "";
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Ah(View rootView) {
        String joinToString$default;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0M2003OIIM08YV9M");
        hashMap.put("group_id", Long.valueOf(Long.parseLong(this.troopUin)));
        hashMap.put("pg_state", Integer.valueOf(!this.chooseRepeatUser.isEmpty() ? 1 : 0));
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.chooseTroop, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        hashMap.put("choose_group_id", joinToString$default);
        VideoReport.setPageId(rootView, "pg_group_duplicate_member_list");
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_ALL);
        VideoReport.reportPgIn(rootView);
    }

    private final void Bh(View rootView) {
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

    private final void Ch(View rootView) {
        Bh(rootView);
        View findViewById = rootView.findViewById(R.id.agp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.btn_delete)");
        this.btnDelete = findViewById;
        RecyclerView recyclerView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberDistinctResultFragment.Dh(TroopMemberDistinctResultFragment.this, view);
            }
        });
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.f300570a;
        View view = this.btnDelete;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
            view = null;
        }
        aVar.a("dt_imp", view, "em_group_members_del_btn", uh());
        View findViewById2 = rootView.findViewById(R.id.f73723ub);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.result_list_container)");
        this.resultListContainer = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f73713ua);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.result_list)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById3;
        this.resultList = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultList");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView3 = this.resultList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultList");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setAdapter(Eh());
        Eh().p0(Hh());
        zh(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(TroopMemberDistinctResultFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final k Eh() {
        return (k) this.resultListAdapter.getValue();
    }

    private final com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] Fh() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a>>> it = this.chooseRepeatUser.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[]) array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a itemModel, boolean isChecked) {
        Long l3;
        Long l16;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        TroopMemberDetectSvr$DuplicateMember b16 = itemModel.b();
        View view = null;
        if (b16 != null && (pBUInt64Field2 = b16.uin) != null) {
            l3 = Long.valueOf(es2.a.b(pBUInt64Field2));
        } else {
            l3 = null;
        }
        TroopMemberDetectSvr$GroupInfo a16 = itemModel.a();
        if (a16 != null && (pBUInt64Field = a16.group_id) != null) {
            l16 = Long.valueOf(es2.a.b(pBUInt64Field));
        } else {
            l16 = null;
        }
        if (l3 != null && l16 != null) {
            ArrayList<Long> arrayList = this.deleteTroop.get(l16);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.deleteTroop.put(l16, arrayList);
            }
            if (isChecked) {
                arrayList.add(l3);
            } else {
                arrayList.remove(l3);
            }
            itemModel.e(isChecked);
        }
        View view2 = this.btnDelete;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
            view2 = null;
        }
        view2.setEnabled(Jh());
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.f300570a;
        View view3 = this.btnDelete;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
        } else {
            view = view3;
        }
        aVar.a("dt_imp", view, "em_group_members_del_btn", uh());
    }

    private final Function2<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, Boolean, Unit> Hh() {
        return new Function2<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a, Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctResultFragment$handleTapResultItem$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberDistinctResultFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a aVar, Boolean bool) {
                invoke(aVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a itemModel, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, itemModel, Boolean.valueOf(z16));
                    return;
                }
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                if (itemModel.c() == TroopMemberDistinctResultListItemType.f300565GROUP) {
                    TroopMemberDistinctResultFragment.this.Gh(itemModel, z16);
                } else if (itemModel.c() == TroopMemberDistinctResultListItemType.USER) {
                    TroopMemberDistinctResultFragment.this.Ih(itemModel);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a itemModel) {
        Long l3;
        boolean z16;
        int i3;
        Long l16;
        String valueOf;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        TroopMemberDetectSvr$DuplicateMember b16 = itemModel.b();
        Long l17 = null;
        if (b16 != null && (pBUInt64Field2 = b16.uin) != null) {
            l3 = Long.valueOf(pBUInt64Field2.get());
        } else {
            l3 = null;
        }
        String valueOf2 = String.valueOf(l3);
        if (valueOf2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isFriend(valueOf2)) {
                i3 = 20;
            } else {
                i3 = 120;
            }
            AllInOne allInOne = new AllInOne(valueOf2, i3);
            TroopMemberDetectSvr$GroupInfo a16 = itemModel.a();
            if (a16 != null && (pBUInt64Field = a16.group_id) != null) {
                l16 = Long.valueOf(pBUInt64Field.get());
            } else {
                l16 = null;
            }
            if (l16 == null) {
                valueOf = "";
            } else {
                PBUInt64Field pBUInt64Field3 = itemModel.a().group_id;
                if (pBUInt64Field3 != null) {
                    l17 = Long.valueOf(pBUInt64Field3.get());
                }
                valueOf = String.valueOf(l17);
            }
            allInOne.troopCode = valueOf;
            allInOne.nickname = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getAccountNickName(this.app, valueOf2);
            allInOne.profileEntryType = 4;
            ProfileUtils.openProfileCard(getContext(), allInOne);
        }
    }

    private final boolean Jh() {
        Iterator<Map.Entry<Long, ArrayList<Long>>> it = this.deleteTroop.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final void Kh() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, getString(R.string.f180803c2), getString(R.string.f2059456z), getString(R.string.f20595570), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopMemberDistinctResultFragment.Lh(TroopMemberDistinctResultFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopMemberDistinctResultFragment.Mh(TroopMemberDistinctResultFragment.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026ickDelConfirmPop(false)})");
        createCustomDialog.show();
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.troopUin);
        VideoReport.reportEvent("ev_group_del_confirm_pop_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(TroopMemberDistinctResultFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xh();
        this$0.Ph(true);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(TroopMemberDistinctResultFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ph(false);
    }

    private final void Nh() {
        boolean z16;
        int i3;
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a[] Fh = Fh();
        Eh().o0(Fh);
        View view = this.resultListContainer;
        FrameLayout frameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultListContainer");
            view = null;
        }
        boolean z17 = true;
        int i16 = 0;
        if (Fh.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        FrameLayout frameLayout2 = this.resultEmpty;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultEmpty");
        } else {
            frameLayout = frameLayout2;
        }
        if (Fh.length != 0) {
            z17 = false;
        }
        if (!z17) {
            i16 = 8;
        }
        frameLayout.setVisibility(i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r9 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Oh(byte[] data) {
        boolean z16;
        TroopMemberDetectSvr$DuplicateMember[] troopMemberDetectSvr$DuplicateMemberArr;
        List<TroopMemberDetectSvr$DuplicateMember> list;
        this.chooseRepeatUser.clear();
        if (data != null) {
            if (data.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                TroopMemberDetectSvr$QueryDuplicateMembersRsp troopMemberDetectSvr$QueryDuplicateMembersRsp = new TroopMemberDetectSvr$QueryDuplicateMembersRsp();
                troopMemberDetectSvr$QueryDuplicateMembersRsp.mergeFrom(data);
                PBRepeatMessageField<TroopMemberDetectSvr$DuplicateMember> pBRepeatMessageField = troopMemberDetectSvr$QueryDuplicateMembersRsp.list;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    Object[] array = list.toArray(new TroopMemberDetectSvr$DuplicateMember[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    troopMemberDetectSvr$DuplicateMemberArr = (TroopMemberDetectSvr$DuplicateMember[]) array;
                }
                troopMemberDetectSvr$DuplicateMemberArr = new TroopMemberDetectSvr$DuplicateMember[0];
                for (TroopMemberDetectSvr$DuplicateMember it : troopMemberDetectSvr$DuplicateMemberArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a> vh5 = vh(it);
                    if (!vh5.isEmpty()) {
                        this.chooseRepeatUser.put(Long.valueOf(it.uin.get()), vh5);
                    }
                }
            }
        }
        Nh();
    }

    private final void Ph(boolean isConfirm) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.troopUin);
        hashMap.put("btn_type", Integer.valueOf(isConfirm ? 1 : 0));
        VideoReport.reportEvent("ev_group_del_confirm_pop_clck", hashMap);
    }

    private final HashMap<String, Object> uh() {
        String joinToString$default;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<Long, ArrayList<Long>>> it = this.deleteTroop.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next().getValue());
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedHashSet, ";", null, null, 0, null, null, 62, null);
        hashMap.put(AudienceReportConst.USER_QQ, joinToString$default);
        return hashMap;
    }

    private final ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a> vh(TroopMemberDetectSvr$DuplicateMember repeatMember) {
        ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a> arrayList = new ArrayList<>();
        int size = repeatMember.groups.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a(TroopMemberDistinctResultListItemType.f300565GROUP, repeatMember, repeatMember.groups.get(i3), false, 8, null));
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, new com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a(TroopMemberDistinctResultListItemType.USER, repeatMember, null, false, 12, null));
        }
        return arrayList;
    }

    private final void wh(long groupCode, List<Long> qqList) {
        Object obj;
        boolean z16;
        Object obj2;
        boolean z17;
        boolean z18;
        PBUInt64Field pBUInt64Field;
        Iterator<T> it = qqList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            ArrayList<com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a> arrayList = this.chooseRepeatUser.get(Long.valueOf(longValue));
            if (arrayList != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    obj = null;
                    z16 = true;
                    if (it5.hasNext()) {
                        obj2 = it5.next();
                        TroopMemberDetectSvr$GroupInfo a16 = ((com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a) obj2).a();
                        if (a16 != null && (pBUInt64Field = a16.group_id) != null && pBUInt64Field.get() == groupCode) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a aVar = (com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a) obj2;
                if (aVar != null) {
                    arrayList.remove(aVar);
                }
                Iterator<T> it6 = arrayList.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    if (((com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.model.a) next).c() == TroopMemberDistinctResultListItemType.f300565GROUP) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    z16 = false;
                }
                booleanRef.element = z16;
            }
            if (!booleanRef.element) {
                this.chooseRepeatUser.remove(Long.valueOf(longValue));
            }
        }
    }

    private final void xh() {
        View view;
        Iterator<Map.Entry<Long, ArrayList<Long>>> it = this.deleteTroop.entrySet().iterator();
        while (true) {
            view = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, ArrayList<Long>> next = it.next();
            com.tencent.qqnt.bean.b bVar = new com.tencent.qqnt.bean.b();
            bVar.troopUin = String.valueOf(next.getKey().longValue());
            bVar.d(next.getValue());
            bVar.isBlack = false;
            ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).deleteTroopMember(bVar, this, QPublicBaseFragment.TAG, null);
            wh(next.getKey().longValue(), next.getValue());
        }
        Qh(this.deleteTroop);
        com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a aVar = com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.report.a.f300570a;
        View view2 = this.btnDelete;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
        } else {
            view = view2;
        }
        aVar.a("dt_clck", view, "em_group_members_del_btn", uh());
        this.deleteTroop.clear();
        Nh();
        QQToastUtil.showQQToast(2, R.string.f180843c6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void yh() {
        AppActivity appActivity;
        AppRuntime appRuntime;
        AppInterface appInterface;
        String[] strArr;
        Intent intent;
        ArrayList<String> stringArrayListExtra;
        Intent intent2;
        Context context = getContext();
        String str = null;
        if (context instanceof AppActivity) {
            appActivity = (AppActivity) context;
        } else {
            appActivity = null;
        }
        if (appActivity != null) {
            appRuntime = appActivity.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        this.app = appInterface;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra("troop_uin");
        }
        this.troopUin = String.valueOf(str);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null && (stringArrayListExtra = intent.getStringArrayListExtra("choose_troop_code")) != null) {
            Object[] array = stringArrayListExtra.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
        }
        strArr = new String[0];
        this.chooseTroop = strArr;
    }

    private final void zh(View rootView) {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(9);
        String string = getString(R.string.f180813c3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_tr\u2026stinct_result_blank_text)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
        build.setVisibility(0);
        View findViewById = rootView.findViewById(R.id.f73683u8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.result_blank)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.resultEmpty = frameLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultEmpty");
            frameLayout = null;
        }
        frameLayout.addView(build);
        FrameLayout frameLayout3 = this.resultEmpty;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultEmpty");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(8);
    }

    public final void Qh(@NotNull Map<Long, ? extends ArrayList<Long>> troops) {
        String str;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troops);
            return;
        }
        Intrinsics.checkNotNullParameter(troops, "troops");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Map.Entry<Long, ? extends ArrayList<Long>>> it = troops.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                linkedHashSet.add(String.valueOf(((Number) it5.next()).longValue()));
            }
        }
        HashMap hashMap = new HashMap();
        AppInterface appInterface = this.app;
        if (appInterface != null) {
            str = appInterface.getCurrentUid();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "app?.currentUid ?: \"\"");
        }
        hashMap.put("group_owner_uin", str);
        hashMap.put("group_id", this.troopUin);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedHashSet, ";", null, null, 0, null, null, 62, null);
        hashMap.put("del_uin", joinToString$default);
        VideoReport.reportEvent("ev_group_members_deduplication", hashMap);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        byte[] bArr;
        View view;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.mContext = requireActivity;
            View inflate = inflater.inflate(R.layout.f168611g15, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026result, container, false)");
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
            Ch(view4);
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                bArr = intent.getByteArrayExtra("key_distinct_member_pb_data");
            } else {
                bArr = null;
            }
            Oh(bArr);
            View view5 = this.mRootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view5 = null;
            }
            Ah(view5);
            View view6 = this.btnDelete;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
                view6 = null;
            }
            VideoReport.reportEvent("dt_imp", view6, null);
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
        View view = this.btnDelete;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnDelete");
            view = null;
        }
        VideoReport.reportEvent("dt_imp_end", view, null);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        VideoReport.reportPgOut(view2);
        super.onDestroy();
    }
}
