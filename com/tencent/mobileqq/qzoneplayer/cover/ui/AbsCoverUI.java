package com.tencent.mobileqq.qzoneplayer.cover.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.BaseVideoPresenter;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.OnBaseVideoClickListener;
import com.tencent.mobileqq.qzoneplayer.cover.presenter.b;
import com.tencent.mobileqq.qzoneplayer.video.Recycleable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class AbsCoverUI implements VideoPlayerEventCenter.IObserver, Recycleable, View.OnClickListener {
    protected static final int GONE = 8;
    protected static final int INVISIBLE = 4;
    private static final int[] MSG_Array = {1, 48, 49, 9, 6, 8, 5, 4, 7, 1, 2, 10};
    protected static final int VISIBLE = 0;
    protected OnBaseVideoClickListener mBaseVideoClickListener;
    protected VideoData mBaseVideoData;
    protected Context mContext;
    protected b mOnCoverStateChangeListener;
    protected View mParentView;
    protected WeakReference<VideoPlayerEventCenter.ISubject> mSubjectWeakRef;
    protected int mPos = -1;
    protected BaseVideoPresenter mBaseVideoPresenter = null;
    protected int mViewType = -1;
    protected int mState = 0;
    private Handler handler = new a(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            removeMessages(message.what);
            int i3 = message.what;
            if (i3 == 1) {
                AbsCoverUI.this.onShowStopView();
                return;
            }
            if (i3 == 2) {
                AbsCoverUI.this.onShowWaitView();
                return;
            }
            if (i3 == 10) {
                AbsCoverUI.this.onShowPlayingView();
                return;
            }
            if (i3 == 48) {
                AbsCoverUI.this.onUpdate();
                return;
            }
            if (i3 != 49) {
                switch (i3) {
                    case 4:
                        AbsCoverUI.this.onShowPlayCompleteView();
                        return;
                    case 5:
                        AbsCoverUI.this.onShowPauseView();
                        return;
                    case 6:
                        AbsCoverUI.this.onShowErrorView();
                        return;
                    case 7:
                        AbsCoverUI.this.onShowRetryView();
                        return;
                    case 8:
                        AbsCoverUI.this.onShowPlayFloatCompleteView();
                        return;
                    default:
                        AbsCoverUI.this.onReceiveMsg(message);
                        return;
                }
            }
            AbsCoverUI.this.onUpdateUI();
        }
    }

    public AbsCoverUI(Context context) {
        this.mContext = context;
    }

    private void removeMessageException() {
        if (this.handler == null) {
            return;
        }
        for (int i3 : MSG_Array) {
            this.handler.removeMessages(i3);
        }
    }

    public void addView(AbsCoverUI absCoverUI) {
        if (absCoverUI == null || absCoverUI.getView() == null || !isViewGroup()) {
            return;
        }
        ((ViewGroup) this.mParentView).addView(absCoverUI.getView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View findViewById(int i3) {
        View view = this.mParentView;
        if (view != null) {
            return view.findViewById(i3);
        }
        return null;
    }

    public VideoData getData() {
        return this.mBaseVideoData;
    }

    protected abstract int getLayoutId();

    public BaseVideoPresenter getPresenter() {
        return this.mBaseVideoPresenter;
    }

    public View getView() {
        return this.mParentView;
    }

    public int getViewType() {
        return this.mViewType;
    }

    protected abstract void initChildView();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initUI(Context context) {
        if (getLayoutId() > 0) {
            this.mParentView = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null);
            initChildView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdv() {
        return VideoData.isAdvData(this.mBaseVideoData);
    }

    public boolean isParentInit() {
        return this.mParentView != null;
    }

    protected boolean isViewGroup() {
        View view = this.mParentView;
        return view != null && (view instanceof ViewGroup);
    }

    protected void onReceiveMsg(Message message) {
        onShowDefaultView(message);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public void onRecycled() {
        WeakReference<VideoPlayerEventCenter.ISubject> weakReference = this.mSubjectWeakRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mSubjectWeakRef.get().detacth(this);
    }

    protected abstract void onShowDefaultView(Message message);

    protected abstract void onShowErrorView();

    protected abstract void onShowPauseView();

    protected abstract void onShowPlayCompleteView();

    protected abstract void onShowPlayFloatCompleteView();

    protected abstract void onShowPlayingView();

    protected abstract void onShowRetryView();

    protected abstract void onShowStopView();

    protected abstract void onShowWaitView();

    protected abstract void onUpdate();

    public void setOnBaseVideoElementClickListener(OnBaseVideoClickListener onBaseVideoClickListener) {
        this.mBaseVideoClickListener = onBaseVideoClickListener;
    }

    public void setPos(int i3) {
        this.mPos = i3;
    }

    public void setPresenter(BaseVideoPresenter baseVideoPresenter) {
        this.mBaseVideoPresenter = baseVideoPresenter;
    }

    public void setViewType(int i3) {
        this.mViewType = i3;
    }

    public void setVisibility(int i3) {
        View view = this.mParentView;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public final void upDateData() {
        this.handler.sendEmptyMessage(48);
    }

    public final void updateUI() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(49);
        }
    }

    public void reset() {
        this.mState = 0;
    }

    public void addView(View view) {
        if (view == null || !isViewGroup()) {
            return;
        }
        ((ViewGroup) this.mParentView).addView(view);
    }

    public void attachSubject(VideoPlayerEventCenter.ISubject iSubject) {
        if (iSubject != null) {
            this.mSubjectWeakRef = new WeakReference<>(iSubject);
            iSubject.attacth(this);
        }
    }

    public void initLayout(ViewStub viewStub) {
        if (viewStub != null) {
            viewStub.setLayoutResource(getLayoutId());
            this.mParentView = viewStub.inflate();
            initChildView();
        }
    }

    public void setData(VideoData videoData) {
        if (videoData != null) {
            this.mBaseVideoData = videoData;
            upDateData();
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.IObserver
    public void update(VideoPlayerEventCenter.ISubject iSubject) {
        if (iSubject == null) {
            return;
        }
        int state = iSubject.getState();
        if (state != this.mState) {
            removeMessageException();
            switch (state) {
                case 1:
                    this.handler.sendEmptyMessage(1);
                    break;
                case 2:
                    this.handler.sendEmptyMessage(2);
                    break;
                case 3:
                case 9:
                default:
                    this.handler.sendEmptyMessage(9);
                    break;
                case 4:
                    this.handler.sendEmptyMessage(4);
                    break;
                case 5:
                    this.handler.sendEmptyMessage(5);
                    break;
                case 6:
                    this.handler.sendEmptyMessage(6);
                    break;
                case 7:
                    this.handler.sendEmptyMessage(7);
                    break;
                case 8:
                    this.handler.sendEmptyMessage(8);
                    break;
                case 10:
                    this.handler.sendEmptyMessage(10);
                    break;
            }
        }
        this.mState = iSubject.getState();
    }

    public void addView(AbsCoverUI absCoverUI, ViewGroup.LayoutParams layoutParams) {
        if (absCoverUI == null || absCoverUI.getView() == null || !isViewGroup() || layoutParams == null) {
            return;
        }
        ((ViewGroup) this.mParentView).addView(absCoverUI.getView(), layoutParams);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null || !isViewGroup() || layoutParams == null) {
            return;
        }
        ((ViewGroup) this.mParentView).addView(view, layoutParams);
    }

    protected void onUpdateUI() {
    }

    public void setOnCoverStateChangeListener(b bVar) {
    }
}
