package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment;
import com.tencent.mobileqq.guild.setting.guildinfo.ProfileRuleData;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef1.c;
import h53.CharacterCountInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rz1.RuleData;
import rz1.RuleItemData;
import rz1.SortRuleItemData;
import rz1.TitleStatus;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001nB\u0007\u00a2\u0006\u0004\bk\u0010lJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\fH\u0014J&\u0010)\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010*\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0012\u00100\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u000fH\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0003H\u0016R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010@\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010B\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006o"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/GuildRuleEditFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initView", "bi", "initViewModel", "Lrz1/h;", "titleStatus", "si", "", "status", "ri", "", NodeProps.VISIBLE, "ki", "Xh", "Rh", "Sh", "Lrz1/d;", "ruleData", "Uh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "qi", "ai", "handleBackClick", "ni", "Landroidx/recyclerview/widget/ItemTouchHelper;", "Th", WidgetCacheLunarData.JI, "initDtReport", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "needStatusTrans", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onBackEvent", "v", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", VasWebviewConstants.KEY_PAGE_TITLE, "E", "backButton", UserInfo.SEX_FEMALE, "sortCancelButton", "G", "sortFinishButton", "H", "startSortButton", "Landroidx/recyclerview/widget/RecyclerView;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "ruleList", "J", "sortList", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "emptyContainer", "L", "Landroid/view/ViewGroup;", "editPageContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "M", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "previewButton", "N", "finishButton", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/s;", "P", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/s;", "ruleAdapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "sortAdapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/r;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/r;", "viewModel", ExifInterface.LATITUDE_SOUTH, "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Lcom/tencent/mobileqq/guild/window/s;", "T", "Lcom/tencent/mobileqq/guild/window/s;", "mSoftKeyboardStateHelper", "", "U", "Ljava/lang/String;", "guildId", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRuleEditFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView pageTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private View backButton;

    /* renamed from: F, reason: from kotlin metadata */
    private View sortCancelButton;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView sortFinishButton;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView startSortButton;

    /* renamed from: I, reason: from kotlin metadata */
    private RecyclerView ruleList;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView sortList;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout emptyContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private ViewGroup editPageContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private QUIButton previewButton;

    /* renamed from: N, reason: from kotlin metadata */
    private QUIButton finishButton;

    /* renamed from: P, reason: from kotlin metadata */
    private s ruleAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private s sortAdapter;

    /* renamed from: R, reason: from kotlin metadata */
    private r viewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final ItemTouchHelper itemTouchHelper = Th();

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.window.s mSoftKeyboardStateHelper;

    /* renamed from: U, reason: from kotlin metadata */
    private String guildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/GuildRuleEditFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "requestCode", "", "a", "", "ITEM_SPACE_DP", UserInfo.SEX_FEMALE, "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String guildId, int requestCode) {
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildRuleEditFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/rule/GuildRuleEditFragment$b", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "isDragStart", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "getMovementFlags", "target", "onMove", "direction", "onSwiped", "actionState", "onSelectedChanged", "clearView", "isLongPressDragEnabled", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ItemTouchHelper.Callback {
        b() {
        }

        private final void a(RecyclerView.ViewHolder viewHolder, boolean isDragStart) {
            View view;
            float f16;
            if (viewHolder != null) {
                view = viewHolder.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                try {
                    viewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    View view2 = viewHolder.itemView;
                    if (isDragStart) {
                        f16 = 20.0f;
                    } else {
                        f16 = 0.0f;
                    }
                    view2.setTranslationZ(f16);
                } catch (Exception e16) {
                    Logger.f235387a.d().w("Guild.mnr.GuildRuleEditFragment", 1, "setItemShadow " + e16);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            a(viewHolder, false);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            Object tag = viewHolder.itemView.getTag();
            Object tag2 = target.itemView.getTag();
            if ((tag instanceof SortRuleItemData) && (tag2 instanceof SortRuleItemData)) {
                r rVar = GuildRuleEditFragment.this.viewModel;
                if (rVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    rVar = null;
                }
                rVar.f2(((SortRuleItemData) tag).getRuleData(), ((SortRuleItemData) tag2).getRuleData());
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == 2) {
                a(viewHolder, true);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f234251a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildRuleEditFragment f234252b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildRuleEditFragment guildRuleEditFragment) {
            this.f234251a = viewModelStoreOwner;
            this.f234252b = guildRuleEditFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f234252b.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            TimedValue timedValue = new TimedValue(new r(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/rule/GuildRuleEditFragment$d", "Lcom/tencent/mobileqq/guild/window/s$c;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements s.c {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildRuleEditFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Xh();
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardClosed() {
            RecyclerView recyclerView = GuildRuleEditFragment.this.ruleList;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView = null;
            }
            RecyclerView recyclerView3 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView3 = null;
            }
            int paddingLeft = recyclerView3.getPaddingLeft();
            RecyclerView recyclerView4 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView4 = null;
            }
            int paddingTop = recyclerView4.getPaddingTop();
            RecyclerView recyclerView5 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
            } else {
                recyclerView2 = recyclerView5;
            }
            recyclerView.setPadding(paddingLeft, paddingTop, recyclerView2.getPaddingRight(), 0);
            View view = GuildRuleEditFragment.this.getView();
            if (view != null) {
                view.requestFocus();
            }
        }

        @Override // com.tencent.mobileqq.guild.window.s.c
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            RecyclerView recyclerView = GuildRuleEditFragment.this.ruleList;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView = null;
            }
            RecyclerView recyclerView3 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView3 = null;
            }
            int paddingLeft = recyclerView3.getPaddingLeft();
            RecyclerView recyclerView4 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView4 = null;
            }
            int paddingTop = recyclerView4.getPaddingTop();
            RecyclerView recyclerView5 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView5 = null;
            }
            recyclerView.setPadding(paddingLeft, paddingTop, recyclerView5.getPaddingRight(), keyboardHeightInPx);
            RecyclerView recyclerView6 = GuildRuleEditFragment.this.ruleList;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
            } else {
                recyclerView2 = recyclerView6;
            }
            final GuildRuleEditFragment guildRuleEditFragment = GuildRuleEditFragment.this;
            recyclerView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRuleEditFragment.d.b(GuildRuleEditFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(View view) {
        InputMethodUtil.hide(requireActivity());
        bt.h(bt.f235484a, view, "em_sgrp_add_rule", "clck", null, 8, null);
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.S1();
    }

    private final ItemTouchHelper Th() {
        return new ItemTouchHelper(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(View view, final RuleData ruleData) {
        bt btVar = bt.f235484a;
        bt.h(btVar, view, "em_sgrp_del_rule", "clck", null, 8, null);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u786e\u5b9a\u5220\u9664\u6b64\u6761\u89c4\u5219\uff1f", getString(R.string.cancel), getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildRuleEditFragment.Vh(GuildRuleEditFragment.this, ruleData, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildRuleEditFragment.Wh(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026}\n            }\n        )");
        createCustomDialog.show();
        VideoReport.setLogicParent(createCustomDialog.getRootView(), view);
        ViewGroup rootView = createCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "confirmDialog.rootView");
        bt.h(btVar, rootView, "em_sgrp_del_rule_pop", "imp", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildRuleEditFragment this$0, RuleData ruleData, DialogInterface dialogInterface, int i3) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ruleData, "$ruleData");
        r rVar = this$0.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.T1(ruleData);
        if (dialogInterface instanceof QQCustomDialog) {
            bt btVar = bt.f235484a;
            ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 1));
            btVar.g(rootView, "em_sgrp_del_rule_pop", "clck", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(DialogInterface dialogInterface, int i3) {
        Map<String, ? extends Object> mapOf;
        if (dialogInterface instanceof QQCustomDialog) {
            bt btVar = bt.f235484a;
            ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 2));
            btVar.g(rootView, "em_sgrp_del_rule_pop", "clck", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        Object obj;
        View view = this.rootView;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findFocus = view.findFocus();
        if (findFocus != null) {
            obj = findFocus.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof RuleItemData) {
            RuleItemData ruleItemData = (RuleItemData) obj;
            if (ruleItemData.getOrder() - 1 != 0) {
                RecyclerView recyclerView2 = this.ruleList;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                    recyclerView2 = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                View findViewByPosition = ((LinearLayoutManager) layoutManager).findViewByPosition(ruleItemData.getOrder() - 1);
                if (findViewByPosition == null) {
                    return;
                }
                int[] iArr = new int[2];
                findViewByPosition.getLocationOnScreen(iArr);
                int i3 = iArr[1];
                int realHeight = ScreenUtil.getRealHeight(getContext());
                int i16 = realHeight / 2;
                if (i3 + findViewByPosition.getHeight() > i16) {
                    RecyclerView recyclerView3 = this.ruleList;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                        recyclerView3 = null;
                    }
                    recyclerView3.getLocationOnScreen(iArr);
                    int i17 = iArr[1];
                    int height = (i16 - findViewByPosition.getHeight()) - i17;
                    if (height < 0) {
                        return;
                    }
                    Logger.f235387a.d().d("Guild.mnr.GuildRuleEditFragment", 1, "findFocusAindScroll: " + realHeight + ", " + i17 + ", " + height + ", " + findViewByPosition.getHeight() + ", " + ruleItemData.getOrder());
                    RecyclerView recyclerView4 = this.ruleList;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                    } else {
                        recyclerView = recyclerView4;
                    }
                    com.tencent.mobileqq.guild.base.extension.q.d(recyclerView, ruleItemData.getOrder() - 1, height);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildRuleEditFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void ai() {
        boolean z16;
        r rVar = this.viewModel;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        List<RuleData> W1 = rVar.W1();
        if (W1.isEmpty()) {
            ni();
            return;
        }
        Iterator<RuleData> it = W1.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (CharacterCountInfo.d(h53.c.b(it.next().getTitle(), null, 2, null), null, 1, null) < 5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            QQToast.makeText(getActivity(), 0, "\u89c4\u5219\u6807\u9898\u4e0d\u5c11\u4e8e5\u4e2a\u5b57", 1).show();
            RecyclerView recyclerView = this.ruleList;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
                recyclerView = null;
            }
            com.tencent.mobileqq.guild.base.extension.q.e(recyclerView, i3, 0, 2, null);
            return;
        }
        r rVar3 = this.viewModel;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            rVar2 = rVar3;
        }
        rVar2.k2();
    }

    private final void bi(View view) {
        Window window;
        View findViewById = view.findViewById(R.id.xl7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.immersive_bar)");
        findViewById.getLayoutParams().height = ImmersiveUtils.statusHeight;
        FragmentActivity activity = getActivity();
        TextView textView = null;
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        ImmersiveUtils.clearCoverForStatus(window, true);
        View findViewById2 = view.findViewById(R.id.ygz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.left_back)");
        this.backButton = findViewById2;
        View findViewById3 = view.findViewById(R.id.f86894sw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.sort_cancel_button)");
        this.sortCancelButton = findViewById3;
        View findViewById4 = view.findViewById(R.id.f86904sx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.sort_finish_button)");
        this.sortFinishButton = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f220802r);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.page_title)");
        this.pageTitle = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f88024vy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.start_sort_button)");
        this.startSortButton = (TextView) findViewById6;
        View view2 = this.backButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view2 = null;
        }
        view2.setOnClickListener(this);
        View view3 = this.sortCancelButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortCancelButton");
            view3 = null;
        }
        view3.setOnClickListener(this);
        TextView textView2 = this.sortFinishButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.startSortButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startSortButton");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void handleBackClick() {
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        if (Intrinsics.areEqual(rVar.Z1().getValue(), Boolean.TRUE)) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u662f\u5426\u9000\u51fa\u672c\u6b21\u7f16\u8f91\uff1f", "\u9000\u51fa", "\u7ee7\u7eed\u7f16\u8f91", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildRuleEditFragment.Yh(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildRuleEditFragment.Zh(GuildRuleEditFragment.this, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026          }\n            )");
            createCustomDialog.show();
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initDtReport() {
        TextView textView;
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_channel_set_rule");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        iGuildDTReportApi.setGuildPageParams(view2, str, null);
        TextView textView2 = this.startSortButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startSortButton");
            textView = null;
        } else {
            textView = textView2;
        }
        bt.d(textView, "em_sgrp_sort", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
    }

    private final void initView(View view) {
        bi(view);
        View findViewById = view.findViewById(R.id.f786947r);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        s sVar = new s(new t(new GuildRuleEditFragment$initView$1$1(this), new GuildRuleEditFragment$initView$1$2(this), new GuildRuleEditFragment$initView$1$3(this), new GuildRuleEditFragment$initView$1$4(this)));
        this.ruleAdapter = sVar;
        recyclerView.setAdapter(sVar);
        QUIButton qUIButton = null;
        recyclerView.addItemDecoration(new com.tencent.mobileqq.guild.widget.q(QQGuildUIUtil.f(16.0f), 0, 2, null));
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Recycl\u2026TEM_SPACE_DP)))\n        }");
        this.ruleList = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ruleList");
            recyclerView = null;
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(120L);
            itemAnimator.setMoveDuration(120L);
            itemAnimator.setAddDuration(150L);
            itemAnimator.setRemoveDuration(150L);
        }
        View findViewById2 = view.findViewById(R.id.f86914sy);
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(requireContext()));
        s sVar2 = new s(new t(new GuildRuleEditFragment$initView$3$1(this), new GuildRuleEditFragment$initView$3$2(this), new GuildRuleEditFragment$initView$3$3(this), new GuildRuleEditFragment$initView$3$4(this)));
        this.sortAdapter = sVar2;
        recyclerView2.setAdapter(sVar2);
        recyclerView2.addItemDecoration(new com.tencent.mobileqq.guild.widget.q(QQGuildUIUtil.f(16.0f), 0, 2, null));
        this.itemTouchHelper.attachToRecyclerView(recyclerView2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<Recycl\u2026yclerView(this)\n        }");
        this.sortList = recyclerView2;
        View findViewById3 = view.findViewById(R.id.if5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.root_view)");
        this.rootView = findViewById3;
        View findViewById4 = view.findViewById(R.id.bwb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.empty_container)");
        this.emptyContainer = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.uqk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.edit_page_container)");
        this.editPageContainer = (ViewGroup) findViewById5;
        View findViewById6 = view.findViewById(R.id.f27100fb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.preview_button)");
        this.previewButton = (QUIButton) findViewById6;
        View findViewById7 = view.findViewById(R.id.v6k);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.finish_button)");
        this.finishButton = (QUIButton) findViewById7;
        QUIButton qUIButton2 = this.previewButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewButton");
            qUIButton2 = null;
        }
        qUIButton2.setOnClickListener(this);
        QUIButton qUIButton3 = this.finishButton;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("finishButton");
        } else {
            qUIButton = qUIButton3;
        }
        qUIButton.setOnClickListener(this);
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(r.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        r rVar = (r) viewModel;
        this.viewModel = rVar;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        LiveData<Integer> a26 = rVar.a2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer pageStatus) {
                GuildRuleEditFragment guildRuleEditFragment = GuildRuleEditFragment.this;
                Intrinsics.checkNotNullExpressionValue(pageStatus, "pageStatus");
                guildRuleEditFragment.ri(pageStatus.intValue());
            }
        };
        a26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.di(Function1.this, obj);
            }
        });
        r rVar3 = this.viewModel;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar3 = null;
        }
        LiveData<TitleStatus> e26 = rVar3.e2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<TitleStatus, Unit> function12 = new Function1<TitleStatus, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TitleStatus titleStatus) {
                invoke2(titleStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TitleStatus titleStatus) {
                GuildRuleEditFragment guildRuleEditFragment = GuildRuleEditFragment.this;
                Intrinsics.checkNotNullExpressionValue(titleStatus, "titleStatus");
                guildRuleEditFragment.si(titleStatus);
            }
        };
        e26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.ei(Function1.this, obj);
            }
        });
        r rVar4 = this.viewModel;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar4 = null;
        }
        LiveData<Boolean> Z1 = rVar4.Z1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean hasDataChanged) {
                QUIButton qUIButton;
                qUIButton = GuildRuleEditFragment.this.finishButton;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("finishButton");
                    qUIButton = null;
                }
                Intrinsics.checkNotNullExpressionValue(hasDataChanged, "hasDataChanged");
                qUIButton.setEnabled(hasDataChanged.booleanValue());
            }
        };
        Z1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.fi(Function1.this, obj);
            }
        });
        r rVar5 = this.viewModel;
        if (rVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar5 = null;
        }
        LiveData<cf1.b> toastEvent = rVar5.getToastEvent();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final GuildRuleEditFragment$initViewModel$5 guildRuleEditFragment$initViewModel$5 = new Function1<cf1.b, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cf1.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cf1.b it) {
                if (it.f30775b == 0) {
                    QQToast.makeText(BaseApplication.getContext(), 2, it.f30774a, 1).show();
                    return;
                }
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                SecurityTipHelperKt.G(context, it, null, 4, null);
            }
        };
        toastEvent.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.gi(Function1.this, obj);
            }
        });
        r rVar6 = this.viewModel;
        if (rVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar6 = null;
        }
        LiveData<Boolean> X1 = rVar6.X1();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                FragmentActivity activity = GuildRuleEditFragment.this.getActivity();
                if (activity != null) {
                    activity.setResult(-1);
                    activity.finish();
                }
            }
        };
        X1.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.hi(Function1.this, obj);
            }
        });
        r rVar7 = this.viewModel;
        if (rVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar7 = null;
        }
        LiveData<List<rz1.b>> c26 = rVar7.c2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<List<? extends rz1.b>, Unit> function15 = new Function1<List<? extends rz1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends rz1.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends rz1.b> list) {
                s sVar;
                sVar = GuildRuleEditFragment.this.ruleAdapter;
                if (sVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ruleAdapter");
                    sVar = null;
                }
                sVar.setItems(list);
            }
        };
        c26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.ii(Function1.this, obj);
            }
        });
        r rVar8 = this.viewModel;
        if (rVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            rVar2 = rVar8;
        }
        LiveData<List<rz1.b>> d26 = rVar2.d2();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<List<? extends rz1.b>, Unit> function16 = new Function1<List<? extends rz1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment$initViewModel$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends rz1.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends rz1.b> list) {
                s sVar;
                sVar = GuildRuleEditFragment.this.sortAdapter;
                if (sVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sortAdapter");
                    sVar = null;
                }
                sVar.setItems(list);
            }
        };
        d26.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRuleEditFragment.ci(Function1.this, obj);
            }
        });
    }

    private final void ji() {
        String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.guildId = stringExtra;
    }

    private final void ki(boolean visible) {
        LinearLayout linearLayout = null;
        if (visible) {
            LinearLayout linearLayout2 = this.emptyContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            LinearLayout linearLayout3 = this.emptyContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
                linearLayout3 = null;
            }
            if (linearLayout3.getChildCount() == 0) {
                GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(getContext()).s(3).u("\u8bbe\u7f6e\u9891\u9053\u89c4\u5219\uff0c\u5efa\u7acb\u53cb\u597d\u793e\u533a\u6c1b\u56f4").r(false).n(false).o(0).p("\u7acb\u5373\u8bbe\u7f6e", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildRuleEditFragment.li(GuildRuleEditFragment.this, view);
                    }
                }).a();
                LinearLayout linearLayout4 = this.emptyContainer;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
                } else {
                    linearLayout = linearLayout4;
                }
                linearLayout.addView(a16);
                return;
            }
            return;
        }
        LinearLayout linearLayout5 = this.emptyContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
        } else {
            linearLayout = linearLayout5;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(final GuildRuleEditFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("Guild.mnr.GuildRuleEditFragment")) {
            r rVar = this$0.viewModel;
            RecyclerView recyclerView = null;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                rVar = null;
            }
            rVar.Q1();
            RecyclerView recyclerView2 = this$0.ruleList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleList");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRuleEditFragment.mi(GuildRuleEditFragment.this);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(GuildRuleEditFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s sVar = this$0.ruleAdapter;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ruleAdapter");
            sVar = null;
        }
        sVar.notifyItemChanged(0, 2);
    }

    private final void ni() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u786e\u5b9a\u6e05\u7a7a\u9891\u9053\u89c4\u5219\uff1f", getString(R.string.cancel), "\u6e05\u7a7a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildRuleEditFragment.oi(GuildRuleEditFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.rule.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildRuleEditFragment.pi(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026}\n            }\n        )");
        createCustomDialog.show();
        ViewGroup rootView = createCustomDialog.getRootView();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setLogicParent(rootView, view);
        bt btVar = bt.f235484a;
        ViewGroup rootView2 = createCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView2, "dialog.rootView");
        bt.h(btVar, rootView2, "em_sgrp_rule_empty_pop", "imp", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(GuildRuleEditFragment this$0, DialogInterface dialogInterface, int i3) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r rVar = this$0.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        rVar.k2();
        if (dialogInterface instanceof QQCustomDialog) {
            bt btVar = bt.f235484a;
            ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 1));
            btVar.g(rootView, "em_sgrp_rule_empty_pop", "clck", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(DialogInterface dialogInterface, int i3) {
        Map<String, ? extends Object> mapOf;
        if (dialogInterface instanceof QQCustomDialog) {
            bt btVar = bt.f235484a;
            ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 2));
            btVar.g(rootView, "em_sgrp_rule_empty_pop", "clck", mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(RecyclerView.ViewHolder viewHolder) {
        this.itemTouchHelper.startDrag(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri(int status) {
        int i3;
        int i16 = 0;
        boolean z16 = true;
        if (status != 1) {
            z16 = false;
        }
        ki(z16);
        RecyclerView recyclerView = this.sortList;
        ViewGroup viewGroup = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortList");
            recyclerView = null;
        }
        if (status == 3) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        recyclerView.setVisibility(i3);
        ViewGroup viewGroup2 = this.editPageContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editPageContainer");
        } else {
            viewGroup = viewGroup2;
        }
        if (status != 2) {
            i16 = 8;
        }
        viewGroup.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(TitleStatus titleStatus) {
        float f16;
        int i3 = 0;
        TextView textView = null;
        if (titleStatus.getStatus() == 3) {
            TextView textView2 = this.pageTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(VasWebviewConstants.KEY_PAGE_TITLE);
                textView2 = null;
            }
            textView2.setText("\u6392\u5e8f");
            View view = this.backButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
                view = null;
            }
            view.setVisibility(8);
            TextView textView3 = this.startSortButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startSortButton");
                textView3 = null;
            }
            textView3.setVisibility(8);
            View view2 = this.sortCancelButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortCancelButton");
                view2 = null;
            }
            view2.setVisibility(0);
            TextView textView4 = this.sortFinishButton;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
                textView4 = null;
            }
            textView4.setVisibility(0);
            boolean isOrderChanged = titleStatus.getIsOrderChanged();
            TextView textView5 = this.sortFinishButton;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
                textView5 = null;
            }
            textView5.setEnabled(isOrderChanged);
            TextView textView6 = this.sortFinishButton;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
            } else {
                textView = textView6;
            }
            if (isOrderChanged) {
                f16 = 1.0f;
            } else {
                f16 = 0.3f;
            }
            textView.setAlpha(f16);
            return;
        }
        TextView textView7 = this.pageTitle;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(VasWebviewConstants.KEY_PAGE_TITLE);
            textView7 = null;
        }
        textView7.setText("\u7f16\u8f91\u9891\u9053\u89c4\u5219");
        View view3 = this.backButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = this.sortCancelButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortCancelButton");
            view4 = null;
        }
        view4.setVisibility(8);
        TextView textView8 = this.sortFinishButton;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
            textView8 = null;
        }
        textView8.setVisibility(8);
        TextView textView9 = this.startSortButton;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startSortButton");
        } else {
            textView = textView9;
        }
        if (!titleStatus.getCanSort()) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f6w;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        r rVar = this.viewModel;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rVar = null;
        }
        Integer value = rVar.a2().getValue();
        if (value != null && value.intValue() == 3) {
            return true;
        }
        handleBackClick();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.mobileqq.guild.util.o.c("Guild.mnr.GuildRuleEditFragment")) {
            View view = this.backButton;
            QUIButton qUIButton = null;
            r rVar = null;
            r rVar2 = null;
            r rVar3 = null;
            String str = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
                view = null;
            }
            if (Intrinsics.areEqual(v3, view)) {
                handleBackClick();
            } else {
                View view2 = this.sortCancelButton;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sortCancelButton");
                    view2 = null;
                }
                if (Intrinsics.areEqual(v3, view2)) {
                    r rVar4 = this.viewModel;
                    if (rVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        rVar = rVar4;
                    }
                    rVar.R1();
                } else {
                    TextView textView = this.sortFinishButton;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sortFinishButton");
                        textView = null;
                    }
                    if (Intrinsics.areEqual(v3, textView)) {
                        r rVar5 = this.viewModel;
                        if (rVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            rVar2 = rVar5;
                        }
                        rVar2.U1();
                    } else {
                        TextView textView2 = this.startSortButton;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("startSortButton");
                            textView2 = null;
                        }
                        if (Intrinsics.areEqual(v3, textView2)) {
                            InputMethodUtil.hide(requireActivity());
                            r rVar6 = this.viewModel;
                            if (rVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                rVar3 = rVar6;
                            }
                            rVar3.j2();
                        } else {
                            QUIButton qUIButton2 = this.previewButton;
                            if (qUIButton2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("previewButton");
                                qUIButton2 = null;
                            }
                            if (Intrinsics.areEqual(v3, qUIButton2)) {
                                bt.h(bt.f235484a, v3, "em_sgrp_preview", "clck", null, 8, null);
                                r rVar7 = this.viewModel;
                                if (rVar7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    rVar7 = null;
                                }
                                Pair<ArrayList<ProfileRuleData>, Boolean> b26 = rVar7.b2();
                                if (b26.getSecond().booleanValue()) {
                                    QQToast.makeText(getActivity(), 0, "\u5c11\u4e8e5\u4e2a\u5b57\u7684\u89c4\u5219\u4e0d\u5c55\u793a", 1).show();
                                }
                                GuildInfoFragment.Companion companion = GuildInfoFragment.INSTANCE;
                                Context requireContext = requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                                String str2 = this.guildId;
                                if (str2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                                } else {
                                    str = str2;
                                }
                                companion.b(requireContext, str, b26.getFirst());
                            } else {
                                QUIButton qUIButton3 = this.finishButton;
                                if (qUIButton3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("finishButton");
                                } else {
                                    qUIButton = qUIButton3;
                                }
                                if (Intrinsics.areEqual(v3, qUIButton)) {
                                    bt.h(bt.f235484a, v3, "em_sgrp_complete_btn", "clck", null, 8, null);
                                    ai();
                                }
                            }
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        com.tencent.mobileqq.guild.window.s sVar = new com.tencent.mobileqq.guild.window.s(requireActivity().getWindow().getDecorView());
        this.mSoftKeyboardStateHelper = sVar;
        sVar.g(new d());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.guild.window.s sVar = this.mSoftKeyboardStateHelper;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoftKeyboardStateHelper");
            sVar = null;
        }
        sVar.j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ji();
        initView(view);
        initViewModel();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(DialogInterface dialogInterface, int i3) {
    }
}
