package com.tencent.mobileqq.pic.api;

import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.option.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\fH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isDynamicImg", "isEmotion", "", "picMaxSize", "getThumbMaxDp", "getThumbMinDp", "picType", "Lcom/tencent/mobileqq/pic/option/a;", "options", "", "loadPic", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "resetHelperCache", "pic_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicAIOApi extends QRouteApi {
    @NotNull
    IPicLoader getPicLoader();

    int getThumbMaxDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize);

    int getThumbMinDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize);

    boolean isDynamicImg(int picType);

    void loadPic(@NotNull Option option, @Nullable IPicLoadStateListener listener);

    void loadPic(@NotNull a options);

    void resetHelperCache();
}
