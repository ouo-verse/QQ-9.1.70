package com.tencent.mobileqq.util.conversationtitlebutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0004/5;:B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J3\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\tJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014JT\u0010%\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001e2<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020#0\"\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060 J:\u0010)\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u001e2\u0018\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0'\u0012\u0004\u0012\u00020\u00060\tJ&\u0010-\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0014R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R0\u00107\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0302j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f03`48\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager;", "", "", "u", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", tl.h.F, "", "t", "needReportImpl", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", DownloadInfo.spKey_Config, "callback", "i", "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$b;", "observer", "f", ReportConstant.COSTREPORT_PREFIX, "p", "", "businessId", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfoForRedPoint", "needClear", "r", "o", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "tips", "", "Landroid/graphics/drawable/Drawable;", "avatars", "k", "appInfoForTip", "", "cb", "g", "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "buttonState", WadlProxyConsts.KEY_JUMP_URL, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$ConfigVerifier;", "a", "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$ConfigVerifier;", "configVerifier", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "configChangeObservers", "<init>", "()V", "c", "ConfigVerifier", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TitleButtonProcessorManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final TitleButtonProcessorManager f306674d = new TitleButtonProcessorManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ConfigVerifier configVerifier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<WeakReference<b>> configChangeObservers = new ArrayList<>();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$ConfigVerifier;", "", "Lcom/tencent/mobileqq/util/conversationtitlebutton/b;", "configList", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "Lkotlin/ParameterName;", "name", DownloadInfo.spKey_Config, "", "callback", "c", "", "a", "I", "verifyingConfigIndex", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class ConfigVerifier {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int verifyingConfigIndex;

        public final void c(final com.tencent.mobileqq.util.conversationtitlebutton.b configList, final Function1<? super ConversationTitleBtnConfig, Unit> callback) {
            Intrinsics.checkNotNullParameter(configList, "configList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.verifyingConfigIndex >= configList.a().size()) {
                QLog.i("TitleButtonProcessorManager", 1, "[verify] no config available, size=" + configList.a().size());
                callback.invoke(null);
                return;
            }
            ConversationTitleBtnConfig conversationTitleBtnConfig = configList.a().get(this.verifyingConfigIndex);
            Intrinsics.checkNotNullExpressionValue(conversationTitleBtnConfig, "configList.configs[verifyingConfigIndex]");
            final ConversationTitleBtnConfig conversationTitleBtnConfig2 = conversationTitleBtnConfig;
            if (!conversationTitleBtnConfig2.i()) {
                QLog.w("TitleButtonProcessorManager", 1, "[verify] config is invalid. config=" + conversationTitleBtnConfig2);
                this.verifyingConfigIndex = this.verifyingConfigIndex + 1;
                c(configList, callback);
                return;
            }
            g gVar = h.f306728a.a().get(conversationTitleBtnConfig2.getBusinessId());
            if (gVar == null) {
                QLog.w("TitleButtonProcessorManager", 1, "[verify] processor not exists, pass. business=" + conversationTitleBtnConfig2.getBusinessId());
                callback.invoke(conversationTitleBtnConfig2);
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            gVar.isSupport(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager$ConfigVerifier$verify$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    int i3;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TitleButtonProcessorManager", 1, "[verify] business available. business=" + conversationTitleBtnConfig2.getBusinessId() + " time=" + currentTimeMillis2);
                        }
                        callback.invoke(conversationTitleBtnConfig2);
                        return;
                    }
                    QLog.w("TitleButtonProcessorManager", 1, "[verify] business not available. business=" + conversationTitleBtnConfig2.getBusinessId() + " time=" + currentTimeMillis2);
                    TitleButtonProcessorManager.ConfigVerifier configVerifier = this;
                    i3 = configVerifier.verifyingConfigIndex;
                    configVerifier.verifyingConfigIndex = i3 + 1;
                    this.c(configList, callback);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$a;", "", "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager;", "a", "()Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager;", "getInstance$annotations", "()V", "", "BUSINESS_ID_CHAT_AI", "Ljava/lang/String;", "TAG", "<init>", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TitleButtonProcessorManager a() {
            return TitleButtonProcessorManager.f306674d;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$b;", "", "", "onConfigChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void onConfigChanged();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$c;", "", "", "businessId", "", "b", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f306678a = new c();

        c() {
        }

        public final void a(String businessId) {
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            HashMap hashMap = new HashMap();
            hashMap.put("param_business_id", businessId);
            hashMap.put("param_event", "2");
            Unit unit = Unit.INSTANCE;
            v.c("", "main_page_right_top_button_act", hashMap);
        }

        public final void b(String businessId) {
            Intrinsics.checkNotNullParameter(businessId, "businessId");
            HashMap hashMap = new HashMap();
            hashMap.put("param_business_id", businessId);
            hashMap.put("param_event", "1");
            Unit unit = Unit.INSTANCE;
            v.c("", "main_page_right_top_button_act", hashMap);
        }
    }

    TitleButtonProcessorManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationTitleBtnConfig h() {
        return new ConversationTitleBtnConfig("Adelie", 0, 0, 0, 0, "https://static-res.qq.com/static-res/adelie/home/animated_robot_entrance_v3.png", "mqqapi://adelie/open_home?source=1", "\u667a\u80fd\u4f53");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(g gVar, Context context, long j3, Function2 callback) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            gVar.getCustomTips(context, new TitleButtonProcessorManager$getCustomTips$1$1(j3, callback));
        } catch (Throwable th5) {
            QLog.w("TitleButtonProcessorManager", 1, "[getCustomTips] error: " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TitleButtonProcessorManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.configChangeObservers.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onConfigChanged();
            }
        }
    }

    private final void t() {
        Iterator<WeakReference<b>> it = this.configChangeObservers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "configChangeObservers.iterator()");
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "it.next()");
            if (next.get() == null) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        return false;
    }

    public final void f(b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        t();
        Iterator<T> it = this.configChangeObservers.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == observer) {
                return;
            }
        }
        this.configChangeObservers.add(new WeakReference<>(observer));
    }

    public final void g(String businessId, BusinessInfoCheckUpdate.AppInfo appInfoForTip, Context context, Function1<? super Drawable[], Unit> cb5) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        g gVar = h.f306728a.a().get(businessId);
        if (gVar != null) {
            gVar.getAvatarDrawableList(context, appInfoForTip, cb5);
        } else {
            cb5.invoke(new Drawable[0]);
        }
    }

    public final void i(final boolean needReportImpl, final Function1<? super ConversationTitleBtnConfig, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.util.conversationtitlebutton.b bVar = (com.tencent.mobileqq.util.conversationtitlebutton.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("qq_conversation_second_button_config");
        if (bVar == null) {
            QLog.i("TitleButtonProcessorManager", 1, "[getCurrentConfig] config is null");
            callback.invoke(new ConversationTitleBtnConfig(null, 0, 0, 0, 0, null, null, null, 255, null));
        } else {
            ConfigVerifier configVerifier = new ConfigVerifier();
            configVerifier.c(bVar, new Function1<ConversationTitleBtnConfig, Unit>() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager$getCurrentConfig$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConversationTitleBtnConfig conversationTitleBtnConfig) {
                    invoke2(conversationTitleBtnConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ConversationTitleBtnConfig conversationTitleBtnConfig) {
                    boolean u16;
                    ConversationTitleBtnConfig h16;
                    u16 = TitleButtonProcessorManager.this.u();
                    if (u16) {
                        if (!Intrinsics.areEqual(conversationTitleBtnConfig != null ? conversationTitleBtnConfig.getBusinessId() : null, "Adelie")) {
                            Function1<ConversationTitleBtnConfig, Unit> function1 = callback;
                            h16 = TitleButtonProcessorManager.this.h();
                            function1.invoke(h16);
                            return;
                        }
                    }
                    if (conversationTitleBtnConfig != null && needReportImpl) {
                        g gVar = h.f306728a.a().get(conversationTitleBtnConfig.getBusinessId());
                        if (gVar != null) {
                            gVar.onButtonDidShow(conversationTitleBtnConfig);
                        }
                        TitleButtonProcessorManager.c.f306678a.b(conversationTitleBtnConfig.getBusinessId());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("TitleButtonProcessorManager", 1, "[getCurrentConfig] config=" + (conversationTitleBtnConfig != null ? conversationTitleBtnConfig.getBusinessId() : null));
                    }
                    Function1<ConversationTitleBtnConfig, Unit> function12 = callback;
                    if (conversationTitleBtnConfig == null) {
                        conversationTitleBtnConfig = new ConversationTitleBtnConfig(null, 0, 0, 0, 0, null, null, null, 255, null);
                    }
                    function12.invoke(conversationTitleBtnConfig);
                }
            });
            this.configVerifier = configVerifier;
        }
    }

    public final void k(String businessId, final Context context, final Function2<? super String, ? super List<? extends Drawable>, Unit> callback) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final g gVar = h.f306728a.a().get(businessId);
        if (gVar == null) {
            QLog.w("TitleButtonProcessorManager", 1, "[getCustomTips] processor is null, businessId=" + businessId);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.j
            @Override // java.lang.Runnable
            public final void run() {
                TitleButtonProcessorManager.l(g.this, context, currentTimeMillis, callback);
            }
        }, 16, null, false);
    }

    public final boolean m(TitleButtonState buttonState, String businessId, Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(buttonState, "buttonState");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        c.f306678a.a(businessId);
        g gVar = h.f306728a.a().get(businessId);
        if (gVar != null) {
            return gVar.handleIconClick(buttonState, context, jumpUrl);
        }
        return false;
    }

    public final boolean n(String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        g gVar = h.f306728a.a().get(businessId);
        if (gVar != null) {
            return gVar.needCustomizeRedDot();
        }
        return false;
    }

    public final boolean o(String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        g gVar = h.f306728a.a().get(businessId);
        if (gVar != null) {
            return gVar.needCustomizeTips();
        }
        return false;
    }

    public final void p() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.i
            @Override // java.lang.Runnable
            public final void run() {
                TitleButtonProcessorManager.q(TitleButtonProcessorManager.this);
            }
        });
    }

    public final void r(String businessId, RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfoForRedPoint, boolean needClear) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        Intrinsics.checkNotNullParameter(appInfoForRedPoint, "appInfoForRedPoint");
        try {
            g gVar = h.f306728a.a().get(businessId);
            if (gVar != null) {
                gVar.refreshRedDot(redTouch, appInfoForRedPoint, needClear);
            }
        } catch (Throwable th5) {
            QLog.w("TitleButtonProcessorManager", 1, "[refreshRedDot] error: " + th5);
        }
    }

    public final void s(b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = this.configChangeObservers.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == observer) {
                this.configChangeObservers.remove(weakReference);
                return;
            }
        }
    }

    public static /* synthetic */ void j(TitleButtonProcessorManager titleButtonProcessorManager, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        titleButtonProcessorManager.i(z16, function1);
    }
}
