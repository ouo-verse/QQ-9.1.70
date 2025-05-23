package com.tencent.mobileqq.reminder.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.multishare.api.IMultiShareApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.reminder.multishare.listener.MultiShareEventListener;
import com.tencent.mobileqq.reminder.multishare.part.MultiShareEmoPanelPart;
import com.tencent.mobileqq.reminder.util.c;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/c;", "", "a", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/c$a;", "", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "contacts", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "c", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/reminder/multishare/config/a;", DownloadInfo.spKey_Config, "e", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.util.c$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(List contacts, String msgContent) {
            boolean z16;
            Intrinsics.checkNotNullParameter(contacts, "$contacts");
            Intrinsics.checkNotNullParameter(msgContent, "$msgContent");
            QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
            QRouteApi api2 = QRoute.api(IMsgSendHelper.class);
            Intrinsics.checkNotNullExpressionValue(api2, "api(IMsgSendHelper::class.java)");
            IMsgSendHelper iMsgSendHelper = (IMsgSendHelper) api2;
            Iterator it = contacts.iterator();
            while (it.hasNext()) {
                ResultRecord resultRecord = (ResultRecord) it.next();
                String uid = iRelationNTUinAndUidApi.getUidFromUin(resultRecord.uin);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                if (uid.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.e("NotifyCardUtil", 1, resultRecord.uin + " convert uid failed!");
                } else {
                    iMsgSendHelper.sendText(uid, 1, msgContent);
                }
            }
        }

        public final boolean b(@NotNull ContainerData first, @NotNull ContainerData second) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) first, (Object) second)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            if (first.n() == second.n() && first.i() == second.i() && Intrinsics.areEqual(first.j(), second.j()) && Intrinsics.areEqual(first.l(), second.l()) && Intrinsics.areEqual(first.k(), second.k()) && Intrinsics.areEqual(first.o(), second.o()) && Intrinsics.areEqual(first.h(), second.h())) {
                return true;
            }
            return false;
        }

        public final void c(@NotNull final List<? extends ResultRecord> contacts, @NotNull final String msgContent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) contacts, (Object) msgContent);
                return;
            }
            Intrinsics.checkNotNullParameter(contacts, "contacts");
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            if (!contacts.isEmpty()) {
                if (msgContent.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.reminder.util.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.Companion.d(contacts, msgContent);
                        }
                    }, 16, null, false);
                }
            }
        }

        public final void e(@NotNull Context context, @NotNull com.tencent.mobileqq.reminder.multishare.config.a config) {
            IFriendDataService iFriendDataService;
            ArrayList arrayListOf;
            String str;
            Friends friends;
            String str2;
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) config);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            if (config.d().isEmpty()) {
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            QLog.d("NotifyCardUtil", 1, "showMultiShare context: " + context + " topActivity: " + topActivity);
            if (topActivity != null && (!(context instanceof FragmentActivity) || !Intrinsics.areEqual(context, topActivity))) {
                context = topActivity;
            }
            ArrayList arrayList = new ArrayList();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
            } else {
                iFriendDataService = null;
            }
            for (String str3 : config.d()) {
                if (iFriendDataService != null) {
                    friends = iFriendDataService.getFriendFromMemoryCache(str3);
                } else {
                    friends = null;
                }
                if (friends != null) {
                    str2 = friends.remark;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    if (friends != null) {
                        str2 = friends.name;
                    } else {
                        str2 = null;
                    }
                }
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    str2 = str3;
                }
                arrayList.add(new com.tencent.mobileqq.multishare.action.c(str3, 0, str2));
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new MultiShareEmoPanelPart());
            com.tencent.mobileqq.multishare.config.a aVar = new com.tencent.mobileqq.multishare.config.a();
            MultiShareEventListener multiShareEventListener = new MultiShareEventListener(config.a(), config.b());
            aVar.B(arrayList);
            aVar.A(new com.tencent.mobileqq.reminder.multishare.listener.c(config.d(), config.c()));
            aVar.t(multiShareEventListener);
            aVar.z(multiShareEventListener);
            aVar.y(multiShareEventListener);
            aVar.v(config.a());
            if (arrayList.size() > 1) {
                str = "\u5206\u522b\u53d1\u9001";
            } else {
                str = "\u53d1\u9001";
            }
            aVar.C(str);
            aVar.s(arrayListOf);
            aVar.r(true);
            aVar.u(multiShareEventListener);
            Intent intent = new Intent();
            QRouteApi api = QRoute.api(IMultiShareApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMultiShareApi::class.java)");
            IMultiShareApi iMultiShareApi = (IMultiShareApi) api;
            multiShareEventListener.g(iMultiShareApi);
            iMultiShareApi.createPanel(aVar);
            iMultiShareApi.setForwardIntent(intent);
            iMultiShareApi.showPanel(context);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30730);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
