package com.qwallet.authorize.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.authorize.AuthorizePhoneData;
import com.qwallet.authorize.dialog.k;
import com.qwallet.authorize.phone.AuthorizePhoneListFragment;
import com.qwallet.authorize.verify.AuthorizeVerifyPhoneFragment;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$Contract;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$GetAuthPhonePanelRsp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.util.LoadingUtil;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 _2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010\"\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010)R\u0016\u0010<\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010>\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010)R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020W0V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010Y\u00a8\u0006a"}, d2 = {"Lcom/qwallet/authorize/dialog/AuthorizeDialogFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "Landroid/view/View;", "view", "", "initView", "initData", "showLoadingDialog", "Lcom/qwallet/authorize/AuthorizePhoneData;", "selectedPhone", "Zh", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$GetAuthPhonePanelRsp;", "rsp", "Yh", "Uh", "initHandle", "Xh", "currentItem", "ai", "Mh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onCancel", "", "getTheme", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "channelLogo", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "channelName", "E", "authorizeTitle", UserInfo.SEX_FEMALE, "authorizeContent", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "phoneRecyclerView", "H", "useOtherPhoneBtn", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "I", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "savePhoneCheckBox", "J", "savePhoneCheckContract", "K", "protocolCheckBox", "L", "protocolCheckContract", "Landroid/widget/Button;", "M", "Landroid/widget/Button;", "disagreeBtn", "N", "agreeBtn", "Lcom/qwallet/authorize/dialog/k;", "P", "Lcom/qwallet/authorize/dialog/k;", "adapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/app/Dialog;", "loadingDialog", "Lcom/qwallet/authorize/dialog/AuthorizeViewModel;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "Nh", "()Lcom/qwallet/authorize/dialog/AuthorizeViewModel;", "viewModel", "", ExifInterface.LATITUDE_SOUTH, "Z", "hasPhoneCanDelete", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "T", "Landroidx/activity/result/ActivityResultLauncher;", "addPhoneLauncher", "U", "renewPhoneLauncher", "<init>", "()V", "V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizeDialogFragment extends QWalletBottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView channelLogo;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView channelName;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView authorizeTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView authorizeContent;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView phoneRecyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView useOtherPhoneBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private QUICheckBox savePhoneCheckBox;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView savePhoneCheckContract;

    /* renamed from: K, reason: from kotlin metadata */
    private QUICheckBox protocolCheckBox;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView protocolCheckContract;

    /* renamed from: M, reason: from kotlin metadata */
    private Button disagreeBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private Button agreeBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private k adapter;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AuthorizeViewModel.class), new Function0<ViewModelStore>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasPhoneCanDelete;

    /* renamed from: T, reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> addPhoneLauncher;

    /* renamed from: U, reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> renewPhoneLauncher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qwallet/authorize/dialog/AuthorizeDialogFragment$b", "Lcom/qwallet/authorize/dialog/k$c;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "authorPhoneData", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements k.c {
        b() {
        }

        @Override // com.qwallet.authorize.dialog.k.c
        public void a(@Nullable AuthorizePhoneData authorPhoneData) {
            AuthorizeDialogFragment authorizeDialogFragment = AuthorizeDialogFragment.this;
            authorizeDialogFragment.Yh(authorizeDialogFragment.Nh().O1().getValue(), authorPhoneData);
            AuthorizeDialogFragment.this.Zh(authorPhoneData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/qwallet/authorize/dialog/AuthorizeDialogFragment$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QWalletAuthorize$Contract f41411e;

        c(QWalletAuthorize$Contract qWalletAuthorize$Contract) {
            this.f41411e = qWalletAuthorize$Contract;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            com.tencent.mobileqq.qwallet.utils.k.c(AuthorizeDialogFragment.this.getActivity(), this.f41411e.url.get(), false, false, null, 28, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
            ds5.setColor(AuthorizeDialogFragment.this.getResources().getColor(R.color.f157883a50));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(AuthorizePhoneData currentItem) {
        boolean z16;
        showLoadingDialog();
        QUICheckBox qUICheckBox = this.savePhoneCheckBox;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckBox");
            qUICheckBox = null;
        }
        if (qUICheckBox.getVisibility() == 0) {
            QUICheckBox qUICheckBox3 = this.savePhoneCheckBox;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckBox");
            } else {
                qUICheckBox2 = qUICheckBox3;
            }
            if (qUICheckBox2.isChecked()) {
                z16 = true;
                Nh().X1(currentItem, z16, new Function2<Boolean, String, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$confirmAuth$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke(bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, @NotNull String dataStr) {
                        Dialog dialog;
                        Intrinsics.checkNotNullParameter(dataStr, "dataStr");
                        dialog = AuthorizeDialogFragment.this.loadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (z17) {
                            AuthorizeDialogFragment authorizeDialogFragment = AuthorizeDialogFragment.this;
                            Bundle bundle = new Bundle();
                            bundle.putInt("extra_key_result_code", 0);
                            bundle.putString("extra_key_result_data", dataStr);
                            Unit unit = Unit.INSTANCE;
                            FragmentKt.setFragmentResult(authorizeDialogFragment, "qwallet_authorize_request", bundle);
                            AuthorizeDialogFragment.this.dismiss();
                        }
                    }
                });
            }
        }
        z16 = false;
        Nh().X1(currentItem, z16, new Function2<Boolean, String, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$confirmAuth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @NotNull String dataStr) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(dataStr, "dataStr");
                dialog = AuthorizeDialogFragment.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (z17) {
                    AuthorizeDialogFragment authorizeDialogFragment = AuthorizeDialogFragment.this;
                    Bundle bundle = new Bundle();
                    bundle.putInt("extra_key_result_code", 0);
                    bundle.putString("extra_key_result_data", dataStr);
                    Unit unit = Unit.INSTANCE;
                    FragmentKt.setFragmentResult(authorizeDialogFragment, "qwallet_authorize_request", bundle);
                    AuthorizeDialogFragment.this.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthorizeViewModel Nh() {
        return (AuthorizeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(AuthorizeDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(AuthorizeDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.c cVar = com.tencent.mobileqq.qwallet.c.f277112a;
        Button button = this$0.disagreeBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
            button = null;
        }
        com.tencent.mobileqq.qwallet.c.f("qqwallet_phone_authorize_pop_operate_button_click", null, String.valueOf(this$0.Nh().getAppId()), button.getText().toString(), null, 18, null);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_result_code", -1);
        bundle.putString("extra_key_result_msg", "\u7528\u6237\u62d2\u7edd");
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this$0, "qwallet_authorize_request", bundle);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(final AuthorizeDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.c cVar = com.tencent.mobileqq.qwallet.c.f277112a;
        Button button = this$0.agreeBtn;
        String str = null;
        TextView textView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
            button = null;
        }
        com.tencent.mobileqq.qwallet.c.f("qqwallet_phone_authorize_pop_operate_button_click", null, String.valueOf(this$0.Nh().getAppId()), button.getText().toString(), null, 18, null);
        k kVar = this$0.adapter;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            kVar = null;
        }
        if (kVar.getCurrentList().isEmpty()) {
            TextView textView2 = this$0.useOtherPhoneBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("useOtherPhoneBtn");
            } else {
                textView = textView2;
            }
            textView.performClick();
        } else {
            QUICheckBox qUICheckBox = this$0.protocolCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
                qUICheckBox = null;
            }
            if (!qUICheckBox.isChecked()) {
                QUICheckBox qUICheckBox2 = this$0.protocolCheckBox;
                if (qUICheckBox2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
                    qUICheckBox2 = null;
                }
                if (qUICheckBox2.getVisibility() == 0) {
                    QQToast.makeText(this$0.getActivity(), 1, "\u8bf7\u540c\u610f\u76f8\u5173\u6388\u6743\u534f\u8bae", 0).show();
                }
            }
            k kVar2 = this$0.adapter;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                kVar2 = null;
            }
            AuthorizePhoneData k06 = kVar2.k0();
            if (k06 == null) {
                QQToast.makeText(this$0.getActivity(), 1, "\u624b\u673a\u53f7\u9009\u62e9\u6709\u8bef\uff0c\u8bf7\u4f7f\u7528\u6b63\u786e\u624b\u673a\u53f7", 0).show();
            } else {
                QLog.i("AuthorizeDialogFragment", 1, "onClickAgree: phoneMask=" + k06.getPhoneMask() + " state=" + k06.getState() + " source=" + k06.getSource());
                if (k06.getState() == 2) {
                    AuthorizePhoneData localPhoneData = this$0.Nh().getLocalPhoneData();
                    if (localPhoneData != null) {
                        str = localPhoneData.getPhoneMask();
                    }
                    if (Intrinsics.areEqual(str, k06.getPhoneMask())) {
                        this$0.showLoadingDialog();
                        com.qwallet.authorize.a.f41406a.a(this$0.Nh().getAppId(), this$0.Nh().getSessionId(), localPhoneData.getToken(), k06, new Function1<AuthorizePhoneData, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$initHandle$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AuthorizePhoneData authorizePhoneData) {
                                invoke2(authorizePhoneData);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable AuthorizePhoneData authorizePhoneData) {
                                Dialog dialog;
                                if (authorizePhoneData != null) {
                                    AuthorizeDialogFragment.this.Mh(authorizePhoneData);
                                    return;
                                }
                                dialog = AuthorizeDialogFragment.this.loadingDialog;
                                if (dialog != null) {
                                    dialog.dismiss();
                                }
                            }
                        });
                    } else {
                        this$0.ai(k06);
                    }
                } else {
                    this$0.Mh(k06);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Uh() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.qwallet.authorize.dialog.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthorizeDialogFragment.Wh(AuthorizeDialogFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul\u2026\n            }\n        })");
        this.addPhoneLauncher = registerForActivityResult;
        ActivityResultLauncher<Intent> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.qwallet.authorize.dialog.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthorizeDialogFragment.Vh(AuthorizeDialogFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResul\u2026\n            }\n        })");
        this.renewPhoneLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(AuthorizeDialogFragment this$0, ActivityResult activityResult) {
        AuthorizePhoneData authorizePhoneData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            if (data != null && (authorizePhoneData = (AuthorizePhoneData) data.getParcelableExtra("extra_key_snap_phone_data")) != null) {
                QLog.d("AuthorizeDialogFragment", 1, "renewPhone finish result = " + activityResult);
                this$0.Mh(authorizePhoneData);
                return;
            }
            QLog.w("AuthorizeDialogFragment", 1, "renewPhone result error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(AuthorizeDialogFragment this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AuthorizeDialogFragment", 1, "result = " + activityResult);
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            boolean z16 = false;
            if (data != null) {
                z16 = data.getBooleanExtra("extra_key_update_phone_list", false);
            }
            AuthorizePhoneData authorizePhoneData = null;
            if (z16) {
                AuthorizeViewModel.a2(this$0.Nh(), null, 1, null);
            }
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                authorizePhoneData = (AuthorizePhoneData) data2.getParcelableExtra("extra_key_snap_phone_data");
            }
            this$0.Nh().f2(authorizePhoneData);
        }
    }

    private final void Xh() {
        Class cls;
        Intent intent = new Intent(requireActivity(), (Class<?>) QPublicFragmentActivity.class);
        if (this.hasPhoneCanDelete) {
            cls = AuthorizePhoneListFragment.class;
        } else {
            intent.putExtra("KEY_VERIFY_MODE", AuthorizeVerifyPhoneFragment.EnumVerifyMode.ADD);
            cls = AuthorizeVerifyPhoneFragment.class;
        }
        intent.putExtra("public_fragment_class", cls.getName());
        intent.putExtra("extra_key_local_phone_data", Nh().getLocalPhoneData());
        intent.putExtra("extra_key_snap_phone_data", Nh().getSnapPhoneData());
        intent.putExtra("extra_key_authorize_appid", Nh().getAppId());
        intent.putExtra("extra_key_authorize_openid", Nh().getOpenId());
        intent.putExtra("extra_key_authorize_access_token", Nh().getAccessToken());
        intent.putExtra("extra_key_authorize_sign", Nh().getSign());
        ActivityResultLauncher<Intent> activityResultLauncher = this.addPhoneLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addPhoneLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if (r3 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Yh(QWalletAuthorize$GetAuthPhonePanelRsp rsp, AuthorizePhoneData selectedPhone) {
        boolean z16;
        if (rsp == null) {
            return;
        }
        List<QWalletAuthorize$Contract> list = rsp.contracts.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.contracts.get()");
        ArrayList<QWalletAuthorize$Contract> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            QWalletAuthorize$Contract qWalletAuthorize$Contract = (QWalletAuthorize$Contract) next;
            if (!qWalletAuthorize$Contract.filter.is_global.get()) {
                if (selectedPhone != null && qWalletAuthorize$Contract.filter.carrier_type.get() == selectedPhone.getCarrierType()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            z17 = true;
            if (z17) {
                arrayList.add(next);
            }
        }
        TextView textView = null;
        if (arrayList.isEmpty()) {
            QUICheckBox qUICheckBox = this.protocolCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
                qUICheckBox = null;
            }
            qUICheckBox.setVisibility(8);
            TextView textView2 = this.protocolCheckContract;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protocolCheckContract");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        QUICheckBox qUICheckBox2 = this.protocolCheckBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckBox");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setVisibility(0);
        TextView textView3 = this.protocolCheckContract;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckContract");
            textView3 = null;
        }
        textView3.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.z9x));
        for (QWalletAuthorize$Contract qWalletAuthorize$Contract2 : arrayList) {
            String str = qWalletAuthorize$Contract2.name.get();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
            spannableStringBuilder2.setSpan(new c(qWalletAuthorize$Contract2), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        TextView textView4 = this.protocolCheckContract;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckContract");
            textView4 = null;
        }
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView5 = this.protocolCheckContract;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protocolCheckContract");
        } else {
            textView = textView5;
        }
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(AuthorizePhoneData selectedPhone) {
        TextView textView = null;
        if (selectedPhone != null && !selectedPhone.getHasSavePhone() && selectedPhone.getSource() == 4) {
            QUICheckBox qUICheckBox = this.savePhoneCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckBox");
                qUICheckBox = null;
            }
            qUICheckBox.setVisibility(0);
            TextView textView2 = this.savePhoneCheckContract;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckContract");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        QUICheckBox qUICheckBox2 = this.savePhoneCheckBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckBox");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setVisibility(8);
        TextView textView3 = this.savePhoneCheckContract;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savePhoneCheckContract");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    private final void ai(AuthorizePhoneData currentItem) {
        Intent intent = new Intent(requireActivity(), (Class<?>) QPublicFragmentActivity.class);
        intent.putExtra("public_fragment_class", AuthorizeVerifyPhoneFragment.class.getName());
        intent.putExtra("extra_key_authorize_appid", Nh().getAppId());
        intent.putExtra("extra_key_authorize_openid", Nh().getOpenId());
        intent.putExtra("extra_key_authorize_access_token", Nh().getAccessToken());
        intent.putExtra("extra_key_authorize_sessionid", Nh().getSessionId());
        intent.putExtra("KEY_VERIFY_MODE", AuthorizeVerifyPhoneFragment.EnumVerifyMode.RENEW);
        intent.putExtra("KEY_VERIFY_PHONE_DATA", currentItem);
        ActivityResultLauncher<Intent> activityResultLauncher = this.renewPhoneLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renewPhoneLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(intent);
    }

    private final void initData() {
        MutableLiveData<QWalletAuthorize$GetAuthPhonePanelRsp> O1 = Nh().O1();
        final Function1<QWalletAuthorize$GetAuthPhonePanelRsp, Unit> function1 = new Function1<QWalletAuthorize$GetAuthPhonePanelRsp, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QWalletAuthorize$GetAuthPhonePanelRsp qWalletAuthorize$GetAuthPhonePanelRsp) {
                invoke2(qWalletAuthorize$GetAuthPhonePanelRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QWalletAuthorize$GetAuthPhonePanelRsp qWalletAuthorize$GetAuthPhonePanelRsp) {
                ImageView imageView;
                TextView textView;
                TextView textView2;
                TextView textView3;
                k kVar;
                if (qWalletAuthorize$GetAuthPhonePanelRsp == null) {
                    return;
                }
                imageView = AuthorizeDialogFragment.this.channelLogo;
                k kVar2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelLogo");
                    imageView = null;
                }
                imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(qWalletAuthorize$GetAuthPhonePanelRsp.channel_info.logo.get()));
                textView = AuthorizeDialogFragment.this.channelName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelName");
                    textView = null;
                }
                textView.setText(qWalletAuthorize$GetAuthPhonePanelRsp.channel_info.title.get());
                textView2 = AuthorizeDialogFragment.this.authorizeTitle;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorizeTitle");
                    textView2 = null;
                }
                textView2.setText(qWalletAuthorize$GetAuthPhonePanelRsp.title.get());
                textView3 = AuthorizeDialogFragment.this.authorizeContent;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorizeContent");
                    textView3 = null;
                }
                textView3.setText(qWalletAuthorize$GetAuthPhonePanelRsp.content.get());
                kVar = AuthorizeDialogFragment.this.adapter;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    kVar2 = kVar;
                }
                AuthorizePhoneData l06 = kVar2.l0();
                AuthorizeDialogFragment.this.Yh(qWalletAuthorize$GetAuthPhonePanelRsp, l06);
                AuthorizeDialogFragment.this.Zh(l06);
            }
        };
        O1.observe(this, new Observer() { // from class: com.qwallet.authorize.dialog.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorizeDialogFragment.Oh(Function1.this, obj);
            }
        });
        MutableLiveData<List<AuthorizePhoneData>> P1 = Nh().P1();
        final AuthorizeDialogFragment$initData$2 authorizeDialogFragment$initData$2 = new AuthorizeDialogFragment$initData$2(this);
        P1.observe(this, new Observer() { // from class: com.qwallet.authorize.dialog.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorizeDialogFragment.Ph(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> R1 = Nh().R1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeDialogFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isLocalPhoneResult) {
                Dialog dialog;
                Intrinsics.checkNotNullExpressionValue(isLocalPhoneResult, "isLocalPhoneResult");
                if (isLocalPhoneResult.booleanValue()) {
                    dialog = AuthorizeDialogFragment.this.loadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    AuthorizeDialogFragment.this.loadingDialog = null;
                    return;
                }
                AuthorizeDialogFragment.this.showLoadingDialog();
            }
        };
        R1.observe(this, new Observer() { // from class: com.qwallet.authorize.dialog.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorizeDialogFragment.Qh(Function1.this, obj);
            }
        });
    }

    private final void initHandle() {
        TextView textView = this.useOtherPhoneBtn;
        Button button = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("useOtherPhoneBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizeDialogFragment.Rh(AuthorizeDialogFragment.this, view);
            }
        });
        Button button2 = this.disagreeBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizeDialogFragment.Sh(AuthorizeDialogFragment.this, view);
            }
        });
        Button button3 = this.agreeBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
        } else {
            button = button3;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizeDialogFragment.Th(AuthorizeDialogFragment.this, view);
            }
        });
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.syy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorize_channel_logo)");
        this.channelLogo = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.syz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.authorize_channel_name)");
        this.channelName = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f164526sz3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.authorize_content_title)");
        this.authorizeTitle = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f164525sz2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.authorize_content_text)");
        this.authorizeContent = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.sza);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.a\u2026orize_phone_recycle_view)");
        this.phoneRecyclerView = (RecyclerView) findViewById5;
        View findViewById6 = view.findViewById(R.id.szl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.authorize_use_other_phone)");
        this.useOtherPhoneBtn = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.szf);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.authorize_save_phone_box)");
        this.savePhoneCheckBox = (QUICheckBox) findViewById7;
        View findViewById8 = view.findViewById(R.id.szg);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.a\u2026rize_save_phone_contract)");
        this.savePhoneCheckContract = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f164523sz0);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.authorize_check_box)");
        this.protocolCheckBox = (QUICheckBox) findViewById9;
        View findViewById10 = view.findViewById(R.id.f164524sz1);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.authorize_check_contract)");
        this.protocolCheckContract = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.sz5);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.authorize_disagree_btn)");
        this.disagreeBtn = (Button) findViewById11;
        View findViewById12 = view.findViewById(R.id.syx);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.authorize_agree_btn)");
        this.agreeBtn = (Button) findViewById12;
        k kVar = new k();
        this.adapter = kVar;
        kVar.q0(new b());
        RecyclerView recyclerView = this.phoneRecyclerView;
        k kVar2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneRecyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        k kVar3 = this.adapter;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            kVar2 = kVar3;
        }
        recyclerView.setAdapter(kVar2);
        com.tencent.mobileqq.qwallet.c.f("qqwallet_phone_authorize_pop_show", null, String.valueOf(Nh().getAppId()), null, null, 26, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingDialog() {
        Dialog dialog = this.loadingDialog;
        if (dialog == null) {
            dialog = LoadingUtil.showLoadingDialog(getContext(), "\u52a0\u8f7d\u4e2d", false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
            }
            this.loadingDialog = dialog;
            Intrinsics.checkNotNullExpressionValue(dialog, "showLoadingDialog(contex\u2026ngDialog = this\n        }");
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.a76;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_result_code", -1);
        bundle.putString("extra_key_result_msg", ShareJsPlugin.ERRMSG_INVITE_CANCEL);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this, "qwallet_authorize_request", bundle);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setSkipCollapsed(true);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setHideable(false);
        aVar.setCanceledOnTouchOutside(false);
        Window window = aVar.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hhv, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        Uh();
        initHandle();
    }
}
