package com.tencent.mobileqq.troop.homework.handler;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.troop.utils.f;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "psKey", "", IPublicAccountDetailReportUtil.KEY_SEARCH, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class HomeworkCourseHandler$executeCgiTask$1 extends Lambda implements Function2<String, String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppInterface $appInterface;
    final /* synthetic */ Function2<Boolean, TroopHwCourseMgrRsp, Unit> $callback;
    final /* synthetic */ com.tencent.mobileqq.troop.homework.coursemgr.repo.a $req;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeworkCourseHandler$executeCgiTask$1(com.tencent.mobileqq.troop.homework.coursemgr.repo.a aVar, AppInterface appInterface, Function2<? super Boolean, ? super TroopHwCourseMgrRsp, Unit> function2) {
        super(2);
        this.$req = aVar;
        this.$appInterface = appInterface;
        this.$callback = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, appInterface, function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.mobileqq.troop.homework.coursemgr.repo.a req, Function2 callback, JSONObject jSONObject, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("HomeworkCourseHandler", 1, "[manageCourse] type = " + req.b() + " result = " + jSONObject);
        try {
            if (jSONObject == null) {
                callback.invoke(Boolean.FALSE, null);
                return;
            }
            TroopHwCourseMgrRsp a16 = TroopHwCourseMgrRsp.INSTANCE.a(jSONObject);
            if (a16.getRetCode() == 0) {
                callback.invoke(Boolean.TRUE, a16);
            } else {
                callback.invoke(Boolean.FALSE, null);
            }
        } catch (Exception e16) {
            QLog.i("HomeworkCourseHandler", 1, "[manageCourse] TroopHwCourseMgrRsp parse error e = " + e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable String str, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.mobileqq.troop.homework.coursemgr.repo.a aVar = this.$req;
        AppInterface appInterface = this.$appInterface;
        hashMap.put("BUNDLE", aVar.c(appInterface, str, str2));
        hashMap.put("CONTEXT", appInterface.getApp().getApplicationContext());
        final com.tencent.mobileqq.troop.homework.coursemgr.repo.a aVar2 = this.$req;
        final Function2<Boolean, TroopHwCourseMgrRsp, Unit> function2 = this.$callback;
        new f("https://qun.qq.com/cgi-bin/homework/hw/course_mgr.fcg", "POST", new e.a() { // from class: com.tencent.mobileqq.troop.homework.handler.a
            @Override // com.tencent.mobileqq.troop.utils.e.a
            public final void rg(JSONObject jSONObject, int i3, Bundle bundle) {
                HomeworkCourseHandler$executeCgiTask$1.b(com.tencent.mobileqq.troop.homework.coursemgr.repo.a.this, function2, jSONObject, i3, bundle);
            }
        }, 0, null).b(hashMap);
    }
}
