package com.tencent.mobileqq.springhb.interactive.providers.guild;

import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.api.b;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/providers/guild/GuildInteractiveHelperProvider;", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "", "g", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/msg/d;", "msg", "e", "c", "Lkotlinx/coroutines/flow/Flow;", "b", "f", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "a", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "d", "Lcom/tencent/aio/api/help/a;", "Lcom/tencent/aio/api/help/a;", "param", "<init>", "(Lcom/tencent/aio/api/help/a;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildInteractiveHelperProvider implements b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f289280b = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.help.a param;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/providers/guild/GuildInteractiveHelperProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public GuildInteractiveHelperProvider(@NotNull com.tencent.aio.api.help.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public InteractiveRecord a(@NotNull final d record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return new InteractiveRecord() { // from class: com.tencent.mobileqq.springhb.interactive.providers.guild.GuildInteractiveHelperProvider$recordCovertInteractiveRecord$1

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy msgContent;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(d.this);
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.springhb.interactive.providers.guild.GuildInteractiveHelperProvider$recordCovertInteractiveRecord$1$msgContent$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
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
            }

            @Override // com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord, com.tencent.mobileqq.springhb.interactive.config.b
            public boolean b() {
                AppInterface appInterface;
                IRuntimeService iRuntimeService;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String str = null;
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    str = iGPSService.getSelfTinyId();
                }
                return TextUtils.equals(str, MsgExtKt.m(d.this));
            }

            @NotNull
            public final String q() {
                return (String) this.msgContent.getValue();
            }

            @Override // com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord
            @NotNull
            public String r() {
                String msgContent = q();
                Intrinsics.checkNotNullExpressionValue(msgContent, "msgContent");
                return msgContent;
            }
        };
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public Flow<d> b() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow();
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean c(@NotNull d msg2) {
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
    @NotNull
    public com.tencent.mobileqq.springhb.interactive.api.a d() {
        return com.tencent.mobileqq.springhb.interactive.frequencyControl.b.f289236a;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean e(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull d msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (aioContext == null) {
            return false;
        }
        String j3 = aioContext.g().r().c().j();
        int e16 = aioContext.g().r().c().e();
        if (!Intrinsics.areEqual(msg2.a().peerUid, j3) || msg2.a().chatType != e16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public Flow<d> f() {
        return FlowKt.flatMapConcat(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1(null));
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    public boolean g() {
        String str;
        AIOParam a16 = this.param.a();
        if (a16 != null) {
            str = a16.n();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, com.tencent.guild.aio.factory.a.class.getName());
    }
}
