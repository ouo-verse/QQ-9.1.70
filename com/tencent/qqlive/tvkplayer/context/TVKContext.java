package com.tencent.qqlive.tvkplayer.context;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.event.TVKEventSender;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKObjectHolder;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKContext {
    private static final int INSTANCE_ID_BEGIN_NUMBER = 1000;
    private static final int SEQUENCE_BEGIN_NUMBER = 10000;
    private static final AtomicInteger sInstanceIDGenerator = new AtomicInteger(1000);
    private final TVKObjectHolder<Context> mContext;
    private final TVKObjectHolder<TVKDebugTrackingEventReporter> mDebugTrackingEventReporter;
    private final TVKObjectHolder<TVKEventSender> mEventSender;
    private final TVKObjectHolder<Integer> mInstanceID;
    private final TVKObjectHolder<Integer> mSequence;

    public TVKContext(Context context) {
        this.mEventSender = new TVKObjectHolder<>(new TVKEventSender());
        this.mInstanceID = new TVKObjectHolder<>(Integer.valueOf(sInstanceIDGenerator.incrementAndGet()));
        this.mSequence = new TVKObjectHolder<>(10000);
        this.mContext = new TVKObjectHolder<>(context);
        this.mDebugTrackingEventReporter = new TVKObjectHolder<>(null);
    }

    public Context getContext() {
        return this.mContext.getObject();
    }

    @Nullable
    public TVKDebugTrackingEventReporter getDebugTrackingEventReporter() {
        return this.mDebugTrackingEventReporter.getObject();
    }

    public TVKEventSender getEventSender() {
        return this.mEventSender.getObject();
    }

    public int getInstanceID() {
        return this.mInstanceID.getObject().intValue();
    }

    public int getSequence() {
        return this.mSequence.getObject().intValue();
    }

    public String getTag() {
        return "TVKPlayer_C" + this.mInstanceID + "_T" + this.mSequence;
    }

    public void increaseSequence() {
        TVKObjectHolder<Integer> tVKObjectHolder = this.mSequence;
        tVKObjectHolder.updateObject(Integer.valueOf(tVKObjectHolder.getObject().intValue() + 1));
    }

    public void setDebugTrackingEventReporter(@Nullable TVKDebugTrackingEventReporter tVKDebugTrackingEventReporter) {
        this.mDebugTrackingEventReporter.updateObject(tVKDebugTrackingEventReporter);
    }

    public void updateContext(Context context) {
        this.mContext.updateObject(context);
    }

    public TVKContext(TVKContext tVKContext) {
        this.mEventSender = tVKContext.mEventSender;
        this.mInstanceID = tVKContext.mInstanceID;
        this.mSequence = tVKContext.mSequence;
        this.mContext = tVKContext.mContext;
        this.mDebugTrackingEventReporter = tVKContext.mDebugTrackingEventReporter;
    }
}
