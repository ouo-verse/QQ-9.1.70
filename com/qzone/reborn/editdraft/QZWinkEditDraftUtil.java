package com.qzone.reborn.editdraft;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.publishqueue.e;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\u0017R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u0005*\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/editdraft/QZWinkEditDraftUtil;", "", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaWrapperList", "", h.F, "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "shuoshuoVideoInfo", "g", "missionIds", "", "a", "b", "Lcom/qzone/publish/business/publishqueue/e;", "Lkotlin/Lazy;", "e", "()Lcom/qzone/publish/business/publishqueue/e;", "cacheManager", "c", "d", "caCacheManager", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorDraftCleanAPI;", "()Lcom/tencent/mobileqq/wink/api/IQQWinkEditorDraftCleanAPI;", DTConstants.TAG.API, "f", "(Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;)Ljava/lang/String;", "compatMissionId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZWinkEditDraftUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final QZWinkEditDraftUtil f53839a = new QZWinkEditDraftUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy cacheManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy caCacheManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy api;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.qzone.reborn.editdraft.QZWinkEditDraftUtil$cacheManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e();
            }
        });
        cacheManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.qzone.reborn.editdraft.QZWinkEditDraftUtil$caCacheManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e("certified_account_publish_queue");
            }
        });
        caCacheManager = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<IQQWinkEditorDraftCleanAPI>() { // from class: com.qzone.reborn.editdraft.QZWinkEditDraftUtil$api$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IQQWinkEditorDraftCleanAPI invoke() {
                return (IQQWinkEditorDraftCleanAPI) QRoute.api(IQQWinkEditorDraftCleanAPI.class);
            }
        });
        api = lazy3;
    }

    QZWinkEditDraftUtil() {
    }

    @JvmStatic
    public static final void a(List<String> missionIds) {
        Intrinsics.checkNotNullParameter(missionIds, "missionIds");
        f53839a.c().deleteQZoneDraft(missionIds);
    }

    private final IQQWinkEditorDraftCleanAPI c() {
        return (IQQWinkEditorDraftCleanAPI) api.getValue();
    }

    private final e d() {
        return (e) caCacheManager.getValue();
    }

    private final e e() {
        return (e) cacheManager.getValue();
    }

    private final String f(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        String str = shuoshuoVideoInfo.mProcessMissionID;
        return str == null ? shuoshuoVideoInfo.getEditDraftMissionId() : str;
    }

    public final List<String> b() {
        List<String> plus;
        ArrayList<IQueueTask> b16 = e().b();
        Intrinsics.checkNotNullExpressionValue(b16, "cacheManager.allTasks");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            List<String> editMissionId = ((IQueueTask) it.next()).getEditMissionId();
            Intrinsics.checkNotNullExpressionValue(editMissionId, "it.editMissionId");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, editMissionId);
        }
        ArrayList<IQueueTask> b17 = d().b();
        Intrinsics.checkNotNullExpressionValue(b17, "caCacheManager.allTasks");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = b17.iterator();
        while (it5.hasNext()) {
            List<String> editMissionId2 = ((IQueueTask) it5.next()).getEditMissionId();
            Intrinsics.checkNotNullExpressionValue(editMissionId2, "it.editMissionId");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, editMissionId2);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        RFWLog.d("QZWinkEditDraftUtil", RFWLog.USR, "getAllEditDraftMissionId, ret:" + plus);
        return plus;
    }

    @JvmStatic
    public static final List<String> g(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        List<String> emptyList;
        List<String> emptyList2;
        if (shuoshuoVideoInfo == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        String f16 = f53839a.f(shuoshuoVideoInfo);
        if (f16 == null || f16.length() == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f16);
        return arrayList;
    }

    @JvmStatic
    public static final List<String> h(List<? extends MediaWrapper> mediaWrapperList) {
        String str;
        List<String> emptyList;
        if (mediaWrapperList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaWrapper mediaWrapper : mediaWrapperList) {
            if (mediaWrapper != null && mediaWrapper.isVideo()) {
                ShuoshuoVideoInfo videoInfo = mediaWrapper.getVideoInfo();
                if (videoInfo != null) {
                    QZWinkEditDraftUtil qZWinkEditDraftUtil = f53839a;
                    Intrinsics.checkNotNullExpressionValue(videoInfo, "videoInfo");
                    str = qZWinkEditDraftUtil.f(videoInfo);
                } else {
                    str = null;
                }
                if (!(str == null || str.length() == 0)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
