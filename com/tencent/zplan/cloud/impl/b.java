package com.tencent.zplan.cloud.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import dx4.d;
import dx4.e;
import ex4.LocalRecordDoneResult;
import ex4.LocalRecordFailedResult;
import ex4.LocalRecordStartResult;
import ix4.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u000e\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J2\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0005H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/zplan/cloud/impl/b;", "", "", "Lix4/k;", "result", "Ldx4/d;", "cloudRecordListener", "", "g", "([Lix4/k;Ldx4/d;)V", "", "startUserTaskList", "f", "doneUserTaskList", "d", "failedUserTaskList", "e", "", "appearanceKey", "Lgx4/a;", "avatarCharacter", "", "recordScene", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "listener", "c", "Lkx4/b;", "a", "Lkx4/b;", "cloudRecordService", "<init>", "()V", "b", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final kx4.b cloudRecordService = new kx4.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/zplan/cloud/impl/b$b", "Lkx4/a;", "", "Lix4/k;", "result", "", "a", "([Lix4/k;)V", "", "error", "", "message", "onResultFailure", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.cloud.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10051b implements kx4.a<k[]> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f385264b;

        C10051b(d dVar) {
            this.f385264b = dVar;
        }

        @Override // kx4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(@NotNull k[] result) {
            Intrinsics.checkNotNullParameter(result, "result");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "LocalRecordTaskImpl", 1, "recordActionByCloud success :: result size == " + result.length, null, 8, null);
            }
            b.this.g(result, this.f385264b);
        }

        @Override // kx4.a
        public void onResultFailure(int error, @Nullable String message) {
            List<LocalRecordFailedResult> emptyList;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "LocalRecordTaskImpl", 1, "recordActionByCloud failed :: error == " + error + " , message == " + message, null, 8, null);
            }
            dx4.d dVar = this.f385264b;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (message == null) {
                message = "";
            }
            dVar.a(emptyList, error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/zplan/cloud/impl/b$c", "Ldx4/e;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "uploadUrl", "", "a", "", "errorCode", "errorMessage", "b", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements e {
        c() {
        }

        @Override // dx4.e
        public void a(@NotNull String taskId, @NotNull String uploadUrl) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(uploadUrl, "uploadUrl");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", taskId);
            jSONObject.put("status", 0);
            jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, uploadUrl);
            kx4.b bVar = b.this.cloudRecordService;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "bizInfo.toString()");
            bVar.g(taskId, 0, uploadUrl, "", jSONObject2);
        }

        @Override // dx4.e
        public void b(@NotNull String taskId, int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", taskId);
            jSONObject.put("status", errorCode);
            jSONObject.put("errMsg", errorMessage);
            b.this.cloudRecordService.g(taskId, errorCode, "", errorMessage, "");
        }
    }

    private final void d(List<k> doneUserTaskList, dx4.d cloudRecordListener) {
        ArrayList arrayList = new ArrayList();
        for (k kVar : doneUserTaskList) {
            MemeZPlanAction e16 = ex4.a.f397351b.e(new JSONObject(kVar.f408953d.f408938a));
            String str = kVar.f408950a;
            Intrinsics.checkNotNullExpressionValue(str, "userRecordTask.taskId");
            String str2 = kVar.f408967r;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.result");
            String str3 = kVar.f408961l;
            Intrinsics.checkNotNullExpressionValue(str3, "userRecordTask.taskHash");
            long j3 = kVar.f408971v;
            int i3 = kVar.f408972w;
            String str4 = kVar.B;
            Intrinsics.checkNotNullExpressionValue(str4, "userRecordTask.appearanceKeySaved");
            String str5 = kVar.C;
            Intrinsics.checkNotNullExpressionValue(str5, "userRecordTask.appearanceKeyNewSaved");
            arrayList.add(new LocalRecordDoneResult(str, e16, str2, str3, j3, i3, str4, str5));
        }
        if (!arrayList.isEmpty()) {
            cloudRecordListener.b(arrayList);
        }
    }

    private final void e(List<k> failedUserTaskList, dx4.d cloudRecordListener) {
        ArrayList arrayList = new ArrayList();
        for (k kVar : failedUserTaskList) {
            MemeZPlanAction e16 = ex4.a.f397351b.e(new JSONObject(kVar.f408953d.f408938a));
            String str = kVar.f408950a;
            Intrinsics.checkNotNullExpressionValue(str, "userRecordTask.taskId");
            int i3 = kVar.f408965p;
            String str2 = kVar.f408966q;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.errorMsg");
            arrayList.add(new LocalRecordFailedResult(str, e16, i3, str2));
        }
        if (!arrayList.isEmpty()) {
            cloudRecordListener.a(arrayList, -10, "some error exist in list");
        }
    }

    private final void f(List<k> startUserTaskList, dx4.d cloudRecordListener) {
        ArrayList arrayList = new ArrayList();
        for (k kVar : startUserTaskList) {
            MemeZPlanAction e16 = ex4.a.f397351b.e(new JSONObject(kVar.f408953d.f408938a));
            String str = kVar.f408950a;
            Intrinsics.checkNotNullExpressionValue(str, "userRecordTask.taskId");
            String str2 = kVar.f408961l;
            Intrinsics.checkNotNullExpressionValue(str2, "userRecordTask.taskHash");
            String str3 = kVar.A;
            Intrinsics.checkNotNullExpressionValue(str3, "userRecordTask.uploadFilePath");
            arrayList.add(new LocalRecordStartResult(str, e16, str2, str3, kVar.f408973z));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        cloudRecordListener.c(arrayList, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(k[] result, dx4.d cloudRecordListener) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (k kVar : result) {
            int i3 = kVar.f408970u;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        arrayList3.add(kVar);
                    }
                } else {
                    arrayList2.add(kVar);
                }
            } else {
                arrayList.add(kVar);
            }
        }
        d(arrayList2, cloudRecordListener);
        f(arrayList, cloudRecordListener);
        e(arrayList3, cloudRecordListener);
    }

    public void c(@NotNull String appearanceKey, @Nullable gx4.a avatarCharacter, int recordScene, @NotNull MemeZPlanBaseAction action, @NotNull dx4.d listener) {
        String str;
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "LocalRecordTaskImpl", 1, "createLocalTask :: start , action == " + action, null, 8, null);
        }
        String d16 = ex4.a.f397351b.d(action);
        kx4.b bVar = this.cloudRecordService;
        k kVar = new k();
        if (avatarCharacter != null) {
            kVar.f408952c = 3;
            kVar.f408960k = avatarCharacter;
        } else {
            kVar.f408952c = 1;
        }
        ix4.e eVar = new ix4.e();
        eVar.f408938a = d16;
        Unit unit = Unit.INSTANCE;
        kVar.f408953d = eVar;
        kVar.f408951b = recordScene;
        yx4.c cVar = (yx4.c) mx4.a.f417748a.a(yx4.c.class);
        if (cVar == null || (str = cVar.getZPlanVersion()) == null) {
            str = "";
        }
        kVar.f408959j = str;
        kVar.f408957h = appearanceKey;
        bVar.a(kVar, new C10051b(listener));
    }
}
