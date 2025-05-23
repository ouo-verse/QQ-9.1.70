package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.IQZWinkEditDraftApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/QZoneWEDBatchDeleteStrategy;", "Lcom/tencent/mobileqq/wink/editdraft/d;", "", "a", "", "g", "", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lcooperation/qzone/api/IQZWinkEditDraftApi;", "k", "Lkotlin/Lazy;", "o", "()Lcooperation/qzone/api/IQZWinkEditDraftApi;", "qzDraftApi", "f", "()Ljava/lang/String;", "logTag", "<init>", "()V", "l", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneWEDBatchDeleteStrategy extends d {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qzDraftApi;

    public QZoneWEDBatchDeleteStrategy() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQZWinkEditDraftApi>() { // from class: com.tencent.mobileqq.wink.editdraft.QZoneWEDBatchDeleteStrategy$qzDraftApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQZWinkEditDraftApi invoke() {
                return (IQZWinkEditDraftApi) QRoute.api(IQZWinkEditDraftApi.class);
            }
        });
        this.qzDraftApi = lazy;
    }

    private final IQZWinkEditDraftApi o() {
        return (IQZWinkEditDraftApi) this.qzDraftApi.getValue();
    }

    @Override // com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    @NotNull
    public String a() {
        return "QZONE";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d, com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    @NotNull
    /* renamed from: f */
    public String getLogTag() {
        return super.getLogTag() + "_QZone";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    public boolean g() {
        return e.f318514a.e();
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    public int i() {
        return e.f318514a.b() * 1048576;
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    @NotNull
    public List<String> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.j());
        if (e.f318514a.f()) {
            arrayList.addAll(b());
        }
        QLog.d(getLogTag(), 1, "getDraftKeyBusinessPrefix, ret:" + arrayList);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.editdraft.d
    @NotNull
    public List<String> m() {
        List<String> distinct;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.m());
        List<String> allEditDraftMissionId = o().getAllEditDraftMissionId();
        Intrinsics.checkNotNullExpressionValue(allEditDraftMissionId, "qzDraftApi.allEditDraftMissionId");
        arrayList.addAll(allEditDraftMissionId);
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        QLog.d(getLogTag(), 1, "getUsableMissionIds, ret:" + distinct);
        return distinct;
    }
}
