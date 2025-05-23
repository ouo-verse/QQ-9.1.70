package com.tencent.thumbplayer.common;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.event.TPPlayerEventPublisher;
import com.tencent.thumbplayer.tpplayer.ITPPlayerStateQuerier;
import com.tencent.thumbplayer.tpplayer.TPPlayerStateMgr;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPContext {
    private static final AtomicInteger sPlayIDBase = new AtomicInteger(0);
    private final Context mAppContext;

    @NonNull
    private final TPPlayerStateMgr mStateMgr;
    private final Looper mWorkerLooper;
    private int mPlayID = sPlayIDBase.incrementAndGet();
    private String mLogTagPrefix = "";
    private String mLogTag = "";
    private final TPPlayerEventPublisher mPlayerEventPublisher = new TPPlayerEventPublisher();

    public TPContext(@NonNull Context context, @NonNull Looper looper) {
        this.mAppContext = context;
        this.mWorkerLooper = looper;
        buildLogTag();
        this.mStateMgr = new TPPlayerStateMgr(this);
    }

    private void buildLogTag() {
        String str;
        if (!TextUtils.isEmpty(this.mLogTagPrefix)) {
            str = this.mLogTagPrefix + "_";
        } else {
            str = "";
        }
        this.mLogTag = str + "tpplayer" + this.mPlayID;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    @NonNull
    public String getLogTag() {
        return this.mLogTag;
    }

    @NonNull
    public TPPlayerEventPublisher getPlayerEventPublisher() {
        return this.mPlayerEventPublisher;
    }

    @NonNull
    public ITPPlayerStateQuerier getStateQuerier() {
        return this.mStateMgr;
    }

    @NonNull
    public Looper getWorkerLooper() {
        return this.mWorkerLooper;
    }

    public synchronized void increasePlayID() {
        this.mPlayID = sPlayIDBase.incrementAndGet();
        buildLogTag();
    }

    public void setLogTagPrefix(@NonNull String str) {
        if (!TextUtils.equals(this.mLogTagPrefix, str)) {
            this.mLogTagPrefix = str;
            buildLogTag();
        }
    }
}
