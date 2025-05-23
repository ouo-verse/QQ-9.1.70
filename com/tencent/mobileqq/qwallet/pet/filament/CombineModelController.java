package com.tencent.mobileqq.qwallet.pet.filament;

import com.google.android.filament.utils.Float3;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\f\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B'\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\b\u0012\u0006\u00103\u001a\u00020\u001e\u0012\u0006\u00106\u001a\u000204\u00a2\u0006\u0004\bF\u0010GJ\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J \u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001bH\u0016J \u0010-\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010/\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001eH\u0016R\u0014\u0010(\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00101R\u0014\u00103\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u00105R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010CR\u0016\u0010E\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00102\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/CombineModelController;", "", "Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "Lcom/tencent/mobileqq/qwallet/pet/filament/e;", "Lkotlin/Function0;", "", "finishCallback", h.F, "", "controllerId", "k", "Lcom/tencent/mobileqq/qwallet/pet/filament/b;", "mainLaunchModel", "", "subLaunchModelList", "o", "Lcom/tencent/mobileqq/qwallet/pet/filament/ModelController;", "f", "Lcom/google/android/filament/utils/b;", "centerPoint", "customTranslation", "Lcom/google/android/filament/utils/d;", "u", "callback", "r", ReportConstant.COSTREPORT_PREFIX, "i", "", "animationTimeSeconds", "p", "", DomainData.DOMAIN_NAME, "", "entityInstance", "l", "isActive", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "j", "petType", "actionType", "c", "progress", "d", "g", "isReady", "b", "a", "Ljava/lang/String;", "Z", "isLoop", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "sceneViewer", "e", "Ljava/util/List;", "modelLaunchModelInfoList", "", "modelControllerList", "", "Ljava/util/Set;", "animationFinishList", "modelLoadReadyList", "modelLaunchFinishList", "Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "animationCallback", "Lcom/tencent/mobileqq/qwallet/pet/filament/e;", "modelReadyCallback", "hasCallbackStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/qwallet/pet/filament/f;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CombineModelController implements c, e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String petType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isLoop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f sceneViewer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<LaunchModelInfo> modelLaunchModelInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ModelController> modelControllerList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> animationFinishList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> modelLoadReadyList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> modelLaunchFinishList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c animationCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e modelReadyCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean hasCallbackStart;

    public CombineModelController(@NotNull String petType, @NotNull String actionType, boolean z16, @NotNull f sceneViewer) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(sceneViewer, "sceneViewer");
        this.petType = petType;
        this.actionType = actionType;
        this.isLoop = z16;
        this.sceneViewer = sceneViewer;
        this.modelControllerList = new ArrayList();
        this.animationFinishList = new LinkedHashSet();
        this.modelLoadReadyList = new LinkedHashSet();
        this.modelLaunchFinishList = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Function0<Unit> finishCallback) {
        List<LaunchModelInfo> list = this.modelLaunchModelInfoList;
        boolean z16 = false;
        if (list != null && this.modelLaunchFinishList.size() == list.size()) {
            z16 = true;
        }
        if (z16) {
            finishCallback.invoke();
        }
    }

    private final void k(String controllerId) {
        Object obj;
        Iterator<T> it = this.modelControllerList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(controllerId, ((ModelController) obj).getId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        this.sceneViewer.s((ModelController) obj);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.e
    public void b(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId, boolean isReady) {
        e eVar;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        if (isReady) {
            this.modelLoadReadyList.add(controllerId);
        }
        if (n() && (eVar = this.modelReadyCallback) != null) {
            eVar.b(petType, actionType, controllerId, isReady);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void c(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId) {
        c cVar;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        if (!this.hasCallbackStart && (cVar = this.animationCallback) != null) {
            cVar.c(petType, actionType, controllerId);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void d(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId, float progress) {
        Object lastOrNull;
        String str;
        c cVar;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.modelControllerList);
        ModelController modelController = (ModelController) lastOrNull;
        if (modelController != null) {
            str = modelController.getId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(controllerId, str) && (cVar = this.animationCallback) != null) {
            cVar.d(petType, actionType, controllerId, progress);
        }
    }

    @NotNull
    public final List<ModelController> f() {
        return this.modelControllerList;
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void g(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        boolean z16 = true;
        com.tencent.xaction.log.b.a("QWallet.Pet.CombineModel", 1, "onAnimationEnd: " + controllerId);
        this.animationFinishList.add(controllerId);
        List<LaunchModelInfo> list = this.modelLaunchModelInfoList;
        if (list == null || this.animationFinishList.size() != list.size()) {
            z16 = false;
        }
        if (z16) {
            c cVar = this.animationCallback;
            if (cVar != null) {
                cVar.g(petType, actionType, controllerId);
                return;
            }
            return;
        }
        k(controllerId);
    }

    public void i() {
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).j();
        }
    }

    public void j() {
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).k();
        }
    }

    @Nullable
    public String l(int entityInstance) {
        boolean z16;
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            String n3 = ((ModelController) it.next()).n(entityInstance);
            if (n3 != null && n3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return n3;
            }
        }
        return null;
    }

    public boolean m() {
        List<ModelController> list = this.modelControllerList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((ModelController) it.next()).getActive()) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        List<LaunchModelInfo> list = this.modelLaunchModelInfoList;
        if (list == null || this.modelLoadReadyList.size() != list.size()) {
            return false;
        }
        return true;
    }

    public final void o(@Nullable LaunchModelInfo mainLaunchModel, @Nullable List<LaunchModelInfo> subLaunchModelList, @NotNull final Function0<Unit> finishCallback) {
        Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
        ArrayList arrayList = new ArrayList();
        if (mainLaunchModel != null) {
            arrayList.add(mainLaunchModel);
        }
        if (subLaunchModelList != null) {
            arrayList.addAll(subLaunchModelList);
        }
        this.modelLaunchModelInfoList = arrayList;
        if (mainLaunchModel != null) {
            final ModelController q16 = this.sceneViewer.q(this.petType, this.actionType, this.isLoop, this.petType + "-" + this.actionType + "-main");
            q16.s(mainLaunchModel, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.filament.CombineModelController$launch$2$mainController$1$1
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
                    Set set;
                    set = CombineModelController.this.modelLaunchFinishList;
                    set.add(q16.getId());
                    CombineModelController.this.h(finishCallback);
                }
            });
            q16.w(this);
            q16.y(this);
            this.modelControllerList.add(q16);
        }
        if (subLaunchModelList != null) {
            for (LaunchModelInfo launchModelInfo : subLaunchModelList) {
                final ModelController q17 = this.sceneViewer.q(this.petType, this.actionType, this.isLoop, this.petType + "-" + this.actionType + "-" + launchModelInfo.getActionTypeName());
                q17.s(launchModelInfo, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.filament.CombineModelController$launch$controller$1$1
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
                        Set set;
                        set = CombineModelController.this.modelLaunchFinishList;
                        set.add(q17.getId());
                        CombineModelController.this.h(finishCallback);
                    }
                });
                q17.w(this);
                q17.y(this);
                this.modelControllerList.add(q17);
            }
        }
    }

    public void p(float animationTimeSeconds) {
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).u(animationTimeSeconds);
        }
    }

    public void q(boolean isActive) {
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).v(isActive);
        }
    }

    public void r(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animationCallback = callback;
    }

    public void s(@NotNull e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.modelReadyCallback = callback;
    }

    public void t() {
        Iterator<T> it = this.modelControllerList.iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).B();
        }
    }

    @Nullable
    public com.google.android.filament.utils.d u(@NotNull Float3 centerPoint, @NotNull Float3 customTranslation) {
        Object first;
        Intrinsics.checkNotNullParameter(centerPoint, "centerPoint");
        Intrinsics.checkNotNullParameter(customTranslation, "customTranslation");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.modelControllerList);
        com.google.android.filament.utils.d C = ((ModelController) first).C(centerPoint, customTranslation);
        List<ModelController> list = this.modelControllerList;
        Iterator<T> it = list.subList(1, list.size()).iterator();
        while (it.hasNext()) {
            ((ModelController) it.next()).A(C);
        }
        return C;
    }
}
