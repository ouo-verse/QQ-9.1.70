package com.tencent.mobileqq.matchfriend.reborn.publish.upload;

import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader", f = "SquareFeedPicUploader.kt", i = {0, 0}, l = {62, 68}, m = "uploadPics", n = {"destination$iv$iv", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS}, s = {"L$0", "Z$0"})
/* loaded from: classes33.dex */
public final class SquareFeedPicUploader$uploadPics$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SquareFeedPicUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFeedPicUploader$uploadPics$1(SquareFeedPicUploader squareFeedPicUploader, Continuation<? super SquareFeedPicUploader$uploadPics$1> continuation) {
        super(continuation);
        this.this$0 = squareFeedPicUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, false, this);
    }
}
