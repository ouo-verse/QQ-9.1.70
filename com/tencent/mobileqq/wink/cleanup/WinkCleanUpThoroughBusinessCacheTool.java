package com.tencent.mobileqq.wink.cleanup;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/cleanup/WinkCleanUpThoroughBusinessCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Lcom/tencent/mobileqq/wink/publish/api/IWinkDraft;", "draftApi$delegate", "Lkotlin/Lazy;", "getDraftApi", "()Lcom/tencent/mobileqq/wink/publish/api/IWinkDraft;", "draftApi", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkCleanUpThoroughBusinessCacheTool implements y {

    @NotNull
    private static final String TAG = "WinkCleanUpThoroughBusinessCacheTool";

    /* renamed from: draftApi$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy draftApi;

    public WinkCleanUpThoroughBusinessCacheTool() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IWinkDraft>() { // from class: com.tencent.mobileqq.wink.cleanup.WinkCleanUpThoroughBusinessCacheTool$draftApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IWinkDraft invoke() {
                return (IWinkDraft) QRoute.api(IWinkDraft.class);
            }
        });
        this.draftApi = lazy;
    }

    private final IWinkDraft getDraftApi() {
        return (IWinkDraft) this.draftApi.getValue();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        y.a.a(this);
        QLog.d(TAG, 1, "clear image feature by QQ");
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> c16 = y.a.c(this);
        try {
            List<DraftBean> allDataSync = getDraftApi().getAllDataSync();
            Intrinsics.checkNotNullExpressionValue(allDataSync, "draftApi.allDataSync");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = allDataSync.iterator();
            while (it.hasNext()) {
                String coverUrl = ((DraftBean) it.next()).getCoverUrl();
                if (coverUrl != null) {
                    arrayList.add(coverUrl);
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(c16, arrayList);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getWhiteList, error ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "getWhiteList, ret:" + c16);
        }
        return c16;
    }
}
