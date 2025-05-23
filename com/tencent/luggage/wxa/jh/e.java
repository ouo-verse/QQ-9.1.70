package com.tencent.luggage.wxa.jh;

import com.tencent.mm.libmmwebrtc.MMWebRTCBinding;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.webrtc.VideoSink;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f131173a = new e();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        ErrOk,
        ErrNoWebRTCRuntime,
        ErrWebRTCRuntimeReleased,
        ErrNoMediaStreamTrackId,
        ErrInternal
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        AddOrUpdate,
        Remove
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f131183a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.AddOrUpdate.ordinal()] = 1;
            iArr[b.Remove.ordinal()] = 2;
            f131183a = iArr;
        }
    }

    public final a a(JSONObject jSONObject, VideoSink videoSink, com.tencent.luggage.wxa.xd.d appBrandComponent, b opCode) {
        MMWebRTCBinding mMWebRTCBinding;
        Intrinsics.checkNotNullParameter(videoSink, "videoSink");
        Intrinsics.checkNotNullParameter(appBrandComponent, "appBrandComponent");
        Intrinsics.checkNotNullParameter(opCode, "opCode");
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("mediaStreamTrackId");
            if (appBrandComponent instanceof com.tencent.luggage.wxa.r4.d) {
                mMWebRTCBinding = ((com.tencent.luggage.wxa.r4.d) appBrandComponent).g0().E();
            } else if (appBrandComponent instanceof com.tencent.luggage.wxa.m4.b) {
                mMWebRTCBinding = ((com.tencent.luggage.wxa.m4.b) appBrandComponent).y0().g0().E();
            } else {
                mMWebRTCBinding = null;
            }
            if (mMWebRTCBinding != null) {
                if (!mMWebRTCBinding.isRunning()) {
                    return a.ErrWebRTCRuntimeReleased;
                }
                int i3 = c.f131183a[opCode.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (mMWebRTCBinding.removeStreamFromVideoSink(videoSink, optInt)) {
                            return a.ErrOk;
                        }
                        return a.ErrInternal;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (mMWebRTCBinding.addOrUpdateStreamToVideoSink(videoSink, optInt)) {
                    return a.ErrOk;
                }
                return a.ErrInternal;
            }
            return a.ErrNoWebRTCRuntime;
        }
        return a.ErrNoMediaStreamTrackId;
    }
}
