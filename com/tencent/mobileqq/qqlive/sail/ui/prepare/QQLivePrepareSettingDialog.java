package com.tencent.mobileqq.qqlive.sail.ui.prepare;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveSetAudienceInfoViewableReq;
import com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002CDB#\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JB\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00106\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "s0", "u0", "Landroid/view/View;", "view", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "", "businessParams", "C0", "initView", "x0", "A0", "v", NodeProps.ON_CLICK, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "dismiss", "Landroidx/fragment/app/Fragment;", "T", "Landroidx/fragment/app/Fragment;", "fragment", "", "U", "J", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$b;", "V", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$b;", "resSettingCallback", "Lii2/a;", "W", "Lii2/a;", "binding", "X", "Z", "getInitStatus", "()Z", "setInitStatus", "(Z)V", "initStatus", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "Y", "Lkotlin/Lazy;", "r0", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "audienceInfoViewableSwitch", "Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "resSettingDialog", "<init>", "(Landroidx/fragment/app/Fragment;JLcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$b;)V", "a0", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePrepareSettingDialog extends BaseSlideUpDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Fragment fragment;

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
    @NotNull
    private final Lazy audienceInfoViewableSwitch;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private ResolutionSettingDialog resSettingDialog;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$a;", "", "", "BTN_BACKGROUND_COLOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSettingDialog$b;", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "resolutionLevelType", "", "b", "", "a", "()Ljava/util/List;", "supportResolutionLevels", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        @NotNull
        List<ResolutionLevelType> a();

        void b(@NotNull ResolutionLevelType resolutionLevelType);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLivePrepareSettingDialog(@NotNull Fragment fragment, long j3, @Nullable b bVar) {
        super(fragment.getContext());
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fragment, Long.valueOf(j3), bVar);
            return;
        }
        this.fragment = fragment;
        this.roomId = j3;
        this.resSettingCallback = bVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FormSwitchItem>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog$audienceInfoViewableSwitch$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareSettingDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FormSwitchItem invoke() {
                ii2.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FormSwitchItem) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                aVar = QQLivePrepareSettingDialog.this.binding;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar = null;
                }
                return aVar.f407713i.f407715b;
            }
        });
        this.audienceInfoViewableSwitch = lazy;
    }

    private final void A0() {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLivePrepareSettingDialog", "sendSettingRequest", "initStatus=" + this.initStatus + ", isChecked=" + r0().isChecked());
        if (this.initStatus == r0().isChecked()) {
            companion.d("Open_Live|QQLivePrepareSettingDialog", "sendSettingRequest", "isSame not to sendSettingRequest");
            return;
        }
        if (this.roomId == 0) {
            companion.e("Open_Live|QQLivePrepareSettingDialog", "sendSettingRequest", "invalid roomId");
            return;
        }
        LiveData sendRequest = ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetAudienceInfoViewableReq(this.roomId, r0().isChecked()));
        LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        final Function1<QQLiveResponse<ir4.g>, Unit> function1 = new Function1<QQLiveResponse<ir4.g>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog$sendSettingRequest$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareSettingDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ir4.g> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQLiveResponse<ir4.g> qQLiveResponse) {
                FormSwitchItem r06;
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveResponse);
                    return;
                }
                if (!qQLiveResponse.isFailed()) {
                    r06 = QQLivePrepareSettingDialog.this.r0();
                    boolean z16 = !r06.isChecked();
                    AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSettingDialog", "sendSettingRequest", "onSuccess, hide=" + z16);
                    j3 = QQLivePrepareSettingDialog.this.roomId;
                    ct3.a.n("MMKV_KEY_HIDE_ROOM_NICKNAME", j3, z16);
                    return;
                }
                AegisLogger.INSTANCE.e("Open_Live|QQLivePrepareSettingDialog", "sendSettingRequest", "onFailed, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
                gt3.a.b(gt3.a.INSTANCE.a(), "\u5f00\u5173\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0, null, 6, null);
            }
        };
        sendRequest.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePrepareSettingDialog.B0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void C0(View view, String element, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, Map<String, String> businessParams) {
        VideoReport.setElementId(view, element);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementParams(view, businessParams);
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
        r0().setBackgroundColor(Color.parseColor("#05001F"));
        ii2.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar4;
        }
        aVar2.f407707c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLivePrepareSettingDialog.z0(QQLivePrepareSettingDialog.this, view);
            }
        });
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormSwitchItem r0() {
        return (FormSwitchItem) this.audienceInfoViewableSwitch.getValue();
    }

    private final void s0() {
        r0().setChecked(!ct3.a.d("MMKV_KEY_HIDE_ROOM_NICKNAME", this.roomId));
        r0().setText("");
        this.initStatus = r0().isChecked();
    }

    private final void u0() {
        String str;
        Switch r26 = r0().getSwitch();
        Intrinsics.checkNotNullExpressionValue(r26, "audienceInfoViewableSwitch.switch");
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        HashMap hashMap = new HashMap();
        if (r0().isChecked()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("qqlive_switch_status", str);
        Unit unit = Unit.INSTANCE;
        C0(r26, "em_qqlive_privacy_switch_set", clickPolicy, exposurePolicy, hashMap);
        r0().setOnCheckedChangeListener(this);
        ii2.a aVar = this.binding;
        ii2.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f407711g.setOnClickListener(this);
        ii2.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f407710f.setOnClickListener(this);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.m
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                QQLivePrepareSettingDialog.w0(QQLivePrepareSettingDialog.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QQLivePrepareSettingDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A0();
    }

    private final void x0() {
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
        this.resSettingDialog = new ResolutionSettingDialog(this.resSettingCallback.a(), new Function1<ResolutionLevelType, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSettingDialog$initResolutionSettingView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareSettingDialog.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResolutionLevelType resolutionLevelType) {
                invoke2(resolutionLevelType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ResolutionLevelType it) {
                ii2.a aVar2;
                QQLivePrepareSettingDialog.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                aVar2 = QQLivePrepareSettingDialog.this.binding;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar2 = null;
                }
                aVar2.f407712h.setText(it.getTerm());
                bVar = QQLivePrepareSettingDialog.this.resSettingCallback;
                bVar.b(it);
            }
        }, QQLivePrepareSettingDialog$initResolutionSettingView$1$2.INSTANCE);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQLivePrepareSettingDialog.y0(QQLivePrepareSettingDialog.this, view);
            }
        });
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        a.C11346a.a((ug4.a) b16, findViewById, true, null, "em_qqlive_clarity", null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(QQLivePrepareSettingDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ResolutionSettingDialog resolutionSettingDialog = this$0.resSettingDialog;
        if (resolutionSettingDialog != null) {
            resolutionSettingDialog.f();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(QQLivePrepareSettingDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
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
        this.resSettingDialog = null;
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
        s0();
        initView();
        u0();
    }
}
