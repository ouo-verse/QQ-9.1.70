package com.qzone.reborn.qzmoment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.qzone.reborn.qzmoment.view.blur.QZMBlurry;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedBlurView extends QZoneBaseWidgetView<bn.a> {

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f59116e;

    public QZMFeedBlurView(Context context) {
        this(context, null);
    }

    private void n0() {
        int i3 = (int) dn.a.f394285a;
        ViewGroup.LayoutParams layoutParams = this.f59116e.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = (int) (i3 / 0.7507f);
        this.f59116e.setLayoutParams(layoutParams);
    }

    private void q0() {
        if (getData() == null || getData().a() == null) {
            return;
        }
        Option failDrawable = Option.obtain().setUrl(getData().a().picUrl.get()).setLoadingDrawable(getResources().getDrawable(R.drawable.at8)).setFailDrawable(getResources().getDrawable(R.drawable.at_));
        if (this.f59116e.getLayoutParams() != null) {
            failDrawable.setRequestWidth(this.f59116e.getLayoutParams().width);
            failDrawable.setRequestHeight(this.f59116e.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(failDrawable, new IPicLoadStateListener() { // from class: com.qzone.reborn.qzmoment.widget.QZMFeedBlurView.1
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                if (loadState.isFinish()) {
                    if (!loadState.isFinishError() && option.getResultBitMap() != null) {
                        QZMBlurry.d().c().e(25).f(4).c().d(option.getResultBitMap()).a(QZMFeedBlurView.this.f59116e);
                    } else {
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.widget.QZMFeedBlurView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZMFeedBlurView.this.f59116e.setImageResource(R.drawable.at_);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128082e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n0();
    }

    public QZMFeedBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p0();
    }

    private void p0() {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.loz);
        this.f59116e = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(bn.a aVar, int i3) {
        String str;
        if (aVar == null) {
            return;
        }
        n0();
        q0();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bindData  | url = ");
        if (aVar.a() != null) {
            str = aVar.a().picUrl.get();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(" | hashcode = ");
        sb5.append(hashCode());
        QLog.i("BaseWidgetView", 1, sb5.toString());
    }
}
