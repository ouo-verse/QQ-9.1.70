package com.tencent.qqguild.directmessage.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.l;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0016\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u001b\u0010,\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/DirectMessageHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/l;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/qqguild/base/mvvm/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "e", "Lcom/tencent/qqguild/directmessage/aio/DirectMessageError;", "error", "o", DomainData.DOMAIN_NAME, "Ljava/util/HashMap;", "", "", "i", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "account", "onAccountChanged", "state", "onMoveToState", "", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", "list", "r0", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "f", "Lkotlin/Lazy;", "k", "()Lcom/tencent/qqguild/base/mvvm/b;", "onMessageEvent", h.F, "()Ljava/lang/String;", "channelId", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "activityContext", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "j", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class DirectMessageHelper implements com.tencent.aio.main.businesshelper.h, l, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ServiceCache$LazyHolder serviceHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy onMessageEvent;

    public DirectMessageHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqguild.base.mvvm.b>() { // from class: com.tencent.qqguild.directmessage.aio.DirectMessageHelper$onMessageEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqguild.base.mvvm.b invoke() {
                com.tencent.qqguild.base.mvvm.b m3;
                m3 = DirectMessageHelper.this.m();
                return m3;
            }
        });
        this.onMessageEvent = lazy;
    }

    private final void e() {
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, "fetchUserDisplayName() find node which channelId = " + h());
        DirectMessageNode C = DirectMessageNodeRepository.C(h());
        if (C != null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            j e16 = aVar.e();
            String guildUserDisplayName = j().getGuildUserDisplayName(C.getSource().getGuildId(), C.getSource().getTinyId());
            Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "igpsService.getGuildUser\u2026ldId, node.source.tinyId)");
            e16.h(new DirectMessageNodeUpdateEvent(C, guildUserDisplayName, "fetchUser"));
            return;
        }
        logger.d().i("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, "fetchUserDisplayName() not find node which channelId = " + h());
    }

    private final Context g() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 == null) {
            return null;
        }
        return c16.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return com.tencent.guild.aio.util.a.b(g16);
    }

    private final HashMap<String, Object> i() {
        String str;
        MessageSource source;
        String guildId;
        MessageSource source2;
        HashMap<String, Object> hashMap = new HashMap<>();
        DirectMessageNode C = DirectMessageNodeRepository.C(h());
        String str2 = "unknown";
        if (C == null || (source2 = C.getSource()) == null || (str = source2.getTinyId()) == null) {
            str = "unknown";
        }
        if (C != null && (source = C.getSource()) != null && (guildId = source.getGuildId()) != null) {
            str2 = guildId;
        }
        hashMap.put("sgrp_channel_id", str2);
        hashMap.put("touin", str);
        hashMap.put("sgrp_channel_id", str2);
        hashMap.put("sgrp_user_type", Integer.valueOf(v.c(str2)));
        hashMap.put("sgrp_login_flag", 1);
        hashMap.put("sgrp_duration_flag", 1);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Parcelable parcelable = aVar.g().l().getParcelable("GuildAppReportSourceInfo");
        if (parcelable instanceof GuildAppReportSourceInfo) {
            hashMap.putAll(((GuildAppReportSourceInfo) parcelable).getReportInfoMap());
        }
        return hashMap;
    }

    private final IGPSService j() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = this.serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.b();
    }

    private final com.tencent.qqguild.base.mvvm.b k() {
        return (com.tencent.qqguild.base.mvvm.b) this.onMessageEvent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqguild.base.mvvm.b m() {
        return new com.tencent.qqguild.base.mvvm.b(new Function1<MsgIntent, Unit>() { // from class: com.tencent.qqguild.directmessage.aio.DirectMessageHelper$newMessageEventHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgIntent msgIntent) {
                invoke2(msgIntent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgIntent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof DirectMessageError) {
                    DirectMessageHelper.this.o((DirectMessageError) event);
                    return;
                }
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "unknown event: " + event;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, (String) it.next(), null);
                }
            }
        });
    }

    private final void n() {
        Logger.f235387a.d().i("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, "setupDtAutoReport");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        View view = aVar.c().getView();
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        VideoReport.addToDetectionWhitelist(aVar2.c().getActivity());
        VideoReport.resetPageParams(view);
        VideoReport.setPageId(view, "pg_sgrp_private_aio");
        VideoReport.setPageParams(view, new PageParams(i()));
        VideoReport.setPageContentId(view, String.valueOf(SystemClock.elapsedRealtime()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(DirectMessageError error) {
        String errorMessage;
        boolean z16;
        Context g16 = g();
        if (g16 == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("activityContext is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, (String) it.next(), null);
            }
            return;
        }
        Resources resources = g16.getResources();
        switch (error.getErrorCode()) {
            case 100100:
                errorMessage = resources.getString(R.string.f155821ij);
                break;
            case 100306:
                errorMessage = resources.getString(R.string.f15194192);
                break;
            case 100308:
                errorMessage = resources.getString(R.string.f156871ld);
                break;
            case BusinessInfoCheckUpdateItem.UIAPPID_MYDEVICE /* 100701 */:
                errorMessage = resources.getString(R.string.f146630up);
                break;
            case BusinessInfoCheckUpdateItem.UIAPPID_NEWDEVICE /* 100702 */:
                errorMessage = resources.getString(R.string.f1517618k);
                break;
            case 100707:
                errorMessage = resources.getString(R.string.f155791ig);
                break;
            default:
                errorMessage = error.getErrorMessage();
                break;
        }
        if (errorMessage != null && errorMessage.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str = "SendMessageError: " + error.getErrorCode() + " " + error.getErrorMessage();
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, (String) it5.next(), null);
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar3 = new Logger.b();
        String str2 = "Show toast " + errorMessage + ", SendMessageError: " + error.getErrorCode();
        if (str2 instanceof String) {
            bVar3.a().add(str2);
        }
        Iterator<T> it6 = bVar3.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.AIO.GuildAio.DirectMessageHelper", 1, (String) it6.next(), null);
        }
        QQToast.makeText(g16, errorMessage, 1).show();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 10;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "Guild.C2C.AIO.GuildAio.DirectMessageHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12, 3, 8};
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.serviceHolder = new ServiceCache$LazyHolder("Guild.C2C.AIO.GuildAio.DirectMessageHelper");
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        com.tencent.guild.aio.util.a.g(g16);
        this.serviceHolder = new ServiceCache$LazyHolder("Guild.C2C.AIO.GuildAio.DirectMessageHelper");
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().d(Reflection.getOrCreateKotlinClass(DirectMessageError.class).getQualifiedName(), k());
        DirectMessageNodeRepository.p(this);
        e();
        AccountChangedNotifier.f214789d.a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().b(Reflection.getOrCreateKotlinClass(DirectMessageError.class).getQualifiedName(), k());
        DirectMessageNodeRepository.W(this);
        AccountChangedNotifier.f214789d.d(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            n();
        }
    }

    @Override // com.tencent.mobileqq.guild.message.directmessage.model.repositories.l
    public void r0(@NotNull List<DirectMessageNode> list) {
        com.tencent.aio.api.runtime.a aVar;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        DirectMessageNodeRepository.C(h());
        Iterator<T> it = list.iterator();
        while (true) {
            aVar = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DirectMessageNode) obj).getChannelId(), h())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DirectMessageNode directMessageNode = (DirectMessageNode) obj;
        if (directMessageNode != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            j e16 = aVar.e();
            String guildUserDisplayName = j().getGuildUserDisplayName(directMessageNode.getSource().getGuildId(), directMessageNode.getSource().getTinyId());
            Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "igpsService.getGuildUser\u2026ldId, node.source.tinyId)");
            e16.h(new DirectMessageNodeUpdateEvent(directMessageNode, guildUserDisplayName, "nodeChangeCallback"));
        }
    }
}
