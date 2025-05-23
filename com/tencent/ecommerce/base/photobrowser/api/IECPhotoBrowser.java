package com.tencent.ecommerce.base.photobrowser.api;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/photobrowser/api/IECPhotoBrowser;", "", "show", "", "photoUrl", "", "", "index", "", "params", "Ljava/util/HashMap;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPhotoBrowser {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IECPhotoBrowser iECPhotoBrowser, List list, int i3, HashMap hashMap, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    hashMap = null;
                }
                iECPhotoBrowser.show(list, i3, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }

    void show(@NotNull List<String> photoUrl, int index, @Nullable HashMap<String, String> params);
}
