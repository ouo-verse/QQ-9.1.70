package com.tencent.mobileqq.vas.social.config;

import com.tencent.state.square.IObtainInstanceHelper;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquareLifecycleProxy;
import com.tencent.state.square.api.ISquareNearbyAvatarService;
import com.tencent.state.square.api.ISquareTaskService;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/o;", "Lcom/tencent/state/square/IObtainInstanceHelper;", "Lcom/tencent/state/square/api/IFaceDecoder;", "getFaceDecoder", "Lcom/tencent/state/square/api/ISquareLifecycleProxy;", "getSquareLifecycleObserver", "Lcom/tencent/state/square/api/ISquareNearbyAvatarService;", "getNearByProAvatarService", "Lcom/tencent/state/square/api/ISquareTaskService;", "getSquareTaskService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class o implements IObtainInstanceHelper {
    @Override // com.tencent.state.square.IObtainInstanceHelper
    public IFaceDecoder getFaceDecoder() {
        return new g();
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    public ISquareNearbyAvatarService getNearByProAvatarService() {
        return new x();
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    public ISquareLifecycleProxy getSquareLifecycleObserver() {
        return new k();
    }

    @Override // com.tencent.state.square.IObtainInstanceHelper
    public ISquareTaskService getSquareTaskService() {
        return new y();
    }
}
