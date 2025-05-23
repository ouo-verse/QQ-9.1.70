package com.tencent.mobileqq.aio.msg.action;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/action/c;", "", "", "onCreate", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "payloads", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "getRoot", "", "getMinWidth", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface c {
    boolean a(@NotNull AIOMsgItem msgItem, @NotNull List<Object> payloads);

    int getMinWidth();

    @NotNull
    View getRoot();

    void onCreate();

    void onDestroy();
}
