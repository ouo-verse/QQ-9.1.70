package com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.business.handler.MobileNetSwitchHandler;
import com.tencent.av.ui.setting.QavSettingFragment;
import com.tencent.av.utils.ax;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.settings.message.ao;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.notification.report.h;
import com.tencent.util.AutoSaveUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bT\u0010UJH\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0005*\u00020\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002JT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J\f\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J\f\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0002J\u001a\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u0004\u0018\u00010.J\u0010\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\u0010\u00103\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000100J\b\u00104\u001a\u00020\bH\u0016J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020605\u00a2\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\bH\u0016R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR0\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010S\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/setting/generalSetting/subRichMediaSetting/SubRichMediaSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "", "onExpo", "bi", "", "leftText", "", "leftIcon", "rightText", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "ei", "Lcom/tencent/mobileqq/widget/listitem/a;", "di", WidgetCacheLunarData.JI, "Kh", "Mh", "Oh", "hi", "Vh", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$f;", "Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "Sh", "Uh", "", "switchId", "", "isChecked", "ai", "Zh", "Yh", "Xh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/app/QQAppInterface;", "Jh", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "Ih", "Wh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Qh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "onResume", "J", "Lcom/tencent/mobileqq/widget/listitem/x;", "picSendConfig", "Lcom/tencent/av/business/handler/MobileNetSwitchHandler;", "K", "Lcom/tencent/av/business/handler/MobileNetSwitchHandler;", "getMMobileNetSwitchHandler", "()Lcom/tencent/av/business/handler/MobileNetSwitchHandler;", "setMMobileNetSwitchHandler", "(Lcom/tencent/av/business/handler/MobileNetSwitchHandler;)V", "mMobileNetSwitchHandler", "Lcom/tencent/mobileqq/widget/listitem/c;", "Rh", "()Lcom/tencent/mobileqq/widget/listitem/c;", "setNetWorkDoubleLineConfig", "(Lcom/tencent/mobileqq/widget/listitem/c;)V", "netWorkDoubleLineConfig", "Llu/a;", "M", "Llu/a;", "mMobileNetObserver", "N", "Ljava/lang/String;", "getPAGE_ID", "()Ljava/lang/String;", "PAGE_ID", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SubRichMediaSettingFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private x<x.b.d, x.c.g> picSendConfig;

    /* renamed from: K, reason: from kotlin metadata */
    private MobileNetSwitchHandler mMobileNetSwitchHandler;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.c<c.a.f, c.b.C8994b> netWorkDoubleLineConfig;

    /* renamed from: M, reason: from kotlin metadata */
    private final lu.a mMobileNetObserver = new a();

    /* renamed from: N, reason: from kotlin metadata */
    private final String PAGE_ID = "pg_bas_media_settings";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/setting/generalSetting/subRichMediaSetting/SubRichMediaSettingFragment$a", "Llu/a;", "", "isSuccess", "", "data", "", "a", "b", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends lu.a {
        a() {
        }

        @Override // lu.a
        public void a(boolean isSuccess, Object data) {
            boolean z16 = true;
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchObserver", 1, "onUpdateGetMobileNetSwitch isSuc: " + isSuccess);
            }
            if (isSuccess && (data instanceof Integer)) {
                if (!Intrinsics.areEqual(data, (Object) 0) && !Intrinsics.areEqual(data, (Object) 2)) {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("MobileNetSwitchObserver", 2, "onUpdateGetMobileNetSwitch switch turnOn: " + z16);
                }
                if (SubRichMediaSettingFragment.this.Rh() != null) {
                    com.tencent.mobileqq.widget.listitem.c<c.a.f, c.b.C8994b> Rh = SubRichMediaSettingFragment.this.Rh();
                    c.b.C8994b O = Rh != null ? Rh.O() : null;
                    if (O != null) {
                        O.e(z16);
                    }
                }
                if (SubRichMediaSettingFragment.this.Jh() != null) {
                    QQAppInterface Jh = SubRichMediaSettingFragment.this.Jh();
                    ea.X2(Jh != null ? Jh.getCurrentUin() : null, z16);
                }
            }
        }

        @Override // lu.a
        public void b(boolean isSuccess, Object data) {
            if (QLog.isColorLevel()) {
                QLog.i("MobileNetSwitchObserver", 2, "onUpdateSetMobileNetSwitch isSuc: " + isSuccess);
            }
            if (isSuccess && (data instanceof Boolean)) {
                if (QLog.isColorLevel()) {
                    QLog.i("MobileNetSwitchObserver", 1, "onUpdateSetMobileNetSwitch switch turnOn: " + data);
                }
                if (SubRichMediaSettingFragment.this.Jh() != null) {
                    QQAppInterface Jh = SubRichMediaSettingFragment.this.Jh();
                    ea.X2(Jh != null ? Jh.getCurrentUin() : null, ((Boolean) data).booleanValue());
                }
            }
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Kh() {
        boolean readValue = SettingCloneUtil.readValue((Context) getActivity(), (String) null, getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        ai("em_bas_download_and_save", readValue);
        String string = getString(R.string.f2043252l);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026todownVideoAndPicNonWiFi)");
        return new x(new x.b.d(string), new x.c.f(readValue, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubRichMediaSettingFragment.Lh(SubRichMediaSettingFragment.this, compoundButton, z16);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(SubRichMediaSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            SettingCloneUtil.writeValue(this$0.getActivity(), (String) null, this$0.getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, z16);
        }
        this$0.Xh("em_bas_download_and_save", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(SubRichMediaSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            AutoSaveUtils.i(true, z16);
        }
        this$0.Xh("em_bas_save_picture_system_album", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(SubRichMediaSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            AutoSaveUtils.i(false, z16);
        }
        this$0.Xh("em_bas_save_video_system_album", z16);
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.f, c.b.C8994b> Sh() {
        QQAppInterface Jh = Jh();
        ai("em_bas_network_improvement_quality", ea.n2(Jh != null ? Jh.getCurrentAccountUin() : null));
        String string = getString(R.string.f1785036u);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qav_use_mobile_net_switch)");
        String string2 = getString(R.string.f1784836s);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.qav_use_mobile_net_descript_m)");
        c.a.f fVar = new c.a.f(string, string2);
        QQAppInterface Jh2 = Jh();
        com.tencent.mobileqq.widget.listitem.c<c.a.f, c.b.C8994b> cVar = new com.tencent.mobileqq.widget.listitem.c<>(fVar, new c.b.C8994b(ea.n2(Jh2 != null ? Jh2.getCurrentAccountUin() : null), null));
        c.b.C8994b O = cVar.O();
        QQAppInterface Jh3 = Jh();
        O.e(ea.n2(Jh3 != null ? Jh3.getCurrentAccountUin() : null));
        cVar.O().f(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubRichMediaSettingFragment.Th(SubRichMediaSettingFragment.this, compoundButton, z16);
            }
        });
        this.netWorkDoubleLineConfig = cVar;
        if (!ax.b()) {
            cVar.p(false);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(SubRichMediaSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("com.tencent.av.MOBILE_NET_SWITCH");
        intent.putExtra("key_mobile_net_switch", z16);
        MobileQQ.restrictBroadcast(intent);
        MobileQQ.sMobileQQ.onSendBroadcast(this$0.getContext(), intent);
        this$0.Xh("em_bas_network_improvement_quality", z16);
        MobileNetSwitchHandler mobileNetSwitchHandler = this$0.mMobileNetSwitchHandler;
        if (mobileNetSwitchHandler == null || mobileNetSwitchHandler == null) {
            return;
        }
        mobileNetSwitchHandler.H2(z16);
    }

    private final void Uh() {
        MobileNetSwitchHandler mobileNetSwitchHandler;
        if (!ax.b() || (mobileNetSwitchHandler = this.mMobileNetSwitchHandler) == null || mobileNetSwitchHandler == null) {
            return;
        }
        mobileNetSwitchHandler.D2();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Vh() {
        Zh("em_bas_call_suspension_window");
        String string = getString(R.string.f17747342);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qav_assistant_float_view)");
        return fi(this, string, 0, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment$qavConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentActivity activity = SubRichMediaSettingFragment.this.getActivity();
                if (activity != null) {
                    QPublicFragmentActivity.start(activity, new Intent(), QavSettingFragment.class);
                }
                SubRichMediaSettingFragment.this.Yh("em_bas_call_suspension_window");
            }
        }, null, 16, null);
    }

    private final void Xh(String switchId, boolean isChecked) {
        h.z(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(String switchId) {
        h.z(this.PAGE_ID, switchId, null, null, null, 24, null);
    }

    private final void Zh(String switchId) {
        h.D(this.PAGE_ID, switchId, null, null, null, 24, null);
    }

    private final void ai(String switchId, boolean isChecked) {
        h.D(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final <L extends x.b, R extends x.c> x<L, R> bi(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                SubRichMediaSettingFragment.ci(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> di() {
        String string;
        com.tencent.qqnt.qbasealbum.utils.a aVar = com.tencent.qqnt.qbasealbum.utils.a.f361642a;
        if (!aVar.c()) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(getString(R.string.f1358902o), "getString(com.tencent.qq\u2026string.full_screen_album)");
        if (aVar.a() == 1) {
            string = getString(R.string.f1358902o);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026string.full_screen_album)");
        } else {
            string = getString(R.string.f158601q2);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026string.half_screen_album)");
        }
        Zh("em_bas_graphic_mode");
        String string2 = getString(R.string.f225156kv);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.send_pic_mode)");
        x<x.b.d, x.c.g> ei5 = ei(string2, 0, string, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment$setPicSettingMsgConfig$picSendConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (SubRichMediaSettingFragment.this.getActivity() != null) {
                    SubRichMediaSettingFragment subRichMediaSettingFragment = SubRichMediaSettingFragment.this;
                    if (subRichMediaSettingFragment.getActivity() != null) {
                        com.tencent.qqnt.qbasealbum.a aVar2 = com.tencent.qqnt.qbasealbum.a.f360732a;
                        FragmentActivity requireActivity = subRichMediaSettingFragment.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "this.requireActivity()");
                        aVar2.n(requireActivity, true);
                    }
                }
                ReportController.y(SubRichMediaSettingFragment.this.Jh(), "0X800B87C");
                SubRichMediaSettingFragment.this.Yh("em_bas_graphic_mode");
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment$setPicSettingMsgConfig$picSendConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReportController.y(SubRichMediaSettingFragment.this.Jh(), "0X800B818");
            }
        });
        this.picSendConfig = ei5;
        return ei5;
    }

    private final x<x.b.d, x.c.g> ei(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubRichMediaSettingFragment.gi(Function0.this, view);
            }
        });
        bi(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment$singleLineConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function0 = onExpo;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> hi() {
        QQAppInterface Jh = Jh();
        String currentAccountUin = Jh != null ? Jh.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        ai("em_bas_group_file_online_preview", ea.p2(currentAccountUin));
        c.a.f fVar = new c.a.f("\u7fa4\u6587\u4ef6\u5728\u7ebf\u9884\u89c8\u670d\u52a1", "<100MB\u7684\u6587\u4ef6\u53ef\u5728\u7ebf\u9884\u89c8\uff0c\u8d85\u51fa\u9700\u4e0b\u8f7d\u67e5\u770b");
        QQAppInterface Jh2 = Jh();
        com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(fVar, new c.b.C8994b(ea.n2(Jh2 != null ? Jh2.getCurrentAccountUin() : null), null));
        c.b.C8994b c8994b = (c.b.C8994b) cVar.O();
        QQAppInterface Jh3 = Jh();
        String currentAccountUin2 = Jh3 != null ? Jh3.getCurrentAccountUin() : null;
        c8994b.e(ea.p2(currentAccountUin2 != null ? currentAccountUin2 : ""));
        ((c.b.C8994b) cVar.O()).f(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubRichMediaSettingFragment.ii(SubRichMediaSettingFragment.this, compoundButton, z16);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(SubRichMediaSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (compoundButton.isPressed()) {
            ao.a(this$0.Jh(), "0X800C5EF", z16);
            QQAppInterface Jh = this$0.Jh();
            String currentAccountUin = Jh != null ? Jh.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            ea.c3(currentAccountUin, z16);
            this$0.Xh("em_bas_group_file_online_preview", z16);
        }
    }

    private final void ji() {
        String string;
        com.tencent.qqnt.qbasealbum.utils.a aVar = com.tencent.qqnt.qbasealbum.utils.a.f361642a;
        if (aVar.c()) {
            if (this.picSendConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picSendConfig");
            }
            Intrinsics.checkNotNullExpressionValue(getString(R.string.f1358902o), "getString(com.tencent.qq\u2026string.full_screen_album)");
            if (aVar.a() == 1) {
                string = getString(R.string.f1358902o);
                Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026string.full_screen_album)");
            } else {
                string = getString(R.string.f158601q2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026string.half_screen_album)");
            }
            x<x.b.d, x.c.g> xVar = this.picSendConfig;
            x<x.b.d, x.c.g> xVar2 = null;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picSendConfig");
                xVar = null;
            }
            xVar.O().h(string);
            QUIListItemAdapter th5 = th();
            if (th5 != null) {
                x<x.b.d, x.c.g> xVar3 = this.picSendConfig;
                if (xVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("picSendConfig");
                } else {
                    xVar2 = xVar3;
                }
                th5.l0(xVar2);
            }
        }
    }

    public final QQAppInterface Jh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    public final com.tencent.mobileqq.widget.listitem.c<c.a.f, c.b.C8994b> Rh() {
        return this.netWorkDoubleLineConfig;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Wh(this.mMobileNetObserver);
        h.u(this.PAGE_ID, null, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ji();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.f2042652f);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026g_general_chat_richMedia)");
        setTitle(string);
        QQAppInterface Jh = Jh();
        BusinessHandler businessHandler = Jh != null ? Jh.getBusinessHandler(MobileNetSwitchHandler.class.getName()) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.av.business.handler.MobileNetSwitchHandler");
        this.mMobileNetSwitchHandler = (MobileNetSwitchHandler) businessHandler;
        Ih(this.mMobileNetObserver);
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Qh = Qh();
            th5.t0((Group[]) Arrays.copyOf(Qh, Qh.length));
        }
        Uh();
        h.q(this.PAGE_ID, null, 2, null);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Mh() {
        boolean g16 = AutoSaveUtils.g(true);
        ai("em_bas_save_picture_system_album", g16);
        String string = getString(R.string.f2043552o);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026neral_sub_picdownAndload)");
        return new x(new x.b.d(string), new x.c.f(g16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubRichMediaSettingFragment.Nh(SubRichMediaSettingFragment.this, compoundButton, z16);
            }
        }));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Oh() {
        boolean g16 = AutoSaveUtils.g(false);
        ai("em_bas_save_video_system_album", g16);
        String string = getString(R.string.f2043652p);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026ral_sub_vdieodownAndload)");
        return new x(new x.b.d(string), new x.c.f(g16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubRichMediaSettingFragment.Ph(SubRichMediaSettingFragment.this, compoundButton, z16);
            }
        }));
    }

    public final Group[] Qh() {
        List mutableListOf;
        List filterNotNull;
        List mutableListOf2;
        List filterNotNull2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(di(), Kh(), Mh(), Oh(), hi());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(Vh(), Sh());
        filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf2);
        Object[] array2 = filterNotNull2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = (com.tencent.mobileqq.widget.listitem.a[]) array2;
        return new Group[]{new Group("", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)), new Group("", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void Ih(BusinessObserver observer) {
        if (observer == null) {
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).addObserver(observer);
        }
    }

    public final void Wh(BusinessObserver observer) {
        if (observer == null) {
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).removeObserver(observer);
        }
    }

    static /* synthetic */ x fi(SubRichMediaSettingFragment subRichMediaSettingFragment, CharSequence charSequence, int i3, CharSequence charSequence2, Function0 function0, Function0 function02, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            charSequence2 = "";
        }
        return subRichMediaSettingFragment.ei(charSequence, i17, charSequence2, (i16 & 8) != 0 ? null : function0, (i16 & 16) != 0 ? null : function02);
    }
}
