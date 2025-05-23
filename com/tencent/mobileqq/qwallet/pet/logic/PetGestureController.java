package com.tencent.mobileqq.qwallet.pet.logic;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.filament.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.filament.CustomGestureDetector;
import com.tencent.mobileqq.qwallet.pet.h5event.PetH5Method;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.mobileqq.qwallet.pet.logic.PetGestureController;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0002\b\fB)\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/PetGestureController;", "", "", h.F, "Landroid/view/MotionEvent;", "event", "g", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "a", "Lcom/tencent/mobileqq/qwallet/pet/filament/f;", "sceneViewer", "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "b", "Lcom/tencent/mobileqq/qwallet/pet/filament/a;", "playerInterfaceImpl", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "c", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "h5Controller", "Landroid/view/GestureDetector;", "d", "Landroid/view/GestureDetector;", "singleTabDetector", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector;", "e", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector;", "rotationGestureDetector", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "fragment", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;Lcom/tencent/mobileqq/qwallet/pet/filament/f;Lcom/tencent/mobileqq/qwallet/pet/filament/a;Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;)V", "f", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetGestureController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.qwallet.pet.filament.a playerInterfaceImpl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletPetH5Controller h5Controller;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector singleTabDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CustomGestureDetector rotationGestureDetector;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/PetGestureController$b;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "handler", "Lcom/google/android/filament/View$d;", "Lcom/google/android/filament/View$d;", "callback", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/logic/PetGestureController;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View.d callback;

        public b() {
            this.callback = new View.d() { // from class: com.tencent.mobileqq.qwallet.pet.logic.b
                @Override // com.google.android.filament.View.d
                public final void a(View.e eVar) {
                    PetGestureController.b.b(PetGestureController.this, eVar);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PetGestureController this$0, View.e result) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.mobileqq.qwallet.pet.filament.a aVar = this$0.playerInterfaceImpl;
            if (aVar != null) {
                str = aVar.e(result.f33027a);
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String arrays = Arrays.toString(result.f33029c);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                QLog.i("QWallet.Pet.PetGestureController", 1, "singleClick " + arrays + " " + str);
                this$0.h5Controller.g(PetH5Method.ToH5DispatchEvent.OnPetTouch);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            int i3;
            int i16;
            if (Intrinsics.areEqual(PetStateManager.f278740a.w().getValue(), Boolean.TRUE)) {
                return false;
            }
            View view = PetGestureController.this.sceneViewer.getView();
            if (e16 != null) {
                i3 = (int) e16.getX();
            } else {
                i3 = 0;
            }
            if (e16 != null) {
                i16 = (int) e16.getY();
            } else {
                i16 = 0;
            }
            view.pick(i3, i16, this.handler, this.callback);
            return false;
        }
    }

    public PetGestureController(@NotNull QWalletPetFragment fragment, @NotNull com.tencent.mobileqq.qwallet.pet.filament.f sceneViewer, @Nullable com.tencent.mobileqq.qwallet.pet.filament.a aVar, @NotNull QWalletPetH5Controller h5Controller) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(sceneViewer, "sceneViewer");
        Intrinsics.checkNotNullParameter(h5Controller, "h5Controller");
        this.sceneViewer = sceneViewer;
        this.playerInterfaceImpl = aVar;
        this.h5Controller = h5Controller;
        this.singleTabDetector = new GestureDetector(jl2.b.f410584a.a(), new b());
        CustomGestureDetector customGestureDetector = new CustomGestureDetector(sceneViewer.getView().getViewport().height, sceneViewer.u());
        CustomGestureDetector.h(customGestureDetector, false, false, false, 1, null);
        this.rotationGestureDetector = customGestureDetector;
        h();
        LiveData<Boolean> w3 = PetStateManager.f278740a.w();
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.pet.logic.PetGestureController.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PetGestureController.this.h();
            }
        };
        w3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.pet.logic.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PetGestureController.b(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        float f16;
        int[] intArray;
        Context a16 = jl2.b.f410584a.a();
        if (Intrinsics.areEqual(PetStateManager.f278740a.w().getValue(), Boolean.TRUE)) {
            f16 = 110.0f;
        } else {
            f16 = 0.0f;
        }
        int c16 = this.sceneViewer.getModelArea()[1] - x.c(a16, f16);
        int i3 = this.sceneViewer.getModelArea()[3] + c16;
        CustomGestureDetector customGestureDetector = this.rotationGestureDetector;
        intArray = ArraysKt___ArraysKt.toIntArray(new Integer[]{Integer.valueOf(c16), Integer.valueOf(i3)});
        customGestureDetector.f(intArray);
        QLog.d("QWallet.Pet.PetGestureController", 1, "modelArea: " + c16 + ", " + i3);
    }

    public final void g(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.singleTabDetector.onTouchEvent(event);
        this.rotationGestureDetector.e(event);
    }
}
