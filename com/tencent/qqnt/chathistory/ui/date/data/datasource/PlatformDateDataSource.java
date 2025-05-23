package com.tencent.qqnt.chathistory.ui.date.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qqnt.chathistory.ui.date.data.model.a;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IQueryCalendarCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0015\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J*\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00122\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/data/datasource/PlatformDateDataSource;", "", "Lcom/tencent/qqnt/kernel/api/w;", "c", "Ljava/util/ArrayList;", "", "calendars", "", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/b;", "e", "day", "", "f", "chatType", "", "peerId", "", "curDate", "Lkotlinx/coroutines/flow/Flow;", "d", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "appRuntime", "<init>", "()V", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformDateDataSource {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppRuntime appRuntime;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/data/datasource/PlatformDateDataSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.date.data.datasource.PlatformDateDataSource$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016R)\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/data/datasource/PlatformDateDataSource$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryCalendarCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", QQPermissionConstants.Permission.CALENDAR_GROUP, "", "onResult", "Ljava/lang/ref/WeakReference;", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/b;", "a", "Ljava/lang/ref/WeakReference;", "getScope", "()Ljava/lang/ref/WeakReference;", "scope", "Lcom/tencent/qqnt/chathistory/ui/date/data/datasource/PlatformDateDataSource;", "b", "getInner", "inner", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IQueryCalendarCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<ProducerScope<List<com.tencent.qqnt.chathistory.ui.date.data.model.b>>> scope;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<PlatformDateDataSource> inner;

        public b(@NotNull WeakReference<ProducerScope<List<com.tencent.qqnt.chathistory.ui.date.data.model.b>>> scope, @NotNull WeakReference<PlatformDateDataSource> inner) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(inner, "inner");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) inner);
            } else {
                this.scope = scope;
                this.inner = inner;
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryCalendarCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable ArrayList<Integer> calendar) {
            List<com.tencent.qqnt.chathistory.ui.date.data.model.b> e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(result), errMsg, calendar);
                return;
            }
            PlatformDateDataSource platformDateDataSource = this.inner.get();
            if (platformDateDataSource != null && (e16 = platformDateDataSource.e(calendar)) != null) {
                d.f354054a.a("PlatformDateDataSource", "searchHistoryDate result  " + result + "  errMsg " + errMsg + "  calendar " + calendar);
                ProducerScope<List<com.tencent.qqnt.chathistory.ui.date.data.model.b>> producerScope = this.scope.get();
                if (producerScope != null) {
                    ChannelResult.m2008boximpl(producerScope.mo2003trySendJP2dKIU(e16));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformDateDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w c() {
        if (this.appRuntime == null) {
            this.appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.appRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.qqnt.chathistory.ui.date.data.model.b> e(ArrayList<Integer> calendars) {
        int i3;
        int i16;
        ArrayList arrayList = new ArrayList();
        if (calendars == null) {
            return arrayList;
        }
        Calendar calendar = Calendar.getInstance();
        int i17 = calendar.get(1);
        int i18 = calendar.get(2) + 1;
        a aVar = new a(i17, i18, Integer.valueOf(calendar.get(5)));
        d.f354054a.a("PlatformDateDataSource", " current date " + aVar);
        for (int size = calendars.size() - 1; -1 < size; size += -1) {
            Integer num = calendars.get(size);
            Intrinsics.checkNotNullExpressionValue(num, "calendars[i]");
            List<Boolean> f16 = f(num.intValue());
            int i19 = i18 - size;
            if (i19 <= 0) {
                i16 = (i19 % 12) + 12;
                i3 = i17 - ((Math.abs(i19) / 12) + 1);
            } else {
                i3 = i17;
                i16 = i19;
            }
            a aVar2 = new a(i3, i16, null, 4, null);
            d.f354054a.a("PlatformSearchDataSource", "index " + size + " modelDate " + aVar2);
            arrayList.add(new com.tencent.qqnt.chathistory.ui.date.data.model.b(aVar2, aVar, f16));
        }
        return arrayList;
    }

    private final List<Boolean> f(int day) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Boolean.FALSE);
        while (true) {
            boolean z16 = true;
            if (day == 0) {
                break;
            }
            if (day % 2 != 1) {
                z16 = false;
            }
            arrayList.add(Boolean.valueOf(z16));
            day /= 2;
        }
        for (int size = arrayList.size() + 1; size < 33; size++) {
            arrayList.add(Boolean.FALSE);
        }
        return arrayList;
    }

    @NotNull
    public final Flow<List<com.tencent.qqnt.chathistory.ui.date.data.model.b>> d(int chatType, @NotNull String peerId, long curDate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(chatType), peerId, Long.valueOf(curDate));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return FlowKt.callbackFlow(new PlatformDateDataSource$searchHistoryDate$1(chatType, curDate, this, peerId, null));
    }
}
