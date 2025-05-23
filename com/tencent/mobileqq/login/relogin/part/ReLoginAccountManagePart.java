package com.tencent.mobileqq.login.relogin.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.login.relogin.dialog.h;
import com.tencent.mobileqq.login.relogin.dialog.y;
import com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment;
import com.tencent.mobileqq.login.u;
import com.tencent.mobileqq.loginregister.v;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.aj;
import com.tencent.mobileqq.util.l;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J&\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J0\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&H\u0002R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R#\u0010F\u001a\n A*\u0004\u0018\u00010@0@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010C\u001a\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010W\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/part/ReLoginAccountManagePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "v", NodeProps.ON_CLICK, "xa", "onPostThemeChanged", "Lcom/tencent/mobileqq/login/account/a;", "account", "za", "", "fragmentType", "arguments", "", "forceRoot", "pa", "na", "ia", "ta", "Y9", "va", LocaleUtils.L_JAPANESE, "Z9", "da", "resId", "wa", "oa", "", "t", "r2", "r3", "r4", "r5", "ua", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "nicknameTv", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "e", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "loginBtn", tl.h.F, "Landroid/view/View;", "privacyCheckLayout", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "i", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "privacyCheckBox", "Lcom/tencent/mobileqq/login/relogin/vm/g;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/login/relogin/vm/g;", "accountManageVM", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/login/account/a;", "currAccount", "", "D", "Ljava/util/List;", "accountList", "E", "ma", "()I", "loginEntrance", "Lcom/tencent/mobileqq/login/relogin/dialog/y;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/login/relogin/dialog/y;", "accountManageDialog", "G", "Z", "firstGetAccountList", "H", "deletingAccountWhenRelease", "<init>", "()V", "I", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ReLoginAccountManagePart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.login.account.a currAccount;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.login.account.a> accountList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy loginEntrance;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private y accountManageDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean firstGetAccountList;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean deletingAccountWhenRelease;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView nicknameTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView avatarIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIButton loginBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View privacyCheckLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox privacyCheckBox;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountManageVM;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/part/ReLoginAccountManagePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/relogin/part/ReLoginAccountManagePart$b", "Lcom/tencent/mobileqq/login/relogin/dialog/h;", "Lcom/tencent/mobileqq/login/account/a;", "account", "", "b", "d", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.login.relogin.dialog.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReLoginAccountManagePart.this);
            }
        }

        @Override // com.tencent.mobileqq.login.relogin.dialog.h
        public void a(@NotNull com.tencent.mobileqq.login.account.a account) {
            y yVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) account);
                return;
            }
            Intrinsics.checkNotNullParameter(account, "account");
            y yVar2 = ReLoginAccountManagePart.this.accountManageDialog;
            boolean z16 = false;
            if (yVar2 != null && yVar2.isShowing()) {
                z16 = true;
            }
            if (z16 && (yVar = ReLoginAccountManagePart.this.accountManageDialog) != null) {
                yVar.R();
            }
            ReLoginAccountManagePart.this.la().f2(account);
        }

        @Override // com.tencent.mobileqq.login.relogin.dialog.h
        public void b(@NotNull com.tencent.mobileqq.login.account.a account) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) account);
            } else {
                Intrinsics.checkNotNullParameter(account, "account");
                ReLoginAccountManagePart.this.Z9(account);
            }
        }

        @Override // com.tencent.mobileqq.login.relogin.dialog.h
        public void c(@NotNull y yVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) yVar);
            } else {
                h.a.a(this, yVar);
            }
        }

        @Override // com.tencent.mobileqq.login.relogin.dialog.h
        public void d(@NotNull com.tencent.mobileqq.login.account.a account) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) account);
            } else {
                Intrinsics.checkNotNullParameter(account, "account");
                ReLoginAccountManagePart.this.da(account);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ReLoginAccountManagePart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.login.relogin.vm.g>() { // from class: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$accountManageVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReLoginAccountManagePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.login.relogin.vm.g invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.login.relogin.vm.g) ReLoginAccountManagePart.this.getViewModel(com.tencent.mobileqq.login.relogin.vm.g.class) : (com.tencent.mobileqq.login.relogin.vm.g) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.accountManageVM = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$loginEntrance$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReLoginAccountManagePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IPartHost partHost = ReLoginAccountManagePart.this.getPartHost();
                    Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment");
                    return Integer.valueOf(((ReLoginFragment) partHost).uh());
                }
            });
            this.loginEntrance = lazy2;
            this.firstGetAccountList = true;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean Y9() {
        QUICheckBox qUICheckBox = this.privacyCheckBox;
        View view = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyCheckBox");
            qUICheckBox = null;
        }
        if (!qUICheckBox.isChecked()) {
            Context context = getContext();
            View view2 = this.privacyCheckLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyCheckLayout");
            } else {
                view = view2;
            }
            l.f(context, view);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(final com.tencent.mobileqq.login.account.a account) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            QLog.i("ReLoginAccountManagePart", 2, "deleteAccount uin=" + account.f());
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(getActivity(), 230, getActivity().getString(R.string.f200234rk), getActivity().getString(R.string.f200224rj, account.f()), getActivity().getString(R.string.f211145k1), false, getActivity().getString(R.string.f200204rh), getActivity().getString(R.string.f200214ri), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.aa(Ref.BooleanRef.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.ba(Ref.BooleanRef.this, this, account, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.ca(dialogInterface, i3);
                }
            });
            createDialogWithCheckBox.setCanceledOnTouchOutside(true);
            createDialogWithCheckBox.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Ref.BooleanRef clearHistory, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clearHistory, "$clearHistory");
        clearHistory.element = !clearHistory.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(final Ref.BooleanRef clearHistory, final ReLoginAccountManagePart this$0, com.tencent.mobileqq.login.account.a account, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clearHistory, "$clearHistory");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        if (clearHistory.element) {
            this$0.wa(R.string.akr);
        }
        com.tencent.mobileqq.login.relogin.vm.g la5 = this$0.la();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        la5.R1(activity, account, clearHistory.element, new Function1<String, Unit>(this$0) { // from class: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$deleteAccount$dialog$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ReLoginAccountManagePart this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this$0;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Ref.BooleanRef.this, (Object) this$0);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (Ref.BooleanRef.this.element) {
                    this.this$0.oa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(final com.tencent.mobileqq.login.account.a account) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            QLog.i("ReLoginAccountManagePart", 2, "deletePassword uin=" + account.f());
            if (!la().d2()) {
                com.tencent.mobileqq.login.relogin.vm.g la5 = la();
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                la5.U1(activity, account);
                return;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(getActivity(), 230, getActivity().getString(R.string.f200284rp), getActivity().getString(R.string.f200274ro), getActivity().getString(R.string.f200484s9), false, getActivity().getString(R.string.f200254rm), getActivity().getString(R.string.f200264rn), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.ga(Ref.BooleanRef.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.ha(Ref.BooleanRef.this, this, account, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.login.relogin.part.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ReLoginAccountManagePart.ea(dialogInterface, i3);
                }
            });
            createDialogWithCheckBox.setCanceledOnTouchOutside(true);
            createDialogWithCheckBox.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Ref.BooleanRef needConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(needConfirm, "$needConfirm");
        needConfirm.element = !needConfirm.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Ref.BooleanRef needConfirm, ReLoginAccountManagePart this$0, com.tencent.mobileqq.login.account.a account, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(needConfirm, "$needConfirm");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(account, "$account");
        if (!needConfirm.element) {
            this$0.la().g2(false);
        }
        com.tencent.mobileqq.login.relogin.vm.g la5 = this$0.la();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        la5.U1(activity, account);
    }

    private final void ia(com.tencent.mobileqq.login.account.a account) {
        if (u.o(account.f())) {
            if (!Y9()) {
                QLog.d("ReLoginAccountManagePart", 2, "privacy policy is not agreed");
                return;
            } else if (la().X1(account.f(), ma())) {
                QLog.i("ReLoginAccountManagePart", 1, "directLogin uin=" + StringUtil.getSimpleUinForPrint(account.f()));
                return;
            }
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getActivity(), R.string.b3j, 0).show();
        } else {
            ta(account);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja() {
        y yVar = this.accountManageDialog;
        boolean z16 = false;
        if (yVar != null && yVar.isShowing()) {
            z16 = true;
        }
        if (z16) {
            try {
                y yVar2 = this.accountManageDialog;
                if (yVar2 != null) {
                    yVar2.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("ReLoginAccountManagePart", 1, "dialog dismiss error:", e16);
            }
        }
        this.accountManageDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.login.relogin.vm.g la() {
        return (com.tencent.mobileqq.login.relogin.vm.g) this.accountManageVM.getValue();
    }

    private final int ma() {
        return ((Number) this.loginEntrance.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        Intent intent;
        Activity activity = getActivity();
        com.tencent.mobileqq.login.account.a aVar = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        boolean z16 = false;
        if (!intent.getBooleanExtra("is_from_account_release", false)) {
            return;
        }
        intent.putExtra("is_from_account_release", false);
        String stringExtra = intent.getStringExtra("release_account_uin");
        QLog.i("ReLoginAccountManagePart", 1, "handleReleaseAccount releaseUin=" + stringExtra);
        if (stringExtra == null || stringExtra.length() == 0) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<com.tencent.mobileqq.login.account.a> list = this.accountList;
        if (list != null) {
            for (com.tencent.mobileqq.login.account.a aVar2 : list) {
                if (Intrinsics.areEqual(aVar2.f(), stringExtra)) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar == null) {
            QLog.w("ReLoginAccountManagePart", 1, "releaseAccount is null");
            return;
        }
        wa(R.string.akr);
        this.deletingAccountWhenRelease = true;
        com.tencent.mobileqq.login.relogin.vm.g la5 = la();
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        la5.R1(activity2, aVar, true, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$handleReleaseAccount$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReLoginAccountManagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ReLoginAccountManagePart.this.oa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa() {
        if (getPartHost() instanceof BaseLoginFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment");
            ((ReLoginFragment) partHost).hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(int fragmentType, Bundle arguments, boolean forceRoot) {
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment");
        ((ReLoginFragment) partHost).Hh(fragmentType, arguments, forceRoot);
    }

    static /* synthetic */ void qa(ReLoginAccountManagePart reLoginAccountManagePart, int i3, Bundle bundle, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            bundle = null;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        reLoginAccountManagePart.pa(i3, bundle, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(ReLoginAccountManagePart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.la().h2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ta(com.tencent.mobileqq.login.account.a account) {
        QLog.i("ReLoginAccountManagePart", 1, "previousTypeLogin uin=" + StringUtil.getSimpleUinForPrint(account.f()) + " loginType=" + account.b());
        int b16 = account.b();
        if (b16 != 4 && b16 != 5) {
            if (b16 != 7) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", account.f());
                qa(this, 5, bundle, false, 4, null);
                return;
            }
            Bundle bundle2 = new Bundle();
            Pair<String, String> e16 = account.e();
            if (e16 != null) {
                bundle2.putString("country_code", e16.getFirst());
                bundle2.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, e16.getSecond());
            }
            bundle2.putString("uin", account.f());
            qa(this, 4, bundle2, false, 4, null);
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("previousPhoneNum", account.a());
        Pair<String, String> e17 = account.e();
        if (e17 != null) {
            bundle3.putString("country_code", e17.getFirst());
            bundle3.putString(AuthDevOpenUgActivity.KEY_PHONE_NUM, e17.getSecond());
        }
        bundle3.putString("uin", account.f());
        aj ajVar = aj.f306554f;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.login.relogin.fragment.ReLoginFragment");
        ajVar.s((ReLoginFragment) partHost, bundle3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(String t16, String r26, String r36, String r46, String r56) {
        ReportController.r(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", t16, t16, 0, 0, r26, r36, r46, r56);
    }

    private final void va() {
        String str;
        List<com.tencent.mobileqq.login.account.a> list = this.accountList;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<com.tencent.mobileqq.login.account.a> list2 = list;
        com.tencent.mobileqq.login.account.a aVar = this.currAccount;
        if (aVar == null || (str = aVar.f()) == null) {
            str = "";
        }
        b bVar = new b();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        y yVar = new y(context, list2, str, bVar, false, 16, null);
        this.accountManageDialog = yVar;
        try {
            yVar.show();
        } catch (Exception e16) {
            QLog.e("ReLoginAccountManagePart", 1, "dialog show error:", e16);
        }
    }

    private final void wa(int resId) {
        if (getPartHost() instanceof BaseLoginFragment) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.login.fragment.BaseLoginFragment");
            ((BaseLoginFragment) partHost).Oh(resId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za(com.tencent.mobileqq.login.account.a account) {
        QQProAvatarView qQProAvatarView;
        String string;
        TextView textView = this.nicknameTv;
        QUIButton qUIButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nicknameTv");
            textView = null;
        }
        textView.setText(account.d());
        com.tencent.mobileqq.login.account.d dVar = com.tencent.mobileqq.login.account.d.f241848a;
        QQProAvatarView qQProAvatarView2 = this.avatarIv;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            qQProAvatarView = null;
        } else {
            qQProAvatarView = qQProAvatarView2;
        }
        com.tencent.mobileqq.login.account.d.i(dVar, qQProAvatarView, account.f(), 200, null, 8, null);
        QUIButton qUIButton2 = this.loginBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginBtn");
        } else {
            qUIButton = qUIButton2;
        }
        if (account.g()) {
            string = BaseApplication.getContext().getString(R.string.f200354rw);
        } else {
            string = BaseApplication.getContext().getString(R.string.f199904qo);
        }
        qUIButton.setText(string);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f164659te2) {
                com.tencent.mobileqq.login.account.a aVar = this.currAccount;
                if (aVar != null) {
                    ia(aVar);
                }
            } else if (num != null && num.intValue() == R.id.f1057566v) {
                List<com.tencent.mobileqq.login.account.a> list = this.accountList;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    str = "2";
                } else {
                    str = "1";
                }
                String i3 = z.i();
                Intrinsics.checkNotNullExpressionValue(i3, "getQimei36()");
                ua("0X800C4C6", "", str, i3, "");
                va();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.k9t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_nickname)");
        this.nicknameTv = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_avatar)");
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById2;
        this.avatarIv = qQProAvatarView;
        QUICheckBox qUICheckBox = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            qQProAvatarView = null;
        }
        qQProAvatarView.setDrawAreaMode(1);
        View findViewById3 = rootView.findViewById(R.id.f164659te2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.btn_direct_login)");
        this.loginBtn = (QUIButton) findViewById3;
        rootView.findViewById(R.id.f164659te2).setOnClickListener(this);
        rootView.findViewById(R.id.f1057566v).setOnClickListener(this);
        View findViewById4 = rootView.findViewById(R.id.yug);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026in_privacy_policy_layout)");
        this.privacyCheckLayout = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.yuf);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026vacy_policy_check_clause)");
        QUICheckBox qUICheckBox2 = (QUICheckBox) findViewById5;
        this.privacyCheckBox = qUICheckBox2;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyCheckBox");
            qUICheckBox2 = null;
        }
        PrivacyPolicyHelper.expandCheckBoxTouchDelegate(qUICheckBox2);
        View findViewById6 = rootView.findViewById(R.id.yuh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026ogin_privacy_policy_text)");
        TextView textView = (TextView) findViewById6;
        String c16 = l.c();
        QUICheckBox qUICheckBox3 = this.privacyCheckBox;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyCheckBox");
            qUICheckBox3 = null;
        }
        PrivacyPolicyHelper.initPrivacyPolicyTextView(textView, c16, l.b(qUICheckBox3));
        QUICheckBox qUICheckBox4 = this.privacyCheckBox;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyCheckBox");
        } else {
            qUICheckBox = qUICheckBox4;
        }
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.login.relogin.part.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ReLoginAccountManagePart.ra(ReLoginAccountManagePart.this, compoundButton, z16);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        la().e2();
        MutableLiveData<com.tencent.mobileqq.login.relogin.vm.a> Z1 = la().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.login.relogin.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.login.relogin.vm.a, Unit>() { // from class: com.tencent.mobileqq.login.relogin.part.ReLoginAccountManagePart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReLoginAccountManagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.login.relogin.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.login.relogin.vm.a aVar) {
                boolean z16;
                boolean z17;
                List list;
                MqqHandler handler;
                y yVar;
                List<com.tencent.mobileqq.login.account.a> list2;
                com.tencent.mobileqq.login.account.a aVar2;
                String str;
                com.tencent.mobileqq.login.account.a aVar3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                com.tencent.mobileqq.login.account.a b16 = aVar.b();
                if (b16 != null) {
                    ReLoginAccountManagePart.this.za(b16);
                }
                z16 = ReLoginAccountManagePart.this.deletingAccountWhenRelease;
                ReLoginAccountManagePart.this.deletingAccountWhenRelease = false;
                Bundle bundle = null;
                if (aVar.b() != null) {
                    ReLoginAccountManagePart.this.currAccount = aVar.b();
                    ReLoginAccountManagePart.this.accountList = aVar.a();
                    y yVar2 = ReLoginAccountManagePart.this.accountManageDialog;
                    if ((yVar2 != null && yVar2.isShowing()) != false && (yVar = ReLoginAccountManagePart.this.accountManageDialog) != null) {
                        list2 = ReLoginAccountManagePart.this.accountList;
                        if (list2 == null) {
                            list2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        aVar2 = ReLoginAccountManagePart.this.currAccount;
                        if (aVar2 == null || (str = aVar2.f()) == null) {
                            str = "";
                        }
                        yVar.i0(list2, str);
                    }
                    ReLoginAccountManagePart.this.na();
                    if (z16) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                        if (appInterface != null && (handler = appInterface.getHandler(v.class)) != null) {
                            handler.sendEmptyMessage(2006);
                        }
                    }
                    z17 = ReLoginAccountManagePart.this.firstGetAccountList;
                    if (z17) {
                        ReLoginAccountManagePart.this.firstGetAccountList = false;
                        ReLoginAccountManagePart reLoginAccountManagePart = ReLoginAccountManagePart.this;
                        list = reLoginAccountManagePart.accountList;
                        List list3 = list;
                        String str2 = ((list3 == null || list3.isEmpty()) ? 1 : 0) != 0 ? "2" : "1";
                        String i3 = z.i();
                        Intrinsics.checkNotNullExpressionValue(i3, "getQimei36()");
                        reLoginAccountManagePart.ua("0X800C4C5", "", str2, i3, "");
                        return;
                    }
                    return;
                }
                if (z16) {
                    bundle = new Bundle();
                    bundle.putBoolean("show_release_account_dialog", true);
                }
                int d16 = com.tencent.mobileqq.login.account.d.d();
                if (d16 == 0) {
                    aVar3 = ReLoginAccountManagePart.this.currAccount;
                    d16 = aVar3 != null ? aVar3.b() : 0;
                }
                if (d16 == 4 || d16 == 5 || d16 == 7) {
                    ReLoginAccountManagePart.this.pa(4, bundle, true);
                } else {
                    ReLoginAccountManagePart.this.pa(5, bundle, true);
                }
                ReLoginAccountManagePart.this.ja();
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.login.relogin.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReLoginAccountManagePart.sa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            la().i2();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            la().a2();
        }
    }

    public final void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQProAvatarView qQProAvatarView = this.avatarIv;
        if (qQProAvatarView == null) {
            return;
        }
        QQProAvatarView qQProAvatarView2 = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            qQProAvatarView = null;
        }
        int dpToPx = ViewUtils.dpToPx(3.0f);
        QQProAvatarView qQProAvatarView3 = this.avatarIv;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
        } else {
            qQProAvatarView2 = qQProAvatarView3;
        }
        qQProAvatarView.setEnableFrame(dpToPx, ContextCompat.getColor(qQProAvatarView2.getContext(), R.color.qui_common_border_superlight));
    }

    public final void xa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QUIButton qUIButton = this.loginBtn;
        if (qUIButton == null) {
            return;
        }
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginBtn");
            qUIButton = null;
        }
        if (qUIButton.m()) {
            QUIButton qUIButton3 = this.loginBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginBtn");
            } else {
                qUIButton2 = qUIButton3;
            }
            qUIButton2.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(DialogInterface dialogInterface, int i3) {
    }
}
