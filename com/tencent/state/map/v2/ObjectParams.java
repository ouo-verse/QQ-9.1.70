package com.tencent.state.map.v2;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/map/v2/ObjectParams;", "", "id", "", "getId", "()Ljava/lang/String;", "location", "Lcom/tencent/state/map/v2/Location;", "getLocation", "()Lcom/tencent/state/map/v2/Location;", "type", "Lcom/tencent/state/map/v2/ObjectType;", "getType", "()Lcom/tencent/state/map/v2/ObjectType;", AppConstants.Key.COLUMN_IS_VALID, "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface ObjectParams {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        public static boolean isValid(ObjectParams objectParams) {
            return true;
        }
    }

    String getId();

    Location getLocation();

    ObjectType getType();

    boolean isValid();
}
