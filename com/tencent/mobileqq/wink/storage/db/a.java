package com.tencent.mobileqq.wink.storage.db;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.utils.aj;
import com.tencent.qphone.base.util.QLog;
import fa3.b;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007J$\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J)\u0010\u001c\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001a\"\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/storage/db/a;", "", "Landroidx/lifecycle/LiveData;", "", "Lha3/b;", "u", "", "t", "", "uin", "missionId", "v", "w", "y", "", "uploadStatus", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "publishContent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "toastStatus", "B", "D", "o", "", "missionIds", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J[Ljava/lang/String;)V", "i", "k", "l", "Lfa3/b;", "a", "Lfa3/b;", "mWinkPublishContentDao", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mWinkPublishContentDao;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            this.mWinkPublishContentDao = WinkRoomDatabase.c(context).d();
        } catch (Exception e16) {
            QLog.e("WinkPublishContentRepository", 1, "WinkPublishContentRepository init error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(a this$0, ha3.b publishContent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishContent, "$publishContent");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.b(publishContent);
        }
        fa3.a.a("WinkPublishContentRepository", "[insert] publishContent: " + publishContent + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(a this$0, long j3, String missionId, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(missionId, "$missionId");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.updateToastStatus(j3, missionId, i3);
        }
        fa3.a.a("WinkPublishContentRepository", "[updateToastStatus] missionId: " + missionId + ", toastStatus: " + i3 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(a this$0, long j3, String missionId, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(missionId, "$missionId");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.updateUploadStatus(j3, missionId, i3);
        }
        fa3.a.a("WinkPublishContentRepository", "[updateUploadStatus] missionId: " + missionId + ", uploadStatus: " + i3 + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(a this$0, long j3, List missionIds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(missionIds, "$missionIds");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.delete(j3, missionIds);
        }
        fa3.a.a("WinkPublishContentRepository", "[delete] missionIds: " + missionIds + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(a this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.deleteAll(j3);
        }
        fa3.a.a("WinkPublishContentRepository", "[deleteAll] uin: " + j3 + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.deleteAll();
        }
        fa3.a.a("WinkPublishContentRepository", "[deleteAll] cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(a this$0, long j3, String missionId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(missionId, "$missionId");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.deleteByMissionId(j3, missionId);
        }
        fa3.a.a("WinkPublishContentRepository", "[deleteByMissionId] missionId: " + missionId + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(a this$0, long j3, String[] missionIds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(missionIds, "$missionIds");
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this$0.mWinkPublishContentDao;
        if (bVar != null) {
            bVar.e(j3, missionIds);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String arrays = Arrays.toString(missionIds);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        fa3.a.a("WinkPublishContentRepository", "[deleteByMissionIds] missionIds: " + arrays + ", timeCost: " + currentTimeMillis2 + "ms");
    }

    public final void B(final long uin, @NotNull final String missionId, final int toastStatus) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.g
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.C(com.tencent.mobileqq.wink.storage.db.a.this, uin, missionId, toastStatus);
            }
        });
    }

    public final void D(final long uin, @NotNull final String missionId, final int uploadStatus) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.d
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.E(com.tencent.mobileqq.wink.storage.db.a.this, uin, missionId, uploadStatus);
            }
        });
    }

    public final void i(final long uin, @NotNull final List<String> missionIds) {
        Intrinsics.checkNotNullParameter(missionIds, "missionIds");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.h
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.j(com.tencent.mobileqq.wink.storage.db.a.this, uin, missionIds);
            }
        });
    }

    public final void k() {
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.f
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.n(com.tencent.mobileqq.wink.storage.db.a.this);
            }
        });
    }

    public final void l(final long uin) {
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.e
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.m(com.tencent.mobileqq.wink.storage.db.a.this, uin);
            }
        });
    }

    public final void o(final long uin, @NotNull final String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.j
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.p(com.tencent.mobileqq.wink.storage.db.a.this, uin, missionId);
            }
        });
    }

    public final void q(final long uin, @NotNull final String... missionIds) {
        Intrinsics.checkNotNullParameter(missionIds, "missionIds");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.i
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.r(com.tencent.mobileqq.wink.storage.db.a.this, uin, missionIds);
            }
        });
    }

    @WorkerThread
    @Nullable
    public final List<ha3.b> s() {
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.getAllDataSync();
        }
        return null;
    }

    @WorkerThread
    @Nullable
    public final List<String> t() {
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.d(aj.c());
        }
        return null;
    }

    @Nullable
    public final LiveData<List<ha3.b>> u() {
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.c(aj.c());
        }
        return null;
    }

    @Nullable
    public final LiveData<List<ha3.b>> v(long uin, @NotNull String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.g(uin, missionId);
        }
        return null;
    }

    @Nullable
    public final List<ha3.b> w(long uin, @NotNull String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.f(uin, missionId);
        }
        return null;
    }

    @WorkerThread
    @Nullable
    public final List<ha3.b> x(long uin, @NotNull int[] uploadStatus) {
        Intrinsics.checkNotNullParameter(uploadStatus, "uploadStatus");
        b bVar = this.mWinkPublishContentDao;
        if (bVar != null) {
            return bVar.getDataByUploadStatusSync(uin, uploadStatus);
        }
        return null;
    }

    @WorkerThread
    @Nullable
    public final ha3.b y(long uin) {
        try {
            b bVar = this.mWinkPublishContentDao;
            if (bVar == null) {
                return null;
            }
            return bVar.a(uin);
        } catch (Exception e16) {
            w53.b.e("WinkPublishContentRepository", e16);
            return null;
        }
    }

    public final void z(@NotNull final ha3.b publishContent) {
        Intrinsics.checkNotNullParameter(publishContent, "publishContent");
        WinkRoomDatabase.f326404b.execute(new Runnable() { // from class: fa3.k
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.wink.storage.db.a.A(com.tencent.mobileqq.wink.storage.db.a.this, publishContent);
            }
        });
    }
}
