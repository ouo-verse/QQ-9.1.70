package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LoadingMoreHelper {
    static IPatchRedirector $redirector_;
    Context mContext;
    protected boolean mLoadEnabled;
    protected ILoadMoreLayout mLoadMoreLayout;
    protected OnLoadMoreListener mLoadMoreListener;
    protected int mProLoaderCount;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnLoadMoreListener {
        boolean onLoadMore(boolean z16);

        void onLoadMoreComplete();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class OnLoadMoreSimpleListener implements OnLoadMoreListener {
        static IPatchRedirector $redirector_;

        public OnLoadMoreSimpleListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
        public void onLoadMoreComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoadingMoreHelper.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LoadingMoreHelper.this.setLoadMore(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public LoadingMoreHelper(ILoadMoreLayout iLoadMoreLayout, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iLoadMoreLayout, (Object) context);
            return;
        }
        this.mProLoaderCount = 5;
        this.mLoadEnabled = false;
        this.mLoadMoreLayout = iLoadMoreLayout;
        this.mContext = context;
    }

    public int getProLoaderCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mProLoaderCount;
    }

    public void setLoadMore(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (!this.mLoadEnabled || this.mLoadMoreLayout.getState() == 0 || !this.mLoadMoreLayout.checkState(2)) {
            return;
        }
        OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
        if (onLoadMoreListener != null) {
            z17 = onLoadMoreListener.onLoadMore(z16);
        } else {
            z17 = true;
        }
        if (z17) {
            this.mLoadMoreLayout.setState(2);
        }
    }

    public void setLoadMoreComplete(boolean z16, boolean z17) {
        OnLoadMoreListener onLoadMoreListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!this.mLoadEnabled) {
            return;
        }
        if (!z16) {
            this.mLoadMoreLayout.setState(5);
            return;
        }
        if (!z17) {
            i3 = 4;
        }
        this.mLoadMoreLayout.setState(i3);
        if (this.mLoadMoreLayout.checkState(i3) && (onLoadMoreListener = this.mLoadMoreListener) != null) {
            onLoadMoreListener.onLoadMoreComplete();
        }
    }

    public void setLoadMoreEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (this.mLoadEnabled == z16) {
            return;
        }
        this.mLoadEnabled = z16;
        if (z16) {
            this.mLoadMoreLayout.setState(3);
        } else {
            this.mLoadMoreLayout.setState(0);
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onLoadMoreListener);
            return;
        }
        this.mLoadMoreListener = onLoadMoreListener;
        if (onLoadMoreListener != null) {
            setLoadMoreEnabled(true);
            setLoadMoreComplete(true, false);
        }
        this.mLoadMoreLayout.setOnClickListener(new a());
    }

    public void setPreLoaderCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mProLoaderCount = i3;
        }
    }
}
