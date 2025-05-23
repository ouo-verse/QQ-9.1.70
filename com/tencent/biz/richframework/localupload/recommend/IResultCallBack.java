package com.tencent.biz.richframework.localupload.recommend;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/IResultCallBack;", "", "handleBatchResult", "", "mediaInfos", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "msg", "", "onFinish", "isBreak", "", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IResultCallBack {
    void handleBatchResult(@NotNull List<RFWMediaInfo> mediaInfos, @NotNull String msg2);

    void onFinish(boolean isBreak);
}
