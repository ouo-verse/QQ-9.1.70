package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZplanBubbleProcessor;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0004()\u0013\u0010B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00022\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00190\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor;", "Lcom/tencent/mobileqq/processor/c;", "", "r", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "p", "", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "entryMap", "o", "", "w", "Lcom/tencent/mobileqq/qqsettingme/a;", "qqSettingMe", "d", "Lmqq/app/AppRuntime;", "app", "c", "onResume", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/q;", tl.h.F, "Landroidx/lifecycle/MutableLiveData;", "zplanBubbleBeanLiveData", "", "i", "Ljava/util/Map;", "zplanBubbleBeanMap", "", "j", "Z", "isV9", "<init>", "()V", "k", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQSettingMeZplanBubbleProcessor extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.q> zplanBubbleBeanLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, com.tencent.mobileqq.activity.qqsettingme.bean.q> zplanBubbleBeanMap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isV9;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZplanBubbleProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor$b;", "", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "b", "", "actionId", "", "adId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "c", "", "a", "hasRequest", "d", "", "Ljava/util/Map;", "USER_REQUEST_RECORD_MAP", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f184771a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Map<String, Boolean> USER_REQUEST_RECORD_MAP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52544);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                f184771a = new b();
                USER_REQUEST_RECORD_MAP = new LinkedHashMap();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a() {
            String currentUin;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (currentUin = peekAppRuntime.getCurrentUin()) == null) {
                return false;
            }
            boolean z16 = !Intrinsics.areEqual(USER_REQUEST_RECORD_MAP.get(currentUin), Boolean.TRUE);
            QLog.i("QQSettingMeZplanBubbleProcessor", 1, "checkNeedRequestTianShu? " + z16);
            return z16;
        }

        @NotNull
        public final List<TianShuAdPosItemData> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = gdt_analysis_event.EVENT_GET_WEBVIEW_USER_AGENT;
            arrayList.add(tianShuAdPosItemData);
            return arrayList;
        }

        public final void c(int actionId, @NotNull String adId, @NotNull String traceInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(actionId), adId, traceInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(adId, "adId");
            Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
            cooperation.vip.ad.w.d(adId, actionId, traceInfo);
        }

        public final void d(boolean hasRequest) {
            String currentUin;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, hasRequest);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (currentUin = peekAppRuntime.getCurrentUin()) == null) {
                return;
            }
            USER_REQUEST_RECORD_MAP.put(currentUin, Boolean.valueOf(hasRequest));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor$c;", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor;", "d", "Lmqq/util/WeakReference;", "processorRef", "processor", "<init>", "(Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QQSettingMeZplanBubbleProcessor> processorRef;

        public c(@NotNull QQSettingMeZplanBubbleProcessor processor) {
            Intrinsics.checkNotNullParameter(processor, "processor");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) processor);
            } else {
                this.processorRef = new WeakReference<>(processor);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TianShuAccess.GetAdsRsp getAdsRsp, c this$0) {
            QQSettingMeZplanBubbleProcessor qQSettingMeZplanBubbleProcessor;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (getAdsRsp != null && (qQSettingMeZplanBubbleProcessor = this$0.processorRef.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(qQSettingMeZplanBubbleProcessor, "get()");
                qQSettingMeZplanBubbleProcessor.p(getAdsRsp);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, @Nullable final TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(result), getAdsRsp);
            } else if (!result) {
                QLog.e("QQSettingMeZplanBubbleProcessor", 1, "onGetAdvs fail");
                b.f184771a.d(false);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bi
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQSettingMeZplanBubbleProcessor.c.b(TianShuAccess.GetAdsRsp.this, this);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZplanBubbleProcessor$d;", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/q;", "b", "bubble", "", "c", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f184774a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52546);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                f184774a = new d();
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a(@Nullable com.tencent.mobileqq.activity.qqsettingme.bean.q bubble) {
            AppRuntime peekAppRuntime;
            String currentUin;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bubble)).booleanValue();
            }
            if (bubble == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (currentUin = peekAppRuntime.getCurrentUin()) == null) {
                return false;
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            boolean decodeBool = from.decodeBool("qq_setting_me_zplan_bubble_click_" + bubble.f184950a + "_" + currentUin, false);
            if (decodeBool) {
                QLog.i("QQSettingMeZplanBubbleProcessor", 2, "checkUserClickRecord user has click. adId: " + bubble.f184950a);
            }
            return decodeBool;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:44:0x00c2. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[Catch: Exception -> 0x018d, TryCatch #0 {Exception -> 0x018d, blocks: (B:10:0x0021, B:12:0x0025, B:13:0x002f, B:15:0x0033, B:16:0x0039, B:18:0x003d, B:19:0x0043, B:22:0x0063, B:24:0x006c, B:26:0x0072, B:28:0x007a, B:30:0x007e, B:32:0x0086, B:34:0x008a, B:35:0x0090, B:38:0x00b2, B:40:0x00b6, B:43:0x00be, B:44:0x00c2, B:46:0x00c6, B:49:0x00d0, B:51:0x00d4, B:58:0x00da, B:65:0x00e8, B:68:0x00f3, B:74:0x00f7, B:80:0x0101, B:83:0x010c, B:85:0x0110, B:92:0x0117, B:95:0x0122, B:101:0x0126, B:107:0x0130, B:110:0x013b, B:116:0x013f, B:122:0x0149, B:125:0x0154, B:131:0x0158, B:147:0x0167, B:150:0x016f, B:152:0x0176, B:153:0x017c), top: B:9:0x0021 }] */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final com.tencent.mobileqq.activity.qqsettingme.bean.q b(@NotNull TianShuAccess.AdItem adItem) {
            Integer num;
            String str;
            List<TianShuAccess.MapEntry> list;
            String str2;
            String str3;
            String str4;
            int i3;
            String str5;
            int i16;
            String str6;
            String str7;
            String str8;
            String str9;
            PBStringField pBStringField;
            PBStringField pBStringField2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.activity.qqsettingme.bean.q) iPatchRedirector.redirect((short) 2, (Object) this, (Object) adItem);
            }
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            try {
                PBUInt32Field pBUInt32Field = adItem.iAdId;
                if (pBUInt32Field != null) {
                    num = Integer.valueOf(pBUInt32Field.get());
                } else {
                    num = null;
                }
                PBStringField pBStringField3 = adItem.traceinfo;
                if (pBStringField3 != null) {
                    str = pBStringField3.get();
                } else {
                    str = null;
                }
                PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField = adItem.argList;
                if (pBRepeatMessageField != null) {
                    list = pBRepeatMessageField.get();
                } else {
                    list = null;
                }
                QLog.i("QQSettingMeZplanBubbleProcessor", 2, "parse bubble adId[" + num + "]");
                String str10 = "";
                if (list == null) {
                    str2 = "";
                    str3 = str2;
                    str4 = null;
                    i3 = 0;
                    str5 = null;
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = null;
                    i3 = 0;
                    while (true) {
                        str5 = null;
                        for (TianShuAccess.MapEntry mapEntry : list) {
                            if (mapEntry != null && (pBStringField2 = mapEntry.key) != null) {
                                str6 = pBStringField2.get();
                            } else {
                                str6 = null;
                            }
                            if (mapEntry != null && (pBStringField = mapEntry.value) != null) {
                                str7 = pBStringField.get();
                            } else {
                                str7 = null;
                            }
                            QLog.i("QQSettingMeZplanBubbleProcessor", 2, "parse bubble kv: " + str6 + MsgSummary.STR_COLON + str7);
                            if (mapEntry != null) {
                                PBStringField pBStringField4 = mapEntry.key;
                                if (pBStringField4 != null) {
                                    str8 = pBStringField4.get();
                                } else {
                                    str8 = null;
                                }
                                if (str8 != null) {
                                    switch (str8.hashCode()) {
                                        case -2079578164:
                                            if (str8.equals("sub_text")) {
                                                PBStringField pBStringField5 = mapEntry.value;
                                                if (pBStringField5 != null) {
                                                    str3 = pBStringField5.get();
                                                    break;
                                                } else {
                                                    str3 = null;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        case 110986:
                                            if (str8.equals("pic")) {
                                                PBStringField pBStringField6 = mapEntry.value;
                                                if (pBStringField6 != null) {
                                                    str4 = pBStringField6.get();
                                                    break;
                                                } else {
                                                    str4 = null;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        case 116079:
                                            if (str8.equals("url")) {
                                                PBStringField pBStringField7 = mapEntry.value;
                                                if (pBStringField7 != null) {
                                                    str10 = pBStringField7.get();
                                                    break;
                                                } else {
                                                    str10 = null;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        case 3226745:
                                            if (str8.equals("icon")) {
                                                PBStringField pBStringField8 = mapEntry.value;
                                                if (pBStringField8 != null) {
                                                    str5 = pBStringField8.get();
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                            break;
                                        case 3556653:
                                            if (str8.equals("text")) {
                                                PBStringField pBStringField9 = mapEntry.value;
                                                if (pBStringField9 != null) {
                                                    str2 = pBStringField9.get();
                                                    break;
                                                } else {
                                                    str2 = null;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        case 3575610:
                                            if (str8.equals("type")) {
                                                PBStringField pBStringField10 = mapEntry.value;
                                                if (pBStringField10 != null && (str9 = pBStringField10.get()) != null) {
                                                    Intrinsics.checkNotNullExpressionValue(str9, "get()");
                                                    i3 = Integer.parseInt(str9);
                                                    break;
                                                } else {
                                                    i3 = 0;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                    }
                                    while (r0.hasNext()) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
                if (!com.tencent.mobileqq.activity.qqsettingme.utils.b.g(str4, i3, str10)) {
                    return null;
                }
                com.tencent.mobileqq.activity.qqsettingme.bean.q qVar = new com.tencent.mobileqq.activity.qqsettingme.bean.q();
                if (num != null) {
                    i16 = num.intValue();
                } else {
                    i16 = 0;
                }
                qVar.f184950a = i16;
                qVar.f184951b = str;
                qVar.f184952c = str4;
                qVar.f184953d = str5;
                qVar.f184954e = str2;
                qVar.f184955f = str3;
                qVar.f184956g = i3;
                qVar.f184957h = str10;
                return qVar;
            } catch (Exception e16) {
                QLog.e("QQSettingMeZplanBubbleProcessor", 1, "parse catch exception", e16);
                return null;
            }
        }

        public final void c(@Nullable com.tencent.mobileqq.activity.qqsettingme.bean.q bubble) {
            AppRuntime peekAppRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bubble);
                return;
            }
            if (bubble == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime() ?: return");
            String currentUin = peekAppRuntime.getCurrentUin();
            if (currentUin == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin ?: return");
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeBool("qq_setting_me_zplan_bubble_click_" + bubble.f184950a + "_" + currentUin, true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeZplanBubbleProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.zplanBubbleBeanLiveData = new MutableLiveData<>(null);
            this.zplanBubbleBeanMap = new LinkedHashMap();
        }
    }

    private final void o(Map<Integer, TianShuAccess.RspEntry> entryMap) {
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        TianShuAccess.AdItem adItem;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        boolean z16 = true;
        if (entryMap == null) {
            QLog.e("QQSettingMeZplanBubbleProcessor", 1, "handleDrawerZplanBubble entryMap null");
            return;
        }
        TianShuAccess.RspEntry rspEntry = entryMap.get(Integer.valueOf(gdt_analysis_event.EVENT_GET_WEBVIEW_USER_AGENT));
        String str = null;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null) {
            pBRepeatMessageField = adPlacementInfo.lst;
        } else {
            pBRepeatMessageField = null;
        }
        if (pBRepeatMessageField == null || !pBRepeatMessageField.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (pBRepeatMessageField != null) {
            adItem = pBRepeatMessageField.get(0);
        } else {
            adItem = null;
        }
        if (adItem == null) {
            return;
        }
        d dVar = d.f184774a;
        com.tencent.mobileqq.activity.qqsettingme.bean.q b16 = dVar.b(adItem);
        if (!dVar.a(b16)) {
            this.zplanBubbleBeanLiveData.setValue(b16);
            if (b16 != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    str = peekAppRuntime.getCurrentUin();
                }
                if (str != null) {
                    this.zplanBubbleBeanMap.put(str, b16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        o(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void r() {
        b bVar = b.f184771a;
        if (bVar.a()) {
            bVar.d(true);
            TianShuManager.getInstance().requestAdv(bVar.b(), new c(this));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(@Nullable AppRuntime app) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) app);
            return;
        }
        QLog.i("QQSettingMeZplanBubbleProcessor", 2, "fillData");
        com.tencent.mobileqq.activity.qqsettingme.bean.q qVar = null;
        if (app != null) {
            str = app.getCurrentUin();
        } else {
            str = null;
        }
        if (str != null) {
            qVar = this.zplanBubbleBeanMap.get(str);
        } else {
            QLog.e("QQSettingMeZplanBubbleProcessor", 1, "fillData uin is null");
        }
        this.zplanBubbleBeanLiveData.setValue(qVar);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(@Nullable final com.tencent.mobileqq.qqsettingme.a qqSettingMe) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqSettingMe);
            return;
        }
        if (qqSettingMe != null) {
            z16 = qqSettingMe.n();
        } else {
            z16 = false;
        }
        this.isV9 = z16;
        QLog.i("QQSettingMeZplanBubbleProcessor", 2, "initViewBinder isV9? " + z16);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.q> mutableLiveData = this.zplanBubbleBeanLiveData;
        LifecycleOwner lifecycleOwner = this.f259743d;
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.q, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.q, Unit>() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZplanBubbleProcessor$initViewBinder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqsettingme.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.q qVar) {
                invoke2(qVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.activity.qqsettingme.bean.q qVar) {
                QQSettingMeViewModel k3;
                MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.q> mutableLiveData2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) qVar);
                    return;
                }
                com.tencent.mobileqq.qqsettingme.a aVar = com.tencent.mobileqq.qqsettingme.a.this;
                if (aVar != null) {
                    aVar.U(qVar);
                }
                com.tencent.mobileqq.qqsettingme.a aVar2 = com.tencent.mobileqq.qqsettingme.a.this;
                if (aVar2 == null || (k3 = aVar2.k()) == null || (mutableLiveData2 = k3.R) == null) {
                    return;
                }
                mutableLiveData2.postValue(qVar);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.qqsettingme.bh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZplanBubbleProcessor.q(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(@Nullable View v3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.q value = this.zplanBubbleBeanLiveData.getValue();
        if (value != null) {
            b bVar = b.f184771a;
            String valueOf = String.valueOf(value.f184950a);
            String str = value.f184951b;
            Intrinsics.checkNotNullExpressionValue(str, "it.traceInfo");
            bVar.c(102, valueOf, str);
            String str2 = value.f184957h;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                int i3 = value.f184956g;
                if (i3 != 1) {
                    if (i3 != 2) {
                        QLog.i("QQSettingMeZplanBubbleProcessor", 2, "onClick type: " + i3);
                    } else {
                        com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), qBaseActivity, value.f184957h);
                        if (c16 != null) {
                            c16.b();
                        } else {
                            QLog.e("QQSettingMeZplanBubbleProcessor", 1, "onClick parse jumpAction is null. scheme= " + value.f184957h);
                        }
                    }
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("url", value.f184957h);
                    RouteUtils.startActivity(qBaseActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
                }
            } else {
                QLog.i("QQSettingMeZplanBubbleProcessor", 1, "onClick scheme is: [" + value.f184957h + "]");
            }
        }
        d.f184774a.c(value);
        String str3 = null;
        this.zplanBubbleBeanLiveData.setValue(null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str3 = peekAppRuntime.getCurrentUin();
        }
        if (str3 != null) {
            this.zplanBubbleBeanMap.remove(str3);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        QLog.i("QQSettingMeZplanBubbleProcessor", 2, "onResume");
        if (this.isV9) {
            com.tencent.mobileqq.activity.qqsettingme.bean.q value = this.zplanBubbleBeanLiveData.getValue();
            if (value != null) {
                b bVar = b.f184771a;
                String valueOf = String.valueOf(value.f184950a);
                String str = value.f184951b;
                Intrinsics.checkNotNullExpressionValue(str, "bean.traceInfo");
                bVar.c(101, valueOf, str);
                return;
            }
            r();
            return;
        }
        QLog.e("QQSettingMeZplanBubbleProcessor", 2, "onResume not v9");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    @NotNull
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_zplan_bubble";
    }
}
