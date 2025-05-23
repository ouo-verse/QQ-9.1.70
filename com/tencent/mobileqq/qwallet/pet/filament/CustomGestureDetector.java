package com.tencent.mobileqq.qwallet.pet.filament;

import android.view.MotionEvent;
import com.google.android.filament.utils.Float2;
import com.google.android.filament.utils.Manipulator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.filament.zplan.avatar.ManipulatorMode;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u00028\u0003B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ$\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001ej\b\u0012\u0004\u0012\u00020\u001b`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010 R$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001ej\b\u0012\u0004\u0012\u00020\u001b`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010 R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001ej\b\u0012\u0004\u0012\u00020\u001b`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010 R\u0014\u0010%\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013R\u0014\u0010'\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010\u0013R\u0014\u0010)\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010\u0013R\u0014\u0010-\u001a\u00020*8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010/\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector;", "", "", "a", "", "b", "c", "d", "", "activeArea", "f", "Landroid/view/MotionEvent;", "event", "e", "supportOrbit", "supportPan", "supportZoom", "g", "", "I", "viewHeight", "Lcom/google/android/filament/utils/Manipulator;", "Lcom/google/android/filament/utils/Manipulator;", "manipulator", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$Gesture;", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$Gesture;", "currentGesture", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$a;", "Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$a;", "previousTouch", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "tentativePanEvents", "tentativeOrbitEvents", "tentativeZoomEvents", h.F, "kGestureConfidenceCount", "i", "kPanConfidenceDistance", "j", "kZoomConfidenceDistance", "", "k", UserInfo.SEX_FEMALE, "kZoomSpeed", "l", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "[I", "p", "isActive", "<init>", "(ILcom/google/android/filament/utils/Manipulator;)V", ComponentFactory.ComponentType.GESTURE, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CustomGestureDetector {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int viewHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Manipulator manipulator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Gesture currentGesture;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TouchPair previousTouch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<TouchPair> tentativePanEvents;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<TouchPair> tentativeOrbitEvents;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<TouchPair> tentativeZoomEvents;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int kGestureConfidenceCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int kPanConfidenceDistance;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int kZoomConfidenceDistance;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final float kZoomSpeed;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean supportOrbit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean supportPan;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean supportZoom;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] activeArea;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$Gesture;", "", "(Ljava/lang/String;I)V", "NONE", ManipulatorMode.ORBIT, "PAN", "ZOOM", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum Gesture {
        NONE,
        ORBIT,
        PAN,
        ZOOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010$B\t\b\u0016\u00a2\u0006\u0004\b#\u0010%B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\rR\u0011\u0010 \u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0018R\u0011\u0010\"\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/CustomGestureDetector$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/google/android/filament/utils/a;", "a", "Lcom/google/android/filament/utils/a;", "getPt0", "()Lcom/google/android/filament/utils/a;", "setPt0", "(Lcom/google/android/filament/utils/a;)V", "pt0", "b", "getPt1", "setPt1", "pt1", "c", "I", "getCount", "()I", "setCount", "(I)V", "count", "", "()F", "separation", "midpoint", HippyTKDListViewAdapter.X, "d", "y", "<init>", "(Lcom/google/android/filament/utils/a;Lcom/google/android/filament/utils/a;I)V", "()V", "Landroid/view/MotionEvent;", "me", "height", "(Landroid/view/MotionEvent;I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.filament.CustomGestureDetector$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class TouchPair {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Float2 pt0;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Float2 pt1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int count;

        public TouchPair(@NotNull Float2 pt02, @NotNull Float2 pt12, int i3) {
            Intrinsics.checkNotNullParameter(pt02, "pt0");
            Intrinsics.checkNotNullParameter(pt12, "pt1");
            this.pt0 = pt02;
            this.pt1 = pt12;
            this.count = i3;
        }

        @NotNull
        public final Float2 a() {
            Float2 float2 = this.pt0;
            Float2 float22 = this.pt1;
            return new Float2((float2.getX() * 0.5f) + (float22.getX() * 0.5f), (float2.getY() * 0.5f) + (float22.getY() * 0.5f));
        }

        public final float b() {
            Float2 float2 = this.pt0;
            Float2 float22 = this.pt1;
            Float2 float23 = new Float2(float2.getX() - float22.getX(), float2.getY() - float22.getY());
            return (float) Math.sqrt((float23.getX() * float23.getX()) + (float23.getY() * float23.getY()));
        }

        public final int c() {
            return (int) a().getX();
        }

        public final int d() {
            return (int) a().getY();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TouchPair)) {
                return false;
            }
            TouchPair touchPair = (TouchPair) other;
            if (Intrinsics.areEqual(this.pt0, touchPair.pt0) && Intrinsics.areEqual(this.pt1, touchPair.pt1) && this.count == touchPair.count) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.pt0.hashCode() * 31) + this.pt1.hashCode()) * 31) + this.count;
        }

        @NotNull
        public String toString() {
            return "TouchPair(pt0=" + this.pt0 + ", pt1=" + this.pt1 + ", count=" + this.count + ")";
        }

        public TouchPair() {
            this(new Float2(0.0f), new Float2(0.0f), 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public TouchPair(@NotNull MotionEvent me5, int i3) {
            this();
            Intrinsics.checkNotNullParameter(me5, "me");
            if (me5.getPointerCount() >= 1) {
                Float2 float2 = new Float2(me5.getX(0), i3 - me5.getY(0));
                this.pt0 = float2;
                this.pt1 = float2;
                this.count++;
            }
            if (me5.getPointerCount() >= 2) {
                this.pt1 = new Float2(me5.getX(1), i3 - me5.getY(1));
                this.count++;
            }
        }
    }

    public CustomGestureDetector(int i3, @NotNull Manipulator manipulator) {
        Intrinsics.checkNotNullParameter(manipulator, "manipulator");
        this.viewHeight = i3;
        this.manipulator = manipulator;
        this.currentGesture = Gesture.NONE;
        this.previousTouch = new TouchPair();
        this.tentativePanEvents = new ArrayList<>();
        this.tentativeOrbitEvents = new ArrayList<>();
        this.tentativeZoomEvents = new ArrayList<>();
        this.kGestureConfidenceCount = 2;
        this.kPanConfidenceDistance = 4;
        this.kZoomConfidenceDistance = 10;
        this.kZoomSpeed = 0.1f;
        this.supportOrbit = true;
        this.supportPan = true;
        this.supportZoom = true;
        this.activeArea = new int[2];
    }

    private final void a() {
        this.tentativePanEvents.clear();
        this.tentativeOrbitEvents.clear();
        this.tentativeZoomEvents.clear();
        this.currentGesture = Gesture.NONE;
        this.manipulator.i();
    }

    private final boolean b() {
        if (!this.supportOrbit || this.tentativeOrbitEvents.size() <= this.kGestureConfidenceCount) {
            return false;
        }
        return true;
    }

    private final boolean c() {
        Object first;
        Object last;
        if (this.supportPan && this.tentativePanEvents.size() > this.kGestureConfidenceCount) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.tentativePanEvents);
            Float2 a16 = ((TouchPair) first).a();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.tentativePanEvents);
            Float2 a17 = ((TouchPair) last).a();
            Float2 float2 = new Float2(a16.getX() - a17.getX(), a16.getY() - a17.getY());
            if (((float) Math.sqrt((float2.getX() * float2.getX()) + (float2.getY() * float2.getY()))) <= this.kPanConfidenceDistance) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean d() {
        Object first;
        Object last;
        if (this.supportZoom && this.tentativeZoomEvents.size() > this.kGestureConfidenceCount) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.tentativeZoomEvents);
            float b16 = ((TouchPair) first).b();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.tentativeZoomEvents);
            if (Math.abs(((TouchPair) last).b() - b16) <= this.kZoomConfidenceDistance) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ void h(CustomGestureDetector customGestureDetector, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        if ((i3 & 4) != 0) {
            z18 = true;
        }
        customGestureDetector.g(z16, z17, z18);
    }

    public final void e(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TouchPair touchPair = new TouchPair(event, this.viewHeight);
        int actionMasked = event.getActionMasked();
        boolean z16 = false;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return;
                    }
                } else {
                    if ((event.getPointerCount() != 1 && this.currentGesture == Gesture.ORBIT) || ((event.getPointerCount() != 2 && this.currentGesture == Gesture.PAN) || ((event.getPointerCount() != 2 && this.currentGesture == Gesture.ZOOM) || !this.isActive))) {
                        a();
                        return;
                    }
                    Gesture gesture = this.currentGesture;
                    Gesture gesture2 = Gesture.ZOOM;
                    if (gesture == gesture2) {
                        this.manipulator.l(touchPair.c(), touchPair.d(), (this.previousTouch.b() - touchPair.b()) * this.kZoomSpeed);
                        this.previousTouch = touchPair;
                        return;
                    }
                    Gesture gesture3 = Gesture.ORBIT;
                    if (gesture == gesture3) {
                        this.manipulator.j(touchPair.c(), 0);
                        return;
                    }
                    if (gesture != Gesture.NONE) {
                        this.manipulator.j(touchPair.c(), touchPair.d());
                        return;
                    }
                    if (event.getPointerCount() == 1) {
                        this.tentativeOrbitEvents.add(touchPair);
                    }
                    if (event.getPointerCount() == 2) {
                        this.tentativePanEvents.add(touchPair);
                        this.tentativeZoomEvents.add(touchPair);
                    }
                    if (b()) {
                        this.manipulator.h(touchPair.c(), 0, false);
                        this.currentGesture = gesture3;
                        return;
                    } else if (d()) {
                        this.currentGesture = gesture2;
                        this.previousTouch = touchPair;
                        return;
                    } else {
                        if (c()) {
                            this.manipulator.h(touchPair.c(), touchPair.d(), true);
                            this.currentGesture = Gesture.PAN;
                            return;
                        }
                        return;
                    }
                }
            }
            a();
            return;
        }
        if (this.activeArea[0] == 0 || (event.getY() > this.activeArea[0] && event.getY() < this.activeArea[1])) {
            z16 = true;
        }
        this.isActive = z16;
        float y16 = event.getY();
        String arrays = Arrays.toString(this.activeArea);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("QWallet.Pet.PetGestureController", 1, "isActive=" + z16 + ": y=" + y16 + " " + arrays);
    }

    public final void f(@NotNull int[] activeArea) {
        Intrinsics.checkNotNullParameter(activeArea, "activeArea");
        this.activeArea = activeArea;
    }

    public final void g(boolean supportOrbit, boolean supportPan, boolean supportZoom) {
        this.supportOrbit = supportOrbit;
        this.supportPan = supportPan;
        this.supportZoom = supportZoom;
    }
}
