package com.tencent.mobileqq.guild.feed.feedoption;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.ad;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J,\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0018\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000fH\u0002J,\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0*j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`+2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bJ\u000e\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/J\u000e\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202J\u000e\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u000205J\u000e\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0003J&\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010B\u001a\u00020A2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020\u0005H\u0016J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010H\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR$\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010WR\u0016\u0010Z\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010NR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010d\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010N\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010h\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010N\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\u0018\u0010k\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010QR\u0016\u0010n\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010]\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "", "position", "", "Nh", "", "", "", "dtParam", "Mh", "Landroid/view/View;", "view", "Dh", "Landroid/widget/TextView;", "Bh", "Ch", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProItemCbData;", "Fh", "Ih", "initView", "uh", "xh", "Landroid/widget/LinearLayout;", VipFunCallConstants.KEY_GROUP, "", "Lkotlin/Pair;", "buttonsTextPair", "sh", "th", "Landroid/content/Context;", "context", "Ah", "itemTextId", "itemId", OcrConfig.CHINESE, "yh", "Lh", "Eh", "Kh", "wh", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Gh", "value", "Oh", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "data", "Hh", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "vh", "Lcom/tencent/mobileqq/guild/feed/feedoption/a;", "callback", "Jh", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onResume", "onStart", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/feedoption/d;", "D", "Lcom/tencent/mobileqq/guild/feed/feedoption/d;", "viewModel", "E", "Ljava/lang/String;", "scene", UserInfo.SEX_FEMALE, "I", "G", "Ljava/util/Map;", "itemDtParams", "H", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "J", "feedId", "", "K", "Z", "isFeedTopLocally", "L", "getFocusSectionName", "()Ljava/lang/String;", "setFocusSectionName", "(Ljava/lang/String;)V", "focusSectionName", "M", "getSourceSectionName", "setSourceSectionName", "sourceSectionName", "N", "Lcom/tencent/mobileqq/guild/feed/feedoption/a;", "doOptionCallback", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "shouldDismissDialog", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedOptionDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<Pair<Integer, Integer>> S;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private d viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GProStFeed data;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private GuildFeedBaseInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFeedTopLocally;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String sourceSectionName;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private a doOptionCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean shouldDismissDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String scene = "";

    /* renamed from: F, reason: from kotlin metadata */
    private int position = -1;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> itemDtParams = new HashMap();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String feedId = "";

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String focusSectionName = "";

    /* renamed from: P, reason: from kotlin metadata */
    private int showType = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 JX\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionDialogFragment$a;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "scene", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "data", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "position", "", "dtParam", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/mobileqq/guild/feed/feedoption/a;", "doOptionCallback", "Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionDialogFragment;", "a", "", "ITEM_HEIGHT_DP", UserInfo.SEX_FEMALE, "SHOW_TYPE_ALL", "I", "SHOW_TYPE_ONLY_FEED_OPTION", "SHOW_TYPE_ONLY_REPORT", "SHOW_TYPE_RECOMMEND_CARD_ALL", "SHOW_TYPE_RECOMMEND_CARD_ONLY_DELETE", "SHOW_TYPE_RECOMMEND_CARD_ONLY_REPORT", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedOptionDialogFragment a(int showType, @NotNull String scene, @NotNull GProStFeed data, @NotNull GuildFeedBaseInitBean initBean, int position, @NotNull Map<String, ? extends Object> dtParam, @NotNull FragmentManager fragmentManager, @NotNull a doOptionCallback) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Intrinsics.checkNotNullParameter(dtParam, "dtParam");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(doOptionCallback, "doOptionCallback");
            GuildFeedOptionDialogFragment guildFeedOptionDialogFragment = new GuildFeedOptionDialogFragment();
            guildFeedOptionDialogFragment.Ph(showType);
            guildFeedOptionDialogFragment.Oh(scene);
            guildFeedOptionDialogFragment.Nh(position);
            guildFeedOptionDialogFragment.Hh(data);
            guildFeedOptionDialogFragment.vh(initBean);
            guildFeedOptionDialogFragment.Mh(dtParam);
            guildFeedOptionDialogFragment.Jh(doOptionCallback);
            com.tencent.mobileqq.guild.base.extension.d.a(guildFeedOptionDialogFragment, fragmentManager, "GuildFeedOptionDialogFr");
            return guildFeedOptionDialogFragment;
        }

        Companion() {
        }
    }

    static {
        List<Pair<Integer, Integer>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Integer.valueOf(R.string.f145560rt), Integer.valueOf(R.id.weu)), TuplesKt.to(Integer.valueOf(R.string.f145540rr), Integer.valueOf(R.id.wes)), TuplesKt.to(Integer.valueOf(R.string.ajx), Integer.valueOf(R.id.wet))});
        S = listOf;
    }

    private final TextView Ah(Context context) {
        int dip2px = ViewUtils.dip2px(56.0f);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.guild_feed_option_first_selector);
        textView.setText(context.getString(R.string.f144740pl, this.sourceSectionName));
        textView.setTextSize(0, ViewUtils.dip2px(14.0f));
        oh1.a.a(textView, R.color.qui_common_text_secondary);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px));
        return textView;
    }

    private final void Bh(TextView view) {
        d dVar = this.viewModel;
        if (dVar != null) {
            dVar.O1(view.getText().toString(), this.feedId, this.scene, Fh());
        }
        QQToast.makeText(view.getContext(), 2, R.string.f144100nv, 0).show();
        Ih();
    }

    private final void Ch(View view) {
        String str;
        long j3;
        GProStUser gProStUser;
        ad adVar = ad.f223828a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        String str2 = this.feedId;
        GProStFeed gProStFeed = this.data;
        if (gProStFeed != null && (gProStUser = gProStFeed.poster) != null) {
            str = gProStUser.idd;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (gProStFeed != null) {
            j3 = gProStFeed.createTime;
        } else {
            j3 = 0;
        }
        adVar.f(new ad.FeedDeleteArgs(context, 0L, 0L, str2, str, j3, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionDialogFragment$doItemDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedOptionDialogFragment.this.Ih();
            }
        }, 70, null));
    }

    private final void Dh(View view) {
        d dVar = this.viewModel;
        if (dVar != null) {
            dVar.Q1(this.feedId);
        }
        QQToast.makeText(view.getContext(), 2, R.string.f144750pm, 0).show();
        Ih();
    }

    private final int Eh() {
        Integer num;
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.itemDtParams.get("sgrp_discover_tab_type_value") == DiscoverTabType.HOT) {
            return 2;
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.initBean;
        if (guildFeedBaseInitBean != null) {
            num = Integer.valueOf(guildFeedBaseInitBean.getBusinessType());
        } else {
            num = null;
        }
        boolean z19 = false;
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 11)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (num != null && num.intValue() == 13)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || (num != null && num.intValue() == 2)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 || (num != null && num.intValue() == 12)) {
            z19 = true;
        }
        if (z19) {
            return 1;
        }
        if (num != null && num.intValue() == 5) {
            return 3;
        }
        return 4;
    }

    private final IGProItemCbData Fh() {
        Object obj = this.itemDtParams.get("sgrp_discover_cb_data");
        if (obj instanceof IGProItemCbData) {
            return (IGProItemCbData) obj;
        }
        return null;
    }

    private final HashMap<String, Object> Gh(View view) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            Intrinsics.checkNotNullExpressionValue(text, "view.text");
            hashMap.put("sgrp_content_feedback_reason", text);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        a aVar = this.doOptionCallback;
        if (aVar != null) {
            aVar.a(this.feedId);
        }
        this.doOptionCallback = null;
        dismissAllowingStateLoss();
    }

    private final void Kh() {
        View findViewById;
        View view = this.rootView;
        if (view != null && (findViewById = view.findViewById(R.id.wcj)) != null) {
            bt.d(findViewById, "em_sgrp_content_feedback_close_btn", null, null, null, null, 60, null);
        }
    }

    private final void Lh() {
        String str;
        String str2;
        String str3;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        GProStChannelInfo gProStChannelInfo2;
        GProStChannelSign gProStChannelSign2;
        GProStRichText gProStRichText;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.rootView, "pg_sgrp_content_feedback");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        GProStFeed gProStFeed = this.data;
        String str4 = null;
        if (gProStFeed == null || (str = gProStFeed.idd) == null) {
            str = null;
        }
        hashMap.put("sgrp_content_id", str);
        if (gProStFeed != null && (gProStRichText = gProStFeed.title) != null) {
            str2 = gProStRichText.toString();
        } else {
            str2 = null;
        }
        hashMap.put("sgrp_content_title", str2);
        hashMap.put("sgrp_content_card_type", 1);
        if (gProStFeed != null && (gProStChannelInfo2 = gProStFeed.channelInfo) != null && (gProStChannelSign2 = gProStChannelInfo2.sign) != null) {
            str3 = Long.valueOf(gProStChannelSign2.guildId).toString();
        } else {
            str3 = null;
        }
        hashMap.put("sgrp_channel_id", str3);
        if (gProStFeed != null && (gProStChannelInfo = gProStFeed.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
            str4 = Long.valueOf(gProStChannelSign.channelId).toString();
        }
        hashMap.put("sgrp_sub_channel_id", str4);
        hashMap.put("sgrp_user_place", Integer.valueOf(this.position));
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, this.itemDtParams.get("sgrp_forum_trace_id"));
        hashMap.put("sgrp_discover_tab_type", this.itemDtParams.get("sgrp_discover_tab_type"));
        hashMap.put("sgrp_slideup_num", this.itemDtParams.get("sgrp_slideup_num"));
        hashMap.put("sgrp_content_type", this.itemDtParams.get("sgrp_content_type"));
        hashMap.put("sgrp_discover_wuji_id", this.itemDtParams.get("sgrp_discover_wuji_id"));
        hashMap.put("sgrp_content_page_type", Integer.valueOf(Eh()));
        w.a(hashMap);
        VideoReport.setPageParams(this.rootView, new PageParams(hashMap));
        VideoReport.reportEvent("pgin", this.rootView, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(Map<String, ? extends Object> dtParam) {
        this.itemDtParams = dtParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(int position) {
        this.position = position;
    }

    private final void initView() {
        View findViewById;
        View findViewById2;
        View view = this.rootView;
        if (view != null && (findViewById2 = view.findViewById(R.id.wcj)) != null) {
            findViewById2.setOnClickListener(this);
        }
        View view2 = this.rootView;
        if (view2 != null && (findViewById = view2.findViewById(R.id.wck)) != null) {
            findViewById.setOnClickListener(this);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColorStateList(R.color.qui_common_bg_middle_light));
        float dip2px = ViewUtils.dip2px(12.0f);
        gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
        View view3 = this.rootView;
        if (view3 != null) {
            view3.setBackground(gradientDrawable);
        }
    }

    private final void sh(LinearLayout group, List<Pair<Integer, Integer>> buttonsTextPair) {
        Map mapOf;
        int i3 = 0;
        for (Object obj : buttonsTextPair) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            int intValue = ((Number) pair.getFirst()).intValue();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            TextView zh5 = zh(intValue, requireContext, ((Number) pair.getSecond()).intValue());
            if (i3 == 0) {
                zh5.setBackgroundResource(R.drawable.guild_feed_option_first_selector);
            }
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f)));
            view.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            if (group != null) {
                group.addView(zh5, i3 * 2);
            }
            if (group != null) {
                group.addView(view, (i3 * 2) + 1);
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_name", zh5.getText()));
            bt.d(zh5, "em_sgrp_forum_operate_btn", mapOf, null, null, null, 56, null);
            i3 = i16;
        }
    }

    private final void th(LinearLayout group) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        TextView Ah = Ah(requireContext);
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f)));
        view.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
        if (group != null) {
            group.addView(Ah, 0);
        }
        if (group != null) {
            group.addView(view, 1);
        }
    }

    private final void uh() {
        LinearLayout linearLayout;
        int i3;
        boolean z16 = false;
        this.isFeedTopLocally = false;
        View view = this.rootView;
        if (view != null) {
            linearLayout = (LinearLayout) view.findViewById(R.id.wor);
        } else {
            linearLayout = null;
        }
        LinkedList linkedList = new LinkedList();
        if (this.isFeedTopLocally) {
            i3 = R.string.f145580rv;
        } else {
            i3 = R.string.f145570ru;
        }
        linkedList.add(TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(R.id.wev)));
        linkedList.addAll(S);
        Unit unit = Unit.INSTANCE;
        sh(linearLayout, linkedList);
        String str = this.sourceSectionName;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            th(linearLayout);
        }
    }

    private final void wh(TextView view) {
        bt.d(view, "em_sgrp_content_feedback_reason_btn", Gh(view), null, null, null, 56, null);
    }

    private final void xh() {
        LinearLayout linearLayout;
        View view = this.rootView;
        if (view != null) {
            linearLayout = (LinearLayout) view.findViewById(R.id.wor);
        } else {
            linearLayout = null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(TuplesKt.to(Integer.valueOf(R.string.ajx), Integer.valueOf(R.id.wet)));
        Unit unit = Unit.INSTANCE;
        sh(linearLayout, linkedList);
    }

    private final void yh(Context context) {
        LinearLayout linearLayout;
        List<String> a16 = GuildFeedOptionConfigParser.INSTANCE.a().a();
        View view = this.rootView;
        if (view != null) {
            linearLayout = (LinearLayout) view.findViewById(R.id.wor);
        } else {
            linearLayout = null;
        }
        int dip2px = ViewUtils.dip2px(56.0f);
        int size = a16.size();
        for (int i3 = 0; i3 < size; i3++) {
            TextView textView = new TextView(context);
            textView.setText(a16.get(i3));
            textView.setGravity(17);
            if (i3 == 0) {
                textView.setBackgroundResource(R.drawable.guild_feed_option_first_selector);
            } else {
                textView.setBackgroundResource(R.drawable.guild_feed_option_item_selector);
            }
            textView.setTextSize(0, ViewUtils.dip2px(17.0f));
            oh1.a.a(textView, R.color.qui_common_text_primary);
            textView.setOnClickListener(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px));
            View view2 = new View(context);
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f)));
            view2.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            if (linearLayout != null) {
                linearLayout.addView(textView, i3 * 2);
            }
            if (linearLayout != null) {
                linearLayout.addView(view2, (i3 * 2) + 1);
            }
            wh(textView);
        }
    }

    private final TextView zh(int itemTextId, Context context, int itemId) {
        int dip2px = ViewUtils.dip2px(56.0f);
        TextView textView = new TextView(context);
        textView.setId(itemId);
        textView.setText(context.getText(itemTextId));
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.guild_feed_option_item_selector);
        textView.setTextSize(0, ViewUtils.dip2px(17.0f));
        oh1.a.a(textView, R.color.qui_common_text_primary);
        textView.setOnClickListener(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px));
        return textView;
    }

    public final void Hh(@NotNull GProStFeed data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.feedId = data.idd.toString();
    }

    public final void Jh(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.doOptionCallback = callback;
    }

    public final void Oh(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.scene = value;
    }

    public final void Ph(int showType) {
        this.showType = showType;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.wcj) {
                dismissAllowingStateLoss();
            } else if (id5 == R.id.wck) {
                Dh(view);
            } else if (id5 == R.id.wet) {
                Ch(view);
            } else if (view instanceof TextView) {
                Bh((TextView) view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
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
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        Window window2 = aVar.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(null);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.rootView = inflater.inflate(R.layout.epu, container);
        Context context = getContext();
        if (context == null) {
            QLog.w("GuildFeedOptionDialogFr", 1, "initUI context is null");
            dismissAllowingStateLoss();
            view = this.rootView;
        } else {
            d dVar = (d) d.INSTANCE.a().create(d.class);
            this.viewModel = dVar;
            if (dVar != null) {
                dVar.init();
            }
            Lh();
            initView();
            int i3 = this.showType;
            if (i3 != 0) {
                View view2 = null;
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                View view3 = this.rootView;
                                if (view3 != null) {
                                    view2 = view3.findViewById(R.id.wck);
                                }
                                if (view2 != null) {
                                    view2.setVisibility(8);
                                }
                                xh();
                            }
                        } else {
                            yh(context);
                        }
                    } else {
                        yh(context);
                        xh();
                    }
                } else {
                    yh(context);
                    View view4 = this.rootView;
                    if (view4 != null) {
                        view2 = view4.findViewById(R.id.wck);
                    }
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                }
            } else {
                yh(context);
                uh();
            }
            Kh();
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewParent viewParent;
        super.onResume();
        View view = this.rootView;
        ViewGroup viewGroup = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog;
        super.onStart();
        if (this.shouldDismissDialog && (dialog = getDialog()) != null) {
            dialog.hide();
        }
    }

    public final void vh(@NotNull GuildFeedBaseInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.initBean = bean;
    }
}
