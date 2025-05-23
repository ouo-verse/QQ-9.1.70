package com.tencent.mobileqq.kandian.biz.common.baseui.api.impl;

import com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/ResourceIdImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IResourceId;", "", "type", "name", "", "getResourceId", "getCommonMaskView", "getId", "getLayoutId", "<init>", "()V", "Companion", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ResourceIdImpl implements IResourceId {
    private static final String TAG = "ResourceIdImpl";
    private static final String TYPE_ID = "id";
    private static final String TYPE_LAYOUT = "layout";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, Integer> sResourceMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/ResourceIdImpl$a;", "", "", "b", "", "TAG", "Ljava/lang/String;", "TYPE_ID", "TYPE_LAYOUT", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sResourceMap", "Ljava/util/HashMap;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.common.baseui.api.impl.ResourceIdImpl$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void b() {
            if (!ResourceIdImpl.sResourceMap.isEmpty()) {
            }
        }

        Companion() {
        }
    }

    private final int getResourceId(String type, String name) {
        try {
            INSTANCE.b();
            Integer num = sResourceMap.get(name);
            Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
            return num.intValue();
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "get " + type + " error, name:" + name);
            QLog.e(TAG, 1, "get " + type + " error, name:" + name + ", id return 0");
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId
    public int getCommonMaskView() {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId
    public int getId(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getResourceId("id", name);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId
    public int getLayoutId(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getResourceId("layout", name);
    }
}
