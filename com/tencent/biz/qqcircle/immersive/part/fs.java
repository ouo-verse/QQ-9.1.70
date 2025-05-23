package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fs extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {
    private TextView C;
    private TextView D;
    private ValueAnimator E = ValueAnimator.ofInt(100, 0);

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f88139d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f88140e;

    /* renamed from: f, reason: collision with root package name */
    private ConstraintLayout f88141f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleTagChallengeInfo f88142h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f88143i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f88144m;

    public fs(QCircleLayerBean qCircleLayerBean) {
        this.f88139d = qCircleLayerBean;
    }

    private void A9(Object obj) {
        if (!(obj instanceof e30.b)) {
            return;
        }
        QCircleTagChallengeInfo c16 = c40.d.c((e30.b) obj);
        QCircleTagChallengeInfo qCircleTagChallengeInfo = this.f88142h;
        if (qCircleTagChallengeInfo != null && qCircleTagChallengeInfo.equals(c16)) {
            return;
        }
        this.f88142h = c16;
        D9(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B9(ValueAnimator valueAnimator) {
        Drawable drawable;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue < 20 && (drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.kfo, null)) != null) {
            drawable.setAlpha((intValue * 255) / 20);
            this.f88143i.setBackgroundDrawable(drawable);
        }
    }

    private void C9() {
        this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fr
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                fs.this.B9(valueAnimator);
            }
        });
        this.f88143i.clearAnimation();
        this.f88143i.setBackgroundResource(R.drawable.kfo);
        this.E.setDuration(1000L);
        this.E.start();
    }

    private void D9(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        if (qCircleTagChallengeInfo != null && qCircleTagChallengeInfo.mTagChallenge != null && this.f88144m != null && this.C != null && this.D != null) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.nrq, null);
            if (drawable != null) {
                drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(17.5f), ImmersiveUtils.dpToPx(17.5f));
            }
            this.f88144m.setCompoundDrawables(drawable, null, null, null);
            this.f88144m.setText(qCircleTagChallengeInfo.mTagChallenge.title);
            this.C.setText(z9(qCircleTagChallengeInfo.mTagChallenge.tagChallengeRank));
            this.D.setText(qCircleTagChallengeInfo.mTagChallenge.subTitle);
            C9();
        }
    }

    private Resources getResources() {
        return getPartRootView().getResources();
    }

    private void initData() {
        QCircleLayerBean qCircleLayerBean = this.f88139d;
        if (qCircleLayerBean == null) {
            return;
        }
        D9(qCircleLayerBean.getTagChallengeInfo());
    }

    private String z9(int i3) {
        return getPartRootView().getResources().getString(R.string.f185323o_, Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTagChallengeFloatTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            A9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f54952gl);
        this.f88140e = viewStub;
        ConstraintLayout constraintLayout = (ConstraintLayout) viewStub.inflate().findViewById(R.id.f54932gj);
        this.f88141f = constraintLayout;
        this.f88143i = (LinearLayout) constraintLayout.findViewById(R.id.f54912gh);
        this.f88144m = (TextView) this.f88141f.findViewById(R.id.f54942gk);
        this.C = (TextView) this.f88141f.findViewById(R.id.f54922gi);
        this.D = (TextView) this.f88141f.findViewById(R.id.f54902gg);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
