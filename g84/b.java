package g84;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.brand.list.data.db.ZplanBrandStoreEntity;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import g84.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r84.ZootopiaBrandMallListData;
import uv4.p;
import yb4.k;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001c\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lg84/b;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lr84/b;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "needHeaderCards", "l", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lyb4/k;", "b", "Lyb4/k;", "service", "Lcom/tencent/sqshow/zootopia/database/ZplanDataBaseHelper;", "c", "Lcom/tencent/sqshow/zootopia/database/ZplanDataBaseHelper;", "dataBaseHelper", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final k service;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ZplanDataBaseHelper dataBaseHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"g84/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/p;", "result", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g84.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10365b implements e<p> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e<ZootopiaBrandMallListData> f401542d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f401543e;

        C10365b(e<ZootopiaBrandMallListData> eVar, b bVar) {
            this.f401542d = eVar;
            this.f401543e = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, p result) {
            ZplanDataBaseHelper zplanDataBaseHelper;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            if (this$0.dataBaseHelper == null) {
                this$0.dataBaseHelper = ZplanDataBaseHelper.h();
            }
            ZplanDataBaseHelper zplanDataBaseHelper2 = this$0.dataBaseHelper;
            if (zplanDataBaseHelper2 != null) {
                zplanDataBaseHelper2.c(ZplanBrandStoreEntity.class.getSimpleName());
            }
            ZplanBrandStoreEntity a16 = ZplanBrandStoreEntity.INSTANCE.a(result);
            if (a16 == null || (zplanDataBaseHelper = this$0.dataBaseHelper) == null) {
                return;
            }
            zplanDataBaseHelper.i(a16);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final p result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f401542d.onResultSuccess(k.INSTANCE.a(result));
            final b bVar = this.f401543e;
            ThreadManagerV2.excute(new Runnable() { // from class: g84.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.C10365b.c(b.this, result);
                }
            }, 32, null, true);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f401542d.onResultFailure(error, message);
        }
    }

    public b(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.service = new k(ZootopiaSource.INSTANCE.j(source));
    }

    public final void l(boolean needHeaderCards, e<ZootopiaBrandMallListData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.service.a(needHeaderCards, new C10365b(callback, this));
    }

    public final void m(e<ZootopiaBrandMallListData> callback) {
        Object obj;
        List<? extends Entity> k3;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(callback, "callback");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dataBaseHelper == null) {
            this.dataBaseHelper = ZplanDataBaseHelper.h();
        }
        ZplanDataBaseHelper zplanDataBaseHelper = this.dataBaseHelper;
        if (zplanDataBaseHelper == null || (k3 = zplanDataBaseHelper.k(ZplanBrandStoreEntity.class)) == null) {
            obj = null;
        } else {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) k3);
            obj = (Entity) firstOrNull;
        }
        ZplanBrandStoreEntity zplanBrandStoreEntity = obj instanceof ZplanBrandStoreEntity ? (ZplanBrandStoreEntity) obj : null;
        if (zplanBrandStoreEntity != null) {
            p b16 = ZplanBrandStoreEntity.INSTANCE.b(zplanBrandStoreEntity);
            if (b16 != null) {
                ZootopiaBrandMallListData a16 = k.INSTANCE.a(b16);
                QLog.i("ZplanBrandStoreRepository", 1, "getBrandMallInfoListFromCache costTime = " + (System.currentTimeMillis() - currentTimeMillis));
                callback.onResultSuccess(a16);
                return;
            }
            callback.onResultFailure(-99901, "");
            return;
        }
        callback.onResultFailure(-99902, "");
    }
}
