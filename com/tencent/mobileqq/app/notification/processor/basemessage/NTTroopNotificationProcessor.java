package com.tencent.mobileqq.app.notification.processor.basemessage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.chats.api.IChatsConfigRuntimeService;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import com.tencent.qqnt.notification.logic.INotifySessionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@KeepClassConstructor
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u000b2\u00020\u0001:\u0007\r\u001d\u001e\u001f\u0011\u0015\u000bB\u0019\b\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor;", "Lcom/tencent/qqnt/notification/struct/b;", "", "u", "t", "Landroid/graphics/Bitmap;", "j", "brief", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", h.F, "g", "", "a", "Landroid/content/Intent;", "k", "", "e", "Ljava/util/List;", "notShowSenderNickList", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "f", "prefixMatcherList", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "b", "c", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class NTTroopNotificationProcessor extends com.tencent.qqnt.notification.struct.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> notShowSenderNickList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<f> prefixMatcherList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$a;", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a implements f {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor.f
        @Nullable
        public String a(@NotNull RecentContactInfo item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Companion companion = NTTroopNotificationProcessor.INSTANCE;
            if (companion.j(item)) {
                return companion.h().getApp().getString(R.string.f171242n8);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$b;", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class b implements f {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor.f
        @Nullable
        public String a(@NotNull RecentContactInfo item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Companion companion = NTTroopNotificationProcessor.INSTANCE;
            if (companion.k(item)) {
                return companion.h().getApp().getString(R.string.f171252n9);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\n0\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$c;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "eventType", "", "l", "k", "j", "Lmqq/app/AppRuntime;", "appRuntime", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "kotlin.jvm.PlatformType", h.F, "id", "", "i", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor$c, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final AppRuntime h() {
            return MobileQQ.sMobileQQ.peekAppRuntime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String i(int id5) {
            String string = h().getApp().getString(id5);
            Intrinsics.checkNotNullExpressionValue(string, "getAppRuntime().app.getString(id)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean j(RecentContactInfo item) {
            if ((item.atType & 1) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k(RecentContactInfo item) {
            if ((item.atType & 4) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean l(RecentContactInfo item, int eventType) {
            SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox;
            ArrayList<MsgBoxNecessaryMsgInfo> arrayList;
            boolean z16;
            Object obj;
            boolean z17;
            ArrayList<SpecificEventTypeInfoInMsgBox> arrayList2 = item.listOfSpecificEventTypeInfosInMsgBox;
            Object obj2 = null;
            if (arrayList2 != null) {
                Iterator<T> it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((SpecificEventTypeInfoInMsgBox) obj).eventTypeInMsgBox == eventType) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                specificEventTypeInfoInMsgBox = (SpecificEventTypeInfoInMsgBox) obj;
            } else {
                specificEventTypeInfoInMsgBox = null;
            }
            if (specificEventTypeInfoInMsgBox != null && (arrayList = specificEventTypeInfoInMsgBox.msgInfos) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (((MsgBoxNecessaryMsgInfo) next).msgSeq == item.msgSeq) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj2 = next;
                        break;
                    }
                }
                obj2 = (MsgBoxNecessaryMsgInfo) obj2;
            }
            if (obj2 != null) {
                return true;
            }
            return false;
        }

        private final boolean m(RecentContactInfo item, int eventType) {
            boolean z16;
            ArrayList<SpecificEventTypeInfoInMsgBox> arrayList = item.listOfSpecificEventTypeInfosInMsgBox;
            Object obj = null;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((SpecificEventTypeInfoInMsgBox) next).eventTypeInMsgBox == eventType) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj = next;
                        break;
                    }
                }
                obj = (SpecificEventTypeInfoInMsgBox) obj;
            }
            if (obj != null) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean n(AppRuntime appRuntime, RecentContactInfo item) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(INotifySessionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService;
            boolean l3 = l(item, 2006);
            if (l3) {
                iNotifySessionService.setSessionNeedPrefix(item.peerUin, 1);
            }
            boolean m3 = m(item, 2006);
            boolean sessionNeedPrefix = iNotifySessionService.getSessionNeedPrefix(item.peerUin, 2);
            if (l3) {
                return true;
            }
            if (m3 && sessionNeedPrefix) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean o(AppRuntime appRuntime, RecentContactInfo item) {
            IRuntimeService runtimeService = appRuntime.getRuntimeService(INotifySessionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            INotifySessionService iNotifySessionService = (INotifySessionService) runtimeService;
            boolean l3 = l(item, 1006);
            if (l3) {
                iNotifySessionService.setSessionNeedPrefix(item.peerUin, 1);
            }
            boolean m3 = m(item, 1006);
            boolean sessionNeedPrefix = iNotifySessionService.getSessionNeedPrefix(item.peerUin, 1);
            if (l3) {
                return true;
            }
            if (m3 && sessionNeedPrefix) {
                return true;
            }
            return false;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$d;", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class d implements f {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor.f
        @Nullable
        public String a(@NotNull RecentContactInfo item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Companion companion = NTTroopNotificationProcessor.INSTANCE;
            AppRuntime h16 = companion.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getAppRuntime()");
            if (companion.n(h16, item)) {
                return companion.h().getApp().getString(R.string.f171282nb);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$e;", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "", "I", "getEventType", "()I", "eventType", "b", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(ILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class e implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int eventType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        public e(int i3, @NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) text);
            } else {
                this.eventType = i3;
                this.text = text;
            }
        }

        @Override // com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor.f
        @Nullable
        public String a(@NotNull RecentContactInfo item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            if (NTTroopNotificationProcessor.INSTANCE.l(item, this.eventType)) {
                return this.text;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface f {
        @Nullable
        String a(@NotNull RecentContactInfo item);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$g;", "Lcom/tencent/mobileqq/app/notification/processor/basemessage/NTTroopNotificationProcessor$f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class g implements f {
        static IPatchRedirector $redirector_;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.notification.processor.basemessage.NTTroopNotificationProcessor.f
        @Nullable
        public String a(@NotNull RecentContactInfo item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Companion companion = NTTroopNotificationProcessor.INSTANCE;
            AppRuntime h16 = companion.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getAppRuntime()");
            if (companion.o(h16, item)) {
                return companion.h().getApp().getString(R.string.f171332ng);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected NTTroopNotificationProcessor(@NotNull AppRuntime app, @NotNull RecentContactInfo msgRecord) {
        super(app, msgRecord);
        List<Integer> listOf;
        List<f> listOf2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(MessageRecord.MSG_TYPE_REVOKE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_FEE), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT_OBJ), Integer.valueOf(MessageRecord.MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS), Integer.valueOf(MessageRecord.MSG_TYPE_HOMEWORK_PRAISE), Integer.valueOf(MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM), Integer.valueOf(MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_GIFT)});
            this.notShowSenderNickList = listOf;
            Companion companion = INSTANCE;
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new e(1004, companion.i(R.string.f171272na)), new e(1007, companion.i(R.string.f171312ne)), new e(1002, companion.i(R.string.f171322nf)), new b(), new a(), new e(1005, companion.i(R.string.f171262n_)), new e(2004, companion.i(R.string.f171352ni)), new e(2005, companion.i(R.string.f171352ni)), new e(2003, companion.i(R.string.f171302nd)), new e(2001, companion.i(R.string.f171292nc)), new g(), new d(), new e(20003, companion.i(R.string.f171342nh))});
            this.prefixMatcherList = listOf2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) msgRecord);
    }

    private final String t() {
        Iterator<T> it = this.prefixMatcherList.iterator();
        while (it.hasNext()) {
            String a16 = ((f) it.next()).a(d());
            if (a16 != null) {
                return a16;
            }
        }
        return "";
    }

    private final String u() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String nickName = "";
        IRuntimeService runtimeService = c().getRuntimeService(IChatsConfigRuntimeService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        boolean z26 = true;
        if (((IChatsConfigRuntimeService) runtimeService).nickUseNTOrder()) {
            String str = d().sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.sendRemarkName");
            if (str.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                nickName = d().sendRemarkName;
            } else {
                String str2 = d().sendMemberName;
                Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.sendMemberName");
                if (str2.length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    nickName = d().sendMemberName;
                } else {
                    String str3 = d().sendNickName;
                    Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.sendNickName");
                    if (str3.length() <= 0) {
                        z26 = false;
                    }
                    if (z26) {
                        nickName = d().sendNickName;
                    } else if (d().senderUin != 0) {
                        nickName = String.valueOf(d().senderUin);
                    }
                }
            }
        } else {
            String str4 = d().sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str4, "msgRecord.sendMemberName");
            if (str4.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                nickName = d().sendMemberName;
            } else {
                String str5 = d().sendRemarkName;
                Intrinsics.checkNotNullExpressionValue(str5, "msgRecord.sendRemarkName");
                if (str5.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    nickName = d().sendRemarkName;
                } else {
                    String str6 = d().sendNickName;
                    Intrinsics.checkNotNullExpressionValue(str6, "msgRecord.sendNickName");
                    if (str6.length() <= 0) {
                        z26 = false;
                    }
                    if (z26) {
                        nickName = d().sendNickName;
                    } else if (d().senderUin != 0) {
                        nickName = String.valueOf(d().senderUin);
                    }
                }
            }
        }
        IQQTextApi iQQTextApi = (IQQTextApi) QRoute.api(IQQTextApi.class);
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        return iQQTextApi.getQQTextPurePlainText(nickName, 16).toString();
    }

    @Override // com.tencent.qqnt.notification.struct.c
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return e(d());
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (Build.VERSION.SDK_INT >= 29 && NotificationFacade.INSTANCE.a().b()) {
            return QQNotificationManager.CHANNEL_ID_GROUP_MSG;
        }
        return super.g();
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @NotNull
    public String h(@NotNull String brief, @Nullable com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) brief, (Object) notificationExtInfo);
        }
        Intrinsics.checkNotNullParameter(brief, "brief");
        if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isSessionShowPreview(d().peerUin, d().chatType, notificationExtInfo)) {
            String string = c().getApp().getString(R.string.f172180o32);
            Intrinsics.checkNotNullExpressionValue(string, "appRuntime.app.getString\u2026.qqstr_messagen_d049f4a8)");
            String string2 = c().getApp().getString(R.string.f172181o33);
            Intrinsics.checkNotNullExpressionValue(string2, "appRuntime.app.getString\u2026.qqstr_messagen_ed6e14aa)");
            IRuntimeService runtimeService = c().getRuntimeService(INotifyCountService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            return string + ((INotifyCountService) runtimeService).getCountBySession(d().peerUin, d().chatType) + string2;
        }
        return t() + u() + MsgSummary.STR_COLON + brief;
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Bitmap j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return NotificationFacade.INSTANCE.a().i(d());
    }

    @Override // com.tencent.qqnt.notification.struct.BaseUinTypeProcessor
    @Nullable
    public Intent k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Intent) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Intent k3 = super.k();
        com.tencent.mobileqq.listentogether.g.c(d(), k3);
        return k3;
    }
}
