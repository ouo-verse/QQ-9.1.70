package lu1;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0013"}, d2 = {"Llu1/k;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/data/ChatMessage;", "a", "", QQBrowserActivity.KEY_MSG_TYPE, "Llu1/e;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "f", "e", "d", "b", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f415564a = new k();

    k() {
    }

    @JvmStatic
    public static final ChatMessage a(AppRuntime app, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        e c16 = f415564a.c(msgRecord.msgType);
        if (c16 != null) {
            return c16.a(app, msgRecord, null);
        }
        return null;
    }

    public final MsgElement b(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.arkElement != null || next.textGiftElement != null || next.liveGiftElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement d(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.fileElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement e(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.picElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement f(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.videoElement != null) {
                return next;
            }
        }
        return null;
    }

    private final e c(int msgType) {
        if (msgType == 2) {
            return new j();
        }
        if (msgType == 3) {
            return new b();
        }
        if (msgType == 5) {
            return new d();
        }
        if (msgType != 7) {
            switch (msgType) {
                case 9:
                    return new m();
                case 10:
                    return new p();
                case 11:
                    return new a();
                default:
                    return new n();
            }
        }
        return new o();
    }
}
