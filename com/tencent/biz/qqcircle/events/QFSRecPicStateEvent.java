package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSRecPicStateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "state", "I", "getState", "()I", "", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRecPicStateEvent extends SimpleBaseEvent {
    public static final int CLOSE_PERMISSION = 4;
    public static final int CLOSE_REC_PIC_BAR = 7;
    public static final int OPEN_INPUT_WINDOW_WITH_BAR = 6;
    public static final int OPEN_PERMISSION = 1;
    public static final int OPEN_REC_BAR = 3;
    public static final int SHOW_PERMISSION_PANEL_GUIDE = 5;
    public static final int START_ANALYSE_FEED_DESC = 8;
    public static final int UPDATE_DATA = 2;

    @NotNull
    private final String feedId;
    private final int state;

    public /* synthetic */ QFSRecPicStateEvent(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final int getState() {
        return this.state;
    }

    public QFSRecPicStateEvent(int i3, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.state = i3;
        this.feedId = feedId;
    }
}
