package com.tencent.component.animation.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseSpringSystem {
    private final SpringLooper mSpringLooper;
    private final Map<String, Spring> mSpringRegistry = new HashMap();
    private final Set<Spring> mActiveSprings = new CopyOnWriteArraySet();
    private final CopyOnWriteArraySet<SpringSystemListener> mListeners = new CopyOnWriteArraySet<>();
    private boolean mIdle = true;

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper != null) {
            this.mSpringLooper = springLooper;
            springLooper.setSpringSystem(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void activateSpring(String str) {
        Spring spring = this.mSpringRegistry.get(str);
        if (spring != null) {
            this.mActiveSprings.add(spring);
            if (getIsIdle()) {
                this.mIdle = false;
                this.mSpringLooper.start();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }

    public void addListener(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.mListeners.add(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    void advance(double d16) {
        for (Spring spring : this.mActiveSprings) {
            if (spring.systemShouldAdvance()) {
                spring.advance(d16 / 1000.0d);
            } else {
                this.mActiveSprings.remove(spring);
            }
        }
    }

    public Spring createSpring() {
        Spring spring = new Spring(this);
        registerSpring(spring);
        return spring;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deregisterSpring(Spring spring) {
        if (spring != null) {
            this.mActiveSprings.remove(spring);
            this.mSpringRegistry.remove(spring.getId());
            return;
        }
        throw new IllegalArgumentException("spring is required");
    }

    public List<Spring> getAllSprings() {
        List arrayList;
        Collection<Spring> values = this.mSpringRegistry.values();
        if (values instanceof List) {
            arrayList = (List) values;
        } else {
            arrayList = new ArrayList(values);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean getIsIdle() {
        return this.mIdle;
    }

    public Spring getSpringById(String str) {
        if (str != null) {
            return this.mSpringRegistry.get(str);
        }
        throw new IllegalArgumentException("id is required");
    }

    public void loop(double d16) {
        Iterator<SpringSystemListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onBeforeIntegrate(this);
        }
        advance(d16);
        if (this.mActiveSprings.isEmpty()) {
            this.mIdle = true;
        }
        Iterator<SpringSystemListener> it5 = this.mListeners.iterator();
        while (it5.hasNext()) {
            it5.next().onAfterIntegrate(this);
        }
        if (this.mIdle) {
            this.mSpringLooper.stop();
        }
    }

    void registerSpring(Spring spring) {
        if (spring != null) {
            if (!this.mSpringRegistry.containsKey(spring.getId())) {
                this.mSpringRegistry.put(spring.getId(), spring);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }

    public void removeListener(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.mListeners.remove(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }
}
