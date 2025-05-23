package com.tencent.biz.qqcircle.events;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class QCirclePanelStateEvent extends SimpleBaseEvent {

    /* renamed from: d, reason: collision with root package name */
    private static long f84410d;

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Long> f84411e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static final List<Integer> f84412f;

    /* renamed from: h, reason: collision with root package name */
    private static final List<Integer> f84413h;

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f84414i;

    @Nullable
    private Object arg;
    private final String mFeedId;
    private final boolean mIsShowing;
    private final int mPanelType;

    static {
        ArrayList arrayList = new ArrayList();
        f84412f = arrayList;
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(14);
        arrayList.add(29);
        ArrayList arrayList2 = new ArrayList();
        f84413h = arrayList2;
        arrayList2.add(27);
        f84414i = new int[]{0, 23};
    }

    public QCirclePanelStateEvent(int i3, String str, boolean z16) {
        this(i3, str, z16, null);
    }

    private static boolean b(int i3, int i16) {
        Long l3;
        if (i16 <= 0 || (l3 = f84411e.get(Integer.valueOf(i16))) == null || ((l3.longValue() >> i3) & 1) != 1) {
            return false;
        }
        return true;
    }

    private void e(int i3, Context context) {
        long j3;
        long j16 = f84410d;
        long j17 = ~(1 << i3);
        f84410d = j16 & j17;
        if (context != null) {
            int hashCode = context.hashCode();
            ConcurrentHashMap<Integer, Long> concurrentHashMap = f84411e;
            Long l3 = concurrentHashMap.get(Integer.valueOf(hashCode));
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            concurrentHashMap.put(Integer.valueOf(hashCode), Long.valueOf(j3 & j17));
        }
    }

    private void f(int i3, Context context) {
        long j3;
        long j16 = 1 << i3;
        f84410d |= j16;
        if (context != null) {
            int hashCode = context.hashCode();
            ConcurrentHashMap<Integer, Long> concurrentHashMap = f84411e;
            Long l3 = concurrentHashMap.get(Integer.valueOf(hashCode));
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            concurrentHashMap.put(Integer.valueOf(hashCode), Long.valueOf(j3 | j16));
        }
    }

    public static int getShowingPanelCount() {
        return Long.bitCount(f84410d);
    }

    public static boolean isAnyPanelShowing() {
        return f84410d > 0;
    }

    public static boolean isBottomPanelShowing() {
        Iterator<Integer> it = f84412f.iterator();
        while (it.hasNext()) {
            if (isSpecifiedPanelShowing(it.next().intValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBottomPanelShowingForTabVisible(Context context) {
        if (isBottomPanelShowing()) {
            return true;
        }
        if (context == null) {
            return false;
        }
        int hashCode = context.hashCode();
        Iterator<Integer> it = f84413h.iterator();
        while (it.hasNext()) {
            if (b(it.next().intValue(), hashCode)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommentPanelShowing() {
        for (int i3 : f84414i) {
            if (isSpecifiedPanelShowing(i3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecifiedPanelShowing(int i3) {
        return ((f84410d >> i3) & 1) == 1;
    }

    public static void resetPanelState() {
        f84410d = 0L;
    }

    @Nullable
    public Object getArg() {
        return this.arg;
    }

    public int getContextHashCode() {
        return this.mHashCode;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getPanelType() {
        return this.mPanelType;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void setArg(@Nullable Object obj) {
        this.arg = obj;
    }

    public void setPanelState(int i3, boolean z16, Context context) {
        if (z16) {
            f(i3, context);
        } else {
            e(i3, context);
        }
    }

    public boolean shouldHidePublishBubble() {
        if ((getPanelType() == 5 || getPanelType() == 7 || getPanelType() == 6 || getPanelType() == 19) && isShowing()) {
            return true;
        }
        return false;
    }

    public QCirclePanelStateEvent(int i3, String str, boolean z16, Context context) {
        this.mPanelType = i3;
        this.mFeedId = str;
        this.mIsShowing = z16;
        this.mHashCode = context != null ? context.hashCode() : 0;
        setPanelState(i3, z16, context);
    }

    public static boolean isAnyPanelShowing(Context context) {
        if (context == null) {
            return f84410d > 0;
        }
        Long l3 = f84411e.get(Integer.valueOf(context.hashCode()));
        return l3 != null && l3.longValue() > 0;
    }

    public static boolean isSpecifiedPanelShowing(int i3, Context context) {
        if (context == null) {
            return ((f84410d >> i3) & 1) == 1;
        }
        Long l3 = f84411e.get(Integer.valueOf(context.hashCode()));
        return l3 != null && ((l3.longValue() >> i3) & 1) == 1;
    }

    public static void resetPanelState(Context context) {
        if (context != null) {
            f84411e.remove(Integer.valueOf(context.hashCode()));
        }
    }
}
