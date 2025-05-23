package cooperation.qzone.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import com.tencent.widget.XListView;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FeedListView extends XListView implements NestedScrollingChild3 {
    public static final String EXT_KEY_SEARCH_MODE = "search_mode";
    protected Map<String, String> extArgMap;
    private boolean isLongClickValid;
    private IActivityLauncherProxy mInjectLauncherProxy;
    private int mLastY;
    private int mNestedOffsetY;
    private int[] mScrollConsumed;
    private int[] mScrollOffset;
    private NestedScrollingChildHelper mScrollingChildHelper;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ExpandHead {
        void hide();

        void show();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface FeedUinChangedListener {
        void onFeedUinChanged(String str, List<Long> list);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface LoadFeedCallback {
        void onLoadOver(boolean z16);
    }

    public FeedListView(Context context) {
        super(context);
        this.extArgMap = Collections.emptyMap();
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private boolean onNestTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(obtain);
        if (actionMasked == 0) {
            this.mNestedOffsetY = 0;
        }
        obtain.offsetLocation(0.0f, this.mNestedOffsetY);
        int y16 = (int) obtain.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                    boolean onTouchEvent = super.onTouchEvent(obtain);
                    stopNestedScroll();
                    return onTouchEvent;
                }
                int i3 = this.mLastY - y16;
                if (dispatchNestedPreScroll(0, i3, this.mScrollConsumed, this.mScrollOffset)) {
                    i3 -= this.mScrollConsumed[1];
                    int i16 = this.mScrollOffset[1];
                    this.mLastY = y16 - i16;
                    obtain.offsetLocation(0.0f, i16);
                    this.mNestedOffsetY += this.mScrollOffset[1];
                }
                boolean onTouchEvent2 = super.onTouchEvent(obtain);
                int[] iArr = this.mScrollOffset;
                if (dispatchNestedScroll(0, iArr[1], 0, i3, iArr)) {
                    obtain.offsetLocation(0.0f, this.mScrollOffset[1]);
                    int i17 = this.mNestedOffsetY;
                    int i18 = this.mScrollOffset[1];
                    this.mNestedOffsetY = i17 + i18;
                    this.mLastY -= i18;
                    return onTouchEvent2;
                }
                return onTouchEvent2;
            }
            return super.onTouchEvent(obtain);
        }
        boolean onTouchEvent3 = super.onTouchEvent(obtain);
        this.mLastY = y16;
        startNestedScroll(2);
        return onTouchEvent3;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return getScrollingChildHelper().dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return getScrollingChildHelper().dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    public IActivityLauncherProxy getActivityLauncherProxy() {
        return this.mInjectLauncherProxy;
    }

    public int getFeedCnt() {
        return 0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public void injectLauncherProxy(IActivityLauncherProxy iActivityLauncherProxy) {
        this.mInjectLauncherProxy = iActivityLauncherProxy;
    }

    public boolean isLongClickValid() {
        return this.isLongClickValid;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isNestedScrollingEnabled()) {
            return onNestTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExtArgs(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.extArgMap = map;
        } else if (!this.extArgMap.isEmpty()) {
            this.extArgMap.clear();
        }
    }

    public void setLongClickValid(boolean z16) {
        this.isLongClickValid = z16;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        getScrollingChildHelper().setNestedScrollingEnabled(z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return getScrollingChildHelper().startNestedScroll(i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public boolean switchTag(String str, LoadFeedCallback loadFeedCallback) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return getScrollingChildHelper().hasNestedScrollingParent(i3);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return getScrollingChildHelper().startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        getScrollingChildHelper().stopNestedScroll(i3);
    }

    public FeedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.extArgMap = Collections.emptyMap();
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
    }

    public FeedListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.extArgMap = Collections.emptyMap();
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void scrollToHeadView() {
    }

    public void scrollToTop() {
    }

    public void loadMore(LoadFeedCallback loadFeedCallback) {
    }

    public void setExpandHead(ExpandHead expandHead) {
    }

    public void setFeedUinChangedListener(FeedUinChangedListener feedUinChangedListener) {
    }

    public void attach(AppRuntime appRuntime, Activity activity, long j3) {
    }

    public void doActivityResult(int i3, int i16, Intent intent) {
    }
}
