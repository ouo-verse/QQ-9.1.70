package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/a;", "Lcom/tencent/mobileqq/wink/editdraft/d;", "", "", "p", "o", "a", "", "g", "", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "()Ljava/lang/String;", "logTag", "<init>", "()V", "k", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends d {
    private final List<String> o() {
        int collectionSizeOrDefault;
        List<String> emptyList;
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService == null) {
            QLog.w("QCircle", 1, "getUploadingMissionIds, invalid service");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<TaskInfo> runningTasks = qfsService.getRunningTasks();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(runningTasks, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = runningTasks.iterator();
        while (it.hasNext()) {
            arrayList.add(((TaskInfo) it.next()).getMissionId());
        }
        return arrayList;
    }

    private final List<String> p() {
        ArrayList arrayList = new ArrayList();
        List<String> o16 = o();
        arrayList.addAll(o16);
        QLog.d("QCircle", 1, "getUsableMissionIdsInner, uploadingMissionIds:" + o16);
        List<String> allDraftMissionIdsSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getAllDraftMissionIdsSync();
        if (allDraftMissionIdsSync != null) {
            arrayList.addAll(allDraftMissionIdsSync);
            QLog.d("QCircle", 1, "getUsableMissionIdsInner, allDraftMissionIds:" + allDraftMissionIdsSync);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    @NotNull
    public String a() {
        return "QCIRCLE";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d, com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    @NotNull
    /* renamed from: f */
    public String getLogTag() {
        return super.getLogTag() + "_QCircle";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    public boolean g() {
        return e.f318514a.c();
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    public int i() {
        return e.f318514a.a() * 1048576;
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    @NotNull
    public String l() {
        return "key_qcircle_lastcleantime";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    @NotNull
    public List<String> m() {
        List<String> distinct;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.m());
        arrayList.addAll(p());
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        QLog.d(getLogTag(), 1, "getUsableMissionIds, ret:" + distinct);
        return distinct;
    }
}
