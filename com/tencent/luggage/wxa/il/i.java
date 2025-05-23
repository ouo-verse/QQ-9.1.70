package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.graphics.drawable.Animatable2;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends CircleProgressDrawable implements Animatable2 {

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f130707l;

    public i(Context context) {
        super(context);
        this.f130707l = null;
    }

    @Override // android.graphics.drawable.Animatable2
    public void clearAnimationCallbacks() {
        ArrayList arrayList = this.f130707l;
        if (arrayList != null) {
            arrayList.clear();
            this.f130707l = null;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return b();
    }

    @Override // android.graphics.drawable.Animatable2
    public void registerAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        ArrayList arrayList = this.f130707l;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.f130707l = arrayList2;
            arrayList2.add(animationCallback);
        } else if (arrayList.contains(animationCallback)) {
            return;
        } else {
            this.f130707l.add(animationCallback);
        }
        if (isRunning()) {
            animationCallback.onAnimationStart(this);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        ArrayList arrayList = this.f130707l;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = new ArrayList(this.f130707l).iterator();
            while (it.hasNext()) {
                ((Animatable2.AnimationCallback) it.next()).onAnimationStart(this);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        ArrayList arrayList = this.f130707l;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = new ArrayList(this.f130707l).iterator();
            while (it.hasNext()) {
                ((Animatable2.AnimationCallback) it.next()).onAnimationEnd(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable2
    public boolean unregisterAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        ArrayList arrayList;
        int indexOf;
        if (animationCallback != null && (arrayList = this.f130707l) != null && (indexOf = arrayList.indexOf(animationCallback)) >= 0) {
            this.f130707l.remove(indexOf);
            return true;
        }
        return false;
    }
}
