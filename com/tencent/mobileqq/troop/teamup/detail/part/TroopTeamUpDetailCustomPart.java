package com.tencent.mobileqq.troop.teamup.detail.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.teamup.detail.common.TroopTeamUploadPicUtils;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.adapter.api.ITempChatApi;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u000223B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u001c\u0010\u0011\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailCustomPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "M9", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "data", "J9", "U9", "T9", "Landroid/text/SpannableString;", "L9", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "newIntent", "onNewIntent", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "d", "Lkotlin/Lazy;", "K9", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "detailVM", "Landroid/widget/Button;", "e", "Landroid/widget/Button;", "actionBtn", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "appliedText", tl.h.F, "hintText", "Landroid/app/Dialog;", "i", "Landroid/app/Dialog;", "loadingDialog", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailCustomPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy detailVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Button actionBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView appliedText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView hintText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailCustomPart$a;", "", "", "ERR_TEAMUP_FULL", "I", "REQ_CODE_UPLOAD_PIC", "", "TAG", "Ljava/lang/String;", "UPLOAD_PIC_LIMIT", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailCustomPart$b;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        public b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.context = context;
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) widget);
            } else {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ((ITempChatApi) QRoute.api(ITempChatApi.class)).openTempChatSetting(this.context);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(BaseApplication.context.getColor(R.color.qui_common_text_link));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55459);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpDetailCustomPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$detailVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopTeamUpDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopTeamUpDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopTeamUpDetailVM.Companion companion = TroopTeamUpDetailVM.INSTANCE;
                    Fragment hostFragment = TroopTeamUpDetailCustomPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.detailVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9(TeamUpTeamDetail data) {
        int i3 = data.status;
        boolean z16 = false;
        if (i3 == 1) {
            if (data.isJoined) {
                if (data.hasCreatedGroup) {
                    long j3 = data.newGroupId;
                    if (j3 != 0) {
                        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(String.valueOf(j3));
                        if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
                            z16 = true;
                        }
                        if (z16) {
                            QRouteApi api = QRoute.api(IAIOStarterApi.class);
                            Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
                            Context context = getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            String str = troopInfoFromCache.troopuin;
                            Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                            String troopDisplayName = troopInfoFromCache.getTroopDisplayName();
                            Intrinsics.checkNotNullExpressionValue(troopDisplayName, "troopInfo.troopDisplayName");
                            IAIOStarterApi.a.b((IAIOStarterApi) api, context, 2, str, troopDisplayName, 0L, null, 48, null);
                            return;
                        }
                        TroopTeamUpDetailVM K9 = K9();
                        Activity activity = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        K9.v2(activity);
                        return;
                    }
                    QLog.e("TroopTeamUpDetailCustomPart", 1, "doAction: newGroupId=0");
                    return;
                }
                QLog.e("TroopTeamUpDetailCustomPart", 1, "doAction: wait notification");
                return;
            }
            int i16 = data.joinType;
            if (i16 != 1) {
                if (i16 != 2) {
                    QLog.e("TroopTeamUpDetailCustomPart", 1, "doAction: not joined, joinType=" + i16);
                    return;
                }
                if (((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
                    TroopTeamUploadPicUtils troopTeamUploadPicUtils = TroopTeamUploadPicUtils.f298872a;
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    troopTeamUploadPicUtils.f(activity2, context2, 100, 10);
                    return;
                }
                TroopTeamUploadPicUtils troopTeamUploadPicUtils2 = TroopTeamUploadPicUtils.f298872a;
                Activity activity3 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity3, "activity");
                troopTeamUploadPicUtils2.e(activity3, 100, 10);
                return;
            }
            K9().W1();
            return;
        }
        QLog.e("TroopTeamUpDetailCustomPart", 1, "doAction: data.status=" + i3);
        QQToast.makeText(getContext(), R.string.f236497ei, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeamUpDetailVM K9() {
        return (TroopTeamUpDetailVM) this.detailVM.getValue();
    }

    private final SpannableString L9() {
        int indexOf$default;
        String string = getContext().getString(R.string.f235907cx);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026etail_apply_success_hint)");
        String string2 = getContext().getString(R.string.f235917cy);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_apply_success_hint_link)");
        SpannableString spannableString = new SpannableString(string);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        b bVar = new b(context);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, string2, 0, false, 6, (Object) null);
        spannableString.setSpan(bVar, indexOf$default, string2.length() + indexOf$default, 33);
        return spannableString;
    }

    private final void M9() {
        LiveData<TeamUpTeamDetail> a26 = K9().a2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<TeamUpTeamDetail, Unit> function1 = new Function1<TeamUpTeamDetail, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TeamUpTeamDetail teamUpTeamDetail) {
                invoke2(teamUpTeamDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TeamUpTeamDetail data) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                    return;
                }
                TroopTeamUpDetailCustomPart troopTeamUpDetailCustomPart = TroopTeamUpDetailCustomPart.this;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                troopTeamUpDetailCustomPart.U9(data);
                TroopTeamUpDetailCustomPart.this.T9(data);
            }
        };
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailCustomPart.N9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.a> Z1 = K9().Z1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.teamup.detail.vm.data.a, Unit> function12 = new Function1<com.tencent.mobileqq.troop.teamup.detail.vm.data.a, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.teamup.detail.vm.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.teamup.detail.vm.data.a aVar) {
                Dialog dialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                dialog = TroopTeamUpDetailCustomPart.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (aVar.b()) {
                    if (aVar.c()) {
                        QQToast.makeText(TroopTeamUpDetailCustomPart.this.getContext(), R.string.f236077dd, 0).show();
                        return;
                    } else {
                        QQToast.makeText(TroopTeamUpDetailCustomPart.this.getContext(), R.string.f235927cz, 0).show();
                        return;
                    }
                }
                QQToast.makeText(TroopTeamUpDetailCustomPart.this.getContext(), aVar.a() == 50001 ? R.string.f235897cw : R.string.f235867ct, 0).show();
            }
        };
        Z1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailCustomPart.O9(Function1.this, obj);
            }
        });
        LiveData<TryJoinTroopResult> d26 = K9().d2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<TryJoinTroopResult, Unit> function13 = new Function1<TryJoinTroopResult, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$initObserver$3
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f298889a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55443);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[TryJoinTroopResult.values().length];
                    try {
                        iArr[TryJoinTroopResult.HAS_JOINED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TryJoinTroopResult.HAS_LAUNCH.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[TryJoinTroopResult.SYS_ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[TryJoinTroopResult.PARAMS_ERROR.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f298889a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult) {
                invoke2(tryJoinTroopResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TryJoinTroopResult tryJoinTroopResult) {
                TroopTeamUpDetailVM K9;
                String l3;
                TroopInfo troopInfoFromCache;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) tryJoinTroopResult);
                    return;
                }
                if ((tryJoinTroopResult == null ? -1 : a.f298889a[tryJoinTroopResult.ordinal()]) != 1) {
                    return;
                }
                K9 = TroopTeamUpDetailCustomPart.this.K9();
                TeamUpTeamDetail value = K9.a2().getValue();
                if (value == null || (l3 = Long.valueOf(value.newGroupId).toString()) == null || (troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(l3)) == null) {
                    return;
                }
                TroopTeamUpDetailCustomPart troopTeamUpDetailCustomPart = TroopTeamUpDetailCustomPart.this;
                QRouteApi api = QRoute.api(IAIOStarterApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
                Context context = troopTeamUpDetailCustomPart.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String str = troopInfoFromCache.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "it.troopuin");
                String troopDisplayName = troopInfoFromCache.getTroopDisplayName();
                Intrinsics.checkNotNullExpressionValue(troopDisplayName, "it.troopDisplayName");
                IAIOStarterApi.a.b((IAIOStarterApi) api, context, 2, str, troopDisplayName, 0L, null, 48, null);
            }
        };
        d26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailCustomPart.P9(Function1.this, obj);
            }
        });
        LiveData<Integer> l26 = K9().l2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$initObserver$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Dialog dialog;
                Dialog dialog2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    TroopTeamUpDetailCustomPart troopTeamUpDetailCustomPart = TroopTeamUpDetailCustomPart.this;
                    troopTeamUpDetailCustomPart.loadingDialog = LoadingUtil.showLoadingDialog(troopTeamUpDetailCustomPart.getContext(), TroopTeamUpDetailCustomPart.this.getContext().getString(R.string.f236097df), false);
                    dialog2 = TroopTeamUpDetailCustomPart.this.loadingDialog;
                    if (dialog2 != null) {
                        dialog2.show();
                        return;
                    }
                    return;
                }
                if ((num != null && num.intValue() == 2) || num == null || num.intValue() != 3) {
                    return;
                }
                dialog = TroopTeamUpDetailCustomPart.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                QQToast.makeText(TroopTeamUpDetailCustomPart.this.getContext(), R.string.f236057db, 0).show();
            }
        };
        l26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailCustomPart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(TroopTeamUpDetailCustomPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.troop.trooptodo.a.a("actionBtn") && NetworkUtil.isNetworkAvailable()) {
            TeamUpTeamDetail value = this$0.K9().a2().getValue();
            if (value != null) {
                this$0.J9(value);
            } else {
                QLog.e("TroopTeamUpDetailCustomPart", 1, "onInitView: click action button, but data not init");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(TeamUpTeamDetail data) {
        TextView textView = null;
        if (data.status == 2) {
            Button button = this.actionBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button = null;
            }
            button.setEnabled(false);
            Button button2 = this.actionBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button2 = null;
            }
            button2.setText(getContext().getString(R.string.f236497ei));
            TextView textView2 = this.hintText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.hintText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
            } else {
                textView = textView3;
            }
            textView.setText(getContext().getString(R.string.f235937d0));
            return;
        }
        boolean z16 = true;
        if (data.isJoined) {
            if (data.hasCreatedGroup) {
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(String.valueOf(data.newGroupId));
                Button button3 = this.actionBtn;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                    button3 = null;
                }
                button3.setEnabled(true);
                if (troopInfoFromCache == null || !troopInfoFromCache.hadJoinTroop()) {
                    z16 = false;
                }
                if (z16) {
                    Button button4 = this.actionBtn;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                        button4 = null;
                    }
                    button4.setText(getContext().getString(R.string.f236017d8));
                    TextView textView4 = this.hintText;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hintText");
                        textView4 = null;
                    }
                    textView4.setVisibility(8);
                } else {
                    Button button5 = this.actionBtn;
                    if (button5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                        button5 = null;
                    }
                    button5.setText(getContext().getString(R.string.f235887cv));
                    TextView textView5 = this.hintText;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hintText");
                        textView5 = null;
                    }
                    textView5.setVisibility(0);
                    TextView textView6 = this.hintText;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hintText");
                        textView6 = null;
                    }
                    textView6.setText(getContext().getString(R.string.f235977d4));
                }
                com.tencent.mobileqq.troop.teamup.detail.common.a aVar = com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a;
                Button button6 = this.actionBtn;
                if (button6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                } else {
                    textView = button6;
                }
                aVar.a(textView, "apply_join");
                return;
            }
            Button button7 = this.actionBtn;
            if (button7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button7 = null;
            }
            button7.setEnabled(false);
            int i3 = data.joinType;
            if (i3 != 1) {
                if (i3 != 2) {
                    QLog.e("TroopTeamUpDetailCustomPart", 1, "updateActionBtn: joined, joinType=" + i3);
                } else {
                    Button button8 = this.actionBtn;
                    if (button8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                        button8 = null;
                    }
                    button8.setText(getContext().getString(R.string.f236087de));
                }
            } else {
                Button button9 = this.actionBtn;
                if (button9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                    button9 = null;
                }
                button9.setText(getContext().getString(R.string.f235857cs));
            }
            TextView textView7 = this.hintText;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView7 = null;
            }
            textView7.setVisibility(0);
            TextView textView8 = this.hintText;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView8 = null;
            }
            textView8.setText(L9());
            TextView textView9 = this.hintText;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
            } else {
                textView = textView9;
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        if (data.joinedCnt >= data.joinLimit) {
            Button button10 = this.actionBtn;
            if (button10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button10 = null;
            }
            button10.setEnabled(false);
            Button button11 = this.actionBtn;
            if (button11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button11 = null;
            }
            button11.setText(getContext().getString(R.string.f235947d1));
            TextView textView10 = this.hintText;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView10 = null;
            }
            textView10.setVisibility(0);
            TextView textView11 = this.hintText;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
            } else {
                textView = textView11;
            }
            textView.setText(getContext().getString(R.string.f235957d2));
            return;
        }
        int i16 = data.joinType;
        if (i16 != 1) {
            if (i16 != 2) {
                QLog.e("TroopTeamUpDetailCustomPart", 1, "updateActionBtn: not joined, joinType=" + i16);
                return;
            }
            Button button12 = this.actionBtn;
            if (button12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button12 = null;
            }
            button12.setEnabled(true);
            Button button13 = this.actionBtn;
            if (button13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
                button13 = null;
            }
            button13.setText(getContext().getString(R.string.f236067dc));
            TextView textView12 = this.hintText;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintText");
                textView12 = null;
            }
            textView12.setVisibility(8);
            com.tencent.mobileqq.troop.teamup.detail.common.a aVar2 = com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a;
            Button button14 = this.actionBtn;
            if (button14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            } else {
                textView = button14;
            }
            aVar2.a(textView, "upload_pic");
            return;
        }
        Button button15 = this.actionBtn;
        if (button15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button15 = null;
        }
        button15.setEnabled(true);
        Button button16 = this.actionBtn;
        if (button16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button16 = null;
        }
        button16.setText(getContext().getString(R.string.f235877cu));
        TextView textView13 = this.hintText;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintText");
            textView13 = null;
        }
        textView13.setVisibility(8);
        com.tencent.mobileqq.troop.teamup.detail.common.a aVar3 = com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a;
        Button button17 = this.actionBtn;
        if (button17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
        } else {
            textView = button17;
        }
        aVar3.a(textView, "participate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(TeamUpTeamDetail data) {
        TextView textView = null;
        if (data.status == 2) {
            TextView textView2 = this.appliedText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appliedText");
                textView2 = null;
            }
            textView2.setText(getContext().getString(R.string.f236497ei));
            TextView textView3 = this.appliedText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appliedText");
            } else {
                textView = textView3;
            }
            textView.setTextColor(getContext().getColor(R.color.qui_common_text_tertiary));
            return;
        }
        TextView textView4 = this.appliedText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedText");
            textView4 = null;
        }
        textView4.setText(getContext().getString(R.string.f235757ci, Integer.valueOf(data.joinedCnt), Integer.valueOf(data.joinLimit)));
        TextView textView5 = this.appliedText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appliedText");
        } else {
            textView = textView5;
        }
        textView.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.f93625a3;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailCustomPart", 2, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode + ", data=" + data);
        }
        if (data == null || requestCode != 100 || !((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
            return;
        }
        K9().o2(data);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailCustomPart", 2, "onInitView: ");
        }
        View findViewById = rootView.findViewById(R.id.f93585_z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026eam_up_detail_action_btn)");
        this.actionBtn = (Button) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f93595a0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.team_up_detail_applied)");
        this.appliedText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f93665a7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026team_up_detail_hint_text)");
        this.hintText = (TextView) findViewById3;
        Button button = this.actionBtn;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button = null;
        }
        button.setVisibility(0);
        Button button3 = this.actionBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button3 = null;
        }
        button3.setEnabled(true);
        Button button4 = this.actionBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
            button4 = null;
        }
        button4.setText(getContext().getString(R.string.f235877cu));
        TextView textView = this.hintText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintText");
            textView = null;
        }
        textView.setVisibility(8);
        Button button5 = this.actionBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBtn");
        } else {
            button2 = button5;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpDetailCustomPart.R9(TroopTeamUpDetailCustomPart.this, view);
            }
        });
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTeamUpDetailCustomPart", 2, "onNewIntent: newIntent=" + newIntent);
        }
        if (newIntent == null || !TroopTeamUploadPicUtils.f298872a.b(newIntent, 100) || ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
            return;
        }
        K9().n2(newIntent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        LiveData<Integer> g26 = K9().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailCustomPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                } else if (num != null && num.intValue() == 1) {
                    TroopTeamUpDetailCustomPart.this.startInit();
                }
            }
        };
        g26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpDetailCustomPart.S9(Function1.this, obj);
            }
        });
    }
}
