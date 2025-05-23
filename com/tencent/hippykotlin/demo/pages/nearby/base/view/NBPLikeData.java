package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPLikeData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeData.class, "doubleClickAnimation", "getDoubleClickAnimation()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeData.class, "numberData", "getNumberData()Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/NBPLikeData$NumberData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeData.class, "icon", "getIcon()Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/NBPLikeData$IconData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeData.class, "iconAnimationIng", "getIconAnimationIng()Z", 0)};
    public final ReadWriteProperty doubleClickAnimation$delegate;
    public ClickLocation doubleClickLocation;
    public final ReadWriteProperty icon$delegate;
    public final ReadWriteProperty iconAnimationIng$delegate;
    public String iconAnimationTimer;
    public final ReadWriteProperty numberData$delegate;

    public NBPLikeData() {
        Boolean bool = Boolean.FALSE;
        this.doubleClickAnimation$delegate = c.a(bool);
        this.doubleClickLocation = new ClickLocation();
        this.numberData$delegate = c.a(new NumberData(0, false));
        this.icon$delegate = c.a(new IconData(false, false));
        this.iconAnimationTimer = "";
        this.iconAnimationIng$delegate = c.a(bool);
    }

    public static void updateData$default(final NBPLikeData nBPLikeData, int i3, Boolean bool) {
        nBPLikeData.getClass();
        Unit unit = null;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            nBPLikeData.setNumberData(new NumberData(i3, booleanValue));
            if (booleanValue) {
                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).callNativeMethod("shakeLight", null, null);
            }
            nBPLikeData.resetIconAnimation();
            IconData iconData = new IconData(booleanValue, true);
            nBPLikeData.iconAnimationTimer = TimerKt.d(800, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData$updateData$1$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPLikeData.this.resetIconAnimation();
                    return Unit.INSTANCE;
                }
            });
            nBPLikeData.setIcon(iconData);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            nBPLikeData.setNumberData(new NumberData(i3, false));
        }
    }

    public final boolean getDoubleClickAnimation() {
        return ((Boolean) this.doubleClickAnimation$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final IconData getIcon() {
        return (IconData) this.icon$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final NumberData getNumberData() {
        return (NumberData) this.numberData$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void resetIconAnimation() {
        TimerKt.b(this.iconAnimationTimer);
        setIcon(new IconData(getIcon().isLiked, false));
        this.iconAnimationIng$delegate.setValue(this, $$delegatedProperties[3], Boolean.FALSE);
    }

    public final void setDoubleClickAnimation(boolean z16) {
        this.doubleClickAnimation$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setIcon(IconData iconData) {
        this.icon$delegate.setValue(this, $$delegatedProperties[2], iconData);
    }

    public final void setNumberData(NumberData numberData) {
        this.numberData$delegate.setValue(this, $$delegatedProperties[1], numberData);
    }

    public final boolean showStatic() {
        return !((Boolean) this.iconAnimationIng$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final void startIconAnimation() {
        this.iconAnimationIng$delegate.setValue(this, $$delegatedProperties[3], Boolean.TRUE);
    }

    public final boolean staticLiked() {
        if (getIcon().iconAnimation) {
            return !getIcon().isLiked;
        }
        return getIcon().isLiked;
    }

    public final void updateLiked(boolean z16) {
        if (z16 == getIcon().isLiked) {
            return;
        }
        setIcon(new IconData(z16, getIcon().iconAnimation));
    }

    public final void updateNumber(int i3) {
        if (i3 == getNumberData().number) {
            return;
        }
        setNumberData(new NumberData(i3, false));
    }

    public final void doDoubleClickAnimation(ClickLocation clickLocation) {
        if (clickLocation != null) {
            this.doubleClickLocation = new ClickLocation(clickLocation.f114210x, clickLocation.f114211y);
        }
        setDoubleClickAnimation(true);
    }

    /* loaded from: classes31.dex */
    public static final class IconData {
        public final boolean iconAnimation;
        public final boolean isLiked;

        public IconData(boolean z16, boolean z17) {
            this.isLiked = z16;
            this.iconAnimation = z17;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean z16 = this.isLiked;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            boolean z17 = this.iconAnimation;
            return i3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("IconData(isLiked=");
            m3.append(this.isLiked);
            m3.append(", iconAnimation=");
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.iconAnimation, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IconData)) {
                return false;
            }
            IconData iconData = (IconData) obj;
            return this.isLiked == iconData.isLiked && this.iconAnimation == iconData.iconAnimation;
        }
    }

    /* loaded from: classes31.dex */
    public static final class NumberData {
        public final int number;
        public final boolean numberAnimation;

        public NumberData(int i3, boolean z16) {
            this.number = i3;
            this.numberAnimation = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int i3 = this.number * 31;
            boolean z16 = this.numberAnimation;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NumberData(number=");
            m3.append(this.number);
            m3.append(", numberAnimation=");
            return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.numberAnimation, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NumberData)) {
                return false;
            }
            NumberData numberData = (NumberData) obj;
            return this.number == numberData.number && this.numberAnimation == numberData.numberAnimation;
        }
    }
}
