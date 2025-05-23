package com.tencent.mobileqq.reminder.chats.notifycard.manager;

import cm2.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi;
import com.tencent.mobileqq.reminder.chats.notifycard.model.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0014\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJW\u0010\u0017\u001a\u00020\u00062O\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0011\u0010!\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/b;", "", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "isChecked", "", "b", "Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/a;", "listener", "e", "", "userList", "c", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "code", "", "msg", "callback", "d", "", "a", "Ljava/util/List;", "mUserMap", "Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/a;", "mSelectItemChangeListener", "Ljava/lang/String;", "mCallbackKey", "()Z", "isUserItemListEmpty", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> mUserMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mSelectItemChangeListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mCallbackKey;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/manager/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.manager.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/reminder/chats/notifycard/manager/b$b", "Lcm2/c;", "", "isSuccess", "", "code", "", "msg", "", "data", "", "i", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8505b implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f280950d;

        /* JADX WARN: Multi-variable type inference failed */
        C8505b(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3) {
            this.f280950d = function3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function3);
            }
        }

        @Override // cm2.b
        public void i(boolean isSuccess, int code, @Nullable String msg2, @Nullable Object data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(code), msg2, data);
                return;
            }
            Function3<Boolean, Integer, String, Unit> function3 = this.f280950d;
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(isSuccess), Integer.valueOf(code), msg2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mUserMap = new ArrayList();
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mUserMap.isEmpty();
    }

    public final void b(@NotNull d item, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, Boolean.valueOf(isChecked));
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        int size = this.mUserMap.size();
        if (isChecked) {
            if (!this.mUserMap.contains(item)) {
                this.mUserMap.add(item);
            }
        } else {
            this.mUserMap.remove(item);
        }
        int size2 = this.mUserMap.size();
        if (size != size2) {
            QLog.i("NotifyGuestCardManager", 1, "on user check changed old: " + size + " new: " + size2 + " item: " + item.c() + " checked: " + isChecked);
            a aVar = this.mSelectItemChangeListener;
            if (aVar != null) {
                aVar.a(size, size2);
            }
        }
    }

    public final void c(@NotNull List<d> userList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) userList);
            return;
        }
        Intrinsics.checkNotNullParameter(userList, "userList");
        int size = this.mUserMap.size();
        this.mUserMap.clear();
        for (d dVar : userList) {
            if (dVar.d()) {
                this.mUserMap.add(dVar);
            }
        }
        int size2 = this.mUserMap.size();
        QLog.i("NotifyGuestCardManager", 1, "resetUserMap size: " + size2);
        a aVar = this.mSelectItemChangeListener;
        if (aVar != null) {
            aVar.a(size, size2);
        }
    }

    public final void d(@Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        if (this.mUserMap.isEmpty()) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, -1, "empty user list");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.mUserMap.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().c()));
            }
            this.mCallbackKey = ((IQQReminderBlessingApi) QRoute.api(IQQReminderBlessingApi.class)).sendBlessingTimedMessage(arrayList, 2, new C8505b(callback));
        }
    }

    public final void e(@Nullable a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.mSelectItemChangeListener = listener;
        }
    }
}
