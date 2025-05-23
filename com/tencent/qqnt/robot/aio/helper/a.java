package com.tencent.qqnt.robot.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.aio.helper.cw;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import su3.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/robot/aio/helper/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "a", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Ljava/lang/String;", "mRobotUid", "f", "mRobotUin", "", h.F, "Z", "mIsFirstResume", "<init>", "()V", "i", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class a implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mRobotUid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mRobotUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstResume = true;

    private final void a() {
        this.mRobotUid = "";
        this.mRobotUin = "";
    }

    private final void b() {
        if (this.mIsFirstResume) {
            this.mIsFirstResume = false;
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            com.tencent.aio.api.runtime.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            String g16 = aVar.g().r().c().g();
            String str = this.mRobotUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRobotUin");
                str = null;
            }
            if (ac.v0(g16, str)) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            String str2 = this.mRobotUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRobotUin");
                str2 = null;
            }
            String g17 = ac.g(qQAppInterface, str2, true);
            Intrinsics.checkNotNullExpressionValue(g17, "getBuddyName(it, mRobotUin, true)");
            String str3 = this.mRobotUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRobotUin");
                str3 = null;
            }
            if (ac.v0(g17, str3)) {
                com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar2 = aVar3;
                }
                aVar2.e().h(new AIOTitleEvent.TitleResponseEvent(4, g17));
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.F0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "RobotTitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mIsFirstResume = true;
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mRobotUid = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        this.mRobotUin = c.b(g16);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            b();
        } else {
            if (state != 12) {
                return;
            }
            a();
        }
    }
}
