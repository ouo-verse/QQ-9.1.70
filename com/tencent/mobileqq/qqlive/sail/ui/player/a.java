package com.tencent.mobileqq.qqlive.sail.ui.player;

import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/a;", "", "", "init", "", "selectedPosition", "fromPosition", "", "b", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "a", QCircleLpReportDc05507.KEY_CLEAR, "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a {
    void a(@NotNull StreamDefinition definition);

    boolean b(int selectedPosition, int fromPosition);

    void clear();

    void init();
}
