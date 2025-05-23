package com.tencent.mobileqq.reminder.chats.notifycard.provider;

import com.tencent.mobileqq.cardcontainer.c;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.f;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.chats.notifycard.model.d;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/provider/a;", "Lcom/tencent/mobileqq/cardcontainer/c;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/b;", "data", "", "f", "", "todayStartTime", "", "extInfo", "g", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "containerData", h.F, "i", "", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "d", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "b", "Lcom/tencent/mobileqq/cardcontainer/f;", "c", "a", "e", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/provider/a$a;", "", "", "BIRTHDAY_UNTIL_TEXT", "Ljava/lang/String;", "", "MS_PER_DAY", "I", "TAG", "TODAY_BIRTHDAY_TEXT", "USER_ITEM_MAX_COUNT", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.chats.notifycard.provider.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21679);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(com.tencent.mobileqq.reminder.chats.notifycard.model.b data) {
        boolean z16;
        IFriendDataService iFriendDataService;
        Long longOrNull;
        boolean z17;
        String f16;
        boolean z18;
        Friends friends;
        String str;
        boolean z19;
        boolean z26;
        String str2;
        boolean z27;
        ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = data.h();
        if (h16 != null && !h16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "all");
        } else {
            iFriendDataService = null;
        }
        long s16 = QQReminderUtil.s(NetConnInfoCenter.getServerTimeMillis());
        QLog.i("NotifyCardTemplateProvider", 1, "convertUserList today start time: " + s16);
        Iterator<com.tencent.mobileqq.cardcontainer.data.b> it = h16.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.cardcontainer.data.b items = it.next();
            Intrinsics.checkNotNullExpressionValue(items, "items");
            com.tencent.mobileqq.cardcontainer.data.b bVar = items;
            if (data.C().size() < 4) {
                String h17 = bVar.h();
                if (h17 != null && longOrNull != null) {
                    long longValue = longOrNull.longValue();
                    String b16 = bVar.b();
                    String f17 = bVar.f();
                    if (f17 != null && f17.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        f16 = bVar.f();
                        Intrinsics.checkNotNull(f16);
                    } else {
                        if (b16 != null && b16.length() != 0) {
                            z27 = false;
                        } else {
                            z27 = true;
                        }
                        if (!z27) {
                            f16 = g(s16, b16);
                            if (f16 == null) {
                            }
                        } else {
                            f16 = "";
                        }
                    }
                    String str3 = f16;
                    String g16 = bVar.g();
                    if (g16 != null && g16.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        str2 = bVar.g();
                        Intrinsics.checkNotNull(str2);
                    } else {
                        String valueOf = String.valueOf(longValue);
                        if (iFriendDataService != null) {
                            friends = iFriendDataService.getFriend(bVar.h(), false);
                        } else {
                            friends = null;
                        }
                        if (friends != null) {
                            String str4 = friends.remark;
                            if (str4 != null && str4.length() != 0) {
                                z19 = false;
                            } else {
                                z19 = true;
                            }
                            if (!z19) {
                                str2 = friends.remark;
                                Intrinsics.checkNotNullExpressionValue(str2, "friend.remark");
                            } else {
                                String str5 = friends.name;
                                if (str5 != null && str5.length() != 0) {
                                    z26 = false;
                                } else {
                                    z26 = true;
                                }
                                if (!z26) {
                                    str2 = friends.name;
                                    Intrinsics.checkNotNullExpressionValue(str2, "friend.name");
                                }
                            }
                        }
                        str = valueOf;
                        data.C().add(new d(longValue, str, str3, false, 8, null));
                    }
                    str = str2;
                    data.C().add(new d(longValue, str, str3, false, 8, null));
                }
            } else {
                return;
            }
        }
    }

    private final String g(long todayStartTime, String extInfo) {
        try {
            QLog.i("NotifyCardTemplateProvider", 1, "processBirthday info: " + extInfo);
            JSONObject jSONObject = new JSONObject(extInfo);
            long optLong = jSONObject.optLong("birthday", -1L);
            String optString = jSONObject.optString("uin", "");
            if (optLong < 0) {
                return null;
            }
            long s16 = QQReminderUtil.s(1000 * optLong);
            if (s16 < todayStartTime) {
                QLog.e("NotifyCardTemplateProvider", 1, "processBirthday uin: " + optString + " birthday: " + optLong + " startTime: " + s16);
                return null;
            }
            if (s16 == todayStartTime) {
                return "\u4eca\u5929\u751f\u65e5";
            }
            return ((s16 - todayStartTime) / 86400000) + "\u5929\u540e";
        } catch (JSONException e16) {
            QLog.e("NotifyCardTemplateProvider", 1, "processBirthday error! json: " + extInfo, e16);
            return null;
        }
    }

    private final ContainerData h(ContainerData containerData) {
        com.tencent.mobileqq.reminder.chats.notifycard.model.b bVar = new com.tencent.mobileqq.reminder.chats.notifycard.model.b(containerData);
        bVar.t();
        f(bVar);
        bVar.D(QQReminderUtil.t(NetConnInfoCenter.getServerTimeMillis(), 1));
        QLog.i("NotifyCardTemplateProvider", 1, "finish processData userSize: " + bVar.C().size() + " expireTime: " + bVar.x() + " dataDate: " + bVar.w());
        return bVar;
    }

    private final ContainerData i(ContainerData containerData) {
        IFriendDataService iFriendDataService;
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.mobileqq.reminder.chats.notifycard.model.c cVar = new com.tencent.mobileqq.reminder.chats.notifycard.model.c(containerData);
        cVar.t();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Friends friends = null;
        if (peekAppRuntime != null) {
            iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "all");
        } else {
            iFriendDataService = null;
        }
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        boolean z19 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (iFriendDataService != null) {
                friends = iFriendDataService.getFriendFromMemoryCache(str);
            }
            if (friends != null) {
                String str2 = friends.name;
                if (str2 != null && str2.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    QLog.i("NotifyCardTemplateProvider", 1, "modify selfNick " + cVar.z() + " -> " + friends.name);
                    String str3 = friends.name;
                    Intrinsics.checkNotNullExpressionValue(str3, "self.name");
                    cVar.D(str3);
                }
            }
        }
        if (cVar.z().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (str == null) {
                str = "";
            }
            cVar.D(str);
        }
        if (cVar.y().b().length() == 0) {
            z19 = true;
        }
        if (z19) {
            cVar.y().f("\u4e00\u952e\u7b54\u8c22");
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public ContainerData a(@NotNull ContainerData containerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ContainerData) iPatchRedirector.redirect((short) 5, (Object) this, (Object) containerData);
        }
        Intrinsics.checkNotNullParameter(containerData, "containerData");
        if (containerData.i() == CardType.GroupMsgReminder) {
            return h(containerData);
        }
        return i(containerData);
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    public boolean b(@NotNull com.tencent.mobileqq.cardcontainer.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        int n3 = QQReminderUtil.n(NetConnInfoCenter.getServerTimeMillis());
        if (data instanceof com.tencent.mobileqq.reminder.chats.notifycard.model.b) {
            com.tencent.mobileqq.reminder.chats.notifycard.model.b bVar = (com.tencent.mobileqq.reminder.chats.notifycard.model.b) data;
            if ((!bVar.C().isEmpty()) && bVar.w() == n3) {
                return true;
            }
            return false;
        }
        if ((data instanceof com.tencent.mobileqq.reminder.chats.notifycard.model.c) && ((com.tencent.mobileqq.reminder.chats.notifycard.model.c) data).u() == n3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    @NotNull
    public List<CardType> d() {
        List<CardType> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CardType[]{CardType.GroupMsgReminder, CardType.SelfGroupMsgReminder});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.cardcontainer.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
