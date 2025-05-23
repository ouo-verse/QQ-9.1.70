package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dl extends u {
    private boolean C = true;
    private boolean D = false;
    private int E = 0;
    private com.tencent.biz.qqcircle.immersive.layer.base.e F;
    private e30.b G;

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends com.tencent.biz.qqcircle.viewmodels.a> f87980d;

    /* renamed from: e, reason: collision with root package name */
    private View f87981e;

    /* renamed from: f, reason: collision with root package name */
    private View f87982f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87983h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f87984i;

    /* renamed from: m, reason: collision with root package name */
    private String f87985m;

    public dl(Class<? extends com.tencent.biz.qqcircle.viewmodels.a> cls) {
        this.f87980d = cls;
    }

    private void B9() {
        this.C = false;
        View view = this.f87981e;
        if (view != null && this.D) {
            view.setVisibility(8);
        }
    }

    private void C9(final View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        if (feedCloudMeta$StFeed == null) {
            QLog.d(getTAG(), 1, "[initMantle] stop. ");
            return;
        }
        if (!this.C) {
            return;
        }
        if (feedCloudMeta$StFeed.type.get() == 2) {
            i3 = 5000;
        } else if (feedCloudMeta$StFeed.type.get() == 3) {
            int i16 = feedCloudMeta$StFeed.video.duration.get();
            if (i16 >= 10000) {
                i16 -= 5000;
            }
            i3 = i16 + 800;
        } else {
            i3 = 0;
        }
        this.f87985m = com.tencent.biz.qqcircle.utils.bh.d(feedCloudMeta$StFeed.feedTextInfo.get(), "middle_page_down_word");
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.dj
            @Override // java.lang.Runnable
            public final void run() {
                dl.this.G9(view);
            }
        }, i3);
    }

    private void D9() {
        View view = this.f87982f;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(R.drawable.kji);
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f87982f.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void E9(final View view) {
        com.tencent.biz.qqcircle.immersive.layer.base.e eVar = (com.tencent.biz.qqcircle.immersive.layer.base.e) getViewModel(this.f87980d);
        this.F = eVar;
        eVar.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.di
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dl.this.H9(view, (UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F9() {
        if (this.D && this.C) {
            B9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(View view) {
        if (this.C && !this.D) {
            I9(view);
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.dk
                @Override // java.lang.Runnable
                public final void run() {
                    dl.this.F9();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(View view, UIStateData uIStateData) {
        if (uIStateData != null && !uIStateData.isFakeData() && uIStateData.getData() != null && ((List) uIStateData.getData()).size() > 0 && !this.f87984i) {
            this.f87984i = true;
            e30.b bVar = (e30.b) RFSafeListUtils.get((List) uIStateData.getData(), this.E);
            if (bVar == null) {
                return;
            }
            this.G = bVar;
            C9(view, bVar.g());
        }
    }

    private void I9(View view) {
        if (view == null) {
            return;
        }
        e30.b bVar = this.G;
        if (bVar != null && bVar.g().opMask2.get().contains(58)) {
            QLog.d("QFSMantlePart", 1, "[showMantle] false: has FORCE_AUTO_SLIDE");
            return;
        }
        this.D = true;
        View inflate = ((ViewStub) view.findViewById(R.id.f45241rc)).inflate();
        this.f87981e = inflate.findViewById(R.id.v8_);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) inflate.getLayoutParams();
        this.f87982f = this.f87981e.findViewById(R.id.f46731vd);
        TextView textView = (TextView) this.f87981e.findViewById(R.id.f45231rb);
        this.f87983h = textView;
        if (textView != null && !TextUtils.isEmpty(this.f87985m)) {
            this.f87983h.setText(this.f87985m);
        }
        D9();
        Integer value = this.F.a2().getValue();
        if (value != null && value.intValue() != 0) {
            marginLayoutParams.bottomMargin = com.tencent.biz.qqcircle.utils.cx.a(0.0f);
        } else {
            marginLayoutParams.bottomMargin = com.tencent.biz.qqcircle.utils.cx.a(56.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMantlePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("layer_notify_part_update_feed_index".equals(str)) {
            Integer num = (Integer) obj;
            QLog.d("QFSMantlePart", 1, "[handleBroadcastMessage] position : " + num);
            if (num.intValue() != 0) {
                if (this.E == 0 || num.intValue() != this.E) {
                    B9();
                    return;
                }
                return;
            }
            return;
        }
        if ("layer_notify_part_action_down".equals(str) && this.D) {
            B9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        B9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        E9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        B9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        B9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        B9();
    }
}
