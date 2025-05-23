package com.tencent.qqnt.chats.main.vm.datasource.preprocess;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.e;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\"\u00a2\u0006\u0004\b1\u00102J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J,\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0014\u0010\u001e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/e;", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "", "isGuildUpdate", "f", "b", "", NotificationCompat.CATEGORY_ERROR, "", "msg", "e", "uidList", "d", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "result", "errMsg", "curSpecifyInfo", "a", "onLitterEarChange", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "proxyPlatformListener", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "contactInfoPreProcessor", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "contactReSortProcessor", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/b;", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/b;", "preProcessExecutor", "", "<set-?>", "Ljava/util/List;", "g", "()Ljava/util/List;", "contactList", "", "Ljava/lang/Object;", "updateLock", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/e;Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e implements com.tencent.qqnt.chats.main.vm.datasource.e {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.main.vm.datasource.e proxyPlatformListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c contactInfoPreProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d contactReSortProcessor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b preProcessExecutor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> sortedContactList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RecentContactInfo> contactList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object updateLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.preprocess.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46181);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull com.tencent.qqnt.chats.main.vm.datasource.e proxyPlatformListener, @NotNull c contactInfoPreProcessor, @NotNull d contactReSortProcessor) {
        Intrinsics.checkNotNullParameter(proxyPlatformListener, "proxyPlatformListener");
        Intrinsics.checkNotNullParameter(contactInfoPreProcessor, "contactInfoPreProcessor");
        Intrinsics.checkNotNullParameter(contactReSortProcessor, "contactReSortProcessor");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, proxyPlatformListener, contactInfoPreProcessor, contactReSortProcessor);
            return;
        }
        this.proxyPlatformListener = proxyPlatformListener;
        this.contactInfoPreProcessor = contactInfoPreProcessor;
        this.contactReSortProcessor = contactReSortProcessor;
        this.preProcessExecutor = new b();
        this.sortedContactList = new ArrayList();
        this.contactList = new ArrayList();
        this.updateLock = new Object();
    }

    private final void h(List<Long> sortedContactList, List<RecentContactInfo> changedList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : changedList) {
            if (!this.contactList.contains((RecentContactInfo) obj)) {
                arrayList.add(obj);
            }
        }
        this.contactList.addAll(arrayList);
        List<RecentContactInfo> list = this.contactList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (!sortedContactList.contains(Long.valueOf(((RecentContactInfo) obj2).contactId))) {
                arrayList2.add(obj2);
            }
        }
        this.contactList.removeAll(arrayList2);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(result), errMsg, curSpecifyInfo);
        } else {
            this.proxyPlatformListener.a(result, errMsg, curSpecifyInfo);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void b(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> changedList, boolean isGuildUpdate) {
        List<Long> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, sortedContactList, changedList, Boolean.valueOf(isGuildUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
        Intrinsics.checkNotNullParameter(changedList, "changedList");
        synchronized (this.updateLock) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedContactList);
            this.sortedContactList = mutableList;
            h(sortedContactList, changedList);
            Unit unit = Unit.INSTANCE;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PlatformListenerPreProcess", 2, "onRecentContactPartChanged old sortedContactList:  " + sortedContactList + ", changedList: " + changedList);
        }
        this.preProcessExecutor.f(this.contactInfoPreProcessor, changedList, isGuildUpdate);
        List<RecentContactInfo> list = this.contactList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (sortedContactList.contains(Long.valueOf(((RecentContactInfo) obj).contactId))) {
                arrayList.add(obj);
            }
        }
        this.preProcessExecutor.f(this.contactInfoPreProcessor, arrayList, isGuildUpdate);
        List<Long> e16 = this.preProcessExecutor.e(this.contactReSortProcessor, sortedContactList, arrayList, isGuildUpdate);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(e16);
        if (QLog.isColorLevel()) {
            QLog.i("PlatformListenerPreProcess", 2, "onRecentContactPartChanged new sortedContactList:  " + sortedContactList + ", changedList: " + changedList);
        }
        e.a.g(this.proxyPlatformListener, arrayList2, changedList, false, 4, null);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void c(@NotNull List<Long> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uinList);
        } else {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            this.proxyPlatformListener.c(uinList);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void d(@NotNull List<String> uidList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uidList);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            this.proxyPlatformListener.d(uidList);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void e(int err, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, err, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.proxyPlatformListener.e(err, msg2);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, info, Boolean.valueOf(isGuildUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        synchronized (this.updateLock) {
            ArrayList<Long> arrayList = info.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "info.sortedContactList");
            this.sortedContactList = arrayList;
            ArrayList<RecentContactInfo> arrayList2 = info.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "info.changedList");
            this.contactList = arrayList2;
            Unit unit = Unit.INSTANCE;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PlatformListenerPreProcess", 2, "onRecentContactListChanged old sortedContactList:  " + info.sortedContactList + ", changedList: " + info.changedList);
        }
        b bVar = this.preProcessExecutor;
        c cVar = this.contactInfoPreProcessor;
        ArrayList<RecentContactInfo> arrayList3 = info.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "info.changedList");
        bVar.f(cVar, arrayList3, isGuildUpdate);
        b bVar2 = this.preProcessExecutor;
        d dVar = this.contactReSortProcessor;
        ArrayList<Long> arrayList4 = info.sortedContactList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "info.sortedContactList");
        ArrayList<RecentContactInfo> arrayList5 = info.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList5, "info.changedList");
        List<Long> e16 = bVar2.e(dVar, arrayList4, arrayList5, isGuildUpdate);
        ArrayList<Long> arrayList6 = new ArrayList<>();
        arrayList6.addAll(e16);
        info.sortedContactList = arrayList6;
        if (QLog.isColorLevel()) {
            QLog.i("PlatformListenerPreProcess", 2, "onRecentContactListChanged new sortedContactList:  " + info.sortedContactList + ", changedList: " + info.changedList);
        }
        this.proxyPlatformListener.f(info, isGuildUpdate);
    }

    @NotNull
    public final List<Long> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sortedContactList;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void onLitterEarChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.proxyPlatformListener.onLitterEarChange();
        }
    }
}
