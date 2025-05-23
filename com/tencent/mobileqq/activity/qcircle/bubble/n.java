package com.tencent.mobileqq.activity.qcircle.bubble;

import androidx.annotation.UiThread;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\t\u001a\u00020\u0004H'J\b\u0010\n\u001a\u00020\u0004H'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/n;", "", "Lcom/tencent/mobileqq/activity/qcircle/bubble/BubbleFailReason;", "failReason", "", "b", "", "loadImageTimeout", "a", "onDismiss", NodeProps.ON_CLICK, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface n {
    @UiThread
    void a(boolean loadImageTimeout);

    @UiThread
    void b(@NotNull BubbleFailReason failReason);

    @UiThread
    void onClick();

    @UiThread
    void onDismiss();
}
