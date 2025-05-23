package com.tencent.mobileqq.guild.live.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guildlive.api.IGuildLiveAioApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.setting.channelsubscribe.GuildConfirmSubscribeDialogFragment;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cc;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 z2\u00020\u0001:\u0002{|BG\u0012\u0006\u0010B\u001a\u00020=\u0012\u0006\u0010H\u001a\u00020C\u0012\u0006\u0010K\u001a\u00020\t\u0012\u0006\u0010O\u001a\u00020\t\u0012\u0006\u0010Q\u001a\u00020\t\u0012\u0006\u0010S\u001a\u00020\t\u0012\u0006\u0010X\u001a\u00020 \u0012\u0006\u0010[\u001a\u00020\t\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0016\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020#0\"2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020\u0002H\u0002J$\u00105\u001a\u00020+2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u00020\u0002H\u0016J\u0012\u0010;\u001a\u00020:2\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0006\u0010<\u001a\u00020\u0002R\u0017\u0010B\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010H\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010K\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010O\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bM\u0010J\u001a\u0004\bN\u0010LR\u0017\u0010Q\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010LR\u0017\u0010S\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bR\u0010J\u001a\u0004\bS\u0010LR\u0017\u0010X\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0017\u0010[\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\bY\u0010J\u001a\u0004\bZ\u0010LR\u0016\u0010]\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010JR\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010JR\u0016\u0010b\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\"\u0010s\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010J\u001a\u0004\bp\u0010L\"\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010JR\u0016\u0010w\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010J\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initData", "Rh", "Yh", "Qh", "", "Kh", "", "Ih", "Lcom/tencent/mobileqq/guild/live/widget/MoreIconViewHolder;", "viewHolder", "ni", "Zh", "Ph", "", "list", "ri", "initView", "ei", "Uh", "ai", "Hh", "isChecked", "Oh", "Lvh2/cc;", "Lh", "hasRegisterRecentMsgList", "si", "Sh", WidgetCacheLunarData.JI, "", "eid", "", "", "Jh", "gi", "ci", "checked", "li", "fi", "ii", "Landroid/view/View;", "view", "qi", "pi", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onStart", "Landroid/app/Dialog;", "onCreateDialog", "onBack", "Landroidx/fragment/app/FragmentActivity;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity", "()Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;", "D", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;", "getCallback", "()Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;", "callback", "E", "Z", "isAdmin", "()Z", UserInfo.SEX_FEMALE, "getAllowStartLive", "allowStartLive", "G", "isAnchorLiving", "H", "isBroadcasting", "I", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "J", "getCanManager", "canManager", "K", "mIsMsgNotifyOpen", "L", "mHasRegisterRecentMsgList", "M", "Landroid/view/View;", "mRootView", "N", "mChangeTitleView", "P", "mMuteView", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mRoomNameTv", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "mMuteSwitch", ExifInterface.LATITUDE_SOUTH, "Nh", "setTriggerByHand", "(Z)V", "triggerByHand", "T", "mHasRemaingAtCount", "U", "mGuildAtAllSwitchOpen", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;ZZZZLjava/lang/String;Z)V", "V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveTopMoreDialogFragment extends BottomSheetDialogFragment {
    private static final int W = R.style.f174032aw0;

    @NotNull
    private static final Map<String, Integer> X;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FragmentActivity fragmentActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final a callback;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isAdmin;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean allowStartLive;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isAnchorLiving;

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean isBroadcasting;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean canManager;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsMsgNotifyOpen;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mHasRegisterRecentMsgList;

    /* renamed from: M, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: N, reason: from kotlin metadata */
    private View mChangeTitleView;

    /* renamed from: P, reason: from kotlin metadata */
    private View mMuteView;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mRoomNameTv;

    /* renamed from: R, reason: from kotlin metadata */
    private GuildSwitchButton mMuteSwitch;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean triggerByHand;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mHasRemaingAtCount;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mGuildAtAllSwitchOpen;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;", "", "", "b", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4 && GuildLiveTopMoreDialogFragment.this.getTriggerByHand()) {
                GuildLiveTopMoreDialogFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) GuildLiveTopMoreDialogFragment.X.get(((MoreIcon) t16).getContent()), (Integer) GuildLiveTopMoreDialogFragment.X.get(((MoreIcon) t17).getContent()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends RecyclerView.ItemDecoration {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) >= 4) {
                outRect.top = (int) cw.b(25);
            }
        }
    }

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(cw.h(R.string.f141060fn), 0), TuplesKt.to(cw.h(R.string.f148000ye), 1), TuplesKt.to(cw.h(R.string.f147970yb), 2), TuplesKt.to(cw.h(R.string.f147980yc), 3), TuplesKt.to(cw.h(R.string.f147330wl), 4), TuplesKt.to(cw.h(R.string.f147960ya), 5));
        X = mapOf;
    }

    public GuildLiveTopMoreDialogFragment(@NotNull FragmentActivity fragmentActivity, @NotNull a callback, boolean z16, boolean z17, boolean z18, boolean z19, @NotNull String title, boolean z26) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(title, "title");
        this.fragmentActivity = fragmentActivity;
        this.callback = callback;
        this.isAdmin = z16;
        this.allowStartLive = z17;
        this.isAnchorLiving = z18;
        this.isBroadcasting = z19;
        this.title = title;
        this.canManager = z26;
        this.triggerByHand = true;
        this.mHasRemaingAtCount = true;
        this.mGuildAtAllSwitchOpen = true ^ ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_offline_aio_atall_entrance", false);
    }

    private final boolean Hh() {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            return false;
        }
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface\n           \u2026va, ProcessConstant.MAIN)");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        return ((IGPSService) runtimeService).isQQMsgListChannel(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId());
    }

    private final boolean Ih() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.s().getChannelInfo() == null) {
            return false;
        }
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        Intrinsics.checkNotNull(channelInfo);
        if (channelInfo.getFinalMsgNotify() != 1) {
            return false;
        }
        return true;
    }

    private final Map<String, Object> Jh(String eid) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_stream_aio");
        hashMap.put("dt_pgid", "pg_sgrp_stream_aio");
        hashMap.put("eid", eid);
        HashMap<String, Object> b16 = new z().b();
        Intrinsics.checkNotNullExpressionValue(b16, "GuildLiveDtUtil().guildLiveDtMap");
        hashMap.put("cur_pg", b16);
        return hashMap;
    }

    private final int Kh() {
        if (this.mHasRegisterRecentMsgList) {
            return R.drawable.guild_detail_subscribed_icon_night;
        }
        if (ai()) {
            return R.drawable.guild_detail_subscribe_icon_dark_with_reddot;
        }
        return R.drawable.guild_detail_subscribe_icon_dark;
    }

    private final cc Lh(final boolean isChecked, final MoreIconViewHolder viewHolder) {
        return new cc() { // from class: com.tencent.mobileqq.guild.live.widget.k
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                GuildLiveTopMoreDialogFragment.Mh(GuildLiveTopMoreDialogFragment.this, isChecked, viewHolder, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GuildLiveTopMoreDialogFragment this$0, boolean z16, MoreIconViewHolder viewHolder, int i3, String str) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        if (!this$0.isAdded()) {
            QLog.e("GuildLiveTopMoreDialogFragment", 1, "registerToMsgListResult: fragment is not added");
            return;
        }
        QLog.d("GuildLiveTopMoreDialogFragment", 1, "registerToMsgListResult: result[" + i3 + "] errMsg[" + str + "]");
        this$0.mHasRegisterRecentMsgList = this$0.Hh();
        if (i3 != 0) {
            if (i3 != 110000) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
                this$0.si(viewHolder, this$0.mHasRegisterRecentMsgList);
                return;
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f141010fi, 0).show();
                this$0.si(viewHolder, this$0.mHasRegisterRecentMsgList);
                return;
            }
        }
        BaseApplication context = BaseApplication.getContext();
        if (z16) {
            i16 = R.string.f141020fj;
        } else {
            i16 = R.string.f141880hv;
        }
        QQToast.makeText(context, 2, i16, 0).show();
    }

    private final void Oh(boolean isChecked, MoreIconViewHolder viewHolder) {
        AppInterface l3 = ch.l();
        if (l3 == null) {
            return;
        }
        int i3 = 1;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
            si(viewHolder, Hh());
            return;
        }
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        uh2.e eVar = (uh2.e) runtimeService;
        if (!isChecked) {
            i3 = 2;
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        eVar.setQQMsgListChannel(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), i3, Lh(isChecked, viewHolder));
    }

    private final boolean Ph() {
        return com.tencent.mobileqq.guild.rolegroup.model.repositories.r.f232798e.getGuildPermission(GLiveChannelCore.f226698a.s().getGuildId()).a(40001);
    }

    private final void Qh() {
        List<Integer> listOf;
        if (!GLiveChannelCore.f226698a.r().a() || !this.isBroadcasting || !this.allowStartLive) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(R.id.t_w));
            ri(listOf);
        }
    }

    private final void Rh() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setPeekHeight(0);
        Dialog dialog2 = getDialog();
        Intrinsics.checkNotNull(dialog2, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog2).getBehavior().setState(3);
        Dialog dialog3 = getDialog();
        Intrinsics.checkNotNull(dialog3, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog3).getBehavior().addBottomSheetCallback(new c());
    }

    private final void Sh() {
        ((com.tencent.mobileqq.guild.live.viewmodel.h) GLiveChannelCore.f226698a.q(com.tencent.mobileqq.guild.live.viewmodel.h.class)).h2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.widget.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildLiveTopMoreDialogFragment.Th(GuildLiveTopMoreDialogFragment.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildLiveTopMoreDialogFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mRoomNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoomNameTv");
            textView = null;
        }
        textView.setText(str);
    }

    private final void Uh() {
        GuildSwitchButton guildSwitchButton = this.mMuteSwitch;
        GuildSwitchButton guildSwitchButton2 = null;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteSwitch");
            guildSwitchButton = null;
        }
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        boolean z16 = false;
        if (channelInfo != null && channelInfo.getBannedSpeak() == 1) {
            z16 = true;
        }
        guildSwitchButton.setChecked(!z16);
        GuildSwitchButton guildSwitchButton3 = this.mMuteSwitch;
        if (guildSwitchButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteSwitch");
        } else {
            guildSwitchButton2 = guildSwitchButton3;
        }
        guildSwitchButton2.setOnCheckedChangeListener(new GuildSwitchButton.a() { // from class: com.tencent.mobileqq.guild.live.widget.p
            @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
            public final void onCheckedChanged(GuildSwitchButton guildSwitchButton4, boolean z17) {
                GuildLiveTopMoreDialogFragment.Vh(GuildLiveTopMoreDialogFragment.this, guildSwitchButton4, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(GuildLiveTopMoreDialogFragment this$0, GuildSwitchButton guildSwitchButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.li(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(GuildLiveTopMoreDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ci();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(GuildLiveTopMoreDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ci();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Yh() {
        List mutableListOf;
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        List<Integer> emptyList;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String string = getString(R.string.f147330wl);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_key_setting)");
        MoreIcon moreIcon = new MoreIcon(string, R.drawable.guild_hexagon_setting_white, new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$managerIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.ji();
            }
        });
        String string2 = getString(R.string.f147970yb);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild_live_more_float)");
        MoreIcon moreIcon2 = new MoreIcon(string2, R.drawable.guild_live_topbar_scale_icon, new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$floatIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.gi();
            }
        });
        String string3 = getString(R.string.f147980yc);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild_live_more_gift)");
        MoreIcon moreIcon3 = new MoreIcon(string3, R.drawable.guild_more_gift, new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$giftIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.ii();
            }
        });
        String string4 = getString(R.string.f147960ya);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.guild_live_more_end)");
        MoreIcon moreIcon4 = new MoreIcon(string4, R.drawable.guild_more_close, new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$closeIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.fi();
            }
        });
        String string5 = getString(R.string.f141060fn);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.guild_channel_announce)");
        MoreIcon moreIcon5 = new MoreIcon(string5, R.drawable.guild_detail_uptop_icon_dark, new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$uptopMsgIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.ei();
            }
        });
        String string6 = getString(R.string.f148000ye);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.guild\u2026ore_register_recent_msgs)");
        MoreIcon moreIcon6 = new MoreIcon(string6, Kh(), new Function1<MoreIconViewHolder, Unit>() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment$initVisibility$registerRecentMsgIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MoreIconViewHolder moreIconViewHolder) {
                invoke2(moreIconViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MoreIconViewHolder it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildLiveTopMoreDialogFragment.this.ni(it);
            }
        });
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(moreIcon5, moreIcon6);
        if (this.isAdmin || this.canManager) {
            mutableListOf.add(moreIcon);
        }
        if (!this.isBroadcasting) {
            Qh();
            if (this.isAdmin || Intrinsics.areEqual(GLiveChannelCore.f226698a.t().C().getValue(), Boolean.TRUE)) {
                mutableListOf.add(moreIcon3);
            }
        } else {
            boolean z16 = this.isAdmin;
            if (!z16 && !this.canManager && !this.isAnchorLiving) {
                arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(moreIcon3);
                mutableListOf.addAll(arrayListOf4);
                Qh();
            } else if ((z16 || this.canManager) && !this.isAnchorLiving) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(moreIcon2, moreIcon3);
                mutableListOf.addAll(arrayListOf);
                Qh();
            } else if (z16 || !this.isAnchorLiving) {
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(moreIcon2, moreIcon3, moreIcon4);
                mutableListOf.addAll(arrayListOf2);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                ri(emptyList);
            } else {
                arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(moreIcon3, moreIcon4);
                mutableListOf.addAll(arrayListOf3);
            }
            if (GLiveChannelCore.f226698a.r().a() && (this.allowStartLive || this.isAdmin)) {
                if (!mutableListOf.contains(moreIcon2)) {
                    mutableListOf.add(moreIcon2);
                }
                if (!mutableListOf.contains(moreIcon3)) {
                    mutableListOf.add(moreIcon3);
                }
                if (!mutableListOf.contains(moreIcon4)) {
                    mutableListOf.add(moreIcon4);
                }
            }
        }
        if (!this.isAdmin && !this.allowStartLive) {
            mutableListOf.remove(moreIcon3);
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (Intrinsics.areEqual(gLiveChannelCore.s().getEnterSourceType(), "functional_qq_little_world_feed")) {
            mutableListOf.remove(moreIcon2);
        }
        if (iGPSService.isQQMsgListGuild(az.d(gLiveChannelCore.s().getGuildId(), 0L))) {
            mutableListOf.remove(moreIcon6);
        }
        if (d12.a.c()) {
            mutableListOf.remove(moreIcon6);
        }
        if (!mutableListOf.isEmpty()) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f790948u);
            int i3 = 4;
            if (mutableListOf.size() <= 4) {
                i3 = mutableListOf.size();
            }
            recyclerView.setLayoutManager(new SafeGridLayoutManager(getContext(), i3));
            recyclerView.addItemDecoration(new e());
            if (mutableListOf.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableListOf, new d());
            }
            recyclerView.setAdapter(new MoreIconAdapter(mutableListOf));
        }
        if ((!ch.z0() || !this.isBroadcasting || Zh() || !Ph()) && gLiveChannelCore.r().a() && this.isBroadcasting && this.isAdmin) {
            Zh();
        }
    }

    private final boolean Zh() {
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        boolean z16 = false;
        if (channelInfo != null && channelInfo.getVisibleType() == 1) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean ai() {
        if (((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")) == null) {
            return false;
        }
        if (!r0.getQQMsgListChannels().isEmpty()) {
            bw.S0();
            return false;
        }
        String[] showRedDotVersions = GuildConfirmSubscribeDialogFragment.L;
        Intrinsics.checkNotNullExpressionValue(showRedDotVersions, "showRedDotVersions");
        for (String str : showRedDotVersions) {
            if (str.equals(AppSetting.f99551k)) {
                return !bw.s0();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(com.google.android.material.bottomsheet.a it, GuildLiveTopMoreDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.show();
        it.getBehavior().setState(3);
        this$0.triggerByHand = true;
    }

    private final void ci() {
        this.triggerByHand = false;
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((com.google.android.material.bottomsheet.a) dialog).getBehavior().setState(4);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.q
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveTopMoreDialogFragment.di(GuildLiveTopMoreDialogFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(GuildLiveTopMoreDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mRoomNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoomNameTv");
            textView = null;
        }
        GuildLiveChangeTitleFragment guildLiveChangeTitleFragment = new GuildLiveChangeTitleFragment(textView.getText().toString(), this$0);
        FragmentManager supportFragmentManager = this$0.fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildLiveChangeTitleFragment, supportFragmentManager, "GuildLiveTopMoreDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        Long value = gLiveChannelCore.t().G().getValue();
        if (value == null) {
            value = -1L;
        }
        long longValue = value.longValue();
        if (longValue < 0) {
            longValue = Long.MAX_VALUE;
        }
        ((IGuildLiveAioApi) QRoute.api(IGuildLiveAioApi.class)).jumpToExcellentMsgDetail(getContext(), gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), longValue);
        dismissAllowingStateLoss();
        ch.f235509b.doReportEvent("dt_clck", Jh("em_sgrp_announcement_entrance"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi() {
        dismissAllowingStateLoss();
        this.callback.a();
        ch.f235509b.doReportEvent("dt_clck", Jh("em_stream_aio_button"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        dismissAllowingStateLoss();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveTopMoreDialogFragment.hi(GuildLiveTopMoreDialogFragment.this);
            }
        }, 360L);
        ch.f235509b.doReportEvent("dt_clck", Jh("em_stream_aio_fwindow"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(GuildLiveTopMoreDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        Context context = getContext();
        if (context != null) {
            SecurityTipHelperKt.l(context, "https://h5.qzone.qq.com/v2/vip/qun-gift/qq-coin-wallet?_wv=2");
            ch.f235509b.doReportEvent("dt_clck", Jh("em_sgrp_stream_revenue"));
            dismiss();
        }
    }

    private final void initData() {
        this.mHasRegisterRecentMsgList = Hh();
        this.mIsMsgNotifyOpen = Ih();
    }

    private final void initView() {
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.trp);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildLiveTopMoreDialogFragment.Wh(GuildLiveTopMoreDialogFragment.this, view3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<V\u2026ChangeTitle() }\n        }");
        this.mChangeTitleView = findViewById;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.zkh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.mute)");
        this.mMuteView = findViewById2;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.f166079ym0);
        TextView textView = (TextView) findViewById3;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildLiveTopMoreDialogFragment.Xh(GuildLiveTopMoreDialogFragment.this, view5);
            }
        });
        Sh();
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById<T\u2026 initNameView()\n        }");
        this.mRoomNameTv = textView;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view5;
        }
        View findViewById4 = view2.findViewById(R.id.zko);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.mute_switch)");
        this.mMuteSwitch = (GuildSwitchButton) findViewById4;
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        dismissAllowingStateLoss();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveTopMoreDialogFragment.ki(GuildLiveTopMoreDialogFragment.this);
            }
        }, 50L);
        ch.f235509b.doReportEvent("dt_clck", Jh("em_stream_aio_manage"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(GuildLiveTopMoreDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.b();
    }

    private final void li(final boolean checked) {
        int i3;
        if (com.tencent.mobileqq.guild.util.o.c("live_change_mute")) {
            return;
        }
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_comment_deal_click", null, 0, null, 14, null);
        HashMap hashMap = new HashMap();
        if (checked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_switch", Integer.valueOf(i3));
        GuildSwitchButton guildSwitchButton = this.mMuteSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteSwitch");
            guildSwitchButton = null;
        }
        VideoReport.reportEvent("clck", guildSwitchButton, hashMap);
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo != null) {
            ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).setChannelBannedSpeak(channelInfo.getChannelUin(), !checked ? 1 : 0, new cd() { // from class: com.tencent.mobileqq.guild.live.widget.r
                @Override // vh2.cd
                public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                    GuildLiveTopMoreDialogFragment.mi(checked, i16, str, iGProSecurityResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(boolean z16, int i3, String errMsg, IGProSecurityResult iGProSecurityResult) {
        HashMap hashMapOf;
        com.tencent.mobileqq.guild.safety.j.b("GuildLiveTopMoreDialogFragment", "onClickMuteChange | result: " + i3 + " | errMsg: " + errMsg);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("room_mute_state", String.valueOf(z16)));
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        com.tencent.mobileqq.guild.performance.report.l.g("live_room_comment_deal_callback", hashMapOf, i3, errMsg);
        if (i3 == 0) {
            if (z16) {
                aa.a(R.string.f147900y5);
                return;
            } else {
                aa.a(R.string.f147890y4);
                return;
            }
        }
        aa.a(R.string.f1521119i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni(MoreIconViewHolder viewHolder) {
        boolean z16 = !this.mHasRegisterRecentMsgList;
        this.mHasRegisterRecentMsgList = z16;
        si(viewHolder, z16);
        Oh(this.mHasRegisterRecentMsgList, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(GuildLiveTopMoreDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void pi() {
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        GuildSwitchButton guildSwitchButton = this.mMuteSwitch;
        if (guildSwitchButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteSwitch");
            guildSwitchButton = null;
        }
        guildDTReportApiImpl.setElementExposureAndClickParams(guildSwitchButton, "em_sgrp_stream_switch", null);
        GuildSwitchButton guildSwitchButton2 = this.mMuteSwitch;
        if (guildSwitchButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteSwitch");
            guildSwitchButton2 = null;
        }
        guildDTReportApiImpl.setElementExposureAndClickParams(guildSwitchButton2, "em_sgrp_stream_switch", null);
    }

    private final void qi(View view) {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        IGProGuildInfo guildInfo = gLiveChannelCore.s().getGuildInfo();
        if (channelInfo != null && guildInfo != null) {
            z zVar = new z(channelInfo, guildInfo);
            String anchorTinyId = gLiveChannelCore.s().getAnchorTinyId();
            HashMap<String, Object> pageParams = zVar.b();
            Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
            pageParams.put("sgrp_access_id", anchorTinyId);
            w.a(pageParams);
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(view, "pg_sgrp_stream_aio");
            ch.f235509b.setChannelPageParams(view, channelInfo, pageParams);
        }
    }

    private final void ri(List<Integer> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            view.findViewById(intValue).setVisibility(8);
        }
    }

    private final void si(MoreIconViewHolder viewHolder, boolean hasRegisterRecentMsgList) {
        int i3;
        ImageView icon = viewHolder.getIcon();
        if (hasRegisterRecentMsgList) {
            i3 = R.drawable.guild_detail_subscribed_icon_night;
        } else {
            i3 = R.drawable.guild_detail_subscribe_icon_dark;
        }
        icon.setImageResource(i3);
    }

    /* renamed from: Nh, reason: from getter */
    public final boolean getTriggerByHand() {
        return this.triggerByHand;
    }

    public final void onBack() {
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildLiveTopMoreDialogFragment.bi(com.google.android.material.bottomsheet.a.this, this);
            }
        }, 100L);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = W;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eww, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026dialog, container, false)");
        this.mRootView = inflate;
        initView();
        initData();
        Yh();
        Rh();
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        qi(view);
        pi();
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        view2.getRootView().findViewById(tp1.a.c()).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.widget.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildLiveTopMoreDialogFragment.oi(GuildLiveTopMoreDialogFragment.this, view4);
            }
        });
    }
}
