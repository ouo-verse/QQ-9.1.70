package com.tencent.qqnt.msg.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.BackGroundInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.msg.api.IMsgPushForegroundApi;
import com.tencent.qqnt.msg.api.IUnreadCountChangeApi;
import com.tencent.qqnt.msg.api.impl.MsgPushForegroundApiImpl;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016JD\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u000f2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl;", "Lcom/tencent/qqnt/msg/api/IMsgPushForegroundApi;", "Lmqq/app/AppRuntime;", "app", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "registerForegroundCallback", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "unreadInfo", "", "type", "Lkotlin/Pair;", "", "getUnreadPairByType", "mApp", "Lmqq/app/AppRuntime;", "Lcom/tencent/qqnt/kernel/api/w;", "mService", "Lcom/tencent/qqnt/kernel/api/w;", "com/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl$b", "mForegroundCallback", "Lcom/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl$b;", "<init>", "()V", "Companion", "a", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgPushForegroundApiImpl implements IMsgPushForegroundApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MsgPushForegroundApiImpl";
    private AppRuntime mApp;

    @NotNull
    private final b mForegroundCallback;

    @Nullable
    private w mService;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msg.api.impl.MsgPushForegroundApiImpl$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl$b", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements QActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/msg/api/impl/MsgPushForegroundApiImpl$b$a", "Lcom/tencent/qqnt/msg/unread/a;", "", "unreadCount", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "unreadInfo", "", "a", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes24.dex */
        public static final class a implements com.tencent.qqnt.msg.unread.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MsgPushForegroundApiImpl f359564a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ IUnreadCountChangeApi f359565b;

            a(MsgPushForegroundApiImpl msgPushForegroundApiImpl, IUnreadCountChangeApi iUnreadCountChangeApi) {
                this.f359564a = msgPushForegroundApiImpl;
                this.f359565b = iUnreadCountChangeApi;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgPushForegroundApiImpl, (Object) iUnreadCountChangeApi);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(int i3, String str) {
                QLog.d(MsgPushForegroundApiImpl.TAG, 1, "switchBackGround res: ", Integer.valueOf(i3), ", errMsg: ", str);
            }

            @Override // com.tencent.qqnt.msg.unread.a
            public void a(int unreadCount, @NotNull HashMap<String, UnreadCntInfo> unreadInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, unreadCount, (Object) unreadInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(unreadInfo, "unreadInfo");
                Pair<Integer, List<String>> unreadPairByType = this.f359564a.getUnreadPairByType(unreadInfo, 1);
                Pair<Integer, List<String>> unreadPairByType2 = this.f359564a.getUnreadPairByType(unreadInfo, 2);
                ArrayList<Long> arrayList = new ArrayList<>();
                try {
                    Iterator<T> it = unreadPairByType2.getSecond().iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
                    }
                } catch (NumberFormatException e16) {
                    QLog.e(MsgPushForegroundApiImpl.TAG, 1, "parseLong error: ", e16);
                }
                BackGroundInfo backGroundInfo = new BackGroundInfo();
                backGroundInfo.c2cUnreadCnt = unreadPairByType.getFirst().intValue();
                backGroundInfo.groupUnreadCnt = unreadPairByType2.getFirst().intValue();
                backGroundInfo.groupUnreadCodes = arrayList;
                QLog.d(MsgPushForegroundApiImpl.TAG, 1, "switchBackGround backgroundInfo: ", backGroundInfo);
                w wVar = this.f359564a.mService;
                if (wVar != null) {
                    wVar.switchBackGround(backGroundInfo, new IOperateCallback() { // from class: com.tencent.qqnt.msg.api.impl.d
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            MsgPushForegroundApiImpl.b.a.c(i3, str);
                        }
                    });
                }
                this.f359565b.unRegisterUnreadCountObserver(this);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgPushForegroundApiImpl.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, String str) {
            QLog.d(MsgPushForegroundApiImpl.TAG, 1, "switchForeGround res: ", Integer.valueOf(i3), ", errMsg: ", str);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) outState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
                return;
            }
            QRouteApi api = QRoute.api(IUnreadCountChangeApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnreadCountChangeApi::class.java)");
            IUnreadCountChangeApi iUnreadCountChangeApi = (IUnreadCountChangeApi) api;
            iUnreadCountChangeApi.registerUnreadCountObserver(new a(MsgPushForegroundApiImpl.this, iUnreadCountChangeApi));
            com.tencent.qqnt.msg.unread.b.f359711a.h();
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                w wVar = MsgPushForegroundApiImpl.this.mService;
                if (wVar != null) {
                    wVar.switchForeGround(new IOperateCallback() { // from class: com.tencent.qqnt.msg.api.impl.c
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            MsgPushForegroundApiImpl.b.b(i3, str);
                        }
                    });
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39927);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgPushForegroundApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mForegroundCallback = new b();
        }
    }

    @NotNull
    public final Pair<Integer, List<String>> getUnreadPairByType(@NotNull HashMap<String, UnreadCntInfo> unreadInfo, int type) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Pair) iPatchRedirector.redirect((short) 5, (Object) this, (Object) unreadInfo, type);
        }
        Intrinsics.checkNotNullParameter(unreadInfo, "unreadInfo");
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<String, UnreadCntInfo>> entrySet = unreadInfo.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "unreadInfo.entries");
        ArrayList<Map.Entry> arrayList2 = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((UnreadCntInfo) ((Map.Entry) next).getValue()).peer.chatType == type) {
                i3 = 1;
            }
            if (i3 != 0) {
                arrayList2.add(next);
            }
        }
        for (Map.Entry entry : arrayList2) {
            i3 += ((UnreadCntInfo) entry.getValue()).showUnreadCnt.cnt;
            arrayList.add(entry.getKey());
        }
        return new Pair<>(Integer.valueOf(i3), arrayList);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        this.mApp = app;
        this.mService = f.e();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IMsgPushForegroundApi
    public void registerForegroundCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            Foreground.addActivityLifeCallback(this.mForegroundCallback);
        }
    }
}
