package com.tencent.qqnt.aio.helper;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0007R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/helper/au;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "c", "e", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "uinType", "b", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class au implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/au$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
                au.this.c(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(MsgIntent i3) {
        if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
            e();
        }
    }

    private final void e() {
        String str;
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        SessionInfo a16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (a16 = su3.b.a(g16)) == null || (str = b(a16.f179555d)) == null) {
            str = "";
        }
        String str2 = str;
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (e16 = aVar2.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, null, null, str2, "5")));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350656n0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "FriendVerifySubTitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Intrinsics.checkNotNull(a16);
        a16.e().d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleRequestEvent.class).getQualifiedName(), this.mAction1);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.SubTitleRequestEvent.class).getQualifiedName(), this.mAction1);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            onDestroy();
        }
    }

    public final String b(int uinType) {
        if (uinType == 1022) {
            return HardCodeUtil.qqStr(R.string.f9e);
        }
        return null;
    }
}
