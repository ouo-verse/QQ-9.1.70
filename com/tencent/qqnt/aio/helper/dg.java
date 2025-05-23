package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0004\u0018\u001b\u001f#\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dg;", "Lcom/tencent/aio/main/businesshelper/h;", "", "troopUin", "", "g", "", "c", "e", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/qqnt/aio/helper/dg$b", "Lcom/tencent/qqnt/aio/helper/dg$b;", "mFriendListObserver", "com/tencent/qqnt/aio/helper/dg$e", "f", "Lcom/tencent/qqnt/aio/helper/dg$e;", "simpleInfoChangeCallback", "com/tencent/qqnt/aio/helper/dg$d", tl.h.F, "Lcom/tencent/qqnt/aio/helper/dg$d;", "mTroopSettingObserver", "com/tencent/qqnt/aio/helper/dg$c", "i", "Lcom/tencent/qqnt/aio/helper/dg$c;", "mTroopObserver", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class dg implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b mFriendListObserver = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final e simpleInfoChangeCallback = new e();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final d mTroopSettingObserver = new d();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final c mTroopObserver = new c();
    private static final boolean C = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_simpleinfo_change_callback", true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/dg$b", "Lcom/tencent/mobileqq/app/ar;", "", "uin", "", "isSuccess", "", "onUpdateFriendInfo", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.app.ar {
        b() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String uin, boolean isSuccess) {
            AIOParam g16;
            com.tencent.aio.api.runtime.a aVar = dg.this.mAIOContext;
            if (TextUtils.equals(uin, (aVar == null || (g16 = aVar.g()) == null) ? null : su3.c.b(g16))) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                String H = com.tencent.mobileqq.utils.ac.H((QQAppInterface) peekAppRuntime, uin);
                com.tencent.aio.api.runtime.a aVar2 = dg.this.mAIOContext;
                Intrinsics.checkNotNull(aVar2);
                aVar2.e().h(new AIOTitleEvent.TitleResponseEvent(4, H));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/dg$d", "Lcom/tencent/mobileqq/troop/troopsetting/api/b;", "", "troopUin", "", "f", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends com.tencent.mobileqq.troop.troopsetting.api.b {
        d() {
        }

        @Override // com.tencent.mobileqq.troop.troopsetting.api.b
        protected void f(String troopUin) {
            dg.this.g(troopUin);
        }
    }

    private final boolean c() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        return (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 1) ? false : true;
    }

    private final boolean e() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        return (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String troopUin) {
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String b16 = (aVar == null || (g16 = aVar.g()) == null) ? null : su3.c.b(g16);
        if (e() && TextUtils.equals(troopUin, b16)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            Manager manager = ((QQAppInterface) peekAppRuntime).getManager(QQManagerFactory.TROOP_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.TroopManager");
            TroopInfo k3 = ((TroopManager) manager).k(troopUin);
            if (k3 == null) {
                return;
            }
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            Intrinsics.checkNotNull(aVar2);
            aVar2.e().h(new AIOTitleEvent.TitleResponseEvent(4, k3.getTroopDisplayName()));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350640i;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (c()) {
            if (C) {
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).addChangeFriendUidsCallBack("TitleHelper", this.simpleInfoChangeCallback);
                return;
            } else {
                qQAppInterface.addObserver(this.mFriendListObserver);
                return;
            }
        }
        if (e()) {
            qQAppInterface.addObserver(this.mTroopSettingObserver);
            qQAppInterface.addObserver(this.mTroopObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (c()) {
            if (!C) {
                qQAppInterface.removeObserver(this.mFriendListObserver);
            }
        } else if (e()) {
            qQAppInterface.removeObserver(this.mTroopSettingObserver);
            qQAppInterface.removeObserver(this.mTroopObserver);
        }
        h.a.b(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/dg$c", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuc", "", "troopUin", "", "onGetTroopInfoResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.e {
        c() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean isSuc, String troopUin) {
            if (isSuc) {
                dg.this.g(troopUin);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/dg$e", "Lhx3/b;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements hx3.b<String> {
        e() {
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> responseData) {
            com.tencent.aio.api.runtime.a aVar;
            AIOSession r16;
            AIOContact c16;
            boolean z16 = false;
            if (responseData != null && responseData.a() == 0) {
                z16 = true;
            }
            if (z16 && (aVar = dg.this.mAIOContext) != null) {
                AIOParam g16 = aVar.g();
                String j3 = (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? null : c16.j();
                ArrayList<String> b16 = responseData.b();
                if (b16 != null) {
                    Iterator<T> it = b16.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals((String) it.next(), j3)) {
                            com.tencent.relation.common.bean.nameservice.a aVar2 = new com.tencent.relation.common.bean.nameservice.a();
                            if (j3 == null) {
                                return;
                            }
                            aVar2.d(j3);
                            aVar.e().h(new AIOTitleEvent.TitleResponseEvent(4, ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar2)));
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            onDestroy();
        }
    }
}
