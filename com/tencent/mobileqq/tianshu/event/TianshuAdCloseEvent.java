package com.tencent.mobileqq.tianshu.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B%\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tianshu/event/TianshuAdCloseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", HippyControllerProps.STRING, "", "hashCode", "", "(Ljava/lang/String;I)V", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "senderHashCode", "(Ljava/util/ArrayList;I)V", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/ArrayList;", "getSenderHashCode", "()I", "tianshu-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class TianshuAdCloseEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final ArrayList<Integer> list;
    private final int senderHashCode;

    public TianshuAdCloseEvent(@NotNull ArrayList<Integer> list, int i3) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "list");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, i3);
            return;
        }
        this.list = list;
        this.senderHashCode = i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("send other ad close event, adID:");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        QLog.d("TianshuAdCloseEvent", 1, sb5.toString());
    }

    @NotNull
    public final ArrayList<Integer> getList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.list;
    }

    public final int getSenderHashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.senderHashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r9, new char[]{','}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TianshuAdCloseEvent(@Nullable String str, int i3) {
        this((ArrayList<Integer>) r9, i3);
        ArrayList arrayList;
        List split$default;
        int i16;
        if (str == null || split$default == null) {
            arrayList = new ArrayList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                try {
                    i16 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                } catch (Exception unused) {
                    i16 = 0;
                }
                if (i16 != null) {
                    arrayList2.add(i16);
                }
            }
            arrayList = new ArrayList(arrayList2);
        }
    }
}
