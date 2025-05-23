package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/LocalPermissionStatus;", "", "()V", "NOT_IN_CACHE", "", "getNOT_IN_CACHE", "()I", "TAG", "", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity$delegate", "Lkotlin/Lazy;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "uin", "setStatus", "", "status", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LocalPermissionStatus {
    public static final LocalPermissionStatus INSTANCE = new LocalPermissionStatus();
    private static final int NOT_IN_CACHE = -100;
    private static final String TAG = "LocalPermissionStatus";

    /* renamed from: entity$delegate, reason: from kotlin metadata */
    private static final Lazy entity;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.mini.api.impl.LocalPermissionStatus$entity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
            }
        });
        entity = lazy;
    }

    LocalPermissionStatus() {
    }

    private final MMKVOptionEntity getEntity() {
        return (MMKVOptionEntity) entity.getValue();
    }

    public final int getNOT_IN_CACHE() {
        return NOT_IN_CACHE;
    }

    public final int getStatus(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return getEntity().decodeInt(uin, NOT_IN_CACHE);
    }

    public final void setStatus(String uin, int status) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        getEntity().encodeInt(uin, status).commitAsync();
    }
}
