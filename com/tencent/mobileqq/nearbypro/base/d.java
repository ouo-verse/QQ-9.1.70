package com.tencent.mobileqq.nearbypro.base;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J5\u0010\b\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ?\u0010\r\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/d;", "Req", "", "Rsp", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/nearbypro/request/b;", "listener", "", "b", "(Ljava/lang/Object;Lcom/tencent/mobileqq/nearbypro/request/b;)I", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "c", "(Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/mobileqq/nearbypro/request/b;)I", "", "a", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface d<Req> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ int a(d dVar, Object obj, com.tencent.mobileqq.nearbypro.request.b bVar, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    bVar = null;
                }
                return dVar.b(obj, bVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRequest");
        }
    }

    void a(@Nullable Context context);

    <Rsp> int b(Req request, @Nullable com.tencent.mobileqq.nearbypro.request.b<Req, Rsp> listener);

    <Rsp> int c(@Nullable Context context, Req request, @Nullable com.tencent.mobileqq.nearbypro.request.b<NearbyProBaseRequest, Rsp> listener);
}
