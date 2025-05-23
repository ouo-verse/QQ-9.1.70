package com.tencent.qqnt.aio.assistedchat.panel.setting;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.m;
import com.tencent.mobileqq.widget.listitem.o;
import com.tencent.mobileqq.widget.listitem.p;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.panel.extend.PanelExtendRecyclerView;
import com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingUIState;
import com.tencent.qqnt.aio.assistedchat.panel.setting.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.widget.AlphaClickableImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0016\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010)\u001a\u00020\u001c2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010(\u001a\u00020\u001cH\u0002J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,H\u0002J(\u00103\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,2\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0002J(\u00104\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,2\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0002J\u0018\u00105\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u00109\u001a\u00020\u000b*\u0006\u0012\u0002\b\u0003062\u0006\u00108\u001a\u000207H\u0002R\u0018\u0010<\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "", "bindViewAndData", "state", "x1", "Landroid/content/Context;", "context", ICustomDataEditor.STRING_PARAM_1, "v1", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", "u1", "r1", "N1", "O1", "", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", VideoTemplateParser.ITEM_LIST, "R1", "", "switchOn", "Lcom/tencent/mobileqq/widget/listitem/Group;", "l1", "o1", "A1", "z1", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "Q1", "Lcom/tencent/mobileqq/widget/listitem/w;", DownloadInfo.spKey_Config, "isChecked", "P1", "I1", "K1", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "y1", "", "", "", "params", "E1", Constants.BASE_IN_PLUGIN_ID, "J1", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/g;", "listener", Constants.APK_CERTIFICATE, "d", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "e", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "settingAdapter", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "f", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/b;", "panelExtendHelper", "", tl.h.F, "Ljava/util/Map;", "configMap", "<init>", "()V", "i", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelSettingVB extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PanelExtendRecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIListItemAdapter settingAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.assistedchat.panel.extend.b panelExtendHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<AssistedChatSwitchType, w<?>> configMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVB$a;", "", "", "TAG", "Ljava/lang/String;", "URL_AUTO_POLISH_DARK", "URL_AUTO_POLISH_LIGHT", "URL_REPLY_SUGGESTION_DARK", "URL_REPLY_SUGGESTION_LIGHT", "URL_TOPIC_RECOMMEND_DARK", "URL_TOPIC_RECOMMEND_LIGHT", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVB$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f349263a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59487);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AssistedChatSwitchType.values().length];
            try {
                iArr[AssistedChatSwitchType.AUTO_POLISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AssistedChatSwitchType.REPLY_SUGGESTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f349263a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPanelSettingVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configMap = new LinkedHashMap();
        }
    }

    private final Group A1(final boolean switchOn) {
        String str;
        x xVar = new x(new x.b.d("\u56de\u590d\u5efa\u8bae"), new x.c.f(switchOn, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AssistedChatPanelSettingVB.B1(AssistedChatPanelSettingVB.this, compoundButton, z16);
            }
        }));
        if (z1()) {
            str = "https://downv6.qq.com/extendfriend/assisted_chat_setting_ai_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/assisted_chat_setting_ai_light.png";
        }
        a aVar = new a(str, xVar);
        this.configMap.put(AssistedChatSwitchType.REPLY_SUGGESTION, aVar);
        G1(aVar, new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AssistedChatPanelSettingVB.C1(switchOn, view);
            }
        });
        return new Group("", "\u5f00\u542f\u540e\uff0c\u5728\u5bf9\u65b9\u6d88\u606f\u540e\u4e3a\u4f60\u63a8\u8350\u56de\u590d\u3002", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(AssistedChatPanelSettingVB this$0, CompoundButton buttonView, boolean z16) {
        String str;
        Map<String, String> mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!((IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class)).isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0)) && z16) {
            AssistedChatSwitchType assistedChatSwitchType = AssistedChatSwitchType.REPLY_SUGGESTION;
            this$0.Q1(assistedChatSwitchType, false);
            this$0.K1(assistedChatSwitchType, true);
        } else {
            this$0.I1(AssistedChatSwitchType.REPLY_SUGGESTION, z16);
        }
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.a("em_kl_reply_suggest_switch", buttonView, mapOf);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(boolean z16, View view) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.c("em_kl_reply_suggest_switch", view, mapOf);
    }

    private final void D1(QQCustomDialog dialog, Map<String, ? extends Object> params) {
        String str;
        Map mutableMapOf;
        Map plus;
        TextView messageTextView = dialog.getMessageTextView();
        if (messageTextView == null) {
            return;
        }
        PageInfo pageInfo = VideoReport.getPageInfo(messageTextView);
        if (pageInfo != null) {
            str = pageInfo.getPageId();
        } else {
            str = null;
        }
        VideoReport.setElementId(messageTextView, "em_kl_panel_switch_pop");
        if (params != null) {
            VideoReport.setElementParams(messageTextView, params);
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qq_eid", "em_kl_panel_switch_pop"), TuplesKt.to("qq_pgid", str));
        if (params == null) {
            params = MapsKt__MapsKt.emptyMap();
        }
        plus = MapsKt__MapsKt.plus(mutableMapOf, params);
        VideoReport.reportEvent("qq_clck", messageTextView, plus);
    }

    private final void E1(QQCustomDialog dialog, Map<String, ? extends Object> params) {
        String str;
        Map mutableMapOf;
        Map plus;
        TextView messageTextView = dialog.getMessageTextView();
        if (messageTextView == null) {
            return;
        }
        PageInfo pageInfo = VideoReport.getPageInfo(messageTextView);
        if (pageInfo != null) {
            str = pageInfo.getPageId();
        } else {
            str = null;
        }
        VideoReport.setElementId(messageTextView, "em_kl_panel_switch_pop");
        if (params != null) {
            VideoReport.setElementParams(messageTextView, params);
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qq_eid", "em_kl_panel_switch_pop"), TuplesKt.to("qq_pgid", str));
        if (params == null) {
            params = MapsKt__MapsKt.emptyMap();
        }
        plus = MapsKt__MapsKt.plus(mutableMapOf, params);
        VideoReport.reportEvent("qq_imp", messageTextView, plus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void F1(AssistedChatPanelSettingVB assistedChatPanelSettingVB, QQCustomDialog qQCustomDialog, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        assistedChatPanelSettingVB.E1(qQCustomDialog, map);
    }

    private final void G1(com.tencent.mobileqq.widget.listitem.a<?> aVar, final com.tencent.mobileqq.widget.listitem.g gVar) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        aVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AssistedChatPanelSettingVB.H1(Ref.BooleanRef.this, gVar, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(Ref.BooleanRef firstOnBindView, com.tencent.mobileqq.widget.listitem.g listener, View view) {
        Intrinsics.checkNotNullParameter(firstOnBindView, "$firstOnBindView");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(view, "view");
        if (firstOnBindView.element) {
            listener.M(view);
        }
        firstOnBindView.element = false;
    }

    private final boolean I1(AssistedChatSwitchType switchType, boolean switchOn) {
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(getMContext(), R.string.yom, 0).show();
            Q1(switchType, !switchOn);
            return false;
        }
        sendIntent(new b.c(switchType, switchOn));
        return true;
    }

    private final void J1(AssistedChatSwitchType switchType, boolean switchOn) {
        String str;
        if (switchOn) {
            str = "\u5df2\u5f00\u542f";
        } else {
            str = "\u5df2\u5173\u95ed";
        }
        QQToast.makeText(getMContext(), 2, str, 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K1(final AssistedChatSwitchType switchType, final boolean switchOn) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16;
        int i3 = b.f349263a[switchType.ordinal()];
        boolean z17 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str3 = null;
                    str4 = null;
                    if (str3 == null && str3.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        if (str4 != null && str4.length() != 0) {
                            z17 = false;
                        }
                        if (z17) {
                            return;
                        }
                    }
                    QQCustomDialog dialog = DialogUtil.createCustomDialog(getMContext(), 232, str3, str4, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            AssistedChatPanelSettingVB.L1(AssistedChatPanelSettingVB.this, switchType, switchOn, dialogInterface, i16);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.d
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            AssistedChatPanelSettingVB.M1(AssistedChatPanelSettingVB.this, dialogInterface, i16);
                        }
                    });
                    dialog.show();
                    Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
                    y1(dialog);
                    F1(this, dialog, null, 2, null);
                }
                if (switchOn) {
                    str = "";
                    str2 = "\u56de\u590d\u5efa\u8bae\u529f\u80fd\u4f9d\u8d56\u4e8eAI\u670d\u52a1\uff0c\u662f\u5426\u540c\u65f6\u6253\u5f00AI\u670d\u52a1\u5f00\u5173\uff1f";
                } else {
                    str = "\u786e\u5b9a\u5173\u95ed\u56de\u590d\u5efa\u8bae\u5417\uff1f";
                    str2 = "\u5173\u95ed\u540e\uff0c\u6240\u6709\u804a\u5929\u7a97\u53e3\u90fd\u4e0d\u5c55\u793a\u56de\u590d\u5efa\u8bae\u3002";
                }
            } else {
                str = "\u786e\u5b9a\u5173\u95ed\u81ea\u52a8\u8bdd\u9898\u63a8\u8350\u5417\uff1f";
                str2 = "\u5173\u95ed\u540e\uff0c\u6240\u6709\u804a\u5929\u7a97\u53e3\u90fd\u4e0d\u5c55\u793a\u81ea\u52a8\u8bdd\u9898\u63a8\u8350\u3002";
            }
        } else {
            str = "\u786e\u5b9a\u5173\u95ed\u81ea\u52a8\u6da6\u8272\u5417\uff1f";
            str2 = "\u5173\u95ed\u540e\uff0c\u6240\u6709\u804a\u5929\u7a97\u53e3\u90fd\u4e0d\u5c55\u793a\u81ea\u52a8\u6da6\u8272\u3002";
        }
        str3 = str;
        str4 = str2;
        if (str3 == null) {
        }
        z16 = true;
        if (z16) {
        }
        QQCustomDialog dialog2 = DialogUtil.createCustomDialog(getMContext(), 232, str3, str4, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                AssistedChatPanelSettingVB.L1(AssistedChatPanelSettingVB.this, switchType, switchOn, dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                AssistedChatPanelSettingVB.M1(AssistedChatPanelSettingVB.this, dialogInterface, i16);
            }
        });
        dialog2.show();
        Intrinsics.checkNotNullExpressionValue(dialog2, "dialog");
        y1(dialog2);
        F1(this, dialog2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(AssistedChatPanelSettingVB this$0, AssistedChatSwitchType switchType, boolean z16, DialogInterface dialogInterface, int i3) {
        QQCustomDialog qQCustomDialog;
        Map<String, ? extends Object> mapOf;
        AssistedChatSwitchType assistedChatSwitchType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchType, "$switchType");
        this$0.Q1(switchType, z16);
        if (z16 && switchType == (assistedChatSwitchType = AssistedChatSwitchType.REPLY_SUGGESTION)) {
            this$0.I1(assistedChatSwitchType, true);
            this$0.I1(AssistedChatSwitchType.AI_SERVICE, true);
        } else {
            this$0.I1(switchType, z16);
        }
        if (dialogInterface instanceof QQCustomDialog) {
            qQCustomDialog = (QQCustomDialog) dialogInterface;
        } else {
            qQCustomDialog = null;
        }
        if (qQCustomDialog != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("btn_type", "1"));
            this$0.D1(qQCustomDialog, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(AssistedChatPanelSettingVB this$0, DialogInterface dialogInterface, int i3) {
        QQCustomDialog qQCustomDialog;
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface instanceof QQCustomDialog) {
            qQCustomDialog = (QQCustomDialog) dialogInterface;
        } else {
            qQCustomDialog = null;
        }
        if (qQCustomDialog != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("btn_type", "0"));
            this$0.D1(qQCustomDialog, mapOf);
        }
    }

    private final void N1() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getHostView(), "translationY", com.tencent.qqnt.aio.utils.l.a(-5.0f), 0.0f);
        he0.b.l(ofFloat, R.anim.f154974uh);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getHostView(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        he0.b.l(ofFloat2, R.anim.f154974uh);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(150L);
        animatorSet.start();
    }

    private final void O1() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getHostView(), "translationY", 0.0f, com.tencent.qqnt.aio.utils.l.a(-5.0f));
        he0.b.l(ofFloat, R.anim.f154977uk);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getHostView(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        he0.b.l(ofFloat2, R.anim.f154977uk);
        AIONotificationUIUtils.f192828a.l(animatorSet, new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVB$startExitAnim$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatPanelSettingVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AssistedChatPanelSettingVB.this.sendIntent(b.a.f349267d);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(150L);
        animatorSet.start();
    }

    private final boolean P1(w<?> config, boolean isChecked) {
        if (config instanceof a) {
            return P1(((a) config).J(), isChecked);
        }
        x.c.f fVar = null;
        c.b.C8994b c8994b = null;
        if (config instanceof com.tencent.mobileqq.widget.listitem.c) {
            c.b O = ((com.tencent.mobileqq.widget.listitem.c) config).O();
            if (O instanceof c.b.C8994b) {
                c8994b = (c.b.C8994b) O;
            }
            if (c8994b != null && c8994b.getIsChecked() != isChecked) {
                c8994b.e(isChecked);
                return true;
            }
            return false;
        }
        if (config instanceof x) {
            x.c O2 = ((x) config).O();
            if (O2 instanceof x.c.f) {
                fVar = (x.c.f) O2;
            }
            if (fVar != null && fVar.getIsChecked() != isChecked) {
                fVar.f(isChecked);
                return true;
            }
            return false;
        }
        return false;
    }

    private final void Q1(AssistedChatSwitchType switchType, boolean switchOn) {
        QUIListItemAdapter qUIListItemAdapter;
        w<?> wVar = this.configMap.get(switchType);
        if (wVar != null && P1(wVar, switchOn) && (qUIListItemAdapter = this.settingAdapter) != null) {
            qUIListItemAdapter.l0(wVar);
        }
    }

    private final void R1(List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
        int collectionSizeOrDefault;
        Group l16;
        List<com.tencent.qqnt.aio.assistedchat.model.d> list = itemList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.qqnt.aio.assistedchat.model.d dVar : list) {
            int i3 = b.f349263a[dVar.a().b().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        l16 = A1(dVar.b());
                    } else {
                        throw new IllegalArgumentException("AssistedChatPanelSettingVB unSupportedSwitch " + dVar.a());
                    }
                } else {
                    l16 = o1(dVar.b());
                }
            } else {
                l16 = l1(dVar.b());
            }
            arrayList.add(l16);
        }
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        QUIListItemAdapter qUIListItemAdapter = this.settingAdapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
    }

    private final Group l1(final boolean switchOn) {
        String str;
        x xVar = new x(new x.b.d("\u81ea\u52a8\u6da6\u8272"), new x.c.f(switchOn, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AssistedChatPanelSettingVB.m1(AssistedChatPanelSettingVB.this, compoundButton, z16);
            }
        }));
        if (z1()) {
            str = "https://downv6.qq.com/extendfriend/kl_ai_chat_setting_polish_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/kl_ai_chat_setting_polish_light.png";
        }
        a aVar = new a(str, xVar);
        this.configMap.put(AssistedChatSwitchType.AUTO_POLISH, aVar);
        G1(aVar, new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.k
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AssistedChatPanelSettingVB.n1(switchOn, view);
            }
        });
        return new Group("", "\u5f00\u542f\u540e\uff0c\u5728\u8f93\u5165\u6846\u4e0a\u65b9\u5c55\u793a\u4f18\u5316\u540e\u7684\u6587\u672c\u3002", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(AssistedChatPanelSettingVB this$0, CompoundButton buttonView, boolean z16) {
        String str;
        Map<String, String> mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I1(AssistedChatSwitchType.AUTO_POLISH, z16);
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.a("em_kl_touch_switch", buttonView, mapOf);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(boolean z16, View view) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.c("em_kl_touch_switch", view, mapOf);
    }

    private final Group o1(final boolean switchOn) {
        String str;
        x xVar = new x(new x.b.d("\u81ea\u52a8\u8bdd\u9898\u63a8\u8350"), new x.c.f(switchOn, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                AssistedChatPanelSettingVB.p1(AssistedChatPanelSettingVB.this, compoundButton, z16);
            }
        }));
        if (z1()) {
            str = "https://downv6.qq.com/extendfriend/kl_ai_chat_setting_topic_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/kl_ai_chat_setting_topic_light.png";
        }
        a aVar = new a(str, xVar);
        this.configMap.put(AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND, aVar);
        G1(aVar, new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AssistedChatPanelSettingVB.q1(switchOn, view);
            }
        });
        return new Group("", "\u5f00\u542f\u540e\uff0c\u5728\u8f93\u5165\u6846\u4e0a\u65b9\u5c55\u793a\u8bdd\u9898\u63a8\u8350\u3002", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(AssistedChatPanelSettingVB this$0, CompoundButton buttonView, boolean z16) {
        String str;
        Map<String, String> mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I1(AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND, z16);
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.a("em_kl_topic_recommend_switch", buttonView, mapOf);
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(boolean z16, View view) {
        String str;
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", str));
        assistedChatPanelDtReporter.c("em_kl_topic_recommend_switch", view, mapOf);
    }

    private final void r1() {
        com.tencent.aio.api.runtime.a aVar;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            com.tencent.qqnt.aio.assistedchat.panel.extend.b bVar = new com.tencent.qqnt.aio.assistedchat.panel.extend.b(aVar);
            bVar.n();
            PanelExtendRecyclerView panelExtendRecyclerView = this.recyclerView;
            if (panelExtendRecyclerView != null) {
                bVar.j(panelExtendRecyclerView);
            }
            this.panelExtendHelper = bVar;
            N1();
        }
    }

    private final View s1(Context context) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.tencent.qqnt.aio.utils.l.a(0.5f)));
        view.setBackgroundResource(R.drawable.qui_common_border_light_bg);
        return view;
    }

    private final PanelExtendRecyclerView u1(Context context) {
        PanelExtendRecyclerView panelExtendRecyclerView = new PanelExtendRecyclerView(context, null, 0, 6, null);
        panelExtendRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        panelExtendRecyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        panelExtendRecyclerView.setItemAnimator(null);
        panelExtendRecyclerView.addItemDecoration(new m(context, false));
        p pVar = new p(context, true, true);
        pVar.c(com.tencent.qqnt.aio.utils.l.b(8));
        panelExtendRecyclerView.addItemDecoration(pVar);
        panelExtendRecyclerView.addItemDecoration(new o());
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.settingAdapter = qUIListItemAdapter;
        panelExtendRecyclerView.setAdapter(qUIListItemAdapter);
        this.recyclerView = panelExtendRecyclerView;
        return panelExtendRecyclerView;
    }

    private final View v1(Context context) {
        Typeface create;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.qqnt.aio.utils.l.b(44)));
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                create = Typeface.create(null, 600, false);
                textView.setTypeface(create);
            } catch (Exception unused) {
                QLog.d("AssistedChatPanelSettingVB", 1, "createTitleBar setTypeface error");
            }
        }
        textView.setTextSize(16.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        textView.setText("\u8bbe\u7f6e");
        relativeLayout.addView(textView);
        AlphaClickableImageView alphaClickableImageView = new AlphaClickableImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.tencent.qqnt.aio.utils.l.b(28), com.tencent.qqnt.aio.utils.l.b(28));
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = com.tencent.qqnt.aio.utils.l.b(16);
        alphaClickableImageView.setLayoutParams(layoutParams2);
        int b16 = com.tencent.qqnt.aio.utils.l.b(4);
        alphaClickableImageView.setPadding(b16, b16, b16, b16);
        alphaClickableImageView.setImageResource(R.drawable.qui_chevron_up_icon_secondary_01);
        alphaClickableImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_light_tertiary));
        gradientDrawable.setStroke((int) com.tencent.qqnt.aio.utils.l.a(0.5f), ContextCompat.getColorStateList(context, R.color.qui_common_border_light));
        alphaClickableImageView.setBackground(gradientDrawable);
        alphaClickableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistedChatPanelSettingVB.w1(AssistedChatPanelSettingVB.this, view);
            }
        });
        relativeLayout.addView(alphaClickableImageView);
        relativeLayout.setClickable(true);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(AssistedChatPanelSettingVB this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u.a().b()) {
            this$0.O1();
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            AssistedChatPanelDtReporter.b(assistedChatPanelDtReporter, "em_kl_panel_return_btn", it, null, 4, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void y1(QQCustomDialog dialog) {
        FrameworkVM mUIModel;
        com.tencent.aio.api.runtime.a aVar;
        ViewGroup rootView = dialog.getRootView();
        if (rootView != null && (mUIModel = getMUIModel()) != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            AssistedChatPanelDtReporter.f349138a.e(rootView, aVar);
        }
    }

    private final boolean z1() {
        return com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(getMContext(), R.color.qui_common_bg_nav_bottom_aio));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        if (QLog.isDevelopLevel()) {
            QLog.d("AssistedChatPanelSettingVB", 4, "bindViewAndData");
        }
        r1();
        sendIntent(b.C9457b.f349268d);
        AssistedChatPanelDtReporter.d(AssistedChatPanelDtReporter.f349138a, "em_kl_agent_set_panel", getHostView(), null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<at.c, PanelUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AssistedChatPanelSettingVM();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        linearLayout.setAlpha(0.0f);
        ViewCompat.setImportantForAccessibility(linearLayout, 2);
        Context context = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        linearLayout.addView(s1(context));
        Context context2 = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        linearLayout.addView(v1(context2));
        Context context3 = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        linearLayout.addView(u1(context3));
        return linearLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof AssistedChatPanelSettingUIState.UpdateSettingListUI) {
            R1(((AssistedChatPanelSettingUIState.UpdateSettingListUI) state).a());
            return;
        }
        if (state instanceof AssistedChatPanelSettingUIState.UpdateItemUI) {
            AssistedChatPanelSettingUIState.UpdateItemUI updateItemUI = (AssistedChatPanelSettingUIState.UpdateItemUI) state;
            Q1(updateItemUI.b(), updateItemUI.a());
        } else if (state instanceof AssistedChatPanelSettingUIState.OnSetSettingSwitchSuccess) {
            AssistedChatPanelSettingUIState.OnSetSettingSwitchSuccess onSetSettingSwitchSuccess = (AssistedChatPanelSettingUIState.OnSetSettingSwitchSuccess) state;
            J1(onSetSettingSwitchSuccess.b(), onSetSettingSwitchSuccess.a());
        } else if (state instanceof AssistedChatPanelSettingUIState.ShowSwitchConfirmDialog) {
            AssistedChatPanelSettingUIState.ShowSwitchConfirmDialog showSwitchConfirmDialog = (AssistedChatPanelSettingUIState.ShowSwitchConfirmDialog) state;
            K1(showSwitchConfirmDialog.b(), showSwitchConfirmDialog.a());
        }
    }
}
