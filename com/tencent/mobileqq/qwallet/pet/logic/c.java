package com.tencent.mobileqq.qwallet.pet.logic;

import android.content.Intent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.h5event.PetH5Method;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0015B\u000f\u0012\u0006\u0010(\u001a\u00020&\u00a2\u0006\u0004\b/\u00100J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ \u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J(\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\"\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J(\u0010%\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0016R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010)R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/c;", "Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "Lcom/tencent/mobileqq/qwallet/pet/filament/e;", "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "", "petType", "actionType", "", "progress", "", "j", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method$PetBroadcastEvent;", AdMetricTag.EVENT_NAME, "l", "Lcom/tencent/mobileqq/qwallet/pet/logic/SubPlayerController;", "player", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "actionInfo", "a", "", "hiddenNodeNames", "f", "", "entityInstance", "e", "", "deltaTimeNanos", "i", "controllerId", "c", "d", "g", "", "isReady", "b", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "sceneViewer", "Lcom/tencent/mobileqq/qwallet/pet/logic/SubPlayerController;", "currentPlayer", "preparingPlayer", "defaultActionPlayer", "Z", "supportPreloadDefault", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/filament/f;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements com.tencent.mobileqq.qwallet.pet.filament.c, com.tencent.mobileqq.qwallet.pet.filament.e, com.tencent.mobileqq.qwallet.pet.filament.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SubPlayerController currentPlayer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SubPlayerController preparingPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SubPlayerController defaultActionPlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean supportPreloadDefault;

    public c(@NotNull com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer) {
        Intrinsics.checkNotNullParameter(sceneViewer, "sceneViewer");
        this.sceneViewer = sceneViewer;
        this.supportPreloadDefault = true;
        PetStateManager.f278740a.C(this);
    }

    private final void h(SubPlayerController player) {
        String str;
        String str2;
        SubPlayerController subPlayerController;
        SubPlayerController subPlayerController2 = this.currentPlayer;
        if (subPlayerController2 != null) {
            str = subPlayerController2.getPetType();
        } else {
            str = null;
        }
        SubPlayerController subPlayerController3 = this.currentPlayer;
        if (subPlayerController3 != null) {
            str2 = subPlayerController3.getActionType();
        } else {
            str2 = null;
        }
        QLog.i("QWallet.Pet.PlayerController", 1, "swap subPlayer: old=" + str + "_" + str2 + ", new=" + player.getPetType() + "_" + player.getActionType());
        this.sceneViewer.F();
        SubPlayerController subPlayerController4 = this.currentPlayer;
        if (subPlayerController4 != null) {
            subPlayerController4.k();
        }
        player.i();
        this.currentPlayer = player;
        if (!Intrinsics.areEqual(player, this.preparingPlayer) && (subPlayerController = this.preparingPlayer) != null) {
            subPlayerController.k();
        }
        this.preparingPlayer = null;
    }

    private final void j(String petType, String actionType, float progress) {
        com.tencent.mobileqq.qwallet.pet.data.f fVar;
        String c16;
        if (this.supportPreloadDefault && progress > 0.66f && this.defaultActionPlayer == null && (c16 = (fVar = com.tencent.mobileqq.qwallet.pet.data.f.f278777a).c(petType)) != null && !Intrinsics.areEqual(actionType, c16)) {
            QLog.i("QWallet.Pet.PlayerController", 1, "progress " + progress + " prepare defaultPlayer: " + petType + "-" + actionType);
            com.tencent.mobileqq.qwallet.pet.data.e a16 = fVar.a(petType, c16);
            if (a16 == null) {
                return;
            }
            com.tencent.mobileqq.qwallet.pet.data.d a17 = com.tencent.mobileqq.qwallet.pet.data.d.INSTANCE.a(a16);
            SubPlayerController subPlayerController = new SubPlayerController(this.sceneViewer, this);
            subPlayerController.a(a17);
            this.defaultActionPlayer = subPlayerController;
        }
    }

    private final void l(String actionType, PetH5Method.PetBroadcastEvent eventName) {
        Intent intent = new Intent();
        intent.setAction("qw_action_pet_operate");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", eventName.name());
        jSONObject.put("actionType", actionType);
        Unit unit = Unit.INSTANCE;
        intent.putExtra("qw_extra_json", jSONObject.toString());
        jl2.b.f410584a.a().sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    public void a(@NotNull com.tencent.mobileqq.qwallet.pet.data.d actionInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        QLog.i("QWallet.Pet.PlayerController", 1, "changeModel: " + actionInfo);
        if (this.preparingPlayer == null) {
            SubPlayerController subPlayerController = this.currentPlayer;
            if (subPlayerController != null) {
                str5 = subPlayerController.getActionType();
            } else {
                str5 = null;
            }
            if (Intrinsics.areEqual(str5, actionInfo.getInfoBase().getActionType())) {
                SubPlayerController subPlayerController2 = this.currentPlayer;
                if (subPlayerController2 != null) {
                    str6 = subPlayerController2.getPetType();
                } else {
                    str6 = null;
                }
                if (Intrinsics.areEqual(str6, actionInfo.getInfoBase().getPetType())) {
                    c(actionInfo.getInfoBase().getPetType(), actionInfo.getInfoBase().getActionType(), "");
                    QLog.i("QWallet.Pet.PlayerController", 1, "ignored same action: " + actionInfo.getInfoBase().getActionType());
                    return;
                }
            }
        }
        if (this.currentPlayer == null) {
            SubPlayerController subPlayerController3 = this.preparingPlayer;
            if (subPlayerController3 != null) {
                str3 = subPlayerController3.getActionType();
            } else {
                str3 = null;
            }
            if (Intrinsics.areEqual(str3, actionInfo.getInfoBase().getActionType())) {
                SubPlayerController subPlayerController4 = this.preparingPlayer;
                if (subPlayerController4 != null) {
                    str4 = subPlayerController4.getPetType();
                } else {
                    str4 = null;
                }
                if (Intrinsics.areEqual(str4, actionInfo.getInfoBase().getPetType())) {
                    QLog.i("QWallet.Pet.PlayerController", 1, "ignored same pending action: " + actionInfo.getInfoBase().getActionType());
                    return;
                }
            }
        }
        SubPlayerController subPlayerController5 = this.currentPlayer;
        if (subPlayerController5 != null) {
            if (subPlayerController5 != null) {
                str = subPlayerController5.getPetType();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, actionInfo.getInfoBase().getPetType())) {
                SubPlayerController subPlayerController6 = this.currentPlayer;
                if (subPlayerController6 != null) {
                    str2 = subPlayerController6.getPetType();
                } else {
                    str2 = null;
                }
                QLog.i("QWallet.Pet.PlayerController", 1, "destroy currentPlayer, petType not same: " + str2 + " " + actionInfo.getInfoBase().getPetType());
                SubPlayerController subPlayerController7 = this.currentPlayer;
                if (subPlayerController7 != null) {
                    subPlayerController7.k();
                }
                this.currentPlayer = null;
            }
        }
        SubPlayerController subPlayerController8 = this.defaultActionPlayer;
        this.defaultActionPlayer = null;
        if (actionInfo.getInfoBase().getIsDefault() && subPlayerController8 != null && Intrinsics.areEqual(actionInfo.getInfoBase().getPetType(), subPlayerController8.getPetType()) && Intrinsics.areEqual(actionInfo.getInfoBase().getActionType(), subPlayerController8.getActionType())) {
            if (subPlayerController8.o()) {
                h(subPlayerController8);
                return;
            }
            SubPlayerController subPlayerController9 = this.preparingPlayer;
            if (subPlayerController9 != null) {
                subPlayerController9.k();
            }
            this.preparingPlayer = subPlayerController8;
            return;
        }
        if (subPlayerController8 != null) {
            subPlayerController8.k();
        }
        SubPlayerController subPlayerController10 = new SubPlayerController(this.sceneViewer, this);
        SubPlayerController subPlayerController11 = this.preparingPlayer;
        if (subPlayerController11 != null) {
            subPlayerController11.k();
        }
        this.preparingPlayer = subPlayerController10;
        subPlayerController10.a(actionInfo);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.e
    public void b(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId, boolean isReady) {
        String str;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        SubPlayerController subPlayerController = this.preparingPlayer;
        String str2 = null;
        if (subPlayerController != null) {
            str = subPlayerController.getPetType();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(petType, str)) {
            SubPlayerController subPlayerController2 = this.preparingPlayer;
            if (subPlayerController2 != null) {
                str2 = subPlayerController2.getActionType();
            }
            if (Intrinsics.areEqual(actionType, str2)) {
                SubPlayerController subPlayerController3 = this.preparingPlayer;
                boolean z16 = false;
                if (subPlayerController3 != null && subPlayerController3.o()) {
                    z16 = true;
                }
                if (z16) {
                    h(subPlayerController3);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void c(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        l(actionType, PetH5Method.PetBroadcastEvent.PlayActionStart);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void d(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId, float progress) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        j(petType, actionType, progress);
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    @Nullable
    public String e(int entityInstance) {
        SubPlayerController subPlayerController = this.currentPlayer;
        if (subPlayerController != null) {
            return subPlayerController.e(entityInstance);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.a
    public void f(@Nullable Set<String> hiddenNodeNames) {
        SubPlayerController subPlayerController = this.currentPlayer;
        if (subPlayerController != null) {
            subPlayerController.f(hiddenNodeNames);
        }
        SubPlayerController subPlayerController2 = this.preparingPlayer;
        if (subPlayerController2 != null) {
            subPlayerController2.f(hiddenNodeNames);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.filament.c
    public void g(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId) {
        String str;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(controllerId, "controllerId");
        SubPlayerController subPlayerController = this.preparingPlayer;
        if (subPlayerController == null) {
            PetStateManager.f278740a.o();
            QLog.i("QWallet.Pet.PlayerController", 1, "preparingPlayer is null, changeToDefaultAction");
        } else {
            if (subPlayerController != null) {
                str = subPlayerController.getActionType();
            } else {
                str = null;
            }
            QLog.d("QWallet.Pet.PlayerController", 1, actionType + " onAnimationEnd, waiting for " + str + " ready");
        }
        l(actionType, PetH5Method.PetBroadcastEvent.PlayActionFinish);
    }

    public final void i(long deltaTimeNanos) {
        SubPlayerController subPlayerController = this.currentPlayer;
        if (subPlayerController != null) {
            subPlayerController.l(deltaTimeNanos);
        }
        SubPlayerController subPlayerController2 = this.preparingPlayer;
        if (subPlayerController2 != null) {
            subPlayerController2.l(deltaTimeNanos);
        }
        SubPlayerController subPlayerController3 = this.defaultActionPlayer;
        if (subPlayerController3 != null) {
            subPlayerController3.l(deltaTimeNanos);
        }
    }

    public final void k() {
        PetStateManager.f278740a.z();
    }

    public final void m() {
        PetStateManager.f278740a.o();
    }
}
