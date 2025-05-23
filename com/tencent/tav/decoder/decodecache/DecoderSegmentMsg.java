package com.tencent.tav.decoder.decodecache;

/* compiled from: P */
/* loaded from: classes26.dex */
class DecoderSegmentMsg {
    final RequestStatus callbackObject;
    final CacheSegment segment;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecoderSegmentMsg(CacheSegment cacheSegment, RequestStatus requestStatus) {
        this.segment = cacheSegment;
        this.callbackObject = requestStatus;
    }
}
