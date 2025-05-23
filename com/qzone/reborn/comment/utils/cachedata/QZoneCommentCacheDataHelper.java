package com.qzone.reborn.comment.utils.cachedata;

import android.text.TextUtils;
import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\"\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheDataHelper;", "", "", "content", "", "nowTime", "", "saveMode", "", "f", v4.b.UNIKEY, "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "d", "atInfo", "", "g", "b", "Lcom/qzone/reborn/comment/utils/cachedata/a;", "a", "Lcom/qzone/reborn/comment/utils/cachedata/a;", "e", "()Lcom/qzone/reborn/comment/utils/cachedata/a;", "setCacheDataDelegate", "(Lcom/qzone/reborn/comment/utils/cachedata/a;)V", "cacheDataDelegate", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "cacheData", "<init>", "()V", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentCacheDataHelper {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<QZoneCommentCacheDataHelper> f53794d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a cacheDataDelegate = QZoneCommentCacheFactory.f53797a.a(0);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentCacheData cacheData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheDataHelper$a;", "", "Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheDataHelper;", "a", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/qzone/reborn/comment/utils/cachedata/QZoneCommentCacheDataHelper;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.comment.utils.cachedata.QZoneCommentCacheDataHelper$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final QZoneCommentCacheDataHelper a() {
            return b();
        }

        public final QZoneCommentCacheDataHelper b() {
            return (QZoneCommentCacheDataHelper) QZoneCommentCacheDataHelper.f53794d.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<QZoneCommentCacheDataHelper> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<QZoneCommentCacheDataHelper>() { // from class: com.qzone.reborn.comment.utils.cachedata.QZoneCommentCacheDataHelper$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZoneCommentCacheDataHelper invoke() {
                return new QZoneCommentCacheDataHelper();
            }
        });
        f53794d = lazy;
    }

    @JvmStatic
    public static final QZoneCommentCacheDataHelper c() {
        return INSTANCE.a();
    }

    private final boolean f(String content, long nowTime, int saveMode) {
        QZoneCommentCacheData qZoneCommentCacheData;
        if (TextUtils.isEmpty(content) || (qZoneCommentCacheData = this.cacheData) == null) {
            QLog.e("QZoneCommentCacheDataHelper", 1, "[needUpdateCache] content is " + content);
            return false;
        }
        if (saveMode != 1) {
            Intrinsics.checkNotNull(qZoneCommentCacheData);
            if (nowTime - qZoneCommentCacheData.getTimestamp() < 5) {
                return false;
            }
            QZoneCommentCacheData qZoneCommentCacheData2 = this.cacheData;
            Intrinsics.checkNotNull(qZoneCommentCacheData2);
            if (qZoneCommentCacheData2.getInputContent() != null) {
                QZoneCommentCacheData qZoneCommentCacheData3 = this.cacheData;
                Intrinsics.checkNotNull(qZoneCommentCacheData3);
                if (Intrinsics.areEqual(qZoneCommentCacheData3.getInputContent(), content)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void b(String unikey) {
        if (TextUtils.isEmpty(unikey)) {
            QLog.e("QZoneCommentCacheDataHelper", 1, "[deleteCacheData] unikey is null");
            return;
        }
        a aVar = this.cacheDataDelegate;
        Intrinsics.checkNotNull(unikey);
        aVar.a(unikey);
        this.cacheData = new QZoneCommentCacheData(0L, null, null, null, 0L, 31, null);
    }

    public final QZoneCommentCacheData d(String unikey) {
        if (TextUtils.isEmpty(unikey)) {
            QLog.e("QZoneCommentCacheDataHelper", 1, "[getCacheData] unikey is null");
            return null;
        }
        a aVar = this.cacheDataDelegate;
        Intrinsics.checkNotNull(unikey);
        QZoneCommentCacheData query = aVar.query(unikey);
        this.cacheData = query;
        if (query == null) {
            this.cacheData = new QZoneCommentCacheData(0L, unikey, null, null, 0L, 29, null);
        }
        return this.cacheData;
    }

    /* renamed from: e, reason: from getter */
    public final a getCacheDataDelegate() {
        return this.cacheDataDelegate;
    }

    public final void g(String content, String atInfo, int saveMode) {
        QZoneCommentCacheData qZoneCommentCacheData = this.cacheData;
        if (TextUtils.isEmpty(qZoneCommentCacheData != null ? qZoneCommentCacheData.getV4.b.UNIKEY java.lang.String() : null)) {
            QLog.e("QZoneCommentCacheDataHelper", 1, "[updateCacheData] unikey is null");
            return;
        }
        if (TextUtils.isEmpty(content)) {
            if (saveMode == 1) {
                QZoneCommentCacheData qZoneCommentCacheData2 = this.cacheData;
                Intrinsics.checkNotNull(qZoneCommentCacheData2);
                b(qZoneCommentCacheData2.getV4.b.UNIKEY java.lang.String());
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(atInfo)) {
            content = content + "<{@QzOnEaT@}>" + atInfo;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!f(content, currentTimeMillis, saveMode)) {
            QLog.d("QZoneCommentCacheDataHelper", 1, "[updateCacheData] not needUpdateCache");
            return;
        }
        QZoneCommentCacheData qZoneCommentCacheData3 = this.cacheData;
        Intrinsics.checkNotNull(qZoneCommentCacheData3);
        qZoneCommentCacheData3.e(content);
        QZoneCommentCacheData qZoneCommentCacheData4 = this.cacheData;
        Intrinsics.checkNotNull(qZoneCommentCacheData4);
        qZoneCommentCacheData4.f(currentTimeMillis);
        a aVar = this.cacheDataDelegate;
        QZoneCommentCacheData qZoneCommentCacheData5 = this.cacheData;
        Intrinsics.checkNotNull(qZoneCommentCacheData5);
        aVar.c(qZoneCommentCacheData5);
    }
}
