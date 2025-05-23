package com.tencent.biz.qqcircle.comment.recpic;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<com.tencent.mobileqq.widget.tip.a> f83775a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f83776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f83777e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RoundImageView f83778f;

        a(Context context, View view, RoundImageView roundImageView) {
            this.f83776d = context;
            this.f83777e = view;
            this.f83778f = roundImageView;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess()) {
                com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(this.f83776d);
                r16.S(this.f83777e).a0(this.f83778f).i0(0.0f, -12.0f).g0(false).b0(-1L).Z(1, 0);
                ai.f83775a = new WeakReference(r16);
            }
        }
    }

    public static void b() {
        WeakReference<com.tencent.mobileqq.widget.tip.a> weakReference = f83775a;
        if (weakReference != null && weakReference.get() != null) {
            f83775a.get().o();
        }
    }

    public static void c(View view) {
        Context context = view.getContext();
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setmRadius(DisplayUtil.dip2px(context, 4.0f), false);
        if (view.getTag(-4) instanceof String) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(DisplayUtil.dip2px(context, 120.0f)).setRequestHeight(DisplayUtil.dip2px(context, 120.0f)).setTargetView(roundImageView).setUrl((String) view.getTag(-4)), new a(context, view, roundImageView));
        }
    }
}
