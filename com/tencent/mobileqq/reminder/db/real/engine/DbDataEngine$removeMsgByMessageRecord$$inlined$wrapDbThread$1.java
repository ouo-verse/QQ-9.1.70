package com.tencent.mobileqq.reminder.db.real.engine;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.db.b;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/reminder/db/ExtKt$wrapDbThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class DbDataEngine$removeMsgByMessageRecord$$inlined$wrapDbThread$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f281051d;
    final /* synthetic */ DbDataEngine this$0;

    @Override // java.lang.Runnable
    public final void run() {
        EntityManager e16;
        Integer num;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            e16 = this.this$0.e();
            if (e16 != null) {
                str = this.this$0.operationTableName;
                num = Integer.valueOf(e16.delete(str, "uniseq=?", new String[]{String.valueOf(this.f281051d.getUniseq())}));
            } else {
                num = null;
            }
            com.tencent.mobileqq.reminder.db.a.i("DbDataEngine", "removeMsgByMessageRecord messageRecord -> " + this.f281051d.getUniseq() + " result -> " + num, null, 4, null);
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
