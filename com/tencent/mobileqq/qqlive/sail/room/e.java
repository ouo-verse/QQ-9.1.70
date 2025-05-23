package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "Lcom/tencent/mobileqq/qqlive/sail/room/h;", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "b", "", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "newStreams", "", "i", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "mode", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", tl.h.F, "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface e extends f, h {
    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    AudienceRoomInfo b();

    void d(@NotNull WindowMode mode);

    boolean h();

    void i(@NotNull List<com.tencent.mobileqq.qqlive.sail.model.audience.a> newStreams);

    @NotNull
    WindowMode q();
}
