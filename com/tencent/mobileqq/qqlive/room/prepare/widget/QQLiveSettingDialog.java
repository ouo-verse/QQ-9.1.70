package com.tencent.mobileqq.qqlive.room.prepare.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback;
import com.tencent.mobileqq.qqlive.room.prepare.k;
import com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog;
import com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u0002?@B-\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\u0006\u0010'\u001a\u00020$\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JB\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00106\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "q0", "r0", "Landroid/view/View;", "view", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "", "businessParams", "z0", "initView", "u0", "y0", "v", NodeProps.ON_CLICK, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "dismiss", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "T", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "prepareViewModel", "", "U", "J", "roomId", "Lcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$b;", "V", "Lcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$b;", "resSettingCallback", "Lii2/a;", "W", "Lii2/a;", "binding", "X", "Z", "getInitStatus", "()Z", "setInitStatus", "(Z)V", "initStatus", "Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "Y", "Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "resSettingDialog", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqlive/room/prepare/k;JLcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$b;)V", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveSettingDialog extends BaseSlideUpDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private final k prepareViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final b resSettingCallback;

    /* renamed from: W, reason: from kotlin metadata */
    private ii2.a binding;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean initStatus;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private ResolutionSettingDialog resSettingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$a;", "", "", "BTN_BACKGROUND_COLOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$b;", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "resolutionLevelType", "", "b", "", "a", "()Ljava/util/List;", "supportResolutionLevels", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        @NotNull
        List<ResolutionLevelType> a();

        void b(@NotNull ResolutionLevelType resolutionLevelType);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/widget/QQLiveSettingDialog$c", "Lcom/tencent/mobileqq/qqlive/callback/auth/IQQLiveSetRoomSettingCallback;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends IQQLiveSetRoomSettingCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveSettingDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            } else {
                AegisLogger.INSTANCE.e("Open_Live|QQLiveSettingDialog", "sendSettingRequest", "onFailed");
                gt3.a.b(gt3.a.INSTANCE.a(), "\u5f00\u5173\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0, null, 6, null);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.auth.IQQLiveSetRoomSettingCallback
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.d("Open_Live|QQLiveSettingDialog", "sendSettingRequest", "onSuccess");
            long j3 = QQLiveSettingDialog.this.roomId;
            ii2.a aVar = QQLiveSettingDialog.this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            ct3.a.n("MMKV_KEY_HIDE_ROOM_NICKNAME", j3, !aVar.f407713i.f407715b.isChecked());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ QQLiveSettingDialog(Context context, k kVar, long j3, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, kVar, j3, (i3 & 8) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, kVar, Long.valueOf(j3), bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void initView() {
        ii2.a aVar = this.binding;
        ii2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        e0(aVar.f407708d);
        ii2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        g0(aVar3.f407711g);
        ii2.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        aVar4.f407713i.f407715b.setBackgroundColor(Color.parseColor("#05001F"));
        ii2.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar5;
        }
        aVar2.f407707c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveSettingDialog.x0(QQLiveSettingDialog.this, view);
            }
        });
        u0();
    }

    private final void q0() {
        ii2.a aVar = this.binding;
        ii2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f407713i.f407715b.setChecked(!ct3.a.d("MMKV_KEY_HIDE_ROOM_NICKNAME", this.roomId));
        ii2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f407713i.f407715b.setText("");
        ii2.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar4;
        }
        this.initStatus = aVar2.f407713i.f407715b.isChecked();
    }

    private final void r0() {
        String str;
        ii2.a aVar = this.binding;
        ii2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        View view = aVar.f407713i.f407715b.getSwitch();
        Intrinsics.checkNotNullExpressionValue(view, "binding.tgLiveMessagePus\u2026AudienceInfoSwitch.switch");
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        HashMap hashMap = new HashMap();
        ii2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        if (aVar3.f407713i.f407715b.isChecked()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("qqlive_switch_status", str);
        Unit unit = Unit.INSTANCE;
        z0(view, "em_qqlive_privacy_switch_set", clickPolicy, exposurePolicy, hashMap);
        ii2.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        aVar4.f407713i.f407715b.setOnCheckedChangeListener(this);
        ii2.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        aVar5.f407711g.setOnClickListener(this);
        ii2.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar6;
        }
        aVar2.f407710f.setOnClickListener(this);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.widget.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QQLiveSettingDialog.s0(QQLiveSettingDialog.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(QQLiveSettingDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0();
    }

    private final void u0() {
        View findViewById = findViewById(R.id.f634733m);
        if (this.resSettingCallback == null) {
            findViewById.setVisibility(8);
            return;
        }
        ii2.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f407712h.setText(LiveMediaConfigManager.INSTANCE.getResolutionLevelTypeCache(ResolutionLevelType.UHD).getTerm());
        this.resSettingDialog = new ResolutionSettingDialog(this.resSettingCallback.a(), new Function1<ResolutionLevelType, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog$initResolutionSettingView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveSettingDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResolutionLevelType resolutionLevelType) {
                invoke2(resolutionLevelType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ResolutionLevelType it) {
                QQLiveSettingDialog.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                ii2.a aVar2 = QQLiveSettingDialog.this.binding;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar2 = null;
                }
                aVar2.f407712h.setText(it.getTerm());
                bVar = QQLiveSettingDialog.this.resSettingCallback;
                bVar.b(it);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.widget.QQLiveSettingDialog$initResolutionSettingView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveSettingDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ResolutionSettingDialog resolutionSettingDialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                resolutionSettingDialog = QQLiveSettingDialog.this.resSettingDialog;
                if (resolutionSettingDialog != null) {
                    resolutionSettingDialog.e();
                }
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLiveSettingDialog.w0(QQLiveSettingDialog.this, view);
            }
        });
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        a.C11346a.a((ug4.a) b16, findViewById, true, null, "em_qqlive_clarity", null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QQLiveSettingDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ResolutionSettingDialog resolutionSettingDialog = this$0.resSettingDialog;
        if (resolutionSettingDialog != null) {
            resolutionSettingDialog.f();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QQLiveSettingDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0() {
        boolean z16 = this.initStatus;
        ii2.a aVar = this.binding;
        ii2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        if (z16 == aVar.f407713i.f407715b.isChecked()) {
            AegisLogger.INSTANCE.d("Open_Live|QQLiveSettingDialog", "sendSettingRequest", "isSame not to sendSettingRequest");
            return;
        }
        long j3 = this.roomId;
        if (j3 <= 0) {
            AegisLogger.INSTANCE.d("Open_Live|QQLiveSettingDialog", "sendSettingRequest", "invalid room id");
            return;
        }
        k kVar = this.prepareViewModel;
        if (kVar != null) {
            ii2.a aVar3 = this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar3;
            }
            kVar.r2(j3, aVar2.f407713i.f407715b.isChecked(), new c());
        }
    }

    private final void z0(View view, String element, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, Map<String, String> businessParams) {
        VideoReport.setElementId(view, element);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementParams(view, businessParams);
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.dismiss();
        ResolutionSettingDialog resolutionSettingDialog = this.resSettingDialog;
        if (resolutionSettingDialog != null) {
            resolutionSettingDialog.e();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, buttonView, Boolean.valueOf(isChecked));
        } else {
            HashMap hashMap = new HashMap();
            if (isChecked) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("qqlive_switch_status", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("clck", buttonView, hashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            boolean z16 = false;
            if (v3 != null && v3.getId() == R.id.f635233r) {
                z16 = true;
            }
            if (z16) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ii2.a g16 = ii2.a.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.c((ug4.a) b16, this, "pg_qqlive_gamelive_start", null, 4, null);
        q0();
        initView();
        r0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveSettingDialog(@NotNull Context context, @Nullable k kVar, long j3, @Nullable b bVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, kVar, Long.valueOf(j3), bVar);
            return;
        }
        this.prepareViewModel = kVar;
        this.roomId = j3;
        this.resSettingCallback = bVar;
    }
}
