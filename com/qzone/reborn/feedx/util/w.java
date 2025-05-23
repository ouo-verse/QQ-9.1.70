package com.qzone.reborn.feedx.util;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static volatile w f55785a;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f55786d;

        a(c cVar) {
            this.f55786d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c cVar = this.f55786d;
            if (cVar != null) {
                cVar.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements BubblePopupWindow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BubblePopupWindow f55788a;

        b(BubblePopupWindow bubblePopupWindow) {
            this.f55788a = bubblePopupWindow;
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.c
        public void onDismiss() {
            this.f55788a.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface c {
        void onClick(View view);
    }

    public static w a() {
        if (f55785a == null) {
            synchronized (w.class) {
                if (f55785a == null) {
                    f55785a = new w();
                }
            }
        }
        return f55785a;
    }

    public void b(View view, com.tencent.biz.qqcircle.richframework.widget.menu.c cVar, c cVar2) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.E(com.tencent.biz.qqcircle.richframework.widget.menu.a.a(bubblePopupWindow, view.getContext(), cVar, new a(cVar2)));
        bubblePopupWindow.H(new b(bubblePopupWindow));
        bubblePopupWindow.D(new ColorDrawable(0));
        bubblePopupWindow.I(true);
        bubblePopupWindow.F(true);
        bubblePopupWindow.L(view);
    }
}
