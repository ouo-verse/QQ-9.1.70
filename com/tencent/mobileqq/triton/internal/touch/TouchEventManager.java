package com.tencent.mobileqq.triton.internal.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.triton.touch.InputTouchEvent;
import com.tencent.mobileqq.triton.touch.TTTouchEvents;
import com.tencent.mobileqq.triton.touch.Touch;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 &2\u00020\u0001:\u0002%&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rJ\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager;", "", "mScreenScale", "", "(F)V", "currentClick", "Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;", "lastClicks", "Ljava/util/Queue;", "lastTouchTimestamp", "", "mCurTouchList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/touch/TTTouchEvents;", "mGameBeginTime", "mTTTouchEvents", "addClick", "", "motionEvent", "Landroid/view/MotionEvent;", QCircleLpReportDc05507.KEY_CLEAR, "flushTouchEvents", "", "Lcom/tencent/mobileqq/triton/touch/InputTouchEvent;", "getLastClicks", "", "getLastTouchTimestamp", "getTheLastClickInfo", "handleTouchEvent", "touchEvent", "onTouch", "action", "", "onTouchEvent", "", "setBeginTime", "time", "Click", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TouchEventManager {
    private static final int MAX_CLICKS = 10;
    private Click currentClick;
    private long lastTouchTimestamp;
    private long mGameBeginTime;
    private final float mScreenScale;
    private final TTTouchEvents mTTTouchEvents = new TTTouchEvents();
    private final ArrayList<TTTouchEvents> mCurTouchList = new ArrayList<>();
    private final Queue<Click> lastClicks = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;", "", "startX", "", "startY", "(II)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "endX", "getEndX", "()I", "setEndX", "(I)V", "endY", "getEndY", "setEndY", "getStartX", "setStartX", "getStartY", "setStartY", "timestamp", "getTimestamp", "setTimestamp", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Click {
        private long duration;
        private int endX;
        private int endY;
        private int startX;
        private int startY;
        private long timestamp = System.currentTimeMillis();

        public Click(int i3, int i16) {
            this.startX = i3;
            this.startY = i16;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final int getEndX() {
            return this.endX;
        }

        public final int getEndY() {
            return this.endY;
        }

        public final int getStartX() {
            return this.startX;
        }

        public final int getStartY() {
            return this.startY;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final void setDuration(long j3) {
            this.duration = j3;
        }

        public final void setEndX(int i3) {
            this.endX = i3;
        }

        public final void setEndY(int i3) {
            this.endY = i3;
        }

        public final void setStartX(int i3) {
            this.startX = i3;
        }

        public final void setStartY(int i3) {
            this.startY = i3;
        }

        public final void setTimestamp(long j3) {
            this.timestamp = j3;
        }
    }

    public TouchEventManager(float f16) {
        this.mScreenScale = f16;
    }

    private final synchronized void addClick(MotionEvent motionEvent) {
        if (motionEvent != null) {
            Click click = this.currentClick;
            if (click != null) {
                if (click == null) {
                    Intrinsics.throwNpe();
                }
                int actionIndex = motionEvent.getActionIndex();
                if (Math.abs(motionEvent.getX(actionIndex) - (click.getStartX() * this.mScreenScale)) <= 1.0f && Math.abs(motionEvent.getY(actionIndex) - (click.getStartY() * this.mScreenScale)) <= 1.0f) {
                    click.setEndX((int) (motionEvent.getX(actionIndex) / this.mScreenScale));
                    click.setEndY((int) (motionEvent.getY(actionIndex) / this.mScreenScale));
                    click.setDuration(System.currentTimeMillis() - click.getTimestamp());
                    click.setTimestamp(System.currentTimeMillis());
                    this.lastClicks.offer(click);
                    if (this.lastClicks.size() > 10) {
                        this.lastClicks.poll();
                    }
                }
            }
        }
    }

    private final void onTouch(int action) {
        TTTouchEvents tTTouchEvents = this.mTTTouchEvents;
        tTTouchEvents.action = action;
        TTTouchEvents touchEvent = tTTouchEvents.copy();
        int i3 = touchEvent.action;
        if (i3 == 5) {
            touchEvent.action = 0;
        } else if (i3 == 6) {
            touchEvent.action = 1;
        }
        Intrinsics.checkExpressionValueIsNotNull(touchEvent, "touchEvent");
        handleTouchEvent(touchEvent);
    }

    public final void clear() {
        this.mTTTouchEvents.touches.clear();
        this.mTTTouchEvents.changedTouches.clear();
        this.mCurTouchList.clear();
        this.lastClicks.clear();
    }

    @Nullable
    public final synchronized List<InputTouchEvent> flushTouchEvents() {
        List<InputTouchEvent> createInputTouchEvents;
        createInputTouchEvents = InputTouchEvent.INSTANCE.createInputTouchEvents(this.mCurTouchList);
        this.mCurTouchList.clear();
        return createInputTouchEvents;
    }

    @NotNull
    public final synchronized String getLastClicks() {
        String sb5;
        StringBuilder sb6 = new StringBuilder("[");
        boolean z16 = true;
        for (Click click : this.lastClicks) {
            if (!z16) {
                sb6.append(',');
            }
            sb6.append('[');
            sb6.append(click.getStartX());
            sb6.append(',');
            sb6.append(click.getStartY());
            sb6.append(',');
            sb6.append(click.getEndX());
            sb6.append(',');
            sb6.append(click.getEndY());
            sb6.append(',');
            sb6.append(click.getTimestamp());
            sb6.append("]");
            z16 = false;
        }
        sb6.append("]");
        sb5 = sb6.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb5, "sb.toString()");
        return sb5;
    }

    public final synchronized long getLastTouchTimestamp() {
        return this.lastTouchTimestamp;
    }

    @NotNull
    public final synchronized String getTheLastClickInfo() {
        String jSONObject;
        Object last;
        JSONObject jSONObject2 = new JSONObject();
        try {
            last = CollectionsKt___CollectionsKt.last(this.lastClicks);
            Click click = (Click) last;
            jSONObject2.put("tsx", click.getStartX());
            jSONObject2.put("tsy", click.getStartY());
            jSONObject2.put("tex", click.getEndX());
            jSONObject2.put("tey", click.getEndY());
            jSONObject2.put("td", click.getDuration());
        } catch (NoSuchElementException unused) {
        }
        jSONObject = jSONObject2.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "res.toString()");
        return jSONObject;
    }

    public final synchronized void handleTouchEvent(@NotNull TTTouchEvents touchEvent) {
        Intrinsics.checkParameterIsNotNull(touchEvent, "touchEvent");
        touchEvent.timeStamp = System.currentTimeMillis() - this.mGameBeginTime;
        this.mCurTouchList.add(touchEvent);
    }

    public final boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "motionEvent");
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x16 = motionEvent.getX(actionIndex) / this.mScreenScale;
        float y16 = motionEvent.getY(actionIndex) / this.mScreenScale;
        int actionMasked = motionEvent.getActionMasked();
        this.mTTTouchEvents.changedTouches.clear();
        this.lastTouchTimestamp = System.currentTimeMillis();
        if (actionMasked != 0) {
            int i3 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                while (true) {
                                    if (i3 >= this.mTTTouchEvents.touches.size()) {
                                        break;
                                    }
                                    Touch touch = this.mTTTouchEvents.touches.get(i3);
                                    if (touch.identifier == pointerId) {
                                        this.mTTTouchEvents.changedTouches.add(touch);
                                        actionIndex = i3;
                                        break;
                                    }
                                    i3++;
                                }
                                if (this.mTTTouchEvents.touches.size() > 0 && this.mTTTouchEvents.touches.size() > actionIndex) {
                                    this.mTTTouchEvents.touches.remove(actionIndex);
                                }
                                onTouch(actionMasked);
                            }
                        }
                    } else {
                        TTTouchEvents tTTouchEvents = this.mTTTouchEvents;
                        tTTouchEvents.changedTouches.addAll(tTTouchEvents.touches);
                        this.mTTTouchEvents.touches.clear();
                        onTouch(actionMasked);
                    }
                } else {
                    for (int i16 = 0; i16 < motionEvent.getPointerCount(); i16++) {
                        int pointerId2 = motionEvent.getPointerId(i16);
                        for (int i17 = 0; i17 < this.mTTTouchEvents.touches.size(); i17++) {
                            Touch touch2 = this.mTTTouchEvents.touches.get(i17);
                            if (touch2.identifier == pointerId2) {
                                float x17 = motionEvent.getX(i16) / this.mScreenScale;
                                float y17 = motionEvent.getY(i16) / this.mScreenScale;
                                if (Math.abs(touch2.screenX - x17) >= 0.01f || Math.abs(touch2.screenY - y17) >= 0.01f) {
                                    touch2.setLocation(x17, y17);
                                    this.mTTTouchEvents.changedTouches.add(touch2);
                                }
                            }
                        }
                    }
                    if (this.mTTTouchEvents.changedTouches.size() > 0) {
                        onTouch(actionMasked);
                    }
                }
            } else {
                while (true) {
                    if (i3 >= this.mTTTouchEvents.touches.size()) {
                        break;
                    }
                    Touch touch3 = this.mTTTouchEvents.touches.get(i3);
                    if (touch3.identifier == pointerId) {
                        this.mTTTouchEvents.changedTouches.add(touch3);
                        break;
                    }
                    i3++;
                }
                this.mTTTouchEvents.touches.clear();
                onTouch(actionMasked);
                addClick(motionEvent);
            }
            return true;
        }
        Touch touch4 = new Touch(pointerId, x16, y16);
        this.mTTTouchEvents.touches.add(touch4);
        this.mTTTouchEvents.changedTouches.add(touch4);
        onTouch(actionMasked);
        if (actionMasked == 0) {
            this.currentClick = new Click((int) (motionEvent.getX(actionIndex) / this.mScreenScale), (int) (motionEvent.getY(actionIndex) / this.mScreenScale));
        }
        return true;
    }

    public final void setBeginTime(long time) {
        this.mGameBeginTime = time;
    }
}
