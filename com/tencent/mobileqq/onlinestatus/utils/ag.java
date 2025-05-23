package com.tencent.mobileqq.onlinestatus.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/ag;", "", "", "uin", "Lh43/f;", "statusInfo", "", "b", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "stepMap", "Lh43/a;", "Lh43/a;", "getStepInfoCallback", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f256338a = new ag();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, h43.f> stepMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static h43.a getStepInfoCallback;

    ag() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, h43.f fVar) {
        f256338a.b(str, fVar);
        getStepInfoCallback = null;
    }

    public final void b(@Nullable String uin, @Nullable h43.f statusInfo) {
        if (!TextUtils.isEmpty(uin) && statusInfo != null) {
            HashMap<String, h43.f> hashMap = stepMap;
            Intrinsics.checkNotNull(uin);
            hashMap.put(uin, statusInfo);
        }
    }

    @NotNull
    public final h43.f c(@Nullable final String uin) {
        if (!TextUtils.isEmpty(uin)) {
            HashMap<String, h43.f> hashMap = stepMap;
            if (hashMap.containsKey(uin)) {
                h43.f fVar = hashMap.get(uin);
                if (fVar == null) {
                    getStepInfoCallback = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.utils.af
                        @Override // h43.a
                        public final void a(h43.f fVar2) {
                            ag.d(uin, fVar2);
                        }
                    };
                    ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(uin, Boolean.FALSE, getStepInfoCallback);
                    return new h43.f(0, "", "");
                }
                return fVar;
            }
        }
        return new h43.f(0, "", "");
    }
}
