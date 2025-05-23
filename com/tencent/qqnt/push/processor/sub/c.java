package com.tencent.qqnt.push.processor.sub;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x857.TroopTips0x857$GroupNotifyInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/push/processor/sub/c;", "Lcom/tencent/qqnt/push/b;", "", "notifyMsgBody", "Lcom/tencent/qqnt/push/bean/a;", "commonInfo", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c implements com.tencent.qqnt.push.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/sub/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.sub.c$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.push.b
    public void a(@Nullable Object notifyMsgBody, @NotNull com.tencent.qqnt.push.bean.a commonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, notifyMsgBody, (Object) commonInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        if (notifyMsgBody instanceof TroopTips0x857$NotifyMsgBody) {
            TroopTips0x857$NotifyMsgBody troopTips0x857$NotifyMsgBody = (TroopTips0x857$NotifyMsgBody) notifyMsgBody;
            if (troopTips0x857$NotifyMsgBody.opt_msg_group_notify.has()) {
                long a16 = commonInfo.a();
                TroopTips0x857$GroupNotifyInfo troopTips0x857$GroupNotifyInfo = troopTips0x857$NotifyMsgBody.opt_msg_group_notify.get();
                Intrinsics.checkNotNullExpressionValue(troopTips0x857$GroupNotifyInfo, "notifyMsgBody.opt_msg_group_notify.get()");
                TroopTips0x857$GroupNotifyInfo troopTips0x857$GroupNotifyInfo2 = troopTips0x857$GroupNotifyInfo;
                int i3 = troopTips0x857$GroupNotifyInfo2.opt_uint32_auto_pull_flag.get();
                String stringUtf8 = troopTips0x857$GroupNotifyInfo2.opt_bytes_feeds_id.get().toStringUtf8();
                QLog.i("CenterSubProcessor", 1, "[process] troopUin:" + a16 + ", autoPullFlag:" + i3 + ", feedId:" + stringUtf8);
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).notifyTroopCenter(bg.e(), a16, i3, stringUtf8);
            }
        }
    }
}
