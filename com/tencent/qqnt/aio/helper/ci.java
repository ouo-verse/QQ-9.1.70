package com.tencent.qqnt.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001\u0015\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ci;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "Lcom/tencent/common/app/AppInterface;", "e", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/qqnt/aio/helper/ci$b", "Lcom/tencent/qqnt/aio/helper/ci$b;", "rpObserver", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ci implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b rpObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ci$b", "Lcom/tencent/mobileqq/tianshu/observer/RedpointObserver;", "", "isSucc", "", "onDataChange", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RedpointObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean isSucc) {
            com.tencent.mvi.base.route.j e16;
            if (ci.this.mAIOContext == null) {
                return;
            }
            QLog.i("NTPanelIconRedDotHelper", 1, "onDataChange: " + isSucc);
            com.tencent.aio.api.runtime.a aVar = ci.this.mAIOContext;
            if (aVar == null || (e16 = aVar.e()) == null) {
                return;
            }
            e16.h(PlusPanelEvent.FetchPlusPanelAppList.f360439d);
        }
    }

    private final void c() {
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Integer valueOf = (aVar == null || (g16 = aVar.g()) == null) ? null : Integer.valueOf(com.tencent.guild.aio.util.a.e(g16));
        if (valueOf != null && valueOf.intValue() == 1) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026), QMMKVFile.FILE_COMMON)");
            AppInterface e16 = e();
            String currentAccountUin = e16 != null ? e16.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            if (from.decodeBool("HOT_PIC_KEY_FIRST_" + currentAccountUin, false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("NTPanelIconRedDotHelper", 2, "isAlready prepareHotPicData");
                    return;
                }
                return;
            }
            Manager hotPicManager = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getHotPicManager();
            HotPicManager hotPicManager2 = hotPicManager instanceof HotPicManager ? (HotPicManager) hotPicManager : null;
            if (hotPicManager2 != null) {
                hotPicManager2.w();
            }
            from.encodeBool("HOT_PIC_KEY_FIRST_" + currentAccountUin, true);
            QLog.d("NTPanelIconRedDotHelper", 1, "isAlready prepareHotPicData");
        }
    }

    private final AppInterface e() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ci this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101124");
        this$0.c();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350674t0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "NTPanelIconRedDotHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        AppInterface e16;
        if (state != 4) {
            if (state == 12 && (e16 = e()) != null) {
                e16.removeObserver(this.rpObserver);
                return;
            }
            return;
        }
        AppInterface e17 = e();
        if (e17 != null) {
            e17.addObserver(this.rpObserver);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ch
            @Override // java.lang.Runnable
            public final void run() {
                ci.g(ci.this);
            }
        }, 16, null, false);
    }
}
