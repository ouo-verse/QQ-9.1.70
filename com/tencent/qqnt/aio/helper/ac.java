package com.tencent.qqnt.aio.helper;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotStoryBoardApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001a\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ac;", "Lcom/tencent/aio/main/businesshelper/h;", "", "uin", "", tl.h.F, "Landroid/os/Message;", "msg", "i", "c", "e", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "peerUid", "Lcom/tencent/aio/main/businesshelper/b;", "helpParam", "com/tencent/qqnt/aio/helper/ac$c", "f", "Lcom/tencent/qqnt/aio/helper/ac$c;", "friendListObserver", "Lmqq/app/AppRuntime;", "g", "()Lmqq/app/AppRuntime;", "app", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ac implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String peerUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helpParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c friendListObserver = new c();

    private final void c() {
        if (g() instanceof AppInterface) {
            AppRuntime g16 = g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) g16).addObserver(this.friendListObserver);
            AppRuntime g17 = g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) g17).setHandler(ac.class, new b());
        }
    }

    private final void e() {
        if (g() instanceof AppInterface) {
            AppRuntime g16 = g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) g16).removeObserver(this.friendListObserver);
            AppRuntime g17 = g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) g17).removeHandler(ac.class);
        }
    }

    private final AppRuntime g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Message msg2) {
        if (msg2.what == 16711681) {
            Object obj = msg2.obj;
            h(obj instanceof String ? (String) obj : null);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.S;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "C2CResignHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helpParam = param;
        this.peerUid = param.a().g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ac$b", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends MqqHandler {
        b() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message msg2) {
            if (msg2 != null) {
                ac.this.i(msg2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/ac$c", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "", "uin", "", "onUpdateDelFriend", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.app.ar {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean isSuccess, Object uin) {
            if (isSuccess && (uin instanceof Long)) {
                ac.this.h(String.valueOf(((Number) uin).longValue()));
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String uin) {
        if (uin == null || uin.length() == 0) {
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (QLog.isColorLevel()) {
            QLog.d("C2CResignHelper", 2, "onUpdateDelFriend exit ChatActivity now uin = " + uin + ", uid = " + uidFromUin);
        }
        if (TextUtils.isEmpty(uidFromUin)) {
            return;
        }
        String str = this.peerUid;
        com.tencent.aio.main.businesshelper.b bVar = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUid");
            str = null;
        }
        if (uidFromUin.equals(str)) {
            IRobotStoryBoardApi iRobotStoryBoardApi = (IRobotStoryBoardApi) QRoute.api(IRobotStoryBoardApi.class);
            com.tencent.aio.main.businesshelper.b bVar2 = this.helpParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                bVar2 = null;
            }
            iRobotStoryBoardApi.handleDelFriend(bVar2.a());
            com.tencent.aio.main.businesshelper.b bVar3 = this.helpParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpParam");
            } else {
                bVar = bVar3;
            }
            bVar.a().e().h(new ExternalCommIntent("close_aio", new Bundle()));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            c();
        } else {
            if (state != 12) {
                return;
            }
            e();
        }
    }
}
