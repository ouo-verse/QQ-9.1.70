package com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.troopsetting.activity.d;
import com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.TroopGameInfoData;
import com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.report.SwitchState;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\b*\u0001L\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u001c\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0002H\u0002J8\u0010+\u001a\u00020\n*\u00020%2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00122\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0)H\u0002J0\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020&2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R0\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%06j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/ui/TroopGameInfoFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "onDestroyView", "initData", "initNavBar", "Ih", "Mh", "Kh", "", "xh", "Jh", "Landroid/content/Context;", "context", "stringRes", "Landroid/widget/TextView;", "Ah", "Hh", "Landroid/view/View;", "Bh", "Landroid/widget/LinearLayout$LayoutParams;", OcrConfig.CHINESE, "isChecked", HippyHeaderListViewController.VIEW_TAG, "Ph", "Nh", "Qh", "Lh", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "", "title", "checkOption", "Lkotlin/Function1;", "onCheckChanged", "Dh", "view", "elementId", "", "", "elemParams", "Fh", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "containerView", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "viewCaches", "E", "I", "changingOption", "Lcom/tencent/common/app/AppInterface;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "yh", "()Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData;", "G", "Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData;", ISchemeApi.KEY_PAGE_DATA, "", "H", "Ljava/util/List;", "gameGroupUITags", "com/tencent/mobileqq/troop/troopsetting/modules/gameinfo/ui/TroopGameInfoFragment$b", "Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/ui/TroopGameInfoFragment$b;", "gameSwitchObserver", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopGameInfoFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout containerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, FormSwitchItem> viewCaches;

    /* renamed from: E, reason: from kotlin metadata */
    private int changingOption;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: G, reason: from kotlin metadata */
    private TroopGameInfoData pageData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<Integer> gameGroupUITags;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b gameSwitchObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/ui/TroopGameInfoFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/TroopGameInfoData;", ISchemeApi.KEY_PAGE_DATA, "", "a", "", "BG_ALPHA", "I", "", "BUNDLE_KEY_PAGE_DATA", "Ljava/lang/String;", "SCHEMA_GAME_CENTER_GAME_BINDING", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.TroopGameInfoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull TroopGameInfoData pageData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) pageData);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("bundle_key_page_data", pageData));
            Intent intent = new Intent();
            intent.putExtras(bundleOf);
            QPublicFragmentActivity.start(context, intent, TroopGameInfoFragment.class);
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/modules/gameinfo/ui/TroopGameInfoFragment$b", "Lcom/tencent/mobileqq/troop/troopgame/api/b;", "", "isSuccess", "", "uin", "errCode", "", "errInfo", "", "onModifyMemberGameCardSwitch", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameInfoFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onModifyMemberGameCardSwitch(boolean isSuccess, long uin, long errCode, @NotNull String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin), Long.valueOf(errCode), errInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(errInfo, "errInfo");
            QLog.i("TroopGameInfoFragment", 1, "[onModifyMemberGameCardSwitch] isSuccess = " + isSuccess + " uin = " + uin + " errCode = " + errCode + " changingOption = " + TroopGameInfoFragment.this.changingOption);
            TroopGameInfoData troopGameInfoData = TroopGameInfoFragment.this.pageData;
            if (troopGameInfoData == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                troopGameInfoData = null;
            }
            if (!Intrinsics.areEqual(troopGameInfoData.b(), String.valueOf(uin))) {
                return;
            }
            if (!isSuccess) {
                QQToast.makeText(TroopGameInfoFragment.this.getContext(), 1, HardCodeUtil.qqStr(R.string.f180243aj), 0).show();
                TroopGameInfoFragment troopGameInfoFragment = TroopGameInfoFragment.this;
                troopGameInfoFragment.Nh(troopGameInfoFragment.changingOption);
            } else {
                TroopGameInfoFragment troopGameInfoFragment2 = TroopGameInfoFragment.this;
                troopGameInfoFragment2.Qh(troopGameInfoFragment2.changingOption);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopGameInfoFragment() {
        Lazy lazy;
        List<Integer> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewCaches = new HashMap<>();
        this.changingOption = -1;
        lazy = LazyKt__LazyJVMKt.lazy(TroopGameInfoFragment$app$2.INSTANCE);
        this.app = lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{23, 25});
        this.gameGroupUITags = listOf;
        this.gameSwitchObserver = new b();
    }

    private final TextView Ah(Context context, @StringRes int stringRes) {
        TextView textView = new TextView(context);
        textView.setSingleLine(false);
        textView.setText(stringRes);
        textView.setTextColor(ie0.a.f().h(context, R.color.qui_common_text_secondary, 1000));
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.aw5));
        return textView;
    }

    private final View Bh(Context context) {
        View footerView = LayoutInflater.from(context).inflate(R.layout.h5q, (ViewGroup) null);
        ((TextView) footerView.findViewById(R.id.f108906ed)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopGameInfoFragment.Ch(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(footerView, "footerView");
        return footerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ax b16 = com.tencent.mobileqq.troop.troopcard.reborn.ktx.b.f299536a.b("mqqapi://kuikly/open?src_type=web&version=1&url=%25253FFFROMSCHEMA%25253D%252526adtag%25253D__REPLACE_OASIS_ADTAG__&page_name=QQGameCenterActionSheetBindGameListPage&bundle_name=gamecenter_action_sheet_bind_game_list");
        if (b16 != null) {
            b16.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Dh(FormSwitchItem formSwitchItem, int i3, String str, boolean z16, final Function1<? super Boolean, Unit> function1) {
        formSwitchItem.setText(str);
        formSwitchItem.setContentDescription(str);
        formSwitchItem.getTextView().setTextColor(AppCompatResources.getColorStateList(formSwitchItem.getContext(), R.color.skin_black));
        formSwitchItem.setFocusable(true);
        formSwitchItem.getBackground().setAlpha(255);
        formSwitchItem.getSwitch().setTag(Integer.valueOf(i3));
        formSwitchItem.getSwitch().setChecked(z16);
        formSwitchItem.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                TroopGameInfoFragment.Eh(Function1.this, compoundButton, z17);
            }
        });
        this.viewCaches.put(Integer.valueOf(i3), formSwitchItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 onCheckChanged, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(onCheckChanged, "$onCheckChanged");
        onCheckChanged.invoke(Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Fh(View view, String elementId, Map<String, ? extends Object> elemParams) {
        boolean z16;
        VideoReport.setElementId(view, elementId);
        if (elemParams != null && !elemParams.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            VideoReport.setElementParams(view, elemParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Gh(TroopGameInfoFragment troopGameInfoFragment, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        troopGameInfoFragment.Fh(view, str, map);
    }

    private final void Hh() {
        if (!xh()) {
            return;
        }
        TroopGameInfoData troopGameInfoData = this.pageData;
        LinearLayout linearLayout = null;
        if (troopGameInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopGameInfoData = null;
        }
        QLog.e("TroopGameInfoFragment", 1, "initMyGameCardUI isMyGameCardEnabled=" + troopGameInfoData.f());
        FormSwitchItem formSwitchItem = new FormSwitchItem(getContext(), null);
        formSwitchItem.setBgType(0);
        String string = getString(R.string.f180353au);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026p_game_show_my_game_card)");
        TroopGameInfoData troopGameInfoData2 = this.pageData;
        if (troopGameInfoData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopGameInfoData2 = null;
        }
        Dh(formSwitchItem, 25, string, troopGameInfoData2.f(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.TroopGameInfoFragment$initMyGameCardUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameInfoFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TroopGameInfoFragment.this.Ph(z16, 25);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        LinearLayout linearLayout2 = this.containerView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout2 = null;
        }
        linearLayout2.addView(formSwitchItem);
        Gh(this, formSwitchItem, "em_group_show_my_game_data", null, 4, null);
        Context ctx = getContext();
        if (ctx != null) {
            Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
            View Bh = Bh(ctx);
            LinearLayout linearLayout3 = this.containerView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.addView(Bh, zh());
        }
    }

    private final void Ih() {
        yh().addObserver(this.gameSwitchObserver);
    }

    private final void Jh() {
        SwitchState switchState;
        TroopGameInfoData troopGameInfoData = this.pageData;
        LinearLayout linearLayout = null;
        TroopGameInfoData troopGameInfoData2 = null;
        if (troopGameInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopGameInfoData = null;
        }
        if (!troopGameInfoData.c()) {
            TroopGameInfoData troopGameInfoData3 = this.pageData;
            if (troopGameInfoData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopGameInfoData2 = troopGameInfoData3;
            }
            QLog.i("TroopGameInfoFragment", 1, "[initTeammateGameStatusItemUI] ignored. troopUin:" + troopGameInfoData2.b() + " not gang up troop");
            return;
        }
        FormSwitchItem formSwitchItem = new FormSwitchItem(getContext(), null);
        formSwitchItem.setBgType(0);
        TroopGameInfoData troopGameInfoData4 = this.pageData;
        if (troopGameInfoData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopGameInfoData4 = null;
        }
        boolean a16 = troopGameInfoData4.a();
        String string = getString(R.string.f180413b0);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026oop_game_teammate_status)");
        Dh(formSwitchItem, 23, string, a16, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.TroopGameInfoFragment$initTeammateGameStatusItemUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGameInfoFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                QLog.i("TroopGameInfoFragment", 1, "[initTeammateGameStatusItemUI] onCheckChanged: " + z16);
                TroopGameInfoFragment.this.Ph(z16, 23);
            }
        });
        if (xh()) {
            d dVar = d.f301060a;
            LinearLayout linearLayout2 = this.containerView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout2 = null;
            }
            d.b(dVar, linearLayout2, 0.0f, 1, null);
        }
        LinearLayout linearLayout3 = this.containerView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout3 = null;
        }
        linearLayout3.addView(formSwitchItem);
        Map<String, ? extends Object> hashMap = new HashMap<>();
        if (a16) {
            switchState = SwitchState.CHECKED_AFTER_CLICK;
        } else {
            switchState = SwitchState.UNCHECKED_AFTER_CLICK;
        }
        hashMap.put("btn_state", String.valueOf(switchState.getValue()));
        Fh(formSwitchItem, "em_group_show_play_together_status", hashMap);
        TextView Ah = Ah(getContext(), R.string.f180423b1);
        LinearLayout linearLayout4 = this.containerView;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.addView(Ah, zh());
    }

    private final void Kh() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.containerView = linearLayout;
        d dVar = d.f301060a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        d.b(dVar, linearLayout, 0.0f, 1, null);
        Hh();
        Jh();
    }

    private final boolean Lh(int viewTag) {
        return this.gameGroupUITags.contains(Integer.valueOf(viewTag));
    }

    private final void Mh() {
        yh().removeObserver(this.gameSwitchObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(final int viewTag) {
        boolean a16;
        if (!Lh(viewTag)) {
            return;
        }
        if (viewTag != 23) {
            if (viewTag != 25) {
                a16 = false;
            } else {
                TroopGameInfoData troopGameInfoData = this.pageData;
                if (troopGameInfoData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopGameInfoData = null;
                }
                a16 = troopGameInfoData.f();
            }
        } else {
            TroopGameInfoData troopGameInfoData2 = this.pageData;
            if (troopGameInfoData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                troopGameInfoData2 = null;
            }
            a16 = troopGameInfoData2.a();
        }
        FormSwitchItem formSwitchItem = this.viewCaches.get(Integer.valueOf(viewTag));
        if (formSwitchItem != null) {
            formSwitchItem.getSwitch().setOnCheckedChangeListener(null);
            formSwitchItem.getSwitch().setChecked(a16);
            formSwitchItem.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    TroopGameInfoFragment.Oh(TroopGameInfoFragment.this, viewTag, compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(TroopGameInfoFragment this$0, int i3, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ph(z16, i3);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r14 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0045, code lost:
    
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0048, code lost:
    
        if (r14 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ph(boolean isChecked, int viewTag) {
        com.tencent.mobileqq.troop.troopgame.api.a aVar;
        int i3;
        int i16;
        String str;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(getContext(), R.string.dst, 0).show();
            Nh(viewTag);
            return;
        }
        this.changingOption = viewTag;
        Object businessHandler = yh().getBusinessHandler(TroopGameHandler.class.getName());
        TroopGameInfoData troopGameInfoData = null;
        if (businessHandler instanceof com.tencent.mobileqq.troop.troopgame.api.a) {
            aVar = (com.tencent.mobileqq.troop.troopgame.api.a) businessHandler;
        } else {
            aVar = null;
        }
        if (viewTag != 23) {
            if (viewTag != 25) {
                return;
            } else {
                i3 = 16;
            }
        } else {
            i3 = 4;
        }
        if (aVar != null) {
            TroopGameInfoData troopGameInfoData2 = this.pageData;
            if (troopGameInfoData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                troopGameInfoData2 = null;
            }
            aVar.R0(troopGameInfoData2.b(), i3, i16);
        }
        if (isChecked) {
            str = "game_switch_on";
        } else {
            str = "game_switch_off";
        }
        String str2 = str;
        String[] strArr = new String[2];
        TroopGameInfoData troopGameInfoData3 = this.pageData;
        if (troopGameInfoData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
        } else {
            troopGameInfoData = troopGameInfoData3;
        }
        strArr[0] = troopGameInfoData.b();
        strArr[1] = String.valueOf(viewTag);
        eu.g("Grp_manage_new", "game", str2, 0, 0, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(int viewTag) {
        FormSwitchItem formSwitchItem;
        SwitchState switchState;
        if (!Lh(viewTag) || (formSwitchItem = this.viewCaches.get(Integer.valueOf(viewTag))) == null) {
            return;
        }
        boolean isChecked = formSwitchItem.isChecked();
        int i3 = this.changingOption;
        TroopGameInfoData troopGameInfoData = null;
        if (i3 != 23) {
            if (i3 == 25) {
                TroopGameInfoData troopGameInfoData2 = this.pageData;
                if (troopGameInfoData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                } else {
                    troopGameInfoData = troopGameInfoData2;
                }
                troopGameInfoData.j(isChecked);
            }
        } else {
            TroopGameInfoData troopGameInfoData3 = this.pageData;
            if (troopGameInfoData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopGameInfoData = troopGameInfoData3;
            }
            troopGameInfoData.k(isChecked);
        }
        com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.report.a aVar = com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.report.a.f301170a;
        if (isChecked) {
            switchState = SwitchState.CHECKED_AFTER_CLICK;
        } else {
            switchState = SwitchState.UNCHECKED_AFTER_CLICK;
        }
        aVar.b(formSwitchItem, switchState);
    }

    private final void initData() {
        TroopGameInfoData troopGameInfoData;
        Bundle arguments = getArguments();
        TroopGameInfoData troopGameInfoData2 = null;
        if (arguments != null) {
            troopGameInfoData = (TroopGameInfoData) arguments.getParcelable("bundle_key_page_data");
        } else {
            troopGameInfoData = null;
        }
        if (troopGameInfoData instanceof TroopGameInfoData) {
            troopGameInfoData2 = troopGameInfoData;
        }
        if (troopGameInfoData2 == null) {
            QLog.e("TroopGameInfoFragment", 1, "invalid setting data is null.");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.pageData = troopGameInfoData2;
    }

    private final void initNavBar() {
        setTitle(getString(R.string.f23341777));
    }

    private final boolean xh() {
        TroopGameInfoData troopGameInfoData = this.pageData;
        TroopGameInfoData troopGameInfoData2 = null;
        if (troopGameInfoData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopGameInfoData = null;
        }
        if (troopGameInfoData.g()) {
            TroopGameInfoData troopGameInfoData3 = this.pageData;
            if (troopGameInfoData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopGameInfoData2 = troopGameInfoData3;
            }
            if (!troopGameInfoData2.e() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                return true;
            }
        }
        return false;
    }

    private final AppInterface yh() {
        return (AppInterface) this.app.getValue();
    }

    private final LinearLayout.LayoutParams zh() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ViewUtils.dpToPx(33.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(33.0f);
        layoutParams.topMargin = ViewUtils.dpToPx(6.5f);
        layoutParams.bottomMargin = ViewUtils.dpToPx(11.5f);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        initData();
        initNavBar();
        Kh();
        Ih();
        com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.report.a aVar = com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.report.a.f301170a;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        LinearLayout linearLayout = this.containerView;
        TroopGameInfoData troopGameInfoData = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        TroopGameInfoData troopGameInfoData2 = this.pageData;
        if (troopGameInfoData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
        } else {
            troopGameInfoData = troopGameInfoData2;
        }
        aVar.a(qBaseActivity, linearLayout, troopGameInfoData.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h6k;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            Mh();
            super.onDestroyView();
        }
    }
}
