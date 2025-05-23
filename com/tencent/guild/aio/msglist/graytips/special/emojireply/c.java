package com.tencent.guild.aio.msglist.graytips.special.emojireply;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.graytips.special.emojireply.GuildEmojiReplyGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.emojireply.b;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u001d\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0018\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/c;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", "tinyId", "", "o", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "emojiReplyElement", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lol3/b;", "intent", "handleIntent", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "getMEmojiReplyElement", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "setMEmojiReplyElement", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;)V", "mEmojiReplyElement", "", "e", "Z", "getMNeedUpdateGrayTipNick", "()Z", "setMNeedUpdateGrayTipNick", "(Z)V", "mNeedUpdateGrayTipNick", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observer", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;Z)V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EmojiReplyElement mEmojiReplyElement;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedUpdateGrayTipNick;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/graytips/special/emojireply/c$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            c.this.o(tinyId);
        }
    }

    public /* synthetic */ c(EmojiReplyElement emojiReplyElement, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : emojiReplyElement, (i3 & 2) != 0 ? false : z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(EmojiReplyElement emojiReplyElement) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        String obj;
        String str2;
        String str3;
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
        if (!TextUtils.equals(str, String.valueOf(emojiReplyElement.tinyId))) {
            this.mNeedUpdateGrayTipNick = true;
            if (iGPSService != null) {
                str3 = iGPSService.getGuildUserDisplayName(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().f(), String.valueOf(emojiReplyElement.tinyId));
            } else {
                str3 = null;
            }
            str2 = String.valueOf(str3);
            obj = l.b(l.f112411a, R.string.f1385509v, null, 2, null).toString();
        } else {
            l lVar = l.f112411a;
            String obj2 = l.b(lVar, R.string.f1385409u, null, 2, null).toString();
            obj = l.b(lVar, R.string.f1385309t, null, 2, null).toString();
            str2 = obj2;
        }
        updateUI(new GuildEmojiReplyGrayTipsUIState.SetEmojiReplyText(str2, obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(EmojiReplyElement emojiReplyElement) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildEmojiReplyGrayTipsVM", emojiReplyElement.msgSeq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String tinyId) {
        EmojiReplyElement emojiReplyElement = this.mEmojiReplyElement;
        if (emojiReplyElement == null) {
            return;
        }
        Intrinsics.checkNotNull(emojiReplyElement);
        if (TextUtils.equals(tinyId, String.valueOf(emojiReplyElement.tinyId)) && this.mNeedUpdateGrayTipNick) {
            EmojiReplyElement emojiReplyElement2 = this.mEmojiReplyElement;
            Intrinsics.checkNotNull(emojiReplyElement2);
            m(emojiReplyElement2);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C1197b) {
            b.C1197b c1197b = (b.C1197b) intent;
            this.mEmojiReplyElement = c1197b.getEmojiReplyElement();
            m(c1197b.getEmojiReplyElement());
        } else if (intent instanceof b.a) {
            b.a aVar = (b.a) intent;
            this.mEmojiReplyElement = aVar.getEmojiReplyElement();
            n(aVar.getEmojiReplyElement());
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

    public c(@Nullable EmojiReplyElement emojiReplyElement, boolean z16) {
        this.mEmojiReplyElement = emojiReplyElement;
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
