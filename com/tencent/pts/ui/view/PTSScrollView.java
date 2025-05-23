package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSViewDecorationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSScrollView extends HorizontalScrollView implements IView {
    static IPatchRedirector $redirector_;
    public final String TAG;
    private FrameLayout container;
    private List<Integer> currentVisibleChildIndexList;
    private List<Integer> lastVisibleChildIndexList;
    private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
    private PTSNodeScrollView node;
    private Rect scrollRect;

    public PTSScrollView(PTSNodeScrollView pTSNodeScrollView) {
        super(pTSNodeScrollView.getContext());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSNodeScrollView);
            return;
        }
        this.TAG = "PTSScrollView";
        this.lastVisibleChildIndexList = new ArrayList();
        this.currentVisibleChildIndexList = new ArrayList();
        this.scrollRect = new Rect();
        this.node = pTSNodeScrollView;
        FrameLayout frameLayout = new FrameLayout(pTSNodeScrollView.getContext());
        this.container = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.container);
        setHorizontalScrollBarEnabled(false);
        this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
    }

    private void clearLastVisibleChildIndexList() {
        this.lastVisibleChildIndexList.clear();
    }

    private void triggerItemViewExposureImp() {
        PTSThreadUtil.runOnUIThread(new Runnable() { // from class: com.tencent.pts.ui.view.PTSScrollView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSScrollView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (PTSScrollView.this.container == null) {
                    PTSLog.e("PTSScrollView", "[triggerItemViewExposureImp] container is null.");
                    return;
                }
                PTSScrollView pTSScrollView = PTSScrollView.this;
                pTSScrollView.getHitRect(pTSScrollView.scrollRect);
                int childCount = PTSScrollView.this.container.getChildCount();
                PTSScrollView.this.currentVisibleChildIndexList.clear();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (PTSScrollView.this.container.getChildAt(i3).getLocalVisibleRect(PTSScrollView.this.scrollRect)) {
                        PTSScrollView.this.currentVisibleChildIndexList.add(Integer.valueOf(i3));
                    }
                }
                Iterator it = PTSScrollView.this.currentVisibleChildIndexList.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!PTSScrollView.this.lastVisibleChildIndexList.contains(Integer.valueOf(intValue))) {
                        PTSScrollView.this.node.triggerItemViewExposure(intValue);
                    }
                }
                PTSScrollView.this.lastVisibleChildIndexList.clear();
                PTSScrollView.this.lastVisibleChildIndexList.addAll(PTSScrollView.this.currentVisibleChildIndexList);
            }
        });
    }

    public void addChild(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null && view != null) {
            frameLayout.addView(view);
        } else {
            PTSLog.e("PTSScrollView", "[addChild] failed, container or view is null.");
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        int saveCount = this.mRoundedCorner.getSaveCount(canvas);
        super.draw(canvas);
        this.mRoundedCorner.drawCorner(canvas, saveCount);
        this.mRoundedCorner.drawBorder(canvas);
        triggerItemViewExposureImp();
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeInfo);
        } else {
            this.mRoundedCorner.onBindNodeInfo(pTSNodeInfo);
            clearLastVisibleChildIndexList();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDetachedFromWindow();
            clearLastVisibleChildIndexList();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (i3 != 0) {
            clearLastVisibleChildIndexList();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        if (!z16) {
            clearLastVisibleChildIndexList();
        } else {
            triggerItemViewExposureImp();
        }
    }

    public void removeChild(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null && view != null) {
            frameLayout.removeView(view);
        } else {
            PTSLog.e("PTSScrollView", "[removeChild] failed, container or view is null.");
        }
    }
}
