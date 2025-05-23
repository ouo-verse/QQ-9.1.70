package com.tencent.mobileqq.vas.avatar.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.avatar.NtVasAvatarView;
import com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager;
import com.tencent.mobileqq.vas.avatar.e;
import com.tencent.mobileqq.vas.avatar.j;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J@\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016JJ\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/api/impl/VasAvatarManagerImpl;", "Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/avatar/NtVasAvatarView;", "getVasAvatarView", "", "uin", "", "faceId", "headSize", "shopSource", "useSource", "Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager$DrawableCreateCallback;", "createSuccessCallback", "specialShapeMaskId", "", "getVasAvatarDrawable", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "numberInfo", "", "isAutoDownload", "Lcom/tencent/mobileqq/vas/avatar/j;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAvatarManagerImpl implements IVasAvatarManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/avatar/api/impl/VasAvatarManagerImpl$a", "Lcom/tencent/mobileqq/vas/avatar/e;", "Landroid/graphics/drawable/Drawable;", "d", "", "a", "", "errorCode", "", "msg", "fail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVasAvatarManager.DrawableCreateCallback f308794a;

        a(IVasAvatarManager.DrawableCreateCallback drawableCreateCallback) {
            this.f308794a = drawableCreateCallback;
        }

        @Override // com.tencent.mobileqq.vas.avatar.e
        public void a(@Nullable Drawable d16) {
            this.f308794a.createCallback(d16);
        }

        @Override // com.tencent.mobileqq.vas.avatar.e
        public void fail(int errorCode, @Nullable String msg2) {
            this.f308794a.createFail(errorCode, msg2);
        }
    }

    @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager
    public void getVasAvatarDrawable(@NotNull String uin, int faceId, int headSize, int shopSource, int useSource, @NotNull IVasAvatarManager.DrawableCreateCallback createSuccessCallback, int specialShapeMaskId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(createSuccessCallback, "createSuccessCallback");
        j jVar = new j(uin, faceId, headSize, shopSource, useSource, null, specialShapeMaskId);
        jVar.F(new a(createSuccessCallback));
        jVar.D();
    }

    @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager
    @NotNull
    public NtVasAvatarView getVasAvatarView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NtVasAvatarView(context);
    }

    @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager
    @NotNull
    public j getVasAvatarDrawable(@NotNull String uin, int faceId, int headSize, int shopSource, int useSource, @Nullable VipData.VipNumberInfo numberInfo, boolean isAutoDownload, int specialShapeMaskId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        j jVar = new j(uin, faceId, headSize, shopSource, useSource, numberInfo, specialShapeMaskId);
        jVar.D();
        jVar.B(isAutoDownload);
        return jVar;
    }
}
