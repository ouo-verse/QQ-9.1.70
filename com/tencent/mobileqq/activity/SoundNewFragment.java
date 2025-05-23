package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bH\u0010IJ\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002JH\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0000\u0010\r*\u00020\f\"\b\b\u0001\u0010\u000f*\u00020\u000e*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011H\u0002JT\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00142\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011H\u0002J\u001a\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u0004\u0018\u00010&J\u0006\u0010(\u001a\u00020\nJ\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)\u00a2\u0006\u0004\b+\u0010,J\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\u0006\u0010.\u001a\u00020\bR\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020/0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020/038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000e038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u00105R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00101R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/activity/SoundNewFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/chat/MessageNotificationSettingManager$c;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Qh", "Lh", "Sh", "Ih", "", "isChecked", "", "Nh", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "onExpo", "Uh", "", "leftText", "", "leftIcon", "rightText", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Wh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", VipFunCallConstants.KEY_RING_ID, "r8", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Hh", "initData", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Jh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Oh", "Kh", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "J", "Lcom/tencent/mobileqq/widget/listitem/x;", "msgNotifyConfig", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "K", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "groupNotifyConfig", "notifySoundConfig", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$b$b;", "M", "Lcom/tencent/mobileqq/widget/listitem/c;", "specialFriendConfig", "N", "commonTelConfig", "Lcom/tencent/mobileqq/chat/MessageNotificationSettingManager;", "P", "Lcom/tencent/mobileqq/chat/MessageNotificationSettingManager;", "notificationSettingManager", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "sound_pageID", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SoundNewFragment extends BaseSettingFragment implements MessageNotificationSettingManager.c {

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> msgNotifyConfig;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> groupNotifyConfig;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> notifySoundConfig;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> specialFriendConfig;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> commonTelConfig;

    /* renamed from: P, reason: from kotlin metadata */
    private MessageNotificationSettingManager notificationSettingManager;

    /* renamed from: Q, reason: from kotlin metadata */
    private String sound_pageID = "pg_bas_audio";

    private final com.tencent.mobileqq.widget.listitem.a<?> Ih() {
        getQBaseActivity().getAppRuntime();
        String string = getString(R.string.f170662xr);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.call_record_color_ring_default)");
        com.tencent.qqnt.notification.report.h.D(this.sound_pageID, "em_bas_ring_tone", null, null, null, 24, null);
        String string2 = getString(R.string.f2042752g);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.qq_se\u2026eneral_common_tel_notify)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Wh = Wh(string2, 0, string, new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.SoundNewFragment$commonTelSoundSettingMsgConfig$friendConfig$1
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
                String str;
                str = SoundNewFragment.this.sound_pageID;
                com.tencent.qqnt.notification.report.h.z(str, "em_bas_ring_tone", null, null, null, 24, null);
                String url = ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl("call");
                IVipTraceDetailReport a16 = IVipTraceDetailReport.INSTANCE.a();
                Intrinsics.checkNotNull(url);
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(SoundNewFragment.this.getActivity(), a16.buildTraceDetailUrl(url, IVipTraceDetailReport.FROM.FUN_CALL_SETTING));
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.SoundNewFragment$commonTelSoundSettingMsgConfig$friendConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        this.commonTelConfig = Wh;
        return Wh;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Lh() {
        boolean z16 = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(Hh()) == 1;
        String string = getString(R.string.f2042952i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026general_group_msg_notify)");
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string), new x.c.f(z16, null), th());
        bVar.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.fb
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                SoundNewFragment.Mh(SoundNewFragment.this, compoundButton, z17);
            }
        });
        this.groupNotifyConfig = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(SoundNewFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Nh(z16);
        com.tencent.qqnt.notification.report.h.z(this$0.sound_pageID, "em_bas_pay_special_attention_beep", Boolean.valueOf(z16), null, null, 24, null);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Qh() {
        boolean readValue = SettingCloneUtil.readValue((Context) getActivity(), (String) null, getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        String string = getString(R.string.f2043452n);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026ral_sub_msg_notify_sound)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.f(readValue, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.ez
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SoundNewFragment.Rh(SoundNewFragment.this, compoundButton, z16);
            }
        }));
        this.msgNotifyConfig = xVar;
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Sh() {
        final AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        String string = getString(R.string.aya);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026eqlock_auth_already_open)");
        String string2 = getString(R.string.f226516oj);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.settings_sound_type)");
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string2), new x.c.g(string, true, false), th());
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SoundNewFragment.Th(AppRuntime.this, this, view);
            }
        });
        this.notifySoundConfig = bVar;
        return bVar;
    }

    private final <L extends x.b, R extends x.c> com.tencent.mobileqq.widget.listitem.x<L, R> Uh(com.tencent.mobileqq.widget.listitem.x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.activity.fd
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                SoundNewFragment.Vh(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Wh(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SoundNewFragment.Xh(Function0.this, view);
            }
        });
        Uh(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.SoundNewFragment$singleLineConfig$1$2
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

    public final QQAppInterface Hh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        QLog.d("SoundNewFragment", 2, "-get app is null- ");
        return null;
    }

    public final boolean Kh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        return (waitAppRuntime instanceof QQAppInterface) && ((QQAppInterface) waitAppRuntime).getALLGeneralSettingRing() != 0;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> Oh() {
        boolean z16 = false;
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(Hh()) == 0) {
            QQAppInterface Hh = Hh();
            if (Hh != null && Hh.getALLGeneralSettingRing() == 0) {
                z16 = true;
            }
            z16 = !z16;
        } else if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(Hh()) == 1) {
            z16 = true;
        }
        com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> cVar = new com.tencent.mobileqq.widget.listitem.c<>(new c.a.f("\u7279\u522b\u5173\u5fc3\u63d0\u793a\u97f3", "\u7279\u522b\u5173\u5fc3\u7684\u597d\u53cb\u6d88\u606f\u5c06\u6709\u4e2a\u6027\u5316\u63d0\u793a\u97f3"), new c.b.C8994b(z16, null, true));
        cVar.O().f(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.activity.ey
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                SoundNewFragment.Ph(SoundNewFragment.this, compoundButton, z17);
            }
        });
        com.tencent.qqnt.notification.report.h.D(this.sound_pageID, "em_bas_pay_special_attention_beep", Boolean.valueOf(z16), null, null, 24, null);
        this.specialFriendConfig = cVar;
        return cVar;
    }

    public final void initData() {
        boolean Kh = Kh();
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = null;
        if (Kh) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar2 = this.notifySoundConfig;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
                bVar2 = null;
            }
            bVar2.h0(0);
            com.tencent.qqnt.notification.report.h.D(this.sound_pageID, "em_bas_prompt_tone", null, null, null, 24, null);
        } else {
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar3 = this.notifySoundConfig;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
                bVar3 = null;
            }
            bVar3.h0(8);
        }
        if (Kh) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.msgNotifyConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgNotifyConfig");
                xVar = null;
            }
            xVar.O().f(Kh);
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar4 = this.groupNotifyConfig;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                bVar4 = null;
            }
            bVar4.h0(0);
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar5 = this.notifySoundConfig;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
                bVar5 = null;
            }
            bVar5.h0(0);
            int troopGeneralSettingRing = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(Hh());
            if (QLog.isColorLevel()) {
                QLog.d("SoundNewFragment", 2, "-canPlayGroupSound- :" + troopGeneralSettingRing);
            }
            if (troopGeneralSettingRing == 0) {
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar6 = this.groupNotifyConfig;
                if (bVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                    bVar6 = null;
                }
                bVar6.a0(false);
            } else {
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar7 = this.groupNotifyConfig;
                if (bVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                    bVar7 = null;
                }
                bVar7.a0(true);
            }
            String str = this.sound_pageID;
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar8 = this.groupNotifyConfig;
            if (bVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
            } else {
                bVar = bVar8;
            }
            com.tencent.qqnt.notification.report.h.D(str, "em_bas_group_sound_switch", Boolean.valueOf(bVar.W()), null, null, 24, null);
            return;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = this.msgNotifyConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgNotifyConfig");
            xVar2 = null;
        }
        xVar2.O().f(false);
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar9 = this.groupNotifyConfig;
        if (bVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
            bVar9 = null;
        }
        bVar9.h0(8);
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar10 = this.notifySoundConfig;
        if (bVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
        } else {
            bVar = bVar10;
        }
        bVar.h0(8);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageNotificationSettingManager messageNotificationSettingManager = this.notificationSettingManager;
        if (messageNotificationSettingManager != null) {
            messageNotificationSettingManager.P(this);
        }
        com.tencent.qqnt.notification.report.h.u(this.sound_pageID, null, 2, null);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MessageNotificationSettingManager messageNotificationSettingManager = this.notificationSettingManager;
        int q16 = messageNotificationSettingManager != null ? messageNotificationSettingManager.q() : 0;
        MessageNotificationSettingManager messageNotificationSettingManager2 = this.notificationSettingManager;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = null;
        Pair<String, String> t16 = messageNotificationSettingManager2 != null ? messageNotificationSettingManager2.t(q16, null, -1) : null;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = this.notifySoundConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
            bVar = null;
        }
        bVar.f0(t16 != null ? t16.first : null);
        QQAppInterface Hh = Hh();
        QQAppInterface Hh2 = Hh();
        String account = Hh2 != null ? Hh2.getAccount() : null;
        QQAppInterface Hh3 = Hh();
        int resIdByUin = VipFunCallUtil.getResIdByUin(Hh, account, 6, false, Hh3 != null ? Hh3.getAccount() : null);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar2 = this.commonTelConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonTelConfig");
            xVar2 = null;
        }
        x.c.g O = xVar2.O();
        String funCallName = VipFunCallUtil.getFunCallName(Hh(), resIdByUin);
        Intrinsics.checkNotNullExpressionValue(funCallName, "getFunCallName(app(), callId)");
        O.h(funCallName);
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar3 = this.commonTelConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonTelConfig");
            } else {
                xVar = xVar3;
            }
            th5.l0(xVar);
        }
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u58f0\u97f3");
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(Hh());
        this.notificationSettingManager = l3;
        if (l3 != null) {
            l3.V(this);
        }
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Jh = Jh();
            th5.t0((Group[]) Arrays.copyOf(Jh, Jh.length));
        }
        com.tencent.qqnt.notification.report.h.q(this.sound_pageID, null, 2, null);
        initData();
    }

    @Override // com.tencent.mobileqq.chat.MessageNotificationSettingManager.c
    public void r8(int ringId) {
        MessageNotificationSettingManager messageNotificationSettingManager = this.notificationSettingManager;
        Pair<String, String> t16 = messageNotificationSettingManager != null ? messageNotificationSettingManager.t(ringId, null, -1) : null;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar = this.notifySoundConfig;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
            bVar = null;
        }
        bVar.f0(t16 != null ? t16.first : null);
    }

    private final void Nh(boolean isChecked) {
        if (isChecked) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(Hh(), 1);
            com.tencent.mobileqq.utils.ff.T(Hh(), "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
        } else {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(Hh(), 2);
            com.tencent.mobileqq.utils.ff.T(Hh(), "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
        }
    }

    public final Group[] Jh() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Qh(), Lh(), Sh(), Oh(), Ih());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(SoundNewFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingRing(this$0.Hh(), 1);
        } else {
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).setTroopGeneralSettingRing(this$0.Hh(), 0);
        }
        ReportController.o(this$0.Hh(), "CliOper", "", "", "Setting_tab", "Clk_notice_gupsound", 0, z16 ? 1 : 0, "", "", "", "");
        com.tencent.qqnt.notification.report.h.z(this$0.sound_pageID, "em_bas_group_sound_switch", Boolean.valueOf(z16), null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(SoundNewFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            QQAppInterface Hh = this$0.Hh();
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = null;
            com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> cVar = null;
            SettingCloneUtil.readValueForInt(activity, Hh != null ? Hh.getCurrentAccountUin() : null, AppConstants.Preferences.SOUND_TYPE, AppConstants.QQSETTING_NOTIFY_SOUNDTYPE_KEY, SoundAndVibrateActivity.H0);
            if (z16) {
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar2 = this$0.notifySoundConfig;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
                    bVar2 = null;
                }
                bVar2.h0(0);
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar3 = this$0.groupNotifyConfig;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                    bVar3 = null;
                }
                bVar3.h0(0);
                if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this$0.Hh()) == 0) {
                    com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar4 = this$0.groupNotifyConfig;
                    if (bVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                        bVar4 = null;
                    }
                    bVar4.a0(false);
                } else {
                    com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar5 = this$0.groupNotifyConfig;
                    if (bVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                        bVar5 = null;
                    }
                    bVar5.a0(true);
                }
                QQAppInterface Hh2 = this$0.Hh();
                if (Hh2 != null) {
                    Hh2.setALLGeneralSettingRing(1);
                }
                QQAppInterface Hh3 = this$0.Hh();
                VasWebviewUtil.reportCommercialDrainage(Hh3 != null ? Hh3.getCurrentAccountUin() : null, "bell", "show", "", 1, 0, 0, "", "", "");
                com.tencent.qqnt.notification.report.h.D(this$0.sound_pageID, "em_bas_prompt_tone", null, null, null, 24, null);
                String str = this$0.sound_pageID;
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar6 = this$0.groupNotifyConfig;
                if (bVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                    bVar6 = null;
                }
                com.tencent.qqnt.notification.report.h.D(str, "em_bas_group_sound_switch", Boolean.valueOf(bVar6.W()), null, null, 24, null);
                com.tencent.mobileqq.widget.listitem.c<c.a.g, c.b.C8994b> cVar2 = this$0.specialFriendConfig;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("specialFriendConfig");
                } else {
                    cVar = cVar2;
                }
                cVar.O().e(true);
            } else {
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c> bVar7 = this$0.notifySoundConfig;
                if (bVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notifySoundConfig");
                    bVar7 = null;
                }
                bVar7.h0(8);
                com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar8 = this$0.groupNotifyConfig;
                if (bVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupNotifyConfig");
                } else {
                    bVar = bVar8;
                }
                bVar.h0(8);
                QQAppInterface Hh4 = this$0.Hh();
                if (Hh4 != null) {
                    Hh4.setALLGeneralSettingRing(0);
                }
            }
            ReportController.o(this$0.Hh(), "CliOper", "", "", "Setting_tab", "Clk_notice_sound", 0, z16 ? 1 : 0, "", "", "", "");
            com.tencent.qqnt.notification.report.h.z(this$0.sound_pageID, "em_bas_sound_tips", Boolean.valueOf(z16), null, null, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0075, code lost:
    
        r5 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r4, "[uid]", "", false, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Th(AppRuntime appRuntime, SoundNewFragment this$0, View view) {
        String replace$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.o(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 4, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(appRuntime.getCurrentAccountUin(), "bell", "click", "", 1, 0, 0, "", "", "");
        com.tencent.qqnt.notification.report.h.z(this$0.sound_pageID, "em_bas_prompt_tone", null, null, null, 24, null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) QQBrowserActivity.class);
        String url = ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(IndividuationUrlHelper.UrlId.SPECIALCARE_MALL_URL);
        String replace$default2 = (url == null || replace$default == null) ? null : StringsKt__StringsJVMKt.replace$default(replace$default, "[lType]", "1", false, 4, (Object) null);
        intent.putExtra("url", replace$default2);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
