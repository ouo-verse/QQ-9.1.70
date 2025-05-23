package com.tencent.mobileqq.aio.msglist.msgprocessor;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/f;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgprocessor/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.msgprocessor.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (QLog.isDevelopLevel()) {
            QLog.d("PaiYiPaiMsgProcessor", 2, "beforeMsgToScreen displayList size=" + displayList.size());
        }
        AIOContact c16 = b().g().r().c();
        int e16 = c16.e();
        if (e16 == 2 || e16 == 1) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) displayList);
            Iterator it = mutableList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) it.next();
                if ((aVar instanceof GrayTipsMsgItem) && com.tencent.mobileqq.aio.utils.d.J((AIOMsgItem) aVar)) {
                    if (!((IPaiYiPaiApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPaiYiPaiApi.class)).shouldAddGuideTip()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PaiYiPaiMsgProcessor", 2, "shouldAddGuideTip false");
                        }
                        return displayList;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PaiYiPaiMsgProcessor", 2, "beforeMsgToScreen really add GrayTip");
                    }
                    BaseApplication baseApplication = BaseApplication.context;
                    LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(c16.j(), c16.e(), 2041L, 0, true, false, null, 72, null);
                    String string = baseApplication.getString(R.string.f173142sc);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026pai_double_tap_tips_head)");
                    LocalGrayTip.LocalGrayTipBuilder j3 = LocalGrayTip.LocalGrayTipBuilder.j(localGrayTipBuilder, string, new com.tencent.qqnt.graytips.action.i(), 0, 4, null);
                    String string2 = baseApplication.getString(R.string.f173132sb);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026i_yi_pai_double_tap_tips)");
                    LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(j3, string2, 0, 2, null).m();
                    INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                    iNtGrayTipApi.addLocalGrayTip(peekAppRuntime, m3, null);
                }
            }
            return displayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiMsgProcessor", 2, "beforeMsgToScreen chatType " + e16);
        }
        return displayList;
    }
}
