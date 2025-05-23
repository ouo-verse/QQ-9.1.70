package com.tencent.state.map;

import com.tencent.mobileqq.R;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.media.MapPlayableSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007H&J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/map/MapPlayableItem;", "Lcom/tencent/state/map/MapItem;", "type", "", "uin", "", "isCenter", "", "location", "Lcom/tencent/state/map/Location;", "(ILjava/lang/String;ZLcom/tencent/state/map/Location;)V", "defaultResourceId", "getDefaultResourceId", "()I", "isGenderMale", "()Z", "isMe", "name", "getName", "()Ljava/lang/String;", "playableSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "getPlayableSource", "()Lcom/tencent/state/square/media/MapPlayableSource;", "resource", "Lcom/tencent/state/square/data/Resource;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "resetDefault", "", "updateDressKey", "dressKey", "updateGender", "isMale", "updateResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapPlayableItem extends MapItem {
    private final int defaultResourceId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapPlayableItem(int i3, String uin, boolean z16, Location location) {
        super(i3, uin, z16, location);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(location, "location");
        this.defaultResourceId = R.drawable.i9e;
    }

    public int getDefaultResourceId() {
        return this.defaultResourceId;
    }

    public abstract String getName();

    public final MapPlayableSource getPlayableSource() {
        Resource resource = getResource();
        if (resource != null) {
            return SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(getDefaultResourceId()));
        }
        return null;
    }

    public abstract Resource getResource();

    public abstract boolean isGenderMale();

    public final boolean isMe() {
        return SquareBaseKt.getSquareCommon().isCurrentAccount(getUin());
    }

    public abstract void resetDefault();

    public abstract void updateDressKey(String dressKey);

    public abstract void updateGender(boolean isMale);

    public abstract void updateResource(Resource resource);
}
