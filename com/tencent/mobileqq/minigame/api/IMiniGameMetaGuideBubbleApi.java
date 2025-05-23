package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameMetaGuideBubbleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkRedTouchWhenExit", "", "clearSendGuideBubbleReqFlag", "dismissLebaMetaGuideBubble", "hasGuideBubbleRedTouch", "", "hasSendGuideBubbleReq", "showLebaMetaGuideBubble", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameMetaGuideBubbleApi extends QRouteApi {
    void checkRedTouchWhenExit();

    void clearSendGuideBubbleReqFlag();

    void dismissLebaMetaGuideBubble();

    boolean hasGuideBubbleRedTouch();

    boolean hasSendGuideBubbleReq();

    boolean showLebaMetaGuideBubble(@Nullable FrameFragment frameFragment);
}
