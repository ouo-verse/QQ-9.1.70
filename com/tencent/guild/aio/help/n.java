package com.tencent.guild.aio.help;

import android.os.Handler;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.help.n;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qqguildsdk.data.eo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\u0019\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/help/n;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "j", "e", "i", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldAddGrayTip", "com/tencent/guild/aio/help/n$b", "f", "Lcom/tencent/guild/aio/help/n$b;", "action", "<init>", "()V", tl.h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class n implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean shouldAddGrayTip = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/n$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(n this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.shouldAddGrayTip.get()) {
                this$0.e();
                this$0.shouldAddGrayTip.set(false);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildMsgListIntent.LoadFirstPageFinEvent) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final n nVar = n.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.guild.aio.help.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.b.b(n.this);
                    }
                });
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        AIOParam g18 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g18, "mAIOContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g18);
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setChannelShowedBlockAdsTip(b16);
        Contact contact = new Contact(4, b16, g17);
        String format = String.format("<gtip align=\"left\"><img src=\"%s\"/><nor txt=\"%s\"/></gtip>", Arrays.copyOf(new Object[]{"https://downv6.qq.com/innovate/guild/wordChannel/grayTip/gray_tip_info.png", HardCodeUtil.qqStr(R.string.f1629021o)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        ((IMsgService) QRoute.api(IMsgService.class)).addLocalGrayTipMsg(contact, new LocalGrayTipElement(8, null, null, format), true, null);
    }

    private final void g() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).preloadSpeakRule(com.tencent.guild.aio.util.a.g(g16), new wh2.f() { // from class: com.tencent.guild.aio.help.m
            @Override // wh2.f
            public final void a(int i3, String str, eo eoVar) {
                n.h(n.this, i3, str, eoVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(n this$0, int i3, String str, eo eoVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eoVar != null && !eoVar.c()) {
            this$0.j();
        }
    }

    private final void i() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.LoadFirstPageFinEvent.class).getQualifiedName(), this.action);
    }

    private final void j() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        i.e eVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mAIOContext.aioParam");
        if (((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).isChannelShowedBlockAdsTip(com.tencent.guild.aio.util.a.b(g16))) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        AIOParam g17 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mAIOContext.aioParam");
        if (com.tencent.guild.aio.util.a.k(g17)) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar3 = null;
            }
            com.tencent.mvi.base.route.k k3 = aVar3.e().k(GuildMsgListIntent.GetLoadFirstPageFin.f110413d);
            if (k3 instanceof i.e) {
                eVar = (i.e) k3;
            }
            if (eVar != null) {
                z16 = eVar.getResult();
            } else {
                z16 = true;
            }
            if (z16) {
                e();
                return;
            } else {
                this.shouldAddGrayTip.set(true);
                return;
            }
        }
        e();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 31;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildSpeakRuleTipsHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
        this.shouldAddGrayTip.set(false);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.LoadFirstPageFinEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state == 12) {
                i();
                return;
            }
            return;
        }
        g();
    }
}
