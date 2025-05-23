package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.api.IVipDataUpdateApi;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.mobileqq.vas.troop.api.ITroopGameInfo;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.vipicon.NamePlateVipType;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgAvatarPendant;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgIceBreak;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgNamePlate;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p33.ScannerData;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0010B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/VasAIODataProcessor;", "Lcom/tencent/qqnt/aio/msg/b;", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "personalData", "", "uin", "uid", "", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgAvatarPendant;", "c", "", "getBusinessType", "a", "Lcom/tencent/mobileqq/vas/al;", "Lcom/tencent/mobileqq/vas/al;", "frequency", "<init>", "()V", "b", "Companion", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class VasAIODataProcessor implements com.tencent.qqnt.aio.msg.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f307852c = QLog.isColorLevel();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final al frequency = new al();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/VasAIODataProcessor$Companion;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lkotlin/Function1;", "", "", "b", "TAG", "Ljava/lang/String;", "", "isPrintLog", "Z", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function1<String, Unit> b(final StringBuilder sb5) {
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = System.nanoTime();
            return new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.VasAIODataProcessor$Companion$printCostTime$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String tag) {
                    Intrinsics.checkNotNullParameter(tag, "tag");
                    long nanoTime = System.nanoTime();
                    StringBuilder sb6 = sb5;
                    sb6.append(tag + " timeline = " + (((float) ((nanoTime - longRef.element) / 10000)) / 100.0f) + "ms");
                    Intrinsics.checkNotNullExpressionValue(sb6, "sb.append(\"$tag timeline\u2026ime) / 10000) / 100f}ms\")");
                    sb6.append('\n');
                    Intrinsics.checkNotNullExpressionValue(sb6, "append('\\n')");
                    longRef.element = nanoTime;
                }
            };
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020%\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/VasAIODataProcessor$a;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "info", "", "callback", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "a", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "getPersonalData", "()Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "personalData", "", "b", "J", "getUin", "()J", "uin", "", "c", "Ljava/lang/String;", "getPeerUid", "()Ljava/lang/String;", "peerUid", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "d", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "getPendantBusiness", "()Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "pendantBusiness", "Lcom/tencent/mobileqq/vas/avatar/f;", "e", "Lcom/tencent/mobileqq/vas/avatar/f;", "getFaceBusiness", "()Lcom/tencent/mobileqq/vas/avatar/f;", "faceBusiness", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "f", "Ljava/lang/ref/WeakReference;", "msgRef", "msg", "<init>", "(Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;JLjava/lang/String;Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;Lcom/tencent/mobileqq/vas/avatar/f;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements IVipDataUpdateApi.RequestResultCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IVasAioData.VasAioPersonalData personalData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long uin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String peerUid;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QQVasUpdateBusiness<?> pendantBusiness;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.vas.avatar.f faceBusiness;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<AIOMsgItem> msgRef;

        public a(@NotNull IVasAioData.VasAioPersonalData personalData, long j3, @NotNull String peerUid, @NotNull QQVasUpdateBusiness<?> pendantBusiness, @NotNull com.tencent.mobileqq.vas.avatar.f faceBusiness, @NotNull AIOMsgItem msg2) {
            Intrinsics.checkNotNullParameter(personalData, "personalData");
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            Intrinsics.checkNotNullParameter(pendantBusiness, "pendantBusiness");
            Intrinsics.checkNotNullParameter(faceBusiness, "faceBusiness");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.personalData = personalData;
            this.uin = j3;
            this.peerUid = peerUid;
            this.pendantBusiness = pendantBusiness;
            this.faceBusiness = faceBusiness;
            this.msgRef = new WeakReference<>(msg2);
        }

        @Override // com.tencent.mobileqq.vas.api.IVipDataUpdateApi.RequestResultCallback
        public void callback(@NotNull IVipDataUpdateApi.AvatarPendantInfo info) {
            AIOMsgItem aIOMsgItem;
            Intrinsics.checkNotNullParameter(info, "info");
            WeakReference<AIOMsgItem> weakReference = this.msgRef;
            if (weakReference != null && (aIOMsgItem = weakReference.get()) != null) {
                VasLogNtReporter.INSTANCE.getFrequency().reportDebug("start update avatarPendantInfo success uin:" + this.uin + " info:" + info);
                if (this.personalData.getAvatarId() != info.getAvatarId()) {
                    if (this.personalData.getAvatarId() != 0) {
                        String scid = com.tencent.mobileqq.vas.avatar.h.a(this.personalData.getAvatarId(), com.tencent.mobileqq.vas.avatar.h.b(200));
                        com.tencent.mobileqq.vas.avatar.f fVar = this.faceBusiness;
                        Intrinsics.checkNotNullExpressionValue(scid, "scid");
                        if (!fVar.isFileExist(scid)) {
                            com.tencent.mobileqq.n.f252475a.m(scid, aIOMsgItem);
                        } else {
                            com.tencent.mobileqq.n.f252475a.k(info.getAvatarId(), this.uin, this.peerUid);
                        }
                    }
                } else {
                    com.tencent.mobileqq.n.f252475a.k(info.getAvatarId(), this.uin, this.peerUid);
                }
                if (!f13.a.f397699a.c()) {
                    if (this.personalData.getPendantId() == info.getPendantId() && this.personalData.getPendantDiyInfoId() == info.getPendantDiyId()) {
                        com.tencent.mobileqq.n.f252475a.o(info.getPendantId(), this.uin, this.peerUid);
                        return;
                    }
                    if (this.personalData.getPendantId() != 0 || this.personalData.getPendantDiyInfoId() != 0) {
                        if (!this.pendantBusiness.isFileExists((int) this.personalData.getPendantId())) {
                            com.tencent.mobileqq.n.f252475a.q(this.personalData.getPendantId(), aIOMsgItem);
                        } else {
                            com.tencent.mobileqq.n.f252475a.o(info.getPendantId(), this.uin, this.peerUid);
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/VasAIODataProcessor$b", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "info", "", "callback", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IVipDataUpdateApi.RequestResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f307860a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IVasAioData.VasAioPersonalData f307861b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vas.avatar.f f307862c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOMsgItem f307863d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307864e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQVasUpdateBusiness<?> f307865f;

        b(long j3, IVasAioData.VasAioPersonalData vasAioPersonalData, com.tencent.mobileqq.vas.avatar.f fVar, AIOMsgItem aIOMsgItem, String str, QQVasUpdateBusiness<?> qQVasUpdateBusiness) {
            this.f307860a = j3;
            this.f307861b = vasAioPersonalData;
            this.f307862c = fVar;
            this.f307863d = aIOMsgItem;
            this.f307864e = str;
            this.f307865f = qQVasUpdateBusiness;
        }

        @Override // com.tencent.mobileqq.vas.api.IVipDataUpdateApi.RequestResultCallback
        public void callback(@NotNull IVipDataUpdateApi.AvatarPendantInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            VasLogNtReporter.INSTANCE.getFrequency().reportDebug("start update avatarPendantInfo success uin:" + this.f307860a + " info:" + info);
            if (this.f307861b.getAvatarId() != info.getAvatarId()) {
                if (this.f307861b.getAvatarId() != 0) {
                    String scid = com.tencent.mobileqq.vas.avatar.h.a(this.f307861b.getAvatarId(), com.tencent.mobileqq.vas.avatar.h.b(200));
                    com.tencent.mobileqq.vas.avatar.f fVar = this.f307862c;
                    Intrinsics.checkNotNullExpressionValue(scid, "scid");
                    if (!fVar.isFileExist(scid)) {
                        com.tencent.mobileqq.n.f252475a.m(scid, this.f307863d);
                    } else {
                        com.tencent.mobileqq.n.f252475a.k(info.getAvatarId(), this.f307860a, this.f307864e);
                    }
                }
            } else {
                com.tencent.mobileqq.n.f252475a.k(info.getAvatarId(), this.f307860a, this.f307864e);
            }
            if (!f13.a.f397699a.c()) {
                if (this.f307861b.getPendantId() == info.getPendantId() && this.f307861b.getPendantDiyInfoId() == info.getPendantDiyId()) {
                    com.tencent.mobileqq.n.f252475a.o(info.getPendantId(), this.f307860a, this.f307864e);
                    return;
                }
                if (this.f307861b.getPendantId() != 0 || this.f307861b.getPendantDiyInfoId() != 0) {
                    if (!this.f307865f.isFileExists((int) this.f307861b.getPendantId())) {
                        com.tencent.mobileqq.n.f252475a.q(this.f307861b.getPendantId(), this.f307863d);
                    } else {
                        com.tencent.mobileqq.n.f252475a.o(info.getPendantId(), this.f307860a, this.f307864e);
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/VasAIODataProcessor$c", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$ResultCallback;", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$GameInfo;", "info", "", "onGetSync", "onGetASync", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements ITroopGameInfo.ResultCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VipData f307866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IVasAioData.VasAioPersonalData f307867b;

        c(VipData vipData, IVasAioData.VasAioPersonalData vasAioPersonalData) {
            this.f307866a = vipData;
            this.f307867b = vasAioPersonalData;
        }

        @Override // com.tencent.mobileqq.vas.troop.api.ITroopGameInfo.ResultCallback
        public void onGetASync(@NotNull ITroopGameInfo.GameInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // com.tencent.mobileqq.vas.troop.api.ITroopGameInfo.ResultCallback
        public void onGetSync(@NotNull ITroopGameInfo.GameInfo info) {
            int g16;
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.getGameCardSwitch() && info.getGradeLevel() > 0 && this.f307866a.isWzryVip() && (g16 = ((com.tencent.mobileqq.vas.vipicon.a) QQVasUpdateBusiness.getBusiness(com.tencent.mobileqq.vas.vipicon.a.class)).g(info.getGradeLevel(), true)) > 0) {
                this.f307867b.setGameNamePlateId(g16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00e2, code lost:
    
        if (r7.j(r13) < r22.getMsgRecord().msgTime) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final VASMsgAvatarPendant c(final AIOMsgItem msg2, final IVasAioData.VasAioPersonalData personalData) {
        MsgAttributeInfo msgAttributeInfo;
        int i3;
        int i16;
        long j3;
        VASMsgAvatarPendant vASMsgAvatarPendant;
        int intValue;
        long longValue;
        int intValue2;
        boolean z16;
        com.tencent.mobileqq.n nVar;
        boolean z17;
        com.tencent.mobileqq.n nVar2;
        HashMap<Integer, MsgAttributeInfo> hashMap = msg2.getMsgRecord().msgAttrs;
        if (hashMap != null) {
            msgAttributeInfo = hashMap.get(0);
        } else {
            msgAttributeInfo = null;
        }
        long j16 = 0;
        if (msgAttributeInfo == null) {
            i3 = personalData.getAvatarId();
            j3 = personalData.getPendantId();
            i16 = personalData.getPendantDiyInfoId();
        } else {
            VASMsgElement vASMsgElement = msgAttributeInfo.vasMsgInfo;
            if (vASMsgElement != null && (vASMsgAvatarPendant = vASMsgElement.avatarPendantInfo) != null) {
                Integer num = vASMsgAvatarPendant.avatarId;
                if (num == null) {
                    intValue = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(num, "it.avatarId ?: 0");
                    intValue = num.intValue();
                }
                Long l3 = vASMsgAvatarPendant.pendantId;
                if (l3 == null) {
                    longValue = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(l3, "it.pendantId ?: 0L");
                    longValue = l3.longValue();
                }
                Integer num2 = vASMsgAvatarPendant.pendantDiyInfoId;
                if (num2 == null) {
                    intValue2 = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(num2, "it.pendantDiyInfoId ?: 0");
                    intValue2 = num2.intValue();
                }
                i16 = intValue2;
                i3 = intValue;
                j3 = longValue;
            } else {
                i3 = 0;
                i16 = 0;
                j3 = 0;
            }
        }
        final long j17 = msg2.getMsgRecord().senderUin;
        final String str = msg2.getMsgRecord().peerUid;
        if (i3 != personalData.getAvatarId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j3 != personalData.getPendantId() || i16 != personalData.getPendantDiyInfoId()) {
            z16 = true;
        }
        int avatarId = personalData.getAvatarId();
        long pendantId = personalData.getPendantId();
        int pendantDiyInfoId = personalData.getPendantDiyInfoId();
        final com.tencent.mobileqq.vas.avatar.f fVar = (com.tencent.mobileqq.vas.avatar.f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L);
        final QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L);
        com.tencent.mobileqq.n nVar3 = com.tencent.mobileqq.n.f252475a;
        if (!nVar3.i(j17)) {
            if (z16) {
                nVar = nVar3;
            } else {
                nVar = nVar3;
            }
            z17 = false;
            if (!z17) {
                nVar2 = nVar;
                y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.aj
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasAIODataProcessor.d(j17, personalData, str, businessInstance, fVar, msg2);
                    }
                });
                pendantId = 0;
                avatarId = 0;
                pendantDiyInfoId = 0;
            } else {
                nVar2 = nVar;
            }
            if (personalData.getAvatarId() != 0) {
                String scid = com.tencent.mobileqq.vas.avatar.h.a(personalData.getAvatarId(), com.tencent.mobileqq.vas.avatar.h.b(200));
                Intrinsics.checkNotNullExpressionValue(scid, "scid");
                if (!fVar.isFileExist(scid)) {
                    nVar2.m(scid, msg2);
                    avatarId = 0;
                }
            }
            if (!SimpleUIUtil.getSimpleUISwitch()) {
                if ((personalData.getPendantId() != 0 || personalData.getPendantDiyInfoId() != 0) && !f13.a.f397699a.c() && !businessInstance.isFileExists((int) personalData.getPendantId())) {
                    nVar2.q(personalData.getPendantId(), msg2);
                } else {
                    j16 = pendantId;
                    nVar2.g(j17, msg2.getMsgRecord().msgTime);
                    nVar2.e(j17, avatarId);
                    nVar2.f(j17, j16, pendantDiyInfoId);
                    return new VASMsgAvatarPendant(Integer.valueOf(avatarId), Long.valueOf(j16), Integer.valueOf(pendantDiyInfoId));
                }
            }
            pendantDiyInfoId = 0;
            nVar2.g(j17, msg2.getMsgRecord().msgTime);
            nVar2.e(j17, avatarId);
            nVar2.f(j17, j16, pendantDiyInfoId);
            return new VASMsgAvatarPendant(Integer.valueOf(avatarId), Long.valueOf(j16), Integer.valueOf(pendantDiyInfoId));
        }
        nVar = nVar3;
        z17 = true;
        if (!z17) {
        }
        if (personalData.getAvatarId() != 0) {
        }
        if (!SimpleUIUtil.getSimpleUISwitch()) {
        }
        pendantDiyInfoId = 0;
        nVar2.g(j17, msg2.getMsgRecord().msgTime);
        nVar2.e(j17, avatarId);
        nVar2.f(j17, j16, pendantDiyInfoId);
        return new VASMsgAvatarPendant(Integer.valueOf(avatarId), Long.valueOf(j16), Integer.valueOf(pendantDiyInfoId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(long j3, IVasAioData.VasAioPersonalData personalData, String peerUid, QQVasUpdateBusiness pendantBusiness, com.tencent.mobileqq.vas.avatar.f faceBusiness, AIOMsgItem msg2) {
        Intrinsics.checkNotNullParameter(personalData, "$personalData");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        VasLogNtReporter.INSTANCE.getFrequency().reportDebug("start update avatarPendantInfo uin:" + j3);
        if (VasNtToggle.VAS_BUG_118645149.isEnable(true)) {
            Intrinsics.checkNotNullExpressionValue(pendantBusiness, "pendantBusiness");
            Intrinsics.checkNotNullExpressionValue(faceBusiness, "faceBusiness");
            ((IVipDataUpdateApi) QRoute.api(IVipDataUpdateApi.class)).requestAvatarPendantInfoChanged(String.valueOf(j3), new a(personalData, j3, peerUid, pendantBusiness, faceBusiness, msg2));
            return;
        }
        ((IVipDataUpdateApi) QRoute.api(IVipDataUpdateApi.class)).requestAvatarPendantInfoChanged(String.valueOf(j3), new b(j3, personalData, faceBusiness, msg2, peerUid, pendantBusiness));
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0494 A[LOOP:1: B:193:0x048e->B:195:0x0494, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(AIOMsgItem msg2) {
        MsgAttributeInfo msgAttributeInfo;
        HashMap hashMap;
        ArrayList arrayList;
        VASMsgElement vASMsgElement;
        VASMsgNamePlate vASMsgNamePlate;
        VASMsgElement vASMsgElement2;
        VASMsgIceBreak vASMsgIceBreak;
        VASMsgIceBreak vASMsgIceBreak2;
        VASPersonalNamePlate vASPersonalNamePlate;
        MsgAttributeInfo b16;
        p33.a colorNameData;
        ScannerData scannerData;
        boolean z16;
        com.tencent.qqnt.kernel.api.w msgService;
        GroupAnonymousInfo anonymousInfo;
        MsgAttributeInfo msgAttributeInfo2;
        VASMsgElement vASMsgElement3;
        VASMsgNamePlate vASMsgNamePlate2;
        VASMsgBubble vASMsgBubble;
        boolean z17;
        boolean z18;
        VASMsgFont vASMsgFont;
        VASMsgFont vASMsgFont2;
        VASMsgElement vASMsgElement4;
        Integer num;
        int intValue;
        Integer num2;
        int intValue2;
        Integer num3;
        int intValue3;
        Integer num4;
        int intValue4;
        Integer num5;
        NamePlateVipType convert;
        Integer num6;
        boolean z19;
        int intValue5;
        int b17;
        Integer num7;
        int intValue6;
        ArrayList<Integer> arrayList2;
        Integer num8;
        int intValue7;
        VASMsgFont vASMsgFont3;
        int intValue8;
        VASMsgElement vASMsgElement5;
        VASMsgElement vASMsgElement6;
        VipData.VipNumberInfo vipNumberInfo;
        VipData.VipNumberInfo vipNumberInfo2;
        StringBuilder sb5 = new StringBuilder();
        boolean z26 = f307852c;
        if (z26) {
            sb5.append("[processMsg]: msgId is " + msg2.getMsgId() + " " + msg2.getMsgRecord().senderUin);
            Intrinsics.checkNotNullExpressionValue(sb5, "log.append(\"[processMsg]\u2026sg.msgRecord.senderUin}\")");
            sb5.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        }
        Function1 b18 = INSTANCE.b(sb5);
        HashMap<Integer, MsgAttributeInfo> hashMap2 = msg2.getMsgRecord().msgAttrs;
        if (hashMap2 == null || (msgAttributeInfo = hashMap2.get(1)) == null) {
            msgAttributeInfo = new MsgAttributeInfo();
        }
        MsgAttributeInfo msgAttributeInfo3 = msgAttributeInfo;
        String valueOf = String.valueOf(msg2.getMsgRecord().peerUin);
        String valueOf2 = String.valueOf(msg2.getMsgRecord().senderUin);
        IVasAioData.VasAioPersonalData aioVasPersonalData = ((IVasAioData) QRoute.api(IVasAioData.class)).getAioVasPersonalData(String.valueOf(msg2.getMsgRecord().peerUin), valueOf2, msg2.p0());
        if (z26) {
            b18.invoke("fetch-personal-data");
        }
        VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(valueOf2);
        if (vipDataForFriends.getColorName() > 0) {
            aioVasPersonalData.setColorName(vipDataForFriends.getColorName());
        }
        if (vipDataForFriends.getNameplateItemId() > 0) {
            aioVasPersonalData.setDiyNamePlateItemId(vipDataForFriends.getNameplateItemId());
            aioVasPersonalData.getDiyNamePlateContentIds().add(Integer.valueOf(vipDataForFriends.getNameplateFgId()));
            for (int i3 : vipDataForFriends.getNameplateLetters()) {
                aioVasPersonalData.getDiyNamePlateContentIds().add(Integer.valueOf(i3));
            }
        }
        if (aioVasPersonalData.getAvatarId() > 0 && (vipNumberInfo2 = vipDataForFriends.getVipNumberInfo(VipData.VipNumberInfo.APPID.Avatar, aioVasPersonalData.getAvatarId())) != null) {
            ArrayList<VipData.VipNumberInfo> vipNumbers = aioVasPersonalData.getVipNumbers();
            VipData.VipNumberInfo vipNumberInfo3 = new VipData.VipNumberInfo();
            vipNumberInfo3.setAppId(vipNumberInfo2.getAppId());
            vipNumberInfo3.setItemId(vipNumberInfo2.getItemId());
            vipNumberInfo3.setNumberItemId(vipNumberInfo2.getNumberItemId());
            vipNumberInfo3.setNumberIdx(vipNumberInfo2.getNumberIdx());
            vipNumberInfo3.setLongNumber(vipNumberInfo2.isLongNumber());
            vipNumbers.add(vipNumberInfo3);
        }
        if (aioVasPersonalData.getPendantId() > 0 && (vipNumberInfo = vipDataForFriends.getVipNumberInfo(VipData.VipNumberInfo.APPID.Pendant, (int) aioVasPersonalData.getPendantId())) != null) {
            ArrayList<VipData.VipNumberInfo> vipNumbers2 = aioVasPersonalData.getVipNumbers();
            VipData.VipNumberInfo vipNumberInfo4 = new VipData.VipNumberInfo();
            vipNumberInfo4.setAppId(vipNumberInfo.getAppId());
            vipNumberInfo4.setItemId(vipNumberInfo.getItemId());
            vipNumberInfo4.setNumberItemId(vipNumberInfo.getNumberItemId());
            vipNumberInfo4.setNumberIdx(vipNumberInfo.getNumberIdx());
            vipNumberInfo4.setLongNumber(vipNumberInfo.isLongNumber());
            vipNumbers2.add(vipNumberInfo4);
        }
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            msg2.o0().put(2, 1);
        } else if (vipDataForFriends.getSpecialAvatarId() > 0) {
            msg2.o0().put(2, Integer.valueOf(vipDataForFriends.getSpecialAvatarId()));
        }
        Unit unit = Unit.INSTANCE;
        boolean z27 = f307852c;
        if (z27) {
            b18.invoke("fetch-vipdata");
        }
        HashMap<Integer, MsgAttributeInfo> hashMap3 = msg2.getMsgRecord().msgAttrs;
        if (hashMap3 != null && (msgAttributeInfo2 = hashMap3.get(0)) != null && (vASMsgElement3 = msgAttributeInfo2.vasMsgInfo) != null && (vASMsgNamePlate2 = vASMsgElement3.msgNamePlateInfo) != null) {
            MsgAttributeInfo msgAttributeInfo4 = msg2.getMsgRecord().msgAttrs.get(0);
            if (msgAttributeInfo4 != null && (vASMsgElement6 = msgAttributeInfo4.vasMsgInfo) != null) {
                vASMsgBubble = vASMsgElement6.bubbleInfo;
            } else {
                vASMsgBubble = null;
            }
            if (vASMsgBubble == null) {
                vASMsgBubble = new VASMsgBubble();
            } else {
                Intrinsics.checkNotNullExpressionValue(vASMsgBubble, "msg.msgRecord.msgAttrs[M\u2026bleInfo ?: VASMsgBubble()");
            }
            aioVasPersonalData.setBubble(vASMsgBubble);
            QRouteApi api = QRoute.api(IVasMagicFontManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVasMagicFontManager::class.java)");
            IVasMagicFontManager iVasMagicFontManager = (IVasMagicFontManager) api;
            boolean isDisableMagicFontType = iVasMagicFontManager.isDisableMagicFontType();
            if (!TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), valueOf2) && iVasMagicFontManager.hideGuestMagicFont()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!isDisableMagicFontType && !z17) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                MsgAttributeInfo msgAttributeInfo5 = msg2.getMsgRecord().msgAttrs.get(0);
                if (msgAttributeInfo5 != null && (vASMsgElement5 = msgAttributeInfo5.vasMsgInfo) != null) {
                    vASMsgFont3 = vASMsgElement5.vasFont;
                } else {
                    vASMsgFont3 = null;
                }
                if (vASMsgFont3 != null) {
                    Integer num9 = vASMsgFont3.fontId;
                    if (num9 == null) {
                        intValue8 = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num9, "vasFont.fontId ?: 0");
                        intValue8 = num9.intValue();
                    }
                    if (intValue8 > 16777216) {
                        intValue8 -= 16777216;
                    }
                    vASMsgFont = new VASMsgFont(Integer.valueOf(intValue8), vASMsgFont3.subFontId, vASMsgFont3.diyFontCfgUpdateTime, vASMsgFont3.diyFontImageId, 0);
                    if (vASMsgFont == null) {
                        aioVasPersonalData.setFont(vASMsgFont);
                    } else {
                        MsgAttributeInfo msgAttributeInfo6 = msg2.getMsgRecord().msgAttrs.get(0);
                        if (msgAttributeInfo6 != null && (vASMsgElement4 = msgAttributeInfo6.vasMsgInfo) != null) {
                            vASMsgFont2 = vASMsgElement4.vasFont;
                        } else {
                            vASMsgFont2 = null;
                        }
                        if (vASMsgFont2 == null) {
                            vASMsgFont2 = new VASMsgFont();
                        } else {
                            Intrinsics.checkNotNullExpressionValue(vASMsgFont2, "msg.msgRecord.msgAttrs[M\u2026?.vasFont ?: VASMsgFont()");
                        }
                        aioVasPersonalData.setFont(vASMsgFont2);
                    }
                    num = vASMsgNamePlate2.grayNamePlate;
                    if (num != null) {
                        intValue = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num, "this.grayNamePlate ?: 0");
                        intValue = num.intValue();
                    }
                    aioVasPersonalData.setGrayNameplateFlag(intValue);
                    num2 = vASMsgNamePlate2.vipStarFlag;
                    if (num2 != null) {
                        intValue2 = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num2, "this.vipStarFlag ?: 0");
                        intValue2 = num2.intValue();
                    }
                    aioVasPersonalData.setVipStarFlag(intValue2);
                    num3 = vASMsgNamePlate2.gameNamePlateId;
                    if (num3 != null) {
                        intValue3 = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num3, "this.gameNamePlateId ?: 0");
                        intValue3 = num3.intValue();
                    }
                    aioVasPersonalData.setGameNamePlateId(intValue3);
                    num4 = vASMsgNamePlate2.aioBadgeShowSwitch;
                    if (num4 != null) {
                        intValue4 = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num4, "this.aioBadgeShowSwitch ?: 0");
                        intValue4 = num4.intValue();
                    }
                    aioVasPersonalData.setAioBadgeShowSwitch(intValue4);
                    if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), valueOf2) && msg2.p0() == 2) {
                        String str = msg2.getMsgRecord().senderUid;
                        Intrinsics.checkNotNullExpressionValue(str, "msg.msgRecord.senderUid");
                        f(aioVasPersonalData, valueOf2, str);
                        vASMsgNamePlate2.namePlateType = Integer.valueOf(aioVasPersonalData.getVipType());
                        vASMsgNamePlate2.namePlateId = Integer.valueOf(aioVasPersonalData.getNamePlateId());
                    }
                    num5 = vASMsgNamePlate2.namePlateType;
                    if (num5 != null && vASMsgNamePlate2.namePlateId != null) {
                        Intrinsics.checkNotNullExpressionValue(num5, "this.namePlateType");
                        convert = NamePlateVipType.convert(num5.intValue());
                        num6 = vASMsgNamePlate2.msgBigClubFlag;
                        if (num6 == null && ((num6 == null || num6.intValue() != 0) && convert.isBigVip())) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (aioVasPersonalData.getVipStarFlag() == 0 || z19) {
                            Integer num10 = vASMsgNamePlate2.namePlateType;
                            Intrinsics.checkNotNullExpressionValue(num10, "this.namePlateType");
                            aioVasPersonalData.setVipType(num10.intValue());
                            if (!convert.isBigVip()) {
                                Integer num11 = vASMsgNamePlate2.msgBigClubLevel;
                                Intrinsics.checkNotNullExpressionValue(num11, "{\n                this.m\u2026igClubLevel\n            }");
                                b17 = num11.intValue();
                            } else {
                                com.tencent.mobileqq.vas.vipicon.l lVar = com.tencent.mobileqq.vas.vipicon.l.f311340a;
                                Integer num12 = vASMsgNamePlate2.msgVipLevel;
                                if (num12 == null) {
                                    intValue5 = 0;
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(num12, "this.msgVipLevel ?: 0");
                                    intValue5 = num12.intValue();
                                }
                                b17 = lVar.b(intValue5);
                            }
                            aioVasPersonalData.setVipLevel(b17);
                            num7 = vASMsgNamePlate2.namePlateId;
                            if (num7 != null) {
                                intValue6 = 0;
                            } else {
                                Intrinsics.checkNotNullExpressionValue(num7, "this.namePlateId ?: 0");
                                intValue6 = num7.intValue();
                            }
                            aioVasPersonalData.setNamePlateId(intValue6);
                            arrayList2 = vASMsgNamePlate2.carouselNamePlateIds;
                            if (arrayList2 != null) {
                                Intrinsics.checkNotNullExpressionValue(arrayList2, "this.carouselNamePlateIds");
                                aioVasPersonalData.setCarouselNamePlateIds(arrayList2);
                            }
                            num8 = vASMsgNamePlate2.extendNamePlateId;
                            if (num8 != null) {
                                intValue7 = 0;
                            } else {
                                Intrinsics.checkNotNullExpressionValue(num8, "this.extendNamePlateId ?: 0");
                                intValue7 = num8.intValue();
                            }
                            aioVasPersonalData.setExtendNamePlateId(intValue7);
                        }
                    }
                }
            }
            vASMsgFont = null;
            if (vASMsgFont == null) {
            }
            num = vASMsgNamePlate2.grayNamePlate;
            if (num != null) {
            }
            aioVasPersonalData.setGrayNameplateFlag(intValue);
            num2 = vASMsgNamePlate2.vipStarFlag;
            if (num2 != null) {
            }
            aioVasPersonalData.setVipStarFlag(intValue2);
            num3 = vASMsgNamePlate2.gameNamePlateId;
            if (num3 != null) {
            }
            aioVasPersonalData.setGameNamePlateId(intValue3);
            num4 = vASMsgNamePlate2.aioBadgeShowSwitch;
            if (num4 != null) {
            }
            aioVasPersonalData.setAioBadgeShowSwitch(intValue4);
            if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), valueOf2)) {
                String str2 = msg2.getMsgRecord().senderUid;
                Intrinsics.checkNotNullExpressionValue(str2, "msg.msgRecord.senderUid");
                f(aioVasPersonalData, valueOf2, str2);
                vASMsgNamePlate2.namePlateType = Integer.valueOf(aioVasPersonalData.getVipType());
                vASMsgNamePlate2.namePlateId = Integer.valueOf(aioVasPersonalData.getNamePlateId());
            }
            num5 = vASMsgNamePlate2.namePlateType;
            if (num5 != null) {
                Intrinsics.checkNotNullExpressionValue(num5, "this.namePlateType");
                convert = NamePlateVipType.convert(num5.intValue());
                num6 = vASMsgNamePlate2.msgBigClubFlag;
                if (num6 == null) {
                }
                z19 = false;
                if (aioVasPersonalData.getVipStarFlag() == 0) {
                }
                Integer num102 = vASMsgNamePlate2.namePlateType;
                Intrinsics.checkNotNullExpressionValue(num102, "this.namePlateType");
                aioVasPersonalData.setVipType(num102.intValue());
                if (!convert.isBigVip()) {
                }
                aioVasPersonalData.setVipLevel(b17);
                num7 = vASMsgNamePlate2.namePlateId;
                if (num7 != null) {
                }
                aioVasPersonalData.setNamePlateId(intValue6);
                arrayList2 = vASMsgNamePlate2.carouselNamePlateIds;
                if (arrayList2 != null) {
                }
                num8 = vASMsgNamePlate2.extendNamePlateId;
                if (num8 != null) {
                }
                aioVasPersonalData.setExtendNamePlateId(intValue7);
            }
        }
        if (z27) {
            b18.invoke("read-data");
        }
        if (msg2.p0() == 2 && !com.tencent.mobileqq.aio.utils.d.s(msg2)) {
            if (aioVasPersonalData.getAioBadgeShowSwitch() == 3 && aioVasPersonalData.getExtendNamePlateId() > 0) {
                aioVasPersonalData.setExtendNamePlateId(0);
            } else if (aioVasPersonalData.getAioBadgeShowSwitch() == 2 && aioVasPersonalData.getGameNamePlateId() > 0) {
                aioVasPersonalData.setGameNamePlateId(0);
            } else if (aioVasPersonalData.getAioBadgeShowSwitch() == 1) {
                aioVasPersonalData.setExtendNamePlateId(0);
                aioVasPersonalData.setGameNamePlateId(0);
            } else if (aioVasPersonalData.getAioBadgeShowSwitch() == 0) {
                aioVasPersonalData.setGameNamePlateId(0);
            }
            ((ITroopGameInfo) QRoute.api(ITroopGameInfo.class)).getGameInfo(valueOf, valueOf2, new c(vipDataForFriends, aioVasPersonalData));
        }
        if (z27) {
            b18.invoke("fetch-game-data");
        }
        if (!SimpleUIUtil.isNowSimpleMode()) {
            IKernelService i16 = com.tencent.qqnt.msg.f.i();
            if (i16 != null && (msgService = i16.getMsgService()) != null && (anonymousInfo = msgService.getAnonymousInfo(msg2.getMsgRecord().peerUid)) != null && anonymousInfo.isAnonymousChat) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.frequency.a(msg2, aioVasPersonalData);
                if (z27) {
                    b18.invoke("deal-frequency");
                }
                VASMsgAvatarPendant c16 = c(msg2, aioVasPersonalData);
                if (z27) {
                    b18.invoke("avatar-pendant");
                }
                ArrayList arrayList3 = new ArrayList();
                for (VipData.VipNumberInfo vipNumberInfo5 : aioVasPersonalData.getVipNumbers()) {
                    arrayList3.add(new VASPersonalVipNumberInfo(Integer.valueOf(vipNumberInfo5.getAppId()), Integer.valueOf(vipNumberInfo5.getItemId()), Integer.valueOf(vipNumberInfo5.getNumberItemId()), Integer.valueOf(vipNumberInfo5.getNumberIdx())));
                }
                hashMap = new HashMap();
                arrayList = new ArrayList(aioVasPersonalData.getVipNumbers());
                if (!arrayList.isEmpty()) {
                    try {
                        String vipNumbersStr = new Gson().toJson(arrayList);
                        Intrinsics.checkNotNullExpressionValue(vipNumbersStr, "vipNumbersStr");
                        hashMap.put("vipNumberInfoNew", vipNumbersStr);
                    } catch (Exception e16) {
                        QLog.e("VasAIODataProcessor", 1, e16, new Object[0]);
                    }
                }
                if (!com.tencent.mobileqq.aio.utils.d.s(msg2) && aioVasPersonalData.getColorName() > 0 && (colorNameData = ((ColorNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ColorNameBusiness.class)).getColorNameData(aioVasPersonalData.getColorName())) != null) {
                    hashMap.put("normalColor", colorNameData.getNormalColor());
                    scannerData = colorNameData.getScannerData();
                    if (scannerData != null) {
                    }
                }
                HashMap<Integer, MsgAttributeInfo> hashMap4 = msg2.getMsgRecord().msgAttrs;
                Intrinsics.checkNotNullExpressionValue(hashMap4, "msg.msgRecord.msgAttrs");
                com.tencent.qqnt.kernel.util.a aVar = com.tencent.qqnt.kernel.util.a.f359256a;
                vASMsgElement = msgAttributeInfo3.vasMsgInfo;
                if (vASMsgElement == null) {
                    vASMsgNamePlate = vASMsgElement.msgNamePlateInfo;
                } else {
                    vASMsgNamePlate = null;
                }
                if (vASMsgNamePlate == null) {
                    vASMsgNamePlate = new VASMsgNamePlate();
                }
                VASMsgNamePlate vASMsgNamePlate3 = vASMsgNamePlate;
                VASMsgBubble bubble = aioVasPersonalData.getBubble();
                VASMsgFont font = aioVasPersonalData.getFont();
                vASMsgElement2 = msgAttributeInfo3.vasMsgInfo;
                if (vASMsgElement2 == null) {
                    vASMsgIceBreak = vASMsgElement2.iceBreakInfo;
                } else {
                    vASMsgIceBreak = null;
                }
                if (vASMsgIceBreak != null) {
                    vASMsgIceBreak2 = new VASMsgIceBreak();
                } else {
                    vASMsgIceBreak2 = vASMsgIceBreak;
                }
                VASMsgElement vASMsgElement7 = new VASMsgElement(vASMsgNamePlate3, bubble, c16, font, vASMsgIceBreak2);
                Long valueOf3 = Long.valueOf(aioVasPersonalData.getTroopColorNameId());
                Integer valueOf4 = Integer.valueOf(aioVasPersonalData.getVaDataChangeRand());
                if (!com.tencent.mobileqq.aio.utils.d.s(msg2)) {
                    vASPersonalNamePlate = new VASPersonalNamePlate(0, 0, 0, 0, new ArrayList(), 0, new ArrayList(), 0, 0, 0, 0);
                } else {
                    vASPersonalNamePlate = new VASPersonalNamePlate(Integer.valueOf(aioVasPersonalData.getGrayNameplateFlag()), Integer.valueOf(aioVasPersonalData.getVipType()), Integer.valueOf(aioVasPersonalData.getVipLevel()), Integer.valueOf(aioVasPersonalData.getNamePlateId()), aioVasPersonalData.getCarouselNamePlateIds(), Integer.valueOf(aioVasPersonalData.getDiyNamePlateItemId()), aioVasPersonalData.getDiyNamePlateContentIds(), Integer.valueOf(aioVasPersonalData.getExtendNamePlateId()), Integer.valueOf(aioVasPersonalData.getGameNamePlateId()), Integer.valueOf(aioVasPersonalData.getVipStarFlag()), Integer.valueOf(aioVasPersonalData.getAioBadgeShowSwitch()));
                }
                b16 = aVar.b(msgAttributeInfo3, (i3 & 2) != 0 ? null : null, (i3 & 4) != 0 ? null : null, (i3 & 8) != 0 ? null : vASMsgElement7, (i3 & 16) != 0 ? null : new VASAIOPersonalElement(valueOf3, arrayList3, valueOf4, vASPersonalNamePlate, hashMap), (i3 & 32) != 0 ? null : null, (i3 & 64) != 0 ? null : null, (i3 & 128) != 0 ? null : null, (i3 & 256) != 0 ? null : null, (i3 & 512) != 0 ? null : null, (i3 & 1024) != 0 ? null : null, (i3 & 2048) != 0 ? null : null, (i3 & 4096) != 0 ? null : null, (i3 & 8192) != 0 ? null : null, (i3 & 16384) != 0 ? null : null, (i3 & 32768) != 0 ? null : null, (i3 & 65536) != 0 ? null : null, (i3 & 131072) != 0 ? null : null, (i3 & 262144) != 0 ? null : null, (i3 & 524288) != 0 ? null : null, (i3 & 1048576) != 0 ? null : null, (i3 & 2097152) == 0 ? null : null);
                hashMap4.put(1, b16);
                if (!f307852c) {
                    b18.invoke("setup-data personalData: " + aioVasPersonalData);
                    VasLogReportProxy aIODraw = VasLogNtReporter.INSTANCE.getAIODraw();
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "log.toString()");
                    aIODraw.reportDebug(sb6);
                    return;
                }
                return;
            }
        }
        this.frequency.b(msg2, aioVasPersonalData);
        if (z27) {
        }
        VASMsgAvatarPendant c162 = c(msg2, aioVasPersonalData);
        if (z27) {
        }
        ArrayList arrayList32 = new ArrayList();
        while (r0.hasNext()) {
        }
        hashMap = new HashMap();
        arrayList = new ArrayList(aioVasPersonalData.getVipNumbers());
        if (!arrayList.isEmpty()) {
        }
        if (!com.tencent.mobileqq.aio.utils.d.s(msg2)) {
            hashMap.put("normalColor", colorNameData.getNormalColor());
            scannerData = colorNameData.getScannerData();
            if (scannerData != null) {
            }
        }
        HashMap<Integer, MsgAttributeInfo> hashMap42 = msg2.getMsgRecord().msgAttrs;
        Intrinsics.checkNotNullExpressionValue(hashMap42, "msg.msgRecord.msgAttrs");
        com.tencent.qqnt.kernel.util.a aVar2 = com.tencent.qqnt.kernel.util.a.f359256a;
        vASMsgElement = msgAttributeInfo3.vasMsgInfo;
        if (vASMsgElement == null) {
        }
        if (vASMsgNamePlate == null) {
        }
        VASMsgNamePlate vASMsgNamePlate32 = vASMsgNamePlate;
        VASMsgBubble bubble2 = aioVasPersonalData.getBubble();
        VASMsgFont font2 = aioVasPersonalData.getFont();
        vASMsgElement2 = msgAttributeInfo3.vasMsgInfo;
        if (vASMsgElement2 == null) {
        }
        if (vASMsgIceBreak != null) {
        }
        VASMsgElement vASMsgElement72 = new VASMsgElement(vASMsgNamePlate32, bubble2, c162, font2, vASMsgIceBreak2);
        Long valueOf32 = Long.valueOf(aioVasPersonalData.getTroopColorNameId());
        Integer valueOf42 = Integer.valueOf(aioVasPersonalData.getVaDataChangeRand());
        if (!com.tencent.mobileqq.aio.utils.d.s(msg2)) {
        }
        b16 = aVar2.b(msgAttributeInfo3, (i3 & 2) != 0 ? null : null, (i3 & 4) != 0 ? null : null, (i3 & 8) != 0 ? null : vASMsgElement72, (i3 & 16) != 0 ? null : new VASAIOPersonalElement(valueOf32, arrayList32, valueOf42, vASPersonalNamePlate, hashMap), (i3 & 32) != 0 ? null : null, (i3 & 64) != 0 ? null : null, (i3 & 128) != 0 ? null : null, (i3 & 256) != 0 ? null : null, (i3 & 512) != 0 ? null : null, (i3 & 1024) != 0 ? null : null, (i3 & 2048) != 0 ? null : null, (i3 & 4096) != 0 ? null : null, (i3 & 8192) != 0 ? null : null, (i3 & 16384) != 0 ? null : null, (i3 & 32768) != 0 ? null : null, (i3 & 65536) != 0 ? null : null, (i3 & 131072) != 0 ? null : null, (i3 & 262144) != 0 ? null : null, (i3 & 524288) != 0 ? null : null, (i3 & 1048576) != 0 ? null : null, (i3 & 2097152) == 0 ? null : null);
        hashMap42.put(1, b16);
        if (!f307852c) {
        }
    }

    private final void f(IVasAioData.VasAioPersonalData personalData, String uin, String uid) {
        QRouteApi api = QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasInfoService::class.java)");
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) api).getVasSimpleInfoWithUid(uid, (String) null);
        personalData.setAioBadgeShowSwitch(VipNtMMKV.INSTANCE.getCommon(uin).decodeInt("aioBadgeShowSwitch", 0));
        if (vasSimpleInfoWithUid != null) {
            personalData.setNamePlateId(vasSimpleInfoWithUid.bigClubTemplateId);
            personalData.setVipType(vasSimpleInfoWithUid.nameplateVipType);
            personalData.setExtendNamePlateId(vasSimpleInfoWithUid.bigClubExtTemplateId);
            personalData.setVipStarFlag(vasSimpleInfoWithUid.vipStartFlag);
        }
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public void a(@NotNull AIOMsgItem msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        e(msg2);
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public int getBusinessType() {
        return 1;
    }
}
