package com.tencent.qqnt.notification.logic.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import com.tencent.qqnt.notification.struct.ProcessorFactory;
import com.tencent.qqnt.notification.util.j;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = true, process = {"all"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R.\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001d0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/notification/logic/impl/NotifySessionServiceImpl;", "Lcom/tencent/qqnt/notification/logic/INotifySessionService;", "", "uin", "", "isValidUin", "", "saveUinIdMapToSp", "saveCurrentIdToSp", "restoreUinIdMapAndCurrentIdFromSp", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", "peerUin", "", "uniqueNotifyIdByUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "isSeparateSessionMessage", "chatType", "isSeparateSession", "cancelNotificationByUin", "cancelAllNotification", "clearSessionPrefix", "prefixType", "setSessionNeedPrefix", "getSessionNeedPrefix", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/app/AppRuntime;", "Ljava/util/concurrent/ConcurrentHashMap;", "uinIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "currentMinId", "I", "prefixRecordMap", "<init>", "()V", "Companion", "a", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotifySessionServiceImpl implements INotifySessionService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String SP_KEY_CURRENT_NOTIFY_ID = "NT_SP_KEY_CURRENT_NOTIFY_ID";

    @NotNull
    private static final String SP_KEY_CURRENT_NOTIFY_ID_MAP = "NT_SP_KEY_CURRENT_NOTIFY_ID_MAP";

    @NotNull
    private static final String TAG = "Notification.Session";
    private AppRuntime appRuntime;
    private int currentMinId;

    @NotNull
    private ConcurrentHashMap<Integer, ConcurrentHashMap<Long, Boolean>> prefixRecordMap;

    @NotNull
    private ConcurrentHashMap<Long, Integer> uinIdMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/notification/logic/impl/NotifySessionServiceImpl$a;", "", "", "SP_KEY_CURRENT_NOTIFY_ID", "Ljava/lang/String;", "SP_KEY_CURRENT_NOTIFY_ID_MAP", "TAG", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43126);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifySessionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uinIdMap = new ConcurrentHashMap<>();
        this.currentMinId = 512;
        this.prefixRecordMap = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAllNotification$lambda$0() {
        for (int i3 = 512; i3 < 522; i3++) {
            NotificationFacade.INSTANCE.a().w(i3);
        }
    }

    private final boolean isValidUin(long uin) {
        if (uin > 10000) {
            return true;
        }
        return false;
    }

    private final void restoreUinIdMapAndCurrentIdFromSp() {
        List emptyList;
        List emptyList2;
        boolean z16;
        boolean z17;
        ConcurrentHashMap<Long, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        AppRuntime appRuntime = this.appRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        SharedPreferences sharedPreferences = appRuntime2.getApp().getSharedPreferences(currentAccountUin, 4);
        final String string = sharedPreferences.getString(SP_KEY_CURRENT_NOTIFY_ID_MAP, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                Intrinsics.checkNotNull(string);
                List<String> split = new Regex(",").split(string, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (String str : (String[]) array) {
                    List<String> split2 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str, 0);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    Object[] array2 = emptyList2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array2;
                    concurrentHashMap.put(Long.valueOf(Long.parseLong(strArr[0])), Integer.valueOf(Integer.parseInt(strArr[1])));
                }
            } catch (Exception e16) {
                com.tencent.qqnt.notification.util.a.f359909a.c(TAG, new Function0<String>(e16) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$restoreUinIdMapAndCurrentIdFromSp$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Exception $e;

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
                        return "restoreUinIdMapFromSp: failed. " + this.$e;
                    }
                });
            }
        }
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(string) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$restoreUinIdMapAndCurrentIdFromSp$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $mapStr;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$mapStr = string;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) string);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "restoreUinIdMapFromSp, mapStr: " + this.$mapStr;
            }
        });
        this.uinIdMap = concurrentHashMap;
        this.currentMinId = sharedPreferences.getInt(SP_KEY_CURRENT_NOTIFY_ID, 512);
    }

    private final void saveCurrentIdToSp() {
        AppRuntime appRuntime = this.appRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        appRuntime2.getApp().getSharedPreferences(currentAccountUin, 4).edit().putInt(SP_KEY_CURRENT_NOTIFY_ID, this.currentMinId).apply();
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>() { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$saveCurrentIdToSp$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifySessionServiceImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                i3 = NotifySessionServiceImpl.this.currentMinId;
                return "saveCurrentIdToSp, mCurrentMinId:" + i3;
            }
        });
    }

    private final void saveUinIdMapToSp() {
        boolean z16;
        final StringBuilder sb5 = new StringBuilder();
        for (Long key : this.uinIdMap.keySet()) {
            Intrinsics.checkNotNullExpressionValue(key, "key");
            sb5.append(key.longValue());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.uinIdMap.get(key));
            sb5.append(",");
        }
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            sb5.delete(sb5.length() - 1, sb5.length());
        }
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(sb5) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$saveUinIdMapToSp$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ StringBuilder $mapAsString;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$mapAsString = sb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) sb5);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "saveUinIdMapToSp, mapAsString:" + ((Object) this.$mapAsString);
            }
        });
        AppRuntime appRuntime = this.appRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        appRuntime2.getApp().getSharedPreferences(currentAccountUin, 4).edit().putString(SP_KEY_CURRENT_NOTIFY_ID_MAP, sb5.toString()).apply();
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public void cancelAllNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.qqnt.notification.util.a.f359909a.a(NotifySessionServiceImpl$cancelAllNotification$1.INSTANCE);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.logic.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                NotifySessionServiceImpl.cancelAllNotification$lambda$0();
            }
        }, 16, null, false);
        this.uinIdMap.clear();
        saveUinIdMapToSp();
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public void cancelNotificationByUin(final long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, peerUin);
            return;
        }
        if (!isValidUin(peerUin)) {
            return;
        }
        final Integer num = this.uinIdMap.get(Long.valueOf(peerUin));
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(num, peerUin) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$cancelNotificationByUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Integer $notifyId;
            final /* synthetic */ long $peerUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$notifyId = num;
                this.$peerUin = peerUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, num, Long.valueOf(peerUin));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "cancelNotificationByUin, notifyId:" + this.$notifyId + " friendUin:" + j.f359913a.a(Long.valueOf(this.$peerUin));
            }
        });
        if (num != null) {
            NotificationFacade.INSTANCE.a().w(num.intValue());
        }
        this.uinIdMap.remove(Long.valueOf(peerUin));
        saveUinIdMapToSp();
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public void clearSessionPrefix(final long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, peerUin);
            return;
        }
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(peerUin) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$clearSessionPrefix$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $peerUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$peerUin = peerUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, peerUin);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "clearUinNeedShowCareMap: invoked.  friendOrTroopUin: " + j.f359913a.a(Long.valueOf(this.$peerUin));
            }
        });
        Iterator<Map.Entry<Integer, ConcurrentHashMap<Long, Boolean>>> it = this.prefixRecordMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(Long.valueOf(peerUin));
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public boolean getSessionNeedPrefix(long peerUin, int prefixType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Long.valueOf(peerUin), Integer.valueOf(prefixType))).booleanValue();
        }
        ConcurrentHashMap<Long, Boolean> concurrentHashMap = this.prefixRecordMap.get(Integer.valueOf(prefixType));
        if (concurrentHashMap == null) {
            return false;
        }
        return Intrinsics.areEqual(concurrentHashMap.get(Long.valueOf(peerUin)), Boolean.TRUE);
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public boolean isSeparateSession(int chatType, long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), Long.valueOf(peerUin))).booleanValue();
        }
        if (isValidUin(peerUin) && ProcessorFactory.INSTANCE.a().c(chatType)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public boolean isSeparateSessionMessage(@Nullable RecentContactInfo msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgRecord)).booleanValue();
        }
        if (msgRecord == null) {
            return false;
        }
        return isSeparateSession(msgRecord.chatType, msgRecord.peerUin);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = appRuntime;
        restoreUinIdMapAndCurrentIdFromSp();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.uinIdMap.clear();
            saveUinIdMapToSp();
        }
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public void setSessionNeedPrefix(long peerUin, int prefixType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(peerUin), Integer.valueOf(prefixType));
            return;
        }
        if (this.prefixRecordMap.get(Integer.valueOf(prefixType)) == null) {
            this.prefixRecordMap.put(Integer.valueOf(prefixType), new ConcurrentHashMap<>());
        }
        Long valueOf = Long.valueOf(peerUin);
        ConcurrentHashMap<Long, Boolean> concurrentHashMap = this.prefixRecordMap.get(Integer.valueOf(prefixType));
        Intrinsics.checkNotNull(concurrentHashMap);
        concurrentHashMap.put(valueOf, Boolean.TRUE);
    }

    @Override // com.tencent.qqnt.notification.logic.INotifySessionService
    public int uniqueNotifyIdByUin(final long peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, peerUin)).intValue();
        }
        com.tencent.qqnt.notification.util.a.f359909a.b(TAG, new Function0<String>(peerUin) { // from class: com.tencent.qqnt.notification.logic.impl.NotifySessionServiceImpl$uniqueNotifyIdByUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $peerUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$peerUin = peerUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, peerUin);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "uniqueNotifyIdByUin, peerUin:" + j.f359913a.a(Long.valueOf(this.$peerUin));
            }
        });
        Integer num = this.uinIdMap.get(Long.valueOf(peerUin));
        if (num == null) {
            int i3 = this.currentMinId + 1;
            this.currentMinId = i3;
            if (i3 >= 522) {
                this.currentMinId = 512;
            }
            this.uinIdMap.put(Long.valueOf(peerUin), Integer.valueOf(this.currentMinId));
            num = Integer.valueOf(this.currentMinId);
            saveUinIdMapToSp();
            saveCurrentIdToSp();
        }
        return num.intValue();
    }
}
