package com.tencent.mobileqq.qzoneplayer.cover.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes35.dex */
public class VideoPlayerEventCenter {

    /* loaded from: classes35.dex */
    public static class ConcreteSubject implements ISubject {
        protected int state = -1;
        protected List<IObserver> list = new ArrayList();

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public synchronized void attacth(IObserver iObserver) {
            this.list.add(iObserver);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public synchronized void detacth(IObserver iObserver) {
            this.list.remove(iObserver);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public int getState() {
            return this.state;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public synchronized void notifyObservers() {
            Iterator<IObserver> it = this.list.iterator();
            while (it.hasNext()) {
                it.next().update(this);
            }
        }

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public synchronized void removeAllObservers() {
            this.list.clear();
        }

        @Override // com.tencent.mobileqq.qzoneplayer.cover.data.VideoPlayerEventCenter.ISubject
        public void setState(int i3) {
            this.state = i3;
            notifyObservers();
        }
    }

    /* loaded from: classes35.dex */
    public interface IObserver {
        void update(ISubject iSubject);
    }

    /* loaded from: classes35.dex */
    public interface ISubject {
        void attacth(IObserver iObserver);

        void detacth(IObserver iObserver);

        int getState();

        void notifyObservers();

        void removeAllObservers();

        void setState(int i3);
    }
}
