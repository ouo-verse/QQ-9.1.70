package com.tencent.widget.pull2refresh.anim;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.p;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DefaultAnimManager extends BaseAnimManager {
    static IPatchRedirector $redirector_;

    public DefaultAnimManager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.BaseAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public /* bridge */ /* synthetic */ void endOfRefresh() {
        super.endOfRefresh();
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public int getPullRefreshAreaHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.auf);
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public View getRefreshView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        }
        if (this.mTopRefresh == null) {
            this.mTopRefresh = (PullRefreshHeader) LayoutInflater.from(this.mContext).inflate(R.layout.f168433w5, viewGroup, false);
        }
        return (View) this.mTopRefresh;
    }

    @Override // com.tencent.widget.pull2refresh.anim.BaseAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public /* bridge */ /* synthetic */ boolean isSkinAnimManager() {
        return super.isSkinAnimManager();
    }

    @Override // com.tencent.widget.pull2refresh.anim.BaseAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.widget.pull2refresh.anim.BaseAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public /* bridge */ /* synthetic */ void onPullRefreshCancel() {
        super.onPullRefreshCancel();
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void onPullRefreshComplete(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        p pVar = this.mTopRefresh;
        if (pVar == null) {
            return;
        }
        pVar.h(0L);
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void onPullRefreshing(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        p pVar = this.mTopRefresh;
        if (pVar == null) {
            return;
        }
        if (i3 == 100) {
            pVar.d(0L);
        } else if (z16) {
            pVar.g();
        } else {
            pVar.i(0L);
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.BaseAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void onTouchPullDistance(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.IAnimManager
    public void registerRefreshCompleteListener(IAnimManager.PullRefreshComplete pullRefreshComplete) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) pullRefreshComplete);
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.IAnimManager
    public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener onRefreshPullDistanceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onRefreshPullDistanceListener);
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void showPullRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        p pVar = this.mTopRefresh;
        if (pVar == null) {
            return;
        }
        pVar.h(0L);
        this.mTopRefresh.g();
    }

    @Override // com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void showRefreshResult(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str);
            return;
        }
        if (this.mTopRefresh == null) {
            return;
        }
        if (z16 && !TextUtils.isEmpty(str)) {
            this.mTopRefresh.c(0, str);
        } else if (z16) {
            this.mTopRefresh.l(0);
        } else {
            this.mTopRefresh.l(2);
        }
    }
}
