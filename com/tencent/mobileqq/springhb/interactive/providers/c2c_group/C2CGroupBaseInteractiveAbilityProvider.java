package com.tencent.mobileqq.springhb.interactive.providers.c2c_group;

import android.os.Bundle;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0016\u001a\u00020\u0002*\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u00020\u0002*\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/providers/c2c_group/C2CGroupBaseInteractiveAbilityProvider;", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "", "g", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/msg/d;", "msg", "e", "c", "Lkotlinx/coroutines/flow/Flow;", "b", "f", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "a", "Lcom/tencent/aio/api/help/a;", "Lcom/tencent/aio/api/help/a;", "param", "Landroid/os/Bundle;", "i", "(Landroid/os/Bundle;)Z", "isScaleChatAIO", h.F, "isMiniAio", "<init>", "(Lcom/tencent/aio/api/help/a;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class C2CGroupBaseInteractiveAbilityProvider implements com.tencent.mobileqq.springhb.interactive.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f289277b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.help.a param;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/providers/c2c_group/C2CGroupBaseInteractiveAbilityProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f289277b = new a(null);
        }
    }

    public C2CGroupBaseInteractiveAbilityProvider(@NotNull com.tencent.aio.api.help.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        } else {
            this.param = param;
        }
    }

    private final boolean h(Bundle bundle) {
        return bundle.getBoolean("key_is_miniaio");
    }

    private final boolean i(Bundle bundle) {
        return bundle.getBoolean("key_is_scale_chat");
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public InteractiveRecord a(@NotNull final d record) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InteractiveRecord) iPatchRedirector.redirect((short) 7, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        return new InteractiveRecord(record) { // from class: com.tencent.mobileqq.springhb.interactive.providers.c2c_group.C2CGroupBaseInteractiveAbilityProvider$recordCovertInteractiveRecord$1
            static IPatchRedirector $redirector_;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy msgContent;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(record);
                Lazy lazy;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.springhb.interactive.providers.c2c_group.C2CGroupBaseInteractiveAbilityProvider$recordCovertInteractiveRecord$1$msgContent$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) d.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                            StringBuilder sb5 = new StringBuilder();
                            ArrayList<MsgElement> arrayList = d.this.a().elements;
                            Intrinsics.checkNotNullExpressionValue(arrayList, "record.msgRecord.elements");
                            for (MsgElement msgElement : arrayList) {
                                if (msgElement.elementType == 1) {
                                    sb5.append(msgElement.textElement.content);
                                }
                            }
                            return sb5.toString();
                        }
                    });
                    this.msgContent = lazy;
                } else {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) record);
                }
            }

            @NotNull
            public final String q() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return (String) this.msgContent.getValue();
            }

            @Override // com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord
            @NotNull
            public String r() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (String) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                String msgContent = q();
                Intrinsics.checkNotNullExpressionValue(msgContent, "msgContent");
                return msgContent;
            }
        };
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public Flow<d> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Flow) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean c(@NotNull d msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        MsgRecord a16 = msg2.a();
        if (a16.msgType != 2) {
            return false;
        }
        ArrayList<MsgElement> arrayList = a16.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean e(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull d msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (aioContext == null) {
            return false;
        }
        return Intrinsics.areEqual(msg2.a().peerUid, aioContext.g().r().c().j());
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public Flow<d> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Flow) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return FlowKt.flatMapConcat(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new C2CGroupBaseInteractiveAbilityProvider$getReceiveMsgNotificationFlow$1(null));
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean g() {
        Bundle l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        AIOParam a16 = this.param.a();
        if (a16 == null || (l3 = a16.l()) == null || (!h(l3) && !i(l3))) {
            return true;
        }
        QLog.d("C2CGroupBaseInteractiveAbilityProvider", 1, "mini or scale can not support !!");
        return false;
    }
}
