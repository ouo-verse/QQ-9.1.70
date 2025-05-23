package d22;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.icgame.app.event.AudienceFloatOnExitEvent;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftPanelEvent;
import com.tencent.icgame.game.liveroom.impl.room.profile.ProfileSendGiftClickEvent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ComponentEvent(eventList = {GiftEvent.class, d22.a.class, c.class, h.class, d22.g.class})
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0007!\"\b#\u0016 $B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R0\u0010\u0018\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\n0\u00050\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Ld22/d;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ld22/d$d;", tl.h.F, "", "c", "globalEvent", "Lg32/b;", DomainData.DOMAIN_NAME, "event", "o", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "k", "i", "", "e", "Ljava/util/Map;", "globalEventHandlerList", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "f", "a", "b", "d", "g", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends com.tencent.mobileqq.icgame.framework.component.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, AbstractC10155d<?, ? extends g32.b>> globalEventHandlerList;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld22/d$a;", "Ld22/d$d;", "Lcom/tencent/timi/game/app/event/AudienceFloatCloseEvent;", "Ld22/a;", "from", "e", "<init>", "(Ld22/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class a extends AbstractC10155d<AudienceFloatCloseEvent, d22.a> {
        public a() {
        }

        @Override // d22.d.AbstractC10155d
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public d22.a d(@NotNull AudienceFloatCloseEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            long roomId = from.getRoomId();
            h22.a aVar = d.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (roomId != aVar.getRoomId()) {
                return null;
            }
            return new d22.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld22/d$b;", "Ld22/d$d;", "Lcom/tencent/icgame/app/event/AudienceFloatOnExitEvent;", "Ld22/g;", "from", "e", "<init>", "(Ld22/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class b extends AbstractC10155d<AudienceFloatOnExitEvent, d22.g> {
        public b() {
        }

        @Override // d22.d.AbstractC10155d
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public d22.g d(@NotNull AudienceFloatOnExitEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            return new d22.g();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\nJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a8\u0006\u000f"}, d2 = {"Ld22/d$d;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", UserInfo.SEX_FEMALE, "Lg32/b;", "T", "", "Ljava/lang/Class;", "b", "from", "c", "(Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;)Lg32/b;", "d", "a", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d22.d$d, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC10155d<F extends SimpleBaseEvent, T extends g32.b> {
        private final Class<F> b() {
            boolean z16;
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
                if (actualTypeArguments.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    Type type = actualTypeArguments[0];
                    Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<F of com.tencent.mobileqq.icgame.base.baseroom.globalevent.GlobalEventBusComponent.H>");
                    return (Class) type;
                }
                throw new RuntimeException("getMyFirstTypeClass error_2 !");
            }
            throw new RuntimeException("getMyFirstTypeClass error_1 !");
        }

        @NotNull
        public final Class<F> a() {
            return b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final T c(@NotNull SimpleBaseEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            if (d22.e.a(this, from.getClass(), a())) {
                return d(from);
            }
            return null;
        }

        @Nullable
        public abstract T d(@NotNull F from);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld22/d$e;", "Ld22/d$d;", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/ProfileSendGiftClickEvent;", "Ld22/h;", "from", "e", "<init>", "(Ld22/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class e extends AbstractC10155d<ProfileSendGiftClickEvent, h> {
        public e() {
        }

        @Override // d22.d.AbstractC10155d
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h d(@NotNull ProfileSendGiftClickEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            long roomId = from.getRoomId();
            h22.a aVar = d.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (roomId == aVar.getRoomId()) {
                h22.a aVar2 = d.this.qqLiveRoomService;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar2 = null;
                }
                if (aVar2.p()) {
                    return new h(from.getUid(), from.getNickName(), from.getHeadUrl());
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld22/d$f;", "Ld22/d$d;", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftEvent;", "Ld22/b;", "from", "e", "<init>", "(Ld22/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class f extends AbstractC10155d<TimiGiftEvent, GiftEvent> {
        public f() {
        }

        @Override // d22.d.AbstractC10155d
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public GiftEvent d(@NotNull TimiGiftEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            long roomId = from.getRoomId();
            h22.a aVar = d.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (roomId != aVar.getRoomId()) {
                return null;
            }
            return new GiftEvent(from.getGiftMsg());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ld22/d$g;", "Ld22/d$d;", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftPanelEvent;", "Ld22/c;", "from", "e", "<init>", "(Ld22/d;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class g extends AbstractC10155d<TimiGiftPanelEvent, c> {
        public g() {
        }

        @Override // d22.d.AbstractC10155d
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public c d(@NotNull TimiGiftPanelEvent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            long roomId = from.getRoomId();
            h22.a aVar = d.this.qqLiveRoomService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (roomId != aVar.getRoomId()) {
                return null;
            }
            return new c(from.getCmd(), from.getPanelWidth(), from.getPanelHeight());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.globalEventHandlerList = new LinkedHashMap();
        c(new f());
        c(new a());
        c(new g());
        c(new e());
        c(new b());
    }

    private final void c(AbstractC10155d<?, ?> h16) {
        this.globalEventHandlerList.put(h16.a(), h16);
    }

    private final g32.b n(SimpleBaseEvent globalEvent) {
        g32.b bVar;
        AbstractC10155d<?, ? extends g32.b> abstractC10155d = this.globalEventHandlerList.get(globalEvent.getClass());
        if (abstractC10155d != null) {
            bVar = abstractC10155d.c(globalEvent);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        QLog.w("ICGameGlobalEventBusComponent", 1, "transform: " + globalEvent.getClass().getSimpleName() + " is not handle by GlobalEventBusComponent");
        return null;
    }

    private final void o(g32.b event) {
        getComponentContext().w0(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        Iterator<Map.Entry<Class<?>, AbstractC10155d<?, ? extends g32.b>>> it = this.globalEventHandlerList.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        g32.b n3;
        if (simpleBaseEvent == null || (n3 = n(simpleBaseEvent)) == null) {
            return;
        }
        o(n3);
    }
}
