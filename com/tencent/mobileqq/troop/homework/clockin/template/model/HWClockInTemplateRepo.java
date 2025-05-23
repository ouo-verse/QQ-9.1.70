package com.tencent.mobileqq.troop.homework.clockin.template.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/model/HWClockInTemplateRepo;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTemplateListRsp;", "rsp", "", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/a;", "g", "", "isMore", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/c;", h.F, "a", "Z", "isLoading", "", "b", "I", "pageSize", "c", "curPage", "<init>", "()V", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInTemplateRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isLoading;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int pageSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int curPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/model/HWClockInTemplateRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.template.model.HWClockInTemplateRepo$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInTemplateRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pageSize = 20;
            this.curPage = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<a> g(GroupSchoolTemplateListRsp rsp) {
        ArrayList<GroupSchoolTemplateData> arrayList;
        int collectionSizeOrDefault;
        if (rsp != null && (arrayList = rsp.datas) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (GroupSchoolTemplateData groupSchoolTemplateData : arrayList) {
                String str = groupSchoolTemplateData.f359184id;
                Intrinsics.checkNotNullExpressionValue(str, "it.id");
                String str2 = groupSchoolTemplateData.title;
                Intrinsics.checkNotNullExpressionValue(str2, "it.title");
                String str3 = groupSchoolTemplateData.content;
                Intrinsics.checkNotNullExpressionValue(str3, "it.content");
                arrayList2.add(new a(str, str2, str3, null, 8, null));
            }
            return arrayList2;
        }
        return new ArrayList();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<c> h(boolean isMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this, isMore);
        }
        return FlowKt.callbackFlow(new HWClockInTemplateRepo$loadData$1(this, isMore, null));
    }
}
