package com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel;

import android.os.Parcelable;
import com.tencent.mobileqq.guild.main.announcement.detail.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "b", "(Lcom/tencent/aio/api/runtime/a;)Lcom/tencent/mobileqq/guild/main/announcement/detail/AnnouncementDetailFragment$Param;", "customParam", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Param b(com.tencent.aio.api.runtime.a aVar) {
        Parcelable parcelable = aVar.g().l().getParcelable("aio_param");
        Intrinsics.checkNotNull(parcelable);
        return (Param) parcelable;
    }
}
