package com.tencent.aio.stranger.api;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0011H&J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006H&J(\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aio/stranger/api/IStrangerBackgroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "", "chatType", "", "useMatchFriendAIOBackground", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "uinType", "useMatchFriendAIOBackgroundOnUinType", "Landroid/content/Context;", "context", "Landroid/view/View;", "createMatchFriendAIOBackground", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/stranger/api/a;", "model", "immediate", "setNextMutualModel", "left", "top", "right", "bottom", "notifyInputLayoutChange", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStrangerBackgroundApi extends QRouteApi {
    @NotNull
    View createMatchFriendAIOBackground(@Nullable Context context);

    void notifyInputLayoutChange(int left, int top, int right, int bottom);

    void onCreate(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void onDestroy();

    void setNextMutualModel(@NotNull a model, boolean immediate);

    boolean useMatchFriendAIOBackground(@Nullable String uin, @Nullable Integer chatType);

    boolean useMatchFriendAIOBackgroundOnUinType(@Nullable String uin, @Nullable Integer uinType);
}
