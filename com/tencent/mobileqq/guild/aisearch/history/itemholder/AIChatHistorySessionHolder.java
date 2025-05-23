package com.tencent.mobileqq.guild.aisearch.history.itemholder;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistoryPopupWindow;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistorySessionItem;
import com.tencent.mobileqq.guild.aisearch.history.h;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchDeleteSessionRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te1.a;
import wh2.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 :2\u00020\u0001:\u0001;B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b8\u00109J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u001c\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u001a\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u0011R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\n !*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\n !*\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\n !*\u0004\u0018\u00010-0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00101R(\u00107\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/history/itemholder/AIChatHistorySessionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "elementId", "eventId", "", "w", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "J", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "itemView", "Landroid/animation/LayoutTransition;", "B", "", "enable", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "payloads", "t", "forcePressState", "forceNormalState", "K", "Lcom/tencent/mobileqq/guild/aisearch/history/h;", "E", "Lcom/tencent/mobileqq/guild/aisearch/history/h;", "notifyCallback", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "sessionLayout", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "summaryView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkButton", "Landroid/widget/Space;", "I", "Landroid/widget/Space;", "emptyPlaceHolder", "Landroid/animation/LayoutTransition;", "layoutTransition", "<set-?>", "Lcom/tencent/mobileqq/guild/aisearch/history/f;", "y", "()Lcom/tencent/mobileqq/guild/aisearch/history/f;", "currentItem", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/aisearch/history/h;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIChatHistorySessionHolder extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final h notifyCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private final LinearLayout sessionLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView summaryView;

    /* renamed from: H, reason: from kotlin metadata */
    private final QUICheckBox checkButton;

    /* renamed from: I, reason: from kotlin metadata */
    private final Space emptyPlaceHolder;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LayoutTransition layoutTransition;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private AIChatHistorySessionItem currentItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatHistorySessionHolder(@NotNull View itemView, @NotNull h notifyCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(notifyCallback, "notifyCallback");
        this.notifyCallback = notifyCallback;
        this.sessionLayout = (LinearLayout) itemView.findViewById(R.id.f83454jl);
        this.summaryView = (TextView) itemView.findViewById(R.id.f83464jm);
        this.checkButton = (QUICheckBox) itemView.findViewById(R.id.f164792ax1);
        this.emptyPlaceHolder = (Space) itemView.findViewById(R.id.iz9);
        this.layoutTransition = B(itemView);
        LayoutTransition layoutTransition = ((LinearLayout) itemView).getLayoutTransition();
        layoutTransition.setDuration(200L);
        layoutTransition.setDuration(3, 100L);
    }

    private final Drawable A() {
        float b16 = bi.b(12);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppCompatResources.getColorStateList(this.itemView.getContext(), R.color.qui_button_bg_ghost_pressed));
        gradientDrawable.setCornerRadius(b16);
        return gradientDrawable;
    }

    private final LayoutTransition B(View itemView) {
        Intrinsics.checkNotNull(itemView, "null cannot be cast to non-null type android.widget.LinearLayout");
        LayoutTransition layoutTransition = ((LinearLayout) itemView).getLayoutTransition();
        layoutTransition.setDuration(200L);
        layoutTransition.setDuration(3, 100L);
        Intrinsics.checkNotNullExpressionValue(layoutTransition, "itemView as LinearLayout\u2026APPEARING, 100)\n        }");
        return layoutTransition;
    }

    private final void C(final AIChatHistorySessionItem item) {
        te1.d dVar = te1.d.f435883a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        String string = this.itemView.getContext().getString(R.string.f138940_x);
        Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri\u2026_ai_history_delete_title)");
        String string2 = this.itemView.getContext().getString(R.string.f138910_u);
        Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getStri\u2026d_ai_history_delete_desc)");
        String string3 = this.itemView.getContext().getString(R.string.f138890_s);
        Intrinsics.checkNotNullExpressionValue(string3, "itemView.context.getStri\u2026istory_delete_btn_cancel)");
        String string4 = this.itemView.getContext().getString(R.string.f138900_t);
        Intrinsics.checkNotNullExpressionValue(string4, "itemView.context.getStri\u2026story_delete_btn_confirm)");
        QQCustomDialog a16 = dVar.a(context, 230, string, string2, string3, string4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AIChatHistorySessionHolder.H(AIChatHistorySessionItem.this, this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AIChatHistorySessionHolder.D(dialogInterface, i3);
            }
        });
        a16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AIChatHistorySessionHolder.E(AIChatHistorySessionHolder.this, dialogInterface);
            }
        });
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AIChatHistorySessionHolder this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L(this$0, false, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final AIChatHistorySessionItem item, final AIChatHistorySessionHolder this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqguildsdk.data.genc.b bVar = new com.tencent.mobileqq.qqguildsdk.data.genc.b();
        bVar.b(item.getSessionId());
        Logger.f235387a.d().d("AIChatHistorySessionHolder", 1, "[deleteAISearchSession] session id " + item.getSessionId());
        ((IGPSService) ch.R0(IGPSService.class)).deleteAISearchSession(bVar, new s() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.g
            @Override // wh2.s
            public final void a(int i16, String str, IGProAISearchDeleteSessionRsp iGProAISearchDeleteSessionRsp) {
                AIChatHistorySessionHolder.I(AIChatHistorySessionHolder.this, item, i16, str, iGProAISearchDeleteSessionRsp);
            }
        });
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AIChatHistorySessionHolder this$0, AIChatHistorySessionItem item, int i3, String str, IGProAISearchDeleteSessionRsp iGProAISearchDeleteSessionRsp) {
        boolean z16;
        String str2;
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Logger.f235387a.d().d("AIChatHistorySessionHolder", 1, "[deleteAISearchSession] result " + i3 + ", msg " + str + ", rsp " + iGProAISearchDeleteSessionRsp);
        if (i3 == 0) {
            this$0.notifyCallback.f(item);
            a.Companion companion = te1.a.INSTANCE;
            Context context = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            String string = this$0.itemView.getContext().getString(R.string.f138930_w);
            Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri\u2026i_history_delete_success)");
            companion.b(context, string);
        } else {
            a.Companion companion2 = te1.a.INSTANCE;
            Context context2 = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = this$0.itemView.getContext().getString(R.string.f138920_v);
            }
            Intrinsics.checkNotNullExpressionValue(str, "msg.ifEmpty { itemView.c\u2026ai_history_delete_fail) }");
            companion2.b(context2, str);
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this$0.itemView;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, item.getSummary());
        pairArr[1] = TuplesKt.to("sgrp_ai_session_id", item.getSessionId());
        if (i3 == 0) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("sgrp_result_type", str2);
        pairArr[3] = TuplesKt.to("sgrp_rank", String.valueOf(item.getReportPosition()));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_delete_history_toast", "", "imp", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(AIChatHistorySessionItem item) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.itemView.getContext(), R.string.f1498013_, 0).show();
            L(this, false, false, 3, null);
        } else {
            C(item);
        }
    }

    public static /* synthetic */ void L(AIChatHistorySessionHolder aIChatHistorySessionHolder, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        aIChatHistorySessionHolder.K(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AIChatHistorySessionHolder this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Space emptyPlaceHolder = this$0.emptyPlaceHolder;
        Intrinsics.checkNotNullExpressionValue(emptyPlaceHolder, "emptyPlaceHolder");
        if (emptyPlaceHolder.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.checkButton.toggle();
            this$0.notifyCallback.c(this$0, this$0.checkButton.isChecked());
        } else {
            L(this$0, true, false, 2, null);
            this$0.notifyCallback.e(this$0);
            this$0.w("em_sgrp_history_drawer", "clck");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(final AIChatHistorySessionHolder this$0, final AIChatHistorySessionItem item, View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Space emptyPlaceHolder = this$0.emptyPlaceHolder;
        Intrinsics.checkNotNullExpressionValue(emptyPlaceHolder, "emptyPlaceHolder");
        if (emptyPlaceHolder.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        L(this$0, true, false, 2, null);
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        AIChatHistoryPopupWindow aIChatHistoryPopupWindow = new AIChatHistoryPopupWindow(context, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.AIChatHistorySessionHolder$bindData$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void invoke(int i3) {
                if (i3 == 0) {
                    AIChatHistorySessionHolder.L(AIChatHistorySessionHolder.this, false, false, 3, null);
                } else {
                    if (i3 != 1) {
                        return;
                    }
                    AIChatHistorySessionHolder.this.J(item);
                    AIChatHistorySessionHolder.this.w("em_sgrp_delete_history", "clck");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
        View itemView = this$0.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        aIChatHistoryPopupWindow.i(itemView);
        this$0.w("em_sgrp_delete_history", "imp");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String elementId, String eventId) {
        HashMap hashMapOf;
        AIChatHistorySessionItem aIChatHistorySessionItem = this.currentItem;
        if (aIChatHistorySessionItem == null) {
            return;
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.itemView;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, aIChatHistorySessionItem.getSummary()), TuplesKt.to("sgrp_ai_session_id", aIChatHistorySessionItem.getSessionId()), TuplesKt.to("sgrp_rank", String.valueOf(aIChatHistorySessionItem.getReportPosition())));
        iGuildDTReportApi.reportDtEventManual(view, elementId, "", eventId, hashMapOf);
    }

    private final void x(boolean enable) {
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        if (enable) {
            linearLayout.setLayoutTransition(this.layoutTransition);
        } else {
            linearLayout.setLayoutTransition(null);
        }
    }

    private final Drawable z() {
        int[] intArray;
        int[] intArray2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        intArray = ArraysKt___ArraysKt.toIntArray(new Integer[]{Integer.valueOf(android.R.attr.state_focused)});
        stateListDrawable.addState(intArray, A());
        intArray2 = ArraysKt___ArraysKt.toIntArray(new Integer[]{Integer.valueOf(android.R.attr.state_pressed)});
        stateListDrawable.addState(intArray2, A());
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        return stateListDrawable;
    }

    public final void K(boolean forcePressState, boolean forceNormalState) {
        Drawable z16;
        if (forcePressState) {
            this.sessionLayout.setBackground(A());
            return;
        }
        if (forceNormalState) {
            this.sessionLayout.setBackground(z());
            return;
        }
        if (this.currentItem != null) {
            LinearLayout linearLayout = this.sessionLayout;
            if (this.notifyCallback.d(this)) {
                z16 = A();
            } else {
                z16 = z();
            }
            linearLayout.setBackground(z16);
        }
    }

    public final void t(@NotNull final AIChatHistorySessionItem item, @NotNull List<Object> payloads) {
        Object firstOrNull;
        boolean a16;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.currentItem = item;
        this.summaryView.setText(item.getSummary());
        this.checkButton.setChecked(this.notifyCallback.b(this));
        L(this, false, false, 3, null);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIChatHistorySessionHolder.u(AIChatHistorySessionHolder.this, view);
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.history.itemholder.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean v3;
                v3 = AIChatHistorySessionHolder.v(AIChatHistorySessionHolder.this, item, view);
                return v3;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : payloads) {
            if (obj instanceof h.a.UpdateSelectMode) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        h.a.UpdateSelectMode updateSelectMode = (h.a.UpdateSelectMode) firstOrNull;
        if (updateSelectMode != null) {
            x(true);
        } else {
            x(false);
        }
        if (updateSelectMode != null) {
            a16 = updateSelectMode.getIsSelectMode();
        } else {
            a16 = this.notifyCallback.a();
        }
        if (a16) {
            this.checkButton.setVisibility(0);
            Space emptyPlaceHolder = this.emptyPlaceHolder;
            Intrinsics.checkNotNullExpressionValue(emptyPlaceHolder, "emptyPlaceHolder");
            emptyPlaceHolder.setVisibility(0);
            return;
        }
        this.checkButton.setVisibility(4);
        Space emptyPlaceHolder2 = this.emptyPlaceHolder;
        Intrinsics.checkNotNullExpressionValue(emptyPlaceHolder2, "emptyPlaceHolder");
        emptyPlaceHolder2.setVisibility(8);
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final AIChatHistorySessionItem getCurrentItem() {
        return this.currentItem;
    }
}
