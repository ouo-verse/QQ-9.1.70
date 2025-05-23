package com.tencent.mobileqq.zplan.easteregg;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.zplan.easteregg.v;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

/* loaded from: classes34.dex */
public class EasterEggPagPlayer extends VasPagView implements v {

    /* renamed from: d, reason: collision with root package name */
    private PAGFile f332824d;

    /* renamed from: e, reason: collision with root package name */
    private v.a f332825e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, Bitmap> f332826f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<PAGImage> f332827h;

    /* renamed from: i, reason: collision with root package name */
    private final PAGView.PAGViewListener f332828i;

    public EasterEggPagPlayer(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        View currentView = api().getCurrentView();
        QLog.i("ZPlanAvatarPagPlayer", 2, "pag view release " + currentView);
        if (currentView instanceof PAGView) {
            PAGView pAGView = (PAGView) currentView;
            if (pAGView.isPlaying()) {
                pAGView.removeListener(this.f332828i);
                pAGView.stop();
            }
            QLog.e("ZPlanAvatarPagPlayer", 1, "release freeCache");
            pAGView.freeCache();
            pAGView.setComposition(null);
        }
        this.f332824d = null;
        v.a aVar = this.f332825e;
        if (aVar != null) {
            aVar.onRelease();
        }
        this.f332825e = null;
        Map<Integer, Bitmap> map = this.f332826f;
        if (map != null) {
            Iterator<Map.Entry<Integer, Bitmap>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().recycle();
                it.remove();
            }
            this.f332826f.clear();
        }
        ArrayList<PAGImage> arrayList = this.f332827h;
        if (arrayList != null) {
            Iterator<PAGImage> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                it5.next().release();
                it5.remove();
            }
            this.f332827h.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(Map map, PAGView pAGView) {
        if (this.f332824d == null) {
            return Unit.INSTANCE;
        }
        this.f332826f = map;
        if (!map.isEmpty()) {
            this.f332827h = new ArrayList<>();
        }
        for (Map.Entry<Integer, Bitmap> entry : this.f332826f.entrySet()) {
            PAGImage o16 = o(entry.getValue());
            if (o16 == null) {
                QLog.w("ZPlanAvatarPagPlayer", 1, "replaceImage: bitmap is null, index " + entry.getKey());
            } else {
                this.f332827h.add(o16);
                int intValue = entry.getKey().intValue();
                if (intValue < 0) {
                    intValue += p();
                }
                this.f332824d.replaceImage(intValue, o16);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final Map map) {
        api().postAction(new Function1() { // from class: com.tencent.mobileqq.zplan.easteregg.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r16;
                r16 = EasterEggPagPlayer.this.r(map, (PAGView) obj);
                return r16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit t(v.b bVar, PAGView pAGView) {
        QLog.i("ZPlanAvatarPagPlayer", 2, "pag view start postAction");
        PAGFile pAGFile = this.f332824d;
        if (pAGFile == null) {
            return Unit.INSTANCE;
        }
        pAGFile.setStartTime(bVar.f333096c);
        this.f332824d.setDuration(bVar.f333097d);
        pAGView.setRepeatCount(bVar.f333094a ? 0 : bVar.f333095b);
        pAGView.setScaleMode(3);
        pAGView.setComposition(this.f332824d);
        pAGView.setScaleX(bVar.f333098e);
        pAGView.removeListener(this.f332828i);
        pAGView.addListener(this.f332828i);
        QLog.i("ZPlanAvatarPagPlayer", 2, "pag view play " + pAGView);
        pAGView.play();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        View currentView = api().getCurrentView();
        QLog.i("ZPlanAvatarPagPlayer", 2, "pag view before stop  " + currentView);
        if (currentView instanceof PAGView) {
            PAGView pAGView = (PAGView) currentView;
            if (pAGView.isPlaying()) {
                QLog.i("ZPlanAvatarPagPlayer", 2, "pag view stop " + currentView);
                pAGView.stop();
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public boolean a(final v.b bVar) {
        if (!(api().getCurrentView() instanceof PAGView)) {
            QLog.w("ZPlanAvatarPagPlayer", 1, "pag view load fail");
            return false;
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.g
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagPlayer.this.u(bVar);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void c(final Map<Integer, Bitmap> map) {
        post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.f
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagPlayer.this.s(map);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.w("ZPlanAvatarPagPlayer", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.w("ZPlanAvatarPagPlayer", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    public int p() {
        PAGFile pAGFile = this.f332824d;
        if (pAGFile == null) {
            return 0;
        }
        return pAGFile.numImages();
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public boolean prepare(String str) {
        if (!(api().getCurrentView() instanceof PAGView)) {
            QLog.w("ZPlanAvatarPagPlayer", 1, "pag view load fail");
            v.a aVar = this.f332825e;
            if (aVar != null) {
                aVar.onError();
            }
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("ZPlanAvatarPagPlayer", 1, "pag file is empty");
            v.a aVar2 = this.f332825e;
            if (aVar2 != null) {
                aVar2.onError();
            }
            return false;
        }
        PAGFile Load = PagViewMonitor.Load(str);
        this.f332824d = Load;
        if (Load != null) {
            return true;
        }
        QLog.w("ZPlanAvatarPagPlayer", 1, "pag file load fail, filePath : " + str);
        v.a aVar3 = this.f332825e;
        if (aVar3 != null) {
            aVar3.onError();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void setStatusListener(v.a aVar) {
        this.f332825e = aVar;
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void stop() {
        post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.k
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagPlayer.this.v();
            }
        });
    }

    public void w() {
        post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.h
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggPagPlayer.this.q();
            }
        });
    }

    public EasterEggPagPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final v.b bVar) {
        QLog.i("ZPlanAvatarPagPlayer", 2, "pag view start post");
        api().postAction(new Function1() { // from class: com.tencent.mobileqq.zplan.easteregg.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t16;
                t16 = EasterEggPagPlayer.this.t(bVar, (PAGView) obj);
                return t16;
            }
        });
    }

    public EasterEggPagPlayer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f332826f = null;
        this.f332827h = null;
        this.f332828i = new a();
        api().build();
    }

    private PAGImage o(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return PAGImage.FromBitmap(bitmap);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public View getPlayerView() {
        return this;
    }

    /* loaded from: classes34.dex */
    class a implements PAGView.PAGViewListener {
        a() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            if (EasterEggPagPlayer.this.f332825e != null) {
                QLog.i("ZPlanAvatarPagPlayer", 1, "onAnimationCancel");
                EasterEggPagPlayer.this.f332825e.onEnd();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            if (EasterEggPagPlayer.this.f332825e != null) {
                QLog.i("ZPlanAvatarPagPlayer", 1, "onAnimationEnd");
                EasterEggPagPlayer.this.f332825e.onEnd();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
            if (EasterEggPagPlayer.this.f332825e == null || pAGView == null) {
                return;
            }
            QLog.i("ZPlanAvatarPagPlayer", 1, "onAnimationStart pagView.duration() : " + pAGView.duration());
            EasterEggPagPlayer.this.f332825e.onStart(pAGView.duration() / 1000);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
        }
    }
}
