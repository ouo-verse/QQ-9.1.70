package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.qqui.a;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001-B\u001b\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010 \u001a\u00020\n\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J0\u0010\r\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0017\u0010 \u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/SetChosenActionItem;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "", "N", "O", "H", "M", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "J", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/util/qqui/a$c;", "I", "", "contentResId", "", "P", "t", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "L", "g", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "pageId", "Lkotlin/Lazy;", "Leo0/c;", tl.h.F, "Lkotlin/Lazy;", "K", "()Lkotlin/Lazy;", "useCase", "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;Ljava/lang/String;)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class SetChosenActionItem extends t {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<eo0.c> useCase;

    public SetChosenActionItem() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final boolean H() {
        eo0.c value = this.useCase.getValue();
        String str = i().getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.channelId");
        return value.c(str, i().getMsgRecord().msgSeq);
    }

    private final a.c I(Context context) {
        a.c cVar = new a.c();
        cVar.f235600a = context.getString(R.string.f155881ip);
        return cVar;
    }

    private final HashMap<String, Object> J(GuildMsgItem data) {
        boolean H = H();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dt_pgid", this.pageId);
        if (H) {
            hashMap.put("eid", "em_aio_remove_top_sticky");
        } else {
            hashMap.put("eid", "em_aio_sticky_post");
        }
        hashMap.put("sgrp_channel_id", data.getMsgRecord().guildId);
        hashMap.put("sgrp_sub_channel_id", data.getMsgRecord().channelId);
        return hashMap;
    }

    private final boolean M() {
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30001, w(), u());
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026ChannelId()\n            )");
        return hasTargetSecondaryPermission.booleanValue();
    }

    private final boolean N() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(u());
        }
        if (iGProChannelInfo == null || iGProChannelInfo.getApplicationId() != 1000137) {
            return false;
        }
        return true;
    }

    private final boolean O() {
        ArrayList<MsgElement> arrayList = i().getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "data.msgRecord.elements");
        return com.tencent.guild.aio.util.ex.e.d(arrayList);
    }

    private final void P(int contentResId) {
        Context v3 = v();
        if (v3 != null) {
            QQToast.makeText(v3, v3.getString(contentResId), 0).show();
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        boolean H = H();
        QLog.i("SetChosenActionItem", 4, "onItemClick alreadySet=" + H);
        if (H) {
            this.useCase.getValue().d(data);
        } else {
            Context v3 = v();
            if (v3 != null) {
                com.tencent.mobileqq.guild.util.qqui.a.a(v3, I(v3), new b());
            }
        }
        VideoReport.reportEvent("clck", p().f441955d, J(data));
        j().o8();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Lazy<eo0.c> K() {
        return this.useCase;
    }

    public void L() {
        j().o8();
        if (!NetworkUtil.isNetworkAvailable(h().c().getContext())) {
            P(R.string.f153101b7);
        } else if (H()) {
            P(R.string.f1504014w);
            o(i());
        } else {
            eo0.c.m(this.useCase.getValue(), i(), 0, 2, null);
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.a
    /* renamed from: s */
    public void o(@NotNull GuildMsgItem data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        if (H()) {
            p().f441955d.setText(R.string.f1648626z);
            p().f441953b.setBackgroundResource(R.drawable.guild_menu_icon_cancel_chosen);
        } else {
            p().f441955d.setText(getItemInfo().getItemTitleRes());
            p().f441953b.setBackgroundResource(getItemInfo().getLeftDrawableRes());
        }
        if (H()) {
            str = "em_aio_remove_top_sticky";
        } else {
            str = "em_aio_sticky_post";
        }
        HashMap<String, Object> J = J(data);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(p().f441955d, str, J);
        VideoReport.reportEvent("imp", p().f441955d, J);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.isWalletMsg()) {
            return false;
        }
        if (qr0.d.e(data)) {
            QLog.i("SetChosenActionItem", 4, "isDynamicPicMsg, hide ChosenActionItem");
            return false;
        }
        if (qr0.d.i(data)) {
            QLog.i("SetChosenActionItem", 4, "isMarketFaceMsg, hide ChosenActionItem");
            return false;
        }
        if (O()) {
            QLog.i("SetChosenActionItem", 4, "isLottieMsg, hide ChosenActionItem");
            return false;
        }
        if (N()) {
            QLog.i("SetChosenActionItem", 4, "isGameQAChannel, hide ChosenActionItem");
            return false;
        }
        if (!B() && ((!C() && !z()) || y())) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean D = D();
        boolean M = M();
        boolean G = G();
        QLog.i("SetChosenActionItem", 4, "inSupportAioType=" + z16 + " sendSuccess=" + D + " hasPermission=" + M);
        if (!z16 || !D || !M || !G) {
            return false;
        }
        return true;
    }

    public /* synthetic */ SetChosenActionItem(t.ItemData itemData, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.qui_star, R.string.f1648526y) : itemData, (i3 & 2) != 0 ? "pg_sgrp_aio" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetChosenActionItem(@NotNull t.ItemData itemData, @NotNull String pageId) {
        super(itemData);
        Lazy<eo0.c> lazy;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.pageId = pageId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<eo0.c>() { // from class: com.tencent.guild.aio.halfpop.menu.SetChosenActionItem$useCase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final eo0.c invoke() {
                return new eo0.c(SetChosenActionItem.this.j().getHostContext());
            }
        });
        this.useCase = lazy;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guild/aio/halfpop/menu/SetChosenActionItem$b", "Lcom/tencent/mobileqq/guild/util/qqui/a$d;", "", "k", "onCancelClick", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements a.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.util.qqui.a.d
        public void k() {
            SetChosenActionItem.this.L();
        }

        @Override // com.tencent.mobileqq.guild.util.qqui.a.d
        public void onCancelClick() {
        }
    }
}
