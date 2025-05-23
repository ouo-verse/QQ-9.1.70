package com.tencent.state.square.chatland.view;

import com.tencent.state.map.Location;
import com.tencent.state.template.data.OperationAd;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/chatland/view/IOperationView;", "", "checkIsSameMedia", "", "ad", "Lcom/tencent/state/template/data/OperationAd;", "destroy", "", "resetElevation", "location", "Lcom/tencent/state/map/Location;", "showDebugTools", "update", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IOperationView {
    boolean checkIsSameMedia(OperationAd ad5);

    void destroy();

    void resetElevation(Location location);

    void showDebugTools();

    void update(OperationAd ad5);
}
