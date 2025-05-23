package km4;

import android.content.Context;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.api.TabPreloadItem;
import j05.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRotateMessage;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lkm4/b;", "Lj05/b;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomRotateMessage;", "msg", "", "Q3", "", "Lkm4/a;", "", "roomId", "P3", "", "R3", "Landroid/content/Context;", "context", "init", "", "R2", TabPreloadItem.TAB_NAME_MESSAGE, "p2", Constants.APK_CERTIFICATE, "o2", "a", "Ljava/util/List;", "operationBundleList", "b", "tmpYoloRoomRotateMsgList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lj05/b$a;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onYoloRoomSystemMsgListenerList", "<init>", "()V", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements j05.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<OperationBundle> operationBundleList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<YoloRoomOuterClass$YoloRoomRotateMessage> tmpYoloRoomRotateMsgList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b.a> onYoloRoomSystemMsgListenerList = new CopyOnWriteArrayList<>();

    private final OperationBundle P3(List<OperationBundle> list, long j3) {
        Object obj;
        boolean z16;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((OperationBundle) obj).getRoomId() == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OperationBundle operationBundle = (OperationBundle) obj;
        if (operationBundle == null) {
            OperationBundle operationBundle2 = new OperationBundle(j3, null, new ArrayList());
            list.add(operationBundle2);
            return operationBundle2;
        }
        return operationBundle;
    }

    private final boolean Q3(YoloRoomOuterClass$YoloRoomRotateMessage msg2) {
        if (msg2.message_type.get() != 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R3(List<OperationBundle> list, long j3) {
        Object obj;
        boolean z16;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((OperationBundle) obj).getRoomId() == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OperationBundle operationBundle = (OperationBundle) obj;
        if (operationBundle != null) {
            list.remove(operationBundle);
        }
    }

    @Override // j05.b
    public void G1(long roomId) {
        R3(this.operationBundleList, roomId);
        this.tmpYoloRoomRotateMsgList.clear();
    }

    @Override // j05.b
    @NotNull
    public List<YoloRoomOuterClass$YoloRoomRotateMessage> R2() {
        return this.tmpYoloRoomRotateMsgList;
    }

    @Override // j05.b
    public void p2(long roomId, @NotNull List<YoloRoomOuterClass$YoloRoomRotateMessage> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        List<YoloRoomOuterClass$YoloRoomRotateMessage> list = msgList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Q3((YoloRoomOuterClass$YoloRoomRotateMessage) obj)) {
                arrayList.add(obj);
            }
        }
        this.tmpYoloRoomRotateMsgList.addAll(new ArrayList(arrayList));
        Iterator<T> it = this.onYoloRoomSystemMsgListenerList.iterator();
        while (it.hasNext()) {
            ((b.a) it.next()).a(arrayList);
        }
        OperationBundle P3 = P3(this.operationBundleList, roomId);
        P3.b();
        List<YoloRoomOuterClass$YoloRoomRotateMessage> c16 = P3.c();
        ArrayList arrayList2 = new ArrayList();
        for (YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage : list) {
            if (Q3(yoloRoomOuterClass$YoloRoomRotateMessage)) {
                yoloRoomOuterClass$YoloRoomRotateMessage = null;
            }
            if (yoloRoomOuterClass$YoloRoomRotateMessage != null) {
                arrayList2.add(yoloRoomOuterClass$YoloRoomRotateMessage);
            }
        }
        c16.addAll(arrayList2);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
