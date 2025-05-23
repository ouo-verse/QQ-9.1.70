package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0017\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ZplanEntranceHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "com/tencent/qqnt/aio/helper/ZplanEntranceHelper$b", "f", "Lcom/tencent/qqnt/aio/helper/ZplanEntranceHelper$b;", "mZplanCallback", "Lcom/tencent/mobileqq/activity/aio/z;", tl.h.F, "Lcom/tencent/mobileqq/activity/aio/z;", "mAIOZplanEntranceHelper", "<init>", "()V", "i", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ZplanEntranceHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b mZplanCallback = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.aio.z mAIOZplanEntranceHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/qqnt/aio/helper/ZplanEntranceHelper$b", "Lcom/tencent/mobileqq/activity/aio/helper/AIOZplanEntranceHelper$c;", "", "e", "Landroid/content/Context;", "getContext", "c", "", "type", "", "value", "", "a", "Landroid/view/View;", "view", "", "d", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "checkIsShowRedTouch", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements AIOZplanEntranceHelper.c {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public void a(int type, Object value) {
            com.tencent.mvi.base.route.j e16;
            com.tencent.aio.api.runtime.a aVar = ZplanEntranceHelper.this.mAIOContext;
            if (aVar == null || (e16 = aVar.e()) == null) {
                return;
            }
            e16.h(new AIOTitleEvent.UpdateZplanEvent(type, value));
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public boolean b(BusinessInfoCheckUpdate.AppInfo appInfo, boolean checkIsShowRedTouch) {
            com.tencent.mvi.base.route.j e16;
            com.tencent.mvi.base.route.k k3;
            com.tencent.aio.api.runtime.a aVar = ZplanEntranceHelper.this.mAIOContext;
            if (aVar == null || (e16 = aVar.e()) == null || (k3 = e16.k(new AIOTitleEvent.ZplanRequestEvent(com.tencent.mobileqq.aio.utils.bb.f194129a.b(), null))) == null) {
                return false;
            }
            Object a16 = ((m.f) k3).a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) a16).booleanValue();
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public String c() {
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            com.tencent.aio.api.runtime.a aVar = ZplanEntranceHelper.this.mAIOContext;
            if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) {
                return null;
            }
            return c16.g();
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public boolean d(View view) {
            com.tencent.mvi.base.route.j e16;
            com.tencent.mvi.base.route.k k3;
            com.tencent.aio.api.runtime.a aVar = ZplanEntranceHelper.this.mAIOContext;
            if (aVar == null || (e16 = aVar.e()) == null || (k3 = e16.k(new AIOTitleEvent.ZplanRequestEvent(com.tencent.mobileqq.aio.utils.bb.f194129a.a(), null))) == null) {
                return false;
            }
            Object a16 = ((m.f) k3).a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) a16).booleanValue();
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public String e() {
            AIOParam g16;
            com.tencent.aio.api.runtime.a aVar = ZplanEntranceHelper.this.mAIOContext;
            return String.valueOf((aVar == null || (g16 = aVar.g()) == null) ? null : Long.valueOf(su3.c.a(g16)));
        }

        @Override // com.tencent.mobileqq.activity.aio.helper.AIOZplanEntranceHelper.c
        public Context getContext() {
            Context context = ZplanEntranceHelper.this.mContext;
            Intrinsics.checkNotNull(context);
            return context;
        }
    }

    private final void c() {
        com.tencent.mobileqq.activity.aio.z zVar = this.mAIOZplanEntranceHelper;
        if (zVar != null) {
            zVar.onMoveToState(5);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350658o;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ZplanEntranceHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Fragment c16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Context requireContext = (a16 == null || (c16 = a16.c()) == null) ? null : c16.requireContext();
        Intrinsics.checkNotNull(requireContext);
        this.mContext = requireContext;
        QLog.i("ZplanEntranceHelper", 1, "onCreate, mContext= " + requireContext + ", mAIOContext= " + this.mAIOContext);
        com.tencent.mobileqq.activity.aio.helper.u generateAioMiniHomeConnectedEntranceHelper = ((IMiniHomeConnectedApi) QRoute.api(IMiniHomeConnectedApi.class)).generateAioMiniHomeConnectedEntranceHelper(new ZplanEntranceHelper$onCreate$1(this.mZplanCallback), new ZplanEntranceHelper$onCreate$2(this.mZplanCallback), new ZplanEntranceHelper$onCreate$3(this.mZplanCallback), new ZplanEntranceHelper$onCreate$4(this.mZplanCallback));
        if (generateAioMiniHomeConnectedEntranceHelper == null) {
            generateAioMiniHomeConnectedEntranceHelper = new AIOZplanEntranceHelper(this.mZplanCallback);
        }
        this.mAIOZplanEntranceHelper = generateAioMiniHomeConnectedEntranceHelper;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("ZplanEntranceHelper", 1, "onMoveToState - " + state);
        if (state == 1) {
            c();
            return;
        }
        if (state == 9) {
            com.tencent.mobileqq.activity.aio.z zVar = this.mAIOZplanEntranceHelper;
            if (zVar != null) {
                zVar.onMoveToState(12);
                return;
            }
            return;
        }
        if (state != 12) {
            return;
        }
        com.tencent.mobileqq.activity.aio.z zVar2 = this.mAIOZplanEntranceHelper;
        if (zVar2 != null) {
            zVar2.onMoveToState(15);
        }
        this.mAIOZplanEntranceHelper = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{9, 1, 12};
    }
}
