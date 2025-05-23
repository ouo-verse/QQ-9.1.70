package com.tencent.av.ui.effect.toolbar;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.utils.e;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseToolbar {
    protected WeakReference<AVActivity> mActivity;
    protected VideoAppInterface mApp;
    protected View toolbarView;
    public final String TAG = getClass().getSimpleName();
    public Button mEffectBtn = null;
    public RedTouch mEffectBtnRedTouch = null;
    private boolean mIsCreated = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: g, reason: collision with root package name */
        public String f75563g;

        /* renamed from: a, reason: collision with root package name */
        public int f75557a = R.color.f157512rm;

        /* renamed from: b, reason: collision with root package name */
        public int f75558b = R.color.f157481qm;

        /* renamed from: c, reason: collision with root package name */
        public int f75559c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f75560d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f75561e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f75562f = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f75564h = 0;
    }

    public BaseToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        this.mApp = videoAppInterface;
        this.mActivity = new WeakReference<>(aVActivity);
    }

    public static BaseToolbar createToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity, Class<? extends BaseToolbar> cls) {
        try {
            return cls.getConstructor(VideoAppInterface.class, AVActivity.class).newInstance(videoAppInterface, aVActivity);
        } catch (Exception e16) {
            QLog.d(cls.getSimpleName(), 1, "createToolbar crash", e16);
            throw new IllegalArgumentException("create Toolbar fail, Illegal value[" + cls.getName() + "], srcException[" + e16.getClass().getName() + "]");
        }
    }

    public static void keepInToolbar(VideoAppInterface videoAppInterface, long j3) {
        if (videoAppInterface != null) {
            videoAppInterface.k0(new Object[]{125, Long.valueOf(j3)});
        }
    }

    public static void setSelectedListViewItemAndShow(HorizontalListView horizontalListView, QAVPtvTemplateAdapter qAVPtvTemplateAdapter, int i3) {
        int i16;
        if (qAVPtvTemplateAdapter.o(i3)) {
            if (i3 < horizontalListView.getFirstVisiblePosition() || i3 > horizontalListView.getLastVisiblePosition()) {
                if (i3 > 0 && i3 > qAVPtvTemplateAdapter.c()) {
                    i16 = QAVPtvTemplateAdapter.N * (i3 - 1);
                } else {
                    i16 = 0;
                }
                horizontalListView.resetCurrentX(i16);
            }
        }
    }

    private void show(long j3, int i3, boolean z16) {
        if (this.mIsCreated) {
            this.toolbarView.setVisibility(0);
            onShow(j3, i3, z16);
        }
    }

    public boolean canShowToolbar() {
        return isEffectBtnNormal();
    }

    public final void create(long j3, ViewGroup viewGroup) {
        if (getUIInfo().f75564h != 0) {
            if (this.mIsCreated) {
                return;
            }
            this.mIsCreated = true;
            View inflate = LayoutInflater.from(this.mActivity.get()).inflate(getUIInfo().f75564h, (ViewGroup) null);
            this.toolbarView = inflate;
            viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -2));
            onCreate(j3, this.mActivity.get());
            return;
        }
        throw new IllegalArgumentException("create Toolbar fail, Illegal toolbarLayout id\u3002" + this.TAG + "_" + j3);
    }

    protected abstract Button createEffectButton(ViewGroup viewGroup, int i3, a aVar);

    public final void destroy(long j3, VideoAppInterface videoAppInterface) {
        if (!this.mIsCreated) {
            return;
        }
        onDestroy(j3, videoAppInterface);
        this.toolbarView = null;
        this.mEffectBtnRedTouch = null;
        this.mEffectBtn = null;
        this.mIsCreated = false;
    }

    public AVActivity getAVActivity() {
        WeakReference<AVActivity> weakReference = this.mActivity;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.mActivity.get();
    }

    public int getEffectBtnId() {
        return getUIInfo().f75560d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract a getUIInfo();

    public String getUnableInfo() {
        return "";
    }

    public final void hideToolbar(long j3) {
        if (this.mIsCreated) {
            this.toolbarView.setVisibility(8);
            onHide(j3);
            setSelected(false);
        }
    }

    public void initBtn(ViewGroup viewGroup, boolean z16, View.OnClickListener onClickListener) {
        int i3;
        if (viewGroup == null) {
            return;
        }
        Button createEffectButton = createEffectButton(viewGroup, getEffectBtnId(), getUIInfo());
        this.mEffectBtn = createEffectButton;
        createEffectButton.setOnClickListener(onClickListener);
        if (e.e(0) == 1) {
            Button button = this.mEffectBtn;
            if (getEffectBtnId() % 2 == 0) {
                i3 = -16777216;
            } else {
                i3 = -256;
            }
            button.setBackgroundColor(i3);
        }
        if (!z16) {
            this.mEffectBtn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean is64bitAndSDKVersionUnderM() {
        VideoEnvironment64BitUtils.checkIs64bit();
        return false;
    }

    public boolean isAvailable() {
        Button button = this.mEffectBtn;
        if (button != null && button.getVisibility() == 0 && canShowToolbar()) {
            return true;
        }
        return false;
    }

    public boolean isCreated() {
        return this.mIsCreated;
    }

    public boolean isEffectBtnEnable() {
        return true;
    }

    public boolean isEffectBtnNormal() {
        return true;
    }

    public void onButtonClick(int i3, boolean z16, boolean z17) {
        showEffectBtnAnimation(i3, z16, z17);
    }

    public final void performClick() {
        Button button = this.mEffectBtn;
        if (button != null) {
            button.setTag(R.id.jae, Boolean.TRUE);
            this.mEffectBtn.performClick();
            this.mEffectBtn.setTag(R.id.jae, null);
        }
    }

    public void setEffectBtnVisibility(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        Button button = this.mEffectBtn;
        if (button != null) {
            button.setVisibility(i3);
        }
        RedTouch redTouch = this.mEffectBtnRedTouch;
        if (redTouch != null) {
            redTouch.setVisibility(i3);
        }
    }

    public void setSelected(boolean z16) {
        if (!this.mIsCreated) {
            return;
        }
        Button button = this.mEffectBtn;
        if (button != null) {
            button.setSelected(z16);
        }
        if (getUIInfo().f75559c != 0) {
            updateEffectBtnStatus();
        }
    }

    protected void showEffectBtnAnimation(int i3, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "showEffectBtnAnimation lastEffectBtnID: " + i3 + ", showToolbar: " + z17 + "\uff0c bFromPerformClick = " + z16 + ", getEffectBtnId = " + getEffectBtnId());
        }
    }

    public final boolean tryShowToolbar(long j3, ViewGroup viewGroup, int i3, boolean z16) {
        if (!canShowToolbar()) {
            String unableInfo = getUnableInfo();
            if (!TextUtils.isEmpty(unableInfo)) {
                cw.e.p(this.mApp, 1010, unableInfo);
            }
            QLog.w(this.TAG, 1, "tryShowToolbar, \u5931\u8d25[" + unableInfo + "], seq[" + j3 + "]");
            return false;
        }
        create(j3, viewGroup);
        show(j3, i3, z16);
        setSelected(true);
        if (PadUtil.a(this.mActivity.get()) == DeviceType.FOLD) {
            updateRecycler();
        }
        return true;
    }

    public abstract void updateEffectBtnStatus();

    public void updateRecycler() {
    }

    protected void onHide(long j3) {
    }

    public void update(Object[] objArr) {
    }

    protected void onCreate(long j3, AVActivity aVActivity) {
    }

    protected void onDestroy(long j3, VideoAppInterface videoAppInterface) {
    }

    protected void onShow(long j3, int i3, boolean z16) {
    }
}
