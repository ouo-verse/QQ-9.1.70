package com.tencent.qqnt.aio.contact.profile;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/n;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "b", "a", "", "", "Ljava/util/List;", "getFilterUin", "()Ljava/util/List;", "filterUin", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> filterUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.contact.profile.n$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
            this.filterUin = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(QQAppInterface app, Context context, AIOMsgItem msgItem) {
        boolean z16;
        AllInOne allInOne;
        if (app == null || msgItem.getMsgRecord().chatType != 2) {
            return false;
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(msgItem.getMsgRecord().peerUin));
        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        QLog.i("SimpleFilterInterceptor", 1, "[jumpProfileIfIsExitTroop] exit troop");
        boolean isSelf = msgItem.isSelf();
        String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
        String valueOf2 = String.valueOf(msgItem.getMsgRecord().peerUin);
        int i3 = msgItem.getMsgRecord().chatType;
        if (TextUtils.isEmpty(valueOf)) {
            return true;
        }
        if (isSelf) {
            allInOne = new AllInOne(app.getCurrentAccountUin(), 0);
            allInOne.nickname = app.getCurrentNickname();
        } else if (com.tencent.qqnt.contact.friends.b.f355778a.c(valueOf, "SimpleFilterInterceptor")) {
            allInOne = new AllInOne(valueOf, 1);
            allInOne.nickname = ac.G(app, valueOf);
        } else {
            allInOne = new AllInOne(valueOf, 35);
        }
        allInOne.preWinUin = valueOf2;
        allInOne.preWinType = i3;
        allInOne.lastActivity = 2;
        allInOne.uid = msgItem.getMsgRecord().senderUid;
        ProfileUtils.openProfileCard(context, allInOne);
        return true;
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (this.filterUin.contains(String.valueOf(msgItem.getMsgRecord().senderUin)) || b(qQAppInterface, context, msgItem)) {
            return true;
        }
        if (Utils.G(String.valueOf(msgItem.getMsgRecord().senderUin)) && BusinessUtils.X(context)) {
            return true;
        }
        if (1000000 == msgItem.getMsgRecord().senderUin) {
            if (qQAppInterface != null && (context instanceof Activity)) {
                TroopUtils.S(qQAppInterface, (Activity) context, String.valueOf(msgItem.getMsgRecord().peerUin), "1");
            }
            return true;
        }
        return false;
    }
}
