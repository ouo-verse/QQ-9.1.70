package com.tencent.mobileqq.guild.live.livemanager.gift;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRealNameAuthInfo;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lo1.GiftListDataConfig;
import lo1.GuildGiftConfig;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001(B\u000f\u0012\u0006\u0010D\u001a\u00020?\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J*\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\r0\nH\u0002J*\u0010\u000f\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\r0\nH\u0002J*\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\r0\nH\u0002J*\u0010\u0011\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\r0\nH\u0002J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J$\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010)\u001a\u00020$H\u0016J\u0016\u0010-\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0002H\u0016J\u0016\u0010.\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0002H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0004H\u0016J\u001a\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u00010\fH\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u0018\u00108\u001a\u00020\u00052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u0018H\u0016J\u0018\u0010:\u001a\u00020\u00052\u0006\u00106\u001a\u0002052\u0006\u00109\u001a\u00020\u0003H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010FR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00180L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010MR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00180L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/gift/GuildLiveGiftService;", "Lcom/tencent/mobileqq/guild/live/livemanager/gift/h;", "Lcom/tencent/mobileqq/guild/gift/module/k;", "", "Lcom/tencent/mobileqq/guild/gift/module/m;", "", "H", "G", "Llo1/b;", DomainData.DOMAIN_NAME, "Lkotlin/Function0;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "r", "w", "u", "v", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "tipsContent", "B", "verifyUrl", "D", "", "y", "init", "destroy", "i", "hidePanel", "Landroidx/lifecycle/Lifecycle;", "pageLifecycle", "Landroid/view/ViewGroup;", "bannerViewGroup", "fullViewGroup", "b", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "a", "giftId", "getGiftResFilePathByGiftId", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "listener", tl.h.F, "g", "e", "f", "errCode", "errMsg", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "isFromPack", HippyTKDListViewAdapter.X, "originalData", "I", "Landroid/view/View;", "contentView", "of", "t", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "d", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "giftSendListeners", "panelEventListeners", "Llo1/c;", "Llo1/c;", "giftEngine", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "enterRoomObserver", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "selfLivingObserver", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveGiftService implements h, k<Object>, m {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<k<GiftMessage>> giftSendListeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<m> panelEventListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private lo1.c giftEngine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> enterRoomObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> selfLivingObserver;

    public GuildLiveGiftService(@NotNull GLiveChannelCore core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.giftSendListeners = new CopyOnWriteArrayList<>();
        this.panelEventListeners = new CopyOnWriteArrayList<>();
        this.enterRoomObserver = new Observer() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildLiveGiftService.p(GuildLiveGiftService.this, (Boolean) obj);
            }
        };
        this.selfLivingObserver = new Observer() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildLiveGiftService.z(GuildLiveGiftService.this, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(FragmentActivity fragmentActivity, GuildLiveGiftService this$0, int i3, String str, IGProRealNameAuthInfo iGProRealNameAuthInfo) {
        com.tencent.mobileqq.guild.gift.module.f d16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        logger.d().i("QGL.GuildLiveGiftService", 1, "onGetRealNameAuthResult, result:" + i3 + ",errMsg:" + str);
        if (iGProRealNameAuthInfo != null && i3 == 0) {
            if (MediaChannelUtils.f228046a.s(fragmentActivity)) {
                Logger.b bVar = new Logger.b();
                bVar.a().add("showPanel error, activity is finish");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
                }
                return;
            }
            logger.d().i("QGL.GuildLiveGiftService", 1, "onGetRealNameAuthResult, authInfo:" + iGProRealNameAuthInfo);
            int result = iGProRealNameAuthInfo.getResult();
            if (result != 1) {
                if (result != 2) {
                    Intrinsics.checkNotNull(fragmentActivity);
                    this$0.B(fragmentActivity, iGProRealNameAuthInfo.getTipsContent());
                    return;
                } else {
                    Intrinsics.checkNotNull(fragmentActivity);
                    this$0.D(fragmentActivity, iGProRealNameAuthInfo.getVerifyUrl(), iGProRealNameAuthInfo.getTipsContent());
                    return;
                }
            }
            lo1.c cVar = this$0.giftEngine;
            if (cVar != null && (d16 = cVar.d()) != null) {
                ShowPanelTab showPanelTab = ShowPanelTab.Default;
                Intrinsics.checkNotNull(fragmentActivity);
                d16.d(showPanelTab, fragmentActivity);
            }
        }
    }

    private final void B(FragmentActivity activity, String tipsContent) {
        boolean z16;
        if (tipsContent != null && tipsContent.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "showTipsDialog err, " + tipsContent;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
            return;
        }
        if (y(activity)) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, (String) null, tipsContent, (String) null, HardCodeUtil.qqStr(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildLiveGiftService.C(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    private final void D(final FragmentActivity activity, final String verifyUrl, String tipsContent) {
        boolean z16;
        boolean z17 = false;
        if (verifyUrl != null && verifyUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (tipsContent == null || tipsContent.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                if (y(activity)) {
                    return;
                }
                DialogUtil.createCustomDialog(activity, 230, (String) null, tipsContent, HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildLiveGiftService.E(GuildLiveGiftService.this, activity, verifyUrl, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        GuildLiveGiftService.F(dialogInterface, i3);
                    }
                }).show();
                return;
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "showVerifyDialog err, " + verifyUrl + ", " + tipsContent;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(GuildLiveGiftService this$0, FragmentActivity activity, String str, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        cx.c(activity, str, this$0.core.s().getGuildId());
    }

    private final void G() {
        boolean z16;
        long g16;
        com.tencent.mobileqq.guild.gift.module.f d16;
        com.tencent.mobileqq.guild.gift.module.f d17;
        if (this.giftEngine == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("updateGiftReceiver, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
            return;
        }
        Integer value = this.core.n().f226766d.getValue();
        if ((value == null || value.intValue() != 2) && !this.core.s().getAnchorIsSelf()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            g16 = this.core.p().c();
        } else {
            g16 = this.core.o().g();
        }
        Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "updateGiftReceiver, " + value + " " + z16 + ", receiver is " + g16);
        if (g16 > 0) {
            lo1.c cVar = this.giftEngine;
            if (cVar != null && (d17 = cVar.d()) != null) {
                d17.setReceiver(Long.valueOf(g16));
                return;
            }
            return;
        }
        lo1.c cVar2 = this.giftEngine;
        if (cVar2 != null && (d16 = cVar2.d()) != null) {
            d16.setReceiver(null);
        }
    }

    private final void H() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "updateReceiverUid2TinyId", null, null, null, new GuildLiveGiftService$updateReceiverUid2TinyId$1(this, null), 14, null);
        }
    }

    private final GuildGiftConfig n() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true);
        bVar.f264953a = Color.parseColor("#1D1D20");
        bVar.f264956d = Color.parseColor("#0099FF");
        bVar.f264962j = -1;
        bVar.f264963k = true;
        String anchorTinyId = this.core.s().getAnchorTinyId();
        Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "createLiveConfig, anchorTinyId:" + anchorTinyId);
        if (anchorTinyId == null) {
            anchorTinyId = "";
        }
        return new GuildGiftConfig(10006, "fa1ad6f7637b8968b2bb96a1c8321680", this.core.s().getChannelId(), null, new LiveGiftDataAdapter(this.core), new GiftListDataConfig(1, anchorTinyId, null, 4, null), this, new LiveGiftReceivePushModule(this.core), null, r(), w(), v(), u(), bVar, null, null, this, 49416, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildLiveGiftService this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.H();
        }
        this$0.G();
    }

    private final Function0<HashMap<String, String>> r() {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.GuildLiveGiftService$getExtPageParams$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("sgrp_subchannel_type", "5");
                return hashMap;
            }
        };
    }

    private final Function0<HashMap<String, String>> u() {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.GuildLiveGiftService$getRechargeUrlExtData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                GuildLiveGiftService guildLiveGiftService = GuildLiveGiftService.this;
                hashMap.put("sgrp_channel_id", guildLiveGiftService.getCore().s().getGuildId());
                hashMap.put("sgrp_sub_channel_id", guildLiveGiftService.getCore().s().getChannelId());
                String channelName = guildLiveGiftService.getCore().s().getChannelName();
                if (channelName == null) {
                    channelName = "";
                }
                hashMap.put("sgrp_sub_channel_name", channelName);
                IGProGuildInfo guildInfo = guildLiveGiftService.getCore().s().getGuildInfo();
                hashMap.put("sgrp_user_type", String.valueOf(v.b(guildInfo != null ? guildInfo.getUserType() : 4)));
                Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "getRechargeUrlExtData," + hashMap);
                return hashMap;
            }
        };
    }

    private final Function0<HashMap<String, String>> v() {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.GuildLiveGiftService$getReportExtData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                GuildLiveGiftService guildLiveGiftService = GuildLiveGiftService.this;
                hashMap.put("roomid", String.valueOf(guildLiveGiftService.getCore().s().getRoomId()));
                hashMap.put("anchor_uid", "2");
                hashMap.put("clusterid", guildLiveGiftService.getCore().s().getChannelId());
                hashMap.put("program_id", guildLiveGiftService.getCore().s().getLiveRoomProgramId());
                Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "getReportExtData," + hashMap);
                return hashMap;
            }
        };
    }

    private final Function0<HashMap<String, String>> w() {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.GuildLiveGiftService$getSendReqExtData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                GuildLiveGiftService guildLiveGiftService = GuildLiveGiftService.this;
                hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(guildLiveGiftService.getCore().s().getRoomId()));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "2");
                hashMap.put("guild_id", guildLiveGiftService.getCore().s().getGuildId());
                Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "getSendReqExtData," + hashMap);
                return hashMap;
            }
        };
    }

    private final boolean y(FragmentActivity activity) {
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(GuildLiveGiftService this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull Object originalData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).I(data, (GiftMessage) originalData);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void a(int materialId, @NotNull com.tencent.mobileqq.guild.gift.module.d callback) {
        com.tencent.mobileqq.guild.gift.module.h e16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        lo1.c cVar = this.giftEngine;
        if (cVar == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getGiftResFilePathByMaterialId, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
            callback.a(false, materialId, null, null);
            return;
        }
        if (cVar != null && (e16 = cVar.e()) != null) {
            e16.a(materialId, callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void b(@NotNull Lifecycle pageLifecycle, @Nullable ViewGroup bannerViewGroup, @Nullable ViewGroup fullViewGroup) {
        com.tencent.mobileqq.guild.gift.module.b c16;
        Intrinsics.checkNotNullParameter(pageLifecycle, "pageLifecycle");
        if (this.giftEngine == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("setGiftAnimationContainer, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
        }
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (c16 = cVar.c()) != null) {
            c16.b(pageLifecycle, bannerViewGroup, fullViewGroup);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void destroy() {
        this.core.t().n().removeObserver(this.enterRoomObserver);
        this.core.t().D().removeObserver(this.selfLivingObserver);
        lo1.c cVar = this.giftEngine;
        if (cVar != null) {
            cVar.destroy();
        }
        this.giftEngine = null;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void e(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.panelEventListeners.contains(listener)) {
            this.panelEventListeners.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void f(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.panelEventListeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void g(@NotNull k<GiftMessage> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.giftSendListeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    @Nullable
    public String getGiftResFilePathByGiftId(int giftId) {
        com.tencent.mobileqq.guild.gift.module.h e16;
        lo1.c cVar = this.giftEngine;
        if (cVar == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getGiftResFilePathByGiftId, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
            return null;
        }
        if (cVar == null || (e16 = cVar.e()) == null) {
            return null;
        }
        return e16.getGiftResFilePathByGiftId(giftId);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void h(@NotNull k<GiftMessage> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.giftSendListeners.contains(listener)) {
            this.giftSendListeners.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void hidePanel() {
        com.tencent.mobileqq.guild.gift.module.f d16;
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (d16 = cVar.d()) != null) {
            d16.hide();
        }
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).hidePayPanel();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void i(@Nullable final FragmentActivity activity) {
        if (this.giftEngine == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("showPanel error, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it.next(), null);
            }
            return;
        }
        LiveData<Boolean> n3 = this.core.t().n();
        Intrinsics.checkNotNullExpressionValue(n3, "core.uiData.isEnterRoomSuc");
        if (!((Boolean) e12.d.b(n3, Boolean.FALSE)).booleanValue()) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("showPanel error, is not in room.");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it5.next(), null);
            }
            return;
        }
        if (this.core.r().a()) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("showPanel error, isProgramListType.");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("QGL.GuildLiveGiftService", 1, (String) it6.next(), null);
            }
            return;
        }
        ((IGPSService) ch.R0(IGPSService.class)).doRealNameAuth(4, new cv() { // from class: com.tencent.mobileqq.guild.live.livemanager.gift.a
            @Override // wh2.cv
            public final void a(int i3, String str, IGProRealNameAuthInfo iGProRealNameAuthInfo) {
                GuildLiveGiftService.A(FragmentActivity.this, this, i3, str, iGProRealNameAuthInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.gift.h
    public void init() {
        if (this.giftEngine != null) {
            Logger.f235387a.d().w("QGL.GuildLiveGiftService", 1, "init, giftEngine not null, ignore.");
            return;
        }
        mo1.c cVar = new mo1.c();
        this.giftEngine = cVar;
        Intrinsics.checkNotNull(cVar);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        cVar.a(peekAppRuntime, n());
        Unit unit = Unit.INSTANCE;
        this.core.t().n().observeForever(this.enterRoomObserver);
        this.core.t().D().observeForever(this.selfLivingObserver);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void o() {
        QQToastUtil.showQQToast(0, "\u8bf7\u5148\u9009\u62e9\u9001\u793c\u5bf9\u8c61");
        Logger.f235387a.d().i("QGL.GuildLiveGiftService", 1, "onNotSetReceiver");
        G();
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void of(@NotNull View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Iterator<T> it = this.panelEventListeners.iterator();
        while (it.hasNext()) {
            ((m) it.next()).of(contentView);
        }
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final GLiveChannelCore getCore() {
        return this.core;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void s(int errCode, @Nullable String errMsg) {
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).s(errCode, errMsg);
        }
        QQToastUtil.showQQToast(1, "\u9001\u793c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void t() {
        Iterator<T> it = this.panelEventListeners.iterator();
        while (it.hasNext()) {
            ((m) it.next()).t();
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).x(data, isFromPack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(DialogInterface dialogInterface, int i3) {
    }
}
