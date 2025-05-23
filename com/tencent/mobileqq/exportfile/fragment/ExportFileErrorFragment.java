package com.tencent.mobileqq.exportfile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u5bfc\u51fa\u7535\u8111\u6587\u4ef6\u5f02\u5e38\u9875", path = "/export_file/error")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileErrorFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/exportfile/fragment/w;", "Landroid/os/Bundle;", "intent", "", "dealIntent", "disconnect", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "onBackEvent", "view", "onBackClick", "Lm53/b;", "binding", "Lm53/b;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "I", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ExportFileErrorFragment extends QPublicBaseFragment implements w {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int ERROR_CUSTOM_TIPS = 1;
    public static final int ERROR_FORGOT_PWD = 3;
    public static final int ERROR_IN_OTHER_DEVICE = 5;
    public static final int ERROR_IN_WIFI_PHOTO = 6;

    @NotNull
    public static final String ERROR_KEY = "ERROR_KEY";
    public static final int ERROR_NOT_SUPPORT = 4;
    public static final int ERROR_PC_QQ_NO_PWD = 2;

    @NotNull
    public static final String ERROR_TYPE = "ERROR_TYPE";
    private m53.b binding;
    private int errorType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileErrorFragment$a;", "", "", "ERROR_CUSTOM_TIPS", "I", "ERROR_FORGOT_PWD", "ERROR_IN_OTHER_DEVICE", "ERROR_IN_WIFI_PHOTO", "", ExportFileErrorFragment.ERROR_KEY, "Ljava/lang/String;", "ERROR_NOT_SUPPORT", "ERROR_PC_QQ_NO_PWD", ExportFileErrorFragment.ERROR_TYPE, "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.ExportFileErrorFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ExportFileErrorFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.errorType = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x021e, code lost:
    
        if (r0 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        if (r0 == false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void dealIntent(Bundle intent) {
        boolean z16;
        int indexOf$default;
        boolean z17;
        boolean z18 = true;
        int i3 = intent.getInt(ERROR_TYPE, 1);
        this.errorType = i3;
        m53.b bVar = null;
        switch (i3) {
            case 1:
                String string = intent.getString(ERROR_KEY);
                if (string != null) {
                    if (string.length() == 0) {
                        z16 = true;
                        break;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                z18 = false;
                if (z18) {
                    m53.b bVar2 = this.binding;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar2 = null;
                    }
                    bVar2.f416193b.setText(string);
                    m53.b bVar3 = this.binding;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bVar = bVar3;
                    }
                    bVar.f416193b.setContentDescription(string);
                    return;
                }
                return;
            case 2:
                m53.b bVar4 = this.binding;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar4 = null;
                }
                bVar4.f416193b.setText(R.string.f2316872i);
                String z19 = QFileBridgeService.f205517a.z();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.f2316972j);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.tips_set_pc_qq_pwd_second)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{z19}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                SpannableString spannableString = new SpannableString(format);
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) format, z19, 0, false, 6, (Object) null);
                if (indexOf$default > 0) {
                    spannableString.setSpan(new StyleSpan(1), indexOf$default, z19.length() + indexOf$default, 33);
                    spannableString.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)), indexOf$default, z19.length() + indexOf$default, 33);
                }
                m53.b bVar5 = this.binding;
                if (bVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar5 = null;
                }
                bVar5.f416194c.setText(spannableString);
                m53.b bVar6 = this.binding;
                if (bVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar6;
                }
                bVar.f416194c.setContentDescription(spannableString);
                return;
            case 3:
                m53.b bVar7 = this.binding;
                if (bVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar7 = null;
                }
                bVar7.f416193b.setText(R.string.f2316172b);
                m53.b bVar8 = this.binding;
                if (bVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar8 = null;
                }
                TextView textView = bVar8.f416193b;
                m53.b bVar9 = this.binding;
                if (bVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar9 = null;
                }
                textView.setContentDescription(bVar9.f416193b.getText());
                m53.b bVar10 = this.binding;
                if (bVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar10 = null;
                }
                bVar10.f416194c.setText(R.string.f2316272c);
                m53.b bVar11 = this.binding;
                if (bVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar11 = null;
                }
                TextView textView2 = bVar11.f416194c;
                m53.b bVar12 = this.binding;
                if (bVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar12;
                }
                textView2.setContentDescription(bVar.f416194c.getText());
                return;
            case 4:
                String string3 = intent.getString(ERROR_KEY);
                if (string3 != null) {
                    if (string3.length() == 0) {
                        z17 = true;
                        break;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                z18 = false;
                if (z18) {
                    m53.b bVar13 = this.binding;
                    if (bVar13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar13 = null;
                    }
                    bVar13.f416193b.setText(string3);
                    m53.b bVar14 = this.binding;
                    if (bVar14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bVar14 = null;
                    }
                    bVar14.f416193b.setContentDescription(string3);
                }
                m53.b bVar15 = this.binding;
                if (bVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar15 = null;
                }
                bVar15.f416194c.setText(R.string.f2316572f);
                m53.b bVar16 = this.binding;
                if (bVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar16 = null;
                }
                TextView textView3 = bVar16.f416194c;
                m53.b bVar17 = this.binding;
                if (bVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar17;
                }
                textView3.setContentDescription(bVar.f416194c.getText());
                return;
            case 5:
                m53.b bVar18 = this.binding;
                if (bVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar18 = null;
                }
                bVar18.f416193b.setText(R.string.zwe);
                m53.b bVar19 = this.binding;
                if (bVar19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar19 = null;
                }
                TextView textView4 = bVar19.f416193b;
                m53.b bVar20 = this.binding;
                if (bVar20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar20 = null;
                }
                textView4.setContentDescription(bVar20.f416193b.getText());
                m53.b bVar21 = this.binding;
                if (bVar21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar21 = null;
                }
                bVar21.f416194c.setText("");
                m53.b bVar22 = this.binding;
                if (bVar22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar22 = null;
                }
                TextView textView5 = bVar22.f416194c;
                m53.b bVar23 = this.binding;
                if (bVar23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar23;
                }
                textView5.setContentDescription(bVar.f416194c.getText());
                return;
            case 6:
                m53.b bVar24 = this.binding;
                if (bVar24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar24 = null;
                }
                bVar24.f416193b.setText(R.string.zwf);
                m53.b bVar25 = this.binding;
                if (bVar25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar25 = null;
                }
                TextView textView6 = bVar25.f416193b;
                m53.b bVar26 = this.binding;
                if (bVar26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar26 = null;
                }
                textView6.setContentDescription(bVar26.f416193b.getText());
                m53.b bVar27 = this.binding;
                if (bVar27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar27 = null;
                }
                bVar27.f416194c.setText(R.string.zwp);
                m53.b bVar28 = this.binding;
                if (bVar28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bVar28 = null;
                }
                TextView textView7 = bVar28.f416194c;
                m53.b bVar29 = this.binding;
                if (bVar29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar29;
                }
                textView7.setContentDescription(bVar.f416194c.getText());
                return;
            default:
                return;
        }
    }

    private final void disconnect() {
        if (this.errorType == 2) {
            QFileBridgeService.f205517a.x(100107);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.w
    public void onBackClick(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            disconnect();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        disconnect();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.b g16 = m53.b.g(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
            this.binding = g16;
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                String string = getString(R.string.f2318072u);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.title_export_file)");
                c.a(parentFragment, string, false);
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            dealIntent(arguments);
            m53.b bVar = this.binding;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar = null;
            }
            root = bVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newIntent);
            return;
        }
        super.onNewIntent(newIntent);
        if (newIntent != null) {
            Bundle extras = newIntent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(extras, "it.extras ?: Bundle()");
            dealIntent(extras);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
