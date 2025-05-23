package com.tencent.mobileqq.troop.qrcode;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.protofile.source.QunSourceSvrPB$SourceItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\t*\u0001.\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006Jp\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062`\u0010\u0018\u001a\\\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u000fJ\u0010\u0010\u001a\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J;\u0010\u001e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001b2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u001dR*\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/biz/qrcode/mgr/d;", "qrCodeData", "", "O1", "", "getLogTag", "onCleared", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "troopUin", "sourceId", "R1", "S1", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "style", "shortChain", "url", "cb", "T1", "N1", "Lcom/tencent/protofile/source/QunSourceSvrPB$SourceItem;", "sourceItem", "Lkotlin/Function1;", "M1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentQRCodeData", "(Landroidx/lifecycle/MutableLiveData;)V", "currentQRCodeData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "Q1", "()Z", "U1", "(Z)V", "isSourceChainReady", "com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager$a", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager$a;", "troopSourceDataObserver", "<init>", "()V", "D", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRDisplayTroopCardManager extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a troopSourceDataObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<com.tencent.biz.qrcode.mgr.d> currentQRCodeData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSourceChainReady;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014JE\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager$Companion;", "", "", "troopUin", WadlProxyConsts.CHANNEL, "downloadUrl", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "cb", "a", "AIGC_URL", "Ljava/lang/String;", "KEY_START_BY_JS", "KEY_START_BY_MY_QRCODE", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull final String troopUin, @Nullable final String channel, @Nullable String downloadUrl, @NotNull final Function1<? super Boolean, Unit> cb5) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, channel, downloadUrl, cb5);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(cb5, "cb");
            QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
            if (!qRDisplayTroopCardRepo.i()) {
                QLog.i("QRDisplayTroopCardViewModel", 1, "AIGC Style is not enabled.");
                cb5.invoke(Boolean.FALSE);
                return;
            }
            if (channel != null && channel.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.mobileqq.troop.addsource.c());
                if (downloadUrl == null || downloadUrl.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    qRDisplayTroopCardRepo.p(troopUin, channel, downloadUrl);
                }
            }
            QRDisplayTroopCardRepo.s(qRDisplayTroopCardRepo, troopUin, false, new Function4<Boolean, Integer, String, String, Unit>(troopUin, channel, cb5) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$Companion$setAIGCQRCode$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<Boolean, Unit> $cb;
                final /* synthetic */ String $channel;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                    this.$troopUin = troopUin;
                    this.$channel = channel;
                    this.$cb = cb5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, channel, cb5);
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                    invoke(bool.booleanValue(), num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z18, int i3, @NotNull String shortChain, @NotNull String url) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z18), Integer.valueOf(i3), shortChain, url);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                    Intrinsics.checkNotNullParameter(url, "url");
                    if (!z18) {
                        this.$cb.invoke(Boolean.FALSE);
                        return;
                    }
                    if (i3 == 2) {
                        QRDisplayTroopCardRepo qRDisplayTroopCardRepo2 = QRDisplayTroopCardRepo.f298123a;
                        String str = this.$troopUin;
                        qRDisplayTroopCardRepo2.j(str, url, new Function2<Boolean, Bitmap, Unit>(str, shortChain, this.$cb) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$Companion$setAIGCQRCode$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Function1<Boolean, Unit> $cb;
                            final /* synthetic */ String $shortChain;
                            final /* synthetic */ String $troopUin;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                                this.$troopUin = str;
                                this.$shortChain = shortChain;
                                this.$cb = r10;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, str, shortChain, r10);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                                invoke(bool.booleanValue(), bitmap);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z19, @Nullable Bitmap bitmap) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, this, Boolean.valueOf(z19), bitmap);
                                    return;
                                }
                                if (z19) {
                                    QRDisplayTroopCardRepo qRDisplayTroopCardRepo3 = QRDisplayTroopCardRepo.f298123a;
                                    qRDisplayTroopCardRepo3.v(this.$troopUin, this.$shortChain);
                                    IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
                                    String str2 = this.$troopUin;
                                    iBusManager.sendEvent(new af(str2, new com.tencent.biz.qrcode.mgr.d(2, this.$shortChain, qRDisplayTroopCardRepo3.m(str2), bitmap)));
                                    this.$cb.invoke(Boolean.TRUE);
                                    return;
                                }
                                this.$cb.invoke(Boolean.FALSE);
                            }
                        });
                    } else {
                        String str2 = this.$channel;
                        if (!(str2 == null || str2.length() == 0)) {
                            this.$cb.invoke(Boolean.TRUE);
                        } else {
                            QLog.i("QRDisplayTroopCardViewModel", 1, "setAIGCQRCode onReceive success, but style not match.");
                            this.$cb.invoke(Boolean.FALSE);
                        }
                    }
                }
            }, 2, null);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardManager$a", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements zv3.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardManager.this);
            }
        }

        @Override // zv3.c
        public void B5(@NotNull zv3.a event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("QRDisplayTroopCardViewModel", 1, "[troopSourceDataObserver] isSourceChainReady = " + QRDisplayTroopCardManager.this.Q1());
            if (event instanceof af) {
                af afVar = (af) event;
                if (afVar.a() != null && !QRDisplayTroopCardManager.this.Q1()) {
                    QRDisplayTroopCardManager.this.P1().postValue(afVar.a());
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QRDisplayTroopCardManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.currentQRCodeData = new MutableLiveData<>();
        a aVar = new a();
        this.troopSourceDataObserver = aVar;
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(af.class, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(com.tencent.biz.qrcode.mgr.d qrCodeData) {
        QLog.i("QRDisplayTroopCardViewModel", 1, "[doUpdateQRCode] isSourceChainReady = " + this.isSourceChainReady + ",  qrCodeData = " + qrCodeData);
        if (!this.isSourceChainReady) {
            this.currentQRCodeData.postValue(qrCodeData);
        }
    }

    public final void M1(@Nullable String troopUin, @NotNull final QunSourceSvrPB$SourceItem sourceItem, @NotNull final Function1<? super com.tencent.biz.qrcode.mgr.d, Unit> cb5) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, sourceItem, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(sourceItem, "sourceItem");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        final String str2 = troopUin + "_" + sourceItem.f342212id.get();
        QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
        if (qRDisplayTroopCardRepo.i() && sourceItem.is_use_custom_qr_code.get()) {
            String str3 = sourceItem.custom_qr_code_url.get();
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str4 = sourceItem.custom_qr_code_url.get();
                Intrinsics.checkNotNullExpressionValue(str4, "sourceItem.custom_qr_code_url.get()");
                qRDisplayTroopCardRepo.j(str2, str4, new Function2<Boolean, Bitmap, Unit>(cb5, sourceItem, str2) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$createQRCodeDataForSource$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function1<com.tencent.biz.qrcode.mgr.d, Unit> $cb;
                    final /* synthetic */ String $sourceAigcFilePath;
                    final /* synthetic */ QunSourceSvrPB$SourceItem $sourceItem;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$cb = cb5;
                        this.$sourceItem = sourceItem;
                        this.$sourceAigcFilePath = str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, cb5, sourceItem, str2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                        invoke(bool.booleanValue(), bitmap);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, @Nullable Bitmap bitmap) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z17), bitmap);
                            return;
                        }
                        QLog.i("QRDisplayTroopCardViewModel", 1, "[createQRCodeDataForSource] [getBitmapAsync] getBitmapSuccess = " + z17 + ", bitmap = " + bitmap);
                        if (z17) {
                            Function1<com.tencent.biz.qrcode.mgr.d, Unit> function1 = this.$cb;
                            PBStringField pBStringField = this.$sourceItem.url;
                            String str5 = pBStringField != null ? pBStringField.get() : null;
                            function1.invoke(new com.tencent.biz.qrcode.mgr.d(2, str5 != null ? str5 : "", QRDisplayTroopCardRepo.f298123a.m(this.$sourceAigcFilePath), bitmap));
                            return;
                        }
                        Function1<com.tencent.biz.qrcode.mgr.d, Unit> function12 = this.$cb;
                        PBStringField pBStringField2 = this.$sourceItem.url;
                        String str6 = pBStringField2 != null ? pBStringField2.get() : null;
                        if (str6 == null) {
                            str6 = "";
                        }
                        function12.invoke(new com.tencent.biz.qrcode.mgr.d(1, str6, "", null));
                    }
                });
                return;
            }
        }
        PBStringField pBStringField = sourceItem.url;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        cb5.invoke(new com.tencent.biz.qrcode.mgr.d(1, str, "", null));
    }

    public final boolean N1(@Nullable com.tencent.biz.qrcode.mgr.d qrCodeData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) qrCodeData)).booleanValue();
        }
        if (qrCodeData == null || !QRDisplayTroopCardRepo.f298123a.i() || qrCodeData.getStyle() != 2 || qrCodeData.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String() == null) {
            return false;
        }
        return true;
    }

    @NotNull
    public final MutableLiveData<com.tencent.biz.qrcode.mgr.d> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.currentQRCodeData;
    }

    public final boolean Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isSourceChainReady;
    }

    public final void R1(@NotNull Activity activity, @NotNull String troopUin, @Nullable String sourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, troopUin, sourceId);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String str = "https://h5.tu.qq.com/web/pretty-qrcode/group-qr-result?_wv=3&_wwv=1&groupid=" + troopUin;
        if (sourceId != null) {
            str = str + "&channel=" + sourceId;
        }
        QRoute.createNavigator(activity, RouterConstants.UI_ROUTE_BROWSER).withBoolean("key_start_by_my_qrcode", true).withString("url", str).request();
    }

    public final void S1(@NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            T1(troopUin, new Function4<Boolean, Integer, String, String, Unit>(troopUin) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$requestQRCodeData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                    this.$troopUin = troopUin;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QRDisplayTroopCardManager.this, (Object) troopUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                    invoke(bool.booleanValue(), num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, @NotNull String shortChain, @NotNull String url) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), shortChain, url);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                    Intrinsics.checkNotNullParameter(url, "url");
                    if (i3 == 1) {
                        QRDisplayTroopCardManager.this.O1(new com.tencent.biz.qrcode.mgr.d(i3, shortChain, null, null, 12, null));
                    } else {
                        if (i3 != 2) {
                            return;
                        }
                        QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
                        String str = this.$troopUin;
                        qRDisplayTroopCardRepo.j(str, url, new Function2<Boolean, Bitmap, Unit>(i3, shortChain, str) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$requestQRCodeData$1.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ String $shortChain;
                            final /* synthetic */ int $style;
                            final /* synthetic */ String $troopUin;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                                this.$style = i3;
                                this.$shortChain = shortChain;
                                this.$troopUin = str;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, QRDisplayTroopCardManager.this, Integer.valueOf(i3), shortChain, str);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Bitmap bitmap) {
                                invoke(bool.booleanValue(), bitmap);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17, @Nullable Bitmap bitmap) {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, this, Boolean.valueOf(z17), bitmap);
                                } else if (z17) {
                                    QRDisplayTroopCardManager.this.O1(new com.tencent.biz.qrcode.mgr.d(this.$style, this.$shortChain, QRDisplayTroopCardRepo.f298123a.m(this.$troopUin), bitmap));
                                } else {
                                    QRDisplayTroopCardManager.this.O1(new com.tencent.biz.qrcode.mgr.d(1, this.$shortChain, null, null, 12, null));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public final void T1(@NotNull final String troopUin, @NotNull final Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopUin, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QRDisplayTroopCardRepo.f298123a.r(troopUin, false, new Function4<Boolean, Integer, String, String, Unit>(troopUin, cb5) { // from class: com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardManager$requestQRCodeDataWithCallback$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function4<Boolean, Integer, String, String, Unit> $cb;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
                this.$troopUin = troopUin;
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, String str2) {
                invoke(bool.booleanValue(), num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String shortChain, @NotNull String url) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), shortChain, url);
                    return;
                }
                Intrinsics.checkNotNullParameter(shortChain, "shortChain");
                Intrinsics.checkNotNullParameter(url, "url");
                QLog.i("QRDisplayTroopCardViewModel", 1, "[requestQRCodeDataWithCallback] troopUin = " + this.$troopUin + " isSuccess = " + z16 + " style = " + i3 + " shortChain = " + shortChain + " url = " + url);
                if (z16) {
                    this.$cb.invoke(Boolean.TRUE, Integer.valueOf(i3), shortChain, url);
                }
            }
        });
    }

    public final void U1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isSourceChainReady = z16;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QRDisplayTroopCardViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onCleared();
            ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(af.class, this.troopSourceDataObserver);
        }
    }
}
