package com.tencent.mobileqq.qwallet.pet.logic;

import com.google.android.filament.utils.Float3;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.data.k;
import com.tencent.mobileqq.qwallet.pet.filament.CombineModelController;
import com.tencent.mobileqq.qwallet.pet.filament.LaunchModelInfo;
import com.tencent.mobileqq.qwallet.pet.filament.ModelController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/SubPlayerController;", "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "", "j", "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "actionInfo", "a", "", "", "hiddenNodeNames", "f", "", "entityInstance", "e", "", "deltaTimeNanos", "l", "", "o", "i", "k", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "sceneViewer", "Lcom/tencent/mobileqq/qwallet/pet/logic/c;", "b", "Lcom/tencent/mobileqq/qwallet/pet/logic/c;", "mainPlayer", "c", "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "<set-?>", "d", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "petType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "actionType", "Z", "isActive", "", "g", UserInfo.SEX_FEMALE, "animationTime", "Lcom/tencent/mobileqq/qwallet/pet/filament/CombineModelController;", h.F, "Lcom/tencent/mobileqq/qwallet/pet/filament/CombineModelController;", "petModelController", "Lcom/google/android/filament/utils/d;", "Lcom/google/android/filament/utils/d;", "petTransform", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController;", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController;", "clothingModelController", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/filament/f;Lcom/tencent/mobileqq/qwallet/pet/logic/c;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SubPlayerController implements com.tencent.mobileqq.qwallet.pet.filament.a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Float3 f278969l = new Float3(0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mainPlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.pet.data.d actionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String petType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String actionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float animationTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CombineModelController petModelController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.google.android.filament.utils.d petTransform;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ModelController clothingModelController;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/SubPlayerController$a;", "", "Lcom/google/android/filament/utils/b;", "PET_TRANSLATE", "Lcom/google/android/filament/utils/b;", "a", "()Lcom/google/android/filament/utils/b;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.logic.SubPlayerController$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Float3 a() {
            return SubPlayerController.f278969l;
        }

        Companion() {
        }
    }

    public SubPlayerController(@NotNull com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer, @NotNull c mainPlayer) {
        Intrinsics.checkNotNullParameter(sceneViewer, "sceneViewer");
        Intrinsics.checkNotNullParameter(mainPlayer, "mainPlayer");
        this.sceneViewer = sceneViewer;
        this.mainPlayer = mainPlayer;
        this.animationTime = -1.0f;
    }

    private final void j() {
        LaunchModelInfo b16;
        PetStateManager petStateManager = PetStateManager.f278740a;
        if (!petStateManager.v()) {
            QLog.d("QWallet.Pet.SubPlayer", 1, "no need create clothController");
            return;
        }
        com.tencent.mobileqq.qwallet.pet.data.d dVar = this.actionInfo;
        if (dVar == null) {
            return;
        }
        this.sceneViewer.s(this.clothingModelController);
        DownloadDetail clothDownloadDetail = dVar.getClothDownloadDetail();
        if (clothDownloadDetail != null && (b16 = LaunchModelInfo.Companion.b(LaunchModelInfo.INSTANCE, clothDownloadDetail, null, null, 6, null)) != null) {
            final ModelController q16 = this.sceneViewer.q(dVar.getInfoBase().getPetType(), dVar.getInfoBase().getActionType(), dVar.getInfoBase().getIsDefault(), this.petType + "-" + this.actionType + "-CLOTH");
            q16.x(petStateManager.u());
            q16.y(this.mainPlayer);
            q16.s(b16, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.logic.SubPlayerController$createClothController$1$1$1
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
                    com.google.android.filament.utils.d dVar2;
                    CombineModelController combineModelController;
                    dVar2 = SubPlayerController.this.petTransform;
                    if (dVar2 != null) {
                        q16.A(dVar2);
                    }
                    q16.B();
                    ModelController modelController = q16;
                    combineModelController = SubPlayerController.this.petModelController;
                    modelController.v(combineModelController != null ? combineModelController.m() : false);
                }
            });
            this.clothingModelController = q16;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    public void a(@NotNull com.tencent.mobileqq.qwallet.pet.data.d actionInfo) {
        List<LaunchModelInfo> list;
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        this.actionInfo = actionInfo;
        this.petType = actionInfo.getInfoBase().getPetType();
        this.actionType = actionInfo.getInfoBase().getActionType();
        boolean isDefault = actionInfo.getInfoBase().getIsDefault();
        LaunchModelInfo b16 = LaunchModelInfo.Companion.b(LaunchModelInfo.INSTANCE, actionInfo.getPetDownloadDetail(), null, null, 6, null);
        Map<k, DownloadDetail> e16 = actionInfo.e();
        if (e16 != null) {
            ArrayList arrayList = new ArrayList(e16.size());
            for (Map.Entry<k, DownloadDetail> entry : e16.entrySet()) {
                arrayList.add(LaunchModelInfo.INSTANCE.a(entry.getValue(), entry.getKey().getSubActionType(), entry.getKey()));
            }
            list = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        } else {
            list = null;
        }
        this.sceneViewer.r(this.petModelController);
        final CombineModelController combineModelController = new CombineModelController(actionInfo.getInfoBase().getPetType(), actionInfo.getInfoBase().getActionType(), isDefault, this.sceneViewer);
        combineModelController.o(b16, list, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.logic.SubPlayerController$playAction$1$1
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

            /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
            
                r0 = r4.this$0.clothingModelController;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                ModelController modelController;
                ModelController modelController2;
                com.google.android.filament.utils.d dVar;
                SubPlayerController.this.petTransform = combineModelController.u(com.tencent.mobileqq.qwallet.pet.filament.f.INSTANCE.a(), SubPlayerController.INSTANCE.a());
                modelController = SubPlayerController.this.clothingModelController;
                boolean z16 = false;
                if (modelController != null && modelController.getIsParseFinish()) {
                    z16 = true;
                }
                if (z16 && modelController2 != null) {
                    dVar = SubPlayerController.this.petTransform;
                    modelController2.A(dVar);
                }
                combineModelController.t();
            }
        });
        combineModelController.s(this.mainPlayer);
        combineModelController.r(this.mainPlayer);
        this.petModelController = combineModelController;
        j();
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    @Nullable
    public String e(int entityInstance) {
        CombineModelController combineModelController = this.petModelController;
        if (combineModelController != null) {
            return combineModelController.l(entityInstance);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    public void f(@Nullable Set<String> hiddenNodeNames) {
        if (this.clothingModelController == null) {
            j();
        }
        ModelController modelController = this.clothingModelController;
        if (modelController != null) {
            modelController.x(hiddenNodeNames);
        }
    }

    public final void i() {
        this.isActive = true;
        QLog.i("QWallet.Pet.SubPlayer", 1, "active: " + this.petType + "-" + this.actionType);
        CombineModelController combineModelController = this.petModelController;
        if (combineModelController != null) {
            combineModelController.q(true);
        }
        ModelController modelController = this.clothingModelController;
        if (modelController != null) {
            modelController.v(true);
        }
    }

    public final void k() {
        this.sceneViewer.r(this.petModelController);
        this.sceneViewer.s(this.clothingModelController);
    }

    public final void l(long deltaTimeNanos) {
        boolean z16;
        CombineModelController combineModelController = this.petModelController;
        if (combineModelController != null) {
            combineModelController.i();
        }
        ModelController modelController = this.clothingModelController;
        if (modelController != null) {
            modelController.j();
        }
        if (this.isActive) {
            float f16 = this.animationTime;
            if (f16 == -1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.animationTime = 0.0f;
            } else {
                this.animationTime = f16 + (((float) deltaTimeNanos) / 1000000000);
            }
            CombineModelController combineModelController2 = this.petModelController;
            if (combineModelController2 != null) {
                combineModelController2.p(this.animationTime);
            }
            ModelController modelController2 = this.clothingModelController;
            if (modelController2 != null) {
                modelController2.u(this.animationTime);
            }
        }
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getPetType() {
        return this.petType;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean o() {
        boolean z16;
        ModelController modelController;
        boolean z17;
        boolean z18;
        boolean z19;
        CombineModelController combineModelController = this.petModelController;
        if (combineModelController != null) {
            if (combineModelController != null && combineModelController.n()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                z16 = false;
                modelController = this.clothingModelController;
                if (modelController != null) {
                    if (modelController != null && modelController.getIsReady()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z17 = false;
                        if (z16 && z17) {
                            return true;
                        }
                    }
                }
                z17 = true;
                return z16 ? false : false;
            }
        }
        z16 = true;
        modelController = this.clothingModelController;
        if (modelController != null) {
        }
        z17 = true;
        if (z16) {
        }
    }
}
