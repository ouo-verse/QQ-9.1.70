package com.tencent.sqshow.zootopia.avatar.mall;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleEvent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import n74.ak;
import qv4.bk;
import qv4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0005`\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/avatar/mall/AvatarRoleTitleView$registerCreateRoleEventReceiver$1", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleEvent;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AvatarRoleTitleView$registerCreateRoleEventReceiver$1 implements SimpleEventReceiver<CreateRoleEvent> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AvatarRoleTitleView f370089d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AvatarRoleTitleView$registerCreateRoleEventReceiver$1(AvatarRoleTitleView avatarRoleTitleView) {
        this.f370089d = avatarRoleTitleView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        ya4.b bVar = ya4.b.f449938a;
        z a16 = bVar.a();
        if (a16 != null) {
            bk bkVar = a16.f430211a;
            if (bkVar != null) {
                bkVar.f430082h = null;
            }
            bVar.c(a16);
        }
        gb4.a aVar = gb4.a.f401894a;
        bk f16 = aVar.f();
        f16.f430082h = null;
        aVar.h(f16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.i("AvatarNativeTitleView_", 1, "onReceiveEvent event=" + event);
        if ((event instanceof CreateRoleEvent) && ((CreateRoleEvent) event).getSuccess()) {
            final AvatarRoleTitleView avatarRoleTitleView = this.f370089d;
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView$registerCreateRoleEventReceiver$1$onReceiveEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ak akVar;
                    AvatarRoleTitleView.this.hasCreateRole = true;
                    akVar = AvatarRoleTitleView.this.mBinding;
                    akVar.f418644h.setVisibility(8);
                    f94.c.d(f94.c.f398021a, false, 1, null);
                }
            });
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.mall.j
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarRoleTitleView$registerCreateRoleEventReceiver$1.b();
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<CreateRoleEvent>> getEventClass() {
        ArrayList<Class<CreateRoleEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CreateRoleEvent.class);
        return arrayListOf;
    }
}
