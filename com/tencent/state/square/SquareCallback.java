package com.tencent.state.square;

import com.tencent.state.square.data.Resource;
import java.io.File;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/SquareCallback;", "", "getAnimImageFile", "", "resource", "Lcom/tencent/state/square/data/Resource;", "type", "", "getAnimImageUrl", "getDefaultAvatarFile", "Ljava/io/File;", "isMale", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface SquareCallback {
    String getAnimImageFile(Resource resource, int type);

    String getAnimImageUrl(Resource resource, int type);

    File getDefaultAvatarFile(boolean isMale, Resource resource);
}
