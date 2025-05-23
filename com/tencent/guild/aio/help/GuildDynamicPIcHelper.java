package com.tencent.guild.aio.help;

import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.help.GuildDynamicPIcHelper$scrollListener$2;
import com.tencent.guild.aio.msglist.video.GuildVideoViewer;
import com.tencent.guild.api.gift.IGuildGiftComponentApi;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\n*\u0001\u0012\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/help/GuildDynamicPIcHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "c", "b", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "com/tencent/guild/aio/help/GuildDynamicPIcHelper$scrollListener$2$a", "e", "Lkotlin/Lazy;", "()Lcom/tencent/guild/aio/help/GuildDynamicPIcHelper$scrollListener$2$a;", "scrollListener", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildDynamicPIcHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    public GuildDynamicPIcHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildDynamicPIcHelper$scrollListener$2.a>() { // from class: com.tencent.guild.aio.help.GuildDynamicPIcHelper$scrollListener$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/help/GuildDynamicPIcHelper$scrollListener$2$a", "Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack;", "", "state", "", "onScrollStateChange", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes6.dex */
            public static final class a implements AIOServiceContact$IRecycleViewScrollCallBack {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildDynamicPIcHelper f110754d;

                a(GuildDynamicPIcHelper guildDynamicPIcHelper) {
                    this.f110754d = guildDynamicPIcHelper;
                }

                @Override // com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack
                public void onScrollStateChange(int state) {
                    com.tencent.aio.main.businesshelper.b bVar;
                    com.tencent.aio.main.businesshelper.b bVar2;
                    com.tencent.aio.main.businesshelper.b bVar3;
                    com.tencent.aio.api.runtime.a a16;
                    com.tencent.mvi.base.route.j e16;
                    com.tencent.aio.api.runtime.a a17;
                    com.tencent.mvi.base.route.j e17;
                    com.tencent.aio.api.runtime.a a18;
                    com.tencent.mvi.base.route.j e18;
                    com.tencent.aio.main.businesshelper.b bVar4;
                    com.tencent.aio.main.businesshelper.b bVar5;
                    com.tencent.aio.api.runtime.a a19;
                    com.tencent.mvi.base.route.j e19;
                    com.tencent.aio.api.runtime.a a26;
                    com.tencent.mvi.base.route.j e26;
                    if (state != 0) {
                        if (state == 1 || state == 2) {
                            AbstractGifImage.pauseAll();
                            ApngImage.pauseAll();
                            bVar4 = this.f110754d.param;
                            if (bVar4 != null && (a26 = bVar4.a()) != null && (e26 = a26.e()) != null) {
                                e26.h(new GuildMsgListIntent.GuildApngPlayEvent(false));
                            }
                            URLDrawable.pause();
                            ((IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class)).setPause(true);
                            bVar5 = this.f110754d.param;
                            if (bVar5 != null && (a19 = bVar5.a()) != null && (e19 = a19.e()) != null) {
                                e19.h(new GuildMsgListIntent.GuildGiftPlayEvent(true));
                            }
                            GuildVideoViewer.f111960n.b();
                            return;
                        }
                        return;
                    }
                    AbstractGifImage.resumeAll();
                    ApngImage.resumeAll();
                    bVar = this.f110754d.param;
                    if (bVar != null && (a18 = bVar.a()) != null && (e18 = a18.e()) != null) {
                        e18.h(new GuildMsgListIntent.GuildApngPlayEvent(true));
                    }
                    URLDrawable.resume();
                    ((IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class)).setPause(false);
                    bVar2 = this.f110754d.param;
                    if (bVar2 != null && (a17 = bVar2.a()) != null && (e17 = a17.e()) != null) {
                        e17.h(new GuildMsgListIntent.GuildGiftPlayEvent(false));
                    }
                    GuildVideoViewer.f111960n.a();
                    bVar3 = this.f110754d.param;
                    if (bVar3 != null && (a16 = bVar3.a()) != null && (e16 = a16.e()) != null) {
                        e16.h(new GuildMsgListIntent.GuildVideoPlayEvent(false, false));
                    }
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
                return new a(GuildDynamicPIcHelper.this);
            }
        });
        this.scrollListener = lazy;
    }

    private final void b() {
        QLog.d("GuildDynamicPIcHelper", 4, "doOnCreate");
        ((IGuildGiftComponentApi) QRoute.api(IGuildGiftComponentApi.class)).preLoadPag();
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null) {
            bVar.a().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).a(e());
        }
        QQSysAndEmojiResMgr.getInstance().refreshConfig();
    }

    private final void c() {
        QLog.d("GuildDynamicPIcHelper", 4, "doOnDestroy");
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null) {
            bVar.a().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).c(e());
        }
    }

    private final GuildDynamicPIcHelper$scrollListener$2.a e() {
        return (GuildDynamicPIcHelper$scrollListener$2.a) this.scrollListener.getValue();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 20;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildDynamicPIcHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
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
                c();
                return;
            }
            return;
        }
        b();
    }
}
