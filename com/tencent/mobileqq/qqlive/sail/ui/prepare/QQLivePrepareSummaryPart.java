package com.tencent.mobileqq.qqlive.sail.ui.prepare;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0002\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R#\u0010-\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "com/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart$c", "ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart$c;", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "room", "", "Ca", "", "roomName", "Ha", "url", "Ga", "sa", "Da", "Fa", "photoPath", "xa", "wa", "Landroid/content/Intent;", "data", "va", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "action", "", "args", "handleBroadcastMessage", "newIntent", "onNewIntent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "ta", "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "prepareViewModel", "Lcom/tencent/mobileqq/qqlive/base/permission/a;", "f", "Lcom/tencent/mobileqq/qqlive/base/permission/a;", "permissionManager", "Landroid/widget/EditText;", tl.h.F, "Landroid/widget/EditText;", "roomNameText", "Lcom/tencent/image/URLImageView;", "i", "Lcom/tencent/image/URLImageView;", "coverImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "locationLayout", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "locationTextView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "locationIcon", "Landroid/net/Uri;", "E", "Landroid/net/Uri;", "uploadPathUri", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePrepareSummaryPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView locationTextView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView locationIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Uri uploadPathUri;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy prepareViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.permission.a permissionManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText roomNameText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView coverImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View locationLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart$a;", "", "", "DP_COVER_HEIGHT", "I", "DP_COVER_WIDTH", "REQUEST_CODE_CROP_PHOTO", "REQUEST_CODE_TAKE_PHOTO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSummaryPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareSummaryPart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                QQLivePrepareSummaryPart.this.Da();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            super.onDenied(permissions, results);
            AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "checkPermissionAndPickCover", "WriteReadPermission is denied");
            QQLivePrepareSummaryPart qQLivePrepareSummaryPart = QQLivePrepareSummaryPart.this;
            qQLivePrepareSummaryPart.ba(qQLivePrepareSummaryPart.getContext().getResources().getString(R.string.f210375hy));
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareSummaryPart$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareSummaryPart.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            String str;
            Editable text;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            MutableLiveData<String> U1 = QQLivePrepareSummaryPart.this.ta().U1();
            EditText editText = QQLivePrepareSummaryPart.this.roomNameText;
            if (editText != null && (text = editText.getText()) != null) {
                str = text.toString();
            } else {
                str = null;
            }
            U1.setValue(str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePrepareSummaryPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePrepareViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSummaryPart$prepareViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareSummaryPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final QQLivePrepareViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePrepareViewModel) QQLivePrepareSummaryPart.this.getViewModel(QQLivePrepareViewModel.class) : (QQLivePrepareViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.prepareViewModel = lazy;
            this.permissionManager = new com.tencent.mobileqq.qqlive.base.permission.a();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da() {
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(getPartHost().getHostActivity(), null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet != null) {
            actionSheet.addButton(R.string.f199844qi, 5);
            actionSheet.addButton(R.string.f199834qh, 5);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.s
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    QQLivePrepareSummaryPart.Ea(QQLivePrepareSummaryPart.this, actionSheet, view, i3);
                }
            });
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(QQLivePrepareSummaryPart this$0, ActionSheet this_apply, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.Fa();
            }
        } else {
            this$0.uploadPathUri = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this$0.getPartHost().getHostActivity(), 1);
        }
        this_apply.dismiss();
    }

    private final void Fa() {
        Activity hostActivity = getPartHost().getHostActivity();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", new ArrayList<>());
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", hostActivity.getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        hostActivity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).startPhotoList(hostActivity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(String url) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.nmj, null);
            int dip2px = ViewUtils.dip2px(85.0f);
            int dip2px2 = ViewUtils.dip2px(120.0f);
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setTag(new int[]{dip2px, dip2px2});
            drawable.setDecodeHandler(com.tencent.mobileqq.qqlive.room.prepare.b.f271920m);
            URLImageView uRLImageView = this.coverImageView;
            if (uRLImageView != null) {
                uRLImageView.setImageDrawable(drawable);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|QQLivePrepareSummaryPart", "loadRoundImg", "load fail " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha(String roomName) {
        EditText editText = this.roomNameText;
        if (editText == null || Intrinsics.areEqual(editText.getText().toString(), roomName)) {
            return;
        }
        editText.setText(roomName);
        Selection.setSelection(editText.getText(), roomName.length());
    }

    private final void sa() {
        int authState = ta().P1().getAuthState();
        if (authState != 0 && authState != 2) {
            if (authState != 3) {
                this.permissionManager.g(getPartHost().getHostActivity(), new b());
                return;
            } else {
                da(R.string.f210295hq);
                return;
            }
        }
        da(R.string.f210545ie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLivePrepareViewModel ta() {
        return (QQLivePrepareViewModel) this.prepareViewModel.getValue();
    }

    private final c ua() {
        return new c();
    }

    private final void va(Intent data) {
        if (data == null) {
            AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "handleCropPhotoResult", "data is null");
            return;
        }
        CoverInfo coverInfo = (CoverInfo) data.getSerializableExtra(IQQLiveUtil.COVER_INFO_KEY);
        if (coverInfo != null) {
            ta().N1().setValue(coverInfo.toRoomCoverInfo(String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G())));
            return;
        }
        int intExtra = data.getIntExtra(IQQLiveUtil.UPLOAD_ERROR_CODE, 0);
        String stringExtra = data.getStringExtra(IQQLiveUtil.UPLOAD_ERROR_MESSAGE);
        if (intExtra != 0) {
            ba("\u4e0a\u4f20\u5931\u8d25");
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "handleCropPhotoResult", "errorCode:" + intExtra + ", errorMsg: " + stringExtra);
    }

    private final void wa() {
        if (this.uploadPathUri == null) {
            AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "handleTakePhotoResult", "uploadPathUri is null");
        } else {
            xa(BaseImageUtil.getRealPathFromContentURI(getContext(), this.uploadPathUri));
        }
    }

    private final void xa(String photoPath) {
        boolean z16;
        if (photoPath != null && photoPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "jumpToCropPhotoFragment", "the path is empty");
            return;
        }
        long roomId = ta().getRoomId();
        if (roomId <= 0) {
            AegisLogger.INSTANCE.i("Open_Live|QQLivePrepareSummaryPart", "jumpToCropPhotoFragment", "the roomId is invalid");
        } else {
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getPartHost().getHostActivity(), photoPath, String.valueOf(roomId), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(QQLivePrepareSummaryPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sa();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        com.tencent.mobileqq.qqlive.sail.room.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "onStartRoom")) {
            if (args instanceof com.tencent.mobileqq.qqlive.sail.room.d) {
                dVar = (com.tencent.mobileqq.qqlive.sail.room.d) args;
            } else {
                dVar = null;
            }
            Ca(dVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1) {
            if (requestCode == 2) {
                va(data);
                return;
            }
            return;
        }
        wa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.roomNameText = (EditText) rootView.findViewById(R.id.f60932wr);
        this.coverImageView = (URLImageView) rootView.findViewById(R.id.f60752w_);
        View findViewById = rootView.findViewById(R.id.f60812wf);
        this.locationLayout = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.locationTextView = (TextView) rootView.findViewById(R.id.f60792wd);
        this.locationIcon = (ImageView) rootView.findViewById(R.id.f60802we);
        EditText editText = this.roomNameText;
        if (editText != null) {
            editText.addTextChangedListener(ua());
        }
        URLImageView uRLImageView = this.coverImageView;
        if (uRLImageView != null) {
            uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQLivePrepareSummaryPart.za(QQLivePrepareSummaryPart.this, view);
                }
            });
        }
        MutableLiveData<String> U1 = ta().U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSummaryPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareSummaryPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQLivePrepareSummaryPart qQLivePrepareSummaryPart = QQLivePrepareSummaryPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLivePrepareSummaryPart.Ha(it);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePrepareSummaryPart.Aa(Function1.this, obj);
            }
        });
        MutableLiveData<RoomCoverInfo> N1 = ta().N1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<RoomCoverInfo, Unit> function12 = new Function1<RoomCoverInfo, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareSummaryPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareSummaryPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomCoverInfo roomCoverInfo) {
                invoke2(roomCoverInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomCoverInfo roomCoverInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQLivePrepareSummaryPart.this.Ga(roomCoverInfo.e());
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) roomCoverInfo);
                }
            }
        };
        N1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLivePrepareSummaryPart.Ba(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        ArrayList<String> arrayList;
        String str;
        boolean z16;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newIntent);
            return;
        }
        AegisLogger.INSTANCE.d("Open_Live|QQLivePrepareSummaryPart", "onNewIntent", "invoke success");
        String str2 = null;
        if (newIntent != null) {
            arrayList = newIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        } else {
            arrayList = null;
        }
        if (newIntent != null) {
            str = newIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        } else {
            str = null;
        }
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            str2 = (String) first;
        } else {
            if (str == null || str.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                str2 = str;
            }
        }
        xa(str2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
        }
    }

    private final void Ca(com.tencent.mobileqq.qqlive.sail.room.d room) {
    }
}
