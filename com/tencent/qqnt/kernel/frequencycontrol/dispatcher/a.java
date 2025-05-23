package com.tencent.qqnt.kernel.frequencycontrol.dispatcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.b;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItemListBody;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/kernel/frequencycontrol/dispatcher/a;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "", "cmd", "", "pbBuffer", "", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "", "a", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/frequencycontrol/dispatcher/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.frequencycontrol.dispatcher.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{221005};
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (QLog.isDevelopLevel()) {
            QLog.i("RefreshFrequencyControlDispatcher", 4, "[onDispatchCall]: cmd is " + cmd);
        }
        FrequencyControlField$ResourceItemListBody a16 = com.tencent.qqnt.kernel.frequencycontrol.a.f359079a.a(pbBuffer);
        if (a16.item_list.isEmpty()) {
            QLog.i("RefreshFrequencyControlDispatcher", 1, "[onDispatchCall]: itemList is empty");
            return;
        }
        int size = a16.item_list.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 = 0; i3 < size; i3++) {
            FrequencyControlField$ResourceItem resItem = a16.item_list.get(i3);
            if (resItem.has()) {
                int i16 = resItem.scene_id.get();
                List list = (List) linkedHashMap.get(Integer.valueOf(i16));
                if (list == null) {
                    list = new ArrayList();
                }
                Intrinsics.checkNotNullExpressionValue(resItem, "resItem");
                list.add(resItem);
                linkedHashMap.put(Integer.valueOf(i16), list);
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            RefreshFrequencyControlInject.f359080a.b(((Number) entry.getKey()).intValue(), (List) entry.getValue());
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        QLog.e("RefreshFrequencyControlDispatcher", 1, "[onDispatchRequest]: cmd is " + cmd + ", requestId is " + requestId);
    }
}
