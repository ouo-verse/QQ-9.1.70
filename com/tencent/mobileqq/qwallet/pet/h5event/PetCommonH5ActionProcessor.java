package com.tencent.mobileqq.qwallet.pet.h5event;

import android.content.Context;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qwallet.pet.filament.f;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.mobileqq.qwallet.utils.c;
import com.tencent.mobileqq.util.x;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetCommonH5ActionProcessor;", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller$b;", "", "isOffsetUp", "", "b", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method;", "h5Action", "c", "e", "d", "", "methodName", "h5Method", "a", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "h5Controller", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetCommonH5ActionProcessor implements QWalletPetH5Controller.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetH5Controller h5Controller;

    public PetCommonH5ActionProcessor(@NotNull QWalletPetH5Controller h5Controller) {
        Intrinsics.checkNotNullParameter(h5Controller, "h5Controller");
        this.h5Controller = h5Controller;
    }

    private final void b(boolean isOffsetUp) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            String simpleName = PetCommonH5ActionProcessor.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "PetCommonH5ActionProcessor::class.java.simpleName");
            CorountineFunKt.e(f16, simpleName, null, null, null, new PetCommonH5ActionProcessor$changeOffsetUp$1(isOffsetUp, null), 14, null);
        }
    }

    private final void c(PetH5Method h5Action) {
        boolean optBoolean = h5Action.getRawJSON().optBoolean("canResponse", true);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            String simpleName = PetCommonH5ActionProcessor.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "PetCommonH5ActionProcessor::class.java.simpleName");
            CorountineFunKt.e(f16, simpleName, null, null, null, new PetCommonH5ActionProcessor$changePetTouchControl$1(optBoolean, null), 14, null);
        }
    }

    private final void d(PetH5Method h5Action) {
        JSONObject jSONObject = new JSONObject();
        c cVar = c.f279254a;
        jSONObject.put("phoneModel", cVar.e());
        jSONObject.put("memorySize", cVar.d());
        jSONObject.put("cpuBrand", cVar.a());
        jSONObject.put("cpuMaxFreq", cVar.c());
        jSONObject.put("cpuCoreNumber", cVar.b());
        this.h5Controller.c(h5Action.getCallback(), jSONObject);
    }

    private final void e(PetH5Method h5Action) {
        int[] iArr;
        Context a16 = jl2.b.f410584a.a();
        f sceneViewer = this.h5Controller.getFragment().getFilamentPetController().getSceneViewer();
        if (sceneViewer == null || (iArr = sceneViewer.getModelArea()) == null) {
            iArr = new int[4];
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("left", x.h(a16, iArr[0]));
        jSONObject.put("top", x.h(a16, iArr[1]));
        jSONObject.put("width", x.h(a16, iArr[2]));
        jSONObject.put("height", x.h(a16, iArr[3]));
        this.h5Controller.c(h5Action.getCallback(), jSONObject);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0012. Please report as an issue. */
    @Override // com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller.b
    public boolean a(@NotNull String methodName, @NotNull PetH5Method h5Method) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(h5Method, "h5Method");
        switch (methodName.hashCode()) {
            case -2104217006:
                if (!methodName.equals("GetPetPosition")) {
                    return false;
                }
                e(h5Method);
                return true;
            case -1494381621:
                if (!methodName.equals("DressPanelClose")) {
                    return false;
                }
                b(false);
                return true;
            case -47844841:
                if (!methodName.equals("DressPanelOpen")) {
                    return false;
                }
                b(true);
                return true;
            case 626413501:
                if (!methodName.equals("PetTouchControl")) {
                    return false;
                }
                c(h5Method);
                return true;
            case 651136403:
                if (!methodName.equals("WebLoadComplete")) {
                    return false;
                }
                this.h5Controller.i(true);
                return true;
            case 1282065402:
                if (!methodName.equals(QZoneJsConstants.METHOD_GETDEVICEINFO)) {
                    return false;
                }
                d(h5Method);
                return true;
            default:
                return false;
        }
    }
}
