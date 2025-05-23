package com.tencent.mobileqq.wink.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.wink.api.IAISceneChainHelper;
import com.tencent.mobileqq.wink.utils.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/AISceneChainHelperImpl;", "Lcom/tencent/mobileqq/wink/api/IAISceneChainHelper;", "", "path", "", "option", "Lcom/tencent/mobileqq/wink/model/a;", "detectAISceneChain", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getAIDetectorVersion", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AISceneChainHelperImpl implements IAISceneChainHelper {
    @Override // com.tencent.mobileqq.wink.api.IAISceneChainHelper
    @Nullable
    public com.tencent.mobileqq.wink.model.a detectAISceneChain(@NotNull String path, int option) {
        Intrinsics.checkNotNullParameter(path, "path");
        return ag.f326666a.e(path, option);
    }

    @Override // com.tencent.mobileqq.wink.api.IAISceneChainHelper
    public int getAIDetectorVersion() {
        return ag.f326666a.b();
    }

    @Override // com.tencent.mobileqq.wink.api.IAISceneChainHelper
    @Nullable
    public com.tencent.mobileqq.wink.model.a detectAISceneChain(@NotNull Bitmap bitmap, int option) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return ag.f326666a.d(bitmap, option);
    }
}
