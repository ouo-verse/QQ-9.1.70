package com.tencent.qqnt.notification.struct;

import com.dataline.qqnt.notification.DataLineNotificationProcessor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.notification.processor.basemessage.NTC2CFriendNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.NTContactStrangerNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.NTGameMsgNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.NTMatchFriendNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.NearbyProNotificationProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.processor.basemessage.TempSessionNotificationProcessor;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/notification/struct/ProcessorFactory;", "", "", "e", "Lcom/tencent/qqnt/notification/struct/BaseUinTypeProcessor;", "d", "", "uinType", "", "c", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "b", "<init>", "()V", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ProcessorFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<ProcessorFactory> f359885b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/notification/Inject_Notification.yml", version = 3)
    @NotNull
    private static HashMap<String, Class<? extends BaseUinTypeProcessor>> f359886c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/notification/struct/ProcessorFactory$a;", "", "Lcom/tencent/qqnt/notification/struct/ProcessorFactory;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/notification/struct/ProcessorFactory;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.struct.ProcessorFactory$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ProcessorFactory a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ProcessorFactory) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (ProcessorFactory) ProcessorFactory.f359885b.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<ProcessorFactory> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45574);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) ProcessorFactory$Companion$instance$2.INSTANCE);
        f359885b = lazy;
        HashMap<String, Class<? extends BaseUinTypeProcessor>> hashMap = new HashMap<>();
        f359886c = hashMap;
        hashMap.put("10013", TempSessionNotificationProcessor.class);
        f359886c.put("10010", TempSessionNotificationProcessor.class);
        f359886c.put("10008", TempSessionNotificationProcessor.class);
        f359886c.put("10007", TempSessionNotificationProcessor.class);
        f359886c.put("1025", TempSessionNotificationProcessor.class);
        f359886c.put("1024", TempSessionNotificationProcessor.class);
        f359886c.put("1023", TempSessionNotificationProcessor.class);
        f359886c.put("1000", TempSessionNotificationProcessor.class);
        f359886c.put("1020", TempSessionNotificationProcessor.class);
        f359886c.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, TempSessionNotificationProcessor.class);
        f359886c.put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, TempSessionNotificationProcessor.class);
        f359886c.put("1003", TempSessionNotificationProcessor.class);
        f359886c.put("10004", TempSessionNotificationProcessor.class);
        f359886c.put("10002", TempSessionNotificationProcessor.class);
        f359886c.put("1001", TempSessionNotificationProcessor.class);
        f359886c.put("1009", TempSessionNotificationProcessor.class);
        f359886c.put("119", NearbyProNotificationProcessor.class);
        f359886c.put("111", NTContactStrangerNotificationProcessor.class);
        f359886c.put("116", NTGameMsgNotificationProcessor.class);
        f359886c.put("105", NTGameMsgNotificationProcessor.class);
        f359886c.put(QAdVrReportParams.ClickAdActionTypeValue.ACTION_TYPE_NO_JUMP, NTMatchFriendNotificationProcessor.class);
        f359886c.put("104", NTMatchFriendNotificationProcessor.class);
        f359886c.put("8", DataLineNotificationProcessor.class);
        f359886c.put("2", NTTroopNotificationProcessor.class);
        f359886c.put("1", NTC2CFriendNotificationProcessor.class);
    }

    public /* synthetic */ ProcessorFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
    }

    private final BaseUinTypeProcessor d(final Throwable e16) {
        com.tencent.qqnt.notification.util.a.f359909a.c("Notification.ProcessorFactory", new Function0<String>(e16) { // from class: com.tencent.qqnt.notification.struct.ProcessorFactory$nullProcessorWithException$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Throwable $e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$e = e16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "nullProcessorWithException: failed. " + this.$e;
            }
        });
        if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            return null;
        }
        throw new IllegalStateException(e16);
    }

    @Nullable
    public final BaseUinTypeProcessor b(@Nullable AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseUinTypeProcessor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Class<? extends BaseUinTypeProcessor> cls = f359886c.get(String.valueOf(msgRecord.chatType));
        if (cls == null) {
            cls = com.tencent.qqnt.notification.processor.business.a.class;
        }
        if (!BaseUinTypeProcessor.class.isAssignableFrom(cls)) {
            d(new RuntimeException("not subclass of BaseUinTypeProcessor"));
        }
        try {
            Constructor<? extends BaseUinTypeProcessor> declaredConstructor = cls.getDeclaredConstructor(AppRuntime.class, RecentContactInfo.class);
            declaredConstructor.setAccessible(true);
            final BaseUinTypeProcessor newInstance = declaredConstructor.newInstance(app, msgRecord);
            com.tencent.qqnt.notification.util.a.f359909a.b("Notification.ProcessorFactory", new Function0<String>(newInstance) { // from class: com.tencent.qqnt.notification.struct.ProcessorFactory$create$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Object $instance;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$instance = newInstance;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, newInstance);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "create processor: " + this.$instance.getClass().getSimpleName();
                }
            });
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.notification.struct.BaseUinTypeProcessor");
            return newInstance;
        } catch (Throwable th5) {
            return d(th5);
        }
    }

    public final boolean c(int uinType) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, uinType)).booleanValue();
        }
        Class<? extends BaseUinTypeProcessor> cls = f359886c.get(String.valueOf(uinType));
        if (cls != null) {
            bool = Boolean.valueOf(TempSessionNotificationProcessor.class.isAssignableFrom(cls));
        } else {
            bool = null;
        }
        if (uinType == 1 || uinType == 2 || uinType == 3 || uinType == 4 || Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    ProcessorFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
