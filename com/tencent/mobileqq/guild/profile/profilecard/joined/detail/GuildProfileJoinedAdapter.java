package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.base.extension.t;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ax;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bq;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import vp1.cz;
import wh2.em;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0011\u0018\u0000  2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "list", "", "setData", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "holder", "position", "o0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "value", BdhLogUtil.LogTag.Tag_Conn, "I", "n0", "()I", "q0", "(I)V", "mostCardCnt", "<init>", "()V", "D", "a", "ViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int E = bi.b(10);
    private static final int F = bi.a(6.7f);
    private static final int G = bi.b(8);
    private static final int H = bi.a(5.3f);
    private static final int I = bi.b(4);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildProfileJoinedData> dataList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private int mostCardCnt = 2;

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00106\u001a\u000201\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J.\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J&\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010'0&2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010*\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010=\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010<R\u001c\u0010>\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010<R#\u0010C\u001a\n ;*\u0004\u0018\u00010?0?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "J", "", "isLeftItem", "U", "O", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "", "name", BdhLogUtil.LogTag.Tag_Req, "guildName", "Lkotlin/Function1;", "", "block", "P", "channelStatus", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "tagList", "guildProfile", "guildNameLines", "M", "I", "text", "size", "", "N", "W", "data", "joined", "w", "D", "v", "", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H", "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lvp1/cz;", UserInfo.SEX_FEMALE, "Lvp1/cz;", "getBinding", "()Lvp1/cz;", "binding", "G", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "mCurData", "Landroid/animation/Animator;", "kotlin.jvm.PlatformType", "Landroid/animation/Animator;", "scaleInAnimator", "scaleOutAnimator", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/graphics/drawable/Drawable;", "onlineCircleDrawable", "K", "Z", "isNightTheme", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "L", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "reportApi", "<init>", "(Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter;Landroid/content/Context;Lvp1/cz;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final cz binding;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private GuildProfileJoinedData mCurData;

        /* renamed from: H, reason: from kotlin metadata */
        private final Animator scaleInAnimator;

        /* renamed from: I, reason: from kotlin metadata */
        private final Animator scaleOutAnimator;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final Lazy onlineCircleDrawable;

        /* renamed from: K, reason: from kotlin metadata */
        private boolean isNightTheme;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final GuildDTReportApiImpl reportApi;
        final /* synthetic */ GuildProfileJoinedAdapter M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull GuildProfileJoinedAdapter guildProfileJoinedAdapter, @NotNull Context context, cz binding) {
            super(binding.getRoot());
            Lazy lazy;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.M = guildProfileJoinedAdapter;
            this.context = context;
            this.binding = binding;
            this.scaleInAnimator = ve1.a.a(this.itemView, 1.0f, 0.96f);
            this.scaleOutAnimator = ve1.a.a(this.itemView, 0.96f, 1.0f);
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter$ViewHolder$onlineCircleDrawable$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Drawable invoke() {
                    return GuildProfileJoinedAdapter.ViewHolder.this.itemView.getResources().getDrawable(R.drawable.guild_recommend_circle_0cce6d_6dp);
                }
            });
            this.onlineCircleDrawable = lazy;
            this.isNightTheme = GuildThemeManager.f235286a.b();
            this.reportApi = new GuildDTReportApiImpl();
            binding.f442846n.setSelected(true);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Map<String, Object> B(GuildProfileJoinedData item, int guildNameLines) {
            String str;
            String str2;
            Map<String, Object> mutableMapOf;
            boolean z16;
            Object obj = "";
            if (item.getFriendJoinedNum() <= 0) {
                str = "";
            } else {
                str = String.valueOf(item.getFriendJoinedNum());
            }
            int i3 = 1;
            if (guildNameLines <= 1) {
                if (item.getChannelStatusText().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    str2 = item.getChannelStatusText();
                    if (guildNameLines <= 1 && !item.o().isEmpty()) {
                        obj = item.o();
                    }
                    Pair[] pairArr = new Pair[5];
                    pairArr[0] = TuplesKt.to("sgrp_channel_id", item.getGuildId());
                    pairArr[1] = TuplesKt.to("sgrp_channel_tags", str2);
                    pairArr[2] = TuplesKt.to("sgrp_relationship_tags", str);
                    pairArr[3] = TuplesKt.to("sgrp_state_tags", obj);
                    if (item.getJoinGuildFlag() != 1) {
                        i3 = 2;
                    }
                    pairArr[4] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_RESULT_JOIN_STATE, Integer.valueOf(i3));
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    return mutableMapOf;
                }
            }
            str2 = "";
            if (guildNameLines <= 1) {
                obj = item.o();
            }
            Pair[] pairArr2 = new Pair[5];
            pairArr2[0] = TuplesKt.to("sgrp_channel_id", item.getGuildId());
            pairArr2[1] = TuplesKt.to("sgrp_channel_tags", str2);
            pairArr2[2] = TuplesKt.to("sgrp_relationship_tags", str);
            pairArr2[3] = TuplesKt.to("sgrp_state_tags", obj);
            if (item.getJoinGuildFlag() != 1) {
            }
            pairArr2[4] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_RESULT_JOIN_STATE, Integer.valueOf(i3));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr2);
            return mutableMapOf;
        }

        private final Drawable C() {
            return (Drawable) this.onlineCircleDrawable.getValue();
        }

        private final void D(GuildProfileJoinedData data) {
            ArrayList<String> arrayListOf;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            GuildJumpUtil.n(context, j.c(data));
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(data.getGuildId());
            iGPSService.reportUserViewGuild(arrayListOf, j.a(), j.b(), 2, new em() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.h
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    GuildProfileJoinedAdapter.ViewHolder.E(i3, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E(int i3, String str) {
            if (i3 != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str2 = "reportUserViewGuild failed result: " + i3 + ", errMsg: " + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.profile.GuildProfileJoinedAdapter", 1, (String) it.next(), null);
                }
            }
        }

        private final void I(String guildProfile) {
            boolean z16;
            if (guildProfile.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.binding.f442838f.setVisibility(0);
                this.binding.f442845m.setVisibility(0);
                this.binding.f442845m.setText(N(guildProfile, 13));
                TextView textView = this.binding.f442844l;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.guildRecommendGuildName");
                t.g(textView, 0, 0, 0, GuildProfileJoinedAdapter.E, 0, 0, 55, null);
                LinearLayout linearLayout = this.binding.f442838f;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.guildRecommendChannelTagContainer");
                t.g(linearLayout, 0, 0, 0, GuildProfileJoinedAdapter.G, 0, 0, 55, null);
                return;
            }
            TextView textView2 = this.binding.f442844l;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildRecommendGuildName");
            t.g(textView2, 0, 0, 0, GuildProfileJoinedAdapter.F, 0, 0, 55, null);
            LinearLayout linearLayout2 = this.binding.f442838f;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.guildRecommendChannelTagContainer");
            t.g(linearLayout2, 0, 0, 0, GuildProfileJoinedAdapter.H, 0, 0, 55, null);
            this.binding.f442845m.setVisibility(4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        private final void J(final GuildProfileJoinedData item) {
            this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean K;
                    K = GuildProfileJoinedAdapter.ViewHolder.K(GuildProfileJoinedAdapter.ViewHolder.this, view, motionEvent);
                    return K;
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileJoinedAdapter.ViewHolder.L(GuildProfileJoinedAdapter.ViewHolder.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean K(ViewHolder this$0, View view, MotionEvent motionEvent) {
            Integer num;
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                this$0.scaleInAnimator.start();
            } else {
                boolean z17 = true;
                if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 4)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && (num == null || num.intValue() != 3)) {
                    z17 = false;
                }
                if (z17) {
                    this$0.scaleOutAnimator.start();
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(ViewHolder this$0, GuildProfileJoinedData item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this$0.D(item);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void M(int channelStatus, List<? extends IGProRecommendLabel> tagList, String guildProfile, int guildNameLines) {
            ax.a(this.binding.f442836d, channelStatus, false);
            this.binding.f442838f.setVisibility(0);
            this.binding.f442849q.setVisibility(8);
            this.binding.f442847o.setVisibility(8);
            this.binding.f442848p.setVisibility(8);
            this.binding.f442845m.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            if (!tagList.isEmpty()) {
                for (IGProRecommendLabel iGProRecommendLabel : tagList) {
                    if (iGProRecommendLabel.getBussiLabelType() == 1 && !TextUtils.isEmpty(iGProRecommendLabel.getLabelName())) {
                        this.binding.f442849q.setVisibility(0);
                        if (iGProRecommendLabel.getLabelType() == 17) {
                            this.binding.f442849q.setCompoundDrawables(null, null, null, null);
                        } else {
                            this.binding.f442849q.setCompoundDrawablePadding(GuildProfileJoinedAdapter.H);
                            C().setBounds(0, 0, C().getIntrinsicWidth(), C().getIntrinsicHeight());
                            this.binding.f442849q.setCompoundDrawables(C(), null, null, null);
                        }
                        this.binding.f442849q.setText(iGProRecommendLabel.getLabelName());
                    }
                    if (iGProRecommendLabel.getBussiLabelType() == 2) {
                        arrayList.add(iGProRecommendLabel);
                        this.binding.f442847o.setVisibility(0);
                        if (iGProRecommendLabel.getLabelType() == 2) {
                            bq bqVar = bq.f235472a;
                            TextView textView = this.binding.f442847o;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildRecommendNormalText");
                            String labelName = iGProRecommendLabel.getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
                            bqVar.c(textView, labelName);
                        } else {
                            bq bqVar2 = bq.f235472a;
                            TextView textView2 = this.binding.f442847o;
                            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildRecommendNormalText");
                            String labelName2 = iGProRecommendLabel.getLabelName();
                            Intrinsics.checkNotNullExpressionValue(labelName2, "label.labelName");
                            bqVar2.a(textView2, labelName2);
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                I(guildProfile);
            }
            if (guildNameLines > 1) {
                this.binding.f442838f.setVisibility(8);
                TextView textView3 = this.binding.f442844l;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.guildRecommendGuildName");
                t.g(textView3, 0, 0, 0, GuildProfileJoinedAdapter.F, 0, 0, 55, null);
                return;
            }
            TextView textView4 = this.binding.f442844l;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.guildRecommendGuildName");
            t.g(textView4, 0, 0, 0, GuildProfileJoinedAdapter.F, 0, 0, 55, null);
            LinearLayout linearLayout = this.binding.f442838f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.guildRecommendChannelTagContainer");
            t.g(linearLayout, 0, 0, 0, GuildProfileJoinedAdapter.H, 0, 0, 55, null);
        }

        private final CharSequence N(String text, int size) {
            QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(text, size);
            Intrinsics.checkNotNullExpressionValue(qQText, "api(IGuildEmotionCodecAp\u2026ava).toQQText(text, size)");
            return qQText;
        }

        private final void O() {
            this.binding.f442837e.getLayoutParams().height = ViewUtils.dpToPx(19.0f);
            this.binding.f442837e.getRoot().getLayoutParams().height = ViewUtils.dpToPx(19.0f);
        }

        private final void P(String guildName, final Function1<? super Integer, Unit> block) {
            this.binding.f442844l.setText(guildName);
            this.binding.f442844l.post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildProfileJoinedAdapter.ViewHolder.Q(Function1.this, this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Q(Function1 block, ViewHolder this$0) {
            Intrinsics.checkNotNullParameter(block, "$block");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            block.invoke(Integer.valueOf(this$0.binding.f442844l.getLineCount()));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0033 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[LOOP:0: B:2:0x0015->B:19:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void R(List<? extends IGProMedalInfo> medalInfoList, final String name, final GuildProfileJoinedData item) {
            boolean z16;
            Object obj = null;
            final List t16 = GuildMedalUtils.t(new ArrayList(medalInfoList), 0, 2, null);
            Iterator it = t16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                IGProOfficialMedalInfoExt officialMedalInfoExt = ((IGProMedalInfo) next).getOfficialMedalInfoExt();
                if (officialMedalInfoExt != null) {
                    z16 = true;
                    if (officialMedalInfoExt.getIsOffical()) {
                        if (!z16) {
                            obj = next;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            if (((IGProMedalInfo) obj) == null) {
                H(item.getGuildName(), item);
            } else {
                this.binding.f442844l.setText(name);
                this.binding.f442844l.post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildProfileJoinedAdapter.ViewHolder.T(name, t16, this, item);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void T(String name, List validMediaList, final ViewHolder this$0, final GuildProfileJoinedData item) {
            Intrinsics.checkNotNullParameter(name, "$name");
            Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
            TextView textView = this$0.binding.f442844l;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildRecommendGuildName");
            GuildMedalUtils.w(guildMedalUtils, name, validMediaList, textView, null, 0, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter$ViewHolder$updateGuildNameAndMedalIcon$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String ellipsizeGuildName) {
                    Intrinsics.checkNotNullParameter(ellipsizeGuildName, "ellipsizeGuildName");
                    GuildProfileJoinedAdapter.ViewHolder.this.H(ellipsizeGuildName, item);
                }
            }, 24, null);
        }

        private final void U(boolean isLeftItem) {
            if (isLeftItem) {
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                t.g(itemView, GuildProfileJoinedAdapter.E, 0, 0, 0, 0, bi.b(232), 28, null);
            } else {
                View itemView2 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                t.g(itemView2, 0, GuildProfileJoinedAdapter.E, 0, 0, 0, bi.b(232), 28, null);
            }
        }

        private final void W(GuildProfileJoinedData item) {
            if (item.getJoinGuildFlag() == 1) {
                this.binding.f442846n.setVisibility(0);
                w(item, false);
            } else {
                w(item, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void v(GuildProfileJoinedData item, int guildNameLines) {
            Map<String, Object> emptyMap;
            this.reportApi.setElementExposureAllAndClickPolicy(this.itemView, "em_sgrp_discover_channel_card");
            this.reportApi.setElementParams(this.itemView, B(item, guildNameLines));
            VideoReport.setElementReuseIdentifier(this.itemView, "itemView-" + item.hashCode());
            GuildDTReportApiImpl guildDTReportApiImpl = this.reportApi;
            QUIButton qUIButton = this.binding.f442846n;
            emptyMap = MapsKt__MapsKt.emptyMap();
            guildDTReportApiImpl.setElementClickParams(qUIButton, "em_sgrp_discover_channel_card_join_btn", emptyMap);
            VideoReport.setElementReuseIdentifier(this.binding.f442846n, "joinGuildBtn-" + item.hashCode());
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void w(final GuildProfileJoinedData data, boolean joined) {
            boolean z16;
            boolean z17;
            if (GuildThemeManager.f235286a.b()) {
                this.binding.f442846n.setThemeId(1002);
            } else {
                this.binding.f442846n.setThemeId(1001);
            }
            if (joined) {
                QUIButton qUIButton = this.binding.f442846n;
                qUIButton.setSelected(false);
                qUIButton.setText("\u53bb\u9891\u9053");
                qUIButton.setType(1);
                this.binding.f442846n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildProfileJoinedAdapter.ViewHolder.z(GuildProfileJoinedAdapter.ViewHolder.this, data, view);
                    }
                });
                return;
            }
            String joinGuildSig = data.getJoinGuildSig();
            if (joinGuildSig != null) {
                if (joinGuildSig.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (z16) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "joinGuildSig is empty: " + data.getGuildId();
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.profile.GuildProfileJoinedAdapter", 1, (String) it.next(), null);
                        }
                    }
                    QUIButton qUIButton2 = this.binding.f442846n;
                    qUIButton2.setText("\u52a0\u5165");
                    qUIButton2.setType(0);
                    this.binding.f442846n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GuildProfileJoinedAdapter.ViewHolder.x(GuildProfileJoinedAdapter.ViewHolder.this, data, view);
                        }
                    });
                }
            }
            z16 = false;
            if (z16) {
            }
            QUIButton qUIButton22 = this.binding.f442846n;
            qUIButton22.setText("\u52a0\u5165");
            qUIButton22.setType(0);
            this.binding.f442846n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileJoinedAdapter.ViewHolder.x(GuildProfileJoinedAdapter.ViewHolder.this, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(final ViewHolder this$0, final GuildProfileJoinedData data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(this$0.itemView.getContext(), j.c(data), new JoinGuildLogic.JumpParam(), "Guild.profile.GuildProfileJoinedAdapter", new bv() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.g
                @Override // vh2.bv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    GuildProfileJoinedAdapter.ViewHolder.y(GuildProfileJoinedAdapter.ViewHolder.this, data, i3, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(ViewHolder this$0, GuildProfileJoinedData data, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
                this$0.w(data, true);
                data.q(2);
                this$0.D(data);
                return;
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.itemView.getContext(), i3, str, iGProSecurityResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(ViewHolder this$0, GuildProfileJoinedData data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this$0.D(data);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void A(@NotNull GuildProfileJoinedData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mCurData = data;
            J(data);
            O();
            if (this.M.getMostCardCnt() == 2) {
                U(data.getIsLeftItem());
            }
            R(data.l(), data.getGuildName(), data);
            v vVar = v.f235697a;
            String guildCoverUrl = data.getGuildCoverUrl();
            RoundImageView roundImageView = this.binding.f442839g;
            Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildRecommendGuildCover");
            vVar.j(guildCoverUrl, roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter$ViewHolder$doBindView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Option loadImage) {
                    Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                    loadImage.setFailedDrawableColor(GuildProfileJoinedAdapter.ViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setLoadingDrawableColor(GuildProfileJoinedAdapter.ViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                }
            });
            boolean b16 = GuildThemeManager.f235286a.b();
            if (this.isNightTheme != b16) {
                this.isNightTheme = b16;
                com.tencent.mobileqq.guild.theme.c.a(this.itemView);
            }
            if (b16) {
                this.binding.f442840h.setVisibility(0);
            } else {
                this.binding.f442840h.setVisibility(8);
            }
            String guildIconUrl = data.getGuildIconUrl();
            RoundImageView roundImageView2 = this.binding.f442841i;
            Intrinsics.checkNotNullExpressionValue(roundImageView2, "binding.guildRecommendGuildIcon");
            vVar.j(guildIconUrl, roundImageView2, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter$ViewHolder$doBindView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                    invoke2(option);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Option loadImage) {
                    Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                    loadImage.setFailedDrawableColor(GuildProfileJoinedAdapter.ViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                    loadImage.setLoadingDrawableColor(GuildProfileJoinedAdapter.ViewHolder.this.itemView.getResources().getColor(R.color.guild_color_ebebeb_313138));
                }
            });
            W(data);
        }

        public final void H(@NotNull String name, @NotNull final GuildProfileJoinedData item) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(item, "item");
            P(name, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedAdapter$ViewHolder$setGuildName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    GuildProfileJoinedAdapter.ViewHolder.this.M(item.getChannelStatus(), item.n(), item.getGuildProfile(), i3);
                    GuildProfileJoinedAdapter.ViewHolder.this.v(item, i3);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void m0(@NotNull List<GuildProfileJoinedData> list) {
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(list, "list");
        list2 = CollectionsKt___CollectionsKt.toList(this.dataList);
        this.dataList.addAll(list);
        list3 = CollectionsKt___CollectionsKt.toList(this.dataList);
        DiffUtil.calculateDiff(new p(list2, list3)).dispatchUpdatesTo(this);
    }

    /* renamed from: n0, reason: from getter */
    public final int getMostCardCnt() {
        return this.mostCardCnt;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        GuildProfileJoinedData guildProfileJoinedData = (GuildProfileJoinedData) orNull;
        if (guildProfileJoinedData == null) {
            return;
        }
        holder.A(guildProfileJoinedData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        cz g16 = cz.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(this, context, g16);
    }

    public final void q0(int i3) {
        this.mostCardCnt = i3;
    }

    public final void setData(@NotNull List<GuildProfileJoinedData> list) {
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(list, "list");
        list2 = CollectionsKt___CollectionsKt.toList(this.dataList);
        this.dataList.clear();
        this.dataList.addAll(list);
        list3 = CollectionsKt___CollectionsKt.toList(list);
        DiffUtil.calculateDiff(new p(list2, list3)).dispatchUpdatesTo(this);
    }
}
