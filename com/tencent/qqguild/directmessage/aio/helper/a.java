package com.tencent.qqguild.directmessage.aio.helper;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotDataApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vw1.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "i", "", "e", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "c", "b", h.F, "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mParam", "Lcom/tencent/aio/data/AIOContact;", "Lcom/tencent/aio/data/AIOContact;", "mAIOContact", "Lcom/tencent/common/app/AppInterface;", "f", "Lcom/tencent/common/app/AppInterface;", "mApp", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIOContact mAIOContact;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AppInterface mApp;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J2\u0010\u000e\u001a\u00020\u00072\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqguild/directmessage/aio/helper/a$b", "Lvw1/c;", "Lxw1/b;", "", "errCode", "", "msg", "", "onError", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dataList", "", "params", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements c<xw1.b> {
        b() {
        }

        @Override // vw1.c
        public void a(@Nullable ArrayList<xw1.b> dataList, @Nullable Object params) {
            if (params instanceof Integer) {
                ((Number) params).intValue();
            }
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNull(dataList);
            Iterator<xw1.b> it = dataList.iterator();
            while (it.hasNext()) {
                xw1.b next = it.next();
                Intrinsics.checkNotNull(next);
                arrayList.add(next.a());
            }
            AIOContact aIOContact = a.this.mAIOContact;
            if (aIOContact == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContact");
                aIOContact = null;
            }
            String g16 = aIOContact.g();
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.AIO.RobotMsgHelper", 1, "peerName = " + g16);
            }
        }

        @Override // vw1.c
        public void onError(int errCode, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("Guild.C2C.AIO.RobotMsgHelper", 2, "getRobotCommonGuilds error with errCode:" + errCode + ", msg:" + msg2);
        }
    }

    private final void b() {
        IGuildRobotDataApi iGuildRobotDataApi = (IGuildRobotDataApi) QRoute.api(IGuildRobotDataApi.class);
        AppInterface appInterface = this.mApp;
        AIOContact aIOContact = null;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        AIOContact aIOContact2 = this.mAIOContact;
        if (aIOContact2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContact");
        } else {
            aIOContact = aIOContact2;
        }
        iGuildRobotDataApi.getRobotCommonGuilds(appInterface, aIOContact.j(), new b());
    }

    private final boolean c(AIOParam aioParam) {
        if (aioParam.l().getInt(((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).getGuildDirectMsgTypeKey()) == 2) {
            return true;
        }
        return false;
    }

    private final boolean e() {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "mParam.aioContext.aioParam");
        return c(g16);
    }

    private final void g() {
        if (e()) {
            b();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 19;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "Guild.C2C.AIO.RobotMsgHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mParam = param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            param = null;
        }
        this.mAIOContact = param.a().g().r().c();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        this.mApp = (AppInterface) peekAppRuntime;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    h();
                    return;
                }
                return;
            }
            i();
            return;
        }
        g();
    }

    private final void h() {
    }

    private final void i() {
    }
}
