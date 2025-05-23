package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J%\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\nH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOAvatarApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOAvatarApi;", "()V", "clearAIOCache", "", "getAvatar", "Landroid/graphics/Bitmap;", "uin", "", "getAvatars", "", "uins", "([Ljava/lang/String;)[Landroid/graphics/Bitmap;", "isUseOldAvatarComponent", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOAvatarApiImpl implements IAIOAvatarApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public void clearAIOCache() {
        com.tencent.qqnt.avatar.g.d();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public Bitmap getAvatar(String uin) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return ((QQAppInterface) runtime).getFaceBitmap(uin, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public Bitmap[] getAvatars(String[] uins) {
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(uins, "uins");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        filterNotNull = ArraysKt___ArraysKt.filterNotNull(uins);
        boolean z16 = filterNotNull.size() == 1;
        List list = filterNotNull;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(qQAppInterface.getFaceBitmap((String) it.next(), z16 ? (byte) 3 : (byte) 1, true));
        }
        Object[] array = arrayList.toArray(new Bitmap[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Bitmap[]) array;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public boolean isUseOldAvatarComponent() {
        return !VasToggle.NT_NEW_AVATAR_AIO.isEnable(true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi
    public boolean useCircleImageView() {
        return IAIOAvatarApi.a.c(this);
    }
}
