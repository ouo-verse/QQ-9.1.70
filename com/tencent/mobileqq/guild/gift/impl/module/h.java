package com.tencent.mobileqq.guild.gift.impl.module;

import android.os.Looper;
import android.util.Log;
import androidx.collection.LruCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.gift.impl.module.h;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import lo1.GuildGiftConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0007\u00a2\u0006\u0004\b6\u00107J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\fH\u0017J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010#\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\fR0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0&j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/impl/module/h;", "Lcom/tencent/mobileqq/guild/gift/module/a;", "Lcom/tencent/mobileqq/guild/gift/module/h;", "Lrh2/e;", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "", HippyTKDListViewAdapter.X, "Ljava/lang/Runnable;", "runnable", BdhLogUtil.LogTag.Tag_Conn, "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "w", "Lnh2/c;", "sdk", "Llo1/b;", DownloadInfo.spKey_Config, "B", "Lmo1/b;", "eventBus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "giftId", "", "getGiftResFilePathByGiftId", "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "a", "errCode", "errMsg", "onFailed", "onReceive", "id", "y", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "giftId2MaterialId", "Lcom/tencent/mobileqq/guild/gift/impl/module/e;", "i", "Lcom/tencent/mobileqq/guild/gift/impl/module/e;", "resDownloadCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/guild/gift/module/g;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "giftResInitCallbacks", "Lcom/tencent/mobileqq/guild/gift/impl/module/IGiftInitState;", "Lcom/tencent/mobileqq/guild/gift/impl/module/IGiftInitState;", "initState", "<init>", "()V", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends com.tencent.mobileqq.guild.gift.module.a implements com.tencent.mobileqq.guild.gift.module.h, rh2.e {

    @NotNull
    private static final LruCache<Integer, QQGiftPanelResource> E = new LruCache<>(128);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e resDownloadCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> giftId2MaterialId = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.gift.module.g> giftResInitCallbacks = new CopyOnWriteArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private IGiftInitState initState = IGiftInitState.IDLE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/gift/impl/module/h$b", "Lcom/tencent/mobileqq/guild/gift/impl/module/d;", "", "id", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "", "c", "errorCode", "httpCode", "", "errorMessage", "onLoadFail", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends d {
        b() {
        }

        @Override // qh2.f
        public void c(int id5, @Nullable QQGiftPanelResource panelResource) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("IGuildGiftEngine.", 2, "load gift res suc, id[" + id5 + "] " + panelResource);
            }
            h.this.w(id5, panelResource);
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getGiftPanelResourcePutCache, onLoadFail. " + id5 + "-" + errorCode + "-" + httpCode + "-" + errorMessage;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/gift/impl/module/h$c", "Lcom/tencent/mobileqq/guild/gift/impl/module/d;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends d {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.gift.module.d f224566e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f224567f;

        c(com.tencent.mobileqq.guild.gift.module.d dVar, int i3) {
            this.f224566e = dVar;
            this.f224567f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(com.tencent.mobileqq.guild.gift.module.d callback, int i3) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.a(false, i3, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(com.tencent.mobileqq.guild.gift.module.d callback, int i3, QQGiftPanelResource qQGiftPanelResource) {
            String str;
            Intrinsics.checkNotNullParameter(callback, "$callback");
            String str2 = null;
            if (qQGiftPanelResource != null) {
                str = qQGiftPanelResource.f265002b;
            } else {
                str = null;
            }
            if (qQGiftPanelResource != null) {
                str2 = qQGiftPanelResource.f265005e;
            }
            callback.a(true, i3, str, str2);
        }

        @Override // qh2.f
        public void c(int id5, @Nullable final QQGiftPanelResource panelResource) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("IGuildGiftEngine.", "getGiftResFilePathByMaterialId, onLoadSuccess. id[" + id5 + "] " + panelResource);
            }
            h.this.w(id5, panelResource);
            h hVar = h.this;
            final com.tencent.mobileqq.guild.gift.module.d dVar = this.f224566e;
            final int i3 = this.f224567f;
            hVar.C(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.impl.module.j
                @Override // java.lang.Runnable
                public final void run() {
                    h.c.e(com.tencent.mobileqq.guild.gift.module.d.this, i3, panelResource);
                }
            });
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getGiftResFilePathByMaterialId, onLoadFail. id:" + id5 + ", errCode:" + errorCode + ", httpCode:" + httpCode + ", errMsg:" + errorMessage;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            h hVar = h.this;
            final com.tencent.mobileqq.guild.gift.module.d dVar = this.f224566e;
            final int i3 = this.f224567f;
            hVar.C(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.impl.module.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.c.d(com.tencent.mobileqq.guild.gift.module.d.this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(com.tencent.mobileqq.guild.gift.module.d callback, int i3, QQGiftPanelResource qQGiftPanelResource) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(true, i3, qQGiftPanelResource.f265002b, qQGiftPanelResource.f265005e);
    }

    private final void B(nh2.c sdk, GuildGiftConfig config) {
        this.initState = IGiftInitState.INIT_ING;
        if (config.getGiftListDataConfig() == null) {
            sdk.a().M(this);
        } else {
            com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a();
            aVar.f264855a = config.getGiftListDataConfig().getPanelType();
            aVar.f264858d = config.getGiftListDataConfig().getAnchorId();
            aVar.f264856b = config.getGiftListDataConfig().getSource();
            sdk.a().P(aVar, this);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("IGuildGiftEngine.", "GiftResourceModule preloadResource.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int materialId, QQGiftPanelResource panelResource) {
        if (panelResource != null) {
            E.put(Integer.valueOf(materialId), panelResource);
        }
    }

    private final void x(List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
        int collectionSizeOrDefault;
        oh2.a b16;
        oh2.a b17;
        this.resDownloadCallback = new e(new WeakReference(this));
        List<com.tencent.mobileqq.qqgift.data.service.d> list = giftList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("IGuildGiftEngine.", "downloadPanelRes, giftId[" + dVar.f264874d + "] materialId[" + dVar.C + "]");
            }
            this.giftId2MaterialId.put(Integer.valueOf(dVar.f264874d), Integer.valueOf(dVar.C));
            arrayList.add(new com.tencent.mobileqq.qqgift.data.service.g(dVar.C, dVar.f264874d, dVar.f264883i));
        }
        nh2.c sdk = getSdk();
        if (sdk != null && (b17 = sdk.b()) != null) {
            b17.i(arrayList, this.resDownloadCallback);
        }
        nh2.c sdk2 = getSdk();
        if (sdk2 != null && (b16 = sdk2.b()) != null) {
            b16.S(arrayList, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(com.tencent.mobileqq.guild.gift.module.d callback, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(false, i3, null, null);
    }

    @Override // com.tencent.mobileqq.guild.gift.module.h
    public void a(final int materialId, @NotNull final com.tencent.mobileqq.guild.gift.module.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getSdk() == null) {
            C(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.impl.module.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.z(com.tencent.mobileqq.guild.gift.module.d.this, materialId);
                }
            });
            return;
        }
        final QQGiftPanelResource qQGiftPanelResource = E.get(Integer.valueOf(materialId));
        if (qQGiftPanelResource != null) {
            C(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.impl.module.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.A(com.tencent.mobileqq.guild.gift.module.d.this, materialId, qQGiftPanelResource);
                }
            });
            return;
        }
        nh2.c sdk = getSdk();
        Intrinsics.checkNotNull(sdk);
        sdk.b().e(materialId, new c(callback, materialId));
    }

    @Override // com.tencent.mobileqq.guild.gift.module.h
    @Deprecated(message = "\u8bf7\u5c3d\u91cf\u4f7f\u7528getMaterialIdByGiftId")
    @Nullable
    public String getGiftResFilePathByGiftId(int giftId) {
        QQGiftPanelResource qQGiftPanelResource;
        Integer num = this.giftId2MaterialId.get(Integer.valueOf(giftId));
        if (num == null || (qQGiftPanelResource = E.get(num)) == null) {
            return null;
        }
        return qQGiftPanelResource.f265002b;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.a
    public void j() {
        WeakReference<h> c16;
        super.j();
        e eVar = this.resDownloadCallback;
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.clear();
        }
        this.giftId2MaterialId.clear();
        this.initState = IGiftInitState.IDLE;
        LruCache<Integer, QQGiftPanelResource> lruCache = E;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("IGuildGiftEngine.", 2, "GiftResourceModule destroy," + lruCache + ", size:" + lruCache.size());
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.a
    public void m(@NotNull nh2.c sdk, @NotNull GuildGiftConfig config, @NotNull mo1.b eventBus) {
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        super.m(sdk, config, eventBus);
        B(sdk, config);
    }

    @Override // qh2.d
    public void onFailed(int errCode, @Nullable String errMsg) {
        if (this.initState != IGiftInitState.INIT_ING) {
            Logger.f235387a.d().i("IGuildGiftEngine.", 1, "GiftResourceModule onReceive. ignore.");
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "GiftResourceModule onFailed, errCode:" + errCode + " errMsg:" + errMsg;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
        }
        this.initState = IGiftInitState.FAILED;
        Iterator<T> it5 = this.giftResInitCallbacks.iterator();
        while (it5.hasNext()) {
            ((com.tencent.mobileqq.guild.gift.module.g) it5.next()).onResult(false);
        }
    }

    @Override // rh2.e
    public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
        Integer num;
        if (this.initState != IGiftInitState.INIT_ING) {
            Logger.f235387a.d().i("IGuildGiftEngine.", 1, "GiftResourceModule onReceive. ignore.");
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (giftList != null) {
            num = Integer.valueOf(giftList.size());
        } else {
            num = null;
        }
        d16.i("IGuildGiftEngine.", 1, "GiftResourceModule onReceive. size:" + num);
        if (giftList != null) {
            x(giftList);
        }
        this.initState = IGiftInitState.SUCCESS;
        Iterator<T> it = this.giftResInitCallbacks.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.gift.module.g) it.next()).onResult(true);
        }
    }

    public final void y(int id5) {
        oh2.a b16;
        nh2.c sdk = getSdk();
        if (sdk != null && (b16 = sdk.b()) != null) {
            b16.e(id5, new b());
        }
    }
}
