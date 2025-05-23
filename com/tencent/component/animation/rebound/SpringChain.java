package com.tencent.component.animation.rebound;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpringChain implements SpringListener {
    private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
    private static final int DEFAULT_ATTACHMENT_TENSION = 70;
    private static final int DEFAULT_MAIN_FRICTION = 6;
    private static final int DEFAULT_MAIN_TENSION = 40;
    private final SpringConfig mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<SpringListener> mListeners;
    private final SpringConfig mMainSpringConfig;
    private final SpringSystem mSpringSystem;
    private final CopyOnWriteArrayList<Spring> mSprings;
    private static final SpringConfigRegistry registry = SpringConfigRegistry.getInstance();

    /* renamed from: id, reason: collision with root package name */
    private static int f99894id = 0;

    SpringChain() {
        this(40, 6, 70, 10);
    }

    public static SpringChain create() {
        return new SpringChain();
    }

    public SpringChain addSpring(SpringListener springListener) {
        this.mSprings.add(this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig));
        this.mListeners.add(springListener);
        return this;
    }

    public List<Spring> getAllSprings() {
        return this.mSprings;
    }

    public SpringConfig getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public Spring getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public SpringConfig getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    @Override // com.tencent.component.animation.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.tencent.component.animation.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.tencent.component.animation.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringEndStateChange(spring);
    }

    @Override // com.tencent.component.animation.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i3;
        int i16;
        int indexOf = this.mSprings.indexOf(spring);
        SpringListener springListener = this.mListeners.get(indexOf);
        int i17 = this.mControlSpringIndex;
        if (indexOf == i17) {
            i16 = indexOf - 1;
            i3 = indexOf + 1;
        } else if (indexOf < i17) {
            i16 = indexOf - 1;
            i3 = -1;
        } else if (indexOf > i17) {
            i3 = indexOf + 1;
            i16 = -1;
        } else {
            i3 = -1;
            i16 = -1;
        }
        if (i3 > -1 && i3 < this.mSprings.size()) {
            this.mSprings.get(i3).setEndValue(spring.getCurrentValue());
        }
        if (i16 > -1 && i16 < this.mSprings.size()) {
            this.mSprings.get(i16).setEndValue(spring.getCurrentValue());
        }
        springListener.onSpringUpdate(spring);
    }

    public SpringChain setControlSpringIndex(int i3) {
        this.mControlSpringIndex = i3;
        if (this.mSprings.get(i3) == null) {
            return null;
        }
        Iterator<Spring> it = this.mSpringSystem.getAllSprings().iterator();
        while (it.hasNext()) {
            it.next().setSpringConfig(this.mAttachmentSpringConfig);
        }
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
    }

    SpringChain(int i3, int i16, int i17, int i18) {
        this.mSpringSystem = SpringSystem.create();
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mSprings = new CopyOnWriteArrayList<>();
        this.mControlSpringIndex = -1;
        SpringConfig fromOrigamiTensionAndFriction = SpringConfig.fromOrigamiTensionAndFriction(i3, i16);
        this.mMainSpringConfig = fromOrigamiTensionAndFriction;
        SpringConfig fromOrigamiTensionAndFriction2 = SpringConfig.fromOrigamiTensionAndFriction(i17, i18);
        this.mAttachmentSpringConfig = fromOrigamiTensionAndFriction2;
        SpringConfigRegistry springConfigRegistry = registry;
        StringBuilder sb5 = new StringBuilder("main spring ");
        int i19 = f99894id;
        f99894id = i19 + 1;
        sb5.append(i19);
        springConfigRegistry.addSpringConfig(fromOrigamiTensionAndFriction, sb5.toString());
        StringBuilder sb6 = new StringBuilder("attachment spring ");
        int i26 = f99894id;
        f99894id = i26 + 1;
        sb6.append(i26);
        springConfigRegistry.addSpringConfig(fromOrigamiTensionAndFriction2, sb6.toString());
    }

    public static SpringChain create(int i3, int i16, int i17, int i18) {
        return new SpringChain(i3, i16, i17, i18);
    }
}
