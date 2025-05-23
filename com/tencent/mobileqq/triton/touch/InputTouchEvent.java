package com.tencent.mobileqq.triton.touch;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J1\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0082 J\u0019\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\nH\u0082 J\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/triton/touch/InputTouchEvent;", "", "action", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "(ID)V", "getAction", "()I", "<set-?>", "", "nativePtr", "getNativePtr", "()J", "getTimeStamp", "()D", "addTouch", "", IECDtReport.ACTION_IDENTIFIER, "screenX", "", "screenY", "isChanged", "", "nativeAddTouch", "ptr", "nativeCreate", "nativeRelease", "release", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class InputTouchEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_EVENT_SIZE = 12;
    private static final int MAX_TOUCH_SIZE = 16;
    private final int action;
    private long nativePtr;
    private final double timeStamp;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/triton/touch/InputTouchEvent$Companion;", "", "()V", "MAX_EVENT_SIZE", "", "MAX_TOUCH_SIZE", "addTouch", "", "inputTouchEvent", "Lcom/tencent/mobileqq/triton/touch/InputTouchEvent;", "touches", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/touch/Touch;", "isChanged", "", "createByTTTouchEvents", "ttTouchEvent", "Lcom/tencent/mobileqq/triton/touch/TTTouchEvents;", "createInputTouchEvents", "", "touchList", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        private final void addTouch(InputTouchEvent inputTouchEvent, ArrayList<Touch> touches, boolean isChanged) {
            int i3;
            if (touches.isEmpty()) {
                return;
            }
            int size = touches.size();
            if (touches.size() > 16) {
                i3 = touches.size() - 16;
            } else {
                i3 = 0;
            }
            while (i3 < size) {
                Touch touch = touches.get(i3);
                Intrinsics.checkExpressionValueIsNotNull(touch, "touches[i]");
                Touch touch2 = touch;
                inputTouchEvent.addTouch(touch2.identifier, touch2.screenX, touch2.screenY, isChanged);
                i3++;
            }
        }

        private final InputTouchEvent createByTTTouchEvents(TTTouchEvents ttTouchEvent) {
            InputTouchEvent inputTouchEvent = new InputTouchEvent(ttTouchEvent.action, ttTouchEvent.timeStamp);
            ArrayList<Touch> arrayList = ttTouchEvent.touches;
            Intrinsics.checkExpressionValueIsNotNull(arrayList, "ttTouchEvent.touches");
            addTouch(inputTouchEvent, arrayList, false);
            ArrayList<Touch> arrayList2 = ttTouchEvent.changedTouches;
            Intrinsics.checkExpressionValueIsNotNull(arrayList2, "ttTouchEvent.changedTouches");
            addTouch(inputTouchEvent, arrayList2, true);
            return inputTouchEvent;
        }

        @Nullable
        public final List<InputTouchEvent> createInputTouchEvents(@NotNull ArrayList<TTTouchEvents> touchList) {
            int i3;
            Intrinsics.checkParameterIsNotNull(touchList, "touchList");
            if (touchList.isEmpty()) {
                return null;
            }
            if (touchList.size() > 12) {
                i3 = touchList.size() - 12;
            } else {
                i3 = 0;
            }
            int size = touchList.size();
            ArrayList arrayList = new ArrayList(size - i3);
            while (i3 < size) {
                TTTouchEvents tTTouchEvents = touchList.get(i3);
                Intrinsics.checkExpressionValueIsNotNull(tTTouchEvents, "touchList[i]");
                arrayList.add(createByTTTouchEvents(tTTouchEvents));
                i3++;
            }
            return arrayList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InputTouchEvent(int i3, double d16) {
        this.action = i3;
        this.timeStamp = d16;
        this.nativePtr = nativeCreate(i3, d16);
    }

    private final native void nativeAddTouch(long ptr, int identifier, float screenX, float screenY, boolean isChanged);

    private final native long nativeCreate(int action, double timeStamp);

    private final native void nativeRelease(long ptr);

    public final void addTouch(int identifier, float screenX, float screenY, boolean isChanged) {
        long j3 = this.nativePtr;
        if (j3 == 0) {
            return;
        }
        nativeAddTouch(j3, identifier, screenX, screenY, isChanged);
    }

    public final int getAction() {
        return this.action;
    }

    public final long getNativePtr() {
        return this.nativePtr;
    }

    public final double getTimeStamp() {
        return this.timeStamp;
    }

    public final void release() {
        long j3 = this.nativePtr;
        if (j3 == 0) {
            return;
        }
        nativeRelease(j3);
        this.nativePtr = 0L;
    }
}
