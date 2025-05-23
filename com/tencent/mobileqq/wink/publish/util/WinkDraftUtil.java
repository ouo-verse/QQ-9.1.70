package com.tencent.mobileqq.wink.publish.util;

import android.app.Application;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import e93.i;
import fa3.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/WinkDraftUtil;", "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkDraftUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final com.tencent.mobileqq.wink.storage.db.a f325966b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Function1<List<? extends ha3.b>, List<DraftBean>> f325967c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f325968d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/publish/util/WinkDraftUtil$a", "Lfa3/a$a;", "", "tag", "msg", "", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements a.InterfaceC10295a {
        a() {
        }

        @Override // fa3.a.InterfaceC10295a
        public void d(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, 1, msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u00011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J&\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u0012H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0002H\u0007J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0007J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J+\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u001d\"\u00020\u0010H\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0007J\b\u0010\"\u001a\u00020\u000bH\u0007J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J \u0010'\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%H\u0007J \u0010(\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020%H\u0007R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-R,\u0010/\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/WinkDraftUtil$b;", "", "", "Lha3/b;", "publishContents", "Lcom/tencent/mobileqq/winkpublish/model/DraftBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "publishContent", "p", "Lk93/c;", "parameter", "", ReportConstant.COSTREPORT_PREFIX, "r", "", "uin", "", "missionId", "Landroidx/lifecycle/LiveData;", "k", "l", h.F, DomainData.DOMAIN_NAME, "", "uploadStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "g", "e", "", "missionIds", "f", "(J[Ljava/lang/String;)V", "b", "c", "d", "o", "", "toastStatus", "t", "u", "Lcom/tencent/mobileqq/wink/storage/db/a;", "REPOSITORY", "Lcom/tencent/mobileqq/wink/storage/db/a;", "TAG", "Ljava/lang/String;", "Lkotlin/Function1;", "sBeansConverter", "Lkotlin/jvm/functions/Function1;", "com/tencent/mobileqq/wink/publish/util/WinkDraftUtil$a", "sLogInf", "Lcom/tencent/mobileqq/wink/publish/util/WinkDraftUtil$a;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.util.WinkDraftUtil$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List i(Function1 tmp0, List list) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (List) tmp0.invoke(list);
        }

        @JvmStatic
        public final void b(long uin, @NotNull List<String> missionIds) {
            Intrinsics.checkNotNullParameter(missionIds, "missionIds");
            w53.b.f("[PublishUpload]WinkDraftUtil", "delete missionIds:" + missionIds);
            WinkDraftUtil.f325966b.i(uin, missionIds);
        }

        @JvmStatic
        public final void c() {
            WinkDraftUtil.f325966b.k();
        }

        @JvmStatic
        public final void d(long uin) {
            WinkDraftUtil.f325966b.l(uin);
        }

        @JvmStatic
        public final void e(long uin, @NotNull String missionId) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            w53.b.f("[PublishUpload]WinkDraftUtil", "deleteByMissionId missionId:" + missionId);
            WinkDraftUtil.f325966b.o(uin, missionId);
        }

        @JvmStatic
        public final void f(long uin, @NotNull String... missionIds) {
            Intrinsics.checkNotNullParameter(missionIds, "missionIds");
            String arrays = Arrays.toString(missionIds);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            w53.b.f("[PublishUpload]WinkDraftUtil", "deleteByMissionIds missionIds:" + arrays);
            WinkDraftUtil.f325966b.q(uin, (String[]) Arrays.copyOf(missionIds, missionIds.length));
        }

        @JvmStatic
        @WorkerThread
        @Nullable
        public final List<DraftBean> g() {
            List<ha3.b> s16 = WinkDraftUtil.f325966b.s();
            if (s16 != null) {
                return WinkDraftUtil.INSTANCE.q(s16);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final LiveData<List<DraftBean>> h() {
            LiveData<List<DraftBean>> liveData;
            List emptyList;
            LiveData<List<ha3.b>> u16 = WinkDraftUtil.f325966b.u();
            if (u16 != null) {
                final Function1 function1 = WinkDraftUtil.f325967c;
                liveData = Transformations.map(u16, new Function() { // from class: com.tencent.mobileqq.wink.publish.util.a
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        List i3;
                        i3 = WinkDraftUtil.Companion.i(Function1.this, (List) obj);
                        return i3;
                    }
                });
            } else {
                liveData = null;
            }
            if (liveData == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new MutableLiveData(emptyList);
            }
            return liveData;
        }

        @JvmStatic
        @WorkerThread
        @Nullable
        public final List<String> j() {
            return WinkDraftUtil.f325966b.t();
        }

        @JvmStatic
        @Nullable
        public final LiveData<List<ha3.b>> k(long uin, @NotNull String missionId) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            return WinkDraftUtil.f325966b.v(uin, missionId);
        }

        @JvmStatic
        @Nullable
        public final List<ha3.b> l(long uin, @NotNull String missionId) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            try {
                return WinkDraftUtil.f325966b.w(uin, missionId);
            } catch (Exception e16) {
                w53.b.e("[PublishUpload]WinkDraftUtil", e16);
                return null;
            }
        }

        @JvmStatic
        @WorkerThread
        @Nullable
        public final List<DraftBean> m(long uin, @NotNull int[] uploadStatus) {
            Intrinsics.checkNotNullParameter(uploadStatus, "uploadStatus");
            List<ha3.b> x16 = WinkDraftUtil.f325966b.x(uin, uploadStatus);
            if (x16 != null) {
                return WinkDraftUtil.INSTANCE.q(x16);
            }
            return null;
        }

        @JvmStatic
        @WorkerThread
        @Nullable
        public final DraftBean n(long uin) {
            return p(WinkDraftUtil.f325966b.y(uin));
        }

        @JvmStatic
        public final void o(@NotNull ha3.b publishContent) {
            Intrinsics.checkNotNullParameter(publishContent, "publishContent");
            WinkDraftUtil.f325966b.z(publishContent);
        }

        @JvmStatic
        @Nullable
        public final DraftBean p(@Nullable ha3.b publishContent) {
            boolean z16;
            String str;
            int i3 = 1;
            QLog.i("[PublishUpload]WinkDraftUtil", 1, "[publishContent2DraftBean] publishContent: " + publishContent);
            if (publishContent == null) {
                return null;
            }
            DraftBean draftBean = new DraftBean();
            draftBean.setMissionId(publishContent.f404620e);
            draftBean.setContent(publishContent.f404619d);
            draftBean.setUploadStatus(publishContent.f404626k);
            draftBean.setToastStatus(publishContent.f404627l);
            draftBean.setClientKey(publishContent.f404628m);
            draftBean.setClientTraceId(publishContent.f404634s);
            List<String> list = publishContent.f404621f;
            Map<String, LocalMediaInfo> map = publishContent.f404622g;
            if (list != null && map != null && (!list.isEmpty())) {
                draftBean.setVideoCount(list.size());
                LocalMediaInfo localMediaInfo = map.get(list.get(0));
                if (localMediaInfo != null) {
                    String str2 = localMediaInfo.thumbnailPath;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        str = localMediaInfo.thumbnailPath;
                    } else {
                        str = localMediaInfo.path;
                    }
                    draftBean.setCoverUrl(str);
                    if (i.G(localMediaInfo)) {
                        i3 = 0;
                    } else if (!i.I(localMediaInfo)) {
                        i3 = -1;
                    }
                    draftBean.setMediaType(i3);
                }
                Collection<LocalMediaInfo> values = map.values();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    Iterable iterable = ((LocalMediaInfo) it.next()).mOriginPath;
                    if (iterable == null) {
                        iterable = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(iterable, "it.mOriginPath ?: emptyList()");
                    }
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
                }
                draftBean.setOriginPath(arrayList);
            }
            draftBean.setTaskId(publishContent.f404633r);
            draftBean.setCreateTime(publishContent.f404624i);
            return draftBean;
        }

        @JvmStatic
        @NotNull
        public final List<DraftBean> q(@NotNull List<? extends ha3.b> publishContents) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(publishContents, "publishContents");
            List<? extends ha3.b> list = publishContents;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                DraftBean p16 = WinkDraftUtil.INSTANCE.p((ha3.b) it.next());
                if (p16 == null) {
                    p16 = new DraftBean();
                }
                arrayList.add(p16);
            }
            return arrayList;
        }

        @JvmStatic
        public final void r(@Nullable ha3.b publishContent) {
            QLog.d("[PublishUpload]WinkDraftUtil", 1, "savePublishContent, parameter: " + publishContent);
            if (publishContent != null) {
                WinkDraftUtil.INSTANCE.o(publishContent);
            }
        }

        @JvmStatic
        public final void s(@Nullable k93.c parameter) {
            QLog.d("[PublishUpload]WinkDraftUtil", 1, "savePublishContent, parameter: " + parameter);
            if (parameter != null) {
                ha3.b publishContent = parameter.h();
                Companion companion = WinkDraftUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(publishContent, "publishContent");
                companion.o(publishContent);
            }
        }

        @JvmStatic
        public final void t(long uin, @NotNull String missionId, int toastStatus) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            WinkDraftUtil.f325966b.B(uin, missionId, toastStatus);
        }

        @JvmStatic
        public final void u(long uin, @NotNull String missionId, int uploadStatus) {
            Intrinsics.checkNotNullParameter(missionId, "missionId");
            WinkDraftUtil.f325966b.D(uin, missionId, uploadStatus);
        }

        Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        f325966b = new com.tencent.mobileqq.wink.storage.db.a(application);
        f325967c = new WinkDraftUtil$Companion$sBeansConverter$1(companion);
        a aVar = new a();
        f325968d = aVar;
        fa3.a.b(aVar);
    }

    @JvmStatic
    public static final void c(long j3, @NotNull List<String> list) {
        INSTANCE.b(j3, list);
    }

    @JvmStatic
    public static final void d() {
        INSTANCE.c();
    }

    @JvmStatic
    public static final void e(long j3) {
        INSTANCE.d(j3);
    }

    @JvmStatic
    public static final void f(long j3, @NotNull String str) {
        INSTANCE.e(j3, str);
    }

    @JvmStatic
    public static final void g(long j3, @NotNull String... strArr) {
        INSTANCE.f(j3, strArr);
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final List<DraftBean> h() {
        return INSTANCE.g();
    }

    @JvmStatic
    @NotNull
    public static final LiveData<List<DraftBean>> i() {
        return INSTANCE.h();
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final List<String> j() {
        return INSTANCE.j();
    }

    @JvmStatic
    @Nullable
    public static final LiveData<List<ha3.b>> k(long j3, @NotNull String str) {
        return INSTANCE.k(j3, str);
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final List<DraftBean> l(long j3, @NotNull int[] iArr) {
        return INSTANCE.m(j3, iArr);
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final DraftBean m(long j3) {
        return INSTANCE.n(j3);
    }

    @JvmStatic
    public static final void n(@Nullable k93.c cVar) {
        INSTANCE.s(cVar);
    }

    @JvmStatic
    public static final void o(long j3, @NotNull String str, int i3) {
        INSTANCE.t(j3, str, i3);
    }

    @JvmStatic
    public static final void p(long j3, @NotNull String str, int i3) {
        INSTANCE.u(j3, str, i3);
    }
}
