package com.tencent.mobileqq.guild.channel.managev2;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM$mAction$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.BaseVM;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\u000f\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "l", "com/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM$mAction$2$a", "d", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM$mAction$2$a;", "mAction", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class ChannelSettingBaseVM extends BaseVM<b, ChannelSettingUIState, ChannelSettingMviContext> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAction;

    public ChannelSettingBaseVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChannelSettingBaseVM$mAction$2.a>() { // from class: com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM$mAction$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM$mAction$2$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements com.tencent.mvi.base.route.a {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ChannelSettingBaseVM f215123d;

                a(ChannelSettingBaseVM channelSettingBaseVM) {
                    this.f215123d = channelSettingBaseVM;
                }

                @Override // com.tencent.mvi.base.route.a
                public void call(@NotNull MsgIntent i3) {
                    Intrinsics.checkNotNullParameter(i3, "i");
                    this.f215123d.l(i3);
                }

                @Override // com.tencent.mvi.base.route.a
                public boolean sticky() {
                    return a.C9235a.a(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(ChannelSettingBaseVM.this);
            }
        });
        this.mAction = lazy;
    }

    private final ChannelSettingBaseVM$mAction$2.a j() {
        return (ChannelSettingBaseVM$mAction$2.a) this.mAction.getValue();
    }

    public void l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m */
    public void onCreate(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((ChannelSettingBaseVM) context);
        List<String> n3 = n();
        if (n3 != null) {
            Iterator<T> it = n3.iterator();
            while (it.hasNext()) {
                context.e().d((String) it.next(), j());
            }
        }
    }

    @Nullable
    public List<String> n() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        List<String> n3 = n();
        if (n3 != null) {
            Iterator<T> it = n3.iterator();
            while (it.hasNext()) {
                ((ChannelSettingMviContext) getMContext()).e().b((String) it.next(), j());
            }
        }
    }
}
