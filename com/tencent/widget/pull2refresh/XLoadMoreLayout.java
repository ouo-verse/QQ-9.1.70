package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XLoadMoreLayout extends FrameLayout implements ILoadMoreLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int CAN_MORE = 2;
    public static final int HIDE = 0;
    public static final int LOADING = 1;
    public static final int LOAD_MORE_ERROR = 5;
    public static final int LOAD_MORE_PENDING = 3;
    public static final int NO_MORE_DATA = 4;
    protected String mCanMoreText;
    protected Context mContext;
    protected View mLoadLayout;
    protected String mLoadMoreError;
    protected String mLoadingText;
    protected String mNoMoreDataText;
    protected ProgressBar mProgressBar;
    protected int mState;
    protected TextView mTextView;
    protected String mWillLoadMoreText;

    public XLoadMoreLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mState = -1;
            init();
        }
    }

    private boolean checkStateSwitch(int i3, int i16) {
        if (i3 >= 0 && i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (i16 == 0 || i16 == 1 || i16 == 2 || i16 == 3) {
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        if (i16 == 0 || i16 == 1 || i16 == 3) {
                            return true;
                        }
                        return false;
                    }
                    if (i16 == 0 || i16 == 1 || i16 == 2 || i16 == 4 || i16 == 5) {
                        return true;
                    }
                    return false;
                }
                if (i16 == 0 || i16 == 3 || i16 == 4 || i16 == 5) {
                    return true;
                }
                return false;
            }
            if (i16 != 0 && i16 != 3 && i16 != 4 && i16 != 5) {
                return false;
            }
        }
        return true;
    }

    private void init() {
        initResources();
        initView();
    }

    private void initResources() {
        this.mWillLoadMoreText = HardCodeUtil.qqStr(R.string.f1766831x);
        this.mCanMoreText = HardCodeUtil.qqStr(R.string.f1766431t);
        this.mNoMoreDataText = HardCodeUtil.qqStr(R.string.f1766731w);
        this.mLoadingText = getResources().getString(R.string.f1766631v);
        this.mLoadMoreError = HardCodeUtil.qqStr(R.string.f1766531u);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.fse, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.g5k);
        this.mLoadLayout = findViewById;
        this.mProgressBar = (ProgressBar) findViewById.findViewById(R.id.g5n);
        this.mTextView = (TextView) this.mLoadLayout.findViewById(R.id.g5o);
        updateState(0);
    }

    private boolean updateState(int i3) {
        if (!checkStateSwitch(this.mState, i3)) {
            return false;
        }
        this.mState = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.mProgressBar.setVisibility(8);
                                this.mTextView.setText(this.mLoadMoreError);
                                this.mLoadLayout.setVisibility(0);
                            }
                        } else {
                            this.mLoadLayout.setVisibility(8);
                        }
                    } else {
                        this.mProgressBar.setVisibility(8);
                        this.mTextView.setText(this.mWillLoadMoreText);
                        this.mLoadLayout.setVisibility(0);
                    }
                } else {
                    this.mProgressBar.setVisibility(0);
                    this.mTextView.setText(this.mCanMoreText);
                    this.mLoadLayout.setVisibility(0);
                }
            } else {
                this.mProgressBar.setVisibility(0);
                this.mTextView.setText(this.mLoadingText);
                this.mLoadLayout.setVisibility(0);
            }
        } else {
            this.mLoadLayout.setVisibility(8);
        }
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean checkState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        return checkStateSwitch(this.mState, i3);
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mState;
    }

    @Override // android.view.View, com.tencent.widget.pull2refresh.ILoadMoreLayout
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            this.mLoadLayout.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.widget.pull2refresh.ILoadMoreLayout
    public boolean setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        return updateState(i3);
    }

    public XLoadMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mState = -1;
            init();
        }
    }

    public XLoadMoreLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mState = -1;
            init();
        }
    }
}
