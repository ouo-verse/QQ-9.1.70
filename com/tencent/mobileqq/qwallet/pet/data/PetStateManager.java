package com.tencent.mobileqq.qwallet.pet.data;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qwallet.protocol.Wallet.pb.pet.PetCommon$Clothing;
import com.qwallet.protocol.Wallet.pb.pet.PetCommon$Scene;
import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001d\u001a\u00020\u0002J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017J\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0017J\u0014\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019J\u0010\u0010$\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010)J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00172\u0006\u00100\u001a\u00020/H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00172\u0006\u00103\u001a\u000202H\u0016R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R(\u0010?\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u0001098\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020F0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010LR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010LR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010LR$\u0010'\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b#\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010SR\u0019\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0T8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00060T8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010VR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00060T8F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010V\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/PetStateManager;", "Lcom/tencent/mobileqq/qwallet/pet/download/PetDownloadManager$a;", "", "B", "Lcom/tencent/mobileqq/qwallet/pet/data/e;", "actionInfoBase", "", tl.h.F, "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "action", "y", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "downloadDetail", "r", "actionInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "playerInstance", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/qwallet/protocol/Wallet/pb/pet/PetUserState$HomepageRsp;", "rsp", "D", "", "petType", "", "clothing", WadlProxyConsts.SCENE_ID, "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "actionType", "l", "o", "g", "activeClothing", "j", DomainData.DOMAIN_NAME, "toOffsetUp", "k", "canTouchPet", "i", "", "u", "v", "url", "filePath", "onDownloadSucceed", "", "process", "onDownloadProgress", "", "errCode", "a", "Lcom/tencent/mobileqq/qwallet/pet/data/PetStateManager$a;", "b", "Lcom/tencent/mobileqq/qwallet/pet/data/PetStateManager$a;", "mineStateCache", "Lcom/tencent/mobileqq/qwallet/pet/data/g;", "<set-?>", "c", "Lcom/tencent/mobileqq/qwallet/pet/data/g;", "getCurrentPet", "()Lcom/tencent/mobileqq/qwallet/pet/data/g;", "currentPet", "d", "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "pendingAction", "e", "currentAction", "", "Lcom/tencent/mobileqq/qwallet/pet/data/a;", "f", "Ljava/util/Set;", "currentClothing", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qwallet/pet/data/i;", "Landroidx/lifecycle/MutableLiveData;", "_currentScene", "_isOffsetUp", "_isShowLoading", "Z", ReportConstant.COSTREPORT_PREFIX, "()Z", "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "Landroidx/lifecycle/LiveData;", "t", "()Landroidx/lifecycle/LiveData;", "currentScene", "w", "isOffsetUp", HippyTKDListViewAdapter.X, "isShowLoading", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetStateManager implements PetDownloadManager.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PetStateCache mineStateCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PetInfo currentPet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d pendingAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static d currentAction;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.qwallet.pet.filament.a playerInstance;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PetStateManager f278740a = new PetStateManager();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<ClothInfo> currentClothing = new LinkedHashSet();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<i> _currentScene = new MutableLiveData<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> _isOffsetUp = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> _isShowLoading = new MutableLiveData<>(Boolean.TRUE);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean canTouchPet = true;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/PetStateManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "pet", "c", "petActionType", "", "Ljava/util/List;", "()Ljava/util/List;", "clothingIdList", "d", WadlProxyConsts.SCENE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.data.PetStateManager$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PetStateCache {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String pet;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String petActionType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> clothingIdList;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String sceneId;

        public PetStateCache(@Nullable String str, @Nullable String str2, @NotNull List<String> clothingIdList, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(clothingIdList, "clothingIdList");
            this.pet = str;
            this.petActionType = str2;
            this.clothingIdList = clothingIdList;
            this.sceneId = str3;
        }

        @NotNull
        public final List<String> a() {
            return this.clothingIdList;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPet() {
            return this.pet;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getPetActionType() {
            return this.petActionType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getSceneId() {
            return this.sceneId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PetStateCache)) {
                return false;
            }
            PetStateCache petStateCache = (PetStateCache) other;
            if (Intrinsics.areEqual(this.pet, petStateCache.pet) && Intrinsics.areEqual(this.petActionType, petStateCache.petActionType) && Intrinsics.areEqual(this.clothingIdList, petStateCache.clothingIdList) && Intrinsics.areEqual(this.sceneId, petStateCache.sceneId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.pet;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.petActionType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int hashCode3 = (((i16 + hashCode2) * 31) + this.clothingIdList.hashCode()) * 31;
            String str3 = this.sceneId;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return hashCode3 + i3;
        }

        @NotNull
        public String toString() {
            return "PetStateCache(pet=" + this.pet + ", petActionType=" + this.petActionType + ", clothingIdList=" + this.clothingIdList + ", sceneId=" + this.sceneId + ")";
        }
    }

    PetStateManager() {
    }

    private final void B() {
        String str;
        String str2;
        int collectionSizeOrDefault;
        j infoBase;
        e infoBase2;
        PetInfo petInfo = currentPet;
        String str3 = null;
        if (petInfo != null) {
            str = petInfo.getType();
        } else {
            str = null;
        }
        d dVar = currentAction;
        if (dVar == null) {
            dVar = pendingAction;
        }
        if (dVar != null && (infoBase2 = dVar.getInfoBase()) != null) {
            str2 = infoBase2.getActionType();
        } else {
            str2 = null;
        }
        Set<ClothInfo> set = currentClothing;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClothInfo) it.next()).getId());
        }
        i value = _currentScene.getValue();
        if (value != null && (infoBase = value.getInfoBase()) != null) {
            str3 = infoBase.getSceneId();
        }
        mineStateCache = new PetStateCache(str, str2, arrayList, str3);
    }

    private final synchronized boolean h(e actionInfoBase) {
        e eVar;
        d a16 = d.INSTANCE.a(actionInfoBase);
        if (!q(a16)) {
            d dVar = pendingAction;
            if (dVar != null) {
                eVar = dVar.getInfoBase();
            } else {
                eVar = null;
            }
            if (Intrinsics.areEqual(eVar, actionInfoBase)) {
                return false;
            }
            QLog.w("QWallet.Pet.PetState", 1, "changeActionInner to pending, " + a16.getPetDownloadDetail() + " " + a16.getClothDownloadDetail());
            _isShowLoading.setValue(Boolean.TRUE);
            pendingAction = a16;
            Iterator<T> it = a16.a().iterator();
            while (it.hasNext()) {
                f278740a.r((DownloadDetail) it.next());
            }
            return false;
        }
        y(a16);
        return true;
    }

    public static /* synthetic */ void m(PetStateManager petStateManager, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        petStateManager.l(str, str2);
    }

    private final boolean q(d actionInfo) {
        List<DownloadDetail> a16 = actionInfo.a();
        if ((a16 instanceof Collection) && a16.isEmpty()) {
            return true;
        }
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            if (!((DownloadDetail) it.next()).e()) {
                return false;
            }
        }
        return true;
    }

    private final void r(DownloadDetail downloadDetail) {
        Unit unit;
        String downloadUrl;
        QLog.i("QWallet.Pet.PetState", 1, "start download " + downloadDetail);
        if (downloadDetail != null && (downloadUrl = downloadDetail.getDownloadUrl()) != null) {
            PetDownloadManager.f278805a.u(downloadUrl, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("QWallet.Pet.PetState", 1, "url is null");
        }
    }

    private final void y(d action) {
        QLog.i("QWallet.Pet.PetState", 1, "playAction " + action.getInfoBase().getActionType());
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QWallet.Pet.PetState", null, null, null, new PetStateManager$playAction$1(action, null), 14, null);
        }
    }

    public final void A() {
        PetStateCache petStateCache = mineStateCache;
        if (petStateCache == null) {
            return;
        }
        mineStateCache = null;
        String sceneId = petStateCache.getSceneId();
        if (sceneId != null) {
            f278740a.n(sceneId);
        }
        String pet = petStateCache.getPet();
        if (pet != null) {
            f278740a.l(pet, petStateCache.getPetActionType());
        }
        j(petStateCache.a());
    }

    public final void C(@Nullable com.tencent.mobileqq.qwallet.pet.filament.a playerInstance2) {
        playerInstance = playerInstance2;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:? A[LOOP:0: B:6:0x002c->B:145:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0052 A[Catch: all -> 0x02a7, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0026, B:6:0x002c, B:8:0x0032, B:10:0x0041, B:15:0x004d, B:20:0x0064, B:21:0x0068, B:23:0x0086, B:27:0x0091, B:29:0x0099, B:31:0x009d, B:32:0x00a3, B:34:0x00ab, B:35:0x00b1, B:37:0x00b7, B:41:0x00c6, B:43:0x00cc, B:44:0x00d4, B:46:0x00f2, B:49:0x00fd, B:50:0x0116, B:52:0x011c, B:55:0x012b, B:60:0x012f, B:61:0x013e, B:63:0x0144, B:65:0x0154, B:66:0x016d, B:68:0x0173, B:71:0x0183, B:76:0x0187, B:77:0x0194, B:79:0x019a, B:81:0x01aa, B:83:0x01b7, B:84:0x01bd, B:86:0x01c3, B:97:0x01d3, B:89:0x01de, B:92:0x01e8, B:100:0x01ee, B:101:0x021c, B:103:0x0222, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:113:0x0243, B:115:0x024b, B:116:0x0251, B:118:0x0257, B:122:0x0266, B:124:0x026a, B:129:0x026f, B:131:0x029a, B:146:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[Catch: all -> 0x02a7, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0026, B:6:0x002c, B:8:0x0032, B:10:0x0041, B:15:0x004d, B:20:0x0064, B:21:0x0068, B:23:0x0086, B:27:0x0091, B:29:0x0099, B:31:0x009d, B:32:0x00a3, B:34:0x00ab, B:35:0x00b1, B:37:0x00b7, B:41:0x00c6, B:43:0x00cc, B:44:0x00d4, B:46:0x00f2, B:49:0x00fd, B:50:0x0116, B:52:0x011c, B:55:0x012b, B:60:0x012f, B:61:0x013e, B:63:0x0144, B:65:0x0154, B:66:0x016d, B:68:0x0173, B:71:0x0183, B:76:0x0187, B:77:0x0194, B:79:0x019a, B:81:0x01aa, B:83:0x01b7, B:84:0x01bd, B:86:0x01c3, B:97:0x01d3, B:89:0x01de, B:92:0x01e8, B:100:0x01ee, B:101:0x021c, B:103:0x0222, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:113:0x0243, B:115:0x024b, B:116:0x0251, B:118:0x0257, B:122:0x0266, B:124:0x026a, B:129:0x026f, B:131:0x029a, B:146:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc A[Catch: all -> 0x02a7, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0026, B:6:0x002c, B:8:0x0032, B:10:0x0041, B:15:0x004d, B:20:0x0064, B:21:0x0068, B:23:0x0086, B:27:0x0091, B:29:0x0099, B:31:0x009d, B:32:0x00a3, B:34:0x00ab, B:35:0x00b1, B:37:0x00b7, B:41:0x00c6, B:43:0x00cc, B:44:0x00d4, B:46:0x00f2, B:49:0x00fd, B:50:0x0116, B:52:0x011c, B:55:0x012b, B:60:0x012f, B:61:0x013e, B:63:0x0144, B:65:0x0154, B:66:0x016d, B:68:0x0173, B:71:0x0183, B:76:0x0187, B:77:0x0194, B:79:0x019a, B:81:0x01aa, B:83:0x01b7, B:84:0x01bd, B:86:0x01c3, B:97:0x01d3, B:89:0x01de, B:92:0x01e8, B:100:0x01ee, B:101:0x021c, B:103:0x0222, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:113:0x0243, B:115:0x024b, B:116:0x0251, B:118:0x0257, B:122:0x0266, B:124:0x026a, B:129:0x026f, B:131:0x029a, B:146:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2 A[Catch: all -> 0x02a7, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0026, B:6:0x002c, B:8:0x0032, B:10:0x0041, B:15:0x004d, B:20:0x0064, B:21:0x0068, B:23:0x0086, B:27:0x0091, B:29:0x0099, B:31:0x009d, B:32:0x00a3, B:34:0x00ab, B:35:0x00b1, B:37:0x00b7, B:41:0x00c6, B:43:0x00cc, B:44:0x00d4, B:46:0x00f2, B:49:0x00fd, B:50:0x0116, B:52:0x011c, B:55:0x012b, B:60:0x012f, B:61:0x013e, B:63:0x0144, B:65:0x0154, B:66:0x016d, B:68:0x0173, B:71:0x0183, B:76:0x0187, B:77:0x0194, B:79:0x019a, B:81:0x01aa, B:83:0x01b7, B:84:0x01bd, B:86:0x01c3, B:97:0x01d3, B:89:0x01de, B:92:0x01e8, B:100:0x01ee, B:101:0x021c, B:103:0x0222, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:113:0x0243, B:115:0x024b, B:116:0x0251, B:118:0x0257, B:122:0x0266, B:124:0x026a, B:129:0x026f, B:131:0x029a, B:146:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x02a7, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0026, B:6:0x002c, B:8:0x0032, B:10:0x0041, B:15:0x004d, B:20:0x0064, B:21:0x0068, B:23:0x0086, B:27:0x0091, B:29:0x0099, B:31:0x009d, B:32:0x00a3, B:34:0x00ab, B:35:0x00b1, B:37:0x00b7, B:41:0x00c6, B:43:0x00cc, B:44:0x00d4, B:46:0x00f2, B:49:0x00fd, B:50:0x0116, B:52:0x011c, B:55:0x012b, B:60:0x012f, B:61:0x013e, B:63:0x0144, B:65:0x0154, B:66:0x016d, B:68:0x0173, B:71:0x0183, B:76:0x0187, B:77:0x0194, B:79:0x019a, B:81:0x01aa, B:83:0x01b7, B:84:0x01bd, B:86:0x01c3, B:97:0x01d3, B:89:0x01de, B:92:0x01e8, B:100:0x01ee, B:101:0x021c, B:103:0x0222, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:113:0x0243, B:115:0x024b, B:116:0x0251, B:118:0x0257, B:122:0x0266, B:124:0x026a, B:129:0x026f, B:131:0x029a, B:146:0x0052), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean D(@NotNull PetUserState$HomepageRsp rsp) {
        PetInfo petInfo;
        e eVar;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Object obj;
        String str;
        Object obj2;
        PBStringField pBStringField;
        String str2;
        Object obj3;
        Object obj4;
        boolean z16;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        _isOffsetUp.setValue(Boolean.FALSE);
        _isShowLoading.setValue(Boolean.TRUE);
        canTouchPet = true;
        String str3 = null;
        currentAction = null;
        pendingAction = null;
        List<PetInfo> e16 = f.f278777a.e();
        if (e16 != null) {
            Iterator<T> it = e16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj4 = it.next();
                    PetInfo petInfo2 = (PetInfo) obj4;
                    String str4 = rsp.pet_type.get();
                    if (str4 != null && str4.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            areEqual = petInfo2.getIsDefault();
                        } else {
                            areEqual = Intrinsics.areEqual(petInfo2.getType(), rsp.pet_type.get());
                        }
                        if (!areEqual) {
                            break;
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    if (!areEqual) {
                    }
                } else {
                    obj4 = null;
                    break;
                }
            }
            petInfo = (PetInfo) obj4;
        } else {
            petInfo = null;
        }
        currentPet = petInfo;
        QLog.i("QWallet.Pet.PetState", 1, "currentPet: " + petInfo);
        if (currentPet == null) {
            QLog.w("QWallet.Pet.PetState", 1, "currentPet: is null");
            return false;
        }
        Map<String, List<e>> f16 = f.f278777a.f();
        if (f16 != null) {
            PetInfo petInfo3 = currentPet;
            if (petInfo3 != null) {
                str2 = petInfo3.getType();
            } else {
                str2 = null;
            }
            List<e> list = f16.get(str2);
            if (list != null) {
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj3 = it5.next();
                        if (((e) obj3).getIsDefault()) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                eVar = (e) obj3;
                if (eVar != null) {
                    pendingAction = d.INSTANCE.a(eVar);
                }
                QLog.i("QWallet.Pet.PetState", 1, "pendingAction: " + pendingAction);
                if (pendingAction != null) {
                    QLog.w("QWallet.Pet.PetState", 1, "pendingAction: is null");
                    return false;
                }
                List<PetCommon$Clothing> list2 = rsp.dress.clothing.get();
                Intrinsics.checkNotNullExpressionValue(list2, "rsp.dress.clothing.get()");
                ArrayList arrayList = new ArrayList();
                for (Object obj5 : list2) {
                    if (((PetCommon$Clothing) obj5).equipped.get()) {
                        arrayList.add(obj5);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(((PetCommon$Clothing) it6.next()).f41703id.get());
                }
                List<PetCommon$Clothing> list3 = rsp.dress.clothing.get();
                Intrinsics.checkNotNullExpressionValue(list3, "rsp.dress.clothing.get()");
                ArrayList arrayList3 = new ArrayList();
                for (Object obj6 : list3) {
                    if (!((PetCommon$Clothing) obj6).equipped.get()) {
                        arrayList3.add(obj6);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    arrayList4.add(((PetCommon$Clothing) it7.next()).f41703id.get());
                }
                currentClothing.clear();
                List<ClothInfo> b16 = f.f278777a.b();
                if (b16 != null) {
                    for (ClothInfo clothInfo : b16) {
                        if (arrayList2.contains(clothInfo.getId())) {
                            clothInfo.d(Boolean.TRUE);
                            currentClothing.add(clothInfo);
                        } else if (arrayList4.contains(clothInfo.getId())) {
                            clothInfo.d(Boolean.FALSE);
                        }
                    }
                }
                QLog.i("QWallet.Pet.PetState", 1, "currentClothing: " + currentClothing);
                List<PetCommon$Scene> list4 = rsp.dress.scene.get();
                Intrinsics.checkNotNullExpressionValue(list4, "rsp.dress.scene.get()");
                Iterator<T> it8 = list4.iterator();
                while (true) {
                    if (it8.hasNext()) {
                        obj = it8.next();
                        if (((PetCommon$Scene) obj).equipped.get()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                PetCommon$Scene petCommon$Scene = (PetCommon$Scene) obj;
                if (petCommon$Scene != null && (pBStringField = petCommon$Scene.f41705id) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (str == null) {
                    List<j> g16 = f.f278777a.g();
                    if (g16 != null) {
                        Iterator<T> it9 = g16.iterator();
                        while (true) {
                            if (it9.hasNext()) {
                                obj2 = it9.next();
                                if (((j) obj2).getIsDefault()) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        j jVar = (j) obj2;
                        if (jVar != null) {
                            str3 = jVar.getSceneId();
                        }
                    }
                    str = str3;
                }
                n(str);
                QLog.i("QWallet.Pet.PetState", 1, "currentScene: " + t().getValue());
                if (_currentScene.getValue() != null) {
                    return true;
                }
                QLog.w("QWallet.Pet.PetState", 1, "currentScene: is null");
                return false;
            }
        }
        eVar = null;
        if (eVar != null) {
        }
        QLog.i("QWallet.Pet.PetState", 1, "pendingAction: " + pendingAction);
        if (pendingAction != null) {
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void a(@NotNull String url, int errCode) {
        List<DownloadDetail> a16;
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.w("QWallet.Pet.PetState", 1, "onDownloadFail, " + errCode + " " + url);
        d dVar = pendingAction;
        Object obj = null;
        if (dVar != null && (a16 = dVar.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((DownloadDetail) next).getDownloadUrl(), url)) {
                    obj = next;
                    break;
                }
            }
            obj = (DownloadDetail) obj;
        }
        if (obj != null) {
            _isShowLoading.setValue(Boolean.FALSE);
            QLog.w("QWallet.Pet.PetState", 1, "download " + pendingAction + " fail, ignored action, " + url);
        }
    }

    public final boolean g(@NotNull String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        PetInfo petInfo = currentPet;
        if (petInfo == null) {
            QLog.w("QWallet.Pet.PetState", 1, "changeAction fail, currentPet is null");
            return false;
        }
        e a16 = f.f278777a.a(petInfo.getType(), actionType);
        if (a16 == null) {
            QLog.w("QWallet.Pet.PetState", 1, "changeAction fail, targetAction is null: " + petInfo.getType() + "-" + actionType);
            return false;
        }
        return h(a16);
    }

    public final void i(boolean canTouchPet2) {
        if (canTouchPet == canTouchPet2) {
            return;
        }
        canTouchPet = canTouchPet2;
    }

    public final void j(@NotNull List<String> activeClothing) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(activeClothing, "activeClothing");
        Set<ClothInfo> set = currentClothing;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((ClothInfo) it.next()).getId());
        }
        if (Intrinsics.areEqual(arrayList, activeClothing)) {
            return;
        }
        currentClothing.clear();
        List<ClothInfo> b16 = f.f278777a.b();
        if (b16 != null) {
            for (ClothInfo clothInfo : b16) {
                if (activeClothing.contains(clothInfo.getId())) {
                    clothInfo.d(Boolean.TRUE);
                    currentClothing.add(clothInfo);
                } else if (Intrinsics.areEqual(clothInfo.getIsEquipped(), Boolean.TRUE)) {
                    clothInfo.d(Boolean.FALSE);
                }
            }
        }
        Set<ClothInfo> set2 = currentClothing;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(set2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = set2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((ClothInfo) it5.next()).getId());
        }
        QLog.i("QWallet.Pet.PetState", 1, "changeClothing currentClothing=" + arrayList2);
        com.tencent.mobileqq.qwallet.pet.filament.a aVar = playerInstance;
        if (aVar != null) {
            aVar.f(u());
        }
    }

    public final void k(boolean toOffsetUp) {
        MutableLiveData<Boolean> mutableLiveData = _isOffsetUp;
        if (Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.valueOf(toOffsetUp))) {
            return;
        }
        mutableLiveData.setValue(Boolean.valueOf(toOffsetUp));
    }

    public final void l(@NotNull String petType, @Nullable String actionType) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(petType, "petType");
        PetInfo petInfo = currentPet;
        if (petInfo != null) {
            str = petInfo.getType();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, petType)) {
            List<PetInfo> e16 = f.f278777a.e();
            if (e16 != null) {
                Iterator<T> it = e16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((PetInfo) obj).getType(), petType)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                PetInfo petInfo2 = (PetInfo) obj;
                if (petInfo2 != null) {
                    QLog.i("QWallet.Pet.PetState", 1, "changePet: " + petType);
                    currentPet = petInfo2;
                }
            }
            QLog.w("QWallet.Pet.PetState", 1, "changePet error, can't find " + petType);
            return;
        }
        currentAction = null;
        pendingAction = null;
        if (actionType == null) {
            o();
        } else {
            g(actionType);
        }
    }

    public final void n(@Nullable String sceneId) {
        DownloadDetail b16;
        String str;
        j infoBase;
        if (sceneId != null) {
            i value = _currentScene.getValue();
            if (value != null && (infoBase = value.getInfoBase()) != null) {
                str = infoBase.getSceneId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, sceneId)) {
                return;
            }
        }
        j h16 = f.f278777a.h(sceneId);
        if (h16 == null || (b16 = jl2.b.f410584a.b(ModelType.NULL, h16.getDownloadUrl())) == null) {
            return;
        }
        if (!b16.e()) {
            r(b16);
        }
        _currentScene.setValue(new i(h16, b16));
    }

    public final void o() {
        String str;
        f fVar = f.f278777a;
        PetInfo petInfo = currentPet;
        if (petInfo != null) {
            str = petInfo.getType();
        } else {
            str = null;
        }
        String c16 = fVar.c(str);
        if (c16 == null) {
            return;
        }
        g(c16);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void onDownloadProgress(@NotNull String url, float process) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void onDownloadSucceed(@NotNull String url, @NotNull String filePath) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        d dVar = pendingAction;
        if (dVar == null) {
            return;
        }
        Iterator<T> it = dVar.a().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DownloadDetail) obj).getDownloadUrl(), url)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DownloadDetail downloadDetail = (DownloadDetail) obj;
        if (downloadDetail == null) {
            return;
        }
        downloadDetail.f(ModelDownloadState.DOWNLOADED);
        downloadDetail.g(filePath);
        downloadDetail.h(jl2.b.f410584a.g(downloadDetail.getModelType(), filePath));
        if (q(dVar)) {
            y(dVar);
        }
        QLog.i("QWallet.Pet.PetState", 1, "onDownloadSucceed: " + url + " " + filePath);
    }

    public final synchronized void p(@NotNull String petType, @NotNull List<String> clothing, @Nullable String sceneId) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(clothing, "clothing");
        B();
        canTouchPet = true;
        k(false);
        m(this, petType, null, 2, null);
        j(clothing);
        if (sceneId != null) {
            f278740a.n(sceneId);
        }
    }

    public final boolean s() {
        return canTouchPet;
    }

    @NotNull
    public final LiveData<i> t() {
        return _currentScene;
    }

    @Nullable
    public final Set<String> u() {
        Set set;
        Set set2;
        int collectionSizeOrDefault;
        Set<String> set3;
        Set<ClothInfo> set4 = currentClothing;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set4) {
            if (Intrinsics.areEqual(((ClothInfo) obj).getIsEquipped(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        List<ClothInfo> b16 = f.f278777a.b();
        if (b16 != null) {
            set2 = CollectionsKt___CollectionsKt.subtract(b16, set);
        } else {
            set2 = null;
        }
        if (set2 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ClothInfo) it.next()).getNodeName());
            }
            set3 = CollectionsKt___CollectionsKt.toSet(arrayList2);
            return set3;
        }
        return null;
    }

    public final boolean v() {
        Set<ClothInfo> set = currentClothing;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((ClothInfo) it.next()).getIsEquipped(), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final LiveData<Boolean> w() {
        return _isOffsetUp;
    }

    @NotNull
    public final LiveData<Boolean> x() {
        return _isShowLoading;
    }

    public final void z() {
        playerInstance = null;
    }
}
