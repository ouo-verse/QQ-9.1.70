package com.tencent.mobileqq.zootopia;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.FileUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/e;", "", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f328302a = new e();

    e() {
    }

    public final boolean a(@Nullable pu4.g material) {
        String str;
        String str2 = null;
        if (material != null) {
            str = material.f427435b;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual("mp4", str)) {
            if (material != null) {
                str2 = material.f427435b;
            }
            if (!Intrinsics.areEqual(FileUtils.FILE_TYPE_MOV, str2)) {
                return false;
            }
        }
        return true;
    }
}
