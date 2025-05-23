package com.tencent.state.square;

import com.tencent.state.square.data.Resource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/DefaultSquareCallback;", "Lcom/tencent/state/square/SquareCallback;", "()V", "getAnimImageFile", "", "resource", "Lcom/tencent/state/square/data/Resource;", "type", "", "getAnimImageUrl", "getDefaultAvatarFile", "Ljava/io/File;", "isMale", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class DefaultSquareCallback implements SquareCallback {
    @Override // com.tencent.state.square.SquareCallback
    public String getAnimImageFile(Resource resource, int type) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return null;
    }

    @Override // com.tencent.state.square.SquareCallback
    public String getAnimImageUrl(Resource resource, int type) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return null;
    }

    @Override // com.tencent.state.square.SquareCallback
    public File getDefaultAvatarFile(boolean isMale, Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return null;
    }
}
