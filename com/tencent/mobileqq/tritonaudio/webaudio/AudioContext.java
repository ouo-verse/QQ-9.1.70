package com.tencent.mobileqq.tritonaudio.webaudio;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AudioContext {
    private ArrayList<Integer> audioBufferSourceNodeList = new ArrayList<>();
    private final long startTime = System.currentTimeMillis();
    private String state;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    interface State {
        public static final String CLOSED = "closed";
        public static final String RUNNING = "running";
        public static final String SUSPENDED = "suspended";
    }

    public AudioContext() {
        AudioNativeManager.initAudioContext();
    }

    public void close() {
        this.state = State.CLOSED;
        stopAllChannels();
    }

    public int createBufferSource() {
        int createBufferSource = AudioNativeManager.createBufferSource();
        this.audioBufferSourceNodeList.add(Integer.valueOf(createBufferSource));
        return createBufferSource;
    }

    public float getCurrentGain(int i3) {
        return AudioNativeManager.getCurrentGain(i3);
    }

    public long getCurrentTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public String getState() {
        return this.state;
    }

    public void resume() {
        this.state = "running";
        AudioNativeManager.resumeAudioContext();
    }

    public void setBufferSourceLoop(int i3, boolean z16) {
        AudioNativeManager.setBufferSourceLoop(i3, z16);
    }

    public void setCurrentGain(int i3, double d16) {
        AudioNativeManager.setCurrentGain(i3, (float) d16);
    }

    public void stopAllChannels() {
        Iterator<Integer> it = this.audioBufferSourceNodeList.iterator();
        while (it.hasNext()) {
            AudioNativeManager.stopSource(it.next().intValue());
        }
    }

    public void suspend() {
        this.state = State.SUSPENDED;
        AudioNativeManager.suspendAudioContext();
    }

    public void updateState(String str) {
        this.state = str;
    }
}
