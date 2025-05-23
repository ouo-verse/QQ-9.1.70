package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class OperationView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    IPlayOperationViewModel f252791d;

    /* renamed from: e, reason: collision with root package name */
    VideoData f252792e;

    /* renamed from: f, reason: collision with root package name */
    public AppInterface f252793f;

    public OperationView(Context context) {
        super(context);
    }

    public void a() {
        this.f252791d.destroy();
    }

    public IPlayOperationViewModel b() {
        return this.f252791d;
    }

    public void c() {
        this.f252791d = ((IPlayOperationViewModel) QRoute.api(IPlayOperationViewModel.class)).init(LayoutInflater.from(getContext()).inflate(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyNowLayoutVideoOperator(), (ViewGroup) this, true), this.f252793f);
    }

    public void d() {
        if (this.f252792e.f252693d != 4) {
            this.f252791d.initCommentsWidget();
        }
    }

    public void e(boolean z16) {
        if (this.f252792e == null) {
            return;
        }
        this.f252791d.showIfCan(z16);
    }

    public void f(VideoData videoData) {
        this.f252792e = videoData;
        this.f252791d.updateShowInfo(videoData);
    }

    public void setCurrentAnchorUin(long j3) {
        IPlayOperationViewModel iPlayOperationViewModel = this.f252791d;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setCurrentAnchorUin(j3);
        }
    }

    public void setOnCloseListener(Object obj) {
        IPlayOperationViewModel iPlayOperationViewModel = this.f252791d;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setOnCloseListener(obj);
        }
    }

    public void setOnCommentClickListener(View.OnClickListener onClickListener) {
        IPlayOperationViewModel iPlayOperationViewModel = this.f252791d;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setOnCommentClickListener(onClickListener);
        }
    }

    public void setVideoPageSource(int i3) {
        this.f252791d.setVideoPageSource(i3);
    }

    public void setWatchCount(int i3) {
        VideoData videoData = this.f252792e;
        if (videoData == null || videoData.f252693d == 1) {
            return;
        }
        this.f252791d.setWatchCount(i3);
    }

    public OperationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
