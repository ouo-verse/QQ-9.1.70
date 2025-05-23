package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPShootTrackAnimation {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPShootTrackAnimation.class, "animationTransform", "getAnimationTransform()Lcom/tencent/hippykotlin/demo/pages/nearby/mood_group/vm/shoot/NBPShootTrackTransform;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPShootTrackAnimation.class, "animationRotate", "getAnimationRotate()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPShootTrackAnimation.class, "animationConfig", "getAnimationConfig()Lcom/tencent/kuikly/core/base/Animation;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPShootTrackAnimation.class, "showBoomView", "getShowBoomView()Z", 0)};
    public final Function1<NBPShootTrackAnimation, Unit> animationCompletion;
    public final ReadWriteProperty animationConfig$delegate;
    public int animationIndex;
    public final ReadWriteProperty animationRotate$delegate;
    public float animationSize;
    public final ReadWriteProperty animationTransform$delegate;
    public final Function1<NBPShootTrackAnimation, Unit> boomAnimationBegin;
    public float boomViewSize;
    public boolean didBoomAnimationEnd;
    public final boolean isBigger;
    public List<NBPShootTrackTransform> keyframeAnimations;
    public final Lazy maxRandomShootDistance$delegate;
    public final float pagerHeight;
    public final ReadWriteProperty showBoomView$delegate;
    public boolean startAnimation;

    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
    public NBPShootTrackAnimation(NBPShootPoint nBPShootPoint, float f16, boolean z16, float f17, float f18, Function1 function1, Function1 function12) {
        Lazy lazy;
        this.isBigger = z16;
        this.pagerHeight = f18;
        this.boomAnimationBegin = function1;
        this.animationCompletion = function12;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackAnimation$maxRandomShootDistance$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                double d16 = NBPShootTrackAnimation.this.pagerHeight;
                return Float.valueOf(Random.INSTANCE.nextInt((int) ((0.4d * d16) + d16), (int) ((0.6d * d16) + d16)));
            }
        });
        this.maxRandomShootDistance$delegate = lazy;
        this.keyframeAnimations = new ArrayList();
        this.animationSize = z16 ? 96.0f : 57.6f;
        this.animationTransform$delegate = c.a(new NBPShootTrackTransform(new NBPShootPoint(0.0f, 0.0f), 0.0f, 0.0f, 0.0f));
        this.animationRotate$delegate = c.a(Float.valueOf(0.0f));
        this.animationConfig$delegate = c.a(b.Companion.l(b.INSTANCE, 1.0f, null, 2, null));
        this.showBoomView$delegate = c.a(Boolean.FALSE);
        this.boomViewSize = z16 ? 314.0f : 256.0f;
        this.keyframeAnimations = (ArrayList) createKeyframeAnimations(nBPShootPoint, f16, getMaxRandomShootDistance(), f17, f18);
        if (!r7.isEmpty()) {
            setAnimationTransform((NBPShootTrackTransform) this.keyframeAnimations.get(0));
            setAnimationRotate(getAnimationTransform().getRotate());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x016a, code lost:
    
        if ((r12 == r32) != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0156, code lost:
    
        if ((r12 == r31) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x016d, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ce, code lost:
    
        if (r9 >= 180.0d) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0201, code lost:
    
        if (r9 >= 90.0d) goto L148;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<NBPShootTrackTransform> createKeyframeAnimations(NBPShootPoint nBPShootPoint, float f16, float f17, float f18, float f19) {
        float f26;
        Object next;
        NBPShootPoint nBPShootPoint2;
        char c16;
        Double d16;
        boolean z16;
        Double d17;
        boolean z17;
        int i3;
        double d18;
        ArrayList arrayList = new ArrayList();
        double d19 = ((((int) f16) - 90) + 1080) % 360;
        NBPShootPoint nBPShootPoint3 = nBPShootPoint;
        arrayList.add(createTrackTransform(nBPShootPoint3, (float) d19));
        float f27 = f17;
        while (f27 > 0.0f) {
            ArrayList arrayList2 = new ArrayList();
            double d26 = (3.141592653589793d * d19) / 180.0d;
            if (Math.abs(d26 - 1.5707963267948966d) < 1.0E-6d) {
                arrayList2.add(new NBPShootPoint(nBPShootPoint3.f114234x, f19));
            } else if (Math.abs(d26 - 4.71238898038469d) < 1.0E-6d) {
                arrayList2.add(new NBPShootPoint(nBPShootPoint3.f114234x, 0.0f));
            } else {
                float sin = (float) (Math.sin(d26) / Math.cos(d26));
                float f28 = nBPShootPoint3.f114235y - (nBPShootPoint3.f114234x * sin);
                float f29 = (sin * 0.0f) + f28;
                if (f29 >= 0.0f && f29 <= f19 && d19 > 90.0d && d19 < 270.0d) {
                    arrayList2.add(new NBPShootPoint(0.0f, f29));
                }
                float f36 = (sin * f18) + f28;
                if (f36 >= 0.0f && f36 <= f19 && ((d19 > 270.0d && d19 <= 360.0d) || (d19 >= 0.0d && d19 < 90.0d))) {
                    arrayList2.add(new NBPShootPoint(f18, f36));
                }
                float f37 = (0.0f - f28) / sin;
                if (f37 >= 0.0f && f37 <= f18 && d19 > 180.0d && d19 < 360.0d) {
                    arrayList2.add(new NBPShootPoint(f37, 0.0f));
                }
                float f38 = (f19 - f28) / sin;
                if (f38 >= 0.0f && f38 <= f18 && d19 > 0.0d && d19 < 180.0d) {
                    arrayList2.add(new NBPShootPoint(f38, f19));
                }
            }
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    float distance = NBPShootTrackAnimationKt.distance(nBPShootPoint3, (NBPShootPoint) next);
                    do {
                        Object next2 = it.next();
                        float distance2 = NBPShootTrackAnimationKt.distance(nBPShootPoint3, (NBPShootPoint) next2);
                        if (Float.compare(distance, distance2) > 0) {
                            distance = distance2;
                            next = next2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            NBPShootPoint nBPShootPoint4 = (NBPShootPoint) next;
            if (nBPShootPoint4 != null) {
                float f39 = nBPShootPoint4.f114234x;
                if (!(f39 == 0.0f)) {
                }
                float f46 = nBPShootPoint4.f114235y;
                if (!(f46 == 0.0f)) {
                }
                boolean z18 = true;
                if (z18) {
                    nBPShootPoint2 = nBPShootPoint4;
                    c16 = '\u0168';
                    d18 = d19;
                } else {
                    float f47 = nBPShootPoint4.f114235y;
                    if (!(f47 == 0.0f)) {
                        if (!(f47 == f19)) {
                            z17 = false;
                            nBPShootPoint2 = nBPShootPoint4;
                            double d27 = (!z17 ? 360 : 180) - d19;
                            int i16 = 15;
                            if (z17) {
                                if (d27 < 75 || d27 > 90.0d) {
                                    if (d27 < 285 || d27 > 270.0d) {
                                        if (d27 < 255 || d27 > 270.0d) {
                                            if (d27 <= 105) {
                                            }
                                            i3 = -15;
                                        }
                                    }
                                    i3 = 0;
                                }
                                i3 = -15;
                                i16 = 0;
                            } else {
                                if (d27 >= 15 || d27 < 0.0d) {
                                    if ((d27 <= 165 || d27 > 180.0d) && (d27 < 345 || d27 >= 360.0d)) {
                                        if (d27 <= 195) {
                                        }
                                        i3 = -15;
                                    }
                                    i3 = -15;
                                    i16 = 0;
                                }
                                i3 = 0;
                            }
                            double nextInt = d27 + Random.INSTANCE.nextInt(i3, i16);
                            c16 = '\u0168';
                            double d28 = 360;
                            d18 = (nextInt + d28) % d28;
                        }
                    }
                    z17 = true;
                    nBPShootPoint2 = nBPShootPoint4;
                    double d272 = (!z17 ? 360 : 180) - d19;
                    int i162 = 15;
                    if (z17) {
                    }
                    double nextInt2 = d272 + Random.INSTANCE.nextInt(i3, i162);
                    c16 = '\u0168';
                    double d282 = 360;
                    d18 = (nextInt2 + d282) % d282;
                }
                d16 = Double.valueOf(d18);
            } else {
                nBPShootPoint2 = nBPShootPoint4;
                c16 = '\u0168';
                d16 = null;
            }
            Pair pair = new Pair(nBPShootPoint2, d16);
            NBPShootPoint nBPShootPoint5 = (NBPShootPoint) pair.getFirst();
            if (nBPShootPoint5 == null || (d17 = (Double) pair.getSecond()) == null) {
                z16 = false;
            } else {
                double doubleValue = d17.doubleValue();
                float distance3 = NBPShootTrackAnimationKt.distance(nBPShootPoint3, nBPShootPoint5);
                if (distance3 > f27) {
                    float f48 = f27 / distance3;
                    float f49 = nBPShootPoint3.f114234x;
                    float f56 = ((nBPShootPoint5.f114234x - f49) * f48) + f49;
                    float f57 = nBPShootPoint3.f114235y;
                    arrayList.add(createTrackTransform(new NBPShootPoint(f56, ((nBPShootPoint5.f114235y - f57) * f48) + f57), (float) d19));
                } else {
                    arrayList.add(createTrackTransform(nBPShootPoint5, (float) d19));
                }
                f27 -= distance3;
                nBPShootPoint3 = nBPShootPoint5;
                d19 = doubleValue;
                z16 = true;
            }
            if (!z16 || arrayList.size() > 10) {
                KLog.INSTANCE.e("mood_group", "shoot keyframeAnimations obtain max count");
                f26 = 0.0f;
                break;
            }
        }
        f26 = 0.0f;
        if (f27 > f26) {
            arrayList.clear();
        }
        return arrayList;
    }

    public final NBPShootTrackTransform createTrackTransform(NBPShootPoint nBPShootPoint, float f16) {
        float f17 = nBPShootPoint.f114234x;
        float f18 = this.animationSize;
        return new NBPShootTrackTransform(nBPShootPoint, (f17 / f18) - 0.5f, (nBPShootPoint.f114235y / f18) - 0.5f, f16 + 90.0f);
    }

    public final NBPShootTrackTransform getAnimationTransform() {
        return (NBPShootTrackTransform) this.animationTransform$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final float getMaxRandomShootDistance() {
        return ((Number) this.maxRandomShootDistance$delegate.getValue()).floatValue();
    }

    public final void onBoomAnimationCompletion() {
        if (this.didBoomAnimationEnd) {
            return;
        }
        this.didBoomAnimationEnd = true;
        this.animationCompletion.invoke(this);
    }

    public final void setAnimationRotate(float f16) {
        this.animationRotate$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(f16));
    }

    public final void setAnimationTransform(NBPShootTrackTransform nBPShootTrackTransform) {
        this.animationTransform$delegate.setValue(this, $$delegatedProperties[0], nBPShootTrackTransform);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootTrackTransform>, java.util.ArrayList] */
    public final void toNextFrameAnimation() {
        if (this.animationIndex + 1 < this.keyframeAnimations.size()) {
            int i3 = this.animationIndex + 1;
            this.animationIndex = i3;
            NBPShootTrackTransform nBPShootTrackTransform = (NBPShootTrackTransform) this.keyframeAnimations.get(i3);
            NBPShootTrackTransform nBPShootTrackTransform2 = (NBPShootTrackTransform) this.keyframeAnimations.get(this.animationIndex - 1);
            float f16 = nBPShootTrackTransform.translateX - nBPShootTrackTransform2.translateX;
            float f17 = nBPShootTrackTransform.translateY - nBPShootTrackTransform2.translateY;
            b l3 = b.Companion.l(b.INSTANCE, ((float) Math.sqrt((f17 * f17) + (f16 * f16))) * (this.isBigger ? 0.2f : 0.03f), null, 2, null);
            ReadWriteProperty readWriteProperty = this.animationConfig$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(this, kPropertyArr[2], l3);
            this.animationTransform$delegate.setValue(this, kPropertyArr[0], nBPShootTrackTransform);
            this.animationRotate$delegate.setValue(this, kPropertyArr[1], Float.valueOf(getAnimationTransform().rotate));
            return;
        }
        this.showBoomView$delegate.setValue(this, $$delegatedProperties[3], Boolean.TRUE);
    }
}
