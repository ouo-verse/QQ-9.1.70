package com.tencent.qqprotect.accountassistant.chat.data.model.cache;

import android.database.SQLException;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.accountassistant.chat.data.model.db.AssistantRobotDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0014R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\n \u0017*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqprotect/accountassistant/chat/data/model/cache/d;", "", "Lorg/json/JSONObject;", "data", "", "k", "e", "Lorg/json/JSONArray;", "messageList", "i", "", "conversationID", "Lcom/tencent/qqprotect/accountassistant/chat/data/model/db/c;", "g", "", "rowID", "", "count", "", h.F, "", "d", "Lcom/tencent/qqprotect/accountassistant/chat/data/model/db/AssistantRobotDatabase;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/qqprotect/accountassistant/chat/data/model/db/AssistantRobotDatabase;", "database", "Lcom/tencent/qqprotect/accountassistant/chat/data/model/db/a;", "c", "Lcom/tencent/qqprotect/accountassistant/chat/data/model/db/a;", "messageDao", "<init>", "()V", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f363456a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AssistantRobotDatabase database;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.qqprotect.accountassistant.chat.data.model.db.a messageDao;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f363456a = new d();
        AssistantRobotDatabase c16 = AssistantRobotDatabase.c(BaseApplication.context);
        database = c16;
        messageDao = c16.d();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        messageDao.e(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.a(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, JSONArray messageList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(messageList, "$messageList");
        synchronized (this$0) {
            int itemCount = messageDao.getItemCount() + 1;
            ArrayList arrayList = new ArrayList();
            int length = messageList.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = new JSONObject(messageList.getString(i3));
                com.tencent.qqprotect.accountassistant.chat.data.model.db.c d16 = messageDao.d(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.c(jSONObject));
                if (d16 != null) {
                    QLog.i("AssistantRobotLocalCacheMgr", 1, "updateMessage rowID: " + d16.f363483k);
                    arrayList.add(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.b(jSONObject, d16.f363483k));
                } else {
                    QLog.i("AssistantRobotLocalCacheMgr", 1, "insertMessage rowID: " + itemCount);
                    com.tencent.qqprotect.accountassistant.chat.data.model.db.c b16 = com.tencent.qqprotect.accountassistant.chat.data.model.db.c.b(jSONObject, (long) itemCount);
                    itemCount++;
                    arrayList.add(b16);
                }
            }
            try {
                messageDao.f(arrayList);
            } catch (SQLException e16) {
                QLog.e("AssistantRobotLocalCacheMgr", 1, "insertOrUpdateMessages exception, e: " + e16);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        try {
            com.tencent.qqprotect.accountassistant.chat.data.model.db.a aVar = messageDao;
            com.tencent.qqprotect.accountassistant.chat.data.model.db.c d16 = aVar.d(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.c(data));
            if (d16 != null) {
                aVar.a(com.tencent.qqprotect.accountassistant.chat.data.model.db.c.b(data, d16.f363483k));
            }
        } catch (SQLException e16) {
            QLog.e("AssistantRobotLocalCacheMgr", 1, "updateMessageInCache exception, messageRecord: " + data + " e: " + e16);
        }
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        try {
            messageDao.g();
            return true;
        } catch (SQLException e16) {
            QLog.e("AssistantRobotLocalCacheMgr", 1, "clearCache exception, e: " + e16);
            return false;
        }
    }

    public final void e(@NotNull final JSONObject data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqprotect.accountassistant.chat.data.model.cache.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(JSONObject.this);
                }
            }, 32, null, true);
        }
    }

    @Nullable
    public final com.tencent.qqprotect.accountassistant.chat.data.model.db.c g(@NotNull String conversationID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqprotect.accountassistant.chat.data.model.db.c) iPatchRedirector.redirect((short) 5, (Object) this, (Object) conversationID);
        }
        Intrinsics.checkNotNullParameter(conversationID, "conversationID");
        return messageDao.b(conversationID);
    }

    @NotNull
    public final List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> h(@NotNull String conversationID, long rowID, int count) {
        List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, conversationID, Long.valueOf(rowID), Integer.valueOf(count));
        }
        Intrinsics.checkNotNullParameter(conversationID, "conversationID");
        ArrayList arrayList = new ArrayList();
        try {
            List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> c16 = messageDao.c(conversationID, rowID, count);
            if (c16 == null) {
                c16 = CollectionsKt__CollectionsKt.emptyList();
            }
            arrayList.addAll(c16);
            CollectionsKt___CollectionsJvmKt.reverse(arrayList);
            return arrayList;
        } catch (SQLException e16) {
            QLog.e("AssistantRobotLocalCacheMgr", 1, "getMessageBefore exception, e: " + e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final void i(@NotNull final JSONArray messageList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageList);
        } else {
            Intrinsics.checkNotNullParameter(messageList, "messageList");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqprotect.accountassistant.chat.data.model.cache.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(d.this, messageList);
                }
            }, 32, null, true);
        }
    }

    public final void k(@NotNull final JSONObject data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqprotect.accountassistant.chat.data.model.cache.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.l(JSONObject.this);
                }
            }, 32, null, true);
        }
    }
}
