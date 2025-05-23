package com.tencent.state.decode;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/decode/ILargeImageView;", "", "destroy", "", "initialize", DownloadInfo.spKey_Config, "Lcom/tencent/state/decode/RegionConfig;", "onFling", "finalX", "", "finalY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "scrolledX", "scrolledY", "onTranslate", "transX", "transY", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public interface ILargeImageView {
    void destroy();

    void initialize(RegionConfig config);

    void onFling(int finalX, int finalY);

    void onScroll(int scrolledX, int scrolledY);

    void onTranslate(int transX, int transY);
}
