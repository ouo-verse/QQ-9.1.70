package com.tencent.mobileqq.guild.media.core.logic.gift;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.gift.module.i;
import com.tencent.mobileqq.guild.gift.module.j;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.l;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.media.gift.GuildMediaGiftHeader;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lo1.GuildGiftConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sh2.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001.B\u000f\u0012\u0006\u0010L\u001a\u00020H\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f0\tH\u0002J:\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\f0\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J$\u0010!\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016J)\u0010)\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,H\u0016J\u0016\u00101\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u0001H\u0016J\u0016\u00102\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u0001H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0004H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0004H\u0016J\u001a\u00107\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016J\u0018\u0010?\u001a\u00020\u00172\u0006\u0010:\u001a\u0002092\u0006\u0010>\u001a\u00020\u0002H\u0016J\u0018\u0010D\u001a\u00020B2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010E\u001a\u00020BH\u0016J\b\u0010G\u001a\u00020\u0017H\u0016R\u0017\u0010L\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\b3\u0010I\u001a\u0004\bJ\u0010KR \u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00010M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010NR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010Y\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010?\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftService;", "Lcom/tencent/mobileqq/guild/gift/module/k;", "", "Lcom/tencent/mobileqq/guild/gift/module/l;", "Lcom/tencent/mobileqq/guild/gift/module/m;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/a;", "Llo1/b;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function0;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "W", "guildId", "channelId", "Y", "Lcom/tencent/mobileqq/qqgift/mvvm/business/data/b;", "X", "Lsh2/c$g;", "a0", "Landroid/view/View$OnClickListener;", ExifInterface.LATITUDE_SOUTH, "", "init", "", "v", "u", "Landroidx/lifecycle/Lifecycle;", "pageLifecycle", "Landroid/view/ViewGroup;", "bannerViewGroup", "fullViewGroup", "b", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;", "type", "K", "", "receiverTinyId", "J", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;)V", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "listener", h.F, "g", "e", "f", "errCode", "errMsg", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "isFromPack", HippyTKDListViewAdapter.X, "originalData", "I", "Landroid/content/Context;", "context", "Landroid/view/View;", "logicParentView", "r", "contentView", "of", "t", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "U", "()Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "giftSendListeners", "panelEventListeners", "Llo1/c;", "i", "Llo1/c;", "giftEngine", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/gift/module/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "selectUserUI", BdhLogUtil.LogTag.Tag_Conn, "defaultPanelHeight", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaGiftService extends com.tencent.mobileqq.guild.media.core.logic.h implements k<Object>, l, m, a {

    /* renamed from: C, reason: from kotlin metadata */
    private int defaultPanelHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<k<IGProSendGiftEventData>> giftSendListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<m> panelEventListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private lo1.c giftEngine;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<j> selectUserUI;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/gift/MediaGiftService$b", "Lcom/tencent/mobileqq/guild/gift/module/i;", "", "tinyId", "", "a", "(Ljava/lang/Long;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements i {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.gift.module.i
        public void a(@Nullable Long tinyId) {
            com.tencent.mobileqq.guild.gift.module.f d16;
            lo1.c cVar = MediaGiftService.this.giftEngine;
            if (cVar != null && (d16 = cVar.d()) != null) {
                d16.setReceiver(tinyId);
            }
        }
    }

    public MediaGiftService(@NotNull f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.giftSendListeners = new CopyOnWriteArrayList<>();
        this.panelEventListeners = new CopyOnWriteArrayList<>();
        this.defaultPanelHeight = ViewUtils.dpToPx(456.0f);
    }

    private final GuildGiftConfig R() {
        BaseQQAppInterface qQAppInterface = this.core.getQQAppInterface();
        String guildID = this.core.getGuildID();
        String E = this.core.E();
        return new GuildGiftConfig(10016, "571ab62646abd99881be652d3e250a39", E, this, new MediaGiftDataAdapter(qQAppInterface, guildID, E), null, this, new MediaGiftReceivePushModule(this.core), null, W(), Y(guildID, E), null, null, X(), S(), a0(), this, 6432, null);
    }

    private final View.OnClickListener S() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaGiftService.T(MediaGiftService.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MediaGiftService this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.Core.MediaGiftHelper", 2, "emptyPackClick, " + this$0.getCore().E() + ", panelHeight:" + this$0.v());
        }
        QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
        IGuildMediaChannelApi.a.j((IGuildMediaChannelApi) api, null, this$0.core.getGuildID(), this$0.core.E(), this$0.v(), null, 17, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Function0<HashMap<String, String>> W() {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftService$getExtPageParams$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("sgrp_subchannel_type", "2");
                return hashMap;
            }
        };
    }

    private final com.tencent.mobileqq.qqgift.mvvm.business.data.b X() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true);
        bVar.f264953a = Color.parseColor("#1D1D20");
        bVar.f264956d = Color.parseColor("#0099FF");
        bVar.f264962j = -1;
        bVar.f264963k = true;
        return bVar;
    }

    private final Function0<HashMap<String, String>> Y(final String guildId, final String channelId) {
        return new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.MediaGiftService$getSendReqExtData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                String str = guildId;
                String str2 = channelId;
                hashMap.put("guild_id", str);
                hashMap.put("channel_id", str2);
                return hashMap;
            }
        };
    }

    private final c.g a0() {
        return new c.g() { // from class: com.tencent.mobileqq.guild.media.core.logic.gift.d
            @Override // sh2.c.g
            public final void a(String str) {
                MediaGiftService.b0(MediaGiftService.this, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(MediaGiftService this$0, String it) {
        j jVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.Core.MediaGiftHelper", 2, "panelTabSelected, tabId:" + it);
        }
        WeakReference<j> weakReference = this$0.selectUserUI;
        if (weakReference != null && (jVar = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jVar.setSelectedTab(it);
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @NotNull Object originalData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).I(data, (IGProSendGiftEventData) originalData);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void J(@Nullable Long receiverTinyId, @NotNull FragmentActivity activity, @NotNull ShowPanelTab type) {
        com.tencent.mobileqq.guild.gift.module.f d16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(type, "type");
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (d16 = cVar.d()) != null) {
            d16.setReceiver(receiverTinyId);
        }
        K(activity, type);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void K(@NotNull FragmentActivity activity, @NotNull ShowPanelTab type) {
        com.tencent.mobileqq.guild.gift.module.f d16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.giftEngine == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("showPanel error, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaGiftHelper", 1, (String) it.next(), null);
            }
        }
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (d16 = cVar.d()) != null) {
            d16.d(type, activity);
        }
    }

    @NotNull
    /* renamed from: U, reason: from getter */
    public final f getCore() {
        return this.core;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
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
                Logger.f235387a.d().e("QGMC.Core.MediaGiftHelper", 1, (String) it.next(), null);
            }
            callback.a(false, materialId, null, null);
            return;
        }
        if (cVar != null && (e16 = cVar.e()) != null) {
            e16.a(materialId, callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void b(@NotNull Lifecycle pageLifecycle, @Nullable ViewGroup bannerViewGroup, @Nullable ViewGroup fullViewGroup) {
        com.tencent.mobileqq.guild.gift.module.b c16;
        Intrinsics.checkNotNullParameter(pageLifecycle, "pageLifecycle");
        if (this.giftEngine == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("setGiftAnimationContainer error, giftEngine is null!!!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaGiftHelper", 1, (String) it.next(), null);
            }
        }
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (c16 = cVar.c()) != null) {
            c16.b(pageLifecycle, bannerViewGroup, fullViewGroup);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void e(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.panelEventListeners.contains(listener)) {
            this.panelEventListeners.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void f(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.panelEventListeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void g(@NotNull k<IGProSendGiftEventData> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.giftSendListeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void h(@NotNull k<IGProSendGiftEventData> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.giftSendListeners.contains(listener)) {
            this.giftSendListeners.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public void init() {
        if (this.giftEngine != null) {
            Logger.f235387a.d().w("QGMC.Core.MediaGiftHelper", 1, "init, giftEngine not null, ignore.");
            return;
        }
        if (this.core.o0().getStartParams().getChannelType() == 2) {
            mo1.c cVar = new mo1.c();
            this.giftEngine = cVar;
            Intrinsics.checkNotNull(cVar);
            cVar.a(this.core.getQQAppInterface(), R());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void o() {
        QQToastUtil.showQQToast(0, "\u8bf7\u5148\u9009\u62e9\u9001\u793c\u5bf9\u8c61");
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void of(@NotNull View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Iterator<T> it = this.panelEventListeners.iterator();
        while (it.hasNext()) {
            ((m) it.next()).of(contentView);
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.l
    @NotNull
    public View r(@NotNull Context context, @NotNull View logicParentView) {
        Long l3;
        com.tencent.mobileqq.guild.gift.module.f d16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logicParentView, "logicParentView");
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (d16 = cVar.d()) != null) {
            l3 = d16.c();
        } else {
            l3 = null;
        }
        b bVar = new b();
        GuildMediaGiftHeader guildMediaGiftHeader = new GuildMediaGiftHeader(context, l3, bVar, logicParentView);
        guildMediaGiftHeader.setSelectCallback(bVar);
        this.selectUserUI = new WeakReference<>(guildMediaGiftHeader);
        return guildMediaGiftHeader;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void s(int errCode, @Nullable String errMsg) {
        j jVar;
        com.tencent.mobileqq.guild.gift.module.f d16;
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).s(errCode, errMsg);
        }
        if (errCode == 841005) {
            QQToastUtil.showQQToast(0, "\u5bf9\u65b9\u5df2\u79bb\u5f00\u5b50\u9891\u9053\uff0c\u8bf7\u9009\u62e9\u5176\u4ed6\u4eba");
            lo1.c cVar = this.giftEngine;
            if (cVar != null && (d16 = cVar.d()) != null) {
                d16.setReceiver(null);
            }
            WeakReference<j> weakReference = this.selectUserUI;
            if (weakReference != null && (jVar = weakReference.get()) != null) {
                jVar.setReceiver(null);
                return;
            }
            return;
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

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        this.giftSendListeners.clear();
        this.panelEventListeners.clear();
        lo1.c cVar = this.giftEngine;
        if (cVar != null) {
            cVar.destroy();
        }
        this.giftEngine = null;
        this.selectUserUI = null;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.gift.a
    public int v() {
        int i3;
        com.tencent.mobileqq.guild.gift.module.f d16;
        lo1.c cVar = this.giftEngine;
        if (cVar != null && (d16 = cVar.d()) != null) {
            i3 = d16.v();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            Logger.f235387a.d().i("QGMC.Core.MediaGiftHelper", 1, "getPanelHeight, height:" + i3);
            this.defaultPanelHeight = i3;
        }
        return this.defaultPanelHeight;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.k
    public void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = this.giftSendListeners.iterator();
        while (it.hasNext()) {
            ((k) it.next()).x(data, isFromPack);
        }
    }
}
