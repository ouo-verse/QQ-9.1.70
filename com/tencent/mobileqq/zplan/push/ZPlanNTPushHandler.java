package com.tencent.mobileqq.zplan.push;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import msf.msgcomm.nt_msg_common$Msg;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/ZPlanNTPushHandler;", "", "", BaseConstants.EXTRA_PUSHID, "", "msgBuf", "", "a", "Lcom/tencent/mobileqq/zplan/push/ZPlanNTPushHandler$PushType;", "type", "Lcom/tencent/mobileqq/zplan/push/a;", "notify", "b", "c", "", "Lcom/tencent/mobileqq/zplan/push/ZPlanNTPushHandler$a;", "Ljava/util/Map;", "notifyMap", "<init>", "()V", "PushType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanNTPushHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanNTPushHandler f335027a = new ZPlanNTPushHandler();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, Observer> notifyMap;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/ZPlanNTPushHandler$PushType;", "", "value", "", "(Ljava/lang/String;IJ)V", HippyTextInputController.COMMAND_getValue, "()J", "SCENE_LINKAGE", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum PushType {
        SCENE_LINKAGE(357);

        private final long value;

        PushType(long j3) {
            this.value = j3;
        }

        public final long getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\u0004\b\u0012\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R.\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/ZPlanNTPushHandler$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/push/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "observers", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.push.ZPlanNTPushHandler$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class Observer {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private List<WeakReference<a>> observers;

        public Observer() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final List<WeakReference<a>> a() {
            return this.observers;
        }

        public final void b(List<WeakReference<a>> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.observers = list;
        }

        public int hashCode() {
            return this.observers.hashCode();
        }

        public String toString() {
            return "Observer(observers=" + this.observers + ")";
        }

        public Observer(List<WeakReference<a>> observers) {
            Intrinsics.checkNotNullParameter(observers, "observers");
            this.observers = observers;
        }

        public /* synthetic */ Observer(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Observer) && Intrinsics.areEqual(this.observers, ((Observer) other).observers);
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        notifyMap = linkedHashMap;
        linkedHashMap.put(Long.valueOf(PushType.SCENE_LINKAGE.getValue()), new Observer(null, 1, 0 == true ? 1 : 0));
    }

    ZPlanNTPushHandler() {
    }

    public final void a(long pushId, byte[] msgBuf) {
        Intrinsics.checkNotNullParameter(msgBuf, "msgBuf");
        Observer observer = notifyMap.get(Long.valueOf(pushId));
        if (observer == null) {
            return;
        }
        List<WeakReference<a>> a16 = observer.a();
        if (a16 == null || a16.isEmpty()) {
            return;
        }
        nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
        nt_msg_common_msg.mergeFrom(msgBuf);
        long j3 = nt_msg_common_msg.routing_head.from_uin.get();
        long j16 = nt_msg_common_msg.routing_head.to_uin.get();
        byte[] body = nt_msg_common_msg.body.msg_content.get().toByteArray();
        Iterator<WeakReference<a>> it = observer.a().iterator();
        while (it.hasNext()) {
            a aVar = it.next().get();
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(body, "body");
                aVar.a(j3, j16, body);
            }
        }
    }

    public final void b(PushType type, a notify) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notify, "notify");
        Observer observer = notifyMap.get(Long.valueOf(type.getValue()));
        if (observer != null) {
            List<WeakReference<a>> a16 = observer.a();
            boolean z16 = false;
            if (a16 == null || a16.isEmpty()) {
                observer.b(new ArrayList());
            }
            Iterator<WeakReference<a>> it = observer.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next().get(), notify)) {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                return;
            }
            observer.a().add(new WeakReference<>(notify));
        }
    }

    public final void c(PushType type, a notify) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(notify, "notify");
        Observer observer = notifyMap.get(Long.valueOf(type.getValue()));
        if (observer != null) {
            Iterator<WeakReference<a>> it = observer.a().iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().get(), notify)) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
