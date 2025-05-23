package com.tencent.guild.aio.msglist.graytips.special.essence;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.graytips.special.essence.GuildEssenceGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.essence.c;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.l;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B)\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010(\u001a\u00020!\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/d;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", "tinyId", "", "o", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "essenceElement", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lol3/b;", "intent", "handleIntent", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "getMGuildMsgItem", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "setMGuildMsgItem", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "mGuildMsgItem", "e", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "getMEssenceElement", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "setMEssenceElement", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;)V", "mEssenceElement", "", "f", "Z", "getMNeedUpdateGrayTipNick", "()Z", "setMNeedUpdateGrayTipNick", "(Z)V", "mNeedUpdateGrayTipNick", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;Z)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem mGuildMsgItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EssenceElement mEssenceElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedUpdateGrayTipNick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/graytips/special/essence/d$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            d.this.o(tinyId);
        }
    }

    public /* synthetic */ d(GuildMsgItem guildMsgItem, EssenceElement essenceElement, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : guildMsgItem, (i3 & 2) != 0 ? null : essenceElement, (i3 & 4) != 0 ? false : z16);
    }

    private final void m(GuildMsgItem guildMsgItem, EssenceElement essenceElement) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        String obj;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
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
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, String.valueOf(essenceElement.tinyId))) {
            this.mNeedUpdateGrayTipNick = true;
            String valueOf = String.valueOf(essenceElement.tinyId);
            String str2 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "guildMsgItem.msgRecord.guildId");
            obj = iq0.a.u(valueOf, str2);
        } else {
            obj = l.b(l.f112411a, R.string.f1385409u, null, 2, null).toString();
        }
        updateUI(new GuildEssenceGrayTipsUIState.SetEssenceText(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(EssenceElement essenceElement) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildEssenceGrayTipsVM", essenceElement.msgSeq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String tinyId) {
        EssenceElement essenceElement;
        if (this.mGuildMsgItem != null && (essenceElement = this.mEssenceElement) != null) {
            Intrinsics.checkNotNull(essenceElement);
            if (TextUtils.equals(tinyId, String.valueOf(essenceElement.tinyId)) && this.mNeedUpdateGrayTipNick) {
                GuildMsgItem guildMsgItem = this.mGuildMsgItem;
                Intrinsics.checkNotNull(guildMsgItem);
                EssenceElement essenceElement2 = this.mEssenceElement;
                Intrinsics.checkNotNull(essenceElement2);
                m(guildMsgItem, essenceElement2);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.b) {
            c.b bVar = (c.b) intent;
            this.mEssenceElement = bVar.getEssenceElement();
            this.mGuildMsgItem = bVar.getGuildMsgItem();
            m(bVar.getGuildMsgItem(), bVar.getEssenceElement());
            return;
        }
        if (intent instanceof c.a) {
            c.a aVar = (c.a) intent;
            this.mEssenceElement = aVar.getEssenceElement();
            n(aVar.getEssenceElement());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.observer);
        }
    }

    public d(@Nullable GuildMsgItem guildMsgItem, @Nullable EssenceElement essenceElement, boolean z16) {
        this.mGuildMsgItem = guildMsgItem;
        this.mEssenceElement = essenceElement;
        this.mNeedUpdateGrayTipNick = z16;
        this.observer = new b();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.observer);
        }
    }
}
