package com.tencent.mobileqq.guild.inbox.centerpanel.income;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils;
import com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildIncomeNoticeAdapter;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.en;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import vp1.bt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B*\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R1\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter$ViewHolder;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "list", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "urlJumpCallback", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataList", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "D", "a", "ViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildIncomeNoticeAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<co> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super String, Unit> urlJumpCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", UinConfigManager.KEY_ADS, "", "tipStr", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqguildsdk/data/co$c;", "jumpData", "Landroid/text/SpannableStringBuilder;", TtmlNode.TAG_SPAN, "o", "Lkotlin/Function0;", NodeProps.ON_CLICK, "Landroid/text/style/ClickableSpan;", "t", "", "event", "u", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lvp1/bt;", UserInfo.SEX_FEMALE, "Lvp1/bt;", ReportConstant.COSTREPORT_PREFIX, "()Lvp1/bt;", "binding", "G", "Ljava/lang/String;", "time", "H", "title", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter;Landroid/content/Context;Lvp1/bt;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final bt binding;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private String time;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private String title;
        final /* synthetic */ GuildIncomeNoticeAdapter I;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/income/GuildIncomeNoticeAdapter$ViewHolder$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends ClickableSpan {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f226139d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ViewHolder f226140e;

            a(Function0<Unit> function0, ViewHolder viewHolder) {
                this.f226139d = function0;
                this.f226140e = viewHolder;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NotNull View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                Function0<Unit> function0 = this.f226139d;
                if (!o.c("fastClickGuard")) {
                    function0.invoke();
                }
                this.f226140e.u("clck");
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NotNull TextPaint ds5) {
                Intrinsics.checkNotNullParameter(ds5, "ds");
                ds5.setColor(this.f226140e.getBinding().f442587b.getContext().getColor(R.color.qui_common_text_link));
                ds5.setUnderlineText(false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull GuildIncomeNoticeAdapter guildIncomeNoticeAdapter, @NotNull Context context, bt binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.I = guildIncomeNoticeAdapter;
            this.context = context;
            this.binding = binding;
            this.time = "";
            this.title = "";
        }

        private final void n(co notice, CharSequence tipStr) {
            boolean z16;
            this.binding.f442587b.setTag(notice.f265885a);
            List<co.c> list = notice.f265898n;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.binding.f442587b.setText(tipStr);
                return;
            }
            co.c jumpData = notice.f265898n.get(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tipStr);
            Intrinsics.checkNotNullExpressionValue(jumpData, "jumpData");
            o(jumpData, spannableStringBuilder);
        }

        private final void o(final co.c jumpData, SpannableStringBuilder span) {
            int coerceAtMost;
            int coerceAtLeast;
            int coerceAtMost2;
            int coerceAtLeast2;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(jumpData.f265913c - 1, span.length() - 1);
            final GuildIncomeNoticeAdapter guildIncomeNoticeAdapter = this.I;
            ClickableSpan t16 = t(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildIncomeNoticeAdapter$ViewHolder$bindSpan$webViewJumpTextClickSpan$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Function1 function1 = GuildIncomeNoticeAdapter.this.urlJumpCallback;
                    String str = jumpData.f265912b;
                    Intrinsics.checkNotNullExpressionValue(str, "jumpData.url");
                    function1.invoke(str);
                }
            });
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost + jumpData.f265911a.length(), span.length());
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(coerceAtMost2, 0);
            span.setSpan(t16, coerceAtLeast, coerceAtLeast2, 17);
            this.binding.f442587b.setText(span);
            this.binding.f442587b.setMovementMethod(LinkMovementMethod.getInstance());
            this.binding.f442587b.setHighlightColor(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean p(co notice) {
            boolean z16;
            boolean z17;
            boolean isBlank;
            List<co.c> list = notice.f265898n;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str = notice.f265898n.get(0).f265912b;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z17 = false;
                        if (!z17) {
                            return true;
                        }
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ViewHolder this$0, co notice, GuildIncomeNoticeAdapter this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(notice, "$notice");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.p(notice)) {
                Function1 function1 = this$1.urlJumpCallback;
                String str = notice.f265898n.get(0).f265912b;
                Intrinsics.checkNotNullExpressionValue(str, "notice.jumpLink[0].url");
                function1.invoke(str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final ClickableSpan t(Function0<Unit> onClick) {
            return new a(onClick, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u(String event) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_sgrp_account_change_notice");
            hashMap.put("sgrp_content_title", this.title);
            hashMap.put("sgrp_content_time", this.time);
            VideoReport.reportEvent(event, this.itemView, hashMap);
        }

        public final void q(@NotNull final co notice) {
            Intrinsics.checkNotNullParameter(notice, "notice");
            GuildNoticeUtils guildNoticeUtils = GuildNoticeUtils.f226106a;
            GuildUserAvatarView guildUserAvatarView = this.binding.f442588c;
            Intrinsics.checkNotNullExpressionValue(guildUserAvatarView, "binding.guildIncomeIc");
            co.b bVar = notice.f265891g;
            String str = notice.f265890f;
            Intrinsics.checkNotNullExpressionValue(str, "notice.guildId");
            GuildNoticeUtils.k(guildNoticeUtils, guildUserAvatarView, bVar, str, null, 8, null);
            String p16 = en.p(notice.f265887c * 1000, true, "yy-MM-dd");
            Intrinsics.checkNotNullExpressionValue(p16, "getRecentMessageDateTime\u2026 1000L, true, \"yy-MM-dd\")");
            this.time = p16;
            String i3 = GuildNoticeUtils.i(notice);
            this.title = i3;
            this.binding.f442590e.setText(i3);
            this.binding.f442589d.setText(this.time);
            View view = this.itemView;
            final GuildIncomeNoticeAdapter guildIncomeNoticeAdapter = this.I;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildIncomeNoticeAdapter.ViewHolder.r(GuildIncomeNoticeAdapter.ViewHolder.this, notice, guildIncomeNoticeAdapter, view2);
                }
            });
            n(notice, GuildNoticeUtils.g(guildNoticeUtils, notice, false, 2, null));
            ch.Y0(this.itemView, "em_sgrp_account_change_msg", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
            u("imp");
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final bt getBinding() {
            return this.binding;
        }
    }

    public GuildIncomeNoticeAdapter(@NotNull Function1<? super String, Unit> urlJumpCallback) {
        Intrinsics.checkNotNullParameter(urlJumpCallback, "urlJumpCallback");
        this.urlJumpCallback = urlJumpCallback;
        this.dataList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        co coVar = (co) orNull;
        if (coVar == null) {
            return;
        }
        holder.q(coVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bt g16 = bt.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(this, context, g16);
    }

    public final void setData(@NotNull List<? extends co> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }
}
