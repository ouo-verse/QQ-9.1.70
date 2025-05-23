package com.tencent.mobileqq.activity.aio.intimate.reborn.model;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/GetLoverValueEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isSuccess", "", "wording", "", "value", "url", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getUrl", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "getWording", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class GetLoverValueEvent extends SimpleBaseEvent {
    private final boolean isSuccess;

    @NotNull
    private final String url;

    @NotNull
    private final String value;

    @NotNull
    private final String wording;

    public GetLoverValueEvent(boolean z16, @NotNull String wording, @NotNull String value, @NotNull String url) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(url, "url");
        this.isSuccess = z16;
        this.wording = wording;
        this.value = value;
        this.url = url;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final String getWording() {
        return this.wording;
    }

    /* renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}
