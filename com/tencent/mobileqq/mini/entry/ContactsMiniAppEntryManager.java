package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.q;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ContactsMiniAppEntryManager implements BusinessObserver, DrawerFrame.e, CommonRefreshLayout.b, BaseContactsMiniAppEntryManager {
    public static final int MODE_IDLE = 1;
    public static final int MODE_REFRESH = 2;
    public static final int MODE_SHOW_NODE = 3;
    private static final float SPEED_2 = 1.5f;
    public static final String TAG = "ContactsMiniAppEntryManager";
    public static long sScrollTimestamp;
    private int OFFSET_SCROLL_OVER;
    private QQAppInterface mApp;
    private MiniAppEntryLayout mContentView;
    private Context mContext;
    private ViewGroup mMiniAppListLayout;
    private q mPullRefreshHeader;
    private static final int OFFSET_NODE_OPEN = ViewUtils.dip2px(-50.0f);
    private static final int OFFSET_NODE_SCROLL = ViewUtils.dip2px(-50.0f);
    private static final int OFFSET_NODE_SCROLL_FAST = ViewUtils.dip2px(-100.0f);
    private static final int STORY_TRANSLATE = ViewUtils.dip2px(-70.0f);
    boolean flag = false;
    private int mode = 1;
    private int preMode = 1;
    private int mCurrentTab = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsMiniAppEntryManager(Context context, QQAppInterface qQAppInterface, RelativeLayout relativeLayout, int i3) {
        this.mContext = context;
        this.mPullRefreshHeader = (q) relativeLayout;
        this.mApp = qQAppInterface;
        MiniAppEntryLayout miniAppEntryLayout = new MiniAppEntryLayout(context, i3);
        this.mContentView = miniAppEntryLayout;
        this.mMiniAppListLayout = miniAppEntryLayout.getContainerView();
        this.mApp.registObserver(this);
    }

    private void onNodeScrollOut() {
        sScrollTimestamp = SystemClock.uptimeMillis();
    }

    private void removeDrawerFrameEvent(int i3) {
        WeakReference<DrawerFrame> weakReference = FrameHelperActivity.f194645g0;
        if (weakReference != null) {
            DrawerFrame drawerFrame = weakReference.get();
            if (drawerFrame != null) {
                drawerFrame.I(i3);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "removeDrawerFrameEvent. ref=null");
    }

    private void setMicroAppEntryPanelAlpha(float f16) {
        ViewGroup viewGroup = this.mMiniAppListLayout;
        if (viewGroup != null) {
            viewGroup.setAlpha(f16);
        }
    }

    private void setRefreshLayoutVisible(boolean z16) {
        this.mPullRefreshHeader.j(4, Integer.valueOf(z16 ? 0 : 8));
    }

    @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.e
    public boolean interceptDrawer(View view, MotionEvent motionEvent) {
        if (this.mode != 1) {
            return this.mContentView.interceptDrawer(view, motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
    public void onAccountChanged(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            onAccountChanged((QQAppInterface) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.b
    public void onFlingScrollHeader(int i3, int i16) {
        if (this.mContentView != null) {
            if (i3 > 2 && this.OFFSET_SCROLL_OVER != 0) {
                doOnScroll(i16, false);
            }
            if (i16 > (-this.mContentView.getHeight()) || this.mContentView.getHeight() == 0) {
                return;
            }
            setMicroAppEntryCompleteVisible(true);
            this.mContentView.resetDotViewStatus();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
    public void onPostThemeChanged() {
        this.mContentView.onPostThemeChanged();
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        MiniAppEntryLayout miniAppEntryLayout = this.mContentView;
        if (miniAppEntryLayout != null) {
            miniAppEntryLayout.updateMicroAppItemData();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.b
    public void onTouchMoving(CommonRefreshLayout commonRefreshLayout, int i3, MotionEvent motionEvent) {
        if (this.mContentView.getVisibility() != 0) {
            this.mContentView.setVisibility(0);
        }
        if (this.OFFSET_SCROLL_OVER == 0) {
            this.OFFSET_SCROLL_OVER = -this.mContentView.getHeight();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.flag && this.mode == 1) {
                        this.flag = true;
                        setMicroAppEntryCompleteVisible(false);
                        this.mContentView.resetDotViewStatus();
                    }
                    if (i3 <= 0 && this.mode == 1) {
                        doOnScroll(i3, true);
                        return;
                    } else {
                        if (i3 < 0) {
                            QLog.d(TAG, 2, "fight...onTouchMoving.onMove..scrollY = " + i3);
                            return;
                        }
                        return;
                    }
                }
                if (action != 3) {
                    return;
                }
            }
            this.flag = false;
            this.preMode = this.mode;
            if (i3 >= 0) {
                this.mode = 1;
                commonRefreshLayout.setShowMiniAppPanel(false);
            } else if (commonRefreshLayout.q()) {
                if (i3 <= (-commonRefreshLayout.j())) {
                    String str = (String) this.mPullRefreshHeader.f(11, null);
                    if (str != null && str.contains(HardCodeUtil.qqStr(R.string.l3z))) {
                        this.mode = 3;
                    } else {
                        QLog.d(TAG, 2, "story node start refresh onTouchMoving");
                        this.mode = 2;
                    }
                    commonRefreshLayout.setShowMiniAppPanel(true);
                } else if (i3 <= (-this.mContentView.getHeight())) {
                    this.mode = 3;
                    commonRefreshLayout.setShowMiniAppPanel(true);
                } else {
                    this.mode = 1;
                    commonRefreshLayout.setShowMiniAppPanel(false);
                }
            } else if (i3 <= (-this.mContentView.getHeight())) {
                if (this.mode != 2) {
                    this.mode = 3;
                    commonRefreshLayout.setShowMiniAppPanel(true);
                    onNodeScrollOut();
                }
            } else if (i3 <= OFFSET_NODE_OPEN) {
                if (this.mode == 2) {
                    setMicroAppEntryCompleteVisible(false);
                } else {
                    this.mode = 3;
                    commonRefreshLayout.setShowMiniAppPanel(true);
                    onNodeScrollOut();
                }
            } else {
                this.mode = 1;
                commonRefreshLayout.setShowMiniAppPanel(false);
            }
            setRefreshLayoutVisible(commonRefreshLayout.q());
            if (this.preMode == 1 && this.mode == 3) {
                this.mContentView.recordExposureItem();
                int i16 = this.mCurrentTab;
                if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183040c) {
                    MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_contact");
                } else if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183041d) {
                    MiniProgramLpReportDC04239.reportPageView("expo_page", "pulldown_mini_more");
                }
            }
            if (this.preMode == 3 && this.mode == 1) {
                MiniAppEntryLayout.exposureReport();
                return;
            }
            return;
        }
        if (this.mode == 1) {
            this.flag = true;
            setMicroAppEntryCompleteVisible(false);
            this.mContentView.resetDotViewStatus();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.b
    public int onViewCompleteAfterRefresh(boolean z16) {
        int height;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onViewCompleteAfterRefresh, mode:" + this.mode + ", showMiniApp: " + z16);
        }
        this.mContentView.updateMicroAppItemData();
        int i3 = this.mode;
        if (i3 == 2) {
            if (z16) {
                this.mode = 3;
                height = this.mContentView.getHeight();
            } else {
                this.mode = 1;
                return 0;
            }
        } else {
            if (i3 != 3) {
                return 0;
            }
            height = this.mContentView.getHeight();
        }
        return -height;
    }

    @Override // com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
    public void setDrawerFrameEvent(int i3) {
        WeakReference<DrawerFrame> weakReference = FrameHelperActivity.f194645g0;
        if (weakReference != null) {
            DrawerFrame drawerFrame = weakReference.get();
            if (drawerFrame != null) {
                drawerFrame.setMiniAppTouchEventInterceptor(i3, this);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "setDrawerFrameEvent. ref=null");
    }

    @Override // com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
    public void showMicroAppPanel(int i3) {
        this.mContentView.updateMicroAppItemData();
        this.mCurrentTab = i3;
        q qVar = this.mPullRefreshHeader;
        if (qVar == null || ((Integer) qVar.f(8, this.mContentView)).intValue() >= 0) {
            return;
        }
        this.mPullRefreshHeader.j(9, this.mContentView);
        this.mode = 1;
        this.mContentView.setVisibility(8);
        setDrawerFrameEvent(i3);
    }

    @Override // com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
    public void shutdownMiniAppPullDownEntry(ViewGroup viewGroup, int i3) {
        if (viewGroup instanceof CommonRefreshLayout) {
            shutdownMiniAppPullDownEntry((CommonRefreshLayout) viewGroup, i3);
        }
    }

    public void onAccountChanged(QQAppInterface qQAppInterface) {
        this.mApp.unRegistObserver(this);
        qQAppInterface.registObserver(this);
        this.mApp = qQAppInterface;
        QLog.d(TAG, 1, "[MiniAppUserAppInfoListManager].onAccountChanged");
    }

    public void shutdownMiniAppPullDownEntry(CommonRefreshLayout commonRefreshLayout, int i3) {
        try {
            setMicroAppEntryCompleteVisible(false);
            commonRefreshLayout.setShowMiniAppPanel(false);
            commonRefreshLayout.y();
            if (((Integer) this.mPullRefreshHeader.f(8, this.mContentView)).intValue() >= 0) {
                this.mPullRefreshHeader.j(10, this.mContentView);
                setRefreshLayoutVisible(true);
                this.mode = 1;
                removeDrawerFrameEvent(i3);
                commonRefreshLayout.setMiniAppScrollListener(null);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "shutdownMiniAppPullDownEntry, " + Log.getStackTraceString(e16));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doOnScroll(float f16, boolean z16) {
        float f17;
        if (z16 || this.preMode != 3) {
            this.mContentView.dotViewOnScroll(f16);
        }
        int i3 = OFFSET_NODE_SCROLL;
        QLog.d(TAG, 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%d,offset_scroll_over:%d", Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(this.OFFSET_SCROLL_OVER)));
        float f18 = 0.0f;
        if (f16 <= i3) {
            if (f16 > this.OFFSET_SCROLL_OVER) {
                int i16 = OFFSET_NODE_SCROLL_FAST;
                if (f16 <= i16) {
                    float f19 = (i16 - f16) / (i16 - r6);
                    float f26 = STORY_TRANSLATE + (i3 - i16);
                    f17 = f26 - ((f19 * f26) * 1.5f);
                } else {
                    f17 = STORY_TRANSLATE + (i3 - f16);
                }
                float translationY = this.mMiniAppListLayout.getTranslationY();
                this.mMiniAppListLayout.setTranslationY(f17);
                float translationY2 = this.mMiniAppListLayout.getTranslationY();
                int i17 = STORY_TRANSLATE;
                if (translationY2 < i17) {
                    this.mMiniAppListLayout.setTranslationY(i17);
                }
                if (this.mMiniAppListLayout.getTranslationY() > 0.0f) {
                    this.mMiniAppListLayout.setTranslationY(0.0f);
                }
                f18 = this.mMiniAppListLayout.getTranslationY() - translationY;
                setMicroAppEntryPanelAlpha((1.0f - (this.mMiniAppListLayout.getTranslationY() / i17)) + 0.8f);
                if (f16 <= ViewUtils.dpToPx(-70.0f)) {
                    this.mContentView.setDotViewTranslationY((f16 + r6.getDotViewHeight()) / 2.0f);
                    return;
                } else {
                    MiniAppEntryLayout miniAppEntryLayout = this.mContentView;
                    miniAppEntryLayout.setDotViewTranslationY(miniAppEntryLayout.getDotViewTranslationY() + f18);
                    return;
                }
            }
        }
        int i18 = this.OFFSET_SCROLL_OVER;
        if (f16 <= i18 && i18 != 0) {
            setMicroAppEntryCompleteVisible(true);
        }
        if (f16 <= ViewUtils.dpToPx(-70.0f)) {
        }
    }

    private void setMicroAppEntryCompleteVisible(boolean z16) {
        if (z16) {
            if (this.mMiniAppListLayout.getTranslationY() != 0.0f) {
                this.mMiniAppListLayout.setTranslationY(0.0f);
            }
            if (this.mMiniAppListLayout.getAlpha() != 1.0f) {
                setMicroAppEntryPanelAlpha(1.0f);
                return;
            }
            return;
        }
        float translationY = this.mMiniAppListLayout.getTranslationY();
        int i3 = STORY_TRANSLATE;
        if (translationY != i3) {
            this.mMiniAppListLayout.setTranslationY(i3);
        }
        if (this.mMiniAppListLayout.getAlpha() != 0.0f) {
            setMicroAppEntryPanelAlpha(0.0f);
        }
    }
}
